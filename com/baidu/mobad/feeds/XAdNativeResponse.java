package com.baidu.mobad.feeds;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebView;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.XAdInstanceInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class XAdNativeResponse implements NativeResponse {

    /* renamed from: a  reason: collision with root package name */
    private IXAdInstanceInfo f3267a;

    /* renamed from: b  reason: collision with root package name */
    private BaiduNative f3268b;
    private boolean c;
    private IXAdFeedsRequestParameters d;
    private IXAdContainer e;

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.c = false;
        this.f3267a = iXAdInstanceInfo;
        this.f3268b = baiduNative;
        this.e = iXAdContainer;
        if (this.f3267a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload()) {
            this.c = true;
        }
        this.d = iXAdFeedsRequestParameters;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAdLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBaiduLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-logo_2x.png";
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getTitle() {
        return this.f3267a.getTitle();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getDesc() {
        return this.f3267a.getDescription();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getIconUrl() {
        String iconUrl = this.f3267a.getIconUrl();
        if (iconUrl == null || iconUrl.equals("")) {
            return this.f3267a.getMainPictureUrl();
        }
        return iconUrl;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getImageUrl() {
        return this.f3267a.getMainPictureUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isDownloadApp() {
        return this.c;
    }

    public void setIsDownloadApp(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.f3268b.isAdAvailable(context, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public long getAppSize() {
        return this.f3267a.getAppSize();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPackage() {
        return this.f3267a.getAppPackageName();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public List<String> getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.f3267a.getOriginJsonObject().optJSONArray("morepics");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Exception e) {
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public Map<String, String> getExtras() {
        return null;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void recordImpression(View view) {
        this.f3268b.recordImpression(view, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view, int i) {
        a(view, i, this.f3267a);
    }

    private void a(View view, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        if (isDownloadApp()) {
            Context context = view.getContext();
            if (this.d.getAPPConfirmPolicy() == 3) {
                iXAdInstanceInfo.setActionOnlyWifi(false);
                this.f3268b.handleClick(view, iXAdInstanceInfo, i, this.d);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 4) {
                a(context);
                this.f3268b.handleClick(view, iXAdInstanceInfo, i, this.d);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 2) {
                a(view, i);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 1) {
                if (XAdSDKFoundationFacade.getInstance().getSystemUtils().is3GConnected(context).booleanValue()) {
                    a(view, i);
                    return;
                }
                a(context);
                this.f3268b.handleClick(view, iXAdInstanceInfo, i, this.d);
                return;
            } else {
                return;
            }
        }
        this.f3268b.handleClick(view, this.f3267a, i, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (XAdSDKFoundationFacade.getInstance().getSystemUtils().is3GConnected(context).booleanValue()) {
            this.f3267a.setActionOnlyWifi(false);
        } else {
            this.f3267a.setActionOnlyWifi(true);
        }
    }

    private void a(final View view, final int i) {
        final Context context = view.getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确认下载\"" + getTitle() + "\"?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.baidu.mobad.feeds.XAdNativeResponse.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                XAdNativeResponse.this.a(context);
                XAdNativeResponse.this.f3268b.handleClick(view, XAdNativeResponse.this.f3267a, i, XAdNativeResponse.this.d);
            }
        });
        builder.setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.baidu.mobad.feeds.XAdNativeResponse.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onStart(Context context) {
        this.f3268b.handleOnStart(context, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onError(Context context, int i, int i2) {
        this.f3268b.handleOnError(context, i, i2, this.f3267a);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onComplete(Context context) {
        this.f3268b.handleOnComplete(context, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClose(Context context, int i) {
        this.f3268b.handleOnClose(context, i, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onFullScreen(Context context, int i) {
        this.f3268b.handleOnFullScreen(context, i, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getVideoUrl() {
        return this.f3267a.getVideoUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getDuration() {
        return this.f3267a.getVideoDuration();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        if (this.f3267a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (this.f3267a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getHtmlSnippet() {
        return this.f3267a.getHtmlSnippet();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public WebView getWebView() {
        return (WebView) this.e.getAdView();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClickAd(Context context) {
        this.f3268b.handleOnClickAd(context, this.f3267a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicWidth() {
        return this.f3267a.getMainMaterialWidth();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicHeight() {
        return this.f3267a.getMainMaterialHeight();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBrandName() {
        return this.f3267a.getAppName();
    }

    protected boolean supportDownloadDirect() {
        return this.f3267a.getAction().equals("video") && this.f3267a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload() && this.f3267a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    protected void handleClickDownloadDirect(View view) {
        if (supportDownloadDirect()) {
            try {
                XAdInstanceInfo xAdInstanceInfo = (XAdInstanceInfo) ((XAdInstanceInfo) this.f3267a).clone();
                xAdInstanceInfo.setAction("");
                a(view, -1, xAdInstanceInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
