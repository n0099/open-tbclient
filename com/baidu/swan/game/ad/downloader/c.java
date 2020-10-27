package com.baidu.swan.game.ad.downloader;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
    public static boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("type", swanAppDownloadType.getTypeName());
        String str = "";
        if (jSONObject != null) {
            str = jSONObject.toString();
        }
        bundle.putString(PushConstants.PARAMS, str);
        com.baidu.swan.apps.process.messaging.client.a aCO = com.baidu.swan.apps.process.messaging.client.a.aCO();
        if (aCO != null) {
            aCO.b(bundle, b.class, new d(aVar, swanAppDownloadType));
            return true;
        }
        return true;
    }
}
