package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DialogSyncMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<DialogSyncMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int category;
    public long fromUid;
    public long operatedMaxMsgid;
    public long paid;
    public int remainEmptySession;
    public int status;
    public int updateTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1885745273, "Lcom/baidu/android/imsdk/chatmessage/messages/DialogSyncMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1885745273, "Lcom/baidu/android/imsdk/chatmessage/messages/DialogSyncMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<DialogSyncMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg.1
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
            public DialogSyncMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new DialogSyncMsg(parcel);
                }
                return (DialogSyncMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DialogSyncMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new DialogSyncMsg[i];
                }
                return (DialogSyncMsg[]) invokeI.objValue;
            }
        };
    }

    public long getOperatedMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.operatedMaxMsgid;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.paid;
        }
        return invokeV.longValue;
    }

    public int getRemainEmptySession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.remainEmptySession;
        }
        return invokeV.intValue;
    }

    public int getSyncCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.category;
        }
        return invokeV.intValue;
    }

    public long getSyncFromUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.fromUid;
        }
        return invokeV.longValue;
    }

    public int getSyncStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.status;
        }
        return invokeV.intValue;
    }

    public DialogSyncMsg() {
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
        this.status = -1;
        this.updateTime = -1;
        this.category = -1;
        this.fromUid = -1L;
        this.operatedMaxMsgid = -1L;
        this.paid = -1L;
        this.remainEmptySession = 0;
        setNotifyCmd(22);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogSyncMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.status = -1;
        this.updateTime = -1;
        this.category = -1;
        this.fromUid = -1L;
        this.operatedMaxMsgid = -1L;
        this.paid = -1L;
        this.remainEmptySession = 0;
        this.status = parcel.readInt();
        this.updateTime = parcel.readInt();
        this.category = parcel.readInt();
        this.fromUid = parcel.readLong();
        this.operatedMaxMsgid = parcel.readLong();
        this.paid = parcel.readLong();
        this.remainEmptySession = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                this.status = jSONObject.getInt("status");
                this.updateTime = jSONObject.getInt("update_time");
                this.category = jSONObject.getInt("category");
                this.fromUid = jSONObject.getLong("from_uid");
                this.operatedMaxMsgid = jSONObject.optLong("msgid", -1L);
                this.paid = jSONObject.optLong(Constants.EXTRA_PAUID_TYPE, -1L);
                this.remainEmptySession = jSONObject.optInt(Constants.EXTRA_REMAIN_EMPTY_SESSION, 0);
                return true;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.status);
            parcel.writeInt(this.updateTime);
            parcel.writeInt(this.category);
            parcel.writeLong(this.fromUid);
            parcel.writeLong(this.operatedMaxMsgid);
            parcel.writeLong(this.paid);
            parcel.writeInt(this.remainEmptySession);
        }
    }
}
