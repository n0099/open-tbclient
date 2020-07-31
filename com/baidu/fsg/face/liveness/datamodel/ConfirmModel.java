package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class ConfirmModel implements IBeanResponse, Serializable {
    public String message;
    public int status;

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
