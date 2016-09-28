package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class bl {
    private String UZ;
    private long Va;
    private int Vb;
    private int Vc;
    private int Vd;
    private List<String> Ve;
    private int Vf;
    private String location;
    private List<String> photoList;
    private int startTime;

    public List<String> sN() {
        return this.photoList;
    }

    public String getActivityName() {
        return this.UZ;
    }

    public long getActivityId() {
        return this.Va;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int sO() {
        return this.Vb;
    }

    public String getLocation() {
        return this.location;
    }

    public int sP() {
        return this.Vc;
    }

    public int sQ() {
        return this.Vd;
    }

    public List<String> sR() {
        return this.Ve;
    }

    public int sS() {
        return this.Vf;
    }

    public void a(TogetherHi togetherHi) {
        if (togetherHi != null) {
            this.UZ = togetherHi.album_name;
            this.Va = togetherHi.album_id.longValue();
            this.startTime = togetherHi.start_time.intValue();
            this.Vb = togetherHi.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Vf = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Vf = 1;
            } else if (this.Vb < currentTimeMillis) {
                this.Vf = 4;
            } else {
                this.Vf = 2;
            }
            this.location = togetherHi.location;
            this.Vc = togetherHi.num_join.intValue();
            this.Vd = togetherHi.num_signup.intValue();
            this.Ve = togetherHi.potraits;
            this.photoList = togetherHi.pic_urls;
        }
    }
}
