package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class bj {
    private String UO;
    private long UQ;
    private int UR;
    private int US;
    private int UT;
    private List<String> UU;
    private int UV;
    private String location;
    private List<String> photoList;
    private int startTime;

    public List<String> sy() {
        return this.photoList;
    }

    public String getActivityName() {
        return this.UO;
    }

    public long getActivityId() {
        return this.UQ;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int sz() {
        return this.UR;
    }

    public String getLocation() {
        return this.location;
    }

    public int sA() {
        return this.US;
    }

    public int sB() {
        return this.UT;
    }

    public List<String> sC() {
        return this.UU;
    }

    public int sD() {
        return this.UV;
    }

    public void a(TogetherHi togetherHi) {
        if (togetherHi != null) {
            this.UO = togetherHi.album_name;
            this.UQ = togetherHi.album_id.longValue();
            this.startTime = togetherHi.start_time.intValue();
            this.UR = togetherHi.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.UV = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.UV = 1;
            } else if (this.UR < currentTimeMillis) {
                this.UV = 4;
            } else {
                this.UV = 2;
            }
            this.location = togetherHi.location;
            this.US = togetherHi.num_join.intValue();
            this.UT = togetherHi.num_signup.intValue();
            this.UU = togetherHi.potraits;
            this.photoList = togetherHi.pic_urls;
        }
    }
}
