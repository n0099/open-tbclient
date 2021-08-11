package com.baidu.mobads.container.components.countly;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.landingpage.XAdRemoteAbstractTrackingInfo;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class XAdRemoteDownloadMonitorTrackingInfo extends XAdRemoteAbstractTrackingInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean autoOpen;
    public Context mContext;
    public XAdRemoteAPKDownloadExtraInfo mExtraInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdRemoteDownloadMonitorTrackingInfo(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        super(xAdRemoteAPKDownloadExtraInfo.getAdid(), xAdRemoteAPKDownloadExtraInfo.getQueryKey(), xAdRemoteAPKDownloadExtraInfo.getProd(), xAdRemoteAPKDownloadExtraInfo.getAppsid(), xAdRemoteAPKDownloadExtraInfo.getAppsec());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xAdRemoteAPKDownloadExtraInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.autoOpen = true;
        this.mContext = context;
        this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
    }

    @Override // com.baidu.mobads.container.landingpage.XAdRemoteAbstractTrackingInfo
    public HashMap<String, String> toAdditionalHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "1";
            String str2 = "" + ProcessUtils.getInstance().getCurrentProcessId();
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                hashMap.put(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN, this.autoOpen ? "true" : "false");
                hashMap.put("pk", this.mExtraInfo.getPackageName());
                hashMap.put(XAdRemoteAPKDownloadExtraInfo.BUYER, this.mExtraInfo.getBuyer());
                hashMap.put("c", "0");
                hashMap.put(XAdRemoteAPKDownloadExtraInfo.FIRST_PROCESS_ID, str2);
                hashMap.put("clickTime", this.mExtraInfo.getClickTime() + "");
                hashMap.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, "" + this.mExtraInfo.getAppSize());
                hashMap.put(XAdRemoteAPKDownloadExtraInfo.DL_COUNTS, "1");
                hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.mExtraInfo.getClickTime()));
                hashMap.put(XAdRemoteAPKDownloadExtraInfo.DL_TUNNEL, "3");
                if (!this.mExtraInfo.isTooLarge()) {
                    str = "0";
                }
                hashMap.put("dlWay", str);
                hashMap.put("exp_id", "");
                hashMap.put("exp2", "");
                hashMap.put("pkg", this.mExtraInfo.getPackageName());
                hashMap.put("typeProcId", str2);
                hashMap.put("url2", "");
                hashMap.putAll(this.mExtraInfo.mExtras);
                hashMap.put(IAdRequestParam.SN, DeviceUtils.getInstance().getEncodedSN(this.mContext));
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
