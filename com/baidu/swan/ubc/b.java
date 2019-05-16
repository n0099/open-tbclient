package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b {
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [123=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(h hVar, boolean z) {
        File file;
        FileOutputStream fileOutputStream;
        File file2 = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (TextUtils.isEmpty(hVar.getFileName())) {
            file = new File(file2, z ? "filereal" : "filedata");
        } else {
            File file3 = new File(file2, "proc");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            file = new File(file3, hVar.getFileName());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", hVar.getId());
            jSONObject.put("timestamp", hVar.getTime());
            jSONObject.put("eventType", "0");
            if (!TextUtils.isEmpty(hVar.getContent())) {
                jSONObject.put("content", hVar.getContent());
            } else if (hVar.WX() != null) {
                jSONObject.put("content", hVar.WX().toString());
            }
            if (!TextUtils.isEmpty(hVar.WW())) {
                jSONObject.put(ImageViewerConfig.ABTEST, hVar.WW());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                jSONObject.put("c", hVar.getCategory());
            }
            if (hVar.WS()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", d.WI().kM(hVar.getId()));
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
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [186=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(v vVar, boolean z) {
        BufferedReader bufferedReader;
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file.exists()) {
            file.mkdir();
        }
        boolean b = z ? false : b(vVar);
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
                        if (jSONObject.has(ImageViewerConfig.ABTEST)) {
                            vVar.kV("1");
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
                        vVar.aU(jSONObject);
                        b = true;
                    } catch (Exception e) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                            }
                        }
                        return b;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th;
                    }
                }
                vVar.g(j, j2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Exception e5) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
        return b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [254=4] */
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
                            if (jSONObject.has(ImageViewerConfig.ABTEST)) {
                                vVar.kV("1");
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
                            vVar.aU(jSONObject);
                            i++;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } while (i < 10);
                vVar.g(j, j2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dk(boolean z) {
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
