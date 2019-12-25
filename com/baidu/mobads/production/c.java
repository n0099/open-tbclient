package com.baidu.mobads.production;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements IOAdEventListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        IXAdResponseInfo iXAdResponseInfo;
        IXAdResponseInfo iXAdResponseInfo2;
        IXAdResponseInfo iXAdResponseInfo3;
        IXAdResponseInfo iXAdResponseInfo4;
        IXAdResponseInfo iXAdResponseInfo5;
        IXAdResponseInfo iXAdResponseInfo6;
        this.a.k();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            try {
                this.a.setAdResponseInfo(new com.baidu.mobads.vo.c((String) iOAdEvent.getData().get("message")));
                iXAdResponseInfo = this.a.x;
                if (iXAdResponseInfo != null) {
                    iXAdResponseInfo5 = this.a.x;
                    if (iXAdResponseInfo5.getAdInstanceList().size() > 0) {
                        b bVar = this.a;
                        iXAdResponseInfo6 = this.a.x;
                        bVar.d = iXAdResponseInfo6.getPrimaryAdInstanceInfo();
                        JSONObject originJsonObject = this.a.d.getOriginJsonObject();
                        this.a.r = originJsonObject.optString(DownloadDataConstants.Columns.COLUMN_MIME_TYPE);
                        this.a.q();
                        this.a.a();
                        return;
                    }
                }
                IXAdErrorCode errorCode = XAdSDKFoundationFacade.getInstance().getErrorCode();
                iXAdResponseInfo2 = this.a.x;
                String errorCode2 = iXAdResponseInfo2.getErrorCode();
                iXAdResponseInfo3 = this.a.x;
                errorCode.printErrorMessage(errorCode2, iXAdResponseInfo3.getErrorMessage(), "");
                b bVar2 = this.a;
                iXAdResponseInfo4 = this.a.x;
                bVar2.d(iXAdResponseInfo4.getErrorMessage());
                return;
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "response json parsing error", "");
                this.a.d("response json parsing error");
                com.baidu.mobads.c.a.a().a("response json parsing error");
                return;
            }
        }
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "request ad-server error, io_err/timeout", "");
        this.a.d("request ad-server error, io_err/timeout");
        com.baidu.mobads.c.a.a().a("request ad-server error, io_err/timeout");
    }
}
