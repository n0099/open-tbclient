package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.livesdk.R;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageUtils {
    public static boolean canCopy(LiveMessageBean liveMessageBean) {
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

    public static String convertToText(Context context, LiveMessageBean liveMessageBean) {
        int i;
        LiveMessageBean.Txt txt;
        LiveMessageBean.Txt txt2;
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

    public static String createOldVideoLiveMessage(Context context, LiveMessageBean liveMessageBean, boolean z) {
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

    public static String getReplyNamePre(Context context, LiveMessageBean liveMessageBean) {
        if (liveMessageBean == null || TextUtils.isEmpty(liveMessageBean.at_uid)) {
            return "";
        }
        return context.getString(R.string.livesdk_reply) + liveMessageBean.at_name + " ";
    }

    public static int halfSearch(List<LiveMessageBean> list, boolean z, long j) {
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

    public static boolean hasLink(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Link link;
        return (messageBody == null || (link = messageBody.link) == null || TextUtils.isEmpty(link.url)) ? false : true;
    }

    public static boolean hasPic(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Pic pic;
        LiveMessageBean.Pic.ImageInfo imageInfo;
        return (messageBody == null || (pic = messageBody.pic) == null || (imageInfo = pic.thumbnail) == null || TextUtils.isEmpty(imageInfo.url)) ? false : true;
    }

    public static boolean hasText(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Txt txt;
        return (messageBody == null || (txt = messageBody.txt) == null || TextUtils.isEmpty(txt.word)) ? false : true;
    }

    public static boolean hasVoice(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Voice voice;
        return (messageBody == null || (voice = messageBody.voice) == null || TextUtils.isEmpty(voice.url)) ? false : true;
    }

    public static void trimReplayMessage(Context context, LiveMessageBean liveMessageBean) {
        LiveMessageBean.MessageBody messageBody;
        LiveMessageBean.Txt txt;
        if (liveMessageBean == null || (messageBody = liveMessageBean.at_message_body) == null || (txt = messageBody.txt) == null || TextUtils.isEmpty(txt.word)) {
            return;
        }
        String replyNamePre = getReplyNamePre(context, liveMessageBean);
        if (liveMessageBean.at_message_body.txt.word.startsWith(replyNamePre)) {
            LiveMessageBean.Txt txt2 = liveMessageBean.at_message_body.txt;
            txt2.word = txt2.word.replace(replyNamePre, "");
        }
    }
}
