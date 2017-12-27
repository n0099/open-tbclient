package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String aVs;
    private boolean aVt;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aVs = null;
        this.mObjTp = null;
        this.aVt = false;
        this.mType = str;
        this.aVt = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aVs = null;
        this.mObjTp = null;
        this.aVt = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aVt) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        x xVar = new x(TbConfig.SERVER_ADDRESS + str);
        xVar.n("st_type", this.mType);
        if (this.mParam != null) {
            xVar.n("st_param", this.mParam);
        }
        if (this.aVs != null) {
            xVar.n("obj", this.aVs);
        }
        if (this.mObjTp != null) {
            xVar.n("obj_tp", this.mObjTp);
        }
        String BP = xVar.BP();
        System.out.println("pv_test !!!");
        if (BP != null) {
            Log.i("USEINTERVAL", BP);
            try {
                JSONObject jSONObject = new JSONObject(BP);
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
