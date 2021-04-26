package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f2197e;

    /* renamed from: f  reason: collision with root package name */
    public String f2198f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2199g;

    /* renamed from: h  reason: collision with root package name */
    public long f2200h;

    public long s() {
        return Math.max(Math.min(this.f2200h * 80, 240000L), 60000L);
    }
}
