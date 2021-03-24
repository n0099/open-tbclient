package alaim.AlaMgetLiveStatus;

import alaim.Error;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class AlaMgetLiveStatusResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<AlaMgetLiveStatusResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(AlaMgetLiveStatusResIdl alaMgetLiveStatusResIdl) {
            super(alaMgetLiveStatusResIdl);
            if (alaMgetLiveStatusResIdl == null) {
                return;
            }
            this.error = alaMgetLiveStatusResIdl.error;
            this.data = alaMgetLiveStatusResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public AlaMgetLiveStatusResIdl build(boolean z) {
            return new AlaMgetLiveStatusResIdl(this, z);
        }
    }

    public AlaMgetLiveStatusResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
