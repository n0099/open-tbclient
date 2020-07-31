package com.baidu.ar.vo.b;

import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private boolean mR;
    private long mTimestamp;
    private boolean oG;
    private ArrayList<TrackModel> xJ;

    public g(long j) {
        this.mTimestamp = j;
    }

    public void G(boolean z) {
        this.oG = z;
    }

    public void b(ArrayList<TrackModel> arrayList) {
        this.xJ = arrayList;
    }

    public ArrayList<TrackModel> fV() {
        return this.xJ;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTracked(boolean z) {
        this.mR = z;
    }
}
