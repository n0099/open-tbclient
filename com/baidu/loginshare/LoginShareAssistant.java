package com.baidu.loginshare;

import android.content.Context;
import com.baidu.share.Crypto;
import com.baidu.share.ShareAssistant;
import com.baidu.share.ShareModel;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LoginShareAssistant {
    private static LoginShareAssistant a = null;
    private f b;

    static {
        System.loadLibrary("loginshare");
    }

    private LoginShareAssistant() {
        this.b = null;
        this.b = new f();
    }

    public static synchronized LoginShareAssistant getInstance() {
        LoginShareAssistant loginShareAssistant;
        synchronized (LoginShareAssistant.class) {
            if (a == null) {
                a = new LoginShareAssistant();
            }
            loginShareAssistant = a;
        }
        return loginShareAssistant;
    }

    public void destroy() {
        if (this.b != null) {
            f fVar = this.b;
            if (fVar.b != null && fVar.p != null) {
                fVar.b.unRegistListener(fVar.p);
                fVar.b = null;
            }
            fVar.f = null;
            fVar.a = null;
            fVar.m = false;
        }
        a = null;
        this.b = null;
    }

    public Token getLastToken() {
        return this.b.e;
    }

    public void initial(Context context, String str, String str2) {
        f fVar = this.b;
        if (fVar.m) {
            return;
        }
        if (context == null || !l.a(str) || !l.a(str2)) {
            throw new IllegalArgumentException("params cannot be null");
        }
        fVar.a = context;
        fVar.f = new j(str, str2);
        fVar.b = ShareAssistant.a(fVar.a);
        fVar.b.registListener(fVar.p);
        fVar.d = new a(fVar.a);
        String a2 = fVar.d.a(Keystore.k());
        if (!l.a(a2)) {
            fVar.d.a(Keystore.k(), fVar.j);
            fVar.d.a(Keystore.l(), fVar.k);
            fVar.d.a();
            fVar.g.a = true;
            new h(fVar).start();
            fVar.m = true;
            return;
        }
        String a3 = fVar.d.a(Keystore.l());
        String a4 = fVar.d.a(Keystore.o());
        fVar.g.a = fVar.k.equals(a3);
        try {
            fVar.g.b = Long.parseLong(a4);
        } catch (Exception e) {
        }
        String a5 = fVar.d.a(Keystore.f());
        String a6 = fVar.d.a(Keystore.g());
        String a7 = fVar.d.a(Keystore.h());
        String a8 = fVar.d.a(Keystore.i());
        String a9 = fVar.d.a(Keystore.j());
        String a10 = fVar.d.a(Keystore.m());
        HashMap hashMap = new HashMap();
        if (l.a(a10)) {
            try {
                JSONObject jSONObject = new JSONObject(a10);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        fVar.e = new Token();
        fVar.e.mEvent = fVar.i.equals(a2) ? LoginShareEvent.VALID : LoginShareEvent.INVALID;
        fVar.e.mUsername = a5;
        fVar.e.mEmail = a6;
        fVar.e.mPhoneNumber = a7;
        fVar.e.mBduss = a8;
        fVar.e.mPtoken = a9;
        fVar.e.mExtras = hashMap;
        fVar.m = true;
    }

    public boolean invalid(Token token) {
        f fVar = this.b;
        if (fVar.m && f.c(token)) {
            String str = token.mUsername;
            String str2 = token.mEmail;
            String str3 = token.mPhoneNumber;
            String str4 = token.mBduss;
            String str5 = token.mPtoken;
            String encrypt = Crypto.encrypt(fVar.a, str);
            String encrypt2 = Crypto.encrypt(fVar.a, str2);
            String encrypt3 = Crypto.encrypt(fVar.a, str3);
            String encrypt4 = Crypto.encrypt(fVar.a, str4);
            String encrypt5 = Crypto.encrypt(fVar.a, str5);
            HashMap hashMap = new HashMap();
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = Keystore.d();
            shareModel.mData.put(Keystore.f(), encrypt);
            shareModel.mData.put(Keystore.g(), encrypt2);
            shareModel.mData.put(Keystore.h(), encrypt3);
            shareModel.mData.put(Keystore.i(), encrypt4);
            shareModel.mData.put(Keystore.j(), encrypt5);
            for (String str6 : token.mExtras.keySet()) {
                String encrypt6 = Crypto.encrypt(fVar.a, (String) token.mExtras.get(str6));
                hashMap.put(str6, encrypt6);
                shareModel.mData.put(str6, encrypt6);
            }
            fVar.a(false, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.INVALID;
            fVar.e = token;
            return fVar.a(shareModel, false, str4);
        }
        return false;
    }

    public void onActivityCreate() {
        f fVar = this.b;
        if (fVar.f != null) {
            fVar.f.c = true;
        }
    }

    public void setLoginShareListener(ILoginShareListener iLoginShareListener) {
        this.b.h.a(iLoginShareListener);
    }

    public boolean valid(Token token) {
        f fVar = this.b;
        if (fVar.m && f.c(token)) {
            String str = token.mUsername;
            String str2 = token.mEmail;
            String str3 = token.mPhoneNumber;
            String str4 = token.mBduss;
            String str5 = token.mPtoken;
            String encrypt = Crypto.encrypt(fVar.a, str);
            String encrypt2 = Crypto.encrypt(fVar.a, str2);
            String encrypt3 = Crypto.encrypt(fVar.a, str3);
            String encrypt4 = Crypto.encrypt(fVar.a, str4);
            String encrypt5 = Crypto.encrypt(fVar.a, str5);
            HashMap hashMap = new HashMap();
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = Keystore.c();
            shareModel.mData.put(Keystore.f(), encrypt);
            shareModel.mData.put(Keystore.g(), encrypt2);
            shareModel.mData.put(Keystore.h(), encrypt3);
            shareModel.mData.put(Keystore.i(), encrypt4);
            shareModel.mData.put(Keystore.j(), encrypt5);
            for (String str6 : token.mExtras.keySet()) {
                String encrypt6 = Crypto.encrypt(fVar.a, (String) token.mExtras.get(str6));
                hashMap.put(str6, encrypt6);
                shareModel.mData.put(str6, encrypt6);
            }
            fVar.a(true, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            fVar.e = token;
            return fVar.a(shareModel, true, str4);
        }
        return false;
    }
}
