package c.a.r0.v.g.g;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes3.dex */
public interface c {
    void a();

    void c(@NonNull DownloadStatus downloadStatus);

    void d(@NonNull AdDownloadData adDownloadData);

    void onProgressChanged(int i2);
}
