package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> cmr;

    public static ArrayList<MediaModel> aiX() {
        return cmr;
    }

    public static int getSelectedCount() {
        if (cmr == null) {
            return 0;
        }
        return cmr.size();
    }

    public static String aiY() {
        if (cmr == null || cmr.size() == 0 || cmr.get(0) == null) {
            return null;
        }
        return cmr.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cmr == null || cmr.size() == 0) {
            return false;
        }
        return cmr.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cmr == null) {
            return -1;
        }
        int size = cmr.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cmr.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cmr != null) {
            cmr.clear();
            cmr = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cmr == null) {
                cmr = new ArrayList<>();
            }
            cmr.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cmr != null) {
            cmr.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cmr == null) {
            return false;
        }
        return cmr.contains(mediaModel);
    }
}
