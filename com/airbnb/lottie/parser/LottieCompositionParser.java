package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
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
/* loaded from: classes4.dex */
public class LottieCompositionParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1327010022, "Lcom/airbnb/lottie/parser/LottieCompositionParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1327010022, "Lcom/airbnb/lottie/parser/LottieCompositionParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    }

    public LottieCompositionParser() {
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
                    default:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
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

    public static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, jsonReader, lottieComposition, list, longSparseArray) == null) {
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
}
