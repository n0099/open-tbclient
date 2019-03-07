package com.baidu.swan.apps.scheme;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes2.dex */
public class f {
    public static String getErrMessage(int i) {
        switch (i) {
            case 2001:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_file_not_exist);
            case BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER /* 2002 */:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_file_too_large);
            case 2003:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_file_io_exception);
            case 2004:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_files_delete_fail);
            case PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE_BROADCAST /* 2005 */:
            default:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_file_not_exist);
            case 2006:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_file_path_invalid);
            case 2007:
                return AppRuntime.getAppContext().getString(b.h.aiapps_scheme_err_message_ab_switch_off);
        }
    }
}
