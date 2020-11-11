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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public class g extends a {
    private boolean akk;
    private boolean ePv;
    private int procType;

    public g(boolean z, int i, boolean z2) {
        this.akk = true;
        this.procType = 0;
        this.ePv = true;
        this.akk = z;
        this.procType = i;
        this.ePv = z2;
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
        return this.akk;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brG() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int brI() {
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
        com.baidu.adp.lib.stats.a mT = com.baidu.tbadk.core.util.u.mT();
        mT.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Cg = Cg(av.getNameMd5FromUrl(str2));
        if (Cg == null) {
            return null;
        }
        Cg.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Cg.setSdCard(false);
        Cg.setSubFolder(true);
        Cg.setSavedCache(true);
        Cg.setIsFormatData(false);
        Cg.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(Cg);
            aVar.MS = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.lL().c(Cg)) {
            com.baidu.tbadk.core.util.u.a(mT, str2, false, mT.getTimeCost(), isWifiNet);
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
        if (!Cg.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = b(Cg, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(mT, str2, true, mT.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.u.a(mT, str2, false, mT.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.Vn.resourceFromType = "disk";
            aVar2.Vn.costTime = mT.getTimeCost();
            aVar2.Vn.isScuess = true;
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
        byte[] aw;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a mT = com.baidu.tbadk.core.util.u.mT();
        mT.startTimer();
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
                    aVar.MS = iVar;
                }
                aw = iVar.aw(str3, isFromCDN);
                boolean brC = iVar.brC();
                Rect rect = new Rect();
                StringBuilder sb = new StringBuilder(100);
                if (!iVar.brB()) {
                    if (iVar.responseCode == 302 && (17 == brI() || 18 == brI() || 13 == brI() || 14 == brI())) {
                        if (iVar.eOR != null) {
                            com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eOR, "redirect", mT.getTimeCost(), iVar.brE(), 0L, brI());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, brC);
                            if (a2 != null) {
                                a2.Vn.resourceFromType = "net";
                                a2.Vn.costTime = mT.getTimeCost();
                                a2.Vn.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a2;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.my().Mo) {
                        long j = 0;
                        if (aw != null) {
                            j = aw.length;
                        }
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eOR, "NetworkError", mT.getTimeCost(), iVar.brE(), j, brI());
                        return null;
                    }
                }
                if (aw != null) {
                    if (!iVar.my().Mo) {
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eOR, "ByteIsNull", mT.getTimeCost(), iVar.brE(), 0L, brI());
                    }
                    return null;
                }
                if (aw.length > 1) {
                    k.brK().t(aw.length, mT.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(mT, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eOR, "InputToByteSucc", mT.getTimeCost(), iVar.brE(), aw.length, brI());
                } else {
                    com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eOR, "bytes<1", mT.getTimeCost(), iVar.brE(), aw.length, brI());
                }
                com.baidu.adp.lib.stats.a mT2 = com.baidu.tbadk.core.util.u.mT();
                mT2.startTimer();
                com.baidu.tbadk.imageManager.c.bBd().freePicCache(TbConfig.getPbImageSize() + aw.length);
                if (aw == null) {
                    com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z, 0, "TmpIsNull", mT2.getTimeCost(), sb.toString(), iVar.eOR);
                    return null;
                }
                com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(aw), iVar, aw, rect, brC);
                if (a3 != null) {
                    a3.Vn.resourceFromType = "net";
                    a3.Vn.costTime = mT.getTimeCost();
                    a3.Vn.isScuess = true;
                }
                return a3;
            }
        }
        z = false;
        str3 = o;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        aw = iVar.aw(str3, isFromCDN);
        boolean brC2 = iVar.brC();
        Rect rect2 = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.brB()) {
        }
        if (aw != null) {
        }
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z, str, bArr);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.eOW) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                cVar.ac(this.ePv);
                com.baidu.adp.lib.Disk.d.lL().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.MS = eVar;
                }
            }
        }
        return aVar2;
    }
}
