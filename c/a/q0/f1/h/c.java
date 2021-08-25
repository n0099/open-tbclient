package c.a.q0.f1.h;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f17662a;

    /* renamed from: b  reason: collision with root package name */
    public static int f17663b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(771330553, "Lc/a/q0/f1/h/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(771330553, "Lc/a/q0/f1/h/c;");
        }
    }

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity != null) {
                try {
                    return activity.isInMultiWindowMode();
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null) {
            return;
        }
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        View childAt = bdTypeRecyclerView.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : 0;
        f17662a = firstVisiblePosition;
        f17663b = top;
    }

    public static void c(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || f17662a > bdTypeRecyclerView.getCount() - 1) {
            return;
        }
        bdTypeRecyclerView.requestFocusFromTouch();
        ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(f17662a, f17663b);
        f17662a = 0;
        f17663b = 0;
    }
}
