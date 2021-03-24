package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
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
public final class RpcMetaPb$RpcMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ACCEPT_COMPRESS_TYPE_FIELD_NUMBER = 9;
    public static final int ATTACHMENT_SIZE_FIELD_NUMBER = 5;
    public static final int AUTHENTICATION_DATA_FIELD_NUMBER = 7;
    public static final int CHUNK_INFO_FIELD_NUMBER = 6;
    public static final int COMPRESS_TYPE_FIELD_NUMBER = 3;
    public static final int CORRELATION_ID_FIELD_NUMBER = 4;
    public static final int NOTIFY_FIELD_NUMBER = 8;
    public static final Parser<RpcMetaPb$RpcMeta> PARSER = new a();
    public static final int REQUEST_FIELD_NUMBER = 1;
    public static final int RESPONSE_FIELD_NUMBER = 2;
    public static final RpcMetaPb$RpcMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int acceptCompressType;
    public int attachmentSize;
    public ByteString authenticationData;
    public int bitField0;
    public RpcMetaPb$ChunkInfo chunkInfo;
    public int compressType;
    public long correlationId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public RpcMetaPb$RpcNotifyMeta notify;
    public RpcMetaPb$RpcRequestMeta request;
    public RpcMetaPb$RpcResponseMeta response;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcMeta> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public RpcMetaPb$RpcMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcMeta(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcMeta, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6404e;

        /* renamed from: h  reason: collision with root package name */
        public int f6407h;
        public long i;
        public int j;
        public int n;

        /* renamed from: f  reason: collision with root package name */
        public RpcMetaPb$RpcRequestMeta f6405f = RpcMetaPb$RpcRequestMeta.getDefaultInstance();

        /* renamed from: g  reason: collision with root package name */
        public RpcMetaPb$RpcResponseMeta f6406g = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
        public RpcMetaPb$ChunkInfo k = RpcMetaPb$ChunkInfo.getDefaultInstance();
        public ByteString l = ByteString.EMPTY;
        public RpcMetaPb$RpcNotifyMeta m = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        public b A(int i) {
            this.f6404e |= 256;
            this.n = i;
            return this;
        }

        public b B(int i) {
            this.f6404e |= 16;
            this.j = i;
            return this;
        }

        public b C(ByteString byteString) {
            if (byteString != null) {
                this.f6404e |= 64;
                this.l = byteString;
                return this;
            }
            throw null;
        }

        public b D(int i) {
            this.f6404e |= 4;
            this.f6407h = i;
            return this;
        }

        public b E(long j) {
            this.f6404e |= 8;
            this.i = j;
            return this;
        }

        public b F(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            if (rpcMetaPb$RpcRequestMeta != null) {
                this.f6405f = rpcMetaPb$RpcRequestMeta;
                this.f6404e |= 1;
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
            return !t() || r().isInitialized();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$RpcMeta build() {
            RpcMetaPb$RpcMeta buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            w(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public RpcMetaPb$RpcMeta buildPartial() {
            RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta(this);
            int i = this.f6404e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            rpcMetaPb$RpcMeta.request = this.f6405f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            rpcMetaPb$RpcMeta.response = this.f6406g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            rpcMetaPb$RpcMeta.compressType = this.f6407h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            rpcMetaPb$RpcMeta.correlationId = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            rpcMetaPb$RpcMeta.attachmentSize = this.j;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            rpcMetaPb$RpcMeta.chunkInfo = this.k;
            if ((i & 64) == 64) {
                i2 |= 64;
            }
            rpcMetaPb$RpcMeta.authenticationData = this.l;
            if ((i & 128) == 128) {
                i2 |= 128;
            }
            rpcMetaPb$RpcMeta.notify = this.m;
            if ((i & 256) == 256) {
                i2 |= 256;
            }
            rpcMetaPb$RpcMeta.acceptCompressType = this.n;
            rpcMetaPb$RpcMeta.bitField0 = i2;
            return rpcMetaPb$RpcMeta;
        }

        public b o() {
            super.clear();
            this.f6405f = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
            this.f6404e &= -2;
            this.f6406g = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            int i = this.f6404e & (-3);
            this.f6404e = i;
            this.f6407h = 0;
            int i2 = i & (-5);
            this.f6404e = i2;
            this.i = 0L;
            int i3 = i2 & (-9);
            this.f6404e = i3;
            this.j = 0;
            this.f6404e = i3 & (-17);
            this.k = RpcMetaPb$ChunkInfo.getDefaultInstance();
            int i4 = this.f6404e & (-33);
            this.f6404e = i4;
            this.l = ByteString.EMPTY;
            this.f6404e = i4 & (-65);
            this.m = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            int i5 = this.f6404e & (-129);
            this.f6404e = i5;
            this.n = 0;
            this.f6404e = i5 & (-257);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.v(buildPartial());
            return q;
        }

        public RpcMetaPb$ChunkInfo r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: s */
        public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcMeta.getDefaultInstance();
        }

        public boolean t() {
            return (this.f6404e & 32) == 32;
        }

        public b u(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            if ((this.f6404e & 32) == 32 && this.k != RpcMetaPb$ChunkInfo.getDefaultInstance()) {
                RpcMetaPb$ChunkInfo.b newBuilder = RpcMetaPb$ChunkInfo.newBuilder(this.k);
                newBuilder.u(rpcMetaPb$ChunkInfo);
                this.k = newBuilder.buildPartial();
            } else {
                this.k = rpcMetaPb$ChunkInfo;
            }
            this.f6404e |= 32;
            return this;
        }

        public b v(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            if (rpcMetaPb$RpcMeta == RpcMetaPb$RpcMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcMeta.hasRequest()) {
                y(rpcMetaPb$RpcMeta.getRequest());
            }
            if (rpcMetaPb$RpcMeta.hasResponse()) {
                z(rpcMetaPb$RpcMeta.getResponse());
            }
            if (rpcMetaPb$RpcMeta.hasCompressType()) {
                D(rpcMetaPb$RpcMeta.getCompressType());
            }
            if (rpcMetaPb$RpcMeta.hasCorrelationId()) {
                E(rpcMetaPb$RpcMeta.getCorrelationId());
            }
            if (rpcMetaPb$RpcMeta.hasAttachmentSize()) {
                B(rpcMetaPb$RpcMeta.getAttachmentSize());
            }
            if (rpcMetaPb$RpcMeta.hasChunkInfo()) {
                u(rpcMetaPb$RpcMeta.getChunkInfo());
            }
            if (rpcMetaPb$RpcMeta.hasAuthenticationData()) {
                C(rpcMetaPb$RpcMeta.getAuthenticationData());
            }
            if (rpcMetaPb$RpcMeta.hasNotify()) {
                x(rpcMetaPb$RpcMeta.getNotify());
            }
            if (rpcMetaPb$RpcMeta.hasAcceptCompressType()) {
                A(rpcMetaPb$RpcMeta.getAcceptCompressType());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b w(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = null;
            try {
                try {
                    RpcMetaPb$RpcMeta parsePartialFrom = RpcMetaPb$RpcMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        v(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta2 = (RpcMetaPb$RpcMeta) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        rpcMetaPb$RpcMeta = rpcMetaPb$RpcMeta2;
                        if (rpcMetaPb$RpcMeta != null) {
                            v(rpcMetaPb$RpcMeta);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rpcMetaPb$RpcMeta != null) {
                }
                throw th;
            }
        }

        public b x(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            if ((this.f6404e & 128) == 128 && this.m != RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                RpcMetaPb$RpcNotifyMeta.b newBuilder = RpcMetaPb$RpcNotifyMeta.newBuilder(this.m);
                newBuilder.s(rpcMetaPb$RpcNotifyMeta);
                this.m = newBuilder.buildPartial();
            } else {
                this.m = rpcMetaPb$RpcNotifyMeta;
            }
            this.f6404e |= 128;
            return this;
        }

        public b y(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            if ((this.f6404e & 1) == 1 && this.f6405f != RpcMetaPb$RpcRequestMeta.getDefaultInstance()) {
                RpcMetaPb$RpcRequestMeta.b newBuilder = RpcMetaPb$RpcRequestMeta.newBuilder(this.f6405f);
                newBuilder.s(rpcMetaPb$RpcRequestMeta);
                this.f6405f = newBuilder.buildPartial();
            } else {
                this.f6405f = rpcMetaPb$RpcRequestMeta;
            }
            this.f6404e |= 1;
            return this;
        }

        public b z(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            if ((this.f6404e & 2) == 2 && this.f6406g != RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                RpcMetaPb$RpcResponseMeta.b newBuilder = RpcMetaPb$RpcResponseMeta.newBuilder(this.f6406g);
                newBuilder.s(rpcMetaPb$RpcResponseMeta);
                this.f6406g = newBuilder.buildPartial();
            } else {
                this.f6406g = rpcMetaPb$RpcResponseMeta;
            }
            this.f6404e |= 2;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            v(rpcMetaPb$RpcMeta);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            w(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta(true);
        defaultInstance = rpcMetaPb$RpcMeta;
        rpcMetaPb$RpcMeta.initFields();
    }

    public static RpcMetaPb$RpcMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.request = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
        this.response = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
        this.compressType = 0;
        this.correlationId = 0L;
        this.attachmentSize = 0;
        this.chunkInfo = RpcMetaPb$ChunkInfo.getDefaultInstance();
        this.authenticationData = ByteString.EMPTY;
        this.notify = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
        this.acceptCompressType = 0;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getAcceptCompressType() {
        return this.acceptCompressType;
    }

    public int getAttachmentSize() {
        return this.attachmentSize;
    }

    public ByteString getAuthenticationData() {
        return this.authenticationData;
    }

    public RpcMetaPb$ChunkInfo getChunkInfo() {
        return this.chunkInfo;
    }

    public int getCompressType() {
        return this.compressType;
    }

    public long getCorrelationId() {
        return this.correlationId;
    }

    public RpcMetaPb$RpcNotifyMeta getNotify() {
        return this.notify;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcMeta> getParserForType() {
        return PARSER;
    }

    public RpcMetaPb$RpcRequestMeta getRequest() {
        return this.request;
    }

    public RpcMetaPb$RpcResponseMeta getResponse() {
        return this.response;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.request) : 0;
        if ((this.bitField0 & 2) == 2) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, this.response);
        }
        if ((this.bitField0 & 4) == 4) {
            computeMessageSize += CodedOutputStream.computeInt32Size(3, this.compressType);
        }
        if ((this.bitField0 & 8) == 8) {
            computeMessageSize += CodedOutputStream.computeInt64Size(4, this.correlationId);
        }
        if ((this.bitField0 & 16) == 16) {
            computeMessageSize += CodedOutputStream.computeInt32Size(5, this.attachmentSize);
        }
        if ((this.bitField0 & 32) == 32) {
            computeMessageSize += CodedOutputStream.computeMessageSize(6, this.chunkInfo);
        }
        if ((this.bitField0 & 64) == 64) {
            computeMessageSize += CodedOutputStream.computeBytesSize(7, this.authenticationData);
        }
        if ((this.bitField0 & 128) == 128) {
            computeMessageSize += CodedOutputStream.computeMessageSize(8, this.notify);
        }
        if ((this.bitField0 & 256) == 256) {
            computeMessageSize += CodedOutputStream.computeInt32Size(9, this.acceptCompressType);
        }
        this.memoizedSerializedSize = computeMessageSize;
        return computeMessageSize;
    }

    public boolean hasAcceptCompressType() {
        return (this.bitField0 & 256) == 256;
    }

    public boolean hasAttachmentSize() {
        return (this.bitField0 & 16) == 16;
    }

    public boolean hasAuthenticationData() {
        return (this.bitField0 & 64) == 64;
    }

    public boolean hasChunkInfo() {
        return (this.bitField0 & 32) == 32;
    }

    public boolean hasCompressType() {
        return (this.bitField0 & 4) == 4;
    }

    public boolean hasCorrelationId() {
        return (this.bitField0 & 8) == 8;
    }

    public boolean hasNotify() {
        return (this.bitField0 & 128) == 128;
    }

    public boolean hasRequest() {
        return (this.bitField0 & 1) == 1;
    }

    public boolean hasResponse() {
        return (this.bitField0 & 2) == 2;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (hasChunkInfo() && !getChunkInfo().isInitialized()) {
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
        if ((this.bitField0 & 1) == 1) {
            codedOutputStream.writeMessage(1, this.request);
        }
        if ((this.bitField0 & 2) == 2) {
            codedOutputStream.writeMessage(2, this.response);
        }
        if ((this.bitField0 & 4) == 4) {
            codedOutputStream.writeInt32(3, this.compressType);
        }
        if ((this.bitField0 & 8) == 8) {
            codedOutputStream.writeInt64(4, this.correlationId);
        }
        if ((this.bitField0 & 16) == 16) {
            codedOutputStream.writeInt32(5, this.attachmentSize);
        }
        if ((this.bitField0 & 32) == 32) {
            codedOutputStream.writeMessage(6, this.chunkInfo);
        }
        if ((this.bitField0 & 64) == 64) {
            codedOutputStream.writeBytes(7, this.authenticationData);
        }
        if ((this.bitField0 & 128) == 128) {
            codedOutputStream.writeMessage(8, this.notify);
        }
        if ((this.bitField0 & 256) == 256) {
            codedOutputStream.writeInt32(9, this.acceptCompressType);
        }
    }

    public static b newBuilder(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
        b newBuilder = newBuilder();
        newBuilder.v(rpcMetaPb$RpcMeta);
        return newBuilder;
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
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

    public RpcMetaPb$RpcMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcMeta(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$RpcMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            RpcMetaPb$RpcRequestMeta.b builder = (this.bitField0 & 1) == 1 ? this.request.toBuilder() : null;
                            RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = (RpcMetaPb$RpcRequestMeta) codedInputStream.readMessage(RpcMetaPb$RpcRequestMeta.PARSER, extensionRegistryLite);
                            this.request = rpcMetaPb$RpcRequestMeta;
                            if (builder != null) {
                                builder.s(rpcMetaPb$RpcRequestMeta);
                                this.request = builder.buildPartial();
                            }
                            this.bitField0 |= 1;
                        } else if (readTag == 18) {
                            RpcMetaPb$RpcResponseMeta.b builder2 = (this.bitField0 & 2) == 2 ? this.response.toBuilder() : null;
                            RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = (RpcMetaPb$RpcResponseMeta) codedInputStream.readMessage(RpcMetaPb$RpcResponseMeta.PARSER, extensionRegistryLite);
                            this.response = rpcMetaPb$RpcResponseMeta;
                            if (builder2 != null) {
                                builder2.s(rpcMetaPb$RpcResponseMeta);
                                this.response = builder2.buildPartial();
                            }
                            this.bitField0 |= 2;
                        } else if (readTag == 24) {
                            this.bitField0 |= 4;
                            this.compressType = codedInputStream.readInt32();
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.correlationId = codedInputStream.readInt64();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.attachmentSize = codedInputStream.readInt32();
                        } else if (readTag == 50) {
                            RpcMetaPb$ChunkInfo.b builder3 = (this.bitField0 & 32) == 32 ? this.chunkInfo.toBuilder() : null;
                            RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = (RpcMetaPb$ChunkInfo) codedInputStream.readMessage(RpcMetaPb$ChunkInfo.PARSER, extensionRegistryLite);
                            this.chunkInfo = rpcMetaPb$ChunkInfo;
                            if (builder3 != null) {
                                builder3.u(rpcMetaPb$ChunkInfo);
                                this.chunkInfo = builder3.buildPartial();
                            }
                            this.bitField0 |= 32;
                        } else if (readTag == 58) {
                            this.bitField0 |= 64;
                            this.authenticationData = codedInputStream.readBytes();
                        } else if (readTag == 66) {
                            RpcMetaPb$RpcNotifyMeta.b builder4 = (this.bitField0 & 128) == 128 ? this.notify.toBuilder() : null;
                            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = (RpcMetaPb$RpcNotifyMeta) codedInputStream.readMessage(RpcMetaPb$RpcNotifyMeta.PARSER, extensionRegistryLite);
                            this.notify = rpcMetaPb$RpcNotifyMeta;
                            if (builder4 != null) {
                                builder4.s(rpcMetaPb$RpcNotifyMeta);
                                this.notify = builder4.buildPartial();
                            }
                            this.bitField0 |= 128;
                        } else if (readTag != 72) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0 |= 256;
                            this.acceptCompressType = codedInputStream.readInt32();
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
