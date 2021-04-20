package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
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
public class e extends a.a.a.a.b<NativeExpressADView> {
    public final HashMap<NativeExpressADView, String> m;

    /* loaded from: classes.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1162a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1164c;

        public a(FunAdSlot funAdSlot) {
            this.f1164c = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.a();
            e.this.f1010g.a(this.f1163b);
            this.f1163b = true;
            e.this.e();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADCloseOverlay", new Object[0]);
            a.a.a.a.v.f.g.c.a(e.this.f1010g.f1377a, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADClosed", new Object[0]);
            e.this.f1010g.d();
            e.this.f();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.a();
            e.this.f1010g.b(this.f1162a);
            this.f1162a = true;
            e eVar = e.this;
            eVar.a((e) nativeExpressADView, eVar.m.remove(nativeExpressADView));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADLeftApplication", new Object[0]);
            e.this.f1010g.a();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.f1010g.b();
                NativeExpressADView nativeExpressADView = list.get(0);
                e.this.k.b(nativeExpressADView, this.f1164c.getSid());
                nativeExpressADView.render();
                return;
            }
            e.this.f1010g.a("NoFill");
            e.this.b(0, "NoFill");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADOpenOverlay", new Object[0]);
            a.a.a.a.v.f.g.c.a(e.this.f1010g.f1377a, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            e.this.f1010g.a(Integer.valueOf(adError.getErrorCode()));
            e.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b();
            a.a.a.a.v.f.g.c.a(e.this.f1010g.f1377a, "render_failed", new Object[0]);
            e.this.b(0, "RenderFail");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.a();
            e.this.f1010g.e();
            e.this.m.put(nativeExpressADView, this.f1164c.getSid());
            e eVar = e.this;
            eVar.a((e) nativeExpressADView);
            eVar.h();
        }
    }

    public e(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.f(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = nativeExpressADView;
        if (nativeExpressADView2.getBoundData().getAdPatternType() == 2) {
            nativeExpressADView2.setMediaListener(new f(this));
        }
        this.f1010g.g();
        this.m.put(nativeExpressADView2, str);
        if (nativeExpressADView2.getParent() != null) {
            ((ViewGroup) nativeExpressADView2.getParent()).removeView(nativeExpressADView2);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(nativeExpressADView2);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "NotActvity");
            return;
        }
        a aVar = new a(funAdSlot);
        this.f1010g.a(funAdSlot, this.f1011h);
        NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.f1011h.f1320c, aVar);
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
        nativeExpressAD.setMinVideoDuration(0);
        nativeExpressAD.setMaxVideoDuration(0);
        nativeExpressAD.setVideoPlayPolicy(1);
        nativeExpressAD.loadAD(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = nativeExpressADView;
        this.m.remove(nativeExpressADView2);
        if (nativeExpressADView2 != null) {
            nativeExpressADView2.destroy();
        }
    }
}
