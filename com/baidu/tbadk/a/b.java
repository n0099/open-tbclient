package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.f;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public final class b implements com.baidu.adp.framework.e.d {
    @Override // com.baidu.adp.framework.e.d
    public final void a(String str, String str2, int i, com.baidu.adp.framework.message.d<?> dVar) {
        int i2;
        int i3 = 0;
        if (dVar == null || !(dVar instanceof com.baidu.tbadk.message.websockt.d)) {
            i2 = 0;
        } else {
            i2 = dVar.e();
            i3 = ((com.baidu.tbadk.message.websockt.d) dVar).k();
        }
        TiebaStatic.a(str, i2, i3, str2, i);
    }

    @Override // com.baidu.adp.framework.e.d
    public final void a(String str, String str2, int i, f<?> fVar) {
        int i2;
        int i3 = 0;
        if (fVar == null || fVar.h() == null || !(fVar.h() instanceof com.baidu.tbadk.message.websockt.d)) {
            i2 = 0;
        } else {
            i2 = fVar.g();
            i3 = ((com.baidu.tbadk.message.websockt.d) fVar.h()).k();
        }
        TiebaStatic.a(str, i2, i3, str2, i);
    }
}
