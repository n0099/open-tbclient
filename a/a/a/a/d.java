package a.a.a.a;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
/* loaded from: classes.dex */
public class d implements m {

    /* renamed from: a  reason: collision with root package name */
    public final m f1016a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1017b;

    /* renamed from: c  reason: collision with root package name */
    public long f1018c;

    /* loaded from: classes.dex */
    public class a implements n {

        /* renamed from: a  reason: collision with root package name */
        public final n f1019a;

        public a(n nVar) {
            this.f1019a = nVar;
        }

        @Override // a.a.a.a.n
        public void a() {
            this.f1019a.a();
        }

        @Override // a.a.a.a.n
        public void a(int i2, String str) {
            this.f1019a.a(i2, str);
        }

        @Override // a.a.a.a.n
        public void b() {
            this.f1019a.b();
        }

        @Override // a.a.a.a.n
        public void onAdClicked() {
            this.f1019a.onAdClicked();
        }

        @Override // a.a.a.a.n
        public void onAdClose() {
            this.f1019a.onAdClose();
        }

        @Override // a.a.a.a.n
        public void onAdShow() {
            this.f1019a.onAdShow();
        }

        @Override // a.a.a.a.n
        public void onError(int i2, String str) {
            this.f1019a.onError(i2, str);
        }

        @Override // a.a.a.a.n
        public void onLoaded() {
            d.this.f1018c = System.currentTimeMillis();
            this.f1019a.onLoaded();
        }
    }

    public d(m mVar) {
        this.f1016a = mVar;
        this.f1017b = mVar.b().f1336e * 60 * 1000;
    }

    @Override // a.a.a.a.m
    public void a() {
        this.f1016a.a();
    }

    @Override // a.a.a.a.m
    public void a(n nVar) {
        this.f1016a.a(new a(nVar));
    }

    @Override // a.a.a.a.m
    public boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        return this.f1016a.a(activity, viewGroup, str, funNativeAdInflater);
    }

    @Override // a.a.a.a.m
    public boolean a(Context context, FunAdSlot funAdSlot) {
        return this.f1016a.a(context, funAdSlot);
    }

    @Override // a.a.a.a.m
    public e.a b() {
        return this.f1016a.b();
    }

    @Override // a.a.a.a.m
    public boolean c() {
        return this.f1016a.c() && System.currentTimeMillis() - this.f1018c < this.f1017b;
    }

    @Override // a.a.a.a.m
    public a.a.a.a.w.p d() {
        return this.f1016a.d();
    }

    @Override // a.a.a.a.m
    public FunNativeAd getNativeAd(Context context, String str) {
        return this.f1016a.getNativeAd(context, str);
    }
}
