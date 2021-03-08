package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileDownloadCallBack;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b {
    private boolean aWb;
    private com.baidu.live.entereffect.a.a aWc;
    private String aWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final boolean z, final com.baidu.live.entereffect.a.a aVar, final String str, final String str2, final String str3, final boolean z2) {
        if (!d(aVar.id, str, z2)) {
            new BdAsyncTask<Void, Void, DownloadData>() { // from class: com.baidu.live.entereffect.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public DownloadData doInBackground(Void... voidArr) {
                    if (aVar == null || TextUtils.isEmpty(aVar.id) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                        return null;
                    }
                    b.this.aWb = z;
                    b.this.aWc = aVar;
                    b.this.aWd = str;
                    if (com.baidu.live.h.a.existFile(str2)) {
                        b.this.fN(str2);
                    }
                    final String str4 = aVar.id;
                    DownloadData downloadData = new DownloadData();
                    downloadData.setId(aVar.id);
                    downloadData.setForceDownload(z2);
                    downloadData.setName(str4);
                    downloadData.setUrl(str);
                    downloadData.setType(20);
                    downloadData.setPath(b.this.aq(str2, str4));
                    downloadData.setPriority(128);
                    downloadData.setCallback(new FileDownloadCallBack() { // from class: com.baidu.live.entereffect.b.b.1.1
                        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                        public void onFileUpdateProgress(DownloadData downloadData2) {
                        }

                        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                        public boolean onPreDownload(DownloadData downloadData2) {
                            return com.baidu.live.storage.opt.b.Rj().I(downloadData2);
                        }

                        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                        public boolean onFileDownloaded(DownloadData downloadData2) {
                            return true;
                        }

                        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                        public void onFileDownloadSucceed(DownloadData downloadData2) {
                            b.this.ap(b.this.aq(str2, str4), str3);
                        }

                        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                        public void onFileDownloadFailed(DownloadData downloadData2, int i, String str5) {
                            int i2 = 2;
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            if (3 == i) {
                                i2 = 1;
                            } else if (2 != i) {
                                if (4 == i) {
                                    i2 = 3;
                                } else if (6 == i) {
                                    i2 = 4;
                                } else if (7 != i) {
                                    i2 = 0;
                                } else {
                                    i2 = 5;
                                }
                            }
                            try {
                                jSONObject2.put("step_error", i2);
                                jSONObject2.put("down_type", UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST);
                                jSONObject2.put("down_url", downloadData2.getUrl());
                                if (downloadData2.getNetErrorJson() != null) {
                                    jSONObject2.put("net_error", downloadData2.getNetErrorJson());
                                }
                                jSONObject.put("download", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_RESP, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", "").setContentExt(jSONObject), null, true);
                        }
                    });
                    return downloadData;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public void onPostExecute(DownloadData downloadData) {
                    super.onPostExecute(downloadData);
                    if (downloadData != null) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("down_type", UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST);
                            jSONObject.put("download", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_REQ, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", "").setContentExt(jSONObject));
                        FileSerialDownLoader.getInstance().startDownLoadWithoutMax(downloadData);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    private boolean d(String str, String str2, boolean z) {
        DownloadData downloadData;
        int i = 0;
        if (FileSerialDownLoader.getInstance().isDownloading(str, str2, 20)) {
            if (z) {
                List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
                if (downloadList == null || downloadList.isEmpty()) {
                    return true;
                }
                Iterator<DownloadData> it = downloadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        downloadData = null;
                        break;
                    }
                    DownloadData next = it.next();
                    if (next != null && 20 == next.getType() && next.getId().equals(str) && next.getUrl().equals(str2)) {
                        next.setPriority(383);
                        it.remove();
                        downloadData = next;
                        break;
                    }
                }
                if (downloadData == null) {
                    return true;
                }
                if (!downloadList.isEmpty()) {
                    while (i < downloadList.size()) {
                        if (downloadData.getPriority() >= downloadList.get(i).getPriority()) {
                            break;
                        }
                        i++;
                    }
                }
                i = -1;
                if (i >= 0) {
                    downloadList.add(i, downloadData);
                } else {
                    downloadList.add(downloadData);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.b>>() { // from class: com.baidu.live.entereffect.b.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public List<com.baidu.live.entereffect.a.b> doInBackground(Void... voidArr) {
                    List<com.baidu.live.entereffect.a.b> ar = b.this.ar(str, str2);
                    if (ar == null || ar.isEmpty()) {
                        b.this.fN(str);
                        b.this.fN(str2);
                        l.F(b.this.aWc == null ? "" : b.this.aWc.id, b.this.aWd, "unZip result null");
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            String str3 = "";
                            if (b.this.aWc != null) {
                                str3 = b.this.aWb ? b.this.aWc.videoUrl : b.this.aWc.aVN;
                            }
                            jSONObject2.put("step_error", 6);
                            jSONObject2.put("down_type", UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST);
                            jSONObject2.put("down_url", str3);
                            jSONObject.put("download", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_RESP, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", "").setContentExt(jSONObject), null, true);
                    }
                    return ar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: B */
                public void onPostExecute(List<com.baidu.live.entereffect.a.b> list) {
                    super.onPostExecute(list);
                    if (list != null && !list.isEmpty()) {
                        c.Dc().a(b.this.aWb, b.this.aWc, str2, list);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2) {
        return str + "/" + str2 + ".zip";
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List<com.baidu.live.entereffect.a.b> ar(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb7
            r3.<init>(r8)     // Catch: java.lang.Throwable -> Lb7
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Lbb
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Lbb
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Lbb
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lbb
            r0 = r1
        L11:
            java.util.zip.ZipEntry r4 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L6d
            boolean r5 = r4.isDirectory()     // Catch: java.lang.Throwable -> L4d
            if (r5 != 0) goto L11
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L4d
            java.io.File r4 = r7.b(r2, r9, r4)     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L11
            java.lang.String r5 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L4d
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4d
            if (r5 != 0) goto L11
            if (r0 != 0) goto L38
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
        L38:
            com.baidu.live.entereffect.a.b r5 = new com.baidu.live.entereffect.a.b     // Catch: java.lang.Throwable -> L4d
            r5.<init>()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L4d
            r5.path = r6     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = com.baidu.live.h.a.getFileMd5(r4)     // Catch: java.lang.Throwable -> L4d
            r5.md5 = r4     // Catch: java.lang.Throwable -> L4d
            r0.add(r5)     // Catch: java.lang.Throwable -> L4d
            goto L11
        L4d:
            r0 = move-exception
        L4e:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb5
            com.baidu.live.entereffect.a.a r4 = r7.aWc     // Catch: java.lang.Throwable -> Lb5
            if (r4 != 0) goto L95
            java.lang.String r4 = ""
        L58:
            java.lang.String r5 = r7.aWd     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> Lb5
            com.baidu.live.utils.l.F(r4, r5, r0)     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L9a
        L66:
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.io.IOException -> L9a
        L6b:
            r0 = r1
        L6c:
            return r0
        L6d:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L4d
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L4d
            com.baidu.live.tbadk.core.util.FileHelper.deleteFile(r4)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L85
            boolean r4 = r0.isEmpty()     // Catch: java.lang.Throwable -> L4d
            if (r4 != 0) goto L85
            com.baidu.live.entereffect.b.b$3 r4 = new com.baidu.live.entereffect.b.b$3     // Catch: java.lang.Throwable -> L4d
            r4.<init>()     // Catch: java.lang.Throwable -> L4d
            java.util.Collections.sort(r0, r4)     // Catch: java.lang.Throwable -> L4d
        L85:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.io.IOException -> L90
        L8a:
            if (r3 == 0) goto L6c
            r3.close()     // Catch: java.io.IOException -> L90
            goto L6c
        L90:
            r1 = move-exception
            r1.printStackTrace()
            goto L6c
        L95:
            com.baidu.live.entereffect.a.a r4 = r7.aWc     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = r4.id     // Catch: java.lang.Throwable -> Lb5
            goto L58
        L9a:
            r0 = move-exception
            r0.printStackTrace()
            goto L6b
        L9f:
            r0 = move-exception
            r2 = r1
            r3 = r1
        La2:
            if (r2 == 0) goto La7
            r2.close()     // Catch: java.io.IOException -> Lad
        La7:
            if (r3 == 0) goto Lac
            r3.close()     // Catch: java.io.IOException -> Lad
        Lac:
            throw r0
        Lad:
            r1 = move-exception
            r1.printStackTrace()
            goto Lac
        Lb2:
            r0 = move-exception
            r2 = r1
            goto La2
        Lb5:
            r0 = move-exception
            goto La2
        Lb7:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto L4e
        Lbb:
            r0 = move-exception
            r2 = r1
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.entereffect.b.b.ar(java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [442=5, 443=5, 444=5, 446=5, 447=5] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File b(InputStream inputStream, String str, String str2) {
        String[] split;
        FileOutputStream fileOutputStream;
        if (inputStream == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2.contains("/.")) {
            return null;
        }
        try {
            File file = new File(str + "/" + (str2.split("/").length > 1 ? split[split.length - 1] : split[0]));
            String parent = file.getParent();
            if (!TextUtils.isEmpty(parent)) {
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (file.exists() && !file.delete()) {
                        if (0 != 0) {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    } else if (!file.createNewFile()) {
                        if (0 != 0) {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } else {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    return file;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return file;
                                }
                            }
                            return file;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            l.G(this.aWc == null ? "" : this.aWc.id, this.aWd, e.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.h.a.cleanDir(new File(str));
        }
    }
}
