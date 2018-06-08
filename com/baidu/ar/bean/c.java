package com.baidu.ar.bean;

import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    private Map<String, a> a;

    /* loaded from: classes3.dex */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }
    }

    public a a(String str) {
        return this.a.get(str);
    }

    public void a(Map<String, a> map) {
        this.a = map;
    }
}
