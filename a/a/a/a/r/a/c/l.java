package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
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
public class l extends a.a.a.a.b<RewardVideoAD> {
    public final HashMap<RewardVideoAD, String> m;

    /* loaded from: classes.dex */
    public class a implements RewardVideoADListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1182a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1183b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RewardVideoAD[] f1184c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1185d;

        public a(RewardVideoAD[] rewardVideoADArr, FunAdSlot funAdSlot) {
            this.f1184c = rewardVideoADArr;
            this.f1185d = funAdSlot;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            a.a.a.a.v.d.a();
            l.this.f1010g.a(this.f1183b);
            this.f1183b = true;
            l.this.e();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            a.a.a.a.v.d.a();
            l.this.f1010g.d();
            l.this.f();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            a.a.a.a.v.d.a();
            l.this.f1010g.b(this.f1182a);
            this.f1182a = true;
            RewardVideoAD rewardVideoAD = this.f1184c[0];
            l lVar = l.this;
            lVar.a((l) rewardVideoAD, lVar.m.remove(rewardVideoAD));
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            a.a.a.a.v.d.a();
            l.this.f1010g.b();
            RewardVideoAD rewardVideoAD = this.f1184c[0];
            l.this.m.put(rewardVideoAD, this.f1185d.getSid());
            l lVar = l.this;
            lVar.a((l) rewardVideoAD);
            lVar.h();
            l.this.k.b(rewardVideoAD, this.f1185d.getSid());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            a.a.a.a.v.d.a();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            a.a.a.a.v.d.b("GDTRewardVideoAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            l.this.f1010g.a(Integer.valueOf(adError.getErrorCode()));
            l.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            a.a.a.a.v.d.a();
            l.this.f1010g.f();
            l.this.i();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            a.a.a.a.v.d.a();
            l.this.f1010g.c();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            a.a.a.a.v.d.a();
            l.this.f1010g.i();
        }
    }

    public l(e.a aVar) {
        super(aVar);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.h(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, RewardVideoAD rewardVideoAD) {
        RewardVideoAD rewardVideoAD2 = rewardVideoAD;
        this.f1010g.g();
        this.m.put(rewardVideoAD2, str);
        rewardVideoAD2.showAD(activity);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(r1, funAdSlot);
        this.f1010g.a(funAdSlot, this.f1011h);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(context.getApplicationContext(), this.f1011h.f1320c, (RewardVideoADListener) aVar, true);
        RewardVideoAD[] rewardVideoADArr = {rewardVideoAD};
        rewardVideoAD.loadAD();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(RewardVideoAD rewardVideoAD) {
        this.m.remove(rewardVideoAD);
    }
}
