package com.baidu.searchbox.player.event;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.pool.IPoolItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class VideoEvent implements IPoolItem {
    public static final int LOG_LEVEL_HIGH = 0;
    public static final int LOG_LEVEL_LOW = 1;
    public static final int PRIORITY_AT_ONCE = 1;
    public static final int PRIORITY_ENTER_QUEUE = 0;
    public static final int TYPE_CONTROL_EVENT = 2;
    public static final int TYPE_INTERACTIVE_EVENT = 8;
    public static final int TYPE_LAYER_EVENT = 3;
    public static final int TYPE_PLAYER_EVENT = 4;
    public static final int TYPE_PLUGIN_EVENT = 7;
    public static final int TYPE_STATE_EVENT = 5;
    public static final int TYPE_STATISTICS_EVENT = 6;
    public static final int TYPE_SYSTEM_EVENT = 1;
    public static final int TYPE_UNDEFINE_EVENT = -1;
    public static final VideoEventPool sEventPool = new VideoEventPool();
    public String action;
    public StringBuilder desc;
    public final SparseArray<Object> eventBundle;
    public int logLevel;
    public int priority;
    public Object sender;
    public int targetType;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LogLevel {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Priority {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }

    public VideoEvent() {
        this("");
    }

    @NonNull
    @PublicMethod
    public String getAction() {
        return this.action;
    }

    @PublicMethod
    public SparseArray<Object> getBundle() {
        return this.eventBundle;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getPriority() {
        return this.priority;
    }

    @Nullable
    @PublicMethod
    public Object getSender() {
        return this.sender;
    }

    @PublicMethod
    public int getTargetType() {
        return this.targetType;
    }

    @PublicMethod
    public int getType() {
        return this.type;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        this.eventBundle.clear();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        this.action = "";
        this.sender = null;
        this.targetType = -1;
        this.type = -1;
        this.priority = 0;
        this.logLevel = 0;
        this.eventBundle.clear();
    }

    @PublicMethod
    public void recycle() {
        sEventPool.release((VideoEventPool) this);
    }

    public VideoEvent(String str) {
        this.eventBundle = new SparseArray<>(3);
        this.type = -1;
        this.targetType = -1;
        this.priority = 0;
        this.logLevel = 0;
        this.action = str;
    }

    @PublicMethod
    public static VideoEvent copy(@NonNull VideoEvent videoEvent) {
        VideoEvent acquire = sEventPool.acquire();
        acquire.setType(videoEvent.type);
        acquire.setAction(videoEvent.action);
        acquire.setSender(videoEvent.sender);
        acquire.setTargetType(videoEvent.targetType);
        acquire.setPriority(videoEvent.priority);
        acquire.setBundle(videoEvent.eventBundle);
        acquire.setLogLevel(videoEvent.logLevel);
        return acquire;
    }

    public boolean filter(@NonNull INeuron iNeuron) {
        if (getSender() != iNeuron && (getTargetType() == -1 || getTargetType() == iNeuron.getType())) {
            return false;
        }
        return true;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i) {
        return getBooleanExtra(i, false);
    }

    @PublicMethod
    public Object getExtra(int i) {
        return this.eventBundle.get(i);
    }

    @PublicMethod
    public float getFloatExtra(int i) {
        return getFloatExtra(i, 0.0f);
    }

    @PublicMethod
    public int getIntExtra(int i) {
        return getIntExtra(i, 0);
    }

    @PublicMethod
    public long getLongExtra(int i) {
        return getLongExtra(i, 0L);
    }

    @PublicMethod
    public String getStringExtra(int i) {
        return getStringExtra(i, "");
    }

    @PublicMethod
    public void setAction(@NonNull String str) {
        this.action = str;
    }

    @PublicMethod
    public void setBundle(@NonNull SparseArray<Object> sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            this.eventBundle.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    @PublicMethod(version = "11.24.0.0")
    public void setPriority(int i) {
        this.priority = i;
    }

    @PublicMethod
    public void setSender(@NonNull Object obj) {
        this.sender = obj;
    }

    @PublicMethod
    public void setTargetType(int i) {
        this.targetType = i;
    }

    @PublicMethod
    public void setType(int i) {
        this.type = i;
    }

    public static VideoEvent obtain(@NonNull String str, int i) {
        VideoEvent acquire = sEventPool.acquire();
        acquire.setType(i);
        acquire.setAction(str);
        return acquire;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i, boolean z) {
        Object obj = this.eventBundle.get(i);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return z;
    }

    @PublicMethod(version = "12.2.0")
    public float getFloatExtra(int i, float f) {
        Object obj = this.eventBundle.get(i);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return f;
    }

    @PublicMethod
    public int getIntExtra(int i, int i2) {
        Object obj = this.eventBundle.get(i);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i2;
    }

    @PublicMethod
    public long getLongExtra(int i, long j) {
        Object obj = this.eventBundle.get(i);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return j;
    }

    @PublicMethod
    public String getStringExtra(int i, String str) {
        Object obj = this.eventBundle.get(i);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return str;
    }

    @PublicMethod
    public void putExtra(int i, Object obj) {
        this.eventBundle.put(i, obj);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = this.desc;
        if (sb == null) {
            this.desc = new StringBuilder();
        } else if (sb.length() > 0) {
            StringBuilder sb2 = this.desc;
            sb2.delete(0, sb2.length());
        }
        StringBuilder sb3 = this.desc;
        sb3.append("Action :");
        sb3.append(this.action);
        sb3.append(", type :");
        sb3.append(this.type);
        sb3.append(", from :");
        sb3.append(this.sender);
        sb3.append(", priority :");
        sb3.append(this.priority);
        sb3.append(", targetType :");
        sb3.append(this.targetType);
        sb3.append(", bundle :");
        sb3.append(this.eventBundle.toString());
        sb3.append(", hash :");
        sb3.append(hashCode());
        return this.desc.toString();
    }
}
