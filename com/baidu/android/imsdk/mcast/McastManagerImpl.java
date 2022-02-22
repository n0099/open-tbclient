package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class McastManagerImpl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile McastManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public McastManagerImpl(Context context) {
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
        this.mContext = context.getApplicationContext();
    }

    public static McastManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (mInstance == null) {
                synchronized (McastManagerImpl.class) {
                    if (mInstance == null) {
                        mInstance = new McastManagerImpl(context);
                    }
                }
            }
            return mInstance;
        }
        return (McastManagerImpl) invokeL.objValue;
    }

    public String getAllCastIdList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ConversationStudioManImpl.getInstance(this.mContext).getAllCastIdList() : (String) invokeV.objValue;
    }

    public long getJoinedCastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ConversationStudioManImpl.getInstance(this.mContext).getJoinedCastId() : invokeV.longValue;
    }

    public long getMaxReliableMsgId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? ConversationStudioManImpl.getInstance(this.mContext).getMaxReliableMsgId(j2) : invokeJ.longValue;
    }

    public long getReliableMsgCount(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? ConversationStudioManImpl.getInstance(this.mContext).getReliableMsgCount(j2) : invokeJ.longValue;
    }

    public void sendQuizOpts(long j2, long j3, int i2, String str, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), str, iMcastSetListener}) == null) {
        }
    }
}
