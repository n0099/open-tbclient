package com.baidu.platform.comapi.walknavi.d.a.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class b implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public String f9496b;

    /* renamed from: c  reason: collision with root package name */
    public String f9497c;

    /* renamed from: d  reason: collision with root package name */
    public String f9498d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f9499e;

    /* renamed from: f  reason: collision with root package name */
    public String f9500f;

    /* renamed from: g  reason: collision with root package name */
    public String f9501g;

    /* renamed from: h  reason: collision with root package name */
    public int f9502h;
    public String i;
    public String l;
    public String m;

    /* renamed from: a  reason: collision with root package name */
    public int f9495a = Integer.MIN_VALUE;
    public boolean j = false;
    public boolean k = true;

    public void a(int i) {
        this.f9495a = i;
    }

    public String b() {
        return this.f9496b;
    }

    public String c() {
        return this.f9497c;
    }

    public String d() {
        return this.f9498d;
    }

    public void e(String str) {
        this.f9501g = str;
    }

    public void f(String str) {
        this.i = str;
    }

    public boolean g() {
        return this.k;
    }

    public String h() {
        return this.m;
    }

    public String toString() {
        return "ARResource [ err_code = " + this.f9495a + StringUtil.ARRAY_ELEMENT_SEPARATOR + PmsConstant.Statistic.STATISTIC_ERRMSG + " = " + this.f9496b + ", , version_code = " + this.f9501g + StringUtil.ARRAY_ELEMENT_SEPARATOR + "ar_resource = " + this.f9498d + " ]";
    }

    public int a() {
        return this.f9495a;
    }

    public void b(String str) {
        this.f9497c = str;
    }

    public void c(String str) {
        this.f9498d = str;
    }

    public void d(String str) {
        this.f9500f = str;
    }

    public int e() {
        return this.f9502h;
    }

    public boolean f() {
        return this.j;
    }

    public void g(String str) {
        this.l = str;
    }

    public void h(String str) {
        this.m = str;
    }

    public void a(String str) {
        this.f9496b = str;
    }

    public void b(int i) {
        this.f9502h = i;
    }

    public void a(String[] strArr) {
        this.f9499e = strArr;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void a(boolean z) {
        this.j = z;
    }
}
