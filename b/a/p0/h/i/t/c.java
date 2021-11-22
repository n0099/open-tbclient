package b.a.p0.h.i.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import b.a.p0.h.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.view.RewardLoadWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, AdElementInfo adElementInfo, b.a.p0.h.i.o.a aVar) {
        super(context, adElementInfo, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AdElementInfo) objArr2[1], (b.a.p0.h.i.o.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.h.i.t.a
    public void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, relativeLayout, adElementInfo) == null) {
        }
    }

    @Override // b.a.p0.h.i.t.a
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? RewardLoadWebView.BANNER_HTML_TYPE : (String) invokeV.objValue;
    }

    @Override // b.a.p0.h.i.t.a
    @SuppressLint({"InflateParams"})
    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? LayoutInflater.from(this.p).inflate(f.ng_game_portrait_por_play, (ViewGroup) null) : (View) invokeV.objValue;
    }
}
