package com.baidu.searchbox.crius.render.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.searchbox.crius.factory.NativeRenderFactory;
import com.baidu.searchbox.crius.parser.GradientAttrs;
import com.baidu.searchbox.crius.render.CriusGradientDrawable;
import com.baidu.searchbox.crius.render.OpacityController;
import com.baidu.searchbox.crius.ui.IOpacitySupport;
import com.baidu.searchbox.crius.util.ColorUtils;
import com.baidu.searchbox.crius.util.CriusUtil;
import com.baidu.searchbox.ui.UnifyTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import view.CriusTextView;
/* loaded from: classes2.dex */
public class RenderUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GRADIENT_COLORS_MIN_LENGTH = 2;
    public static final String PREFIX_HOLDER = "PREFIX";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class PrefixLabelSpan extends ReplacementSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mLabelWidth;

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            }
        }

        public PrefixLabelSpan(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLabelWidth = f;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
                return (int) this.mLabelWidth;
            }
            return invokeCommon.intValue;
        }
    }

    public RenderUtils() {
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

    public static float convertFloatValue(double d, @NonNull Context context) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d), context})) == null) {
            return CriusUtil.convertFloatValue(d, DeviceUtils.ScreenInfo.getDensity(context));
        }
        return invokeCommon.floatValue;
    }

    public static void renderTextView(@Nullable View view2, @Nullable RenderData renderData, boolean z, boolean z2) {
        float f;
        float f2;
        String str;
        String str2;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{view2, renderData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if ((view2 instanceof TextView) && renderData != null && !TextUtils.isEmpty(renderData.text)) {
                int i = renderData.maxLines;
                if (i > 0) {
                    if (i == 1) {
                        ((TextView) view2).setSingleLine(true);
                    } else {
                        ((TextView) view2).setSingleLine(false);
                    }
                    TextView textView = (TextView) view2;
                    textView.setMaxLines(renderData.maxLines);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                RenderData.TextColor textColor = renderData.textColorData;
                if (textColor != null) {
                    if (z && !TextUtils.isEmpty(textColor.colorNight)) {
                        if (z2 && !TextUtils.isEmpty(textColor.colorNightVisited)) {
                            str = textColor.colorNightVisited;
                            str2 = textColor.colorNightVisitedActive;
                        } else {
                            str = textColor.colorNight;
                            str2 = textColor.colorNightActive;
                        }
                    } else if (z2 && !TextUtils.isEmpty(textColor.colorVisited)) {
                        str = textColor.colorVisited;
                        str2 = textColor.colorVisitedActive;
                    } else {
                        str = textColor.color;
                        str2 = textColor.colorActive;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                ((TextView) view2).setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{ColorUtils.parseColor(str2), ColorUtils.parseColor(str)}));
                            } finally {
                                boolean z3 = CriusRuntime.DEBUG;
                                if (z3) {
                                }
                            }
                        } else {
                            try {
                                ((TextView) view2).setTextColor(ColorUtils.parseColor(str));
                            } finally {
                                boolean z4 = CriusRuntime.DEBUG;
                                if (z4) {
                                }
                            }
                        }
                    }
                }
                if (Double.compare(renderData.fontSize, 0.0d) >= 0) {
                    ((TextView) view2).setTextSize(0, renderData.fontSize * view2.getResources().getDisplayMetrics().density);
                }
                TextView textView2 = (TextView) view2;
                textView2.setTypeface(renderData.fontStyle);
                if (textView2.getPaint() != null && renderData.fontStrokeWidth > 0.0f) {
                    textView2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                    textView2.getPaint().setStrokeWidth(renderData.fontStrokeWidth);
                }
                textView2.setGravity(renderData.gravity);
                SpannableString spannableString = new SpannableString(renderData.text);
                if (renderData.hasPrefix && renderData.prefixLabelWidth > 0.0f) {
                    spannableString = new SpannableString(PREFIX_HOLDER + renderData.text);
                    spannableString.setSpan(new PrefixLabelSpan(renderData.prefixLabelWidth), 0, 6, 17);
                }
                if (view2 instanceof UnifyTextView) {
                    ((UnifyTextView) view2).setTextWithUnifiedPadding(spannableString, TextView.BufferType.NORMAL);
                } else {
                    textView2.setText(spannableString);
                }
                double d = renderData.lineSpace;
                if (d > 0.0d) {
                    f = convertFloatValue(d, view2.getContext());
                } else {
                    f = 0.0f;
                }
                double d2 = renderData.lineMulti;
                if (d2 > 0.0d) {
                    f2 = (float) d2;
                } else {
                    f2 = 1.0f;
                }
                if (f > 0.0f || f2 > 0.0f) {
                    textView2.setLineSpacing(f, f2);
                }
            }
            if ((view2 instanceof CriusTextView) && renderData != null) {
                if (!TextUtils.isEmpty(renderData.text)) {
                    CriusTextView criusTextView = (CriusTextView) view2;
                    criusTextView.setTextDecoration(renderData.textDecoration);
                    criusTextView.setTextDecorationColor(ColorUtils.parseColor(renderData.textDecorationColor));
                }
                if (renderData.ignoreTextPadding) {
                    ((CriusTextView) view2).setTopPadding(0);
                }
            }
        }
    }

    @Deprecated
    public static void setAlpha(@Nullable View view2, double d, double d2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{view2, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z)}) != null) || view2 == null) {
            return;
        }
        if (z && d2 >= -1.0d) {
            view2.setAlpha((float) d2);
        } else if (d > -1.0d) {
            view2.setAlpha((float) d);
        } else {
            view2.setAlpha(1.0f);
        }
    }

    public static void setBackground(@Nullable View view2, @Nullable String str, @Nullable RenderData renderData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, str, renderData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            GradientAttrs gradientAttrs = renderData.gradientBgColor;
            if (gradientAttrs != null && gradientAttrs.getDayColors() != null && renderData.gradientBgColor.getDayColors().length >= 2) {
                setBgGradientColor(view2, renderData.gradientBgColor, renderData.borderData, z);
                return;
            }
            setBackgroundImage(view2, str, renderData.backgroundImgData, z, z2);
            setBackgroundColor(view2, renderData.backgroundData, z);
            setBorder(view2, renderData.backgroundData, renderData.borderData, z, z2);
        }
    }

    public static void setBackgroundColor(@Nullable View view2, @Nullable RenderData.BackgroundData backgroundData, boolean z) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65541, null, view2, backgroundData, z) == null) && view2 != null && backgroundData != null) {
            if (z && !TextUtils.isEmpty(backgroundData.backgroundColorNight)) {
                if (!TextUtils.isEmpty(backgroundData.backgroundColorNightActive)) {
                    try {
                        StateListDrawable stateListDrawable = new StateListDrawable();
                        ColorDrawable colorDrawable = new ColorDrawable(ColorUtils.parseColor(backgroundData.backgroundColorNightActive));
                        ColorDrawable colorDrawable2 = new ColorDrawable(ColorUtils.parseColor(backgroundData.backgroundColorNight));
                        stateListDrawable.addState(new int[]{16842919}, colorDrawable);
                        stateListDrawable.addState(new int[]{-16842919}, colorDrawable2);
                        view2.setBackground(stateListDrawable);
                    } finally {
                        boolean z2 = CriusRuntime.DEBUG;
                        if (!z2) {
                        }
                    }
                } else {
                    try {
                        view2.setBackgroundColor(ColorUtils.parseColor(backgroundData.backgroundColorNight));
                    } finally {
                        boolean z3 = CriusRuntime.DEBUG;
                        if (!z3) {
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(backgroundData.backgroundColor)) {
                if (!TextUtils.isEmpty(backgroundData.backgroundColorActive)) {
                    try {
                        StateListDrawable stateListDrawable2 = new StateListDrawable();
                        ColorDrawable colorDrawable3 = new ColorDrawable(ColorUtils.parseColor(backgroundData.backgroundColorActive));
                        ColorDrawable colorDrawable4 = new ColorDrawable(ColorUtils.parseColor(backgroundData.backgroundColor));
                        stateListDrawable2.addState(new int[]{16842919}, colorDrawable3);
                        stateListDrawable2.addState(new int[]{-16842919}, colorDrawable4);
                        view2.setBackground(stateListDrawable2);
                    } finally {
                        boolean z4 = CriusRuntime.DEBUG;
                        if (!z4) {
                        }
                    }
                } else {
                    try {
                        view2.setBackgroundColor(ColorUtils.parseColor(backgroundData.backgroundColor));
                    } finally {
                        boolean z5 = CriusRuntime.DEBUG;
                        if (!z5) {
                        }
                    }
                }
            }
        }
    }

    public static void setBackgroundImage(@Nullable View view2, @Nullable String str, @Nullable RenderData.BackgroundImgData backgroundImgData, boolean z, boolean z2) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{view2, str, backgroundImgData, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || view2 == null) {
            return;
        }
        if (z) {
            if (z2 && !TextUtils.isEmpty(backgroundImgData.backgroundImageNightVisited)) {
                str2 = backgroundImgData.backgroundImageNightVisited;
                str3 = backgroundImgData.backgroundImageNightVisitedActive;
            } else if (!TextUtils.isEmpty(backgroundImgData.backgroundImageNight)) {
                str2 = backgroundImgData.backgroundImageNight;
                str3 = backgroundImgData.backgroundImageNightActive;
            } else {
                str2 = backgroundImgData.backgroundImage;
                str3 = backgroundImgData.backgroundImageActive;
            }
        } else if (z2 && !TextUtils.isEmpty(backgroundImgData.backgroundImageVisited)) {
            str2 = backgroundImgData.backgroundImageVisited;
            str3 = backgroundImgData.backgroundImageVisitedActive;
        } else {
            str2 = backgroundImgData.backgroundImage;
            str3 = backgroundImgData.backgroundImageActive;
        }
        if (!TextUtils.isEmpty(str2)) {
            NativeRenderFactory.getInstance().renderBackground(str, view2, str2, str3);
        }
    }

    public static void setBgGradientColor(@NonNull View view2, @NonNull GradientAttrs gradientAttrs, @Nullable RenderData.BorderData borderData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{view2, gradientAttrs, borderData, Boolean.valueOf(z)}) == null) {
            CriusGradientDrawable criusGradientDrawable = new CriusGradientDrawable();
            if (z && gradientAttrs.getNightColors() != null && gradientAttrs.getNightColors().length > 2) {
                criusGradientDrawable.setColors(gradientAttrs.getNightColors(), gradientAttrs.getLocations());
            } else {
                criusGradientDrawable.setColors(gradientAttrs.getDayColors(), gradientAttrs.getLocations());
            }
            criusGradientDrawable.setStart(gradientAttrs.getStartX(), gradientAttrs.getStartY());
            criusGradientDrawable.setEnd(gradientAttrs.getEndX(), gradientAttrs.getEndY());
            if (borderData != null) {
                float f = borderData.borderRadius;
                if (f > 0.0f) {
                    criusGradientDrawable.setRadii(f, f, f, f);
                } else {
                    float[] fArr = borderData.borderRadii;
                    if (fArr != null && fArr.length > 0) {
                        criusGradientDrawable.setRadii(fArr);
                    }
                }
            }
            view2.setBackground(criusGradientDrawable);
        }
    }

    public static void setBorder(@Nullable View view2, @Nullable RenderData.BackgroundData backgroundData, @Nullable RenderData.BorderData borderData, boolean z, boolean z2) {
        String str;
        String str2;
        String str3;
        String str4;
        IllegalArgumentException illegalArgumentException;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{view2, backgroundData, borderData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && view2 != null && borderData != null && backgroundData != null) {
            if (z) {
                if (z2 && !TextUtils.isEmpty(borderData.borderColorNightVisited)) {
                    str = borderData.borderColorNightVisited;
                    str2 = borderData.borderColorNightVisitedActive;
                } else if (!TextUtils.isEmpty(borderData.borderColorNight)) {
                    str = borderData.borderColorNight;
                    str2 = borderData.borderColorNightActive;
                } else {
                    str = borderData.borderColor;
                    str2 = borderData.borderColorActive;
                }
            } else if (z2 && !TextUtils.isEmpty(borderData.borderColorVisited)) {
                str = borderData.borderColorVisited;
                str2 = borderData.borderColorVisitedActive;
            } else {
                str = borderData.borderColor;
                str2 = borderData.borderColorActive;
            }
            if (z) {
                if (z2 && !TextUtils.isEmpty(backgroundData.backgroundColorNightVisited)) {
                    str3 = backgroundData.backgroundColorNightVisited;
                    str4 = backgroundData.backgroundColorNightVisitedActive;
                } else if (!TextUtils.isEmpty(backgroundData.backgroundColorNight)) {
                    str3 = backgroundData.backgroundColorNight;
                    str4 = backgroundData.backgroundColorNightActive;
                } else {
                    str3 = backgroundData.backgroundColor;
                    str4 = backgroundData.backgroundColorActive;
                }
            } else if (z2 && !TextUtils.isEmpty(backgroundData.backgroundColorVisited)) {
                str3 = backgroundData.backgroundColorVisited;
                str4 = backgroundData.backgroundColorVisitedActive;
            } else {
                str3 = backgroundData.backgroundColor;
                str4 = backgroundData.backgroundColorActive;
            }
            try {
                float f = borderData.borderWidth;
                float f2 = borderData.borderRadius;
                float[] fArr = borderData.borderRadii;
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str4)) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    if (!TextUtils.isEmpty(str3)) {
                        gradientDrawable.setColor(ColorUtils.parseColor(str3));
                    }
                    if (borderData.borderWidth > 0.0f && !TextUtils.isEmpty(str)) {
                        gradientDrawable.setStroke((int) f, ColorUtils.parseColor(str));
                    }
                    if (f2 > 0.0f) {
                        gradientDrawable.setCornerRadius(f2);
                    } else if (fArr != null) {
                        gradientDrawable.setCornerRadii(fArr);
                    } else {
                        gradientDrawable.setCornerRadius(0.0f);
                    }
                    view2.setBackground(gradientDrawable);
                    return;
                }
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                if (!TextUtils.isEmpty(str3)) {
                    gradientDrawable2.setColor(ColorUtils.parseColor(str3));
                }
                if (borderData.borderWidth > 0.0f && !TextUtils.isEmpty(str)) {
                    gradientDrawable2.setStroke((int) f, ColorUtils.parseColor(str));
                }
                int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i > 0) {
                    gradientDrawable2.setCornerRadius(f2);
                } else if (fArr != null) {
                    gradientDrawable2.setCornerRadii(fArr);
                } else {
                    gradientDrawable2.setCornerRadius(0.0f);
                }
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                if (!TextUtils.isEmpty(str4)) {
                    gradientDrawable3.setColor(ColorUtils.parseColor(str4));
                } else if (!TextUtils.isEmpty(str3)) {
                    gradientDrawable3.setColor(ColorUtils.parseColor(str3));
                }
                if (borderData.borderWidth > 0.0f && !TextUtils.isEmpty(str2)) {
                    gradientDrawable3.setStroke((int) f, ColorUtils.parseColor(str2));
                } else if (borderData.borderWidth > 0.0f && !TextUtils.isEmpty(str)) {
                    gradientDrawable3.setStroke((int) f, ColorUtils.parseColor(str));
                }
                if (i > 0) {
                    gradientDrawable3.setCornerRadius(f2);
                } else if (fArr != null) {
                    gradientDrawable3.setCornerRadii(fArr);
                } else {
                    gradientDrawable3.setCornerRadius(0.0f);
                }
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, gradientDrawable3);
                stateListDrawable.addState(new int[]{-16842919}, gradientDrawable2);
                view2.setBackground(stateListDrawable);
            } finally {
                boolean z3 = CriusRuntime.DEBUG;
                if (!z3) {
                }
            }
        }
    }

    public static void setInitAlphaAndController(@Nullable View view2, RenderData.Opacities opacities, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{view2, opacities, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || view2 == null) {
            return;
        }
        OpacityController opacityController = new OpacityController(z, z2, opacities);
        opacityController.updateOpacity(view2, false);
        if (view2 instanceof IOpacitySupport) {
            ((IOpacitySupport) view2).setOpacityController(opacityController);
        }
    }
}
