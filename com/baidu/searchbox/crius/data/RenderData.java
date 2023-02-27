package com.baidu.searchbox.crius.data;

import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.parser.GradientAttrs;
import com.baidu.searchbox.crius.parser.PraiseAttrs;
import com.baidu.searchbox.crius.parser.PrefixLabelAttrs;
import com.baidu.searchbox.crius.parser.ScaleFocusPoint;
import com.baidu.searchbox.crius.parser.SyncInfo;
import com.baidu.searchbox.crius.util.ColorUtils;
/* loaded from: classes2.dex */
public class RenderData {
    public BackgroundData backgroundData;
    public String backgroundImage;
    public String backgroundImageNight;
    public BackgroundImgData backgroundImgData;
    public BorderData borderData;
    public float borderRadius;
    public int borderRadiusColor;
    public float borderRadiusLeftBottom;
    public float borderRadiusLeftTop;
    public float borderRadiusRightBottom;
    public float borderRadiusRightTop;
    public float borderRadiusWidth;
    public int color;
    public int colorNight;
    public int downloadStyle;
    public ScaleFocusPoint focusPoint;
    public float fontSize;
    public float fontStrokeWidth;
    public Typeface fontStyle;
    public GradientAttrs gradientBgColor;
    public int gravity;
    public boolean hasPrefix;
    public int height;
    public boolean ignoreTextPadding;
    public double lineMulti;
    public double lineSpace;
    public int maxLines;
    public Opacities opacities;
    public String placeHolderImage;
    public String placeHolderImageNight;
    public String poster;
    public PraiseAttrs praiseAttrs;
    public float prefixLabelWidth;
    public int progressColor;
    public int progressNightColor;
    public String src;
    public int strokeColor;
    public int strokeNightColor;
    public float strokeWidth;
    public SyncInfo syncInfo;
    public String text;
    public TextColor textColorData;
    public String textDecoration;
    public String textDecorationColor;
    public int videoDuration;
    public int voteStyle;
    public int width;
    public int imageScaleType = 6;
    public int placeHolderScaleType = 6;
    public int imageTemplateFlag = 1;

    /* loaded from: classes2.dex */
    public static class BackgroundData {
        public String backgroundColor;
        public String backgroundColorActive;
        public String backgroundColorNight;
        public String backgroundColorNightActive;
        public String backgroundColorNightVisited;
        public String backgroundColorNightVisitedActive;
        public String backgroundColorVisited;
        public String backgroundColorVisitedActive;

        public static BackgroundData initFrom(@Nullable CriusData criusData) {
            if (criusData == null) {
                return null;
            }
            BackgroundData backgroundData = new BackgroundData();
            backgroundData.backgroundColor = criusData.backgroundColor;
            backgroundData.backgroundColorNight = criusData.backgroundColorNight;
            backgroundData.backgroundColorVisited = criusData.backgroundColorVisited;
            backgroundData.backgroundColorActive = criusData.backgroundColorActive;
            backgroundData.backgroundColorNightVisited = criusData.backgroundColorNightVisited;
            backgroundData.backgroundColorNightActive = criusData.backgroundColorNightActive;
            backgroundData.backgroundColorVisitedActive = criusData.backgroundColorVisitedActive;
            backgroundData.backgroundColorNightVisitedActive = criusData.backgroundColorNightVisitedActive;
            return backgroundData;
        }
    }

    /* loaded from: classes2.dex */
    public static class BackgroundImgData {
        public String backgroundImage;
        public String backgroundImageActive;
        public String backgroundImageNight;
        public String backgroundImageNightActive;
        public String backgroundImageNightVisited;
        public String backgroundImageNightVisitedActive;
        public String backgroundImageVisited;
        public String backgroundImageVisitedActive;

