package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes3.dex */
public final class LiveMedia extends Message {
    @ProtoField(tag = 1)
    public final LiveVideoInfo video;

    private LiveMedia(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.video = builder.video;
        } else {
            this.video = builder.video;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<LiveMedia> {
        public LiveVideoInfo video;

        public Builder() {
        }

        public Builder(LiveMedia liveMedia) {
            super(liveMedia);
            if (liveMedia != null) {
                this.video = liveMedia.video;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveMedia build(boolean z) {
            return new LiveMedia(this, z);
        }
    }
}
