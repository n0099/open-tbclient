package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah extends Thread {
    private String aqr;
    private boolean aqs;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ah(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aqr = null;
        this.mObjTp = null;
        this.aqs = false;
        this.mType = str;
        this.aqs = z;
    }

    public ah(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aqr = null;
        this.mObjTp = null;
        this.aqs = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aqs) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        y yVar = new y(TbConfig.SERVER_ADDRESS + str);
        yVar.o("st_type", this.mType);
        if (this.mParam != null) {
            yVar.o("st_param", this.mParam);
        }
        if (this.aqr != null) {
            yVar.o("obj", this.aqr);
        }
        if (this.mObjTp != null) {
            yVar.o("obj_tp", this.mObjTp);
        }
        String yl = yVar.yl();
        System.out.println("pv_test !!!");
        if (yl != null) {
            Log.i("USEINTERVAL", yl);
            try {
                JSONObject jSONObject = new JSONObject(yl);
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
