package com.baidu.swan.game.ad.downloader.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.h.i.k.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class DownloadInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCreateAt;
    public transient c mDownloadListener;
    public DownloadException mException;
    public String mId;
    public String mPackageName;
    public String mPath;
    public long mProgress;
    public long mSize;
    public int mStatus;
    public String mUri;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public long f40387b;

        /* renamed from: c  reason: collision with root package name */
        public String f40388c;

        /* renamed from: d  reason: collision with root package name */
        public String f40389d;

        /* renamed from: e  reason: collision with root package name */
        public String f40390e;

        public a() {
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
            this.f40387b = -1L;
        }

        public DownloadInfo a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DownloadInfo downloadInfo = new DownloadInfo();
                if (!TextUtils.isEmpty(this.f40388c)) {
                    downloadInfo.setUri(this.f40388c);
                    if (!TextUtils.isEmpty(this.f40390e)) {
                        downloadInfo.setPath(this.f40390e);
                        if (TextUtils.isEmpty(this.f40389d)) {
                            downloadInfo.setPackageName(this.f40389d);
                        }
                        if (this.f40387b == -1) {
                            b(System.currentTimeMillis());
                        }
                        if (TextUtils.isEmpty(this.a)) {
                            downloadInfo.setId(this.f40388c);
                        } else {
                            downloadInfo.setId(this.a);
                        }
                        return downloadInfo;
                    }
                    throw new DownloadException(1, "path cannot be null.");
                }
                throw new DownloadException(0, "uri cannot be null.");
            }
            return (DownloadInfo) invokeV.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f40387b = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f40389d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f40390e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f40388c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public DownloadInfo() {
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || DownloadInfo.class != obj.getClass()) {
                return false;
            }
            return this.mId.equals(((DownloadInfo) obj).mId);
        }
        return invokeL.booleanValue;
    }

    public long getCreateAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCreateAt : invokeV.longValue;
    }

    public c getDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDownloadListener : (c) invokeV.objValue;
    }

    public DownloadException getException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mException : (DownloadException) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPath : (String) invokeV.objValue;
    }

    public long getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mProgress : invokeV.longValue;
    }

    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSize : invokeV.longValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public String getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUri : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mId.hashCode() : invokeV.intValue;
    }

    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mStatus == DownloadState.DOWNLOAD_PAUSED.value() || this.mStatus == DownloadState.DOWNLOAD_FAILED.value() || this.mStatus == DownloadState.DELETED.value() : invokeV.booleanValue;
    }

    public void setCreateAt(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.mCreateAt = j2;
        }
    }

    public void setDownloadListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.mDownloadListener = cVar;
        }
    }

    public void setException(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, downloadException) == null) {
            this.mException = downloadException;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mId = str;
        }
    }

    public DownloadInfo setPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.mPackageName = str;
            return this;
        }
        return (DownloadInfo) invokeL.objValue;
    }

    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mPath = str;
        }
    }

    public void setProgress(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.mProgress = j2;
        }
    }

    public void setSize(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.mSize = j2;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mStatus = i2;
        }
    }

    public void setUri(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mUri = str;
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return "DownloadInfo{mDownloadListener=" + this.mDownloadListener + ", mException=" + this.mException + ", mId='" + this.mId + ExtendedMessageFormat.QUOTE + ", mCreateAt=" + this.mCreateAt + ", mUri='" + this.mUri + ExtendedMessageFormat.QUOTE + ", mPackageName='" + this.mPackageName + ExtendedMessageFormat.QUOTE + ", mPath='" + this.mPath + ExtendedMessageFormat.QUOTE + ", mSize=" + this.mSize + ", mProgress=" + this.mProgress + ", mStatus=" + this.mStatus + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
