package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class LiveTranscodeSessionInfo extends Message {
    public static final String DEFAULT_FLVURL = "";
    public static final String DEFAULT_HLSURL = "";
    public static final String DEFAULT_RTMPURL = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String flvUrl;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String hlsUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String rtmpUrl;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<LiveTranscodeSessionInfo> {
        public String flvUrl;
        public String hlsUrl;
        public String rtmpUrl;

        public Builder() {
        }

        public Builder(LiveTranscodeSessionInfo liveTranscodeSessionInfo) {
            super(liveTranscodeSessionInfo);
            if (liveTranscodeSessionInfo == null) {
                return;
            }
            this.rtmpUrl = liveTranscodeSessionInfo.rtmpUrl;
            this.hlsUrl = liveTranscodeSessionInfo.hlsUrl;
            this.flvUrl = liveTranscodeSessionInfo.flvUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveTranscodeSessionInfo build(boolean z) {
            return new LiveTranscodeSessionInfo(this, z);
        }
    }

    public LiveTranscodeSessionInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.rtmpUrl;
            if (str == null) {
                this.rtmpUrl = "";
            } else {
                this.rtmpUrl = str;
            }
            String str2 = builder.hlsUrl;
            if (str2 == null) {
                this.hlsUrl = "";
            } else {
                this.hlsUrl = str2;
            }
            String str3 = builder.flvUrl;
            if (str3 == null) {
                this.flvUrl = "";
                return;
            } else {
                this.flvUrl = str3;
                return;
            }
        }
        this.rtmpUrl = builder.rtmpUrl;
        this.hlsUrl = builder.hlsUrl;
        this.flvUrl = builder.flvUrl;
    }
}
