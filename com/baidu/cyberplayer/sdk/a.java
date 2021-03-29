package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0070a> f4845a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0070a {

        /* renamed from: a  reason: collision with root package name */
        public String f4846a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4847b;

        public C0070a(String str, Object obj) {
            this.f4846a = str;
            this.f4847b = obj;
        }

        public String a() {
            return this.f4846a;
        }

        public void a(Object obj) {
            this.f4847b = obj;
        }

        public Object b() {
            return this.f4847b;
        }
    }

    public void a() {
        this.f4845a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f4845a.size();
        for (int i = 0; i < size; i++) {
            C0070a c0070a = this.f4845a.get(i);
            if (c0070a != null && c0070a.a() != null && c0070a.a().equals(str)) {
                c0070a.a(obj);
                return;
            }
        }
        this.f4845a.add(new C0070a(str, obj));
    }

    public ArrayList<C0070a> b() {
        return this.f4845a;
    }
}
