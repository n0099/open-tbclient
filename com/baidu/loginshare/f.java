package com.baidu.loginshare;

import android.content.Context;
import com.baidu.share.Crypto;
import com.baidu.share.IShareListener;
import com.baidu.share.ShareAssistant;
import com.baidu.share.ShareModel;
import com.baidu.tieba.util.NetWorkCore;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private static final int q = 100;
    private static final int r = 1;
    Context a = null;
    ShareAssistant b = null;
    String c = "loginshare";
    a d = null;
    Token e = null;
    j f = null;
    b g = new b();
    e h = new e();
    String i = NetWorkCore.NET_TYPE_NET;
    String j = "0";
    String k = NetWorkCore.NET_TYPE_NET;
    String l = "0";
    volatile boolean m = false;
    private i s = null;
    volatile boolean n = false;
    ArrayList o = new ArrayList();
    IShareListener p = new g(this);

    static /* synthetic */ void a(f fVar, ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (Keystore.f().equals(str)) {
                token.mUsername = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else if (Keystore.g().equals(str)) {
                token.mEmail = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else if (Keystore.h().equals(str)) {
                token.mPhoneNumber = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else if (Keystore.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!l.a(str2)) {
                    return;
                }
                token.mBduss = Crypto.decrypt(fVar.a, str2);
            } else if (Keystore.j().equals(str)) {
                token.mPtoken = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, Crypto.decrypt(fVar.a, str3));
            }
        }
        if (c(token)) {
            fVar.a(true, token.mUsername, token.mEmail, token.mPhoneNumber, token.mBduss, token.mPtoken, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            fVar.e = token;
            fVar.f.a(2, token.mBduss);
            fVar.h.a(token);
        }
    }

    private void a(ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (Keystore.f().equals(str)) {
                token.mUsername = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else if (Keystore.g().equals(str)) {
                token.mEmail = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else if (Keystore.h().equals(str)) {
                token.mPhoneNumber = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else if (Keystore.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!l.a(str2)) {
                    return;
                }
                token.mBduss = Crypto.decrypt(this.a, str2);
            } else if (Keystore.j().equals(str)) {
                token.mPtoken = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, Crypto.decrypt(this.a, str3));
            }
        }
        if (c(token)) {
            a(true, token.mUsername, token.mEmail, token.mPhoneNumber, token.mBduss, token.mPtoken, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            this.e = token;
            this.f.a(2, token.mBduss);
            this.h.a(token);
        }
    }

    private boolean a(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.d != null) {
            this.d.a(Keystore.k(), z ? NetWorkCore.NET_TYPE_NET : "0");
            this.d.a(Keystore.f(), str);
            this.d.a(Keystore.g(), str2);
            this.d.a(Keystore.h(), str3);
            this.d.a(Keystore.i(), str4);
            this.d.a(Keystore.j(), str5);
            if (l.a(str6)) {
                this.d.a(Keystore.m(), str6);
            }
            return this.d.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar, ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (Keystore.f().equals(str)) {
                token.mUsername = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else if (Keystore.g().equals(str)) {
                token.mEmail = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else if (Keystore.h().equals(str)) {
                token.mPhoneNumber = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else if (Keystore.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!l.a(str2)) {
                    return;
                }
                token.mBduss = Crypto.decrypt(fVar.a, str2);
            } else if (Keystore.j().equals(str)) {
                token.mPtoken = Crypto.decrypt(fVar.a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, Crypto.decrypt(fVar.a, str3));
            }
        }
        if (c(token)) {
            token.mEvent = LoginShareEvent.INVALID;
            fVar.a(false, token.mUsername, token.mEmail, token.mPhoneNumber, token.mBduss, token.mPtoken, token.mExtras);
            fVar.e = token;
            fVar.h.a(token);
        }
    }

    private void b(ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (Keystore.f().equals(str)) {
                token.mUsername = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else if (Keystore.g().equals(str)) {
                token.mEmail = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else if (Keystore.h().equals(str)) {
                token.mPhoneNumber = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else if (Keystore.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!l.a(str2)) {
                    return;
                }
                token.mBduss = Crypto.decrypt(this.a, str2);
            } else if (Keystore.j().equals(str)) {
                token.mPtoken = Crypto.decrypt(this.a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, Crypto.decrypt(this.a, str3));
            }
        }
        if (c(token)) {
            token.mEvent = LoginShareEvent.INVALID;
            a(false, token.mUsername, token.mEmail, token.mPhoneNumber, token.mBduss, token.mPtoken, token.mExtras);
            this.e = token;
            this.h.a(token);
        }
    }

    static /* synthetic */ void c(f fVar, ShareModel shareModel) {
        String str = shareModel.mFrom;
        if (l.a(fVar.d.a(Keystore.k()))) {
            String encrypt = Crypto.encrypt(fVar.a, fVar.d.a(Keystore.i()));
            if (l.a(encrypt)) {
                ShareModel shareModel2 = new ShareModel();
                shareModel2.mAction = Keystore.b();
                shareModel2.mData.put(Keystore.k(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.k())));
                shareModel2.mData.put(Keystore.f(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.f())));
                shareModel2.mData.put(Keystore.g(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.g())));
                shareModel2.mData.put(Keystore.h(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.h())));
                shareModel2.mData.put(Keystore.i(), encrypt);
                shareModel2.mData.put(Keystore.j(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.j())));
                shareModel2.mData.put(Keystore.m(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.m())));
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                fVar.b.share(shareModel2, arrayList);
            }
        }
    }

    private void c(ShareModel shareModel) {
        String str = shareModel.mFrom;
        if (l.a(this.d.a(Keystore.k()))) {
            String encrypt = Crypto.encrypt(this.a, this.d.a(Keystore.i()));
            if (l.a(encrypt)) {
                ShareModel shareModel2 = new ShareModel();
                shareModel2.mAction = Keystore.b();
                shareModel2.mData.put(Keystore.k(), Crypto.encrypt(this.a, this.d.a(Keystore.k())));
                shareModel2.mData.put(Keystore.f(), Crypto.encrypt(this.a, this.d.a(Keystore.f())));
                shareModel2.mData.put(Keystore.g(), Crypto.encrypt(this.a, this.d.a(Keystore.g())));
                shareModel2.mData.put(Keystore.h(), Crypto.encrypt(this.a, this.d.a(Keystore.h())));
                shareModel2.mData.put(Keystore.i(), encrypt);
                shareModel2.mData.put(Keystore.j(), Crypto.encrypt(this.a, this.d.a(Keystore.j())));
                shareModel2.mData.put(Keystore.m(), Crypto.encrypt(this.a, this.d.a(Keystore.m())));
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.b.share(shareModel2, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Token token) {
        return (token == null || token.mExtras == null || !l.a(token.mBduss)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(f fVar, ShareModel shareModel) {
        boolean z;
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        String decrypt = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.k()));
        String decrypt2 = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.f()));
        String decrypt3 = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.g()));
        String decrypt4 = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.h()));
        String decrypt5 = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.i()));
        String decrypt6 = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.j()));
        String decrypt7 = Crypto.decrypt(fVar.a, (String) hashMap.get(Keystore.m()));
        if (l.a(decrypt) && l.a(decrypt5)) {
            if (l.a(decrypt7)) {
                HashMap hashMap2 = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(decrypt7);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap2.put(next, jSONObject.optString(next));
                    }
                    token.mExtras = hashMap2;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            token.mEvent = fVar.i.equals(decrypt) ? LoginShareEvent.VALID : LoginShareEvent.INVALID;
            token.mUsername = decrypt2;
            token.mEmail = decrypt3;
            token.mPhoneNumber = decrypt4;
            token.mBduss = decrypt5;
            token.mPtoken = decrypt6;
            boolean equals = fVar.i.equals(decrypt);
            if (fVar.d != null) {
                fVar.d.a(Keystore.k(), equals ? NetWorkCore.NET_TYPE_NET : "0");
                fVar.d.a(Keystore.f(), decrypt2);
                fVar.d.a(Keystore.g(), decrypt3);
                fVar.d.a(Keystore.h(), decrypt4);
                fVar.d.a(Keystore.i(), decrypt5);
                fVar.d.a(Keystore.j(), decrypt6);
                if (l.a(decrypt7)) {
                    fVar.d.a(Keystore.m(), decrypt7);
                }
                z = fVar.d.a();
            } else {
                z = false;
            }
            if (z) {
                fVar.e = token;
                fVar.h.a(token);
            }
        }
    }

    private void d(ShareModel shareModel) {
        boolean z;
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        String decrypt = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.k()));
        String decrypt2 = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.f()));
        String decrypt3 = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.g()));
        String decrypt4 = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.h()));
        String decrypt5 = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.i()));
        String decrypt6 = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.j()));
        String decrypt7 = Crypto.decrypt(this.a, (String) hashMap.get(Keystore.m()));
        if (l.a(decrypt) && l.a(decrypt5)) {
            if (l.a(decrypt7)) {
                HashMap hashMap2 = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(decrypt7);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap2.put(next, jSONObject.optString(next));
                    }
                    token.mExtras = hashMap2;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            token.mEvent = this.i.equals(decrypt) ? LoginShareEvent.VALID : LoginShareEvent.INVALID;
            token.mUsername = decrypt2;
            token.mEmail = decrypt3;
            token.mPhoneNumber = decrypt4;
            token.mBduss = decrypt5;
            token.mPtoken = decrypt6;
            boolean equals = this.i.equals(decrypt);
            if (this.d != null) {
                this.d.a(Keystore.k(), equals ? NetWorkCore.NET_TYPE_NET : "0");
                this.d.a(Keystore.f(), decrypt2);
                this.d.a(Keystore.g(), decrypt3);
                this.d.a(Keystore.h(), decrypt4);
                this.d.a(Keystore.i(), decrypt5);
                this.d.a(Keystore.j(), decrypt6);
                if (l.a(decrypt7)) {
                    this.d.a(Keystore.m(), decrypt7);
                }
                z = this.d.a();
            } else {
                z = false;
            }
            if (z) {
                this.e = token;
                this.h.a(token);
            }
        }
    }

    private boolean d() {
        long j = this.g.b;
        Date date = new Date(System.currentTimeMillis());
        long time = new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
        return j < 86400000 + time && j >= time;
    }

    final Token a() {
        return this.e;
    }

    final void a(Context context, String str, String str2) {
        if (this.m) {
            return;
        }
        if (context == null || !l.a(str) || !l.a(str2)) {
            throw new IllegalArgumentException("params cannot be null");
        }
        this.a = context;
        this.f = new j(str, str2);
        this.b = ShareAssistant.a(this.a);
        this.b.registListener(this.p);
        this.d = new a(this.a);
        String a = this.d.a(Keystore.k());
        if (!l.a(a)) {
            this.d.a(Keystore.k(), this.j);
            this.d.a(Keystore.l(), this.k);
            this.d.a();
            this.g.a = true;
            new h(this).start();
            this.m = true;
            return;
        }
        String a2 = this.d.a(Keystore.l());
        String a3 = this.d.a(Keystore.o());
        this.g.a = this.k.equals(a2);
        try {
            this.g.b = Long.parseLong(a3);
        } catch (Exception e) {
        }
        String a4 = this.d.a(Keystore.f());
        String a5 = this.d.a(Keystore.g());
        String a6 = this.d.a(Keystore.h());
        String a7 = this.d.a(Keystore.i());
        String a8 = this.d.a(Keystore.j());
        String a9 = this.d.a(Keystore.m());
        HashMap hashMap = new HashMap();
        if (l.a(a9)) {
            try {
                JSONObject jSONObject = new JSONObject(a9);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.e = new Token();
        this.e.mEvent = this.i.equals(a) ? LoginShareEvent.VALID : LoginShareEvent.INVALID;
        this.e.mUsername = a4;
        this.e.mEmail = a5;
        this.e.mPhoneNumber = a6;
        this.e.mBduss = a7;
        this.e.mPtoken = a8;
        this.e.mExtras = hashMap;
        this.m = true;
    }

    final void a(ILoginShareListener iLoginShareListener) {
        this.h.a(iLoginShareListener);
    }

    final boolean a(Token token) {
        if (this.m && c(token)) {
            String str = token.mUsername;
            String str2 = token.mEmail;
            String str3 = token.mPhoneNumber;
            String str4 = token.mBduss;
            String str5 = token.mPtoken;
            String encrypt = Crypto.encrypt(this.a, str);
            String encrypt2 = Crypto.encrypt(this.a, str2);
            String encrypt3 = Crypto.encrypt(this.a, str3);
            String encrypt4 = Crypto.encrypt(this.a, str4);
            String encrypt5 = Crypto.encrypt(this.a, str5);
            HashMap hashMap = new HashMap();
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = Keystore.c();
            shareModel.mData.put(Keystore.f(), encrypt);
            shareModel.mData.put(Keystore.g(), encrypt2);
            shareModel.mData.put(Keystore.h(), encrypt3);
            shareModel.mData.put(Keystore.i(), encrypt4);
            shareModel.mData.put(Keystore.j(), encrypt5);
            for (String str6 : token.mExtras.keySet()) {
                String encrypt6 = Crypto.encrypt(this.a, (String) token.mExtras.get(str6));
                hashMap.put(str6, encrypt6);
                shareModel.mData.put(str6, encrypt6);
            }
            a(true, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            this.e = token;
            return a(shareModel, true, str4);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ShareModel shareModel, boolean z, String str) {
        long j = this.g.b;
        Date date = new Date(System.currentTimeMillis());
        long time = new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
        if (j < 86400000 + time && j >= time) {
            boolean share = this.g.a ? this.b.share(shareModel) : false;
            if (share && z) {
                this.f.a(1, str);
                return share;
            }
            return share;
        }
        synchronized (this.o) {
            this.o.add(shareModel);
        }
        if (!this.n) {
            this.s = new i(this, z, str);
            new Thread(this.s).start();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(boolean z, String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
        if (this.d != null) {
            this.d.a(Keystore.k(), z ? NetWorkCore.NET_TYPE_NET : "0");
            this.d.a(Keystore.f(), str);
            this.d.a(Keystore.g(), str2);
            this.d.a(Keystore.h(), str3);
            this.d.a(Keystore.i(), str4);
            this.d.a(Keystore.j(), str5);
            if (hashMap != null) {
                this.d.a(Keystore.m(), new JSONObject(hashMap).toString());
            }
            return this.d.a();
        }
        return false;
    }

    final void b() {
        if (this.b != null && this.p != null) {
            this.b.unRegistListener(this.p);
            this.b = null;
        }
        this.f = null;
        this.a = null;
        this.m = false;
    }

    final boolean b(Token token) {
        if (this.m && c(token)) {
            String str = token.mUsername;
            String str2 = token.mEmail;
            String str3 = token.mPhoneNumber;
            String str4 = token.mBduss;
            String str5 = token.mPtoken;
            String encrypt = Crypto.encrypt(this.a, str);
            String encrypt2 = Crypto.encrypt(this.a, str2);
            String encrypt3 = Crypto.encrypt(this.a, str3);
            String encrypt4 = Crypto.encrypt(this.a, str4);
            String encrypt5 = Crypto.encrypt(this.a, str5);
            HashMap hashMap = new HashMap();
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = Keystore.d();
            shareModel.mData.put(Keystore.f(), encrypt);
            shareModel.mData.put(Keystore.g(), encrypt2);
            shareModel.mData.put(Keystore.h(), encrypt3);
            shareModel.mData.put(Keystore.i(), encrypt4);
            shareModel.mData.put(Keystore.j(), encrypt5);
            for (String str6 : token.mExtras.keySet()) {
                String encrypt6 = Crypto.encrypt(this.a, (String) token.mExtras.get(str6));
                hashMap.put(str6, encrypt6);
                shareModel.mData.put(str6, encrypt6);
            }
            a(false, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.INVALID;
            this.e = token;
            return a(shareModel, false, str4);
        }
        return false;
    }

    final void c() {
        if (this.f != null) {
            this.f.c = true;
        }
    }
}
