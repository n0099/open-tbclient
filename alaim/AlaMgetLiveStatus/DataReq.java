package alaim.AlaMgetLiveStatus;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import tbclient.CommonReq;
/* loaded from: classes4.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long audience_count;
    @ProtoField(tag = 1)

    /* renamed from: common  reason: collision with root package name */
    public final CommonReq f956common;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> live_ids;
    public static final List<Long> DEFAULT_LIVE_IDS = Collections.emptyList();
    public static final Long DEFAULT_AUDIENCE_COUNT = 0L;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.f956common = builder.f957common;
            if (builder.live_ids == null) {
                this.live_ids = DEFAULT_LIVE_IDS;
            } else {
                this.live_ids = immutableCopyOf(builder.live_ids);
            }
            if (builder.audience_count == null) {
                this.audience_count = DEFAULT_AUDIENCE_COUNT;
                return;
            } else {
                this.audience_count = builder.audience_count;
                return;
            }
        }
        this.f956common = builder.f957common;
        this.live_ids = immutableCopyOf(builder.live_ids);
        this.audience_count = builder.audience_count;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long audience_count;

        /* renamed from: common  reason: collision with root package name */
        public CommonReq f957common;
        public List<Long> live_ids;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.f957common = dataReq.f956common;
                this.live_ids = DataReq.copyOf(dataReq.live_ids);
                this.audience_count = dataReq.audience_count;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
