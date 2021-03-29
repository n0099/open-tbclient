package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f2193e;

    /* renamed from: f  reason: collision with root package name */
    public String f2194f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2195g;

    /* renamed from: h  reason: collision with root package name */
    public long f2196h;

    public long s() {
        return Math.max(Math.min(this.f2196h * 80, 240000L), 60000L);
    }
}
