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

    public MarginPageTransformer(@Px int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgumentNonnegative(i, "Margin must be non-negative");
        this.mMarginPx = i;
    }

    private ViewPager2 requireViewPager(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, view2)) == null) {
            ViewParent parent = view2.getParent();
            ViewParent parent2 = parent.getParent();
            if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
                return (ViewPager2) parent2;
            }
            throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
        }
        return (ViewPager2) invokeL.objValue;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
            ViewPager2 requireViewPager = requireViewPager(view2);
            float f2 = this.mMarginPx * f;
            if (requireViewPager.getOrientation() == 0) {
                if (requireViewPager.isRtl()) {
                    f2 = -f2;
                }
                view2.setTranslationX(f2);
                return;
            }
            view2.setTranslationY(f2);
        }
    }
}
