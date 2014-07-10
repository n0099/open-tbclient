package com.baidu.tbadk.a;

import com.baidu.adp.framework.a.e;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class b extends e {
    public b(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.a.e
    public void a(int i, int i2) {
        ReloginManager.a().a(i, i2);
    }

    @Override // com.baidu.adp.framework.a.e
    public void a(int i) {
        ReloginManager.a().a(i);
    }
}
