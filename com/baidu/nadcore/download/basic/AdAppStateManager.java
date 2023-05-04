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
import com.baidu.tieba.a11;
import com.baidu.tieba.ak0;
import com.baidu.tieba.el0;
import com.baidu.tieba.fm0;
import com.baidu.tieba.k41;
import com.baidu.tieba.li0;
import com.baidu.tieba.mj0;
import com.baidu.tieba.nj0;
import com.baidu.tieba.p21;
import com.baidu.tieba.pj0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.rj0;
import com.baidu.tieba.uh0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.xl0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public ak0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, ak0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ ak0 a;

        public a(ak0 ak0Var) {
            this.a = ak0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ul0<xl0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ul0
        public void onEvent(@NonNull xl0 xl0Var) {
            AdAppStateManager.this.mIsForeGround = xl0Var.a;
            if (xl0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = pj0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    uh0.b(a);
                    pj0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        li0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        ql0.a().b(new Object(), new b(xl0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !k41.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(ak0 ak0Var) {
        if (ak0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = ak0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(ak0Var);
    }

    public void register(@NonNull ak0 ak0Var) {
        if (TextUtils.isEmpty(ak0Var.d)) {
            return;
        }
        a11.e(this.mDatas, ak0Var.d, ak0Var);
    }

    public void launch(ak0 ak0Var) {
        this.mBlockingNotifyData = null;
        if (ak0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(ak0Var.d)) {
            String a2 = pj0.a(ak0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                uh0.b(a2);
                pj0.c(ak0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(ak0Var.p.c) && uh0.b(ak0Var.p.c)) || !ak0Var.q.u) {
            return;
        }
        el0.g(ak0Var.d);
        nj0.d(AdDownloadAction.OPEN, ak0Var);
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
        ak0 ak0Var = (ak0) a11.b(this.mDatas, str);
        if (ak0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            ak0Var.c = AdDownloadStatus.INSTALLED;
            ak0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = li0.b().getPackageManager().getPackageInfo(ak0Var.d, 0);
                if (packageInfo != null) {
                    ak0Var.o = packageInfo.versionName;
                    ak0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ak0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            nj0.b().f(AdDownloadAction.INSTALL_FINISH, ak0Var);
            ak0Var.q.p = 0L;
            boolean z = true;
            if (fm0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                p21.a(new a(ak0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(ak0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            nj0.b().f(AdDownloadAction.REMOVE, ak0Var);
            if (ak0Var.q.q > 0) {
                mj0.a().b(ak0Var);
            }
            ak0Var.q.p = -1L;
        }
        rj0.b().d();
    }
}
