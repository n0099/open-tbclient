package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import java.io.Serializable;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class PhotoLiveCardData implements Serializable {
    public static final String FROM_FRS = "from_frs";
    public static final String FROM_FRS_THREAD = "frs_thread";
    public static final String FROM_OHTERS = "from_others";
    public static final String FROM_PHOTO_LIVE_LIST = "from_photo_live_list";
    private static final long serialVersionUID = 1;
    private String authorId;
    private String authorName;
    private String authorPortrait;
    private boolean canDeleteLivePost;
    private String content;
    private String cover;
    private int discussNum;
    private long forumId;
    private String forumName;
    private String from = "from_frs";
    private long lastModifiedTime;
    private String liveCoverSrcBsize;
    private String photoLiveAbstract;
    private int postNum;
    private int praiseNum;
    private String refreshTime;
    private long threadId;
    private String title;

    public void setForumId(long j) {
        this.forumId = j;
    }

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(String str) {
        this.authorId = str;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setAuthorPortrait(String str) {
        this.authorPortrait = str;
    }

    public String getAuthorPortrait() {
        return this.authorPortrait;
    }

    public void setRefreshTime(String str) {
        this.refreshTime = str;
    }

    public String getRefreshTime() {
        return TextUtils.isEmpty(this.refreshTime) ? rV() : this.refreshTime;
    }

    private String rV() {
        return String.valueOf(aq.m(this.lastModifiedTime * 1000)) + TbadkCoreApplication.m411getInst().getString(i.C0057i.update_floor_num, new Object[]{aq.o(this.postNum)});
    }

    public void setPhotoLiveCover(String str) {
        this.cover = str;
    }

    public String getPhotoLiveCover() {
        return this.cover;
    }

    public void setPraiseNum(int i) {
        this.praiseNum = i;
    }

    public int getPraiseNum() {
        return this.praiseNum;
    }

    public void setDiscussNum(int i) {
        this.discussNum = i;
    }

    public int getDiscussNum() {
        return this.discussNum;
    }

    public void setCanDeleteLivePost(boolean z) {
        this.canDeleteLivePost = z;
    }

    public boolean getCanDeleteLivePost() {
        return this.canDeleteLivePost;
    }

    public void setPhotoLiveAbstract(String str) {
        this.photoLiveAbstract = str;
    }

    public String getPhotoLiveAbstract() {
        return this.photoLiveAbstract;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String geFrom() {
        return this.from;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public SpannableStringBuilder getTitleWithLabel() {
        if (StringUtils.isNull(this.title)) {
            this.title = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + this.title);
        Bitmap cq = al.cq(i.e.icon_live);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cq);
        bitmapDrawable.setBounds(0, 0, cq.getWidth(), cq.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return aq.a(spannableStringBuilder);
    }

    public String getTitle() {
        return this.title;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public int getPostNum() {
        return this.postNum;
    }

    public void setPostNum(int i) {
        this.postNum = i;
    }

    public String getLiveCoverSrcBsize() {
        return this.liveCoverSrcBsize;
    }

    public void setLiveCoverSrcBsize(String str) {
        this.liveCoverSrcBsize = str;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public void setLastModifiedTime(long j) {
        this.lastModifiedTime = j;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void parserProtobuf(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.postNum = zhiBoInfoTW.post_num.intValue();
            this.title = zhiBoInfoTW.title;
            this.forumId = zhiBoInfoTW.forum_id.longValue();
            this.liveCoverSrcBsize = zhiBoInfoTW.livecover_src_bsize;
            this.lastModifiedTime = zhiBoInfoTW.last_modified_time.longValue();
            this.forumName = zhiBoInfoTW.forum_name;
            this.threadId = zhiBoInfoTW.thread_id.longValue();
            this.content = zhiBoInfoTW.content;
            this.cover = zhiBoInfoTW.livecover_src;
            this.discussNum = zhiBoInfoTW.reply_num.intValue();
            if (zhiBoInfoTW.zan != null) {
                this.praiseNum = zhiBoInfoTW.zan.num.intValue();
            }
            if (zhiBoInfoTW.user != null) {
                this.authorId = String.valueOf(zhiBoInfoTW.user.id);
                this.authorName = zhiBoInfoTW.user.name;
                this.authorPortrait = zhiBoInfoTW.user.portrait;
            }
        }
    }
}
