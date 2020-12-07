package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class e {
    private static ArrayList<MediaModel> diO;

    public static ArrayList<MediaModel> aDw() {
        return diO;
    }

    public static int getSelectedCount() {
        if (diO == null) {
            return 0;
        }
        return diO.size();
    }

    public static String aDx() {
        if (diO == null || diO.size() == 0 || diO.get(0) == null) {
            return null;
        }
        return diO.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (diO == null || diO.size() == 0) {
            return false;
        }
        return diO.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || diO == null) {
            return -1;
        }
        int size = diO.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(diO.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (diO != null) {
            diO.clear();
            diO = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (diO == null) {
                diO = new ArrayList<>();
            }
            diO.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (diO != null) {
            diO.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (diO == null) {
            return false;
        }
        return diO.contains(mediaModel);
    }
}
