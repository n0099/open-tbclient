package com.baidu.lcp.sdk.pb;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class RpcMetaPb {

    /* loaded from: classes3.dex */
    public enum CompressType implements Internal.EnumLite {
        COMPRESS_NONE(0, 0),
        COMPRESS_GZIP(1, 1);
        
        public static final int COMPRESS_GZIP_VALUE = 1;
        public static final int COMPRESS_NONE_VALUE = 0;
        private static Internal.EnumLiteMap<CompressType> internalValueMap = new Internal.EnumLiteMap<CompressType>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb.CompressType.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: bV */
            public CompressType findValueByNumber(int i) {
                return CompressType.valueOf(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static CompressType valueOf(int i) {
            switch (i) {
                case 0:
                    return COMPRESS_NONE;
                case 1:
                    return COMPRESS_GZIP;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<CompressType> internalGetValueMap() {
            return internalValueMap;
        }

        CompressType(int i, int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class RpcMeta extends GeneratedMessageLite implements j {
        public static final int ACCEPT_COMPRESS_TYPE_FIELD_NUMBER = 9;
        public static final int ATTACHMENT_SIZE_FIELD_NUMBER = 5;
        public static final int AUTHENTICATION_DATA_FIELD_NUMBER = 7;
        public static final int CHUNK_INFO_FIELD_NUMBER = 6;
        public static final int COMPRESS_TYPE_FIELD_NUMBER = 3;
        public static final int CORRELATION_ID_FIELD_NUMBER = 4;
        public static final int NOTIFY_FIELD_NUMBER = 8;
        public static final int REQUEST_FIELD_NUMBER = 1;
        public static final int RESPONSE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int acceptCompressType;
        private int attachmentSize;
        private ByteString authenticationData;
        private int bitField0;
        private ChunkInfo chunkInfo;
        private int compressType;
        private long correlationId;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private RpcNotifyMeta notify;
        private RpcRequestMeta request;
        private RpcResponseMeta response;
        public static final Parser<RpcMeta> PARSER = new AbstractParser<RpcMeta>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb.RpcMeta.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: n */
            public RpcMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RpcMeta(codedInputStream, extensionRegistryLite);
            }
        };
        private static final RpcMeta defaultInstance = new RpcMeta(true);

        private RpcMeta(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private RpcMeta(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static RpcMeta getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public RpcMeta getDefaultInstanceForType() {
            return defaultInstance;
        }

        private RpcMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                continue;
                                z2 = z;
                            case 10:
                                RpcRequestMeta.a builder = (this.bitField0 & 1) == 1 ? this.request.toBuilder() : null;
                                this.request = (RpcRequestMeta) codedInputStream.readMessage(RpcRequestMeta.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.request);
                                    this.request = builder.buildPartial();
                                }
                                this.bitField0 |= 1;
                                z = z2;
                                continue;
                                z2 = z;
                            case 18:
                                RpcResponseMeta.a builder2 = (this.bitField0 & 2) == 2 ? this.response.toBuilder() : null;
                                this.response = (RpcResponseMeta) codedInputStream.readMessage(RpcResponseMeta.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.response);
                                    this.response = builder2.buildPartial();
                                }
                                this.bitField0 |= 2;
                                z = z2;
                                continue;
                                z2 = z;
                            case 24:
                                this.bitField0 |= 4;
                                this.compressType = codedInputStream.readInt32();
                                z = z2;
                                continue;
                                z2 = z;
                            case 32:
                                this.bitField0 |= 8;
                                this.correlationId = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 40:
                                this.bitField0 |= 16;
                                this.attachmentSize = codedInputStream.readInt32();
                                z = z2;
                                continue;
                                z2 = z;
                            case 50:
                                ChunkInfo.a builder3 = (this.bitField0 & 32) == 32 ? this.chunkInfo.toBuilder() : null;
                                this.chunkInfo = (ChunkInfo) codedInputStream.readMessage(ChunkInfo.PARSER, extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.chunkInfo);
                                    this.chunkInfo = builder3.buildPartial();
                                }
                                this.bitField0 |= 32;
                                z = z2;
                                continue;
                                z2 = z;
                            case 58:
                                this.bitField0 |= 64;
                                this.authenticationData = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 66:
                                RpcNotifyMeta.a builder4 = (this.bitField0 & 128) == 128 ? this.notify.toBuilder() : null;
                                this.notify = (RpcNotifyMeta) codedInputStream.readMessage(RpcNotifyMeta.PARSER, extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.notify);
                                    this.notify = builder4.buildPartial();
                                }
                                this.bitField0 |= 128;
                                z = z2;
                                continue;
                                z2 = z;
                            case 72:
                                this.bitField0 |= 256;
                                this.acceptCompressType = codedInputStream.readInt32();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    continue;
                                    z2 = z;
                                }
                                break;
                        }
                        z = z2;
                        z2 = z;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<RpcMeta> getParserForType() {
            return PARSER;
        }

        public boolean hasRequest() {
            return (this.bitField0 & 1) == 1;
        }

        public RpcRequestMeta getRequest() {
            return this.request;
        }

        public boolean hasResponse() {
            return (this.bitField0 & 2) == 2;
        }

        public RpcResponseMeta getResponse() {
            return this.response;
        }

        public boolean hasCompressType() {
            return (this.bitField0 & 4) == 4;
        }

        public int getCompressType() {
            return this.compressType;
        }

        public boolean hasCorrelationId() {
            return (this.bitField0 & 8) == 8;
        }

        public long getCorrelationId() {
            return this.correlationId;
        }

        public boolean hasAttachmentSize() {
            return (this.bitField0 & 16) == 16;
        }

        public int getAttachmentSize() {
            return this.attachmentSize;
        }

        public boolean hasChunkInfo() {
            return (this.bitField0 & 32) == 32;
        }

        public ChunkInfo getChunkInfo() {
            return this.chunkInfo;
        }

        public boolean hasAuthenticationData() {
            return (this.bitField0 & 64) == 64;
        }

        public ByteString getAuthenticationData() {
            return this.authenticationData;
        }

        public boolean hasNotify() {
            return (this.bitField0 & 128) == 128;
        }

        public RpcNotifyMeta getNotify() {
            return this.notify;
        }

        public boolean hasAcceptCompressType() {
            return (this.bitField0 & 256) == 256;
        }

        public int getAcceptCompressType() {
            return this.acceptCompressType;
        }

        private void initFields() {
            this.request = RpcRequestMeta.getDefaultInstance();
            this.response = RpcResponseMeta.getDefaultInstance();
            this.compressType = 0;
            this.correlationId = 0L;
            this.attachmentSize = 0;
            this.chunkInfo = ChunkInfo.getDefaultInstance();
            this.authenticationData = ByteString.EMPTY;
            this.notify = RpcNotifyMeta.getDefaultInstance();
            this.acceptCompressType = 0;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.request) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.response);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.compressType);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.correlationId);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.attachmentSize);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeMessageSize(6, this.chunkInfo);
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeBytesSize(7, this.authenticationData);
                }
                if ((this.bitField0 & 128) == 128) {
                    i += CodedOutputStream.computeMessageSize(8, this.notify);
                }
                if ((this.bitField0 & 256) == 256) {
                    i += CodedOutputStream.computeInt32Size(9, this.acceptCompressType);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RpcMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static RpcMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RpcMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static RpcMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RpcMeta parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static RpcMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static RpcMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static RpcMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static RpcMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static RpcMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.wB();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(RpcMeta rpcMeta) {
            return newBuilder().mergeFrom(rpcMeta);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<RpcMeta, a> implements j {
            private int acceptCompressType;
            private int attachmentSize;
            private int bitField0;
            private int compressType;
            private long correlationId;
            private RpcRequestMeta request = RpcRequestMeta.getDefaultInstance();
            private RpcResponseMeta response = RpcResponseMeta.getDefaultInstance();
            private ChunkInfo chunkInfo = ChunkInfo.getDefaultInstance();
            private ByteString authenticationData = ByteString.EMPTY;
            private RpcNotifyMeta notify = RpcNotifyMeta.getDefaultInstance();

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a wB() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wC */
            public a clear() {
                super.clear();
                this.request = RpcRequestMeta.getDefaultInstance();
                this.bitField0 &= -2;
                this.response = RpcResponseMeta.getDefaultInstance();
                this.bitField0 &= -3;
                this.compressType = 0;
                this.bitField0 &= -5;
                this.correlationId = 0L;
                this.bitField0 &= -9;
                this.attachmentSize = 0;
                this.bitField0 &= -17;
                this.chunkInfo = ChunkInfo.getDefaultInstance();
                this.bitField0 &= -33;
                this.authenticationData = ByteString.EMPTY;
                this.bitField0 &= -65;
                this.notify = RpcNotifyMeta.getDefaultInstance();
                this.bitField0 &= -129;
                this.acceptCompressType = 0;
                this.bitField0 &= -257;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wD */
            public a clone() {
                return wB().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public RpcMeta getDefaultInstanceForType() {
                return RpcMeta.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wE */
            public RpcMeta build() {
                RpcMeta buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wF */
            public RpcMeta buildPartial() {
                RpcMeta rpcMeta = new RpcMeta(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rpcMeta.request = this.request;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcMeta.response = this.response;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcMeta.compressType = this.compressType;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                rpcMeta.correlationId = this.correlationId;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                rpcMeta.attachmentSize = this.attachmentSize;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                rpcMeta.chunkInfo = this.chunkInfo;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                rpcMeta.authenticationData = this.authenticationData;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                rpcMeta.notify = this.notify;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                rpcMeta.acceptCompressType = this.acceptCompressType;
                rpcMeta.bitField0 = i2;
                return rpcMeta;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(RpcMeta rpcMeta) {
                if (rpcMeta != RpcMeta.getDefaultInstance()) {
                    if (rpcMeta.hasRequest()) {
                        b(rpcMeta.getRequest());
                    }
                    if (rpcMeta.hasResponse()) {
                        a(rpcMeta.getResponse());
                    }
                    if (rpcMeta.hasCompressType()) {
                        bW(rpcMeta.getCompressType());
                    }
                    if (rpcMeta.hasCorrelationId()) {
                        ai(rpcMeta.getCorrelationId());
                    }
                    if (rpcMeta.hasAttachmentSize()) {
                        bX(rpcMeta.getAttachmentSize());
                    }
                    if (rpcMeta.hasChunkInfo()) {
                        b(rpcMeta.getChunkInfo());
                    }
                    if (rpcMeta.hasAuthenticationData()) {
                        b(rpcMeta.getAuthenticationData());
                    }
                    if (rpcMeta.hasNotify()) {
                        a(rpcMeta.getNotify());
                    }
                    if (rpcMeta.hasAcceptCompressType()) {
                        bY(rpcMeta.getAcceptCompressType());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !hasChunkInfo() || getChunkInfo().isInitialized();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: o */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                RpcMeta rpcMeta = null;
                try {
                    try {
                        RpcMeta parsePartialFrom = RpcMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (rpcMeta != null) {
                            mergeFrom(rpcMeta);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    RpcMeta rpcMeta2 = (RpcMeta) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        rpcMeta = rpcMeta2;
                        if (rpcMeta != null) {
                        }
                        throw th;
                    }
                }
            }

            public a a(RpcRequestMeta rpcRequestMeta) {
                if (rpcRequestMeta == null) {
                    throw new NullPointerException();
                }
                this.request = rpcRequestMeta;
                this.bitField0 |= 1;
                return this;
            }

            public a b(RpcRequestMeta rpcRequestMeta) {
                if ((this.bitField0 & 1) == 1 && this.request != RpcRequestMeta.getDefaultInstance()) {
                    this.request = RpcRequestMeta.newBuilder(this.request).mergeFrom(rpcRequestMeta).buildPartial();
                } else {
                    this.request = rpcRequestMeta;
                }
                this.bitField0 |= 1;
                return this;
            }

            public a a(RpcResponseMeta rpcResponseMeta) {
                if ((this.bitField0 & 2) == 2 && this.response != RpcResponseMeta.getDefaultInstance()) {
                    this.response = RpcResponseMeta.newBuilder(this.response).mergeFrom(rpcResponseMeta).buildPartial();
                } else {
                    this.response = rpcResponseMeta;
                }
                this.bitField0 |= 2;
                return this;
            }

            public a bW(int i) {
                this.bitField0 |= 4;
                this.compressType = i;
                return this;
            }

            public a ai(long j) {
                this.bitField0 |= 8;
                this.correlationId = j;
                return this;
            }

            public a bX(int i) {
                this.bitField0 |= 16;
                this.attachmentSize = i;
                return this;
            }

            public boolean hasChunkInfo() {
                return (this.bitField0 & 32) == 32;
            }

            public ChunkInfo getChunkInfo() {
                return this.chunkInfo;
            }

            public a b(ChunkInfo chunkInfo) {
                if ((this.bitField0 & 32) == 32 && this.chunkInfo != ChunkInfo.getDefaultInstance()) {
                    this.chunkInfo = ChunkInfo.newBuilder(this.chunkInfo).mergeFrom(chunkInfo).buildPartial();
                } else {
                    this.chunkInfo = chunkInfo;
                }
                this.bitField0 |= 32;
                return this;
            }

            public a b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 64;
                this.authenticationData = byteString;
                return this;
            }

            public a a(RpcNotifyMeta rpcNotifyMeta) {
                if ((this.bitField0 & 128) == 128 && this.notify != RpcNotifyMeta.getDefaultInstance()) {
                    this.notify = RpcNotifyMeta.newBuilder(this.notify).mergeFrom(rpcNotifyMeta).buildPartial();
                } else {
                    this.notify = rpcNotifyMeta;
                }
                this.bitField0 |= 128;
                return this;
            }

            public a bY(int i) {
                this.bitField0 |= 256;
                this.acceptCompressType = i;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class RpcRequestMeta extends GeneratedMessageLite implements l {
        public static final int LOG_ID_FIELD_NUMBER = 3;
        public static final int METHOD_ID_FIELD_NUMBER = 2;
        public static final int NEED_COMMON_FIELD_NUMBER = 4;
        public static final int SERVICE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private long logId;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long methodId;
        private int needCommon;
        private long serviceId;
        public static final Parser<RpcRequestMeta> PARSER = new AbstractParser<RpcRequestMeta>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb.RpcRequestMeta.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: r */
            public RpcRequestMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RpcRequestMeta(codedInputStream, extensionRegistryLite);
            }
        };
        private static final RpcRequestMeta defaultInstance = new RpcRequestMeta(true);

        private RpcRequestMeta(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private RpcRequestMeta(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static RpcRequestMeta getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public RpcRequestMeta getDefaultInstanceForType() {
            return defaultInstance;
        }

        private RpcRequestMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0 |= 1;
                                    this.serviceId = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0 |= 2;
                                    this.methodId = codedInputStream.readInt64();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.logId = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.needCommon = codedInputStream.readInt32();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<RpcRequestMeta> getParserForType() {
            return PARSER;
        }

        public boolean hasServiceId() {
            return (this.bitField0 & 1) == 1;
        }

        public long getServiceId() {
            return this.serviceId;
        }

        public boolean hasMethodId() {
            return (this.bitField0 & 2) == 2;
        }

        public long getMethodId() {
            return this.methodId;
        }

        public boolean hasLogId() {
            return (this.bitField0 & 4) == 4;
        }

        public long getLogId() {
            return this.logId;
        }

        public boolean hasNeedCommon() {
            return (this.bitField0 & 8) == 8;
        }

        public int getNeedCommon() {
            return this.needCommon;
        }

        private void initFields() {
            this.serviceId = 0L;
            this.methodId = 0L;
            this.logId = 0L;
            this.needCommon = 0;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.serviceId);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.methodId);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.logId);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt32(4, this.needCommon);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.methodId);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.logId);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.needCommon);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RpcRequestMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static RpcRequestMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RpcRequestMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static RpcRequestMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RpcRequestMeta parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static RpcRequestMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static RpcRequestMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static RpcRequestMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static RpcRequestMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static RpcRequestMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.wN();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(RpcRequestMeta rpcRequestMeta) {
            return newBuilder().mergeFrom(rpcRequestMeta);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<RpcRequestMeta, a> implements l {
            private int bitField0;
            private long logId;
            private long methodId;
            private int needCommon;
            private long serviceId;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a wN() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wO */
            public a clear() {
                super.clear();
                this.serviceId = 0L;
                this.bitField0 &= -2;
                this.methodId = 0L;
                this.bitField0 &= -3;
                this.logId = 0L;
                this.bitField0 &= -5;
                this.needCommon = 0;
                this.bitField0 &= -9;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wP */
            public a clone() {
                return wN().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public RpcRequestMeta getDefaultInstanceForType() {
                return RpcRequestMeta.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wQ */
            public RpcRequestMeta build() {
                RpcRequestMeta buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wR */
            public RpcRequestMeta buildPartial() {
                RpcRequestMeta rpcRequestMeta = new RpcRequestMeta(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rpcRequestMeta.serviceId = this.serviceId;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcRequestMeta.methodId = this.methodId;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcRequestMeta.logId = this.logId;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                rpcRequestMeta.needCommon = this.needCommon;
                rpcRequestMeta.bitField0 = i2;
                return rpcRequestMeta;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c */
            public a mergeFrom(RpcRequestMeta rpcRequestMeta) {
                if (rpcRequestMeta != RpcRequestMeta.getDefaultInstance()) {
                    if (rpcRequestMeta.hasServiceId()) {
                        am(rpcRequestMeta.getServiceId());
                    }
                    if (rpcRequestMeta.hasMethodId()) {
                        an(rpcRequestMeta.getMethodId());
                    }
                    if (rpcRequestMeta.hasLogId()) {
                        ao(rpcRequestMeta.getLogId());
                    }
                    if (rpcRequestMeta.hasNeedCommon()) {
                        bZ(rpcRequestMeta.getNeedCommon());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                RpcRequestMeta rpcRequestMeta = null;
                try {
                    try {
                        RpcRequestMeta parsePartialFrom = RpcRequestMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (rpcRequestMeta != null) {
                            mergeFrom(rpcRequestMeta);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    RpcRequestMeta rpcRequestMeta2 = (RpcRequestMeta) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        rpcRequestMeta = rpcRequestMeta2;
                        if (rpcRequestMeta != null) {
                        }
                        throw th;
                    }
                }
            }

            public a am(long j) {
                this.bitField0 |= 1;
                this.serviceId = j;
                return this;
            }

            public a an(long j) {
                this.bitField0 |= 2;
                this.methodId = j;
                return this;
            }

            public a ao(long j) {
                this.bitField0 |= 4;
                this.logId = j;
                return this;
            }

            public a bZ(int i) {
                this.bitField0 |= 8;
                this.needCommon = i;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class RpcResponseMeta extends GeneratedMessageLite implements m {
        public static final int ERROR_CODE_FIELD_NUMBER = 4;
        public static final int ERROR_TEXT_FIELD_NUMBER = 5;
        public static final int LOG_ID_FIELD_NUMBER = 3;
        public static final int METHOD_ID_FIELD_NUMBER = 2;
        public static final int SERVICE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private int errorCode;
        private Object errorText;
        private long logId;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long methodId;
        private long serviceId;
        public static final Parser<RpcResponseMeta> PARSER = new AbstractParser<RpcResponseMeta>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb.RpcResponseMeta.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: t */
            public RpcResponseMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RpcResponseMeta(codedInputStream, extensionRegistryLite);
            }
        };
        private static final RpcResponseMeta defaultInstance = new RpcResponseMeta(true);

        private RpcResponseMeta(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private RpcResponseMeta(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static RpcResponseMeta getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public RpcResponseMeta getDefaultInstanceForType() {
            return defaultInstance;
        }

        private RpcResponseMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0 |= 1;
                                    this.serviceId = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0 |= 2;
                                    this.methodId = codedInputStream.readInt64();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.logId = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.errorCode = codedInputStream.readInt32();
                                    break;
                                case 42:
                                    this.bitField0 |= 16;
                                    this.errorText = codedInputStream.readBytes();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<RpcResponseMeta> getParserForType() {
            return PARSER;
        }

        public boolean hasServiceId() {
            return (this.bitField0 & 1) == 1;
        }

        public long getServiceId() {
            return this.serviceId;
        }

        public boolean hasMethodId() {
            return (this.bitField0 & 2) == 2;
        }

        public long getMethodId() {
            return this.methodId;
        }

        public boolean hasLogId() {
            return (this.bitField0 & 4) == 4;
        }

        public long getLogId() {
            return this.logId;
        }

        public boolean hasErrorCode() {
            return (this.bitField0 & 8) == 8;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public boolean hasErrorText() {
            return (this.bitField0 & 16) == 16;
        }

        public String getErrorText() {
            Object obj = this.errorText;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.errorText = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getErrorTextBytes() {
            Object obj = this.errorText;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errorText = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.serviceId = 0L;
            this.methodId = 0L;
            this.logId = 0L;
            this.errorCode = 0;
            this.errorText = "";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.serviceId);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.methodId);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.logId);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt32(4, this.errorCode);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeBytes(5, getErrorTextBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.methodId);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.logId);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.errorCode);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getErrorTextBytes());
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RpcResponseMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static RpcResponseMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RpcResponseMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static RpcResponseMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RpcResponseMeta parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static RpcResponseMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static RpcResponseMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static RpcResponseMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static RpcResponseMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static RpcResponseMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.wT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(RpcResponseMeta rpcResponseMeta) {
            return newBuilder().mergeFrom(rpcResponseMeta);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<RpcResponseMeta, a> implements m {
            private int bitField0;
            private int errorCode;
            private Object errorText = "";
            private long logId;
            private long methodId;
            private long serviceId;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a wT() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wU */
            public a clear() {
                super.clear();
                this.serviceId = 0L;
                this.bitField0 &= -2;
                this.methodId = 0L;
                this.bitField0 &= -3;
                this.logId = 0L;
                this.bitField0 &= -5;
                this.errorCode = 0;
                this.bitField0 &= -9;
                this.errorText = "";
                this.bitField0 &= -17;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wV */
            public a clone() {
                return wT().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public RpcResponseMeta getDefaultInstanceForType() {
                return RpcResponseMeta.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wW */
            public RpcResponseMeta build() {
                RpcResponseMeta buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wX */
            public RpcResponseMeta buildPartial() {
                RpcResponseMeta rpcResponseMeta = new RpcResponseMeta(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rpcResponseMeta.serviceId = this.serviceId;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcResponseMeta.methodId = this.methodId;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcResponseMeta.logId = this.logId;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                rpcResponseMeta.errorCode = this.errorCode;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                rpcResponseMeta.errorText = this.errorText;
                rpcResponseMeta.bitField0 = i2;
                return rpcResponseMeta;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: b */
            public a mergeFrom(RpcResponseMeta rpcResponseMeta) {
                if (rpcResponseMeta != RpcResponseMeta.getDefaultInstance()) {
                    if (rpcResponseMeta.hasServiceId()) {
                        ap(rpcResponseMeta.getServiceId());
                    }
                    if (rpcResponseMeta.hasMethodId()) {
                        aq(rpcResponseMeta.getMethodId());
                    }
                    if (rpcResponseMeta.hasLogId()) {
                        ar(rpcResponseMeta.getLogId());
                    }
                    if (rpcResponseMeta.hasErrorCode()) {
                        ca(rpcResponseMeta.getErrorCode());
                    }
                    if (rpcResponseMeta.hasErrorText()) {
                        this.bitField0 |= 16;
                        this.errorText = rpcResponseMeta.errorText;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: u */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                RpcResponseMeta rpcResponseMeta = null;
                try {
                    try {
                        RpcResponseMeta parsePartialFrom = RpcResponseMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (rpcResponseMeta != null) {
                            mergeFrom(rpcResponseMeta);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    RpcResponseMeta rpcResponseMeta2 = (RpcResponseMeta) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        rpcResponseMeta = rpcResponseMeta2;
                        if (rpcResponseMeta != null) {
                        }
                        throw th;
                    }
                }
            }

            public a ap(long j) {
                this.bitField0 |= 1;
                this.serviceId = j;
                return this;
            }

            public a aq(long j) {
                this.bitField0 |= 2;
                this.methodId = j;
                return this;
            }

            public a ar(long j) {
                this.bitField0 |= 4;
                this.logId = j;
                return this;
            }

            public a ca(int i) {
                this.bitField0 |= 8;
                this.errorCode = i;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class RpcNotifyMeta extends GeneratedMessageLite implements k {
        public static final int LOG_ID_FIELD_NUMBER = 3;
        public static final int METHOD_ID_FIELD_NUMBER = 2;
        public static final int SERVICE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private long logId;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long methodId;
        private long serviceId;
        public static final Parser<RpcNotifyMeta> PARSER = new AbstractParser<RpcNotifyMeta>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb.RpcNotifyMeta.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: p */
            public RpcNotifyMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RpcNotifyMeta(codedInputStream, extensionRegistryLite);
            }
        };
        private static final RpcNotifyMeta defaultInstance = new RpcNotifyMeta(true);

        private RpcNotifyMeta(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private RpcNotifyMeta(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static RpcNotifyMeta getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public RpcNotifyMeta getDefaultInstanceForType() {
            return defaultInstance;
        }

        private RpcNotifyMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0 |= 1;
                                    this.serviceId = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0 |= 2;
                                    this.methodId = codedInputStream.readInt64();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.logId = codedInputStream.readInt64();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<RpcNotifyMeta> getParserForType() {
            return PARSER;
        }

        public boolean hasServiceId() {
            return (this.bitField0 & 1) == 1;
        }

        public long getServiceId() {
            return this.serviceId;
        }

        public boolean hasMethodId() {
            return (this.bitField0 & 2) == 2;
        }

        public long getMethodId() {
            return this.methodId;
        }

        public boolean hasLogId() {
            return (this.bitField0 & 4) == 4;
        }

        public long getLogId() {
            return this.logId;
        }

        private void initFields() {
            this.serviceId = 0L;
            this.methodId = 0L;
            this.logId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.serviceId);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.methodId);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.logId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.methodId);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.logId);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RpcNotifyMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static RpcNotifyMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RpcNotifyMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static RpcNotifyMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RpcNotifyMeta parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static RpcNotifyMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static RpcNotifyMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static RpcNotifyMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static RpcNotifyMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static RpcNotifyMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.wH();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(RpcNotifyMeta rpcNotifyMeta) {
            return newBuilder().mergeFrom(rpcNotifyMeta);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<RpcNotifyMeta, a> implements k {
            private int bitField0;
            private long logId;
            private long methodId;
            private long serviceId;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a wH() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wI */
            public a clear() {
                super.clear();
                this.serviceId = 0L;
                this.bitField0 &= -2;
                this.methodId = 0L;
                this.bitField0 &= -3;
                this.logId = 0L;
                this.bitField0 &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wJ */
            public a clone() {
                return wH().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public RpcNotifyMeta getDefaultInstanceForType() {
                return RpcNotifyMeta.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wK */
            public RpcNotifyMeta build() {
                RpcNotifyMeta buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wL */
            public RpcNotifyMeta buildPartial() {
                RpcNotifyMeta rpcNotifyMeta = new RpcNotifyMeta(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rpcNotifyMeta.serviceId = this.serviceId;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcNotifyMeta.methodId = this.methodId;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcNotifyMeta.logId = this.logId;
                rpcNotifyMeta.bitField0 = i2;
                return rpcNotifyMeta;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: b */
            public a mergeFrom(RpcNotifyMeta rpcNotifyMeta) {
                if (rpcNotifyMeta != RpcNotifyMeta.getDefaultInstance()) {
                    if (rpcNotifyMeta.hasServiceId()) {
                        aj(rpcNotifyMeta.getServiceId());
                    }
                    if (rpcNotifyMeta.hasMethodId()) {
                        ak(rpcNotifyMeta.getMethodId());
                    }
                    if (rpcNotifyMeta.hasLogId()) {
                        al(rpcNotifyMeta.getLogId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: q */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                RpcNotifyMeta rpcNotifyMeta = null;
                try {
                    try {
                        RpcNotifyMeta parsePartialFrom = RpcNotifyMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (rpcNotifyMeta != null) {
                            mergeFrom(rpcNotifyMeta);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    RpcNotifyMeta rpcNotifyMeta2 = (RpcNotifyMeta) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        rpcNotifyMeta = rpcNotifyMeta2;
                        if (rpcNotifyMeta != null) {
                        }
                        throw th;
                    }
                }
            }

            public a aj(long j) {
                this.bitField0 |= 1;
                this.serviceId = j;
                return this;
            }

            public a ak(long j) {
                this.bitField0 |= 2;
                this.methodId = j;
                return this;
            }

            public a al(long j) {
                this.bitField0 |= 4;
                this.logId = j;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ChunkInfo extends GeneratedMessageLite implements i {
        public static final int CHUNK_ID_FIELD_NUMBER = 2;
        public static final int STREAM_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private long chunkId;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long streamId;
        public static final Parser<ChunkInfo> PARSER = new AbstractParser<ChunkInfo>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb.ChunkInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: l */
            public ChunkInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ChunkInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ChunkInfo defaultInstance = new ChunkInfo(true);

        private ChunkInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ChunkInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ChunkInfo getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public ChunkInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ChunkInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0 |= 1;
                                    this.streamId = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0 |= 2;
                                    this.chunkId = codedInputStream.readInt64();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ChunkInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasStreamId() {
            return (this.bitField0 & 1) == 1;
        }

        public long getStreamId() {
            return this.streamId;
        }

        public boolean hasChunkId() {
            return (this.bitField0 & 2) == 2;
        }

        public long getChunkId() {
            return this.chunkId;
        }

        private void initFields() {
            this.streamId = 0L;
            this.chunkId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasStreamId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasChunkId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.streamId);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.chunkId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.streamId) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.chunkId);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ChunkInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ChunkInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ChunkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ChunkInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ChunkInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ChunkInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ChunkInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ChunkInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ChunkInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ChunkInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.wv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(ChunkInfo chunkInfo) {
            return newBuilder().mergeFrom(chunkInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<ChunkInfo, a> implements i {
            private int bitField0;
            private long chunkId;
            private long streamId;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a wv() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: ww */
            public a clear() {
                super.clear();
                this.streamId = 0L;
                this.bitField0 &= -2;
                this.chunkId = 0L;
                this.bitField0 &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: wx */
            public a clone() {
                return wv().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public ChunkInfo getDefaultInstanceForType() {
                return ChunkInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wy */
            public ChunkInfo build() {
                ChunkInfo buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: wz */
            public ChunkInfo buildPartial() {
                ChunkInfo chunkInfo = new ChunkInfo(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                chunkInfo.streamId = this.streamId;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                chunkInfo.chunkId = this.chunkId;
                chunkInfo.bitField0 = i2;
                return chunkInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(ChunkInfo chunkInfo) {
                if (chunkInfo != ChunkInfo.getDefaultInstance()) {
                    if (chunkInfo.hasStreamId()) {
                        ag(chunkInfo.getStreamId());
                    }
                    if (chunkInfo.hasChunkId()) {
                        ah(chunkInfo.getChunkId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasStreamId() && hasChunkId();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: m */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ChunkInfo chunkInfo = null;
                try {
                    try {
                        ChunkInfo parsePartialFrom = ChunkInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (chunkInfo != null) {
                            mergeFrom(chunkInfo);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    ChunkInfo chunkInfo2 = (ChunkInfo) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        chunkInfo = chunkInfo2;
                        if (chunkInfo != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasStreamId() {
                return (this.bitField0 & 1) == 1;
            }

            public a ag(long j) {
                this.bitField0 |= 1;
                this.streamId = j;
                return this;
            }

            public boolean hasChunkId() {
                return (this.bitField0 & 2) == 2;
            }

            public a ah(long j) {
                this.bitField0 |= 2;
                this.chunkId = j;
                return this;
            }
        }
    }
}
