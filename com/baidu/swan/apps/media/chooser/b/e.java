package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private static ArrayList<MediaModel> cbH;

    public static ArrayList<MediaModel> afJ() {
        return cbH;
    }

    public static int getSelectedCount() {
        if (cbH == null) {
            return 0;
        }
        return cbH.size();
    }

    public static String afK() {
        if (cbH == null || cbH.size() == 0 || cbH.get(0) == null) {
            return null;
        }
        return cbH.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (cbH == null || cbH.size() == 0) {
            return false;
        }
        return cbH.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || cbH == null) {
            return -1;
        }
        int size = cbH.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(cbH.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (cbH != null) {
            cbH.clear();
            cbH = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (cbH == null) {
                cbH = new ArrayList<>();
            }
            cbH.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (cbH != null) {
            cbH.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (cbH == null) {
            return false;
        }
        return cbH.contains(mediaModel);
    }
}
