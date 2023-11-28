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
import com.baidu.tieba.aj0;
import com.baidu.tieba.c01;
import com.baidu.tieba.d21;
import com.baidu.tieba.gi0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.ig0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.jg0;
import com.baidu.tieba.lg0;
import com.baidu.tieba.ng0;
import com.baidu.tieba.ny0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.wg0;
import com.baidu.tieba.xi0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public wg0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, wg0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ wg0 a;

        public a(wg0 wg0Var) {
            this.a = wg0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends xi0<aj0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(@NonNull aj0 aj0Var) {
            AdAppStateManager.this.mIsForeGround = aj0Var.a;
            if (aj0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = lg0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    qe0.b(a);
                    lg0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        hf0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        ti0.a().c(new Object(), new b(aj0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !d21.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(wg0 wg0Var) {
        if (wg0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = wg0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(wg0Var);
    }

    public void register(@NonNull wg0 wg0Var) {
        if (TextUtils.isEmpty(wg0Var.d)) {
            return;
        }
        ny0.e(this.mDatas, wg0Var.d, wg0Var);
    }

    public void launch(wg0 wg0Var) {
        this.mBlockingNotifyData = null;
        if (wg0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(wg0Var.d)) {
            String a2 = lg0.a(wg0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                qe0.b(a2);
                lg0.c(wg0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(wg0Var.p.c) && qe0.b(wg0Var.p.c)) || !wg0Var.q.u) {
            return;
        }
        gi0.h(wg0Var.d);
        jg0.e(AdDownloadAction.OPEN, wg0Var);
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
        wg0 wg0Var = (wg0) ny0.b(this.mDatas, str);
        if (wg0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            wg0Var.c = AdDownloadStatus.INSTALLED;
            wg0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = hf0.b().getPackageManager().getPackageInfo(wg0Var.d, 0);
                if (packageInfo != null) {
                    wg0Var.o = packageInfo.versionName;
                    wg0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            wg0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            jg0.c().g(AdDownloadAction.INSTALL_FINISH, wg0Var);
            wg0Var.q.p = 0L;
            boolean z = true;
            if (ij0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                c01.a(new a(wg0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(wg0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            jg0.c().g(AdDownloadAction.REMOVE, wg0Var);
            if (wg0Var.q.q > 0) {
                ig0.a().b(wg0Var);
            }
            wg0Var.q.p = -1L;
        }
        ng0.b().e();
    }
}
