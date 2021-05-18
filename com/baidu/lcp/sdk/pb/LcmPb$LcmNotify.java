package com.baidu.lcp.sdk.pb;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes2.dex */
public final class LcmPb$LcmNotify extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 2;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static final Parser<LcmPb$LcmNotify> PARSER = new a();
    public static final LcmPb$LcmNotify defaultInstance;
    public static final long serialVersionUID = 0;
    public int action_;
    public int bitField0_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<LcmPb$LcmNotify> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public LcmPb$LcmNotify parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$LcmNotify(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$LcmNotify, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6432e;

        /* renamed from: f  reason: collision with root package name */
        public long f6433f;

        /* renamed from: g  reason: collision with root package name */
        public int f6434g;

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$LcmNotify build() {
            LcmPb$LcmNotify buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public LcmPb$LcmNotify buildPartial() {
            LcmPb$LcmNotify lcmPb$LcmNotify = new LcmPb$LcmNotify(this);
            int i2 = this.f6432e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            lcmPb$LcmNotify.logId_ = this.f6433f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            lcmPb$LcmNotify.action_ = this.f6434g;
            lcmPb$LcmNotify.bitField0_ = i3;
            return lcmPb$LcmNotify;
        }

        public b o() {
            super.clear();
            this.f6433f = 0L;
            int i2 = this.f6432e & (-2);
            this.f6432e = i2;
            this.f6434g = 0;
            this.f6432e = i2 & (-3);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.t(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$LcmNotify getDefaultInstanceForType() {
            return LcmPb$LcmNotify.getDefaultInstance();
        }

        public boolean s() {
            return (this.f6432e & 1) == 1;
        }

        public b t(LcmPb$LcmNotify lcmPb$LcmNotify) {
            if (lcmPb$LcmNotify == LcmPb$LcmNotify.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$LcmNotify.hasLogId()) {
                w(lcmPb$LcmNotify.getLogId());
            }
            if (lcmPb$LcmNotify.hasAction()) {
                v(lcmPb$LcmNotify.getAction());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$LcmNotify lcmPb$LcmNotify = null;
            try {
                try {
                    LcmPb$LcmNotify parsePartialFrom = LcmPb$LcmNotify.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        t(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    LcmPb$LcmNotify lcmPb$LcmNotify2 = (LcmPb$LcmNotify) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        lcmPb$LcmNotify = lcmPb$LcmNotify2;
                        if (lcmPb$LcmNotify != null) {
                            t(lcmPb$LcmNotify);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lcmPb$LcmNotify != null) {
                }
                throw th;
            }
        }

        public b v(int i2) {
            this.f6432e |= 2;
            this.f6434g = i2;
            return this;
        }

        public b w(long j) {
            this.f6432e |= 1;
            this.f6433f = j;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$LcmNotify lcmPb$LcmNotify) {
            t(lcmPb$LcmNotify);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        LcmPb$LcmNotify lcmPb$LcmNotify = new LcmPb$LcmNotify(true);
        defaultInstance = lcmPb$LcmNotify;
        lcmPb$LcmNotify.initFields();
    }

    public static LcmPb$LcmNotify getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.logId_ = 0L;
        this.action_ = 0;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static LcmPb$LcmNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$LcmNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getAction() {
        return this.action_;
    }

    public long getLogId() {
        return this.logId_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$LcmNotify> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeInt32Size(2, this.action_);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (!hasLogId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt64(1, this.logId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.action_);
        }
    }

    public static b newBuilder(LcmPb$LcmNotify lcmPb$LcmNotify) {
        b newBuilder = newBuilder();
        newBuilder.t(lcmPb$LcmNotify);
        return newBuilder;
    }

    public static LcmPb$LcmNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$LcmNotify getDefaultInstanceForType() {
        return defaultInstance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public LcmPb$LcmNotify(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$LcmNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$LcmNotify(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$LcmNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$LcmNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.logId_ = codedInputStream.readInt64();
                        } else if (readTag != 16) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.action_ = codedInputStream.readInt32();
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }
}
