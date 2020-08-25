package alaim;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class ImEffect extends Message {
    public static final String DEFAULT_END_COLOR = "";
    public static final String DEFAULT_START_COLOR = "";
    public static final String DEFAULT_STROKE_COLOR = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String end_color;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String start_color;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String stroke_color;

    private ImEffect(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.start_color == null) {
                this.start_color = "";
            } else {
                this.start_color = builder.start_color;
            }
            if (builder.end_color == null) {
                this.end_color = "";
            } else {
                this.end_color = builder.end_color;
            }
            if (builder.stroke_color == null) {
                this.stroke_color = "";
                return;
            } else {
                this.stroke_color = builder.stroke_color;
                return;
            }
        }
        this.start_color = builder.start_color;
        this.end_color = builder.end_color;
        this.stroke_color = builder.stroke_color;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<ImEffect> {
        public String end_color;
        public String start_color;
        public String stroke_color;

        public Builder() {
        }

        public Builder(ImEffect imEffect) {
            super(imEffect);
            if (imEffect != null) {
                this.start_color = imEffect.start_color;
                this.end_color = imEffect.end_color;
                this.stroke_color = imEffect.stroke_color;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public ImEffect build(boolean z) {
            return new ImEffect(this, z);
        }
    }
}
