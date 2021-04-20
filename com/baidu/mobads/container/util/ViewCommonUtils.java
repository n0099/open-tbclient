package com.baidu.mobads.container.util;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ViewCommonUtils {
    public static final String TAG = "ViewCommonUtils";

    public static Bitmap getCacheBitmapFromView(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
            view.setDrawingCacheEnabled(false);
            return createBitmap;
        }
        return null;
    }

    public static void showDirectChildList(ViewGroup viewGroup) {
        Log.e(TAG, "==============Child list of " + viewGroup + " ===============");
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            Log.e(TAG, "child " + i + ZeusCrashHandler.NAME_SEPERATOR + viewGroup.getChildAt(i));
        }
        Log.e(TAG, "==============Child list of " + viewGroup + " ===============");
    }

    public static int traverseViewGroup(View view) {
        int i;
        if (view == null) {
            return 0;
        }
        Log.e(TAG, "[==============View tree of " + view + " ===============]");
        Log.e(TAG, "view no.0" + ZeusCrashHandler.NAME_SEPERATOR + view);
        if (view instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.add((ViewGroup) view);
            i = 0;
            while (!linkedList.isEmpty()) {
                ViewGroup viewGroup = (ViewGroup) linkedList.removeFirst();
                i++;
                Log.e(TAG, "---------------Children for " + viewGroup + "---------------");
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    Log.e(TAG, "view no." + i + ZeusCrashHandler.NAME_SEPERATOR + viewGroup.getChildAt(i2));
                    if (viewGroup.getChildAt(i2) instanceof ViewGroup) {
                        linkedList.addLast((ViewGroup) viewGroup.getChildAt(i2));
                    } else {
                        i++;
                    }
                }
            }
        } else {
            Log.e(TAG, "view no.0" + ZeusCrashHandler.NAME_SEPERATOR + view);
            i = 1;
        }
        Log.e(TAG, "[==============View tree of " + view + " ===============]");
        return i;
    }
}
