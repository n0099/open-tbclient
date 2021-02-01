package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class e {
    private static ArrayList<MediaModel> dlj;

    public static ArrayList<MediaModel> aBt() {
        return dlj;
    }

    public static int aBu() {
        if (dlj == null) {
            return 0;
        }
        return dlj.size();
    }

    public static String aBv() {
        if (dlj == null || dlj.size() == 0 || dlj.get(0) == null) {
            return null;
        }
        return dlj.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (dlj == null || dlj.size() == 0) {
            return false;
        }
        return dlj.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || dlj == null) {
            return -1;
        }
        int size = dlj.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(dlj.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (dlj != null) {
            dlj.clear();
            dlj = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (dlj == null) {
                dlj = new ArrayList<>();
            }
            dlj.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (dlj != null) {
            dlj.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (dlj == null) {
            return false;
        }
        return dlj.contains(mediaModel);
    }
}
