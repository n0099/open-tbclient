package a.a.a.a.r.a.f;

import a.a.a.a.s.e;
import a.a.a.a.u.n;
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
public class a extends a.a.a.a.b<KsDrawAd> {

    /* renamed from: a.a.a.a.r.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0004a implements KsLoadManager.DrawAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1224a;

        public C0004a(FunAdSlot funAdSlot) {
            this.f1224a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                a.this.f1010g.b();
                for (KsDrawAd ksDrawAd : list) {
                    if (ksDrawAd != null) {
                        a.this.k.b(ksDrawAd, this.f1224a.getSid());
                    }
                }
                a aVar = a.this;
                if (aVar == null) {
                    throw null;
                }
                for (KsDrawAd ksDrawAd2 : list) {
                    aVar.a((a) ksDrawAd2);
                }
                aVar.h();
                return;
            }
            a.a.a.a.v.d.b("onDrawAdLoad error: adList is null or empty", new Object[0]);
            onError(0, "NoFill");
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            a.this.f1010g.a(Integer.valueOf(i));
            a.this.b(i, str);
        }
    }

    public a(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new n(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsDrawAd ksDrawAd) {
        KsDrawAd ksDrawAd2 = ksDrawAd;
        this.f1010g.g();
        ksDrawAd2.setAdInteractionListener(new b(this, ksDrawAd2, str));
        View drawView = ksDrawAd2.getDrawView(viewGroup.getContext());
        if (drawView == null) {
            a.a.a.a.v.d.b("drawView is null", new Object[0]);
            return false;
        }
        if (drawView.getParent() != null) {
            ((ViewGroup) drawView.getParent()).removeView(drawView);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(drawView);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1011h.f1334c)).adNum(5).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        KsAdSDK.getLoadManager().loadDrawAd(build, new C0004a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(KsDrawAd ksDrawAd) {
    }
}
