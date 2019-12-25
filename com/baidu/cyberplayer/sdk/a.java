package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<C0053a> a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0053a {
        private String a;
        private Object b;

        public C0053a(String str, Object obj) {
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
            C0053a c0053a = this.a.get(i);
            if (c0053a != null && c0053a.a() != null && c0053a.a().equals(str)) {
                c0053a.a(obj);
                return;
            }
        }
        this.a.add(new C0053a(str, obj));
    }

    public ArrayList<C0053a> b() {
        return this.a;
    }
}
