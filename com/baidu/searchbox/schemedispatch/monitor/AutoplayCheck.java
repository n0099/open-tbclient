package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.utils.SchemeSpUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AutoplayCheck extends OpenAppBaseCheck {
    public static final String AUTOPLAY_SWITCH = "switch";
    public static final String AUTOPLAY_SWITCH_KEY = "autoplay_switch";
    public static final int AUTOPLAY_SWITCH_OFF = 0;
    public static final int AUTOPLAY_SWITCH_ON = 1;
    public static final String AUTOPLAY_WHITE_LIST = "white_list";
    public static final String AUTOPLAY_WHITE_LIST_FILENAME = "autoplay_white_list";
    public static final String TAG = "AutoplayCheck";
    public static List<String> sWhiteList = new ArrayList();

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
    }

    static {
        loadWhiteList();
    }

    public static boolean isAutoplaySwitchOn() {
        if (SchemeSpUtil.getInstance().getInt(AUTOPLAY_SWITCH_KEY, 0) != 1) {
            return false;
        }
        return true;
    }

    public static void loadWhiteList() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.monitor.AutoplayCheck.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AutoplayCheck.class) {
                    AutoplayCheck.sWhiteList.clear();
                    AutoplayCheck.sWhiteList.addAll(OpenAppBaseCheck.readCache(AutoplayCheck.AUTOPLAY_WHITE_LIST_FILENAME));
                }
            }
        }, "AutoplayWhiteListLoad", 2);
    }

    public static synchronized boolean isInAutoplayWhiteList(String str) {
        synchronized (AutoplayCheck.class) {
            if (isAutoplaySwitchOn() && !TextUtils.isEmpty(str)) {
                return OpenAppBaseCheck.isInWhiteList(str, sWhiteList);
            }
            return false;
        }
    }

    public static boolean saveData(String str) {
        return new AutoplayCheck().saveWhiteList(str);
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("switch");
        JSONArray optJSONArray = jSONObject.optJSONArray("white_list");
        if (optInt != 0 && optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            if (!OpenAppBaseCheck.writeCache(arrayList, AUTOPLAY_WHITE_LIST_FILENAME)) {
                return false;
            }
            SchemeSpUtil.getInstance().putInt(AUTOPLAY_SWITCH_KEY, optInt);
            synchronized (AutoplayCheck.class) {
                sWhiteList.clear();
                sWhiteList.addAll(arrayList);
            }
            return true;
        }
        if (OpenAppBaseCheck.DEBUG) {
            Log.d(TAG, "switch or whitelist is empty");
        }
        return false;
    }
}
