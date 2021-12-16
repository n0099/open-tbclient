package c.a.d.f.m;

import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes.dex */
public class c extends Resources {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ColorStateList f2477c;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2478b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502578540, "Lc/a/d/f/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502578540, "Lc/a/d/f/m/c;");
                return;
            }
        }
        f2477c = ColorStateList.valueOf(-16777216);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = resources;
        this.f2478b = false;
    }

    public final void a(String str, int i2) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            try {
                str2 = this.a.getResourceEntryName(i2);
            } catch (Exception unused) {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            try {
                BdStatisticsManager.getInstance().error("resources", str, null, -9115, null, "resid", Integer.valueOf(i2), "resname", str2);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    return this.a.getColor(i2);
                } catch (OutOfMemoryError e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e3) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e3;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a("color", i2);
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    return this.a.getColorStateList(i2);
                } catch (OutOfMemoryError e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e3) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e3;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a("colorstatelist", i2);
            return f2477c;
        }
        return (ColorStateList) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    return this.a.getDrawable(i2);
                } catch (OutOfMemoryError e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e3) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e3;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a("drawable", i2);
            return null;
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    return this.a.getString(i2);
                } catch (OutOfMemoryError e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e3) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.f2478b)) {
                        throw e3;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            a("string", i2);
            return "";
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.a.openRawResource(i2) : (InputStream) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, typedValue)) == null) ? this.a.openRawResource(i2, typedValue) : (InputStream) invokeIL.objValue;
    }
}
