package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e extends a.a.a.a.c<NativeExpressADView> {
    public final HashMap<NativeExpressADView, String> n;

    /* loaded from: classes.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1182a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1183b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1184c;

        public a(FunAdSlot funAdSlot) {
            this.f1184c = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.a();
            e.this.f1014h.a(this.f1183b);
            this.f1183b = true;
            e.this.e();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.b("GDTNativeExpressAd onADCloseOverlay", new Object[0]);
            a.a.a.a.y.f.g.c.a(e.this.f1014h.f1406a, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.b("GDTNativeExpressAd onADClosed", new Object[0]);
            e.this.f1014h.d();
            e.this.f();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.a();
            e.this.f1014h.b(this.f1182a);
            this.f1182a = true;
            e eVar = e.this;
            eVar.a((e) nativeExpressADView, eVar.n.remove(nativeExpressADView));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.b("GDTNativeExpressAd onADLeftApplication", new Object[0]);
            e.this.f1014h.a();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.f1014h.b();
                NativeExpressADView nativeExpressADView = list.get(0);
                e.this.l.b(nativeExpressADView, this.f1184c.getSid());
                nativeExpressADView.render();
                return;
            }
            e.this.f1014h.a("NoFill");
            e.this.b(0, "NoFill");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.b("GDTNativeExpressAd onADOpenOverlay", new Object[0]);
            a.a.a.a.y.f.g.c.a(e.this.f1014h.f1406a, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.y.d.b("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            e.this.f1014h.a(Integer.valueOf(adError.getErrorCode()));
            e.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.b();
            a.a.a.a.y.f.g.c.a(e.this.f1014h.f1406a, "render_failed", new Object[0]);
            e.this.b(0, "RenderFail");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            a.a.a.a.y.d.a();
            e.this.f1014h.e();
            e.this.n.put(nativeExpressADView, this.f1184c.getSid());
            e eVar = e.this;
            eVar.a((e) nativeExpressADView);
            eVar.h();
        }
    }

    public e(e.a aVar) {
        super(aVar, false);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.g(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = nativeExpressADView;
        if (nativeExpressADView2.getBoundData().getAdPatternType() == 2) {
            nativeExpressADView2.setMediaListener(new f(this));
        }
        this.f1014h.g();
        this.n.put(nativeExpressADView2, str);
        if (nativeExpressADView2.getParent() != null) {
            ((ViewGroup) nativeExpressADView2.getParent()).removeView(nativeExpressADView2);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(nativeExpressADView2);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        this.f1014h.a(funAdSlot, this.f1015i);
        if (!(context instanceof Activity)) {
            this.f1014h.a("NoA");
            b(0, "NotActvity");
            return;
        }
        NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.f1015i.f1342c, new a(funAdSlot));
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
        nativeExpressAD.setMinVideoDuration(0);
        nativeExpressAD.setMaxVideoDuration(0);
        nativeExpressAD.setVideoPlayPolicy(1);
        nativeExpressAD.loadAD(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = nativeExpressADView;
        this.n.remove(nativeExpressADView2);
        if (nativeExpressADView2 != null) {
            nativeExpressADView2.destroy();
        }
    }
}
