package com.baidu.tbadk.core.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class MediaScannerClient implements MediaScannerConnection.MediaScannerConnectionClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean completed;
    public int length;
    public MediaScannerConnection mConnection;
    public Context mContext;
    public onScanCompletedListener mListener;
    public String mMimeType;
    public String[] mMimeTypes;
    public String mPath;
    public String[] mPaths;

    /* loaded from: classes11.dex */
    public interface onScanCompletedListener {
        void onScanCompeted();
    }

    public MediaScannerClient(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.mConnection = new MediaScannerConnection(this.mContext, this);
    }

    private String getVideoMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            String lowerCase = str.toLowerCase();
            return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? "video/mp4" : "video/3gp";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType)) {
                this.mConnection.scanFile(this.mPath, this.mMimeType);
            }
            String[] strArr2 = this.mPaths;
            if (strArr2 == null || (strArr = this.mMimeTypes) == null || strArr2.length != strArr.length) {
                return;
            }
            int length = strArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mConnection.scanFile(this.mPaths[i2], this.mMimeTypes[i2]);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        String[] strArr;
        onScanCompletedListener onscancompletedlistener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, uri) == null) {
            if (!TextUtils.isEmpty(this.mPath) && !TextUtils.isEmpty(this.mMimeType) && str.equals(this.mPath)) {
                this.mConnection.disconnect();
                this.mConnection = null;
                this.mPath = null;
                this.mMimeType = null;
                this.completed = true;
            } else {
                String[] strArr2 = this.mPaths;
                if (strArr2 != null && (strArr = this.mMimeTypes) != null && strArr2.length == strArr.length) {
                    int i2 = this.length - 1;
                    this.length = i2;
                    if (i2 == 0) {
                        this.mConnection.disconnect();
                        this.mConnection = null;
                        this.mPaths = null;
                        this.mMimeTypes = null;
                        this.completed = true;
                    } else {
                        this.completed = false;
                    }
                }
            }
            if (!this.completed || (onscancompletedlistener = this.mListener) == null) {
                return;
            }
            onscancompletedlistener.onScanCompeted();
        }
    }

    public void saveImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mPath = str;
            String substring = str.substring(str.lastIndexOf("."));
            this.mMimeType = "image/jpeg";
            if (substring.equals(".gif")) {
                this.mMimeType = "image/gif";
            }
            this.mConnection.connect();
        }
    }

    public void saveVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mPath = str;
            this.mMimeType = getVideoMimeType(str);
            this.mConnection.connect();
        }
    }

    public void scanFile(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.mPath = str;
            this.mMimeType = str2;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mMimeType)) {
                this.mConnection.connect();
                return;
            }
            this.mPath = null;
            this.mMimeType = null;
        }
    }

    public void scanFiles(String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, strArr, strArr2) == null) {
            this.mPaths = strArr;
            this.mMimeTypes = strArr2;
            if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
                this.length = strArr.length;
                this.mConnection.connect();
                return;
            }
            this.mPaths = null;
            this.mMimeTypes = null;
            this.length = 0;
        }
    }

    public void setOnScanCompletedListener(onScanCompletedListener onscancompletedlistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onscancompletedlistener) == null) {
            this.mListener = onscancompletedlistener;
        }
    }
}
