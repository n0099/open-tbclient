package b.a.r0.x0.x1;

import b.a.e.m.e.n;
import b.a.q0.k0.b.b;
import b.a.q0.k0.b.h;
import b.a.q0.s.q.d2;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.StarTrends.DataRes;
import tbclient.StarTrends.StarTrendsResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class a implements b, h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Wire f28092i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f28093e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f28094f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28095g;

    /* renamed from: h  reason: collision with root package name */
    public int f28096h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-434994045, "Lb/a/r0/x0/x1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-434994045, "Lb/a/r0/x0/x1/a;");
                return;
            }
        }
        f28092i = new Wire(new Class[0]);
    }

    public a() {
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
        this.f28093e = new ArrayList<>();
        this.f28094f = new HashMap<>();
    }

    public StarTrendsResIdl a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) f28092i.parseFrom(bArr, StarTrendsResIdl.class);
                if (starTrendsResIdl != null && starTrendsResIdl.data != null) {
                    b(starTrendsResIdl.data);
                }
                return starTrendsResIdl;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (StarTrendsResIdl) invokeL.objValue;
    }

    public final void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f28094f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    d2 d2Var = new d2();
                    d2Var.G4(this.f28094f);
                    d2Var.a3(threadInfo);
                    d2Var.e3();
                    d2Var.I1();
                    if (d2Var.getType() == d2.b3 || d2Var.getType() == d2.y3 || d2Var.getType() == d2.E3 || d2Var.getType() == d2.z3 || d2Var.getType() == d2.I3 || d2Var.getType() == d2.J3) {
                        this.f28093e.add(d2Var);
                    }
                }
            }
        }
        b.a.q0.b.f.a.d(this.f28093e);
        this.f28095g = dataRes.has_more.intValue() == 1;
    }

    @Override // b.a.q0.k0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.q0.k0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.q0.k0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
        }
    }

    @Override // b.a.q0.k0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
        }
    }

    @Override // b.a.q0.k0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }
}
