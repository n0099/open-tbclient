package com.baidu.swan.games.u.b;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public JSONObject emp;
    public d emq;
    public String query;
    public String title;
    public String videoPath;

    public String toString() {
        return "{ videoPath=" + this.videoPath + " , query=" + this.query + " , title=" + this.title + ", extra=" + this.emp + ", videoEditorParams=" + this.emq + " }";
    }
}
