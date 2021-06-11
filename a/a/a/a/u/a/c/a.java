package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
import android.app.Activity;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
/* loaded from: classes.dex */
public class a extends o {
    public a(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.a.c.o, a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.e(aVar);
    }

    @Override // a.a.a.a.u.a.c.o
    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.showFullScreenAD(activity);
    }

    @Override // a.a.a.a.u.a.c.o
    public void a(UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.loadFullScreenAD();
    }
}
