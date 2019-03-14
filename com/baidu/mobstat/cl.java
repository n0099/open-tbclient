package com.baidu.mobstat;

import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class cl extends ck {
    @Override // com.baidu.mobstat.ck, com.baidu.mobstat.cj
    public cz a(cz czVar) {
        super.a(czVar);
        czVar.a("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        return czVar;
    }

    @Override // com.baidu.mobstat.ck, com.baidu.mobstat.cj
    public cj c() {
        return new cl();
    }
}
