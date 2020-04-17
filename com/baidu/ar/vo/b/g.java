package com.baidu.ar.vo.b;

import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private long mTimestamp;
    private boolean mu;
    private boolean oh;
    private ArrayList<TrackModel> xj;

    public g(long j) {
        this.mTimestamp = j;
    }

    public void G(boolean z) {
        this.oh = z;
    }

    public void b(ArrayList<TrackModel> arrayList) {
        this.xj = arrayList;
    }

    public ArrayList<TrackModel> fF() {
        return this.xj;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTracked(boolean z) {
        this.mu = z;
    }
}
