package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
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
public final class LcmPb$RpcData extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int LCM_NOTIFY_FIELD_NUMBER = 3;
    public static final int LCM_REQUEST_FIELD_NUMBER = 1;
    public static final int LCM_RESPONSE_FIELD_NUMBER = 2;
    public static final Parser<LcmPb$RpcData> PARSER = new a();
    public static final LcmPb$RpcData defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public LcmPb$LcmNotify lcmNotify_;
    public LcmPb$LcmRequest lcmRequest_;
    public LcmPb$LcmResponse lcmResponse_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<LcmPb$RpcData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public LcmPb$RpcData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$RpcData(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$RpcData, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6621e;

        /* renamed from: f  reason: collision with root package name */
        public LcmPb$LcmRequest f6622f = LcmPb$LcmRequest.getDefaultInstance();

        /* renamed from: g  reason: collision with root package name */
        public LcmPb$LcmResponse f6623g = LcmPb$LcmResponse.getDefaultInstance();

        /* renamed from: h  reason: collision with root package name */
        public LcmPb$LcmNotify f6624h = LcmPb$LcmNotify.getDefaultInstance();

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        public b A(LcmPb$LcmNotify lcmPb$LcmNotify) {
            if ((this.f6621e & 4) == 4 && this.f6624h != LcmPb$LcmNotify.getDefaultInstance()) {
                LcmPb$LcmNotify.b newBuilder = LcmPb$LcmNotify.newBuilder(this.f6624h);
                newBuilder.t(lcmPb$LcmNotify);
                this.f6624h = newBuilder.buildPartial();
            } else {
                this.f6624h = lcmPb$LcmNotify;
            }
            this.f6621e |= 4;
            return this;
        }

        public b B(LcmPb$LcmRequest lcmPb$LcmRequest) {
            if ((this.f6621e & 1) == 1 && this.f6622f != LcmPb$LcmRequest.getDefaultInstance()) {
                LcmPb$LcmRequest.b newBuilder = LcmPb$LcmRequest.newBuilder(this.f6622f);
                newBuilder.u(lcmPb$LcmRequest);
                this.f6622f = newBuilder.buildPartial();
            } else {
                this.f6622f = lcmPb$LcmRequest;
            }
            this.f6621e |= 1;
            return this;
        }

        public b C(LcmPb$LcmResponse lcmPb$LcmResponse) {
            if ((this.f6621e & 2) == 2 && this.f6623g != LcmPb$LcmResponse.getDefaultInstance()) {
                LcmPb$LcmResponse.b newBuilder = LcmPb$LcmResponse.newBuilder(this.f6623g);
                newBuilder.u(lcmPb$LcmResponse);
                this.f6623g = newBuilder.buildPartial();
            } else {
                this.f6623g = lcmPb$LcmResponse;
            }
            this.f6621e |= 2;
            return this;
        }

        public b D(LcmPb$LcmNotify lcmPb$LcmNotify) {
            if (lcmPb$LcmNotify != null) {
                this.f6624h = lcmPb$LcmNotify;
                this.f6621e |= 4;
                return this;
            }
            throw null;
        }

        public b E(LcmPb$LcmRequest lcmPb$LcmRequest) {
            if (lcmPb$LcmRequest != null) {
                this.f6622f = lcmPb$LcmRequest;
                this.f6621e |= 1;
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!w() || t().isInitialized()) {
                if (!x() || u().isInitialized()) {
                    return !v() || s().isInitialized();
                }
                return false;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$RpcData build() {
            LcmPb$RpcData buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public LcmPb$RpcData buildPartial() {
            LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData(this);
            int i2 = this.f6621e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            lcmPb$RpcData.lcmRequest_ = this.f6622f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            lcmPb$RpcData.lcmResponse_ = this.f6623g;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            lcmPb$RpcData.lcmNotify_ = this.f6624h;
            lcmPb$RpcData.bitField0_ = i3;
            return lcmPb$RpcData;
        }

        public b o() {
            super.clear();
            this.f6622f = LcmPb$LcmRequest.getDefaultInstance();
            this.f6621e &= -2;
            this.f6623g = LcmPb$LcmResponse.getDefaultInstance();
            this.f6621e &= -3;
            this.f6624h = LcmPb$LcmNotify.getDefaultInstance();
            this.f6621e &= -5;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.y(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$RpcData getDefaultInstanceForType() {
            return LcmPb$RpcData.getDefaultInstance();
        }

        public LcmPb$LcmNotify s() {
            return this.f6624h;
        }

        public LcmPb$LcmRequest t() {
            return this.f6622f;
        }

        public LcmPb$LcmResponse u() {
            return this.f6623g;
        }

        public boolean v() {
            return (this.f6621e & 4) == 4;
        }

        public boolean w() {
            return (this.f6621e & 1) == 1;
        }

        public boolean x() {
            return (this.f6621e & 2) == 2;
        }

        public b y(LcmPb$RpcData lcmPb$RpcData) {
            if (lcmPb$RpcData == LcmPb$RpcData.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$RpcData.hasLcmRequest()) {
                B(lcmPb$RpcData.getLcmRequest());
            }
            if (lcmPb$RpcData.hasLcmResponse()) {
                C(lcmPb$RpcData.getLcmResponse());
            }
            if (lcmPb$RpcData.hasLcmNotify()) {
                A(lcmPb$RpcData.getLcmNotify());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b z(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$RpcData lcmPb$RpcData = null;
            try {
                try {
                    LcmPb$RpcData parsePartialFrom = LcmPb$RpcData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        y(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    LcmPb$RpcData lcmPb$RpcData2 = (LcmPb$RpcData) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        lcmPb$RpcData = lcmPb$RpcData2;
                        if (lcmPb$RpcData != null) {
                            y(lcmPb$RpcData);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lcmPb$RpcData != null) {
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$RpcData lcmPb$RpcData) {
            y(lcmPb$RpcData);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData(true);
        defaultInstance = lcmPb$RpcData;
        lcmPb$RpcData.initFields();
    }

    public static LcmPb$RpcData getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.lcmRequest_ = LcmPb$LcmRequest.getDefaultInstance();
        this.lcmResponse_ = LcmPb$LcmResponse.getDefaultInstance();
        this.lcmNotify_ = LcmPb$LcmNotify.getDefaultInstance();
    }

    public static b newBuilder() {
        return b.q();
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public LcmPb$LcmNotify getLcmNotify() {
        return this.lcmNotify_;
    }

    public LcmPb$LcmRequest getLcmRequest() {
        return this.lcmRequest_;
    }

    public LcmPb$LcmResponse getLcmResponse() {
        return this.lcmResponse_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$RpcData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.lcmRequest_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, this.lcmResponse_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, this.lcmNotify_);
        }
        this.memoizedSerializedSize = computeMessageSize;
        return computeMessageSize;
    }

    public boolean hasLcmNotify() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasLcmRequest() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasLcmResponse() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (hasLcmRequest() && !getLcmRequest().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (hasLcmResponse() && !getLcmResponse().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (hasLcmNotify() && !getLcmNotify().isInitialized()) {
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
            codedOutputStream.writeMessage(1, this.lcmRequest_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.lcmResponse_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.lcmNotify_);
        }
    }

    public static b newBuilder(LcmPb$RpcData lcmPb$RpcData) {
        b newBuilder = newBuilder();
        newBuilder.y(lcmPb$RpcData);
        return newBuilder;
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$RpcData getDefaultInstanceForType() {
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

    public LcmPb$RpcData(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$RpcData(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$RpcData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                LcmPb$LcmRequest.b builder = (this.bitField0_ & 1) == 1 ? this.lcmRequest_.toBuilder() : null;
                                LcmPb$LcmRequest lcmPb$LcmRequest = (LcmPb$LcmRequest) codedInputStream.readMessage(LcmPb$LcmRequest.PARSER, extensionRegistryLite);
                                this.lcmRequest_ = lcmPb$LcmRequest;
                                if (builder != null) {
                                    builder.u(lcmPb$LcmRequest);
                                    this.lcmRequest_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (readTag == 18) {
                                LcmPb$LcmResponse.b builder2 = (this.bitField0_ & 2) == 2 ? this.lcmResponse_.toBuilder() : null;
                                LcmPb$LcmResponse lcmPb$LcmResponse = (LcmPb$LcmResponse) codedInputStream.readMessage(LcmPb$LcmResponse.PARSER, extensionRegistryLite);
                                this.lcmResponse_ = lcmPb$LcmResponse;
                                if (builder2 != null) {
                                    builder2.u(lcmPb$LcmResponse);
                                    this.lcmResponse_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                LcmPb$LcmNotify.b builder3 = (this.bitField0_ & 4) == 4 ? this.lcmNotify_.toBuilder() : null;
                                LcmPb$LcmNotify lcmPb$LcmNotify = (LcmPb$LcmNotify) codedInputStream.readMessage(LcmPb$LcmNotify.PARSER, extensionRegistryLite);
                                this.lcmNotify_ = lcmPb$LcmNotify;
                                if (builder3 != null) {
                                    builder3.t(lcmPb$LcmNotify);
                                    this.lcmNotify_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }
}
