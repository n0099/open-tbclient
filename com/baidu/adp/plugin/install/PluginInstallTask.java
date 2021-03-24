package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f2192e;

    /* renamed from: f  reason: collision with root package name */
    public String f2193f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2194g;

    /* renamed from: h  reason: collision with root package name */
    public long f2195h;

    public long s() {
        return Math.max(Math.min(this.f2195h * 80, 240000L), 60000L);
    }
}
