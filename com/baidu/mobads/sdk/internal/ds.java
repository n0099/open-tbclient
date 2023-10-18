package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ds extends bf {
    public static /* synthetic */ Interceptable $ic;
    public static int G;
    public static ds M;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public SplashAdListener H;
    public SplashAd.OnFinishListener I;
    public SplashAd.SplashFocusAdListener J;
    public SplashAd.SplashCardAdListener K;
    public RequestParameters L;
    public a N;
    public SplashAd.SplashAdDownloadDialogListener O;
    public HashMap<String, String> P;
    public int a;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public RelativeLayout v;
    public String w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833695904, "Lcom/baidu/mobads/sdk/internal/ds;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833695904, "Lcom/baidu/mobads/sdk/internal/ds;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds(Context context, String str, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.F = 60;
        this.a = 67;
        this.q = -16777216;
        this.s = false;
        this.t = false;
        this.u = false;
        this.w = str;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
        this.B = z;
        this.C = z2;
        this.D = z4;
        this.E = z3;
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            G = i;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.q = i;
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.F = i;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, str) == null) && (splashAdDownloadDialogListener = this.O) != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            splashAdDownloadDialogListener.onADFunctionLpShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, iOAdEvent) == null) {
            this.s = true;
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdClick();
            }
            SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
            if (splashFocusAdListener != null) {
                splashFocusAdListener.onAdClick();
            }
            SplashAd.SplashCardAdListener splashCardAdListener = this.K;
            if (splashCardAdListener != null) {
                splashCardAdListener.onCardClick();
            }
        }
    }

    public Object j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (this.N != null) {
                if (HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID.equals(str)) {
                    return this.N.U();
                }
                return this.N.a(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        ds dsVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, activity, jSONObject, splashFocusAdListener) == null) && (dsVar = M) != null) {
            dsVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    M.a(jSONObject2, hashMap);
                } finally {
                    M = null;
                }
            } catch (JSONException e) {
                br.a().c(e);
            } catch (Throwable th) {
                br.a().c(th);
            }
        }
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent, onFinishListener) == null) && (context = this.h) != null && intent != null) {
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            this.h.startActivity(intent);
            if (onFinishListener != null) {
                onFinishListener.onFinishActivity();
                return;
            }
            Context context2 = this.h;
            if (context2 instanceof Activity) {
                ((Activity) context2).finish();
            }
        }
    }

    private String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (this.L != null && !TextUtils.isEmpty(str)) {
                try {
                    Map<String, String> extras = this.L.getExtras();
                    if (extras != null) {
                        return extras.get(str);
                    }
                    return null;
                } catch (Throwable th) {
                    this.i.d(bf.b, th);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        List<a> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) {
            if (iOAdEvent != null && (a = b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
                this.N = a.get(0);
            }
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null) {
                splashAdListener.onADLoaded();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener == null) {
                this.l = false;
                return;
            }
            this.l = true;
            if (!this.r) {
                iAdInterListener.setAdContainer(this.v);
            }
            this.k.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
            }
            super.b_();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
            }
            super.c_();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onLpClosed();
            }
            SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
            if (splashFocusAdListener != null) {
                splashFocusAdListener.onLpClosed();
            }
            super.d();
        }
    }

    public void f() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && !this.r && (iAdInterListener = this.k) != null) {
            iAdInterListener.setAdContainer(this.v);
            this.k.showAd();
        }
    }

    public a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.N;
        }
        return (a) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdPresent();
            }
            SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
            if (splashFocusAdListener != null) {
                splashFocusAdListener.onAdIconShow();
            }
            SplashAd.SplashCardAdListener splashCardAdListener = this.K;
            if (splashCardAdListener != null) {
                splashCardAdListener.onCardShow();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            SplashAd.OnFinishListener onFinishListener = this.I;
            if (onFinishListener != null) {
                onFinishListener.onFinishActivity();
                this.I = null;
            } else {
                Context context = this.h;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
            this.h = null;
            this.v = null;
            super.t();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (splashAdDownloadDialogListener = this.O) != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            splashAdDownloadDialogListener.onADPrivacyLpClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (splashAdDownloadDialogListener = this.O) != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            splashAdDownloadDialogListener.onADFunctionLpClose();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a = i;
        }
    }

    public void c(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            try {
                this.P = j.a(map);
            } catch (Throwable unused) {
                this.P = new HashMap<>();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && (splashAdDownloadDialogListener = this.O) != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            splashAdDownloadDialogListener.onADPrivacyLpShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            this.u = true;
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null) {
                splashAdListener.onAdFailed("广告无填充");
            }
            super.a(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) && (splashAdDownloadDialogListener = this.O) != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            if (z) {
                splashAdDownloadDialogListener.adDownloadWindowShow();
            } else {
                splashAdDownloadDialogListener.adDownloadWindowClose();
            }
        }
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, intent, onFinishListener) == null) {
            try {
                if (!this.s && intent != null && this.k != null && !this.u && (this.h instanceof Activity)) {
                    this.I = onFinishListener;
                    JSONObject jSONObject = new JSONObject();
                    HashMap hashMap = new HashMap();
                    try {
                        jSONObject.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_focus_start_activity");
                        hashMap.put("splash_focus_user_intent", intent);
                    } catch (JSONException e) {
                        br.a().a(e);
                    }
                    this.k.removeAllListeners();
                    this.k.addEventListener(w.Z, this.j);
                    this.k.addEventListener(w.M, this.j);
                    this.k.addEventListener(w.H, this.j);
                    this.k.addEventListener(w.W, this.j);
                    this.k.addEventListener(w.X, this.j);
                    a(jSONObject, hashMap);
                    this.H = null;
                    M = this;
                    ba.a().a(new dt(this), 3L, TimeUnit.SECONDS);
                    return;
                }
                b(intent, onFinishListener);
            } catch (Throwable th) {
                th.printStackTrace();
                b(intent, onFinishListener);
            }
        }
    }

    public void a(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, relativeLayout) == null) {
            this.v = relativeLayout;
        }
    }

    public void a(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, requestParameters) == null) {
            this.L = requestParameters;
            c(requestParameters.getExt());
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, splashAdDownloadDialogListener) == null) {
            this.O = splashAdDownloadDialogListener;
        }
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, splashCardAdListener) == null) {
            this.K = splashCardAdListener;
            this.t = false;
        }
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, splashFocusAdListener) == null) {
            this.J = splashFocusAdListener;
            this.t = false;
        }
    }

    public void a(SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, splashAdListener) == null) {
            this.H = splashAdListener;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("msg", str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashFailedLog");
                } catch (JSONException e) {
                    br.a().a(e);
                }
                a(jSONObject, hashMap);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) && (splashAdDownloadDialogListener = this.O) != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            if (z) {
                splashAdDownloadDialogListener.onADPermissionShow();
            } else {
                splashAdDownloadDialogListener.onADPermissionClose();
            }
        }
    }

    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            a(z, str, (HashMap<String, Object>) null);
        }
    }

    public void a(boolean z, String str, HashMap<String, Object> hashMap) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), str, hashMap}) == null) && (aVar = this.N) != null) {
            a(aVar.H(), z, str, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) {
            this.u = true;
            if (this.H != null) {
                a(i + "==" + str);
                this.H.onAdFailed(str);
            }
            super.b(str, i);
        }
    }

    public boolean b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, activity)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                this.k.removeAllListeners();
                this.k.addEventListener(w.M, this.j);
                this.k.addEventListener(w.H, this.j);
                this.k.addEventListener(w.W, this.j);
                this.H = null;
                jSONObject.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_focus_card");
                hashMap.put("splash_focus_activity", activity);
                a(jSONObject, hashMap);
                Object obj = hashMap.get("splash_focus_card_show");
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return false;
            } catch (JSONException e) {
                br.a().c(e);
                return false;
            } catch (Throwable th) {
                br.a().c(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, iOAdEvent) == null) && !this.t) {
            this.t = true;
            Map<String, Object> data = iOAdEvent.getData();
            if (this.J != null && data != null && data.containsKey("splash_close_reason")) {
                this.J.onAdClose();
                return;
            }
            SplashAd.SplashCardAdListener splashCardAdListener = this.K;
            if (splashCardAdListener != null) {
                splashCardAdListener.onCardClose();
                return;
            }
            super.g(iOAdEvent);
            SplashAdListener splashAdListener = this.H;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_focus_card_enable");
                a(jSONObject, hashMap);
                Object obj = hashMap.get("splash_focus_card_enable");
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return false;
            } catch (JSONException e) {
                br.a().c(e);
                return false;
            } catch (Throwable th) {
                br.a().c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            String str = "1";
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
                this.k.createProdHandler(jSONObject2);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.w);
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
                jSONObject.put("n", "1");
                jSONObject.put("at", "26");
                jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put("w", "" + this.x);
                jSONObject.put("h", "" + this.y);
                jSONObject.put("msa", 399);
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                String k = k(SplashAd.KEY_USE_ADAPTIVE_AD);
                if (!TextUtils.isEmpty(k)) {
                    if (!Boolean.parseBoolean(k)) {
                        str = "0";
                    }
                    jSONObject.put("adtv", str);
                }
                jSONObject = j.a(jSONObject, b(this.P));
                b(jSONObject);
                return jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timeout", this.A);
                jSONObject.put("splashTipStyle", this.z);
                jSONObject.put("bitmapDisplayMode", G);
                jSONObject.put("countDownNew", YYOption.IsLive.VALUE_TRUE);
                jSONObject.put("Display_Down_Info", "" + this.B);
                jSONObject.put("popDialogIfDl", "" + this.C);
                jSONObject.put("limitRegionClick", "" + this.D);
                jSONObject.put("displayClickButton", "" + this.E);
                jSONObject.put("needCache", true);
                jSONObject.put("onlyLoadAd", this.r);
                jSONObject.put("cacheVideoOnlyWifi", true);
                jSONObject.put("shakeLogoSize", this.F);
                jSONObject.put("twistLogoHeightDp", this.a);
                jSONObject.put("twistBgColor", this.q);
                if (this.L != null) {
                    a(this.L.getExtras());
                }
                return j.a(jSONObject, b(this.m));
            } catch (Exception e) {
                e.printStackTrace();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
