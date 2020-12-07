package com.baidu.mobads.openad.d;

import android.net.Uri;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2389a;
    public String b;
    public long c = 0;
    public String d = "text/plain";
    public int e = 1;
    private Uri.Builder f;

    public c(String str, String str2) {
        this.f2389a = str;
        this.b = str2;
    }

    public String a() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getFixedString(this.f2389a);
    }

    public Uri.Builder b() {
        return this.f;
    }

    public void a(Uri.Builder builder) {
        this.f = builder;
    }

    public void a(int i) {
        this.e = i;
    }
}
