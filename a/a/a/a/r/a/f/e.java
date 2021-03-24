package a.a.a.a.r.a.f;

import a.a.a.a.s.e;
import a.a.a.a.u.m;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes.dex */
public class e extends a.a.a.a.b<KsFeedAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1238a;

        public a(FunAdSlot funAdSlot) {
            this.f1238a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("KSNativeExpressAd onError code: " + i + ", message: " + str, new Object[0]);
            e.this.f1010g.a(Integer.valueOf(i));
            e.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.f1010g.b();
                KsFeedAd ksFeedAd = list.get(0);
                e eVar = e.this;
                eVar.a((e) ksFeedAd);
                eVar.h();
                e.this.k.b(ksFeedAd, this.f1238a.getSid());
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            e.this.f1010g.a("NoFill");
            onError(0, "NoFill");
        }
    }

    public e(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new m(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsFeedAd ksFeedAd) {
        KsFeedAd ksFeedAd2 = ksFeedAd;
        View feedView = ksFeedAd2.getFeedView(activity);
        this.f1010g.g();
        ksFeedAd2.setAdInteractionListener(new f(this, ksFeedAd2, str, feedView));
        ksFeedAd2.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        if (feedView != null && feedView.getParent() != null) {
            ((ViewGroup) feedView.getParent()).removeView(feedView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int i = (int) ((activity.getResources().getDisplayMetrics().density * 10.0f) + 0.5f);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        viewGroup.removeAllViews();
        viewGroup.addView(feedView, layoutParams);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1011h.f1334c)).adNum(1).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        KsAdSDK.getLoadManager().loadFeedAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(KsFeedAd ksFeedAd) {
    }
}
