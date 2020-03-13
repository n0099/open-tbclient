package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> bCY;

    public static ArrayList<MediaModel> XJ() {
        return bCY;
    }

    public static int getSelectedCount() {
        if (bCY == null) {
            return 0;
        }
        return bCY.size();
    }

    public static String XK() {
        if (bCY == null || bCY.size() == 0 || bCY.get(0) == null) {
            return null;
        }
        return bCY.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (bCY == null || bCY.size() == 0) {
            return false;
        }
        return bCY.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || bCY == null) {
            return -1;
        }
        int size = bCY.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(bCY.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (bCY != null) {
            bCY.clear();
            bCY = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (bCY == null) {
                bCY = new ArrayList<>();
            }
            bCY.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (bCY != null) {
            bCY.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (bCY == null) {
            return false;
        }
        return bCY.contains(mediaModel);
    }
}
