package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ListViewCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ListViewCompat() {
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

    public static boolean canScrollList(@NonNull ListView listView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, listView, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return listView.canScrollList(i2);
            }
            int childCount = listView.getChildCount();
            if (childCount == 0) {
                return false;
            }
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            if (i2 > 0) {
                return firstVisiblePosition + childCount < listView.getCount() || listView.getChildAt(childCount + (-1)).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
            }
            return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
        }
        return invokeLI.booleanValue;
    }

    public static void scrollListBy(@NonNull ListView listView, int i2) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, listView, i2) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                listView.scrollListBy(i2);
                return;
            }
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
                return;
            }
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i2);
        }
    }
}
