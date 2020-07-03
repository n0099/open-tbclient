package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileDownloadCallBack;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b {
    private boolean aFF;
    private com.baidu.live.entereffect.a.a aFG;

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
                b.this.aFF = z;
                b.this.aFG = aVar;
                if (com.baidu.live.f.a.existFile(str2)) {
                    b.this.eD(str2);
                } else if (!new File(str2).mkdirs()) {
                    return null;
                }
                final String str4 = "enter_effect_" + aVar.id;
                DownloadData downloadData = new DownloadData();
                downloadData.setId("enter_effect_" + aVar.id);
                downloadData.setName(str4);
                downloadData.setUrl(str);
                downloadData.setType(20);
                downloadData.setPath(b.this.ah(str2, str4));
                downloadData.setCallback(new FileDownloadCallBack() { // from class: com.baidu.live.entereffect.b.b.1.1
                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public void onFileUpdateProgress(DownloadData downloadData2) {
                    }

                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public boolean onPreDownload(DownloadData downloadData2) {
                        return BdNetTypeUtil.isWifiNet();
                    }

                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public boolean onFileDownloaded(DownloadData downloadData2) {
                        return true;
                    }

                    @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                    public void onFileDownloadSucceed(DownloadData downloadData2) {
                        b.this.ag(b.this.ah(str2, str4), str3);
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
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_RESP, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", null).setContentExt(jSONObject), null, true);
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
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_REQ, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", null).setContentExt(jSONObject));
                    FileSerialDownLoader.getInstance().startDownLoadWithoutMax(downloadData);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new BdAsyncTask<Void, Void, List<String>>() { // from class: com.baidu.live.entereffect.b.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: c */
                public List<String> doInBackground(Void... voidArr) {
                    List<String> ai = b.this.ai(str, str2);
                    if (ai == null || ai.isEmpty()) {
                        b.this.eD(str);
                        b.this.eD(str2);
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            String str3 = "";
                            if (b.this.aFG != null) {
                                str3 = b.this.aFF ? b.this.aFG.videoUrl : b.this.aFG.aFv;
                            }
                            jSONObject2.put("step_error", 6);
                            jSONObject2.put("down_type", UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST);
                            jSONObject2.put("down_url", str3);
                            jSONObject.put("download", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_RESP, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", null).setContentExt(jSONObject), null, true);
                    }
                    return ai;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: v */
                public void onPostExecute(List<String> list) {
                    super.onPostExecute(list);
                    if (list != null && !list.isEmpty()) {
                        c.xd().a(b.this.aFF, b.this.aFG, str2, list);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ah(String str, String str2) {
        return str + str2 + ".zip";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=4, 299=4, 301=4, 302=4, 304=4, 305=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public List<String> ai(String str, String str2) {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream2;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            zipInputStream2 = null;
            fileInputStream = null;
        } catch (IOException e2) {
            e = e2;
            zipInputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
            fileInputStream = null;
        }
        try {
            zipInputStream2 = new ZipInputStream(new BufferedInputStream(fileInputStream));
            ArrayList arrayList = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        String a = a(zipInputStream2, str2, nextEntry.getName());
                        if (!TextUtils.isEmpty(a)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(a);
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (zipInputStream2 != null) {
                        try {
                            zipInputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (zipInputStream2 != null) {
                        try {
                            zipInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            }
            FileHelper.deleteFile(new File(str));
            if (arrayList != null && !arrayList.isEmpty()) {
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.baidu.live.entereffect.b.b.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(String str3, String str4) {
                        return str3.compareTo(str4);
                    }
                });
            }
            if (zipInputStream2 != null) {
                try {
                    zipInputStream2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return arrayList;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
                return arrayList;
            }
            return arrayList;
        } catch (FileNotFoundException e8) {
            e = e8;
            zipInputStream2 = null;
        } catch (IOException e9) {
            e = e9;
            zipInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                    throw th;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [374=5, 375=5, 376=5, 378=5, 379=5] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            String str3 = str + (str2.split("/").length > 1 ? split[split.length - 1] : split[0]);
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
    public void eD(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(str));
        }
    }
}
