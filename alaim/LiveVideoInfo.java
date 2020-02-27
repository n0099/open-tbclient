package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes3.dex */
public final class LiveVideoInfo extends Message {
    public static final Long DEFAULT_DURATION = 0L;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_URL = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long duration;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String url;

    private LiveVideoInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.id == null) {
                this.id = "";
            } else {
                this.id = builder.id;
            }
            if (builder.duration == null) {
                this.duration = DEFAULT_DURATION;
            } else {
                this.duration = builder.duration;
            }
            if (builder.url == null) {
                this.url = "";
                return;
            } else {
                this.url = builder.url;
                return;
            }
        }
        this.id = builder.id;
        this.duration = builder.duration;
        this.url = builder.url;
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<LiveVideoInfo> {
        public Long duration;
        public String id;
        public String url;

        public Builder() {
        }

        public Builder(LiveVideoInfo liveVideoInfo) {
            super(liveVideoInfo);
            if (liveVideoInfo != null) {
                this.id = liveVideoInfo.id;
                this.duration = liveVideoInfo.duration;
                this.url = liveVideoInfo.url;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveVideoInfo build(boolean z) {
            return new LiveVideoInfo(this, z);
        }
    }
}
