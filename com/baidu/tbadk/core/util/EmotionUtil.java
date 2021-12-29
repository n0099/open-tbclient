package com.baidu.tbadk.core.util;

import android.database.Cursor;
import android.text.TextUtils;
import c.a.d.f.p.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class EmotionUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NEW_EMOTION_SHARPTEXT_PREFIX = "#(meme,";
    public static final String NEW_EMOTION_SHARPTEXT_PREFIX_SHORT = "meme,";
    public static final String TABLE_NAME_USER_EMOTIONS = "user_emotions";
    public transient /* synthetic */ FieldHolder $fh;

    public EmotionUtil() {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static void statisticsEmotionGroupNums() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            int i2 = 0;
            Cursor cursor = null;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{TbadkCoreApplication.getCurrentAccount()});
                while (cursor.moveToNext()) {
                    i2++;
                }
            } finally {
                try {
                    o.a(cursor);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_TOTAL_NUM);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_param1", i2);
                    TiebaStatic.log(statisticItem);
                } catch (Throwable th) {
                }
            }
            o.a(cursor);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_TOTAL_NUM);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("obj_param1", i2);
            TiebaStatic.log(statisticItem2);
        }
    }

    public static void statisticsEmotionUse(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            Matcher matcher = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)").matcher(str);
            int i2 = 0;
            while (matcher.find()) {
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && !((Boolean) runTask.getData()).booleanValue()) {
                    i2++;
                }
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
            while (matcher2.find()) {
                String[] split = matcher2.group().split(",");
                if (split != null && split.length == 5) {
                    String str2 = split[1];
                    if (!TextUtils.isEmpty(str2) && str2.contains("_") && !str2.contains("collect_")) {
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
                statisticItem.param("obj_param1", i2);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
