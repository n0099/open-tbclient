package com.baidu.tbadk.core.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    public static void Al(String str) {
        int i;
        CustomResponsedMessage runTask;
        int i2 = 0;
        Matcher matcher = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)").matcher(str);
        while (true) {
            i = i2;
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && !((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
            i2 = i;
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split = matcher2.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5) {
                String str2 = split[1];
                if (!TextUtils.isEmpty(str2) && str2.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !str2.contains("collect_")) {
                    i++;
                }
            }
        }
        if (i > 0) {
            aq aqVar = new aq(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
            aqVar.ai("obj_param1", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void bjt() {
        new Thread(new Runnable() { // from class: com.baidu.tbadk.core.util.j.1
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor;
                Throwable th;
                int i;
                com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
                try {
                    cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    i = 0;
                    while (cursor.moveToNext()) {
                        try {
                            i++;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.listMyEmotions");
                                com.baidu.adp.lib.util.n.close(cursor);
                                aq aqVar = new aq(TbadkCoreStatisticKey.FACESHOP_TOTAL_NUM);
                                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                aqVar.ai("obj_param1", i);
                                TiebaStatic.log(aqVar);
                            } catch (Throwable th3) {
                                com.baidu.adp.lib.util.n.close(cursor);
                                throw th3;
                            }
                        }
                    }
                    com.baidu.adp.lib.util.n.close(cursor);
                } catch (Throwable th4) {
                    cursor = null;
                    th = th4;
                    i = 0;
                }
                aq aqVar2 = new aq(TbadkCoreStatisticKey.FACESHOP_TOTAL_NUM);
                aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.ai("obj_param1", i);
                TiebaStatic.log(aqVar2);
            }
        }).start();
    }
}
