package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class da extends bf {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String G;
    public static final String a = "enter_refresh_bookstore";
    public static final String q = "enter_reader";
    public static final String r = "notify_impression";
    public static final String s = "request_int_ad_view";
    public static final String t = "request_banner_ad_view";
    public static final String u = "request_bookstore_bottom_view";
    public static final String v = "request_shelf_ad_view";
    public static final String w = "reader_background_status_change";
    public static final String x = "pre_chapter_adstart_countdown";
    public static final String y = "try_get_cuid";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String F;
    public CPUNovelAd.CpuNovelListener H;
    public SoftReference<RelativeLayout> I;
    public HashMap<String, Object> z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833695346, "Lcom/baidu/mobads/sdk/internal/da;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833695346, "Lcom/baidu/mobads/sdk/internal/da;");
                return;
            }
        }
        G = da.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            an.b();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            an.a(this.B);
            an.b(this.C);
            an.a(new dd(this));
        }
    }

    public Activity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return an.c();
        }
        return (Activity) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return an.d();
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return an.e();
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            an.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cPUWebAdRequestParam};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.B = 5;
        this.C = 60;
        this.D = 0;
        this.E = 10006;
        this.F = "";
        this.A = str;
        this.z = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOAdEvent) == null) && (cpuNovelListener = this.H) != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) && (cpuNovelListener = this.H) != null) {
            cpuNovelListener.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, map) == null) && map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            Object obj8 = map.get("motivateDeeplinkAdSwitch");
            Object obj9 = map.get("motivateDeeplinkAdFrequency");
            Object obj10 = map.get("motivateDeeplinkAdExpTime");
            Object obj11 = map.get("motivateDeeplinkNoAdTime");
            Object obj12 = map.get("isStartRewardAdTimer");
            Object obj13 = map.get("temporaryAdDensitySwitch");
            Object obj14 = map.get("temporaryAdDensityTimes");
            Object obj15 = map.get("temporaryAdDensityScreen");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                if (((Integer) obj5).intValue() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                an.a(z);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                an.a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                an.h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                an.b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                an.b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f();
            if (this.k == null) {
                this.l = false;
                return;
            }
            this.l = true;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "novel");
                this.k.createProdHandler(jSONObject);
                n();
                this.k.addEventListener("Update_fbReader_Setting", new db(this));
                this.k.addEventListener("closeInterstitialAd", new dc(this));
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(this.A)) {
                    jSONObject2.put("appid", this.A);
                }
                jSONObject2.put(IAdInterListener.AdReqParam.PROD, "novel");
                this.k.loadAd(jSONObject2, j.a(this.z));
            } catch (Throwable th) {
                this.i.c(G, th);
            }
        }
    }

    public void a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cpuNovelListener) == null) {
            this.H = cpuNovelListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View a2 = an.a(this.h);
            if (a2 instanceof FrameLayout) {
                RelativeLayout relativeLayout = new RelativeLayout(this.h);
                this.I = new SoftReference<>(relativeLayout);
                relativeLayout.setId(33);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ax.a(this.h, 53.0f));
                layoutParams.gravity = 80;
                ((FrameLayout) a2).addView(relativeLayout, layoutParams);
                if (bj.a((Context) null).a() >= 18) {
                    relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new de(this, relativeLayout));
                }
            }
            return a2;
        }
        return (View) invokeV.objValue;
    }
}
