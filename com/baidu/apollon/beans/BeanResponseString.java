package com.baidu.apollon.beans;
/* loaded from: classes.dex */
public class BeanResponseString extends BeanResponseBase {
    public String content = null;

    @Override // com.baidu.apollon.beans.BeanResponseBase
    public String getRealResponseContent() {
        String str = this.content;
        return str != null ? str.toString() : "";
    }

    @Override // com.baidu.apollon.beans.BeanResponseBase
    public String getToken() {
        return this.token;
    }
}
