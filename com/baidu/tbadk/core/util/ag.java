package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String axB;
    private boolean axC;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.axB = null;
        this.mObjTp = null;
        this.axC = false;
        this.mType = str;
        this.axC = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.axB = null;
        this.mObjTp = null;
        this.axC = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.axC) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        x xVar = new x(TbConfig.SERVER_ADDRESS + str);
        xVar.x("st_type", this.mType);
        if (this.mParam != null) {
            xVar.x("st_param", this.mParam);
        }
        if (this.axB != null) {
            xVar.x("obj", this.axB);
        }
        if (this.mObjTp != null) {
            xVar.x("obj_tp", this.mObjTp);
        }
        String BA = xVar.BA();
        System.out.println("pv_test !!!");
        if (BA != null) {
            Log.i("USEINTERVAL", BA);
            try {
                JSONObject jSONObject = new JSONObject(BA);
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
