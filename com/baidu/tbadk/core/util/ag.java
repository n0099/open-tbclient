package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String dNA;
    private boolean dNB;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.dNA = null;
        this.mObjTp = null;
        this.dNB = false;
        this.mType = str;
        this.dNB = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.dNA = null;
        this.mObjTp = null;
        this.dNB = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            if (this.dNB) {
                str = TbConfig.IN_PV_ADDRESS;
            } else {
                str = TbConfig.LOAD_REG_PV_ADDRESS;
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + str);
            xVar.addPostData("st_type", this.mType);
            if (this.mParam != null) {
                xVar.addPostData("st_param", this.mParam);
            }
            if (this.dNA != null) {
                xVar.addPostData("obj", this.dNA);
            }
            if (this.mObjTp != null) {
                xVar.addPostData("obj_tp", this.mObjTp);
            }
            String postNetData = xVar.postNetData();
            System.out.println("pv_test !!!");
            if (postNetData != null) {
                Log.i("USEINTERVAL", postNetData);
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
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
