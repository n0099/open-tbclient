package com.baidu.mobads.openad.b;

import android.net.Uri;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f2438a;
    public String b;
    public long c = 0;
    public String d = "text/plain";
    public int e = 1;
    private Uri.Builder f;

    public b(String str, String str2) {
        this.f2438a = str;
        this.b = str2;
    }

    public String a() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getFixedString(this.f2438a);
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
