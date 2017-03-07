package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    public long ya = 0;
    public String yb = null;

    public boolean gA() {
        String str = null;
        d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
        dVar.u(false);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.dI().b(dVar);
        if (dVar.isSuccess()) {
            str = dVar.getContent();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ya = jSONObject.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            this.yb = jSONObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis);
                jSONObject.put("data", str);
                d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.WRITE_FORCE);
                dVar.u(false);
                dVar.setContent(jSONObject.toString());
                dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.dI().b(dVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
