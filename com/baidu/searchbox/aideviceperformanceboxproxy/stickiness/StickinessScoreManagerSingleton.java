package com.baidu.searchbox.aideviceperformanceboxproxy.stickiness;

import android.content.Context;
import com.baidu.searchbox.aideviceperformance.data.UserStickinessSQLiteOpenHelper;
import com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreDataProvider;
import com.baidu.searchbox.aideviceperformance.stickiness.StickinessScoreManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.data.UserStickinessSQLiteOpenSingleton;
/* loaded from: classes3.dex */
public class StickinessScoreManagerSingleton extends StickinessScoreManager {
    public static StickinessScoreManagerSingleton sInstance = new StickinessScoreManagerSingleton();

    public StickinessScoreManagerSingleton() {
        super(new IStickinessScoreDataProvider() { // from class: com.baidu.searchbox.aideviceperformanceboxproxy.stickiness.StickinessScoreManagerSingleton.1
            @Override // com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreDataProvider
            public UserStickinessSQLiteOpenHelper getUserStickinessSQLiteOpenHelper(Context context) {
                return UserStickinessSQLiteOpenSingleton.getInstance(context);
            }
        });
    }

    public static StickinessScoreManagerSingleton getInstance() {
        return sInstance;
    }
}
