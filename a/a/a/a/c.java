package a.a.a.a;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
/* loaded from: classes.dex */
public class c implements k {

    /* renamed from: a  reason: collision with root package name */
    public final k f1013a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1014b;

    /* renamed from: c  reason: collision with root package name */
    public long f1015c;

    /* loaded from: classes.dex */
    public class a implements l {

        /* renamed from: a  reason: collision with root package name */
        public final l f1016a;

        public a(l lVar) {
            this.f1016a = lVar;
        }

        @Override // a.a.a.a.l
        public void a() {
            this.f1016a.a();
        }

        @Override // a.a.a.a.l
        public void a(int i, String str) {
            this.f1016a.a(i, str);
        }

        @Override // a.a.a.a.l
        public void b() {
            this.f1016a.b();
        }

        @Override // a.a.a.a.l
        public void onAdClicked() {
            this.f1016a.onAdClicked();
        }

        @Override // a.a.a.a.l
        public void onAdClose() {
            this.f1016a.onAdClose();
        }

        @Override // a.a.a.a.l
        public void onAdShow() {
            this.f1016a.onAdShow();
        }

        @Override // a.a.a.a.l
        public void onError(int i, String str) {
            this.f1016a.onError(i, str);
        }

        @Override // a.a.a.a.l
        public void onLoaded() {
            c.this.f1015c = System.currentTimeMillis();
            this.f1016a.onLoaded();
        }
    }

    public c(k kVar) {
        this.f1013a = kVar;
        this.f1014b = kVar.b().f1322e * 60 * 1000;
    }

    @Override // a.a.a.a.k
    public void a() {
        this.f1013a.a();
    }

    @Override // a.a.a.a.k
    public void a(l lVar) {
        this.f1013a.a(new a(lVar));
    }

    @Override // a.a.a.a.k
    public void a(Context context, FunAdSlot funAdSlot) {
        this.f1013a.a(context, funAdSlot);
    }

    @Override // a.a.a.a.k
    public boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        return this.f1013a.a(activity, viewGroup, str, funNativeAdInflater);
    }

    @Override // a.a.a.a.k
    public e.a b() {
        return this.f1013a.b();
    }

    @Override // a.a.a.a.k
    public boolean c() {
        return this.f1013a.c() && System.currentTimeMillis() - this.f1015c < this.f1014b;
    }

    @Override // a.a.a.a.k
    public a.a.a.a.u.o d() {
        return this.f1013a.d();
    }

    @Override // a.a.a.a.k
    public FunNativeAd getNativeAd(Context context, String str) {
        return this.f1013a.getNativeAd(context, str);
    }
}