        public static BackgroundImgData initFrom(@Nullable CriusData criusData) {
            if (criusData == null) {
                return null;
            }
            BackgroundImgData backgroundImgData = new BackgroundImgData();
            backgroundImgData.backgroundImage = criusData.backgroundImage;
            backgroundImgData.backgroundImageActive = criusData.backgroundImageActive;
            backgroundImgData.backgroundImageVisited = criusData.backgroundImageVisited;
            backgroundImgData.backgroundImageVisitedActive = criusData.backgroundImageVisitedActive;
            backgroundImgData.backgroundImageNight = criusData.backgroundImageNight;
            backgroundImgData.backgroundImageNightActive = criusData.backgroundImageNightActive;
            backgroundImgData.backgroundImageNightVisited = criusData.backgroundImageNightVisited;
            backgroundImgData.backgroundImageNightVisitedActive = criusData.backgroundImageNightVisitedActive;
            return backgroundImgData;
        }
    }

    /* loaded from: classes2.dex */
    public static class BorderData {
        public String borderColor;
        public String borderColorActive;
        public String borderColorNight;
        public String borderColorNightActive;
        public String borderColorNightVisited;
        public String borderColorNightVisitedActive;
        public String borderColorVisited;
        public String borderColorVisitedActive;
        public float[] borderRadii;
        public float borderRadius;
        public float borderWidth;

        public static BorderData initFrom(@Nullable CriusData criusData) {
            if (criusData == null) {
                return null;
            }
            BorderData borderData = new BorderData();
            borderData.borderWidth = criusData.convertedBorderWidth();
            borderData.borderRadius = criusData.convertedBorderRadius();
            borderData.borderRadii = criusData.getBorderRadii();
            borderData.borderColor = criusData.borderColor;
            borderData.borderColorNight = criusData.borderColorNight;
            borderData.borderColorVisited = criusData.borderColorVisited;
            borderData.borderColorActive = criusData.borderColorActive;
            borderData.borderColorNightVisited = criusData.borderColorNightVisited;
            borderData.borderColorNightActive = criusData.borderColorNightActive;
            borderData.borderColorVisitedActive = criusData.borderColorVisitedActive;
            borderData.borderColorNightVisitedActive = criusData.borderColorNightVisitedActive;
            return borderData;
        }
    }

    /* loaded from: classes2.dex */
    public static class Opacities {
        public double opacity = -10000.0d;
        public double opacityActive = -10000.0d;
        public double opacityVisited = -10000.0d;
        public double opacityVisitedActive = -10000.0d;
        public double opacityNight = -10000.0d;
        public double opacityNightActive = -10000.0d;
        public double opacityNightVisited = -10000.0d;
        public double opacityNightVisitedActive = -10000.0d;

        public static Opacities initFrom(@Nullable CriusData criusData) {
            if (criusData == null) {
                return null;
            }
            Opacities opacities = new Opacities();
            opacities.opacity = criusData.opacity;
            opacities.opacityActive = criusData.opacityActive;
            opacities.opacityVisited = criusData.opacityVisited;
            opacities.opacityVisitedActive = criusData.opacityVisitedActive;
            opacities.opacityNight = criusData.opacityNight;
            opacities.opacityNightActive = criusData.opacityNightActive;
            opacities.opacityNightVisited = criusData.opacityNightVisited;
            opacities.opacityNightVisitedActive = criusData.opacityNightVisitedActive;
            return opacities;
        }
    }

    /* loaded from: classes2.dex */
    public static class TextColor {
        public String color;
        public String colorActive;
        public String colorNight;
        public String colorNightActive;
        public String colorNightVisited;
        public String colorNightVisitedActive;
        public String colorVisited;
        public String colorVisitedActive;

        public static TextColor initFrom(@Nullable CriusData criusData) {
            if (criusData == null) {
                return null;
            }
            TextColor textColor = new TextColor();
            textColor.color = criusData.color;
            textColor.colorActive = criusData.colorActive;
            textColor.colorVisited = criusData.colorVisited;
            textColor.colorVisitedActive = criusData.colorVisitedActive;
            textColor.colorNight = criusData.colorNight;
            textColor.colorNightActive = criusData.colorNightActive;
            textColor.colorNightVisited = criusData.colorNightVisited;
            textColor.colorNightVisitedActive = criusData.colorNightVisitedActive;
            return textColor;
        }
    }

