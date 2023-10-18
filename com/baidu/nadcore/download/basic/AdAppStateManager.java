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
import com.baidu.tieba.bi0;
import com.baidu.tieba.eg0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.l11;
import com.baidu.tieba.oh0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.qf0;
import com.baidu.tieba.qi0;
import com.baidu.tieba.rf0;
import com.baidu.tieba.tf0;
import com.baidu.tieba.vf0;
import com.baidu.tieba.vx0;
import com.baidu.tieba.yd0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public eg0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, eg0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ eg0 a;

        public a(eg0 eg0Var) {
            this.a = eg0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends fi0<ii0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi0
        public void onEvent(@NonNull ii0 ii0Var) {
            AdAppStateManager.this.mIsForeGround = ii0Var.a;
            if (ii0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = tf0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    yd0.b(a);
                    tf0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        pe0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        bi0.a().c(new Object(), new b(ii0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !l11.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(eg0 eg0Var) {
        if (eg0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = eg0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(eg0Var);
    }

    public void register(@NonNull eg0 eg0Var) {
        if (TextUtils.isEmpty(eg0Var.d)) {
            return;
        }
        vx0.e(this.mDatas, eg0Var.d, eg0Var);
    }

    public void launch(eg0 eg0Var) {
        this.mBlockingNotifyData = null;
        if (eg0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(eg0Var.d)) {
            String a2 = tf0.a(eg0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                yd0.b(a2);
                tf0.c(eg0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(eg0Var.p.c) && yd0.b(eg0Var.p.c)) || !eg0Var.q.u) {
            return;
        }
        oh0.h(eg0Var.d);
        rf0.e(AdDownloadAction.OPEN, eg0Var);
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
        eg0 eg0Var = (eg0) vx0.b(this.mDatas, str);
        if (eg0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            eg0Var.c = AdDownloadStatus.INSTALLED;
            eg0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = pe0.b().getPackageManager().getPackageInfo(eg0Var.d, 0);
                if (packageInfo != null) {
                    eg0Var.o = packageInfo.versionName;
                    eg0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            eg0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            rf0.c().g(AdDownloadAction.INSTALL_FINISH, eg0Var);
            eg0Var.q.p = 0L;
            boolean z = true;
            if (qi0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                kz0.a(new a(eg0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(eg0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            rf0.c().g(AdDownloadAction.REMOVE, eg0Var);
            if (eg0Var.q.q > 0) {
                qf0.a().b(eg0Var);
            }
            eg0Var.q.p = -1L;
        }
        vf0.b().e();
    }
}
