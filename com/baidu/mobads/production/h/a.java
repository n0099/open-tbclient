package com.baidu.mobads.production.h;

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
/* loaded from: classes14.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected IXAdProd f3454a;

    public a(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType, IXAdProd iXAdProd) {
        super(context, activity, slotType);
        this.f3525b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        this.f3454a = iXAdProd;
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
        hashMap.put("prod", "video");
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
        hashMap.put("at", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        hashMap.put("n", "1");
        if (this.f3454a.getProdBase() == null && getApt() != AdSize.PrerollVideoNative.getValue()) {
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
