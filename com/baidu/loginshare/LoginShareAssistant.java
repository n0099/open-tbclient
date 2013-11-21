package com.baidu.loginshare;

import android.content.Context;
/* loaded from: classes.dex */
public class LoginShareAssistant {

    /* renamed from: a  reason: collision with root package name */
    private static LoginShareAssistant f940a = null;
    private b b;

    private LoginShareAssistant() {
        this.b = null;
        this.b = new b();
    }

    public static synchronized LoginShareAssistant getInstance() {
        LoginShareAssistant loginShareAssistant;
        synchronized (LoginShareAssistant.class) {
            if (f940a == null) {
                f940a = new LoginShareAssistant();
            }
            loginShareAssistant = f940a;
        }
        return loginShareAssistant;
    }

    public void destroy() {
        if (this.b != null) {
            this.b.b();
        }
        f940a = null;
        this.b = null;
    }

    public Token getLastToken() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    public void initial(Context context, String str, String str2) {
        try {
            this.b.a(context, str, str2);
        } catch (Throwable th) {
        }
    }

    public boolean invalid(Token token) {
        try {
            return this.b.b(token);
        } catch (Throwable th) {
            return false;
        }
    }

    public void onActivityCreate() {
        if (this.b != null) {
            this.b.c();
        }
    }

    public void setLoginShareListener(ILoginShareListener iLoginShareListener) {
        try {
            this.b.a(iLoginShareListener);
        } catch (Throwable th) {
        }
    }

    public boolean valid(Token token) {
        try {
            return this.b.a(token);
        } catch (Throwable th) {
            return false;
        }
    }
}
