package a.a.a.a.r.a.c;

import a.a.a.a.s.h;
import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
/* loaded from: classes.dex */
public class a extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // a.a.a.a.r.a.c.o, a.a.a.a.b
    public a.a.a.a.u.a a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.e(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    @Override // a.a.a.a.r.a.c.o
    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, unifiedInterstitialAD) == null) {
            unifiedInterstitialAD.showFullScreenAD(activity);
        }
    }

    @Override // a.a.a.a.r.a.c.o
    public void a(UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unifiedInterstitialAD) == null) {
            unifiedInterstitialAD.loadFullScreenAD();
        }
    }
}
