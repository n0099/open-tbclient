package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private static ArrayList<MediaModel> cDa;

    public static ArrayList<MediaModel> atQ() {
        return cDa;
    }

    public static int getSelectedCount() {
        if (cDa == null) {
            return 0;
        }
        return cDa.size();
    }

    public static String atR() {
        if (cDa == null || cDa.size() == 0 || cDa.get(0) == null) {
            return null;
        }
        return cDa.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cDa == null || cDa.size() == 0) {
            return false;
        }
        return cDa.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cDa == null) {
            return -1;
        }
        int size = cDa.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cDa.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cDa != null) {
            cDa.clear();
            cDa = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cDa == null) {
                cDa = new ArrayList<>();
            }
            cDa.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cDa != null) {
            cDa.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cDa == null) {
            return false;
        }
        return cDa.contains(mediaModel);
    }
}
