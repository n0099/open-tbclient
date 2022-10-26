package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ActionBarBackgroundDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActionBarContainer mContainer;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, colorFilter) == null) {
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {actionBarContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContainer = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            ActionBarContainer actionBarContainer = this.mContainer;
            if (actionBarContainer.mIsSplit) {
                Drawable drawable = actionBarContainer.mSplitBackground;
                if (drawable != null) {
                    drawable.draw(canvas);
                    return;
                }
                return;
            }
            Drawable drawable2 = actionBarContainer.mBackground;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            ActionBarContainer actionBarContainer2 = this.mContainer;
            Drawable drawable3 = actionBarContainer2.mStackedBackground;
            if (drawable3 != null && actionBarContainer2.mIsStacked) {
                drawable3.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, outline) == null) {
            ActionBarContainer actionBarContainer = this.mContainer;
            if (actionBarContainer.mIsSplit) {
                Drawable drawable = actionBarContainer.mSplitBackground;
                if (drawable != null) {
                    drawable.getOutline(outline);
                    return;
                }
                return;
            }
            Drawable drawable2 = actionBarContainer.mBackground;
            if (drawable2 != null) {
                drawable2.getOutline(outline);
            }
        }
    }
}
