package com.baidu.searchbox;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/DangerousPermissionContentUtils;", "Landroid/content/Context;", "context", "", "permissionGroupName", "getFormatTitle", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getPermissionMessage", "<init>", "()V", "lib-oem-permission_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DangerousPermissionContentUtils {
    public static final DangerousPermissionContentUtils INSTANCE = new DangerousPermissionContentUtils();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String getFormatTitle(Context context, String permissionGroupName) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionGroupName, "permissionGroupName");
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        Resources resources = appContext.getResources();
        if (resources != null) {
            switch (permissionGroupName.hashCode()) {
                case -1639857183:
                    if (permissionGroupName.equals("android.permission-group.CONTACTS")) {
                        str = resources.getString(R.string.obfuscated_res_0x7f0f0fbc);
                        break;
                    }
                    str = null;
                    break;
                case -1410061184:
                    if (permissionGroupName.equals("android.permission-group.PHONE")) {
                        str = resources.getString(R.string.obfuscated_res_0x7f0f0fbe);
                        break;
                    }
                    str = null;
                    break;
                case -1140935117:
                    if (permissionGroupName.equals("android.permission-group.CAMERA")) {
                        str = resources.getString(R.string.obfuscated_res_0x7f0f0fa0);
                        break;
                    }
                    str = null;
                    break;
                case 828638019:
                    if (permissionGroupName.equals("android.permission-group.LOCATION")) {
                        str = resources.getString(R.string.obfuscated_res_0x7f0f0fad);
                        break;
                    }
                    str = null;
                    break;
                case 852078861:
                    if (permissionGroupName.equals("android.permission-group.STORAGE")) {
                        str = resources.getString(R.string.obfuscated_res_0x7f0f0fc3);
                        break;
                    }
                    str = null;
                    break;
                case 1581272376:
                    if (permissionGroupName.equals("android.permission-group.MICROPHONE")) {
                        str = resources.getString(R.string.obfuscated_res_0x7f0f0fbb);
                        break;
                    }
                    str = null;
                    break;
                default:
                    str = null;
                    break;
            }
            if (str != null) {
                String string = resources.getString(R.string.obfuscated_res_0x7f0f0fc0);
                Intrinsics.checkNotNullExpressionValue(string, "resource.getString(R.string.permission_title_end)");
                return str + string;
            }
        }
        return null;
    }

    public final String getPermissionMessage(Context context, String permissionGroupName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionGroupName, "permissionGroupName");
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        Resources resources = appContext.getResources();
        if (resources == null) {
            return null;
        }
        switch (permissionGroupName.hashCode()) {
            case -1639857183:
                if (!permissionGroupName.equals("android.permission-group.CONTACTS")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f0fb5);
            case -1410061184:
                if (!permissionGroupName.equals("android.permission-group.PHONE")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f0fb7);
            case -1140935117:
                if (!permissionGroupName.equals("android.permission-group.CAMERA")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f0faf);
            case 828638019:
                if (!permissionGroupName.equals("android.permission-group.LOCATION")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f0fb1);
            case 852078861:
                if (!permissionGroupName.equals("android.permission-group.STORAGE")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f0fba);
            case 1581272376:
                if (!permissionGroupName.equals("android.permission-group.MICROPHONE")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f0fb3);
            default:
                return null;
        }
    }
}
