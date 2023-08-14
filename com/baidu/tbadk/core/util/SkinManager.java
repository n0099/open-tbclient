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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.vka;
import com.baidu.tieba.w65;
import com.baidu.tieba.y9a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import tbclient.ThemeColorInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class SkinManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float RESOURCE_ALPHA_DISABLE;
    public static final float RESOURCE_ALPHA_PRESS;
    public static final int SKIN_TYPE_DARK = 4;
    public static final int SKIN_TYPE_NONE = 3;
    public static final int SKIN_TYPE_NORMAL = 0;
    public static final String SKIN_TYPE_STR_DARK = "dark";
    public static final String SKIN_TYPE_STR_NORMAL = "default";
    public static final int SKIN_TYPE_THEME = 2;
    public static final String TAG = "SkinManager";
    public static final String THEME_ICON_COLOR_VALUE = "icon_color";
    public static final String THEME_ICON_COVER_VALUE = "icon_cover_maintab";
    public static String TYPE_COLOR = null;
    public static String TYPE_ERROR = null;
    public static AssetManager am = null;
    public static final String darkSuffix = "_2";
    public static Bitmap mDefaultBitmap = null;
    public static Resources mPluginRes = null;
    public static String mSkinPackageName = null;
    public static Resources mSkinRes = null;
    public static final String nightSufix = "_1";
    public static SparseIntArray sDarkResourceIdMap;
    public static SparseIntArray sNightResourceIdMap;
    public static String sPackagename;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
        RESOURCE_ALPHA_PRESS = w65.b(R.string.A_X07);
        RESOURCE_ALPHA_DISABLE = w65.b(R.string.A_X09);
        TYPE_ERROR = "skinType not support";
        TYPE_COLOR = "com.baidu.tieba:color/CAM_X0";
        sPackagename = null;
        sNightResourceIdMap = new SparseIntArray();
        sDarkResourceIdMap = new SparseIntArray();
    }

    public static boolean isCurrentSystemDarkMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getResources() == null || TbadkCoreApplication.getInst().getResources().getConfiguration() == null || (TbadkCoreApplication.getInst().getResources().getConfiguration().uiMode & 48) != 32) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public SkinManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getCurrentSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return TbadkCoreApplication.getInst().getSkinType();
        }
        return invokeV.intValue;
    }

    public static String getCurrentSkinTypeString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                return "dark";
            }
            return "default";
        }
        return (String) invokeV.objValue;
    }

    public static String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return sPackagename;
        }
        return (String) invokeV.objValue;
    }

    public static Bitmap getTbDefaultBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            Bitmap bitmap = mDefaultBitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                mDefaultBitmap = getBitmap(null, R.color.transparent, new BitmapFactory.Options());
            }
            return mDefaultBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public static ColorStateList createCheckedColorStateList(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, null, i, i2, i3, i4)) == null) {
            if (i != 0 && i2 != 0 && i3 != 0) {
                return new ColorStateList(new int[][]{new int[]{16842912}, new int[]{-16842910}, new int[0]}, new int[]{getColor(i4, i2), y9a.a(getColor(i4, i3), RESOURCE_ALPHA_DISABLE), getColor(i4, i)});
            }
            return null;
        }
        return (ColorStateList) invokeIIII.objValue;
    }

    public static void setBackgroundEndColorToAutoColor(View view2, @ColorRes int i, GradientDrawable.Orientation orientation, float[] fArr) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65587, null, view2, i, orientation, fArr) == null) && view2 != null && i != 0 && orientation != null && fArr.length >= 8) {
            int color = getColor(i);
            int[] iArr = {y9a.c(color), color};
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
            view2.setBackgroundDrawable(gradientDrawable);
        }
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(65607, null, imageView, i, i2, i3) == null) && i != 0 && i2 != 0 && imageView != null) {
            boolean z = true;
            if (TbadkCoreApplication.getInst().getUsedThemeColor() != 1) {
                z = false;
            }
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(i2);
                }
            } else if (i3 == 4) {
                setImageResource(imageView, i2, i3);
            } else {
                setImageResource(imageView, i, i3);
            }
        }
    }

    public static void setViewTextColorSelector(View view2, int i, int i2, int i3) {
        ColorStateList createColorStateList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(65627, null, view2, i, i2, i3) != null) || i == 0 || i2 == 0 || view2 == null || (createColorStateList = createColorStateList(i, i2, i3)) == null) {
            return;
        }
        if (view2 instanceof Button) {
            ((Button) view2).setTextColor(createColorStateList);
        } else if (view2 instanceof EditText) {
            ((EditText) view2).setTextColor(createColorStateList);
        } else if (view2 instanceof TextView) {
            ((TextView) view2).setTextColor(createColorStateList);
        } else if (view2 instanceof CheckBox) {
            ((CheckBox) view2).setTextColor(createColorStateList);
        }
    }

    public static ColorStateList createColorStateList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 0) {
                return null;
            }
            int color = getColor(TbadkCoreApplication.getInst().getSkinType(), i);
            int a = y9a.a(color, RESOURCE_ALPHA_PRESS);
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{a, a, color});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static Drawable getColorDrawableWithClickState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = getDrawable(i);
            drawable.mutate().setAlpha((int) (RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842910, 16842919}, drawable);
            stateListDrawable.addState(new int[0], getDrawable(i).mutate());
            return stateListDrawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public static ColorStateList getColorStateListWithClickState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            if (i <= 0) {
                return null;
            }
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[0]}, new int[]{y9a.a(getColor(i), RESOURCE_ALPHA_PRESS), getColor(i)});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            return createColorStateList(i, i2, TbadkCoreApplication.getInst().getSkinType());
        }
        return (ColorStateList) invokeII.objValue;
    }

    public static GradientDrawable createShapeDrawableFromColor(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i2);
            if (i > 0) {
                gradientDrawable.setCornerRadius(i);
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeII.objValue;
    }

    public static int getColor(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, null, i, i2)) == null) {
            return getColor(i, null, i2);
        }
        return invokeII.intValue;
    }

    public static int getColorFromServerColor(ThemeColorInfo themeColorInfo, @ColorRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, themeColorInfo, i)) == null) {
            if (themeColorInfo == null) {
                return getColor(i);
            }
            int b = vka.b(themeColorInfo);
            if (b == 0 || b == Integer.MAX_VALUE) {
                return getColor(i);
            }
            return b;
        }
        return invokeLI.intValue;
    }

    public static ColorStateList getColorList(Resources resources, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, resources, i)) == null) {
            return getColorList(TbadkCoreApplication.getInst().getSkinType(), resources, i);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static Drawable getDrawable(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65568, null, i, i2)) == null) {
            if (i == 0) {
                try {
                    return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return getDrawable(i, null, i2);
        }
        return (Drawable) invokeII.objValue;
    }

    public static void setBackgroundColor(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65581, null, view2, i) == null) {
            setBackgroundColor(view2, i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65585, null, popupWindow, i) == null) {
            setBackgroundDrawable(popupWindow, i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundResource(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65588, null, view2, i) == null) {
            setBackgroundResource(view2, i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Deprecated
    public static void setBlueTextColor1(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65598, null, textView, i) == null) && textView != null) {
            setViewTextColor(textView, R.color.common_color_10213, 1);
        }
    }

    public static void setDarkLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i) {
        int darkResourceId;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65600, null, tBLottieAnimationView, i) == null) && (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
            tBLottieAnimationView.setAnimation(darkResourceId);
        }
    }

    public static void setFrsPBBgColor(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65602, null, view2, i) == null) && view2 != null) {
            setBackgroundResource(view2, R.drawable.common_bg);
        }
    }

    public static void setImageResource(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65603, null, imageView, i) == null) && imageView != null && i != 0) {
            imageView.setImageDrawable(getDrawable(imageView.getResources(), i));
        }
    }

    public static void setLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i) {
        int lottieAnimation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65605, null, tBLottieAnimationView, i) == null) && (lottieAnimation = getLottieAnimation(i)) > 0) {
            tBLottieAnimationView.setAnimation(lottieAnimation);
        }
    }

    public static void setTopBarBackBgImage(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65614, null, imageView, i) == null) && imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_topbar_return_n);
        }
    }

    public static void setTopBarBgImage(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65615, null, view2, i) == null) && view2 != null) {
            setBackgroundResource(view2, R.drawable.titlebar_bg);
        }
    }

    public static void setTopBarCommonFinishButton(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65616, null, textView, i) == null) {
            if (textView != null) {
                setBackgroundResource(textView, R.drawable.navi_done_text_bg);
            }
            setTopBarCommonFinishButtonText(textView, i);
        }
    }

    public static void setTopBarCommonFinishButtonText(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65617, null, textView, i) == null) && textView != null) {
            setViewTextColor(textView, R.color.navi_done_text, 1);
        }
    }

    public static void setTopBarRefrshBgImage(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65618, null, imageView, i) == null) && imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_refresh_n);
        }
    }

    public static void setViewTextColor(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65621, null, view2, i) == null) {
            setViewTextColor(view2, i, 1);
        }
    }

    public static void setViewTextColorWithClickState(TextView textView, @ColorInt int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65628, null, textView, i) != null) || textView == null) {
            return;
        }
        textView.setTextColor(getIntColorStateListWithClickState(i));
    }

    public static ColorStateList createColorStateList(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65541, null, i, i2, i3)) == null) {
            if (i != 0 && i2 != 0) {
                int color = getColor(i3, i);
                int color2 = getColor(i3, i2);
                return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
            }
            return null;
        }
        return (ColorStateList) invokeIII.objValue;
    }

    public static StateListDrawable createStateDrawable(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65546, null, i, i2, i3)) == null) {
            if (i != 0 && i2 != 0) {
                Drawable drawable = getDrawable(i3, i);
                Drawable drawable2 = getDrawable(i3, i2);
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

    public static void setBackgroundColor(View view2, int i, int i2) {
        int color;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65582, null, view2, i, i2) == null) && view2 != null && i != 0) {
            int paddingLeft = view2.getPaddingLeft();
            int paddingRight = view2.getPaddingRight();
            int paddingTop = view2.getPaddingTop();
            int paddingBottom = view2.getPaddingBottom();
            if (i2 == 0) {
                color = view2.getResources().getColor(i);
            } else {
                color = getColor(i2, view2.getResources(), i);
            }
            view2.setBackgroundColor(color);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void setBackgroundResourceWithTintColor(View view2, int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65591, null, view2, i, i2) == null) && view2 != null && i != 0) {
            int paddingLeft = view2.getPaddingLeft();
            int paddingRight = view2.getPaddingRight();
            int paddingTop = view2.getPaddingTop();
            int paddingBottom = view2.getPaddingBottom();
            Drawable drawable = getDrawable(i);
            if (drawable == null) {
                return;
            }
            ColorStateList colorListByResourceType = SvgManager.SvgResourceStateType.NORMAL.getColorListByResourceType(i2);
            Drawable mutate = drawable.mutate();
            DrawableCompat.setTintList(mutate, colorListByResourceType);
            view2.setBackgroundDrawable(mutate);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static GradientDrawable createShapeDrawable(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i2 == 0) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getColor(i5, i2));
            if (i > 0) {
                gradientDrawable.setCornerRadius(i);
            }
            if (i3 != 0 && i4 > 0) {
                gradientDrawable.setStroke(i4, getColor(i5, i3));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public static GradientDrawable createShapeDrawableFromColor(int i, int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            return createShapeDrawableFromColor(i, i2, str, i3, TbadkCoreApplication.getInst().getSkinType());
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public static void setNavbarTitleColor(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(65610, null, view2, i, i2, i3) == null) && i != 0 && i2 != 0 && view2 != null) {
            boolean z = true;
            if (TbadkCoreApplication.getInst().getUsedThemeColor() != 1) {
                z = false;
            }
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    setViewTextColor(view2, i);
                    return;
                } else {
                    setViewTextColor(view2, i2);
                    return;
                }
            }
            setViewTextColor(view2, i);
        }
    }

    public static GradientDrawable createShapeDrawableFromColor(int i, int i2, String str, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 == 0) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getColor(i4, i2));
            if (i > 0) {
                gradientDrawable.setCornerRadius(i);
            }
            if (i3 > 0) {
                gradientDrawable.setStroke(i3, Color.parseColor("#80" + str));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65608, null, new Object[]{imageView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i != 0 && i2 != 0 && imageView != null) {
            boolean z = true;
            if (TbadkCoreApplication.getInst().getUsedThemeColor() != 1) {
                z = false;
            }
            if (i4 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(i2);
                }
            } else if (i4 == 4) {
                setImageResource(imageView, i3, i4);
            } else {
                setImageResource(imageView, i, i4);
            }
        }
    }

    public static int getBgColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 4) {
                return app.getResources().getColor(R.color.common_color_10150);
            }
            return app.getResources().getColor(R.color.common_color_10163);
        }
        return invokeI.intValue;
    }

    public static ColorStateList getIntColorStateListWithClickState(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65571, null, i)) == null) {
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[0]}, new int[]{y9a.a(i, RESOURCE_ALPHA_PRESS), i});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static Bitmap getBitmap(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            return getBitmap(null, i, new BitmapFactory.Options());
        }
        return (Bitmap) invokeI.objValue;
    }

    public static Bitmap getBitmap565Quality(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return getBitmap(null, i, options);
        }
        return (Bitmap) invokeI.objValue;
    }

    public static int getColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            return getColor(TbadkCoreApplication.getInst().getSkinType(), null, i);
        }
        return invokeI.intValue;
    }

    public static ColorStateList getColorList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i)) == null) {
            return getColorList(TbadkCoreApplication.getInst().getSkinType(), null, i);
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static int getCommentTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) {
            if (i == 4) {
                return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10004);
            }
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return invokeI.intValue;
    }

    public static Drawable getDrawable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i)) == null) {
            return getDrawable(TbadkCoreApplication.getInst().getSkinType(), null, i);
        }
        return (Drawable) invokeI.objValue;
    }

    public static int getLottieAnimation(int i) {
        InterceptResult invokeI;
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i)) == null) {
            if (i <= 0) {
                return 0;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4 && (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
                return darkResourceId;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static int getResourceId(int i) {
        InterceptResult invokeI;
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65574, null, i)) == null) {
            if (i <= 0) {
                return 0;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4 && (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
                return darkResourceId;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, str) == null) {
            sPackagename = str;
        }
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, resources, i, options)) == null) {
            return getBitmap(resources, i, options, TbadkCoreApplication.getInst().getSkinType());
        }
        return (Bitmap) invokeLIL.objValue;
    }

    public static void setBackgroundColorToTransparent(View view2, @ColorRes int i, GradientDrawable.Orientation orientation) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65583, null, view2, i, orientation) == null) && view2 != null && i != 0 && orientation != null) {
            view2.setBackgroundDrawable(new GradientDrawable(orientation, new int[]{getColor(i), 0}));
        }
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65586, null, popupWindow, i, i2) == null) && popupWindow != null && i != 0) {
            popupWindow.setBackgroundDrawable(getDrawable(i2, i));
        }
    }

    public static void setBackgroundResourceSelector(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65590, null, view2, i, i2) == null) {
            setBackgroundSelector(view2, i, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setImageResource(ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65604, null, imageView, i, i2) == null) && imageView != null && i != 0) {
            Drawable drawable = null;
            if (i2 == 0) {
                try {
                    drawable = imageView.getResources().getDrawable(i);
                } catch (Throwable unused) {
                }
            } else {
                drawable = getDrawable(i2, imageView.getResources(), i);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65606, null, imageView, i, i2) == null) {
            setNavbarIconSrc(imageView, i, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setNavbarTitleColor(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65609, null, view2, i, i2) == null) {
            setNavbarTitleColor(view2, i, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setViewTextColor(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65622, null, view2, i, i2) == null) {
            setViewTextColor(view2, i, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setViewTextColorSelector(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65626, null, view2, i, i2) == null) {
            setViewTextColorSelector(view2, i, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{resources, Integer.valueOf(i), options, Integer.valueOf(i2)})) == null) {
            if (i == 0) {
                return null;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i2 == 4) {
                int darkResourceId = getDarkResourceId(resources, i);
                if (darkResourceId == 0 || mPluginRes == null) {
                    darkResourceId = i;
                }
                try {
                    Bitmap darkCashBitmap = BitmapHelper.getDarkCashBitmap(mPluginRes, darkResourceId, i, options);
                    if (darkCashBitmap == null) {
                        return BitmapHelper.getCashBitmap(i, options);
                    }
                    return darkCashBitmap;
                } catch (Throwable unused) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
            } else if (i2 == 2) {
                int skinResourceId = getSkinResourceId(resources, i);
                if (skinResourceId == 0) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
                try {
                    Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(mSkinRes, skinResourceId, i, options);
                    if (themeCashBitmap == null) {
                        return BitmapHelper.getCashBitmap(i, options);
                    }
                    return themeCashBitmap;
                } catch (Throwable unused2) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
            } else {
                return BitmapHelper.getCashBitmap(i, options);
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static void setBackgroundColorWithAlpha(View view2, int i, float f, int i2) {
        int color;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{view2, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && view2 != null && i != 0) {
            int paddingLeft = view2.getPaddingLeft();
            int paddingRight = view2.getPaddingRight();
            int paddingTop = view2.getPaddingTop();
            int paddingBottom = view2.getPaddingBottom();
            if (i2 == 0) {
                color = view2.getResources().getColor(i);
            } else {
                color = getColor(i2, view2.getResources(), i);
            }
            view2.setBackgroundColor(y9a.a(color, f));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void setViewTextColor(View view2, int i, int i2, int i3) {
        ColorStateList colorList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(65623, null, view2, i, i2, i3) == null) && view2 != null && i != 0 && view2.getResources() != null) {
            if (i3 == 0) {
                colorList = view2.getResources().getColorStateList(i);
            } else {
                colorList = getColorList(i3, view2.getResources(), i);
            }
            if (colorList == null) {
                return;
            }
            if (i2 == 3 && (view2 instanceof Button)) {
                ((Button) view2).setTextColor(colorList);
            } else if (i2 == 2 && (view2 instanceof EditText)) {
                ((EditText) view2).setTextColor(colorList);
            } else if (i2 == 1 && (view2 instanceof TextView)) {
                ((TextView) view2).setTextColor(colorList);
            } else if (i2 == 4 && (view2 instanceof CheckBox)) {
                ((CheckBox) view2).setTextColor(colorList);
            }
        }
    }

    public static int getColor(int i, Resources resources, int i2) {
        InterceptResult invokeCommon;
        int darkResourceId;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i), resources, Integer.valueOf(i2)})) == null) {
            int idByABTest = EMABTest.getIdByABTest(i2, "color");
            if (idByABTest == 0) {
                return 0;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i != 2 ? i != 4 || (darkResourceId = getDarkResourceId(resources, idByABTest)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getSkinResourceId(resources, idByABTest)) == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                darkResourceId = idByABTest;
            }
            try {
                return resources2.getColor(darkResourceId);
            } catch (Throwable unused) {
                return resources.getColor(idByABTest);
            }
        }
        return invokeCommon.intValue;
    }

    public static ColorStateList getColorList(int i, Resources resources, int i2) {
        InterceptResult invokeCommon;
        int darkResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{Integer.valueOf(i), resources, Integer.valueOf(i2)})) == null) {
            int idByABTest = EMABTest.getIdByABTest(i2, "color");
            if (idByABTest == 0) {
                return null;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i != 2 ? !(i != 4 || (darkResourceId = getDarkResourceId(resources, idByABTest)) == 0 || mPluginRes == null) : !((darkResourceId = getSkinResourceId(resources, idByABTest)) == 0 || mSkinRes == null)) {
                idByABTest = darkResourceId;
            }
            if (idByABTest == 0) {
                return null;
            }
            try {
                return AppCompatResources.getColorStateList(BdBaseApplication.getInst().getApp(), idByABTest);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public static Drawable getDrawable(int i, Resources resources, int i2) {
        InterceptResult invokeCommon;
        int darkResourceId;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{Integer.valueOf(i), resources, Integer.valueOf(i2)})) == null) {
            if (i2 == 0) {
                return null;
            }
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            if (i != 2 ? i != 4 || (darkResourceId = getDarkResourceId(resources, i2)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getSkinResourceId(resources, i2)) == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                darkResourceId = i2;
            }
            try {
                try {
                    return resources2.getDrawable(darkResourceId);
                } catch (Throwable unused) {
                    return null;
                }
            } catch (Throwable unused2) {
                return resources.getDrawable(i2);
            }
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static int getColor(Resources resources, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, resources, i)) == null) {
            return getColor(TbadkCoreApplication.getInst().getSkinType(), resources, i);
        }
        return invokeLI.intValue;
    }

    public static Drawable getDrawable(Resources resources, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65570, null, resources, i)) == null) {
            return getDrawable(TbadkCoreApplication.getInst().getSkinType(), resources, i);
        }
        return (Drawable) invokeLI.objValue;
    }

    public static ColorStateList getColorStateListWithClickAndDisableState(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65561, null, i, i2)) == null) {
            if (i <= 0) {
                return null;
            }
            return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{-16842910}, new int[0]}, new int[]{y9a.a(getColor(i2, i), RESOURCE_ALPHA_PRESS), y9a.a(getColor(i2, i), RESOURCE_ALPHA_DISABLE), getColor(i2, i)});
        }
        return (ColorStateList) invokeII.objValue;
    }

    public static int getSkinColor(Resources resources, int i) {
        InterceptResult invokeLI;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65575, null, resources, i)) == null) {
            if (i == 0) {
                return 0;
            }
            if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
                if (resources == null) {
                    resources = BdBaseApplication.getInst().getApp().getResources();
                }
                int skinResourceId = getSkinResourceId(resources, i);
                if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                    resources2 = resources;
                    skinResourceId = i;
                }
                try {
                    return resources2.getColor(skinResourceId);
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    return resources.getColor(i);
                }
            }
            return getColor(i);
        }
        return invokeLI.intValue;
    }

    public static Drawable getSkinDrawable(Resources resources, int i) {
        InterceptResult invokeLI;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65576, null, resources, i)) == null) {
            if (i == 0) {
                return null;
            }
            if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
                if (resources == null) {
                    resources = BdBaseApplication.getInst().getApp().getResources();
                }
                int skinResourceId = getSkinResourceId(resources, i);
                if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                    resources2 = resources;
                    skinResourceId = i;
                }
                try {
                    return resources2.getDrawable(skinResourceId);
                } catch (Throwable unused) {
                    return resources.getDrawable(i);
                }
            }
            return getDrawable(i);
        }
        return (Drawable) invokeLI.objValue;
    }

    public static boolean setViewTextColor(View view2, String str) {
        InterceptResult invokeLL;
        Resources resources;
        int identifier;
        ColorStateList colorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65624, null, view2, str)) == null) {
            if (view2 == null || StringUtils.isNull(str) || (resources = view2.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.getInst().getPackageName())) <= 0 || (colorList = getColorList(resources, identifier)) == null || !(view2 instanceof TextView)) {
                return false;
            }
            ((TextView) view2).setTextColor(colorList);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int getDarkResourceId(Resources resources, int i) {
        InterceptResult invokeLI;
        int i2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, resources, i)) == null) {
            if (mPluginRes == null) {
                mPluginRes = resources;
            }
            try {
                i2 = sDarkResourceIdMap.get(i, -1);
            } catch (ArrayIndexOutOfBoundsException e) {
                DefaultLog.getInstance().e(TAG, "catch ArrayIndexOutOfBoundsException : " + e.getMessage());
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    i2 = -1;
                } else {
                    throw e;
                }
            }
            if (i2 != -1) {
                return i2;
            }
            try {
                str = resources.getResourceName(i);
            } catch (Exception unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
                if (StringUtils.isNull(sPackagename)) {
                    sPackagename = BdBaseApplication.getInst().getPackageName();
                }
                Resources resources2 = mPluginRes;
                i2 = resources2.getIdentifier((sPackagename + str.substring(str.indexOf(":"))) + "_2", null, null);
                if (i2 <= 0) {
                    Resources resources3 = mPluginRes;
                    i2 = resources3.getIdentifier((BdBaseApplication.getInst().getPackageName() + str2.substring(str2.indexOf(":"))) + "_2", null, null);
                }
            }
            if (i2 != 0) {
                sDarkResourceIdMap.put(i, i2);
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static int getSkinResourceId(Resources resources, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65577, null, resources, i)) == null) {
            if (mSkinRes == null) {
                mSkinRes = resources;
            }
            if (mSkinRes == null) {
                return 0;
            }
            try {
                str = resources.getResourceName(i);
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

    public static int getVectorToDefaultResId(Resources resources, int i) {
        InterceptResult invokeLI;
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, resources, i)) == null) {
            if (mPluginRes == null) {
                mPluginRes = resources;
            }
            Logger.addLog("img", -1L, 0, "svg_load_failed", 0, "svg_load_failed", "version_code", DeviceInfoHelper.getOsVersion(), "model", DeviceInfoHelper.getModel(), "brand", Build.BRAND);
            try {
                String resourceName = resources.getResourceName(i);
                if (StringUtils.isNull(resourceName)) {
                    return 0;
                }
                if (resourceName.replace("_svg", "").indexOf(":") <= 0 || mPluginRes == null) {
                    return 0;
                }
                if (StringUtils.isNull(sPackagename)) {
                    sPackagename = BdBaseApplication.getInst().getPackageName();
                }
                String str = sPackagename + replace.substring(replace.indexOf(":"));
                return mPluginRes.getIdentifier(str + nightSufix, null, null);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLI.intValue;
    }

    public static void setDayOrDarkSkinTypeWithSystemMode(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean isCurrentSystemDarkMode = isCurrentSystemDarkMode();
            Activity currentActivity = BdActivityStack.getInst().currentActivity();
            if (currentActivity == null) {
                return;
            }
            int i = 0;
            if (!isCurrentSystemDarkMode) {
                if (z) {
                    UtilHelper.showSkinChangeAnimation(currentActivity);
                }
                if (z2) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(0);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(0);
                    return;
                }
                TbadkCoreApplication.getInst().setSkinType(0);
            } else if (SharedPrefHelper.getInstance().getBoolean("key_is_dark_mode_notify_shown", false)) {
                boolean z3 = SharedPrefHelper.getInstance().getBoolean("key_is_follow_system_mode", false);
                if (z) {
                    UtilHelper.showSkinChangeAnimation(currentActivity);
                }
                if (z3) {
                    i = 4;
                }
                if (z2) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(i);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(i);
                    return;
                }
                TbadkCoreApplication.getInst().setSkinType(i);
            } else {
                SharedPrefHelper.getInstance().putBoolean("key_is_dark_mode_notify_shown", true);
                SharedPrefHelper.getInstance().putBoolean("key_is_follow_system_mode", true);
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (isCurrentSystemDarkMode()) {
                    i = 4;
                }
                inst.setSkinType(i);
            }
        }
    }

    public static void setBackgroundResource(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65589, null, view2, i, i2) == null) && view2 != null && i != 0) {
            int paddingLeft = view2.getPaddingLeft();
            int paddingRight = view2.getPaddingRight();
            int paddingTop = view2.getPaddingTop();
            int paddingBottom = view2.getPaddingBottom();
            view2.setBackgroundDrawable(getDrawable(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void setBackgroundSelector(View view2, int i, int i2, int i3) {
        StateListDrawable createStateDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(65592, null, view2, i, i2, i3) != null) || i == 0 || i2 == 0 || view2 == null || (createStateDrawable = createStateDrawable(i, i2, i3)) == null) {
            return;
        }
        view2.setBackgroundDrawable(createStateDrawable);
    }

    public static void setBackgroundShapeDrawable(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65593, null, view2, i, i2, i3) == null) {
            setBackgroundShapeDrawable(view2, i, i2, i3, 0, 0, 0, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setViewCheckedTextColorSelector(View view2, int i, int i2, int i3) {
        ColorStateList createCheckedColorStateList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(65620, null, view2, i, i2, i3) == null) && i != 0 && i2 != 0 && view2 != null && (createCheckedColorStateList = createCheckedColorStateList(i, i2, i3, TbadkCoreApplication.getInst().getSkinType())) != null && (view2 instanceof CheckBox)) {
            ((CheckBox) view2).setTextColor(createCheckedColorStateList);
        }
    }

    public static void setBackgroundShapeDrawable(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65594, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            setBackgroundShapeDrawable(view2, i, i2, i3, 0, 0, 0, i4);
        }
    }

    public static void setBackgroundShapeDrawable(View view2, int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65595, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            setBackgroundShapeDrawable(view2, i, i2, i3, i4, i5, i6, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void setBackgroundShapeDrawable(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65596, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) != null) || view2 == null) {
            return;
        }
        GradientDrawable createShapeDrawable = createShapeDrawable(i, i2, i4, i6, i7);
        GradientDrawable createShapeDrawable2 = createShapeDrawable(i, i3, i5, i6, i7);
        if (createShapeDrawable != null && createShapeDrawable2 != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, createShapeDrawable2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, createShapeDrawable2);
            stateListDrawable.addState(new int[0], createShapeDrawable);
            view2.setBackgroundDrawable(stateListDrawable);
        }
    }

    public static void setBgColor(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65597, null, view2, i) == null) && view2 != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 4) {
                view2.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
            } else {
                view2.setBackgroundColor(app.getResources().getColor(R.color.common_color_10163));
            }
        }
    }

    @Deprecated
    public static void setButtonTextColor(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65599, null, textView, i) == null) && textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10212));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    @Deprecated
    public static void setTextColor(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65613, null, textView, i) == null) && textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.black_alpha100));
            }
        }
    }

    public static void setTopBarTitleColor(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65619, null, textView, i) == null) && textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public static void setViewTextColorSelector(View view2, int i) {
        ColorStateList createColorStateList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65625, null, view2, i) != null) || i == 0 || view2 == null || (createColorStateList = createColorStateList(i)) == null) {
            return;
        }
        if (view2 instanceof Button) {
            ((Button) view2).setTextColor(createColorStateList);
        } else if (view2 instanceof EditText) {
            ((EditText) view2).setTextColor(createColorStateList);
        } else if (view2 instanceof TextView) {
            ((TextView) view2).setTextColor(createColorStateList);
        } else if (view2 instanceof CheckBox) {
            ((CheckBox) view2).setTextColor(createColorStateList);
        }
    }

    public static void setSkinRes(String str) throws SecurityException, IllegalArgumentException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65612, null, str) != null) || StringUtils.isNull(str)) {
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
            BdUtilHelper.showToast(BdBaseApplication.getInst().getApp(), (int) R.string.theme_skin_apk_error);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
