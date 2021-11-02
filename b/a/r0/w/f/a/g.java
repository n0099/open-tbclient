package b.a.r0.w.f.a;

import b.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f24515h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d2 f24516e;

    /* renamed from: f  reason: collision with root package name */
    public int f24517f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24518g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1556691635, "Lb/a/r0/w/f/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1556691635, "Lb/a/r0/w/f/a/g;");
                return;
            }
        }
        f24515h = BdUniqueId.gen();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d2 d2Var = this.f24516e;
            if (d2Var == null || d2Var.q1() == null || this.f24516e.q1().video_height.intValue() <= 0) {
                return 0.0f;
            }
            return this.f24516e.q1().video_width.intValue() / this.f24516e.q1().video_height.intValue();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f24515h : (BdUniqueId) invokeV.objValue;
    }

    public StatisticItem i(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            d2 d2Var = this.f24516e;
            if (d2Var == null) {
                return null;
            }
            int i2 = 1;
            if (d2Var.o0()) {
                i2 = 2;
            } else if (this.f24516e.p1() != null && this.f24516e.p1().f13385a != 0) {
                i2 = 3;
            }
            StatisticItem param = new StatisticItem(str).param("tid", this.f24516e.s1()).param("obj_type", i2).param("obj_param1", this.f24516e.Y0).param("obj_source", this.f24516e.X0).param("obj_locate", this.f24517f).param("ab_tag", this.f24516e.Z0).param(TiebaStatic.Params.OBJ_PARAM3, g() > 1.0f ? "1" : "0");
            if (z) {
                param.param(TiebaStatic.Params.OBJ_PARAM2, this.f24516e.n0() > 0 ? "0" : "1");
            }
            return param;
        }
        return (StatisticItem) invokeLZ.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24518g : invokeV.booleanValue;
    }
}
