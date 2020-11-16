package com.baidu.minivideo.plugin.capture.bean;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public interface Jsonable {
    boolean parse(String str);

    JSONObject toJson();
}
