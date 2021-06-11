package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.nativ.express2.NativeExpressAD2;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a.a.a.a.c<NativeExpressADData2> {
    public final HashMap<NativeExpressADData2, String> n;

    /* loaded from: classes.dex */
    public class a implements NativeExpressAD2.AdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1174a;

        public a(FunAdSlot funAdSlot) {
            this.f1174a = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                b.this.f1014h.b();
                NativeExpressADData2 nativeExpressADData2 = list.get(0);
                b bVar = b.this;
                String sid = this.f1174a.getSid();
                if (bVar != null) {
                    nativeExpressADData2.setAdEventListener(new c(bVar, nativeExpressADData2, sid));
                    nativeExpressADData2.setMediaListener(new d(bVar));
                    nativeExpressADData2.render();
                    b.this.l.b(nativeExpressADData2, this.f1174a.getSid());
                    return;
                }
                throw null;
            }
            b.this.f1014h.a("NoFill");
            b.this.b(0, "NoFill");
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.y.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            b.this.f1014h.a(Integer.valueOf(adError.getErrorCode()));
            b.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public b(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.f(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADData2 nativeExpressADData2) {
        NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
        this.f1014h.g();
        this.n.put(nativeExpressADData22, str);
        View adView = nativeExpressADData22.getAdView();
        if (adView.getParent() != null) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(adView);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context.getApplicationContext(), this.f1015i.f1342c, new a(funAdSlot));
        this.f1014h.a(funAdSlot, this.f1015i);
        nativeExpressAD2.setAdSize(expressWidth, expressHeight);
        VideoOption2.Builder builder = new VideoOption2.Builder();
        builder.setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
        nativeExpressAD2.setVideoOption2(builder.build());
        nativeExpressAD2.loadAd(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(NativeExpressADData2 nativeExpressADData2) {
        NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
        this.n.remove(nativeExpressADData22);
        if (nativeExpressADData22 != null) {
            nativeExpressADData22.destroy();
        }
    }
}
