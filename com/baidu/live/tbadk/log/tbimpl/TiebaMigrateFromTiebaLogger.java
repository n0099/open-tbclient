package com.baidu.live.tbadk.log.tbimpl;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IMigrateFromTiebaLogger;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class TiebaMigrateFromTiebaLogger implements IMigrateFromTiebaLogger {
    @Override // com.baidu.live.tbadk.log.IMigrateFromTiebaLogger
    public void doDisplayAttentionLog() {
        HashMap hashMap = new HashMap();
        hashMap.put(TiebaInitialize.Params.KEY, "c13129");
        ExtraParamsManager.doTiebaLog(hashMap);
    }

    @Override // com.baidu.live.tbadk.log.IMigrateFromTiebaLogger
    public void doClickShareLog(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TiebaInitialize.Params.KEY, "c12320");
        hashMap.put("uid", str);
        hashMap.put("obj_id", str2);
        ExtraParamsManager.doTiebaLog(hashMap);
    }

    @Override // com.baidu.live.tbadk.log.IMigrateFromTiebaLogger
    public void doClickRankListEntryLog(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TiebaInitialize.Params.KEY, "c12383");
        hashMap.put("obj_locate", str);
        ExtraParamsManager.doTiebaLog(hashMap);
    }
}
