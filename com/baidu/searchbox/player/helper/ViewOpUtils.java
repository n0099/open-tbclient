package com.baidu.searchbox.player.helper;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class ViewOpUtils {
    public static final String TAG = "ViewOpUtils";

    @PublicMethod
    public static boolean removeView(View view2) {
        if (view2 != null && view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.indexOfChild(view2) != -1) {
                try {
                    BdVideoLog.d(TAG, "removeView " + view2.hashCode());
                    viewGroup.removeView(view2);
                    return true;
                } catch (Exception e) {
                    BdVideoLog.e("removeView(" + System.identityHashCode(view2) + SmallTailInfo.EMOTION_SUFFIX, e);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
