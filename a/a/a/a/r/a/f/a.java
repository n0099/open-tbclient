package a.a.a.a.r.a.f;

import a.a.a.a.a.e;
import a.a.a.a.c.n;
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
/* loaded from: classes4.dex */
public class a extends a.a.a.a.c<KsDrawAd> {
    public a(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new n(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.zl.c)).adNum(5).build();
        this.zk.a(funAdSlot, this.zl);
        KsAdSDK.getLoadManager().loadDrawAd(build, new C0004a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsDrawAd ksDrawAd) {
        KsDrawAd ksDrawAd2 = ksDrawAd;
        this.zk.g();
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsDrawAd ksDrawAd) {
    }

    /* renamed from: a.a.a.a.r.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0004a implements KsLoadManager.DrawAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public C0004a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            a.this.zk.a(Integer.valueOf(i));
            a.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                a.this.zk.b();
                for (KsDrawAd ksDrawAd : list) {
                    if (ksDrawAd != null) {
                        a.this.zm.b(ksDrawAd, this.zR.getSid());
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
    }
}
