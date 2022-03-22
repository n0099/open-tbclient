package com.baidu.tbadk.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class RichContentHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RICH_CONTENT_IMAGE_TYPE = 1;
    public static final int RICH_CONTENT_TEXT_TYPE = 0;
    public static final String RICH_CONTENT_TYPE_KEY = "rich_content_type";
    public static final String TEXT_RICH_CONTENT_KEY = "text_rich_content";
    public transient /* synthetic */ FieldHolder $fh;

    public RichContentHelper() {
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

    @NonNull
    public static List<Object> toData(@Nullable JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject.getInt(RICH_CONTENT_TYPE_KEY) == 0) {
                        arrayList.add(optJSONObject.getString(TEXT_RICH_CONTENT_KEY));
                    } else if (optJSONObject.getInt(RICH_CONTENT_TYPE_KEY) == 1) {
                        ImageFileInfo parseJson = new ImageFileInfo().parseJson(optJSONObject);
                        parseJson.setIsLong(FileHelper.checkIsLongImage(parseJson.getFilePath()));
                        arrayList.add(parseJson);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public static JSONArray toJson(@Nullable List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list == null) {
                return jSONArray;
            }
            try {
                for (Object obj : list) {
                    if (obj instanceof ImageFileInfo) {
                        JSONObject json = ((ImageFileInfo) obj).toJson();
                        if (json != null) {
                            json.put(RICH_CONTENT_TYPE_KEY, 1);
                            jSONArray.put(json);
                        }
                    } else if (obj instanceof String) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TEXT_RICH_CONTENT_KEY, obj);
                        jSONObject.put(RICH_CONTENT_TYPE_KEY, 0);
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
