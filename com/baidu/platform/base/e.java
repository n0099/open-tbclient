package com.baidu.platform.base;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: b  reason: collision with root package name */
    public boolean f9380b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9381c = true;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.util.a f9379a = new com.baidu.platform.util.a();

    public String a() {
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
        if (this.f9380b) {
            this.f9379a.a("token", authToken);
        }
        String str = this.f9379a.a() + HttpClient.getPhoneInfo();
        if (this.f9381c) {
            str = str + "&sign=" + AppMD5.getSignMD5String(str);
        }
        return a2 + "?" + str;
    }

    public final String a(PlanNode planNode) {
        StringBuilder sb;
        if (planNode == null) {
            return null;
        }
        String str = new String(StringUtil.ARRAY_START);
        LatLng location = planNode.getLocation();
        if (location != null) {
            String str2 = str + "\"type\":1,";
            Point ll2point = CoordUtil.ll2point(location);
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("\"xy\":\"");
            sb.append(ll2point.x);
            sb.append(",");
            sb.append(ll2point.y);
        } else if (planNode.getName() == null) {
            return str;
        } else {
            sb = new StringBuilder();
            sb.append(str + "\"type\":2,");
            sb.append("\"keyword\":\"");
            sb.append(planNode.getName());
        }
        sb.append("\"}");
        return sb.toString();
    }

    public abstract String a(com.baidu.platform.domain.c cVar);

    public void a(boolean z) {
        this.f9381c = z;
    }

    public void b(boolean z) {
        this.f9380b = z;
    }
}
