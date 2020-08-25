package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.TwZhiBoAnti;
/* loaded from: classes2.dex */
public class TwzhiboAnti implements Serializable {
    public static final int ERROR = 0;
    public static final int OK = 1;
    private int can_add_live_post = 0;
    private int can_del_live_post = 0;
    private int canShowPBHeadline = 0;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.can_add_live_post = jSONObject.optInt("can_add_live_post", 0);
                this.can_del_live_post = jSONObject.optInt("can_del_live_post", 0);
                this.canShowPBHeadline = jSONObject.optInt("can_show_pb_headline", 0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void parserProtobuf(TwZhiBoAnti twZhiBoAnti) {
        if (twZhiBoAnti != null) {
            this.can_add_live_post = twZhiBoAnti.can_add_live_post.intValue();
            this.can_del_live_post = twZhiBoAnti.can_del_live_post.intValue();
            this.canShowPBHeadline = twZhiBoAnti.can_show_pb_headline.intValue();
        }
    }

    public int getCan_add_live_post() {
        return this.can_add_live_post;
    }

    public int getCan_del_live_post() {
        return this.can_del_live_post;
    }

    public int getCanShowPBHeadline() {
        return this.canShowPBHeadline;
    }
}
