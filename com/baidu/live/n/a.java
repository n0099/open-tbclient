package com.baidu.live.n;

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
/* loaded from: classes7.dex */
public class a extends BdAsyncTask<String, Void, b> {
    private c bgF;

    public a(c cVar) {
        this.bgF = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    /* renamed from: l */
    public b doInBackground(String... strArr) {
        b bVar = new b();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoSDK");
        netWork.addPostData("user_id", strArr[0]);
        netWork.addPostData("anchor_id", strArr[1]);
        netWork.addPostData("group_id", strArr[2]);
        netWork.addPostData("meta_key", strArr[3]);
        netWork.addPostData("show_name", strArr[4]);
        netWork.addPostData(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
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
                        bVar.bgG = new PersonUserData();
                        bVar.bgG.parserJson(optJSONObject);
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
        if (this.bgF != null && bVar != null) {
            if (bVar.errCode == 0) {
                this.bgF.a(bVar.bgG);
            } else {
                this.bgF.p(bVar.errCode, bVar.errMsg);
            }
        }
    }
}
