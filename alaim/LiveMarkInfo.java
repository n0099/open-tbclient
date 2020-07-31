package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
public final class LiveMarkInfo extends Message {
    public static final String DEFAULT_MARK_NAME = "";
    public static final String DEFAULT_MARK_PIC = "";
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long anchor_user_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long height;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long mark_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String mark_name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String mark_pic;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long type;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long width;
    public static final Long DEFAULT_MARK_ID = 0L;
    public static final Long DEFAULT_ANCHOR_USER_ID = 0L;
    public static final Long DEFAULT_TYPE = 0L;
    public static final Long DEFAULT_HEIGHT = 0L;
    public static final Long DEFAULT_WIDTH = 0L;

    private LiveMarkInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.mark_id == null) {
                this.mark_id = DEFAULT_MARK_ID;
            } else {
                this.mark_id = builder.mark_id;
            }
            if (builder.mark_name == null) {
                this.mark_name = "";
            } else {
                this.mark_name = builder.mark_name;
            }
            if (builder.anchor_user_id == null) {
                this.anchor_user_id = DEFAULT_ANCHOR_USER_ID;
            } else {
                this.anchor_user_id = builder.anchor_user_id;
            }
            if (builder.mark_pic == null) {
                this.mark_pic = "";
            } else {
                this.mark_pic = builder.mark_pic;
            }
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
            }
            if (builder.height == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = builder.height;
            }
            if (builder.width == null) {
                this.width = DEFAULT_WIDTH;
                return;
            } else {
                this.width = builder.width;
                return;
            }
        }
        this.mark_id = builder.mark_id;
        this.mark_name = builder.mark_name;
        this.anchor_user_id = builder.anchor_user_id;
        this.mark_pic = builder.mark_pic;
        this.type = builder.type;
        this.height = builder.height;
        this.width = builder.width;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<LiveMarkInfo> {
        public Long anchor_user_id;
        public Long height;
        public Long mark_id;
        public String mark_name;
        public String mark_pic;
        public Long type;
        public Long width;

        public Builder() {
        }

        public Builder(LiveMarkInfo liveMarkInfo) {
            super(liveMarkInfo);
            if (liveMarkInfo != null) {
                this.mark_id = liveMarkInfo.mark_id;
                this.mark_name = liveMarkInfo.mark_name;
                this.anchor_user_id = liveMarkInfo.anchor_user_id;
                this.mark_pic = liveMarkInfo.mark_pic;
                this.type = liveMarkInfo.type;
                this.height = liveMarkInfo.height;
                this.width = liveMarkInfo.width;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveMarkInfo build(boolean z) {
            return new LiveMarkInfo(this, z);
        }
    }
}
