package a.a.a.a.t.a.e;

import a.a.a.a.u.e;
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
public class e extends a.a.a.a.c<KsFeedAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1249a;

        public a(FunAdSlot funAdSlot) {
            this.f1249a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("KSNativeExpressAd onError code: " + i2 + ", message: " + str, new Object[0]);
            e.this.f1013g.a(Integer.valueOf(i2));
            e.this.b(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.f1013g.b();
                KsFeedAd ksFeedAd = list.get(0);
                e eVar = e.this;
                eVar.a((e) ksFeedAd);
                eVar.h();
                e.this.k.b(ksFeedAd, this.f1249a.getSid());
                return;
            }
            a.a.a.a.x.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            e.this.f1013g.a("NoFill");
            onError(0, "NoFill");
        }
    }

    public e(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.m(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsFeedAd ksFeedAd) {
        KsFeedAd ksFeedAd2 = ksFeedAd;
        View feedView = ksFeedAd2.getFeedView(activity);
        this.f1013g.g();
        ksFeedAd2.setAdInteractionListener(new f(this, ksFeedAd2, str, feedView));
        ksFeedAd2.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        if (feedView != null && feedView.getParent() != null) {
            ((ViewGroup) feedView.getParent()).removeView(feedView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int i2 = (int) ((activity.getResources().getDisplayMetrics().density * 10.0f) + 0.5f);
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        viewGroup.removeAllViews();
        viewGroup.addView(feedView, layoutParams);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1014h.f1334c)).adNum(1).build();
        this.f1013g.a(funAdSlot, this.f1014h);
        KsAdSDK.getLoadManager().loadFeedAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsFeedAd ksFeedAd) {
    }
}
