package com.baidu.android.imsdk.mcast;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface IMEmojiReplyListener extends IMListener {
    void onResult(int i, String str);

    /* loaded from: classes.dex */
    public static class IMEmojiReplyRequestInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String emojiContent;
        public int emojiPackageId;
        public ChatMsg msg;
        public int opType;
        public long toUser;

        public IMEmojiReplyRequestInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "IMEmojiReplyRequestInfo{toUser=" + this.toUser + ", msg=" + this.msg + ", opType=" + this.opType + ", emojiPackageId=" + this.emojiPackageId + ", emojiContent='" + this.emojiContent + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
