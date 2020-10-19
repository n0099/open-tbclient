package GetSugTopic;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes21.dex */
public final class GetSugTopicReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private GetSugTopicReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes21.dex */
    public static final class Builder extends Message.Builder<GetSugTopicReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(GetSugTopicReqIdl getSugTopicReqIdl) {
            super(getSugTopicReqIdl);
            if (getSugTopicReqIdl != null) {
                this.data = getSugTopicReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public GetSugTopicReqIdl build(boolean z) {
            return new GetSugTopicReqIdl(this, z);
        }
    }
}
