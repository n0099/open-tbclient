package com.baidu.platform.comapi.walknavi.e;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f10043a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i, int i2, int i3) {
        this.f10043a.putInt("start_x", i);
        this.f10043a.putInt("start_y", i2);
        this.f10043a.putInt("start_cityid", i3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void b(int i) {
        this.f10043a.putInt("wnavi_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void c(int i) {
        this.f10043a.putInt("wnavi_extra_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void d(int i) {
        this.f10043a.putInt("route_data_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int[] b(String str) {
        return this.f10043a.getIntArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.f10043a.putIntArray("end_x", iArr);
        this.f10043a.putIntArray("end_y", iArr2);
        this.f10043a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i) {
        this.f10043a.putInt("launched_from", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public byte[] a(String str) {
        return this.f10043a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int a(String str, int i) {
        return this.f10043a.getInt(str, i);
    }
}
