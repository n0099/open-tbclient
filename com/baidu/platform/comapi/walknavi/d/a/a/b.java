package com.baidu.platform.comapi.walknavi.d.a.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class b implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public String f9851b;

    /* renamed from: c  reason: collision with root package name */
    public String f9852c;

    /* renamed from: d  reason: collision with root package name */
    public String f9853d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f9854e;

    /* renamed from: f  reason: collision with root package name */
    public String f9855f;

    /* renamed from: g  reason: collision with root package name */
    public String f9856g;

    /* renamed from: h  reason: collision with root package name */
    public int f9857h;

    /* renamed from: i  reason: collision with root package name */
    public String f9858i;
    public String l;
    public String m;

    /* renamed from: a  reason: collision with root package name */
    public int f9850a = Integer.MIN_VALUE;
    public boolean j = false;
    public boolean k = true;

    public void a(int i2) {
        this.f9850a = i2;
    }

    public String b() {
        return this.f9851b;
    }

    public String c() {
        return this.f9852c;
    }

    public String d() {
        return this.f9853d;
    }

    public void e(String str) {
        this.f9856g = str;
    }

    public void f(String str) {
        this.f9858i = str;
    }

    public boolean g() {
        return this.k;
    }

    public String h() {
        return this.m;
    }

    public String toString() {
        return "ARResource [ err_code = " + this.f9850a + StringUtil.ARRAY_ELEMENT_SEPARATOR + PmsConstant.Statistic.STATISTIC_ERRMSG + " = " + this.f9851b + ", , version_code = " + this.f9856g + StringUtil.ARRAY_ELEMENT_SEPARATOR + "ar_resource = " + this.f9853d + " ]";
    }

    public int a() {
        return this.f9850a;
    }

    public void b(String str) {
        this.f9852c = str;
    }

    public void c(String str) {
        this.f9853d = str;
    }

    public void d(String str) {
        this.f9855f = str;
    }

    public int e() {
        return this.f9857h;
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
        this.f9851b = str;
    }

    public void b(int i2) {
        this.f9857h = i2;
    }

    public void a(String[] strArr) {
        this.f9854e = strArr;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void a(boolean z) {
        this.j = z;
    }
}
