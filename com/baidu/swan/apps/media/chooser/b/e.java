package com.baidu.swan.apps.media.chooser.b;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    private static ArrayList<MediaModel> dbN;

    public static ArrayList<MediaModel> aAn() {
        return dbN;
    }

    public static int getSelectedCount() {
        if (dbN == null) {
            return 0;
        }
        return dbN.size();
    }

    public static String aAo() {
        if (dbN == null || dbN.size() == 0 || dbN.get(0) == null) {
            return null;
        }
        return dbN.get(0).getType();
    }

    public static boolean c(MediaModel mediaModel) {
        if (dbN == null || dbN.size() == 0) {
            return false;
        }
        return dbN.contains(mediaModel);
    }

    public static int d(MediaModel mediaModel) {
        if (mediaModel == null || dbN == null) {
            return -1;
        }
        int size = dbN.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(dbN.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void clear() {
        if (dbN != null) {
            dbN.clear();
            dbN = null;
        }
    }

    public static void e(MediaModel mediaModel) {
        if (mediaModel != null) {
            if (dbN == null) {
                dbN = new ArrayList<>();
            }
            dbN.add(mediaModel);
        }
    }

    public static void f(MediaModel mediaModel) {
        if (dbN != null) {
            dbN.remove(mediaModel);
        }
    }

    public static boolean g(MediaModel mediaModel) {
        if (dbN == null) {
            return false;
        }
        return dbN.contains(mediaModel);
    }
}
