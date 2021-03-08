package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class l extends a.a.a.a.c<RewardVideoAD> {
    public final HashMap<RewardVideoAD, String> m;

    /* loaded from: classes4.dex */
    public class a implements RewardVideoADListener {
        public final /* synthetic */ RewardVideoAD[] AO;
        public final /* synthetic */ FunAdSlot AP;

        /* renamed from: a  reason: collision with root package name */
        public boolean f986a;
        public boolean b;

        public a(RewardVideoAD[] rewardVideoADArr, FunAdSlot funAdSlot) {
            this.AO = rewardVideoADArr;
            this.AP = funAdSlot;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            a.a.a.a.v.d.a();
            l.this.zk.a(this.b);
            this.b = true;
            l.this.e();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            a.a.a.a.v.d.a();
            l.this.zk.d();
            l.this.f();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            a.a.a.a.v.d.a();
            l.this.zk.b(this.f986a);
            this.f986a = true;
            RewardVideoAD rewardVideoAD = this.AO[0];
            l lVar = l.this;
            lVar.a((l) rewardVideoAD, lVar.m.remove(rewardVideoAD));
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            a.a.a.a.v.d.a();
            l.this.zk.b();
            RewardVideoAD rewardVideoAD = this.AO[0];
            l.this.m.put(rewardVideoAD, this.AP.getSid());
            l lVar = l.this;
            lVar.a((l) rewardVideoAD);
            lVar.h();
            l.this.zm.b(rewardVideoAD, this.AP.getSid());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            a.a.a.a.v.d.a();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            a.a.a.a.v.d.b("GDTRewardVideoAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            l.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            l.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward() {
            a.a.a.a.v.d.a();
            l.this.zk.f();
            l.this.i();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            a.a.a.a.v.d.a();
            l.this.zk.c();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            a.a.a.a.v.d.a();
            l.this.zk.i();
        }
    }

    public l(e.a aVar) {
        super(aVar);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.i(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(r0, funAdSlot);
        this.zk.a(funAdSlot, this.zl);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(context.getApplicationContext(), this.zl.c, (RewardVideoADListener) aVar, true);
        RewardVideoAD[] rewardVideoADArr = {rewardVideoAD};
        rewardVideoAD.loadAD();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, RewardVideoAD rewardVideoAD) {
        RewardVideoAD rewardVideoAD2 = rewardVideoAD;
        this.zk.g();
        this.m.put(rewardVideoAD2, str);
        rewardVideoAD2.showAD(activity);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(RewardVideoAD rewardVideoAD) {
        this.m.remove(rewardVideoAD);
    }
}
