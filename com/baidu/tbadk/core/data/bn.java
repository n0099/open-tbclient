package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class bn {
    private int VA;
    private int VB;
    private List<String> VC;
    private int VD;
    private String Vx;
    private long Vy;
    private int Vz;
    private String location;
    private List<String> photoList;
    private int startTime;

    public List<String> sR() {
        return this.photoList;
    }

    public String getActivityName() {
        return this.Vx;
    }

    public long getActivityId() {
        return this.Vy;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int sS() {
        return this.Vz;
    }

    public String getLocation() {
        return this.location;
    }

    public int sT() {
        return this.VA;
    }

    public int sU() {
        return this.VB;
    }

    public List<String> sV() {
        return this.VC;
    }

    public int sW() {
        return this.VD;
    }

    public void a(TogetherHi togetherHi) {
        if (togetherHi != null) {
            this.Vx = togetherHi.album_name;
            this.Vy = togetherHi.album_id.longValue();
            this.startTime = togetherHi.start_time.intValue();
            this.Vz = togetherHi.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.VD = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.VD = 1;
            } else if (this.Vz < currentTimeMillis) {
                this.VD = 4;
            } else {
                this.VD = 2;
            }
            this.location = togetherHi.location;
            this.VA = togetherHi.num_join.intValue();
            this.VB = togetherHi.num_signup.intValue();
            this.VC = togetherHi.potraits;
            this.photoList = togetherHi.pic_urls;
        }
    }
}
