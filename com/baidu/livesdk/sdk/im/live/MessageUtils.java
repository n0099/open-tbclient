package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.livesdk.R;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class MessageUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MessageUtils() {
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

    public static boolean canCopy(LiveMessageBean liveMessageBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveMessageBean)) == null) {
            if (liveMessageBean == null) {
                return false;
            }
            int i2 = -1;
            try {
                i2 = Integer.parseInt(liveMessageBean.message_type);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 || i2 == 2 || i2 == 3;
        }
        return invokeL.booleanValue;
    }

    public static String convertToText(Context context, LiveMessageBean liveMessageBean) {
        int i2;
        LiveMessageBean.Txt txt;
        LiveMessageBean.Txt txt2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, liveMessageBean)) == null) {
            try {
                i2 = Integer.parseInt(liveMessageBean.message_type);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            String str = "";
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return "" + context.getString(R.string.livesdk_not_support_msg_type);
                            }
                            return "" + context.getString(R.string.livesdk_voice);
                        }
                    }
                }
                LiveMessageBean.MessageBody messageBody = liveMessageBean.message_body;
                if (messageBody != null && (txt2 = messageBody.txt) != null && !TextUtils.isEmpty(txt2.word)) {
                    str = liveMessageBean.message_body.txt.word;
                }
                return str + context.getString(R.string.livesdk_pic);
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
            return context.getString(R.string.livesdk_reply) + liveMessageBean.at_name + " ";
        }
        return (String) invokeLL.objValue;
    }

    public static int halfSearch(List<LiveMessageBean> list, boolean z, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{list, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            int size = list.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) / 2;
                if (j < list.get(i3).msgId) {
                    if (z) {
                        size = i3 - 1;
                    } else {
                        i2 = i3 + 1;
                    }
                } else if (j <= list.get(i3).msgId) {
                    return i3;
                } else {
                    if (z) {
                        i2 = i3 + 1;
                    } else {
                        size = i3 - 1;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, messageBody)) == null) ? (messageBody == null || (link = messageBody.link) == null || TextUtils.isEmpty(link.url)) ? false : true : invokeL.booleanValue;
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
