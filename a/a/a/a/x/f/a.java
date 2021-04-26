package a.a.a.a.x.f;

import com.fun.openid.sdk.OnGetOaidListener;
/* loaded from: classes.dex */
public final class a implements OnGetOaidListener {
    @Override // com.fun.openid.sdk.OnGetOaidListener
    public void onGetOaid(String str) {
        c.m = str;
        a.a.a.a.x.d.a("Got oaid:%s", str);
    }
}
