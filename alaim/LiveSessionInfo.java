package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class LiveSessionInfo extends Message {
    public static final String DEFAULT_DEFAULT_LINE = "";
    public static final String DEFAULT_FLVURL = "";
    public static final String DEFAULT_HLSURL = "";
    public static final String DEFAULT_RTMPURL = "";
    public static final String DEFAULT_SESSIONID = "";
    @ProtoField(tag = 6)
    public final LiveTranscodeSessionInfo L1;
    @ProtoField(tag = 7)
    public final LiveTranscodeSessionInfo L2;
    @ProtoField(tag = 8)
    public final LiveTranscodeSessionInfo L3;
    @ProtoField(tag = 9)
    public final LiveTranscodeSessionInfo L4;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String default_line;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String flvUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String hlsUrl;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String rtmpUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sessionId;

    private LiveSessionInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.sessionId == null) {
                this.sessionId = "";
            } else {
                this.sessionId = builder.sessionId;
            }
            if (builder.rtmpUrl == null) {
                this.rtmpUrl = "";
            } else {
                this.rtmpUrl = builder.rtmpUrl;
            }
            if (builder.hlsUrl == null) {
                this.hlsUrl = "";
            } else {
                this.hlsUrl = builder.hlsUrl;
            }
            if (builder.flvUrl == null) {
                this.flvUrl = "";
            } else {
                this.flvUrl = builder.flvUrl;
            }
            if (builder.default_line == null) {
                this.default_line = "";
            } else {
                this.default_line = builder.default_line;
            }
            this.L1 = builder.L1;
            this.L2 = builder.L2;
            this.L3 = builder.L3;
            this.L4 = builder.L4;
            return;
        }
        this.sessionId = builder.sessionId;
        this.rtmpUrl = builder.rtmpUrl;
        this.hlsUrl = builder.hlsUrl;
        this.flvUrl = builder.flvUrl;
        this.default_line = builder.default_line;
        this.L1 = builder.L1;
        this.L2 = builder.L2;
        this.L3 = builder.L3;
        this.L4 = builder.L4;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<LiveSessionInfo> {
        public LiveTranscodeSessionInfo L1;
        public LiveTranscodeSessionInfo L2;
        public LiveTranscodeSessionInfo L3;
        public LiveTranscodeSessionInfo L4;
        public String default_line;
        public String flvUrl;
        public String hlsUrl;
        public String rtmpUrl;
        public String sessionId;

        public Builder() {
        }

        public Builder(LiveSessionInfo liveSessionInfo) {
            super(liveSessionInfo);
            if (liveSessionInfo != null) {
                this.sessionId = liveSessionInfo.sessionId;
                this.rtmpUrl = liveSessionInfo.rtmpUrl;
                this.hlsUrl = liveSessionInfo.hlsUrl;
                this.flvUrl = liveSessionInfo.flvUrl;
                this.default_line = liveSessionInfo.default_line;
                this.L1 = liveSessionInfo.L1;
                this.L2 = liveSessionInfo.L2;
                this.L3 = liveSessionInfo.L3;
                this.L4 = liveSessionInfo.L4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveSessionInfo build(boolean z) {
            return new LiveSessionInfo(this, z);
        }
    }
}
