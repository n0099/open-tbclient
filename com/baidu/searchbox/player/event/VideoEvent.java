package com.baidu.searchbox.player.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.pool.IPoolItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes15.dex */
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
    private static VideoEventPool sEventPool = new VideoEventPool();
    private String mAction;
    private StringBuilder mDesc;
    private SparseArray<Object> mEventBundle;
    private int mPriority;
    private Object mSender;
    private int mTargetType;
    private int mType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface Priority {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface Type {
    }

    public VideoEvent() {
        this("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoEvent(String str) {
        this.mEventBundle = new SparseArray<>(3);
        this.mType = -1;
        this.mTargetType = -1;
        this.mPriority = 0;
        this.mAction = str;
    }

    @PublicMethod
    public void putExtra(int i, Object obj) {
        this.mEventBundle.put(i, obj);
    }

    @PublicMethod
    public Object getExtra(int i) {
        return this.mEventBundle.get(i);
    }

    @PublicMethod
    public boolean getBooleanExtra(int i) {
        return getBooleanExtra(i, false);
    }

    @PublicMethod
    public boolean getBooleanExtra(int i, boolean z) {
        Object obj = this.mEventBundle.get(i);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return z;
    }

    @PublicMethod
    public int getIntExtra(int i) {
        return getIntExtra(i, 0);
    }

    @PublicMethod
    public int getIntExtra(int i, int i2) {
        Object obj = this.mEventBundle.get(i);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i2;
    }

    @PublicMethod
    public String getStringExtra(int i) {
        return getStringExtra(i, "");
    }

    @PublicMethod
    public String getStringExtra(int i, String str) {
        Object obj = this.mEventBundle.get(i);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return str;
    }

    @PublicMethod
    public long getLongExtra(int i) {
        return getLongExtra(i, 0L);
    }

    @PublicMethod
    public long getLongExtra(int i, long j) {
        Object obj = this.mEventBundle.get(i);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return j;
    }

    @PublicMethod
    public void setBundle(@NonNull SparseArray<Object> sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            this.mEventBundle.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    @PublicMethod
    public SparseArray<Object> getBundle() {
        return this.mEventBundle;
    }

    @PublicMethod
    @NonNull
    public String getAction() {
        return this.mAction;
    }

    @PublicMethod
    public void setAction(@NonNull String str) {
        this.mAction = str;
    }

    @PublicMethod
    public void setSender(@NonNull Object obj) {
        this.mSender = obj;
    }

    @PublicMethod
    @Nullable
    public Object getSender() {
        return this.mSender;
    }

    @PublicMethod
    public int getType() {
        return this.mType;
    }

    @PublicMethod
    public void setType(int i) {
        this.mType = i;
    }

    @PublicMethod
    public void setTargetType(int i) {
        this.mTargetType = i;
    }

    @PublicMethod
    public int getTargetType() {
        return this.mTargetType;
    }

    @PublicMethod(version = "11.24.0.0")
    public void setPriority(int i) {
        this.mPriority = i;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getPriority() {
        return this.mPriority;
    }

    public boolean filter(@NonNull INeuron iNeuron) {
        return getSender() == iNeuron || !(getTargetType() == -1 || getTargetType() == iNeuron.getType());
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

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }

    @NonNull
    public String toString() {
        if (BDPlayerConfig.isDebug()) {
            if (this.mDesc == null) {
                this.mDesc = new StringBuilder();
            } else if (this.mDesc.length() > 0) {
                this.mDesc.delete(0, this.mDesc.length());
            }
            this.mDesc.append("Event【Action :").append(this.mAction).append("，type :").append(this.mType).append("，from :").append(this.mSender).append("，priority :").append(this.mPriority).append("，targetType :").append(this.mTargetType).append("，bundle :").append(this.mEventBundle.toString()).append("，hash :").append(hashCode()).append("】");
            return this.mDesc.toString();
        }
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static VideoEvent obtain(@NonNull String str, int i) {
        VideoEvent acquire = sEventPool.acquire();
        acquire.setType(i);
        acquire.setAction(str);
        return acquire;
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

    @PublicMethod
    public void recycle() {
        sEventPool.release((VideoEventPool) this);
    }
}
