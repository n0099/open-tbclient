package com.baidu.ar.algo.a.a;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.baidu.ar.algo.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0036a {
        public float[] a;
        public int b;
        public int c;

        public void a(float[] fArr, int i, int i2) {
            this.a = fArr;
            this.b = i;
            this.c = i2;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void a(int i, String str);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, String str);

        void a(C0036a c0036a);
    }

    void close();

    int init(String str, String str2);

    C0036a predictForFloatMatrix(float[] fArr, int i, int i2, int i3);
}
