package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Abstract;
/* loaded from: classes.dex */
public class AbstractData extends OrmObject implements Serializable {
    public String duringTime;
    public String link;
    public String src;
    public String text;
    public int type;
    public String un;
    public String voiceMD5;

    public void parser(Abstract r2) {
        if (r2 != null) {
            this.type = r2.type.intValue();
            this.text = r2.text;
            this.link = r2.link;
            this.src = r2.src;
            this.un = r2.un;
            this.duringTime = r2.during_time;
            this.voiceMD5 = r2.voice_md5;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = jSONObject.optInt("type", 0);
                this.text = jSONObject.optString("text");
                this.link = jSONObject.optString("link");
                this.src = jSONObject.optString(UserAccountActionItem.KEY_SRC);
                this.un = jSONObject.optString("un");
                this.duringTime = jSONObject.optString("during_time");
                this.voiceMD5 = jSONObject.optString("voice_md5");
            } catch (Throwable th) {
            }
        }
    }
}
