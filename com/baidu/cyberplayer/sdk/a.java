package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0069a> f4754a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0069a {

        /* renamed from: a  reason: collision with root package name */
        public String f4755a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4756b;

        public C0069a(String str, Object obj) {
            this.f4755a = str;
            this.f4756b = obj;
        }

        public String a() {
            return this.f4755a;
        }

        public void a(Object obj) {
            this.f4756b = obj;
        }

        public Object b() {
            return this.f4756b;
        }
    }

    public void a() {
        this.f4754a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f4754a.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0069a c0069a = this.f4754a.get(i2);
            if (c0069a != null && c0069a.a() != null && c0069a.a().equals(str)) {
                c0069a.a(obj);
                return;
            }
        }
        this.f4754a.add(new C0069a(str, obj));
    }

    public ArrayList<C0069a> b() {
        return this.f4754a;
    }
}
