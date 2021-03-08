package a.a.a.a;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
/* loaded from: classes4.dex */
public class d implements l {
    public final long b;
    public long c;
    public final l zo;

    /* loaded from: classes4.dex */
    public class a implements m {
        public final m zp;

        public a(m mVar) {
            this.zp = mVar;
        }

        @Override // a.a.a.a.m
        public void a() {
            this.zp.a();
        }

        @Override // a.a.a.a.m
        public void a(int i, String str) {
            this.zp.a(i, str);
        }

        @Override // a.a.a.a.m
        public void b() {
            this.zp.b();
        }

        @Override // a.a.a.a.m
        public void onAdClicked() {
            this.zp.onAdClicked();
        }

        @Override // a.a.a.a.m
        public void onAdClose() {
            this.zp.onAdClose();
        }

        @Override // a.a.a.a.m
        public void onAdShow() {
            this.zp.onAdShow();
        }

        @Override // a.a.a.a.m
        public void onError(int i, String str) {
            this.zp.onError(i, str);
        }

        @Override // a.a.a.a.m
        public void onLoaded() {
            d.this.c = System.currentTimeMillis();
            this.zp.onLoaded();
        }
    }

    public d(l lVar) {
        this.zo = lVar;
        this.b = lVar.hq().e * 60 * 1000;
    }

    @Override // a.a.a.a.l
    public void a() {
        this.zo.a();
    }

    @Override // a.a.a.a.l
    public void a(m mVar) {
        this.zo.a(new a(mVar));
    }

    @Override // a.a.a.a.l
    public boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        return this.zo.a(activity, viewGroup, str, funNativeAdInflater);
    }

    @Override // a.a.a.a.l
    public void b(Context context, FunAdSlot funAdSlot) {
        this.zo.b(context, funAdSlot);
    }

    @Override // a.a.a.a.l
    public boolean c() {
        return this.zo.c() && System.currentTimeMillis() - this.c < this.b;
    }

    @Override // a.a.a.a.l
    public FunNativeAd getNativeAd(Context context, String str) {
        return this.zo.getNativeAd(context, str);
    }

    @Override // a.a.a.a.l
    public e.a hq() {
        return this.zo.hq();
    }

    @Override // a.a.a.a.l
    public a.a.a.a.c.p hr() {
        return this.zo.hr();
    }
}
