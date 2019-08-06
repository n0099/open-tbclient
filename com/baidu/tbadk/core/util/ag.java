package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String bTg;
    private boolean bTh;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.bTg = null;
        this.mObjTp = null;
        this.bTh = false;
        this.mType = str;
        this.bTh = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.bTg = null;
        this.mObjTp = null;
        this.bTh = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            if (this.bTh) {
                str = TbConfig.IN_PV_ADDRESS;
            } else {
                str = TbConfig.LOAD_REG_PV_ADDRESS;
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + str);
            xVar.o("st_type", this.mType);
            if (this.mParam != null) {
                xVar.o("st_param", this.mParam);
            }
            if (this.bTg != null) {
                xVar.o("obj", this.bTg);
            }
            if (this.mObjTp != null) {
                xVar.o("obj_tp", this.mObjTp);
            }
            String aii = xVar.aii();
            System.out.println("pv_test !!!");
            if (aii != null) {
                Log.i("USEINTERVAL", aii);
                try {
                    JSONObject jSONObject = new JSONObject(aii);
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
}
