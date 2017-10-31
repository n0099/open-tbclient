package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String agO;
    private boolean agP;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.agO = null;
        this.mObjTp = null;
        this.agP = false;
        this.mType = str;
        this.agP = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.agO = null;
        this.mObjTp = null;
        this.agP = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.agP) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        x xVar = new x(TbConfig.SERVER_ADDRESS + str);
        xVar.n("st_type", this.mType);
        if (this.mParam != null) {
            xVar.n("st_param", this.mParam);
        }
        if (this.agO != null) {
            xVar.n("obj", this.agO);
        }
        if (this.mObjTp != null) {
            xVar.n("obj_tp", this.mObjTp);
        }
        String up = xVar.up();
        if (up != null) {
            Log.i("USEINTERVAL", up);
            try {
                JSONObject jSONObject = new JSONObject(up);
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
