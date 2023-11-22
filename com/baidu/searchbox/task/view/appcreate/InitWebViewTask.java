package com.baidu.searchbox.task.view.appcreate;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.ckc;
import com.baidu.tieba.ig6;
/* loaded from: classes4.dex */
public class InitWebViewTask extends LaunchTask {
    public static final String KEY_UA_SKIN = "skin/";
    public static final String KEY_UA_SPACE = " ";
    public static final String KEY_UA_TIEBA = "tieba/";

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitWebViewTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            ig6 ig6Var = new ig6();
            ig6Var.j(TbadkCoreApplication.getInst().isDebugMode());
            ig6.d(new ckc<String, Pair<Boolean, String>>() { // from class: com.baidu.searchbox.task.view.appcreate.InitWebViewTask.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ckc
                public Pair<Boolean, String> call(String str) {
                    return InitWebViewTask.updateUA(str);
                }
            });
            ig6.b(TbadkCoreApplication.getInst(), ig6Var);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @RequiresApi(api = 5)
    public static Pair<Boolean, String> updateUA(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(Boolean.FALSE, null);
        }
        if (!str.contains(KEY_UA_TIEBA)) {
            str = str + str + " " + KEY_UA_TIEBA;
        }
        if (!str.contains(KEY_UA_SKIN)) {
            str = str + str + " " + KEY_UA_SKIN;
        }
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2)) {
                if (str2.startsWith(KEY_UA_TIEBA)) {
                    sb.append(KEY_UA_TIEBA);
                    sb.append(TbConfig.getVersion());
                } else if (str2.startsWith(KEY_UA_SKIN)) {
                    sb.append(KEY_UA_SKIN);
                    sb.append(SkinManager.getCurrentSkinTypeString());
                } else {
                    sb.append(str2);
                }
                if (i != split.length - 1) {
                    sb.append(" ");
                }
            }
        }
        if (!str.equals(sb.toString())) {
            return new Pair<>(Boolean.TRUE, sb.toString());
        }
        return new Pair<>(Boolean.FALSE, sb.toString());
    }
}
