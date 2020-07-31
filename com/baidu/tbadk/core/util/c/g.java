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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public class g extends a {
    private boolean aib;
    private boolean ecS;
    private int procType;

    public g(boolean z, int i, boolean z2) {
        this.aib = true;
        this.procType = 0;
        this.ecS = true;
        this.aib = z;
        this.procType = i;
        this.ecS = z2;
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
        return this.aib;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bbl() {
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
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.u.lo();
        lo.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c yc = yc(au.getNameMd5FromUrl(str2));
        if (yc == null) {
            return null;
        }
        yc.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        yc.setSdCard(false);
        yc.setSubFolder(true);
        yc.setSavedCache(true);
        yc.setIsFormatData(false);
        yc.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(yc);
            aVar.LH = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.kh().c(yc)) {
            com.baidu.tbadk.core.util.u.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
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
        if (!yc.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = b(yc, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(lo, str2, true, lo.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.u.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.TY.resourceFromType = "disk";
            aVar2.TY.costTime = lo.getTimeCost();
            aVar2.TY.isScuess = true;
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
    /* JADX WARN: Removed duplicated region for block: B:63:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01eb  */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] am;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.u.lo();
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
                    aVar.LH = iVar;
                }
                am = iVar.am(str3, isFromCDN);
                boolean bbf = iVar.bbf();
                Rect rect = new Rect();
                StringBuilder sb = new StringBuilder(100);
                if (!iVar.bbe()) {
                    if (iVar.responseCode == 302 && (17 == bbl() || 18 == bbl() || 13 == bbl() || 14 == bbl())) {
                        if (iVar.eco != null) {
                            com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "redirect", lo.getTimeCost(), iVar.bbh(), 0L, bbl());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, bbf);
                            if (a != null) {
                                a.TY.resourceFromType = "net";
                                a.TY.costTime = lo.getTimeCost();
                                a.TY.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.kU().Le) {
                        long j = 0;
                        if (am != null) {
                            j = am.length;
                        }
                        com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "NetworkError", lo.getTimeCost(), iVar.bbh(), j, bbl());
                        return null;
                    }
                }
                if (am != null) {
                    if (!iVar.kU().Le) {
                        com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "ByteIsNull", lo.getTimeCost(), iVar.bbh(), 0L, bbl());
                    }
                    return null;
                }
                if (am.length > 1) {
                    k.bbn().t(am.length, lo.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(lo, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "InputToByteSucc", lo.getTimeCost(), iVar.bbh(), am.length, bbl());
                } else {
                    com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "bytes<1", lo.getTimeCost(), iVar.bbh(), am.length, bbl());
                }
                com.baidu.adp.lib.stats.a lo2 = com.baidu.tbadk.core.util.u.lo();
                lo2.startTimer();
                com.baidu.tbadk.imageManager.c.bkk().freePicCache(TbConfig.getPbImageSize() + am.length);
                if (am == null) {
                    com.baidu.tbadk.core.util.u.a(lo2, str, str3, false, isFromCDN, z, 0, "TmpIsNull", lo2.getTimeCost(), sb.toString(), iVar.eco);
                    return null;
                }
                com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(am), iVar, am, rect, bbf);
                if (a2 != null) {
                    a2.TY.resourceFromType = "net";
                    a2.TY.costTime = lo.getTimeCost();
                    a2.TY.isScuess = true;
                }
                return a2;
            }
        }
        z = false;
        str3 = o;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        am = iVar.am(str3, isFromCDN);
        boolean bbf2 = iVar.bbf();
        Rect rect2 = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.bbe()) {
        }
        if (am != null) {
        }
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z, str, bArr);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.ect) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                cVar.ac(this.ecS);
                com.baidu.adp.lib.Disk.d.kh().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.LH = eVar;
                }
            }
        }
        return aVar2;
    }
}
