package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String agt;
    private boolean agu;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.agt = null;
        this.mObjTp = null;
        this.agu = false;
        this.mType = str;
        this.agu = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.agt = null;
        this.mObjTp = null;
        this.agu = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.agu) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        x xVar = new x(TbConfig.SERVER_ADDRESS + str);
        xVar.n("st_type", this.mType);
        if (this.mParam != null) {
            xVar.n("st_param", this.mParam);
        }
        if (this.agt != null) {
            xVar.n("obj", this.agt);
        }
        if (this.mObjTp != null) {
            xVar.n("obj_tp", this.mObjTp);
        }
        String ui = xVar.ui();
        if (ui != null) {
            Log.i("USEINTERVAL", ui);
            try {
                JSONObject jSONObject = new JSONObject(ui);
                if (jSONObject.has("use_duration")) {
                    long optLong = jSONObject.optLong("use_duration");
                    Log.i("USEINTERVAL", "duration " + optLong);
                    if (optLong >= 0 && optLong != TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        TbadkCoreApplication.getInst().setUseTimeInterval(optLong);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
