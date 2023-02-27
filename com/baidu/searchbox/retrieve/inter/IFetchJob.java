package com.baidu.searchbox.retrieve.inter;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class IFetchJob {
    public abstract void dispatch(JSONObject jSONObject);

    public abstract String getFetchJobType();
}
