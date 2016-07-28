package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class bf {
    private String RZ;
    private long Sa;
    private int Sb;
    private int Sc;
    private int Sd;
    private List<String> Se;
    private int Sf;
    private String location;
    private List<String> photoList;
    private int startTime;

    public List<String> rt() {
        return this.photoList;
    }

    public String getActivityName() {
        return this.RZ;
    }

    public long getActivityId() {
        return this.Sa;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int ru() {
        return this.Sb;
    }

    public String getLocation() {
        return this.location;
    }

    public int rv() {
        return this.Sc;
    }

    public int rw() {
        return this.Sd;
    }

    public List<String> rx() {
        return this.Se;
    }

    public int ry() {
        return this.Sf;
    }

    public void a(TogetherHi togetherHi) {
        if (togetherHi != null) {
            this.RZ = togetherHi.album_name;
            this.Sa = togetherHi.album_id.longValue();
            this.startTime = togetherHi.start_time.intValue();
            this.Sb = togetherHi.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Sf = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Sf = 1;
            } else if (this.Sb < currentTimeMillis) {
                this.Sf = 4;
            } else {
                this.Sf = 2;
            }
            this.location = togetherHi.location;
            this.Sc = togetherHi.num_join.intValue();
            this.Sd = togetherHi.num_signup.intValue();
            this.Se = togetherHi.potraits;
            this.photoList = togetherHi.pic_urls;
        }
    }
}
