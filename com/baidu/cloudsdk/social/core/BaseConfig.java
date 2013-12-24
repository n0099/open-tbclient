package com.baidu.cloudsdk.social.core;

import android.content.Context;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.assets.AssetFileUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.util.Validator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseConfig {
    protected Context mContext;
    protected Map mStringResources = new HashMap();
    protected Map mAssetFiles = new HashMap();
    protected Map mIntItems = new HashMap();
    private boolean a = false;

    public BaseConfig(Context context) {
        Validator.notNull(context, "context");
        this.mContext = context.getApplicationContext();
    }

    private void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("strings");
        if (optJSONObject != null) {
            copyStringFromJsonObject2Map(optJSONObject, this.mStringResources);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("files");
        if (optJSONObject2 != null) {
            copyStringFromJsonObject2Map(optJSONObject2, this.mAssetFiles);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("ints");
        if (optJSONObject3 != null) {
            copyIntegerFromJsonObject2Map(optJSONObject3, this.mIntItems);
        }
        loadSelfDefinedConfigItems(jSONObject);
    }

    protected static void copyIntegerFromJsonObject2Map(JSONObject jSONObject, Map map) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            map.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void copyStringFromJsonObject2Map(JSONObject jSONObject, Map map) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            map.put(next, jSONObject.optString(next));
        }
    }

    public String getAssetFileName(String str) {
        return (String) this.mAssetFiles.get(str);
    }

    protected abstract String getDefaultConfigFile();

    public int getInt(String str) {
        Integer num = (Integer) this.mIntItems.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public String getString(String str) {
        return (String) this.mStringResources.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadDefaultConfig() {
        if (this.a) {
            return;
        }
        this.a = true;
        loadFromLocal(getDefaultConfigFile());
        loadFromLocal("config.json");
    }

    public void loadFromLocal(String str) {
        Validator.notNullOrEmpty(str, "filename");
        a(AssetFileUtils.getFileContent(this.mContext, str));
    }

    public void loadFromServer(String str, IBaiduListener iBaiduListener) {
        Validator.notNullOrEmpty(str, SocialConstants.PARAM_URL);
        Validator.notNull(iBaiduListener, "listener");
        new AsyncHttpClient().get(null, str, new o(this, iBaiduListener, str));
    }

    protected void loadSelfDefinedConfigItems(JSONObject jSONObject) {
    }
}
