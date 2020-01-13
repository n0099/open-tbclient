package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private static ArrayList<MediaModel> byP;

    public static ArrayList<MediaModel> Vt() {
        return byP;
    }

    public static int getSelectedCount() {
        if (byP == null) {
            return 0;
        }
        return byP.size();
    }

    public static String Vu() {
        if (byP == null || byP.size() == 0 || byP.get(0) == null) {
            return null;
        }
        return byP.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (byP == null || byP.size() == 0) {
            return false;
        }
        return byP.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || byP == null) {
            return -1;
        }
        int size = byP.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(byP.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (byP != null) {
            byP.clear();
            byP = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (byP == null) {
                byP = new ArrayList<>();
            }
            byP.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (byP != null) {
            byP.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (byP == null) {
            return false;
        }
        return byP.contains(mediaModel);
    }
}
