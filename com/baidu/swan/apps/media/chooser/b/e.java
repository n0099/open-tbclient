package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> bCX;

    public static ArrayList<MediaModel> XJ() {
        return bCX;
    }

    public static int getSelectedCount() {
        if (bCX == null) {
            return 0;
        }
        return bCX.size();
    }

    public static String XK() {
        if (bCX == null || bCX.size() == 0 || bCX.get(0) == null) {
            return null;
        }
        return bCX.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (bCX == null || bCX.size() == 0) {
            return false;
        }
        return bCX.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || bCX == null) {
            return -1;
        }
        int size = bCX.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(bCX.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (bCX != null) {
            bCX.clear();
            bCX = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (bCX == null) {
                bCX = new ArrayList<>();
            }
            bCX.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (bCX != null) {
            bCX.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (bCX == null) {
            return false;
        }
        return bCX.contains(mediaModel);
    }
}
