package com.baidu.tbadk.BdToken;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.DecryptCode.DecryptCodeResIdl;
/* loaded from: classes4.dex */
public class DecryptCodeSocketRespMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fu4 decryptData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecryptCodeSocketRespMsg(int i) {
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
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            try {
                DecryptCodeResIdl decryptCodeResIdl = (DecryptCodeResIdl) new Wire(new Class[0]).parseFrom(bArr, DecryptCodeResIdl.class);
                if (decryptCodeResIdl != null) {
                    fu4 fu4Var = new fu4();
                    this.decryptData = fu4Var;
                    fu4Var.h(decryptCodeResIdl.data);
                }
                return decryptCodeResIdl;
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        return invokeIL.objValue;
    }

    public fu4 getDecryptData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.decryptData;
        }
        return (fu4) invokeV.objValue;
    }
}
