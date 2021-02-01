package com.baidu.mobads.production.f;

import android.content.Context;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    l f3454a;

    public b(Context context, IXAdConstants4PDK.SlotType slotType) {
        super(context, null, slotType);
        this.f3454a = XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.f3529b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        g(1);
        i(this.f3454a.getAdCreativeTypeImage() + this.f3454a.getAdCreativeTypeVideo() + this.f3454a.getAdCreativeTypeRichmedia());
        f(8);
        h(0);
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
        hashMap.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }
}
