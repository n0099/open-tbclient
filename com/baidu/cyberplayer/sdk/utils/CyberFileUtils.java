package com.baidu.cyberplayer.sdk.utils;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.Downloader;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class CyberFileUtils {
    public static final String MD5_ = "md5_";
    public static final int MD5_PREFIX_LENGTH = 37;
    public static final String TAG = "CyberFileUtils";

    /* loaded from: classes3.dex */
    public static class DownloadException extends Exception {
        public DownloadException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class MD5VerificationException extends Exception {
        public MD5VerificationException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class RenameException extends Exception {
        public RenameException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class UnZipException extends Exception {
        public UnZipException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class CyberFileNameInfo {
        public String mMD5;
        public String mShortName;

        public static boolean isCyberFileNameFormat(String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("md5_") && str.length() > CyberFileUtils.MD5_PREFIX_LENGTH) {
                return true;
            }
            return false;
        }

        public static CyberFileNameInfo parser(String str) {
            if (isCyberFileNameFormat(str)) {
                CyberFileNameInfo cyberFileNameInfo = new CyberFileNameInfo();
                cyberFileNameInfo.mShortName = str.substring(CyberFileUtils.MD5_PREFIX_LENGTH);
                cyberFileNameInfo.mMD5 = str.substring(4, 36);
                return cyberFileNameInfo;
            }
            return null;
        }
    }

    public static ArrayList<String> downloadAndUnzip(String str, String str2, String str3) throws Exception {
        CyberFileNameInfo parser;
        String downloadFileSync = downloadFileSync(str, str2, str3);
        ArrayList<String> unZip = unZip(downloadFileSync, str3);
        for (int i = 0; i < unZip.size(); i++) {
            String str4 = unZip.get(i);
            File file = new File(str4);
            if (!file.isDirectory() && (parser = CyberFileNameInfo.parser(file.getName())) != null && !Utils.checkFileMd5(parser.mMD5, str4)) {
                String str5 = str4 + " md5 verification failed " + parser.mMD5;
                CyberLog.d(TAG, str5);
                if (unZip != null) {
                    Iterator<String> it = unZip.iterator();
                    while (it.hasNext()) {
                        CyberLog.d(TAG, "md5 verification fail, delete:" + downloadFileSync);
                        Utils.deleteFile(it.next());
                    }
                }
                unZip.clear();
                throw new MD5VerificationException(str5);
            }
        }
        return unZip;
    }

    public static String downloadFileSync(String str, String str2, String str3) throws Exception {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (Utils.isNetWorkCanUse()) {
                CyberLog.d(TAG, "downloadServer:" + str);
                CyberLog.d(TAG, "fileName:" + str2);
                CyberLog.d(TAG, "saveDirectory:" + str3);
                Utils.makeSureFolderExists(str3);
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
                String str5 = str3 + File.separator + str2;
                try {
                    CyberLog.d(TAG, "FileSize:" + Downloader.startDownload(str + File.separator + str2 + str4, str5));
                    CyberLog.d(TAG, "FilePath:" + str5);
                    return str5;
                } catch (Exception e) {
                    CyberLog.d(TAG, "download fail, delete:" + str5);
                    Utils.deleteFile(str5);
                    throw new DownloadException(e.getMessage());
                }
            }
            throw new DownloadException("Disconnect");
        }
        throw new DownloadException("argument is null");
    }

    public static ArrayList<String> unZip(String str, String str2) throws Exception {
        File file = new File(str);
        ArrayList<String> arrayList = null;
        try {
            CyberLog.d(TAG, "unzip " + file + " to " + str2);
            arrayList = ZipUtils.unZip(file, str2);
            Utils.deleteFile(str);
            CyberLog.d(TAG, "unzip FileList:" + arrayList);
            return arrayList;
        } catch (Exception e) {
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    CyberLog.d(TAG, "unzip fail, delete:" + str);
                    Utils.deleteFile(it.next());
                }
                arrayList.clear();
            }
            throw new UnZipException(e.toString());
        }
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
                            unZipAndRename(file, str2);
                        } else {
                            String str4 = str2 + File.separator + "libs";
                            Utils.makeSureFolderExists(str4);
                            unZipAndRename(file, str4);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        CyberLog.d(TAG, "external core ver:" + str3);
        return str3;
    }

    public static ArrayList<String> unZipAndRename(File file, String str) throws Exception {
        MD5VerificationException mD5VerificationException;
        ArrayList arrayList = new ArrayList();
        try {
            CyberLog.d(TAG, ZeusPerformanceTiming.KEY_UNZIP + file + " to " + str);
            ArrayList<String> unZip = ZipUtils.unZip(file, str);
            StringBuilder sb = new StringBuilder();
            sb.append("unzip FileList:");
            sb.append(unZip);
            CyberLog.d(TAG, sb.toString());
            if (unZip == null) {
                return null;
            }
            int i = 0;
            while (true) {
                if (i < unZip.size()) {
                    String str2 = unZip.get(i);
                    File file2 = new File(str2);
                    if (file2.isDirectory()) {
                        arrayList.add(str2);
                    } else {
                        CyberFileNameInfo parser = CyberFileNameInfo.parser(file2.getName());
                        if (parser == null) {
                            continue;
                        } else if (!Utils.checkFileMd5(parser.mMD5, str2)) {
                            CyberLog.d(TAG, "---step---checkUnzipFilesMd5----fail");
                            mD5VerificationException = new MD5VerificationException(str2 + " md5 is not " + parser.mMD5);
                            break;
                        } else {
                            File file3 = new File(file2.getParent(), parser.mShortName);
                            boolean renameTo = file2.renameTo(file3);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(file2.getName());
                            sb2.append("(" + file2.exists() + SmallTailInfo.EMOTION_SUFFIX);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(" to ");
                            sb3.append(file3.getName());
                            sb2.append(sb3.toString());
                            sb2.append("(" + file3.exists() + SmallTailInfo.EMOTION_SUFFIX);
                            CyberLog.d(TAG, sb2.toString());
                            if (renameTo) {
                                CyberLog.d(TAG, "rename success:" + ((Object) sb2));
                            } else {
                                CyberLog.d(TAG, "rename failed:" + ((Object) sb2));
                            }
                        }
                    }
                    i++;
                } else {
                    mD5VerificationException = null;
                    break;
                }
            }
            if (mD5VerificationException == null) {
                return null;
            }
            throw mD5VerificationException;
        } catch (Exception e) {
            throw new UnZipException(e.toString());
        }
    }
}
