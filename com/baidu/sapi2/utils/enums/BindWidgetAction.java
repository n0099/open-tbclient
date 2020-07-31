package com.baidu.sapi2.utils.enums;
/* loaded from: classes19.dex */
public enum BindWidgetAction {
    BIND_MOBILE("/wp/bindwidget-bindmobile", "绑定手机"),
    BIND_EMAIL("/wp/bindwidget-bindemail", "绑定邮箱"),
    REBIND_MOBILE("/wp/bindwidget-rebindmobile", "换绑手机"),
    REBIND_EMAIL("/wp/bindwidget-rebindemail", "换绑邮箱"),
    UNBIND_MOBILE("/wp/bindwidget-unbindmobile", "解绑手机"),
    UNBIND_EMAIL("/wp/bindwidget-unbindemail", "解绑邮箱");
    
    private String b;
    private String c;

    BindWidgetAction(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public String getName() {
        return this.c;
    }

    public String getUri() {
        return this.b;
    }
}
