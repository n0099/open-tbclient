package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> cbN;

    public static ArrayList<MediaModel> afI() {
        return cbN;
    }

    public static int getSelectedCount() {
        if (cbN == null) {
            return 0;
        }
        return cbN.size();
    }

    public static String afJ() {
        if (cbN == null || cbN.size() == 0 || cbN.get(0) == null) {
            return null;
        }
        return cbN.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cbN == null || cbN.size() == 0) {
            return false;
        }
        return cbN.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cbN == null) {
            return -1;
        }
        int size = cbN.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cbN.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cbN != null) {
            cbN.clear();
            cbN = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cbN == null) {
                cbN = new ArrayList<>();
            }
            cbN.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cbN != null) {
            cbN.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cbN == null) {
            return false;
        }
        return cbN.contains(mediaModel);
    }
}
