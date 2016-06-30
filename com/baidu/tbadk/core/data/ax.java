package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes.dex */
public class ax {
    private long Oe;
    private long Qb;
    private String Qc;
    private String Qd;
    private long forumId;
    private String forumName;
    private int mHeight;
    private int mWidth;
    private String obj_id;
    private long taskId;
    private long threadId;

    public String getForumName() {
        return this.forumName;
    }

    public String getForumId() {
        return new StringBuilder(String.valueOf(this.forumId)).toString();
    }

    public long qs() {
        return this.Qb;
    }

    public long qt() {
        return this.Oe;
    }

    public String getTaskId() {
        return new StringBuilder(String.valueOf(this.taskId)).toString();
    }

    public String getThreadId() {
        return new StringBuilder(String.valueOf(this.threadId)).toString();
    }

    public String qu() {
        return this.Qc;
    }

    public String qv() {
        return this.Qd;
    }

    public int qw() {
        return this.mWidth;
    }

    public int qx() {
        return this.mHeight;
    }

    public String oH() {
        return this.obj_id;
    }

    public void a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            this.forumName = taskInfo.forum_name;
            this.forumId = taskInfo.forum_id.longValue();
            this.taskId = taskInfo.task_id != null ? taskInfo.task_id.longValue() : -1L;
            this.threadId = taskInfo.thread_id != null ? taskInfo.thread_id.longValue() : -1L;
            this.Qc = taskInfo.bgimg;
            this.Qd = taskInfo.thread_img;
            this.Qb = taskInfo.start_time != null ? taskInfo.start_time.longValue() : -1L;
            this.Oe = taskInfo.end_time != null ? taskInfo.end_time.longValue() : -1L;
            String str = taskInfo.thread_img_size;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.mWidth = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.mWidth <= 0) {
                this.mWidth = 1;
            }
            if (this.mHeight <= 0) {
                this.mHeight = 1;
            }
            this.obj_id = taskInfo.obj_id;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.forumName = jSONObject.optString("forum_name");
                this.forumId = jSONObject.optLong("forum_id");
                this.taskId = jSONObject.optLong(InterviewLiveActivityConfig.KEY_TASK_ID);
                this.threadId = jSONObject.optLong("thread_id");
                this.Qc = jSONObject.optString("bgimg");
                this.Qb = jSONObject.optLong(ThActivityDetailActivityConfig.START_TIME);
                this.Oe = jSONObject.optLong(ThActivityDetailActivityConfig.END_TIME);
                this.Qd = jSONObject.optString("thread_img");
                String optString = jSONObject.optString("thread_img_size");
                if (optString != null && optString.length() > 0) {
                    String[] split = optString.split(",");
                    if (split.length > 1) {
                        this.mWidth = Integer.valueOf(split[0]).intValue();
                        this.mHeight = Integer.valueOf(split[1]).intValue();
                    }
                }
                if (this.mWidth <= 0) {
                    this.mWidth = 1;
                }
                if (this.mHeight <= 0) {
                    this.mHeight = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
