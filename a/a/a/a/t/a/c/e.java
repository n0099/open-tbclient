package a.a.a.a.t.a.c;

import a.a.a.a.u.e;
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
    public final HashMap<NativeExpressADView, String> m;

    /* loaded from: classes.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1179a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1180b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1181c;

        public a(FunAdSlot funAdSlot) {
            this.f1181c = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.a();
            e.this.f1013g.a(this.f1180b);
            this.f1180b = true;
            e.this.e();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.b("GDTNativeExpressAd onADCloseOverlay", new Object[0]);
            a.a.a.a.x.f.g.c.a(e.this.f1013g.f1393a, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.b("GDTNativeExpressAd onADClosed", new Object[0]);
            e.this.f1013g.d();
            e.this.f();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.a();
            e.this.f1013g.b(this.f1179a);
            this.f1179a = true;
            e eVar = e.this;
            eVar.a((e) nativeExpressADView, eVar.m.remove(nativeExpressADView));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.b("GDTNativeExpressAd onADLeftApplication", new Object[0]);
            e.this.f1013g.a();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.f1013g.b();
                NativeExpressADView nativeExpressADView = list.get(0);
                e.this.k.b(nativeExpressADView, this.f1181c.getSid());
                nativeExpressADView.render();
                return;
            }
            e.this.f1013g.a("NoFill");
            e.this.b(0, "NoFill");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.b("GDTNativeExpressAd onADOpenOverlay", new Object[0]);
            a.a.a.a.x.f.g.c.a(e.this.f1013g.f1393a, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.x.d.b("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            e.this.f1013g.a(Integer.valueOf(adError.getErrorCode()));
            e.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.b();
            a.a.a.a.x.f.g.c.a(e.this.f1013g.f1393a, "render_failed", new Object[0]);
            e.this.b(0, "RenderFail");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            a.a.a.a.x.d.a();
            e.this.f1013g.e();
            e.this.m.put(nativeExpressADView, this.f1181c.getSid());
            e eVar = e.this;
            eVar.a((e) nativeExpressADView);
            eVar.h();
        }
    }

    public e(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.g(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = nativeExpressADView;
        if (nativeExpressADView2.getBoundData().getAdPatternType() == 2) {
            nativeExpressADView2.setMediaListener(new f(this));
        }
        this.f1013g.g();
        this.m.put(nativeExpressADView2, str);
        if (nativeExpressADView2.getParent() != null) {
            ((ViewGroup) nativeExpressADView2.getParent()).removeView(nativeExpressADView2);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(nativeExpressADView2);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        this.f1013g.a(funAdSlot, this.f1014h);
        if (!(context instanceof Activity)) {
            this.f1013g.a("NoA");
            b(0, "NotActvity");
            return;
        }
        NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.f1014h.f1334c, new a(funAdSlot));
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
        this.m.remove(nativeExpressADView2);
        if (nativeExpressADView2 != null) {
            nativeExpressADView2.destroy();
        }
    }
}
