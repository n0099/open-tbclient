package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.swiperefreshlayout.widget.CircleImageView;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    public static final int AMBIENT_SHADOW_ALPHA = 30;
    public static final float BLUR_FACTOR = 0.010416667f;
    public static final PorterDuff.Mode DEFAULT_TINT_MODE;
    public static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    @VisibleForTesting
    public static final String EXTRA_INT1 = "int1";
    @VisibleForTesting
    public static final String EXTRA_INT2 = "int2";
    @VisibleForTesting
    public static final String EXTRA_OBJ = "obj";
    @VisibleForTesting
    public static final String EXTRA_STRING1 = "string1";
    @VisibleForTesting
    public static final String EXTRA_TINT_LIST = "tint_list";
    @VisibleForTesting
    public static final String EXTRA_TINT_MODE = "tint_mode";
    @VisibleForTesting
    public static final String EXTRA_TYPE = "type";
    public static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    public static final int KEY_SHADOW_ALPHA = 61;
    public static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    public static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    public transient /* synthetic */ FieldHolder $fh;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] mData;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt2;
    public Object mObj1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable mParcelable;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mString1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList mTintList;
    public PorterDuff.Mode mTintMode;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mTintModeStr;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface IconType {
    }

    public static String typeToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) {
            switch (i) {
                case 1:
                    return "BITMAP";
                case 2:
                    return "RESOURCE";
                case 3:
                    return "DATA";
                case 4:
                    return DownloadConstants.DownloadColumns.COLUMN_URI;
                case 5:
                    return "BITMAP_MASKABLE";
                case 6:
                    return "URI_MASKABLE";
                default:
                    return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeI.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(176355549, "Landroidx/core/graphics/drawable/IconCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(176355549, "Landroidx/core/graphics/drawable/IconCompat;");
                return;
            }
        }
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                return getType((Icon) this.mObj1);
            }
            return this.mType;
        }
        return invokeV.intValue;
    }

    @NonNull
    @RequiresApi(23)
    @Deprecated
    public Icon toIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return toIcon(null);
        }
        return (Icon) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    @IdRes
    public int getResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                return getResId((Icon) this.mObj1);
            }
            if (this.mType == 2) {
                return this.mInt1;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return invokeV.intValue;
    }

    public IconCompat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i;
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, icon)) == null) {
            Preconditions.checkNotNull(icon);
            int type = getType(icon);
            if (type != 2) {
                if (type != 4) {
                    if (type != 6) {
                        IconCompat iconCompat = new IconCompat(-1);
                        iconCompat.mObj1 = icon;
                        return iconCompat;
                    }
                    return createWithAdaptiveBitmapContentUri(getUri(icon));
                }
                return createWithContentUri(getUri(icon));
            }
            return createWithResource(null, getResPackage(icon), getResId(icon));
        }
        return (IconCompat) invokeL.objValue;
    }

    @DrawableRes
    @IdRes
    @RequiresApi(23)
    public static int getResId(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, icon)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return icon.getResId();
            }
            try {
                return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to get icon resource", e);
                return 0;
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "Unable to get icon resource", e2);
                return 0;
            } catch (InvocationTargetException e3) {
                Log.e(TAG, "Unable to get icon resource", e3);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Nullable
    @RequiresApi(23)
    public static String getResPackage(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, icon)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return icon.getResPackage();
            }
            try {
                return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to get icon package", e);
                return null;
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "Unable to get icon package", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e(TAG, "Unable to get icon package", e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    @RequiresApi(23)
    public static Uri getUri(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, icon)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return icon.getUri();
            }
            try {
                return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to get icon uri", e);
                return null;
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "Unable to get icon uri", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e(TAG, "Unable to get icon uri", e3);
                return null;
            }
        }
        return (Uri) invokeL.objValue;
    }

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            int i = bundle.getInt("type");
            IconCompat iconCompat = new IconCompat(i);
            iconCompat.mInt1 = bundle.getInt(EXTRA_INT1);
            iconCompat.mInt2 = bundle.getInt(EXTRA_INT2);
            iconCompat.mString1 = bundle.getString(EXTRA_STRING1);
            if (bundle.containsKey(EXTRA_TINT_LIST)) {
                iconCompat.mTintList = (ColorStateList) bundle.getParcelable(EXTRA_TINT_LIST);
            }
            if (bundle.containsKey(EXTRA_TINT_MODE)) {
                iconCompat.mTintMode = PorterDuff.Mode.valueOf(bundle.getString(EXTRA_TINT_MODE));
            }
            switch (i) {
                case -1:
                case 1:
                case 5:
                    iconCompat.mObj1 = bundle.getParcelable("obj");
                    break;
                case 0:
                default:
                    Log.w(TAG, "Unknown type " + i);
                    return null;
                case 2:
                case 4:
                case 6:
                    iconCompat.mObj1 = bundle.getString("obj");
                    break;
                case 3:
                    iconCompat.mObj1 = bundle.getByteArray("obj");
                    break;
            }
            return iconCompat;
        }
        return (IconCompat) invokeL.objValue;
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat createFromIcon(@NonNull Context context, @NonNull Icon icon) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, icon)) == null) {
            Preconditions.checkNotNull(icon);
            int type = getType(icon);
            if (type != 2) {
                if (type != 4) {
                    if (type != 6) {
                        IconCompat iconCompat = new IconCompat(-1);
                        iconCompat.mObj1 = icon;
                        return iconCompat;
                    }
                    return createWithAdaptiveBitmapContentUri(getUri(icon));
                }
                return createWithContentUri(getUri(icon));
            }
            String resPackage = getResPackage(icon);
            try {
                return createWithResource(getResources(context, resPackage), resPackage, getResId(icon));
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        }
        return (IconCompat) invokeLL.objValue;
    }

    public static Resources getResources(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            if ("android".equals(str)) {
                return Resources.getSystem();
            }
            PackageManager packageManager = context.getPackageManager();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
                if (applicationInfo == null) {
                    return null;
                }
                return packageManager.getResourcesForApplication(applicationInfo);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, String.format("Unable to find pkg=%s for icon", str), e);
                return null;
            }
        }
        return (Resources) invokeLL.objValue;
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, icon)) == null) {
            if (getType(icon) == 2 && getResId(icon) == 0) {
                return null;
            }
            return createFromIcon(icon);
        }
        return (IconCompat) invokeL.objValue;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bitmap)) == null) {
            if (bitmap != null) {
                IconCompat iconCompat = new IconCompat(5);
                iconCompat.mObj1 = bitmap;
                return iconCompat;
            }
            throw new IllegalArgumentException("Bitmap must not be null.");
        }
        return (IconCompat) invokeL.objValue;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            if (uri != null) {
                return createWithAdaptiveBitmapContentUri(uri.toString());
            }
            throw new IllegalArgumentException("Uri must not be null.");
        }
        return (IconCompat) invokeL.objValue;
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bitmap)) == null) {
            if (bitmap != null) {
                IconCompat iconCompat = new IconCompat(1);
                iconCompat.mObj1 = bitmap;
                return iconCompat;
            }
            throw new IllegalArgumentException("Bitmap must not be null.");
        }
        return (IconCompat) invokeL.objValue;
    }

    public static IconCompat createWithContentUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) {
            if (uri != null) {
                return createWithContentUri(uri.toString());
            }
            throw new IllegalArgumentException("Uri must not be null.");
        }
        return (IconCompat) invokeL.objValue;
    }

    public IconCompat setTint(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return setTintList(ColorStateList.valueOf(i));
        }
        return (IconCompat) invokeI.objValue;
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, colorStateList)) == null) {
            this.mTintList = colorStateList;
            return this;
        }
        return (IconCompat) invokeL.objValue;
    }

    public IconCompat setTintMode(PorterDuff.Mode mode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, mode)) == null) {
            this.mTintMode = mode;
            return this;
        }
        return (IconCompat) invokeL.objValue;
    }

    @VisibleForTesting
    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, bitmap, z)) == null) {
            int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
            Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(3);
            float f = min;
            float f2 = 0.5f * f;
            float f3 = 0.9166667f * f2;
            if (z) {
                float f4 = 0.010416667f * f;
                paint.setColor(0);
                paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, CircleImageView.FILL_SHADOW_COLOR);
                canvas.drawCircle(f2, f2, f3, paint);
                paint.setShadowLayer(f4, 0.0f, 0.0f, CircleImageView.KEY_SHADOW_COLOR);
                canvas.drawCircle(f2, f2, f3, paint);
                paint.clearShadowLayer();
            }
            paint.setColor(-16777216);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            Matrix matrix = new Matrix();
            matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            canvas.drawCircle(f2, f2, f3, paint);
            canvas.setBitmap(null);
            return createBitmap;
        }
        return (Bitmap) invokeLZ.objValue;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str != null) {
                IconCompat iconCompat = new IconCompat(6);
                iconCompat.mObj1 = str;
                return iconCompat;
            }
            throw new IllegalArgumentException("Uri must not be null.");
        }
        return (IconCompat) invokeL.objValue;
    }

    public static IconCompat createWithContentUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str != null) {
                IconCompat iconCompat = new IconCompat(4);
                iconCompat.mObj1 = str;
                return iconCompat;
            }
            throw new IllegalArgumentException("Uri must not be null.");
        }
        return (IconCompat) invokeL.objValue;
    }

    public static IconCompat createWithData(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, bArr, i, i2)) == null) {
            if (bArr != null) {
                IconCompat iconCompat = new IconCompat(3);
                iconCompat.mObj1 = bArr;
                iconCompat.mInt1 = i;
                iconCompat.mInt2 = i2;
                return iconCompat;
            }
            throw new IllegalArgumentException("Data must not be null.");
        }
        return (IconCompat) invokeLII.objValue;
    }

    public static IconCompat createWithResource(Context context, @DrawableRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, context, i)) == null) {
            if (context != null) {
                return createWithResource(context.getResources(), context.getPackageName(), i);
            }
            throw new IllegalArgumentException("Context must not be null.");
        }
        return (IconCompat) invokeLI.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(Resources resources, String str, @DrawableRes int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, resources, str, i)) == null) {
            if (str != null) {
                if (i != 0) {
                    IconCompat iconCompat = new IconCompat(2);
                    iconCompat.mInt1 = i;
                    if (resources != null) {
                        try {
                            iconCompat.mObj1 = resources.getResourceName(i);
                        } catch (Resources.NotFoundException unused) {
                            throw new IllegalArgumentException("Icon resource cannot be found");
                        }
                    } else {
                        iconCompat.mObj1 = str;
                    }
                    iconCompat.mString1 = str;
                    return iconCompat;
                }
                throw new IllegalArgumentException("Drawable resource ID must not be 0");
            }
            throw new IllegalArgumentException("Package must not be null.");
        }
        return (IconCompat) invokeLLI.objValue;
    }

    @RequiresApi(23)
    public static int getType(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, icon)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return icon.getType();
            }
            try {
                return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to get icon type " + icon, e);
                return -1;
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "Unable to get icon type " + icon, e2);
                return -1;
            } catch (InvocationTargetException e3) {
                Log.e(TAG, "Unable to get icon type " + icon, e3);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context context) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.mType == 2 && (obj = this.mObj1) != null) {
            String str = (String) obj;
            if (!str.contains(":")) {
                return;
            }
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            String resPackage = getResPackage();
            int identifier = getResources(context, resPackage).getIdentifier(str4, str3, str5);
            if (this.mInt1 != identifier) {
                Log.i(TAG, "Id has changed for " + resPackage + " " + str);
                this.mInt1 = identifier;
            }
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream getUriInputStream(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            Uri uri = getUri();
            String scheme = uri.getScheme();
            if (!"content".equals(scheme) && !"file".equals(scheme)) {
                try {
                    return new FileInputStream(new File((String) this.mObj1));
                } catch (FileNotFoundException e) {
                    Log.w(TAG, "Unable to load image from path: " + uri, e);
                    return null;
                }
            }
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (Exception e2) {
                Log.w(TAG, "Unable to load image from URI: " + uri, e2);
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mTintModeStr = this.mTintMode.name();
            switch (this.mType) {
                case -1:
                    if (!z) {
                        this.mParcelable = (Parcelable) this.mObj1;
                        return;
                    }
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                case 0:
                default:
                    return;
                case 1:
                case 5:
                    if (z) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ((Bitmap) this.mObj1).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                        this.mData = byteArrayOutputStream.toByteArray();
                        return;
                    }
                    this.mParcelable = (Parcelable) this.mObj1;
                    return;
                case 2:
                    this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
                    return;
                case 3:
                    this.mData = (byte[]) this.mObj1;
                    return;
                case 4:
                case 6:
                    this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                    return;
            }
        }
    }

    private Drawable loadDrawableInner(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, context)) == null) {
            switch (this.mType) {
                case 1:
                    return new BitmapDrawable(context.getResources(), (Bitmap) this.mObj1);
                case 2:
                    String resPackage = getResPackage();
                    if (TextUtils.isEmpty(resPackage)) {
                        resPackage = context.getPackageName();
                    }
                    try {
                        return ResourcesCompat.getDrawable(getResources(context, resPackage), this.mInt1, context.getTheme());
                    } catch (RuntimeException e) {
                        Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.mInt1), this.mObj1), e);
                        break;
                    }
                case 3:
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
                case 4:
                    InputStream uriInputStream = getUriInputStream(context);
                    if (uriInputStream != null) {
                        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream));
                    }
                    break;
                case 5:
                    return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
                case 6:
                    InputStream uriInputStream2 = getUriInputStream(context);
                    if (uriInputStream2 != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            return new AdaptiveIconDrawable(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream2)));
                        }
                        return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(uriInputStream2), false));
                    }
                    break;
            }
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    @NonNull
    @RequiresApi(23)
    public Icon toIcon(@Nullable Context context) {
        InterceptResult invokeL;
        Icon createWithBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) {
            switch (this.mType) {
                case -1:
                    return (Icon) this.mObj1;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) this.mObj1);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(getResPackage(), this.mInt1);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) this.mObj1);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 26) {
                        createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.mObj1);
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
                        break;
                    }
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(getUri());
                        break;
                    } else if (context != null) {
                        InputStream uriInputStream = getUriInputStream(context);
                        if (uriInputStream != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(uriInputStream));
                                break;
                            } else {
                                createWithBitmap = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(uriInputStream), false));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + getUri());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + getUri());
                    }
            }
            ColorStateList colorStateList = this.mTintList;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = this.mTintMode;
            if (mode != DEFAULT_TINT_MODE) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }
        return (Icon) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@NonNull Intent intent, @Nullable Drawable drawable, @NonNull Context context) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, intent, drawable, context) == null) {
            checkResource(context);
            int i = this.mType;
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        bitmap = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
                    } else {
                        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
                    }
                } else {
                    try {
                        Context createPackageContext = context.createPackageContext(getResPackage(), 0);
                        if (drawable == null) {
                            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(createPackageContext, this.mInt1));
                            return;
                        }
                        Drawable drawable2 = ContextCompat.getDrawable(createPackageContext, this.mInt1);
                        if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
                            bitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            drawable2.draw(new Canvas(bitmap));
                        }
                        int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                        bitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                        drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        drawable2.draw(new Canvas(bitmap));
                    } catch (PackageManager.NameNotFoundException e) {
                        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
                    }
                }
            } else {
                bitmap = (Bitmap) this.mObj1;
                if (drawable != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            }
            if (drawable != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                drawable.setBounds(width / 2, height / 2, width, height);
                drawable.draw(new Canvas(bitmap));
            }
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                Object obj = this.mObj1;
                if (obj instanceof Bitmap) {
                    return (Bitmap) obj;
                }
                return null;
            }
            int i = this.mType;
            if (i == 1) {
                return (Bitmap) this.mObj1;
            }
            if (i == 5) {
                return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
        return (Bitmap) invokeV.objValue;
    }

    @NonNull
    public String getResPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                return getResPackage((Icon) this.mObj1);
            }
            if (this.mType == 2) {
                if (TextUtils.isEmpty(this.mString1)) {
                    return ((String) this.mObj1).split(":", -1)[0];
                }
                return this.mString1;
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                return getUri((Icon) this.mObj1);
            }
            int i = this.mType;
            if (i != 4 && i != 6) {
                throw new IllegalStateException("called getUri() on " + this);
            }
            return Uri.parse((String) this.mObj1);
        }
        return (Uri) invokeV.objValue;
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            checkResource(context);
            if (Build.VERSION.SDK_INT >= 23) {
                return toIcon(context).loadDrawable(context);
            }
            Drawable loadDrawableInner = loadDrawableInner(context);
            if (loadDrawableInner != null && (this.mTintList != null || this.mTintMode != DEFAULT_TINT_MODE)) {
                loadDrawableInner.mutate();
                DrawableCompat.setTintList(loadDrawableInner, this.mTintList);
                DrawableCompat.setTintMode(loadDrawableInner, this.mTintMode);
            }
            return loadDrawableInner;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
            switch (this.mType) {
                case -1:
                    Parcelable parcelable = this.mParcelable;
                    if (parcelable != null) {
                        this.mObj1 = parcelable;
                        return;
                    }
                    throw new IllegalArgumentException("Invalid icon");
                case 0:
                default:
                    return;
                case 1:
                case 5:
                    Parcelable parcelable2 = this.mParcelable;
                    if (parcelable2 != null) {
                        this.mObj1 = parcelable2;
                        return;
                    }
                    byte[] bArr = this.mData;
                    this.mObj1 = bArr;
                    this.mType = 3;
                    this.mInt1 = 0;
                    this.mInt2 = bArr.length;
                    return;
                case 2:
                case 4:
                case 6:
                    String str = new String(this.mData, Charset.forName("UTF-16"));
                    this.mObj1 = str;
                    if (this.mType == 2 && this.mString1 == null) {
                        this.mString1 = str.split(":", -1)[0];
                        return;
                    }
                    return;
                case 3:
                    this.mObj1 = this.mData;
                    return;
            }
        }
    }

    @NonNull
    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Bundle bundle = new Bundle();
            switch (this.mType) {
                case -1:
                    bundle.putParcelable("obj", (Parcelable) this.mObj1);
                    break;
                case 0:
                default:
                    throw new IllegalArgumentException("Invalid icon");
                case 1:
                case 5:
                    bundle.putParcelable("obj", (Bitmap) this.mObj1);
                    break;
                case 2:
                case 4:
                case 6:
                    bundle.putString("obj", (String) this.mObj1);
                    break;
                case 3:
                    bundle.putByteArray("obj", (byte[]) this.mObj1);
                    break;
            }
            bundle.putInt("type", this.mType);
            bundle.putInt(EXTRA_INT1, this.mInt1);
            bundle.putInt(EXTRA_INT2, this.mInt2);
            bundle.putString(EXTRA_STRING1, this.mString1);
            ColorStateList colorStateList = this.mTintList;
            if (colorStateList != null) {
                bundle.putParcelable(EXTRA_TINT_LIST, colorStateList);
            }
            PorterDuff.Mode mode = this.mTintMode;
            if (mode != DEFAULT_TINT_MODE) {
                bundle.putString(EXTRA_TINT_MODE, mode.name());
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mType == -1) {
                return String.valueOf(this.mObj1);
            }
            StringBuilder sb = new StringBuilder("Icon(typ=");
            sb.append(typeToString(this.mType));
            switch (this.mType) {
                case 1:
                case 5:
                    sb.append(" size=");
                    sb.append(((Bitmap) this.mObj1).getWidth());
                    sb.append("x");
                    sb.append(((Bitmap) this.mObj1).getHeight());
                    break;
                case 2:
                    sb.append(" pkg=");
                    sb.append(this.mString1);
                    sb.append(" id=");
                    sb.append(String.format("0x%08x", Integer.valueOf(getResId())));
                    break;
                case 3:
                    sb.append(" len=");
                    sb.append(this.mInt1);
                    if (this.mInt2 != 0) {
                        sb.append(" off=");
                        sb.append(this.mInt2);
                        break;
                    }
                    break;
                case 4:
                case 6:
                    sb.append(" uri=");
                    sb.append(this.mObj1);
                    break;
            }
            if (this.mTintList != null) {
                sb.append(" tint=");
                sb.append(this.mTintList);
            }
            if (this.mTintMode != DEFAULT_TINT_MODE) {
                sb.append(" mode=");
                sb.append(this.mTintMode);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
