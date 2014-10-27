package com.baidu.adp.lib.debug.a;
/* loaded from: classes.dex */
public class i extends a {
    private String gt = "dalvikvm";
    private String[] gu = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};

    @Override // com.baidu.adp.lib.debug.a.a
    public void start() {
        super.start();
        try {
            k.a(this.gt, new j(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
