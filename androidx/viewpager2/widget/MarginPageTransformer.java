package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mMarginPx;

    public MarginPageTransformer(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgumentNonnegative(i2, "Margin must be non-negative");
        this.mMarginPx = i2;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, view)) == null) {
            ViewParent parent = view.getParent();
            ViewParent parent2 = parent.getParent();
            if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
                return (ViewPager2) parent2;
            }
            throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
        }
        return (ViewPager2) invokeL.objValue;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
            ViewPager2 requireViewPager = requireViewPager(view);
            float f3 = this.mMarginPx * f2;
            if (requireViewPager.getOrientation() == 0) {
                if (requireViewPager.isRtl()) {
                    f3 = -f3;
                }
                view.setTranslationX(f3);
                return;
            }
            view.setTranslationY(f3);
        }
    }
}
