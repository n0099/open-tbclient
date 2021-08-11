package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ContentModelParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-438128669, "Lcom/airbnb/lottie/parser/ContentModelParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-438128669, "Lcom/airbnb/lottie/parser/ContentModelParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("ty", "d");
    }

    public ContentModelParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r2.equals("gs") != false) goto L26;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        ContentModel contentModel;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            jsonReader.beginObject();
            char c2 = 2;
            int i2 = 2;
            while (true) {
                contentModel = null;
                if (!jsonReader.hasNext()) {
                    str = null;
                    break;
                }
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                    break;
                } else if (selectName != 1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    i2 = jsonReader.nextInt();
                }
            }
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case 3239:
                    if (str.equals("el")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3270:
                    if (str.equals("fl")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3295:
                    if (str.equals("gf")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3307:
                    if (str.equals("gr")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3308:
                    break;
                case 3488:
                    if (str.equals("mm")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3633:
                    if (str.equals("rc")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3646:
                    if (str.equals("rp")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3669:
                    if (str.equals(IAdRequestParam.SCREEN_HEIGHT)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3679:
                    if (str.equals(BaseStatisContent.SR)) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3681:
                    if (str.equals("st")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3705:
                    if (str.equals("tm")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3710:
                    if (str.equals("tr")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
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
                    contentModel = CircleShapeParser.parse(jsonReader, lottieComposition, i2);
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
        return (ContentModel) invokeLL.objValue;
    }
}
