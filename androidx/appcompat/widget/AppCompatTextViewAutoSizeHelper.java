package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    public static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    public static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    public static final String TAG = "ACTVAutoSizeHelper";
    public static final RectF TEMP_RECTF;
    public static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    public static final int VERY_WIDE = 1048576;
    public static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache;
    public static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAutoSizeMaxTextSizeInPx;
    public float mAutoSizeMinTextSizeInPx;
    public float mAutoSizeStepGranularityInPx;
    public int[] mAutoSizeTextSizesInPx;
    public int mAutoSizeTextType;
    public final Context mContext;
    public boolean mHasPresetAutoSizeValues;
    public final Impl mImpl;
    public boolean mNeedsAutoSizeText;
    public TextPaint mTempTextPaint;
    @NonNull
    public final TextView mTextView;

    /* loaded from: classes.dex */
    public static class Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Impl() {
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

        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, builder, textView) == null) {
            }
        }

        public boolean isHorizontallyScrollable(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView)) == null) ? ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue() : invokeL.booleanValue;
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Impl23 extends Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Impl23() {
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

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, builder, textView) == null) {
                builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
            }
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Impl29 extends Impl23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Impl29() {
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

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, builder, textView) == null) {
                builder.setTextDirection(textView.getTextDirectionHeuristic());
            }
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView)) == null) ? textView.isHorizontallyScrollable() : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1678761869, "Landroidx/appcompat/widget/AppCompatTextViewAutoSizeHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1678761869, "Landroidx/appcompat/widget/AppCompatTextViewAutoSizeHelper;");
                return;
            }
        }
        TEMP_RECTF = new RectF();
        sTextViewMethodByNameCache = new ConcurrentHashMap<>();
        sTextViewFieldByNameCache = new ConcurrentHashMap<>();
    }

    public AppCompatTextViewAutoSizeHelper(@NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = textView;
        this.mContext = textView.getContext();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            this.mImpl = new Impl29();
        } else if (i4 >= 23) {
            this.mImpl = new Impl23();
        } else {
            this.mImpl = new Impl();
        }
    }

    public static <T> T accessAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, obj, str, t)) == null) {
            try {
                Field textViewField = getTextViewField(str);
                return textViewField == null ? t : (T) textViewField.get(obj);
            } catch (IllegalAccessException e2) {
                Log.w(TAG, "Failed to access TextView#" + str + " member", e2);
                return t;
            }
        }
        return (T) invokeLLL.objValue;
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, iArr)) == null) {
            int length = iArr.length;
            if (length == 0) {
                return iArr;
            }
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (length == arrayList.size()) {
                return iArr;
            }
            int size = arrayList.size();
            int[] iArr2 = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    private void clearAutoSizeConfiguration() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mAutoSizeTextType = 0;
            this.mAutoSizeMinTextSizeInPx = -1.0f;
            this.mAutoSizeMaxTextSizeInPx = -1.0f;
            this.mAutoSizeStepGranularityInPx = -1.0f;
            this.mAutoSizeTextSizesInPx = new int[0];
            this.mNeedsAutoSizeText = false;
        }
    }

    @RequiresApi(23)
    private StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(AdIconUtil.AD_TEXT_ID, this, charSequence, alignment, i2, i3)) == null) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.mTempTextPaint, i2);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i3);
            try {
                this.mImpl.computeAndSetTextDirection(obtain, this.mTextView);
            } catch (ClassCastException unused) {
                Log.w(TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
        return (StaticLayout) invokeLLII.objValue;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, this, charSequence, alignment, i2)) == null) ? new StaticLayout(charSequence, this.mTempTextPaint, i2, alignment, ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue()) : (StaticLayout) invokeLLI.objValue;
    }

    @RequiresApi(16)
    private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, this, charSequence, alignment, i2)) == null) ? new StaticLayout(charSequence, this.mTempTextPaint, i2, alignment, this.mTextView.getLineSpacingMultiplier(), this.mTextView.getLineSpacingExtra(), this.mTextView.getIncludeFontPadding()) : (StaticLayout) invokeLLI.objValue;
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, rectF)) == null) {
            int length = this.mAutoSizeTextSizesInPx.length;
            if (length != 0) {
                int i2 = length - 1;
                int i3 = 1;
                int i4 = 0;
                while (i3 <= i2) {
                    int i5 = (i3 + i2) / 2;
                    if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i5], rectF)) {
                        int i6 = i5 + 1;
                        i4 = i3;
                        i3 = i6;
                    } else {
                        i4 = i5 - 1;
                        i2 = i4;
                    }
                }
                return this.mAutoSizeTextSizesInPx[i4];
            }
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        return invokeL.intValue;
    }

    @Nullable
    public static Field getTextViewField(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                Field field = sTextViewFieldByNameCache.get(str);
                if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                    field.setAccessible(true);
                    sTextViewFieldByNameCache.put(str, field);
                }
                return field;
            } catch (NoSuchFieldException e2) {
                Log.w(TAG, "Failed to access TextView#" + str + " member", e2);
                return null;
            }
        }
        return (Field) invokeL.objValue;
    }

    @Nullable
    public static Method getTextViewMethod(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                Method method = sTextViewMethodByNameCache.get(str);
                if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                    method.setAccessible(true);
                    sTextViewMethodByNameCache.put(str, method);
                }
                return method;
            } catch (Exception e2) {
                Log.w(TAG, "Failed to retrieve TextView#" + str + "() method", e2);
                return null;
            }
        }
        return (Method) invokeL.objValue;
    }

    public static <T> T invokeAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, obj, str, t)) == null) {
            try {
                return (T) getTextViewMethod(str).invoke(obj, new Object[0]);
            } catch (Exception e2) {
                Log.w(TAG, "Failed to invoke TextView#" + str + "() method", e2);
                return t;
            }
        }
        return (T) invokeLLL.objValue;
    }

    private void setRawTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65548, this, f2) == null) || f2 == this.mTextView.getPaint().getTextSize()) {
            return;
        }
        this.mTextView.getPaint().setTextSize(f2);
        boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.mTextView.isInLayout() : false;
        if (this.mTextView.getLayout() != null) {
            this.mNeedsAutoSizeText = false;
            try {
                Method textViewMethod = getTextViewMethod("nullLayouts");
                if (textViewMethod != null) {
                    textViewMethod.invoke(this.mTextView, new Object[0]);
                }
            } catch (Exception e2) {
                Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e2);
            }
            if (!isInLayout) {
                this.mTextView.requestLayout();
            } else {
                this.mTextView.forceLayout();
            }
            this.mTextView.invalidate();
        }
    }

    private boolean setupAutoSizeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
                if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                    int floor = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
                    int[] iArr = new int[floor];
                    for (int i2 = 0; i2 < floor; i2++) {
                        iArr[i2] = Math.round(this.mAutoSizeMinTextSizeInPx + (i2 * this.mAutoSizeStepGranularityInPx));
                    }
                    this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
                }
                this.mNeedsAutoSizeText = true;
            } else {
                this.mNeedsAutoSizeText = false;
            }
            return this.mNeedsAutoSizeText;
        }
        return invokeV.booleanValue;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, typedArray) == null) {
            int length = typedArray.length();
            int[] iArr = new int[length];
            if (length > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
                setupAutoSizeUniformPresetSizesConfiguration();
            }
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int length = this.mAutoSizeTextSizesInPx.length;
            boolean z = length > 0;
            this.mHasPresetAutoSizeValues = z;
            if (z) {
                this.mAutoSizeTextType = 1;
                int[] iArr = this.mAutoSizeTextSizesInPx;
                this.mAutoSizeMinTextSizeInPx = iArr[0];
                this.mAutoSizeMaxTextSizeInPx = iArr[length - 1];
                this.mAutoSizeStepGranularityInPx = -1.0f;
            }
            return this.mHasPresetAutoSizeValues;
        }
        return invokeV.booleanValue;
    }

    private boolean suggestedSizeFitsInSpace(int i2, RectF rectF) {
        InterceptResult invokeIL;
        CharSequence transformation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, this, i2, rectF)) == null) {
            CharSequence text = this.mTextView.getText();
            TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.mTextView)) != null) {
                text = transformation;
            }
            int maxLines = Build.VERSION.SDK_INT >= 16 ? this.mTextView.getMaxLines() : -1;
            initTempTextPaint(i2);
            StaticLayout createLayout = createLayout(text, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
            return (maxLines == -1 || (createLayout.getLineCount() <= maxLines && createLayout.getLineEnd(createLayout.getLineCount() - 1) == text.length())) && ((float) createLayout.getHeight()) <= rectF.bottom;
        }
        return invokeIL.booleanValue;
    }

    private boolean supportsAutoSizeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? !(this.mTextView instanceof AppCompatEditText) : invokeV.booleanValue;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f2, float f3, float f4) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (f2 <= 0.0f) {
                throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
            } else if (f3 <= f2) {
                throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
            } else if (f4 > 0.0f) {
                this.mAutoSizeTextType = 1;
                this.mAutoSizeMinTextSizeInPx = f2;
                this.mAutoSizeMaxTextSizeInPx = f3;
                this.mAutoSizeStepGranularityInPx = f4;
                this.mHasPresetAutoSizeValues = false;
            } else {
                throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && isAutoSizeEnabled()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() <= 0 || this.mTextView.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.mImpl.isHorizontallyScrollable(this.mTextView) ? 1048576 : (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (TEMP_RECTF) {
                    TEMP_RECTF.setEmpty();
                    TEMP_RECTF.right = measuredWidth;
                    TEMP_RECTF.bottom = height;
                    float findLargestTextSizeWhichFits = findLargestTextSizeWhichFits(TEMP_RECTF);
                    if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                        setTextSizeInternal(0, findLargestTextSizeWhichFits);
                    }
                }
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    @VisibleForTesting
    public StaticLayout createLayout(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, alignment, i2, i3)) == null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 23) {
                return createStaticLayoutForMeasuring(charSequence, alignment, i2, i3);
            }
            if (i4 >= 16) {
                return createStaticLayoutForMeasuringPre23(charSequence, alignment, i2);
            }
            return createStaticLayoutForMeasuringPre16(charSequence, alignment, i2);
        }
        return (StaticLayout) invokeLLII.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Math.round(this.mAutoSizeMaxTextSizeInPx) : invokeV.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.round(this.mAutoSizeMinTextSizeInPx) : invokeV.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.round(this.mAutoSizeStepGranularityInPx) : invokeV.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAutoSizeTextSizesInPx : (int[]) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAutoSizeTextType : invokeV.intValue;
    }

    @VisibleForTesting
    public void initTempTextPaint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            TextPaint textPaint = this.mTempTextPaint;
            if (textPaint == null) {
                this.mTempTextPaint = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.mTempTextPaint.set(this.mTextView.getPaint());
            this.mTempTextPaint.setTextSize(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? supportsAutoSizeText() && this.mAutoSizeTextType != 0 : invokeV.booleanValue;
    }

    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i2) {
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i2, 0);
            TextView textView = this.mTextView;
            ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R.styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i2, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
                this.mAutoSizeTextType = obtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
            }
            float dimension = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
            float dimension2 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
            float dimension3 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                setupAutoSizeUniformPresetSizes(obtainTypedArray);
                obtainTypedArray.recycle();
            }
            obtainStyledAttributes.recycle();
            if (supportsAutoSizeText()) {
                if (this.mAutoSizeTextType == 1) {
                    if (!this.mHasPresetAutoSizeValues) {
                        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                        if (dimension2 == -1.0f) {
                            dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                        }
                        if (dimension3 == -1.0f) {
                            dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                        }
                        if (dimension == -1.0f) {
                            dimension = 1.0f;
                        }
                        validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
                    }
                    setupAutoSizeText();
                    return;
                }
                return;
            }
            this.mAutoSizeTextType = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) && supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, iArr, i2) == null) && supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr2);
                if (!setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && supportsAutoSizeText()) {
            if (i2 == 0) {
                clearAutoSizeConfiguration();
            } else if (i2 == 1) {
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (setupAutoSizeText()) {
                    autoSizeText();
                }
            } else {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSizeInternal(int i2, float f2) {
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            Context context = this.mContext;
            if (context == null) {
                resources = Resources.getSystem();
            } else {
                resources = context.getResources();
            }
            setRawTextSize(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
        }
    }
}
