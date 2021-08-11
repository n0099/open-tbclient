package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.b.j;
import java.io.IOException;
/* loaded from: classes4.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static /* synthetic */ Interceptable $ic;
    public static final DocumentDataParser INSTANCE;
    public static final JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-353442546, "Lcom/airbnb/lottie/parser/DocumentDataParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-353442546, "Lcom/airbnb/lottie/parser/DocumentDataParser;");
                return;
            }
        }
        INSTANCE = new DocumentDataParser();
        NAMES = JsonReader.Options.of("t", "f", "s", j.q, "tr", IAdRequestParam.QUERY_HEIGHT, "ls", "fc", "sc", "sw", "of");
    }

    public DocumentDataParser() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public DocumentData parse(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, jsonReader, f2)) == null) {
            DocumentData.Justification justification = DocumentData.Justification.CENTER;
            jsonReader.beginObject();
            DocumentData.Justification justification2 = justification;
            String str = null;
            String str2 = null;
            float f3 = 0.0f;
            int i2 = 0;
            float f4 = 0.0f;
            float f5 = 0.0f;
            int i3 = 0;
            int i4 = 0;
            float f6 = 0.0f;
            boolean z = true;
            while (jsonReader.hasNext()) {
                switch (jsonReader.selectName(NAMES)) {
                    case 0:
                        str = jsonReader.nextString();
                        break;
                    case 1:
                        str2 = jsonReader.nextString();
                        break;
                    case 2:
                        f3 = (float) jsonReader.nextDouble();
                        break;
                    case 3:
                        int nextInt = jsonReader.nextInt();
                        if (nextInt <= DocumentData.Justification.CENTER.ordinal() && nextInt >= 0) {
                            justification2 = DocumentData.Justification.values()[nextInt];
                            break;
                        } else {
                            justification2 = DocumentData.Justification.CENTER;
                            break;
                        }
                        break;
                    case 4:
                        i2 = jsonReader.nextInt();
                        break;
                    case 5:
                        f4 = (float) jsonReader.nextDouble();
                        break;
                    case 6:
                        f5 = (float) jsonReader.nextDouble();
                        break;
                    case 7:
                        i3 = JsonUtils.jsonToColor(jsonReader);
                        break;
                    case 8:
                        i4 = JsonUtils.jsonToColor(jsonReader);
                        break;
                    case 9:
                        f6 = (float) jsonReader.nextDouble();
                        break;
                    case 10:
                        z = jsonReader.nextBoolean();
                        break;
                    default:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            return new DocumentData(str, str2, f3, justification2, i2, f4, f5, i3, i4, f6, z);
        }
        return (DocumentData) invokeLF.objValue;
    }
}
