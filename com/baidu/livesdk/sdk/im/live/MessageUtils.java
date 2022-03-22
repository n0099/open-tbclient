package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class MessageUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MessageUtils() {
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

    public static boolean canCopy(LiveMessageBean liveMessageBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveMessageBean)) == null) {
            if (liveMessageBean == null) {
                return false;
            }
            int i = -1;
            try {
                i = Integer.parseInt(liveMessageBean.message_type);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i == 0 || i == 2 || i == 3;
        }
        return invokeL.booleanValue;
    }

    public static String convertToText(Context context, LiveMessageBean liveMessageBean) {
        int i;
        LiveMessageBean.Txt txt;
        LiveMessageBean.Txt txt2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, liveMessageBean)) == null) {
            try {
                i = Integer.parseInt(liveMessageBean.message_type);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                i = -1;
            }
            String str = "";
            if (i != 0) {
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return "" + context.getString(R.string.obfuscated_res_0x7f0f0a1e);
                            }
                            return "" + context.getString(R.string.obfuscated_res_0x7f0f0a21);
                        }
                    }
                }
                LiveMessageBean.MessageBody messageBody = liveMessageBean.message_body;
                if (messageBody != null && (txt2 = messageBody.txt) != null && !TextUtils.isEmpty(txt2.word)) {
                    str = liveMessageBean.message_body.txt.word;
                }
                return str + context.getString(R.string.obfuscated_res_0x7f0f0a1f);
            }
            LiveMessageBean.MessageBody messageBody2 = liveMessageBean.message_body;
            if (messageBody2 == null || (txt = messageBody2.txt) == null || TextUtils.isEmpty(txt.word)) {
                return "";
            }
            return "" + liveMessageBean.message_body.txt.word;
        }
        return (String) invokeLL.objValue;
    }

    public static String createOldVideoLiveMessage(Context context, LiveMessageBean liveMessageBean, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, context, liveMessageBean, z)) == null) {
            String convertToText = convertToText(context, liveMessageBean);
            if (!z || TextUtils.isEmpty(liveMessageBean.at_uid)) {
                return convertToText;
            }
            String replyNamePre = getReplyNamePre(context, liveMessageBean);
            if (convertToText.startsWith(replyNamePre)) {
                return convertToText;
            }
            return replyNamePre + convertToText;
        }
        return (String) invokeLLZ.objValue;
    }

    public static String getReplyNamePre(Context context, LiveMessageBean liveMessageBean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, liveMessageBean)) == null) {
            if (liveMessageBean == null || TextUtils.isEmpty(liveMessageBean.at_uid)) {
                return "";
            }
            return context.getString(R.string.obfuscated_res_0x7f0f0a20) + liveMessageBean.at_name + " ";
        }
        return (String) invokeLL.objValue;
    }

    public static int halfSearch(List<LiveMessageBean> list, boolean z, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{list, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            int size = list.size() - 1;
            int i = 0;
            while (i <= size) {
                int i2 = (i + size) / 2;
                if (j < list.get(i2).msgId) {
                    if (z) {
                        size = i2 - 1;
                    } else {
                        i = i2 + 1;
                    }
                } else if (j <= list.get(i2).msgId) {
                    return i2;
                } else {
                    if (z) {
                        i = i2 + 1;
                    } else {
                        size = i2 - 1;
                    }
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean hasLink(LiveMessageBean.MessageBody messageBody) {
        InterceptResult invokeL;
        LiveMessageBean.Link link;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, messageBody)) == null) ? (messageBody == null || (link = messageBody.link) == null || TextUtils.isEmpty(link.url)) ? false : true : invokeL.booleanValue;
    }

    public static boolean hasPic(LiveMessageBean.MessageBody messageBody) {
        InterceptResult invokeL;
        LiveMessageBean.Pic pic;
        LiveMessageBean.Pic.ImageInfo imageInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, messageBody)) == null) ? (messageBody == null || (pic = messageBody.pic) == null || (imageInfo = pic.thumbnail) == null || TextUtils.isEmpty(imageInfo.url)) ? false : true : invokeL.booleanValue;
    }

    public static boolean hasText(LiveMessageBean.MessageBody messageBody) {
        InterceptResult invokeL;
        LiveMessageBean.Txt txt;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, messageBody)) == null) ? (messageBody == null || (txt = messageBody.txt) == null || TextUtils.isEmpty(txt.word)) ? false : true : invokeL.booleanValue;
    }

    public static boolean hasVoice(LiveMessageBean.MessageBody messageBody) {
        InterceptResult invokeL;
        LiveMessageBean.Voice voice;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, messageBody)) == null) ? (messageBody == null || (voice = messageBody.voice) == null || TextUtils.isEmpty(voice.url)) ? false : true : invokeL.booleanValue;
    }

    public static void trimReplayMessage(Context context, LiveMessageBean liveMessageBean) {
        LiveMessageBean.MessageBody messageBody;
        LiveMessageBean.Txt txt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, liveMessageBean) == null) || liveMessageBean == null || (messageBody = liveMessageBean.at_message_body) == null || (txt = messageBody.txt) == null || TextUtils.isEmpty(txt.word)) {
            return;
        }
        String replyNamePre = getReplyNamePre(context, liveMessageBean);
        if (liveMessageBean.at_message_body.txt.word.startsWith(replyNamePre)) {
            LiveMessageBean.Txt txt2 = liveMessageBean.at_message_body.txt;
            txt2.word = txt2.word.replace(replyNamePre, "");
        }
    }
}
