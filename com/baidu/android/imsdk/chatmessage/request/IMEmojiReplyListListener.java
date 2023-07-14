package com.baidu.android.imsdk.chatmessage.request;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface IMEmojiReplyListListener extends IMListener {
    void onResult(int i, String str, int i2, IMEmojiReplyListResponse iMEmojiReplyListResponse);

    /* loaded from: classes.dex */
    public static class IMEmojiItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int allNum;
        public String emojiContent;
        public int hasReacted;
        public long minSortTimeUs;
        public long msgId;
        public String msgKey;

        public IMEmojiItem() {
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
                return "IMEmojiItem{msgKey='" + this.msgId + "', msgKey='" + this.msgKey + "', emojiContent='" + this.emojiContent + "', allNum=" + this.allNum + ", minSortTimeUs=" + this.minSortTimeUs + ", hasReacted=" + this.hasReacted + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class IMEmojiReplyListRequestInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int emojiPackageId;
        public ArrayList<Long> msgs;
        public long roomId;

        public IMEmojiReplyListRequestInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.msgs = new ArrayList<>();
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "IMEmojiReplyListRequestInfo{msgs=" + this.msgs.toString() + ", emojiPackageId=" + this.emojiPackageId + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class IMEmojiReplyListResponse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<Long, ArrayList<IMEmojiItem>> emojiReplyMap;

        public IMEmojiReplyListResponse() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.emojiReplyMap = new HashMap<>();
        }
    }
}
