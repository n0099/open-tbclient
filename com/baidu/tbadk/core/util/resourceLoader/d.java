package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.Bitmap;
import com.baidu.adp.lib.a.f;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public final class d extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object a(String str, com.baidu.tbadk.core.util.b bVar) {
        return com.baidu.tbadk.imageManager.e.a().c(bVar.a(str));
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        if (eVar.g) {
            String f = bc.f(str);
            String str2 = bVar.f != null ? String.valueOf(f) + bVar.f : f;
            String a = bVar.a(str);
            synchronized (g.a) {
                if (str2 != null) {
                    if (eVar.d == 5) {
                        Bitmap a2 = com.baidu.tbadk.core.c.a.a(a);
                        if (a2 != null) {
                            eVar.e = a2;
                        }
                    } else {
                        int c = bb.a().c(str2);
                        if (c > 0) {
                            com.baidu.tbadk.imageManager.e.a().b(c);
                            eVar.e = bb.a().a(str2);
                            if (eVar.e != null) {
                                s<String> x = com.baidu.tbadk.core.c.b.a().x();
                                if (x != null && "gif".equals(x.a(a))) {
                                    eVar.h = true;
                                }
                                if (!eVar.h) {
                                    eVar.h = bb.a().b(str2);
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
                eVar.i = new com.baidu.adp.widget.ImageView.b(eVar.e, eVar.h, str);
                com.baidu.tbadk.imageManager.e.a().d(a, eVar.i);
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.i != null) {
                    dVar.d(eVar);
                }
                eVar.f = true;
                return eVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        String f;
        int i;
        int i2;
        String sb;
        boolean z;
        String str2;
        Bitmap a;
        int lastIndexOf;
        if (str == null || str.length() == 0) {
            TiebaStatic.a("", -1003, "url is null", "");
            return null;
        }
        int i3 = eVar.d;
        v vVar = new v();
        vVar.a("url", str);
        String f2 = bVar.f != null ? String.valueOf(f) + bVar.f : bc.f(str);
        vVar.a("name", f2);
        if (bVar.b == 0) {
            i = i.a(bVar.a, 105.0f);
        } else {
            i = bVar.b;
        }
        if (bVar.c == 0) {
            i2 = i.a(bVar.a, 105.0f);
        } else {
            i2 = bVar.c;
        }
        vVar.a("picW", Integer.valueOf(i));
        vVar.a("picH", Integer.valueOf(i2));
        boolean d = bVar.d();
        if (d) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(n.d);
            sb2.append("src=");
            sb2.append(bc.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bd.a().d());
            sb2.append("&first_gif=1");
            if (bVar.e) {
                sb2.append("&ispv=1");
            }
            if (bVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        if (!(TbadkApplication.j().aw() && f.a().b("webp_enable") == 1) || sb.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = sb.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str2 = sb;
        } else {
            str2 = String.valueOf(sb.substring(0, lastIndexOf)) + ".webp" + sb.substring(lastIndexOf + 4, sb.length());
            z = true;
        }
        vVar.a("fullUrl", str2);
        eVar.a = new com.baidu.tbadk.core.util.a.e();
        if (bVar.h != null && !d) {
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
        byte[] a2 = eVar.a.a(str2, !d);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (!eVar.a.a()) {
            a(-1117, eVar, vVar, d, str2, currentTimeMillis2);
            return null;
        } else if (a2 == null) {
            a(-1115, eVar, vVar, d, str2, currentTimeMillis2);
            return null;
        } else if (eVar.n) {
            return null;
        } else {
            if (d) {
                h.a().a(System.currentTimeMillis() - currentTimeMillis);
            }
            String a3 = bVar.a(str);
            if (eVar.n) {
                return null;
            }
            com.baidu.tbadk.imageManager.e.a().b(n.h() + a2.length);
            eVar.e = g.a(a2);
            eVar.j = a2;
            if (z && eVar.e == null) {
                com.baidu.adp.lib.util.f.b("Webp decoding failed: " + str2);
                TiebaStatic.a(eVar.a.a, -1012, "Webp decoding failed.", str2);
                TbadkApplication.j().ax();
                byte[] a4 = eVar.a.a(sb, !d);
                if (a4 != null && eVar.a.a()) {
                    eVar.e = g.a(a4);
                    eVar.j = a4;
                }
            }
            if (eVar.e == null) {
                a(-1116, eVar, vVar, d, str2, currentTimeMillis2);
                return null;
            }
            eVar.h = eVar.a.d || i.a(a2);
            if (eVar.n) {
                return null;
            }
            if (eVar.e.getWidth() > i || eVar.e.getHeight() > i2) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(eVar.e.getWidth()) + "*" + String.valueOf(eVar.e.getHeight())));
                com.baidu.tbadk.imageManager.e.a().b(g.a(eVar.e) * 2);
                eVar.e = g.a(eVar.e, i, i2, true);
            }
            if (eVar.n) {
                return null;
            }
            if (i3 == 4) {
                com.baidu.tbadk.imageManager.e.a().b(g.a(eVar.e) * 2);
                eVar.e = g.a(eVar.e, 7.0f, true);
            }
            if (eVar.n) {
                return null;
            }
            if (eVar.p && (a = av.a().a(eVar.e, eVar.p, true, f2)) != null) {
                eVar.e = a;
            }
            eVar.i = new com.baidu.adp.widget.ImageView.b(eVar.e, eVar.h, str);
            com.baidu.tbadk.imageManager.e.a().d(a3, eVar.i);
            if (eVar.n) {
                return null;
            }
            dVar.d(eVar);
            if (eVar.n) {
                return null;
            }
            eVar.k = f2;
            eVar.l = a3;
            eVar.m = vVar.toString();
            eVar.f = false;
            return eVar.i;
        }
    }

    private static void a(int i, com.baidu.tbadk.core.util.e eVar, v vVar, boolean z, String str, long j) {
        int indexOf;
        String str2;
        String str3;
        boolean a = com.baidu.adp.lib.network.willdelete.h.a();
        String a2 = m.a();
        v vVar2 = new v();
        vVar2.a("IS_CDN", Boolean.valueOf(z));
        vVar2.a("isWIFI", Integer.valueOf(a ? 1 : 0));
        vVar2.a("local_ip", a2);
        if (str.indexOf("hiphotos.baidu.com") <= 0) {
            str2 = "";
            str3 = "";
        } else {
            str3 = String.valueOf(str.substring(0, indexOf).replace(com.baidu.loginshare.e.f, "")) + "hiphotos.baidu.com";
            str2 = UtilHelper.b(str3);
        }
        vVar2.a("tiebaIp", UtilHelper.b("tieba.baidu.com"));
        vVar2.a("host", str3);
        vVar2.a("cdnip", str2);
        vVar2.a("isGzip", eVar.a.c ? "1" : "0");
        vVar2.a("image_datasize", Integer.valueOf(eVar.a.f));
        vVar2.a("image_exception", eVar.a.e);
        vVar2.a("responseCode", Integer.valueOf(eVar.a.g));
        vVar2.a("pic_request_network_cost", Long.valueOf(j));
        vVar2.a(vVar);
        TiebaStatic.a(eVar.a.a, i, eVar.a.e, vVar2.toString());
        if (z) {
            for (int i2 = 0; i2 < eVar.a.b.size(); i2++) {
                h.a().a(eVar.a.b.get(i2).intValue());
            }
            h.a().a(eVar.a.g);
        }
    }
}
