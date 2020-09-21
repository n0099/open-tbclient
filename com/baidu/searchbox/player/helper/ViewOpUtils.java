package com.baidu.searchbox.player.helper;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes8.dex */
public class ViewOpUtils {
    private static final String TAG = "ViewOpUtils";

    @PublicMethod
    public static boolean removeView(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    BdVideoLog.d(TAG, "removeView " + view.hashCode());
                    viewGroup.removeView(view);
                } catch (Exception e) {
                    BdVideoLog.e(TAG, "remove view ex");
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }
}
