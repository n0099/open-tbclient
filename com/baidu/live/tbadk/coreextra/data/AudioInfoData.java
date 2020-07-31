package com.baidu.live.tbadk.coreextra.data;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class AudioInfoData extends BaseData implements Serializable {
    private static final long serialVersionUID = -3295150133270063363L;
    private int errorCode;
    private String errorMsg;
    private String errorUserMsg;
    private String voiceId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
                if (optJSONObject != null) {
                    this.errorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                    this.errorMsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG, null);
                    this.errorUserMsg = optJSONObject.optString("usermsg", null);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                if (optJSONObject2 != null) {
                    this.voiceId = optJSONObject2.optString("voice_md5", null);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String getVoiceId() {
        return this.voiceId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorUserMsg() {
        return this.errorUserMsg;
    }
}
