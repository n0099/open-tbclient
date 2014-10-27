package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
public class e {
    public String cdnIp;
    public g cdnTachometerModel;
    public f ipListData;
    public boolean isSuccess;
    public int pos;
    public long tm;
    final /* synthetic */ TbCDNTachometerService xS;
    private boolean isNormal = false;
    private String xT = null;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.TbCDNTachometerService.startTachometer(com.baidu.tbadk.cdnOptimize.f):void] */
    public static /* synthetic */ void a(e eVar, boolean z) {
        eVar.isNormal = z;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.a.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.e>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ boolean b(e eVar) {
        return eVar.isNormal;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.a.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.e>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ String a(e eVar) {
        return eVar.xT;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.TbCDNTachometerService.startTachometer(com.baidu.tbadk.cdnOptimize.f):void, com.baidu.tbadk.cdnOptimize.a.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.e>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ void a(e eVar, String str) {
        eVar.xT = str;
    }

    public e(TbCDNTachometerService tbCDNTachometerService, f fVar, int i) {
        this.xS = tbCDNTachometerService;
        this.ipListData = fVar;
        this.pos = i;
    }
}
