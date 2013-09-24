package com.baidu.loginshare;

import android.content.Context;
import com.baidu.share.IShareListener;
import com.baidu.share.ShareAssistant;
import com.baidu.share.ShareModel;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static final int m = 100;
    private static final int n = 1;

    /* renamed from: a  reason: collision with root package name */
    private Context f798a = null;
    private ShareAssistant b = null;
    private String c = "loginshare";
    private i d = null;
    private Token e = null;
    private c f = null;
    private a g = new a();
    private j h = new j();
    private String i = "1";
    private String j = "0";
    private String k = "1";
    private String l = "0";
    private volatile boolean o = false;
    private k p = null;
    private volatile boolean q = false;
    private ArrayList r = new ArrayList();
    private IShareListener s = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (g.f().equals(str)) {
                token.mUsername = f.b(this.f798a, (String) hashMap.get(str));
            } else if (g.g().equals(str)) {
                token.mEmail = f.b(this.f798a, (String) hashMap.get(str));
            } else if (g.h().equals(str)) {
                token.mPhoneNumber = f.b(this.f798a, (String) hashMap.get(str));
            } else if (g.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!e.a(str2)) {
                    return;
                }
                token.mBduss = f.b(this.f798a, str2);
            } else if (g.j().equals(str)) {
                token.mPtoken = f.b(this.f798a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, f.b(this.f798a, str3));
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

    private boolean a(ShareModel shareModel, boolean z, String str) {
        if (d()) {
            boolean share = this.g.a() ? this.b.share(shareModel) : false;
            if (share && z) {
                this.f.a(1, str);
                return share;
            }
            return share;
        }
        synchronized (this.r) {
            this.r.add(shareModel);
        }
        if (!this.q) {
            this.p = new k(this, z, str);
            new Thread(this.p).start();
        }
        return true;
    }

    private boolean a(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.d != null) {
            this.d.a(g.k(), z ? "1" : "0");
            this.d.a(g.f(), str);
            this.d.a(g.g(), str2);
            this.d.a(g.h(), str3);
            this.d.a(g.i(), str4);
            this.d.a(g.j(), str5);
            if (e.a(str6)) {
                this.d.a(g.n(), str6);
            }
            return this.d.a();
        }
        return false;
    }

    private boolean a(boolean z, String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
        if (this.d != null) {
            this.d.a(g.k(), z ? "1" : "0");
            this.d.a(g.f(), str);
            this.d.a(g.g(), str2);
            this.d.a(g.h(), str3);
            this.d.a(g.i(), str4);
            this.d.a(g.j(), str5);
            if (hashMap != null) {
                this.d.a(g.n(), new JSONObject(hashMap).toString());
            }
            return this.d.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (g.f().equals(str)) {
                token.mUsername = f.b(this.f798a, (String) hashMap.get(str));
            } else if (g.g().equals(str)) {
                token.mEmail = f.b(this.f798a, (String) hashMap.get(str));
            } else if (g.h().equals(str)) {
                token.mPhoneNumber = f.b(this.f798a, (String) hashMap.get(str));
            } else if (g.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!e.a(str2)) {
                    return;
                }
                token.mBduss = f.b(this.f798a, str2);
            } else if (g.j().equals(str)) {
                token.mPtoken = f.b(this.f798a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, f.b(this.f798a, str3));
            }
        }
        if (c(token)) {
            token.mEvent = LoginShareEvent.INVALID;
            a(false, token.mUsername, token.mEmail, token.mPhoneNumber, token.mBduss, token.mPtoken, token.mExtras);
            this.e = token;
            this.h.a(token);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareModel shareModel) {
        String str = shareModel.mFrom;
        if (e.a(this.d.a(g.k()))) {
            String a2 = f.a(this.f798a, this.d.a(g.i()));
            if (e.a(a2)) {
                ShareModel shareModel2 = new ShareModel();
                shareModel2.mAction = g.b();
                shareModel2.mData.put(g.k(), f.a(this.f798a, this.d.a(g.k())));
                shareModel2.mData.put(g.f(), f.a(this.f798a, this.d.a(g.f())));
                shareModel2.mData.put(g.g(), f.a(this.f798a, this.d.a(g.g())));
                shareModel2.mData.put(g.h(), f.a(this.f798a, this.d.a(g.h())));
                shareModel2.mData.put(g.i(), a2);
                shareModel2.mData.put(g.j(), f.a(this.f798a, this.d.a(g.j())));
                shareModel2.mData.put(g.n(), f.a(this.f798a, this.d.a(g.n())));
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.b.share(shareModel2, arrayList);
            }
        }
    }

    private static boolean c(Token token) {
        return token != null && token.mExtras != null && e.a(token.mBduss) && e.a(token.mPtoken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareModel shareModel) {
        HashMap hashMap = shareModel.mData;
        String str = (String) hashMap.get(g.g());
        String str2 = (String) hashMap.get(g.h());
        String str3 = (String) hashMap.get(g.i());
        String str4 = (String) hashMap.get(g.j());
        String str5 = (String) hashMap.get(g.n());
        Token token = new Token();
        String b = f.b(this.f798a, (String) hashMap.get(g.k()));
        String b2 = f.b(this.f798a, (String) hashMap.get(g.f()));
        String b3 = f.b(this.f798a, str);
        String b4 = f.b(this.f798a, str2);
        String b5 = f.b(this.f798a, str3);
        String b6 = f.b(this.f798a, str4);
        String b7 = f.b(this.f798a, str5);
        if (e.a(b) && e.a(b5)) {
            if (e.a(b7)) {
                HashMap hashMap2 = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(b7);
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
            token.mEvent = this.i.equals(b) ? LoginShareEvent.VALID : LoginShareEvent.INVALID;
            token.mUsername = b2;
            token.mEmail = b3;
            token.mPhoneNumber = b4;
            token.mBduss = b5;
            token.mPtoken = b6;
            if (a(this.i.equals(b), b2, b3, b4, b5, b6, b7)) {
                this.e = token;
                this.h.a(token);
            }
        }
    }

    private boolean d() {
        long b = this.g.b();
        Date date = new Date(System.currentTimeMillis());
        long time = new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
        return b < Util.MILLSECONDS_OF_DAY + time && b >= time;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, String str2) {
        if (this.o) {
            return;
        }
        if (context == null || !e.a(str) || !e.a(str2)) {
            throw new IllegalArgumentException("params cannot be null");
        }
        this.f798a = context;
        this.f = new c(str, str2);
        this.b = ShareAssistant.a(this.f798a);
        this.b.registListener(this.s);
        this.d = new i(this.f798a);
        String a2 = this.d.a(g.k());
        if (!e.a(a2)) {
            this.d.a(g.k(), this.j);
            this.d.a(g.m(), this.k);
            this.d.a();
            this.g.a(true);
            new l(this).start();
            this.o = true;
            return;
        }
        String a3 = this.d.a(g.m());
        String a4 = this.d.a(g.p());
        this.g.a(this.k.equals(a3));
        try {
            this.g.a(Long.parseLong(a4));
        } catch (Exception e) {
        }
        String a5 = this.d.a(g.f());
        String a6 = this.d.a(g.g());
        String a7 = this.d.a(g.h());
        String a8 = this.d.a(g.i());
        String a9 = this.d.a(g.j());
        String a10 = this.d.a(g.n());
        HashMap hashMap = new HashMap();
        if (e.a(a10)) {
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
        this.e = new Token();
        this.e.mEvent = this.i.equals(a2) ? LoginShareEvent.VALID : LoginShareEvent.INVALID;
        this.e.mUsername = a5;
        this.e.mEmail = a6;
        this.e.mPhoneNumber = a7;
        this.e.mBduss = a8;
        this.e.mPtoken = a9;
        this.e.mExtras = hashMap;
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ILoginShareListener iLoginShareListener) {
        this.h.a(iLoginShareListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Token token) {
        if (this.o && c(token)) {
            String str = token.mUsername;
            String str2 = token.mEmail;
            String str3 = token.mPhoneNumber;
            String str4 = token.mBduss;
            String str5 = token.mPtoken;
            String a2 = f.a(this.f798a, str);
            String a3 = f.a(this.f798a, str2);
            String a4 = f.a(this.f798a, str3);
            String a5 = f.a(this.f798a, str4);
            String a6 = f.a(this.f798a, str5);
            HashMap hashMap = new HashMap();
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = g.c();
            shareModel.mData.put(g.f(), a2);
            shareModel.mData.put(g.g(), a3);
            shareModel.mData.put(g.h(), a4);
            shareModel.mData.put(g.i(), a5);
            shareModel.mData.put(g.j(), a6);
            for (String str6 : token.mExtras.keySet()) {
                String a7 = f.a(this.f798a, (String) token.mExtras.get(str6));
                hashMap.put(str6, a7);
                shareModel.mData.put(str6, a7);
            }
            a(true, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            this.e = token;
            return a(shareModel, true, str4);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.b != null && this.s != null) {
            this.b.unRegistListener(this.s);
            this.b = null;
        }
        this.f = null;
        this.f798a = null;
        this.o = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Token token) {
        if (this.o && c(token)) {
            String str = token.mUsername;
            String str2 = token.mEmail;
            String str3 = token.mPhoneNumber;
            String str4 = token.mBduss;
            String str5 = token.mPtoken;
            String a2 = f.a(this.f798a, str);
            String a3 = f.a(this.f798a, str2);
            String a4 = f.a(this.f798a, str3);
            String a5 = f.a(this.f798a, str4);
            String a6 = f.a(this.f798a, str5);
            HashMap hashMap = new HashMap();
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = g.d();
            shareModel.mData.put(g.f(), a2);
            shareModel.mData.put(g.g(), a3);
            shareModel.mData.put(g.h(), a4);
            shareModel.mData.put(g.i(), a5);
            shareModel.mData.put(g.j(), a6);
            for (String str6 : token.mExtras.keySet()) {
                String a7 = f.a(this.f798a, (String) token.mExtras.get(str6));
                hashMap.put(str6, a7);
                shareModel.mData.put(str6, a7);
            }
            a(false, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.INVALID;
            this.e = token;
            return a(shareModel, false, str4);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f != null) {
            this.f.b();
        }
    }
}
