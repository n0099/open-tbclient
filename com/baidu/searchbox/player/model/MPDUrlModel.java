package com.baidu.searchbox.player.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/model/MPDUrlModel;", "Lcom/baidu/searchbox/player/model/VideoUrlModel;", "encodedUrl", "", "(Ljava/lang/String;)V", "getEncodedUrl", "()Ljava/lang/String;", "setEncodedUrl", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class MPDUrlModel extends VideoUrlModel {
    public String encodedUrl;

    public MPDUrlModel() {
        this(null, 1, null);
    }

    public MPDUrlModel(String str) {
        super(null, null, false, 0, null, false, 63, null);
        this.encodedUrl = str;
    }

    public final void setEncodedUrl(String str) {
        this.encodedUrl = str;
    }

    public /* synthetic */ MPDUrlModel(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getEncodedUrl() {
        return this.encodedUrl;
    }
}
