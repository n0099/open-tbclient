package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes26.dex */
public final class j implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f2924a;
    private String b;
    private String[] c;
    private int[] d;
    private int e;
    private int f;
    private String g;

    public j(String str, String str2, String[] strArr, int[] iArr, int i, int i2, String str3) {
        this.f2924a = str;
        this.b = str2;
        this.e = i;
        this.f = i2;
        if (strArr != null) {
            this.c = (String[]) Array.newInstance(String.class, strArr.length);
            System.arraycopy(strArr, 0, this.c, 0, strArr.length);
        }
        if (iArr != null) {
            this.d = new int[iArr.length];
            System.arraycopy(iArr, 0, this.d, 0, iArr.length);
        }
        this.g = str3;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof j) && TextUtils.equals(this.f2924a, ((j) obj).f2924a) && TextUtils.equals(this.b, ((j) obj).b) && Arrays.equals(this.c, ((j) obj).c)) {
            return Arrays.equals(this.d, ((j) obj).d);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndoorMapInfo:building_id:").append(this.f2924a);
        sb.append(";floor_id:").append(this.b);
        sb.append(";indoor_type:").append(this.e);
        sb.append(";floor_list:").append(Arrays.toString(this.c));
        sb.append(";floor_attribute:").append(Arrays.toString(this.d));
        return sb.toString();
    }
}
