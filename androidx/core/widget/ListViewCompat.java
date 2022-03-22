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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean canScrollList(@NonNull ListView listView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, listView, i)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return listView.canScrollList(i);
            }
            int childCount = listView.getChildCount();
            if (childCount == 0) {
                return false;
            }
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            if (i > 0) {
                return firstVisiblePosition + childCount < listView.getCount() || listView.getChildAt(childCount + (-1)).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
            }
            return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
        }
        return invokeLI.booleanValue;
    }

    public static void scrollListBy(@NonNull ListView listView, int i) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, listView, i) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                listView.scrollListBy(i);
                return;
            }
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
                return;
            }
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }
}
