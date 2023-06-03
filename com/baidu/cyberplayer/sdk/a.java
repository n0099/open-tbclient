package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public ArrayList<C0090a> a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0090a {
        public String a;
        public Object b;

        public C0090a(String str, Object obj) {
            this.a = str;
            this.b = obj;
        }

        public String a() {
            return this.a;
        }

        public Object b() {
            return this.b;
        }

        public void a(Object obj) {
            this.b = obj;
        }
    }

    public void a() {
        this.a.clear();
    }

    public ArrayList<C0090a> b() {
        return this.a;
    }

    public void a(String str, Object obj) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            C0090a c0090a = this.a.get(i);
            if (c0090a != null && c0090a.a() != null && c0090a.a().equals(str)) {
                c0090a.a(obj);
                return;
            }
        }
        this.a.add(new C0090a(str, obj));
    }
}
