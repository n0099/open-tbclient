package com.baidu.nadcore.download.basic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.cj0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.il0;
import com.baidu.tieba.j31;
import com.baidu.tieba.jn0;
import com.baidu.tieba.mn0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.uk0;
import com.baidu.tieba.un0;
import com.baidu.tieba.vk0;
import com.baidu.tieba.xk0;
import com.baidu.tieba.y41;
import com.baidu.tieba.z61;
import com.baidu.tieba.zk0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public il0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, il0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ il0 a;

        public a(il0 il0Var) {
            this.a = il0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends jn0<mn0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jn0
        public void onEvent(@NonNull mn0 mn0Var) {
            AdAppStateManager.this.mIsForeGround = mn0Var.a;
            if (mn0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = xk0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    cj0.b(a);
                    xk0.c(AdAppStateManager.this.mBlockingNotifyData.d);
                    return;
                }
                boolean z = AdAppStateManager.this.mBlockingNotifyData.q.s;
                int i = AdAppStateManager.this.mBlockingNotifyData.q.t;
                if (z && AdAppStateManager.this.isInternalValid(i)) {
                    AdAppStateManager adAppStateManager = AdAppStateManager.this;
                    adAppStateManager.launchAfterInstall(adAppStateManager.mBlockingNotifyData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static final AdAppStateManager a = new AdAppStateManager(null);
    }

    public AdAppStateManager() {
        this.mDatas = new HashMap<>(16);
        this.mBlockingNotifyData = null;
        this.mIsForeGround = true;
        init();
    }

    private void init() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addDataScheme("package");
        tj0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        fn0.a().b(new Object(), new b(mn0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !z61.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(il0 il0Var) {
        if (il0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = il0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(il0Var);
    }

    public void register(@NonNull il0 il0Var) {
        if (TextUtils.isEmpty(il0Var.d)) {
            return;
        }
        j31.e(this.mDatas, il0Var.d, il0Var);
    }

    public void launch(il0 il0Var) {
        this.mBlockingNotifyData = null;
        if (il0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(il0Var.d)) {
            String a2 = xk0.a(il0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                cj0.b(a2);
                xk0.c(il0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(il0Var.p.c) && cj0.b(il0Var.p.c)) || !il0Var.q.u) {
            return;
        }
        sm0.h(il0Var.d);
        vk0.e(AdDownloadAction.OPEN, il0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data != null) {
            str = data.getEncodedSchemeSpecificPart();
        } else {
            str = "";
        }
        il0 il0Var = (il0) j31.b(this.mDatas, str);
        if (il0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            il0Var.c = AdDownloadStatus.INSTALLED;
            il0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = tj0.b().getPackageManager().getPackageInfo(il0Var.d, 0);
                if (packageInfo != null) {
                    il0Var.o = packageInfo.versionName;
                    il0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            il0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            vk0.c().g(AdDownloadAction.INSTALL_FINISH, il0Var);
            il0Var.q.p = 0L;
            boolean z = true;
            if (un0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                y41.a(new a(il0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(il0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            vk0.c().g(AdDownloadAction.REMOVE, il0Var);
            if (il0Var.q.q > 0) {
                uk0.a().b(il0Var);
            }
            il0Var.q.p = -1L;
        }
        zk0.b().d();
    }
}
