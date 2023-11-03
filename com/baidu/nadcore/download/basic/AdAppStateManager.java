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
import com.baidu.tieba.b01;
import com.baidu.tieba.c21;
import com.baidu.tieba.fi0;
import com.baidu.tieba.gf0;
import com.baidu.tieba.hg0;
import com.baidu.tieba.hj0;
import com.baidu.tieba.ig0;
import com.baidu.tieba.kg0;
import com.baidu.tieba.mg0;
import com.baidu.tieba.my0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.si0;
import com.baidu.tieba.vg0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.zi0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public vg0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, vg0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ vg0 a;

        public a(vg0 vg0Var) {
            this.a = vg0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wi0<zi0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(@NonNull zi0 zi0Var) {
            AdAppStateManager.this.mIsForeGround = zi0Var.a;
            if (zi0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = kg0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    pe0.b(a);
                    kg0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        gf0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        si0.a().c(new Object(), new b(zi0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !c21.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(vg0 vg0Var) {
        if (vg0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = vg0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(vg0Var);
    }

    public void register(@NonNull vg0 vg0Var) {
        if (TextUtils.isEmpty(vg0Var.d)) {
            return;
        }
        my0.e(this.mDatas, vg0Var.d, vg0Var);
    }

    public void launch(vg0 vg0Var) {
        this.mBlockingNotifyData = null;
        if (vg0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(vg0Var.d)) {
            String a2 = kg0.a(vg0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                pe0.b(a2);
                kg0.c(vg0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(vg0Var.p.c) && pe0.b(vg0Var.p.c)) || !vg0Var.q.u) {
            return;
        }
        fi0.h(vg0Var.d);
        ig0.e(AdDownloadAction.OPEN, vg0Var);
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
        vg0 vg0Var = (vg0) my0.b(this.mDatas, str);
        if (vg0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            vg0Var.c = AdDownloadStatus.INSTALLED;
            vg0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = gf0.b().getPackageManager().getPackageInfo(vg0Var.d, 0);
                if (packageInfo != null) {
                    vg0Var.o = packageInfo.versionName;
                    vg0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            vg0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            ig0.c().g(AdDownloadAction.INSTALL_FINISH, vg0Var);
            vg0Var.q.p = 0L;
            boolean z = true;
            if (hj0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                b01.a(new a(vg0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(vg0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            ig0.c().g(AdDownloadAction.REMOVE, vg0Var);
            if (vg0Var.q.q > 0) {
                hg0.a().b(vg0Var);
            }
            vg0Var.q.p = -1L;
        }
        mg0.b().e();
    }
}
