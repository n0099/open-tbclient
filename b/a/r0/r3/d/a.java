package b.a.r0.r3.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f23082a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f23083b;

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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23082a : (String) invokeV.objValue;
    }

    public List<DressItemData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23083b : (List) invokeV.objValue;
    }

    public void c(ThemePendantInMain themePendantInMain) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themePendantInMain) == null) || themePendantInMain == null) {
            return;
        }
        this.f23082a = themePendantInMain.pendant_category;
        this.f23083b = new ArrayList();
        for (ThemeBgProp themeBgProp : themePendantInMain.props) {
            this.f23083b.add(new DressItemData(themeBgProp));
        }
    }
}
