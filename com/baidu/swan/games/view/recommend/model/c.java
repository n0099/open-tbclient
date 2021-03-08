package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public int Vs;
    public JSONObject data;
    public String errMsg;

    public boolean isSuccess() {
        return this.Vs == 0;
    }
}
