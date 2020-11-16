package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PollInfo;
/* loaded from: classes.dex */
public class PollData extends n implements Serializable {
    private int endTime;
    private int isMulti;
    private int isPolled;
    private int lastTime;
    private List<PollOptionData> options = new ArrayList();
    private int optionsCount;
    private String polledValue;
    private String title;
    private long totalNum;
    private long totalPoll;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
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
                    for (int i = 0; i < length; i++) {
                        PollOptionData pollOptionData = new PollOptionData();
                        pollOptionData.parserJson(optJSONArray.optJSONObject(i));
                        this.options.add(pollOptionData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtobuf(PollInfo pollInfo) {
        if (pollInfo != null) {
            this.isMulti = pollInfo.is_multi.intValue();
            this.totalNum = pollInfo.total_num.longValue();
            this.optionsCount = pollInfo.options_count.intValue();
            this.isPolled = pollInfo.is_polled.intValue();
            this.polledValue = pollInfo.polled_value;
            this.endTime = pollInfo.end_time.intValue();
            this.totalPoll = pollInfo.total_poll.longValue();
            this.title = pollInfo.title;
            this.lastTime = pollInfo.last_time.intValue();
            if (pollInfo.options != null) {
                int size = pollInfo.options.size();
                for (int i = 0; i < size; i++) {
                    PollOptionData pollOptionData = new PollOptionData();
                    pollOptionData.parserProtobuf(pollInfo.options.get(i));
                    this.options.add(pollOptionData);
                }
            }
        }
    }

    public int getIsMulti() {
        return this.isMulti;
    }

    public void setIsMulti(int i) {
        this.isMulti = i;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(long j) {
        this.totalNum = j;
    }

    public int getOptionsCount() {
        return this.optionsCount;
    }

    public void setOptionsCount(int i) {
        this.optionsCount = i;
    }

    public int getIsPolled() {
        return this.isPolled;
    }

    public void setIsPolled(int i) {
        this.isPolled = i;
    }

    public String getPolledValue() {
        return this.polledValue;
    }

    public void setPolledValue(String str) {
        this.polledValue = str;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public List<PollOptionData> getOptions() {
        return this.options;
    }

    public void setOptions(List<PollOptionData> list) {
        this.options = list;
    }

    public long getTotalPoll() {
        return this.totalPoll;
    }

    public void setTotalPoll(long j) {
        this.totalPoll = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(int i) {
        this.lastTime = i;
    }
}
