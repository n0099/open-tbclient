package c.a.r0.q3.f.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24168a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f24169b;

    public b() {
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

    public List<DressItemData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24169b : (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24168a : (String) invokeV.objValue;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeBubbleInMain) == null) || themeBubbleInMain == null) {
            return;
        }
        this.f24168a = themeBubbleInMain.bubble_category;
        this.f24169b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f24169b.add(new DressItemData(themeBgProp));
        }
    }
}
