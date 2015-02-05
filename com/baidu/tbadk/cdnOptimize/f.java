package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
public class f {
    final /* synthetic */ TbCDNTachometerService BD;
    public String cdnIp;
    public m cdnTachometerModel;
    public g ipListData;
    public boolean isSuccess;
    public int pos;
    public long vA;
    private boolean isNormal = false;
    private String BE = null;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.b.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.f>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ boolean b(f fVar) {
        return fVar.isNormal;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.b.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.f>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ String a(f fVar) {
        return fVar.BE;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.cdnOptimize.b.run(com.baidu.adp.framework.message.CustomMessage<com.baidu.tbadk.cdnOptimize.f>):com.baidu.adp.framework.message.CustomResponsedMessage<?>] */
    public static /* synthetic */ void a(f fVar, String str) {
        fVar.BE = str;
    }

    public f(TbCDNTachometerService tbCDNTachometerService, g gVar, int i) {
        this.BD = tbCDNTachometerService;
        this.ipListData = gVar;
        this.pos = i;
    }
}
