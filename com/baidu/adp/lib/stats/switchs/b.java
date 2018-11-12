package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    public long EY = 0;
    public String EZ = null;

    public boolean ks() {
        String str = null;
        d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
        dVar.T(false);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.hB().b(dVar);
        if (dVar.isSuccess()) {
            str = dVar.getContent();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.EY = jSONObject.getLong("time");
            this.EZ = jSONObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void bd(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("data", str);
                d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.WRITE_FORCE);
                dVar.T(false);
                dVar.setContent(jSONObject.toString());
                dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.hB().b(dVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
