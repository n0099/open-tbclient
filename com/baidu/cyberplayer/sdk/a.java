package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0069a> f5000a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0069a {

        /* renamed from: a  reason: collision with root package name */
        public String f5001a;

        /* renamed from: b  reason: collision with root package name */
        public Object f5002b;

        public C0069a(String str, Object obj) {
            this.f5001a = str;
            this.f5002b = obj;
        }

        public String a() {
            return this.f5001a;
        }

        public void a(Object obj) {
            this.f5002b = obj;
        }

        public Object b() {
            return this.f5002b;
        }
    }

    public void a() {
        this.f5000a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f5000a.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0069a c0069a = this.f5000a.get(i2);
            if (c0069a != null && c0069a.a() != null && c0069a.a().equals(str)) {
                c0069a.a(obj);
                return;
            }
        }
        this.f5000a.add(new C0069a(str, obj));
    }

    public ArrayList<C0069a> b() {
        return this.f5000a;
    }
}
