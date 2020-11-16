package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C0107a> f1358a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0107a {

        /* renamed from: a  reason: collision with root package name */
        private String f1359a;
        private Object b;

        public C0107a(String str, Object obj) {
            this.f1359a = str;
            this.b = obj;
        }

        public String a() {
            return this.f1359a;
        }

        public void a(Object obj) {
            this.b = obj;
        }

        public Object b() {
            return this.b;
        }
    }

    public void a() {
        this.f1358a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f1358a.size();
        for (int i = 0; i < size; i++) {
            C0107a c0107a = this.f1358a.get(i);
            if (c0107a != null && c0107a.a() != null && c0107a.a().equals(str)) {
                c0107a.a(obj);
                return;
            }
        }
        this.f1358a.add(new C0107a(str, obj));
    }

    public ArrayList<C0107a> b() {
        return this.f1358a;
    }
}
