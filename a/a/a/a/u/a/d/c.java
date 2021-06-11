package a.a.a.a.u.a.d;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.PBVideo;
import com.win.opensdk.PBVideoListener;
/* loaded from: classes.dex */
public class c extends a.a.a.a.c<PBVideo> {

    /* loaded from: classes.dex */
    public class a implements PBVideoListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1234a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1235b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBVideo f1236c;

        public a(PBVideo pBVideo) {
            this.f1236c = pBVideo;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            a.a.a.a.y.d.a();
            c.this.f1014h.a(this.f1235b);
            this.f1235b = true;
            c.this.e();
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            a.a.a.a.y.d.b("onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg(), new Object[0]);
            c.this.f1014h.b(Integer.valueOf(pBError.getCode()));
            c.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            a.a.a.a.y.d.a();
            c.this.f1014h.b();
            c cVar = c.this;
            cVar.a((c) this.f1236c);
            cVar.h();
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdClosed() {
            a.a.a.a.y.d.a();
            c.this.f1014h.d();
            c.this.f();
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedAdOpened() {
            a.a.a.a.y.d.a();
            c.this.f1014h.b(this.f1234a);
            this.f1234a = true;
            c.this.a((c) null, (String) null);
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onRewardedShowFail(String str) {
            a.a.a.a.y.d.b("onRewardedShowFail: errorCode: 0, , errorMessage: " + str, new Object[0]);
            c.this.f1014h.b(str);
            c.this.a(0, str);
        }

        @Override // com.win.opensdk.PBVideoListener
        public void onUserEarnedReward(boolean z, long j) {
            a.a.a.a.y.d.a();
            c.this.f1014h.f();
            c.this.i();
        }
    }

    public c(e.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBVideo pBVideo) {
        PBVideo pBVideo2 = pBVideo;
        this.f1014h.g();
        if (pBVideo2.isReady()) {
            pBVideo2.show();
            return true;
        }
        a.a.a.a.y.d.b("Ad isn't ready now", new Object[0]);
        return false;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        PBVideo pBVideo = new PBVideo(context.getApplicationContext(), this.f1015i.f1342c);
        pBVideo.setVideoListener(new a(pBVideo));
        this.f1014h.a(funAdSlot, this.f1015i);
        pBVideo.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBVideo pBVideo) {
        PBVideo pBVideo2 = pBVideo;
        if (pBVideo2 != null) {
            pBVideo2.destroy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(PBVideo pBVideo) {
        PBVideo pBVideo2 = pBVideo;
        return pBVideo2 != null && pBVideo2.isReady();
    }
}
