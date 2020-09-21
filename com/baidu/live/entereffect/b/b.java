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
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b {
    private boolean aOe;
    private com.baidu.live.entereffect.a.a aOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final boolean z, final com.baidu.live.entereffect.a.a aVar, final String str, final String str2, final String str3) {
        new BdAsyncTask<Void, Void, DownloadData>() { // from class: com.baidu.live.entereffect.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: b */
            public DownloadData doInBackground(Void... voidArr) {
                if (aVar == null || TextUtils.isEmpty(aVar.id) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    return null;
                }
                b.this.aOe = z;
                b.this.aOf = aVar;
                if (com.baidu.live.f.a.existFile(str2)) {
                    b.this.gc(str2);
                } else if (!new File(str2).mkdirs()) {
                    return null;
                }
                final String str4 = "enter_effect_" + aVar.id;
                DownloadData downloadData = new DownloadData();
                downloadData.setId("enter_effect_" + aVar.id);
                downloadData.setName(str4);
                downloadData.setUrl(str);
                downloadData.setType(20);
                downloadData.setPath(b.this.ak(str2, str4));
                downloadData.setCallback(new FileDownloadCallBack() { // from class: com.baidu.live.entereffect.b.b.1.1
                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public void onFileUpdateProgress(DownloadData downloadData2) {
                    }

                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public boolean onPreDownload(DownloadData downloadData2) {
                        return true;
                    }

                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public boolean onFileDownloaded(DownloadData downloadData2) {
                        return true;
                    }

                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public void onFileDownloadSucceed(DownloadData downloadData2) {
                        b.this.aj(b.this.ak(str2, str4), str3);
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
                                jSONObject2.put(ETAG.KEY_NET_ERROR, downloadData2.getNetErrorJson());
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
            /* renamed from: a */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new BdAsyncTask<Void, Void, List<String>>() { // from class: com.baidu.live.entereffect.b.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public List<String> doInBackground(Void... voidArr) {
                    List<String> al = b.this.al(str, str2);
                    if (al == null || al.isEmpty()) {
                        b.this.gc(str);
                        b.this.gc(str2);
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            String str3 = "";
                            if (b.this.aOf != null) {
                                str3 = b.this.aOe ? b.this.aOf.videoUrl : b.this.aOf.aNU;
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
                    return al;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: y */
                public void onPostExecute(List<String> list) {
                    super.onPostExecute(list);
                    if (list != null && !list.isEmpty()) {
                        c.Dz().a(b.this.aOe, b.this.aOf, str2, list);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ak(String str, String str2) {
        return str + str2 + ".zip";
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
    public java.util.List<java.lang.String> al(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8b
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L8b
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L8f
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L8f
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L8f
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L8f
            r0 = r1
        L11:
            java.util.zip.ZipEntry r4 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L46
            boolean r5 = r4.isDirectory()     // Catch: java.lang.Throwable -> L36
            if (r5 != 0) goto L11
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L36
            java.lang.String r4 = r6.a(r2, r8, r4)     // Catch: java.lang.Throwable -> L36
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L36
            if (r5 != 0) goto L11
            if (r0 != 0) goto L32
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L36
            r0.<init>()     // Catch: java.lang.Throwable -> L36
        L32:
            r0.add(r4)     // Catch: java.lang.Throwable -> L36
            goto L11
        L36:
            r0 = move-exception
        L37:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L89
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L6e
        L3f:
            if (r3 == 0) goto L44
            r3.close()     // Catch: java.io.IOException -> L6e
        L44:
            r0 = r1
        L45:
            return r0
        L46:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L36
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L36
            com.baidu.live.tbadk.core.util.FileHelper.deleteFile(r4)     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L5e
            boolean r4 = r0.isEmpty()     // Catch: java.lang.Throwable -> L36
            if (r4 != 0) goto L5e
            com.baidu.live.entereffect.b.b$3 r4 = new com.baidu.live.entereffect.b.b$3     // Catch: java.lang.Throwable -> L36
            r4.<init>()     // Catch: java.lang.Throwable -> L36
            java.util.Collections.sort(r0, r4)     // Catch: java.lang.Throwable -> L36
        L5e:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L69
        L63:
            if (r3 == 0) goto L45
            r3.close()     // Catch: java.io.IOException -> L69
            goto L45
        L69:
            r1 = move-exception
            r1.printStackTrace()
            goto L45
        L6e:
            r0 = move-exception
            r0.printStackTrace()
            goto L44
        L73:
            r0 = move-exception
            r2 = r1
            r3 = r1
        L76:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.io.IOException -> L81
        L7b:
            if (r3 == 0) goto L80
            r3.close()     // Catch: java.io.IOException -> L81
        L80:
            throw r0
        L81:
            r1 = move-exception
            r1.printStackTrace()
            goto L80
        L86:
            r0 = move-exception
            r2 = r1
            goto L76
        L89:
            r0 = move-exception
            goto L76
        L8b:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto L37
        L8f:
            r0 = move-exception
            r2 = r1
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.entereffect.b.b.al(java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [371=5, 372=5, 373=5, 375=5, 376=5] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(InputStream inputStream, String str, String str2) {
        String[] split;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (inputStream == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2.contains("/.")) {
            return null;
        }
        try {
            String str3 = str + "/" + (str2.split("/").length > 1 ? split[split.length - 1] : split[0]);
            File file = new File(str3);
            String parent = file.getParent();
            if (!TextUtils.isEmpty(parent)) {
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    if (file.exists() && !file.delete()) {
                        if (0 != 0) {
                            try {
                                fileOutputStream3.flush();
                                fileOutputStream3.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    } else if (!file.createNewFile()) {
                        if (0 != 0) {
                            try {
                                fileOutputStream3.flush();
                                fileOutputStream3.close();
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
                                    return str3;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return str3;
                                }
                            }
                            return str3;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
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
                    fileOutputStream2 = null;
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
    public void gc(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(str));
        }
    }
}
