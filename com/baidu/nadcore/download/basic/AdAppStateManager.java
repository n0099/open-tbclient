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
import com.baidu.tieba.bj0;
import com.baidu.tieba.en0;
import com.baidu.tieba.f31;
import com.baidu.tieba.hl0;
import com.baidu.tieba.in0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.rm0;
import com.baidu.tieba.sj0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.u41;
import com.baidu.tieba.u61;
import com.baidu.tieba.uk0;
import com.baidu.tieba.wk0;
import com.baidu.tieba.yk0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public hl0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, hl0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ hl0 a;

        public a(hl0 hl0Var) {
            this.a = hl0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends in0<ln0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.in0
        public void onEvent(@NonNull ln0 ln0Var) {
            AdAppStateManager.this.mIsForeGround = ln0Var.a;
            if (ln0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = wk0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    bj0.b(a);
                    wk0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        sj0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        en0.a().b(new Object(), new b(ln0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !u61.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(hl0 hl0Var) {
        if (hl0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = hl0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(hl0Var);
    }

    public void register(@NonNull hl0 hl0Var) {
        if (TextUtils.isEmpty(hl0Var.d)) {
            return;
        }
        f31.e(this.mDatas, hl0Var.d, hl0Var);
    }

    public void launch(hl0 hl0Var) {
        this.mBlockingNotifyData = null;
        if (hl0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(hl0Var.d)) {
            String a2 = wk0.a(hl0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                bj0.b(a2);
                wk0.c(hl0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(hl0Var.p.c) && bj0.b(hl0Var.p.c)) || !hl0Var.q.u) {
            return;
        }
        rm0.h(hl0Var.d);
        uk0.e(AdDownloadAction.OPEN, hl0Var);
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
        hl0 hl0Var = (hl0) f31.b(this.mDatas, str);
        if (hl0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            hl0Var.c = AdDownloadStatus.INSTALLED;
            hl0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = sj0.b().getPackageManager().getPackageInfo(hl0Var.d, 0);
                if (packageInfo != null) {
                    hl0Var.o = packageInfo.versionName;
                    hl0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            hl0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            uk0.c().g(AdDownloadAction.INSTALL_FINISH, hl0Var);
            hl0Var.q.p = 0L;
            boolean z = true;
            if (tn0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                u41.a(new a(hl0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(hl0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            uk0.c().g(AdDownloadAction.REMOVE, hl0Var);
            if (hl0Var.q.q > 0) {
                tk0.a().b(hl0Var);
            }
            hl0Var.q.p = -1L;
        }
        yk0.b().d();
    }
}
