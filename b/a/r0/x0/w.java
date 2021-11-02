package b.a.r0.x0;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes5.dex */
public class w implements b.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f26491i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f26492e;

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f26493f;

    /* renamed from: g  reason: collision with root package name */
    public String f26494g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26495h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1671347729, "Lb/a/r0/x0/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1671347729, "Lb/a/r0/x0/w;");
                return;
            }
        }
        f26491i = BdUniqueId.gen();
    }

    public w() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26492e = 0;
        this.f26494g = "本吧都在关注";
        this.f26495h = false;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26492e : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26494g : (String) invokeV.objValue;
    }

    public List<MetaData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26493f : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26495h : invokeV.booleanValue;
    }

    @Override // b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f26491i : (BdUniqueId) invokeV.objValue;
    }

    public void h(FeatureCardGod featureCardGod) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, featureCardGod) == null) || featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f26492e = featureCardGod.floor.intValue();
        this.f26493f = featureCardGod.sub_nodes;
        this.f26494g = featureCardGod.title;
    }

    public void i(FrsPageUserExtend frsPageUserExtend) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, frsPageUserExtend) == null) || frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f26492e = frsPageUserExtend.user_extend_storey.intValue();
        this.f26493f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f26493f.add(metaData);
            }
        }
        this.f26494g = frsPageUserExtend.tips;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f26495h = z;
        }
    }
}
