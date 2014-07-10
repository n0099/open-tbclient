package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.content.Context;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class c extends a {
    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    public c(boolean z, boolean z2, boolean z3) {
        this.a = true;
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.a = z;
        this.b = z2;
        this.c = z3;
        int b = com.baidu.adp.lib.util.j.b(TbadkApplication.m252getInst().getApp());
        this.d = b <= 0 ? Constants.MEDIA_INFO : b;
        if (this.d > 480) {
            this.d = 480;
        }
        if (this.d > com.baidu.adp.lib.util.j.a((Context) TbadkApplication.m252getInst().getApp(), 320.0f)) {
            this.d = com.baidu.adp.lib.util.j.a((Context) TbadkApplication.m252getInst().getApp(), 320.0f);
        }
        this.e = (int) (this.d * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int d() {
        return BdResourceLoaderNetHelperStatic.a() ? this.d : this.e;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int e() {
        return d();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return this.a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean h() {
        return this.b;
    }
}
