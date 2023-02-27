package com.baidu.searchbox.aideviceperformance.stickiness;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class StickinessScoreManager implements IStickinessScoreManager {
    public static final boolean DEBUG = Config.isDebug();
    public static final int MAX_DATA_COUNT = 50;
    public static final int MIN_DATA_COUNT = 10;
    public static final String TAG = "UserStickinessScore";
    public IStickinessScoreDataProvider mStickinessScoreDataProvider;

    public StickinessScoreManager(IStickinessScoreDataProvider iStickinessScoreDataProvider) {
        this.mStickinessScoreDataProvider = iStickinessScoreDataProvider;
    }

    private String getSpKeyStickinessScore(String str) {
        return "stickiness_score_" + str;
    }

    @Override // com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreManager
    public float getStickinessScore(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1.0f;
        }
        return DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(getSpKeyStickinessScore(str), -1.0f);
    }

    private float getSingleUserStickinessScore(int i, long j) {
        float f = 0.0f;
        if (i <= 0 || j <= 0) {
            return 0.0f;
        }
        float f2 = i * 0.2f;
        float f3 = 1.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f4 = 1.5f - (((float) j) / 60000.0f);
        if (f4 <= 1.0f) {
            f3 = f4;
        }
        if (f3 >= 0.0f) {
            f = f3;
        }
        return Math.max(f, f2);
    }

    @Override // com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreManager
    public boolean updateStickinessScore(Context context) {
        IStickinessScoreDataProvider iStickinessScoreDataProvider = this.mStickinessScoreDataProvider;
        if (iStickinessScoreDataProvider == null) {
            return false;
        }
        List<DBItemModel.UserStickinessItemModel> queryLast = iStickinessScoreDataProvider.getUserStickinessSQLiteOpenHelper(context).queryLast(51);
        if (queryLast == null) {
            if (DEBUG) {
                Log.d(TAG, "userStickinessItems null");
            }
            return false;
        } else if (queryLast.size() <= 10) {
            if (DEBUG) {
                Log.d(TAG, "userStickinessItems not enough : " + queryLast.size());
            }
            return false;
        } else {
            queryLast.remove(0);
            HashMap hashMap = new HashMap();
            for (DBItemModel.UserStickinessItemModel userStickinessItemModel : queryLast) {
                if (DEBUG) {
                    Log.d(TAG, "userStickinessItem detail : " + userStickinessItemModel.toString());
                }
                for (Map.Entry<String, DBItemModel.UserStickinessItemModel.ItemDetailModel> entry : userStickinessItemModel.getIdToItemDetailMap().entrySet()) {
                    String key = entry.getKey();
                    DBItemModel.UserStickinessItemModel.ItemDetailModel value = entry.getValue();
                    if (key != null && value != null) {
                        float singleUserStickinessScore = getSingleUserStickinessScore(value.count, value.firstTime);
                        Float f = (Float) hashMap.get(key);
                        if (f == null) {
                            hashMap.put(key, Float.valueOf(singleUserStickinessScore));
                        } else {
                            hashMap.put(key, Float.valueOf(singleUserStickinessScore + f.floatValue()));
                        }
                    } else {
                        if (DEBUG) {
                            Log.w(TAG, "userStickinessItem id or model null");
                        }
                        return false;
                    }
                }
            }
            int size = queryLast.size();
            for (Map.Entry entry2 : hashMap.entrySet()) {
                float floatValue = ((Float) entry2.getValue()).floatValue() / size;
                DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(getSpKeyStickinessScore((String) entry2.getKey()), floatValue);
                if (DEBUG) {
                    Log.d(TAG, "stickiness score updated. businessId:" + ((String) entry2.getKey()) + " score:" + floatValue + " userStickinessItems count:" + size);
                }
            }
            return true;
        }
    }
}
