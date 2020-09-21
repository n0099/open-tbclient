package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public int SL;
    public JSONObject data;
    public String errMsg;

    public boolean isSuccess() {
        return this.SL == 0;
    }
}
