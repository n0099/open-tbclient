package com.baidu.sapi2.biometrics.liveness.datamodel;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class UploadContrastPortraitModel implements IBeanResponse, Serializable {
    public String authsid;
    public String callbackkey;
    public int contrastres;
    public int forceswitch = 1;
    public int recordvideo;

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public boolean isContrastPass() {
        return 1 == this.contrastres;
    }

    public boolean isGotoRecordvideo() {
        return 1 == this.recordvideo;
    }

    public boolean isTrustResult() {
        return 1 == this.forceswitch;
    }
}
