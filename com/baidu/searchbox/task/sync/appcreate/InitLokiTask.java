package com.baidu.searchbox.task.sync.appcreate;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.LogSystemProcessor;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseUncaughtExceptionHandler;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingDeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.util.AppExtraUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.util.TBCrashHandler;
import com.baidu.searchbox.util.TBCrashHelper;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hk1;
import com.baidu.tieba.n85;
import com.baidu.tieba.o85;
import com.baidu.tieba.p85;
import com.baidu.tieba.r10;
import com.baidu.tieba.s85;
import com.baidu.tieba.wl;
import java.io.File;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InitLokiTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitLoki";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initLoki();
    }

    private void initLoki() {
        if (!GlobalBuildConfig.isDebug() && !userIgnore()) {
            if (Loki.isLokiService(hk1.b())) {
                ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler = new ForwardingDeviceEventSceneHandler();
                forwardingDeviceEventSceneHandler.addEventHandleCallback(new o85());
                LinkedList linkedList = new LinkedList();
                linkedList.add(new LogSystemUploaderStrategy(true, true));
                Loki.initService(new LogSystemProcessor(forwardingDeviceEventSceneHandler, linkedList));
                Loki.setAppExtraCall(new AppExtraUtil.AppExtraCall() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.1
                    @Override // com.baidu.searchbox.logsystem.util.AppExtraUtil.AppExtraCall
                    public JSONObject getAppExtraInfo() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tieba", " extraInfo");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return jSONObject;
                    }
                });
                return;
            }
            lokiAdvancedInit(TbadkCoreApplication.getInst());
        }
    }

    private boolean userIgnore() {
        if ("AE3AA5A9D272F7A397A7AA454D2DB2DE|AD8A01E500000A".equals(TbadkCoreApplication.getInst().getCuid()) || "4E88E57B80B314BAAEA99F40C45B4E4D|V6EWCJSHM".equals(TbadkCoreApplication.getInst().getCuid()) || "C18E2432AD14017741535E88E697A17E|VNB4UHZR2".equals(TbadkCoreApplication.getInst().getCuid()) || "964FF620C8B03D2D0DD1E5F3A1826EAA|0".equals(TbadkCoreApplication.getInst().getCuid())) {
            return true;
        }
        return false;
    }

    private void lokiAdvancedInit(Context context) {
        Supplier<List<ProcessEventSceneHandler>> supplier;
        Supplier<List<ProcessEventSceneHandler>> supplier2 = new Supplier<List<ProcessEventSceneHandler>>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.common.others.java.Supplier
            public List<ProcessEventSceneHandler> get() {
                LinkedList linkedList = new LinkedList();
                linkedList.add(new p85());
                return linkedList;
            }
        };
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BaseProcessExceptionListener() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.3
            @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener, com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
            public void onProcessExceptionFail(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th, @NonNull Throwable th2) {
                super.onProcessExceptionFail(uncaughtExceptionHandler, th, th2);
            }

            @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener, com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
            public void onProcessExceptionStart(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th) {
                super.onProcessExceptionStart(uncaughtExceptionHandler, th);
            }

            @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseProcessExceptionListener, com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
            public void onProcessExceptionSuccess(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th) {
                super.onProcessExceptionSuccess(uncaughtExceptionHandler, th);
            }
        });
        BaseUncaughtExceptionHandler baseUncaughtExceptionHandler = new BaseUncaughtExceptionHandler(context, linkedList, supplier2) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.4
            @Override // com.baidu.searchbox.logsystem.basic.javacrash.BaseUncaughtExceptionHandler, com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
            public void onReport(@NonNull Context context2, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
                if (TBCrashHelper.checkIsUploadOverMax()) {
                    return;
                }
                super.onReport(context2, str, file, logExtra);
            }

            @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
            public void onAttachExtra(@NonNull Context context2, @NonNull JSONObject jSONObject) {
                super.onAttachExtra(context2, jSONObject);
                if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                    s85.q().h();
                }
                n85.a(jSONObject);
            }

            @Override // com.baidu.searchbox.logsystem.basic.javacrash.BUncaughtExceptionHandler
            public void onDisasterRecovery(@NonNull Context context2) {
                super.onDisasterRecovery(context2);
            }
        };
        baseUncaughtExceptionHandler.setProcessLaunchTime(System.currentTimeMillis());
        Loki.init(context, baseUncaughtExceptionHandler);
        Track.getInstance().startTrack(AppRuntime.getAppContext());
        if (Build.VERSION.SDK_INT > 19) {
            supplier = new Supplier<List<ProcessEventSceneHandler>>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.common.others.java.Supplier
                public List<ProcessEventSceneHandler> get() {
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new p85());
                    return linkedList2;
                }
            };
        } else {
            supplier = null;
        }
        final r10 r10Var = new r10(context, supplier) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.6
            @Override // com.baidu.tieba.r10
            public void onAttachExtra(@NonNull Context context2, @NonNull JSONObject jSONObject) {
                super.onAttachExtra(context2, jSONObject);
                if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                    s85.q().h();
                }
                n85.a(jSONObject);
            }

            @Override // com.baidu.tieba.r10
            public void onDisasterRecovery(@NonNull Context context2) {
                super.onDisasterRecovery(context2);
            }

            @Override // com.baidu.tieba.r10
            public void onReport(@NonNull Context context2, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
                if (TBCrashHelper.checkIsUploadOverMax()) {
                    return;
                }
                super.onReport(context2, str, file, logExtra);
            }
        };
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLokiTask.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Loki.initNative(AppRuntime.getAppContext(), r10Var, true);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
        Thread.setDefaultUncaughtExceptionHandler(new TBCrashHandler(new wl(Thread.getDefaultUncaughtExceptionHandler())));
    }
}
