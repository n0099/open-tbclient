package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e {
    private static ArrayList<MediaModel> dmK;

    public static ArrayList<MediaModel> aBw() {
        return dmK;
    }

    public static int aBx() {
        if (dmK == null) {
            return 0;
        }
        return dmK.size();
    }

    public static String aBy() {
        if (dmK == null || dmK.size() == 0 || dmK.get(0) == null) {
            return null;
        }
        return dmK.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (dmK == null || dmK.size() == 0) {
            return false;
        }
        return dmK.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || dmK == null) {
            return -1;
        }
        int size = dmK.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(dmK.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (dmK != null) {
            dmK.clear();
            dmK = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (dmK == null) {
                dmK = new ArrayList<>();
            }
            dmK.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (dmK != null) {
            dmK.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (dmK == null) {
            return false;
        }
        return dmK.contains(mediaModel);
    }
}
