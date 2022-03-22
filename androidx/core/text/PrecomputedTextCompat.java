package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char LINE_FEED = '\n';
    @NonNull
    @GuardedBy("sLock")
    public static Executor sExecutor;
    public static final Object sLock;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final int[] mParagraphEnds;
    @NonNull
    public final Params mParams;
    @NonNull
    public final Spannable mText;
    @Nullable
    public final PrecomputedText mWrapped;

    /* loaded from: classes.dex */
    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Params mParams;
            public CharSequence mText;

            public PrecomputedTextCallback(@NonNull Params params, @NonNull CharSequence charSequence) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {params, charSequence};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mParams = params;
                this.mText = charSequence;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? PrecomputedTextCompat.create(this.mText, this.mParams) : (PrecomputedTextCompat) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrecomputedTextFutureTask(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {params, charSequence};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Callable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1344791128, "Landroidx/core/text/PrecomputedTextCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1344791128, "Landroidx/core/text/PrecomputedTextCompat;");
                return;
            }
        }
        sLock = new Object();
    }

    public PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {charSequence, params, iArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mText = new SpannableString(charSequence);
        this.mParams = params;
        this.mParagraphEnds = iArr;
        this.mWrapped = null;
    }

    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, charSequence, params)) == null) {
            Preconditions.checkNotNull(charSequence);
            Preconditions.checkNotNull(params);
            try {
                TraceCompat.beginSection("PrecomputedText");
                if (Build.VERSION.SDK_INT >= 29 && params.mWrapped != null) {
                    return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params.mWrapped), params);
                }
                ArrayList arrayList = new ArrayList();
                int length = charSequence.length();
                int i = 0;
                while (i < length) {
                    int indexOf = TextUtils.indexOf(charSequence, '\n', i, length);
                    i = indexOf < 0 ? length : indexOf + 1;
                    arrayList.add(Integer.valueOf(i));
                }
                int[] iArr = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
                } else if (Build.VERSION.SDK_INT >= 21) {
                    new StaticLayout(charSequence, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
                return new PrecomputedTextCompat(charSequence, params, iArr);
            } finally {
                TraceCompat.endSection();
            }
        }
        return (PrecomputedTextCompat) invokeLL.objValue;
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence, params, executor)) == null) {
            PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(params, charSequence);
            if (executor == null) {
                synchronized (sLock) {
                    if (sExecutor == null) {
                        sExecutor = Executors.newFixedThreadPool(1);
                    }
                    executor = sExecutor;
                }
            }
            executor.execute(precomputedTextFutureTask);
            return precomputedTextFutureTask;
        }
        return (Future) invokeLLL.objValue;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.mText.charAt(i) : invokeI.charValue;
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mWrapped.getParagraphCount();
            }
            return this.mParagraphEnds.length;
        }
        return invokeV.intValue;
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphEnd(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mWrapped.getParagraphEnd(i);
            }
            return this.mParagraphEnds[i];
        }
        return invokeI.intValue;
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphStart(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mWrapped.getParagraphStart(i);
            }
            if (i == 0) {
                return 0;
            }
            return this.mParagraphEnds[i - 1];
        }
        return invokeI.intValue;
    }

    @NonNull
    public Params getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mParams : (Params) invokeV.objValue;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Spannable spannable = this.mText;
            if (spannable instanceof PrecomputedText) {
                return (PrecomputedText) spannable;
            }
            return null;
        }
        return (PrecomputedText) invokeV.objValue;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? this.mText.getSpanEnd(obj) : invokeL.intValue;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? this.mText.getSpanFlags(obj) : invokeL.intValue;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? this.mText.getSpanStart(obj) : invokeL.intValue;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, cls)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return (T[]) this.mWrapped.getSpans(i, i2, cls);
            }
            return (T[]) this.mText.getSpans(i, i2, cls);
        }
        return (T[]) ((Object[]) invokeIIL.objValue);
    }

    @Override // java.lang.CharSequence
    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mText.length() : invokeV.intValue;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i, i2, cls)) == null) ? this.mText.nextSpanTransition(i, i2, cls) : invokeIIL.intValue;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            if (!(obj instanceof MetricAffectingSpan)) {
                if (Build.VERSION.SDK_INT >= 29) {
                    this.mWrapped.removeSpan(obj);
                    return;
                } else {
                    this.mText.removeSpan(obj);
                    return;
                }
            }
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048589, this, obj, i, i2, i3) == null) {
            if (!(obj instanceof MetricAffectingSpan)) {
                if (Build.VERSION.SDK_INT >= 29) {
                    this.mWrapped.setSpan(obj, i, i2, i3);
                    return;
                } else {
                    this.mText.setSpan(obj, i, i2, i3);
                    return;
                }
            }
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i, i2)) == null) ? this.mText.subSequence(i, i2) : (CharSequence) invokeII.objValue;
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mText.toString() : (String) invokeV.objValue;
    }

    @RequiresApi(28)
    public PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {precomputedText, params};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mText = precomputedText;
        this.mParams = params;
        this.mParagraphEnds = null;
        this.mWrapped = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    /* loaded from: classes.dex */
    public static final class Params {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mBreakStrategy;
        public final int mHyphenationFrequency;
        @NonNull
        public final TextPaint mPaint;
        @Nullable
        public final TextDirectionHeuristic mTextDir;
        public final PrecomputedText.Params mWrapped;

        /* loaded from: classes.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mBreakStrategy;
            public int mHyphenationFrequency;
            @NonNull
            public final TextPaint mPaint;
            public TextDirectionHeuristic mTextDir;

            public Builder(@NonNull TextPaint textPaint) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {textPaint};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mPaint = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.mBreakStrategy = 1;
                    this.mHyphenationFrequency = 1;
                } else {
                    this.mHyphenationFrequency = 0;
                    this.mBreakStrategy = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.mTextDir = null;
                }
            }

            @NonNull
            public Params build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency) : (Params) invokeV.objValue;
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    this.mBreakStrategy = i;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    this.mHyphenationFrequency = i;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, textDirectionHeuristic)) == null) {
                    this.mTextDir = textDirectionHeuristic;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        @SuppressLint({"NewApi"})
        public Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textPaint, textDirectionHeuristic, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.mWrapped = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.mWrapped = null;
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = i;
            this.mHyphenationFrequency = i2;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Params) {
                    Params params = (Params) obj;
                    if (equalsWithoutTextDirection(params)) {
                        return Build.VERSION.SDK_INT < 18 || this.mTextDir == params.getTextDirection();
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params)) == null) {
                if ((Build.VERSION.SDK_INT < 23 || (this.mBreakStrategy == params.getBreakStrategy() && this.mHyphenationFrequency == params.getHyphenationFrequency())) && this.mPaint.getTextSize() == params.getTextPaint().getTextSize() && this.mPaint.getTextScaleX() == params.getTextPaint().getTextScaleX() && this.mPaint.getTextSkewX() == params.getTextPaint().getTextSkewX()) {
                    if ((Build.VERSION.SDK_INT < 21 || (this.mPaint.getLetterSpacing() == params.getTextPaint().getLetterSpacing() && TextUtils.equals(this.mPaint.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()))) && this.mPaint.getFlags() == params.getTextPaint().getFlags()) {
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 24) {
                            if (!this.mPaint.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                                return false;
                            }
                        } else if (i >= 17 && !this.mPaint.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                            return false;
                        }
                        return this.mPaint.getTypeface() == null ? params.getTextPaint().getTypeface() == null : this.mPaint.getTypeface().equals(params.getTextPaint().getTypeface());
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBreakStrategy : invokeV.intValue;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHyphenationFrequency : invokeV.intValue;
        }

        @Nullable
        @RequiresApi(18)
        public TextDirectionHeuristic getTextDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTextDir : (TextDirectionHeuristic) invokeV.objValue;
        }

        @NonNull
        public TextPaint getTextPaint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPaint : (TextPaint) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
                }
                if (i >= 21) {
                    return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
                }
                if (i >= 18) {
                    return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
                }
                if (i >= 17) {
                    return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
                }
                return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                StringBuilder sb = new StringBuilder("{");
                sb.append("textSize=" + this.mPaint.getTextSize());
                sb.append(", textScaleX=" + this.mPaint.getTextScaleX());
                sb.append(", textSkewX=" + this.mPaint.getTextSkewX());
                if (Build.VERSION.SDK_INT >= 21) {
                    sb.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
                    sb.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    sb.append(", textLocale=" + this.mPaint.getTextLocales());
                } else if (i >= 17) {
                    sb.append(", textLocale=" + this.mPaint.getTextLocale());
                }
                sb.append(", typeface=" + this.mPaint.getTypeface());
                if (Build.VERSION.SDK_INT >= 26) {
                    sb.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
                }
                sb.append(", textDir=" + this.mTextDir);
                sb.append(", breakStrategy=" + this.mBreakStrategy);
                sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
                sb.append("}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {params};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPaint = params.getTextPaint();
            this.mTextDir = params.getTextDirection();
            this.mBreakStrategy = params.getBreakStrategy();
            this.mHyphenationFrequency = params.getHyphenationFrequency();
            this.mWrapped = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
