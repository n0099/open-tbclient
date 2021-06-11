package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l extends a.a.a.a.c<RewardVideoAD> {
    public final HashMap<RewardVideoAD, String> n;

    /* loaded from: classes.dex */
    public class a implements RewardVideoADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1203a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1204b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RewardVideoAD[] f1205c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1206d;

        public a(RewardVideoAD[] rewardVideoADArr, FunAdSlot funAdSlot) {
            this.f1205c = rewardVideoADArr;
            this.f1206d = funAdSlot;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            a.a.a.a.y.d.a();
            l.this.f1014h.a(this.f1204b);
            this.f1204b = true;
            l.this.e();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            a.a.a.a.y.d.a();
            l.this.f1014h.d();
            l.this.f();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            a.a.a.a.y.d.a();
            l.this.f1014h.b(this.f1203a);
            this.f1203a = true;
            RewardVideoAD rewardVideoAD = this.f1205c[0];
            l lVar = l.this;
            lVar.a((l) rewardVideoAD, lVar.n.remove(rewardVideoAD));
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            a.a.a.a.y.d.a();
            l.this.f1014h.b();
            RewardVideoAD rewardVideoAD = this.f1205c[0];
            l.this.n.put(rewardVideoAD, this.f1206d.getSid());
            l lVar = l.this;
            lVar.a((l) rewardVideoAD);
            lVar.h();
            l.this.l.b(rewardVideoAD, this.f1206d.getSid());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            a.a.a.a.y.d.a();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            a.a.a.a.y.d.b("GDTRewardVideoAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            l.this.f1014h.a(Integer.valueOf(adError.getErrorCode()));
            l.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            a.a.a.a.y.d.a();
            l.this.f1014h.f();
            l.this.i();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            a.a.a.a.y.d.a();
            l.this.f1014h.c();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            a.a.a.a.y.d.a();
            l.this.f1014h.j();
        }
    }

    public l(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.i(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, RewardVideoAD rewardVideoAD) {
        RewardVideoAD rewardVideoAD2 = rewardVideoAD;
        this.f1014h.g();
        this.n.put(rewardVideoAD2, str);
        rewardVideoAD2.showAD(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(r1, funAdSlot);
        this.f1014h.a(funAdSlot, this.f1015i);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(context.getApplicationContext(), this.f1015i.f1342c, (RewardVideoADListener) aVar, true);
        RewardVideoAD[] rewardVideoADArr = {rewardVideoAD};
        rewardVideoAD.loadAD();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(RewardVideoAD rewardVideoAD) {
        this.n.remove(rewardVideoAD);
    }
}
