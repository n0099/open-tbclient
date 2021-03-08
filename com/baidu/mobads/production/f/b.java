package com.baidu.mobads.production.f;

import android.content.Context;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    l f2460a;

    public b(Context context, IXAdConstants4PDK.SlotType slotType) {
        super(context, null, slotType);
        this.f2460a = XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        g(1);
        i(this.f2460a.getAdCreativeTypeImage() + this.f2460a.getAdCreativeTypeVideo() + this.f2460a.getAdCreativeTypeRichmedia());
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
