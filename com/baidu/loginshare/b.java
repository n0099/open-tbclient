package com.baidu.loginshare;

import android.content.Context;
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
    private Context a = null;
    private com.baidu.share.b b = null;
    private String c = "loginshare";
    private j d = null;
    private Token e = null;
    private c f = null;
    private a g = new a();
    private i h = new i();
    private String i = "1";
    private String j = "0";
    private String k = "1";
    private String l = "0";
    private volatile boolean o = false;
    private k p = null;
    private volatile boolean q = false;
    private ArrayList r = new ArrayList();
    private com.baidu.share.a s = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.share.c cVar) {
        HashMap hashMap = cVar.d;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (h.f().equals(str)) {
                token.mUsername = f.b(this.a, (String) hashMap.get(str));
            } else if (h.g().equals(str)) {
                token.mEmail = f.b(this.a, (String) hashMap.get(str));
            } else if (h.h().equals(str)) {
                token.mPhoneNumber = f.b(this.a, (String) hashMap.get(str));
            } else if (h.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!e.a(str2)) {
                    return;
                }
                token.mBduss = f.b(this.a, str2);
            } else if (h.j().equals(str)) {
                token.mPtoken = f.b(this.a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, f.b(this.a, str3));
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

    private boolean a(com.baidu.share.c cVar, boolean z, String str) {
        if (d()) {
            boolean a = this.g.a() ? this.b.a(cVar) : false;
            if (a && z) {
                this.f.a(1, str);
                return a;
            }
            return a;
        }
        synchronized (this.r) {
            this.r.add(cVar);
        }
        if (!this.q) {
            this.p = new k(this, z, str);
            new Thread(this.p).start();
        }
        return true;
    }

    private boolean a(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.d != null) {
            this.d.a(h.k(), z ? "1" : "0");
            this.d.a(h.f(), str);
            this.d.a(h.g(), str2);
            this.d.a(h.h(), str3);
            this.d.a(h.i(), str4);
            this.d.a(h.j(), str5);
            if (e.a(str6)) {
                this.d.a(h.n(), str6);
            }
            return this.d.a();
        }
        return false;
    }

    private boolean a(boolean z, String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
        if (this.d != null) {
            this.d.a(h.k(), z ? "1" : "0");
            this.d.a(h.f(), str);
            this.d.a(h.g(), str2);
            this.d.a(h.h(), str3);
            this.d.a(h.i(), str4);
            this.d.a(h.j(), str5);
            if (hashMap != null) {
                this.d.a(h.n(), new JSONObject(hashMap).toString());
            }
            return this.d.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.share.c cVar) {
        HashMap hashMap = cVar.d;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            if (h.f().equals(str)) {
                token.mUsername = f.b(this.a, (String) hashMap.get(str));
            } else if (h.g().equals(str)) {
                token.mEmail = f.b(this.a, (String) hashMap.get(str));
            } else if (h.h().equals(str)) {
                token.mPhoneNumber = f.b(this.a, (String) hashMap.get(str));
            } else if (h.i().equals(str)) {
                String str2 = (String) hashMap.get(str);
                if (!e.a(str2)) {
                    return;
                }
                token.mBduss = f.b(this.a, str2);
            } else if (h.j().equals(str)) {
                token.mPtoken = f.b(this.a, (String) hashMap.get(str));
            } else {
                String str3 = (String) hashMap.get(str);
                hashMap2.put(str, str3);
                token.mExtras.put(str, f.b(this.a, str3));
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
    public void c(com.baidu.share.c cVar) {
        String str = cVar.b;
        if (e.a(this.d.a(h.k()))) {
            String a = f.a(this.a, this.d.a(h.i()));
            if (e.a(a)) {
                com.baidu.share.c cVar2 = new com.baidu.share.c();
                cVar2.a = h.b();
                cVar2.d.put(h.k(), f.a(this.a, this.d.a(h.k())));
                cVar2.d.put(h.f(), f.a(this.a, this.d.a(h.f())));
                cVar2.d.put(h.g(), f.a(this.a, this.d.a(h.g())));
                cVar2.d.put(h.h(), f.a(this.a, this.d.a(h.h())));
                cVar2.d.put(h.i(), a);
                cVar2.d.put(h.j(), f.a(this.a, this.d.a(h.j())));
                cVar2.d.put(h.n(), f.a(this.a, this.d.a(h.n())));
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.b.a(cVar2, arrayList);
            }
        }
    }

    private static boolean c(Token token) {
        return token != null && token.mExtras != null && e.a(token.mBduss) && e.a(token.mPtoken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.share.c cVar) {
        HashMap hashMap = cVar.d;
        String str = (String) hashMap.get(h.g());
        String str2 = (String) hashMap.get(h.h());
        String str3 = (String) hashMap.get(h.i());
        String str4 = (String) hashMap.get(h.j());
        String str5 = (String) hashMap.get(h.n());
        Token token = new Token();
        String b = f.b(this.a, (String) hashMap.get(h.k()));
        String b2 = f.b(this.a, (String) hashMap.get(h.f()));
        String b3 = f.b(this.a, str);
        String b4 = f.b(this.a, str2);
        String b5 = f.b(this.a, str3);
        String b6 = f.b(this.a, str4);
        String b7 = f.b(this.a, str5);
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
        return b < 86400000 + time && b >= time;
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
        this.a = context;
        this.f = new c(str, str2);
        this.b = com.baidu.share.b.a(this.a);
        this.b.a(this.s);
        this.d = new j(this.a);
        String a = this.d.a(h.k());
        if (!e.a(a)) {
            this.d.a(h.k(), this.j);
            this.d.a(h.m(), this.k);
            this.d.a();
            this.g.a(true);
            new l(this).start();
            this.o = true;
            return;
        }
        String a2 = this.d.a(h.m());
        String a3 = this.d.a(h.p());
        this.g.a(this.k.equals(a2));
        try {
            this.g.a(Long.parseLong(a3));
        } catch (Exception e) {
        }
        String a4 = this.d.a(h.f());
        String a5 = this.d.a(h.g());
        String a6 = this.d.a(h.h());
        String a7 = this.d.a(h.i());
        String a8 = this.d.a(h.j());
        String a9 = this.d.a(h.n());
        HashMap hashMap = new HashMap();
        if (e.a(a9)) {
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
            String a = f.a(this.a, str);
            String a2 = f.a(this.a, str2);
            String a3 = f.a(this.a, str3);
            String a4 = f.a(this.a, str4);
            String a5 = f.a(this.a, str5);
            HashMap hashMap = new HashMap();
            com.baidu.share.c cVar = new com.baidu.share.c();
            cVar.a = h.c();
            cVar.d.put(h.f(), a);
            cVar.d.put(h.g(), a2);
            cVar.d.put(h.h(), a3);
            cVar.d.put(h.i(), a4);
            cVar.d.put(h.j(), a5);
            for (String str6 : token.mExtras.keySet()) {
                String a6 = f.a(this.a, (String) token.mExtras.get(str6));
                hashMap.put(str6, a6);
                cVar.d.put(str6, a6);
            }
            a(true, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            this.e = token;
            return a(cVar, true, str4);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.b != null && this.s != null) {
            this.b.b(this.s);
            this.b = null;
        }
        this.f = null;
        this.a = null;
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
            String a = f.a(this.a, str);
            String a2 = f.a(this.a, str2);
            String a3 = f.a(this.a, str3);
            String a4 = f.a(this.a, str4);
            String a5 = f.a(this.a, str5);
            HashMap hashMap = new HashMap();
            com.baidu.share.c cVar = new com.baidu.share.c();
            cVar.a = h.d();
            cVar.d.put(h.f(), a);
            cVar.d.put(h.g(), a2);
            cVar.d.put(h.h(), a3);
            cVar.d.put(h.i(), a4);
            cVar.d.put(h.j(), a5);
            for (String str6 : token.mExtras.keySet()) {
                String a6 = f.a(this.a, (String) token.mExtras.get(str6));
                hashMap.put(str6, a6);
                cVar.d.put(str6, a6);
            }
            a(false, str, str2, str3, str4, str5, token.mExtras);
            token.mEvent = LoginShareEvent.INVALID;
            this.e = token;
            return a(cVar, false, str4);
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
