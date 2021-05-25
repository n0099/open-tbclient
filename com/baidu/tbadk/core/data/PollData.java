package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.q.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PollInfo;
import tbclient.PollOption;
/* loaded from: classes3.dex */
public class PollData extends o implements Serializable {
    public int endTime;
    public int isMulti;
    public int isPolled;
    public int lastTime;
    public List<PollOptionData> options = new ArrayList();
    public int optionsCount;
    public String polledValue;
    public String title;
    public long totalNum;
    public long totalPoll;

    public int getEndTime() {
        return this.endTime;
    }

    public int getIsMulti() {
        return this.isMulti;
    }

    public int getIsPolled() {
        return this.isPolled;
    }

    public int getLastTime() {
        return this.lastTime;
    }

    public List<PollOptionData> getOptions() {
        return this.options;
    }

    public int getOptionsCount() {
        return this.optionsCount;
    }

    public String getPolledValue() {
        return this.polledValue;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public long getTotalPoll() {
        return this.totalPoll;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.isMulti = jSONObject.optInt("is_multi", 0);
            this.totalPoll = jSONObject.optLong("total_num", 0L);
            this.optionsCount = jSONObject.optInt("options_count", 0);
            this.isPolled = jSONObject.optInt("is_polled", 0);
            this.polledValue = jSONObject.optString("polled_value", "");
            this.endTime = jSONObject.optInt("end_time", 0);
            this.totalPoll = jSONObject.optLong("total_poll", 0L);
            this.title = jSONObject.optString("title", "");
            this.lastTime = jSONObject.optInt("last_time", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    PollOptionData pollOptionData = new PollOptionData();
                    pollOptionData.parserJson(optJSONArray.optJSONObject(i2));
                    this.options.add(pollOptionData);
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtobuf(PollInfo pollInfo) {
        if (pollInfo == null) {
            return;
        }
        this.isMulti = pollInfo.is_multi.intValue();
        this.totalNum = pollInfo.total_num.longValue();
        this.optionsCount = pollInfo.options_count.intValue();
        this.isPolled = pollInfo.is_polled.intValue();
        this.polledValue = pollInfo.polled_value;
        this.endTime = pollInfo.end_time.intValue();
        this.totalPoll = pollInfo.total_poll.longValue();
        this.title = pollInfo.title;
        this.lastTime = pollInfo.last_time.intValue();
        List<PollOption> list = pollInfo.options;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PollOptionData pollOptionData = new PollOptionData();
                pollOptionData.parserProtobuf(pollInfo.options.get(i2));
                this.options.add(pollOptionData);
            }
        }
    }

    public void setEndTime(int i2) {
        this.endTime = i2;
    }

    public void setIsMulti(int i2) {
        this.isMulti = i2;
    }

    public void setIsPolled(int i2) {
        this.isPolled = i2;
    }

    public void setLastTime(int i2) {
        this.lastTime = i2;
    }

    public void setOptions(List<PollOptionData> list) {
        this.options = list;
    }

    public void setOptionsCount(int i2) {
        this.optionsCount = i2;
    }

    public void setPolledValue(String str) {
        this.polledValue = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalNum(long j) {
        this.totalNum = j;
    }

    public void setTotalPoll(long j) {
        this.totalPoll = j;
    }
}
