package com.baidu.searchbox.process.ipc.delegate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ActivityResultDispatcher {
    public final Set<ActivityResultConsumer> mConsumers = new HashSet();
    public final Activity mHolder;
    public final int mRequestCode;

    public ActivityResultDispatcher(Activity activity, int i2) {
        this.mHolder = activity;
        this.mRequestCode = i2;
    }

    public synchronized void addConsumer(@Nullable ActivityResultConsumer activityResultConsumer) {
        if (activityResultConsumer != null) {
            this.mConsumers.add(activityResultConsumer);
        }
    }

    public synchronized int countConsumer() {
        return this.mConsumers.size();
    }

    public synchronized void deleteConsumer(ActivityResultConsumer activityResultConsumer) {
        this.mConsumers.remove(activityResultConsumer);
    }

    public boolean notifyActivityResult(int i2, int i3, Intent intent) {
        if (this.mRequestCode != i2) {
            return false;
        }
        HashSet hashSet = new HashSet();
        synchronized (this) {
            for (ActivityResultConsumer activityResultConsumer : new HashSet(this.mConsumers)) {
                if (activityResultConsumer.consume(this, i3, intent)) {
                    hashSet.add(activityResultConsumer);
                }
            }
            this.mConsumers.removeAll(hashSet);
        }
        return !hashSet.isEmpty();
    }

    public void startActivityForResult(Intent intent) {
        this.mHolder.startActivityForResult(intent, this.mRequestCode);
    }

    public void startActivityForResult(Intent intent, Bundle bundle) {
        this.mHolder.startActivityForResult(intent, this.mRequestCode, bundle);
    }

    public synchronized void deleteConsumer() {
        this.mConsumers.clear();
    }
}
