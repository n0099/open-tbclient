package c.a.t0.f1.f;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.w3.j0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.ChannelNativeAds;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes7.dex */
public class a implements TTAppDownloadListener, ChannelNativeAds.GdtADStatusChangeListener, KsAppDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final FunAdButton f17735e;

    /* renamed from: f  reason: collision with root package name */
    public final o f17736f;

    public a(FunAdButton funAdButton, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdButton, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17735e = funAdButton;
        this.f17736f = oVar;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            FunAdButton funAdButton = this.f17735e;
            if (funAdButton != null && funAdButton.getTag() == this.f17736f) {
                this.f17735e.setText(i2);
            }
            o oVar = this.f17736f;
            if (oVar != null) {
                oVar.i(TbadkApplication.getInst().getString(i2));
            }
        }
    }

    public void b(int i2) {
        FunAdButton funAdButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (funAdButton = this.f17735e) != null && funAdButton.getTag() == this.f17736f) {
            this.f17735e.setProgress(i2);
        }
    }

    @Override // com.fun.ad.sdk.ChannelNativeAds.GdtADStatusChangeListener
    public void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeUnifiedADData) == null) {
            if (!nativeUnifiedADData.isAppAd()) {
                a(R.string.ad_interaction_type_view);
                return;
            }
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                a(R.string.ad_interaction_type_download);
            } else if (appStatus == 1) {
                a(R.string.ad_interaction_type_start);
            } else if (appStatus == 2) {
                a(R.string.ad_interaction_type_update);
            } else if (appStatus == 4) {
                b(nativeUnifiedADData.getProgress());
            } else if (appStatus == 8) {
                a(R.string.ad_interaction_type_install);
            } else if (appStatus != 16) {
                a(R.string.ad_interaction_type_view);
            } else {
                a(R.string.ad_interaction_type_redownload);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || j2 <= 0) {
            return;
        }
        b((int) ((j3 * 100) / j2));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
            a(R.string.ad_interaction_type_download);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            a(R.string.ad_interaction_type_install);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || j2 <= 0) {
            return;
        }
        b((int) ((j3 * 100) / j2));
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener, com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a(R.string.ad_interaction_type_download);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            a(R.string.ad_interaction_type_open);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            b(i2);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(R.string.ad_interaction_type_download);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a(R.string.ad_interaction_type_install);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            a(R.string.ad_interaction_type_open);
        }
    }
}
