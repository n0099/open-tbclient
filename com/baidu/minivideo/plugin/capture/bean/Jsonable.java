package com.baidu.minivideo.plugin.capture.bean;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface Jsonable {
    boolean parse(String str);

    JSONObject toJson();
}
