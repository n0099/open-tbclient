package com.baidu.adp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.NetworkState;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface TbadkCore {
    public static final String MODULE = "tbadkcore";
    public static final String NAME = "tbadkcore";
    @NonNull
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("tbadkcore", "tbadkcore");

    void createAllTablesMessage(SQLiteDatabase sQLiteDatabase);

    void dispatchNetWorkChangedMessage(NetworkState networkState);

    boolean isNetWorkAvailable();

    boolean permissionUtilCheckReadPhoneState(@NonNull Context context);

    boolean permissionUtilIsAgreePrivacyPolicy();

    void registerDbListener(String str, HashMap hashMap, HashMap hashMap2);

    void statHttpsDownToHttp();

    @NonNull
    String tbConfigGetVersion();
}
