package a.a.a.a.r.a.a;

import a.a.a.a.s.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.mobads.nativecpu.CPUAdRequest;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.baidu.mobads.nativecpu.NativeCPUManager;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdLargeImgView;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdSmallImgView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends a.a.a.a.b<IBasicCPUData> {
    public boolean m;

    /* renamed from: a.a.a.a.r.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a implements NativeCPUManager.CPUAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1084a;

        public C0000a(FunAdSlot funAdSlot) {
            this.f1084a = funAdSlot;
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdClick() {
            d.a();
            a.this.f1010g.a(false);
            a.this.e();
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdError(String str, int i) {
            d.b("onAdError code: " + i + ", message: " + str, new Object[0]);
            a.this.f1010g.a(Integer.valueOf(i));
            a.this.b(i, str);
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdLoaded(List<IBasicCPUData> list) {
            d.a();
            if (list == null || list.isEmpty()) {
                a aVar = a.this;
                aVar.f1010g.a("NoFill");
                aVar.b(0, "NoFill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (IBasicCPUData iBasicCPUData : list) {
                if (TextUtils.equals(iBasicCPUData.getType(), "ad")) {
                    arrayList.add(iBasicCPUData);
                    a.this.k.b(iBasicCPUData, this.f1084a.getSid());
                }
            }
            d.a("loaded %d ad data", Integer.valueOf(arrayList.size()));
            if (arrayList.isEmpty()) {
                a aVar2 = a.this;
                aVar2.f1010g.a("NoFill");
                aVar2.b(0, "NoFill");
                return;
            }
            a.this.f1010g.b();
            a aVar3 = a.this;
            if (aVar3 == null) {
                throw null;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar3.a((a) it.next());
            }
            aVar3.h();
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdStatusChanged(String str) {
            d.a("onAdStatusChanged appPackageName: " + str, new Object[0]);
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onNoAd(String str, int i) {
            d.b("onNoAd code: " + i + ", message: " + str, new Object[0]);
            a.this.f1010g.a(Integer.valueOf(i));
            a.this.b(i, str);
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onVideoDownloadFailed() {
            d.a();
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onVideoDownloadSuccess() {
            d.a();
        }
    }

    public a(e.a aVar) {
        super(aVar, true, true);
        this.m = false;
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.b(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, IBasicCPUData iBasicCPUData) {
        return new a.a.a.a.r.b.a.c(iBasicCPUData, str, this);
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        this.m = funAdSlot.isSmallImgStyle();
        C0000a c0000a = new C0000a(funAdSlot);
        this.f1010g.a(funAdSlot, this.f1011h);
        NativeCPUManager nativeCPUManager = new NativeCPUManager(context.getApplicationContext(), this.f1011h.k.f1330b, c0000a);
        CPUAdRequest.Builder builder = new CPUAdRequest.Builder();
        builder.setDownloadAppConfirmPolicy(3);
        nativeCPUManager.setRequestParameter(builder.build());
        nativeCPUManager.setRequestTimeoutMillis(10000);
        nativeCPUManager.setPageSize(10);
        try {
            nativeCPUManager.loadAd(1, Integer.parseInt(this.f1011h.f1334c), true);
            g();
        } catch (NumberFormatException unused) {
            b(1, "F:invalid pid:" + this.f1011h.f1334c);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(IBasicCPUData iBasicCPUData) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0233  */
    @Override // a.a.a.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Activity activity, ViewGroup viewGroup, String str, IBasicCPUData iBasicCPUData) {
        String thumbUrl;
        String str2;
        Context context;
        Button button;
        int i;
        String thumbUrl2;
        String str3;
        Context context2;
        Button button2;
        int i2;
        IBasicCPUData iBasicCPUData2 = iBasicCPUData;
        LayoutInflater from = LayoutInflater.from(activity);
        this.f1010g.g();
        if (this.m) {
            BaiduNativeCpuAdSmallImgView baiduNativeCpuAdSmallImgView = (BaiduNativeCpuAdSmallImgView) from.inflate(R.layout.baidu_ad_native_cpu_small_img_view, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(baiduNativeCpuAdSmallImgView);
            if (baiduNativeCpuAdSmallImgView == null) {
                throw null;
            }
            List<String> imageUrls = iBasicCPUData2.getImageUrls();
            List<String> smallImageUrls = iBasicCPUData2.getSmallImageUrls();
            if (smallImageUrls != null && !smallImageUrls.isEmpty()) {
                str3 = smallImageUrls.get(0);
            } else if (imageUrls == null || imageUrls.isEmpty()) {
                thumbUrl2 = iBasicCPUData2.getThumbUrl();
                if (TextUtils.isEmpty(thumbUrl2)) {
                    Context context3 = baiduNativeCpuAdSmallImgView.getContext();
                    ImageView imageView = baiduNativeCpuAdSmallImgView.f30751b;
                    if (context3 == null) {
                        d.b("GlideHelper: context is null when load: " + thumbUrl2, new Object[0]);
                    } else if (context3 instanceof Activity) {
                        Activity activity2 = (Activity) context3;
                        if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                            d.b("GlideHelper: activity is destroyed when load: " + thumbUrl2, new Object[0]);
                        } else {
                            Glide.with(activity2).load(thumbUrl2).into(imageView);
                        }
                    } else {
                        Glide.with(context3).load(thumbUrl2).into(imageView);
                    }
                    baiduNativeCpuAdSmallImgView.f30751b.setVisibility(0);
                } else {
                    baiduNativeCpuAdSmallImgView.f30751b.setImageDrawable(null);
                    baiduNativeCpuAdSmallImgView.f30751b.setVisibility(8);
                }
                baiduNativeCpuAdSmallImgView.f30750a.setText(iBasicCPUData2.getDesc());
                if (TextUtils.isEmpty(iBasicCPUData2.getBrandName())) {
                    baiduNativeCpuAdSmallImgView.f30752c.setText(iBasicCPUData2.getBrandName());
                } else {
                    baiduNativeCpuAdSmallImgView.f30752c.setText(R.string.ad_title_favourite);
                }
                context2 = baiduNativeCpuAdSmallImgView.getContext();
                String adLogoUrl = iBasicCPUData2.getAdLogoUrl();
                ImageView imageView2 = baiduNativeCpuAdSmallImgView.f30753d;
                if (context2 != null) {
                    d.b("GlideHelper: context is null when load: " + adLogoUrl, new Object[0]);
                } else if (context2 instanceof Activity) {
                    Activity activity3 = (Activity) context2;
                    if (activity3.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity3.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + adLogoUrl, new Object[0]);
                    } else {
                        Glide.with(activity3).load(adLogoUrl).into(imageView2);
                    }
                } else {
                    Glide.with(context2).load(adLogoUrl).into(imageView2);
                }
                if (iBasicCPUData2.isDownloadApp()) {
                    button2 = baiduNativeCpuAdSmallImgView.f30754e;
                    i2 = R.string.ad_interaction_type_browser;
                } else {
                    button2 = baiduNativeCpuAdSmallImgView.f30754e;
                    i2 = R.string.ad_interaction_type_download;
                }
                button2.setText(i2);
                baiduNativeCpuAdSmallImgView.setOnClickListener(new a.a.a.a.r.b.a.b(baiduNativeCpuAdSmallImgView, iBasicCPUData2));
            } else {
                str3 = imageUrls.get(0);
            }
            thumbUrl2 = str3;
            if (TextUtils.isEmpty(thumbUrl2)) {
            }
            baiduNativeCpuAdSmallImgView.f30750a.setText(iBasicCPUData2.getDesc());
            if (TextUtils.isEmpty(iBasicCPUData2.getBrandName())) {
            }
            context2 = baiduNativeCpuAdSmallImgView.getContext();
            String adLogoUrl2 = iBasicCPUData2.getAdLogoUrl();
            ImageView imageView22 = baiduNativeCpuAdSmallImgView.f30753d;
            if (context2 != null) {
            }
            if (iBasicCPUData2.isDownloadApp()) {
            }
            button2.setText(i2);
            baiduNativeCpuAdSmallImgView.setOnClickListener(new a.a.a.a.r.b.a.b(baiduNativeCpuAdSmallImgView, iBasicCPUData2));
        } else {
            BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView = (BaiduNativeCpuAdLargeImgView) from.inflate(R.layout.baidu_ad_native_cpu_large_img_view, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(baiduNativeCpuAdLargeImgView);
            if (baiduNativeCpuAdLargeImgView == null) {
                throw null;
            }
            if (TextUtils.isEmpty(iBasicCPUData2.getIconUrl())) {
                baiduNativeCpuAdLargeImgView.f30745c.setImageDrawable(null);
                baiduNativeCpuAdLargeImgView.f30745c.setVisibility(8);
            } else {
                Context context4 = baiduNativeCpuAdLargeImgView.getContext();
                String iconUrl = iBasicCPUData2.getIconUrl();
                ImageView imageView3 = baiduNativeCpuAdLargeImgView.f30745c;
                if (context4 == null) {
                    d.b("GlideHelper: context is null when load: " + iconUrl, new Object[0]);
                } else if (context4 instanceof Activity) {
                    Activity activity4 = (Activity) context4;
                    if (activity4.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity4.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + iconUrl, new Object[0]);
                    } else {
                        Glide.with(activity4).load(iconUrl).into(imageView3);
                    }
                } else {
                    Glide.with(context4).load(iconUrl).into(imageView3);
                }
                baiduNativeCpuAdLargeImgView.f30745c.setVisibility(0);
            }
            List<String> imageUrls2 = iBasicCPUData2.getImageUrls();
            List<String> smallImageUrls2 = iBasicCPUData2.getSmallImageUrls();
            if (smallImageUrls2 != null && !smallImageUrls2.isEmpty()) {
                str2 = smallImageUrls2.get(0);
            } else if (imageUrls2 == null || imageUrls2.isEmpty()) {
                thumbUrl = iBasicCPUData2.getThumbUrl();
                if (TextUtils.isEmpty(thumbUrl)) {
                    Context context5 = baiduNativeCpuAdLargeImgView.getContext();
                    ImageView imageView4 = baiduNativeCpuAdLargeImgView.f30744b;
                    if (context5 == null) {
                        d.b("GlideHelper: context is null when load: " + thumbUrl, new Object[0]);
                    } else if (context5 instanceof Activity) {
                        Activity activity5 = (Activity) context5;
                        if (activity5.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity5.isDestroyed())) {
                            d.b("GlideHelper: activity is destroyed when load: " + thumbUrl, new Object[0]);
                        } else {
                            Glide.with(activity5).load(thumbUrl).into(imageView4);
                        }
                    } else {
                        Glide.with(context5).load(thumbUrl).into(imageView4);
                    }
                    baiduNativeCpuAdLargeImgView.f30744b.setVisibility(0);
                } else {
                    baiduNativeCpuAdLargeImgView.f30744b.setImageDrawable(null);
                    baiduNativeCpuAdLargeImgView.f30744b.setVisibility(8);
                }
                baiduNativeCpuAdLargeImgView.f30743a.setText(iBasicCPUData2.getDesc());
                if (TextUtils.isEmpty(iBasicCPUData2.getBrandName())) {
                    baiduNativeCpuAdLargeImgView.f30746d.setText(iBasicCPUData2.getBrandName());
                } else {
                    baiduNativeCpuAdLargeImgView.f30746d.setText(R.string.ad_title_favourite);
                }
                context = baiduNativeCpuAdLargeImgView.getContext();
                String adLogoUrl3 = iBasicCPUData2.getAdLogoUrl();
                ImageView imageView5 = baiduNativeCpuAdLargeImgView.f30747e;
                if (context != null) {
                    d.b("GlideHelper: context is null when load: " + adLogoUrl3, new Object[0]);
                } else if (context instanceof Activity) {
                    Activity activity6 = (Activity) context;
                    if (activity6.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity6.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + adLogoUrl3, new Object[0]);
                    } else {
                        Glide.with(activity6).load(adLogoUrl3).into(imageView5);
                    }
                } else {
                    Glide.with(context).load(adLogoUrl3).into(imageView5);
                }
                if (iBasicCPUData2.isDownloadApp()) {
                    button = baiduNativeCpuAdLargeImgView.f30748f;
                    i = R.string.ad_interaction_type_browser;
                } else {
                    button = baiduNativeCpuAdLargeImgView.f30748f;
                    i = R.string.ad_interaction_type_download;
                }
                button.setText(i);
                baiduNativeCpuAdLargeImgView.setOnClickListener(new a.a.a.a.r.b.a.a(baiduNativeCpuAdLargeImgView, iBasicCPUData2));
            } else {
                str2 = imageUrls2.get(0);
            }
            thumbUrl = str2;
            if (TextUtils.isEmpty(thumbUrl)) {
            }
            baiduNativeCpuAdLargeImgView.f30743a.setText(iBasicCPUData2.getDesc());
            if (TextUtils.isEmpty(iBasicCPUData2.getBrandName())) {
            }
            context = baiduNativeCpuAdLargeImgView.getContext();
            String adLogoUrl32 = iBasicCPUData2.getAdLogoUrl();
            ImageView imageView52 = baiduNativeCpuAdLargeImgView.f30747e;
            if (context != null) {
            }
            if (iBasicCPUData2.isDownloadApp()) {
            }
            button.setText(i);
            baiduNativeCpuAdLargeImgView.setOnClickListener(new a.a.a.a.r.b.a.a(baiduNativeCpuAdLargeImgView, iBasicCPUData2));
        }
        a((a) iBasicCPUData2, str);
        iBasicCPUData2.onImpression(viewGroup);
        this.f1010g.b(false);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, IBasicCPUData iBasicCPUData) {
        IBasicCPUData iBasicCPUData2 = iBasicCPUData;
        this.f1010g.g();
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.a.c(iBasicCPUData2, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null || clickViews.isEmpty()) {
            d.b("No clickViews found from FunNativeAdInflater", new Object[0]);
        } else {
            b bVar = new b(this, iBasicCPUData2);
            for (View view : clickViews) {
                view.setOnClickListener(bVar);
            }
        }
        a((a) iBasicCPUData2, str);
        iBasicCPUData2.onImpression(adContainer);
        this.f1010g.b(false);
        return true;
    }
}
