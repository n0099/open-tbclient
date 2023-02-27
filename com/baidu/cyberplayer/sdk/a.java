package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public ArrayList<C0087a> a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0087a {
        public String a;
        public Object b;

        public C0087a(String str, Object obj) {
            this.a = str;
            this.b = obj;
        }

        public String a() {
            return this.a;
        }

        public void a(Object obj) {
            this.b = obj;
        }

        public Object b() {
            return this.b;
        }
    }

    public void a() {
        this.a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            C0087a c0087a = this.a.get(i);
            if (c0087a != null && c0087a.a() != null && c0087a.a().equals(str)) {
                c0087a.a(obj);
                return;
            }
        }
        this.a.add(new C0087a(str, obj));
    }

    public ArrayList<C0087a> b() {
        return this.a;
    }
}
