package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarPolicy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public ActionBarPolicy(Context context) {
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
    }

    public static ActionBarPolicy get(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new ActionBarPolicy(context) : (ActionBarPolicy) invokeL.objValue;
    }

    public boolean enableHomeButtonByDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mContext.getApplicationInfo().targetSdkVersion < 14 : invokeV.booleanValue;
    }

    public int getEmbeddedMenuWidthLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContext.getResources().getDisplayMetrics().widthPixels / 2 : invokeV.intValue;
    }

    public int getMaxActionButtons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Configuration configuration = this.mContext.getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
                return 5;
            }
            if (i2 <= 960 || i3 <= 720) {
                if (i2 <= 720 || i3 <= 960) {
                    if (i2 < 500) {
                        if (i2 <= 640 || i3 <= 480) {
                            if (i2 <= 480 || i3 <= 640) {
                                return i2 >= 360 ? 3 : 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public int getStackedTabMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContext.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width) : invokeV.intValue;
    }

    public int getTabContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
            Resources resources = this.mContext.getResources();
            if (!hasEmbeddedTabs()) {
                layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
            }
            obtainStyledAttributes.recycle();
            return layoutDimension;
        }
        return invokeV.intValue;
    }

    public boolean hasEmbeddedTabs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContext.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs) : invokeV.booleanValue;
    }

    public boolean showsOverflowMenuButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return true;
            }
            return !ViewConfiguration.get(this.mContext).hasPermanentMenuKey();
        }
        return invokeV.booleanValue;
    }
}
