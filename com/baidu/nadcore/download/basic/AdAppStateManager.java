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
import com.baidu.tieba.ao0;
import com.baidu.tieba.d31;
import com.baidu.tieba.dm0;
import com.baidu.tieba.hn0;
import com.baidu.tieba.io0;
import com.baidu.tieba.n61;
import com.baidu.tieba.ok0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.s41;
import com.baidu.tieba.sl0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.xj0;
import com.baidu.tieba.xn0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public dm0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, dm0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ dm0 a;

        public a(dm0 dm0Var) {
            this.a = dm0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends xn0<ao0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xn0
        public void onEvent(@NonNull ao0 ao0Var) {
            AdAppStateManager.this.mIsForeGround = ao0Var.a;
            if (ao0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = sl0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    xj0.b(a);
                    sl0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        ok0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        tn0.a().b(new Object(), new b(ao0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !n61.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(dm0 dm0Var) {
        if (dm0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = dm0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(dm0Var);
    }

    public void register(@NonNull dm0 dm0Var) {
        if (TextUtils.isEmpty(dm0Var.d)) {
            return;
        }
        d31.e(this.mDatas, dm0Var.d, dm0Var);
    }

    public void launch(dm0 dm0Var) {
        this.mBlockingNotifyData = null;
        if (dm0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(dm0Var.d)) {
            String a2 = sl0.a(dm0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                xj0.b(a2);
                sl0.c(dm0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(dm0Var.p.c) && xj0.b(dm0Var.p.c)) || !dm0Var.q.u) {
            return;
        }
        hn0.g(dm0Var.d);
        ql0.d(AdDownloadAction.OPEN, dm0Var);
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
        dm0 dm0Var = (dm0) d31.b(this.mDatas, str);
        if (dm0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            dm0Var.c = AdDownloadStatus.INSTALLED;
            dm0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = ok0.b().getPackageManager().getPackageInfo(dm0Var.d, 0);
                if (packageInfo != null) {
                    dm0Var.o = packageInfo.versionName;
                    dm0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            dm0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            ql0.b().f(AdDownloadAction.INSTALL_FINISH, dm0Var);
            dm0Var.q.p = 0L;
            boolean z = true;
            if (io0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                s41.a(new a(dm0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(dm0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            ql0.b().f(AdDownloadAction.REMOVE, dm0Var);
            if (dm0Var.q.q > 0) {
                pl0.a().b(dm0Var);
            }
            dm0Var.q.p = -1L;
        }
        ul0.b().d();
    }
}
