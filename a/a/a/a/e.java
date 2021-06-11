package a.a.a.a;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
/* loaded from: classes.dex */
public class e implements n {

    /* renamed from: a  reason: collision with root package name */
    public final n f1018a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1019b;

    /* renamed from: c  reason: collision with root package name */
    public long f1020c;

    /* loaded from: classes.dex */
    public class a implements o {

        /* renamed from: a  reason: collision with root package name */
        public final o f1021a;

        public a(o oVar) {
            this.f1021a = oVar;
        }

        @Override // a.a.a.a.o
        public void a() {
            this.f1021a.a();
        }

        @Override // a.a.a.a.o
        public void a(int i2, String str) {
            this.f1021a.a(i2, str);
        }

        @Override // a.a.a.a.o
        public void b() {
            this.f1021a.b();
        }

        @Override // a.a.a.a.o
        public void onAdClicked() {
            this.f1021a.onAdClicked();
        }

        @Override // a.a.a.a.o
        public void onAdClose() {
            this.f1021a.onAdClose();
        }

        @Override // a.a.a.a.o
        public void onAdShow() {
            this.f1021a.onAdShow();
        }

        @Override // a.a.a.a.o
        public void onError(int i2, String str) {
            this.f1021a.onError(i2, str);
        }

        @Override // a.a.a.a.o
        public void onLoaded() {
            e.this.f1020c = System.currentTimeMillis();
            this.f1021a.onLoaded();
        }
    }

    public e(n nVar) {
        this.f1018a = nVar;
        this.f1019b = nVar.b().f1344e * 60 * 1000;
    }

    @Override // a.a.a.a.n
    public void a() {
        this.f1018a.a();
    }

    @Override // a.a.a.a.n
    public void a(o oVar) {
        this.f1018a.a(new a(oVar));
    }

    @Override // a.a.a.a.n
    public boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        return this.f1018a.a(activity, viewGroup, str, funNativeAdInflater);
    }

    @Override // a.a.a.a.n
    public boolean a(Context context, FunAdSlot funAdSlot) {
        return this.f1018a.a(context, funAdSlot);
    }

    @Override // a.a.a.a.n
    public e.a b() {
        return this.f1018a.b();
    }

    @Override // a.a.a.a.n
    public boolean c() {
        return this.f1018a.c() && System.currentTimeMillis() - this.f1020c < this.f1019b;
    }

    @Override // a.a.a.a.n
    public a.a.a.a.x.p d() {
        return this.f1018a.d();
    }

    @Override // a.a.a.a.n
    public FunNativeAd getNativeAd(Context context, String str) {
        return this.f1018a.getNativeAd(context, str);
    }
}
