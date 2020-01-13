package GetSticker;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import tbclient.Error;
/* loaded from: classes11.dex */
public final class GetStickerResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private GetStickerResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes11.dex */
    public static final class Builder extends Message.Builder<GetStickerResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(GetStickerResIdl getStickerResIdl) {
            super(getStickerResIdl);
            if (getStickerResIdl != null) {
                this.error = getStickerResIdl.error;
                this.data = getStickerResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public GetStickerResIdl build(boolean z) {
            return new GetStickerResIdl(this, z);
        }
    }
}
