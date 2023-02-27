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
import com.baidu.tieba.an0;
import com.baidu.tieba.dn0;
import com.baidu.tieba.g21;
import com.baidu.tieba.gl0;
import com.baidu.tieba.km0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.q51;
import com.baidu.tieba.rj0;
import com.baidu.tieba.sk0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.v31;
import com.baidu.tieba.vk0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xk0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static final String TAG = "AdAppStateManager";
    public gl0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, gl0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ gl0 a;

        public a(gl0 gl0Var) {
            this.a = gl0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdAppStateManager.this.launch(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends an0<dn0> {
        public b(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.an0
        public void onEvent(@NonNull dn0 dn0Var) {
            AdAppStateManager.this.mIsForeGround = dn0Var.a;
            if (dn0Var.a && AdAppStateManager.this.mBlockingNotifyData != null) {
                String a = vk0.a(AdAppStateManager.this.mBlockingNotifyData.d);
                if (a != null) {
                    aj0.b(a);
                    vk0.c(AdAppStateManager.this.mBlockingNotifyData.d);
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
        rj0.b().registerReceiver(this, intentFilter);
        registerBackForegroundEvent();
    }

    public static AdAppStateManager instance() {
        return c.a;
    }

    public void registerBackForegroundEvent() {
        wm0.a().b(new Object(), new b(dn0.class));
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        if (i > 0 && !q51.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
            return true;
        }
        return false;
    }

    public void launchAfterInstall(gl0 gl0Var) {
        if (gl0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = gl0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(gl0Var);
    }

    public void register(@NonNull gl0 gl0Var) {
        if (TextUtils.isEmpty(gl0Var.d)) {
            return;
        }
        g21.e(this.mDatas, gl0Var.d, gl0Var);
    }

    public void launch(gl0 gl0Var) {
        this.mBlockingNotifyData = null;
        if (gl0Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(gl0Var.d)) {
            String a2 = vk0.a(gl0Var.d);
            if (!TextUtils.isEmpty(a2)) {
                aj0.b(a2);
                vk0.c(gl0Var.d);
                return;
            }
        }
        if ((!TextUtils.isEmpty(gl0Var.p.c) && aj0.b(gl0Var.p.c)) || !gl0Var.q.u) {
            return;
        }
        km0.g(gl0Var.d);
        tk0.d(AdDownloadAction.OPEN, gl0Var);
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
        gl0 gl0Var = (gl0) g21.b(this.mDatas, str);
        if (gl0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            gl0Var.c = AdDownloadStatus.INSTALLED;
            gl0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = rj0.b().getPackageManager().getPackageInfo(gl0Var.d, 0);
                if (packageInfo != null) {
                    gl0Var.o = packageInfo.versionName;
                    gl0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            gl0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            tk0.b().f(AdDownloadAction.INSTALL_FINISH, gl0Var);
            gl0Var.q.p = 0L;
            boolean z = true;
            if (ln0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                v31.a(new a(gl0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(gl0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            tk0.b().f(AdDownloadAction.REMOVE, gl0Var);
            if (gl0Var.q.q > 0) {
                sk0.a().b(gl0Var);
            }
            gl0Var.q.p = -1L;
        }
        xk0.b().d();
    }
}
