package c.a.a0.v.d0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.helper.ViewOpUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) {
            if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    c.a.a0.v.v0.h.b(ViewOpUtils.TAG, "removeView " + view.hashCode());
                    viewGroup.removeView(view);
                    return true;
                } catch (Exception e2) {
                    c.a.a0.v.v0.h.f("removeView(" + System.identityHashCode(view) + SmallTailInfo.EMOTION_SUFFIX, e2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
