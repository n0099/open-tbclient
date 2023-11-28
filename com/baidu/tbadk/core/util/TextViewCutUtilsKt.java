package com.baidu.tbadk.core.util;

import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a5\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011\u001a0\u0010\u0012\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"shouldEllipsize", "", "maxWidth", "", "paint", "Landroid/graphics/Paint;", "source", "", "maxLen", "", "cutAndSetTextByMaxLine", "Landroid/widget/TextView;", "textSpan", "Landroid/text/SpannableStringBuilder;", "maxLine", "content", "startRemoveOffset", "(Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;ILandroid/text/SpannableStringBuilder;I)Ljava/lang/Boolean;", "realCutAndSetTextByMaxLine", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TextViewCutUtilsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Boolean cutAndSetTextByMaxLine(final TextView textView, final SpannableStringBuilder textSpan, final int i, final SpannableStringBuilder content, final int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{textView, textSpan, Integer.valueOf(i), content, Integer.valueOf(i2)})) == null) {
            Intrinsics.checkNotNullParameter(textView, "<this>");
            Intrinsics.checkNotNullParameter(textSpan, "textSpan");
            Intrinsics.checkNotNullParameter(content, "content");
            if ((textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight() <= 0) {
                textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener(textView, textSpan, i, content, i2) { // from class: com.baidu.tbadk.core.util.TextViewCutUtilsKt$cutAndSetTextByMaxLine$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ SpannableStringBuilder $content;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int $maxLine;
                    public final /* synthetic */ int $startRemoveOffset;
                    public final /* synthetic */ SpannableStringBuilder $textSpan;
                    public final /* synthetic */ TextView $this_cutAndSetTextByMaxLine;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {textView, textSpan, Integer.valueOf(i), content, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$this_cutAndSetTextByMaxLine = textView;
                        this.$textSpan = textSpan;
                        this.$maxLine = i;
                        this.$content = content;
                        this.$startRemoveOffset = i2;
                    }

                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                            this.$this_cutAndSetTextByMaxLine.removeOnLayoutChangeListener(this);
                            TextViewCutUtilsKt.realCutAndSetTextByMaxLine(this.$this_cutAndSetTextByMaxLine, this.$textSpan, this.$maxLine, this.$content, this.$startRemoveOffset);
                        }
                    }
                });
                return null;
            }
            return Boolean.valueOf(realCutAndSetTextByMaxLine(textView, textSpan, i, content, i2));
        }
        return (Boolean) invokeCommon.objValue;
    }

    public static /* synthetic */ Boolean cutAndSetTextByMaxLine$default(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, SpannableStringBuilder spannableStringBuilder2, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            spannableStringBuilder2 = new SpannableStringBuilder("...");
        }
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        return cutAndSetTextByMaxLine(textView, spannableStringBuilder, i, spannableStringBuilder2, i2);
    }

    public static /* synthetic */ boolean realCutAndSetTextByMaxLine$default(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, SpannableStringBuilder spannableStringBuilder2, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            spannableStringBuilder2 = new SpannableStringBuilder("...");
        }
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        return realCutAndSetTextByMaxLine(textView, spannableStringBuilder, i, spannableStringBuilder2, i2);
    }

    public static final boolean realCutAndSetTextByMaxLine(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, SpannableStringBuilder spannableStringBuilder2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{textView, spannableStringBuilder, Integer.valueOf(i), spannableStringBuilder2, Integer.valueOf(i2)})) == null) {
            int measuredWidth = (textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            float f = measuredWidth;
            TextPaint paint = textView.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            String spannableStringBuilder3 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder3, "textSpan.toString()");
            int i3 = 0;
            if (!shouldEllipsize(f, paint, spannableStringBuilder3, i)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, textView.getPaint(), measuredWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() >= i) {
                int i4 = i - 1;
                spannableStringBuilder.delete(staticLayout.getLineEnd(i4), spannableStringBuilder.length());
                f -= staticLayout.getLineWidth(i4);
            }
            if (spannableStringBuilder.length() >= i2) {
                i3 = spannableStringBuilder.length() - i2;
            }
            CharSequence subSequence = spannableStringBuilder.subSequence(i3, spannableStringBuilder.length());
            Intrinsics.checkNotNullExpressionValue(subSequence, "textSpan.subSequence(\n  …textSpan.length\n        )");
            float measureText = textView.getPaint().measureText(spannableStringBuilder2.toString());
            while (measureText > textView.getPaint().measureText(subSequence.toString()) + f) {
                i2++;
                if (spannableStringBuilder.length() - i2 < 0) {
                    break;
                }
                subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i2, spannableStringBuilder.length());
                Intrinsics.checkNotNullExpressionValue(subSequence, "textSpan.subSequence(tex…eOffset, textSpan.length)");
            }
            if (spannableStringBuilder.length() - i2 > 0) {
                spannableStringBuilder.replace(spannableStringBuilder.length() - i2, spannableStringBuilder.length(), "");
                while (spannableStringBuilder.length() > 0 && Character.isHighSurrogate(spannableStringBuilder.charAt(spannableStringBuilder.length() - 1))) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), "");
                }
            }
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean shouldEllipsize(float f, Paint paint, String source, int i) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        float measureText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), paint, source, Integer.valueOf(i)})) == null) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(source, "source");
            float f2 = 0.0f;
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z && i != 0) {
                if (source.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!StringsKt__StringsKt.contains$default((CharSequence) source, (CharSequence) "\n", false, 2, (Object) null)) {
                        if (paint.measureText(source) >= f * i) {
                            return true;
                        }
                        return false;
                    }
                    List split$default = StringsKt__StringsKt.split$default((CharSequence) source, new String[]{"\n"}, false, 0, 6, (Object) null);
                    if (split$default.size() > i) {
                        return true;
                    }
                    int i2 = 0;
                    for (int i3 = 0; i3 < i && split$default.size() > i3; i3++) {
                        if (i3 < i - 1) {
                            measureText = paint.measureText((String) split$default.get(i3));
                            int ceil = (int) Math.ceil(measureText / f);
                            i2 += ceil;
                            if (i2 < i) {
                                measureText = ceil * f;
                            }
                        } else {
                            measureText = paint.measureText((String) split$default.get(i3));
                            i2++;
                        }
                        f2 += measureText;
                        if (i2 >= i) {
                            if (f2 >= f * i) {
                                return true;
                            }
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
