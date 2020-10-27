package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private static ArrayList<MediaModel> cXB;

    public static ArrayList<MediaModel> ayv() {
        return cXB;
    }

    public static int getSelectedCount() {
        if (cXB == null) {
            return 0;
        }
        return cXB.size();
    }

    public static String ayw() {
        if (cXB == null || cXB.size() == 0 || cXB.get(0) == null) {
            return null;
        }
        return cXB.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cXB == null || cXB.size() == 0) {
            return false;
        }
        return cXB.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cXB == null) {
            return -1;
        }
        int size = cXB.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cXB.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cXB != null) {
            cXB.clear();
            cXB = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cXB == null) {
                cXB = new ArrayList<>();
            }
            cXB.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cXB != null) {
            cXB.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cXB == null) {
            return false;
        }
        return cXB.contains(mediaModel);
    }
}
