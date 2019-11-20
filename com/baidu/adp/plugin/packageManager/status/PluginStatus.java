package com.baidu.adp.plugin.packageManager.status;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* loaded from: classes.dex */
public class PluginStatus extends OrmObject {
    public static final int STATUS_INSTALL_ERROR_ROMSIZE = 2;
    public static final int STATUS_INSTALL_FSYNC_FAILED = 5;
    public static final int STATUS_INSTALL_ONLYREAD_FILESYSTEM = 3;
    public static final int STATUS_INSTALL_PERMISSION_DENIED = 4;
    public static final int STATUS_INSTALL_RETRY_TIMEOUT = 6;
    public static final int STATUS_INSTALL_UNKNOWN = 1;
    public static final int STATUS_LOAD_UNKNOWN = 100;
    public static final int STATUS_SUCCESS = 0;
    int errorCode;
    String errorMsg;
    String pkgName;
    int priority;
    PluginPackageManager.PluginStatus wu;
    String wv;
    boolean ww;

    public String getPkgName() {
        return this.pkgName;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String ju() {
        return this.wv;
    }
}
