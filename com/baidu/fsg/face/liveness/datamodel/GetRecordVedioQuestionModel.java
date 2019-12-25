package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class GetRecordVedioQuestionModel implements IBeanResponse, Serializable {
    public String callbackkey;
    public String[] question;
    public int questiontime = 3;

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
