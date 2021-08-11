package com.baidu.adp.lib.util;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NetWorkChangedMessage extends CustomResponsedMessage<NetworkState> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mCurChangedTime;
    public final int mCurNetState;
    public final int mLastNetState;
    public final long mlastChangedTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorkChangedMessage(NetworkState networkState) {
        super(2000994);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkState};
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
        if (networkState != null) {
            this.mLastNetState = networkState.mLastNetState;
            this.mCurNetState = networkState.mCurNetState;
            this.mlastChangedTime = networkState.mlastChangedTime;
            this.mCurChangedTime = networkState.mCurChangedTime;
            return;
        }
        throw new NullPointerException("NetworkState is Null");
    }
}
