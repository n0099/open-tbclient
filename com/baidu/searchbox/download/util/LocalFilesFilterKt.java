package com.baidu.searchbox.download.util;

import com.baidu.searchbox.download.model.CategoryInfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"FILTER_NAME_COLD_START", "", "FILTER_NAME_DUMP", "FILTER_NAME_LOG", "FILTER_NAME_TBS", "FILTER_NAME_TRACE", "FILTER_NAME_UID", "filterCategoryInfoData", "", "data", "Lcom/baidu/searchbox/download/model/CategoryInfoData;", "filterSystemLogName", "fileName", "lib-download_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalFilesFilterKt {
    public static final String FILTER_NAME_COLD_START = "cold_start";
    public static final String FILTER_NAME_DUMP = "dump";
    public static final String FILTER_NAME_LOG = "log";
    public static final String FILTER_NAME_TBS = "tbs";
    public static final String FILTER_NAME_TRACE = "trace";
    public static final String FILTER_NAME_UID = "uid";

    public static final boolean filterCategoryInfoData(CategoryInfoData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return filterSystemLogName(data.mFileName);
    }

    public static final boolean filterSystemLogName(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        if (!StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) FILTER_NAME_LOG, true) && !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "tbs", true) && !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) FILTER_NAME_DUMP, true) && !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "trace", true) && !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "cold_start", true) && !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "uid", true)) {
            return false;
        }
        return true;
    }
}
