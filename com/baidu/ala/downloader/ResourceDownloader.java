package com.baidu.ala.downloader;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import d.a.c.e.p.j;
import d.a.j0.v.c;
import d.a.j0.v.d;
import java.io.File;
import java.util.Vector;
/* loaded from: classes.dex */
public class ResourceDownloader {
    public static Vector<String> sResDownloadingTaskList;

    public static void addDownloadingResId(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (sResDownloadingTaskList == null) {
            sResDownloadingTaskList = new Vector<>();
        }
        synchronized (sResDownloadingTaskList) {
            sResDownloadingTaskList.add(str);
        }
    }

    public static boolean checkAndDownloadResZip(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        if (StringUtils.isNull(str3) || StringUtils.isNull(str2) || StringUtils.isNull(str6)) {
            return false;
        }
        if (DownloaderHelper.checkDirFiles(str4, DownloaderHelper.getAllFileMd5Set(str5 + str3))) {
            if (!DownloaderHelper.existFile(str4)) {
                new File(str4).mkdirs();
            }
            realDownloadResZip(str, str2, str3, str4, str5, str6, z);
            return true;
        }
        return false;
    }

    public static void checkAndDownloadResZipInMainThread(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final boolean z) {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.ala.downloader.ResourceDownloader.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                ResourceDownloader.checkAndDownloadResZip(str, str2, str3, str4, str5, str6, z);
                return null;
            }
        }.execute(new String[0]);
    }

    public static boolean checkDirNeedToDownload(String str, String str2) {
        return DownloaderHelper.checkDirFiles(str, DownloaderHelper.getAllFileMd5Set(str2));
    }

    public static boolean isResZipDownloading(String str) {
        boolean contains;
        if (ListUtils.isEmpty(sResDownloadingTaskList) || StringUtils.isNull(str)) {
            return false;
        }
        synchronized (sResDownloadingTaskList) {
            contains = sResDownloadingTaskList.contains(str);
        }
        return contains;
    }

    public static void realDownloadResZip(final String str, String str2, String str3, final String str4, String str5, String str6, final boolean z) {
        if (j.H() || z) {
            final String str7 = str5 + str3;
            final String str8 = str4 + "/" + str3 + ".zip";
            final DownloadData downloadData = new DownloadData();
            downloadData.setId(str);
            downloadData.setName(str3);
            downloadData.setUrl(str2);
            downloadData.setCheck(str6);
            downloadData.setType(19);
            downloadData.setCallback(new c() { // from class: com.baidu.ala.downloader.ResourceDownloader.2
                @Override // d.a.j0.v.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i2, String str9) {
                    ResourceDownloader.removeDownloadingResId(downloadData2.getId());
                    ResourceDownloader.sendDownloadStatusMessage(5, downloadData2);
                    BdLog.e("failed to donwload dynamic zip" + str9);
                }

                @Override // d.a.j0.v.c
                public void onFileDownloadSucceed(final DownloadData downloadData2) {
                    new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.ala.downloader.ResourceDownloader.2.1
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onCancelled() {
                            super.onCancelled();
                            ResourceDownloader.removeDownloadingResId(downloadData2.getId());
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public Boolean doInBackground(Void... voidArr) {
                            if (downloadData2.getPath() == null) {
                                return Boolean.FALSE;
                            }
                            if (!new File(downloadData2.getPath()).exists()) {
                                return Boolean.FALSE;
                            }
                            boolean unZipFile = DownloaderHelper.unZipFile(downloadData2.getPath(), str4);
                            if (unZipFile) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                DownloaderHelper.saveAllFileMd5ToSharePreference(str7, str4);
                                ResourceDownloader.sendDownloadStatusMessage(4, downloadData2);
                            }
                            return Boolean.valueOf(unZipFile);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Boolean bool) {
                            ResourceDownloader.removeDownloadingResId(downloadData2.getId());
                            if (bool.booleanValue()) {
                                if (DownloaderHelper.existFile(str4)) {
                                    return;
                                }
                                BdLog.e("zip empty");
                                return;
                            }
                            BdLog.e("failed to unzip");
                        }
                    }.execute(new Void[0]);
                }

                @Override // d.a.j0.v.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    ResourceDownloader.sendDownloadStatusMessage(3, downloadData2);
                    return true;
                }

                @Override // d.a.j0.v.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    ResourceDownloader.sendDownloadStatusMessage(2, downloadData2);
                }

                @Override // d.a.j0.v.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    if (j.H() || z) {
                        ResourceDownloader.sendDownloadStatusMessage(1, downloadData2);
                        return true;
                    }
                    return false;
                }
            });
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.ala.downloader.ResourceDownloader.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    if (!ResourceDownloader.isResZipDownloading(str)) {
                        ResourceDownloader.addDownloadingResId(str);
                        DownloaderHelper.cleanDir(new File(str4));
                        downloadData.setPath(str8);
                        d.j().k(downloadData);
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
            }.execute(new Void[0]);
        }
    }

    public static void removeDownloadingResId(String str) {
        if (sResDownloadingTaskList == null || StringUtils.isNull(str)) {
            return;
        }
        synchronized (sResDownloadingTaskList) {
            sResDownloadingTaskList.remove(str);
        }
        if (sResDownloadingTaskList.size() == 0) {
            sResDownloadingTaskList = null;
        }
    }

    public static void sendDownloadStatusMessage(int i2, DownloadData downloadData) {
        WrapDownloadData wrapDownloadData = new WrapDownloadData();
        wrapDownloadData.status = i2;
        wrapDownloadData.data = downloadData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS, wrapDownloadData));
    }
}
