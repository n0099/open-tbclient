package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<CloseFunc> {
        public Integer challenge;
        public Integer pk;
        public Integer red_packet;

        public Builder() {
        }

        public Builder(CloseFunc closeFunc) {
            super(closeFunc);
            if (closeFunc == null) {
                return;
            }
            this.pk = closeFunc.pk;
            this.challenge = closeFunc.challenge;
            this.red_packet = closeFunc.red_packet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public CloseFunc build(boolean z) {
            return new CloseFunc(this, z);
        }
    }

    public CloseFunc(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.pk;
            if (num == null) {
                this.pk = DEFAULT_PK;
            } else {
                this.pk = num;
            }
            Integer num2 = builder.challenge;
            if (num2 == null) {
                this.challenge = DEFAULT_CHALLENGE;
            } else {
                this.challenge = num2;
            }
            Integer num3 = builder.red_packet;
            if (num3 == null) {
                this.red_packet = DEFAULT_RED_PACKET;
                return;
            } else {
                this.red_packet = num3;
                return;
            }
        }
        this.pk = builder.pk;
        this.challenge = builder.challenge;
        this.red_packet = builder.red_packet;
    }
}
