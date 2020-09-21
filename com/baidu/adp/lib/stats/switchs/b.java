package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    public long Or = 0;
    public String Os = null;

    public boolean nV() {
        String str = null;
        d dVar = new d(BdStatsConstant.CONFIG_FILE_PATH, BdStatsConstant.SWITCHS_CONFIG_FILENAME, DiskFileOperate.Action.READ);
        dVar.setSdCard(false);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.lK().b(dVar);
        if (dVar.isSuccess()) {
            str = dVar.getContent();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.Or = jSONObject.getLong("time");
            this.Os = jSONObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void cf(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("data", str);
                d dVar = new d(BdStatsConstant.CONFIG_FILE_PATH, BdStatsConstant.SWITCHS_CONFIG_FILENAME, DiskFileOperate.Action.WRITE_FORCE);
                dVar.setSdCard(false);
                dVar.setContent(jSONObject.toString());
                dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.lK().b(dVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
