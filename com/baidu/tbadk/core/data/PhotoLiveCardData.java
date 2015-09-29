package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class PhotoLiveCardData implements Serializable {
    public static final String FROM_FRS_THREAD = "frs_thread";
    private static final long serialVersionUID = 1;
    private String authorId;
    private String authorName;
    private String authorPortrait;
    private boolean canDeleteLivePost;
    private String content;
    private String cover;
    private int discussNum;
    private int fansNum;
    private long forumId;
    private String forumName;
    private boolean isHeadLive;
    private long lastModifiedTime;
    private String liveCoverSrcBsize;
    private String nickName;
    private int postNum;
    private int praiseNum;
    private String refreshTime;
    private long threadId;
    private String title;
    private int mShowStye = -1;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.coreExtra.view.o> expressionList = new ArrayList<>();

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setFansNum(int i) {
        this.fansNum = i;
    }

    public int getFansNum() {
        return this.fansNum;
    }

    public void setHeadlive(boolean z) {
        this.isHeadLive = z;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

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
        return TextUtils.isEmpty(this.refreshTime) ? buildRefreshTime() : this.refreshTime;
    }

    @Deprecated
    public String buildRefreshTime() {
        return String.valueOf(ar.o(this.lastModifiedTime * 1000)) + " " + TbadkCoreApplication.m411getInst().getString(i.h.update_floor_num, new Object[]{ar.s(this.postNum)});
    }

    public String buildRefreshTimeWithPostNum() {
        return String.valueOf(ar.o(this.lastModifiedTime * 1000)) + " " + TbadkCoreApplication.m411getInst().getString(i.h.update_floor_num, new Object[]{ar.s(this.postNum)});
    }

    public String buildRefreshTimeWithoutPostNum() {
        return TbadkCoreApplication.m411getInst().getString(i.h.photo_live_thread_expression_time, new Object[]{ar.o(this.lastModifiedTime * 1000)});
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

    public void setTitle(String str) {
        this.title = str;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList) {
        this.expressionList = arrayList;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.o> getExpressionDatas() {
        return this.expressionList;
    }

    public SpannableStringBuilder getTitleWithLabel() {
        return getLiveIconTitle(this.title);
    }

    public static SpannableStringBuilder getLiveIconTitle(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cw = am.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        int height = cw.getHeight();
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return ar.a(spannableStringBuilder);
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
                this.nickName = zhiBoInfoTW.user.fans_nickname;
                this.fansNum = zhiBoInfoTW.user.fans_num.intValue();
            }
            if (zhiBoInfoTW.labelInfo != null) {
                int size = zhiBoInfoTW.labelInfo.size();
                for (int i = 0; i < size; i++) {
                    if (zhiBoInfoTW.labelInfo.get(i) != null) {
                        com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
                        oVar.dD(zhiBoInfoTW.labelInfo.get(i).labelHot.intValue());
                        oVar.setLabelId(zhiBoInfoTW.labelInfo.get(i).labelId);
                        oVar.setLabelName(zhiBoInfoTW.labelInfo.get(i).labelContent);
                        this.expressionList.add(oVar);
                    }
                }
                this.isHeadLive = zhiBoInfoTW.is_headline.intValue() == 1;
            }
        }
    }

    public String deleteBlackSpace(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll("\n", "").trim();
    }

    public void setShowStyle(int i) {
        this.mShowStye = i;
    }

    public int getShowStyle() {
        return this.mShowStye;
    }

    public int getRandom(int i, int i2) {
        int nextInt = new Random().nextInt(i);
        if (nextInt == i2) {
            return (nextInt + 1) % i;
        }
        return nextInt;
    }

    public void setShowExpressionViewIndexList(ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList) {
        int size = arrayList.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < size && i < 3) {
            if (arrayList.get(i) != null) {
                int random = getRandom(3, -1);
                if (random == i2 || random == i3) {
                    random = m(size, i2, i3);
                }
                if (i == 0) {
                    i2 = random;
                }
                if (i == 1) {
                    i3 = random;
                }
                this.showExpressionViewIndex.add(Integer.valueOf(random));
            }
            i++;
            i2 = i2;
        }
    }

    public void setShowExpressionViewIndex(ArrayList<Integer> arrayList) {
        this.showExpressionViewIndex.addAll(arrayList);
    }

    private int m(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    public ArrayList<Integer> getShowExpressionViewIndex() {
        return this.showExpressionViewIndex;
    }
}
