package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class RecorderManagerStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001271, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.audiorecorder.lib.voice.RecorderManagerStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.tbadkCore.voice.a> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001271, e.pJ());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001272, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.audiorecorder.lib.voice.RecorderManagerStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001272, new com.baidu.audiorecorder.a.c(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001274, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.audiorecorder.lib.voice.RecorderManagerStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
                return new CustomResponsedMessage<>(2001274, Boolean.TRUE);
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2001291, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.audiorecorder.lib.voice.RecorderManagerStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001291, new a());
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2001301, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.audiorecorder.lib.voice.RecorderManagerStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001301, new com.baidu.audiorecorder.a.a(customMessage.getData()));
            }
        });
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        CustomMessageTask customMessageTask6 = new CustomMessageTask(2001448, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.audiorecorder.lib.voice.RecorderManagerStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001448, new com.baidu.audiorecorder.a.b(customMessage.getData()));
            }
        });
        customMessageTask6.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask6);
        TbadkCoreApplication.getInst().setAudioRecorderExist(true);
    }

    /* loaded from: classes3.dex */
    static class a {
        a() {
        }
    }
}
