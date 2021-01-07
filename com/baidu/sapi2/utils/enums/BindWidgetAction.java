package com.baidu.sapi2.utils.enums;
/* loaded from: classes3.dex */
public enum BindWidgetAction {
    BIND_MOBILE("/wp/bindwidget-bindmobile", "绑定手机"),
    BIND_EMAIL("/wp/bindwidget-bindemail", "绑定邮箱"),
    REBIND_MOBILE("/wp/bindwidget-rebindmobile", "换绑手机"),
    REBIND_EMAIL("/wp/bindwidget-rebindemail", "换绑邮箱"),
    UNBIND_MOBILE("/wp/bindwidget-unbindmobile", "解绑手机"),
    UNBIND_EMAIL("/wp/bindwidget-unbindemail", "解绑邮箱");
    

    /* renamed from: a  reason: collision with root package name */
    private String f5396a;

    /* renamed from: b  reason: collision with root package name */
    private String f5397b;

    BindWidgetAction(String str, String str2) {
        this.f5396a = str;
        this.f5397b = str2;
    }

    public String getName() {
        return this.f5397b;
    }

    public String getUri() {
        return this.f5396a;
    }
}
