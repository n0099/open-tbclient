package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
public class e {
    public f a;
    public int b;
    public boolean c;
    public long d;
    public String e;
    public g f;
    final /* synthetic */ TbCDNTachometerService g;
    private boolean h = false;
    private String i = null;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.a.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.e>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ boolean b(e eVar) {
        return eVar.h;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.a.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.e>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ String a(e eVar) {
        return eVar.i;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.a.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.e>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ void a(e eVar, String str) {
        eVar.i = str;
    }

    public e(TbCDNTachometerService tbCDNTachometerService, f fVar, int i) {
        this.g = tbCDNTachometerService;
        this.a = fVar;
        this.b = i;
    }
}
