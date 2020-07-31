package com.baidu.platform.comapi.walknavi.e;

import android.os.Bundle;
/* loaded from: classes10.dex */
public class d implements c {
    private Bundle a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i, int i2, int i3) {
        this.a.putInt("start_x", i);
        this.a.putInt("start_y", i2);
        this.a.putInt("start_cityid", i3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.a.putIntArray("end_x", iArr);
        this.a.putIntArray("end_y", iArr2);
        this.a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i) {
        this.a.putInt("launched_from", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void b(int i) {
        this.a.putInt("wnavi_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void c(int i) {
        this.a.putInt("wnavi_extra_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void d(int i) {
        this.a.putInt("route_data_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public byte[] a(String str) {
        return this.a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int a(String str, int i) {
        return this.a.getInt(str, i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int[] b(String str) {
        return this.a.getIntArray(str);
    }
}
