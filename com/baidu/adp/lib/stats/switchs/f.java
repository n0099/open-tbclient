package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public long xk = 0;
    public String xl = null;

    public boolean it() {
        String str = null;
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
        eVar.q(false);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.fp().b(eVar);
        if (eVar.isSuccess()) {
            str = eVar.getContent();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.xk = jSONObject.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            this.xl = jSONObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void aF(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis);
                jSONObject.put("data", str);
                com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e("statisticConfig", "switchsConfig", DiskFileOperate.Action.WRITE_FORCE);
                eVar.q(false);
                eVar.setContent(jSONObject.toString());
                eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fp().b(eVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
