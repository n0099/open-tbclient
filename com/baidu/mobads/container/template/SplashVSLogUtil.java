package com.baidu.mobads.container.template;

import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SplashVSLogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_RSPLASH_GIF = 3;
    public static final int TYPE_RSPLASH_STATIC_IMAGE = 1;
    public static final int TYPE_RSPLASH_TEMPLATE = 2;
    public static final int TYPE_RSPLASH_VIDEO = 4;
    public transient /* synthetic */ FieldHolder $fh;

    public SplashVSLogUtil() {
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

    public static void sendLog(XAdContainerContext xAdContainerContext, int i2, boolean z, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{xAdContainerContext, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) || xAdContainerContext == null) {
            return;
        }
        try {
            SendLogUtil.Builder appendApId = SendLogUtil.Builder.create(xAdContainerContext.getAppContext()).appendType(i4).appendProdType("rsplash").appendAppSid(xAdContainerContext.getAppsid()).appendAdInfo(xAdContainerContext.getAdInstanceInfo()).append("uniqueid", xAdContainerContext.getAdInstanceInfo().getUniqueId()).appendApId(xAdContainerContext.getAdPlacementId());
            SendLogUtil.Builder append = appendApId.append("rsplashtype", "" + i3).append("logversion", "4").append("p_ver", AppConfigImp.getInstance().getProxyVersion());
            SendLogUtil.Builder append2 = append.append("isshowsended", "" + z).append("materialtype", xAdContainerContext.getAdInstanceInfo().getMaterialType());
            SendLogUtil.Builder append3 = append2.append("showstate", "" + i2);
            if (str != null && !str.equals("")) {
                append3.append("showrecord", str);
            }
            append3.send();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
        }
    }
}
