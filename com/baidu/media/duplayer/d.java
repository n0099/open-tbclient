package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f8044a;

    /* renamed from: b  reason: collision with root package name */
    public String f8045b;

    /* renamed from: c  reason: collision with root package name */
    public String f8046c;

    /* renamed from: d  reason: collision with root package name */
    public String f8047d;

    /* renamed from: e  reason: collision with root package name */
    public String f8048e;

    /* renamed from: f  reason: collision with root package name */
    public String f8049f;

    /* renamed from: g  reason: collision with root package name */
    public a f8050g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8051h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8052i;
    public boolean j;

    /* loaded from: classes2.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i2, String str, String str2) {
        this.f8051h = false;
        this.f8052i = true;
        this.j = false;
        this.f8044a = i2;
        this.f8045b = str;
        this.f8046c = str2;
        this.f8050g = a.LIB_TYPE_SO;
    }

    public d(int i2, String str, String str2, a aVar) {
        this(i2, str, str2);
        this.f8050g = aVar;
    }

    public String a() {
        return this.f8045b;
    }

    public void b(String str) {
        this.f8046c = str;
    }

    public void c(boolean z) {
        this.f8051h = z;
    }

    public String d() {
        return this.f8046c;
    }

    public void e(String str) {
        this.f8048e = str;
    }

    public void f(boolean z) {
        this.f8052i = z;
    }

    public int g() {
        return this.f8044a;
    }

    public void h(String str) {
        this.f8047d = str;
    }

    public void i(boolean z) {
        this.j = z;
    }

    public String j() {
        return this.f8048e;
    }

    public void k(String str) {
        this.f8049f = str;
    }

    public a l() {
        return this.f8050g;
    }

    public boolean m() {
        return this.f8051h;
    }

    public String n() {
        return this.f8047d;
    }

    public String o() {
        return this.f8049f;
    }

    public boolean p() {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_build_in_check", true)) {
            return this.j;
        }
        return false;
    }

    public boolean q() {
        return this.f8052i;
    }
}
