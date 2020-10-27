package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public int Te;
    public JSONObject data;
    public String errMsg;

    public boolean isSuccess() {
        return this.Te == 0;
    }
}
