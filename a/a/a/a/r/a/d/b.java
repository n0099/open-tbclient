package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
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
/* loaded from: classes4.dex */
public class b extends a.a.a.a.c<NativeExpressADData2> {
    public final HashMap<NativeExpressADData2, String> m;

    public b(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.f(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context, this.zl.c, new a(funAdSlot));
        this.zk.a(funAdSlot, this.zl);
        nativeExpressAD2.setAdSize(expressWidth, expressHeight);
        VideoOption2.Builder builder = new VideoOption2.Builder();
        builder.setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
        nativeExpressAD2.setVideoOption2(builder.build());
        nativeExpressAD2.loadAd(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADData2 nativeExpressADData2) {
        NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
        this.zk.g();
        this.m.put(nativeExpressADData22, str);
        View adView = nativeExpressADData22.getAdView();
        if (adView.getParent() != null) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(adView);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(NativeExpressADData2 nativeExpressADData2) {
        NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
        this.m.remove(nativeExpressADData22);
        if (nativeExpressADData22 != null) {
            nativeExpressADData22.destroy();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements NativeExpressAD2.AdLoadListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            b.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            b.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                b.this.zk.b();
                NativeExpressADData2 nativeExpressADData2 = list.get(0);
                b bVar = b.this;
                String sid = this.zR.getSid();
                if (bVar != null) {
                    nativeExpressADData2.setAdEventListener(new c(bVar, nativeExpressADData2, sid));
                    nativeExpressADData2.setMediaListener(new d(bVar));
                    nativeExpressADData2.render();
                    b.this.zm.b(nativeExpressADData2, this.zR.getSid());
                    return;
                }
                throw null;
            }
            b.this.zk.a("NoFill");
            b.this.b(0, "NoFill");
        }
    }
}
