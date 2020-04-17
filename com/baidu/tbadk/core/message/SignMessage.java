package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.x;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SignMessage extends CustomResponsedMessage {
    public int mSignErrorCode;
    public String mSignErrorString;
    public SignData signData;

    public SignMessage(int i, Object obj) {
        super(CmdConfigCustom.CMD_SIGN_MODEL_TASK, obj);
    }

    public SignMessage(int i) {
        super(CmdConfigCustom.CMD_SIGN_MODEL_TASK);
    }

    public SignMessage() {
        super(CmdConfigCustom.CMD_SIGN_MODEL_TASK);
    }

    public void parserJson(x xVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                jSONObject2 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            } catch (Exception e) {
                BdLog.detailException(e);
                return;
            }
        }
        if (jSONObject2 != null) {
            this.mSignErrorCode = jSONObject2.optInt(BaseJsonData.TAG_ERRNO);
            this.mSignErrorString = jSONObject2.optString("usermsg");
            return;
        }
        this.mSignErrorCode = xVar.getServerErrorCode();
        this.mSignErrorString = xVar.getErrorString();
    }
}
