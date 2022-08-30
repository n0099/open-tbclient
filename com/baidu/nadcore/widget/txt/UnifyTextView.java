package com.baidu.nadcore.widget.txt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.q01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b%\u0010+J\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001d¨\u0006-"}, d2 = {"Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "", "id", "getDimensionPixelSize", "(Landroid/content/Context;I)I", "", "content", "", "hasEmoji", "(Ljava/lang/CharSequence;)Z", "bottomPadding", "", "setBottomPadding", "(I)V", "text", "Landroid/widget/TextView$BufferType;", "type", "setTextWithUnifiedPadding", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "topPadding", "setTopPadding", "topAndBottomCompatable", "(Ljava/lang/CharSequence;)V", "DEBUG", "Z", "DEFAULT_TOP_BOTTOM_PADDING", "I", "", "TAG", "Ljava/lang/String;", "mBottomBuffer", "mBottomPadding", "mTopBuffer", "mTopPadding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ExcludeInnerPaddingSpan", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class UnifyTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* loaded from: classes2.dex */
    public static final class a implements LineHeightSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final TextView b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public a(TextView textView, int i, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.b = textView;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.a = "meizu_15_CN";
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fm) {
            CharSequence subSequence;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{text, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fm}) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(fm, "fm");
                int i5 = fm.descent - fm.ascent;
                if (i5 <= 0) {
                    return;
                }
                int textSize = (int) this.b.getTextSize();
                int round = Math.round(fm.descent * ((textSize * 1.0f) / i5));
                fm.descent = round;
                int i6 = round - textSize;
                fm.ascent = i6;
                fm.top = (i6 - this.c) - this.f;
                String a = q01.a.a();
                int a2 = q01.b.a();
                int i7 = 0;
                try {
                    if (text.length() == i2 && (subSequence = text.subSequence(i, i2)) != null && (StringsKt__StringsKt.contains$default(subSequence, 'y', false, 2, (Object) null) || StringsKt__StringsKt.contains$default(subSequence, 'g', false, 2, (Object) null))) {
                        i7 = this.d;
                    }
                } catch (Exception unused) {
                }
                if (TextUtils.equals(a, this.a) && a2 == 25 && i > 0) {
                    fm.bottom = ((fm.descent + i7) + this.g) - this.e;
                } else {
                    fm.bottom = fm.descent + i7 + this.g;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifyTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getDimensionPixelSize(i);
        }
        return invokeLI.intValue;
    }

    public final boolean b(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) ? Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]").matcher(charSequence).find() : invokeL.booleanValue;
    }

    public final void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            if (b(charSequence)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.d = Math.round(a(context, R.dimen.obfuscated_res_0x7f070576) * 1.5f);
                if (this.b) {
                    String str = this.a;
                    Log.d(str, "has emoji, mTopBuffer: " + this.d);
                }
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                this.d = a(context2, R.dimen.obfuscated_res_0x7f070576);
                if (this.b) {
                    String str2 = this.a;
                    Log.d(str2, "has no emoji, mTopBuffer: " + this.d);
                }
            }
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            this.e = a(context3, R.dimen.obfuscated_res_0x7f070574);
        }
    }

    public final void setBottomPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.g = i;
        }
    }

    public final void setTextWithUnifiedPadding(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, charSequence, bufferType) == null) || charSequence == null) {
            return;
        }
        c(charSequence);
        float lineSpacingExtra = getLineSpacingExtra();
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
            spannableStringBuilder.setSpan(new a(this, this.d, this.e, (int) lineSpacingExtra, this.f, this.g), 0, charSequence.length(), 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new a(this, this.d, this.e, (int) lineSpacingExtra, this.f, this.g), 0, charSequence.length(), 33);
        }
        setText(spannableStringBuilder, bufferType);
    }

    public final void setTopPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifyTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = "UnifyTextView";
        this.c = a(context, R.dimen.obfuscated_res_0x7f070575);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040643, R.attr.obfuscated_res_0x7f040644});
        this.f = obtainStyledAttributes.getDimensionPixelSize(1, this.c);
        this.g = obtainStyledAttributes.getDimensionPixelSize(0, this.c);
        obtainStyledAttributes.recycle();
    }
}
