package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private static ArrayList<MediaModel> ddx;

    public static ArrayList<MediaModel> aAV() {
        return ddx;
    }

    public static int getSelectedCount() {
        if (ddx == null) {
            return 0;
        }
        return ddx.size();
    }

    public static String aAW() {
        if (ddx == null || ddx.size() == 0 || ddx.get(0) == null) {
            return null;
        }
        return ddx.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (ddx == null || ddx.size() == 0) {
            return false;
        }
        return ddx.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || ddx == null) {
            return -1;
        }
        int size = ddx.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(ddx.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (ddx != null) {
            ddx.clear();
            ddx = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (ddx == null) {
                ddx = new ArrayList<>();
            }
            ddx.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (ddx != null) {
            ddx.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (ddx == null) {
            return false;
        }
        return ddx.contains(mediaModel);
    }
}
