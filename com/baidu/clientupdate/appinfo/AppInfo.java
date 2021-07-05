package com.baidu.clientupdate.appinfo;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class AppInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mApkMd5;
    public String mChangelog;
    public String mDownurl;
    public String mIconUrl;
    public String mPackageName;
    public String mPatchDownUrl;
    public String mPatchSize;
    public String mProdline;
    public String mSign;
    public String mSignMd5;
    public String mSize;
    public String mSname;
    public String mUpdateTime;
    public String mVercode;
    public String mVername;

    public AppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "sname: " + this.mSname + " vcode: " + this.mVercode + " vname: " + this.mVername + " downurl: " + this.mDownurl + " changelog: " + this.mChangelog + " size: " + this.mSize + " packageName: " + this.mPackageName + " signmd5: " + this.mSignMd5 + " apkmd5: " + this.mApkMd5 + " patch_downUrl: " + this.mPatchDownUrl + " patch_size: " + this.mPatchSize + " iconurl: " + this.mIconUrl;
        }
        return (String) invokeV.objValue;
    }
}
