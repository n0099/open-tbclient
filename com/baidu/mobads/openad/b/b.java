package com.baidu.mobads.openad.b;

import android.net.Uri;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f8410a;

    /* renamed from: b  reason: collision with root package name */
    public String f8411b;

    /* renamed from: c  reason: collision with root package name */
    public long f8412c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f8413d = "text/plain";

    /* renamed from: e  reason: collision with root package name */
    public int f8414e = 1;

    /* renamed from: f  reason: collision with root package name */
    public Uri.Builder f8415f;

    public b(String str, String str2) {
        this.f8410a = str;
        this.f8411b = str2;
    }

    public String a() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getFixedString(this.f8410a);
    }

    public Uri.Builder b() {
        return this.f8415f;
    }

    public void a(Uri.Builder builder) {
        this.f8415f = builder;
    }

    public void a(int i) {
        this.f8414e = i;
    }
}
