package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater mInflater;
    public Configuration mOverrideConfiguration;
    public Resources mResources;
    public Resources.Theme mTheme;
    public int mThemeResource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextThemeWrapper() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Resources getResourcesInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mResources == null) {
                Configuration configuration = this.mOverrideConfiguration;
                if (configuration == null) {
                    this.mResources = super.getResources();
                } else if (Build.VERSION.SDK_INT >= 17) {
                    this.mResources = createConfigurationContext(configuration).getResources();
                } else {
                    Resources resources = super.getResources();
                    Configuration configuration2 = new Configuration(resources.getConfiguration());
                    configuration2.updateFrom(this.mOverrideConfiguration);
                    this.mResources = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
                }
            }
            return this.mResources;
        }
        return (Resources) invokeV.objValue;
    }

    private void initializeTheme() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            boolean z = this.mTheme == null;
            if (z) {
                this.mTheme = getResources().newTheme();
                Resources.Theme theme = getBaseContext().getTheme();
                if (theme != null) {
                    this.mTheme.setTo(theme);
                }
            }
            onApplyThemeResource(this.mTheme, this.mThemeResource, z);
        }
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
            if (this.mResources == null) {
                if (this.mOverrideConfiguration == null) {
                    this.mOverrideConfiguration = new Configuration(configuration);
                    return;
                }
                throw new IllegalStateException("Override configuration has already been set");
            }
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getResources().getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getResourcesInternal() : (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if ("layout_inflater".equals(str)) {
                if (this.mInflater == null) {
                    this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
                }
                return this.mInflater;
            }
            return getBaseContext().getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Resources.Theme theme = this.mTheme;
            if (theme != null) {
                return theme;
            }
            if (this.mThemeResource == 0) {
                this.mThemeResource = R.style.Theme_AppCompat_Light;
            }
            initializeTheme();
            return this.mTheme;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    public int getThemeResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mThemeResource : invokeV.intValue;
    }

    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            theme.applyStyle(i2, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.mThemeResource == i2) {
            return;
        }
        this.mThemeResource = i2;
        initializeTheme();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextThemeWrapper(Context context, @StyleRes int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThemeResource = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, theme};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTheme = theme;
    }
}
