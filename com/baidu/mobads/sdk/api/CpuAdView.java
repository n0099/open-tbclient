package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.cp;
import com.baidu.mobads.sdk.internal.cr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public final class CpuAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cr mAdProd;

    /* loaded from: classes3.dex */
    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuAdView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), cPUWebAdRequestParam};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        cp cpVar = new cp(context);
        this.mAdProd = new cr(context, cpVar, str, i, cPUWebAdRequestParam);
        addView(cpVar, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), cPUWebAdRequestParam, cpuAdViewInternalStatusListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        cp cpVar = new cp(context);
        cr crVar = new cr(context, cpVar, str, i, cPUWebAdRequestParam);
        this.mAdProd = crVar;
        crVar.a(cpuAdViewInternalStatusListener);
        addView(cpVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                WebView webView = (WebView) this.mAdProd.w();
                if (webView == null) {
                    return false;
                }
                return webView.canGoBack();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                WebView webView = (WebView) this.mAdProd.w();
                if (webView != null) {
                    webView.goBack();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View w = this.mAdProd.w();
            if (w instanceof WebView) {
                ((WebView) w).destroy();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View w = this.mAdProd.w();
            if (w instanceof WebView) {
                ((WebView) w).onPause();
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View w = this.mAdProd.w();
            if (w instanceof WebView) {
                ((WebView) w).onResume();
            }
        }
    }

    public void requestData() {
        cr crVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (crVar = this.mAdProd) != null) {
            crVar.a();
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, keyEvent)) == null) {
            if (i == 4 && canGoBack()) {
                goBack();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
