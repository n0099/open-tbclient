package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private static ArrayList<MediaModel> cPf;

    public static ArrayList<MediaModel> awB() {
        return cPf;
    }

    public static int getSelectedCount() {
        if (cPf == null) {
            return 0;
        }
        return cPf.size();
    }

    public static String awC() {
        if (cPf == null || cPf.size() == 0 || cPf.get(0) == null) {
            return null;
        }
        return cPf.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cPf == null || cPf.size() == 0) {
            return false;
        }
        return cPf.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cPf == null) {
            return -1;
        }
        int size = cPf.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cPf.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cPf != null) {
            cPf.clear();
            cPf = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cPf == null) {
                cPf = new ArrayList<>();
            }
            cPf.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cPf != null) {
            cPf.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cPf == null) {
            return false;
        }
        return cPf.contains(mediaModel);
    }
}
