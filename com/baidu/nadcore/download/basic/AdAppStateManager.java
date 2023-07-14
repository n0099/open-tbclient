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
import com.baidu.tieba.ak0;
import com.baidu.tieba.do0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.m71;
import com.baidu.tieba.o51;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.so0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.xl0;
import com.baidu.tieba.z31;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public gm0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, gm0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ gm0 a;

        public a(gm0 gm0Var) {
            this.a = gm0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ho0<ko0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ho0
        public void onEvent(@NonNull ko0 ko0Var) {
            AdAppStateManager.this.mIsForeGround = ko0Var.a;
            if (ko0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = vl0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    ak0.b(a);
                    vl0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        rk0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        do0.a().b(new Object(), new b(ko0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !m71.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(gm0 gm0Var) {
        if (gm0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = gm0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(gm0Var);
    }

    public void register(@NonNull gm0 gm0Var) {
        if (TextUtils.isEmpty(gm0Var.d)) {
            return;
        }
        z31.e(this.mDatas, gm0Var.d, gm0Var);
    }

    public void launch(gm0 gm0Var) {
        this.mBlockingNotifyData = null;
        if (gm0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(gm0Var.d)) {
            String a2 = vl0.a(gm0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                ak0.b(a2);
                vl0.c(gm0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(gm0Var.p.c) && ak0.b(gm0Var.p.c)) || !gm0Var.q.u) {
            return;
        }
        qn0.h(gm0Var.d);
        tl0.e(AdDownloadAction.OPEN, gm0Var);
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
        gm0 gm0Var = (gm0) z31.b(this.mDatas, str);
        if (gm0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            gm0Var.c = AdDownloadStatus.INSTALLED;
            gm0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = rk0.b().getPackageManager().getPackageInfo(gm0Var.d, 0);
                if (packageInfo != null) {
                    gm0Var.o = packageInfo.versionName;
                    gm0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            gm0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            tl0.c().g(AdDownloadAction.INSTALL_FINISH, gm0Var);
            gm0Var.q.p = 0L;
            boolean z = true;
            if (so0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                o51.a(new a(gm0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(gm0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            tl0.c().g(AdDownloadAction.REMOVE, gm0Var);
            if (gm0Var.q.q > 0) {
                sl0.a().b(gm0Var);
            }
            gm0Var.q.p = -1L;
        }
        xl0.b().d();
    }
}
