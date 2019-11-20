package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> bao = new ArrayList();
    private long ban = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void af(long j) {
        if (this.bao != null) {
            this.bao.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void ag(long j) {
        this.ban = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long NQ() {
        if (this.bao == null || this.bao.size() <= 0 || this.ban < 0) {
            return -1L;
        }
        return this.ban - ((Long) Collections.min(this.bao)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
