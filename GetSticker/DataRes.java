package GetSticker;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes13.dex */
public final class DataRes extends Message {
    public static final List<String> DEFAULT_PIC_INFO = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> pic_info;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.pic_info == null) {
                this.pic_info = DEFAULT_PIC_INFO;
                return;
            } else {
                this.pic_info = immutableCopyOf(builder.pic_info);
                return;
            }
        }
        this.pic_info = immutableCopyOf(builder.pic_info);
    }

    /* loaded from: classes13.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public List<String> pic_info;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.pic_info = DataRes.copyOf(dataRes.pic_info);
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
