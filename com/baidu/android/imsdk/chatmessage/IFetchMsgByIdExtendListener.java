package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class IFetchMsgByIdExtendListener implements IFetchMsgByIdListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IFetchMsgByIdExtendListener() {
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

    @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
    public void onFetchMsgByIdResult(int i2, String str, String str2, int i3, long j, long j2, long j3, int i4, int i5, long j4, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j4), arrayList}) == null) {
        }
    }

    public abstract void onFetchMsgByIdResult(int i2, String str, String str2, int i3, long j, long j2, long j3, int i4, int i5, long j4, ArrayList<ChatMsg> arrayList, boolean z);
}
