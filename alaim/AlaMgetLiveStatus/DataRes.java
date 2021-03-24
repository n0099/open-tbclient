package alaim.AlaMgetLiveStatus;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final List<Long> DEFAULT_CLOSE_LIVE = Collections.emptyList();
    public static final Long DEFAULT_INTERVAL = 0L;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> close_live;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long interval;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public List<Long> close_live;
        public Long interval;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.close_live = Message.copyOf(dataRes.close_live);
            this.interval = dataRes.interval;
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
            List<Long> list = builder.close_live;
            if (list == null) {
                this.close_live = DEFAULT_CLOSE_LIVE;
            } else {
                this.close_live = Message.immutableCopyOf(list);
            }
            Long l = builder.interval;
            if (l == null) {
                this.interval = DEFAULT_INTERVAL;
                return;
            } else {
                this.interval = l;
                return;
            }
        }
        this.close_live = Message.immutableCopyOf(builder.close_live);
        this.interval = builder.interval;
    }
}
