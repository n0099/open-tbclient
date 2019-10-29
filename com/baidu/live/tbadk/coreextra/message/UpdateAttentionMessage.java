package com.baidu.live.tbadk.coreextra.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.BlockPopInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpResponse;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<UpdateAttentionData> {

    /* loaded from: classes6.dex */
    public static class UpdateAttentionData {
        public static final int EACH_ATTENTION = 2;
        public static final int NOT_ATTENTION = 0;
        public static final int SINGLE_ATTENTION = 1;
        public BlockPopInfoData blockData;
        public String blockUrl;
        public String errorString;
        public boolean hasShownForbiddenAlert;
        public boolean isAttention;
        public boolean isSucc;
        public HttpResponse response;
        public JSONObject resultJson;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean isShowMessage = false;
        public int status = 0;

        public void parserJson(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.resultJson = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject(Config.LAUNCH_INFO);
                    if (optJSONObject != null) {
                        this.status = jSONObject.optInt("status");
                        boolean z3 = optJSONObject.optInt("is_toast", 0) == 1;
                        if (!z || !z3) {
                            z2 = false;
                        }
                        this.isShowMessage = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        parseBlockAnti(optJSONObject);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        private void parseBlockAnti(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.blockUrl = jSONObject.optString("block_dealurl");
                String optString = jSONObject.optString("block_content");
                String optString2 = jSONObject.optString("block_confirm");
                String optString3 = jSONObject.optString("block_cancel");
                if (!StringHelper.isEmpty(optString) && !StringHelper.isEmpty(this.blockUrl) && !StringHelper.isEmpty(optString2) && !StringHelper.isEmpty(optString3)) {
                    this.blockData = new BlockPopInfoData();
                    this.blockData.block_info = optString;
                    this.blockData.ahead_url = this.blockUrl;
                    this.blockData.ahead_info = optString2;
                    this.blockData.ok_info = optString3;
                }
            }
        }
    }

    public UpdateAttentionMessage(UpdateAttentionData updateAttentionData) {
        super(CmdConfigCustom.CMD_UPDATE_ATTENTION, updateAttentionData);
    }

    public boolean isSucc() {
        if (getData() == null || !(getData() instanceof UpdateAttentionData)) {
            return false;
        }
        return getData().isSucc;
    }

    public boolean isAttention() {
        if (getData() == null || !(getData() instanceof UpdateAttentionData)) {
            return false;
        }
        return getData().isAttention;
    }

    public boolean isGod() {
        if (getData() == null || !(getData() instanceof UpdateAttentionData)) {
            return false;
        }
        return getData().isGod;
    }
}
