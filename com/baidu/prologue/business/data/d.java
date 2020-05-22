package com.baidu.prologue.business.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.a.c.e;
import com.baidu.prologue.a.c.g;
import com.baidu.prologue.a.c.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private static a bzQ;

    public static File aI(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str2 == null) {
            return null;
        }
        stringBuffer.append(str2);
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf("/");
        if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
            return null;
        }
        stringBuffer.append(str.substring(lastIndexOf));
        return new File(Od(), stringBuffer.toString());
    }

    public static File Od() {
        File file = new File(com.baidu.prologue.a.b.b.getAppContext().getFilesDir(), "splash");
        file.mkdirs();
        return file;
    }

    public static File Oe() {
        return new File(Od(), "splash.dat");
    }

    public static File gB(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(".tmp");
        return new File(Od(), stringBuffer.toString());
    }

    public static void c(final e eVar) {
        final String str = eVar.url;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https")) {
                final File aI = aI(eVar.url, eVar.md5);
                if (!aI.exists()) {
                    final File gB = gB(eVar.md5);
                    if (gB.exists()) {
                        gB.delete();
                    }
                    com.baidu.prologue.service.network.a.execute(new Runnable() { // from class: com.baidu.prologue.business.data.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.baidu.prologue.a.c.e.a(gB, str, new e.a() { // from class: com.baidu.prologue.business.data.d.1.1
                                    @Override // com.baidu.prologue.a.c.e.a
                                    public void NR() {
                                        if (!g.o(gB).equals(eVar.md5)) {
                                            if (d.DEBUG) {
                                                Log.d("SourceManager", "md5 check fail  url:" + eVar.url);
                                                return;
                                            }
                                            return;
                                        }
                                        d.c(gB, aI);
                                    }
                                });
                            } finally {
                                gB.delete();
                            }
                        }
                    }, "download splash resource");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2) {
        return file.renameTo(file2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(List<e> list) {
        a(list, Oe());
    }

    public static void d(e eVar) {
        ArrayList arrayList = new ArrayList();
        File Oe = Oe();
        List<e> Og = Og();
        if (Og != null && Og.size() != 0) {
            if (DEBUG) {
                Log.d("SourceManager", "updateSplashDataItem--->getSplashDataItemList:" + Og.size());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < Og.size()) {
                    e eVar2 = Og.get(i2);
                    if (TextUtils.equals(eVar.id, eVar2.id)) {
                        e.a(eVar2, eVar);
                        arrayList.add(eVar2);
                    } else {
                        arrayList.add(eVar2);
                    }
                    i = i2 + 1;
                } else {
                    a(arrayList, Oe);
                    return;
                }
            }
        }
    }

    public static void e(final e eVar) {
        if (eVar.bAf >= 1) {
            if (eVar.bAg < Integer.MAX_VALUE) {
                eVar.bAg++;
            }
            com.baidu.prologue.service.network.a.execute(new Runnable() { // from class: com.baidu.prologue.business.data.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.d(e.this);
                }
            }, "updateSplashDataItemRate");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Of() {
        com.baidu.prologue.a.c.e.n(Od());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [311=4] */
    public static boolean a(List<e> list, File file) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        if (DEBUG) {
            Log.d("SourceManager", "persistListToFile size:" + list.size());
        }
        try {
            if (list.size() <= 0) {
                return false;
            }
            try {
                e[] eVarArr = (e[]) list.toArray(new e[list.size() - 1]);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                int length = eVarArr.length;
                for (int i = 0; i < length - 1; i++) {
                    stringBuffer.append(eVarArr[i].Ok()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuffer.append(eVarArr[length - 1].Ok());
                stringBuffer.append("]");
                if (DEBUG) {
                    Log.d("SourceManager", "persistListToFile:" + stringBuffer.toString());
                }
                fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(stringBuffer.toString());
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                                e.printStackTrace();
                            }
                        }
                    }
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.d("SourceManager", "persistListToFile() Exception e: ");
                        e.printStackTrace();
                    }
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e3) {
                            if (DEBUG) {
                                Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                                e3.printStackTrace();
                            }
                        }
                    }
                    return true;
                }
            } catch (IOException e4) {
                e = e4;
                fileWriter = null;
            } catch (Throwable th) {
                th = th;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception e5) {
                        if (DEBUG) {
                            Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                            e5.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = null;
        }
    }

    public static List<e> Og() {
        String p;
        ArrayList arrayList = new ArrayList();
        File Oe = Oe();
        if (Oe.exists() && (p = p(Oe)) != null) {
            if (DEBUG) {
                Log.d("SourceManager", "from local content:" + p);
            }
            try {
                JSONArray jSONArray = new JSONArray(p);
                if (DEBUG) {
                    Log.d("SourceManager", "JSONArray" + jSONArray.length());
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    arrayList.add(e.V((JSONObject) jSONArray.get(i2)));
                    i = i2 + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("SourceManager", "from local splashDataItemList:" + arrayList.size());
            }
            return arrayList;
        }
        return null;
    }

    public static HashMap<String, e> Oh() {
        HashMap<String, e> hashMap = new HashMap<>();
        File Oe = Oe();
        if (!Oe.exists()) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(p(Oe));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                e V = e.V((JSONObject) jSONArray.get(i2));
                hashMap.put(V.id, V);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [412=4] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String p(File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                if (DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        return sb.toString();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        if (DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                        if (DEBUG) {
                            e4.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return sb.toString();
    }

    public static void S(final List<e> list) {
        com.baidu.prologue.service.network.a.execute(new Runnable() { // from class: com.baidu.prologue.business.data.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.DEBUG) {
                    Log.d("SourceManager", "SourceManager scheduleDownloadSplashSource");
                }
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList(3);
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        e eVar = (e) it.next();
                        if (eVar == null) {
                            if (d.DEBUG) {
                                Log.d("SourceManager", "SourceManager scheduleDownloadSplashSource() dataItem == null");
                            }
                        } else if (h.dQ(eVar.preloadType)) {
                            d.c(eVar);
                        } else {
                            arrayList.add(eVar);
                        }
                    }
                    if (arrayList.size() > 0) {
                        if (d.bzQ == null) {
                            a unused = d.bzQ = new a(arrayList);
                            com.baidu.prologue.a.b.a.bzx.get().Nt().registerReceiver(d.bzQ, d.bzQ.getIntentFilter());
                            return;
                        }
                        d.bzQ.setNeedDownloadList(arrayList);
                    }
                }
            }
        }, "ScheduleDownloadSplashSourceThread");
    }

    public static int f(e eVar) {
        int i = 0;
        if (!eVar.bAh) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long lastShowTime = f.getLastShowTime();
            i = (currentTimeMillis < eVar.start || currentTimeMillis > eVar.end) ? 2 : 2;
            if (eVar.bAg >= eVar.bAf && eVar.bAf >= 1) {
                i |= 8;
            }
            if (currentTimeMillis - lastShowTime < eVar.bAe * 60000) {
                i |= 16;
            }
            if (eVar.advisible == 0) {
                i |= 32;
                if (DEBUG) {
                    throw new IllegalStateException("空订单有ukey了 ～～～～～");
                }
            }
            File aI = aI(eVar.url, eVar.md5);
            if (aI == null || !aI.exists()) {
                i |= 4;
            }
            if (DEBUG) {
                Log.d("SourceManager", "物料不满足展示条件 reason ：" + i);
            }
        }
        return i;
    }

    /* loaded from: classes6.dex */
    private static class a extends BroadcastReceiver {
        private List<e> mNeedDownloadList;

        private a(List<e> list) {
            this.mNeedDownloadList = list;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d("SourceManager", "onReceive: receiver");
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                ArrayList arrayList = new ArrayList();
                for (e eVar : this.mNeedDownloadList) {
                    if (h.dQ(eVar.preloadType)) {
                        Log.d("SourceManager", "onReceive: " + eVar);
                        d.c(eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }

        public IntentFilter getIntentFilter() {
            return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        }

        public List<e> getNeedDownloadList() {
            return this.mNeedDownloadList;
        }

        public void setNeedDownloadList(List<e> list) {
            this.mNeedDownloadList = list;
        }
    }
}
