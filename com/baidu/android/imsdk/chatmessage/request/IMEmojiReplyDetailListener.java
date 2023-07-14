package com.baidu.android.imsdk.chatmessage.request;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IMEmojiReplyDetailListener extends IMListener {
    void onResult(int i, String str, IMEmojiReplyDetailResponse iMEmojiReplyDetailResponse);

    /* loaded from: classes.dex */
    public static class IMEmojiReplyDetailRequestInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String emojiContent;
        public long emojiPackageId;
        public int fetchCount;
        public long msgId;
        public long roomId;
        public long sortTimeBegin;
        public long sortTimeEnd;

        public IMEmojiReplyDetailRequestInfo() {
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
    }

    /* loaded from: classes.dex */
    public static class IMEmojiReplyDetailResponse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<IMEmojiReplyReactionDetail> emojiReplyDetailList;
        public int hasMore;

        public IMEmojiReplyDetailResponse() {
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
            this.emojiReplyDetailList = new ArrayList<>();
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "IMEmojiReplyListResponse{hasMore=" + this.hasMore + ", emojiReplyOfMsg=" + this.emojiReplyDetailList.toString() + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class IMEmojiReplyReactionDetail {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bduk;
        public long sortTimeUs;

        public IMEmojiReplyReactionDetail() {
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
                return "IMEmojiReplyReactionDetail{bduid=" + this.bduk + ", sortTimeUs='" + this.sortTimeUs + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
