package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
import android.app.Activity;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
/* loaded from: classes4.dex */
public class a extends o {
    public a(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.r.a.d.o
    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.showFullScreenAD(activity);
    }

    @Override // a.a.a.a.r.a.d.o
    public void h(UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.loadFullScreenAD();
    }
}
