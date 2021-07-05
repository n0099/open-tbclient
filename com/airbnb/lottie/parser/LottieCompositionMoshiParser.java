package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class LottieCompositionMoshiParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options ASSETS_NAMES;
    public static final JsonReader.Options FONT_NAMES;
    public static final JsonReader.Options MARKER_NAMES;
    public static final JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-523323540, "Lcom/airbnb/lottie/parser/LottieCompositionMoshiParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-523323540, "Lcom/airbnb/lottie/parser/LottieCompositionMoshiParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
        ASSETS_NAMES = JsonReader.Options.of("id", "layers", "w", "h", "p", "u");
        FONT_NAMES = JsonReader.Options.of("list");
        MARKER_NAMES = JsonReader.Options.of("cm", "tm", "dr");
    }

    public LottieCompositionMoshiParser() {
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

    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        HashMap hashMap;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsonReader)) == null) {
            JsonReader jsonReader2 = jsonReader;
            float dpScale = Utils.dpScale();
            LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
            LottieComposition lottieComposition = new LottieComposition();
            jsonReader.beginObject();
            int i2 = 0;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            int i3 = 0;
            while (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(NAMES)) {
                    case 0:
                        i2 = jsonReader.nextInt();
                        continue;
                        jsonReader2 = jsonReader;
                    case 1:
                        i3 = jsonReader.nextInt();
                        continue;
                        jsonReader2 = jsonReader;
                    case 2:
                        f2 = (float) jsonReader.nextDouble();
                        continue;
                        jsonReader2 = jsonReader;
                    case 3:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        f3 = ((float) jsonReader.nextDouble()) - 0.01f;
                        break;
                    case 4:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        f4 = (float) jsonReader.nextDouble();
                        break;
                    case 5:
                        String[] split = jsonReader.nextString().split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                        if (!Utils.isAtLeastVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                            lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                        }
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case 6:
                        parseLayers(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case 7:
                        parseAssets(jsonReader2, lottieComposition, hashMap2, hashMap3);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case 8:
                        parseFonts(jsonReader2, hashMap4);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case 9:
                        parseChars(jsonReader2, lottieComposition, sparseArrayCompat);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case 10:
                        parseMarkers(jsonReader2, lottieComposition, arrayList3);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    default:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                }
                hashMap4 = hashMap;
                arrayList3 = arrayList;
                jsonReader2 = jsonReader;
            }
            lottieComposition.init(new Rect(0, 0, (int) (i2 * dpScale), (int) (i3 * dpScale)), f2, f3, f4, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
            return lottieComposition;
        }
        return (LottieComposition) invokeL.objValue;
    }

    public static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, jsonReader, lottieComposition, map, map2) == null) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                ArrayList arrayList = new ArrayList();
                LongSparseArray longSparseArray = new LongSparseArray();
                jsonReader.beginObject();
                String str = null;
                String str2 = null;
                String str3 = null;
                int i2 = 0;
                int i3 = 0;
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(ASSETS_NAMES);
                    if (selectName == 0) {
                        str = jsonReader.nextString();
                    } else if (selectName == 1) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer parse = LayerParser.parse(jsonReader, lottieComposition);
                            longSparseArray.put(parse.getId(), parse);
                            arrayList.add(parse);
                        }
                        jsonReader.endArray();
                    } else if (selectName == 2) {
                        i2 = jsonReader.nextInt();
                    } else if (selectName == 3) {
                        i3 = jsonReader.nextInt();
                    } else if (selectName == 4) {
                        str2 = jsonReader.nextString();
                    } else if (selectName != 5) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        str3 = jsonReader.nextString();
                    }
                }
                jsonReader.endObject();
                if (str2 != null) {
                    LottieImageAsset lottieImageAsset = new LottieImageAsset(i2, i3, str, str2, str3);
                    map2.put(lottieImageAsset.getId(), lottieImageAsset);
                } else {
                    map.put(str, arrayList);
                }
            }
            jsonReader.endArray();
        }
    }

    public static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, jsonReader, lottieComposition, sparseArrayCompat) == null) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                FontCharacter parse = FontCharacterParser.parse(jsonReader, lottieComposition);
                sparseArrayCompat.put(parse.hashCode(), parse);
            }
            jsonReader.endArray();
        }
    }

    public static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jsonReader, map) == null) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(FONT_NAMES) != 0) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Font parse = FontParser.parse(jsonReader);
                        map.put(parse.getName(), parse);
                    }
                    jsonReader.endArray();
                }
            }
            jsonReader.endObject();
        }
    }

    public static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, jsonReader, lottieComposition, list, longSparseArray) == null) {
            jsonReader.beginArray();
            int i2 = 0;
            while (jsonReader.hasNext()) {
                Layer parse = LayerParser.parse(jsonReader, lottieComposition);
                if (parse.getLayerType() == Layer.LayerType.IMAGE) {
                    i2++;
                }
                list.add(parse);
                longSparseArray.put(parse.getId(), parse);
                if (i2 > 4) {
                    Logger.warning("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                }
            }
            jsonReader.endArray();
        }
    }

    public static void parseMarkers(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, jsonReader, lottieComposition, list) == null) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                String str = null;
                jsonReader.beginObject();
                float f2 = 0.0f;
                float f3 = 0.0f;
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(MARKER_NAMES);
                    if (selectName == 0) {
                        str = jsonReader.nextString();
                    } else if (selectName == 1) {
                        f2 = (float) jsonReader.nextDouble();
                    } else if (selectName != 2) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        f3 = (float) jsonReader.nextDouble();
                    }
                }
                jsonReader.endObject();
                list.add(new Marker(str, f2, f3));
            }
            jsonReader.endArray();
        }
    }
}
