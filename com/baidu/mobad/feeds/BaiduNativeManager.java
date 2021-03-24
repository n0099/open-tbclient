package com.baidu.mobad.feeds;

import android.content.Context;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.b.a;
import com.baidu.mobads.production.b.b;
import com.baidu.mobads.production.b.e;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.List;
/* loaded from: classes2.dex */
public class BaiduNativeManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8007a = "BaiduNativeManager";

    /* renamed from: b  reason: collision with root package name */
    public final Context f8008b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8009c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8010d;

    /* renamed from: e  reason: collision with root package name */
    public int f8011e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8012f;

    /* loaded from: classes2.dex */
    public interface FeedAdListener {
        void onLpClosed();

        @Deprecated
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes2.dex */
    public interface NativeLoadListener extends FeedAdListener {
        void onLoadFail(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        BaiduNative baiduNative = new BaiduNative(this.f8008b, this.f8009c, new a(feedAdListener), new e(this.f8008b, this.f8009c, IXAdConstants4PDK.SlotType.SLOT_TYPE_CONTENT, this.f8010d, this.f8011e));
        baiduNative.setCacheVideoOnlyWifi(this.f8012f);
        baiduNative.setDownloadListener(new b());
        baiduNative.makeRequest(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        BaiduNative baiduNative = new BaiduNative(this.f8008b, this.f8009c, new a(feedAdListener), this.f8010d, this.f8011e);
        baiduNative.setCacheVideoOnlyWifi(this.f8012f);
        baiduNative.setDownloadListener(new b());
        baiduNative.makeRequest(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        BaiduNative baiduNative = new BaiduNative(this.f8008b, this.f8009c, new a(portraitVideoAdListener), new e(this.f8008b, this.f8009c, IXAdConstants4PDK.SlotType.SLOT_TYPE_PORTRAIT_VIDEO, this.f8010d, this.f8011e));
        baiduNative.setCacheVideoOnlyWifi(this.f8012f);
        baiduNative.setDownloadListener(new b());
        baiduNative.makeRequest(requestParameters);
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.f8012f = z;
    }

    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        this.f8010d = true;
        this.f8011e = 8000;
        this.f8012f = false;
        this.f8008b = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.f8009c = str;
        this.f8010d = z;
        this.f8011e = i;
        q.a(context).a();
    }
}
