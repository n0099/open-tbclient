package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    public static void di(String str) {
        CustomResponsedMessage runTask;
        Matcher matcher = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)").matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && !((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split = matcher2.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5) {
                String str2 = split[1];
                if (!TextUtils.isEmpty(str2) && str2.contains("_") && !str2.contains("collect_")) {
                    i++;
                }
            }
        }
        if (i > 0) {
            au auVar = new au("c12231");
            auVar.r("obj_param1", i);
            TiebaStatic.log(auVar);
        }
    }

    public static void ur() {
        new Thread(new k()).start();
    }
}
