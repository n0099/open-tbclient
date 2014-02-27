package com.baidu.adp.lib.debug.a;
/* loaded from: classes.dex */
public final class h extends a {
    private String a = "dalvikvm";
    private String[] b = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};

    @Override // com.baidu.adp.lib.debug.a.a
    public final void b() {
        super.b();
        try {
            j.a(this.a, new i(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
