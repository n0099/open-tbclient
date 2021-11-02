package com.baidu.android.util.media;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Deprecated
/* loaded from: classes6.dex */
public final class ImageScanner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class ClientProxy implements MediaScannerConnection.MediaScannerConnectionClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final OnScanCompletedListener mClient;
        public MediaScannerConnection mConnection;
        public final String[] mMimeTypes;
        public int mNextPath;
        public final String[] mPaths;

        public ClientProxy(String[] strArr, String[] strArr2, OnScanCompletedListener onScanCompletedListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, strArr2, onScanCompletedListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPaths = strArr;
            this.mMimeTypes = strArr2;
            this.mClient = onScanCompletedListener;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                scanNextPath();
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, uri) == null) {
                OnScanCompletedListener onScanCompletedListener = this.mClient;
                if (onScanCompletedListener != null) {
                    onScanCompletedListener.onScanCompleted(str, uri);
                }
                scanNextPath();
            }
        }

        public void scanNextPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.mNextPath;
                if (i2 >= this.mPaths.length) {
                    this.mConnection.disconnect();
                    return;
                }
                String[] strArr = this.mMimeTypes;
                this.mConnection.scanFile(this.mPaths[this.mNextPath], strArr != null ? strArr[i2] : null);
                this.mNextPath++;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface OnScanCompletedListener {
        void onScanCompleted(String str, Uri uri);
    }

    public ImageScanner() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void scanFile(Context context, String[] strArr, String[] strArr2, OnScanCompletedListener onScanCompletedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, strArr, strArr2, onScanCompletedListener) == null) {
            ClientProxy clientProxy = new ClientProxy(strArr, strArr2, onScanCompletedListener);
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, clientProxy);
            clientProxy.mConnection = mediaScannerConnection;
            mediaScannerConnection.connect();
        }
    }

    public static void scanImageFiles(Context context, String str, String[] strArr, OnScanCompletedListener onScanCompletedListener) {
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, context, str, strArr, onScanCompletedListener) == null) || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        try {
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                strArr2 = new String[listFiles.length];
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    strArr2[i2] = listFiles[i2].getAbsolutePath();
                }
            } else {
                strArr2 = new String[]{str};
            }
            scanFile(context, strArr2, strArr, onScanCompletedListener);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }
}
