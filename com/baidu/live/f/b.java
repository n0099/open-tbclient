package com.baidu.live.f;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.CloseUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.gift.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileDownloadCallBack;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static final Map<String, Integer> aSV = new HashMap();

    public static void a(String str, String str2, final String str3, final String str4, final String str5, String str6, String str7, int i, boolean z) {
        String str8 = str3 + "/" + str6 + ".zip";
        if (TextUtils.isEmpty(str3)) {
            BdLog.w("warning!! download illegal dir");
        } else if (TextUtils.isEmpty(str6)) {
            BdLog.w("warning!! download illegal name");
        } else if (!str3.startsWith(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath())) {
            BdLog.w("warning!! download illegal dir=" + str3 + " name=" + str6);
        } else {
            final DownloadData downloadData = new DownloadData();
            downloadData.setId(str);
            downloadData.setForceDownload(z);
            downloadData.setName(str6);
            downloadData.setUrl(str2);
            downloadData.setCheck(str7);
            downloadData.setType(i);
            downloadData.setPath(str8);
            downloadData.setCallback(new FileDownloadCallBack() { // from class: com.baidu.live.f.b.1
                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (b.aSV != null && downloadData2 != null) {
                        Integer num = (Integer) b.aSV.get(downloadData2.getId());
                        if (num == null) {
                            b.aSV.put(downloadData2.getId(), 10);
                            a(downloadData2);
                        } else if (downloadData2.getProcess() > num.intValue()) {
                            if (num.intValue() < 20) {
                                b.aSV.put(downloadData2.getId(), 20);
                            } else if (num.intValue() < 40) {
                                b.aSV.put(downloadData2.getId(), 40);
                            } else if (num.intValue() < 60) {
                                b.aSV.put(downloadData2.getId(), 60);
                            } else if (num.intValue() < 80) {
                                b.aSV.put(downloadData2.getId(), 80);
                            } else if (num.intValue() < 99) {
                                b.aSV.put(downloadData2.getId(), 99);
                            }
                            a(downloadData2);
                        }
                    }
                }

                private void a(DownloadData downloadData2) {
                    c cVar = new c();
                    cVar.aTa = 7;
                    cVar.aTb = downloadData2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public boolean onPreDownload(DownloadData downloadData2) {
                    if (!com.baidu.live.ac.a.b.Qx().K(downloadData2)) {
                        return false;
                    }
                    c cVar = new c();
                    cVar.aTa = 1;
                    cVar.aTb = downloadData2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
                    return true;
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    c cVar = new c();
                    cVar.aTa = 4;
                    cVar.aTb = downloadData2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
                    if (b.aSV != null) {
                        b.aSV.remove(downloadData2.getId());
                        return true;
                    }
                    return true;
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    BdLog.e("dynamicgift下载成功： " + downloadData2.getUrl());
                    b.a(downloadData2, str4, str5);
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileDownloadFailed(DownloadData downloadData2, int i2, String str9) {
                    int i3 = 3;
                    BdLog.e("dynamicgift下载失败" + i2 + ", " + str9);
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    if (3 == i2) {
                        i3 = 1;
                    } else if (2 == i2) {
                        i3 = 2;
                    } else if (4 != i2) {
                        if (6 == i2) {
                            i3 = 4;
                        } else if (7 != i2) {
                            i3 = 0;
                        } else {
                            i3 = 5;
                        }
                    }
                    try {
                        jSONObject2.put("step_error", i3);
                        jSONObject2.put("down_type", PraiseUBCHelper.SOURCE_DYNAMIC);
                        jSONObject2.put("down_url", downloadData2.getUrl());
                        if (downloadData2.getNetErrorJson() != null) {
                            jSONObject2.put(ETAG.KEY_NET_ERROR, downloadData2.getNetErrorJson());
                        }
                        jSONObject.put("download", jSONObject2);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_RESP, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", "").setContentExt(jSONObject), null, true);
                    c cVar = new c();
                    cVar.aTa = 2;
                    cVar.aTb = downloadData2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
                }
            });
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.live.f.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    a.cleanDir(new File(str3));
                    return true;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("down_type", PraiseUBCHelper.SOURCE_DYNAMIC);
                        jSONObject.put("download", jSONObject2);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_REQ, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", "").setContentExt(jSONObject));
                    FileSerialDownLoader.getInstance().startDownLoadWithoutMax(downloadData);
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final DownloadData downloadData, final String str, final String str2) {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.live.f.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (DownloadData.this.getPath() != null && new File(DownloadData.this.getPath()).exists()) {
                    int ak = b.ak(DownloadData.this.getPath(), str);
                    if (ak == 0) {
                        b.aj(str2, str);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("step_error", ak);
                            jSONObject2.put("down_type", PraiseUBCHelper.SOURCE_DYNAMIC);
                            jSONObject2.put("down_url", DownloadData.this.getUrl());
                            jSONObject.put("download", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_DOWN_RES_RESP, UbcStatConstant.ContentType.UBC_TYPE_RES_DOWN, "liveroom", "").setContentExt(jSONObject), null, true);
                    }
                    return Boolean.valueOf(ak == 0);
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                if (bool.booleanValue()) {
                    if (a.existFile(str)) {
                        u.gA(DownloadData.this.getName());
                        c cVar = new c();
                        cVar.aTa = 5;
                        cVar.aTb = DownloadData.this;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
                        return;
                    }
                    c cVar2 = new c();
                    cVar2.aTa = 6;
                    cVar2.aTb = DownloadData.this;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar2));
                    BdLog.e("zip empty");
                    return;
                }
                BdLog.e("failed to unzip");
            }
        }.execute(new Void[0]);
    }

    public static ArrayList<String> gu(String str) {
        ArrayList<String> arrayList = null;
        String string = d.AZ().getSharedPreferences().getString(str, null);
        if (string == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String str2 = (String) jSONArray.opt(i);
                    if (str2 != null) {
                        arrayList2.add(str2);
                    }
                } catch (JSONException e) {
                    arrayList = arrayList2;
                    e = e;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static boolean b(String str, List<String> list) {
        File[] listFiles;
        if (a.existFile(str)) {
            if (!a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return true;
            } else if (list == null || list.size() <= 0 || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
                return true;
            } else {
                for (File file : listFiles) {
                    if (!file.isDirectory() && !list.contains(a.getFileMd5(file))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aj(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!StringUtils.isNull(str2) && (listFiles = new File(str2).listFiles()) != null) {
            JSONArray jSONArray = new JSONArray();
            for (File file : listFiles) {
                if (file != null && !file.isDirectory() && (fileMd5 = a.getFileMd5(file)) != null) {
                    jSONArray.put(fileMd5);
                }
            }
            d.AZ().putString(str, jSONArray.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ak(String str, String str2) {
        ZipInputStream zipInputStream;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            if (!nextEntry.isDirectory()) {
                                saveFile(str2, nextEntry.getName(), zipInputStream);
                            }
                        } else {
                            zipInputStream.close();
                            FileHelper.deleteFile(new File(str));
                            CloseUtil.close((InputStream) zipInputStream);
                            return 0;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        CloseUtil.close((InputStream) zipInputStream);
                        return 4;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        CloseUtil.close((InputStream) zipInputStream);
                        return 5;
                    }
                }
            } catch (Throwable th) {
                th = th;
                CloseUtil.close((InputStream) null);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            zipInputStream = null;
        } catch (IOException e4) {
            e = e4;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CloseUtil.close((InputStream) null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [492=4] */
    private static String saveFile(String str, String str2, InputStream inputStream) {
        String str3;
        FileOutputStream fileOutputStream;
        if (inputStream == null || StringUtils.isNull(str2)) {
            return null;
        }
        if (str2.contains("/.")) {
            return null;
        }
        try {
            String[] split = str2.split("/");
            str3 = split.length > 1 ? split[split.length - 1] : split[0];
        } catch (Exception e) {
            e.printStackTrace();
            str3 = str2;
        }
        if (!a.existFile(str)) {
            new File(str).mkdirs();
        }
        File file = new File(str + "/" + str3);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        try {
            if (file.exists() && !file.delete()) {
                CloseUtil.close((OutputStream) null);
                return null;
            } else if (!file.createNewFile()) {
                CloseUtil.close((OutputStream) null);
                return null;
            } else {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                fileOutputStream.flush();
                                String path = file.getPath();
                                CloseUtil.close((OutputStream) fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaInitialize.file(e, "FileHelper.saveFile " + str + "/" + str3);
                        CloseUtil.close((OutputStream) fileOutputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    CloseUtil.close((OutputStream) fileOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            CloseUtil.close((OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static void dT(int i) {
        FileSerialDownLoader.getInstance().cancelDownloadByType(i);
        if (aSV != null) {
            aSV.clear();
        }
    }
}
