package com.baidu.searchbox.task.view.appcreate;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.tieba.wia;
import com.baidu.ubc.UBCManager;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/task/view/appcreate/InitMonitorTask;", "Lcom/baidu/searchbox/performance/speed/task/LaunchTask;", "()V", "buildJsonString", "Lorg/json/JSONObject;", "startNode", "Lcom/baidu/tieba/tracker/core/data/IEventNode;", "endNode", "execute", "", "getName", "", "getProcess", "", "Main_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InitMonitorTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitMonitorTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            Tracker a = Tracker.d.a();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            a.e(inst);
            Tracker.d.c(new wia() { // from class: com.baidu.searchbox.task.view.appcreate.InitMonitorTask$execute$1
                public String moduleName = "";

                @Override // com.baidu.tieba.wia
                public String getModuleName() {
                    return "pageMonitor";
                }

                @Override // com.baidu.tieba.wia
                public void onEventReport(String tid, IEventNode event) {
                    IEventNode iEventNode;
                    Intrinsics.checkNotNullParameter(tid, "tid");
                    Intrinsics.checkNotNullParameter(event, "event");
                    IEventNode next = event.getNext();
                    while (true) {
                        if (next != null) {
                            iEventNode = next.getNext();
                        } else {
                            iEventNode = null;
                        }
                        if (iEventNode != null) {
                            next = next.getNext();
                        } else {
                            this.buildJsonString(event, next);
                            return;
                        }
                    }
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
                @Override // com.baidu.tieba.wia
                public void onInit() {
                    objectRef.element = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                    UBCManager uBCManager = objectRef.element;
                    if (uBCManager != null) {
                        uBCManager.setUBCDebug(TbadkCoreApplication.getInst().isDebugMode());
                    }
                }

                @Override // com.baidu.tieba.wia
                public void setModuleName(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.moduleName = value;
                }
            });
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public final JSONObject buildJsonString(IEventNode startNode, IEventNode iEventNode) {
        String str = "1";
        Intrinsics.checkNotNullParameter(startNode, "startNode");
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<Object> it = startNode.getTrackParams().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("value", "1");
            JSONObject jSONObject2 = new JSONObject();
            if (iEventNode != null) {
                int i = iEventNode.getTrackParams().get(StatConstants.KEY_EXT_ERR_CODE);
                if (i == null) {
                    i = 0;
                }
                if (!Intrinsics.areEqual(i, (Object) 0)) {
                    str = "0";
                }
                jSONObject2.put("is_arrive", str);
                jSONObject2.put("duration", String.valueOf(iEventNode.getTimeStamp() - startNode.getTimeStamp()));
                jSONObject2.put("start_time", String.valueOf(startNode.getTimeStamp()));
                jSONObject2.put("end_time", String.valueOf(iEventNode.getTimeStamp()));
                jSONObject2.put(PushMessageHelper.ERROR_TYPE, String.valueOf(i));
            }
            jSONObject.put("ext", jSONObject2);
            return jSONObject;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
