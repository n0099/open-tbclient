package com.baidu.tbadk.core.feedManager;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import tbclient.Error;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public final class PersonalizedResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<PersonalizedResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(PersonalizedResIdl personalizedResIdl) {
            super(personalizedResIdl);
            if (personalizedResIdl == null) {
                return;
            }
            this.error = personalizedResIdl.error;
            this.data = personalizedResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public PersonalizedResIdl build(boolean z) {
            return new PersonalizedResIdl(this, z);
        }
    }

    public PersonalizedResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
