package c.a.r0.x0.p2.k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.view.expandable.SpannableClickTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f27746a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.x0.p2.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1302a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f27748f;

        public C1302a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27747e = str;
            this.f27748f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f27747e)) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13313");
            statisticItem.param("tid", this.f27748f);
            TiebaStatic.log(statisticItem);
            c.a.q0.m.a.u(TbadkCoreApplication.getInst().getApplicationContext(), false, this.f27747e);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, int i2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                canvas.save();
                canvas.translate(f2, (((i6 - i4) - drawable.getBounds().bottom) / 2) + i4);
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
                Rect bounds = getDrawable().getBounds();
                if (fontMetricsInt != null) {
                    Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                    int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                    int i5 = (bounds.bottom - bounds.top) / 2;
                    int i6 = i4 / 4;
                    int i7 = i5 - i6;
                    int i8 = -(i5 + i6);
                    fontMetricsInt.ascent = i8;
                    fontMetricsInt.top = i8;
                    fontMetricsInt.bottom = i7;
                    fontMetricsInt.descent = i7;
                }
                return bounds.right;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends ReplacementSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f27749e;

        /* renamed from: f  reason: collision with root package name */
        public int f27750f;

        public c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27749e = i2;
            this.f27750f = i3;
        }

        public final TextPaint a(Paint paint) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, paint)) == null) {
                TextPaint textPaint = new TextPaint(paint);
                textPaint.setTextSize(this.f27749e);
                textPaint.setColor(this.f27750f);
                return textPaint;
            }
            return (TextPaint) invokeL.objValue;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                CharSequence subSequence = charSequence.subSequence(i2, i3);
                TextPaint a2 = a(paint);
                Paint.FontMetricsInt fontMetricsInt = a2.getFontMetricsInt();
                canvas.drawText(subSequence.toString(), f2, i5 - (((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - ((i6 + i4) / 2)), a2);
            }
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) ? (int) a(paint).measureText(charSequence.subSequence(i2, i3).toString()) : invokeCommon.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1454683903, "Lc/a/r0/x0/p2/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1454683903, "Lc/a/r0/x0/p2/k/a;");
                return;
            }
        }
        f27746a = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds33);
    }

    public static void a(Context context, TextView textView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, context, textView, str, str2, str3) == null) || context == null || textView == null || StringUtils.isNull(str)) {
            return;
        }
        int color = SkinManager.getColor(R.color.CAM_X0107);
        String str4 = str + GlideException.IndentedAppendable.INDENT;
        TextPaint paint = textView.getPaint();
        int g2 = l.p(context)[0] - (l.g(context, R.dimen.tbds48) * 2);
        int g3 = l.g(context, R.dimen.tbds116);
        int t = l.t(paint, " 广告");
        int t2 = l.t(paint, "...  ");
        int t3 = l.t(paint, str4);
        int g4 = l.g(context, R.dimen.tbds30);
        int i2 = t3 + g3 + t + g4;
        int i3 = g2 * 2;
        if (i2 >= i3) {
            str4 = b(paint, str4, (((i3 - g3) - t) - t2) - g4) + "...  ";
        } else if (i2 >= g2 && t3 < g2 && i2 >= g2) {
            str4 = str4.trim() + org.apache.commons.lang3.StringUtils.LF;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
        SpannableString spannableString = new SpannableString("_");
        spannableString.setSpan(new b(context, R.drawable.icon_video_middle_ad_link), 0, 1, 17);
        spannableString.setSpan(new C1302a(str2, str3), 0, 1, 17);
        spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
        SpannableString spannableString2 = new SpannableString(" 广告");
        spannableString2.setSpan(new c(f27746a, color), 0, 3, 17);
        spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
        if (textView instanceof SpannableClickTextView) {
            ((SpannableClickTextView) textView).setCustomMovementMethod();
        } else {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        StatisticItem statisticItem = new StatisticItem("c13312");
        statisticItem.param("tid", str3);
        TiebaStatic.log(statisticItem);
    }

    public static String b(Paint paint, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, paint, str, i2)) == null) {
            String str2 = str;
            for (int length = str.length() - 1; l.t(paint, str2) > i2 && length > 0; length--) {
                str2 = str.substring(0, length);
            }
            return str2;
        }
        return (String) invokeLLI.objValue;
    }
}
