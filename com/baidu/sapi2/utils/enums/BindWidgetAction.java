package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum BindWidgetAction {
    BIND_MOBILE("/wp/bindwidget-bindmobile", "绑定手机"),
    BIND_EMAIL("/wp/bindwidget-bindemail", "绑定邮箱"),
    REBIND_MOBILE("/wp/bindwidget-rebindmobile", "换绑手机"),
    REBIND_EMAIL("/wp/bindwidget-rebindemail", "换绑邮箱"),
    UNBIND_MOBILE("/wp/bindwidget-unbindmobile", "解绑手机"),
    UNBIND_EMAIL("/wp/bindwidget-unbindemail", "解绑邮箱");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11468a;

    /* renamed from: b  reason: collision with root package name */
    public String f11469b;

    BindWidgetAction(String str, String str2) {
        this.f11468a = str;
        this.f11469b = str2;
    }

    public String getName() {
        return this.f11469b;
    }

    public String getUri() {
        return this.f11468a;
    }
}
