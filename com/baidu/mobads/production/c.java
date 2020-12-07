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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2399a = bVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        IXAdResponseInfo iXAdResponseInfo;
        IXAdResponseInfo iXAdResponseInfo2;
        IXAdResponseInfo iXAdResponseInfo3;
        IXAdResponseInfo iXAdResponseInfo4;
        IXAdResponseInfo iXAdResponseInfo5;
        IXAdResponseInfo iXAdResponseInfo6;
        this.f2399a.k();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            try {
                this.f2399a.setAdResponseInfo(new com.baidu.mobads.vo.c((String) iOAdEvent.getData().get("message")));
                iXAdResponseInfo = this.f2399a.x;
                if (iXAdResponseInfo != null) {
                    iXAdResponseInfo5 = this.f2399a.x;
                    if (iXAdResponseInfo5.getAdInstanceList().size() > 0) {
                        b bVar = this.f2399a;
                        iXAdResponseInfo6 = this.f2399a.x;
                        bVar.d = iXAdResponseInfo6.getPrimaryAdInstanceInfo();
                        JSONObject originJsonObject = this.f2399a.d.getOriginJsonObject();
                        this.f2399a.r = originJsonObject.optString(DownloadDataConstants.Columns.COLUMN_MIME_TYPE);
                        this.f2399a.q();
                        this.f2399a.a();
                        return;
                    }
                }
                IXAdErrorCode errorCode = XAdSDKFoundationFacade.getInstance().getErrorCode();
                iXAdResponseInfo2 = this.f2399a.x;
                String errorCode2 = iXAdResponseInfo2.getErrorCode();
                iXAdResponseInfo3 = this.f2399a.x;
                errorCode.printErrorMessage(errorCode2, iXAdResponseInfo3.getErrorMessage(), "");
                b bVar2 = this.f2399a;
                iXAdResponseInfo4 = this.f2399a.x;
                bVar2.d(iXAdResponseInfo4.getErrorMessage());
                return;
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "response json parsing error", "");
                this.f2399a.d("response json parsing error");
                com.baidu.mobads.c.a.a().a("response json parsing error");
                return;
            }
        }
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "request ad-server error, io_err/timeout", "");
        this.f2399a.d("request ad-server error, io_err/timeout");
        com.baidu.mobads.c.a.a().a("request ad-server error, io_err/timeout");
    }
}
