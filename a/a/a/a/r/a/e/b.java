package a.a.a.a.r.a.e;

import a.a.a.a.s.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.win.opensdk.PBError;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a.a.a.a.b<PBNative> {
    public final HashMap<PBNative, C0003b> m;

    /* loaded from: classes.dex */
    public class a implements PBNativeListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1214a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1215b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBNative f1216c;

        public a(PBNative pBNative) {
            this.f1216c = pBNative;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            d.a();
            b.this.f1010g.a(this.f1215b);
            this.f1215b = true;
            b.this.e();
            synchronized (b.this.m) {
                C0003b c0003b = b.this.m.get(this.f1216c);
                if (c0003b != null) {
                    c0003b.f1219b.onAdClicked(c0003b.f1218a);
                }
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            d.a();
            b.this.f1010g.b(this.f1214a);
            this.f1214a = true;
            b.this.a((b) null, (String) null);
            synchronized (b.this.m) {
                C0003b c0003b = b.this.m.get(this.f1216c);
                if (c0003b != null) {
                    c0003b.f1219b.onAdShow(c0003b.f1218a);
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            b.this.f1010g.a(Integer.valueOf(pBError.getCode()));
            b.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            d.a();
            b.this.f1010g.b();
            b bVar = b.this;
            bVar.a((b) this.f1216c);
            bVar.h();
        }
    }

    /* renamed from: a.a.a.a.r.a.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1218a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdInteractionListener f1219b;

        public C0003b(String str, FunAdInteractionListener funAdInteractionListener) {
            this.f1218a = str;
            this.f1219b = funAdInteractionListener;
        }
    }

    public b(e.a aVar) {
        super(aVar, true, true);
        this.m = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, PBNative pBNative) {
        return new a.a.a.a.r.b.d.a(pBNative, str, this);
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        PBNative pBNative = new PBNative(context.getApplicationContext(), this.f1011h.f1334c);
        pBNative.setNativeListener(new a(pBNative));
        this.f1010g.a(funAdSlot, this.f1011h);
        pBNative.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        if (pBNative2 != null) {
            pBNative2.destroy();
            synchronized (this.m) {
                this.m.remove(pBNative2);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean c(PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        return pBNative2 != null && pBNative2.isReady();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        this.f1010g.g();
        JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, viewGroup, false);
        viewGroup.removeAllViews();
        viewGroup.addView(jYNativeAdView);
        jYNativeAdView.f30781a.setText(pBNative2.getBody());
        jYNativeAdView.f30783c.setText(pBNative2.getHeadline());
        Context context = jYNativeAdView.getContext();
        String icon = pBNative2.getIcon();
        ImageView imageView = jYNativeAdView.f30784d;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + icon, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + icon, new Object[0]);
            } else {
                Glide.with(activity2).load(icon).into(imageView);
            }
        } else {
            Glide.with(context).load(icon).into(imageView);
        }
        jYNativeAdView.f30785e.setText(pBNative2.getCallToAction());
        jYNativeAdView.f30786f = (pBNative2.getMediaViewWidth() * 1.0f) / (pBNative2.getMediaViewHeight() * 1.0f);
        pBNative2.registerViewForInteraction(jYNativeAdView, jYNativeAdView.f30782b);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.d.a(pBNative2, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        pBNative2.registerViewForInteraction(adContainer, null, clickViews);
        return true;
    }
}
