package alaim.AlaPushAlert;

import alaim.MsgInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_EXT = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ext;
    @ProtoField(tag = 3)
    public final MsgInfo msgInfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long pushTime;
    public static final Long DEFAULT_PUSHTIME = 0L;
    public static final Integer DEFAULT_CMD = 0;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer cmd;
        public String ext;
        public MsgInfo msgInfo;
        public Long pushTime;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.pushTime = dataRes.pushTime;
            this.cmd = dataRes.cmd;
            this.msgInfo = dataRes.msgInfo;
            this.ext = dataRes.ext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.pushTime;
            if (l == null) {
                this.pushTime = DEFAULT_PUSHTIME;
            } else {
                this.pushTime = l;
            }
            Integer num = builder.cmd;
            if (num == null) {
                this.cmd = DEFAULT_CMD;
            } else {
                this.cmd = num;
            }
            this.msgInfo = builder.msgInfo;
            String str = builder.ext;
            if (str == null) {
                this.ext = "";
                return;
            } else {
                this.ext = str;
                return;
            }
        }
        this.pushTime = builder.pushTime;
        this.cmd = builder.cmd;
        this.msgInfo = builder.msgInfo;
        this.ext = builder.ext;
    }
}
