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
import com.baidu.tieba.cl0;
import com.baidu.tieba.dm0;
import com.baidu.tieba.i41;
import com.baidu.tieba.ji0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.n21;
import com.baidu.tieba.nj0;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.sh0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.y01;
import com.baidu.tieba.yj0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public yj0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, yj0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ yj0 a;

        public a(yj0 yj0Var) {
            this.a = yj0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends sl0<vl0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sl0
        public void onEvent(@NonNull vl0 vl0Var) {
            AdAppStateManager.this.mIsForeGround = vl0Var.a;
            if (vl0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = nj0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    sh0.b(a);
                    nj0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        ji0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        ol0.a().b(new Object(), new b(vl0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !i41.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(yj0 yj0Var) {
        if (yj0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = yj0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(yj0Var);
    }

    public void register(@NonNull yj0 yj0Var) {
        if (TextUtils.isEmpty(yj0Var.d)) {
            return;
        }
        y01.e(this.mDatas, yj0Var.d, yj0Var);
    }

    public void launch(yj0 yj0Var) {
        this.mBlockingNotifyData = null;
        if (yj0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(yj0Var.d)) {
            String a2 = nj0.a(yj0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                sh0.b(a2);
                nj0.c(yj0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(yj0Var.p.c) && sh0.b(yj0Var.p.c)) || !yj0Var.q.u) {
            return;
        }
        cl0.g(yj0Var.d);
        lj0.d(AdDownloadAction.OPEN, yj0Var);
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
        yj0 yj0Var = (yj0) y01.b(this.mDatas, str);
        if (yj0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            yj0Var.c = AdDownloadStatus.INSTALLED;
            yj0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = ji0.b().getPackageManager().getPackageInfo(yj0Var.d, 0);
                if (packageInfo != null) {
                    yj0Var.o = packageInfo.versionName;
                    yj0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            yj0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            lj0.b().f(AdDownloadAction.INSTALL_FINISH, yj0Var);
            yj0Var.q.p = 0L;
            boolean z = true;
            if (dm0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                n21.a(new a(yj0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(yj0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            lj0.b().f(AdDownloadAction.REMOVE, yj0Var);
            if (yj0Var.q.q > 0) {
                kj0.a().b(yj0Var);
            }
            yj0Var.q.p = -1L;
        }
        pj0.b().d();
    }
}
