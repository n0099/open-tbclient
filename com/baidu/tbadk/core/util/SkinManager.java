package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.b;
import d.a.c.e.p.l;
import d.a.o0.r.u.a;
import d.a.p0.h3.c;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class SkinManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_COVER_COLOR = 1275068416;
    public static final String PLUGIN_NIGHT_RESOURCE = "com.baidu.tieba.pluginResource";
    public static final int PRIOROTY_BEFORE_CHANGE_SKIN = -1;
    public static final float RESOURCE_ALPHA_DISABLE;
    public static final float RESOURCE_ALPHA_OVERLAP_SHOW;
    public static final float RESOURCE_ALPHA_PRESS;
    public static final int SKIN_TYPE_DARK = 4;
    public static final int SKIN_TYPE_NIGHT = 1;
    public static final int SKIN_TYPE_NONE = 3;
    public static final int SKIN_TYPE_NORMAL = 0;
    public static final String SKIN_TYPE_STR_DARK = "dark";
    public static final String SKIN_TYPE_STR_NIGHT = "night";
    public static final String SKIN_TYPE_STR_NORMAL = "default";
    public static final int SKIN_TYPE_THEME = 2;
    public static final String THEME_ICON_COLOR_VALUE = "icon_color";
    public static final String THEME_ICON_COVER_VALUE = "icon_cover_maintab";
    public static String TYPE_ERROR = null;
    public static AssetManager am = null;
    public static final String darkSuffix = "_2";
    public static String mPluginPackage = null;
    public static Resources mPluginRes = null;
    public static String mSkinPackageName = null;
    public static Resources mSkinRes = null;
    public static final String nightSufix = "_1";
    public static SparseIntArray sDarkResourceIdMap;
    public static SparseIntArray sNightResourceIdMap;
    public static String sPackagename;
    public static int sPacknameLength;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class ViewType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BUTTON = 3;
        public static final int CHECKBOX = 4;
        public static final int EDITTEXT = 2;
        public static final int TEXTVIEW = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(469951915, "Lcom/baidu/tbadk/core/util/SkinManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(469951915, "Lcom/baidu/tbadk/core/util/SkinManager;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.core.util.SkinManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    SkinManager.mPluginRes = null;
                }
            }
        });
        RESOURCE_ALPHA_OVERLAP_SHOW = a.a(R.string.A_X05);
        RESOURCE_ALPHA_PRESS = a.a(R.string.A_X07);
        RESOURCE_ALPHA_DISABLE = a.a(R.string.A_X09);
        TYPE_ERROR = "skinType not support";
        sPackagename = null;
        sPacknameLength = 0;
        sNightResourceIdMap = new SparseIntArray();
        sDarkResourceIdMap = new SparseIntArray();
    }

    public SkinManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ColorStateList createCheckedColorStateList(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, null, i2, i3, i4, i5)) == null) {
            if (i2 == 0 || i3 == 0 || i4 == 0) {
                return null;
            }
            return new ColorStateList(new int[][]{new int[]{16842912}, new int[]{-16842910}, new int[0]}, new int[]{getColor(i5, i3), c.a(getColor(i5, i4), RESOURCE_ALPHA_DISABLE), getColor(i5, i2)});
        }
        return (ColorStateList) invokeIIII.objValue;
    }

    public static ColorStateList createColorStateList(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) {
            if (i2 == 0 || i3 == 0) {
                return null;
            }
            int color = getColor(i4, i2);
            int color2 = getColor(i4, i3);
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
        }
        return (ColorStateList) invokeIII.objValue;
    }

    public static GradientDrawable createShapeDrawable(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            if (i3 == 0) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getColor(i6, i3));
            if (i2 > 0) {
                gradientDrawable.setCornerRadius(i2);
            }
            if (i4 != 0 && i5 > 0) {
                gradientDrawable.setStroke(i5, getColor(i6, i4));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public static GradientDrawable createShapeDrawableFromColor(int i2, int i3, String str, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i3 == 0) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getColor(i5, i3));
            if (i2 > 0) {
                gradientDrawable.setCornerRadius(i2);
            }
            if (i4 > 0) {
                gradientDrawable.setStroke(i4, Color.parseColor("#80" + str));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public static ShapeDrawable createShapeDrawableWithShadow(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)})) == null) {
            if (i3 == 0) {
                return null;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            int max = i7 != 0 ? Math.max(Math.abs(i5), Math.abs(i6)) + i7 : 0;
            int color = getColor(i8, i4);
            if (i7 != 0) {
                shapeDrawable.getPaint().setShadowLayer(i7, i5, i6, color);
            }
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            shapeDrawable.getPaint().setColor(getColor(i8, i3));
            float[] fArr = new float[8];
            Arrays.fill(fArr, i2);
            RoundRectShapeWithEdge roundRectShapeWithEdge = new RoundRectShapeWithEdge(fArr);
            roundRectShapeWithEdge.setEdge(max);
            shapeDrawable.setShape(roundRectShapeWithEdge);
            return shapeDrawable;
        }
        return (ShapeDrawable) invokeCommon.objValue;
    }

    public static StateListDrawable createStateDrawable(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65550, null, i2, i3, i4)) == null) {
            if (i2 != 0 && i3 != 0) {
                Drawable drawable = getDrawable(i4, i2);
                Drawable drawable2 = getDrawable(i4, i3);
                if (drawable != null && drawable2 != null) {
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
                    stateListDrawable.addState(new int[]{16842910, 16842908}, drawable2);
                    stateListDrawable.addState(new int[0], drawable);
                    return stateListDrawable;
                }
            }
            return null;
        }
        return (StateListDrawable) invokeIII.objValue;
    }

    public static int getBarTextUnselColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) {
            if (i2 != 1 && i2 != 4) {
                throw new IllegalArgumentException(TYPE_ERROR);
            }
            return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10219);
        }
        return invokeI.intValue;
    }

    public static int getBgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i2 != 1 && i2 != 4) {
                return app.getResources().getColor(R.color.common_color_10163);
            }
            return app.getResources().getColor(R.color.common_color_10150);
        }
        return invokeI.intValue;
    }

    public static Bitmap getBitmap(Resources resources, int i2, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, resources, i2, options)) == null) ? getBitmap(resources, i2, options, TbadkCoreApplication.getInst().getSkinType()) : (Bitmap) invokeLIL.objValue;
    }

    public static Bitmap getBitmap565Quality(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return getBitmap(null, i2, options);
        }
        return (Bitmap) invokeI.objValue;
    }

    public static Bitmap getBitmapAllowFail(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, resources, i2)) == null) ? getBitmap(i2) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap getBitmapLowQuality(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            return getBitmap(null, i2, options);
        }
        return (Bitmap) invokeI.objValue;
    }

    public static Bitmap getBitmapQuiteLowQuality(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            return getBitmap(null, i2, options);
        }
        return (Bitmap) invokeI.objValue;
    }

    public static int getColor(int i2, Resources resources, int i3) {
        InterceptResult invokeCommon;
        int darkResourceId;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i2), resources, Integer.valueOf(i3)})) == null) {
            if (i3 == 0) {
                return 0;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i2 != 2 ? i2 != 1 ? i2 != 4 || (darkResourceId = getDarkResourceId(resources, i3)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getNightResouceId(resources, i3)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getSkinResourceId(resources, i3)) == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                darkResourceId = i3;
            }
            try {
                return resources2.getColor(darkResourceId);
            } catch (Throwable unused) {
                return resources.getColor(i3);
            }
        }
        return invokeCommon.intValue;
    }

    public static Drawable getColorDrawableWithClickState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = getDrawable(i2);
            drawable.mutate().setAlpha((int) (RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842910, 16842919}, drawable);
            stateListDrawable.addState(new int[0], getDrawable(i2).mutate());
            return stateListDrawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public static ColorStateList getColorList(int i2, Resources resources, int i3) {
        InterceptResult invokeCommon;
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{Integer.valueOf(i2), resources, Integer.valueOf(i3)})) == null) {
            if (i3 == 0) {
                return null;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i2 != 2 ? !(i2 != 1 ? i2 != 4 || (darkResourceId = getDarkResourceId(resources, i3)) == 0 || mPluginRes == null : (darkResourceId = getNightResouceId(resources, i3)) == 0 || mPluginRes == null) : !((darkResourceId = getSkinResourceId(resources, i3)) == 0 || mSkinRes == null)) {
                i3 = darkResourceId;
            }
            if (i3 == 0) {
                return null;
            }
            try {
                return AppCompatResources.getColorStateList(BdBaseApplication.getInst().getApp(), i3);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public static ColorStateList getColorStateListWithClickAndDisableState(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65571, null, i2, i3)) == null) {
            if (i2 <= 0) {
                return null;
            }
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{-16842910}, new int[0]}, new int[]{c.a(getColor(i3, i2), RESOURCE_ALPHA_PRESS), c.a(getColor(i3, i2), RESOURCE_ALPHA_DISABLE), getColor(i3, i2)});
        }
        return (ColorStateList) invokeII.objValue;
    }

    public static ColorStateList getColorStateListWithClickState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i2)) == null) {
            if (i2 <= 0) {
                return null;
            }
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[0]}, new int[]{c.a(getColor(i2), RESOURCE_ALPHA_PRESS), getColor(i2)});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static int getCommentTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65573, null, i2)) == null) {
            if (i2 != 1 && i2 != 4) {
                throw new IllegalArgumentException(TYPE_ERROR);
            }
            return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10004);
        }
        return invokeI.intValue;
    }

    public static String getCurrentSkinTypeString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            return skinType == 1 ? SKIN_TYPE_STR_NIGHT : skinType == 4 ? SKIN_TYPE_STR_DARK : "default";
        }
        return (String) invokeV.objValue;
    }

    public static int getDarkResourceId(Resources resources, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65575, null, resources, i2)) == null) {
            if (mPluginRes == null) {
                mPluginRes = resources;
            }
            int i3 = sDarkResourceIdMap.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            try {
                str = resources.getResourceName(i2);
            } catch (Exception unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
                if (sPacknameLength == 0) {
                    String packageName = BdBaseApplication.getInst().getPackageName();
                    sPackagename = packageName;
                    sPacknameLength = packageName.length();
                }
                int length = str.length();
                int i4 = sPacknameLength;
                if (length > i4 && str.charAt(i4) != ':' && str.startsWith(sPackagename)) {
                    str = sPackagename + str.substring(str.indexOf(":"));
                }
                i3 = mPluginRes.getIdentifier(str + darkSuffix, null, null);
                if (i3 <= 0) {
                    String str2 = PLUGIN_NIGHT_RESOURCE + str.substring(str.indexOf(":"));
                    i3 = mPluginRes.getIdentifier(str2 + darkSuffix, null, null);
                }
            }
            if (i3 <= 0) {
                i3 = getNightResouceId(resources, i2);
            }
            sDarkResourceIdMap.put(i2, i3);
            return i3;
        }
        return invokeLI.intValue;
    }

    public static Drawable getDrawable(int i2, Resources resources, int i3) {
        InterceptResult invokeCommon;
        int darkResourceId;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{Integer.valueOf(i2), resources, Integer.valueOf(i3)})) == null) {
            if (i3 == 0) {
                return null;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i2 != 2 ? i2 != 1 ? i2 != 4 || (darkResourceId = getDarkResourceId(resources, i3)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getNightResouceId(resources, i3)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getSkinResourceId(resources, i3)) == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                darkResourceId = i3;
            }
            try {
                try {
                    return resources2.getDrawable(darkResourceId);
                } catch (Throwable unused) {
                    return null;
                }
            } catch (Throwable unused2) {
                return resources.getDrawable(i3);
            }
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static Drawable getDrawableWithClickState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65580, null, i2)) == null) {
            if (i2 <= 0) {
                return null;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = getDrawable(i2);
            drawable.setAlpha((int) (RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], getDrawable(i2).mutate());
            return stateListDrawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public static ColorStateList getIntColorStateListWithClickState(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65581, null, i2)) == null) ? new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[0]}, new int[]{c.a(i2, RESOURCE_ALPHA_PRESS), i2}) : (ColorStateList) invokeI.objValue;
    }

    public static int getLottieAnimation(int i2) {
        InterceptResult invokeI;
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65582, null, i2)) == null) {
            if (i2 <= 0) {
                return 0;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                darkResourceId = getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2);
                if (darkResourceId <= 0) {
                    return i2;
                }
            } else if (skinType != 4 || (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) {
                return i2;
            }
            return darkResourceId;
        }
        return invokeI.intValue;
    }

    public static int getNightResouceId(Resources resources, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65583, null, resources, i2)) == null) {
            if (mPluginRes == null) {
                mPluginRes = resources;
            }
            int i3 = sNightResourceIdMap.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            try {
                str = resources.getResourceName(i2);
            } catch (Exception unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
                if (sPacknameLength == 0) {
                    String packageName = BdBaseApplication.getInst().getPackageName();
                    sPackagename = packageName;
                    sPacknameLength = packageName.length();
                }
                int length = str.length();
                int i4 = sPacknameLength;
                if (length > i4 && str.charAt(i4) != ':' && str.startsWith(sPackagename)) {
                    str = sPackagename + str.substring(str.indexOf(":"));
                }
                i3 = mPluginRes.getIdentifier(str + nightSufix, null, null);
                if (i3 <= 0) {
                    Resources resources2 = mPluginRes;
                    i3 = resources2.getIdentifier((PLUGIN_NIGHT_RESOURCE + str.substring(str.indexOf(":"))) + nightSufix, null, null);
                }
            }
            sNightResourceIdMap.put(i2, i3);
            return i3;
        }
        return invokeLI.intValue;
    }

    public static int getResourceId(int i2) {
        InterceptResult invokeI;
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65584, null, i2)) == null) {
            if (i2 <= 0) {
                return 0;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                darkResourceId = getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2);
                if (darkResourceId <= 0) {
                    return i2;
                }
            } else if (skinType != 4 || (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) {
                return i2;
            }
            return darkResourceId;
        }
        return invokeI.intValue;
    }

    public static int getSecondCommentTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65585, null, i2)) == null) {
            if (i2 != 1 && i2 != 4) {
                throw new IllegalArgumentException(TYPE_ERROR);
            }
            return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10217);
        }
        return invokeI.intValue;
    }

    public static int getSkinColor(Resources resources, int i2) {
        InterceptResult invokeLI;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65586, null, resources, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
                if (resources == null) {
                    resources = BdBaseApplication.getInst().getApp().getResources();
                }
                int skinResourceId = getSkinResourceId(resources, i2);
                if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                    resources2 = resources;
                    skinResourceId = i2;
                }
                try {
                    return resources2.getColor(skinResourceId);
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    return resources.getColor(i2);
                }
            }
            return getColor(i2);
        }
        return invokeLI.intValue;
    }

    public static ColorStateList getSkinColorList(Resources resources, int i2) {
        InterceptResult invokeLI;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65587, null, resources, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
                if (resources == null) {
                    resources = BdBaseApplication.getInst().getApp().getResources();
                }
                int skinResourceId = getSkinResourceId(resources, i2);
                if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                    resources2 = resources;
                    skinResourceId = i2;
                }
                try {
                    return resources2.getColorStateList(skinResourceId);
                } catch (Throwable unused) {
                    return resources.getColorStateList(i2);
                }
            }
            return getColorList(i2);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static Drawable getSkinDrawable(Resources resources, int i2) {
        InterceptResult invokeLI;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65588, null, resources, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
                if (resources == null) {
                    resources = BdBaseApplication.getInst().getApp().getResources();
                }
                int skinResourceId = getSkinResourceId(resources, i2);
                if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                    resources2 = resources;
                    skinResourceId = i2;
                }
                try {
                    return resources2.getDrawable(skinResourceId);
                } catch (Throwable unused) {
                    return resources.getDrawable(i2);
                }
            }
            return getDrawable(i2);
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int getSkinResourceId(Resources resources, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65589, null, resources, i2)) == null) {
            if (mSkinRes == null) {
                mSkinRes = resources;
            }
            if (mSkinRes == null) {
                return 0;
            }
            try {
                str = resources.getResourceName(i2);
            } catch (Exception unused) {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                return 0;
            }
            String substring = str.substring(str.indexOf("/"));
            if (StringUtils.isNull(substring) || !substring.startsWith("/s_")) {
                return 0;
            }
            String substring2 = str.substring(str.indexOf(":"));
            return mSkinRes.getIdentifier(mSkinPackageName + substring2, null, null);
        }
        return invokeLI.intValue;
    }

    public static int getThirdCommentTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65590, null, i2)) == null) {
            if (i2 != 1 && i2 != 4) {
                throw new IllegalArgumentException(TYPE_ERROR);
            }
            return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10218);
        }
        return invokeI.intValue;
    }

    public static int getVectorToDefaultResId(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65591, null, resources, i2)) == null) {
            if (mPluginRes == null) {
                mPluginRes = resources;
            }
            d.a.o0.r.z.a.a("img", -1L, 0, "svg_load_failed", 0, "svg_load_failed", "version_code", Build.VERSION.RELEASE, "model", Build.MODEL, "brand", Build.BRAND);
            try {
                String resourceName = resources.getResourceName(i2);
                if (StringUtils.isNull(resourceName)) {
                    return 0;
                }
                String replace = resourceName.replace("_svg", "");
                if (replace.indexOf(":") <= 0 || mPluginRes == null) {
                    return 0;
                }
                if (sPacknameLength == 0) {
                    String packageName = BdBaseApplication.getInst().getPackageName();
                    sPackagename = packageName;
                    sPacknameLength = packageName.length();
                }
                if (replace.length() > sPacknameLength && replace.charAt(sPacknameLength) != ':' && replace.startsWith(sPackagename)) {
                    replace = sPackagename + replace.substring(replace.indexOf(":"));
                }
                return mPluginRes.getIdentifier(replace + nightSufix, null, null);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLI.intValue;
    }

    public static boolean isCurrentSystemDarkMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getResources() == null || TbadkCoreApplication.getInst().getResources().getConfiguration() == null || (TbadkCoreApplication.getInst().getResources().getConfiguration().uiMode & 48) != 32) ? false : true : invokeV.booleanValue;
    }

    public static void setBackgroundColor(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65593, null, view, i2) == null) {
            setBackgroundColor(view, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundColorToTransparent(View view, @ColorRes int i2, GradientDrawable.Orientation orientation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65595, null, view, i2, orientation) == null) || view == null || i2 == 0 || orientation == null) {
            return;
        }
        view.setBackgroundDrawable(new GradientDrawable(orientation, new int[]{getColor(i2), 0}));
    }

    public static void setBackgroundColorWithAlpha(View view, int i2, float f2, int i3) {
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65596, null, new Object[]{view, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || view == null || i2 == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (i3 == 0) {
            color = view.getResources().getColor(i2);
        } else {
            color = getColor(i3, view.getResources(), i2);
        }
        view.setBackgroundColor(c.a(color, f2));
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundColorWithSkin(View view, int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65597, null, view, i2) == null) || view == null || i2 == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            color = getSkinColor(view.getResources(), i2);
        } else {
            color = getColor(view.getResources(), i2);
        }
        view.setBackgroundColor(color);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65598, null, popupWindow, i2) == null) {
            setBackgroundDrawable(popupWindow, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundEndColorToAutoColor(View view, @ColorRes int i2, GradientDrawable.Orientation orientation, float[] fArr) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65600, null, view, i2, orientation, fArr) == null) || view == null || i2 == 0 || orientation == null || fArr.length < 8) {
            return;
        }
        int color = getColor(i2);
        int[] iArr = {c.b(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(orientation);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(orientation, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        view.setBackgroundDrawable(gradientDrawable);
    }

    public static void setBackgroundResource(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65601, null, view, i2) == null) {
            setBackgroundResource(view, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundResourceSelector(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65603, null, view, i2, i3) == null) {
            setBackgroundSelector(view, i2, i3, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundResourceWithSkin(View view, int i2) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65604, null, view, i2) == null) || view == null || i2 == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            drawable = getSkinDrawable(view.getResources(), i2);
        } else {
            drawable = getDrawable(view.getResources(), i2);
        }
        view.setBackgroundDrawable(drawable);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundSelector(View view, int i2, int i3, int i4) {
        StateListDrawable createStateDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65605, null, view, i2, i3, i4) == null) || i2 == 0 || i3 == 0 || view == null || (createStateDrawable = createStateDrawable(i2, i3, i4)) == null) {
            return;
        }
        view.setBackgroundDrawable(createStateDrawable);
    }

    public static void setBackgroundShapeDrawable(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65609, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) || view == null) {
            return;
        }
        GradientDrawable createShapeDrawable = createShapeDrawable(i2, i3, i5, i7, i8);
        GradientDrawable createShapeDrawable2 = createShapeDrawable(i2, i4, i6, i7, i8);
        if (createShapeDrawable == null || createShapeDrawable2 == null) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, createShapeDrawable2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, createShapeDrawable2);
        stateListDrawable.addState(new int[0], createShapeDrawable);
        view.setBackgroundDrawable(stateListDrawable);
    }

    public static void setBackgroundShapeDrawableWithShadow(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65610, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) || view == null) {
            return;
        }
        view.setLayerType(1, null);
        ShapeDrawable createShapeDrawableWithShadow = createShapeDrawableWithShadow(i2, i3, i5, i6, i7, i8, i9);
        ShapeDrawable createShapeDrawableWithShadow2 = createShapeDrawableWithShadow(i2, i4, i5, i6, i7, i8, i9);
        if (createShapeDrawableWithShadow == null || createShapeDrawableWithShadow2 == null) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, createShapeDrawableWithShadow2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, createShapeDrawableWithShadow2);
        stateListDrawable.addState(new int[0], createShapeDrawableWithShadow);
        view.setBackgroundDrawable(stateListDrawable);
    }

    public static void setBgColor(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65611, null, view, i2) == null) || view == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        if (i2 != 1 && i2 != 4) {
            view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10163));
        } else {
            view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
        }
    }

    @Deprecated
    public static void setBlueTextColor1(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65612, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.common_color_10213, 1);
    }

    public static void setBlueTextColor2(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65613, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.common_color_10214, 1);
    }

    @Deprecated
    public static void setButtonTextColor(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65614, null, textView, i2) == null) || textView == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        if (i2 != 1 && i2 != 4) {
            textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
        } else {
            textView.setTextColor(app.getResources().getColor(R.color.common_color_10212));
        }
    }

    public static void setCommonListView(ListView listView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65615, null, listView, i2) == null) || listView == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        setBackgroundColor(listView, R.color.common_color_10163);
        listView.setCacheColorHint(app.getResources().getColor(17170445));
        listView.setDivider(getDrawable(R.drawable.list_divider));
        listView.setSelector(getDrawable(R.drawable.list_selector));
    }

    public static void setCommonListViewNoBackground(ListView listView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65616, null, listView, i2) == null) || listView == null) {
            return;
        }
        listView.setCacheColorHint(BdBaseApplication.getInst().getApp().getResources().getColor(17170445));
        listView.setDivider(getDrawable(R.drawable.list_divider));
        listView.setSelector(getDrawable(R.drawable.list_selector));
    }

    public static void setCommonTabBgImage(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65617, null, view, i2) == null) || view == null) {
            return;
        }
        setBackgroundResource(view, R.drawable.home_radio_button);
    }

    public static void setDarkLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i2) {
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65618, null, tBLottieAnimationView, i2) == null) || (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) {
            return;
        }
        tBLottieAnimationView.setAnimation(darkResourceId);
    }

    public static void setDayOrDarkSkinTypeWithSystemMode(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65619, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean isCurrentSystemDarkMode = isCurrentSystemDarkMode();
            Activity b2 = b.f().b();
            if (b2 == null) {
                return;
            }
            if (!isCurrentSystemDarkMode) {
                if (z) {
                    UtilHelper.showSkinChangeAnimation(b2);
                }
                if (z2) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(0);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(0);
                    return;
                }
                TbadkCoreApplication.getInst().setSkinType(0);
            } else if (d.a.o0.r.d0.b.j().g("key_is_dark_mode_notify_shown", false)) {
                boolean g2 = d.a.o0.r.d0.b.j().g("key_is_follow_system_mode", false);
                if (z) {
                    UtilHelper.showSkinChangeAnimation(b2);
                }
                int i2 = g2 ? 4 : 0;
                if (z2) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(i2);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(i2);
                    return;
                }
                TbadkCoreApplication.getInst().setSkinType(i2);
            } else {
                d.a.o0.r.d0.b.j().t("key_is_dark_mode_notify_shown", true);
                d.a.o0.r.d0.b.j().t("key_is_follow_system_mode", true);
                TbadkCoreApplication.getInst().setSkinType(isCurrentSystemDarkMode() ? 4 : 0);
            }
        }
    }

    public static void setFrsPBBgColor(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65620, null, view, i2) == null) || view == null) {
            return;
        }
        setBackgroundResource(view, R.drawable.common_bg);
    }

    public static void setGrayTextColor1(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65621, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.CAM_X0105, 1);
    }

    public static void setGrayTextColor2(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65622, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.common_color_10005, 1);
    }

    public static void setGrayTextColor3(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65623, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.common_color_10215, 1);
    }

    public static void setImageResource(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65624, null, imageView, i2) == null) || imageView == null || i2 == 0) {
            return;
        }
        imageView.setImageDrawable(getDrawable(imageView.getResources(), i2));
    }

    public static void setImageResourceFromContainer(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65626, null, imageView, i2) == null) || imageView == null || i2 == 0) {
            return;
        }
        imageView.setImageDrawable(getDrawable((Resources) null, i2));
    }

    public static void setImageResourceSelector(ImageView imageView, int i2, int i3, int i4) {
        StateListDrawable createStateDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65628, null, imageView, i2, i3, i4) == null) || i2 == 0 || i3 == 0 || imageView == null || (createStateDrawable = createStateDrawable(i2, i3, i4)) == null) {
            return;
        }
        imageView.setImageDrawable(createStateDrawable);
    }

    public static void setListViewNoDivider(ListView listView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65629, null, listView, i2) == null) || listView == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        setBackgroundColor(listView, R.color.common_color_10163);
        listView.setCacheColorHint(app.getResources().getColor(17170445));
        listView.setSelector(getDrawable(R.drawable.list_selector));
    }

    public static void setLoginBgColor(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65630, null, view, i2) == null) || view == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        if (i2 != 1 && i2 != 4) {
            view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10216));
        } else {
            view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
        }
    }

    public static void setLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i2) {
        int lottieAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65631, null, tBLottieAnimationView, i2) == null) || (lottieAnimation = getLottieAnimation(i2)) <= 0) {
            return;
        }
        tBLottieAnimationView.setAnimation(lottieAnimation);
    }

    public static void setLvSelector(ListView listView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65632, null, listView, i2) == null) || listView == null) {
            return;
        }
        listView.setSelector(getDrawable(R.drawable.list_selector));
    }

    public static void setNavbarIconSrc(ImageView imageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65633, null, imageView, i2, i3) == null) {
            setNavbarIconSrc(imageView, i2, i3, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setNavbarTitleColor(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65636, null, view, i2, i3) == null) {
            setNavbarTitleColor(view, i2, i3, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setNightLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i2) {
        int nightResouceId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65638, null, tBLottieAnimationView, i2) == null) || (nightResouceId = getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) {
            return;
        }
        tBLottieAnimationView.setAnimation(nightResouceId);
    }

    public static void setNineTextColorMode(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65639, null, textView, z) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (z) {
                textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
            } else {
                setViewTextColor(textView, R.color.CAM_X0201, 1);
            }
        }
    }

    public static void setNormalBackgroundResource(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65640, null, view, i2) == null) || view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(i2);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setSkinRes(String str) throws IllegalAccessException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65641, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources == null) {
                return;
            }
            am = (AssetManager) AssetManager.class.newInstance();
            File GetFile = FileHelper.GetFile(str);
            if (GetFile != null && GetFile.exists()) {
                am.getClass().getDeclaredMethod(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(am, GetFile.getAbsolutePath());
                mSkinRes = new Resources(am, resources.getDisplayMetrics(), resources.getConfiguration());
                mSkinPackageName = FileHelper.getApkFilePackageName(str);
                return;
            }
            l.L(BdBaseApplication.getInst().getApp(), R.string.theme_skin_apk_error);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public static void setSubPbBgFootImage(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65642, null, view, i2) == null) || view == null) {
            return;
        }
        setBackgroundResource(view, R.drawable.bg_pb_list_bottom);
    }

    public static void setSubPbBgHeadImage(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65643, null, view, i2) == null) || view == null) {
            return;
        }
        setBackgroundResource(view, R.drawable.bg_pb_list_top);
    }

    @Deprecated
    public static void setTextColor(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65644, null, textView, i2) == null) || textView == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        if (i2 != 1 && i2 != 4) {
            textView.setTextColor(app.getResources().getColor(R.color.black_alpha100));
        } else {
            textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
        }
    }

    public static void setTopBarBackBgImage(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65645, null, imageView, i2) == null) || imageView == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        setImageResource(imageView, R.drawable.icon_topbar_return_n);
    }

    public static void setTopBarBgImage(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65646, null, view, i2) == null) || view == null) {
            return;
        }
        setBackgroundResource(view, R.drawable.titlebar_bg);
    }

    public static void setTopBarCommonButtonBgImage(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65647, null, textView, i2) == null) {
            if (textView != null) {
                setBackgroundResource(textView, R.drawable.title_comm);
            }
            setTopBarTitleColor(textView, i2);
        }
    }

    public static void setTopBarCommonDeleteButton(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65648, null, textView, i2) == null) {
            if (textView != null) {
                setBackgroundResource(textView, R.drawable.navi_del_text_bg);
            }
            setTopBarCommonDeleteButtonText(textView, i2);
        }
    }

    public static void setTopBarCommonDeleteButtonText(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65649, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.navi_del_text, 1);
    }

    public static void setTopBarCommonFinishButton(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65650, null, textView, i2) == null) {
            if (textView != null) {
                setBackgroundResource(textView, R.drawable.navi_done_text_bg);
            }
            setTopBarCommonFinishButtonText(textView, i2);
        }
    }

    public static void setTopBarCommonFinishButtonText(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65651, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.navi_done_text, 1);
    }

    public static void setTopBarCommonHiliteButton(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65652, null, textView, i2) == null) {
            if (textView != null) {
                setBackgroundResource(textView, R.drawable.title_comm_hilite);
            }
            setTopBarTitleColor(textView, i2);
        }
    }

    public static void setTopBarCommonOperateButton(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65653, null, textView, i2) == null) {
            setTopBarCommonOperateButtonText(textView, i2);
        }
    }

    public static void setTopBarCommonOperateButtonText(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65654, null, textView, i2) == null) || textView == null) {
            return;
        }
        setViewTextColor(textView, R.color.navi_op_text, 1);
    }

    public static void setTopBarRefrshBgImage(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65655, null, imageView, i2) == null) || imageView == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        setImageResource(imageView, R.drawable.icon_refresh_n);
    }

    public static void setTopBarSearchBgImage(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65656, null, imageView, i2) == null) || imageView == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        setImageResource(imageView, R.drawable.icon_topbar_search_n);
    }

    public static void setTopBarTitleColor(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65657, null, textView, i2) == null) || textView == null) {
            return;
        }
        Application app = BdBaseApplication.getInst().getApp();
        if (i2 != 1 && i2 != 4) {
            textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
        } else {
            textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
        }
    }

    public static void setViewCheckedTextColorSelector(View view, int i2, int i3, int i4) {
        ColorStateList createCheckedColorStateList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65658, null, view, i2, i3, i4) == null) || i2 == 0 || i3 == 0 || view == null || (createCheckedColorStateList = createCheckedColorStateList(i2, i3, i4, TbadkCoreApplication.getInst().getSkinType())) == null || !(view instanceof CheckBox)) {
            return;
        }
        ((CheckBox) view).setTextColor(createCheckedColorStateList);
    }

    public static void setViewTextColor(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65659, null, view, i2) == null) {
            setViewTextColor(view, i2, 1);
        }
    }

    public static void setViewTextColorSelector(View view, int i2) {
        ColorStateList createColorStateList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65663, null, view, i2) == null) || i2 == 0 || view == null || (createColorStateList = createColorStateList(i2)) == null) {
            return;
        }
        if (view instanceof Button) {
            ((Button) view).setTextColor(createColorStateList);
        } else if (view instanceof EditText) {
            ((EditText) view).setTextColor(createColorStateList);
        } else if (view instanceof TextView) {
            ((TextView) view).setTextColor(createColorStateList);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setTextColor(createColorStateList);
        }
    }

    public static void setViewTextColorWithClickState(TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65666, null, textView, i2) == null) || textView == null) {
            return;
        }
        textView.setTextColor(getIntColorStateListWithClickState(i2));
    }

    public static void setViewTextColorWithSkin(View view, int i2, int i3) {
        ColorStateList colorList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65667, null, view, i2, i3) == null) || view == null || i2 == 0) {
            return;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            colorList = getSkinColorList(view.getResources(), i2);
        } else {
            colorList = getColorList(view.getResources(), i2);
        }
        if (i3 == 3 && (view instanceof Button)) {
            ((Button) view).setTextColor(colorList);
        } else if (i3 == 2 && (view instanceof EditText)) {
            ((EditText) view).setTextColor(colorList);
        } else if (i3 == 1 && (view instanceof TextView)) {
            ((TextView) view).setTextColor(colorList);
        }
    }

    public static void setBackgroundColor(View view, int i2, int i3) {
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65594, null, view, i2, i3) == null) || view == null || i2 == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (i3 == 0) {
            color = view.getResources().getColor(i2);
        } else {
            color = getColor(i3, view.getResources(), i2);
        }
        view.setBackgroundColor(color);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65599, null, popupWindow, i2, i3) == null) || popupWindow == null || i2 == 0) {
            return;
        }
        popupWindow.setBackgroundDrawable(getDrawable(i3, i2));
    }

    public static void setBackgroundResource(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65602, null, view, i2, i3) == null) || view == null || i2 == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(getDrawable(i3, i2));
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setViewTextColor(View view, int i2, int i3, int i4) {
        ColorStateList colorList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65661, null, view, i2, i3, i4) == null) || view == null || i2 == 0 || view.getResources() == null) {
            return;
        }
        if (i4 == 0) {
            colorList = view.getResources().getColorStateList(i2);
        } else {
            colorList = getColorList(i4, view.getResources(), i2);
        }
        if (colorList == null) {
            return;
        }
        if (i3 == 3 && (view instanceof Button)) {
            ((Button) view).setTextColor(colorList);
        } else if (i3 == 2 && (view instanceof EditText)) {
            ((EditText) view).setTextColor(colorList);
        } else if (i3 == 1 && (view instanceof TextView)) {
            ((TextView) view).setTextColor(colorList);
        } else if (i3 == 4 && (view instanceof CheckBox)) {
            ((CheckBox) view).setTextColor(colorList);
        }
    }

    public static Bitmap getBitmap(Resources resources, int i2, BitmapFactory.Options options, int i3) {
        InterceptResult invokeCommon;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{resources, Integer.valueOf(i2), options, Integer.valueOf(i3)})) == null) {
            if (i2 == 0) {
                return null;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i3 == 1) {
                int nightResouceId = getNightResouceId(resources, i2);
                if (nightResouceId == 0 || mPluginRes == null) {
                    nightResouceId = i2;
                }
                try {
                    Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(mPluginRes, nightResouceId, i2, options);
                    return nightCashBitmap == null ? BitmapHelper.getCashBitmap(i2, options) : nightCashBitmap;
                } catch (Throwable unused) {
                    return BitmapHelper.getCashBitmap(i2, options);
                }
            } else if (i3 == 4) {
                int darkResourceId = getDarkResourceId(resources, i2);
                if (darkResourceId == 0 || (resources2 = mPluginRes) == null) {
                    darkResourceId = i2;
                } else {
                    resources = resources2;
                }
                try {
                    Bitmap darkCashBitmap = BitmapHelper.getDarkCashBitmap(mPluginRes, darkResourceId, i2, options);
                    return (darkCashBitmap == null && (darkCashBitmap = BitmapHelper.getNightCashBitmap(mPluginRes, getNightResouceId(resources, i2), i2, options)) == null) ? BitmapHelper.getCashBitmap(i2, options) : darkCashBitmap;
                } catch (Throwable unused2) {
                    return BitmapHelper.getCashBitmap(i2, options);
                }
            } else if (i3 == 2) {
                int skinResourceId = getSkinResourceId(resources, i2);
                if (skinResourceId == 0) {
                    return BitmapHelper.getCashBitmap(i2, options);
                }
                try {
                    Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(mSkinRes, skinResourceId, i2, options);
                    return themeCashBitmap == null ? BitmapHelper.getCashBitmap(i2, options) : themeCashBitmap;
                } catch (Throwable unused3) {
                    return BitmapHelper.getCashBitmap(i2, options);
                }
            } else {
                return BitmapHelper.getCashBitmap(i2, options);
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static void setImageResource(ImageView imageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65625, null, imageView, i2, i3) == null) || imageView == null || i2 == 0) {
            return;
        }
        Drawable drawable = null;
        if (i3 == 0) {
            try {
                drawable = imageView.getResources().getDrawable(i2);
            } catch (Throwable unused) {
            }
        } else {
            drawable = getDrawable(i3, imageView.getResources(), i2);
        }
        imageView.setImageDrawable(drawable);
    }

    public static void setImageResourceSelector(ImageView imageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65627, null, imageView, i2, i3) == null) {
            setImageResourceSelector(imageView, i2, i3, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setNavbarIconSrc(ImageView imageView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65634, null, imageView, i2, i3, i4) == null) || i2 == 0 || i3 == 0 || imageView == null) {
            return;
        }
        boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
        if (i4 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
            if (z) {
                imageView.setImageResource(i2);
            } else {
                imageView.setImageResource(i3);
            }
        } else if (i4 != 1 && i4 != 4) {
            setImageResource(imageView, i2, i4);
        } else {
            setImageResource(imageView, i3, i4);
        }
    }

    public static void setNavbarTitleColor(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65637, null, view, i2, i3, i4) == null) || i2 == 0 || i3 == 0 || view == null) {
            return;
        }
        boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
        if (i4 != 2 || TbadkCoreApplication.getInst().getUsedThemeId() <= 0) {
            setViewTextColor(view, i2);
        } else if (z) {
            setViewTextColor(view, i2);
        } else {
            setViewTextColor(view, i3);
        }
    }

    public static Bitmap getBitmap565Quality(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65557, null, i2, i3)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return getBitmap(null, i2, options, i3);
        }
        return (Bitmap) invokeII.objValue;
    }

    public static Bitmap getBitmapLowQuality(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65560, null, i2, i3)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            return getBitmap(null, i2, options, i3);
        }
        return (Bitmap) invokeII.objValue;
    }

    public static ColorStateList createColorStateList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            int color = getColor(TbadkCoreApplication.getInst().getSkinType(), i2);
            int a2 = c.a(color, RESOURCE_ALPHA_PRESS);
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{a2, a2, color});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static GradientDrawable createShapeDrawableFromColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i2, i3)) == null) {
            if (i3 == 0) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i3);
            if (i2 > 0) {
                gradientDrawable.setCornerRadius(i2);
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeII.objValue;
    }

    public static GradientDrawable createShapeDrawable(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4, i5)) == null) ? createShapeDrawable(i2, i3, i4, i5, TbadkCoreApplication.getInst().getSkinType()) : (GradientDrawable) invokeIIII.objValue;
    }

    public static StateListDrawable createStateDrawable(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65549, null, i2, i3)) == null) ? createStateDrawable(i2, i3, TbadkCoreApplication.getInst().getSkinType()) : (StateListDrawable) invokeII.objValue;
    }

    public static void setBackgroundShapeDrawable(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65608, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            setBackgroundShapeDrawable(view, i2, i3, i4, i5, i6, i7, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static GradientDrawable createShapeDrawableFromColor(int i2, int i3, String str, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4)})) == null) ? createShapeDrawableFromColor(i2, i3, str, i4, TbadkCoreApplication.getInst().getSkinType()) : (GradientDrawable) invokeCommon.objValue;
    }

    public static void setNavbarIconSrc(ImageView imageView, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65635, null, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i2 == 0 || i3 == 0 || imageView == null) {
            return;
        }
        boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
        if (i5 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
            if (z) {
                imageView.setImageResource(i2);
            } else {
                imageView.setImageResource(i3);
            }
        } else if (i5 != 1 && i5 != 4) {
            setImageResource(imageView, i2, i5);
        } else {
            setImageResource(imageView, i4, i5);
        }
    }

    public static int getColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65563, null, i2, i3)) == null) ? getColor(i2, null, i3) : invokeII.intValue;
    }

    public static ColorStateList getColorList(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65570, null, resources, i2)) == null) ? getColorList(TbadkCoreApplication.getInst().getSkinType(), resources, i2) : (ColorStateList) invokeLI.objValue;
    }

    public static Drawable getDrawable(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, resources, i2)) == null) ? getDrawable(TbadkCoreApplication.getInst().getSkinType(), resources, i2) : (Drawable) invokeLI.objValue;
    }

    public static void setBackgroundShapeDrawable(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65606, null, view, i2, i3, i4) == null) {
            setBackgroundShapeDrawable(view, i2, i3, i4, 0, 0, 0, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setViewTextColorSelector(View view, int i2, int i3, int i4) {
        ColorStateList createColorStateList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65665, null, view, i2, i3, i4) == null) || i2 == 0 || i3 == 0 || view == null || (createColorStateList = createColorStateList(i2, i3, i4)) == null) {
            return;
        }
        if (view instanceof Button) {
            ((Button) view).setTextColor(createColorStateList);
        } else if (view instanceof EditText) {
            ((EditText) view).setTextColor(createColorStateList);
        } else if (view instanceof TextView) {
            ((TextView) view).setTextColor(createColorStateList);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setTextColor(createColorStateList);
        }
    }

    public static ColorStateList createColorStateList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? createColorStateList(i2, i3, TbadkCoreApplication.getInst().getSkinType()) : (ColorStateList) invokeII.objValue;
    }

    public static int getColor(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65565, null, resources, i2)) == null) ? getColor(TbadkCoreApplication.getInst().getSkinType(), resources, i2) : invokeLI.intValue;
    }

    public static ColorStateList getColorList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65568, null, i2, i3)) == null) ? getColorList(i2, null, i3) : (ColorStateList) invokeII.objValue;
    }

    public static Drawable getDrawable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65576, null, i2)) == null) ? getDrawable(TbadkCoreApplication.getInst().getSkinType(), null, i2) : (Drawable) invokeI.objValue;
    }

    public static ShapeDrawable createShapeDrawableWithShadow(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) ? createShapeDrawableWithShadow(i2, i3, i4, i5, i6, i7, TbadkCoreApplication.getInst().getSkinType()) : (ShapeDrawable) invokeCommon.objValue;
    }

    public static int getColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i2)) == null) ? getColor(TbadkCoreApplication.getInst().getSkinType(), null, i2) : invokeI.intValue;
    }

    public static ColorStateList getColorList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i2)) == null) ? getColorList(TbadkCoreApplication.getInst().getSkinType(), null, i2) : (ColorStateList) invokeI.objValue;
    }

    public static Drawable getDrawable(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65577, null, i2, i3)) == null) {
            if (i2 == 0) {
                try {
                    return BdBaseApplication.getInst().getApp().getResources().getDrawable(i3);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return getDrawable(i2, null, i3);
        }
        return (Drawable) invokeII.objValue;
    }

    public static void setBackgroundShapeDrawable(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65607, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            setBackgroundShapeDrawable(view, i2, i3, i4, 0, 0, 0, i5);
        }
    }

    public static void setViewTextColor(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65660, null, view, i2, i3) == null) {
            setViewTextColor(view, i2, i3, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static boolean setViewTextColor(View view, String str) {
        InterceptResult invokeLL;
        Resources resources;
        int identifier;
        ColorStateList colorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65662, null, view, str)) == null) {
            if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.getInst().getPackageName())) <= 0 || (colorList = getColorList(resources, identifier)) == null || !(view instanceof TextView)) {
                return false;
            }
            ((TextView) view).setTextColor(colorList);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void setViewTextColorSelector(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65664, null, view, i2, i3) == null) {
            setViewTextColorSelector(view, i2, i3, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static Bitmap getBitmap(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? getBitmap(null, i2, new BitmapFactory.Options()) : (Bitmap) invokeI.objValue;
    }
}
