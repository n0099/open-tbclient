package a.a.a.a.v.f;

import com.fun.openid.sdk.OnGetOaidListener;
/* loaded from: classes.dex */
public final class a implements OnGetOaidListener {
    @Override // com.fun.openid.sdk.OnGetOaidListener
    public void onGetOaid(String str) {
        c.m = str;
        a.a.a.a.v.d.a("Got oaid:%s", str);
    }
}
