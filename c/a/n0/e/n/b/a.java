package c.a.n0.e.n.b;

import android.database.Cursor;
import c.a.n0.t.d;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HashMap<String, PMSAppInfo> a() {
        InterceptResult invokeV;
        HashMap<String, PMSAppInfo> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Cursor query = c.a.n0.n.g.e.a.g().getReadableDatabase().query("swan_app", null, null, null, null, null, null);
            HashMap<String, PMSAppInfo> hashMap2 = new HashMap<>();
            if (query == null || !query.moveToFirst()) {
                hashMap = hashMap2;
            } else {
                int columnIndex = query.getColumnIndex("app_id");
                int columnIndex2 = query.getColumnIndex("app_key");
                int columnIndex3 = query.getColumnIndex("app_sign");
                int columnIndex4 = query.getColumnIndex("version_code");
                int columnIndex5 = query.getColumnIndex("version_name");
                int columnIndex6 = query.getColumnIndex("description");
                int columnIndex7 = query.getColumnIndex("app_status");
                int columnIndex8 = query.getColumnIndex("status_detail");
                int columnIndex9 = query.getColumnIndex("status_desc");
                int columnIndex10 = query.getColumnIndex("resume_date");
                int columnIndex11 = query.getColumnIndex("icon_url");
                int columnIndex12 = query.getColumnIndex("app_name");
                int columnIndex13 = query.getColumnIndex("service_category");
                int columnIndex14 = query.getColumnIndex("subject_info");
                HashMap<String, PMSAppInfo> hashMap3 = hashMap2;
                int columnIndex15 = query.getColumnIndex("type");
                int columnIndex16 = query.getColumnIndex("pkg_size");
                int columnIndex17 = query.getColumnIndex("pending_err_code");
                int columnIndex18 = query.getColumnIndex("app_category");
                int columnIndex19 = query.getColumnIndex("orientation");
                int columnIndex20 = query.getColumnIndex("max_age");
                int columnIndex21 = query.getColumnIndex("create_time");
                int columnIndex22 = query.getColumnIndex("webview_domains");
                int columnIndex23 = query.getColumnIndex("web_action");
                int columnIndex24 = query.getColumnIndex("domains");
                int columnIndex25 = query.getColumnIndex(SwanAppBearInfo.BEAR_INFO);
                int columnIndex26 = query.getColumnIndex("server_ext");
                int columnIndex27 = query.getColumnIndex("pay_protected");
                while (true) {
                    PMSAppInfo pMSAppInfo = new PMSAppInfo();
                    int i2 = columnIndex14;
                    pMSAppInfo.appId = query.getString(columnIndex);
                    pMSAppInfo.appKey = query.getString(columnIndex2);
                    int i3 = columnIndex;
                    int i4 = columnIndex2;
                    pMSAppInfo.appSign = query.getLong(columnIndex3);
                    pMSAppInfo.versionCode = query.getInt(columnIndex4);
                    pMSAppInfo.versionName = query.getString(columnIndex5);
                    pMSAppInfo.description = query.getString(columnIndex6);
                    pMSAppInfo.appStatus = query.getInt(columnIndex7);
                    pMSAppInfo.statusDetail = query.getString(columnIndex8);
                    pMSAppInfo.statusDesc = query.getString(columnIndex9);
                    pMSAppInfo.resumeDate = query.getString(columnIndex10);
                    pMSAppInfo.iconUrl = query.getString(columnIndex11);
                    pMSAppInfo.appName = query.getString(columnIndex12);
                    pMSAppInfo.serviceCategory = query.getString(columnIndex13);
                    pMSAppInfo.subjectInfo = query.getString(i2);
                    int i5 = columnIndex15;
                    pMSAppInfo.type = query.getInt(i5);
                    int i6 = columnIndex3;
                    int i7 = columnIndex16;
                    pMSAppInfo.pkgSize = query.getLong(i7);
                    int i8 = columnIndex17;
                    pMSAppInfo.pendingErrCode = query.getInt(i8);
                    int i9 = columnIndex18;
                    pMSAppInfo.appCategory = query.getInt(i9);
                    int i10 = columnIndex19;
                    pMSAppInfo.setOrientation(query.getInt(i10));
                    int i11 = columnIndex4;
                    int i12 = columnIndex20;
                    pMSAppInfo.maxAge = query.getLong(i12);
                    int i13 = columnIndex21;
                    pMSAppInfo.createTime = query.getLong(i13);
                    pMSAppInfo.webViewDomains = query.getString(columnIndex22);
                    pMSAppInfo.webAction = query.getString(columnIndex23);
                    pMSAppInfo.domains = query.getString(columnIndex24);
                    pMSAppInfo.bearInfo = query.getString(columnIndex25);
                    pMSAppInfo.serverExt = query.getString(columnIndex26);
                    pMSAppInfo.payProtected = query.getInt(columnIndex27);
                    hashMap = hashMap3;
                    hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                    if (!query.moveToNext()) {
                        break;
                    }
                    hashMap3 = hashMap;
                    columnIndex = i3;
                    columnIndex14 = i2;
                    columnIndex2 = i4;
                    columnIndex21 = i13;
                    columnIndex3 = i6;
                    columnIndex15 = i5;
                    columnIndex16 = i7;
                    columnIndex17 = i8;
                    columnIndex18 = i9;
                    columnIndex20 = i12;
                    columnIndex19 = i10;
                    columnIndex4 = i11;
                }
            }
            d.d(query);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
