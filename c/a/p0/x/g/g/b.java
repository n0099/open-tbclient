package c.a.p0.x.g.g;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public interface a {
        boolean b(View view);
    }

    void a(int i);

    boolean b(View view);

    void d(@NonNull DownloadStatus downloadStatus);

    void e(DownloadStatus downloadStatus, int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
