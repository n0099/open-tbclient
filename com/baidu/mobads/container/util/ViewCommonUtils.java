package com.baidu.mobads.container.util;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ViewCommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewCommonUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ViewCommonUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Bitmap getCacheBitmapFromView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }

    public static void showDirectChildList(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, viewGroup) == null) {
            Log.e(TAG, "==============Child list of " + viewGroup + " ===============");
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                Log.e(TAG, "child " + i2 + ZeusCrashHandler.NAME_SEPERATOR + viewGroup.getChildAt(i2));
            }
            Log.e(TAG, "==============Child list of " + viewGroup + " ===============");
        }
    }

    public static int traverseViewGroup(View view) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            Log.e(TAG, "[==============View tree of " + view + " ===============]");
            Log.e(TAG, "view no.0" + ZeusCrashHandler.NAME_SEPERATOR + view);
            if (view instanceof ViewGroup) {
                LinkedList linkedList = new LinkedList();
                linkedList.add((ViewGroup) view);
                i2 = 0;
                while (!linkedList.isEmpty()) {
                    ViewGroup viewGroup = (ViewGroup) linkedList.removeFirst();
                    i2++;
                    Log.e(TAG, "---------------Children for " + viewGroup + "---------------");
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        Log.e(TAG, "view no." + i2 + ZeusCrashHandler.NAME_SEPERATOR + viewGroup.getChildAt(i3));
                        if (viewGroup.getChildAt(i3) instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) viewGroup.getChildAt(i3));
                        } else {
                            i2++;
                        }
                    }
                }
            } else {
                Log.e(TAG, "view no.0" + ZeusCrashHandler.NAME_SEPERATOR + view);
                i2 = 1;
            }
            Log.e(TAG, "[==============View tree of " + view + " ===============]");
            return i2;
        }
        return invokeL.intValue;
    }
}
