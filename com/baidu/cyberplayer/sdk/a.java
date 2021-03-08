package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C0105a> f1394a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0105a {

        /* renamed from: a  reason: collision with root package name */
        private String f1395a;
        private Object b;

        public C0105a(String str, Object obj) {
            this.f1395a = str;
            this.b = obj;
        }

        public String a() {
            return this.f1395a;
        }

        public void a(Object obj) {
            this.b = obj;
        }

        public Object b() {
            return this.b;
        }
    }

    public void a() {
        this.f1394a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f1394a.size();
        for (int i = 0; i < size; i++) {
            C0105a c0105a = this.f1394a.get(i);
            if (c0105a != null && c0105a.a() != null && c0105a.a().equals(str)) {
                c0105a.a(obj);
                return;
            }
        }
        this.f1394a.add(new C0105a(str, obj));
    }

    public ArrayList<C0105a> b() {
        return this.f1394a;
    }
}
