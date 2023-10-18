package com.baidu.searchbox.live.interfaces.service;

import android.app.Activity;
import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.permission.RequestSystemPermissionCallBack;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/PermissionRequestService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", ShareLoginStat.GetShareListStat.KEY_PERMISSION, "", "isPermissionGranted", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "permissions", "isPermissionGroupGranted", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Landroid/app/Activity;", "activity", "", "requestCode", "", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "source", "Lcom/baidu/searchbox/live/interfaces/permission/RequestSystemPermissionCallBack;", "showPermissionWindow", "(Ljava/lang/String;Landroid/app/Activity;[Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/permission/RequestSystemPermissionCallBack;", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface PermissionRequestService {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean isPermissionGranted(Context context, String str);

    boolean isPermissionGroupGranted(Context context, String[] strArr);

    void requestPermissions(Activity activity, String[] strArr, int i);

    RequestSystemPermissionCallBack showPermissionWindow(String str, Activity activity, String[] strArr);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/PermissionRequestService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.PERMISSION_REQUEST);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
