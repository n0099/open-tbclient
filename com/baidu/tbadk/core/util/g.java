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
    private final String Gp;
    final /* synthetic */ e HD;
    private final String HE;
    private final int Hv;
    private final int Hw;
    private final int Hx;
    private final int mType;

    public g(e eVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.HD = eVar;
        this.Hw = i3;
        this.Hv = i4;
        this.Gp = str;
        this.HE = str2;
        this.mType = i;
        this.Hx = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public JSONObject doInBackground(Object... objArr) {
        if (this.HD.op() == null || !this.HD.op().mF() || this.mType == 0) {
            return null;
        }
        this.AR.o("number", String.valueOf(this.Hx));
        if (this.mType == 1) {
            this.AR.o("ab_num_error", String.valueOf(this.Hw));
            this.AR.o("error", this.Gp);
            this.AR.o("ab_num_slow", String.valueOf(this.Hv));
            this.AR.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.HE);
        } else if (this.mType == 3) {
            this.AR.o("ab_num_slow", new StringBuilder(String.valueOf(this.Hv)).toString());
            this.AR.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.HE);
        } else if (this.mType == 2) {
            this.AR.o("ab_num_error", new StringBuilder(String.valueOf(this.Hw)).toString());
            this.AR.o("error", this.Gp);
        }
        String oy = this.AR.oy();
        if (!this.AR.pc() || TextUtils.isEmpty(oy)) {
            return null;
        }
        try {
            return new JSONObject(oy);
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
                com.baidu.adp.lib.stats.q ed = w.ed();
                ed.r("act", "fallback");
                ed.r("result", "1");
                ed.r("type", "end");
                com.baidu.adp.lib.stats.f.eq().a("img", ed);
                return;
            }
            e eVar = this.HD;
            i = eVar.Hq;
            int i2 = i + 1;
            eVar.Hq = i2;
            if (i2 >= 5) {
                hVar2 = this.HD.Hp;
                hVar2.af(false);
                this.HD.mLastUploadTime = System.currentTimeMillis();
                return;
            }
            if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                com.baidu.adp.lib.stats.q ed2 = w.ed();
                ed2.r("act", "fallback");
                ed2.r("result", "2");
                ed2.r("type", "end");
                com.baidu.adp.lib.stats.f.eq().a("img", ed2);
            } else {
                com.baidu.adp.lib.stats.q ed3 = w.ed();
                ed3.r("act", "fallback");
                ed3.r("result", "0");
                ed3.r("type", "end");
                com.baidu.adp.lib.stats.f.eq().a("img", ed3);
                this.HD.reset();
                hVar = this.HD.Hp;
                hVar.af(false);
                this.HD.mLastUploadTime = System.currentTimeMillis();
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.h hVar3 = new com.baidu.tbadk.core.data.h();
            hVar3.parseJson(optString);
            if (hVar3.mF() == this.HD.op().mF() && hVar3.mH() == this.HD.op().mH() && hVar3.mG() == this.HD.op().mG() && hVar3.getTime() == this.HD.op().getTime()) {
                return;
            }
            this.HD.a(hVar3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.HD.mIsUploading = false;
        }
    }
}
