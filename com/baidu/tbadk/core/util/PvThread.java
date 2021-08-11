package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PvThread extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsInpv;
    public String mObj;
    public String mObjTp;
    public String mParam;
    public String mType;

    public PvThread(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + (this.mIsInpv ? TbConfig.IN_PV_ADDRESS : TbConfig.LOAD_REG_PV_ADDRESS));
            netWork.addPostData("st_type", this.mType);
            String str = this.mParam;
            if (str != null) {
                netWork.addPostData("st_param", str);
            }
            String str2 = this.mObj;
            if (str2 != null) {
                netWork.addPostData("obj", str2);
            }
            String str3 = this.mObjTp;
            if (str3 != null) {
                netWork.addPostData("obj_tp", str3);
            }
            String postNetData = netWork.postNetData();
            System.out.println("pv_test !!!");
            if (postNetData != null) {
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("use_duration")) {
                        long optLong = jSONObject.optLong("use_duration");
                        String str4 = "duration " + optLong;
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
    }

    public PvThread(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mIsInpv = z;
    }

    public PvThread(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mType = null;
        this.mParam = null;
        this.mObj = null;
        this.mObjTp = null;
        this.mIsInpv = false;
        this.mType = str;
        this.mParam = str2;
    }

    public PvThread(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
