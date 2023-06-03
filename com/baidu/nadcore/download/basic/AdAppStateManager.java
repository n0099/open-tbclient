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
import com.baidu.tieba.dn0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.j61;
import com.baidu.tieba.kk0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.ml0;
import com.baidu.tieba.o41;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.z21;
import com.baidu.tieba.zl0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public zl0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, zl0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ zl0 a;

        public a(zl0 zl0Var) {
            this.a = zl0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends tn0<wn0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tn0
        public void onEvent(@NonNull wn0 wn0Var) {
            AdAppStateManager.this.mIsForeGround = wn0Var.a;
            if (wn0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = ol0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    tj0.b(a);
                    ol0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        kk0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        pn0.a().b(new Object(), new b(wn0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !j61.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(zl0 zl0Var) {
        if (zl0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = zl0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(zl0Var);
    }

    public void register(@NonNull zl0 zl0Var) {
        if (TextUtils.isEmpty(zl0Var.d)) {
            return;
        }
        z21.e(this.mDatas, zl0Var.d, zl0Var);
    }

    public void launch(zl0 zl0Var) {
        this.mBlockingNotifyData = null;
        if (zl0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(zl0Var.d)) {
            String a2 = ol0.a(zl0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                tj0.b(a2);
                ol0.c(zl0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(zl0Var.p.c) && tj0.b(zl0Var.p.c)) || !zl0Var.q.u) {
            return;
        }
        dn0.g(zl0Var.d);
        ml0.d(AdDownloadAction.OPEN, zl0Var);
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
        zl0 zl0Var = (zl0) z21.b(this.mDatas, str);
        if (zl0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            zl0Var.c = AdDownloadStatus.INSTALLED;
            zl0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = kk0.b().getPackageManager().getPackageInfo(zl0Var.d, 0);
                if (packageInfo != null) {
                    zl0Var.o = packageInfo.versionName;
                    zl0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            zl0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            ml0.b().f(AdDownloadAction.INSTALL_FINISH, zl0Var);
            zl0Var.q.p = 0L;
            boolean z = true;
            if (eo0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                o41.a(new a(zl0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(zl0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            ml0.b().f(AdDownloadAction.REMOVE, zl0Var);
            if (zl0Var.q.q > 0) {
                ll0.a().b(zl0Var);
            }
            zl0Var.q.p = -1L;
        }
        ql0.b().d();
    }
}
