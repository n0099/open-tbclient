package com.baidu.searchbox.process.ipc.delegate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ActivityResultDispatcher {
    private final Set<ActivityResultConsumer> mConsumers = new HashSet();
    public final Activity mHolder;
    public final int mRequestCode;

    public ActivityResultDispatcher(Activity activity, int i) {
        this.mHolder = activity;
        this.mRequestCode = i;
    }

    public synchronized void addConsumer(@Nullable ActivityResultConsumer activityResultConsumer) {
        if (activityResultConsumer != null) {
            this.mConsumers.add(activityResultConsumer);
        }
    }

    public synchronized void deleteConsumer(ActivityResultConsumer activityResultConsumer) {
        this.mConsumers.remove(activityResultConsumer);
    }

    public boolean notifyActivityResult(int i, int i2, Intent intent) {
        if (this.mRequestCode != i) {
            return false;
        }
        HashSet hashSet = new HashSet();
        synchronized (this) {
            for (ActivityResultConsumer activityResultConsumer : new HashSet(this.mConsumers)) {
                if (activityResultConsumer.consume(this, i2, intent)) {
                    hashSet.add(activityResultConsumer);
                }
            }
            this.mConsumers.removeAll(hashSet);
        }
        return !hashSet.isEmpty();
    }

    public synchronized void deleteConsumer() {
        this.mConsumers.clear();
    }

    public synchronized int countConsumer() {
        return this.mConsumers.size();
    }

    public void startActivityForResult(Intent intent) {
        this.mHolder.startActivityForResult(intent, this.mRequestCode);
    }

    public void startActivityForResult(Intent intent, Bundle bundle) {
        this.mHolder.startActivityForResult(intent, this.mRequestCode, bundle);
    }
}
