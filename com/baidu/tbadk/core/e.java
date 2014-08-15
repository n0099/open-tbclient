package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class e {
    protected ae a;
    protected NewErrorData b = null;

    public e() {
        this.a = null;
        this.a = new ae();
    }

    public void a() {
        if (this.a != null) {
            this.a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.a.a(str);
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String h = this.a.h();
        this.b = new NewErrorData();
        this.b.parserJson(h);
        return h;
    }

    public boolean c() {
        if (this.a != null) {
            return this.a.a().b().b();
        }
        return false;
    }

    public String d() {
        if (this.a != null) {
            return this.a.e();
        }
        return null;
    }

    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        return -1;
    }

    public String f() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        return null;
    }
}
