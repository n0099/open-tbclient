package com.baidu.searchbox.ng.ai.apps.swancore;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreControl;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AboutDevSwanCoreHistory {
    private static final String NEW_LINE = "\n";
    private static final String PREF_CORE_VERSION_LIST = "aiapps_core_ver_list_key";
    private static final String SWAN_CORE_TIME_KEY = "time";
    private static final String SWAN_CORE_VERSION_KEY = "version";

    private AboutDevSwanCoreHistory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final AboutDevSwanCoreHistory sInstance = new AboutDevSwanCoreHistory();

        private SingletonHolder() {
        }
    }

    public static AboutDevSwanCoreHistory getIns() {
        return SingletonHolder.sInstance;
    }

    public void cacheSwanCoreInfo(long j) {
        boolean z;
        List<SwanCoreHistory> swanCoreHistorySafely = getSwanCoreHistorySafely();
        if (swanCoreHistorySafely.size() >= 10) {
            swanCoreHistorySafely.remove(0);
        }
        Iterator<SwanCoreHistory> it = swanCoreHistorySafely.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            SwanCoreHistory next = it.next();
            if (next != null && next.swanCoreVersion == j) {
                z = true;
                break;
            }
        }
        if (!z) {
            swanCoreHistorySafely.add(new SwanCoreHistory(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (SwanCoreHistory swanCoreHistory : swanCoreHistorySafely) {
                if (swanCoreHistory != null) {
                    hashSet.add(swanCoreHistory.toJson());
                }
            }
            AiAppsSpHelper.getsInstance().putStringSet(PREF_CORE_VERSION_LIST, hashSet);
        }
    }

    private static void sortByTime(List<SwanCoreHistory> list) {
        Collections.sort(list, new Comparator<SwanCoreHistory>() { // from class: com.baidu.searchbox.ng.ai.apps.swancore.AboutDevSwanCoreHistory.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(SwanCoreHistory swanCoreHistory, SwanCoreHistory swanCoreHistory2) {
                if (swanCoreHistory == null) {
                    return -1;
                }
                if (swanCoreHistory2 == null) {
                    return 1;
                }
                return String.valueOf(swanCoreHistory.curtTime).compareTo(String.valueOf(swanCoreHistory2.curtTime));
            }
        });
    }

    public String getSwanCoreHistoryListString() {
        StringBuilder sb = new StringBuilder();
        String string = AiAppsSpHelper.getsInstance().getString(AiAppSetting.KEY_SWAN_JS_MD5, "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append(NEW_LINE).append(NEW_LINE);
        }
        List<SwanCoreHistory> swanCoreHistorySafely = getSwanCoreHistorySafely();
        int size = swanCoreHistorySafely.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            SwanCoreHistory swanCoreHistory = swanCoreHistorySafely.get(i);
            if (swanCoreHistory != null) {
                z = true;
                sb.append(swanCoreHistory.toString());
                if (i < size - 1) {
                    sb.append(NEW_LINE);
                }
            }
            i++;
            z = z;
        }
        if (!z) {
            sb.append(new SwanCoreHistory(0L, PresetSwanCoreControl.getCurPresetVersion()).toString());
        }
        return sb.toString();
    }

    private List<SwanCoreHistory> getSwanCoreHistorySafely() {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = AiAppsSpHelper.getsInstance().getStringSet(PREF_CORE_VERSION_LIST, null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            SwanCoreHistory parseSwanCoreHistory = parseSwanCoreHistory(str);
            if (parseSwanCoreHistory != null) {
                arrayList.add(parseSwanCoreHistory);
            }
        }
        sortByTime(arrayList);
        return arrayList;
    }

    private SwanCoreHistory parseSwanCoreHistory(String str) {
        SwanCoreHistory swanCoreHistory;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanCoreHistory = new SwanCoreHistory(jSONObject.optLong("time"), jSONObject.optLong("version"));
        } catch (JSONException e) {
            swanCoreHistory = null;
        }
        return swanCoreHistory;
    }

    /* loaded from: classes2.dex */
    public class SwanCoreHistory {
        long curtTime;
        long swanCoreVersion;

        SwanCoreHistory(long j, long j2) {
            this.curtTime = j;
            this.swanCoreVersion = j2;
        }

        public String toString() {
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT, Locale.getDefault()).format(new Date(this.curtTime));
                try {
                    str2 = AiAppsSwanCoreManager.versionValueToString(this.swanCoreVersion);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                str = null;
            }
            return str + " ---> " + str2;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.curtTime);
                jSONObject.put("version", this.swanCoreVersion);
                return jSONObject.toString();
            } catch (JSONException e) {
                return null;
            }
        }
    }
}
