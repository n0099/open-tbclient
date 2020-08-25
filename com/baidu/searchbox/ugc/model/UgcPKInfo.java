package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.a.c;
import java.io.Serializable;
/* loaded from: classes11.dex */
public class UgcPKInfo implements NoProGuard, Serializable {
    @c("end_time")
    public String pkEndTime;
    @c("id")
    public String pkID;
    @c("option")
    public PKOption pkOption;
    @c("start_time")
    public String pkStartTime;
    @c("title")
    public String pkTitle;

    /* loaded from: classes11.dex */
    public class PKOption implements NoProGuard, Serializable {
        @c("night_front_color")
        public String nightOptionTextColor;
        @c("background_color")
        public String optionTextBgColor;
        @c("front_color")
        public String optionTextColor;
        @c("id")
        public String pkOptionID;
        @c("name")
        public String pkOptionName;

        public PKOption() {
        }
    }
}
