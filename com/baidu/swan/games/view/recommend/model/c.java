package com.baidu.swan.games.view.recommend.model;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public int Tf;
    public JSONObject data;
    public String errMsg;

    public boolean isSuccess() {
        return this.Tf == 0;
    }
}
