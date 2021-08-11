package com.baidu.down.manage;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.down.common.DownDetail;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class Download {
    public static /* synthetic */ Interceptable $ic;
    public static final DecimalFormat DFOEMAT;
    public transient /* synthetic */ FieldHolder $fh;
    public Long mControlFlag;
    public Long mCurrentbytes;
    public DownDetail mDownDetail;
    public String mDownDir;
    public String mEtag;
    public String mFailedReason;
    public Integer mFailedType;
    public String mFileName;
    public String mFromParam;
    public Long mId;
    public String mKeyByUser;
    public float mLastProgressNoti;
    public long mLastProgressNotiStamp;
    public long mLastProgressSaveStamp;
    public long mLastSpeed;
    public String mMimetype;
    public boolean mNeedDeleteFile;
    public boolean mNotificationNeeded;
    public int mPriority;
    public String mProgressmap;
    public String mRealUrl;
    public String mRedownloadReason;
    public String mRequestHeader;
    public List<Pair<String, String>> mRequestHeaders;
    public String mSavedPathForUser;
    public String mSize;
    public Integer mStatus;
    public Long mTotalbytes;
    public String mUrihost;
    public String mUrl;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class DownloadState {
        public static final /* synthetic */ DownloadState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DownloadState CANCEL;
        public static final DownloadState DOWNLOADING;
        public static final DownloadState FAILED;
        public static final DownloadState FINISH;
        public static final DownloadState PAUSE;
        public static final DownloadState UNKNOWN;
        public static final DownloadState WAITING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1935318691, "Lcom/baidu/down/manage/Download$DownloadState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1935318691, "Lcom/baidu/down/manage/Download$DownloadState;");
                    return;
                }
            }
            WAITING = new DownloadState("WAITING", 0);
            DOWNLOADING = new DownloadState(AdDownloadApkUtils.DL_STATUS_DOWNLOADING, 1);
            PAUSE = new DownloadState(XDeviceInfo.ABILITY_PAUSE, 2);
            FAILED = new DownloadState("FAILED", 3);
            CANCEL = new DownloadState("CANCEL", 4);
            FINISH = new DownloadState("FINISH", 5);
            DownloadState downloadState = new DownloadState(RomUtils.UNKNOWN, 6);
            UNKNOWN = downloadState;
            $VALUES = new DownloadState[]{WAITING, DOWNLOADING, PAUSE, FAILED, CANCEL, FINISH, downloadState};
        }

        public DownloadState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DownloadState getState(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 != 5) {
                                        return UNKNOWN;
                                    }
                                    return FINISH;
                                }
                                return CANCEL;
                            }
                            return FAILED;
                        }
                        return PAUSE;
                    }
                    return DOWNLOADING;
                }
                return WAITING;
            }
            return (DownloadState) invokeI.objValue;
        }

        public static DownloadState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DownloadState) Enum.valueOf(DownloadState.class, str) : (DownloadState) invokeL.objValue;
        }

        public static DownloadState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (DownloadState[]) $VALUES.clone() : (DownloadState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1179691032, "Lcom/baidu/down/manage/Download;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1179691032, "Lcom/baidu/down/manage/Download;");
                return;
            }
        }
        DFOEMAT = new DecimalFormat("###0.0");
    }

    public Download() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUrl = "";
        this.mRealUrl = "";
        this.mFileName = "";
        this.mSavedPathForUser = "";
        this.mMimetype = "";
        this.mEtag = "";
        this.mStatus = Integer.valueOf(DownloadState.WAITING.ordinal());
        this.mTotalbytes = 0L;
        this.mCurrentbytes = 0L;
        this.mFailedReason = "";
        this.mProgressmap = "";
        this.mUrihost = "";
        this.mControlFlag = 9L;
        this.mFailedType = -1;
        this.mPriority = 3;
        this.mRequestHeaders = new ArrayList();
        this.mLastProgressNotiStamp = 0L;
        this.mLastProgressSaveStamp = 0L;
        this.mLastProgressNoti = 0.0f;
        this.mLastSpeed = 0L;
        this.mNeedDeleteFile = true;
        this.mRedownloadReason = "";
        this.mRequestHeader = "";
        this.mDownDetail = new DownDetail();
        this.mDownDir = "";
        this.mNotificationNeeded = false;
    }

    private void addControlFlag(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            this.mControlFlag = Long.valueOf(j2 | this.mControlFlag.longValue());
        }
    }

    private boolean hasControlFlag(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? (j2 & this.mControlFlag.longValue()) > 0 : invokeJ.booleanValue;
    }

    private void removeControlFlag(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2) == null) {
            this.mControlFlag = Long.valueOf((~j2) & this.mControlFlag.longValue());
        }
    }

    public void addRequestHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (str != null) {
                if (!str.contains(":")) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.mRequestHeaders.add(Pair.create(str, str2));
                    return;
                }
                throw new IllegalArgumentException("header may not contain ':'");
            }
            throw new NullPointerException("header cannot be null");
        }
    }

    public Long getControlFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mControlFlag : (Long) invokeV.objValue;
    }

    public float getCurrentProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mCurrentbytes.longValue() == 0 || this.mTotalbytes.longValue() == 0) {
                return 0.0f;
            }
            float longValue = ((float) (this.mCurrentbytes.longValue() * 100)) / ((float) this.mTotalbytes.longValue());
            if (longValue >= 100.0f) {
                return 99.99f;
            }
            return longValue;
        }
        return invokeV.floatValue;
    }

    public Long getCurrentbytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentbytes : (Long) invokeV.objValue;
    }

    public String getDownloadFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new File(this.mSavedPathForUser, this.mFileName).getPath() : (String) invokeV.objValue;
    }

    public String getEtag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mEtag : (String) invokeV.objValue;
    }

    public String getExactProgressString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? DFOEMAT.format(getCurrentProgress()) : (String) invokeV.objValue;
    }

    public String getFailedReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mFailedReason : (String) invokeV.objValue;
    }

    public Integer getFailedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFailedType : (Integer) invokeV.objValue;
    }

    public String getFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mFileName : (String) invokeV.objValue;
    }

    public String getFromParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mFromParam : (String) invokeV.objValue;
    }

    public Long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mId : (Long) invokeV.objValue;
    }

    public String getKeyByUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mKeyByUser : (String) invokeV.objValue;
    }

    public String getMimetype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMimetype : (String) invokeV.objValue;
    }

    public boolean getNotificationNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mNotificationNeeded : invokeV.booleanValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPriority : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mCurrentbytes.longValue() == 0 || this.mTotalbytes.longValue() == 0) {
                return 0;
            }
            int longValue = (int) ((this.mCurrentbytes.longValue() * 100) / this.mTotalbytes.longValue());
            if (longValue >= 100) {
                return 99;
            }
            return longValue;
        }
        return invokeV.intValue;
    }

    public String getProgressmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mProgressmap : (String) invokeV.objValue;
    }

    public String getRealDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mDownDir : (String) invokeV.objValue;
    }

    public String getRealUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mRealUrl : (String) invokeV.objValue;
    }

    public String getRedownloadReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mRedownloadReason : (String) invokeV.objValue;
    }

    public String getSavedPathForUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mSavedPathForUser : (String) invokeV.objValue;
    }

    public DownloadState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? DownloadState.values()[this.mStatus.intValue()] : (DownloadState) invokeV.objValue;
    }

    public Integer getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mStatus : (Integer) invokeV.objValue;
    }

    public Boolean getSupportrange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Boolean.valueOf(hasControlFlag(1L)) : (Boolean) invokeV.objValue;
    }

    public Long getTotalbytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mTotalbytes : (Long) invokeV.objValue;
    }

    public String getUrihost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mUrihost : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public Boolean isAutoPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? Boolean.valueOf(hasControlFlag(2L)) : (Boolean) invokeV.objValue;
    }

    public boolean isCheckConentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? hasControlFlag(8L) : invokeV.booleanValue;
    }

    public boolean isWifiOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? hasControlFlag(4L) : invokeV.booleanValue;
    }

    public void setAutoPause(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bool) == null) {
            if (bool.booleanValue()) {
                addControlFlag(2L);
            } else {
                removeControlFlag(2L);
            }
        }
    }

    public void setCheckContentType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (z) {
                addControlFlag(8L);
            } else {
                removeControlFlag(8L);
            }
        }
    }

    public void setControlFlag(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, l) == null) {
            this.mControlFlag = l;
        }
    }

    public void setCurrentbytes(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, l) == null) {
            this.mCurrentbytes = l;
        }
    }

    public void setDownDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mDownDir = str;
        }
    }

    public void setEtag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mEtag = str;
        }
    }

    public void setFailedReason(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.mFailedReason = str;
        }
    }

    public void setFailedType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, num) == null) {
            this.mFailedType = num;
        }
    }

    public void setFileName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mFileName = str;
        }
    }

    public void setFromParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mFromParam = str;
        }
    }

    public void setId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, l) == null) {
            this.mId = l;
        }
    }

    public void setKeyByUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mKeyByUser = str;
        }
    }

    public void setMimetype(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.mMimetype = str;
        }
    }

    public void setNeedDeleteFile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.mNeedDeleteFile = z;
        }
    }

    public void setNotificationNeeded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mNotificationNeeded = z;
        }
    }

    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.mPriority = i2;
        }
    }

    public void setProgressmap(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mProgressmap = str;
        }
    }

    public void setRealUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.mRealUrl = str;
        }
    }

    public void setRedownloadReason(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.mRedownloadReason = str;
        }
    }

    public void setSavedPathForUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mSavedPathForUser = str;
        }
    }

    public void setState(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, downloadState) == null) {
            this.mStatus = Integer.valueOf(downloadState.ordinal());
        }
    }

    public void setStatus(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, num) == null) {
            this.mStatus = num;
        }
    }

    public void setSupportrange(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bool) == null) {
            if (bool.booleanValue()) {
                addControlFlag(1L);
            } else {
                removeControlFlag(1L);
            }
        }
    }

    public void setTotalbytes(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, l) == null) {
            this.mTotalbytes = l;
        }
    }

    public void setUrihost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.mUrihost = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.mUrl = str;
        }
    }

    public void setWifiOnly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            if (z) {
                addControlFlag(4L);
            } else {
                removeControlFlag(4L);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[mUrl=");
            stringBuffer.append(this.mUrl);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mFileName=");
            stringBuffer.append(this.mFileName);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mSavedPath=");
            stringBuffer.append(this.mSavedPathForUser);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mFileLength=");
            stringBuffer.append(this.mTotalbytes);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mCurrentLength=");
            stringBuffer.append(this.mCurrentbytes);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mState=");
            stringBuffer.append(this.mStatus);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mFailReason=");
            stringBuffer.append(this.mStatus);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mId=");
            stringBuffer.append(this.mId);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mProgressmap=");
            stringBuffer.append(this.mProgressmap);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mEtag=");
            stringBuffer.append(this.mEtag);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mMimeType=");
            stringBuffer.append(this.mMimetype);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[mSavedPathForUser=");
            stringBuffer.append(this.mSavedPathForUser);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
