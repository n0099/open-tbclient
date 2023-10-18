package com.baidu.mobads.sdk.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ac implements e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaiduNativeManager.FeedAdListener a;

    public ac(BaiduNativeManager.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeResponse) == null) && (nativeResponse instanceof XAdNativeResponse)) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b(NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nativeResponse) == null) {
            BaiduNativeManager.FeedAdListener feedAdListener = this.a;
            if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
                ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
            } else if (nativeResponse instanceof XAdNativeResponse) {
                ((XAdNativeResponse) nativeResponse).onAdClick();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (feedAdListener = this.a) != null) {
            feedAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (feedAdListener = this.a) != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (feedAdListener = this.a) != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(int i, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (feedAdListener = this.a) != null) {
            feedAdListener.onNoAd(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b(int i, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (feedAdListener = this.a) != null) {
            feedAdListener.onNativeFail(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(NativeResponse nativeResponse, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, nativeResponse, i) == null) && (nativeResponse instanceof XAdNativeResponse)) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && (feedAdListener = this.a) != null) {
            feedAdListener.onNativeLoad(list);
        }
    }
}
