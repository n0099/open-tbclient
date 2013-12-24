package com.baidu.cloudsdk.social.core;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SocialConfig extends BaseConfig {
    public static final String AUTHORIZE_URL = "https://openapi.baidu.com/social/oauth/2.0/authorize";
    public static final String ERROR_URL = "http://openapi.baidu.com/social/oauth/2.0/error";
    public static final String HTTPS_URL_PREFIX = "https://openapi.baidu.com/social";
    public static final String HTTP_URL_PREFIX = "http://openapi.baidu.com/social";
    public static final String RECEIVER_URL = "https://openapi.baidu.com/social/oauth/2.0/receiver";
    public static final String SUCCESS_URL = "http://openapi.baidu.com/social/oauth/2.0/login_success";
    public static final String TOKEN_URL = "https://openapi.baidu.com/social/oauth/2.0/token";
    private static SocialConfig a;
    private Map b;
    private Map c;
    private List d;

    private SocialConfig(Context context) {
        super(context);
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new ArrayList();
    }

    public static SocialConfig getInstance(Context context) {
        if (a == null) {
            a = new SocialConfig(context);
            a.loadDefaultConfig();
        }
        return a;
    }

    public String getClientId(MediaType mediaType) {
        return (String) this.b.get(mediaType.toString());
    }

    public String getClientId(String str) {
        return (String) this.b.get(str);
    }

    public String getClientName(MediaType mediaType) {
        return (String) this.c.get(mediaType.toString());
    }

    public String getClientName(String str) {
        return (String) this.c.get(str);
    }

    @Override // com.baidu.cloudsdk.social.core.BaseConfig
    protected String getDefaultConfigFile() {
        return "social/core/config.json";
    }

    public List getSsoMediaTypes() {
        return this.d;
    }

    @Override // com.baidu.cloudsdk.social.core.BaseConfig
    protected void loadSelfDefinedConfigItems(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("client_ids");
        if (optJSONObject != null) {
            copyStringFromJsonObject2Map(optJSONObject, this.b);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("client_names");
        if (optJSONObject2 != null) {
            copyStringFromJsonObject2Map(optJSONObject2, this.c);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sso_medias");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            this.d = new ArrayList();
            for (int i = 0; i < length; i++) {
                try {
                    this.d.add(MediaType.fromString(optJSONArray.optString(i)));
                } catch (Exception e) {
                }
            }
        }
    }

    public SocialConfig setClientId(String str, MediaType mediaType) {
        this.b.put(mediaType.toString(), str);
        return this;
    }
}
