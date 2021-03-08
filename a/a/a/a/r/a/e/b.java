package a.a.a.a.r.a.e;

import a.a.a.a.a.e;
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
/* loaded from: classes4.dex */
public class b extends a.a.a.a.c<PBNative> {
    public final HashMap<PBNative, C0003b> m;

    /* loaded from: classes4.dex */
    public class a implements PBNativeListener {
        public final /* synthetic */ PBNative Ba;

        /* renamed from: a  reason: collision with root package name */
        public boolean f991a;
        public boolean b;

        public a(PBNative pBNative) {
            this.Ba = pBNative;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            d.a();
            b.this.zk.a(this.b);
            this.b = true;
            b.this.e();
            synchronized (b.this.m) {
                C0003b c0003b = b.this.m.get(this.Ba);
                if (c0003b != null) {
                    c0003b.zU.onAdClicked(c0003b.f992a);
                }
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            d.a();
            b.this.zk.b(this.f991a);
            this.f991a = true;
            b.this.a((b) null, (String) null);
            synchronized (b.this.m) {
                C0003b c0003b = b.this.m.get(this.Ba);
                if (c0003b != null) {
                    c0003b.zU.onAdShow(c0003b.f992a);
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
            b.this.zk.a(Integer.valueOf(pBError.getCode()));
            b.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            d.a();
            b.this.zk.b();
            b bVar = b.this;
            bVar.a((b) this.Ba);
            bVar.h();
        }
    }

    /* renamed from: a.a.a.a.r.a.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0003b {

        /* renamed from: a  reason: collision with root package name */
        public final String f992a;
        public final FunAdInteractionListener zU;

        public C0003b(String str, FunAdInteractionListener funAdInteractionListener) {
            this.f992a = str;
            this.zU = funAdInteractionListener;
        }
    }

    public b(e.a aVar) {
        super(aVar, true, true);
        this.m = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, PBNative pBNative) {
        return new a.a.a.a.r.b.d.a(pBNative, str, this);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        PBNative pBNative = new PBNative(context.getApplicationContext(), this.zl.c);
        pBNative.setNativeListener(new a(pBNative));
        this.zk.a(funAdSlot, this.zl);
        pBNative.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
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
    @Override // a.a.a.a.c
    public boolean c(PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        return pBNative2 != null && pBNative2.isReady();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBNative pBNative) {
        PBNative pBNative2 = pBNative;
        this.zk.g();
        JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, viewGroup, false);
        viewGroup.removeAllViews();
        viewGroup.addView(jYNativeAdView);
        jYNativeAdView.f5234a.setText(pBNative2.getBody());
        jYNativeAdView.c.setText(pBNative2.getHeadline());
        Context context = jYNativeAdView.getContext();
        String icon = pBNative2.getIcon();
        ImageView imageView = jYNativeAdView.d;
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
        jYNativeAdView.e.setText(pBNative2.getCallToAction());
        jYNativeAdView.f = (pBNative2.getMediaViewWidth() * 1.0f) / (pBNative2.getMediaViewHeight() * 1.0f);
        pBNative2.registerViewForInteraction(jYNativeAdView, jYNativeAdView.b);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
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
