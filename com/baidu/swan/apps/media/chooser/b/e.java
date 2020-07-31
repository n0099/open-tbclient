package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    private static ArrayList<MediaModel> cti;

    public static ArrayList<MediaModel> alt() {
        return cti;
    }

    public static int getSelectedCount() {
        if (cti == null) {
            return 0;
        }
        return cti.size();
    }

    public static String alu() {
        if (cti == null || cti.size() == 0 || cti.get(0) == null) {
            return null;
        }
        return cti.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cti == null || cti.size() == 0) {
            return false;
        }
        return cti.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cti == null) {
            return -1;
        }
        int size = cti.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cti.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cti != null) {
            cti.clear();
            cti = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cti == null) {
                cti = new ArrayList<>();
            }
            cti.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cti != null) {
            cti.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cti == null) {
            return false;
        }
        return cti.contains(mediaModel);
    }
}
