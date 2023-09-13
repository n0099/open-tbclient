package com.baidu.cyberplayer.sdk.downloader;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.Downloader;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoader;
import com.baidu.cyberplayer.sdk.utils.ZipUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CyberFileDownloader implements Downloader.IDownloadListener {
    public static final String MD5_ = "md5_";
    public static final String RESULE_OK = Boolean.toString(true);
    public static final String TAG = "CyberFileDownloader";
    public String mFileName;
    public ICyberFileDownloadListener mListener;
    public ArrayList<String> mUnzipFilesList = null;
    public String mUnzipFolder;

    /* loaded from: classes3.dex */
    public interface ICyberFileDownloadListener {
        void onDownloadFail(String str, long j, int i, String str2);

        void onDownloadStart(String str, long j);

        void onDownloadSuccess(String str, long j, ArrayList<String> arrayList);

        void onDownloading(String str, long j, long j2);
    }

    private String checkMD5() {
        String str = RESULE_OK;
        try {
            if (this.mUnzipFilesList != null) {
                CyberLog.d(TAG, "---step---checkUnzipFilesMd5----start");
                for (int i = 0; i < this.mUnzipFilesList.size(); i++) {
                    String str2 = this.mUnzipFilesList.get(i);
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_")) {
                        String substring = str2.substring(4, 36);
                        if (!Utils.checkFileMd5(substring, this.mUnzipFolder + File.separator + str2)) {
                            CyberLog.d(TAG, "---step---checkUnzipFilesMd5----fail");
                            return "md5 check fail.";
                        }
                    }
                }
            }
            return str;
        } catch (Exception unused) {
            CyberLog.d(TAG, "---step---checkUnzipFilesMd5----fail");
            return "md5 check fail.";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r2.exists() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r2.exists() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
        r2.delete();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String unzipFile() {
        File file;
        String str = RESULE_OK;
        File file2 = null;
        try {
            file = new File(this.mUnzipFolder, this.mFileName);
            try {
                try {
                    this.mUnzipFilesList = ZipUtils.unZipOld(file, this.mUnzipFolder);
                    CyberLog.d(TAG, "mUnzipFilesList:" + this.mUnzipFilesList);
                } catch (Exception e) {
                    e = e;
                    this.mUnzipFilesList = null;
                    str = e.toString();
                    if (file != null) {
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                file2 = file;
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        } catch (Throwable th2) {
            th = th2;
            if (file2 != null) {
                file2.delete();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
        r1 = "file not found:" + r4.getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String renameUnzipFiles(String str, ArrayList<String> arrayList) {
        File file;
        String str2 = RESULE_OK;
        if (arrayList != null) {
            int i = 0;
            while (true) {
                try {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    String str3 = arrayList.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        File file2 = new File(str, str3);
                        if (!file2.isDirectory()) {
                            String name = file2.getName();
                            String parent = file2.getParent();
                            if (!TextUtils.isEmpty(name) && name.startsWith("md5_") && name.length() > 36) {
                                if (!file2.exists()) {
                                    break;
                                }
                                if (file2.renameTo(new File(parent, name.substring(37)))) {
                                    CyberLog.d(TAG, "rename " + file2.getName() + "(" + file2.exists() + ") to " + file.getName() + "(" + file.exists() + SmallTailInfo.EMOTION_SUFFIX);
                                } else {
                                    str2 = "rename fail";
                                    break;
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    return e.toString();
                }
            }
        }
        return str2;
    }

    public static String unzipCyberFile(String str, String str2) {
        File[] listFiles;
        String str3 = "";
        for (File file : new File(str).listFiles()) {
            if (file.isFile() && file.getName().endsWith(".zip")) {
                String replace = file.getName().replace(".zip", "");
                if (replace.contains(CyberCoreLoader.CYBER_MEDIA_DEX)) {
                    str3 = replace.split("_")[2];
                }
                if (Utils.isMainProcess()) {
                    try {
                        if (replace.startsWith("model_")) {
                            Utils.makeSureFolderExists(str2);
                            renameUnzipFiles(str2, ZipUtils.unZipOld(file.getAbsoluteFile(), str2));
                        } else {
                            String str4 = str2 + File.separator + "libs";
                            Utils.makeSureFolderExists(str4);
                            renameUnzipFiles(str4, ZipUtils.unZipOld(file.getAbsoluteFile(), str4));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        CyberLog.d(TAG, "external core ver:" + str3);
        return str3;
    }

    public void downloadFile(String str, String str2, String str3, ICyberFileDownloadListener iCyberFileDownloadListener) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && iCyberFileDownloadListener != null) {
            this.mFileName = str2;
            this.mListener = iCyberFileDownloadListener;
            this.mUnzipFolder = str3;
            Utils.makeSureFolderExists(str3);
            CyberLog.d(TAG, " unzipFolder:" + this.mUnzipFolder);
            HashMap hashMap = new HashMap();
            if (!str.equals(CyberGlobalSetting.DEFAULT_LIBS_XCDN_DOWNLOAD_SERVER_URL)) {
                str4 = "";
            } else {
                str4 = Downloader.addParamToQuery("", "cdn_type=1");
            }
            String cfgValue = CyberCfgManager.getInstance().getCfgValue(CyberCfgManager.KEY_STR_DOWNLOAD_ZIP_SID, "");
            if (!TextUtils.isEmpty(cfgValue)) {
                str4 = Downloader.addParamToQuery(str4, "abtest=" + cfgValue);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("query", str4);
            }
            hashMap.put("url", str + File.separator + this.mFileName + str4);
            hashMap.put(Downloader.KEY_SAVE_FILE_FOLDER, this.mUnzipFolder);
            hashMap.put(Downloader.KEY_SAVE_FILE_NAME, this.mFileName);
            hashMap.put(Downloader.KEY_IS_ASYN, "0");
            Downloader.startDownload(hashMap, this);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.Downloader.IDownloadListener
    public void onDownloadFail(String str, long j, String str2) {
        this.mListener.onDownloadFail(str, j, -1, str2 + ",networkstatus:" + Utils.getNetworkStatus() + ",url:" + str);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.Downloader.IDownloadListener
    public void onDownloading(String str, long j, long j2) {
        this.mListener.onDownloading(str, j, j2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.Downloader.IDownloadListener
    public void onDownloadStart(String str, long j) {
        this.mListener.onDownloadStart(str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.Downloader.IDownloadListener
    public void onDownloadSuccess(String str, long j) {
        String unzipFile = unzipFile();
        if (!RESULE_OK.equals(unzipFile)) {
            Utils.deleteFiles(this.mUnzipFolder, this.mUnzipFilesList);
            this.mListener.onDownloadFail(str, j, -2, unzipFile);
            return;
        }
        String checkMD5 = checkMD5();
        if (!RESULE_OK.equals(checkMD5)) {
            Utils.deleteFiles(this.mUnzipFolder, this.mUnzipFilesList);
            this.mListener.onDownloadFail(str, j, -3, checkMD5);
            return;
        }
        String renameUnzipFiles = renameUnzipFiles(this.mUnzipFolder, this.mUnzipFilesList);
        if (!RESULE_OK.equals(renameUnzipFiles)) {
            Utils.deleteFiles(this.mUnzipFolder, this.mUnzipFilesList);
            this.mListener.onDownloadFail(str, j, -6, renameUnzipFiles);
            return;
        }
        this.mListener.onDownloadSuccess(str, j, this.mUnzipFilesList);
    }
}
