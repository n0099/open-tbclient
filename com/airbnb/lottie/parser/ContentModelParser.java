package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.fun.ad.sdk.FunAdSdk;
import com.kuaishou.weapon.p0.u;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.IOException;
/* loaded from: classes.dex */
public class ContentModelParser {
    public static JsonReader.Options NAMES = JsonReader.Options.of("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0098, code lost:
        if (r2.equals("gs") != false) goto L24;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ContentModel contentModel;
        String str;
        jsonReader.beginObject();
        char c = 2;
        int i = 2;
        while (true) {
            contentModel = null;
            if (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName != 0) {
                    if (selectName != 1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        i = jsonReader.nextInt();
                    }
                } else {
                    str = jsonReader.nextString();
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals(u.s)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case SpeedStatsStampTable.AD_CALL_SHOW_START_STAMP_KEY /* 3307 */:
                if (str.equals("gr")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case SpeedStatsStampTable.AD_CALL_SHOW_END_STAMP_KEY /* 3308 */:
                break;
            case 3488:
                if (str.equals(FunAdSdk.PLATFORM_MM)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals("sh")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals(BaseStatisContent.SR)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                contentModel = ShapeGroupParser.parse(jsonReader, lottieComposition);
                break;
            case 1:
                contentModel = ShapeStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 2:
                contentModel = GradientStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 3:
                contentModel = ShapeFillParser.parse(jsonReader, lottieComposition);
                break;
            case 4:
                contentModel = GradientFillParser.parse(jsonReader, lottieComposition);
                break;
            case 5:
                contentModel = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                break;
            case 6:
                contentModel = ShapePathParser.parse(jsonReader, lottieComposition);
                break;
            case 7:
                contentModel = CircleShapeParser.parse(jsonReader, lottieComposition, i);
                break;
            case '\b':
                contentModel = RectangleShapeParser.parse(jsonReader, lottieComposition);
                break;
            case '\t':
                contentModel = ShapeTrimPathParser.parse(jsonReader, lottieComposition);
                break;
            case '\n':
                contentModel = PolystarShapeParser.parse(jsonReader, lottieComposition);
                break;
            case 11:
                contentModel = MergePathsParser.parse(jsonReader);
                lottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case '\f':
                contentModel = RepeaterParser.parse(jsonReader, lottieComposition);
                break;
            default:
                Logger.warning("Unknown shape type " + str);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return contentModel;
    }
}
