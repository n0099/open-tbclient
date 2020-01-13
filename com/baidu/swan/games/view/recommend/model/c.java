package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public JSONObject data;
    public String errMsg;
    public int xD;

    public boolean isSuccess() {
        return this.xD == 0;
    }
}
