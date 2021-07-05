package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(18)
/* loaded from: classes.dex */
public class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewGroupOverlay mViewGroupOverlay;

    public ViewGroupOverlayApi18(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewGroupOverlay = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            this.mViewGroupOverlay.add(drawable);
        }
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            this.mViewGroupOverlay.remove(drawable);
        }
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.mViewGroupOverlay.add(view);
        }
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.mViewGroupOverlay.remove(view);
        }
    }
}
