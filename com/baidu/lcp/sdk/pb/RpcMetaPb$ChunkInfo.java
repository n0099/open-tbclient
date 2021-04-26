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
public final class RpcMetaPb$ChunkInfo extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int CHUNK_ID_FIELD_NUMBER = 2;
    public static final Parser<RpcMetaPb$ChunkInfo> PARSER = new a();
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$ChunkInfo defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public long chunkId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long streamId;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<RpcMetaPb$ChunkInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public RpcMetaPb$ChunkInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$ChunkInfo(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$ChunkInfo, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6625e;

        /* renamed from: f  reason: collision with root package name */
        public long f6626f;

        /* renamed from: g  reason: collision with root package name */
        public long f6627g;

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
            return t() && s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$ChunkInfo build() {
            RpcMetaPb$ChunkInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public RpcMetaPb$ChunkInfo buildPartial() {
            RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = new RpcMetaPb$ChunkInfo(this);
            int i2 = this.f6625e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            rpcMetaPb$ChunkInfo.streamId = this.f6626f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            rpcMetaPb$ChunkInfo.chunkId = this.f6627g;
            rpcMetaPb$ChunkInfo.bitField0 = i3;
            return rpcMetaPb$ChunkInfo;
        }

        public b o() {
            super.clear();
            this.f6626f = 0L;
            int i2 = this.f6625e & (-2);
            this.f6625e = i2;
            this.f6627g = 0L;
            this.f6625e = i2 & (-3);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.u(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public RpcMetaPb$ChunkInfo getDefaultInstanceForType() {
            return RpcMetaPb$ChunkInfo.getDefaultInstance();
        }

        public boolean s() {
            return (this.f6625e & 2) == 2;
        }

        public boolean t() {
            return (this.f6625e & 1) == 1;
        }

        public b u(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            if (rpcMetaPb$ChunkInfo == RpcMetaPb$ChunkInfo.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$ChunkInfo.hasStreamId()) {
                x(rpcMetaPb$ChunkInfo.getStreamId());
            }
            if (rpcMetaPb$ChunkInfo.hasChunkId()) {
                w(rpcMetaPb$ChunkInfo.getChunkId());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = null;
            try {
                try {
                    RpcMetaPb$ChunkInfo parsePartialFrom = RpcMetaPb$ChunkInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        u(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo2 = (RpcMetaPb$ChunkInfo) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        rpcMetaPb$ChunkInfo = rpcMetaPb$ChunkInfo2;
                        if (rpcMetaPb$ChunkInfo != null) {
                            u(rpcMetaPb$ChunkInfo);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rpcMetaPb$ChunkInfo != null) {
                }
                throw th;
            }
        }

        public b w(long j) {
            this.f6625e |= 2;
            this.f6627g = j;
            return this;
        }

        public b x(long j) {
            this.f6625e |= 1;
            this.f6626f = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            u(rpcMetaPb$ChunkInfo);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = new RpcMetaPb$ChunkInfo(true);
        defaultInstance = rpcMetaPb$ChunkInfo;
        rpcMetaPb$ChunkInfo.initFields();
    }

    public static RpcMetaPb$ChunkInfo getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.streamId = 0L;
        this.chunkId = 0L;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static RpcMetaPb$ChunkInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public long getChunkId() {
        return this.chunkId;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$ChunkInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeInt64Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.streamId) : 0;
        if ((this.bitField0 & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeInt64Size(2, this.chunkId);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public long getStreamId() {
        return this.streamId;
    }

    public boolean hasChunkId() {
        return (this.bitField0 & 2) == 2;
    }

    public boolean hasStreamId() {
        return (this.bitField0 & 1) == 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
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

    public static b newBuilder(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
        b newBuilder = newBuilder();
        newBuilder.u(rpcMetaPb$ChunkInfo);
        return newBuilder;
    }

    public static RpcMetaPb$ChunkInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$ChunkInfo getDefaultInstanceForType() {
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

    public RpcMetaPb$ChunkInfo(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$ChunkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$ChunkInfo(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$ChunkInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$ChunkInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0 |= 1;
                            this.streamId = codedInputStream.readInt64();
                        } else if (readTag != 16) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0 |= 2;
                            this.chunkId = codedInputStream.readInt64();
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
