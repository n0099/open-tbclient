package com.baidu.sapi2.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
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
    private static boolean f = false;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!e) {
            a(context);
        }
        if (e) {
            String action = intent.getAction();
            if ("baidu.intent.action.SHARE_V6".equals(action)) {
                ShareModel shareModel = (ShareModel) intent.getParcelableExtra("LOGIN_SHARE_MODEL");
                String b2 = com.baidu.sapi2.share.a.b(context, shareModel.e());
                if (TextUtils.isEmpty(b2) || !b2.equals(context.getPackageName())) {
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
            }
            if ("baidu.intent.action.SHARE".equals(action) || "baidu.intent.action.NEWSHARE".equals(action)) {
                c.a(context, intent, b, d);
            }
        }
    }

    private void a(Context context) {
        try {
            a = context;
            c = com.baidu.sapi2.d.a(context);
            b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy;
            d = new b(context);
            e = true;
        } catch (IllegalStateException e2) {
            e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements e {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.baidu.sapi2.share.e
        public void a(ShareModel shareModel) {
            if (shareModel != null && ShareReceiver.b != LoginShareStrategy.DISABLED) {
                switch (shareModel.c()) {
                    case VALIDATE:
                        ShareReceiver.this.a(ShareEvent.VALIDATE, shareModel);
                        return;
                    case INVALIDATE:
                        ShareReceiver.this.a(shareModel);
                        return;
                    case SYNC_REQ:
                        Intent intent = new Intent("baidu.intent.action.SHARE_V6");
                        ShareModel shareModel2 = new ShareModel(ShareEvent.SYNC_ACK);
                        SapiAccount d = ShareReceiver.c.d();
                        if (d != null) {
                            d.app = com.baidu.sapi2.utils.c.a(this.a);
                        }
                        shareModel2.a(d);
                        shareModel2.a(ShareReceiver.c.e());
                        shareModel2.a().addAll(ShareReceiver.c.f());
                        for (SapiAccount sapiAccount : shareModel2.a()) {
                            sapiAccount.app = com.baidu.sapi2.utils.c.a(this.a);
                        }
                        shareModel2.a(this.a.getPackageName());
                        shareModel2.a(this.a);
                        intent.putExtra("LOGIN_SHARE_MODEL", shareModel2);
                        if (ShareReceiver.c.i() != null) {
                            intent.putExtra("RELOGIN_CREDENTIALS", com.baidu.sapi2.share.a.a(this.a, ShareReceiver.c.i().toString()));
                        }
                        this.a.sendBroadcast(intent, "com.baidu.permission.SHARE");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEvent shareEvent, ShareModel shareModel) {
        shareModel.b(a);
        switch (b) {
            case SILENT:
                c();
                if (a(shareModel.d())) {
                    c.a(shareModel.d());
                    c.c(shareModel.d());
                    if (shareEvent == ShareEvent.SYNC_ACK && !f && SapiAccountManager.getInstance().getSapiConfiguration().firstLaunchListener != null) {
                        SapiAccountManager.getInstance().getSapiConfiguration().firstLaunchListener.onReceivedAccount();
                        f = true;
                        return;
                    }
                    return;
                }
                return;
            case CHOICE:
                for (SapiAccount sapiAccount : shareModel.a()) {
                    if (!c.f().contains(sapiAccount) && a(sapiAccount)) {
                        c.b(sapiAccount);
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareModel shareModel) {
        shareModel.b(a);
        if (shareModel.a().size() > 0) {
            SapiAccount sapiAccount = shareModel.a().get(0);
            switch (b) {
                case SILENT:
                    if (c.d() != null && sapiAccount.uid.equals(c.d().uid)) {
                        c.a((SapiAccount) null);
                        c.e(sapiAccount);
                        return;
                    }
                    return;
                case CHOICE:
                    if (c.d() == null || !c.d().uid.equals(sapiAccount.uid)) {
                        c.d(sapiAccount);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void c() {
        for (SapiAccount sapiAccount : c.e()) {
            c.d(sapiAccount);
        }
    }

    static boolean a(SapiAccount sapiAccount) {
        return (sapiAccount == null || TextUtils.isEmpty(sapiAccount.bduss) || TextUtils.isEmpty(sapiAccount.uid) || TextUtils.isEmpty(sapiAccount.displayname)) ? false : true;
    }
}
