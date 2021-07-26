package com.baidu.fsg.face.liveness;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f5936a;

    /* renamed from: b  reason: collision with root package name */
    public int f5937b;

    /* renamed from: c  reason: collision with root package name */
    public int f5938c;

    /* renamed from: d  reason: collision with root package name */
    public String f5939d;

    /* renamed from: e  reason: collision with root package name */
    public String f5940e;

    /* renamed from: f  reason: collision with root package name */
    public long f5941f;

    /* renamed from: g  reason: collision with root package name */
    public long f5942g;

    /* renamed from: h  reason: collision with root package name */
    public long f5943h;

    /* renamed from: i  reason: collision with root package name */
    public long f5944i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public ArrayList<String> p;
    public StringBuilder q;
    public FaceTracker.ErrCode r;
    public int s;
    public LivenessRecogDTO t;

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
        this.f5941f = 0L;
        this.f5942g = 0L;
        this.f5943h = 0L;
        this.p = new ArrayList<>();
        this.q = new StringBuilder();
        this.f5939d = "";
        this.f5940e = "";
    }

    private ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(this.f5944i));
            arrayList.add(String.valueOf(this.j));
            arrayList.add(String.valueOf(this.k));
            arrayList.add(String.valueOf(this.l));
            arrayList.add(String.valueOf(this.m));
            LivenessRecogDTO livenessRecogDTO = this.t;
            arrayList.add(livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void a(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            LivenessRecogDTO livenessRecogDTO = this.t;
            String spno = livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "";
            ArrayList arrayList = new ArrayList();
            if (d.t.equals(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.f5937b + "");
                arrayList2.add(this.f5938c + "");
                arrayList2.add(spno);
                RimStatisticsUtil.onEventWithValues(d.t, arrayList2);
            } else if (d.r.equals(str)) {
                RimStatisticsUtil.onEventWithValues(d.r, c());
            } else if (d.s.equals(str)) {
                arrayList.add(b() + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.s, arrayList);
            } else if (d.f6050f.equals(str)) {
                arrayList.add(((System.currentTimeMillis() - this.f5936a) / 1000) + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.f6050f, arrayList);
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
                    this.p.add(this.f5937b + "*" + this.f5938c);
                    this.p.add(spno);
                    RimStatisticsUtil.onEventWithValues(str, this.p);
                }
            } else if (d.l.equals(str)) {
                arrayList.add(this.f5940e);
                arrayList.add(this.f5939d);
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(str, arrayList);
            } else if (d.o.equals(str)) {
                arrayList.add((System.currentTimeMillis() - this.f5936a) + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(str, arrayList);
            }
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            if (this.q == null) {
                this.q = new StringBuilder();
            }
            StringBuilder sb = this.q;
            sb.append(j);
            sb.append("-");
        }
    }

    private long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long j = this.f5943h;
            if (j >= 2) {
                return (this.f5942g - this.f5941f) / j;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f5939d += str;
        }
    }

    public void b(FaceTracker.ErrCode errCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, errCode) == null) {
            if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                this.f5940e += "0";
            } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
                this.f5940e += "1";
            } else if (errCode == FaceTracker.ErrCode.LIVENESS_NOT_SUCCEED) {
                this.f5940e += "2";
            } else if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                this.f5940e += "3";
            } else {
                FaceTracker.ErrCode errCode2 = FaceTracker.ErrCode.NO_FACE_DETECTED;
                if (errCode == errCode2) {
                    FaceTracker.ErrCode errCode3 = this.r;
                    if (errCode3 == null) {
                        this.f5940e += "4";
                        this.s = 0;
                    } else if (errCode3 == errCode2) {
                        int i2 = this.s;
                        if (i2 == 3) {
                            this.f5940e += "4";
                            this.s = 0;
                        } else {
                            this.s = i2 + 1;
                        }
                    } else {
                        this.f5940e += "4";
                        this.s = 0;
                    }
                } else if (errCode == FaceTracker.ErrCode.DATA_NOT_READY) {
                    this.f5940e += "5";
                } else if (errCode == FaceTracker.ErrCode.DATA_HIT_ONE) {
                    this.f5940e += "6";
                } else if (errCode == FaceTracker.ErrCode.DATA_HIT_LAST) {
                    this.f5940e += "7";
                } else if (errCode == FaceTracker.ErrCode.UNKNOW_TYPE) {
                    this.f5940e += "8";
                }
            }
            this.r = errCode;
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
        this.f5941f = 0L;
        this.f5942g = 0L;
        this.f5943h = 0L;
        this.p = new ArrayList<>();
        this.q = new StringBuilder();
        this.f5939d = "";
        this.f5940e = "";
        this.t = livenessRecogDTO;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f5941f == 0) {
                this.f5941f = System.currentTimeMillis();
            }
            this.f5942g = System.currentTimeMillis();
            this.f5943h++;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.n += j;
            this.o++;
        }
    }

    public void a(FaceTracker.ErrCode errCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, errCode) == null) {
            if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                this.f5944i++;
            } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
                this.j++;
            } else if (errCode == FaceTracker.ErrCode.LIVENESS_NOT_SUCCEED) {
                this.k++;
            } else if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                this.l++;
            } else if (errCode == FaceTracker.ErrCode.DATA_NOT_READY) {
                this.m++;
                LogUtil.d("hello", "ErrCode.DATA_NOT_READY");
            }
        }
    }
}
