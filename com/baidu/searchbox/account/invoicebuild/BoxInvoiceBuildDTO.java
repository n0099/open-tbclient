package com.baidu.searchbox.account.invoicebuild;
/* loaded from: classes3.dex */
public class BoxInvoiceBuildDTO {
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public String TYPE = "0";
    public boolean isExamineVAT = false;
    public String source;
    public String tplse;
    public String tplt;

    public BoxInvoiceBuildDTO(String str, String str2, String str3) {
        this.tplse = str;
        this.tplt = str2;
        this.source = str3;
    }
}
