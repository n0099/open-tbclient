package com.baidu.spswitch.emotion.bean;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.pic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"AUTH_DU_SPOKESMAN", "", "AUTH_FREEDOM", "AUTH_SPOKESMAN", "parseEmotionItemList", "", "", "Lcom/baidu/spswitch/emotion/bean/EmotionItemModel;", "idList", "str", "parseEmotionItemModel", "json", "Lorg/json/JSONObject;", "parseEmotionTabModel", "Lcom/baidu/spswitch/emotion/bean/EmotionTypeModel;", "lib_spswitch_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BDEmotionDynamicModelKt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTH_DU_SPOKESMAN = "2";
    public static final String AUTH_FREEDOM = "1";
    public static final String AUTH_SPOKESMAN = "3";
    public transient /* synthetic */ FieldHolder $fh;

    public static final Map<String, List<EmotionItemModel>> parseEmotionItemList(List<String> list, String str) {
        InterceptResult invokeLL;
        boolean z;
        Iterator<String> keys;
        boolean z2;
        JSONArray itemArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, list, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optString("errno");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || (keys = optJSONObject.keys()) == null) {
                    return null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (keys.hasNext()) {
                    String id = keys.next();
                    if (list != null && list.contains(id)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && (itemArray = optJSONObject.optJSONArray(id)) != null) {
                        Intrinsics.checkNotNullExpressionValue(itemArray, "itemArray");
                        ArrayList arrayList = new ArrayList();
                        int length = itemArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject2 = itemArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject2, "array.optJSONObject(index) ?: continue");
                                EmotionItemModel parseEmotionItemModel = parseEmotionItemModel(optJSONObject2);
                                if (parseEmotionItemModel != null && parseEmotionItemModel.isValid()) {
                                    arrayList.add(parseEmotionItemModel);
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            Intrinsics.checkNotNullExpressionValue(id, "id");
                            linkedHashMap.put(id, arrayList);
                        }
                    }
                }
                return linkedHashMap;
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    Log.d("EmotionItemModel", "parse: " + e + WebvttCueParser.CHAR_SPACE);
                }
                return null;
            }
        }
        return (Map) invokeLL.objValue;
    }

    public static final EmotionItemModel parseEmotionItemModel(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new EmotionItemModel(jSONObject.optString("id"), jSONObject.optString("key"), jSONObject.optString("url"), jSONObject.optString("d_url"), jSONObject.optString("text"));
            } catch (JSONException e) {
                if (!AppConfig.isDebug()) {
                    return null;
                }
                Log.d("EmotionItemModel", "parse: " + e + WebvttCueParser.CHAR_SPACE);
                return null;
            }
        }
        return (EmotionItemModel) invokeL.objValue;
    }

    public static final EmotionTypeModel parseEmotionTabModel(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new EmotionTypeModel(jSONObject.optString("id"), jSONObject.optString("type"), jSONObject.optString("auth"), jSONObject.optString("title"), jSONObject.optString("icon"), jSONObject.optString("schema"), jSONObject.optString("height"), jSONObject.optString("width"), jSONObject.optString(pic.f));
            } catch (JSONException e) {
                if (!AppConfig.isDebug()) {
                    return null;
                }
                Log.d("EmotionItemModel", "parse: " + e + WebvttCueParser.CHAR_SPACE);
                return null;
            }
        }
        return (EmotionTypeModel) invokeL.objValue;
    }
}
