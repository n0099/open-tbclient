package GetSticker;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes11.dex */
public final class GetStickerReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private GetStickerReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes11.dex */
    public static final class Builder extends Message.Builder<GetStickerReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(GetStickerReqIdl getStickerReqIdl) {
            super(getStickerReqIdl);
            if (getStickerReqIdl != null) {
                this.data = getStickerReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public GetStickerReqIdl build(boolean z) {
            return new GetStickerReqIdl(this, z);
        }
    }
}
