package com.baidu.searchbox.vip;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/vip/VipEquitiesType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "VIDEO_DOWNLOAD", "PDF_TO_WORD", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum VipEquitiesType {
    VIDEO_DOWNLOAD("video_download"),
    PDF_TO_WORD("pdf_to_word");
    
    public final String type;

    public final String getType() {
        return this.type;
    }

    VipEquitiesType(String str) {
        this.type = str;
    }
}
