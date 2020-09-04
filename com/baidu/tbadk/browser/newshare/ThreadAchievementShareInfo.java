package com.baidu.tbadk.browser.newshare;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadAchievementShareInfo implements Serializable {
    private String desc;
    private String fr;
    private String img;
    private ParamBean params;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public ParamBean getParams() {
        return this.params;
    }

    public void setParams(ParamBean paramBean) {
        this.params = paramBean;
    }

    public String getFr() {
        return this.fr;
    }

    public void setFr(String str) {
        this.fr = str;
    }

    /* loaded from: classes.dex */
    public static class ParamBean implements Serializable {
        private long agree_num;
        private List<ContentBean> content;
        private String date;
        private int interact;
        private String pageType;
        private long post_num;
        private int rank;
        private List<ThreadListBean> thread_list;
        private String thread_title;
        private String thread_type;
        private String tid;
        private String title;
        private String uid;
        private String url;
        private UserBean user;
        private VideoInfoBean video_info;

        public UserBean getUser() {
            return this.user;
        }

        public void setUser(UserBean userBean) {
            this.user = userBean;
        }

        public int getRank() {
            return this.rank;
        }

        public void setRank(int i) {
            this.rank = i;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getDate() {
            return this.date;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public String getTid() {
            return this.tid;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public String getUid() {
            return this.uid;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getPageType() {
            return this.pageType;
        }

        public void setPageType(String str) {
            this.pageType = str;
        }

        public List<ThreadListBean> getThread_list() {
            return this.thread_list;
        }

        public void setThread_list(List<ThreadListBean> list) {
            this.thread_list = list;
        }

        public String getThread_type() {
            return this.thread_type;
        }

        public void setThread_type(String str) {
            this.thread_type = str;
        }

        public String getThread_title() {
            return this.thread_title;
        }

        public void setThread_title(String str) {
            this.thread_title = str;
        }

        public int getInteract() {
            return this.interact;
        }

        public void setInteract(int i) {
            this.interact = i;
        }

        public long getAgree_num() {
            return this.agree_num;
        }

        public void setAgree_num(int i) {
            this.agree_num = i;
        }

        public long getPost_num() {
            return this.post_num;
        }

        public void setPost_num(int i) {
            this.post_num = i;
        }

        public List<ContentBean> getContent() {
            return this.content;
        }

        public void setContent(List<ContentBean> list) {
            this.content = list;
        }

        public VideoInfoBean getVideo_info() {
            return this.video_info;
        }

        public void setVideo_info(VideoInfoBean videoInfoBean) {
            this.video_info = videoInfoBean;
        }

        public String toString() {
            return "ParamBean{user=" + this.user + ", rank=" + this.rank + ", title='" + this.title + "', date='" + this.date + "', tid='" + this.tid + "', uid='" + this.uid + "', url='" + this.url + "', pageType='" + this.pageType + "', thread_list=" + this.thread_list + ", thread_type='" + this.thread_type + "', thread_title='" + this.thread_title + "', interact=" + this.interact + ", agree_num=" + this.agree_num + ", post_num=" + this.post_num + ", content=" + this.content + ", video_info=" + this.video_info + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class UserBean implements Serializable {
        private String img;
        private String user_img;
        private String username;

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public String getImg() {
            return this.img;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public String getUser_img() {
            return this.user_img;
        }

        public void setUser_img(String str) {
            this.user_img = str;
        }
    }

    /* loaded from: classes.dex */
    public static class ThreadListBean implements Serializable {
        private int duration;
        private String hotvalue;
        private String img;
        private int index;
        private long tid;
        private String title;
        private String user_img;

        public String getUser_img() {
            return this.user_img;
        }

        public void setUser_img(String str) {
            this.user_img = str;
        }

        public long getTid() {
            return this.tid;
        }

        public void setTid(long j) {
            this.tid = j;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getHotvalue() {
            return this.hotvalue;
        }

        public void setHotvalue(String str) {
            this.hotvalue = str;
        }

        public String getImg() {
            return this.img;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }
    }

    /* loaded from: classes.dex */
    public static class ContentBean implements Serializable {
        private String height;
        private String src;
        private String text;
        private int type;
        private String width;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }

        public String getWidth() {
            return this.width;
        }

        public void setWidth(String str) {
            this.width = str;
        }

        public String getHeight() {
            return this.height;
        }

        public void setHeight(String str) {
            this.height = str;
        }
    }

    /* loaded from: classes.dex */
    public static class VideoInfoBean implements Serializable {
        private int auditing;
        private int format_matched;
        private String origin_video_url;
        private String thumbnail_height;
        private String thumbnail_url;
        private String thumbnail_width;
        private int version_h265;
        private List<VideoDescBean> video_desc;
        private List<VideoDescCaeBean> video_desc_cae;
        private List<VideoDescH265Bean> video_desc_h265;
        private String video_duration;
        private String video_height;
        private String video_length;
        private long video_log_id;
        private String video_md5;
        private String video_type;
        private String video_url;
        private String video_width;

        public String getThumbnail_width() {
            return this.thumbnail_width;
        }

        public void setThumbnail_width(String str) {
            this.thumbnail_width = str;
        }

        public String getThumbnail_height() {
            return this.thumbnail_height;
        }

        public void setThumbnail_height(String str) {
            this.thumbnail_height = str;
        }

        public String getVideo_md5() {
            return this.video_md5;
        }

        public void setVideo_md5(String str) {
            this.video_md5 = str;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public String getVideo_duration() {
            return this.video_duration;
        }

        public void setVideo_duration(String str) {
            this.video_duration = str;
        }

        public String getVideo_width() {
            return this.video_width;
        }

        public void setVideo_width(String str) {
            this.video_width = str;
        }

        public String getVideo_height() {
            return this.video_height;
        }

        public void setVideo_height(String str) {
            this.video_height = str;
        }

        public String getVideo_length() {
            return this.video_length;
        }

        public void setVideo_length(String str) {
            this.video_length = str;
        }

        public String getVideo_type() {
            return this.video_type;
        }

        public void setVideo_type(String str) {
            this.video_type = str;
        }

        public String getThumbnail_url() {
            return this.thumbnail_url;
        }

        public void setThumbnail_url(String str) {
            this.thumbnail_url = str;
        }

        public long getVideo_log_id() {
            return this.video_log_id;
        }

        public void setVideo_log_id(long j) {
            this.video_log_id = j;
        }

        public int getAuditing() {
            return this.auditing;
        }

        public void setAuditing(int i) {
            this.auditing = i;
        }

        public int getFormat_matched() {
            return this.format_matched;
        }

        public void setFormat_matched(int i) {
            this.format_matched = i;
        }

        public String getOrigin_video_url() {
            return this.origin_video_url;
        }

        public void setOrigin_video_url(String str) {
            this.origin_video_url = str;
        }

        public int getVersion_h265() {
            return this.version_h265;
        }

        public void setVersion_h265(int i) {
            this.version_h265 = i;
        }

        public List<VideoDescBean> getVideo_desc() {
            return this.video_desc;
        }

        public void setVideo_desc(List<VideoDescBean> list) {
            this.video_desc = list;
        }

        public List<VideoDescCaeBean> getVideo_desc_cae() {
            return this.video_desc_cae;
        }

        public void setVideo_desc_cae(List<VideoDescCaeBean> list) {
            this.video_desc_cae = list;
        }

        public List<VideoDescH265Bean> getVideo_desc_h265() {
            return this.video_desc_h265;
        }

        public void setVideo_desc_h265(List<VideoDescH265Bean> list) {
            this.video_desc_h265 = list;
        }
    }

    /* loaded from: classes.dex */
    public static class VideoDescBean implements Serializable {
        private int video_height;
        private int video_id;
        private int video_size;
        private String video_url;
        private int video_width;

        public int getVideo_id() {
            return this.video_id;
        }

        public void setVideo_id(int i) {
            this.video_id = i;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public int getVideo_width() {
            return this.video_width;
        }

        public void setVideo_width(int i) {
            this.video_width = i;
        }

        public int getVideo_height() {
            return this.video_height;
        }

        public void setVideo_height(int i) {
            this.video_height = i;
        }

        public int getVideo_size() {
            return this.video_size;
        }

        public void setVideo_size(int i) {
            this.video_size = i;
        }
    }

    /* loaded from: classes.dex */
    public static class VideoDescCaeBean implements Serializable {
        private int video_height;
        private int video_id;
        private int video_size;
        private String video_url;
        private int video_width;

        public int getVideo_id() {
            return this.video_id;
        }

        public void setVideo_id(int i) {
            this.video_id = i;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public int getVideo_width() {
            return this.video_width;
        }

        public void setVideo_width(int i) {
            this.video_width = i;
        }

        public int getVideo_height() {
            return this.video_height;
        }

        public void setVideo_height(int i) {
            this.video_height = i;
        }

        public int getVideo_size() {
            return this.video_size;
        }

        public void setVideo_size(int i) {
            this.video_size = i;
        }
    }

    /* loaded from: classes.dex */
    public static class VideoDescH265Bean implements Serializable {
        private int video_height;
        private int video_id;
        private int video_size;
        private String video_url;
        private int video_width;

        public int getVideo_id() {
            return this.video_id;
        }

        public void setVideo_id(int i) {
            this.video_id = i;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public int getVideo_width() {
            return this.video_width;
        }

        public void setVideo_width(int i) {
            this.video_width = i;
        }

        public int getVideo_height() {
            return this.video_height;
        }

        public void setVideo_height(int i) {
            this.video_height = i;
        }

        public int getVideo_size() {
            return this.video_size;
        }

        public void setVideo_size(int i) {
            this.video_size = i;
        }
    }
}
