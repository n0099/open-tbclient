package com.baidu.searchbox.ng.ai.apps.media;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class AiAppsPlayerManager {
    private static ArrayList<AiAppsPlayerContext> sPlayerList = new ArrayList<>();

    public static void onForegroundStateChanged(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = sPlayerList.size() - 1; size >= 0; size--) {
                AiAppsPlayerContext aiAppsPlayerContext = sPlayerList.get(size);
                if (aiAppsPlayerContext != null && TextUtils.equals(str, aiAppsPlayerContext.getSlaveId())) {
                    aiAppsPlayerContext.onForegroundChanged(z);
                }
            }
        }
    }

    public static void onAppForegroundChanged(boolean z) {
        for (int size = sPlayerList.size() - 1; size >= 0; size--) {
            AiAppsPlayerContext aiAppsPlayerContext = sPlayerList.get(size);
            if (aiAppsPlayerContext != null) {
                aiAppsPlayerContext.onAppForegroundChanged(z);
            }
        }
    }

    public static AiAppsPlayerContext getPlayerContext(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = sPlayerList.size() - 1; size >= 0; size--) {
            AiAppsPlayerContext aiAppsPlayerContext = sPlayerList.get(size);
            if (aiAppsPlayerContext != null && TextUtils.equals(str, aiAppsPlayerContext.getPlayerId())) {
                return aiAppsPlayerContext;
            }
        }
        return null;
    }

    public static void addPlayerContext(AiAppsPlayerContext aiAppsPlayerContext) {
        if (aiAppsPlayerContext != null && !sPlayerList.contains(aiAppsPlayerContext)) {
            sPlayerList.add(aiAppsPlayerContext);
        }
    }

    public static void removePlayerContext(AiAppsPlayerContext aiAppsPlayerContext) {
        if (aiAppsPlayerContext != null) {
            sPlayerList.remove(aiAppsPlayerContext);
        }
    }

    public static void clearAllPlayerContext() {
        sPlayerList.clear();
    }

    public static boolean handleBackPressed(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = sPlayerList.size() - 1; size >= 0; size--) {
            AiAppsPlayerContext aiAppsPlayerContext = sPlayerList.get(size);
            if (aiAppsPlayerContext != null && TextUtils.equals(str, aiAppsPlayerContext.getSlaveId()) && aiAppsPlayerContext.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = sPlayerList.size() - 1; size >= 0; size--) {
                AiAppsPlayerContext aiAppsPlayerContext = sPlayerList.get(size);
                if (aiAppsPlayerContext != null && TextUtils.equals(str, aiAppsPlayerContext.getSlaveId())) {
                    aiAppsPlayerContext.onDestroy();
                }
            }
        }
    }

    public static ArrayList<AiAppsPlayerContext> getPlayerList() {
        return sPlayerList;
    }
}
