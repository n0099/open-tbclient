package com.baidu.searchbox.v8engine.event;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class JSEvent {
    public Object data;
    public String type;

    public JSEvent(String str) {
        this(str, null);
    }

    public JSEvent(String str, Object obj) {
        this.type = str;
        this.data = obj;
    }

    public static boolean isValid(JSEvent jSEvent) {
        return (jSEvent == null || TextUtils.isEmpty(jSEvent.type)) ? false : true;
    }
}
