package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0068a> f4854a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0068a {

        /* renamed from: a  reason: collision with root package name */
        public String f4855a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4856b;

        public C0068a(String str, Object obj) {
            this.f4855a = str;
            this.f4856b = obj;
        }

        public String a() {
            return this.f4855a;
        }

        public void a(Object obj) {
            this.f4856b = obj;
        }

        public Object b() {
            return this.f4856b;
        }
    }

    public void a() {
        this.f4854a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f4854a.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0068a c0068a = this.f4854a.get(i2);
            if (c0068a != null && c0068a.a() != null && c0068a.a().equals(str)) {
                c0068a.a(obj);
                return;
            }
        }
        this.f4854a.add(new C0068a(str, obj));
    }

    public ArrayList<C0068a> b() {
        return this.f4854a;
    }
}
