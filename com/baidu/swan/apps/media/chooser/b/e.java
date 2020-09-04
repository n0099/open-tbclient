package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e {
    private static ArrayList<MediaModel> cBa;

    public static ArrayList<MediaModel> ath() {
        return cBa;
    }

    public static int getSelectedCount() {
        if (cBa == null) {
            return 0;
        }
        return cBa.size();
    }

    public static String ati() {
        if (cBa == null || cBa.size() == 0 || cBa.get(0) == null) {
            return null;
        }
        return cBa.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cBa == null || cBa.size() == 0) {
            return false;
        }
        return cBa.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cBa == null) {
            return -1;
        }
        int size = cBa.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cBa.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cBa != null) {
            cBa.clear();
            cBa = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cBa == null) {
                cBa = new ArrayList<>();
            }
            cBa.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cBa != null) {
            cBa.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cBa == null) {
            return false;
        }
        return cBa.contains(mediaModel);
    }
}
