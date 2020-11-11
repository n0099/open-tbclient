package com.baidu.platform.comapi.walknavi.e;

import android.os.Bundle;
/* loaded from: classes7.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f3006a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i, int i2, int i3) {
        this.f3006a.putInt("start_x", i);
        this.f3006a.putInt("start_y", i2);
        this.f3006a.putInt("start_cityid", i3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i, int i2, int i3, String str, String str2) {
        this.f3006a.putInt("start_x", i);
        this.f3006a.putInt("start_y", i2);
        this.f3006a.putInt("start_cityid", i3);
        this.f3006a.putString("start_floor", str);
        this.f3006a.putString("start_building", str2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.f3006a.putIntArray("end_x", iArr);
        this.f3006a.putIntArray("end_y", iArr2);
        this.f3006a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3, String[] strArr, String[] strArr2) {
        this.f3006a.putIntArray("end_x", iArr);
        this.f3006a.putIntArray("end_y", iArr2);
        this.f3006a.putIntArray("end_cityid", iArr3);
        this.f3006a.putStringArray("end_floor", strArr);
        this.f3006a.putStringArray("end_building", strArr2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i) {
        this.f3006a.putInt("launched_from", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void b(int i) {
        this.f3006a.putInt("wnavi_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void c(int i) {
        this.f3006a.putInt("wnavi_extra_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void d(int i) {
        this.f3006a.putInt("route_data_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(byte[] bArr) {
        this.f3006a.putByteArray("route_buff", bArr);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public byte[] a(String str) {
        return this.f3006a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int a(String str, int i) {
        return this.f3006a.getInt(str, i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public String a(String str, String str2) {
        return this.f3006a.getString(str, str2);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public String[] c(String str) {
        return this.f3006a.getStringArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public int[] b(String str) {
        return this.f3006a.getIntArray(str);
    }
}
