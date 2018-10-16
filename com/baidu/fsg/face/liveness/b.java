package com.baidu.fsg.face.liveness;

import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.idl.facesdk.FaceTracker;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    public long a;
    public int b;
    public int c;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private FaceTracker.ErrCode r;
    private int s;
    private LivenessRecogDTO t;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private ArrayList<String> p = new ArrayList<>();
    private StringBuilder q = new StringBuilder();
    public String d = "";
    public String e = "";

    private b() {
    }

    public b(LivenessRecogDTO livenessRecogDTO) {
        this.t = livenessRecogDTO;
    }

    public void a(String str) {
        String spno = this.t != null ? this.t.getSpno() : "";
        ArrayList arrayList = new ArrayList();
        if (d.t.equals(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.b + "");
            arrayList2.add(this.c + "");
            arrayList2.add(spno);
            RimStatisticsUtil.onEventWithValues(d.t, arrayList2);
        } else if (d.r.equals(str)) {
            RimStatisticsUtil.onEventWithValues(d.r, c());
        } else if (d.s.equals(str)) {
            arrayList.add(b() + "");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(d.s, arrayList);
        } else if (d.f.equals(str)) {
            arrayList.add(((System.currentTimeMillis() - this.a) / 1000) + "");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(d.f, arrayList);
        } else if (d.u.equals(str)) {
            arrayList.add(this.o > 0 ? (this.n / this.o) + "" : "0");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(d.u, arrayList);
        } else if (d.v.equals(str)) {
            if (this.p != null) {
                if (this.q != null && this.q.toString().length() > 1) {
                    this.p.add(this.q.substring(0, this.q.toString().length() - 1));
                } else {
                    this.p.add("");
                }
                this.p.add(this.b + "*" + this.c);
                this.p.add(spno);
                RimStatisticsUtil.onEventWithValues(str, this.p);
            }
        } else if (d.l.equals(str)) {
            arrayList.add(this.e);
            arrayList.add(this.d);
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(str, arrayList);
        } else if (d.o.equals(str)) {
            arrayList.add((System.currentTimeMillis() - this.a) + "");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(str, arrayList);
        }
    }

    public void a() {
        if (this.f == 0) {
            this.f = System.currentTimeMillis();
        }
        this.g = System.currentTimeMillis();
        this.h++;
    }

    public void a(long j) {
        this.n += j;
        this.o++;
    }

    public void b(long j) {
        if (this.q == null) {
            this.q = new StringBuilder();
        }
        this.q.append(j).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public void a(FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            this.i++;
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

    private long b() {
        if (this.h >= 2) {
            return (this.g - this.f) / this.h;
        }
        return 0L;
    }

    private ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(this.i));
        arrayList.add(String.valueOf(this.j));
        arrayList.add(String.valueOf(this.k));
        arrayList.add(String.valueOf(this.l));
        arrayList.add(String.valueOf(this.m));
        arrayList.add(this.t != null ? this.t.getSpno() : "");
        return arrayList;
    }

    public void b(String str) {
        this.d += str;
    }

    public void b(FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            this.e += "0";
        } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
            this.e += "1";
        } else if (errCode == FaceTracker.ErrCode.LIVENESS_NOT_SUCCEED) {
            this.e += "2";
        } else if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
            this.e += "3";
        } else if (errCode == FaceTracker.ErrCode.NO_FACE_DETECTED) {
            if (this.r == null) {
                this.e += "4";
                this.s = 0;
            } else if (this.r == FaceTracker.ErrCode.NO_FACE_DETECTED) {
                if (this.s == 3) {
                    this.e += "4";
                    this.s = 0;
                } else {
                    this.s++;
                }
            } else {
                this.e += "4";
                this.s = 0;
            }
        } else if (errCode == FaceTracker.ErrCode.DATA_NOT_READY) {
            this.e += "5";
        } else if (errCode == FaceTracker.ErrCode.DATA_HIT_ONE) {
            this.e += com.tencent.connect.common.Constants.VIA_SHARE_TYPE_INFO;
        } else if (errCode == FaceTracker.ErrCode.DATA_HIT_LAST) {
            this.e += "7";
        } else if (errCode == FaceTracker.ErrCode.UNKNOW_TYPE) {
            this.e += com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
        }
        this.r = errCode;
    }
}
