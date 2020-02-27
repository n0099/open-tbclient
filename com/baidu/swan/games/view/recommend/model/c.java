package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public JSONObject data;
    public String errMsg;
    public int xV;

    public boolean isSuccess() {
        return this.xV == 0;
    }
}
