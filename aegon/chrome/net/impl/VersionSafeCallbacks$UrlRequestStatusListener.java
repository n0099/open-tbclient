package aegon.chrome.net.impl;

import aegon.chrome.net.UrlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$UrlRequestStatusListener extends UrlRequest.StatusListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UrlRequest.StatusListener mWrappedListener;

    @Override // aegon.chrome.net.UrlRequest.StatusListener
    public void onStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mWrappedListener.onStatus(i2);
        }
    }
}
