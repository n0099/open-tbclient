package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C0099a> f1721a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0099a {

        /* renamed from: a  reason: collision with root package name */
        private String f1722a;

        /* renamed from: b  reason: collision with root package name */
        private Object f1723b;

        public C0099a(String str, Object obj) {
            this.f1722a = str;
            this.f1723b = obj;
        }

        public String a() {
            return this.f1722a;
        }

        public void a(Object obj) {
            this.f1723b = obj;
        }

        public Object b() {
            return this.f1723b;
        }
    }

    public void a() {
        this.f1721a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f1721a.size();
        for (int i = 0; i < size; i++) {
            C0099a c0099a = this.f1721a.get(i);
            if (c0099a != null && c0099a.a() != null && c0099a.a().equals(str)) {
                c0099a.a(obj);
                return;
            }
        }
        this.f1721a.add(new C0099a(str, obj));
    }

    public ArrayList<C0099a> b() {
        return this.f1721a;
    }
}
