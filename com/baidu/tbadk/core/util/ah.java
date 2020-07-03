package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah extends Thread {
    private String dUq;
    private boolean dUr;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ah(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.dUq = null;
        this.mObjTp = null;
        this.dUr = false;
        this.mType = str;
        this.dUr = z;
    }

    public ah(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.dUq = null;
        this.mObjTp = null;
        this.dUr = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            if (this.dUr) {
                str = TbConfig.IN_PV_ADDRESS;
            } else {
                str = TbConfig.LOAD_REG_PV_ADDRESS;
            }
            y yVar = new y(TbConfig.SERVER_ADDRESS + str);
            yVar.addPostData("st_type", this.mType);
            if (this.mParam != null) {
                yVar.addPostData("st_param", this.mParam);
            }
            if (this.dUq != null) {
                yVar.addPostData("obj", this.dUq);
            }
            if (this.mObjTp != null) {
                yVar.addPostData("obj_tp", this.mObjTp);
            }
            String postNetData = yVar.postNetData();
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
