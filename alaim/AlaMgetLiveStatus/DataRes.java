package alaim.AlaMgetLiveStatus;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class DataRes extends Message {
    public static final List<Long> DEFAULT_CLOSE_LIVE = Collections.emptyList();
    public static final Long DEFAULT_INTERVAL = 0L;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> close_live;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long interval;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.close_live == null) {
                this.close_live = DEFAULT_CLOSE_LIVE;
            } else {
                this.close_live = immutableCopyOf(builder.close_live);
            }
            if (builder.interval == null) {
                this.interval = DEFAULT_INTERVAL;
                return;
            } else {
                this.interval = builder.interval;
                return;
            }
        }
        this.close_live = immutableCopyOf(builder.close_live);
        this.interval = builder.interval;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public List<Long> close_live;
        public Long interval;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.close_live = DataRes.copyOf(dataRes.close_live);
                this.interval = dataRes.interval;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
