package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> bDj;

    public static ArrayList<MediaModel> XM() {
        return bDj;
    }

    public static int getSelectedCount() {
        if (bDj == null) {
            return 0;
        }
        return bDj.size();
    }

    public static String XN() {
        if (bDj == null || bDj.size() == 0 || bDj.get(0) == null) {
            return null;
        }
        return bDj.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (bDj == null || bDj.size() == 0) {
            return false;
        }
        return bDj.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || bDj == null) {
            return -1;
        }
        int size = bDj.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(bDj.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (bDj != null) {
            bDj.clear();
            bDj = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (bDj == null) {
                bDj = new ArrayList<>();
            }
            bDj.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (bDj != null) {
            bDj.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (bDj == null) {
            return false;
        }
        return bDj.contains(mediaModel);
    }
}
