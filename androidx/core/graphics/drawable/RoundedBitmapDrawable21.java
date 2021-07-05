package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(21)
/* loaded from: classes.dex */
public class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Resources) objArr2[0], (Bitmap) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, outline) == null) {
            updateDstRect();
            outline.setRoundRect(this.mDstRect, getCornerRadius());
        }
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void gravityCompatApply(int i2, int i3, int i4, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), rect, rect2}) == null) {
            Gravity.apply(i2, i3, i4, rect, rect2, 0);
        }
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Bitmap bitmap = this.mBitmap;
            return bitmap != null && bitmap.hasMipMap();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean z) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (bitmap = this.mBitmap) == null) {
            return;
        }
        bitmap.setHasMipMap(z);
        invalidateSelf();
    }
}
