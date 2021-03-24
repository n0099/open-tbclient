package com.baidu.tbadk.browser.newshare;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadAchievementShareInfo implements Serializable {
    public String desc;
    public String fr;
    public String img;
    public ParamBean params;
    public String title;

    /* loaded from: classes3.dex */
    public static class ContentBean implements Serializable {
        public String height;
        public String src;
        public String text;
        public int type;
        public String width;

        public String getHeight() {
            return this.height;
        }

        public String getSrc() {
            return this.src;
        }

        public String getText() {
            return this.text;
        }

        public int getType() {
            return this.type;
        }

        public String getWidth() {
            return this.width;
        }

        public void setHeight(String str) {
            this.height = str;
        }

        public void setSrc(String str) {
            this.src = str;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setWidth(String str) {
            this.width = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class ParamBean implements Serializable {
        public long agree_num;
        public List<ContentBean> content;
        public String date;
        public int interact;
        public String pageType;
        public long post_num;
        public int rank;
        public List<ThreadListBean> thread_list;
        public String thread_title;
        public String thread_type;
        public String tid;
        public String title;
        public String uid;
        public String url;
        public UserBean user;
        public VideoInfoBean video_info;

        public long getAgree_num() {
            return this.agree_num;
        }

        public List<ContentBean> getContent() {
            return this.content;
        }

        public String getDate() {
            return this.date;
        }

        public int getInteract() {
            return this.interact;
        }

        public String getPageType() {
            return this.pageType;
        }

        public long getPost_num() {
            return this.post_num;
        }

        public int getRank() {
            return this.rank;
        }

        public List<ThreadListBean> getThread_list() {
            return this.thread_list;
        }

        public String getThread_title() {
            return this.thread_title;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public String getTid() {
            return this.tid;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUid() {
            return this.uid;
        }

        public String getUrl() {
            return this.url;
        }

        public UserBean getUser() {
            return this.user;
        }

        public VideoInfoBean getVideo_info() {
            return this.video_info;
        }

        public void setAgree_num(int i) {
            this.agree_num = i;
        }

        public void setContent(List<ContentBean> list) {
            this.content = list;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public void setInteract(int i) {
            this.interact = i;
        }

        public void setPageType(String str) {
            this.pageType = str;
        }

        public void setPost_num(int i) {
            this.post_num = i;
        }

        public void setRank(int i) {
            this.rank = i;
        }

        public void setThread_list(List<ThreadListBean> list) {
            this.thread_list = list;
        }

        public void setThread_title(String str) {
            this.thread_title = str;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUser(UserBean userBean) {
            this.user = userBean;
        }

        public void setVideo_info(VideoInfoBean videoInfoBean) {
            this.video_info = videoInfoBean;
        }

        public String toString() {
            return "ParamBean{user=" + this.user + ", rank=" + this.rank + ", title='" + this.title + "', date='" + this.date + "', tid='" + this.tid + "', uid='" + this.uid + "', url='" + this.url + "', pageType='" + this.pageType + "', thread_list=" + this.thread_list + ", thread_type='" + this.thread_type + "', thread_title='" + this.thread_title + "', interact=" + this.interact + ", agree_num=" + this.agree_num + ", post_num=" + this.post_num + ", content=" + this.content + ", video_info=" + this.video_info + '}';
        }
    }

    /* loaded from: classes3.dex */
    public static class ThreadListBean implements Serializable {
        public int duration;
        public String hotvalue;
        public String img;
        public int index;
        public long tid;
        public String title;
        public String user_img;

        public int getDuration() {
            return this.duration;
        }

        public String getHotvalue() {
            return this.hotvalue;
        }

        public String getImg() {
            return this.img;
        }

        public int getIndex() {
            return this.index;
        }

        public long getTid() {
            return this.tid;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUser_img() {
            return this.user_img;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public void setHotvalue(String str) {
            this.hotvalue = str;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public void setTid(long j) {
            this.tid = j;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUser_img(String str) {
            this.user_img = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class UserBean implements Serializable {
        public String img;
        public String user_img;
        public String username;

        public String getImg() {
            return this.img;
        }

        public String getUser_img() {
            return this.user_img;
        }

        public String getUsername() {
            return this.username;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public void setUser_img(String str) {
            this.user_img = str;
        }

        public void setUsername(String str) {
            this.username = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoDescBean implements Serializable {
        public int video_height;
        public int video_id;
        public int video_size;
        public String video_url;
        public int video_width;

        public int getVideo_height() {
            return this.video_height;
        }

        public int getVideo_id() {
            return this.video_id;
        }

        public int getVideo_size() {
            return this.video_size;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public int getVideo_width() {
            return this.video_width;
        }

        public void setVideo_height(int i) {
            this.video_height = i;
        }

        public void setVideo_id(int i) {
            this.video_id = i;
        }

        public void setVideo_size(int i) {
            this.video_size = i;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public void setVideo_width(int i) {
            this.video_width = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoDescCaeBean implements Serializable {
        public int video_height;
        public int video_id;
        public int video_size;
        public String video_url;
        public int video_width;

        public int getVideo_height() {
            return this.video_height;
        }

        public int getVideo_id() {
            return this.video_id;
        }

        public int getVideo_size() {
            return this.video_size;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public int getVideo_width() {
            return this.video_width;
        }

        public void setVideo_height(int i) {
            this.video_height = i;
        }

        public void setVideo_id(int i) {
            this.video_id = i;
        }

        public void setVideo_size(int i) {
            this.video_size = i;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public void setVideo_width(int i) {
            this.video_width = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoDescH265Bean implements Serializable {
        public int video_height;
        public int video_id;
        public int video_size;
        public String video_url;
        public int video_width;

        public int getVideo_height() {
            return this.video_height;
        }

        public int getVideo_id() {
            return this.video_id;
        }

        public int getVideo_size() {
            return this.video_size;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public int getVideo_width() {
            return this.video_width;
        }

        public void setVideo_height(int i) {
            this.video_height = i;
        }

        public void setVideo_id(int i) {
            this.video_id = i;
        }

        public void setVideo_size(int i) {
            this.video_size = i;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public void setVideo_width(int i) {
            this.video_width = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoInfoBean implements Serializable {
        public int auditing;
        public int format_matched;
        public String origin_video_url;
        public String thumbnail_height;
        public String thumbnail_url;
        public String thumbnail_width;
        public int version_h265;
        public List<VideoDescBean> video_desc;
        public List<VideoDescCaeBean> video_desc_cae;
        public List<VideoDescH265Bean> video_desc_h265;
        public String video_duration;
        public String video_height;
        public String video_length;
        public long video_log_id;
        public String video_md5;
        public String video_type;
        public String video_url;
        public String video_width;

        public int getAuditing() {
            return this.auditing;
        }

        public int getFormat_matched() {
            return this.format_matched;
        }

        public String getOrigin_video_url() {
            return this.origin_video_url;
        }

        public String getThumbnail_height() {
            return this.thumbnail_height;
        }

        public String getThumbnail_url() {
            return this.thumbnail_url;
        }

        public String getThumbnail_width() {
            return this.thumbnail_width;
        }

        public int getVersion_h265() {
            return this.version_h265;
        }

        public List<VideoDescBean> getVideo_desc() {
            return this.video_desc;
        }

        public List<VideoDescCaeBean> getVideo_desc_cae() {
            return this.video_desc_cae;
        }

        public List<VideoDescH265Bean> getVideo_desc_h265() {
            return this.video_desc_h265;
        }

        public String getVideo_duration() {
            return this.video_duration;
        }

        public String getVideo_height() {
            return this.video_height;
        }

        public String getVideo_length() {
            return this.video_length;
        }

        public long getVideo_log_id() {
            return this.video_log_id;
        }

        public String getVideo_md5() {
            return this.video_md5;
        }

        public String getVideo_type() {
            return this.video_type;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public String getVideo_width() {
            return this.video_width;
        }

        public void setAuditing(int i) {
            this.auditing = i;
        }

        public void setFormat_matched(int i) {
            this.format_matched = i;
        }

        public void setOrigin_video_url(String str) {
            this.origin_video_url = str;
        }

        public void setThumbnail_height(String str) {
            this.thumbnail_height = str;
        }

        public void setThumbnail_url(String str) {
            this.thumbnail_url = str;
        }

        public void setThumbnail_width(String str) {
            this.thumbnail_width = str;
        }

        public void setVersion_h265(int i) {
            this.version_h265 = i;
        }

        public void setVideo_desc(List<VideoDescBean> list) {
            this.video_desc = list;
        }

        public void setVideo_desc_cae(List<VideoDescCaeBean> list) {
            this.video_desc_cae = list;
        }

        public void setVideo_desc_h265(List<VideoDescH265Bean> list) {
            this.video_desc_h265 = list;
        }

        public void setVideo_duration(String str) {
            this.video_duration = str;
        }

        public void setVideo_height(String str) {
            this.video_height = str;
        }

        public void setVideo_length(String str) {
            this.video_length = str;
        }

        public void setVideo_log_id(long j) {
            this.video_log_id = j;
        }

        public void setVideo_md5(String str) {
            this.video_md5 = str;
        }

        public void setVideo_type(String str) {
            this.video_type = str;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public void setVideo_width(String str) {
            this.video_width = str;
        }
    }

    public String getDesc() {
        return this.desc;
    }

    public String getFr() {
        return this.fr;
    }

    public String getImg() {
        return this.img;
    }

    public ParamBean getParams() {
        return this.params;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFr(String str) {
        this.fr = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setParams(ParamBean paramBean) {
        this.params = paramBean;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
