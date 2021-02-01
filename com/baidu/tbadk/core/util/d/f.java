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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public class f extends a {
    private boolean akO;
    private boolean fcT;
    private int procType;

    public f(boolean z, int i, boolean z2) {
        this.akO = true;
        this.procType = 0;
        this.fcT = true;
        this.akO = z;
        this.procType = i;
        this.fcT = z2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btn() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bto() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.akO;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btp() {
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
        com.baidu.adp.lib.Disk.ops.c Bq = Bq(aw.getNameMd5FromUrl(str2));
        if (Bq == null) {
            return null;
        }
        Bq.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Bq.setSdCard(false);
        Bq.setSubFolder(true);
        Bq.setSavedCache(true);
        Bq.setIsFormatData(false);
        Bq.setLock(bArr);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(Bq);
            bVar.Nl = dVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (com.baidu.adp.lib.Disk.d.lg().c(Bq)) {
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
            return Bq.isSuccess() ? b(Bq, str2, i, i2) : null;
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
        byte[] aw;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int btn = i == 0 ? btn() : i;
        int bto = i2 == 0 ? bto() : i2;
        if (btn == 0) {
            btn = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        if (bto == 0) {
            bto = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String p = isFromCDN ? str : p(str, btn, bto);
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
                    bVar.Nl = iVar;
                }
                aw = iVar.aw(str3, isFromCDN);
                boolean btj = iVar.btj();
                if (!iVar.bti()) {
                    if (iVar.responseCode == 302 && (17 == btp() || 18 == btp() || 13 == btp() || 14 == btp())) {
                        if (iVar.fcr != null) {
                            u.a(str, false, str3, Boolean.valueOf(z), iVar.fcr, "redirect", System.currentTimeMillis() - currentTimeMillis, iVar.btl(), btp());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            boolean z2 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(f);
                            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z2, str, f);
                            aVar.setNeedCache(btj);
                            a(str2, f, Boolean.valueOf(btj), Boolean.valueOf(iVar.fcw), Boolean.valueOf(z2), bVar);
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return aVar;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.lV().MD) {
                        u.a(str, false, str3, Boolean.valueOf(z), iVar.fcr, "NetworkError", System.currentTimeMillis() - currentTimeMillis, iVar.btl(), btp());
                        return null;
                    }
                }
                if (aw != null) {
                    if (!iVar.lV().MD) {
                        u.a(str, false, str3, Boolean.valueOf(z), iVar.fcr, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, iVar.btl(), btp());
                    }
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (aw.length > 1) {
                    g.btr().u(aw.length, currentTimeMillis2);
                    u.a(str, true, str3, Boolean.valueOf(z), iVar.fcr, "InputToByteSucc", currentTimeMillis2, iVar.btl(), btp());
                } else {
                    u.a(str, false, str3, Boolean.valueOf(z), iVar.fcr, "bytes<1", currentTimeMillis2, iVar.btl(), btp());
                }
                com.baidu.tbadk.imageManager.c.bCP().freePicCache(TbConfig.getPbImageSize() + aw.length);
                boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(aw);
                com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a((Bitmap) null, z3, str, aw);
                aVar2.setNeedCache(btj);
                a(str2, aw, Boolean.valueOf(btj), Boolean.valueOf(iVar.fcw), Boolean.valueOf(z3), bVar);
                return aVar2;
            }
        }
        z = false;
        str3 = p;
        iVar = new com.baidu.tbadk.core.util.b.i();
        if (bVar != null) {
        }
        aw = iVar.aw(str3, isFromCDN);
        boolean btj2 = iVar.btj();
        if (!iVar.bti()) {
        }
        if (aw != null) {
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public void a(String str, byte[] bArr, Object... objArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(booleanValue3);
                cVar.Z(this.fcT);
                com.baidu.adp.lib.Disk.d.lg().c(cVar);
                com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.Nl = dVar;
                }
            }
        }
    }
}
