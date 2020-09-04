package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class PollOptionData extends m implements Serializable {
    private int id;
    private long num;
    private String text;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optInt("id", 0);
                this.num = jSONObject.optLong("num", 0L);
                this.text = jSONObject.optString("text", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtobuf(PollOption pollOption) {
        if (pollOption != null) {
            this.id = pollOption.id.intValue();
            this.num = pollOption.num.longValue();
            this.text = pollOption.text;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public long getNum() {
        return this.num;
    }

    public void setNum(long j) {
        this.num = j;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }
}
