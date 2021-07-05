package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ProdAdRequestInfo extends BasicAdRequestInfo implements IAdInterListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_SCHEMA = "bdsdk";
    public transient /* synthetic */ FieldHolder $fh;
    public XAbstractAdProdTemplate adProdTemplate;
    public JSONObject mAllParam;
    public RelativeLayout mRl;

    /* renamed from: com.baidu.mobads.container.adrequest.ProdAdRequestInfo$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-124926451, "Lcom/baidu/mobads/container/adrequest/ProdAdRequestInfo$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-124926451, "Lcom/baidu/mobads/container/adrequest/ProdAdRequestInfo$1;");
                    return;
                }
            }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProdAdRequestInfo(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        XAbstractAdProdTemplate xAbstractAdProdTemplate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, iOAdEventListener) == null) || (xAbstractAdProdTemplate = this.adProdTemplate) == null) {
            return;
        }
        xAbstractAdProdTemplate.addEventListener(str, iOAdEventListener);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void createProdHandler(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            String str = (String) ConvertUtils.optObjectFromJson(jSONObject, "prod");
            if ("feed".equals(str)) {
                this.mPrefixOfV = "androidfeed";
            }
            if ("rsplash".equals(str)) {
                this.adProdTemplate = new XAbstractAdProdTemplate(this.mCxt, this);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void destroyAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.adProdTemplate.destroy();
        }
    }

    public RelativeLayout getAdContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mRl == null) {
                AdView adView = new AdView(this.mCxt);
                this.mRl = adView;
                adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            return this.mRl;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public View getAdContainerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            XAbstractAdProdTemplate xAbstractAdProdTemplate = this.adProdTemplate;
            if (xAbstractAdProdTemplate != null) {
                return xAbstractAdProdTemplate.getAdView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public JSONObject getAllAdParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAllParam : (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public boolean isAdReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void loadAd(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, jSONObject2) == null) || this.adProdTemplate == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, str) == null) {
            onAdTaskProcess(view, str, null);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void removeAllListeners() {
        XAbstractAdProdTemplate xAbstractAdProdTemplate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (xAbstractAdProdTemplate = this.adProdTemplate) == null) {
            return;
        }
        xAbstractAdProdTemplate.removeAllListeners();
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void setAdContainer(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, relativeLayout) == null) {
            this.mRl = relativeLayout;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void showAd() {
        XAbstractAdProdTemplate xAbstractAdProdTemplate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (xAbstractAdProdTemplate = this.adProdTemplate) == null) {
            return;
        }
        xAbstractAdProdTemplate.showAd();
    }

    public void onAdTaskProcess(View view, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, view, str, map) == null) {
            try {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                JSONObject jSONObject = new JSONObject(parse.getQueryParameter("jsonObj"));
                AdTaskType adTaskType = AdTaskType.getAdTaskType(host);
                if ("bdsdk".equals(scheme)) {
                    int i2 = AnonymousClass1.$SwitchMap$com$baidu$mobads$container$adrequest$AdTaskType[adTaskType.ordinal()];
                    if (i2 == 1) {
                        if (this.adProdTemplate != null) {
                            this.adProdTemplate.handleAdClick(view, jSONObject);
                        }
                    } else if (i2 != 2) {
                        if (i2 == 3 && this.adProdTemplate != null) {
                            this.adProdTemplate.handleEvent(jSONObject, map);
                        }
                    } else if (this.adProdTemplate != null) {
                        this.adProdTemplate.recordImpression(view, jSONObject);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            onAdTaskProcess((View) null, str);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, map) == null) {
            onAdTaskProcess(null, str, map);
        }
    }
}
