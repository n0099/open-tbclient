package com.baidu.android.util.concurrent.task;

import com.baidu.android.util.concurrent.task.TaskManager;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class TaskOperation {
    private Object[] mNextTaskParams;
    private TaskManager.TaskManagerState mTaskManagerStatus;

    public TaskOperation() {
        this.mNextTaskParams = null;
        this.mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;
    }

    public TaskOperation(Object[] objArr) {
        this.mNextTaskParams = null;
        this.mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;
        this.mNextTaskParams = objArr;
    }

    public TaskOperation(TaskOperation taskOperation) {
        this.mNextTaskParams = null;
        this.mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;
        setTaskParams(taskOperation);
    }

    public Object[] getTaskParams() {
        return this.mNextTaskParams;
    }

    public void setTaskParamsEmpty() {
        this.mNextTaskParams = null;
    }

    public void setTaskParams(Object[] objArr) {
        this.mNextTaskParams = objArr;
    }

    public void setTaskParams(TaskOperation taskOperation) {
        Object[] taskParams;
        if (taskOperation == this) {
            throw new IllegalArgumentException("The argument can NOT be self.");
        }
        if (taskOperation != null && (taskParams = taskOperation.getTaskParams()) != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mNextTaskParams != null) {
                for (Object obj : this.mNextTaskParams) {
                    arrayList.add(obj);
                }
            }
            for (Object obj2 : taskParams) {
                arrayList.add(obj2);
            }
            this.mNextTaskParams = arrayList.toArray();
        }
    }

    public void setTaskManagerStatus(TaskManager.TaskManagerState taskManagerState) {
        this.mTaskManagerStatus = taskManagerState;
    }

    public TaskManager.TaskManagerState getTaskManagerStatus() {
        return this.mTaskManagerStatus;
    }

    public void appendTaskParam(Object obj) {
        appendTaskParams(new Object[]{obj});
    }

    public void appendTaskParams(Object[] objArr) {
        if (objArr != null) {
            setTaskParams(new TaskOperation(objArr));
        }
    }
}
