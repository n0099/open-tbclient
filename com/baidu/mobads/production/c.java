package com.baidu.mobads.production;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3472a = bVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        IXAdResponseInfo iXAdResponseInfo;
        IXAdResponseInfo iXAdResponseInfo2;
        IXAdResponseInfo iXAdResponseInfo3;
        IXAdResponseInfo iXAdResponseInfo4;
        IXAdResponseInfo iXAdResponseInfo5;
        IXAdResponseInfo iXAdResponseInfo6;
        this.f3472a.k();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            try {
                this.f3472a.setAdResponseInfo(new com.baidu.mobads.vo.c((String) iOAdEvent.getData().get("message")));
                iXAdResponseInfo = this.f3472a.x;
                if (iXAdResponseInfo != null) {
                    iXAdResponseInfo5 = this.f3472a.x;
                    if (iXAdResponseInfo5.getAdInstanceList().size() > 0) {
                        b bVar = this.f3472a;
                        iXAdResponseInfo6 = this.f3472a.x;
                        bVar.d = iXAdResponseInfo6.getPrimaryAdInstanceInfo();
                        JSONObject originJsonObject = this.f3472a.d.getOriginJsonObject();
                        this.f3472a.r = originJsonObject.optString(DownloadDataConstants.Columns.COLUMN_MIME_TYPE);
                        this.f3472a.q();
                        this.f3472a.a();
                        return;
                    }
                }
                IXAdErrorCode errorCode = XAdSDKFoundationFacade.getInstance().getErrorCode();
                iXAdResponseInfo2 = this.f3472a.x;
                String errorCode2 = iXAdResponseInfo2.getErrorCode();
                iXAdResponseInfo3 = this.f3472a.x;
                errorCode.printErrorMessage(errorCode2, iXAdResponseInfo3.getErrorMessage(), "");
                b bVar2 = this.f3472a;
                iXAdResponseInfo4 = this.f3472a.x;
                bVar2.d(iXAdResponseInfo4.getErrorMessage());
                return;
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "response json parsing error", "");
                this.f3472a.d("response json parsing error");
                com.baidu.mobads.c.a.a().a("response json parsing error");
                return;
            }
        }
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "request ad-server error, io_err/timeout", "");
        this.f3472a.d("request ad-server error, io_err/timeout");
        com.baidu.mobads.c.a.a().a("request ad-server error, io_err/timeout");
    }
}
