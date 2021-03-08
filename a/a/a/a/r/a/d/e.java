package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
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
/* loaded from: classes4.dex */
public class e extends a.a.a.a.c<NativeExpressADView> {
    public final HashMap<NativeExpressADView, String> m;

    public e(e.a aVar) {
        super(aVar, false);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.g(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (!(context instanceof Activity)) {
            b(0, "NotActvity");
            return;
        }
        a aVar = new a(funAdSlot);
        this.zk.a(funAdSlot, this.zl);
        NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.zl.c, aVar);
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
        nativeExpressAD.setMinVideoDuration(0);
        nativeExpressAD.setMaxVideoDuration(0);
        nativeExpressAD.setVideoPlayPolicy(1);
        nativeExpressAD.loadAD(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = nativeExpressADView;
        if (nativeExpressADView2.getBoundData().getAdPatternType() == 2) {
            nativeExpressADView2.setMediaListener(new f(this));
        }
        this.zk.g();
        this.m.put(nativeExpressADView2, str);
        if (nativeExpressADView2.getParent() != null) {
            ((ViewGroup) nativeExpressADView2.getParent()).removeView(nativeExpressADView2);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(nativeExpressADView2);
        return true;
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

    /* loaded from: classes4.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {
        public final /* synthetic */ FunAdSlot AC;

        /* renamed from: a  reason: collision with root package name */
        public boolean f984a;
        public boolean b;

        public a(FunAdSlot funAdSlot) {
            this.AC = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.a();
            e.this.zk.a(this.b);
            this.b = true;
            e.this.e();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADCloseOverlay", new Object[0]);
            a.a.a.a.v.f.g.c.a(e.this.zk.BU, "overlay_close", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADClosed", new Object[0]);
            e.this.zk.d();
            e.this.f();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.a();
            e.this.zk.b(this.f984a);
            this.f984a = true;
            e eVar = e.this;
            eVar.a((e) nativeExpressADView, eVar.m.remove(nativeExpressADView));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADLeftApplication", new Object[0]);
            e.this.zk.a();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onADOpenOverlay", new Object[0]);
            a.a.a.a.v.f.g.c.a(e.this.zk.BU, "overlay_open", new Object[0]);
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            e.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            e.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.b();
            a.a.a.a.v.f.g.c.a(e.this.zk.BU, "render_failed", new Object[0]);
            e.this.b(0, "RenderFail");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            a.a.a.a.v.d.a();
            e.this.zk.e();
            e.this.m.put(nativeExpressADView, this.AC.getSid());
            e eVar = e.this;
            eVar.a((e) nativeExpressADView);
            eVar.h();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.zk.b();
                NativeExpressADView nativeExpressADView = list.get(0);
                e.this.zm.b(nativeExpressADView, this.AC.getSid());
                nativeExpressADView.render();
                return;
            }
            e.this.zk.a("NoFill");
            e.this.b(0, "NoFill");
        }
    }
}
