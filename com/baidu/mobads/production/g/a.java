package com.baidu.mobads.production.g;

import android.app.Activity;
import android.content.Context;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.d;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public IXAdProd f8471a;

    public a(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType, IXAdProd iXAdProd) {
        super(context, activity, slotType);
        this.f8625b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        this.f8471a = iXAdProd;
    }

    @Override // com.baidu.mobads.vo.d
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
        hashMap.put("prod", "video");
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
        hashMap.put("at", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        hashMap.put("n", "1");
        if (this.f8471a.getProdBase() == null && getApt() != AdSize.PrerollVideoNative.getValue()) {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, "640");
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, "480");
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }
}
