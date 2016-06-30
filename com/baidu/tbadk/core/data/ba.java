package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class ba {
    private String Rp;
    private long Rq;
    private int Rr;
    private int Rs;
    private int Rt;
    private List<String> Ru;
    private int Rv;
    private String location;
    private List<String> photoList;
    private int startTime;

    public List<String> ru() {
        return this.photoList;
    }

    public String getActivityName() {
        return this.Rp;
    }

    public long getActivityId() {
        return this.Rq;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int rv() {
        return this.Rr;
    }

    public String getLocation() {
        return this.location;
    }

    public int rw() {
        return this.Rs;
    }

    public int rx() {
        return this.Rt;
    }

    public List<String> ry() {
        return this.Ru;
    }

    public int rz() {
        return this.Rv;
    }

    public void a(TogetherHi togetherHi) {
        if (togetherHi != null) {
            this.Rp = togetherHi.album_name;
            this.Rq = togetherHi.album_id.longValue();
            this.startTime = togetherHi.start_time.intValue();
            this.Rr = togetherHi.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Rv = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Rv = 1;
            } else if (this.Rr < currentTimeMillis) {
                this.Rv = 4;
            } else {
                this.Rv = 2;
            }
            this.location = togetherHi.location;
            this.Rs = togetherHi.num_join.intValue();
            this.Rt = togetherHi.num_signup.intValue();
            this.Ru = togetherHi.potraits;
            this.photoList = togetherHi.pic_urls;
        }
    }
}
