package c.a.d.h.f;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IAlertManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class a implements IAlertManager {
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
            }
        }
    }

    @Override // com.baidu.nps.interfa.IAlertManager
    public void onAlert(String str, String str2, View.OnClickListener onClickListener, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, onClickListener, str3) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IAlertManager
    public void onAlert(String str, String str2, View.OnClickListener onClickListener, String str3, View.OnClickListener onClickListener2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, onClickListener, str3, onClickListener2, str4}) == null) {
        }
    }
}
