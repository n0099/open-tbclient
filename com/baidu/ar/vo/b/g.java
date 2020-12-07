package com.baidu.ar.vo.b;

import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class g {
    private long mTimestamp;
    private boolean nN;
    private boolean pE;
    private ArrayList<TrackModel> yX;

    public g(long j) {
        this.mTimestamp = j;
    }

    public void F(boolean z) {
        this.pE = z;
    }

    public void b(ArrayList<TrackModel> arrayList) {
        this.yX = arrayList;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public ArrayList<TrackModel> hk() {
        return this.yX;
    }

    public void setTracked(boolean z) {
        this.nN = z;
    }
}
