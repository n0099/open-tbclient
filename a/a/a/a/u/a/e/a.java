package a.a.a.a.u.a.e;

import a.a.a.a.v.e;
import a.a.a.a.x.n;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes.dex */
public class a extends a.a.a.a.c<KsDrawAd> {

    /* renamed from: a.a.a.a.u.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0003a implements KsLoadManager.DrawAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1243a;

        public C0003a(FunAdSlot funAdSlot) {
            this.f1243a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                a.this.f1014h.b();
                for (KsDrawAd ksDrawAd : list) {
                    a.this.l.b(ksDrawAd, this.f1243a.getSid());
                }
                a.this.a((List) list);
                return;
            }
            a.a.a.a.y.d.b("onDrawAdLoad error: adList is null or empty", new Object[0]);
            onError(0, "NoFill");
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            a.this.f1014h.a(Integer.valueOf(i2));
            a.this.b(i2, str);
        }
    }

    public a(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new n(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsDrawAd ksDrawAd) {
        KsDrawAd ksDrawAd2 = ksDrawAd;
        this.f1014h.g();
        ksDrawAd2.setAdInteractionListener(new b(this, ksDrawAd2, str));
        View drawView = ksDrawAd2.getDrawView(viewGroup.getContext());
        if (drawView == null) {
            a.a.a.a.y.d.b("drawView is null", new Object[0]);
            return false;
        }
        if (drawView.getParent() != null) {
            ((ViewGroup) drawView.getParent()).removeView(drawView);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(drawView);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1015i.f1342c)).adNum(a.a.a.a.a.a(funAdSlot.getAdCount(), 1, 5)).build();
        this.f1014h.a(funAdSlot, this.f1015i);
        KsAdSDK.getLoadManager().loadDrawAd(build, new C0003a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsDrawAd ksDrawAd) {
    }
}
