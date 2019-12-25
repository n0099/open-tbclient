package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.listener.PublishLimitUpdateListener;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.google.gson.Gson;
import com.google.gson.b.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UgcDataUtil {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = UgcDataUtil.class.getSimpleName();
    public static final int WORD_LOWER_LIMIT = 20;
    public static final int WORD_UPPER_LIMIT = 2000;

    public static String parseInterestIdFormTarget(String str) {
        List list;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String optString = new JSONObject(str).optString("tag");
            if (!TextUtils.isEmpty(optString) && (list = (List) new Gson().fromJson(optString, new a<List<UgcTagItem>>() { // from class: com.baidu.searchbox.ugc.utils.UgcDataUtil.1
            }.getType())) != null && list.size() > 0) {
                return ((UgcTagItem) list.get(0)).tagID;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static int verifyWordLimit(int i) {
        if (i < 20) {
            return 20;
        }
        if (i > 2000) {
            return 2000;
        }
        return i;
    }

    public static int getWordLimit(String str, String str2) {
        int wordLimitInternal = getWordLimitInternal(str, str2);
        if (DEBUG) {
            Log.e(TAG, "schemeLimit = " + str + ", wordLimit = " + wordLimitInternal);
        }
        return wordLimitInternal;
    }

    private static int getWordLimitInternal(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return verifyWordLimit(Integer.valueOf(str).intValue());
        }
        int wordLimit = PublishLimitUpdateListener.getWordLimit(str2);
        if (DEBUG) {
            Log.e(TAG, "updateLimit = " + wordLimit);
        }
        return verifyWordLimit(wordLimit);
    }
}
