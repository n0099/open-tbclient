package aegon.chrome.base.task;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class TaskTraits {
    public static final TaskTraits BEST_EFFORT;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK;
    public static final TaskTraits CHOREOGRAPHER_FRAME;
    public static final TaskTraits THREAD_POOL;
    public static final TaskTraits USER_BLOCKING;
    public static final TaskTraits USER_VISIBLE;
    public byte[] mExtensionData;
    public byte mExtensionId;
    public boolean mIsChoreographerFrame;
    public boolean mMayBlock;
    public int mPriority;
    public boolean mPrioritySetExplicitly;
    public boolean mUseThreadPool;

    static {
        TaskTraits.class.desiredAssertionStatus();
        TaskTraits taskPriority = new TaskTraits().taskPriority(0);
        BEST_EFFORT = taskPriority;
        BEST_EFFORT_MAY_BLOCK = taskPriority.mayBlock();
        TaskTraits taskPriority2 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = taskPriority2;
        taskPriority2.mayBlock();
        TaskTraits taskPriority3 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = taskPriority3;
        taskPriority3.mayBlock();
        TaskTraits taskTraits = new TaskTraits();
        CHOREOGRAPHER_FRAME = taskTraits;
        taskTraits.mIsChoreographerFrame = true;
        TaskTraits taskTraits2 = new TaskTraits(new TaskTraits());
        taskTraits2.mUseThreadPool = true;
        THREAD_POOL = taskTraits2;
        taskTraits2.taskPriority(2);
        THREAD_POOL.taskPriority(1);
        THREAD_POOL.taskPriority(0);
    }

    public TaskTraits() {
        this.mPriority = 1;
    }

    public TaskTraits(TaskTraits taskTraits) {
        this.mPrioritySetExplicitly = taskTraits.mPrioritySetExplicitly;
        this.mPriority = taskTraits.mPriority;
        this.mMayBlock = taskTraits.mMayBlock;
        this.mUseThreadPool = taskTraits.mUseThreadPool;
        this.mExtensionId = taskTraits.mExtensionId;
        this.mExtensionData = taskTraits.mExtensionData;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TaskTraits) {
            TaskTraits taskTraits = (TaskTraits) obj;
            return this.mPrioritySetExplicitly == taskTraits.mPrioritySetExplicitly && this.mPriority == taskTraits.mPriority && this.mExtensionId == taskTraits.mExtensionId && Arrays.equals(this.mExtensionData, taskTraits.mExtensionData);
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.mExtensionData) + (((((((((((!this.mPrioritySetExplicitly ? 1 : 0) + 1147) * 37) + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }

    public TaskTraits mayBlock() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mMayBlock = true;
        return taskTraits;
    }

    public TaskTraits taskPriority(int i2) {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mPrioritySetExplicitly = true;
        taskTraits.mPriority = i2;
        return taskTraits;
    }
}
