package com.baidu.searchbox.dyesdk.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/dyesdk/data/DyeInfo;", "", "bizName", "", "nodeName", "dyeId", "startTime", "endTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizName", "()Ljava/lang/String;", "getDyeId", "getEndTime", "getNodeName", "getStartTime", "lib-dye-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DyeInfo {
    public final String bizName;
    public final String dyeId;
    public final String endTime;
    public final String nodeName;
    public final String startTime;

    public DyeInfo(String bizName, String nodeName, String dyeId, String startTime, String endTime) {
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(dyeId, "dyeId");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.bizName = bizName;
        this.nodeName = nodeName;
        this.dyeId = dyeId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final String getDyeId() {
        return this.dyeId;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public final String getStartTime() {
        return this.startTime;
    }
}
