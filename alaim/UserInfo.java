package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class UserInfo extends Message {
    public static final Integer DEFAULT_AUDIENCELEVEL;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final List<Integer> DEFAULT_FAMILY_EFFECT;
    public static final Integer DEFAULT_ISLIVEADMIN;
    public static final Integer DEFAULT_ISOFFICIAL;
    public static final Double DEFAULT_LAT;
    public static final Integer DEFAULT_LEVEL;
    public static final List<LiveMarkInfo> DEFAULT_LIVE_MARK_INFO;
    public static final List<LiveMarkInfo> DEFAULT_LIVE_MARK_INFO_NEW;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_NICKNAME = "";
    public static final Integer DEFAULT_NOBILITY_IM_EFFECT;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_POSITION = "";
    public static final String DEFAULT_TAG_NAME = "";
    public static final Integer DEFAULT_TAG_TYPE;
    public static final String DEFAULT_THIRD_APP_ID = "";
    public static final String DEFAULT_THIRD_APP_NAME = "";
    public static final String DEFAULT_USERNAME = "";
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer audienceLevel;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(label = Message.Label.REPEATED, tag = 21, type = Message.Datatype.UINT32)
    public final List<Integer> family_effect;
    @ProtoField(tag = 23)
    public final ImEffect im_effect;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer isLiveAdmin;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer isOfficial;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(label = Message.Label.REPEATED, tag = 19)
    public final List<LiveMarkInfo> live_mark_info;
    @ProtoField(label = Message.Label.REPEATED, tag = 20)
    public final List<LiveMarkInfo> live_mark_info_new;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String nickName;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long nickNameId;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer nobility_im_effect;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String position;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer sex;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String tag_name;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer tag_type;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String third_app_id;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String third_app_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userName;
    public static final Long DEFAULT_USERID = 0L;
    public static final Long DEFAULT_NICKNAMEID = 0L;
    public static final Integer DEFAULT_SEX = 0;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<UserInfo> {
        public Integer audienceLevel;
        public String description;
        public List<Integer> family_effect;
        public ImEffect im_effect;
        public Integer isLiveAdmin;
        public Integer isOfficial;
        public Double lat;
        public Integer level;
        public List<LiveMarkInfo> live_mark_info;
        public List<LiveMarkInfo> live_mark_info_new;
        public Double lng;
        public String nickName;
        public Long nickNameId;
        public Integer nobility_im_effect;
        public String portrait;
        public String position;
        public Integer sex;
        public String tag_name;
        public Integer tag_type;
        public String third_app_id;
        public String third_app_name;
        public Long userId;
        public String userName;

        public Builder() {
        }

        public Builder(UserInfo userInfo) {
            super(userInfo);
            if (userInfo == null) {
                return;
            }
            this.userId = userInfo.userId;
            this.userName = userInfo.userName;
            this.nickNameId = userInfo.nickNameId;
            this.nickName = userInfo.nickName;
            this.portrait = userInfo.portrait;
            this.sex = userInfo.sex;
            this.position = userInfo.position;
            this.lng = userInfo.lng;
            this.lat = userInfo.lat;
            this.level = userInfo.level;
            this.isOfficial = userInfo.isOfficial;
            this.isLiveAdmin = userInfo.isLiveAdmin;
            this.audienceLevel = userInfo.audienceLevel;
            this.third_app_id = userInfo.third_app_id;
            this.third_app_name = userInfo.third_app_name;
            this.description = userInfo.description;
            this.tag_name = userInfo.tag_name;
            this.tag_type = userInfo.tag_type;
            this.live_mark_info = Message.copyOf(userInfo.live_mark_info);
            this.live_mark_info_new = Message.copyOf(userInfo.live_mark_info_new);
            this.family_effect = Message.copyOf(userInfo.family_effect);
            this.nobility_im_effect = userInfo.nobility_im_effect;
            this.im_effect = userInfo.im_effect;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public UserInfo build(boolean z) {
            return new UserInfo(this, z);
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
        DEFAULT_LEVEL = 0;
        DEFAULT_ISOFFICIAL = 0;
        DEFAULT_ISLIVEADMIN = 0;
        DEFAULT_AUDIENCELEVEL = 0;
        DEFAULT_TAG_TYPE = 0;
        DEFAULT_LIVE_MARK_INFO = Collections.emptyList();
        DEFAULT_LIVE_MARK_INFO_NEW = Collections.emptyList();
        DEFAULT_FAMILY_EFFECT = Collections.emptyList();
        DEFAULT_NOBILITY_IM_EFFECT = 0;
    }

    public UserInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            String str = builder.userName;
            if (str == null) {
                this.userName = "";
            } else {
                this.userName = str;
            }
            Long l2 = builder.nickNameId;
            if (l2 == null) {
                this.nickNameId = DEFAULT_NICKNAMEID;
            } else {
                this.nickNameId = l2;
            }
            String str2 = builder.nickName;
            if (str2 == null) {
                this.nickName = "";
            } else {
                this.nickName = str2;
            }
            String str3 = builder.portrait;
            if (str3 == null) {
                this.portrait = "";
            } else {
                this.portrait = str3;
            }
            Integer num = builder.sex;
            if (num == null) {
                this.sex = DEFAULT_SEX;
            } else {
                this.sex = num;
            }
            String str4 = builder.position;
            if (str4 == null) {
                this.position = "";
            } else {
                this.position = str4;
            }
            Double d2 = builder.lng;
            if (d2 == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = d2;
            }
            Double d3 = builder.lat;
            if (d3 == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = d3;
            }
            Integer num2 = builder.level;
            if (num2 == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = num2;
            }
            Integer num3 = builder.isOfficial;
            if (num3 == null) {
                this.isOfficial = DEFAULT_ISOFFICIAL;
            } else {
                this.isOfficial = num3;
            }
            Integer num4 = builder.isLiveAdmin;
            if (num4 == null) {
                this.isLiveAdmin = DEFAULT_ISLIVEADMIN;
            } else {
                this.isLiveAdmin = num4;
            }
            Integer num5 = builder.audienceLevel;
            if (num5 == null) {
                this.audienceLevel = DEFAULT_AUDIENCELEVEL;
            } else {
                this.audienceLevel = num5;
            }
            String str5 = builder.third_app_id;
            if (str5 == null) {
                this.third_app_id = "";
            } else {
                this.third_app_id = str5;
            }
            String str6 = builder.third_app_name;
            if (str6 == null) {
                this.third_app_name = "";
            } else {
                this.third_app_name = str6;
            }
            String str7 = builder.description;
            if (str7 == null) {
                this.description = "";
            } else {
                this.description = str7;
            }
            String str8 = builder.tag_name;
            if (str8 == null) {
                this.tag_name = "";
            } else {
                this.tag_name = str8;
            }
            Integer num6 = builder.tag_type;
            if (num6 == null) {
                this.tag_type = DEFAULT_TAG_TYPE;
            } else {
                this.tag_type = num6;
            }
            List<LiveMarkInfo> list = builder.live_mark_info;
            if (list == null) {
                this.live_mark_info = DEFAULT_LIVE_MARK_INFO;
            } else {
                this.live_mark_info = Message.immutableCopyOf(list);
            }
            List<LiveMarkInfo> list2 = builder.live_mark_info_new;
            if (list2 == null) {
                this.live_mark_info_new = DEFAULT_LIVE_MARK_INFO_NEW;
            } else {
                this.live_mark_info_new = Message.immutableCopyOf(list2);
            }
            List<Integer> list3 = builder.family_effect;
            if (list3 == null) {
                this.family_effect = DEFAULT_FAMILY_EFFECT;
            } else {
                this.family_effect = Message.immutableCopyOf(list3);
            }
            Integer num7 = builder.nobility_im_effect;
            if (num7 == null) {
                this.nobility_im_effect = DEFAULT_NOBILITY_IM_EFFECT;
            } else {
                this.nobility_im_effect = num7;
            }
            this.im_effect = builder.im_effect;
            return;
        }
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.nickNameId = builder.nickNameId;
        this.nickName = builder.nickName;
        this.portrait = builder.portrait;
        this.sex = builder.sex;
        this.position = builder.position;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.level = builder.level;
        this.isOfficial = builder.isOfficial;
        this.isLiveAdmin = builder.isLiveAdmin;
        this.audienceLevel = builder.audienceLevel;
        this.third_app_id = builder.third_app_id;
        this.third_app_name = builder.third_app_name;
        this.description = builder.description;
        this.tag_name = builder.tag_name;
        this.tag_type = builder.tag_type;
        this.live_mark_info = Message.immutableCopyOf(builder.live_mark_info);
        this.live_mark_info_new = Message.immutableCopyOf(builder.live_mark_info_new);
        this.family_effect = Message.immutableCopyOf(builder.family_effect);
        this.nobility_im_effect = builder.nobility_im_effect;
        this.im_effect = builder.im_effect;
    }
}
