package com.baidu.mobads.container.template;

import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SendLogUtil;
/* loaded from: classes2.dex */
public class SplashVSLogUtil {
    public static final int TYPE_RSPLASH_GIF = 3;
    public static final int TYPE_RSPLASH_STATIC_IMAGE = 1;
    public static final int TYPE_RSPLASH_TEMPLATE = 2;
    public static final int TYPE_RSPLASH_VIDEO = 4;

    public static void sendLog(XAdContainerContext xAdContainerContext, int i, boolean z, int i2, int i3, String str) {
        if (xAdContainerContext == null) {
            return;
        }
        try {
            SendLogUtil.Builder appendApId = SendLogUtil.Builder.create(xAdContainerContext.getAppContext()).appendType(i3).appendProdType("rsplash").appendAppSid(xAdContainerContext.getAppsid()).appendAdInfo(xAdContainerContext.getAdInstanceInfo()).append("uniqueid", xAdContainerContext.getAdInstanceInfo().getUniqueId()).appendApId(xAdContainerContext.getAdPlacementId());
            SendLogUtil.Builder append = appendApId.append("rsplashtype", "" + i2).append("logversion", "4").append("p_ver", AppConfigImp.getInstance().getProxyVersion());
            SendLogUtil.Builder append2 = append.append("isshowsended", "" + z).append("materialtype", xAdContainerContext.getAdInstanceInfo().getMaterialType());
            SendLogUtil.Builder append3 = append2.append("showstate", "" + i);
            if (str != null && !str.equals("")) {
                append3.append("showrecord", str);
            }
            append3.send();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
        }
    }
}
