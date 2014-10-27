package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ TbCDNTachometerService xS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbCDNTachometerService tbCDNTachometerService, int i) {
        super(i);
        this.xS = tbCDNTachometerService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r5 > r0) goto L18;
     */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i;
        HashMap hashMap2;
        ArrayList arrayList7;
        String str2;
        int i2;
        int i3;
        if (customResponsedMessage != null) {
            try {
                e eVar = (e) customResponsedMessage.getData();
                if (eVar != null) {
                    String str3 = eVar.cdnIp;
                    boolean z = eVar.isSuccess;
                    long j = eVar.tm;
                    String valueOf = String.valueOf(j);
                    str = eVar.xT;
                    if (str != null) {
                        str2 = eVar.xT;
                        if (str2.length() > 0) {
                            this.xS.canBroadCast = true;
                            if (z) {
                                i2 = this.xS.hiPhotosMaxTime;
                            }
                            this.xS.isNormal = false;
                        }
                    }
                    if (z) {
                        if (j <= 200 && str3 != null && str3.length() != 0) {
                            hashMap2 = this.xS.cdnIpMap;
                            ArrayList arrayList8 = (ArrayList) hashMap2.get(str3);
                            for (int i4 = 0; i4 < arrayList8.size(); i4++) {
                                arrayList7 = this.xS.optimalIpList;
                                arrayList7.add((String) arrayList8.get(i4));
                            }
                        }
                        if (j <= 1500 && str3 != null && str3.length() != 0) {
                            hashMap = this.xS.cdnIpMap;
                            ArrayList arrayList9 = (ArrayList) hashMap.get(str3);
                            arrayList = this.xS.belowOnePointFiveIpList;
                            if (arrayList.size() > 0) {
                                int i5 = 0;
                                int i6 = 0;
                                while (true) {
                                    arrayList3 = this.xS.belowOnePointFiveIpList;
                                    if (i5 >= arrayList3.size()) {
                                        break;
                                    }
                                    arrayList6 = this.xS.belowOnePointFiveIpList;
                                    String[] split = ((String) arrayList6.get(i5)).split("_");
                                    if (split.length < 2) {
                                        i = i6;
                                    } else if (com.baidu.adp.lib.g.c.a(split[1], 0L) > j) {
                                        i6 = i5;
                                        break;
                                    } else {
                                        i = i5 + 1;
                                    }
                                    i5++;
                                    i6 = i;
                                }
                                arrayList4 = this.xS.belowOnePointFiveIpList;
                                if (i6 <= arrayList4.size()) {
                                    for (int i7 = 0; i7 < arrayList9.size(); i7++) {
                                        arrayList5 = this.xS.belowOnePointFiveIpList;
                                        arrayList5.add(i6, String.valueOf((String) arrayList9.get(i7)) + "_" + valueOf);
                                    }
                                }
                            } else {
                                for (int i8 = 0; i8 < arrayList9.size(); i8++) {
                                    arrayList2 = this.xS.belowOnePointFiveIpList;
                                    arrayList2.add(String.valueOf((String) arrayList9.get(i8)) + "_" + valueOf);
                                }
                            }
                        }
                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        TbCDNTachometerService tbCDNTachometerService = this.xS;
        i3 = tbCDNTachometerService.returnRequestNum;
        tbCDNTachometerService.returnRequestNum = i3 + 1;
        this.xS.judgeIsBroadcastCdnIp();
    }
}
