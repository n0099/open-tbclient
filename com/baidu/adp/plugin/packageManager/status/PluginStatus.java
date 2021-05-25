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

    /* renamed from: e  reason: collision with root package name */
    public String f2238e;

    /* renamed from: f  reason: collision with root package name */
    public int f2239f;

    /* renamed from: g  reason: collision with root package name */
    public PluginPackageManager.PluginStatus f2240g;

    /* renamed from: h  reason: collision with root package name */
    public int f2241h;

    /* renamed from: i  reason: collision with root package name */
    public String f2242i;
    public String j;
    public boolean k;

    public int getErrorCode() {
        return this.f2241h;
    }

    public String getErrorMsg() {
        return this.f2242i;
    }

    public String getPkgName() {
        return this.f2238e;
    }

    public int s() {
        return this.f2239f;
    }

    public String t() {
        return this.j;
    }
}
