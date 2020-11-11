package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C0108a> f1355a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0108a {

        /* renamed from: a  reason: collision with root package name */
        private String f1356a;
        private Object b;

        public C0108a(String str, Object obj) {
            this.f1356a = str;
            this.b = obj;
        }

        public String a() {
            return this.f1356a;
        }

        public void a(Object obj) {
            this.b = obj;
        }

        public Object b() {
            return this.b;
        }
    }

    public void a() {
        this.f1355a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f1355a.size();
        for (int i = 0; i < size; i++) {
            C0108a c0108a = this.f1355a.get(i);
            if (c0108a != null && c0108a.a() != null && c0108a.a().equals(str)) {
                c0108a.a(obj);
                return;
            }
        }
        this.f1355a.add(new C0108a(str, obj));
    }

    public ArrayList<C0108a> b() {
        return this.f1355a;
    }
}
