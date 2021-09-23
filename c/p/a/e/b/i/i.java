package c.p.a.e.b.i;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f35209a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f35210b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f35211c;

    /* renamed from: d  reason: collision with root package name */
    public long f35212d;

    /* renamed from: e  reason: collision with root package name */
    public int f35213e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f35214f;

    /* renamed from: g  reason: collision with root package name */
    public int f35215g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f35216h;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iVar, iVar2)) == null) ? (int) (iVar.h() - iVar2.h()) : invokeLL.intValue;
        }
    }

    public i(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AtomicLong atomicLong = new AtomicLong();
        this.f35210b = atomicLong;
        this.f35215g = 0;
        this.f35209a = j2;
        atomicLong.set(j2);
        this.f35211c = j2;
        if (j3 >= j2) {
            this.f35212d = j3;
        } else {
            this.f35212d = -1L;
        }
    }

    public static String b(List<i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            Collections.sort(list, new a());
            StringBuilder sb = new StringBuilder();
            for (i iVar : list) {
                sb.append(iVar);
                sb.append(Part.CRLF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35210b.get() - this.f35209a : invokeV.longValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f35213e = i2;
        }
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long j3 = this.f35209a;
            if (j2 < j3) {
                j2 = j3;
            }
            long j4 = this.f35212d;
            if (j4 > 0) {
                long j5 = j4 + 1;
                if (j2 > j5) {
                    j2 = j5;
                }
            }
            this.f35210b.set(j2);
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = this.f35212d;
            if (j2 >= this.f35209a) {
                return (j2 - l()) + 1;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f35215g = i2;
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f35210b.addAndGet(j2);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35209a : invokeV.longValue;
    }

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            if (j2 >= this.f35209a) {
                this.f35212d = j2;
                return;
            }
            String str = "setEndOffset: endOffset = " + j2 + ", segment = " + this;
            if (j2 == -1) {
                this.f35212d = j2;
            }
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j2 = this.f35210b.get();
            long j3 = this.f35212d;
            if (j3 > 0) {
                long j4 = j3 + 1;
                if (j2 > j4) {
                    return j4;
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || j2 < this.f35210b.get()) {
            return;
        }
        this.f35211c = j2;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            l lVar = this.f35214f;
            if (lVar != null) {
                long r = lVar.r();
                if (r > this.f35211c) {
                    return r;
                }
            }
            return this.f35211c;
        }
        return invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35212d : invokeV.longValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f35213e : invokeV.intValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f35215g++;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f35215g--;
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f35215g : invokeV.intValue;
    }

    public JSONObject r() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = this.f35216h;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.f35216h = jSONObject;
            }
            jSONObject.put("st", h());
            jSONObject.put(com.baidu.fsg.base.statistics.k.f39576b, j());
            jSONObject.put(com.baidu.fsg.base.statistics.h.f39556a, m());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Segment{startOffset=" + this.f35209a + ",\t currentOffset=" + this.f35210b + ",\t currentOffsetRead=" + l() + ",\t endOffset=" + this.f35212d + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        AtomicLong atomicLong = new AtomicLong();
        this.f35210b = atomicLong;
        this.f35215g = 0;
        this.f35209a = iVar.f35209a;
        this.f35212d = iVar.f35212d;
        atomicLong.set(iVar.f35210b.get());
        this.f35211c = this.f35210b.get();
        this.f35213e = iVar.f35213e;
    }

    public i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35210b = new AtomicLong();
        this.f35215g = 0;
        this.f35209a = jSONObject.optLong("st");
        i(jSONObject.optLong(com.baidu.fsg.base.statistics.h.f39556a));
        d(jSONObject.optLong(com.baidu.fsg.base.statistics.k.f39576b));
        k(j());
    }
}
