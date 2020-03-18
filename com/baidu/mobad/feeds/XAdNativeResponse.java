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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class XAdNativeResponse implements NativeResponse {
    private IXAdInstanceInfo a;
    private BaiduNative aOp;
    private IXAdFeedsRequestParameters aOq;
    private IXAdContainer aOr;
    private boolean c;

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.c = false;
        this.a = iXAdInstanceInfo;
        this.aOp = baiduNative;
        this.aOr = iXAdContainer;
        if (this.a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload()) {
            this.c = true;
        }
        this.aOq = iXAdFeedsRequestParameters;
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
        return this.a.getTitle();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getDesc() {
        return this.a.getDescription();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getIconUrl() {
        String iconUrl = this.a.getIconUrl();
        if (iconUrl == null || iconUrl.equals("")) {
            return this.a.getMainPictureUrl();
        }
        return iconUrl;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getImageUrl() {
        return this.a.getMainPictureUrl();
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
        return this.aOp.isAdAvailable(context, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public long getAppSize() {
        return this.a.getAppSize();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPackage() {
        return this.a.getAppPackageName();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public List<String> getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.a.getOriginJsonObject().optJSONArray("morepics");
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
        this.aOp.c(view, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view, int i) {
        a(view, i, this.a);
    }

    private void a(View view, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        if (isDownloadApp()) {
            Context context = view.getContext();
            if (this.aOq.getAPPConfirmPolicy() == 3) {
                iXAdInstanceInfo.setActionOnlyWifi(false);
                this.aOp.b(view, iXAdInstanceInfo, i, this.aOq);
                return;
            } else if (this.aOq.getAPPConfirmPolicy() == 4) {
                a(context);
                this.aOp.b(view, iXAdInstanceInfo, i, this.aOq);
                return;
            } else if (this.aOq.getAPPConfirmPolicy() == 2) {
                a(view, i);
                return;
            } else if (this.aOq.getAPPConfirmPolicy() == 1) {
                if (XAdSDKFoundationFacade.getInstance().getSystemUtils().is3GConnected(context).booleanValue()) {
                    a(view, i);
                    return;
                }
                a(context);
                this.aOp.b(view, iXAdInstanceInfo, i, this.aOq);
                return;
            } else {
                return;
            }
        }
        this.aOp.b(view, this.a, i, this.aOq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (XAdSDKFoundationFacade.getInstance().getSystemUtils().is3GConnected(context).booleanValue()) {
            this.a.setActionOnlyWifi(false);
        } else {
            this.a.setActionOnlyWifi(true);
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
                XAdNativeResponse.this.aOp.b(view, XAdNativeResponse.this.a, i, XAdNativeResponse.this.aOq);
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
        this.aOp.e(context, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onError(Context context, int i, int i2) {
        this.aOp.b(context, i, i2, this.a);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onComplete(Context context) {
        this.aOp.f(context, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClose(Context context, int i) {
        this.aOp.c(context, i, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onFullScreen(Context context, int i) {
        this.aOp.d(context, i, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getVideoUrl() {
        return this.a.getVideoUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getDuration() {
        return this.a.getVideoDuration();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        if (this.a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (this.a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getHtmlSnippet() {
        return this.a.getHtmlSnippet();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public WebView getWebView() {
        return (WebView) this.aOr.getAdView();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClickAd(Context context) {
        this.aOp.g(context, this.a, this.aOq);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicWidth() {
        return this.a.getMainMaterialWidth();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicHeight() {
        return this.a.getMainMaterialHeight();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBrandName() {
        return this.a.getAppName();
    }
}
