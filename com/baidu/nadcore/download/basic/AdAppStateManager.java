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
import com.baidu.tieba.al0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.g41;
import com.baidu.tieba.hi0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.jj0;
import com.baidu.tieba.l21;
import com.baidu.tieba.lj0;
import com.baidu.tieba.ml0;
import com.baidu.tieba.nj0;
import com.baidu.tieba.qh0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.w01;
import com.baidu.tieba.wj0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public wj0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, wj0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ wj0 a;

        public a(wj0 wj0Var) {
            this.a = wj0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ql0<tl0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ql0
        public void onEvent(@NonNull tl0 tl0Var) {
            AdAppStateManager.this.mIsForeGround = tl0Var.a;
            if (tl0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = lj0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    qh0.b(a);
                    lj0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        hi0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        ml0.a().b(new Object(), new b(tl0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !g41.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(wj0 wj0Var) {
        if (wj0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = wj0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(wj0Var);
    }

    public void register(@NonNull wj0 wj0Var) {
        if (TextUtils.isEmpty(wj0Var.d)) {
            return;
        }
        w01.e(this.mDatas, wj0Var.d, wj0Var);
    }

    public void launch(wj0 wj0Var) {
        this.mBlockingNotifyData = null;
        if (wj0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(wj0Var.d)) {
            String a2 = lj0.a(wj0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                qh0.b(a2);
                lj0.c(wj0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(wj0Var.p.c) && qh0.b(wj0Var.p.c)) || !wj0Var.q.u) {
            return;
        }
        al0.g(wj0Var.d);
        jj0.d(AdDownloadAction.OPEN, wj0Var);
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
        wj0 wj0Var = (wj0) w01.b(this.mDatas, str);
        if (wj0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            wj0Var.c = AdDownloadStatus.INSTALLED;
            wj0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = hi0.b().getPackageManager().getPackageInfo(wj0Var.d, 0);
                if (packageInfo != null) {
                    wj0Var.o = packageInfo.versionName;
                    wj0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            wj0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            jj0.b().f(AdDownloadAction.INSTALL_FINISH, wj0Var);
            wj0Var.q.p = 0L;
            boolean z = true;
            if (bm0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                l21.a(new a(wj0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(wj0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            jj0.b().f(AdDownloadAction.REMOVE, wj0Var);
            if (wj0Var.q.q > 0) {
                ij0.a().b(wj0Var);
            }
            wj0Var.q.p = -1L;
        }
        nj0.b().d();
    }
}
