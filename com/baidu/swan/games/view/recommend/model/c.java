package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public int TW;
    public JSONObject data;
    public String errMsg;

    public boolean isSuccess() {
        return this.TW == 0;
    }
}
