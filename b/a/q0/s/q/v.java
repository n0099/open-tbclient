package b.a.q0.s.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes4.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f14242a;

    /* renamed from: b  reason: collision with root package name */
    public int f14243b;

    public v() {
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
        this.f14242a = new ArrayList<>();
    }

    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14242a : (ArrayList) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14243b : invokeV.intValue;
    }

    public boolean c(ColorEgg colorEgg) {
        InterceptResult invokeL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, colorEgg)) == null) {
            this.f14243b = 0;
            if (colorEgg == null || (list = colorEgg.holiday_words) == null || list.size() <= 0) {
                return false;
            }
            for (String str : colorEgg.holiday_words) {
                if (!StringUtils.isNull(str)) {
                    this.f14242a.add(str);
                }
            }
            if (this.f14242a.size() <= 0) {
                return false;
            }
            this.f14243b = colorEgg.style_flag.intValue();
            return true;
        }
        return invokeL.booleanValue;
    }
}
