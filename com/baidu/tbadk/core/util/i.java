package com.baidu.tbadk.core.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    public static void dQ(String str) {
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
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && !((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
            i2 = i;
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
            an anVar = new an("c12231");
            anVar.r("obj_param1", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void yg() {
        new Thread(new Runnable() { // from class: com.baidu.tbadk.core.util.i.1
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor;
                Throwable th;
                int i;
                com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
                try {
                    cursor = mainDBDatabaseManager.eD().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    i = 0;
                    while (cursor.moveToNext()) {
                        try {
                            i++;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                mainDBDatabaseManager.a(th, "EmotionsDBManager.listMyEmotions");
                                com.baidu.adp.lib.util.n.e(cursor);
                                an anVar = new an("c12232");
                                anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                                anVar.r("obj_param1", i);
                                TiebaStatic.log(anVar);
                            } catch (Throwable th3) {
                                com.baidu.adp.lib.util.n.e(cursor);
                                throw th3;
                            }
                        }
                    }
                    com.baidu.adp.lib.util.n.e(cursor);
                } catch (Throwable th4) {
                    cursor = null;
                    th = th4;
                    i = 0;
                }
                an anVar2 = new an("c12232");
                anVar2.ae("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.r("obj_param1", i);
                TiebaStatic.log(anVar2);
            }
        }).start();
    }
}
