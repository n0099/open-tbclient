package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes.dex */
public class bi {
    private final long eQF;
    private String forumId = "0";
    private boolean isRunning;
    private int progress;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    private bi(long j) {
        this.eQF = j;
    }

    public static bi a(@NonNull WriteData writeData, int i) {
        bi biVar = new bi(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            biVar.forumId = writeData.getForumId();
        }
        biVar.progress = i;
        return biVar;
    }

    public void ju(boolean z) {
        this.isRunning = z;
        if (this.eQF > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean Ag(String str) {
        return this.forumId.equals(str);
    }

    public int getProgress() {
        return this.progress;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void bmU() {
        this.isRunning = false;
    }

    public void a(@NonNull bi biVar) {
        if (!biVar.isRunning) {
            this.isRunning = false;
        }
        this.progress = biVar.getProgress();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof bi) && this.eQF == ((bi) obj).eQF;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.eQF));
    }
}
