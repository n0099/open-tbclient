package com.baidu.searchbox.v8engine.event;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8JavascriptField;
@NotProguard
/* loaded from: classes11.dex */
public class JSEvent {
    @V8JavascriptField
    public Object currentTarget;
    public Object data;
    @V8JavascriptField
    public Object target;
    @V8JavascriptField
    public String type;

    public JSEvent(String str) {
        this(str, null);
    }

    public JSEvent(String str, Object obj, Object obj2) {
        this.type = str;
        this.target = obj;
        this.currentTarget = obj;
        this.data = obj2;
    }

    public JSEvent(String str, Object obj) {
        this.type = str;
        this.data = obj;
    }

    public static boolean isValid(JSEvent jSEvent) {
        return (jSEvent == null || TextUtils.isEmpty(jSEvent.type)) ? false : true;
    }
}
