package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0070a> f4777a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0070a {

        /* renamed from: a  reason: collision with root package name */
        public String f4778a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4779b;

        public C0070a(String str, Object obj) {
            this.f4778a = str;
            this.f4779b = obj;
        }

        public String a() {
            return this.f4778a;
        }

        public void a(Object obj) {
            this.f4779b = obj;
        }

        public Object b() {
            return this.f4779b;
        }
    }

    public void a() {
        this.f4777a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f4777a.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0070a c0070a = this.f4777a.get(i2);
            if (c0070a != null && c0070a.a() != null && c0070a.a().equals(str)) {
                c0070a.a(obj);
                return;
            }
        }
        this.f4777a.add(new C0070a(str, obj));
    }

    public ArrayList<C0070a> b() {
        return this.f4777a;
    }
}
