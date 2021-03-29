package com.baidu.tbadk.core.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.p.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class EmotionUtil {
    public static final String NEW_EMOTION_SHARPTEXT_PREFIX = "#(meme,";
    public static final String NEW_EMOTION_SHARPTEXT_PREFIX_SHORT = "meme,";
    public static final String TABLE_NAME_USER_EMOTIONS = "user_emotions";

    public static void statisticsEmotionGroupNums() {
        new Thread(new Runnable() { // from class: com.baidu.tbadk.core.util.EmotionUtil.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                Cursor cursor = null;
                try {
                    cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    while (cursor.moveToNext()) {
                        i++;
                    }
                } finally {
                    try {
                        m.a(cursor);
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_TOTAL_NUM);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_param1", i);
                        TiebaStatic.log(statisticItem);
                    } catch (Throwable th) {
                    }
                }
                m.a(cursor);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_TOTAL_NUM);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_param1", i);
                TiebaStatic.log(statisticItem2);
            }
        }).start();
    }

    public static void statisticsEmotionUse(String str) {
        CustomResponsedMessage runTask;
        Matcher matcher = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)").matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && !((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split = matcher2.group().split(",");
            if (split != null && split.length == 5) {
                String str2 = split[1];
                if (!TextUtils.isEmpty(str2) && str2.contains("_") && !str2.contains("collect_")) {
                    i++;
                }
            }
        }
        if (i > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
            statisticItem.param("obj_param1", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
