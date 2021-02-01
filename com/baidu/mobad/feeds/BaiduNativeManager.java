package com.baidu.mobad.feeds;

import android.content.Context;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.b.a;
import com.baidu.mobads.production.b.b;
import com.baidu.mobads.production.b.e;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.List;
/* loaded from: classes5.dex */
public class BaiduNativeManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3225a = BaiduNativeManager.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f3226b;
    private final String c;
    private boolean d;
    private int e;
    private boolean f;

    /* loaded from: classes5.dex */
    public interface FeedAdListener {
        void onLpClosed();

        @Deprecated
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes5.dex */
    public interface NativeLoadListener extends FeedAdListener {
        void onLoadFail(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
    }

    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        this.d = true;
        this.e = 8000;
        this.f = false;
        this.f3226b = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.c = str;
        this.d = z;
        this.e = i;
        q.a(context).a();
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.f = z;
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        BaiduNative baiduNative = new BaiduNative(this.f3226b, this.c, new a(feedAdListener), this.d, this.e);
        baiduNative.setCacheVideoOnlyWifi(this.f);
        baiduNative.setDownloadListener(new b());
        baiduNative.makeRequest(requestParameters);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        BaiduNative baiduNative = new BaiduNative(this.f3226b, this.c, new a(feedAdListener), new e(this.f3226b, this.c, IXAdConstants4PDK.SlotType.SLOT_TYPE_CONTENT, this.d, this.e));
        baiduNative.setCacheVideoOnlyWifi(this.f);
        baiduNative.setDownloadListener(new b());
        baiduNative.makeRequest(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        BaiduNative baiduNative = new BaiduNative(this.f3226b, this.c, new a(portraitVideoAdListener), new e(this.f3226b, this.c, IXAdConstants4PDK.SlotType.SLOT_TYPE_PORTRAIT_VIDEO, this.d, this.e));
        baiduNative.setCacheVideoOnlyWifi(this.f);
        baiduNative.setDownloadListener(new b());
        baiduNative.makeRequest(requestParameters);
    }
}
