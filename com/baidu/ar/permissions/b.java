package com.baidu.ar.permissions;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {
    public final String[] a;
    public final boolean[] b;
    public final String[] c;
    public final c d;

    public b(String[] strArr, boolean[] zArr, String[] strArr2, c cVar) {
        this.a = strArr;
        this.c = strArr2;
        this.b = zArr;
        this.d = cVar;
    }

    private int a(String str) {
        for (int i = 0; i < this.a.length; i++) {
            if (TextUtils.equals(this.a[i], str)) {
                return i;
            }
        }
        return -1;
    }

    public void a(String[] strArr, int[] iArr) {
        for (int i = 0; i < strArr.length; i++) {
            boolean z = iArr[i] == 0;
            int a = a(strArr[i]);
            if (a >= 0) {
                this.b[a] = z;
            }
        }
        if (this.d != null) {
            this.d.a(this.a, this.b);
        }
    }
}
