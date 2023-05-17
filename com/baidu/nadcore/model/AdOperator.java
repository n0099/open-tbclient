package com.baidu.nadcore.model;

import com.baidu.searchbox.crius.constants.NativeConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdOperator {
    public final TYPE a;
    public final a b;
    public final String c;
    public String d;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        public a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("text");
        }

        public static a a(JSONObject jSONObject) {
            return new a(jSONObject);
        }
    }

    public AdOperator(JSONObject jSONObject) throws ParseError {
        TYPE type;
        try {
            type = TYPE.from(jSONObject.optString("type"));
        } catch (Throwable unused) {
            type = null;
        }
        if (type != null) {
            this.a = type;
            this.b = a.a(jSONObject.optJSONObject("desc"));
            JSONObject optJSONObject = jSONObject.optJSONObject(NativeConstants.ID_BUTTON);
            optJSONObject = optJSONObject == null ? new JSONObject() : optJSONObject;
            this.c = optJSONObject.optString("text");
            this.d = optJSONObject.optString("scheme");
            return;
        }
        throw ParseError.contentError(12, "operator type:" + jSONObject.optString("type"));
    }

    /* loaded from: classes3.dex */
    public enum TYPE {
        CHECK("check"),
        DOWNLOAD("download");
        
        public final String type;

        TYPE(String str) {
            this.type = str;
        }

        public static TYPE from(String str) {
            TYPE[] values;
            for (TYPE type : values()) {
                if (type.type.equals(str)) {
                    return type;
                }
            }
            throw new EnumConstantNotPresentException(TYPE.class, str);
        }
    }

    public static AdOperator a(JSONObject jSONObject) throws ParseError {
        return new AdOperator(jSONObject);
    }
}
