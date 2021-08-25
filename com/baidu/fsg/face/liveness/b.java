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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f40009a;

    /* renamed from: b  reason: collision with root package name */
    public int f40010b;

    /* renamed from: c  reason: collision with root package name */
    public int f40011c;

    /* renamed from: d  reason: collision with root package name */
    public String f40012d;

    /* renamed from: e  reason: collision with root package name */
    public String f40013e;

    /* renamed from: f  reason: collision with root package name */
    public long f40014f;

    /* renamed from: g  reason: collision with root package name */
    public long f40015g;

    /* renamed from: h  reason: collision with root package name */
    public long f40016h;

    /* renamed from: i  reason: collision with root package name */
    public long f40017i;

    /* renamed from: j  reason: collision with root package name */
    public long f40018j;
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
        this.f40014f = 0L;
        this.f40015g = 0L;
        this.f40016h = 0L;
        this.p = new ArrayList<>();
        this.q = new StringBuilder();
        this.f40012d = "";
        this.f40013e = "";
    }

    private ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(this.f40017i));
            arrayList.add(String.valueOf(this.f40018j));
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
                arrayList2.add(this.f40010b + "");
                arrayList2.add(this.f40011c + "");
                arrayList2.add(spno);
                RimStatisticsUtil.onEventWithValues(d.t, arrayList2);
            } else if (d.r.equals(str)) {
                RimStatisticsUtil.onEventWithValues(d.r, c());
            } else if (d.s.equals(str)) {
                arrayList.add(b() + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.s, arrayList);
            } else if (d.f40128f.equals(str)) {
                arrayList.add(((System.currentTimeMillis() - this.f40009a) / 1000) + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(d.f40128f, arrayList);
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
                    this.p.add(this.f40010b + "*" + this.f40011c);
                    this.p.add(spno);
                    RimStatisticsUtil.onEventWithValues(str, this.p);
                }
            } else if (d.l.equals(str)) {
                arrayList.add(this.f40013e);
                arrayList.add(this.f40012d);
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(str, arrayList);
            } else if (d.o.equals(str)) {
                arrayList.add((System.currentTimeMillis() - this.f40009a) + "");
                arrayList.add(spno);
                RimStatisticsUtil.onEventWithValues(str, arrayList);
            }
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
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
            long j2 = this.f40016h;
            if (j2 >= 2) {
                return (this.f40015g - this.f40014f) / j2;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f40012d += str;
        }
    }

    public void b(FaceTracker.ErrCode errCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, errCode) == null) {
            if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                this.f40013e += "0";
            } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
                this.f40013e += "1";
            } else if (errCode == FaceTracker.ErrCode.LIVENESS_NOT_SUCCEED) {
                this.f40013e += "2";
            } else if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                this.f40013e += "3";
            } else {
                FaceTracker.ErrCode errCode2 = FaceTracker.ErrCode.NO_FACE_DETECTED;
                if (errCode == errCode2) {
                    FaceTracker.ErrCode errCode3 = this.r;
                    if (errCode3 == null) {
                        this.f40013e += "4";
                        this.s = 0;
                    } else if (errCode3 == errCode2) {
                        int i2 = this.s;
                        if (i2 == 3) {
                            this.f40013e += "4";
                            this.s = 0;
                        } else {
                            this.s = i2 + 1;
                        }
                    } else {
                        this.f40013e += "4";
                        this.s = 0;
                    }
                } else if (errCode == FaceTracker.ErrCode.DATA_NOT_READY) {
                    this.f40013e += "5";
                } else if (errCode == FaceTracker.ErrCode.DATA_HIT_ONE) {
                    this.f40013e += "6";
                } else if (errCode == FaceTracker.ErrCode.DATA_HIT_LAST) {
                    this.f40013e += "7";
                } else if (errCode == FaceTracker.ErrCode.UNKNOW_TYPE) {
                    this.f40013e += "8";
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
        this.f40014f = 0L;
        this.f40015g = 0L;
        this.f40016h = 0L;
        this.p = new ArrayList<>();
        this.q = new StringBuilder();
        this.f40012d = "";
        this.f40013e = "";
        this.t = livenessRecogDTO;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f40014f == 0) {
                this.f40014f = System.currentTimeMillis();
            }
            this.f40015g = System.currentTimeMillis();
            this.f40016h++;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.n += j2;
            this.o++;
        }
    }

    public void a(FaceTracker.ErrCode errCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, errCode) == null) {
            if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                this.f40017i++;
            } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
                this.f40018j++;
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
