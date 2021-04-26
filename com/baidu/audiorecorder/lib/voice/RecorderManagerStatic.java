package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.i0.w.m;
/* loaded from: classes.dex */
public class RecorderManagerStatic {

    /* loaded from: classes.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Activity> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.j0.d3.p0.a> run(CustomMessage<Activity> customMessage) {
            return new CustomResponsedMessage<>(2001271, d.a.f.a.a.e.n());
        }
    }

    /* loaded from: classes.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Context> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                return null;
            }
            return new CustomResponsedMessage<>(2001272, new d.a.f.b.c(customMessage.getData()));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements CustomMessageTask.CustomRunnable<Boolean> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            return new CustomResponsedMessage<>(2001274, Boolean.TRUE);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Void> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            return new CustomResponsedMessage<>(2001291, new g());
        }
    }

    /* loaded from: classes.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Context> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                return null;
            }
            return new CustomResponsedMessage<>(2001301, new d.a.f.b.a(customMessage.getData()));
        }
    }

    /* loaded from: classes.dex */
    public static class f implements CustomMessageTask.CustomRunnable<Context> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                return null;
            }
            return new CustomResponsedMessage<>(2001448, new d.a.f.b.b(customMessage.getData()));
        }
    }

    /* loaded from: classes.dex */
    public static class g {
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001271, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001272, new b());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001274, new c());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2001291, new d());
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2001301, new e());
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        CustomMessageTask customMessageTask6 = new CustomMessageTask(2001448, new f());
        customMessageTask6.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask6);
        TbadkCoreApplication.getInst().setAudioRecorderExist(true);
    }
}
