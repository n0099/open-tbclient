package a.a.a.a.r.a.e;

import a.a.a.a.s.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBVideo;
import com.win.opensdk.PBVideoListener;
/* loaded from: classes.dex */
public class c extends a.a.a.a.b<PBVideo> {

    /* loaded from: classes.dex */
    public class a implements PBVideoListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1220a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1221b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBVideo f1222c;

        public a(PBVideo pBVideo) {
            this.f1222c = pBVideo;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            d.a();
            c.this.f1010g.a(this.f1221b);
            this.f1221b = true;
            c.this.e();
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            d.b("onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg(), new Object[0]);
            c.this.f1010g.b(Integer.valueOf(pBError.getCode()));
            c.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            d.a();
            c.this.f1010g.b();
            c cVar = c.this;
            cVar.a((c) this.f1222c);
            cVar.h();
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdClosed() {
            d.a();
            c.this.f1010g.d();
            c.this.f();
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdOpened() {
            d.a();
            c.this.f1010g.b(this.f1220a);
            this.f1220a = true;
            c.this.a((c) null, (String) null);
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedShowFail(String str) {
            d.b("onRewardedShowFail: errorCode: 0, , errorMessage: " + str, new Object[0]);
            c.this.f1010g.b(str);
            c.this.a(0, str);
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onUserEarnedReward(boolean z, long j) {
            d.a();
            c.this.f1010g.f();
            c.this.i();
        }
    }

    public c(e.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBVideo pBVideo) {
        PBVideo pBVideo2 = pBVideo;
        this.f1010g.g();
        if (pBVideo2.isReady()) {
            pBVideo2.show();
            return true;
        }
        d.b("Ad isn't ready now", new Object[0]);
        return false;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        PBVideo pBVideo = new PBVideo(context.getApplicationContext(), this.f1011h.f1334c);
        pBVideo.setVideoListener(new a(pBVideo));
        this.f1010g.a(funAdSlot, this.f1011h);
        pBVideo.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(PBVideo pBVideo) {
        PBVideo pBVideo2 = pBVideo;
        if (pBVideo2 != null) {
            pBVideo2.destroy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean c(PBVideo pBVideo) {
        PBVideo pBVideo2 = pBVideo;
        return pBVideo2 != null && pBVideo2.isReady();
    }
}
