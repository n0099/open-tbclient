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
import com.baidu.tieba.a31;
import com.baidu.tieba.am0;
import com.baidu.tieba.en0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.k61;
import com.baidu.tieba.lk0;
import com.baidu.tieba.ml0;
import com.baidu.tieba.nl0;
import com.baidu.tieba.p41;
import com.baidu.tieba.pl0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.uj0;
import com.baidu.tieba.un0;
import com.baidu.tieba.xn0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public am0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, am0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ am0 a;

        public a(am0 am0Var) {
            this.a = am0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends un0<xn0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.un0
        public void onEvent(@NonNull xn0 xn0Var) {
            AdAppStateManager.this.mIsForeGround = xn0Var.a;
            if (xn0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = pl0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    uj0.b(a);
                    pl0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        lk0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        qn0.a().b(new Object(), new b(xn0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !k61.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(am0 am0Var) {
        if (am0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = am0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(am0Var);
    }

    public void register(@NonNull am0 am0Var) {
        if (TextUtils.isEmpty(am0Var.d)) {
            return;
        }
        a31.e(this.mDatas, am0Var.d, am0Var);
    }

    public void launch(am0 am0Var) {
        this.mBlockingNotifyData = null;
        if (am0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(am0Var.d)) {
            String a2 = pl0.a(am0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                uj0.b(a2);
                pl0.c(am0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(am0Var.p.c) && uj0.b(am0Var.p.c)) || !am0Var.q.u) {
            return;
        }
        en0.g(am0Var.d);
        nl0.d(AdDownloadAction.OPEN, am0Var);
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
        am0 am0Var = (am0) a31.b(this.mDatas, str);
        if (am0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            am0Var.c = AdDownloadStatus.INSTALLED;
            am0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = lk0.b().getPackageManager().getPackageInfo(am0Var.d, 0);
                if (packageInfo != null) {
                    am0Var.o = packageInfo.versionName;
                    am0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            am0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            nl0.b().f(AdDownloadAction.INSTALL_FINISH, am0Var);
            am0Var.q.p = 0L;
            boolean z = true;
            if (fo0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                p41.a(new a(am0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(am0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            nl0.b().f(AdDownloadAction.REMOVE, am0Var);
            if (am0Var.q.q > 0) {
                ml0.a().b(am0Var);
            }
            am0Var.q.p = -1L;
        }
        rl0.b().d();
    }
}
