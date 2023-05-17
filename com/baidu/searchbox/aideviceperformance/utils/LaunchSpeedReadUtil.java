package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.data.LaunchTimeSQLiteOpenHelper;
import java.util.List;
/* loaded from: classes3.dex */
public class LaunchSpeedReadUtil {
    public static final long CACHE_EXPIRE_TIME = 604800000;
    public static final boolean DEBUG = Config.isDebug();
    public static final int MAX_DATA_COUNT = 50;
    public static final int MIN_DATA_COUNT = 8;
    public static final String TAG = "LaunchSpeedReadUtil";

    private float calculateAve(List<DBItemModel.LaunchTimeItemModel> list) {
        if (list == null || list.size() < 8) {
            return -1.0f;
        }
        long j = list.get(0).launchTime;
        long j2 = 0;
        long j3 = j;
        for (DBItemModel.LaunchTimeItemModel launchTimeItemModel : list) {
            if (DEBUG) {
                Log.d(TAG, "Launch Time: " + launchTimeItemModel.launchTime);
            }
            long j4 = launchTimeItemModel.launchTime;
            if (j4 > j) {
                j = j4;
            }
            long j5 = launchTimeItemModel.launchTime;
            if (j5 < j3) {
                j3 = j5;
            }
            j2 += launchTimeItemModel.launchTime;
        }
        return ((((float) j2) - ((float) j)) - ((float) j3)) / (list.size() - 2);
    }

    public float calculateAverageLaunchTime(Context context) {
        List<DBItemModel.LaunchTimeItemModel> queryLast = LaunchTimeSQLiteOpenHelper.getInstance(context).queryLast(50);
        if (queryLast == null) {
            if (DEBUG) {
                Log.d(TAG, "launchTimeItems null");
            }
            return -1.0f;
        } else if (queryLast.size() < 8) {
            if (DEBUG) {
                Log.d(TAG, "launchTimeItems not enough : " + queryLast.size());
            }
            return -1.0f;
        } else {
            return calculateAve(queryLast);
        }
    }
}
