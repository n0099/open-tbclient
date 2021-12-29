package c.a.t0.n1.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import c.a.t0.b4.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String version = TbConfig.getVersion();
        if (TextUtils.isEmpty(version)) {
            return;
        }
        StatService.setAppVersionName(TbadkCoreApplication.getInst(), version);
    }

    @Override // c.a.t0.b4.c.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            StatService.setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_NONE);
            StatService.autoTrace(context);
        }
    }

    @Override // c.a.t0.b4.c.a
    public void b(Context context, WebView webView, WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, webView, webChromeClient) == null) {
            StatService.trackWebView(context, webView, webChromeClient);
        }
    }

    @Override // c.a.t0.b4.c.a
    public void c(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, str, z) == null) {
            StatService.setAppChannel(context, str, z);
        }
    }
}
