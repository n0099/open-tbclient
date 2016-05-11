package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class ay {
    private String QX;
    private long QY;
    private int QZ;
    private int Ra;
    private int Rb;
    private List<String> Rc;
    private int Rd;
    private String location;
    private List<String> photoList;
    private int startTime;

    public List<String> rv() {
        return this.photoList;
    }

    public String getActivityName() {
        return this.QX;
    }

    public long getActivityId() {
        return this.QY;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int rw() {
        return this.QZ;
    }

    public String getLocation() {
        return this.location;
    }

    public int rx() {
        return this.Ra;
    }

    public int ry() {
        return this.Rb;
    }

    public List<String> rz() {
        return this.Rc;
    }

    public int rA() {
        return this.Rd;
    }

    public void a(TogetherHi togetherHi) {
        if (togetherHi != null) {
            this.QX = togetherHi.album_name;
            this.QY = togetherHi.album_id.longValue();
            this.startTime = togetherHi.start_time.intValue();
            this.QZ = togetherHi.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Rd = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Rd = 1;
            } else if (this.QZ < currentTimeMillis) {
                this.Rd = 4;
            } else {
                this.Rd = 2;
            }
            this.location = togetherHi.location;
            this.Ra = togetherHi.num_join.intValue();
            this.Rb = togetherHi.num_signup.intValue();
            this.Rc = togetherHi.potraits;
            this.photoList = togetherHi.pic_urls;
        }
    }
}
