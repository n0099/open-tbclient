package com.baidu.cloudsdk.social.share;

import android.content.Context;
import com.baidu.cloudsdk.social.core.BaseConfig;
import com.baidu.cloudsdk.social.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SocialShareConfig extends BaseConfig {

    /* renamed from: a  reason: collision with root package name */
    private static SocialShareConfig f865a;
    private List b;
    private List c;

    private SocialShareConfig(Context context) {
        super(context);
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public static SocialShareConfig getInstance(Context context) {
        if (f865a == null) {
            f865a = new SocialShareConfig(context);
            f865a.loadDefaultConfig();
        }
        return f865a;
    }

    @Override // com.baidu.cloudsdk.social.core.BaseConfig
    protected String getDefaultConfigFile() {
        return "social/share/config.json";
    }

    public List getExcludedMediaTypesInShareMenu() {
        return this.c;
    }

    public List getSupportedMediaTypes() {
        return this.b;
    }

    @Override // com.baidu.cloudsdk.social.core.BaseConfig
    protected void loadSelfDefinedConfigItems(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("supported_medias");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            if (length > 0) {
                this.b = new ArrayList();
            }
            for (int i = 0; i < length; i++) {
                try {
                    this.b.add(MediaType.fromString(optJSONArray.optString(i)));
                } catch (Exception e) {
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_medias");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            if (length2 > 0) {
                this.c = new ArrayList();
            }
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                    this.c.add(MediaType.fromString(optJSONArray2.optString(i2)));
                } catch (Exception e2) {
                }
            }
        }
    }
}
