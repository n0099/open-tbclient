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
    private final String Cb;
    private final int Da;
    private final int Db;
    final /* synthetic */ e Dh;
    private final String Di;
    private final int mErrorNum;
    private final ac mNetWork = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
    private final int mType;

    public g(e eVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.Dh = eVar;
        this.mErrorNum = i3;
        this.Da = i4;
        this.Cb = str;
        this.Di = str2;
        this.mType = i;
        this.Db = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public JSONObject doInBackground(Object... objArr) {
        if (this.Dh.lr() == null || !this.Dh.lr().jQ() || this.mType == 0) {
            return null;
        }
        this.mNetWork.k("number", String.valueOf(this.Db));
        if (this.mType == 1) {
            this.mNetWork.k("ab_num_error", String.valueOf(this.mErrorNum));
            this.mNetWork.k("error", this.Cb);
            this.mNetWork.k("ab_num_slow", String.valueOf(this.Da));
            this.mNetWork.k("time", this.Di);
        } else if (this.mType == 3) {
            this.mNetWork.k("ab_num_slow", new StringBuilder(String.valueOf(this.Da)).toString());
            this.mNetWork.k("time", this.Di);
        } else if (this.mType == 2) {
            this.mNetWork.k("ab_num_error", new StringBuilder(String.valueOf(this.mErrorNum)).toString());
            this.mNetWork.k("error", this.Cb);
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
            e eVar = this.Dh;
            i = eVar.CV;
            int i2 = i + 1;
            eVar.CV = i2;
            if (i2 >= 5) {
                fVar2 = this.Dh.CU;
                fVar2.O(false);
                this.Dh.mLastUploadTime = System.currentTimeMillis();
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
                this.Dh.reset();
                fVar = this.Dh.CU;
                fVar.O(false);
                this.Dh.mLastUploadTime = System.currentTimeMillis();
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.f fVar3 = new com.baidu.tbadk.core.data.f();
            fVar3.parseJson(optString);
            if (fVar3.jQ() == this.Dh.lr().jQ() && fVar3.jS() == this.Dh.lr().jS() && fVar3.jR() == this.Dh.lr().jR() && fVar3.getTime() == this.Dh.lr().getTime()) {
                return;
            }
            this.Dh.a(fVar3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.Dh.mIsUploading = false;
        }
    }
}
