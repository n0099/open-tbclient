package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.Bitmap;
import com.baidu.adp.lib.a.f;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class d extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object a(String str, com.baidu.tbadk.core.util.b bVar) {
        return com.baidu.tbadk.imageManager.e.a().c(bVar.a(str));
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        if (eVar.g) {
            String f = be.f(str);
            String str2 = bVar.f != null ? String.valueOf(f) + bVar.f : f;
            String a = bVar.a(str);
            synchronized (g.a) {
                if (str2 != null) {
                    if (eVar.d == 5) {
                        Bitmap a2 = com.baidu.tbadk.core.a.a.a(a);
                        if (a2 != null) {
                            eVar.e = a2;
                        }
                    } else {
                        int d = bd.a().d(str2);
                        if (d > 0) {
                            com.baidu.tbadk.imageManager.e.a().c(d);
                            eVar.e = bd.a().b(str2);
                            if (eVar.e != null) {
                                s<String> A = com.baidu.tbadk.core.a.b.a().A();
                                if (A != null && "gif".equals(A.a(a))) {
                                    eVar.h = true;
                                }
                                if (!eVar.h) {
                                    eVar.h = bd.a().c(str2);
                                }
                            }
                        }
                    }
                }
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.e == null) {
                    return null;
                }
                eVar.i = new com.baidu.adp.widget.a.a(eVar.e, eVar.h, str);
                com.baidu.tbadk.imageManager.e.a().b(a, eVar.i);
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.i != null) {
                    dVar.a(eVar);
                }
                eVar.f = true;
                return eVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        String f;
        int i;
        int i2;
        String sb;
        boolean z;
        String str2;
        Bitmap a;
        int lastIndexOf;
        if (str == null || str.length() == 0) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_URL_IS_NULL, "url is null", "");
            return null;
        }
        int i3 = eVar.d;
        w wVar = new w();
        wVar.a("url", str);
        String f2 = bVar.f != null ? String.valueOf(f) + bVar.f : be.f(str);
        wVar.a("name", f2);
        if (bVar.b == 0) {
            i = k.a(bVar.a, 105.0f);
        } else {
            i = bVar.b;
        }
        if (bVar.c == 0) {
            i2 = k.a(bVar.a, 105.0f);
        } else {
            i2 = bVar.c;
        }
        wVar.a("picW", Integer.valueOf(i));
        wVar.a("picH", Integer.valueOf(i2));
        boolean e = bVar.e();
        if (e) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(TbConfig.IMAGE_ADDRESS);
            sb2.append("src=");
            sb2.append(be.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bf.a().d());
            sb2.append("&first_gif=1");
            if (bVar.e) {
                sb2.append("&ispv=1");
            }
            if (bVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        if (!(TbadkApplication.m252getInst().getCapabilityOfWebp() && f.a().b("webp_enable") == 1) || sb.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = sb.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str2 = sb;
        } else {
            str2 = String.valueOf(sb.substring(0, lastIndexOf)) + ".webp" + sb.substring(lastIndexOf + 4, sb.length());
            z = true;
        }
        wVar.a("fullUrl", str2);
        eVar.a = new com.baidu.tbadk.core.util.a.e();
        if (bVar.h != null && !e) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= bVar.h.size()) {
                    break;
                }
                eVar.a.a(bVar.h.get(i5));
                i4 = i5 + 1;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a2 = eVar.a.a(str2, !e);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (!eVar.a.b()) {
            a(TbErrInfo.PIC_REQUEST_FAIL, bVar, eVar, wVar, e, str2, currentTimeMillis2);
            return null;
        } else if (a2 == null) {
            a(TbErrInfo.PIC_NOT_RESULT, bVar, eVar, wVar, e, str2, currentTimeMillis2);
            return null;
        } else if (eVar.n) {
            return null;
        } else {
            String a3 = bVar.a(str);
            if (eVar.n) {
                return null;
            }
            com.baidu.tbadk.imageManager.e.a().c(TbConfig.getPbImageSize() + a2.length);
            eVar.e = g.a(a2);
            eVar.j = a2;
            if (z && eVar.e == null) {
                BdLog.e("Webp decoding failed: " + str2);
                TiebaStatic.imgError(eVar.a.a, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str2);
                TbadkApplication.m252getInst().incWebpFailureCount();
                byte[] a4 = eVar.a.a(sb, !e);
                if (a4 != null && eVar.a.b()) {
                    eVar.e = g.a(a4);
                    eVar.j = a4;
                }
            }
            if (eVar.e == null) {
                a(TbErrInfo.PIC_CONVERT_ERR, bVar, eVar, wVar, e, str2, currentTimeMillis2);
                return null;
            }
            eVar.h = eVar.a.d || k.a(a2);
            if (eVar.n) {
                return null;
            }
            if (eVar.e.getWidth() > i || eVar.e.getHeight() > i2) {
                BdLog.e(getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(eVar.e.getWidth()) + "*" + String.valueOf(eVar.e.getHeight())));
                com.baidu.tbadk.imageManager.e.a().c(g.a(eVar.e) * 2);
                eVar.e = g.a(eVar.e, i, i2, true);
            }
            if (eVar.n) {
                return null;
            }
            if (i3 == 4) {
                com.baidu.tbadk.imageManager.e.a().c(g.a(eVar.e) * 2);
                eVar.e = g.a(eVar.e, 7.0f, true);
            }
            if (eVar.n) {
                return null;
            }
            if (eVar.p && (a = aw.a().a(eVar.e, eVar.p, true, f2)) != null) {
                eVar.e = a;
            }
            eVar.i = new com.baidu.adp.widget.a.a(eVar.e, eVar.h, str);
            com.baidu.tbadk.imageManager.e.a().b(a3, eVar.i);
            if (eVar.n) {
                return null;
            }
            dVar.a(eVar);
            if (eVar.n) {
                return null;
            }
            eVar.k = f2;
            eVar.l = a3;
            eVar.m = wVar.toString();
            eVar.f = false;
            return eVar.i;
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar, w wVar, boolean z, String str, long j) {
    }
}
