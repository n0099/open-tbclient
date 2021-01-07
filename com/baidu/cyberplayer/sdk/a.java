package com.baidu.cyberplayer.sdk;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<C0100a> f1773a = new ArrayList<>();

    /* renamed from: com.baidu.cyberplayer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0100a {

        /* renamed from: a  reason: collision with root package name */
        private String f1774a;

        /* renamed from: b  reason: collision with root package name */
        private Object f1775b;

        public C0100a(String str, Object obj) {
            this.f1774a = str;
            this.f1775b = obj;
        }

        public String a() {
            return this.f1774a;
        }

        public void a(Object obj) {
            this.f1775b = obj;
        }

        public Object b() {
            return this.f1775b;
        }
    }

    public void a() {
        this.f1773a.clear();
    }

    public void a(String str, Object obj) {
        int size = this.f1773a.size();
        for (int i = 0; i < size; i++) {
            C0100a c0100a = this.f1773a.get(i);
            if (c0100a != null && c0100a.a() != null && c0100a.a().equals(str)) {
                c0100a.a(obj);
                return;
            }
        }
        this.f1773a.add(new C0100a(str, obj));
    }

    public ArrayList<C0100a> b() {
        return this.f1773a;
    }
}
