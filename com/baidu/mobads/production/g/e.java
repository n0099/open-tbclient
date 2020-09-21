package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Build;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.m;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e extends com.baidu.mobads.vo.d {
    h a;

    public e(Context context, IXAdConstants4PDK.SlotType slotType) {
        super(context, null, slotType);
        this.a = XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        g(1);
        i(this.a.getAdCreativeTypeImage() + this.a.getAdCreativeTypeVideo() + this.a.getAdCreativeTypeRichmedia());
        f(8);
        h(0);
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
        if (c()) {
            hashMap.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png,rm/3d,rm/vr");
        } else {
            hashMap.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png,rm/3d");
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }

    private boolean c() {
        if (a.r()) {
            try {
                DexClassLoader a = com.baidu.mobads.production.a.a(this.d);
                Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, a);
                Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnGestureListener", false, a);
                Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBitmapLoadedListener", false, a);
                return Build.VERSION.SDK_INT >= 16;
            } catch (Exception e) {
                m.a().d(e);
                return false;
            }
        }
        return false;
    }
}
