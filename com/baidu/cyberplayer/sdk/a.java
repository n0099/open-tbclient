package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0069a> f4880a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069a {

        /* renamed from: a  reason: collision with root package name */
        public String f4881a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4882b;

        public C0069a(String str, Object obj) {
            this.f4881a = str;
            this.f4882b = obj;
        }

        public String a() {
            return this.f4881a;
        }

        public void a(Object obj) {
            this.f4882b = obj;
        }

        public Object b() {
            return this.f4882b;
        }
    }

    public void a() {
        this.f4880a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f4880a.size();
        for (int i = 0; i < size; i++) {
            C0069a c0069a = this.f4880a.get(i);
            if (c0069a != null && c0069a.a() != null && c0069a.a().equals(str)) {
                c0069a.a(obj);
                return;
            }
        }
        this.f4880a.add(new C0069a(str, obj));
    }

    public ArrayList<C0069a> b() {
        return this.f4880a;
    }
}
