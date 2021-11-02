package com.baidu.clientupdate.appinfo;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RuleInfo extends AppInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAutoDownload;
    public String mCategory;
    public String mContentUrl;
    public String mExpire;
    public String mGprs;
    public String mLevel;
    public String mNetwork;
    public String mRemind;
    public String mRemindPlace;
    public String mRemindPoint;
    public String mRemindTime;
    public String mRuleid;
    public String mSilentDown;
    public String mUpgradeid;
    public String mVisitInterface;
    public String mWifi;

    public RuleInfo() {
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
}
