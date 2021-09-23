package com.baidu.clientupdate.download;

import android.net.Uri;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class Download implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f38958a;

    /* renamed from: b  reason: collision with root package name */
    public long f38959b;

    /* renamed from: c  reason: collision with root package name */
    public int f38960c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38961d;
    public long mCurrentLength;
    public String mETag;
    public String mFailReason;
    public long mFileLength;
    public String mFileName;
    public long mId;
    public String mMimeType;
    public boolean mNeedNotification;
    public boolean mNotificationShowed;
    public List mRequestHeaders;
    public String mSavedPath;
    public String mSourceKey;
    public DownloadState mState;
    public String mUrl;
    public boolean mbMustInternal;

    public Download() {
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
        this.mUrl = "";
        this.mFileName = "";
        this.mSavedPath = "";
        this.mFileLength = 0L;
        this.mCurrentLength = 0L;
        this.mState = DownloadState.WAITING;
        this.mFailReason = "";
        this.mId = -1L;
        this.mMimeType = "";
        this.mETag = "";
        this.mbMustInternal = false;
        this.mSourceKey = "";
        this.mNeedNotification = false;
        this.mRequestHeaders = new ArrayList();
        this.f38958a = 0L;
        this.f38959b = 0L;
        this.f38960c = 0;
        this.f38961d = true;
    }

    public void addRequestHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (str == null) {
                throw new NullPointerException("header cannot be null");
            }
            if (str.contains(":")) {
                throw new IllegalArgumentException("header may not contain ':'");
            }
            if (str2 == null) {
                str2 = "";
            }
            this.mRequestHeaders.add(Pair.create(str, str2));
        }
    }

    public long getCurrentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentLength : invokeV.longValue;
    }

    public String getDownloadFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.mFileName;
            return new File(this.mSavedPath, str != null ? Uri.encode(str) : null).getPath();
        }
        return (String) invokeV.objValue;
    }

    public String getDownloadUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public String getFailReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFailReason : (String) invokeV.objValue;
    }

    public long getFileLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFileLength : invokeV.longValue;
    }

    public String getFileType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMimeType : (String) invokeV.objValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mId : invokeV.longValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j2 = this.mCurrentLength;
            if (j2 != 0) {
                long j3 = this.mFileLength;
                if (j3 == 0) {
                    return 0;
                }
                int i2 = (int) ((j2 * 100) / j3);
                if (i2 >= 100) {
                    return 99;
                }
                return i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public DownloadState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mState : (DownloadState) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[mUrl=");
            stringBuffer.append(this.mUrl);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mFileName=");
            stringBuffer.append(this.mFileName);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mSavedPath=");
            stringBuffer.append(this.mSavedPath);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mFileLength=");
            stringBuffer.append(this.mFileLength);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mCurrentLength=");
            stringBuffer.append(this.mCurrentLength);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mState=");
            stringBuffer.append(this.mState.toString());
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mFailReason=");
            stringBuffer.append(this.mFailReason);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mId=");
            stringBuffer.append(this.mId);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mMimeType=");
            stringBuffer.append(this.mMimeType);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
