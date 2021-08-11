package c.a.p0.v0.l1;

import c.a.e.k.e.n;
import c.a.o0.i0.b.b;
import c.a.o0.i0.b.h;
import c.a.o0.s.q.c2;
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
/* loaded from: classes4.dex */
public class a implements b, h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Wire f26039i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f26040e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f26041f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26042g;

    /* renamed from: h  reason: collision with root package name */
    public int f26043h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1169757560, "Lc/a/p0/v0/l1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1169757560, "Lc/a/p0/v0/l1/a;");
                return;
            }
        }
        f26039i = new Wire(new Class[0]);
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
        this.f26040e = new ArrayList<>();
        this.f26041f = new HashMap<>();
    }

    public StarTrendsResIdl a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) f26039i.parseFrom(bArr, StarTrendsResIdl.class);
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
                        this.f26041f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    c2 c2Var = new c2();
                    c2Var.u4(this.f26041f);
                    c2Var.S2(threadInfo);
                    c2Var.W2();
                    c2Var.E1();
                    if (c2Var.getType() == c2.W2 || c2Var.getType() == c2.s3 || c2Var.getType() == c2.y3 || c2Var.getType() == c2.t3 || c2Var.getType() == c2.C3 || c2Var.getType() == c2.D3) {
                        this.f26040e.add(c2Var);
                    }
                }
            }
        }
        c.a.o0.b.f.a.d(this.f26040e);
        this.f26042g = dataRes.has_more.intValue() == 1;
    }

    @Override // c.a.o0.i0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.i0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.i0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
        }
    }

    @Override // c.a.o0.i0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
        }
    }

    @Override // c.a.o0.i0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }
}
