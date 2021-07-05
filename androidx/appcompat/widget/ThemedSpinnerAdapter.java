package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    /* loaded from: classes.dex */
    public static final class Helper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public LayoutInflater mDropDownInflater;
        public final LayoutInflater mInflater;

        public Helper(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LayoutInflater layoutInflater = this.mDropDownInflater;
                return layoutInflater != null ? layoutInflater : this.mInflater;
            }
            return (LayoutInflater) invokeV.objValue;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                LayoutInflater layoutInflater = this.mDropDownInflater;
                if (layoutInflater == null) {
                    return null;
                }
                return layoutInflater.getContext().getTheme();
            }
            return (Resources.Theme) invokeV.objValue;
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, theme) == null) {
                if (theme == null) {
                    this.mDropDownInflater = null;
                } else if (theme == this.mContext.getTheme()) {
                    this.mDropDownInflater = this.mInflater;
                } else {
                    this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, theme));
                }
            }
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);
}
