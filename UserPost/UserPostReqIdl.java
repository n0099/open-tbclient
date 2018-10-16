package UserPost;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes5.dex */
public final class UserPostReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private UserPostReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<UserPostReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(UserPostReqIdl userPostReqIdl) {
            super(userPostReqIdl);
            if (userPostReqIdl != null) {
                this.data = userPostReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public UserPostReqIdl build(boolean z) {
            return new UserPostReqIdl(this, z);
        }
    }
}
