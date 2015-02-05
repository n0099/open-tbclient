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
    private final ad AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
    private final String Gm;
    final /* synthetic */ e HA;
    private final String HB;
    private final int Hs;
    private final int Ht;
    private final int Hu;
    private final int mType;

    public g(e eVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.HA = eVar;
        this.Ht = i3;
        this.Hs = i4;
        this.Gm = str;
        this.HB = str2;
        this.mType = i;
        this.Hu = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public JSONObject doInBackground(Object... objArr) {
        if (this.HA.oi() == null || !this.HA.oi().my() || this.mType == 0) {
            return null;
        }
        this.AO.o("number", String.valueOf(this.Hu));
        if (this.mType == 1) {
            this.AO.o("ab_num_error", String.valueOf(this.Ht));
            this.AO.o("error", this.Gm);
            this.AO.o("ab_num_slow", String.valueOf(this.Hs));
            this.AO.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.HB);
        } else if (this.mType == 3) {
            this.AO.o("ab_num_slow", new StringBuilder(String.valueOf(this.Hs)).toString());
            this.AO.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.HB);
        } else if (this.mType == 2) {
            this.AO.o("ab_num_error", new StringBuilder(String.valueOf(this.Ht)).toString());
            this.AO.o("error", this.Gm);
        }
        String or = this.AO.or();
        if (!this.AO.oV() || TextUtils.isEmpty(or)) {
            return null;
        }
        try {
            return new JSONObject(or);
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
            e eVar = this.HA;
            i = eVar.Hn;
            int i2 = i + 1;
            eVar.Hn = i2;
            if (i2 >= 5) {
                hVar2 = this.HA.Hm;
                hVar2.af(false);
                this.HA.mLastUploadTime = System.currentTimeMillis();
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
                this.HA.reset();
                hVar = this.HA.Hm;
                hVar.af(false);
                this.HA.mLastUploadTime = System.currentTimeMillis();
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.h hVar3 = new com.baidu.tbadk.core.data.h();
            hVar3.parseJson(optString);
            if (hVar3.my() == this.HA.oi().my() && hVar3.mA() == this.HA.oi().mA() && hVar3.mz() == this.HA.oi().mz() && hVar3.getTime() == this.HA.oi().getTime()) {
                return;
            }
            this.HA.a(hVar3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.HA.mIsUploading = false;
        }
    }
}
