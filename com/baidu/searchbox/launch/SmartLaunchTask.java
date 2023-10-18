package com.baidu.searchbox.launch;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class SmartLaunchTask implements Runnable, Comparable<SmartLaunchTask> {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int HIGH_PRIORITY = 3;
    public static final int LOWEST_PRIORITY = 0;
    public static final int LOW_PRIORITY = 1;
    public static final int NORM_PRIORITY = 2;
    public static final String TAG = "SmartLaunchTask";
    public long endTime;
    public String id;
    public Boolean isExecuted;
    public boolean isMainThreadIdleTask;
    public List<SmartLaunchTask> mDependencyList;
    public String name;
    public int priority;
    public double score;
    public long startTime;
    public int type;

    public abstract void execute();

    public SmartLaunchTask() {
        this.priority = 2;
        this.isExecuted = Boolean.FALSE;
        this.startTime = 0L;
        this.endTime = 0L;
        this.type = 0;
        this.score = -1.0d;
        this.isMainThreadIdleTask = false;
        this.mDependencyList = null;
    }

    public List<SmartLaunchTask> getDependency() {
        return this.mDependencyList;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public double getScore() {
        return this.score;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getType() {
        return this.type;
    }

    public boolean isExecuted() {
        return this.isExecuted.booleanValue();
    }

    public boolean isMainThreadIdleTask() {
        return this.isMainThreadIdleTask;
    }

    public void removeAllDependency() {
        List<SmartLaunchTask> list = this.mDependencyList;
        if (list != null) {
            list.clear();
        }
    }

    public SmartLaunchTask(String str) {
        this(str, null);
    }

    public void addDependency(SmartLaunchTask smartLaunchTask) {
        if (this.mDependencyList == null) {
            this.mDependencyList = new ArrayList();
        }
        this.mDependencyList.add(smartLaunchTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull SmartLaunchTask smartLaunchTask) {
        if (this.priority > smartLaunchTask.getPriority()) {
            return -1;
        }
        if (this.priority < smartLaunchTask.getPriority()) {
            return 1;
        }
        if (this.score > smartLaunchTask.getScore()) {
            return -1;
        }
        if (this.score < smartLaunchTask.getScore()) {
            return 1;
        }
        return 0;
    }

    public void removeDependency(SmartLaunchTask smartLaunchTask) {
        List<SmartLaunchTask> list = this.mDependencyList;
        if (list != null) {
            list.remove(smartLaunchTask);
        }
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setScore(double d) {
        this.score = d;
    }

    public void setType(int i) {
        this.type = i;
    }

    public SmartLaunchTask(String str, int i, boolean z) {
        this.priority = 2;
        this.isExecuted = Boolean.FALSE;
        this.startTime = 0L;
        this.endTime = 0L;
        this.type = 0;
        this.score = -1.0d;
        this.isMainThreadIdleTask = false;
        this.mDependencyList = null;
        this.id = str;
        this.priority = i;
        this.isMainThreadIdleTask = z;
    }

    public SmartLaunchTask(String str, String str2) {
        this.priority = 2;
        this.isExecuted = Boolean.FALSE;
        this.startTime = 0L;
        this.endTime = 0L;
        this.type = 0;
        this.score = -1.0d;
        this.isMainThreadIdleTask = false;
        this.mDependencyList = null;
        this.id = str;
        this.name = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.startTime = System.currentTimeMillis();
        execute();
        this.isExecuted = Boolean.TRUE;
        this.endTime = System.currentTimeMillis();
        if (DEBUG) {
            Log.d(TAG, "task id: " + this.id + " name: " + this.name + " startTime: " + this.startTime + " endTime " + this.endTime + " duration: " + (this.endTime - this.startTime));
        }
    }
}
