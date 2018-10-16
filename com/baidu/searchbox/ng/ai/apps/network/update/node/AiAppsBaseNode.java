package com.baidu.searchbox.ng.ai.apps.network.update.node;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AiAppsBaseNode {
    @NonNull
    public abstract String getNodeName();

    public abstract void onFail();

    public abstract void onFiltered();

    public abstract void onUpdate(JSONObject jSONObject);
}
