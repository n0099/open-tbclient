package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes.dex */
public class bb {
    private long ahX;
    private String ahY;
    private String ahZ;
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

    public long uY() {
        return this.ahX;
    }

    public long uZ() {
        return this.endTime;
    }

    public String getTaskId() {
        return this.taskId + "";
    }

    public String getThreadId() {
        return this.threadId + "";
    }

    public String getThreadImgUrl() {
        return this.ahZ;
    }

    public int va() {
        return this.mWidth;
    }

    public int vb() {
        return this.mHeight;
    }

    public String tX() {
        return this.obj_id;
    }

    public void a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            this.forumName = taskInfo.forum_name;
            this.forumId = taskInfo.forum_id.longValue();
            this.taskId = taskInfo.task_id != null ? taskInfo.task_id.longValue() : -1L;
            this.threadId = taskInfo.thread_id != null ? taskInfo.thread_id.longValue() : -1L;
            this.ahY = taskInfo.bgimg;
            this.ahZ = taskInfo.thread_img;
            this.ahX = taskInfo.start_time != null ? taskInfo.start_time.longValue() : -1L;
            this.endTime = taskInfo.end_time != null ? taskInfo.end_time.longValue() : -1L;
            String str = taskInfo.thread_img_size;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.mWidth = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.g(split[1], 1);
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
                this.ahY = jSONObject.optString("bgimg");
                this.ahX = jSONObject.optLong("start_time");
                this.endTime = jSONObject.optLong("end_time");
                this.ahZ = jSONObject.optString("thread_img");
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
