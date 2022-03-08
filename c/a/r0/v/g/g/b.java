package c.a.r0.v.g.g;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public interface a {
        boolean onClickIntercept(View view);
    }

    View getActionBar();

    @NonNull
    View getRealView();

    boolean onClickIntercept(View view);

    void onProgressChanged(int i2);

    void onStateAndProgressChanged(DownloadStatus downloadStatus, int i2);

    void onStatusChanged(@NonNull DownloadStatus downloadStatus);
}
