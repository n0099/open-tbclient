package c.a.t0.e1.y1;

import c.a.d.n.e.n;
import c.a.s0.l0.b.b;
import c.a.s0.l0.b.h;
import c.a.s0.s.q.e2;
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
/* loaded from: classes7.dex */
public class a implements b, h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Wire f17130i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f17131e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f17132f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17133g;

    /* renamed from: h  reason: collision with root package name */
    public int f17134h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-386575749, "Lc/a/t0/e1/y1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-386575749, "Lc/a/t0/e1/y1/a;");
                return;
            }
        }
        f17130i = new Wire(new Class[0]);
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
        this.f17131e = new ArrayList<>();
        this.f17132f = new HashMap<>();
    }

    public StarTrendsResIdl a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) f17130i.parseFrom(bArr, StarTrendsResIdl.class);
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
                        this.f17132f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.J4(this.f17132f);
                    e2Var.d3(threadInfo);
                    e2Var.h3();
                    e2Var.K1();
                    if (e2Var.getType() == e2.j3 || e2Var.getType() == e2.G3 || e2Var.getType() == e2.M3 || e2Var.getType() == e2.H3 || e2Var.getType() == e2.Q3 || e2Var.getType() == e2.R3) {
                        this.f17131e.add(e2Var);
                    }
                }
            }
        }
        c.a.s0.b.f.a.d(this.f17131e);
        this.f17133g = dataRes.has_more.intValue() == 1;
    }

    @Override // c.a.s0.l0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.l0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.l0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
        }
    }

    @Override // c.a.s0.l0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
        }
    }

    @Override // c.a.s0.l0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }
}
