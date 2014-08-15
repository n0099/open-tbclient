package com.baidu.sapi2.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ShareReceiver extends BroadcastReceiver {
    private static Context a;
    private static LoginShareStrategy b;
    private static com.baidu.sapi2.d c;
    private static e d;
    private static boolean e = false;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!e) {
            a(context);
        }
        if (e) {
            String action = intent.getAction();
            if ("baidu.intent.action.SHARE_V6".equals(action)) {
                ShareModel shareModel = (ShareModel) intent.getParcelableExtra("LOGIN_SHARE_MODEL");
                String b2 = com.baidu.sapi2.share.a.b(context, shareModel.c());
                if (TextUtils.isEmpty(b2) || !b2.equals(context.getPackageName())) {
                    if (intent.getSerializableExtra("RUNTIME_ENVIRONMENT") == null || !(intent.getSerializableExtra("RUNTIME_ENVIRONMENT") instanceof Domain) || ((Domain) intent.getSerializableExtra("RUNTIME_ENVIRONMENT")) == SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                        String stringExtra = intent.getStringExtra("RELOGIN_CREDENTIALS");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            try {
                                JSONObject jSONObject = new JSONObject(com.baidu.sapi2.share.a.b(context, stringExtra));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    c.a(next, SapiAccount.ReloginCredentials.fromJSONObject(jSONObject.optJSONObject(next)));
                                }
                            } catch (Throwable th) {
                                L.e(th);
                            }
                        }
                        if (d != null) {
                            d.a(shareModel);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if ("baidu.intent.action.SHARE".equals(action) || "baidu.intent.action.NEWSHARE".equals(action)) {
                c.a(context, intent, b, d);
            }
        }
    }

    void a(Context context) {
        try {
            a = context;
            c = com.baidu.sapi2.d.a(context);
            b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy;
            d = new b();
            e = true;
        } catch (IllegalStateException e2) {
            e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements e {
        b() {
        }

        @Override // com.baidu.sapi2.share.e
        public void a(ShareModel shareModel) {
            if (shareModel != null && ShareReceiver.b != LoginShareStrategy.DISABLED) {
                switch (shareModel.b()) {
                    case VALIDATE:
                        ShareReceiver.this.a(ShareEvent.VALIDATE, shareModel);
                        return;
                    case INVALIDATE:
                        ShareReceiver.this.a(shareModel);
                        return;
                    case SYNC_REQ:
                        ShareReceiver.this.a();
                        return;
                    case SYNC_ACK:
                        ShareReceiver.this.a(ShareEvent.SYNC_ACK, shareModel);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    void a(ShareEvent shareEvent, ShareModel shareModel) {
        shareModel.b(a);
        if (b == LoginShareStrategy.SILENT && !c.h() && c.d() == null && shareModel.a().size() > 0 && SapiUtils.isValidAccount(shareModel.a().get(0))) {
            SapiAccount sapiAccount = shareModel.a().get(0);
            c.a(sapiAccount);
            c.c(sapiAccount);
            c.d(sapiAccount);
            if (shareEvent == ShareEvent.SYNC_ACK) {
                if (SapiAccountManager.getInstance().getSapiConfiguration().shareListener != null) {
                    SapiAccountManager.getInstance().getSapiConfiguration().shareListener.onSilentShare();
                }
                if (SapiAccountManager.getInstance().getSapiConfiguration().firstLaunchListener != null) {
                    SapiAccountManager.getInstance().getSapiConfiguration().firstLaunchListener.onReceivedAccount();
                }
            }
            for (SapiAccount sapiAccount2 : shareModel.a()) {
                if (a(sapiAccount2)) {
                    c.b(sapiAccount2);
                }
            }
            com.baidu.sapi2.utils.c.a("silent_login_share");
            return;
        }
        for (SapiAccount sapiAccount3 : shareModel.a()) {
            if (a(sapiAccount3)) {
                c.b(sapiAccount3);
            }
            b(sapiAccount3);
        }
    }

    boolean a(SapiAccount sapiAccount) {
        return SapiUtils.isValidAccount(sapiAccount) && (c.d() == null || !c.d().uid.equals(sapiAccount.uid)) && !c.f().contains(sapiAccount);
    }

    void a(ShareModel shareModel) {
        shareModel.b(a);
        if (shareModel.a().size() > 0) {
            SapiAccount sapiAccount = shareModel.a().get(0);
            if (c.d() == null || !c.d().uid.equals(sapiAccount.uid)) {
                c.d(sapiAccount);
            }
        }
    }

    void a() {
        Intent intent = new Intent("baidu.intent.action.SHARE_V6");
        ShareModel shareModel = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount d2 = c.d();
        if (d2 != null) {
            d2.app = SapiUtils.getAppName(a);
        }
        shareModel.a(d2);
        shareModel.a().addAll(c.e());
        shareModel.a().addAll(c.f());
        for (SapiAccount sapiAccount : shareModel.a()) {
            sapiAccount.app = SapiUtils.getAppName(a);
        }
        shareModel.a(a.getPackageName());
        shareModel.a(b);
        shareModel.a(a);
        intent.putExtra("LOGIN_SHARE_MODEL", shareModel);
        if (c.k() != null) {
            intent.putExtra("RELOGIN_CREDENTIALS", com.baidu.sapi2.share.a.a(a, c.k().toString()));
        }
        intent.putExtra("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        if (Build.VERSION.SDK_INT > 11) {
            intent.addFlags(32);
        }
        a.sendBroadcast(intent, "com.baidu.permission.SHARE");
    }

    static void b(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            SapiAccount d2 = c.d();
            if (d2 != null && sapiAccount.uid.equals(d2.uid)) {
                d2.bduss = sapiAccount.bduss;
                c.a(d2);
            }
            for (SapiAccount sapiAccount2 : c.f()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    sapiAccount2.bduss = sapiAccount.bduss;
                    c.c(sapiAccount2);
                }
            }
            for (SapiAccount sapiAccount3 : c.e()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    sapiAccount3.bduss = sapiAccount.bduss;
                    c.b(sapiAccount3);
                }
            }
        }
    }
}
