package a.a.a.a.r.a.a;

import a.a.a.a.a.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes4.dex */
public class a extends a.a.a.a.c<IBasicCPUData> {
    public boolean m;

    public a(e.a aVar) {
        super(aVar, true, true);
        this.m = false;
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.b(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, IBasicCPUData iBasicCPUData) {
        return new a.a.a.a.r.b.a.c(iBasicCPUData, str, this);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        this.m = funAdSlot.isSmallImgStyle();
        C0000a c0000a = new C0000a(funAdSlot);
        this.zk.a(funAdSlot, this.zl);
        NativeCPUManager nativeCPUManager = new NativeCPUManager(context.getApplicationContext(), this.zl.BI.b, c0000a);
        CPUAdRequest.Builder builder = new CPUAdRequest.Builder();
        builder.setDownloadAppConfirmPolicy(3);
        nativeCPUManager.setRequestParameter(builder.build());
        nativeCPUManager.setRequestTimeoutMillis(10000);
        nativeCPUManager.setPageSize(10);
        try {
            nativeCPUManager.loadAd(1, Integer.parseInt(this.zl.c), true);
            g();
        } catch (NumberFormatException e) {
            b(1, "F:invalid pid:" + this.zl.c);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(IBasicCPUData iBasicCPUData) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, IBasicCPUData iBasicCPUData) {
        String thumbUrl;
        String thumbUrl2;
        IBasicCPUData iBasicCPUData2 = iBasicCPUData;
        LayoutInflater from = LayoutInflater.from(activity);
        this.zk.g();
        if (this.m) {
            BaiduNativeCpuAdSmallImgView baiduNativeCpuAdSmallImgView = (BaiduNativeCpuAdSmallImgView) from.inflate(R.layout.baidu_ad_native_cpu_small_img_view, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(baiduNativeCpuAdSmallImgView);
            if (baiduNativeCpuAdSmallImgView == null) {
                throw null;
            }
            List<String> imageUrls = iBasicCPUData2.getImageUrls();
            List<String> smallImageUrls = iBasicCPUData2.getSmallImageUrls();
            if (smallImageUrls == null || smallImageUrls.isEmpty()) {
                thumbUrl2 = (imageUrls == null || imageUrls.isEmpty()) ? iBasicCPUData2.getThumbUrl() : imageUrls.get(0);
            } else {
                thumbUrl2 = smallImageUrls.get(0);
            }
            if (TextUtils.isEmpty(thumbUrl2)) {
                baiduNativeCpuAdSmallImgView.b.setImageDrawable(null);
                baiduNativeCpuAdSmallImgView.b.setVisibility(8);
            } else {
                Context context = baiduNativeCpuAdSmallImgView.getContext();
                ImageView imageView = baiduNativeCpuAdSmallImgView.b;
                if (context == null) {
                    d.b("GlideHelper: context is null when load: " + thumbUrl2, new Object[0]);
                } else if (context instanceof Activity) {
                    Activity activity2 = (Activity) context;
                    if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + thumbUrl2, new Object[0]);
                    } else {
                        Glide.with(activity2).load(thumbUrl2).into(imageView);
                    }
                } else {
                    Glide.with(context).load(thumbUrl2).into(imageView);
                }
                baiduNativeCpuAdSmallImgView.b.setVisibility(0);
            }
            baiduNativeCpuAdSmallImgView.f5232a.setText(iBasicCPUData2.getDesc());
            if (TextUtils.isEmpty(iBasicCPUData2.getBrandName())) {
                baiduNativeCpuAdSmallImgView.c.setText(R.string.ad_title_favourite);
            } else {
                baiduNativeCpuAdSmallImgView.c.setText(iBasicCPUData2.getBrandName());
            }
            Context context2 = baiduNativeCpuAdSmallImgView.getContext();
            String adLogoUrl = iBasicCPUData2.getAdLogoUrl();
            ImageView imageView2 = baiduNativeCpuAdSmallImgView.d;
            if (context2 == null) {
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
                baiduNativeCpuAdSmallImgView.e.setText(R.string.ad_interaction_type_download);
            } else {
                baiduNativeCpuAdSmallImgView.e.setText(R.string.ad_interaction_type_browser);
            }
            baiduNativeCpuAdSmallImgView.setOnClickListener(new a.a.a.a.r.b.a.b(baiduNativeCpuAdSmallImgView, iBasicCPUData2));
        } else {
            BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView = (BaiduNativeCpuAdLargeImgView) from.inflate(R.layout.baidu_ad_native_cpu_large_img_view, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(baiduNativeCpuAdLargeImgView);
            if (baiduNativeCpuAdLargeImgView != null) {
                if (TextUtils.isEmpty(iBasicCPUData2.getIconUrl())) {
                    baiduNativeCpuAdLargeImgView.c.setImageDrawable(null);
                    baiduNativeCpuAdLargeImgView.c.setVisibility(8);
                } else {
                    Context context3 = baiduNativeCpuAdLargeImgView.getContext();
                    String iconUrl = iBasicCPUData2.getIconUrl();
                    ImageView imageView3 = baiduNativeCpuAdLargeImgView.c;
                    if (context3 == null) {
                        d.b("GlideHelper: context is null when load: " + iconUrl, new Object[0]);
                    } else if (context3 instanceof Activity) {
                        Activity activity4 = (Activity) context3;
                        if (activity4.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity4.isDestroyed())) {
                            d.b("GlideHelper: activity is destroyed when load: " + iconUrl, new Object[0]);
                        } else {
                            Glide.with(activity4).load(iconUrl).into(imageView3);
                        }
                    } else {
                        Glide.with(context3).load(iconUrl).into(imageView3);
                    }
                    baiduNativeCpuAdLargeImgView.c.setVisibility(0);
                }
                List<String> imageUrls2 = iBasicCPUData2.getImageUrls();
                List<String> smallImageUrls2 = iBasicCPUData2.getSmallImageUrls();
                if (smallImageUrls2 == null || smallImageUrls2.isEmpty()) {
                    thumbUrl = (imageUrls2 == null || imageUrls2.isEmpty()) ? iBasicCPUData2.getThumbUrl() : imageUrls2.get(0);
                } else {
                    thumbUrl = smallImageUrls2.get(0);
                }
                if (TextUtils.isEmpty(thumbUrl)) {
                    baiduNativeCpuAdLargeImgView.b.setImageDrawable(null);
                    baiduNativeCpuAdLargeImgView.b.setVisibility(8);
                } else {
                    Context context4 = baiduNativeCpuAdLargeImgView.getContext();
                    ImageView imageView4 = baiduNativeCpuAdLargeImgView.b;
                    if (context4 == null) {
                        d.b("GlideHelper: context is null when load: " + thumbUrl, new Object[0]);
                    } else if (context4 instanceof Activity) {
                        Activity activity5 = (Activity) context4;
                        if (activity5.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity5.isDestroyed())) {
                            d.b("GlideHelper: activity is destroyed when load: " + thumbUrl, new Object[0]);
                        } else {
                            Glide.with(activity5).load(thumbUrl).into(imageView4);
                        }
                    } else {
                        Glide.with(context4).load(thumbUrl).into(imageView4);
                    }
                    baiduNativeCpuAdLargeImgView.b.setVisibility(0);
                }
                baiduNativeCpuAdLargeImgView.f5231a.setText(iBasicCPUData2.getDesc());
                if (TextUtils.isEmpty(iBasicCPUData2.getBrandName())) {
                    baiduNativeCpuAdLargeImgView.d.setText(R.string.ad_title_favourite);
                } else {
                    baiduNativeCpuAdLargeImgView.d.setText(iBasicCPUData2.getBrandName());
                }
                Context context5 = baiduNativeCpuAdLargeImgView.getContext();
                String adLogoUrl2 = iBasicCPUData2.getAdLogoUrl();
                ImageView imageView5 = baiduNativeCpuAdLargeImgView.e;
                if (context5 == null) {
                    d.b("GlideHelper: context is null when load: " + adLogoUrl2, new Object[0]);
                } else if (context5 instanceof Activity) {
                    Activity activity6 = (Activity) context5;
                    if (activity6.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity6.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + adLogoUrl2, new Object[0]);
                    } else {
                        Glide.with(activity6).load(adLogoUrl2).into(imageView5);
                    }
                } else {
                    Glide.with(context5).load(adLogoUrl2).into(imageView5);
                }
                if (iBasicCPUData2.isDownloadApp()) {
                    baiduNativeCpuAdLargeImgView.f.setText(R.string.ad_interaction_type_download);
                } else {
                    baiduNativeCpuAdLargeImgView.f.setText(R.string.ad_interaction_type_browser);
                }
                baiduNativeCpuAdLargeImgView.setOnClickListener(new a.a.a.a.r.b.a.a(baiduNativeCpuAdLargeImgView, iBasicCPUData2));
            } else {
                throw null;
            }
        }
        a((a) iBasicCPUData2, str);
        iBasicCPUData2.onImpression(viewGroup);
        this.zk.b(false);
        return true;
    }

    /* renamed from: a.a.a.a.r.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0000a implements NativeCPUManager.CPUAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public C0000a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdClick() {
            d.a();
            a.this.zk.a(false);
            a.this.e();
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdError(String str, int i) {
            d.b("onAdError code: " + i + ", message: " + str, new Object[0]);
            a.this.zk.a(Integer.valueOf(i));
            a.this.b(i, str);
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdStatusChanged(String str) {
            d.a("onAdStatusChanged appPackageName: " + str, new Object[0]);
        }

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onNoAd(String str, int i) {
            d.b("onNoAd code: " + i + ", message: " + str, new Object[0]);
            a.this.zk.a(Integer.valueOf(i));
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

        @Override // com.baidu.mobads.nativecpu.NativeCPUManager.CPUAdListener
        public void onAdLoaded(List<IBasicCPUData> list) {
            d.a();
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (IBasicCPUData iBasicCPUData : list) {
                    if (TextUtils.equals(iBasicCPUData.getType(), "ad")) {
                        arrayList.add(iBasicCPUData);
                        a.this.zm.b(iBasicCPUData, this.zR.getSid());
                    }
                }
                d.a("loaded %d ad data", Integer.valueOf(arrayList.size()));
                if (arrayList.isEmpty()) {
                    a aVar = a.this;
                    aVar.zk.a("NoFill");
                    aVar.b(0, "NoFill");
                    return;
                }
                a.this.zk.b();
                a aVar2 = a.this;
                if (aVar2 == null) {
                    throw null;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    aVar2.a((a) it.next());
                }
                aVar2.h();
                return;
            }
            a aVar3 = a.this;
            aVar3.zk.a("NoFill");
            aVar3.b(0, "NoFill");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, IBasicCPUData iBasicCPUData) {
        IBasicCPUData iBasicCPUData2 = iBasicCPUData;
        this.zk.g();
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
        this.zk.b(false);
        return true;
    }
}
