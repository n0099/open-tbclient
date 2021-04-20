package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.tieba.ala.ALaKeepAliveService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FoundationFacadeUtils implements ICommonModuleObj {
    public static volatile FoundationFacadeUtils sInstance;
    public CustomNotification mNotification = new CustomNotification();

    public static FoundationFacadeUtils getInstance() {
        if (sInstance == null) {
            synchronized (FoundationFacadeUtils.class) {
                if (sInstance == null) {
                    sInstance = new FoundationFacadeUtils();
                }
            }
        }
        return sInstance;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        return this.mNotification.getCustomNotification((Context) jSONObject.opt("context"), jSONObject.optString(AppConfigImp.KEY_CHANNELID), jSONObject.optString(ALaKeepAliveService.KEY_TICKER), (Bitmap) jSONObject.opt("icon"), jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optString("status"), jSONObject.optBoolean("autoCancel"), jSONObject.optInt("progress"), jSONObject.optInt("smallIcon"), jSONObject.optString("action"), (PendingIntent) jSONObject.opt("pendingIntent"));
    }
}
