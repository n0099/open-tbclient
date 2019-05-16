package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes.dex */
public class be {
    private long bHS;
    private String bHT;
    private String bHU;
    private long endTime;
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
        return this.forumId + "";
    }

    public long acO() {
        return this.bHS;
    }

    public long acP() {
        return this.endTime;
    }

    public String getTaskId() {
        return this.taskId + "";
    }

    public String getThreadId() {
        return this.threadId + "";
    }

    public String getThreadImgUrl() {
        return this.bHU;
    }

    public int acQ() {
        return this.mWidth;
    }

    public int acR() {
        return this.mHeight;
    }

    public String acS() {
        return this.obj_id;
    }

    public void a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            this.forumName = taskInfo.forum_name;
            this.forumId = taskInfo.forum_id.longValue();
            this.taskId = taskInfo.task_id != null ? taskInfo.task_id.longValue() : -1L;
            this.threadId = taskInfo.thread_id != null ? taskInfo.thread_id.longValue() : -1L;
            this.bHT = taskInfo.bgimg;
            this.bHU = taskInfo.thread_img;
            this.bHS = taskInfo.start_time != null ? taskInfo.start_time.longValue() : -1L;
            this.endTime = taskInfo.end_time != null ? taskInfo.end_time.longValue() : -1L;
            String str = taskInfo.thread_img_size;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.mWidth = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.f(split[1], 1);
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
                this.taskId = jSONObject.optLong("task_id");
                this.threadId = jSONObject.optLong("thread_id");
                this.bHT = jSONObject.optString("bgimg");
                this.bHS = jSONObject.optLong("start_time");
                this.endTime = jSONObject.optLong("end_time");
                this.bHU = jSONObject.optString("thread_img");
                String optString = jSONObject.optString("thread_img_size");
                if (optString != null && optString.length() > 0) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
