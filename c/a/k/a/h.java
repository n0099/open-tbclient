package c.a.k.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends Resources {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, c.a.k.a.q.f<String, Integer>> f4162d;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;

    /* renamed from: b  reason: collision with root package name */
    public String f4163b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f4164c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1328757941, "Lc/a/k/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1328757941, "Lc/a/k/a/h;");
                return;
            }
        }
        String str = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
        f4162d = new HashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, assetManager, displayMetrics, configuration};
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
        this.f4164c = resources;
        new HashMap();
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (!TextUtils.isEmpty(this.f4163b) && !this.f4163b.equals("com.baidu.browser.theme.default")) {
                try {
                    String resourceEntryName = this.f4164c.getResourceEntryName(i2);
                    String resourceTypeName = this.f4164c.getResourceTypeName(i2);
                    c.a.k.a.q.f<String, Integer> fVar = f4162d.get(resourceTypeName);
                    if (fVar == null) {
                        fVar = new c.a.k.a.q.f<>(100);
                        f4162d.put(resourceTypeName, fVar);
                    }
                    Integer c2 = fVar.c(resourceEntryName);
                    if (c2 == null) {
                        c2 = Integer.valueOf(this.a.getIdentifier(resourceEntryName, resourceTypeName, this.f4163b));
                        if (c2.intValue() != 0) {
                            fVar.d(resourceEntryName, c2);
                        }
                    }
                    return c2.intValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getAnimation(a);
            }
            return this.f4164c.getAnimation(i2);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f4164c.getBoolean(i2) : invokeI.booleanValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? getColor(i2, null) : invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? getColorStateList(i2, null) : (ColorStateList) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4164c.getConfiguration() : (Configuration) invokeV.objValue;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getDimension(a);
            }
            return this.f4164c.getDimension(i2);
        }
        return invokeI.floatValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getDimensionPixelOffset(a);
            }
            return this.f4164c.getDimensionPixelOffset(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getDimensionPixelSize(a);
            }
            return this.f4164c.getDimensionPixelSize(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getDrawable(a);
            }
            return this.f4164c.getDrawable(i2);
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getDrawableForDensity(a, i3);
            }
            return this.f4164c.getDrawableForDensity(i2, i3);
        }
        return (Drawable) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048590, this, i2, i3, i4)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getFraction(a, i3, i4);
            }
            return this.f4164c.getFraction(i2, i3, i4);
        }
        return invokeIII.floatValue;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getIntArray(a);
            }
            return this.f4164c.getIntArray(i2);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getInteger(a);
            }
            return this.f4164c.getInteger(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getLayout(a);
            }
            return this.f4164c.getLayout(i2);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getMovie(a);
            }
            return this.f4164c.getMovie(i2);
        }
        return (Movie) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getQuantityString(a, i3);
            }
            return this.f4164c.getQuantityString(i2, i3);
        }
        return (String) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i2, i3)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getQuantityText(a, i3);
            }
            return this.f4164c.getQuantityText(i2, i3);
        }
        return (CharSequence) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.f4164c.getResourceEntryName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.f4164c.getResourceName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? this.f4164c.getResourcePackageName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.f4164c.getResourceTypeName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getString(a);
            }
            return this.f4164c.getString(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getStringArray(a);
            }
            return this.f4164c.getStringArray(i2);
        }
        return (String[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getText(a);
            }
            return this.f4164c.getText(i2);
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getTextArray(a);
            }
            return this.f4164c.getTextArray(i2);
        }
        return (CharSequence[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), typedValue, Boolean.valueOf(z)}) == null) {
            int a = a(i2);
            if (a != 0) {
                this.a.getValue(a, typedValue, z);
            } else {
                this.f4164c.getValue(i2, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), typedValue, Boolean.valueOf(z)}) == null) {
            int a = a(i2);
            if (a != 0) {
                this.a.getValueForDensity(a, i3, typedValue, z);
            } else {
                this.f4164c.getValueForDensity(i2, i3, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) ? this.f4164c.getXml(i2) : (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, attributeSet, iArr)) == null) ? this.f4164c.obtainAttributes(attributeSet, iArr) : (TypedArray) invokeLL.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) ? this.f4164c.obtainTypedArray(i2) : (TypedArray) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            int a = a(i2);
            if (a != 0 && (resources = this.a) != null) {
                try {
                    InputStream openRawResource = resources.openRawResource(a);
                    if (openRawResource != null) {
                        return openRawResource;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f4164c.openRawResource(i2);
        }
        return (InputStream) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            int a = a(i2);
            if (a != 0 && (resources = this.a) != null) {
                try {
                    AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(a);
                    if (openRawResourceFd != null) {
                        return openRawResourceFd;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f4164c.openRawResourceFd(i2);
        }
        return (AssetFileDescriptor) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, theme)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getColor(a);
            }
            return this.f4164c.getColor(i2);
        }
        return invokeIL.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, theme)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getColorStateList(a);
            }
            return this.f4164c.getColorStateList(i2);
        }
        return (ColorStateList) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, theme)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getDrawable(a, null);
            }
            return this.f4164c.getDrawable(i2, theme);
        }
        return (Drawable) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048596, this, i2, i3, objArr)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getQuantityString(a, i3, objArr);
            }
            return this.f4164c.getQuantityString(i2, i3, objArr);
        }
        return (String) invokeIIL.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, objArr)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getString(a, objArr);
            }
            return this.f4164c.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, charSequence)) == null) {
            int a = a(i2);
            if (a != 0) {
                return this.a.getText(a, charSequence);
            }
            return this.f4164c.getText(i2, charSequence);
        }
        return (CharSequence) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048609, this, str, typedValue, z) == null) {
            this.f4164c.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, typedValue)) == null) {
            int a = a(i2);
            if (a != 0 && (resources = this.a) != null) {
                try {
                    InputStream openRawResource = resources.openRawResource(a, typedValue);
                    if (openRawResource != null) {
                        return openRawResource;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f4164c.openRawResource(i2, typedValue);
        }
        return (InputStream) invokeIL.objValue;
    }
}
