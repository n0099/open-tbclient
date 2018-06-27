package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah extends Thread {
    private String aqQ;
    private boolean aqR;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ah(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aqQ = null;
        this.mObjTp = null;
        this.aqR = false;
        this.mType = str;
        this.aqR = z;
    }

    public ah(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aqQ = null;
        this.mObjTp = null;
        this.aqR = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aqR) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        y yVar = new y(TbConfig.SERVER_ADDRESS + str);
        yVar.o("st_type", this.mType);
        if (this.mParam != null) {
            yVar.o("st_param", this.mParam);
        }
        if (this.aqQ != null) {
            yVar.o("obj", this.aqQ);
        }
        if (this.mObjTp != null) {
            yVar.o("obj_tp", this.mObjTp);
        }
        String yz = yVar.yz();
        System.out.println("pv_test !!!");
        if (yz != null) {
            Log.i("USEINTERVAL", yz);
            try {
                JSONObject jSONObject = new JSONObject(yz);
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
