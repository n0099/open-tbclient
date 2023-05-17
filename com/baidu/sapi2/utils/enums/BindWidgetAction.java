package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.dto.BoxWebBindWidgetDTOKt;
/* loaded from: classes3.dex */
public enum BindWidgetAction {
    BIND_MOBILE(BoxWebBindWidgetDTOKt.BIND_MOBILE, "绑定手机"),
    BIND_EMAIL(BoxWebBindWidgetDTOKt.BIND_EMAIL, "绑定邮箱"),
    REBIND_MOBILE(BoxWebBindWidgetDTOKt.REBIND_MOBILE, "换绑手机"),
    REBIND_EMAIL(BoxWebBindWidgetDTOKt.REBIND_EMAIL, "换绑邮箱"),
    UNBIND_MOBILE(BoxWebBindWidgetDTOKt.UNBIND_MOBILE, "解绑手机"),
    UNBIND_EMAIL(BoxWebBindWidgetDTOKt.UNBIND_EMAIL, "解绑邮箱");
    
    public String name;
    public String uri;

    BindWidgetAction(String str, String str2) {
        this.uri = str;
        this.name = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getUri() {
        return this.uri;
    }
}
