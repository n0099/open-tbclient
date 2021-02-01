package b.a.a.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
/* loaded from: classes15.dex */
final class ak extends Handler {
    private FileOutputStream Bp;
    private BufferedOutputStream Bq;
    private StringBuffer Br;
    private /* synthetic */ ai Bs;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f1056a;

    /* renamed from: b  reason: collision with root package name */
    private File f1057b;
    private SimpleDateFormat f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, Looper looper) {
        super(looper);
        this.Bs = aiVar;
        this.f1056a = new byte[0];
        this.f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    }

    private String a(w wVar, Location location, List list, List list2) {
        int size = list != null ? list.size() : 0;
        int size2 = list2 != null ? list2.size() : 0;
        if (size == 0 && size2 == 0) {
            return "";
        }
        x xVar = wVar.AW;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb.append(0).append(",").append(String.format("%.6f", Double.valueOf(location.getLatitude()))).append(",").append(String.format("%.6f", Double.valueOf(location.getLongitude()))).append(",").append((int) location.getAltitude()).append(",").append((int) location.getAccuracy()).append(",").append((int) location.getBearing()).append(",").append(String.format("%.1f", Float.valueOf(location.getSpeed()))).append(",").append(location.getTime());
        if (list2 != null && list2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list2.size()) {
                    break;
                }
                z zVar = (z) list2.get(i2);
                sb2.append(i2 == 0 ? "" : ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR).append(zVar.f1085b).append(",").append(zVar.c).append(",").append(zVar.d).append(",").append(zVar.e).append(",").append(zVar.f);
                i = i2 + 1;
            }
        }
        if (list != null && list.size() > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                ScanResult scanResult = (ScanResult) list.get(i4);
                sb3.append(i4 == 0 ? "" : ETAG.ITEM_SEPARATOR).append(scanResult.BSSID.replaceAll(":", "").toLowerCase()).append(ETAG.ITEM_SEPARATOR).append(scanResult.level);
                i3 = i4 + 1;
            }
        }
        StringBuilder sb4 = new StringBuilder();
        String a2 = j.a(wVar.f1081a);
        if (a2 != null && a2.length() > 5) {
            try {
                JSONObject jSONObject = new JSONObject(a2);
                sb4.append(jSONObject.optString("mac").replaceAll(":", "").toLowerCase()).append(ETAG.ITEM_SEPARATOR).append(jSONObject.optString("ssid")).append(ETAG.ITEM_SEPARATOR).append(jSONObject.optString("rssi"));
            } catch (Throwable th) {
                sb4.setLength(0);
            }
            if (sb4.length() < 5) {
                sb4.setLength(0);
            }
        }
        String str = Build.MANUFACTURER.replaceAll("[| _]", "") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.MODEL.replaceAll("[| _]", "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[").append(this.f.format(new Date())).append("]:").append(x.b()).append("|209|").append(xVar.i()).append("|||||||||").append((CharSequence) sb).append("||").append((CharSequence) sb2).append("|").append((CharSequence) sb3).append("||||||||||||||||sdk_lite").append("||||").append((CharSequence) sb4).append("|||").append(xVar.c.replaceAll("[| _]", "") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + xVar.f1082a).append("|||").append(str);
        return sb5.toString();
    }

    private void a() {
        if (this.Br == null || this.Br.length() == 0 || this.Bq == null) {
            return;
        }
        byte[] a2 = a(this.Br.toString());
        this.Br.setLength(0);
        if (a2.length != 0) {
            try {
                this.Bq.write(a2);
            } catch (Throwable th) {
                this.f1057b = null;
                ai.b(this.Bq);
                ai.b(this.Bp);
            }
        }
    }

    private void a(int i) {
        byte[] bArr;
        aa aaVar;
        af afVar;
        List list;
        String str;
        w wVar;
        w wVar2;
        bArr = this.Bs.i;
        synchronized (bArr) {
            aaVar = this.Bs.Bn;
            afVar = this.Bs.Bm;
            list = this.Bs.j;
        }
        synchronized (this.f1056a) {
            b();
            if (i == 2) {
                wVar2 = this.Bs.Bk;
                str = a(wVar2, aaVar.f1049b, null, list);
            } else if (i == 1) {
                List unmodifiableList = afVar != null ? Collections.unmodifiableList(afVar.f1053b) : null;
                wVar = this.Bs.Bk;
                str = a(wVar, aaVar.f1049b, unmodifiableList, list);
            } else {
                str = "";
            }
            if (this.Bq == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (this.Br == null) {
                this.Br = new StringBuffer((int) LokiService.Constant.MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER);
            }
            this.Br.append(str).append("\n");
            if (this.Br.length() > 25600 || (this.f1057b != null && this.f1057b.length() == 0)) {
                a();
                if (this.f1057b.length() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    this.Bs.a(5);
                }
            }
            new StringBuilder("write:").append(str.substring(0, 60)).append("***");
        }
    }

    private void a(long j) {
        w wVar;
        try {
            wVar = this.Bs.Bk;
            wVar.AZ.edit().putLong("fc_lite_create", j).apply();
        } catch (Throwable th) {
        }
    }

    private static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            byte[] a2 = l.a(a(str.getBytes("GBK")), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
            if (a2 != null && a2.length != 0) {
                bArr = new byte[a2.length + 2];
                int length = a2.length;
                byte[] bArr2 = new byte[2];
                for (int i = 0; i < 2; i++) {
                    bArr2[i] = Integer.valueOf(length & 255).byteValue();
                    length >>= 8;
                }
                System.arraycopy(bArr2, 0, bArr, 0, 2);
                System.arraycopy(a2, 0, bArr, 2, a2.length);
            }
        } catch (Throwable th) {
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th) {
            return bArr2;
        }
    }

    private void b() {
        if (this.f1057b == null || !this.f1057b.exists() || this.Bq == null || !"fclite".equals(this.f1057b.getName())) {
            this.f1057b = d();
            try {
                boolean exists = this.f1057b.exists();
                this.Bp = new FileOutputStream(this.f1057b, true);
                this.Bq = new BufferedOutputStream(this.Bp, 1024);
                if (exists) {
                    return;
                }
                a(System.currentTimeMillis());
            } catch (Throwable th) {
            }
        }
    }

    private void c() {
        File file;
        file = this.Bs.c;
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (File file2 : listFiles) {
            if (file2.isFile() && file2.exists() && file2.getName().startsWith("fclite_") && (currentTimeMillis - file2.lastModified() > BdKVCache.MILLS_30Days || file2.length() == 0)) {
                new StringBuilder("delete expired file:").append(file2.getName());
                file2.delete();
            }
        }
    }

    private File d() {
        File file;
        file = this.Bs.c;
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "fclite");
    }

    private long e() {
        w wVar;
        try {
            wVar = this.Bs.Bk;
            return wVar.AZ.getLong("fc_lite_create", 0L);
        } catch (Throwable th) {
            return 0L;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        File file;
        File file2;
        switch (message.what) {
            case 1:
            case 2:
            case 16:
                try {
                    a(message.what);
                    return;
                } catch (Throwable th) {
                    return;
                }
            case 3:
                try {
                    if (this.Bq != null) {
                        this.Bq.flush();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    this.f1057b = null;
                    ai.b(this.Bq);
                    ai.b(this.Bp);
                    return;
                }
            case 4:
                try {
                    a();
                    if (this.Br != null) {
                        this.Br.setLength(0);
                    }
                    this.f1057b = null;
                    ai.b(this.Bq);
                    ai.b(this.Bp);
                    return;
                } catch (Throwable th3) {
                    this.f1057b = null;
                    ai.b(this.Bq);
                    ai.b(this.Bp);
                    return;
                }
            case 5:
                b();
                file = this.Bs.c;
                if (file == null || this.f1057b == null || !this.f1057b.exists()) {
                    return;
                }
                a();
                if (this.f1057b.length() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT || System.currentTimeMillis() - e() > Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    try {
                        if (this.f1057b == null || this.f1057b.length() < 1024) {
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        file2 = this.Bs.c;
                        File file3 = new File(file2, "fclite_".concat(String.valueOf(currentTimeMillis)));
                        this.f1057b.renameTo(file3);
                        new StringBuilder("rename:").append(this.f1057b.getName()).append(" to ").append(file3.getName());
                        ai.b(this.Bq);
                        ai.b(this.Bp);
                        this.f1057b = null;
                        this.Bq = null;
                        c();
                        a(0L);
                        return;
                    } catch (Throwable th4) {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
