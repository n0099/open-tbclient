package com.baidu.searchbox.ng.ai.apps.scheme;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public class AiAppSchemeStatusCode {
    public static final int ERROR_AB_SWITCH_OFF = 2007;
    public static final int ERROR_FILE_DELETE_FAIL = 2004;
    public static final int ERROR_FILE_NOT_EXIST = 2001;
    public static final int ERROR_FILE_OK = 2000;
    public static final int ERROR_FILE_PATH_NOT_BDFILE = 2006;
    public static final int ERROR_FILE_TOO_LARGE = 2002;
    public static final int ERROR_IO_EXCEPTION = 2003;

    public static String getErrMessage(int i) {
        switch (i) {
            case 2001:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_not_exist);
            case 2002:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_too_large);
            case 2003:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_io_exception);
            case 2004:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_files_delete_fail);
            case 2005:
            default:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_not_exist);
            case 2006:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_file_path_invalid);
            case 2007:
                return AppRuntime.getAppContext().getString(R.string.aiapps_scheme_err_message_ab_switch_off);
        }
    }
}
