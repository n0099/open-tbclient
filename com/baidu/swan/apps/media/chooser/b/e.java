package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class e {
    private static ArrayList<MediaModel> dnL;

    public static ArrayList<MediaModel> aEP() {
        return dnL;
    }

    public static int aEQ() {
        if (dnL == null) {
            return 0;
        }
        return dnL.size();
    }

    public static String aER() {
        if (dnL == null || dnL.size() == 0 || dnL.get(0) == null) {
            return null;
        }
        return dnL.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (dnL == null || dnL.size() == 0) {
            return false;
        }
        return dnL.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || dnL == null) {
            return -1;
        }
        int size = dnL.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(dnL.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (dnL != null) {
            dnL.clear();
            dnL = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (dnL == null) {
                dnL = new ArrayList<>();
            }
            dnL.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (dnL != null) {
            dnL.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (dnL == null) {
            return false;
        }
        return dnL.contains(mediaModel);
    }
}
