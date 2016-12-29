package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.io.Serializable;
import protobuf.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class PhotoLiveCoverData implements Serializable {
    private static final long serialVersionUID = 8418903509567288525L;
    private MetaData author;
    private String forumName;
    private int isMarked;
    private String photoLiveCover = "";
    private long praiseNum;
    private int replyNum;
    private String threadID;
    private String threadTitle;

    public static PhotoLiveCoverData build(bg bgVar, ForumData forumData) {
        if (bgVar == null) {
            return null;
        }
        PhotoLiveCoverData photoLiveCoverData = new PhotoLiveCoverData();
        photoLiveCoverData.photoLiveCover = bgVar.getPhotoLiveCover();
        photoLiveCoverData.author = bgVar.getAuthor();
        PraiseData rv = bgVar.rv();
        if (rv != null) {
            photoLiveCoverData.praiseNum = rv.getNum();
        }
        photoLiveCoverData.replyNum = bgVar.rx();
        photoLiveCoverData.threadID = bgVar.getId();
        photoLiveCoverData.threadTitle = bgVar.getTitle();
        photoLiveCoverData.isMarked = bgVar.getIsMarked();
        photoLiveCoverData.forumName = bgVar.rK();
        String name = forumData != null ? forumData.getName() : null;
        if (StringUtils.isNull(photoLiveCoverData.forumName) && !StringUtils.isNull(name)) {
            photoLiveCoverData.forumName = name;
        }
        return photoLiveCoverData;
    }

    public static PhotoLiveCoverData build(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW == null) {
            return null;
        }
        return new PhotoLiveCoverData();
    }

    public String getPhotoLiveCover() {
        return this.photoLiveCover;
    }

    public void setPhotoLiveCover(String str) {
        this.photoLiveCover = str;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public long getPraiseNum() {
        return this.praiseNum;
    }

    public void setPraiseNum(long j) {
        this.praiseNum = j;
    }

    public int getReplyNum() {
        return this.replyNum;
    }

    public void setReplyNum(int i) {
        this.replyNum = i;
    }

    public String getThreadID() {
        return this.threadID;
    }

    public void setThreadID(String str) {
        this.threadID = str;
    }

    public String getThreadTitle() {
        return this.threadTitle;
    }

    public void setThreadTitle(String str) {
        this.threadTitle = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }
}
