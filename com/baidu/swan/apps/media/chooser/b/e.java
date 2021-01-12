package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e {
    private static ArrayList<MediaModel> diY;

    public static ArrayList<MediaModel> aAV() {
        return diY;
    }

    public static int aAW() {
        if (diY == null) {
            return 0;
        }
        return diY.size();
    }

    public static String aAX() {
        if (diY == null || diY.size() == 0 || diY.get(0) == null) {
            return null;
        }
        return diY.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (diY == null || diY.size() == 0) {
            return false;
        }
        return diY.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || diY == null) {
            return -1;
        }
        int size = diY.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(diY.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (diY != null) {
            diY.clear();
            diY = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (diY == null) {
                diY = new ArrayList<>();
            }
            diY.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (diY != null) {
            diY.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (diY == null) {
            return false;
        }
        return diY.contains(mediaModel);
    }
}
