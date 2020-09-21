package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    private ArrayList<C0104a> a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0104a {
        private String a;
        private Object b;

        public C0104a(String str, Object obj) {
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
            C0104a c0104a = this.a.get(i);
            if (c0104a != null && c0104a.a() != null && c0104a.a().equals(str)) {
                c0104a.a(obj);
                return;
            }
        }
        this.a.add(new C0104a(str, obj));
    }

    public ArrayList<C0104a> b() {
        return this.a;
    }
}
