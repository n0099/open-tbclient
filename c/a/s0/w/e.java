package c.a.s0.w;

import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes6.dex */
public interface e {
    void onFileDownloadFailed(DownloadData downloadData, int i2, String str);

    void onFileDownloadSucceed(DownloadData downloadData);

    boolean onFileDownloaded(DownloadData downloadData);

    void onFileUpdateProgress(DownloadData downloadData);

    boolean onPreDownload(DownloadData downloadData);
}
