package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PvThread extends Thread {
    public boolean mIsInpv;
    public String mObj;
    public String mObjTp;
    public String mParam;
    public String mType;

    public PvThread(String str) {
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mIsInpv = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        String str = this.mIsInpv ? TbConfig.IN_PV_ADDRESS : TbConfig.LOAD_REG_PV_ADDRESS;
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + str);
        netWork.addPostData("st_type", this.mType);
        String str2 = this.mParam;
        if (str2 != null) {
            netWork.addPostData("st_param", str2);
        }
        String str3 = this.mObj;
        if (str3 != null) {
            netWork.addPostData("obj", str3);
        }
        String str4 = this.mObjTp;
        if (str4 != null) {
            netWork.addPostData("obj_tp", str4);
        }
        String postNetData = netWork.postNetData();
        System.out.println("pv_test !!!");
        if (postNetData != null) {
            Log.i("USEINTERVAL", postNetData);
            try {
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.has("use_duration")) {
                    long optLong = jSONObject.optLong("use_duration");
                    Log.i("USEINTERVAL", "duration " + optLong);
                    if (optLong < 0 || optLong == TbadkCoreApplication.getInst().getUseTimeInterval()) {
                        return;
                    }
                    TbadkCoreApplication.getInst().setUseTimeInterval(optLong);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public PvThread(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mIsInpv = z;
    }

    public PvThread(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mParam = str2;
    }

    public PvThread(String str, String str2, String str3) {
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mObj = str2;
        this.mObjTp = str3;
    }

    public PvThread(String str, String str2, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mParam = str2;
        this.mIsInpv = z;
    }
}
