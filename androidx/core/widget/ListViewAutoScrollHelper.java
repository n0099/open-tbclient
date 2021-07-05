package androidx.core.widget;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ListView mTarget;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewAutoScrollHelper(@NonNull ListView listView) {
        super(listView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTarget = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ListView listView = this.mTarget;
            int count = listView.getCount();
            if (count == 0) {
                return false;
            }
            int childCount = listView.getChildCount();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int i3 = firstVisiblePosition + childCount;
            if (i2 > 0) {
                if (i3 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                    return false;
                }
            } else if (i2 >= 0) {
                return false;
            } else {
                if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void scrollTargetBy(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            ListViewCompat.scrollListBy(this.mTarget, i3);
        }
    }
}
