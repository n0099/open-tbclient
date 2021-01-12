package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes.dex */
public class bg {
    private final long eMS;
    private String forumId = "0";
    private boolean isRunning;
    private int progress;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    private bg(long j) {
        this.eMS = j;
    }

    public static bg a(@NonNull WriteData writeData, int i) {
        bg bgVar = new bg(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            bgVar.forumId = writeData.getForumId();
        }
        bgVar.progress = i;
        return bgVar;
    }

    public void js(boolean z) {
        this.isRunning = z;
        if (this.eMS > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean zI(String str) {
        return this.forumId.equals(str);
    }

    public int getProgress() {
        return this.progress;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void bmz() {
        this.isRunning = false;
    }

    public void a(@NonNull bg bgVar) {
        if (!bgVar.isRunning) {
            this.isRunning = false;
        }
        this.progress = bgVar.getProgress();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof bg) && this.eMS == ((bg) obj).eMS;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.eMS));
    }
}
