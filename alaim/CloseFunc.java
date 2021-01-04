package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class CloseFunc extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer challenge;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer pk;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer red_packet;
    public static final Integer DEFAULT_PK = 0;
    public static final Integer DEFAULT_CHALLENGE = 0;
    public static final Integer DEFAULT_RED_PACKET = 0;

    private CloseFunc(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.pk == null) {
                this.pk = DEFAULT_PK;
            } else {
                this.pk = builder.pk;
            }
            if (builder.challenge == null) {
                this.challenge = DEFAULT_CHALLENGE;
            } else {
                this.challenge = builder.challenge;
            }
            if (builder.red_packet == null) {
                this.red_packet = DEFAULT_RED_PACKET;
                return;
            } else {
                this.red_packet = builder.red_packet;
                return;
            }
        }
        this.pk = builder.pk;
        this.challenge = builder.challenge;
        this.red_packet = builder.red_packet;
    }

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<CloseFunc> {
        public Integer challenge;
        public Integer pk;
        public Integer red_packet;

        public Builder() {
        }

        public Builder(CloseFunc closeFunc) {
            super(closeFunc);
            if (closeFunc != null) {
                this.pk = closeFunc.pk;
                this.challenge = closeFunc.challenge;
                this.red_packet = closeFunc.red_packet;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public CloseFunc build(boolean z) {
            return new CloseFunc(this, z);
        }
    }
}
