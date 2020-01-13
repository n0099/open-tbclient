package UserPost;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import tbclient.PostInfoList;
/* loaded from: classes7.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long ctime;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer hide_post;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long logid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mask_type;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<PostInfoList> post_list;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer reddot_deleted_thread;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer view_card_num;
    public static final List<PostInfoList> DEFAULT_POST_LIST = Collections.emptyList();
    public static final Integer DEFAULT_HIDE_POST = 0;
    public static final Long DEFAULT_TIME = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_LOGID = 0L;
    public static final Integer DEFAULT_MASK_TYPE = 0;
    public static final Integer DEFAULT_VIEW_CARD_NUM = 0;
    public static final Integer DEFAULT_REDDOT_DELETED_THREAD = 0;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.post_list == null) {
                this.post_list = DEFAULT_POST_LIST;
            } else {
                this.post_list = immutableCopyOf(builder.post_list);
            }
            if (builder.hide_post == null) {
                this.hide_post = DEFAULT_HIDE_POST;
            } else {
                this.hide_post = builder.hide_post;
            }
            if (builder.time == null) {
                this.time = DEFAULT_TIME;
            } else {
                this.time = builder.time;
            }
            if (builder.ctime == null) {
                this.ctime = DEFAULT_CTIME;
            } else {
                this.ctime = builder.ctime;
            }
            if (builder.logid == null) {
                this.logid = DEFAULT_LOGID;
            } else {
                this.logid = builder.logid;
            }
            if (builder.mask_type == null) {
                this.mask_type = DEFAULT_MASK_TYPE;
            } else {
                this.mask_type = builder.mask_type;
            }
            if (builder.view_card_num == null) {
                this.view_card_num = DEFAULT_VIEW_CARD_NUM;
            } else {
                this.view_card_num = builder.view_card_num;
            }
            if (builder.reddot_deleted_thread == null) {
                this.reddot_deleted_thread = DEFAULT_REDDOT_DELETED_THREAD;
                return;
            } else {
                this.reddot_deleted_thread = builder.reddot_deleted_thread;
                return;
            }
        }
        this.post_list = immutableCopyOf(builder.post_list);
        this.hide_post = builder.hide_post;
        this.time = builder.time;
        this.ctime = builder.ctime;
        this.logid = builder.logid;
        this.mask_type = builder.mask_type;
        this.view_card_num = builder.view_card_num;
        this.reddot_deleted_thread = builder.reddot_deleted_thread;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Long ctime;
        public Integer hide_post;
        public Long logid;
        public Integer mask_type;
        public List<PostInfoList> post_list;
        public Integer reddot_deleted_thread;
        public Long time;
        public Integer view_card_num;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.post_list = DataRes.copyOf(dataRes.post_list);
                this.hide_post = dataRes.hide_post;
                this.time = dataRes.time;
                this.ctime = dataRes.ctime;
                this.logid = dataRes.logid;
                this.mask_type = dataRes.mask_type;
                this.view_card_num = dataRes.view_card_num;
                this.reddot_deleted_thread = dataRes.reddot_deleted_thread;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
