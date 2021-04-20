package com.baidu.fsg.face.liveness;

import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.idl.facesdk.FaceTracker;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f5905a;

    /* renamed from: b  reason: collision with root package name */
    public int f5906b;

    /* renamed from: c  reason: collision with root package name */
    public int f5907c;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public FaceTracker.ErrCode r;
    public int s;
    public LivenessRecogDTO t;

    /* renamed from: f  reason: collision with root package name */
    public long f5910f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f5911g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f5912h = 0;
    public ArrayList<String> p = new ArrayList<>();
    public StringBuilder q = new StringBuilder();

    /* renamed from: d  reason: collision with root package name */
    public String f5908d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f5909e = "";

    public b() {
    }

    private ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(this.i));
        arrayList.add(String.valueOf(this.j));
        arrayList.add(String.valueOf(this.k));
        arrayList.add(String.valueOf(this.l));
        arrayList.add(String.valueOf(this.m));
        LivenessRecogDTO livenessRecogDTO = this.t;
        arrayList.add(livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
        return arrayList;
    }

    public void a(String str) {
        String str2;
        LivenessRecogDTO livenessRecogDTO = this.t;
        String spno = livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "";
        ArrayList arrayList = new ArrayList();
        if (d.t.equals(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f5906b + "");
            arrayList2.add(this.f5907c + "");
            arrayList2.add(spno);
            RimStatisticsUtil.onEventWithValues(d.t, arrayList2);
        } else if (d.r.equals(str)) {
            RimStatisticsUtil.onEventWithValues(d.r, c());
        } else if (d.s.equals(str)) {
            arrayList.add(b() + "");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(d.s, arrayList);
        } else if (d.f6014f.equals(str)) {
            arrayList.add(((System.currentTimeMillis() - this.f5905a) / 1000) + "");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(d.f6014f, arrayList);
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
                this.p.add(this.f5906b + "*" + this.f5907c);
                this.p.add(spno);
                RimStatisticsUtil.onEventWithValues(str, this.p);
            }
        } else if (d.l.equals(str)) {
            arrayList.add(this.f5909e);
            arrayList.add(this.f5908d);
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(str, arrayList);
        } else if (d.o.equals(str)) {
            arrayList.add((System.currentTimeMillis() - this.f5905a) + "");
            arrayList.add(spno);
            RimStatisticsUtil.onEventWithValues(str, arrayList);
        }
    }

    public void b(long j) {
        if (this.q == null) {
            this.q = new StringBuilder();
        }
        StringBuilder sb = this.q;
        sb.append(j);
        sb.append("-");
    }

    private long b() {
        long j = this.f5912h;
        if (j >= 2) {
            return (this.f5911g - this.f5910f) / j;
        }
        return 0L;
    }

    public void b(String str) {
        this.f5908d += str;
    }

    public void b(FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            this.f5909e += "0";
        } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
            this.f5909e += "1";
        } else if (errCode == FaceTracker.ErrCode.LIVENESS_NOT_SUCCEED) {
            this.f5909e += "2";
        } else if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
            this.f5909e += "3";
        } else {
            FaceTracker.ErrCode errCode2 = FaceTracker.ErrCode.NO_FACE_DETECTED;
            if (errCode == errCode2) {
                FaceTracker.ErrCode errCode3 = this.r;
                if (errCode3 == null) {
                    this.f5909e += "4";
                    this.s = 0;
                } else if (errCode3 == errCode2) {
                    int i = this.s;
                    if (i == 3) {
                        this.f5909e += "4";
                        this.s = 0;
                    } else {
                        this.s = i + 1;
                    }
                } else {
                    this.f5909e += "4";
                    this.s = 0;
                }
            } else if (errCode == FaceTracker.ErrCode.DATA_NOT_READY) {
                this.f5909e += "5";
            } else if (errCode == FaceTracker.ErrCode.DATA_HIT_ONE) {
                this.f5909e += "6";
            } else if (errCode == FaceTracker.ErrCode.DATA_HIT_LAST) {
                this.f5909e += "7";
            } else if (errCode == FaceTracker.ErrCode.UNKNOW_TYPE) {
                this.f5909e += "8";
            }
        }
        this.r = errCode;
    }

    public b(LivenessRecogDTO livenessRecogDTO) {
        this.t = livenessRecogDTO;
    }

    public void a() {
        if (this.f5910f == 0) {
            this.f5910f = System.currentTimeMillis();
        }
        this.f5911g = System.currentTimeMillis();
        this.f5912h++;
    }

    public void a(long j) {
        this.n += j;
        this.o++;
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
}
