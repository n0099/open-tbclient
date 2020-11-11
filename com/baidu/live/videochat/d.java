package com.baidu.live.videochat;

import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
/* loaded from: classes4.dex */
public class d {
    public static String G(String str, int i) {
        if (TextHelper.getTextLengthWithEmoji(str) > i) {
            return TextHelper.subStringWithEmoji(str, i) + StringHelper.STRING_MORE;
        }
        return str;
    }
}
