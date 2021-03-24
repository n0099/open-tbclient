package com.baidu.searchbox.pms.download;
/* loaded from: classes.dex */
public class DownloadOptions {
    public static final int PRIORITY_BACKGROUND = 2;
    public static final int PRIORITY_DEFAULT = 1;
    public static final int PRIORITY_SPECIAL = 4;
    public static final int PRIORITY_USER_INTERACTIVE = 3;
    public String fileDir;
    public int priority;
    public boolean forceAnyEnv = true;
    public boolean saveToDb = true;
}
