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
import com.baidu.tieba.bl0;
import com.baidu.tieba.cm0;
import com.baidu.tieba.h41;
import com.baidu.tieba.ii0;
import com.baidu.tieba.jj0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.m21;
import com.baidu.tieba.mj0;
import com.baidu.tieba.nl0;
import com.baidu.tieba.oj0;
import com.baidu.tieba.rh0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.x01;
import com.baidu.tieba.xj0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public xj0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, xj0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ xj0 a;

        public a(xj0 xj0Var) {
            this.a = xj0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends rl0<ul0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rl0
        public void onEvent(@NonNull ul0 ul0Var) {
            AdAppStateManager.this.mIsForeGround = ul0Var.a;
            if (ul0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = mj0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    rh0.b(a);
                    mj0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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

    /* loaded from: classes2.dex */
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
        ii0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        nl0.a().b(new Object(), new b(ul0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !h41.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(xj0 xj0Var) {
        if (xj0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = xj0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(xj0Var);
    }

    public void register(@NonNull xj0 xj0Var) {
        if (TextUtils.isEmpty(xj0Var.d)) {
            return;
        }
        x01.e(this.mDatas, xj0Var.d, xj0Var);
    }

    public void launch(xj0 xj0Var) {
        this.mBlockingNotifyData = null;
        if (xj0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(xj0Var.d)) {
            String a2 = mj0.a(xj0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                rh0.b(a2);
                mj0.c(xj0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(xj0Var.p.c) && rh0.b(xj0Var.p.c)) || !xj0Var.q.u) {
            return;
        }
        bl0.g(xj0Var.d);
        kj0.d(AdDownloadAction.OPEN, xj0Var);
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
        xj0 xj0Var = (xj0) x01.b(this.mDatas, str);
        if (xj0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            xj0Var.c = AdDownloadStatus.INSTALLED;
            xj0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = ii0.b().getPackageManager().getPackageInfo(xj0Var.d, 0);
                if (packageInfo != null) {
                    xj0Var.o = packageInfo.versionName;
                    xj0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            xj0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            kj0.b().f(AdDownloadAction.INSTALL_FINISH, xj0Var);
            xj0Var.q.p = 0L;
            boolean z = true;
            if (cm0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                m21.a(new a(xj0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(xj0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            kj0.b().f(AdDownloadAction.REMOVE, xj0Var);
            if (xj0Var.q.q > 0) {
                jj0.a().b(xj0Var);
            }
            xj0Var.q.p = -1L;
        }
        oj0.b().d();
    }
}
