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
import com.baidu.tieba.bn0;
import com.baidu.tieba.c31;
import com.baidu.tieba.el0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.in0;
import com.baidu.tieba.om0;
import com.baidu.tieba.p61;
import com.baidu.tieba.pj0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.r41;
import com.baidu.tieba.rk0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.vk0;
import com.baidu.tieba.yi0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public el0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, el0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ el0 a;

        public a(el0 el0Var) {
            this.a = el0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends fn0<in0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fn0
        public void onEvent(@NonNull in0 in0Var) {
            AdAppStateManager.this.mIsForeGround = in0Var.a;
            if (in0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = tk0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    yi0.b(a);
                    tk0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        pj0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        bn0.a().b(new Object(), new b(in0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !p61.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(el0 el0Var) {
        if (el0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = el0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(el0Var);
    }

    public void register(@NonNull el0 el0Var) {
        if (TextUtils.isEmpty(el0Var.d)) {
            return;
        }
        c31.e(this.mDatas, el0Var.d, el0Var);
    }

    public void launch(el0 el0Var) {
        this.mBlockingNotifyData = null;
        if (el0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(el0Var.d)) {
            String a2 = tk0.a(el0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                yi0.b(a2);
                tk0.c(el0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(el0Var.p.c) && yi0.b(el0Var.p.c)) || !el0Var.q.u) {
            return;
        }
        om0.h(el0Var.d);
        rk0.e(AdDownloadAction.OPEN, el0Var);
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
        el0 el0Var = (el0) c31.b(this.mDatas, str);
        if (el0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            el0Var.c = AdDownloadStatus.INSTALLED;
            el0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = pj0.b().getPackageManager().getPackageInfo(el0Var.d, 0);
                if (packageInfo != null) {
                    el0Var.o = packageInfo.versionName;
                    el0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            el0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            rk0.c().g(AdDownloadAction.INSTALL_FINISH, el0Var);
            el0Var.q.p = 0L;
            boolean z = true;
            if (qn0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                r41.a(new a(el0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(el0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            rk0.c().g(AdDownloadAction.REMOVE, el0Var);
            if (el0Var.q.q > 0) {
                qk0.a().b(el0Var);
            }
            el0Var.q.p = -1L;
        }
        vk0.b().d();
    }
}
