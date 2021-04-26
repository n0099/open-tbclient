package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import d.a.i0.r.q.o;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PollOption;
/* loaded from: classes3.dex */
public class PollOptionData extends o implements Serializable {
    public int id;
    public long num;
    public String text;

    public int getId() {
        return this.id;
    }

    public long getNum() {
        return this.num;
    }

    public String getText() {
        return this.text;
    }

    @Override // d.a.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.id = jSONObject.optInt("id", 0);
            this.num = jSONObject.optLong("num", 0L);
            this.text = jSONObject.optString("text", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtobuf(PollOption pollOption) {
        if (pollOption == null) {
            return;
        }
        this.id = pollOption.id.intValue();
        this.num = pollOption.num.longValue();
        this.text = pollOption.text;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setNum(long j) {
        this.num = j;
    }

    public void setText(String str) {
        this.text = str;
    }
}
