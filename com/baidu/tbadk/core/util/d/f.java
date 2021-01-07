package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
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
public class f extends a {
    private boolean alQ;
    private boolean ffm;
    private int procType;

    public f(boolean z, int i, boolean z2) {
        this.alQ = true;
        this.procType = 0;
        this.ffm = true;
        this.alQ = z;
        this.procType = i;
        this.ffm = z2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwN() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwO() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.alQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwP() {
        return this.procType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Ck = Ck(av.getNameMd5FromUrl(str2));
        if (Ck == null) {
            return null;
        }
        Ck.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Ck.setSdCard(false);
        Ck.setSubFolder(true);
        Ck.setSavedCache(true);
        Ck.setIsFormatData(false);
        Ck.setLock(bArr);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(Ck);
            bVar.Np = dVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (com.baidu.adp.lib.Disk.d.lh().c(Ck)) {
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
            return Ck.isSuccess() ? b(Ck, str2, i, i2) : null;
        }
        return null;
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
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c3  */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.b.i iVar;
        byte[] ax;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int bwN = i == 0 ? bwN() : i;
        int bwO = i2 == 0 ? bwO() : i2;
        if (bwN == 0) {
            bwN = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        if (bwO == 0) {
            bwO = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String p = isFromCDN ? str : p(str, bwN, bwO);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = p.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = p.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = p.lastIndexOf(".jpg")) > 0) {
                z = true;
                str3 = p.substring(0, lastIndexOf) + ".webp" + p.substring(lastIndexOf + 4, p.length());
                iVar = new com.baidu.tbadk.core.util.b.i();
                if (bVar != null) {
                    bVar.Np = iVar;
                }
                ax = iVar.ax(str3, isFromCDN);
                boolean bwJ = iVar.bwJ();
                if (!iVar.bwI()) {
                    if (iVar.responseCode == 302 && (17 == bwP() || 18 == bwP() || 13 == bwP() || 14 == bwP())) {
                        if (iVar.feK != null) {
                            com.baidu.tbadk.core.util.t.a(str, false, str3, Boolean.valueOf(z), iVar.feK, "redirect", System.currentTimeMillis() - currentTimeMillis, iVar.bwL(), bwP());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            boolean z2 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(f);
                            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z2, str, f);
                            aVar.setNeedCache(bwJ);
                            a(str2, f, Boolean.valueOf(bwJ), Boolean.valueOf(iVar.feP), Boolean.valueOf(z2), bVar);
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return aVar;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.lW().MH) {
                        com.baidu.tbadk.core.util.t.a(str, false, str3, Boolean.valueOf(z), iVar.feK, "NetworkError", System.currentTimeMillis() - currentTimeMillis, iVar.bwL(), bwP());
                        return null;
                    }
                }
                if (ax != null) {
                    if (!iVar.lW().MH) {
                        com.baidu.tbadk.core.util.t.a(str, false, str3, Boolean.valueOf(z), iVar.feK, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, iVar.bwL(), bwP());
                    }
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (ax.length > 1) {
                    g.bwR().t(ax.length, currentTimeMillis2);
                    com.baidu.tbadk.core.util.t.a(str, true, str3, Boolean.valueOf(z), iVar.feK, "InputToByteSucc", currentTimeMillis2, iVar.bwL(), bwP());
                } else {
                    com.baidu.tbadk.core.util.t.a(str, false, str3, Boolean.valueOf(z), iVar.feK, "bytes<1", currentTimeMillis2, iVar.bwL(), bwP());
                }
                com.baidu.tbadk.imageManager.c.bGq().freePicCache(TbConfig.getPbImageSize() + ax.length);
                boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(ax);
                com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z3, str, ax);
                aVar2.setNeedCache(bwJ);
                a(str2, ax, Boolean.valueOf(bwJ), Boolean.valueOf(iVar.feP), Boolean.valueOf(z3), bVar);
                return aVar2;
            }
        }
        z = false;
        str3 = p;
        iVar = new com.baidu.tbadk.core.util.b.i();
        if (bVar != null) {
        }
        ax = iVar.ax(str3, isFromCDN);
        boolean bwJ2 = iVar.bwJ();
        if (!iVar.bwI()) {
        }
        if (ax != null) {
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public void a(String str, byte[] bArr, Object... objArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(booleanValue3);
                cVar.Z(this.ffm);
                com.baidu.adp.lib.Disk.d.lh().c(cVar);
                com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.Np = dVar;
                }
            }
        }
    }
}
