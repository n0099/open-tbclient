package com.baidu.tbadk.BdToken;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetUserByTiebaUid.GetUserByTiebaUidResIdl;
/* loaded from: classes4.dex */
public class TiebaUidCheckSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UserData mUserData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaUidCheckSocketResMsg(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            try {
                GetUserByTiebaUidResIdl getUserByTiebaUidResIdl = (GetUserByTiebaUidResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserByTiebaUidResIdl.class);
                if (getUserByTiebaUidResIdl != null && getUserByTiebaUidResIdl.data != null) {
                    UserData userData = new UserData();
                    this.mUserData = userData;
                    userData.parserProtobuf(getUserByTiebaUidResIdl.data.user);
                }
                return getUserByTiebaUidResIdl;
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        return invokeIL.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mUserData;
        }
        return (UserData) invokeV.objValue;
    }
}
