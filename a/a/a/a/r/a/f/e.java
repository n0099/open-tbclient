package a.a.a.a.r.a.f;

import a.a.a.a.a.e;
import a.a.a.a.c.m;
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
/* loaded from: classes4.dex */
public class e extends a.a.a.a.c<KsFeedAd> {
    public e(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new m(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.zl.c)).adNum(1).build();
        this.zk.a(funAdSlot, this.zl);
        KsAdSDK.getLoadManager().loadFeedAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsFeedAd ksFeedAd) {
        KsFeedAd ksFeedAd2 = ksFeedAd;
        View feedView = ksFeedAd2.getFeedView(activity);
        this.zk.g();
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsFeedAd ksFeedAd) {
    }

    /* loaded from: classes4.dex */
    public class a implements KsLoadManager.FeedAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("KSNativeExpressAd onError code: " + i + ", message: " + str, new Object[0]);
            e.this.zk.a(Integer.valueOf(i));
            e.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                e.this.zk.b();
                KsFeedAd ksFeedAd = list.get(0);
                e eVar = e.this;
                eVar.a((e) ksFeedAd);
                eVar.h();
                e.this.zm.b(ksFeedAd, this.zR.getSid());
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            e.this.zk.a("NoFill");
            onError(0, "NoFill");
        }
    }
}
