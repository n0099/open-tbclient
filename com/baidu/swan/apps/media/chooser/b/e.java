package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> crf;

    public static ArrayList<MediaModel> akd() {
        return crf;
    }

    public static int getSelectedCount() {
        if (crf == null) {
            return 0;
        }
        return crf.size();
    }

    public static String ake() {
        if (crf == null || crf.size() == 0 || crf.get(0) == null) {
            return null;
        }
        return crf.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (crf == null || crf.size() == 0) {
            return false;
        }
        return crf.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || crf == null) {
            return -1;
        }
        int size = crf.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(crf.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (crf != null) {
            crf.clear();
            crf = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (crf == null) {
                crf = new ArrayList<>();
            }
            crf.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (crf != null) {
            crf.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (crf == null) {
            return false;
        }
        return crf.contains(mediaModel);
    }
}
