package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e {
    private static ArrayList<MediaModel> cAW;

    public static ArrayList<MediaModel> ath() {
        return cAW;
    }

    public static int getSelectedCount() {
        if (cAW == null) {
            return 0;
        }
        return cAW.size();
    }

    public static String ati() {
        if (cAW == null || cAW.size() == 0 || cAW.get(0) == null) {
            return null;
        }
        return cAW.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cAW == null || cAW.size() == 0) {
            return false;
        }
        return cAW.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cAW == null) {
            return -1;
        }
        int size = cAW.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cAW.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cAW != null) {
            cAW.clear();
            cAW = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cAW == null) {
                cAW = new ArrayList<>();
            }
            cAW.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cAW != null) {
            cAW.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cAW == null) {
            return false;
        }
        return cAW.contains(mediaModel);
    }
}
