package com.baidu.searchbox.pms.download;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes4.dex */
public class DownloadStatus {
    public static final int CANCEL = 5;
    public static final int ERROR = 6;
    public static final int NONE = 0;
    public static final int PAUSE = 3;
    public static final int RESUME = 4;
    public static final int START = 2;
    public static final int SUCCESS = 10;
    public static final int WAIT = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Status {
    }
}