    public static RenderData initFrom(@Nullable CriusData criusData, boolean z, boolean z2) {
        CriusData criusData2;
        CriusData dataById;
        if (criusData == null) {
            return null;
        }
        RenderData renderData = new RenderData();
        renderData.text = criusData.text;
        renderData.fontStyle = criusData.fontStyle;
        double d = criusData.fontStrokeWidth;
        if (d > 0.0d) {
            renderData.fontStrokeWidth = (float) d;
        }
        renderData.gravity = criusData.gravity;
        renderData.maxLines = criusData.maxLines;
        renderData.lineSpace = criusData.lineSpace;
        renderData.lineMulti = criusData.lineMulti;
        renderData.textDecoration = criusData.textDecoration;
        renderData.textDecorationColor = criusData.textDecorationColor;
        renderData.src = criusData.imageSrc(z, z2);
        renderData.poster = criusData.poster;
        renderData.borderRadiusColor = ColorUtils.parseColor(criusData.borderColor);
        renderData.borderRadius = criusData.convertedBorderRadius();
        renderData.borderRadiusWidth = criusData.convertedBorderWidth();
        renderData.borderRadiusLeftTop = criusData.convertedBorderRadiusLT();
        renderData.borderRadiusLeftBottom = criusData.convertedBorderRadiusLB();
        renderData.borderRadiusRightTop = criusData.convertedBorderRadiusRT();
        renderData.borderRadiusRightBottom = criusData.convertedBorderRadiusRB();
        renderData.videoDuration = criusData.videoDuration;
        renderData.width = (int) criusData.criusNode.getLayoutWidth();
        renderData.height = (int) criusData.criusNode.getLayoutHeight();
        if (!TextUtils.isEmpty(criusData.color)) {
            renderData.color = ColorUtils.parseColor(criusData.color);
        }
        if (!TextUtils.isEmpty(criusData.colorNight)) {
            renderData.colorNight = ColorUtils.parseColor(criusData.colorNight);
        }
        renderData.fontSize = (float) criusData.fontSize();
        renderData.downloadStyle = criusData.downloadStyle;
        renderData.progressColor = ColorUtils.parseColor(criusData.progressColor);
        renderData.strokeColor = ColorUtils.parseColor(criusData.strokeColor);
        renderData.progressNightColor = ColorUtils.parseColor(criusData.progressNightColor);
        renderData.strokeNightColor = ColorUtils.parseColor(criusData.strokeNightColor);
        renderData.strokeWidth = criusData.convertedStrokeWidth();
        renderData.textColorData = TextColor.initFrom(criusData);
        renderData.backgroundData = BackgroundData.initFrom(criusData);
        renderData.backgroundImgData = BackgroundImgData.initFrom(criusData);
        renderData.borderData = BorderData.initFrom(criusData);
        renderData.syncInfo = criusData.syncInfo;
        renderData.voteStyle = criusData.voteStyle;
        renderData.opacities = Opacities.initFrom(criusData);
        PrefixLabelAttrs prefixLabelAttrs = criusData.preLabelAttrs;
        if (prefixLabelAttrs != null) {
            boolean z3 = prefixLabelAttrs.hasPrefix;
            renderData.hasPrefix = z3;
            if (z3 && !TextUtils.isEmpty(prefixLabelAttrs.bindingId) && (criusData2 = criusData.parent) != null && (dataById = criusData2.getDataById(criusData.preLabelAttrs.bindingId)) != null && dataById.criusNode != null) {
                renderData.prefixLabelWidth = criusData.getLabelTextWidth(criusData);
            }
        }
        renderData.gradientBgColor = criusData.gradientAttrs;
        renderData.ignoreTextPadding = criusData.ignoreTextPadding;
        renderData.praiseAttrs = criusData.praiseAttrs;
        return renderData;
    }
}
