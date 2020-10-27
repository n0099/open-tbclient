package com.baidu.swan.games.u.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public JSONObject dTn;
    public d dTo;
    public String query;
    public String title;
    public String videoPath;

    public String toString() {
        return "{ videoPath=" + this.videoPath + " , query=" + this.query + " , title=" + this.title + ", extra=" + this.dTn + ", videoEditorParams=" + this.dTo + " }";
    }
}
