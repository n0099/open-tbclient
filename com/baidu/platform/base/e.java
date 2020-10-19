package com.baidu.platform.base;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public abstract class e {
    private boolean b = true;
    private boolean c = true;

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.platform.util.a f2814a = new com.baidu.platform.util.a();

    private String a(SearchType searchType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SearchType.REVERSE_GEO_CODER == searchType ? a(str) : str;
    }

    private String a(String str) {
        String substring = str.substring(str.indexOf("location=") + "location=".length(), str.indexOf(ETAG.ITEM_SEPARATOR, str.indexOf("location=")));
        if (TextUtils.isEmpty(substring)) {
            return str;
        }
        byte[] bArr = {0};
        try {
            bArr = AlgorithmUtil.setUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), substring.getBytes());
        } catch (Exception e) {
            Log.e("BaseSearch", "get location failed", e);
        }
        return str.replace(substring, Base64.encodeToString(bArr, 0).trim());
    }

    private boolean b(SearchType searchType) {
        return SearchType.REVERSE_GEO_CODER == searchType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(PlanNode planNode) {
        if (planNode == null) {
            return null;
        }
        String str = new String("{");
        LatLng location = planNode.getLocation();
        if (location != null) {
            String str2 = str + "\"type\":1,";
            Point ll2point = CoordUtil.ll2point(location);
            return str2 + "\"xy\":\"" + ll2point.x + Constants.ACCEPT_TIME_SEPARATOR_SP + ll2point.y + "\"}";
        } else if (planNode.getName() != null) {
            return (str + "\"type\":2,") + "\"keyword\":\"" + planNode.getName() + "\"}";
        } else {
            return str;
        }
    }

    public String a(SearchType searchType) {
        String a2 = a(com.baidu.platform.domain.d.a());
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            Log.e("SearchRequest", "toUrlString get authtoken failed");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                Log.e("SearchRequest", "try permissionCheck result is: " + permissionCheck);
                return null;
            }
            authToken = HttpClient.getAuthToken();
        }
        if (this.b) {
            this.f2814a.a("token", authToken);
        }
        String a3 = this.f2814a.a();
        if (b(searchType)) {
            a3 = a(searchType, a3);
        }
        String str = a3 + HttpClient.getPhoneInfo();
        if (this.c) {
            str = str + "&sign=" + AppMD5.getSignMD5String(str);
        }
        return a2 + "?" + str;
    }

    public abstract String a(com.baidu.platform.domain.c cVar);

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.b = z;
    }
}
