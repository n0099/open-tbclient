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
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.a51;
import com.baidu.tieba.bj0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.dk0;
import com.baidu.tieba.f31;
import com.baidu.tieba.fk0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.hk0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.km0;
import com.baidu.tieba.nm0;
import com.baidu.tieba.q11;
import com.baidu.tieba.qk0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.vm0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public qk0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, qk0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ qk0 a;

        public a(qk0 qk0Var) {
            this.a = qk0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends km0<nm0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.km0
        public void onEvent(@NonNull nm0 nm0Var) {
            AdAppStateManager.this.mIsForeGround = nm0Var.a;
            if (nm0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = fk0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    ki0.b(a);
                    fk0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        bj0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        gm0.a().b(new Object(), new b(nm0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !a51.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(qk0 qk0Var) {
        if (qk0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = qk0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(qk0Var);
    }

    public void register(@NonNull qk0 qk0Var) {
        if (TextUtils.isEmpty(qk0Var.d)) {
            return;
        }
        q11.e(this.mDatas, qk0Var.d, qk0Var);
    }

    public void launch(qk0 qk0Var) {
        this.mBlockingNotifyData = null;
        if (qk0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(qk0Var.d)) {
            String a2 = fk0.a(qk0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                ki0.b(a2);
                fk0.c(qk0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(qk0Var.p.c) && ki0.b(qk0Var.p.c)) || !qk0Var.q.u) {
            return;
        }
        ul0.g(qk0Var.d);
        dk0.d(AdDownloadAction.OPEN, qk0Var);
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
        qk0 qk0Var = (qk0) q11.b(this.mDatas, str);
        if (qk0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            qk0Var.c = AdDownloadStatus.INSTALLED;
            qk0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = bj0.b().getPackageManager().getPackageInfo(qk0Var.d, 0);
                if (packageInfo != null) {
                    qk0Var.o = packageInfo.versionName;
                    qk0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            qk0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            dk0.b().f(AdDownloadAction.INSTALL_FINISH, qk0Var);
            qk0Var.q.p = 0L;
            boolean z = true;
            if (vm0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                f31.a(new a(qk0Var), "nad_uad_launch_immediate", 0, BoxAccountManager.GET_SHARE_LOGIN_INFO_DEFAULT_TIMEOUT);
            } else {
                launchAfterInstall(qk0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            dk0.b().f(AdDownloadAction.REMOVE, qk0Var);
            if (qk0Var.q.q > 0) {
                ck0.a().b(qk0Var);
            }
            qk0Var.q.p = -1L;
        }
        hk0.b().d();
    }
}
