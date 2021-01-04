package com.baidu.live.s;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ErrorData;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends BdAsyncTask<String, Void, b> {
    private c byk;

    public d(c cVar) {
        this.byk = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    /* renamed from: m */
    public b doInBackground(String... strArr) {
        b bVar = new b();
        NetWork netWork = new NetWork(com.baidu.live.a.aAH + "ala/audio/user/getUserInfoSDK");
        netWork.addPostData("uk", strArr[0]);
        netWork.addPostData("group_id", strArr[1]);
        netWork.addPostData("live_id", strArr[2]);
        netWork.addPostData(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        netWork.addPostData(HttpRequest.LIVE_SCENE, TbConfig.liveScene + "");
        String postNetData = netWork.postNetData();
        if (netWork.isRequestSuccess()) {
            ErrorData errorData = new ErrorData();
            if (postNetData != null) {
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    errorData.parserJson(jSONObject);
                    bVar.errCode = errorData.error_code;
                    bVar.errMsg = errorData.error_msg;
                    if (optJSONObject != null) {
                        bVar.byl = new PersonUserData();
                        bVar.byl.parserJson(optJSONObject);
                    }
                } catch (JSONException e) {
                    BdLog.detailException(e);
                }
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(b bVar) {
        if (this.byk != null && bVar != null) {
            if (bVar.errCode == 0) {
                this.byk.a(bVar.byl);
            } else {
                this.byk.u(bVar.errCode, bVar.errMsg);
            }
        }
    }
}
