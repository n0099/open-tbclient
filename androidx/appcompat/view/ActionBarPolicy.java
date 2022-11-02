package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return new ActionBarPolicy(context);
        }
        return (ActionBarPolicy) invokeL.objValue;
    }

    public boolean enableHomeButtonByDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mContext.getApplicationInfo().targetSdkVersion < 14) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getEmbeddedMenuWidthLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        return invokeV.intValue;
    }

    public int getStackedTabMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070095);
        }
        return invokeV.intValue;
    }

    public boolean hasEmbeddedTabs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mContext.getResources().getBoolean(R.bool.obfuscated_res_0x7f050000);
        }
        return invokeV.booleanValue;
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

    public int getMaxActionButtons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Configuration configuration = this.mContext.getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (configuration.smallestScreenWidthDp <= 600 && i <= 600) {
                if (i <= 960 || i2 <= 720) {
                    if (i <= 720 || i2 <= 960) {
                        if (i < 500) {
                            if (i <= 640 || i2 <= 480) {
                                if (i <= 480 || i2 <= 640) {
                                    if (i >= 360) {
                                        return 3;
                                    }
                                    return 2;
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
            return 5;
        }
        return invokeV.intValue;
    }

    public int getTabContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, R.attr.obfuscated_res_0x7f04004f, 0);
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
            Resources resources = this.mContext.getResources();
            if (!hasEmbeddedTabs()) {
                layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070094));
            }
            obtainStyledAttributes.recycle();
            return layoutDimension;
        }
        return invokeV.intValue;
    }
}
