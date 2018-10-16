package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.ChooseImageAction;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IAiAppImageIoc {
    void chooseImage(Context context, int i, ChooseImageAction.OnImageChooseResultCallback onImageChooseResultCallback);

    void launchPictureBrowser(Context context, JSONObject jSONObject);
}
