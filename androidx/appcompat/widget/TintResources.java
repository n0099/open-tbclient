package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class TintResources extends ResourcesWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<Context> mContextRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, resources};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Resources) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Drawable drawable = super.getDrawable(i2);
            Context context = this.mContextRef.get();
            if (drawable != null && context != null) {
                ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, i2, drawable);
            }
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }
}
