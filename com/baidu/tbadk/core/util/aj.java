package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aj extends Thread {
    private String eks;
    private boolean ekt;
    private String mObjTp;
    private String mParam;
    private String mType;

    public aj(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.eks = null;
        this.mObjTp = null;
        this.ekt = false;
        this.mType = str;
        this.ekt = z;
    }

    public aj(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.eks = null;
        this.mObjTp = null;
        this.ekt = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            if (this.ekt) {
                str = TbConfig.IN_PV_ADDRESS;
            } else {
                str = TbConfig.LOAD_REG_PV_ADDRESS;
            }
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + str);
            aaVar.addPostData("st_type", this.mType);
            if (this.mParam != null) {
                aaVar.addPostData("st_param", this.mParam);
            }
            if (this.eks != null) {
                aaVar.addPostData(MapBundleKey.MapObjKey.OBJ_SL_OBJ, this.eks);
            }
            if (this.mObjTp != null) {
                aaVar.addPostData("obj_tp", this.mObjTp);
            }
            String postNetData = aaVar.postNetData();
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
