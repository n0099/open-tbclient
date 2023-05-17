package com.baidu.searchbox;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class Router extends BaseRouter {
    public static boolean invoke(Context context, String str) {
        if (UnitedSchemeUtility.isUnitedScheme(str)) {
            return BaseRouter.invokeSchemeForInner(context, Uri.parse(str));
        }
        return CommandUtils.invokeCommand(context, str);
    }

    public static boolean isAvailable(Context context, String str) {
        if (UnitedSchemeUtility.isUnitedScheme(str)) {
            return BaseRouter.isSchemeAvailable(context, Uri.parse(str), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        }
        return CommandUtils.isCommandAvailable(context, str);
    }
}
