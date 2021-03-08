package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.data.Config;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes.dex */
public class ad {
    public boolean eOX;
    public boolean eOY;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        int i;
        if (jSONObject != null) {
            this.eOX = jSONObject.optInt("is_bawu") == 1;
            if (Config.BAWU_TYPE_MANAGER.equals(jSONObject.optString("bawu_type"))) {
                i = 1;
            } else {
                i = Config.BAWU_TYPE_ASSIST.equals(jSONObject.optString("bawu_type")) ? 2 : 0;
            }
            this.type = i;
            this.eOY = jSONObject.optInt("is_deleted") == 1;
        }
    }

    public void a(MultiForumPerm multiForumPerm) {
        int i;
        if (multiForumPerm != null) {
            this.eOX = multiForumPerm.is_bawu.intValue() == 1;
            if (Config.BAWU_TYPE_MANAGER.equals(multiForumPerm.bawu_type)) {
                i = 1;
            } else {
                i = Config.BAWU_TYPE_ASSIST.equals(multiForumPerm.bawu_type) ? 2 : 0;
            }
            this.type = i;
            this.eOY = multiForumPerm.is_deleted.intValue() == 1;
        }
    }
}
