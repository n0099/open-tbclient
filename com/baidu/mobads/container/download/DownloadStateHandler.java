package com.baidu.mobads.container.download;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.IDownloadStateChangeListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class DownloadStateHandler {
    public static /* synthetic */ Interceptable $ic;
    public static volatile DownloadStateHandler mObserverManager;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, WeakReference<IDownloadStateChangeListener>> mDownloadListeners;

    public DownloadStateHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownloadListeners = new HashMap<>();
    }

    public static DownloadStateHandler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mObserverManager == null) {
                synchronized (DownloadStateHandler.class) {
                    if (mObserverManager == null) {
                        mObserverManager = new DownloadStateHandler();
                    }
                }
            }
            return mObserverManager;
        }
        return (DownloadStateHandler) invokeV.objValue;
    }

    public void addDownloadListener(String str, IDownloadStateChangeListener iDownloadStateChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, iDownloadStateChangeListener) == null) || TextUtils.isEmpty(str) || iDownloadStateChangeListener == null) {
            return;
        }
        this.mDownloadListeners.put(str, new WeakReference<>(iDownloadStateChangeListener));
    }

    public HashMap<String, WeakReference<IDownloadStateChangeListener>> getDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDownloadListeners : (HashMap) invokeV.objValue;
    }

    public void removeDownloadListener(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mDownloadListeners.remove(str);
    }
}
