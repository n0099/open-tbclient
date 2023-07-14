package com.baidu.android.imsdk.media.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class SessionParam implements Parcelable, RequestParam {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SessionParam> CREATOR;
    public static final List<Integer> MEDIA_CHAT_TYPES;
    public static final List<Integer> MEDIA_LCOAL_CHAT_TYPES;
    public static final List<Integer> MEDIA_UNREAD_NUM_CHAT_TYPES;
    public static final List<Integer> USER_SESSION_CHAT_TYPES;
    public static final List<Integer> USER_SESSION_NOTIFICATION_CHAT_TYPES;
    public static final List<Integer> USER_UNREAD_NUM_CHAT_TYPES;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> allChatTypes;
    public List<Integer> asyncUnReadChatTypes;
    public long beginMsgid;
    public int businessType;
    public int category;
    public int classType;
    public long clientMaxMsgid;
    public long contacterId;
    public long contacterImUk;
    public long contacterPaid;
    public int contacterUserType;
    public int count;
    public int deleteMode;
    public boolean hudongNeedTop;
    public int isStranger;
    public int mode;
    public int needTop;
    public int reason;
    public String screenKey;
    public int sessionType;
    public long sortUpdateTimeBegin;
    public long sortUpdateTimeEnd;
    public long timeInterval;
    public long toContacterPaUid;
    public long toContacterUk;
    public int toContacterUserType;
    public int type;
    public List<Integer> userNumChatTypes;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1716909783, "Lcom/baidu/android/imsdk/media/bean/SessionParam;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1716909783, "Lcom/baidu/android/imsdk/media/bean/SessionParam;");
                return;
            }
        }
        USER_SESSION_CHAT_TYPES = Arrays.asList(0, 3, 4, 7, 57, 19, 29, 58, 60, 1, 5, 32, 17, 26, 37, 42);
        USER_SESSION_NOTIFICATION_CHAT_TYPES = Arrays.asList(1, 5, 32, 17, 26, 37, 42);
        USER_UNREAD_NUM_CHAT_TYPES = Arrays.asList(0, 7, 19, 29, 1, 5, 32, 17, 26, 37, 42);
        MEDIA_UNREAD_NUM_CHAT_TYPES = Arrays.asList(19, 29);
        MEDIA_LCOAL_CHAT_TYPES = Arrays.asList(19, 29, 57, 60, 58);
        MEDIA_CHAT_TYPES = Arrays.asList(0, 7, 58, 1, 5, 32, 17, 26, 37, 42);
        CREATOR = new Parcelable.Creator<SessionParam>() { // from class: com.baidu.android.imsdk.media.bean.SessionParam.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionParam createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new SessionParam(parcel);
                }
                return (SessionParam) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionParam[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new SessionParam[i];
                }
                return (SessionParam[]) invokeI.objValue;
            }
        };
    }

    public SessionParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.reason = 3;
        List<Integer> list = USER_SESSION_CHAT_TYPES;
        this.allChatTypes = list;
        this.userNumChatTypes = USER_UNREAD_NUM_CHAT_TYPES;
        this.asyncUnReadChatTypes = list;
        this.screenKey = "";
        this.hudongNeedTop = false;
        this.deleteMode = 0;
    }

    public static SessionParam getListRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SessionParam sessionParam = new SessionParam();
            sessionParam.reason = 3;
            sessionParam.businessType = 0;
            sessionParam.mode = 1;
            sessionParam.count = 20;
            sessionParam.needTop = 1;
            sessionParam.sortUpdateTimeBegin = 0L;
            sessionParam.sortUpdateTimeEnd = Long.MAX_VALUE;
            return sessionParam;
        }
        return (SessionParam) invokeV.objValue;
    }

    public SessionParam(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.reason = 3;
        List<Integer> list = USER_SESSION_CHAT_TYPES;
        this.allChatTypes = list;
        this.userNumChatTypes = USER_UNREAD_NUM_CHAT_TYPES;
        this.asyncUnReadChatTypes = list;
        this.screenKey = "";
        this.hudongNeedTop = false;
        this.deleteMode = 0;
        this.contacterPaid = parcel.readLong();
        this.contacterUserType = parcel.readInt();
        this.businessType = parcel.readInt();
        this.sessionType = parcel.readInt();
        this.category = parcel.readInt();
        this.clientMaxMsgid = parcel.readLong();
        this.contacterId = parcel.readLong();
        this.classType = parcel.readInt();
        this.sortUpdateTimeBegin = parcel.readLong();
        this.sortUpdateTimeEnd = parcel.readLong();
        this.count = parcel.readInt();
        this.mode = parcel.readInt();
        this.needTop = parcel.readInt();
        this.isStranger = parcel.readInt();
        this.reason = parcel.readInt();
        parcel.readList(this.allChatTypes, Integer.class.getClassLoader());
        parcel.readList(this.userNumChatTypes, Integer.class.getClassLoader());
        parcel.readList(this.asyncUnReadChatTypes, Integer.class.getClassLoader());
        this.contacterImUk = parcel.readLong();
        this.screenKey = parcel.readString();
        this.deleteMode = parcel.readInt();
        this.toContacterUk = parcel.readLong();
        this.toContacterUserType = parcel.readInt();
        this.toContacterPaUid = parcel.readLong();
    }

    public static SessionParam getAdvisoryReadOrDelParam(long j, long j2, long j3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            SessionParam sessionParam = new SessionParam();
            sessionParam.businessType = 27;
            sessionParam.contacterId = j;
            sessionParam.contacterImUk = j;
            sessionParam.clientMaxMsgid = j2;
            sessionParam.beginMsgid = j3;
            sessionParam.sessionType = i;
            sessionParam.category = 9;
            sessionParam.type = i2;
            return sessionParam;
        }
        return (SessionParam) invokeCommon.objValue;
    }

    public static SessionParam getAsyncUnReadNotifyParam(int i, List<Integer> list, List<Integer> list2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), list, list2, Long.valueOf(j)})) == null) {
            SessionParam sessionParam = new SessionParam();
            sessionParam.count = i;
            sessionParam.asyncUnReadChatTypes = list;
            sessionParam.userNumChatTypes = list2;
            sessionParam.sortUpdateTimeBegin = j;
            return sessionParam;
        }
        return (SessionParam) invokeCommon.objValue;
    }

    public static SessionParam getBjhReadOrDelParam(int i, long j, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            SessionParam sessionParam = new SessionParam();
            sessionParam.type = i3;
            if (i3 != 1) {
                sessionParam.category = i;
                sessionParam.contacterId = j;
            } else {
                sessionParam.businessType = 0;
            }
            sessionParam.classType = i2;
            return sessionParam;
        }
        return (SessionParam) invokeCommon.objValue;
    }

    public static SessionParam getListNextParam(int i, int i2, long j, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)})) == null) {
            SessionParam sessionParam = new SessionParam();
            sessionParam.reason = 3;
            sessionParam.businessType = i;
            sessionParam.mode = i2;
            sessionParam.count = 20;
            sessionParam.needTop = i3;
            sessionParam.sortUpdateTimeBegin = 0L;
            sessionParam.sortUpdateTimeEnd = j - 1;
            return sessionParam;
        }
        return (SessionParam) invokeCommon.objValue;
    }

    public static SessionParam getNotifyRequestParam(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                return null;
            }
            SessionParam sessionParam = new SessionParam();
            sessionParam.reason = 2;
            sessionParam.businessType = 0;
            sessionParam.mode = 1;
            sessionParam.count = 20;
            sessionParam.needTop = -1;
            sessionParam.sortUpdateTimeBegin = MediaSessionManager.getInstance(context).getClientMaxSortTime();
            sessionParam.sortUpdateTimeEnd = Long.MAX_VALUE;
            return sessionParam;
        }
        return (SessionParam) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            parcel.writeLong(this.contacterPaid);
            parcel.writeInt(this.contacterUserType);
            parcel.writeInt(this.businessType);
            parcel.writeInt(this.sessionType);
            parcel.writeInt(this.category);
            parcel.writeLong(this.clientMaxMsgid);
            parcel.writeLong(this.contacterId);
            parcel.writeLong(this.classType);
            parcel.writeLong(this.sortUpdateTimeBegin);
            parcel.writeLong(this.sortUpdateTimeEnd);
            parcel.writeInt(this.count);
            parcel.writeInt(this.mode);
            parcel.writeInt(this.needTop);
            parcel.writeInt(this.isStranger);
            parcel.writeInt(this.reason);
            parcel.writeList(this.allChatTypes);
            parcel.writeList(this.asyncUnReadChatTypes);
            parcel.writeList(this.userNumChatTypes);
            parcel.writeLong(this.contacterImUk);
            parcel.writeString(this.screenKey);
            parcel.writeInt(this.deleteMode);
            parcel.writeLong(this.toContacterUk);
            parcel.writeInt(this.toContacterUserType);
            parcel.writeLong(this.toContacterPaUid);
        }
    }
}
