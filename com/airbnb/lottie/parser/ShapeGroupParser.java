package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShapeGroupParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1648994485, "Lcom/airbnb/lottie/parser/ShapeGroupParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1648994485, "Lcom/airbnb/lottie/parser/ShapeGroupParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "hd", AdvanceSetting.NETWORK_TYPE);
    }

    public ShapeGroupParser() {
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

    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = null;
            boolean z = false;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    z = jsonReader.nextBoolean();
                } else if (selectName != 2) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (parse != null) {
                            arrayList.add(parse);
                        }
                    }
                    jsonReader.endArray();
                }
            }
            return new ShapeGroup(str, arrayList, z);
        }
        return (ShapeGroup) invokeLL.objValue;
    }
}
