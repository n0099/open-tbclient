package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, JSONObject> {
    private final int CZ;
    private final String Ca;
    private final int Da;
    final /* synthetic */ e Dg;
    private final String Dh;
    private final int mErrorNum;
    private final ac mNetWork = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
    private final int mType;

    public g(e eVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.Dg = eVar;
        this.mErrorNum = i3;
        this.CZ = i4;
        this.Ca = str;
        this.Dh = str2;
        this.mType = i;
        this.Da = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public JSONObject doInBackground(Object... objArr) {
        if (this.Dg.lr() == null || !this.Dg.lr().jQ() || this.mType == 0) {
            return null;
        }
        this.mNetWork.k("number", String.valueOf(this.Da));
        if (this.mType == 1) {
            this.mNetWork.k("ab_num_error", String.valueOf(this.mErrorNum));
            this.mNetWork.k("error", this.Ca);
            this.mNetWork.k("ab_num_slow", String.valueOf(this.CZ));
            this.mNetWork.k("time", this.Dh);
        } else if (this.mType == 3) {
            this.mNetWork.k("ab_num_slow", new StringBuilder(String.valueOf(this.CZ)).toString());
            this.mNetWork.k("time", this.Dh);
        } else if (this.mType == 2) {
            this.mNetWork.k("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
            this.mNetWork.k("error", this.Ca);
        }
        String lA = this.mNetWork.lA();
        if (!this.mNetWork.mf() || TextUtils.isEmpty(lA)) {
            return null;
        }
        try {
            return new JSONObject(lA);
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [398=6] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(JSONObject jSONObject) {
        int i;
        com.baidu.tbadk.core.data.f fVar;
        com.baidu.tbadk.core.data.f fVar2;
        super.onPostExecute(jSONObject);
        try {
            if (jSONObject == null) {
                com.baidu.adp.lib.stats.q logItem = v.getLogItem();
                logItem.n("act", "fallback");
                logItem.n("result", "1");
                logItem.n("type", "end");
                com.baidu.adp.lib.stats.f.er().a("img", logItem);
                return;
            }
            e eVar = this.Dg;
            i = eVar.CU;
            int i2 = i + 1;
            eVar.CU = i2;
            if (i2 >= 5) {
                fVar2 = this.Dg.CT;
                fVar2.O(false);
                this.Dg.mLastUploadTime = System.currentTimeMillis();
                return;
            }
            if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                com.baidu.adp.lib.stats.q logItem2 = v.getLogItem();
                logItem2.n("act", "fallback");
                logItem2.n("result", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                logItem2.n("type", "end");
                com.baidu.adp.lib.stats.f.er().a("img", logItem2);
            } else {
                com.baidu.adp.lib.stats.q logItem3 = v.getLogItem();
                logItem3.n("act", "fallback");
                logItem3.n("result", "0");
                logItem3.n("type", "end");
                com.baidu.adp.lib.stats.f.er().a("img", logItem3);
                this.Dg.reset();
                fVar = this.Dg.CT;
                fVar.O(false);
                this.Dg.mLastUploadTime = System.currentTimeMillis();
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.f fVar3 = new com.baidu.tbadk.core.data.f();
            fVar3.parseJson(optString);
            if (fVar3.jQ() == this.Dg.lr().jQ() && fVar3.jS() == this.Dg.lr().jS() && fVar3.jR() == this.Dg.lr().jR() && fVar3.getTime() == this.Dg.lr().getTime()) {
                return;
            }
            this.Dg.a(fVar3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.Dg.mIsUploading = false;
        }
    }
}
