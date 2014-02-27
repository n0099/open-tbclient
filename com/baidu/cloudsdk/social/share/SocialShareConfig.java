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
    private static SocialShareConfig a;
    private List b;
    private List c;
    private List d;

    private SocialShareConfig(Context context) {
        super(context);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public static void clean() {
        if (a != null) {
            a.c.clear();
            a.mIntItems.clear();
            a.d.clear();
            a.mStringResources.clear();
            a.b.clear();
            a.mContext = null;
            a = null;
        }
    }

    public static SocialShareConfig getInstance(Context context) {
        if (a == null) {
            SocialShareConfig socialShareConfig = new SocialShareConfig(context);
            a = socialShareConfig;
            socialShareConfig.loadDefaultConfig();
        }
        return a;
    }

    @Override // com.baidu.cloudsdk.social.core.BaseConfig
    protected String getDefaultConfigFile() {
        return "social/share/config.json";
    }

    public List getExcludedMediaTypesInShareMenu() {
        return this.c;
    }

    public List getNoSupportedPackages() {
        return this.d;
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
        JSONArray optJSONArray3 = jSONObject.optJSONArray("no_supported_packages_in_others");
        if (optJSONArray3 != null) {
            int length3 = optJSONArray3.length();
            if (length3 > 0) {
                this.d = new ArrayList();
            }
            for (int i3 = 0; i3 < length3; i3++) {
                try {
                    this.d.add(optJSONArray3.optString(i3));
                } catch (Exception e3) {
                }
            }
        }
    }
}
