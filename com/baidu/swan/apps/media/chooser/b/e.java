package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> bCW;

    public static ArrayList<MediaModel> XH() {
        return bCW;
    }

    public static int getSelectedCount() {
        if (bCW == null) {
            return 0;
        }
        return bCW.size();
    }

    public static String XI() {
        if (bCW == null || bCW.size() == 0 || bCW.get(0) == null) {
            return null;
        }
        return bCW.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (bCW == null || bCW.size() == 0) {
            return false;
        }
        return bCW.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || bCW == null) {
            return -1;
        }
        int size = bCW.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(bCW.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (bCW != null) {
            bCW.clear();
            bCW = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (bCW == null) {
                bCW = new ArrayList<>();
            }
            bCW.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (bCW != null) {
            bCW.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (bCW == null) {
            return false;
        }
        return bCW.contains(mediaModel);
    }
}
