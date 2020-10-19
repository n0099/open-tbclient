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
    private boolean akj;
    private boolean eBk;
    private int procType;

    public g(boolean z, int i, boolean z2) {
        this.akj = true;
        this.procType = 0;
        this.eBk = true;
        this.akj = z;
        this.procType = i;
        this.eBk = z2;
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
        return this.akj;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bnn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bno() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bnp() {
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
        com.baidu.adp.lib.Disk.ops.c Bz = Bz(av.getNameMd5FromUrl(str2));
        if (Bz == null) {
            return null;
        }
        Bz.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Bz.setSdCard(false);
        Bz.setSubFolder(true);
        Bz.setSavedCache(true);
        Bz.setIsFormatData(false);
        Bz.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(Bz);
            aVar.MR = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.lL().c(Bz)) {
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
        if (!Bz.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = b(Bz, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(mT, str2, true, mT.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.u.a(mT, str2, false, mT.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.Vm.resourceFromType = "disk";
            aVar2.Vm.costTime = mT.getTimeCost();
            aVar2.Vm.isScuess = true;
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
        byte[] au;
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
        String n = isFromCDN ? str : n(str, width, height);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = n.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = n.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = n.lastIndexOf(".jpg")) > 0) {
                z = true;
                str3 = n.substring(0, lastIndexOf) + ".webp" + n.substring(lastIndexOf + 4, n.length());
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.MR = iVar;
                }
                au = iVar.au(str3, isFromCDN);
                boolean bnj = iVar.bnj();
                Rect rect = new Rect();
                StringBuilder sb = new StringBuilder(100);
                if (!iVar.bni()) {
                    if (iVar.responseCode == 302 && (17 == bnp() || 18 == bnp() || 13 == bnp() || 14 == bnp())) {
                        if (iVar.eAG != null) {
                            com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "redirect", mT.getTimeCost(), iVar.bnl(), 0L, bnp());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, bnj);
                            if (a2 != null) {
                                a2.Vm.resourceFromType = "net";
                                a2.Vm.costTime = mT.getTimeCost();
                                a2.Vm.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a2;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.my().Mn) {
                        long j = 0;
                        if (au != null) {
                            j = au.length;
                        }
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "NetworkError", mT.getTimeCost(), iVar.bnl(), j, bnp());
                        return null;
                    }
                }
                if (au != null) {
                    if (!iVar.my().Mn) {
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "ByteIsNull", mT.getTimeCost(), iVar.bnl(), 0L, bnp());
                    }
                    return null;
                }
                if (au.length > 1) {
                    k.bnr().u(au.length, mT.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(mT, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "InputToByteSucc", mT.getTimeCost(), iVar.bnl(), au.length, bnp());
                } else {
                    com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "bytes<1", mT.getTimeCost(), iVar.bnl(), au.length, bnp());
                }
                com.baidu.adp.lib.stats.a mT2 = com.baidu.tbadk.core.util.u.mT();
                mT2.startTimer();
                com.baidu.tbadk.imageManager.c.bwL().freePicCache(TbConfig.getPbImageSize() + au.length);
                if (au == null) {
                    com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z, 0, "TmpIsNull", mT2.getTimeCost(), sb.toString(), iVar.eAG);
                    return null;
                }
                com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, iVar.isGif || com.baidu.adp.lib.util.l.isGif(au), iVar, au, rect, bnj);
                if (a3 != null) {
                    a3.Vm.resourceFromType = "net";
                    a3.Vm.costTime = mT.getTimeCost();
                    a3.Vm.isScuess = true;
                }
                return a3;
            }
        }
        z = false;
        str3 = n;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        au = iVar.au(str3, isFromCDN);
        boolean bnj2 = iVar.bnj();
        Rect rect2 = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.bni()) {
        }
        if (au != null) {
        }
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z, str, bArr);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.eAL) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                cVar.ac(this.eBk);
                com.baidu.adp.lib.Disk.d.lL().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.MR = eVar;
                }
            }
        }
        return aVar2;
    }
}
