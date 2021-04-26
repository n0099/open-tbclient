package com.baidu.platform.comapi.walknavi.e;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f9959a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i2, int i3, int i4) {
        this.f9959a.putInt("start_x", i2);
        this.f9959a.putInt("start_y", i3);
        this.f9959a.putInt("start_cityid", i4);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void b(int i2) {
        this.f9959a.putInt("wnavi_mode", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void c(int i2) {
        this.f9959a.putInt("wnavi_extra_mode", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void d(int i2) {
        this.f9959a.putInt("route_data_mode", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int[] b(String str) {
        return this.f9959a.getIntArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.f9959a.putIntArray("end_x", iArr);
        this.f9959a.putIntArray("end_y", iArr2);
        this.f9959a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i2) {
        this.f9959a.putInt("launched_from", i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public byte[] a(String str) {
        return this.f9959a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int a(String str, int i2) {
        return this.f9959a.getInt(str, i2);
    }
}
