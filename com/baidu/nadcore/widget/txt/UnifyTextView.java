package com.baidu.nadcore.widget.txt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import c.a.c0.g0.f;
import c.a.c0.k0.k;
import c.a.c0.k0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b%\u0010+J\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001d¨\u0006-"}, d2 = {"Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "", "id", "getDimensionPixelSize", "(Landroid/content/Context;I)I", "", "content", "", "hasEmoji", "(Ljava/lang/CharSequence;)Z", "bottomPadding", "", "setBottomPadding", "(I)V", "text", "Landroid/widget/TextView$BufferType;", "type", "setTextWithUnifiedPadding", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "topPadding", "setTopPadding", "topAndBottomCompatable", "(Ljava/lang/CharSequence;)V", "DEBUG", "Z", "DEFAULT_TOP_BOTTOM_PADDING", "I", "", "TAG", "Ljava/lang/String;", "mBottomBuffer", "mBottomPadding", "mTopBuffer", "mTopPadding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ExcludeInnerPaddingSpan", "lib-widget_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public class UnifyTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f37329e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37330f;

    /* renamed from: g  reason: collision with root package name */
    public int f37331g;

    /* renamed from: h  reason: collision with root package name */
    public int f37332h;

    /* renamed from: i  reason: collision with root package name */
    public int f37333i;

    /* renamed from: j  reason: collision with root package name */
    public int f37334j;
    public int k;
    public HashMap l;

    /* loaded from: classes10.dex */
    public static final class a implements LineHeightSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f37335e;

        /* renamed from: f  reason: collision with root package name */
        public final TextView f37336f;

        /* renamed from: g  reason: collision with root package name */
        public final int f37337g;

        /* renamed from: h  reason: collision with root package name */
        public final int f37338h;

        /* renamed from: i  reason: collision with root package name */
        public final int f37339i;

        /* renamed from: j  reason: collision with root package name */
        public final int f37340j;
        public final int k;

        public a(TextView textView, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.f37336f = textView;
            this.f37337g = i2;
            this.f37338h = i3;
            this.f37339i = i4;
            this.f37340j = i5;
            this.k = i6;
            this.f37335e = "meizu_15_CN";
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fm) {
            CharSequence subSequence;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{text, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fm}) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(fm, "fm");
                int i6 = fm.descent - fm.ascent;
                if (i6 <= 0) {
                    return;
                }
                int textSize = (int) this.f37336f.getTextSize();
                int round = Math.round(fm.descent * ((textSize * 1.0f) / i6));
                fm.descent = round;
                int i7 = round - textSize;
                fm.ascent = i7;
                fm.top = (i7 - this.f37337g) - this.f37340j;
                String a = f.a.a();
                int a2 = f.b.a();
                int i8 = 0;
                try {
                    if (text.length() == i3 && (subSequence = text.subSequence(i2, i3)) != null && (StringsKt__StringsKt.contains$default(subSequence, 'y', false, 2, (Object) null) || StringsKt__StringsKt.contains$default(subSequence, 'g', false, 2, (Object) null))) {
                        i8 = this.f37338h;
                    }
                } catch (Exception unused) {
                }
                if (TextUtils.equals(a, this.f37335e) && a2 == 25 && i2 > 0) {
                    fm.bottom = ((fm.descent + i8) + this.k) - this.f37339i;
                } else {
                    fm.bottom = fm.descent + i8 + this.k;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.l) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.l == null) {
                this.l = new HashMap();
            }
            View view = (View) this.l.get(Integer.valueOf(i2));
            if (view == null) {
                View findViewById = findViewById(i2);
                this.l.put(Integer.valueOf(i2), findViewById);
                return findViewById;
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void a(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            if (hasEmoji(charSequence)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.f37332h = Math.round(getDimensionPixelSize(context, k.nad_spannable_exclude_padding_text_top_buffer) * 1.5f);
                if (this.f37330f) {
                    String str = "has emoji, mTopBuffer: " + this.f37332h;
                }
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                this.f37332h = getDimensionPixelSize(context2, k.nad_spannable_exclude_padding_text_top_buffer);
                if (this.f37330f) {
                    String str2 = "has no emoji, mTopBuffer: " + this.f37332h;
                }
            }
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            this.f37333i = getDimensionPixelSize(context3, k.nad_spannable_exclude_padding_text_bottom_buffer);
        }
    }

    public final int getDimensionPixelSize(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i2)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getDimensionPixelSize(i2);
        }
        return invokeLI.intValue;
    }

    public final boolean hasEmoji(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charSequence)) == null) ? Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]").matcher(charSequence).find() : invokeL.booleanValue;
    }

    public final void setBottomPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.k = i2;
        }
    }

    public final void setTextWithUnifiedPadding(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, charSequence, bufferType) == null) || charSequence == null) {
            return;
        }
        a(charSequence);
        float lineSpacingExtra = getLineSpacingExtra();
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
            spannableStringBuilder.setSpan(new a(this, this.f37332h, this.f37333i, (int) lineSpacingExtra, this.f37334j, this.k), 0, charSequence.length(), 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new a(this, this.f37332h, this.f37333i, (int) lineSpacingExtra, this.f37334j, this.k), 0, charSequence.length(), 33);
        }
        setText(spannableStringBuilder, bufferType);
    }

    public final void setTopPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f37334j = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public UnifyTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.f37329e = "UnifyTextView";
        this.f37331g = getDimensionPixelSize(context, k.nad_spannable_exclude_padding_text_top_bottom_extra);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.NADUnifyTextView);
        this.f37334j = obtainStyledAttributes.getDimensionPixelSize(q.NADUnifyTextView_spannable_top_padding, this.f37331g);
        this.k = obtainStyledAttributes.getDimensionPixelSize(q.NADUnifyTextView_spannable_bottom_padding, this.f37331g);
        obtainStyledAttributes.recycle();
    }
}
