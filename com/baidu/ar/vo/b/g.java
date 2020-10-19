package com.baidu.ar.vo.b;

import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
/* loaded from: classes14.dex */
public class g {
    private long mTimestamp;
    private boolean nx;
    private boolean po;
    private ArrayList<TrackModel> yi;

    public g(long j) {
        this.mTimestamp = j;
    }

    public void H(boolean z) {
        this.po = z;
    }

    public void b(ArrayList<TrackModel> arrayList) {
        this.yi = arrayList;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public ArrayList<TrackModel> hk() {
        return this.yi;
    }

    public void setTracked(boolean z) {
        this.nx = z;
    }
}
