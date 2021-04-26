package com.baidu.platform.comapi.walknavi.e;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f9958a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public void a(int i2, int i3, int i4) {
        this.f9958a.putInt("start_x", i2);
        this.f9958a.putInt("start_y", i3);
        this.f9958a.putInt("start_cityid", i4);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public void b(int i2) {
        this.f9958a.putInt("wnavi_mode", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public void c(int i2) {
        this.f9958a.putInt("route_data_mode", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public int[] b(String str) {
        return this.f9958a.getIntArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.f9958a.putIntArray("end_x", iArr);
        this.f9958a.putIntArray("end_y", iArr2);
        this.f9958a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public void a(int i2) {
        this.f9958a.putInt("vehicle", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public byte[] a(String str) {
        return this.f9958a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a
    public int a(String str, int i2) {
        return this.f9958a.getInt(str, i2);
    }
}
