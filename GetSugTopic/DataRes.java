package GetSugTopic;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2)
    public final TopicListModule bang_topic;
    @ProtoField(tag = 3)
    public final TopicListModule sug_topic;
    @ProtoField(tag = 1)
    public final TopicListModule user_his_topic;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.user_his_topic = builder.user_his_topic;
            this.bang_topic = builder.bang_topic;
            this.sug_topic = builder.sug_topic;
            return;
        }
        this.user_his_topic = builder.user_his_topic;
        this.bang_topic = builder.bang_topic;
        this.sug_topic = builder.sug_topic;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public TopicListModule bang_topic;
        public TopicListModule sug_topic;
        public TopicListModule user_his_topic;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.user_his_topic = dataRes.user_his_topic;
                this.bang_topic = dataRes.bang_topic;
                this.sug_topic = dataRes.sug_topic;
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
