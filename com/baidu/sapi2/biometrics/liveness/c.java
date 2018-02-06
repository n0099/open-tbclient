package com.baidu.sapi2.biometrics.liveness;

import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.idl.facesdk.FaceTracker;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    public long a;
    public int b;
    public int c;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private ArrayList<String> n = new ArrayList<>();

    public void a(String str) {
        if (f.r.equals(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.b + "");
            arrayList.add(this.c + "");
            LogUtil.d("hello", "previewsize.width and height:  " + arrayList.toString());
            RimStatisticsUtil.onEventWithValues(f.r, arrayList);
        } else if (f.p.equals(str)) {
            RimStatisticsUtil.onEventWithValues(f.p, c());
            LogUtil.d("hello", "onEventEndWithValues(StatServiceEvent.PREPARERESULT):  idlSDK错误码：  " + c().toString());
        } else if (f.q.equals(str)) {
            RimStatisticsUtil.onEventWithValue(f.q, b() + "");
            LogUtil.d("hello", "onEventEndWithValue(StatServiceEvent.CAMERACALLBACK):  相机回调平均频率（ms）：  " + b());
        } else if (f.e.equals(str)) {
            long currentTimeMillis = (System.currentTimeMillis() - this.a) / 1000;
            RimStatisticsUtil.onEventWithValue(f.e, currentTimeMillis + "");
            LogUtil.d("hello", "onEventWithValue(StatServiceEvent.PASSLIVENESS):  活体通过整个流程的时间  " + currentTimeMillis);
        } else if (f.s.equals(str)) {
            RimStatisticsUtil.onEventWithValue(f.s, this.m > 0 ? (this.l / this.m) + "" : "0");
        } else if (f.t.equals(str) && this.n != null && this.n.size() > 0) {
            RimStatisticsUtil.onEventWithValues(str, this.n);
        }
    }

    public void a() {
        if (this.d == 0) {
            this.d = System.currentTimeMillis();
        }
        this.e = System.currentTimeMillis();
        this.f++;
    }

    public void a(long j) {
        this.l += j;
        this.m++;
    }

    public void b(long j) {
        if (this.n == null) {
            this.n = new ArrayList<>();
        }
        this.n.add(String.valueOf(j));
    }

    public void a(FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            this.g++;
        } else if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
            this.h++;
        } else if (errCode == FaceTracker.ErrCode.LIVENESS_NOT_SUCCEED) {
            this.i++;
        } else if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
            this.j++;
        } else if (errCode == FaceTracker.ErrCode.DATA_NOT_READY) {
            this.k++;
            LogUtil.d("hello", "ErrCode.DATA_NOT_READY");
        }
    }

    private long b() {
        if (this.f >= 2) {
            return (this.e - this.d) / this.f;
        }
        return 0L;
    }

    private ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(this.g));
        arrayList.add(String.valueOf(this.h));
        arrayList.add(String.valueOf(this.i));
        arrayList.add(String.valueOf(this.j));
        arrayList.add(String.valueOf(this.k));
        return arrayList;
    }
}
