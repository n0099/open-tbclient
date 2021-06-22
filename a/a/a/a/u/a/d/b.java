package a.a.a.a.u.a.d;

import a.a.a.a.v.e;
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
public class b extends a.a.a.a.c<PBNative> {
    public final HashMap<PBNative, C0002b> n;

    /* loaded from: classes.dex */
    public class a implements PBNativeListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1227a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1228b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBNative f1229c;

        public a(PBNative pBNative) {
            this.f1229c = pBNative;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            a.a.a.a.y.d.a();
            b.this.f1014h.a(this.f1228b);
            this.f1228b = true;
            b.this.e();
            synchronized (b.this.n) {
                C0002b c0002b = b.this.n.get(this.f1229c);
                if (c0002b != null) {
                    c0002b.f1233c.onAdClicked(c0002b.f1231a);
                }
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            a.a.a.a.y.d.a();
            b.this.f1014h.b(this.f1227a);
            this.f1227a = true;
            b.this.a((b) null, (String) null);
            synchronized (b.this.n) {
                C0002b c0002b = b.this.n.get(this.f1229c);
                if (c0002b != null) {
                    c0002b.f1233c.onAdShow(c0002b.f1231a);
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            a.a.a.a.y.d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            b.this.f1014h.a(Integer.valueOf(pBError.getCode()));
            b.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            a.a.a.a.y.d.a();
            b.this.f1014h.b();
            b bVar = b.this;
            bVar.a((b) this.f1229c);
            bVar.h();
        }
    }

    /* renamed from: a.a.a.a.u.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1231a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1232b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdInteractionListener f1233c;

        public C0002b(String str) {
            this.f1231a = str;
        }
    }

    public b(e.a aVar) {
        super(aVar, true, true);
        this.n = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, PBNative pBNative) {
        return new a.a.a.a.u.b.c.a(pBNative, str, this);
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        PBNative pBNative = new PBNative(context.getApplicationContext(), this.f1015i.f1342c);
        pBNative.setNativeListener(new a(pBNative));
        this.f1014h.a(funAdSlot, this.f1015i);
        pBNative.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        if (pBNative2 != null) {
            pBNative2.destroy();
            synchronized (this.n) {
                this.n.remove(pBNative2);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        return pBNative2 != null && pBNative2.isReady();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        this.f1014h.g();
        JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, viewGroup, false);
        viewGroup.removeAllViews();
        viewGroup.addView(jYNativeAdView);
        jYNativeAdView.f30830a.setText(pBNative2.getBody());
        jYNativeAdView.f30832c.setText(pBNative2.getHeadline());
        Context context = jYNativeAdView.getContext();
        String icon = pBNative2.getIcon();
        ImageView imageView = jYNativeAdView.f30833d;
        if (context == null) {
            a.a.a.a.y.d.b("GlideHelper: context is null when load: " + icon, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                a.a.a.a.y.d.b("GlideHelper: activity is destroyed when load: " + icon, new Object[0]);
            } else {
                Glide.with(activity2).load(icon).into(imageView);
            }
        } else {
            Glide.with(context).load(icon).into(imageView);
        }
        jYNativeAdView.f30834e.setText(pBNative2.getCallToAction());
        jYNativeAdView.f30835f = (pBNative2.getMediaViewWidth() * 1.0f) / (pBNative2.getMediaViewHeight() * 1.0f);
        pBNative2.registerViewForInteraction(jYNativeAdView, jYNativeAdView.f30831b);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.u.b.c.a(pBNative2, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        pBNative2.registerViewForInteraction(adContainer, null, clickViews);
        return true;
    }
}
