package com.baidu.searchbox.player.event;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.pool.IPoolItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class VideoEvent implements IPoolItem {
    public static final int PRIORITY_AT_ONCE = 1;
    public static final int PRIORITY_ENTER_QUEUE = 0;
    public static final int TYPE_CONTROL_EVENT = 2;
    public static final int TYPE_LAYER_EVENT = 3;
    public static final int TYPE_PLAYER_EVENT = 4;
    public static final int TYPE_STATE_EVENT = 5;
    public static final int TYPE_STATISTICS_EVENT = 6;
    public static final int TYPE_SYSTEM_EVENT = 1;
    public static final int TYPE_UNDEFINE_EVENT = -1;
    public static VideoEventPool sEventPool = new VideoEventPool();
    public String mAction;
    public StringBuilder mDesc;
    public SparseArray<Object> mEventBundle;
    public int mPriority;
    public Object mSender;
    public int mTargetType;
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Priority {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Type {
    }

    public VideoEvent() {
        this("");
    }

    @PublicMethod
    public static VideoEvent copy(@NonNull VideoEvent videoEvent) {
        VideoEvent acquire = sEventPool.acquire();
        acquire.setType(videoEvent.mType);
        acquire.setAction(videoEvent.mAction);
        acquire.setSender(videoEvent.mSender);
        acquire.setBundle(videoEvent.getBundle());
        return acquire;
    }

    public static VideoEvent obtain(@NonNull String str, int i) {
        VideoEvent acquire = sEventPool.acquire();
        acquire.setType(i);
        acquire.setAction(str);
        return acquire;
    }

    public boolean filter(@NonNull INeuron iNeuron) {
        return getSender() == iNeuron || !(getTargetType() == -1 || getTargetType() == iNeuron.getType());
    }

    @NonNull
    @PublicMethod
    public String getAction() {
        return this.mAction;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i) {
        return getBooleanExtra(i, false);
    }

    @PublicMethod
    public SparseArray<Object> getBundle() {
        return this.mEventBundle;
    }

    @PublicMethod
    public Object getExtra(int i) {
        return this.mEventBundle.get(i);
    }

    @PublicMethod
    public int getIntExtra(int i) {
        return getIntExtra(i, 0);
    }

    @PublicMethod
    public long getLongExtra(int i) {
        return getLongExtra(i, 0L);
    }

    @PublicMethod(version = "11.24.0.0")
    public int getPriority() {
        return this.mPriority;
    }

    @Nullable
    @PublicMethod
    public Object getSender() {
        return this.mSender;
    }

    @PublicMethod
    public String getStringExtra(int i) {
        return getStringExtra(i, "");
    }

    @PublicMethod
    public int getTargetType() {
        return this.mTargetType;
    }

    @PublicMethod
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        this.mEventBundle.clear();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        this.mAction = "";
        this.mSender = null;
        this.mTargetType = -1;
        this.mType = -1;
        this.mPriority = 0;
        this.mEventBundle.clear();
    }

    @PublicMethod
    public void putExtra(int i, Object obj) {
        this.mEventBundle.put(i, obj);
    }

    @PublicMethod
    public void recycle() {
        sEventPool.release((VideoEventPool) this);
    }

    @PublicMethod
    public void setAction(@NonNull String str) {
        this.mAction = str;
    }

    @PublicMethod
    public void setBundle(@NonNull SparseArray<Object> sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            this.mEventBundle.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setPriority(int i) {
        this.mPriority = i;
    }

    @PublicMethod
    public void setSender(@NonNull Object obj) {
        this.mSender = obj;
    }

    @PublicMethod
    public void setTargetType(int i) {
        this.mTargetType = i;
    }

    @PublicMethod
    public void setType(int i) {
        this.mType = i;
    }

    @NonNull
    public String toString() {
        if (BDPlayerConfig.isDebug()) {
            StringBuilder sb = this.mDesc;
            if (sb == null) {
                this.mDesc = new StringBuilder();
            } else if (sb.length() > 0) {
                StringBuilder sb2 = this.mDesc;
                sb2.delete(0, sb2.length());
            }
            StringBuilder sb3 = this.mDesc;
            sb3.append("Event【Action :");
            sb3.append(this.mAction);
            sb3.append("，type :");
            sb3.append(this.mType);
            sb3.append("，from :");
            sb3.append(this.mSender);
            sb3.append("，priority :");
            sb3.append(this.mPriority);
            sb3.append("，targetType :");
            sb3.append(this.mTargetType);
            sb3.append("，bundle :");
            sb3.append(this.mEventBundle.toString());
            sb3.append("，hash :");
            sb3.append(hashCode());
            sb3.append("】");
            return this.mDesc.toString();
        }
        return super.toString();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }

    public VideoEvent(String str) {
        this.mEventBundle = new SparseArray<>(3);
        this.mType = -1;
        this.mTargetType = -1;
        this.mPriority = 0;
        this.mAction = str;
    }

    @PublicMethod
    public boolean getBooleanExtra(int i, boolean z) {
        Object obj = this.mEventBundle.get(i);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @PublicMethod
    public int getIntExtra(int i, int i2) {
        Object obj = this.mEventBundle.get(i);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
    }

    @PublicMethod
    public long getLongExtra(int i, long j) {
        Object obj = this.mEventBundle.get(i);
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    @PublicMethod
    public String getStringExtra(int i, String str) {
        Object obj = this.mEventBundle.get(i);
        return obj != null ? String.valueOf(obj) : str;
    }
}
