package alaim.AlaMgetLiveStatus;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class AlaMgetLiveStatusReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<AlaMgetLiveStatusReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(AlaMgetLiveStatusReqIdl alaMgetLiveStatusReqIdl) {
            super(alaMgetLiveStatusReqIdl);
            if (alaMgetLiveStatusReqIdl == null) {
                return;
            }
            this.data = alaMgetLiveStatusReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public AlaMgetLiveStatusReqIdl build(boolean z) {
            return new AlaMgetLiveStatusReqIdl(this, z);
        }
    }

    public AlaMgetLiveStatusReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
