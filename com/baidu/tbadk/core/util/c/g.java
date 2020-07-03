package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aik;
    private boolean dWx;
    private int procType;

    public g(boolean z, int i, boolean z2) {
        this.aik = true;
        this.procType = 0;
        this.dWx = true;
        this.aik = z;
        this.procType = i;
        this.dWx = z2;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aik;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aXi() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aXj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aXk() {
        return this.procType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.t.lo();
        lo.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c wU = wU(at.getNameMd5FromUrl(str2));
        if (wU == null) {
            return null;
        }
        wU.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        wU.setSdCard(false);
        wU.setSubFolder(true);
        wU.setSavedCache(true);
        wU.setIsFormatData(false);
        wU.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(wU);
            aVar.LI = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.kh().c(wU)) {
            com.baidu.tbadk.core.util.t.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
            return null;
        }
        int i3 = 2000;
        if (isWifiNet) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!wU.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = b(wU, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.t.a(lo, str2, true, lo.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.t.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.Ue.resourceFromType = "disk";
            aVar2.Ue.costTime = lo.getTimeCost();
            aVar2.Ue.isScuess = true;
            return aVar2;
        }
        return aVar2;
    }

    protected com.baidu.adp.widget.ImageView.a b(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a((Bitmap) null, false, str, cVar.getData());
        cVar.formatData(cVar.getData());
        Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i, i2);
        if (checkBitmapSize != null) {
            return new com.baidu.adp.widget.ImageView.a(checkBitmapSize, cVar.isGif(), str);
        }
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ec  */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] an;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.t.lo();
        lo.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        if (width == 0) {
            width = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String o = isFromCDN ? str : o(str, width, height);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = o.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = o.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = o.lastIndexOf(".jpg")) > 0) {
                z = true;
                str3 = o.substring(0, lastIndexOf) + ".webp" + o.substring(lastIndexOf + 4, o.length());
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.LI = iVar;
                }
                an = iVar.an(str3, isFromCDN);
                boolean aXe = iVar.aXe();
                Rect rect = new Rect();
                StringBuilder sb = new StringBuilder(100);
                if (!iVar.aXd()) {
                    if (iVar.responseCode == 302 && (17 == aXk() || 18 == aXk() || 13 == aXk() || 14 == aXk())) {
                        if (iVar.dVT != null) {
                            com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "redirect", lo.getTimeCost(), iVar.aXg(), 0L, aXk());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, aXe);
                            if (a != null) {
                                a.Ue.resourceFromType = "net";
                                a.Ue.costTime = lo.getTimeCost();
                                a.Ue.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.kU().Le) {
                        long j = 0;
                        if (an != null) {
                            j = an.length;
                        }
                        com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "NetworkError", lo.getTimeCost(), iVar.aXg(), j, aXk());
                        return null;
                    }
                }
                if (an != null) {
                    if (!iVar.kU().Le) {
                        com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "ByteIsNull", lo.getTimeCost(), iVar.aXg(), 0L, aXk());
                    }
                    return null;
                }
                if (an.length > 1) {
                    k.aXm().t(an.length, lo.getTimeCost());
                    com.baidu.tbadk.core.util.t.a(lo, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "InputToByteSucc", lo.getTimeCost(), iVar.aXg(), an.length, aXk());
                } else {
                    com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "bytes<1", lo.getTimeCost(), iVar.aXg(), an.length, aXk());
                }
                com.baidu.adp.lib.stats.a lo2 = com.baidu.tbadk.core.util.t.lo();
                lo2.startTimer();
                com.baidu.tbadk.imageManager.c.bgz().freePicCache(TbConfig.getPbImageSize() + an.length);
                if (an == null) {
                    com.baidu.tbadk.core.util.t.a(lo2, str, str3, false, isFromCDN, z, 0, "TmpIsNull", lo2.getTimeCost(), sb.toString(), iVar.dVT);
                    return null;
                }
                com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(an), iVar, an, rect, aXe);
                if (a2 != null) {
                    a2.Ue.resourceFromType = "net";
                    a2.Ue.costTime = lo.getTimeCost();
                    a2.Ue.isScuess = true;
                }
                return a2;
            }
        }
        z = false;
        str3 = o;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        an = iVar.an(str3, isFromCDN);
        boolean aXe2 = iVar.aXe();
        Rect rect2 = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.aXd()) {
        }
        if (an != null) {
        }
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z, str, bArr);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.dVY) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, at.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                cVar.ac(this.dWx);
                com.baidu.adp.lib.Disk.d.kh().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.LI = eVar;
                }
            }
        }
        return aVar2;
    }
}
