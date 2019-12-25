package com.baidu.live.tbadk.widget.lottie;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.tbadk.core.hybrid.ZIPUtil;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.File;
/* loaded from: classes2.dex */
public class TBLottieAnimationLoader extends BdAsyncTask<Void, String, String> {
    private OnLoadedCallback mCallback;
    private NetWork mNetWork;
    private String mPath;
    private String mUrl;

    /* loaded from: classes2.dex */
    public interface OnLoadedCallback {
        void onLoaded(boolean z, String str);
    }

    public static boolean checkInternalTempDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", ".", "CheckTempDir", HanziToPinyin.Token.SEPARATOR, str));
            return false;
        }
    }

    public TBLottieAnimationLoader(String str, String str2, OnLoadedCallback onLoadedCallback) {
        this.mPath = str;
        this.mUrl = str2;
        this.mCallback = onLoadedCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (StringHelper.isEmpty(this.mPath) || StringHelper.isEmpty(this.mUrl) || !checkInternalTempDir(this.mPath)) {
            return null;
        }
        final String md5 = Md5.toMd5(this.mUrl);
        final String str = this.mPath + md5 + "/";
        if (isExists(str)) {
            return md5;
        }
        this.mNetWork = new NetWork();
        this.mNetWork.setUrl(this.mUrl);
        final String str2 = this.mPath + md5 + ".zip";
        this.mNetWork.downloadFile(str2, null, 0, 3, new NetWork.DownloadResultCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.1
            @Override // com.baidu.live.tbadk.core.util.NetWork.DownloadResultCallback
            public void onSucess() {
                if (TBLottieAnimationLoader.this.unZip(str2, str)) {
                    TBLottieAnimationLoader.this.clearTemp(str2);
                    TBLottieAnimationLoader.this.publishProgress(md5);
                }
            }

            @Override // com.baidu.live.tbadk.core.util.NetWork.DownloadResultCallback
            public void onFail(int i) {
                TBLottieAnimationLoader.this.clearTemp(str2);
            }
        });
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public void onProgressUpdate(String... strArr) {
        if (this.mCallback != null) {
            if (!StringHelper.isEmpty(strArr[0])) {
                this.mCallback.onLoaded(true, strArr[0]);
            } else {
                this.mCallback.onLoaded(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unZip(String str, String str2) {
        if (StringHelper.isEmpty(str) || StringHelper.isEmpty(str2)) {
            return false;
        }
        return ZIPUtil.unZipFiles(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTemp(String str) {
        if (!StringHelper.isEmpty(str)) {
            FileHelper.deleteFileOrDir(new File(str));
        }
    }

    private boolean isExists(String str) {
        return !StringHelper.isEmpty(str) && new File(str).exists();
    }
}
