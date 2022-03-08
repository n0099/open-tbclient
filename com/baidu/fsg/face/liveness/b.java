package com.baidu.fsg.face.liveness;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f32839b;

    /* renamed from: c  reason: collision with root package name */
    public int f32840c;

    /* renamed from: d  reason: collision with root package name */
    public String f32841d;

    /* renamed from: e  reason: collision with root package name */
    public String f32842e;

    /* renamed from: f  reason: collision with root package name */
    public long f32843f;

    /* renamed from: g  reason: collision with root package name */
    public long f32844g;

    /* renamed from: h  reason: collision with root package name */
    public long f32845h;

    /* renamed from: i  reason: collision with root package name */
    public long f32846i;

    /* renamed from: j  reason: collision with root package name */
    public long f32847j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public ArrayList<String> p;
    public StringBuilder q;
    public int r;
    public LivenessRecogDTO s;

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
                return;
            }
        }
        this.f32843f = 0L;
        this.f32844g = 0L;
        this.f32845h = 0L;
        this.p = new ArrayList<>();
        this.q = new StringBuilder();
        this.f32841d = "";
        this.f32842e = "";
    }

    private ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(this.f32846i));
            arrayList.add(String.valueOf(this.f32847j));
            arrayList.add(String.valueOf(this.k));
            arrayList.add(String.valueOf(this.l));
            arrayList.add(String.valueOf(this.m));
            LivenessRecogDTO livenessRecogDTO = this.s;
            arrayList.add(livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void a(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LivenessRecogDTO livenessRecogDTO = this.s;
            String spno = livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "";
            ArrayList arrayList = new ArrayList();
            if (d.t.equals(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.f32839b + "");
                arrayList2.add(this.f32840c + "");
                arrayList2.add(spno);
                RimStatisticsUtil.onEventWithValues(d.t, arrayList2);
            } else if (d.r.equals(str)) {
                RimStatisticsUtil.onEventWithValues(d.r, c());
            } else if (d.s.equals(str)) {
                arrayList.add(b() + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.s, arrayList);
            } else if (d.f32951f.equals(str)) {
                arrayList.add(((System.currentTimeMillis() - this.a) / 1000) + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.f32951f, arrayList);
            } else if (d.u.equals(str)) {
                if (this.o > 0) {
                    str2 = (this.n / this.o) + "";
                } else {
                    str2 = "0";
                }
                arrayList.add(str2);
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.u, arrayList);
            } else if (d.v.equals(str)) {
                if (this.p != null) {
                    StringBuilder sb = this.q;
                    if (sb != null && sb.toString().length() > 1) {
                        ArrayList<String> arrayList3 = this.p;
                        StringBuilder sb2 = this.q;
                        arrayList3.add(sb2.substring(0, sb2.toString().length() - 1));
                    } else {
                        this.p.add("");
                    }
                    this.p.add(this.f32839b + "*" + this.f32840c);
                    this.p.add(spno);
                    RimStatisticsUtil.onEventWithValues(str, this.p);
                }
            } else if (d.l.equals(str)) {
                arrayList.add(this.f32842e);
                arrayList.add(this.f32841d);
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(str, arrayList);
            } else if (d.o.equals(str)) {
                arrayList.add((System.currentTimeMillis() - this.a) + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(str, arrayList);
            }
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            if (this.q == null) {
                this.q = new StringBuilder();
            }
            StringBuilder sb = this.q;
            sb.append(j2);
            sb.append("-");
        }
    }

    private long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long j2 = this.f32845h;
            if (j2 >= 2) {
                return (this.f32844g - this.f32843f) / j2;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f32841d += str;
        }
    }

    public b(LivenessRecogDTO livenessRecogDTO) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {livenessRecogDTO};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32843f = 0L;
        this.f32844g = 0L;
        this.f32845h = 0L;
        this.p = new ArrayList<>();
        this.q = new StringBuilder();
        this.f32841d = "";
        this.f32842e = "";
        this.s = livenessRecogDTO;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f32843f == 0) {
                this.f32843f = System.currentTimeMillis();
            }
            this.f32844g = System.currentTimeMillis();
            this.f32845h++;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.n += j2;
            this.o++;
        }
    }
}
