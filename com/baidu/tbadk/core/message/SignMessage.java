package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SignMessage extends CustomResponsedMessage {
    public int mSignErrorCode;
    public String mSignErrorString;
    public SignData signData;

    public SignMessage(int i, Object obj) {
        super(2001425, obj);
    }

    public void parserJson(NetWork netWork, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                jSONObject2 = jSONObject.optJSONObject("error");
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return;
            }
        }
        if (jSONObject2 != null) {
            this.mSignErrorCode = jSONObject2.optInt("errno");
            this.mSignErrorString = jSONObject2.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
            return;
        }
        this.mSignErrorCode = netWork.getServerErrorCode();
        this.mSignErrorString = netWork.getErrorString();
    }

    public SignMessage(int i) {
        super(2001425);
    }

    public SignMessage() {
        super(2001425);
    }
}
