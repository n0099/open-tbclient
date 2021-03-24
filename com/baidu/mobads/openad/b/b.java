package com.baidu.mobads.openad.b;

import android.net.Uri;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f8409a;

    /* renamed from: b  reason: collision with root package name */
    public String f8410b;

    /* renamed from: c  reason: collision with root package name */
    public long f8411c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f8412d = "text/plain";

    /* renamed from: e  reason: collision with root package name */
    public int f8413e = 1;

    /* renamed from: f  reason: collision with root package name */
    public Uri.Builder f8414f;

    public b(String str, String str2) {
        this.f8409a = str;
        this.f8410b = str2;
    }

    public String a() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getFixedString(this.f8409a);
    }

    public Uri.Builder b() {
        return this.f8414f;
    }

    public void a(Uri.Builder builder) {
        this.f8414f = builder;
    }

    public void a(int i) {
        this.f8413e = i;
    }
}
