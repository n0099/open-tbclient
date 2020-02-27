package com.baidu.mobstat;

import com.tencent.connect.common.Constants;
/* loaded from: classes11.dex */
public class cf extends ce {
    @Override // com.baidu.mobstat.ce, com.baidu.mobstat.cd
    public ct a(ct ctVar) {
        super.a(ctVar);
        ctVar.a("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        return ctVar;
    }

    @Override // com.baidu.mobstat.ce, com.baidu.mobstat.cd
    public cd c() {
        return new cf();
    }
}
