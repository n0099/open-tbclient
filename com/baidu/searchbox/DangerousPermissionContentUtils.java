package com.baidu.searchbox;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/DangerousPermissionContentUtils;", "", "()V", "getFormatTitle", "", "context", "Landroid/content/Context;", "permissionGroupName", "getPermissionMessage", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DangerousPermissionContentUtils {
    public static final DangerousPermissionContentUtils INSTANCE = new DangerousPermissionContentUtils();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String getFormatTitle(Context context, String permissionGroupName) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionGroupName, "permissionGroupName");
        Resources resources = AppRuntime.getAppContext().getResources();
        if (resources == null) {
            return null;
        }
        switch (permissionGroupName.hashCode()) {
            case -1639857183:
                if (permissionGroupName.equals("android.permission-group.CONTACTS")) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f1052);
                    break;
                }
                str = null;
                break;
            case -1410061184:
                if (permissionGroupName.equals("android.permission-group.PHONE")) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f1054);
                    break;
                }
                str = null;
                break;
            case -1140935117:
                if (permissionGroupName.equals("android.permission-group.CAMERA")) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f1036);
                    break;
                }
                str = null;
                break;
            case 828638019:
                if (permissionGroupName.equals("android.permission-group.LOCATION")) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f1043);
                    break;
                }
                str = null;
                break;
            case 852078861:
                if (permissionGroupName.equals("android.permission-group.STORAGE")) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f1059);
                    break;
                }
                str = null;
                break;
            case 1581272376:
                if (permissionGroupName.equals("android.permission-group.MICROPHONE")) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f1051);
                    break;
                }
                str = null;
                break;
            default:
                str = null;
                break;
        }
        if (str == null) {
            return null;
        }
        String string = resources.getString(R.string.obfuscated_res_0x7f0f1056);
        Intrinsics.checkNotNullExpressionValue(string, "resource.getString(R.string.permission_title_end)");
        return str + string;
    }

    public final String getPermissionMessage(Context context, String permissionGroupName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionGroupName, "permissionGroupName");
        Resources resources = AppRuntime.getAppContext().getResources();
        if (resources == null) {
            return null;
        }
        switch (permissionGroupName.hashCode()) {
            case -1639857183:
                if (!permissionGroupName.equals("android.permission-group.CONTACTS")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f104b);
            case -1410061184:
                if (!permissionGroupName.equals("android.permission-group.PHONE")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f104d);
            case -1140935117:
                if (!permissionGroupName.equals("android.permission-group.CAMERA")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f1045);
            case 828638019:
                if (!permissionGroupName.equals("android.permission-group.LOCATION")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f1047);
            case 852078861:
                if (!permissionGroupName.equals("android.permission-group.STORAGE")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f1050);
            case 1581272376:
                if (!permissionGroupName.equals("android.permission-group.MICROPHONE")) {
                    return null;
                }
                return resources.getString(R.string.obfuscated_res_0x7f0f1049);
            default:
                return null;
        }
    }
}
