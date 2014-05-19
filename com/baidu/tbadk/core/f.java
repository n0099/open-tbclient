package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class f {
    protected al a;
    protected NewErrorData b = null;

    public f() {
        this.a = null;
        this.a = new al();
    }

    public void a() {
        if (this.a != null) {
            this.a.g();
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
        String i = this.a.i();
        this.b = new NewErrorData();
        this.b.parserJson(i);
        return i;
    }

    public boolean c() {
        if (this.a != null) {
            return this.a.a().b().b();
        }
        return false;
    }

    public String d() {
        if (this.a != null) {
            return this.a.f();
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
