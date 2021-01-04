package com.baidu.live.tbadk.coreextra.message;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.BlockPopInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpResponse;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<UpdateAttentionData> {
    public boolean comeFromHost;

    /* loaded from: classes11.dex */
    public static class UpdateAttentionData {
        public static final int AUTO_OPEN_FALSE = 2;
        public static final int AUTO_OPEN_FIRSTTIME = 3;
        public static final int AUTO_OPEN_TRUE = 1;
        public static final int EACH_ATTENTION = 2;
        public static final int NOT_ATTENTION = 0;
        public static final int SHOW_POP_FALSE = 2;
        public static final int SHOW_POP_TRUE = 1;
        public static final int SINGLE_ATTENTION = 1;
        public BlockPopInfoData blockData;
        public String blockUrl;
        public String errmsg;
        @Deprecated
        public int errorCode;
        @Deprecated
        public String errorString;
        public boolean hasShownForbiddenAlert;
        public boolean isAttention;
        public boolean isSucc;
        public HttpResponse response;
        public JSONObject resultJson;
        public String showMsg;
        public String toUid;
        public String usermsg;
        public boolean isGod = false;
        public boolean isShowMessage = false;
        public int status = 0;
        public int autoOpenStatus = 1;
        public boolean showPop = false;
        public int errno = 0;

        public void parserJson(String str, boolean z) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.resultJson = jSONObject;
                    this.errorCode = jSONObject.optInt("error_code", 0);
                    JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
                    if (optJSONObject != null) {
                        this.errno = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                        this.errmsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                        this.usermsg = optJSONObject.optString("usermsg");
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                    if (optJSONObject2 != null) {
                        this.status = jSONObject.optInt("status");
                        this.isShowMessage = z && (optJSONObject2.optInt("is_toast", 0) == 1);
                        this.showMsg = optJSONObject2.optString("toast_text");
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("notice");
                        if (optJSONObject3 != null) {
                            this.showPop = optJSONObject3.optInt("is_pop") == 1;
                            this.autoOpenStatus = optJSONObject3.optInt("automatic_open");
                        }
                        parseBlockAnti(optJSONObject2);
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
        this.comeFromHost = false;
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
