package c.a.i0.a.e;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
/* loaded from: classes.dex */
public interface a {
    void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode);

    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingStarted(String str, View view);
}
