package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class VideoFaceMatchModel implements IBeanResponse, Serializable {
    public String authsid;
    public String callbackkey;
    public int contrastres;
    public int forceswitch = 1;
    public int isFake;
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
