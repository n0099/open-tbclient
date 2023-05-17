package com.baidu.searchbox.retrieve.inter;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class IFetchJob {
    public abstract void dispatch(JSONObject jSONObject);

    public abstract String getFetchJobType();
}
