package alaim.AlaMgetLiveStatus;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import tbclient.CommonReq;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long audience_count;
    @ProtoField(tag = 1)

    /* renamed from: common  reason: collision with root package name */
    public final CommonReq f1452common;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> live_ids;
    public static final List<Long> DEFAULT_LIVE_IDS = Collections.emptyList();
    public static final Long DEFAULT_AUDIENCE_COUNT = 0L;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long audience_count;

        /* renamed from: common  reason: collision with root package name */
        public CommonReq f1453common;
        public List<Long> live_ids;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.f1453common = dataReq.f1452common;
            this.live_ids = Message.copyOf(dataReq.live_ids);
            this.audience_count = dataReq.audience_count;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.f1452common = builder.f1453common;
            List<Long> list = builder.live_ids;
            if (list == null) {
                this.live_ids = DEFAULT_LIVE_IDS;
            } else {
                this.live_ids = Message.immutableCopyOf(list);
            }
            Long l = builder.audience_count;
            if (l == null) {
                this.audience_count = DEFAULT_AUDIENCE_COUNT;
                return;
            } else {
                this.audience_count = l;
                return;
            }
        }
        this.f1452common = builder.f1453common;
        this.live_ids = Message.immutableCopyOf(builder.live_ids);
        this.audience_count = builder.audience_count;
    }
}
