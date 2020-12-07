package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class IRetrieveJob {
    public abstract void dispatch(JSONObject jSONObject, Context context);

    public abstract String getRetrieveJobType();
}
