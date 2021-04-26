package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.sdk.container.widget.AdView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ProdAdRequestInfo extends BasicAdRequestInfo implements IAdInterListener {
    public static final String AD_SCHEMA = "bdsdk";
    public XAbstractAdProdTemplate adProdTemplate;
    public JSONObject mAllParam;
    public RelativeLayout mRl;

    /* renamed from: com.baidu.mobads.container.adrequest.ProdAdRequestInfo$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType;

        static {
            int[] iArr = new int[AdTaskType.values().length];
            $SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType = iArr;
            try {
                iArr[AdTaskType.AD_CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType[AdTaskType.AD_IMPRESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType[AdTaskType.HANDLE_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ProdAdRequestInfo(Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        XAbstractAdProdTemplate xAbstractAdProdTemplate = this.adProdTemplate;
        if (xAbstractAdProdTemplate != null) {
            xAbstractAdProdTemplate.addEventListener(str, iOAdEventListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void createProdHandler(JSONObject jSONObject) {
        String str = (String) ConvertUtils.optObjectFromJson(jSONObject, "prod");
        if ("feed".equals(str)) {
            this.mPrefixOfV = "androidfeed";
        }
        if ("rsplash".equals(str)) {
            this.adProdTemplate = new XAbstractAdProdTemplate(this.mCxt, this);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void destroyAd() {
        this.adProdTemplate.destroy();
    }

    public RelativeLayout getAdContainer() {
        if (this.mRl == null) {
            AdView adView = new AdView(this.mCxt);
            this.mRl = adView;
            adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        return this.mRl;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public View getAdContainerView() {
        XAbstractAdProdTemplate xAbstractAdProdTemplate = this.adProdTemplate;
        if (xAbstractAdProdTemplate != null) {
            return xAbstractAdProdTemplate.getAdView();
        }
        return null;
    }

    public JSONObject getAllAdParam() {
        return this.mAllParam;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public boolean isAdReady() {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void loadAd(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.adProdTemplate == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        HashMap<String, String> json2HashMap = ConvertUtils.json2HashMap(jSONObject);
        String optString = jSONObject.optString("apid");
        String optString2 = jSONObject.optString("w");
        String optString3 = jSONObject.optString("h");
        json2HashMap.put(IAdRequestParam.REQ_ID, DeviceUtils.getInstance().createRequestId(this.mCxt, optString));
        if (!TextUtils.isEmpty(optString2)) {
            json2HashMap.put(IAdRequestParam.QUERY_WIDTH, "" + ((int) (Integer.parseInt(optString2) / ScreenUtils.getScreenDensity(this.mCxt))));
        }
        if (!TextUtils.isEmpty(optString3)) {
            json2HashMap.put(IAdRequestParam.QUERY_HEIGHT, "" + ((int) (Integer.parseInt(optString3) / ScreenUtils.getScreenDensity(this.mCxt))));
        }
        this.mAdditionalParameters = json2HashMap;
        try {
            this.mAllParam = ConvertUtils.combineJson(jSONObject, jSONObject2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        XAbstractAdProdTemplate xAbstractAdProdTemplate = this.adProdTemplate;
        if (xAbstractAdProdTemplate != null) {
            xAbstractAdProdTemplate.requestAd();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(View view, String str) {
        onAdTaskProcess(view, str, null);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void removeAllListeners() {
        XAbstractAdProdTemplate xAbstractAdProdTemplate = this.adProdTemplate;
        if (xAbstractAdProdTemplate != null) {
            xAbstractAdProdTemplate.removeAllListeners();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void setAdContainer(RelativeLayout relativeLayout) {
        this.mRl = relativeLayout;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void showAd() {
        XAbstractAdProdTemplate xAbstractAdProdTemplate = this.adProdTemplate;
        if (xAbstractAdProdTemplate != null) {
            xAbstractAdProdTemplate.showAd();
        }
    }

    public void onAdTaskProcess(View view, String str, Map<String, Object> map) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            JSONObject jSONObject = new JSONObject(parse.getQueryParameter("jsonObj"));
            AdTaskType adTaskType = AdTaskType.getAdTaskType(host);
            if ("bdsdk".equals(scheme)) {
                int i2 = AnonymousClass1.$SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType[adTaskType.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && this.adProdTemplate != null) {
                            this.adProdTemplate.handleEvent(jSONObject, map);
                        }
                    } else if (this.adProdTemplate != null) {
                        this.adProdTemplate.recordImpression(view, jSONObject);
                    }
                } else if (this.adProdTemplate != null) {
                    this.adProdTemplate.handleAdClick(view, jSONObject);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str) {
        onAdTaskProcess((View) null, str);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str, Map<String, Object> map) {
        onAdTaskProcess(null, str, map);
    }
}
