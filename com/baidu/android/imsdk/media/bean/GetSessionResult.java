package com.baidu.android.imsdk.media.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class GetSessionResult implements Parcelable, ResponseResult {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<GetSessionResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int consultUnread;
    public int dotUnread;
    public boolean hasMore;
    public int privateChatNoDisturbNumber;
    public List<ChatSession> sessionList;
    public int totalUnread;
    public int weakConsultUnread;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1590976751, "Lcom/baidu/android/imsdk/media/bean/GetSessionResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1590976751, "Lcom/baidu/android/imsdk/media/bean/GetSessionResult;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GetSessionResult>() { // from class: com.baidu.android.imsdk.media.bean.GetSessionResult.1
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
            public GetSessionResult createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GetSessionResult(parcel);
                }
                return (GetSessionResult) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GetSessionResult[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GetSessionResult[i];
                }
                return (GetSessionResult[]) invokeI.objValue;
            }
        };
    }

    public GetSessionResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GetSessionResult getFailResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            GetSessionResult getSessionResult = new GetSessionResult();
            getSessionResult.consultUnread = 0;
            getSessionResult.sessionList = null;
            getSessionResult.totalUnread = 0;
            getSessionResult.hasMore = false;
            getSessionResult.dotUnread = 0;
            return getSessionResult;
        }
        return (GetSessionResult) invokeV.objValue;
    }

    public GetSessionResult(Parcel parcel) {
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
        this.hasMore = parcel.readInt() == 1;
        parcel.readList(this.sessionList, ChatSession.class.getClassLoader());
        this.totalUnread = parcel.readInt();
        this.consultUnread = parcel.readInt();
        this.dotUnread = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            parcel.writeInt(this.hasMore ? 1 : 0);
            parcel.writeList(this.sessionList);
            parcel.writeInt(this.totalUnread);
            parcel.writeInt(this.consultUnread);
            parcel.writeInt(this.dotUnread);
        }
    }
}
