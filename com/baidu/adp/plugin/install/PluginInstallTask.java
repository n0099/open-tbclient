package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f2228e;

    /* renamed from: f  reason: collision with root package name */
    public String f2229f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2230g;

    /* renamed from: h  reason: collision with root package name */
    public long f2231h;

    public long s() {
        return Math.max(Math.min(this.f2231h * 80, 240000L), 60000L);
    }
}
