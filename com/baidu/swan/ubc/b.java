package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class b {
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar, boolean z) {
        File file;
        FileOutputStream fileOutputStream;
        File file2 = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!TextUtils.isEmpty(iVar.getFileName())) {
            File file3 = new File(file2, "proc");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            file = new File(file3, iVar.getFileName());
        } else {
            file = new File(file2, z ? "filereal" : "filedata");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", iVar.getId());
            jSONObject.put("timestamp", iVar.getTime());
            jSONObject.put("eventType", "0");
            if (!TextUtils.isEmpty(iVar.getContent())) {
                jSONObject.put("content", iVar.getContent());
            } else if (iVar.aNt() != null) {
                jSONObject.put("content", iVar.aNt().toString());
            }
            if (!TextUtils.isEmpty(iVar.aNs())) {
                jSONObject.put("abtest", iVar.aNs());
            }
            if (!TextUtils.isEmpty(iVar.getCategory())) {
                jSONObject.put("c", iVar.getCategory());
            }
            if (iVar.aNo()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", d.aNb().uV(iVar.getId()));
        } catch (JSONException e) {
        }
        byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                try {
                    fileOutputStream.write(encode);
                    fileOutputStream.write("\n".getBytes());
                    fileOutputStream.flush();
                    com.baidu.swan.d.d.closeSafely(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    com.baidu.swan.d.d.closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.d.d.closeSafely(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.swan.d.d.closeSafely(fileOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(v vVar, boolean z) {
        BufferedReader bufferedReader;
        boolean z2 = false;
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file.exists()) {
            file.mkdir();
        }
        if (!z) {
            z2 = b(vVar);
        }
        File file2 = new File(file, z ? "filereal" : "filedata");
        if (file2.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                long j = Long.MAX_VALUE;
                long j2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                        if (jSONObject.has("abtest")) {
                            vVar.vg("1");
                        }
                        long j3 = jSONObject.getLong("timestamp");
                        if (j3 > 0) {
                            if (j3 < j) {
                                j = j3;
                            }
                            if (j3 > j2) {
                                j2 = j3;
                            }
                        }
                        vVar.cK(jSONObject);
                        z2 = true;
                    } catch (Exception e) {
                        com.baidu.swan.d.d.closeSafely(bufferedReader);
                        return z2;
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.swan.d.d.closeSafely(bufferedReader);
                        throw th;
                    }
                }
                vVar.t(j, j2);
                com.baidu.swan.d.d.closeSafely(bufferedReader);
            } catch (Exception e2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
        return z2;
    }

    private boolean b(v vVar) {
        File[] listFiles;
        BufferedReader bufferedReader;
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcdir", "proc");
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                int i = 0;
                long j = Long.MAX_VALUE;
                long j2 = 0;
                do {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                vVar.vg("1");
                            }
                            long j3 = jSONObject.getLong("timestamp");
                            if (j3 > 0) {
                                if (j3 < j) {
                                    j = j3;
                                }
                                if (j3 > j2) {
                                    j2 = j3;
                                }
                            }
                            vVar.cK(jSONObject);
                            i++;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.swan.d.d.closeSafely(bufferedReader);
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.swan.d.d.closeSafely(bufferedReader);
                        throw th;
                    }
                } while (i < 10);
                vVar.t(j, j2);
                com.baidu.swan.d.d.closeSafely(bufferedReader);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gL(boolean z) {
        File[] listFiles;
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (file.exists()) {
            File file2 = new File(file, z ? "filereal" : "filedata");
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(file, "proc");
            if (file3.exists() && file3.isDirectory() && (listFiles = file3.listFiles()) != null && listFiles.length != 0) {
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }
}
