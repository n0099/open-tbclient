package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.wu6;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class InitEmotionsTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitEmotions";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            Class.forName("com.baidu.tieba.faceshop.FaceshopStatic");
        } catch (Throwable th) {
            BdLog.e(th);
        }
        try {
            Class.forName("com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        } catch (Throwable th2) {
            BdLog.e(th2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        wu6.f();
    }
}
