package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String aBO;
    private boolean aBP;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aBO = null;
        this.mObjTp = null;
        this.aBP = false;
        this.mType = str;
        this.aBP = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aBO = null;
        this.mObjTp = null;
        this.aBP = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aBP) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        x xVar = new x(TbConfig.SERVER_ADDRESS + str);
        xVar.x("st_type", this.mType);
        if (this.mParam != null) {
            xVar.x("st_param", this.mParam);
        }
        if (this.aBO != null) {
            xVar.x("obj", this.aBO);
        }
        if (this.mObjTp != null) {
            xVar.x("obj_tp", this.mObjTp);
        }
        String CL = xVar.CL();
        System.out.println("pv_test !!!");
        if (CL != null) {
            Log.i("USEINTERVAL", CL);
            try {
                JSONObject jSONObject = new JSONObject(CL);
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
