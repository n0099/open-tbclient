package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import com.baidu.tieba.R;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != 0 && i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    public static boolean hasLink(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Link link;
        if (messageBody != null && (link = messageBody.link) != null && !TextUtils.isEmpty(link.url)) {
            return true;
        }
        return false;
    }

    public static boolean hasPic(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Pic pic;
        LiveMessageBean.Pic.ImageInfo imageInfo;
        if (messageBody != null && (pic = messageBody.pic) != null && (imageInfo = pic.thumbnail) != null && !TextUtils.isEmpty(imageInfo.url)) {
            return true;
        }
        return false;
    }

    public static boolean hasText(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Txt txt;
        if (messageBody != null && (txt = messageBody.txt) != null && !TextUtils.isEmpty(txt.word)) {
            return true;
        }
        return false;
    }

    public static boolean hasVoice(LiveMessageBean.MessageBody messageBody) {
        LiveMessageBean.Voice voice;
        if (messageBody != null && (voice = messageBody.voice) != null && !TextUtils.isEmpty(voice.url)) {
            return true;
        }
        return false;
    }

    public static String convertToText(Context context, LiveMessageBean liveMessageBean) {
        int i;
        LiveMessageBean.Txt txt;
        LiveMessageBean.Txt txt2;
        try {
            i = Integer.parseInt(liveMessageBean.message_type);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = -1;
        }
        String str = "";
        if (i != 0) {
            if (i != 1 && i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return "" + context.getString(R.string.obfuscated_res_0x7f0f0ae2);
                        }
                        return "" + context.getString(R.string.obfuscated_res_0x7f0f0ae5);
                    }
                }
            }
            LiveMessageBean.MessageBody messageBody = liveMessageBean.message_body;
            if (messageBody != null && (txt2 = messageBody.txt) != null && !TextUtils.isEmpty(txt2.word)) {
                str = liveMessageBean.message_body.txt.word;
            }
            return str + context.getString(R.string.obfuscated_res_0x7f0f0ae3);
        }
        LiveMessageBean.MessageBody messageBody2 = liveMessageBean.message_body;
        if (messageBody2 == null || (txt = messageBody2.txt) == null || TextUtils.isEmpty(txt.word)) {
            return "";
        }
        return "" + liveMessageBean.message_body.txt.word;
    }

    public static String createOldVideoLiveMessage(Context context, LiveMessageBean liveMessageBean, boolean z) {
        String convertToText = convertToText(context, liveMessageBean);
        if (z && !TextUtils.isEmpty(liveMessageBean.at_uid)) {
            String replyNamePre = getReplyNamePre(context, liveMessageBean);
            if (!convertToText.startsWith(replyNamePre)) {
                return replyNamePre + convertToText;
            }
            return convertToText;
        }
        return convertToText;
    }

    public static String getReplyNamePre(Context context, LiveMessageBean liveMessageBean) {
        if (liveMessageBean != null && !TextUtils.isEmpty(liveMessageBean.at_uid)) {
            return context.getString(R.string.obfuscated_res_0x7f0f0ae4) + liveMessageBean.at_name + " ";
        }
        return "";
    }

    public static void trimReplayMessage(Context context, LiveMessageBean liveMessageBean) {
        LiveMessageBean.MessageBody messageBody;
        LiveMessageBean.Txt txt;
        if (liveMessageBean != null && (messageBody = liveMessageBean.at_message_body) != null && (txt = messageBody.txt) != null && !TextUtils.isEmpty(txt.word)) {
            String replyNamePre = getReplyNamePre(context, liveMessageBean);
            if (liveMessageBean.at_message_body.txt.word.startsWith(replyNamePre)) {
                LiveMessageBean.Txt txt2 = liveMessageBean.at_message_body.txt;
                txt2.word = txt2.word.replace(replyNamePre, "");
            }
        }
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
            } else if (j > list.get(i2).msgId) {
                if (!z) {
                    size = i2 - 1;
                } else {
                    i = i2 + 1;
                }
            } else {
                return i2;
            }
        }
        return -1;
    }
}
