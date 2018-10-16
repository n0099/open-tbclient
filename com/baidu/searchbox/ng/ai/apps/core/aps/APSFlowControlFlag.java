package com.baidu.searchbox.ng.ai.apps.core.aps;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public final class APSFlowControlFlag {
    private static final int APP_INFO_GET_THEN_UPDATE_DB = 2;
    private static final int APS_ERROR_THEN_LOAD_LOCAL = 16;
    private static final int APS_INFO_GET_THEN_DOWNLOAD_ICON = 1;
    private static final int DB_UPDATE_THEN_START_AI_APP = 4;
    private static final int EMPTY_PACKAGE_THEN_LOAD_LOCAL = 8;

    public static int getAsynDownloadFlowFlag() {
        return 3;
    }

    public static int getCompleteFlowFlag() {
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static boolean apsInfoGetThenDownloadIcon(int i) {
        return (i & 1) == 1;
    }

    public static boolean appInfoGetThenUpdateDb(int i) {
        return (i & 2) == 2;
    }

    public static boolean dbUpdateThenStartAiAppActivity(int i) {
        return (i & 4) == 4;
    }

    public static boolean isNeedStartAiAppActivity(int i) {
        return dbUpdateThenStartAiAppActivity(i);
    }

    public static boolean emptyPackageThenLoadLocal(int i) {
        return (i & 8) == 8;
    }

    public static boolean apsErrorThenLoadLocal(int i) {
        return (i & 16) == 16;
    }

    public static boolean isAsyncDownloadFlow(int i) {
        return i == getAsynDownloadFlowFlag();
    }
}
