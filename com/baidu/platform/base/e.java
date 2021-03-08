package com.baidu.platform.base;

import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
/* loaded from: classes4.dex */
public abstract class e {
    private boolean b = true;
    private boolean c = true;

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.platform.util.a f2867a = new com.baidu.platform.util.a();

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
        if (this.b) {
            this.f2867a.a("token", authToken);
        }
        String str = this.f2867a.a() + HttpClient.getPhoneInfo();
        if (this.c) {
            str = str + "&sign=" + AppMD5.getSignMD5String(str);
        }
        return a2 + "?" + str;
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
            return str2 + "\"xy\":\"" + ll2point.x + "," + ll2point.y + "\"}";
        } else if (planNode.getName() != null) {
            return (str + "\"type\":2,") + "\"keyword\":\"" + planNode.getName() + "\"}";
        } else {
            return str;
        }
    }

    public abstract String a(com.baidu.platform.domain.c cVar);

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.b = z;
    }
}
