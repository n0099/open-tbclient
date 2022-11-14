package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final ItemTouchUIUtil INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, recyclerView, view2, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-956189933, "Landroidx/recyclerview/widget/ItemTouchUIUtilImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-956189933, "Landroidx/recyclerview/widget/ItemTouchUIUtilImpl;");
                return;
            }
        }
        INSTANCE = new ItemTouchUIUtilImpl();
    }

    public ItemTouchUIUtilImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static float findMaxElevation(RecyclerView recyclerView, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, recyclerView, view2)) == null) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view2) {
                    float elevation = ViewCompat.getElevation(childAt);
                    if (elevation > f) {
                        f = elevation;
                    }
                }
            }
            return f;
        }
        return invokeLL.floatValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091013);
                if (tag instanceof Float) {
                    ViewCompat.setElevation(view2, ((Float) tag).floatValue());
                }
                view2.setTag(R.id.obfuscated_res_0x7f091013, null);
            }
            view2.setTranslationX(0.0f);
            view2.setTranslationY(0.0f);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, recyclerView, view2, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (Build.VERSION.SDK_INT >= 21 && z && view2.getTag(R.id.obfuscated_res_0x7f091013) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view2));
                ViewCompat.setElevation(view2, findMaxElevation(recyclerView, view2) + 1.0f);
                view2.setTag(R.id.obfuscated_res_0x7f091013, valueOf);
            }
            view2.setTranslationX(f);
            view2.setTranslationY(f2);
        }
    }
}
