package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class TextViewCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    public static final int LINES = 1;
    public static final String LOG_TAG = "TextViewCompat";
    public static Field sMaxModeField;
    public static boolean sMaxModeFieldFetched;
    public static Field sMaximumField;
    public static boolean sMaximumFieldFetched;
    public static Field sMinModeField;
    public static boolean sMinModeFieldFetched;
    public static Field sMinimumField;
    public static boolean sMinimumFieldFetched;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static class OreoCallback implements ActionMode.Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        public transient /* synthetic */ FieldHolder $fh;
        public final ActionMode.Callback mCallback;
        public boolean mCanUseMenuBuilderReferences;
        public boolean mInitializedMenuBuilderReferences;
        public Class<?> mMenuBuilderClass;
        public Method mMenuBuilderRemoveItemAtMethod;
        public final TextView mTextView;

        public OreoCallback(ActionMode.Callback callback, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallback = callback;
            this.mTextView = textView;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain") : (Intent) invokeV.objValue;
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, resolveInfo, textView)) == null) {
                Intent putExtra = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(textView));
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
            }
            return (Intent) invokeLL.objValue;
        }

        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, packageManager)) == null) {
                ArrayList arrayList = new ArrayList();
                if (context instanceof Activity) {
                    for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(createProcessTextIntent(), 0)) {
                        if (isSupportedActivity(resolveInfo, context)) {
                            arrayList.add(resolveInfo);
                        }
                    }
                    return arrayList;
                }
                return arrayList;
            }
            return (List) invokeLL.objValue;
        }

        private boolean isEditable(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, this, textView)) == null) ? (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled() : invokeL.booleanValue;
        }

        private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, resolveInfo, context)) == null) {
                if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo.exported) {
                    String str = activityInfo.permission;
                    return str == null || context.checkSelfPermission(str) == 0;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        private void recomputeProcessTextMenuItems(Menu menu) {
            Method declaredMethod;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, menu) == null) {
                Context context = this.mTextView.getContext();
                PackageManager packageManager = context.getPackageManager();
                if (!this.mInitializedMenuBuilderReferences) {
                    this.mInitializedMenuBuilderReferences = true;
                    try {
                        Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                        this.mMenuBuilderClass = cls;
                        this.mMenuBuilderRemoveItemAtMethod = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                        this.mCanUseMenuBuilderReferences = true;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        this.mMenuBuilderClass = null;
                        this.mMenuBuilderRemoveItemAtMethod = null;
                        this.mCanUseMenuBuilderReferences = false;
                    }
                }
                try {
                    if (this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu)) {
                        declaredMethod = this.mMenuBuilderRemoveItemAtMethod;
                    } else {
                        declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                    }
                    for (int size = menu.size() - 1; size >= 0; size--) {
                        MenuItem item = menu.getItem(size);
                        if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                            declaredMethod.invoke(menu, Integer.valueOf(size));
                        }
                    }
                    List<ResolveInfo> supportedActivities = getSupportedActivities(context, packageManager);
                    for (int i2 = 0; i2 < supportedActivities.size(); i2++) {
                        ResolveInfo resolveInfo = supportedActivities.get(i2);
                        menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo, this.mTextView)).setShowAsAction(1);
                    }
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, actionMode, menuItem)) == null) ? this.mCallback.onActionItemClicked(actionMode, menuItem) : invokeLL.booleanValue;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, actionMode, menu)) == null) ? this.mCallback.onCreateActionMode(actionMode, menu) : invokeLL.booleanValue;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, actionMode) == null) {
                this.mCallback.onDestroyActionMode(actionMode);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, actionMode, menu)) == null) {
                recomputeProcessTextMenuItems(menu);
                return this.mCallback.onPrepareActionMode(actionMode, menu);
            }
            return invokeLL.booleanValue;
        }
    }

    public TextViewCompat() {
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

    public static int getAutoSizeMaxTextSize(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return textView.getAutoSizeMaxTextSize();
            }
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int getAutoSizeMinTextSize(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return textView.getAutoSizeMinTextSize();
            }
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeMinTextSize();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int getAutoSizeStepGranularity(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return textView.getAutoSizeStepGranularity();
            }
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeStepGranularity();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return textView.getAutoSizeTextAvailableSizes();
            }
            return textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
        }
        return (int[]) invokeL.objValue;
    }

    public static int getAutoSizeTextType(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return textView.getAutoSizeTextType();
            }
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeTextType();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, textView)) == null) {
            Preconditions.checkNotNull(textView);
            if (Build.VERSION.SDK_INT >= 24) {
                return textView.getCompoundDrawableTintList();
            }
            if (textView instanceof TintableCompoundDrawablesView) {
                return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintList();
            }
            return null;
        }
        return (ColorStateList) invokeL.objValue;
    }

    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, textView)) == null) {
            Preconditions.checkNotNull(textView);
            if (Build.VERSION.SDK_INT >= 24) {
                return textView.getCompoundDrawableTintMode();
            }
            if (textView instanceof TintableCompoundDrawablesView) {
                return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeL.objValue;
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, textView)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 18) {
                return textView.getCompoundDrawablesRelative();
            }
            if (i2 >= 17) {
                boolean z = textView.getLayoutDirection() == 1;
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (z) {
                    Drawable drawable = compoundDrawables[2];
                    Drawable drawable2 = compoundDrawables[0];
                    compoundDrawables[0] = drawable;
                    compoundDrawables[2] = drawable2;
                }
                return compoundDrawables;
            }
            return textView.getCompoundDrawables();
        }
        return (Drawable[]) invokeL.objValue;
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, textView)) == null) ? textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top : invokeL.intValue;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, textView)) == null) ? textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom : invokeL.intValue;
    }

    public static int getMaxLines(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return textView.getMaxLines();
            }
            if (!sMaxModeFieldFetched) {
                sMaxModeField = retrieveField("mMaxMode");
                sMaxModeFieldFetched = true;
            }
            Field field = sMaxModeField;
            if (field == null || retrieveIntFromField(field, textView) != 1) {
                return -1;
            }
            if (!sMaximumFieldFetched) {
                sMaximumField = retrieveField("mMaximum");
                sMaximumFieldFetched = true;
            }
            Field field2 = sMaximumField;
            if (field2 != null) {
                return retrieveIntFromField(field2, textView);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int getMinLines(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return textView.getMinLines();
            }
            if (!sMinModeFieldFetched) {
                sMinModeField = retrieveField("mMinMode");
                sMinModeFieldFetched = true;
            }
            Field field = sMinModeField;
            if (field == null || retrieveIntFromField(field, textView) != 1) {
                return -1;
            }
            if (!sMinimumFieldFetched) {
                sMinimumField = retrieveField("mMinimum");
                sMinimumFieldFetched = true;
            }
            Field field2 = sMinimumField;
            if (field2 != null) {
                return retrieveIntFromField(field2, textView);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @RequiresApi(18)
    public static int getTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, textDirectionHeuristic)) == null) {
            if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                return 1;
            }
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                return 2;
            }
            if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                return 3;
            }
            if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                return 4;
            }
            if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                return 5;
            }
            if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                return 6;
            }
            return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
        }
        return invokeL.intValue;
    }

    @RequiresApi(18)
    public static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, textView)) == null) {
            if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
                return TextDirectionHeuristics.LTR;
            }
            if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality != 1 && directionality != 2) {
                    return TextDirectionHeuristics.LTR;
                }
                return TextDirectionHeuristics.RTL;
            }
            boolean z = textView.getLayoutDirection() == 1;
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z) {
                        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        }
        return (TextDirectionHeuristic) invokeL.objValue;
    }

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, textView)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
            }
            PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setBreakStrategy(textView.getBreakStrategy());
                builder.setHyphenationFrequency(textView.getHyphenationFrequency());
            }
            if (Build.VERSION.SDK_INT >= 18) {
                builder.setTextDirection(getTextDirectionHeuristic(textView));
            }
            return builder.build();
        }
        return (PrecomputedTextCompat.Params) invokeL.objValue;
    }

    public static Field retrieveField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            Field field = null;
            try {
                field = TextView.class.getDeclaredField(str);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException unused) {
                Log.e(LOG_TAG, "Could not retrieve " + str + " field.");
                return field;
            }
        }
        return (Field) invokeL.objValue;
    }

    public static int retrieveIntFromField(Field field, TextView textView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, field, textView)) == null) {
            try {
                return field.getInt(textView);
            } catch (IllegalAccessException unused) {
                Log.d(LOG_TAG, "Could not retrieve value of " + field.getName() + " field.");
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView textView, int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{textView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            } else if (textView instanceof AutoSizeableTextView) {
                ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            }
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView textView, @NonNull int[] iArr, int i2) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, textView, iArr, i2) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            } else if (textView instanceof AutoSizeableTextView) {
                ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            }
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, textView, i2) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                textView.setAutoSizeTextTypeWithDefaults(i2);
            } else if (textView instanceof AutoSizeableTextView) {
                ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i2);
            }
        }
    }

    public static void setCompoundDrawableTintList(@NonNull TextView textView, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, textView, colorStateList) == null) {
            Preconditions.checkNotNull(textView);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setCompoundDrawableTintList(colorStateList);
            } else if (textView instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
    }

    public static void setCompoundDrawableTintMode(@NonNull TextView textView, @Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, textView, mode) == null) {
            Preconditions.checkNotNull(textView);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setCompoundDrawableTintMode(mode);
            } else if (textView instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
            }
        }
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65559, null, textView, drawable, drawable2, drawable3, drawable4) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 18) {
                textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            } else if (i2 >= 17) {
                boolean z = textView.getLayoutDirection() == 1;
                Drawable drawable5 = z ? drawable3 : drawable;
                if (!z) {
                    drawable = drawable3;
                }
                textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
            } else {
                textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            }
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65561, null, textView, drawable, drawable2, drawable3, drawable4) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 18) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            } else if (i2 >= 17) {
                boolean z = textView.getLayoutDirection() == 1;
                Drawable drawable5 = z ? drawable3 : drawable;
                if (!z) {
                    drawable = drawable3;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            }
        }
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView textView, @NonNull ActionMode.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, textView, callback) == null) {
            textView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(textView, callback));
        }
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65563, null, textView, i2) == null) {
            Preconditions.checkArgumentNonnegative(i2);
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setFirstBaselineToTopHeight(i2);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding()) {
                i3 = fontMetricsInt.ascent;
            } else {
                i3 = fontMetricsInt.top;
            }
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
            }
        }
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65564, null, textView, i2) == null) {
            Preconditions.checkArgumentNonnegative(i2);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding()) {
                i3 = fontMetricsInt.descent;
            } else {
                i3 = fontMetricsInt.bottom;
            }
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
            }
        }
    }

    public static void setLineHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65565, null, textView, i2) == null) {
            Preconditions.checkArgumentNonnegative(i2);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i2 != fontMetricsInt) {
                textView.setLineSpacing(i2 - fontMetricsInt, 1.0f);
            }
        }
    }

    public static void setPrecomputedText(@NonNull TextView textView, @NonNull PrecomputedTextCompat precomputedTextCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, textView, precomputedTextCompat) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                textView.setText(precomputedTextCompat.getPrecomputedText());
            } else if (getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams())) {
                textView.setText(precomputedTextCompat);
            } else {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        }
    }

    public static void setTextAppearance(@NonNull TextView textView, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, null, textView, i2) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i2);
            } else {
                textView.setTextAppearance(textView.getContext(), i2);
            }
        }
    }

    public static void setTextMetricsParams(@NonNull TextView textView, @NonNull PrecomputedTextCompat.Params params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, textView, params) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                textView.setTextDirection(getTextDirection(params.getTextDirection()));
            }
            if (Build.VERSION.SDK_INT < 23) {
                float textScaleX = params.getTextPaint().getTextScaleX();
                textView.getPaint().set(params.getTextPaint());
                if (textScaleX == textView.getTextScaleX()) {
                    textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
                }
                textView.setTextScaleX(textScaleX);
                return;
            }
            textView.getPaint().set(params.getTextPaint());
            textView.setBreakStrategy(params.getBreakStrategy());
            textView.setHyphenationFrequency(params.getHyphenationFrequency());
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView textView, @NonNull ActionMode.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, textView, callback)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            return (i2 < 26 || i2 > 27 || (callback instanceof OreoCallback)) ? callback : new OreoCallback(callback, textView);
        }
        return (ActionMode.Callback) invokeLL.objValue;
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4, @DrawableRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{textView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 18) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
            } else if (i6 >= 17) {
                boolean z = textView.getLayoutDirection() == 1;
                int i7 = z ? i4 : i2;
                if (!z) {
                    i2 = i4;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(i7, i3, i2, i5);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
            }
        }
    }
}
