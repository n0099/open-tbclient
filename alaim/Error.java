package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class Error extends Message {
    public static final Integer DEFAULT_ERRORNO = 0;
    public static final Long DEFAULT_LOGID = 0L;
    public static final Integer DEFAULT_TIME = 0;
    public static final String DEFAULT_USERMSG = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer errorno;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long logid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer time;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String usermsg;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<Error> {
        public Integer errorno;
        public Long logid;
        public Integer time;
        public String usermsg;

        public Builder() {
        }

        public Builder(Error error) {
            super(error);
            if (error == null) {
                return;
            }
            this.errorno = error.errorno;
            this.usermsg = error.usermsg;
            this.logid = error.logid;
            this.time = error.time;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public Error build(boolean z) {
            return new Error(this, z);
        }
    }

    public Error(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.errorno;
            if (num == null) {
                this.errorno = DEFAULT_ERRORNO;
            } else {
                this.errorno = num;
            }
            String str = builder.usermsg;
            if (str == null) {
                this.usermsg = "";
            } else {
                this.usermsg = str;
            }
            Long l = builder.logid;
            if (l == null) {
                this.logid = DEFAULT_LOGID;
            } else {
                this.logid = l;
            }
            Integer num2 = builder.time;
            if (num2 == null) {
                this.time = DEFAULT_TIME;
                return;
            } else {
                this.time = num2;
                return;
            }
        }
        this.errorno = builder.errorno;
        this.usermsg = builder.usermsg;
        this.logid = builder.logid;
        this.time = builder.time;
    }
}
