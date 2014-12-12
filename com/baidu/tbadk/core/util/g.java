package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, JSONObject> {
    private final ad AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
    private final String Gm;
    private final int Hm;
    private final int Hn;
    private final int Ho;
    final /* synthetic */ e Hu;
    private final String Hv;
    private final int mType;

    public g(e eVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.Hu = eVar;
        this.Hn = i3;
        this.Hm = i4;
        this.Gm = str;
        this.Hv = str2;
        this.mType = i;
        this.Ho = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public JSONObject doInBackground(Object... objArr) {
        if (this.Hu.om() == null || !this.Hu.om().mF() || this.mType == 0) {
            return null;
        }
        this.AR.o("number", String.valueOf(this.Ho));
        if (this.mType == 1) {
            this.AR.o("ab_num_error", String.valueOf(this.Hn));
            this.AR.o("error", this.Gm);
            this.AR.o("ab_num_slow", String.valueOf(this.Hm));
            this.AR.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.Hv);
        } else if (this.mType == 3) {
            this.AR.o("ab_num_slow", new StringBuilder(String.valueOf(this.Hm)).toString());
            this.AR.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.Hv);
        } else if (this.mType == 2) {
            this.AR.o("ab_num_error", new StringBuilder(String.valueOf(this.Hn)).toString());
            this.AR.o("error", this.Gm);
        }
        String ov = this.AR.ov();
        if (!this.AR.oZ() || TextUtils.isEmpty(ov)) {
            return null;
        }
        try {
            return new JSONObject(ov);
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [398=6] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public void onPostExecute(JSONObject jSONObject) {
        int i;
        com.baidu.tbadk.core.data.h hVar;
        com.baidu.tbadk.core.data.h hVar2;
        super.onPostExecute(jSONObject);
        try {
            if (jSONObject == null) {
                com.baidu.adp.lib.stats.q ef = w.ef();
                ef.r("act", "fallback");
                ef.r("result", "1");
                ef.r("type", "end");
                com.baidu.adp.lib.stats.f.es().a("img", ef);
                return;
            }
            e eVar = this.Hu;
            i = eVar.Hh;
            int i2 = i + 1;
            eVar.Hh = i2;
            if (i2 >= 5) {
                hVar2 = this.Hu.Hg;
                hVar2.ae(false);
                this.Hu.mLastUploadTime = System.currentTimeMillis();
                return;
            }
            if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                com.baidu.adp.lib.stats.q ef2 = w.ef();
                ef2.r("act", "fallback");
                ef2.r("result", "2");
                ef2.r("type", "end");
                com.baidu.adp.lib.stats.f.es().a("img", ef2);
            } else {
                com.baidu.adp.lib.stats.q ef3 = w.ef();
                ef3.r("act", "fallback");
                ef3.r("result", "0");
                ef3.r("type", "end");
                com.baidu.adp.lib.stats.f.es().a("img", ef3);
                this.Hu.reset();
                hVar = this.Hu.Hg;
                hVar.ae(false);
                this.Hu.mLastUploadTime = System.currentTimeMillis();
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.h hVar3 = new com.baidu.tbadk.core.data.h();
            hVar3.parseJson(optString);
            if (hVar3.mF() == this.Hu.om().mF() && hVar3.mH() == this.Hu.om().mH() && hVar3.mG() == this.Hu.om().mG() && hVar3.getTime() == this.Hu.om().getTime()) {
                return;
            }
            this.Hu.a(hVar3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.Hu.mIsUploading = false;
        }
    }
}
