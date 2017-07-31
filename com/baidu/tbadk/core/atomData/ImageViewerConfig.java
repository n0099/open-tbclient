package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ImageViewerConfig extends IntentConfig {
    public static final String ASSIST_URLS = "assist_urls";
    public static final String COUNT = "count";
    public static final String DATA_NOT_VALID = "data_not_valid";
    public static final String DATA_VALID = "data_valid";
    public static final String FIXED_COUNT_IN_TITLE = "fixed_count_in_title";
    public static final String FORUM_ID = "fid";
    public static final String FORUM_NAME = "fname";
    public static final String FROM_DISCOVER_BEAUTY = "discover_beauty";
    public static final String FROM_FRS = "frs";
    public static final String FROM_PB = "pb";
    public static final String HAS_NEXT = "hasnext";
    public static final String INDEX = "index";
    public static final String IS_DATA_VALID = "is_data_valid";
    public static final String IS_PV = "is_pv";
    public static final String IS_SHOW_AD = "is_show_ad";
    public static final String LAST_ID = "last_id";
    private static final int MAX_ASSIST_URLS = 20;
    public static final String NEED_BROADCAST = "need_broadcast";
    public static final String NEXT_TILE = "nexttile";
    public static final String PARAM_IS_CDN = "isCdn";
    public static final String PV_TYPE = "pv_type";
    public static final String REVERSE_MODE = "reverse_mode";
    public static final String SEE_HOST = "see_host";
    public static final String START_ACTIVITY_NORMAL = "start_activity_normal";
    public static final String START_ACTIVITY_TYPE = "start_activity_type";
    public static final String THREAD_ID = "tid";
    public static final String THREAD_TYPE = "thread_type";
    public static final String URL = "url";
    public static final String USER_ID = "user_id";

    public ImageViewerConfig(Context context) {
        super(context);
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        return createConfig(arrayList, i, str, str2, str3, z, str4, z2, concurrentHashMap, false);
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z3) {
        return createConfig(arrayList, i, str, str2, str3, z, str4, z2, concurrentHashMap, z3, false, false);
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z3, boolean z4, boolean z5) {
        Intent intent = getIntent();
        intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, z);
            intent.putExtra(FORUM_NAME, str);
            intent.putExtra("fid", str2);
            intent.putExtra("tid", str3);
            intent.putExtra(LAST_ID, str4);
            intent.putExtra(REVERSE_MODE, z2);
            intent.putExtra(ASSIST_URLS, concurrentHashMap);
            intent.putExtra(IS_SHOW_AD, z3);
            intent.putExtra(NEED_BROADCAST, z4);
            intent.putExtra(SEE_HOST, z5);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                intent.putExtra("user_id", currentAccountObj.getID());
            }
        } else {
            intent.putExtra(IS_DATA_VALID, DATA_NOT_VALID);
        }
        return this;
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z3, boolean z4, boolean z5, int i2) {
        Intent intent = getIntent();
        intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, z);
            intent.putExtra(FORUM_NAME, str);
            intent.putExtra("fid", str2);
            intent.putExtra("tid", str3);
            intent.putExtra(LAST_ID, str4);
            intent.putExtra(REVERSE_MODE, z2);
            intent.putExtra(ASSIST_URLS, concurrentHashMap);
            intent.putExtra(IS_SHOW_AD, z3);
            intent.putExtra(NEED_BROADCAST, z4);
            intent.putExtra(SEE_HOST, z5);
            intent.putExtra("thread_type", i2);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                intent.putExtra("user_id", currentAccountObj.getID());
            }
        } else {
            intent.putExtra(IS_DATA_VALID, DATA_NOT_VALID);
        }
        return this;
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2) {
        return createConfig(arrayList, i, str, str2, str3, z, str4, z2, null);
    }

    public ImageViewerConfig setFixCountInTitle(int i) {
        getIntent().putExtra(FIXED_COUNT_IN_TITLE, i);
        return this;
    }

    private void cutAssistUrls(Map<String, ImageUrlData> map) {
        if (map != null && map.size() > 20) {
            int i = 0;
            Iterator<Map.Entry<String, ImageUrlData>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next();
                i++;
                if (i > 20) {
                    it.remove();
                }
            }
        }
    }
}
