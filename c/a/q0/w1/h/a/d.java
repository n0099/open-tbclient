package c.a.q0.w1.h.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTails.ColorInfo;
import tbclient.GetTails.ResData;
import tbclient.GetTails.TailInfo;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<TailData> f28050a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f28051b;

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
        this.f28050a = new ArrayList();
        this.f28051b = new ArrayList();
    }

    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28051b : (List) invokeV.objValue;
    }

    public List<TailData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28050a : (List) invokeV.objValue;
    }

    public void c(ResData resData) {
        List<TailInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resData) == null) || resData == null || (list = resData.tailList) == null) {
            return;
        }
        for (TailInfo tailInfo : list) {
            if (e(tailInfo)) {
                TailData tailData = new TailData();
                tailData.setContent(tailInfo.tailContent);
                tailData.setFontColor(tailInfo.fontColor);
                tailData.setFontType(tailInfo.fontKeyName);
                tailData.setId(tailInfo.tailId.intValue());
                tailData.setSelected(tailInfo.is_selected.intValue() == 1);
                b().add(tailData);
            }
        }
        d(resData.default_color);
        for (ColorInfo colorInfo : resData.colorList) {
            a().add(colorInfo.fontColor);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public final boolean e(TailInfo tailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tailInfo)) == null) {
            Integer num = tailInfo.tailId;
            return (num == null || num.intValue() == 0 || tailInfo.fontColor == null) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
