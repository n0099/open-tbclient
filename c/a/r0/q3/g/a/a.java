package c.a.r0.q3.g.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24195a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.r0.q3.a> f24196b;

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

    public ArrayList<c.a.r0.q3.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24196b : (ArrayList) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24195a : (String) invokeV.objValue;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeCardInMain) == null) || themeCardInMain == null) {
            return;
        }
        this.f24195a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f24196b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                c.a.r0.q3.a aVar = new c.a.r0.q3.a();
                aVar.k(themeCardPropMain);
                this.f24196b.add(aVar);
            }
        }
    }
}
