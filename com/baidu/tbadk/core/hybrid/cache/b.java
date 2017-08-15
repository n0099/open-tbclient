package com.baidu.tbadk.core.hybrid.cache;

import android.text.TextUtils;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class b {
    private static b aeD;
    private c aeE = new c();

    private b() {
    }

    public static b uq() {
        if (aeD == null) {
            synchronized (b.class) {
                if (aeD == null) {
                    aeD = new b();
                }
            }
        }
        return aeD;
    }

    public CacheEntry di(String str) {
        return this.aeE.di(dk(str));
    }

    public synchronized boolean dj(String str) {
        return this.aeE.dj(dk(str));
    }

    public synchronized boolean saveCache(String str, String str2, boolean z, byte[] bArr) {
        boolean z2;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) {
            z2 = false;
        } else {
            String dk = dk(str);
            CacheEntry cacheEntry = new CacheEntry();
            cacheEntry.seteTag(str2);
            cacheEntry.setUrl(dk);
            cacheEntry.setWriteTime(System.currentTimeMillis());
            cacheEntry.setSize(bArr.length);
            cacheEntry.setForever(z);
            if (!TextUtils.isEmpty(str2)) {
                cacheEntry.setName(str2);
            } else {
                cacheEntry.setName(r.aV(dk));
            }
            z2 = this.aeE.a(cacheEntry, bArr);
        }
        return z2;
    }

    private String dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String substring = str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return substring;
    }

    public void ur() {
        File[] listFiles;
        List<CacheEntry> up = a.um().up();
        if (up != null && up.size() != 0) {
            Collections.sort(up, new Comparator<CacheEntry>() { // from class: com.baidu.tbadk.core.hybrid.cache.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(CacheEntry cacheEntry, CacheEntry cacheEntry2) {
                    if (cacheEntry == null && cacheEntry2 == null) {
                        return 0;
                    }
                    if (cacheEntry != null) {
                        if (cacheEntry2 == null) {
                            return -1;
                        }
                        if (cacheEntry.getWriteTime() == cacheEntry2.getWriteTime()) {
                            return 0;
                        }
                        return cacheEntry.getWriteTime() - cacheEntry2.getWriteTime() >= 0 ? -1 : 1;
                    }
                    return 1;
                }
            });
            ArrayList<CacheEntry> arrayList = new ArrayList();
            long j = 0;
            long j2 = 200 * 1048576;
            long j3 = j2 > 31457280 ? j2 : 31457280L;
            for (CacheEntry cacheEntry : up) {
                j += cacheEntry.getSize();
                if (System.currentTimeMillis() - cacheEntry.getWriteTime() > 7776000000L) {
                    arrayList.add(cacheEntry);
                } else if (j >= j3) {
                    arrayList.add(cacheEntry);
                }
            }
            for (CacheEntry cacheEntry2 : arrayList) {
                this.aeE.dj(cacheEntry2.getUrl());
            }
            ArrayList arrayList2 = new ArrayList();
            for (CacheEntry cacheEntry3 : up) {
                arrayList2.add(cacheEntry3.getName());
            }
            File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (!arrayList2.contains(file2.getName())) {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [240=5, 241=5, 242=5] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean us() {
        InputStream inputStream;
        File file;
        byte[] p;
        boolean z;
        boolean z2 = true;
        File file2 = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/temp");
        if (file2.exists() || file2.mkdirs()) {
            InputStream inputStream2 = null;
            try {
                file = new File(file2, "hybridCache.zip");
                inputStream = TbadkCoreApplication.getInst().getAssets().open("hybridCache.zip");
            } catch (IOException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                if (o.a(file, inputStream, false)) {
                    File file3 = new File(file2, "unzips");
                    if (!file3.exists() && !file3.mkdirs()) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return false;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return false;
                            }
                        }
                        return false;
                    } else if (y.c(file, file3.toString())) {
                        File file4 = new File(file3, "config.config");
                        if (file4.isFile() && file4.length() > 0 && (p = o.p(file4)) != null && p.length > 0) {
                            try {
                                JSONArray jSONArray = new JSONArray(new String(p));
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    CacheEntry cacheEntry = new CacheEntry();
                                    cacheEntry.parse(jSONArray.get(i).toString());
                                    arrayList.add(cacheEntry);
                                }
                                File file5 = new File(file3, "files");
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    z = z2;
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    CacheEntry cacheEntry2 = (CacheEntry) it.next();
                                    z2 = !saveCache(cacheEntry2.getUrl(), cacheEntry2.geteTag(), true, o.p(new File(file5, cacheEntry2.getName()))) ? false : z;
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                return z;
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return false;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return false;
                    }
                }
                return false;
            } catch (IOException e6) {
                e = e6;
                inputStream2 = inputStream;
                try {
                    e.printStackTrace();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            return false;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                }
                throw th;
            }
        }
        return false;
    }
}
