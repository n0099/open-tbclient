package c.a.o0.h.o0.g.b;

import android.content.res.Resources;
import c.a.o0.h.m0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField
    public volatile float top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public d() {
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
        Resources resources = c.a.o0.a.c1.a.b() != null ? c.a.o0.a.c1.a.b().getResources() : null;
        this.left = a(resources, c.a.o0.f.c.swangame_recommend_button_default_left);
        this.top = a(resources, c.a.o0.f.c.swangame_recommend_button_default_top);
        this.width = a(resources, c.a.o0.f.c.swangame_recommend_button_default_width);
        this.height = a(resources, c.a.o0.f.c.swangame_recommend_button_default_height);
    }

    public final float a(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, resources, i2)) == null) {
            if (resources == null || i2 == 0) {
                return 0.0f;
            }
            return g.b(resources.getDimension(i2));
        }
        return invokeLI.floatValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + "}";
        }
        return (String) invokeV.objValue;
    }
}
