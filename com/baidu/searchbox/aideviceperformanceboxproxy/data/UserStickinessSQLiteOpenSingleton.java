package com.baidu.searchbox.aideviceperformanceboxproxy.data;

import android.content.Context;
import com.baidu.searchbox.aideviceperformance.data.UserStickinessSQLiteOpenHelper;
import com.baidu.searchbox.aideviceperformanceboxproxy.stickiness.UserStickinessRuntime;
/* loaded from: classes2.dex */
public class UserStickinessSQLiteOpenSingleton extends UserStickinessSQLiteOpenHelper {
    public static UserStickinessSQLiteOpenSingleton instance;

    public UserStickinessSQLiteOpenSingleton(Context context) {
        super(context, UserStickinessRuntime.getDefaultHandler());
    }

    public static UserStickinessSQLiteOpenSingleton getInstance(Context context) {
        if (instance == null) {
            synchronized (UserStickinessSQLiteOpenSingleton.class) {
                if (instance == null) {
                    instance = new UserStickinessSQLiteOpenSingleton(context);
                }
            }
        }
        return instance;
    }
}
