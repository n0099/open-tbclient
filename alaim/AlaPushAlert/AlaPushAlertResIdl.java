package alaim.AlaPushAlert;

import alaim.Error;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class AlaPushAlertResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private AlaPushAlertResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<AlaPushAlertResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(AlaPushAlertResIdl alaPushAlertResIdl) {
            super(alaPushAlertResIdl);
            if (alaPushAlertResIdl != null) {
                this.error = alaPushAlertResIdl.error;
                this.data = alaPushAlertResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public AlaPushAlertResIdl build(boolean z) {
            return new AlaPushAlertResIdl(this, z);
        }
    }
}
