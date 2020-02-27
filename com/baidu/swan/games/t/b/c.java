package com.baidu.swan.games.t.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public JSONObject csa;
    public d csb;
    public String query;
    public String title;
    public String videoPath;

    public String toString() {
        return "{ videoPath=" + this.videoPath + " , query=" + this.query + " , title=" + this.title + ", extra=" + this.csa + ", videoEditorParams=" + this.csb + " }";
    }
}
