package com.baidu.live.tbadk.message.http;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ErrorData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonHttpResponsedMessage extends TbHttpResponsedMessage {
    private long mLogId;

    public JsonHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tbadk.message.http.TbHttpResponsedMessage, com.baidu.live.adp.framework.message.IDecode
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        JSONObject jSONObject = null;
        String parseToString = parseToString(bArr);
        if (!TextUtils.isEmpty(parseToString)) {
            jSONObject = parseServerResponsedData(parseToString);
        }
        if (jSONObject != null) {
            this.mLogId = jSONObject.optLong("logid");
        }
        decodeLogicInBackGround(i, jSONObject);
    }

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
    }

    protected JSONObject parseServerResponsedData(String str) {
        JSONObject jSONObject;
        Exception e;
        if (str == null) {
            return null;
        }
        try {
            ErrorData errorData = new ErrorData();
            jSONObject = new JSONObject(str);
            try {
                errorData.parserJson(str);
                setError(errorData.getError_code());
                if (getError() == -1) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_unkown_try_again));
                } else {
                    setErrorString(errorData.getError_msg());
                }
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                setError(-1);
                setErrorString(TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_unkown_try_again));
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
    }

    public long getLogId() {
        return this.mLogId;
    }
}
