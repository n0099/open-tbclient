package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class e {
    private static ArrayList<MediaModel> byc;

    public static ArrayList<MediaModel> UW() {
        return byc;
    }

    public static int getSelectedCount() {
        if (byc == null) {
            return 0;
        }
        return byc.size();
    }

    public static String UX() {
        if (byc == null || byc.size() == 0 || byc.get(0) == null) {
            return null;
        }
        return byc.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (byc == null || byc.size() == 0) {
            return false;
        }
        return byc.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || byc == null) {
            return -1;
        }
        int size = byc.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(byc.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (byc != null) {
            byc.clear();
            byc = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (byc == null) {
                byc = new ArrayList<>();
            }
            byc.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (byc != null) {
            byc.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (byc == null) {
            return false;
        }
        return byc.contains(mediaModel);
    }
}
