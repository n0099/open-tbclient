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
public final class RpcMetaPb$RpcRequestMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static final int NEED_COMMON_FIELD_NUMBER = 4;
    public static final Parser<RpcMetaPb$RpcRequestMeta> PARSER = new a();
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcRequestMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public long logId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId;
    public int needCommon;
    public long serviceId;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcRequestMeta> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public RpcMetaPb$RpcRequestMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcRequestMeta(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcRequestMeta, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6461e;

        /* renamed from: f  reason: collision with root package name */
        public long f6462f;

        /* renamed from: g  reason: collision with root package name */
        public long f6463g;

        /* renamed from: h  reason: collision with root package name */
        public long f6464h;

        /* renamed from: i  reason: collision with root package name */
        public int f6465i;

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
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$RpcRequestMeta build() {
            RpcMetaPb$RpcRequestMeta buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public RpcMetaPb$RpcRequestMeta buildPartial() {
            RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = new RpcMetaPb$RpcRequestMeta(this);
            int i2 = this.f6461e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            rpcMetaPb$RpcRequestMeta.serviceId = this.f6462f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            rpcMetaPb$RpcRequestMeta.methodId = this.f6463g;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            rpcMetaPb$RpcRequestMeta.logId = this.f6464h;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            rpcMetaPb$RpcRequestMeta.needCommon = this.f6465i;
            rpcMetaPb$RpcRequestMeta.bitField0 = i3;
            return rpcMetaPb$RpcRequestMeta;
        }

        public b o() {
            super.clear();
            this.f6462f = 0L;
            int i2 = this.f6461e & (-2);
            this.f6461e = i2;
            this.f6463g = 0L;
            int i3 = i2 & (-3);
            this.f6461e = i3;
            this.f6464h = 0L;
            int i4 = i3 & (-5);
            this.f6461e = i4;
            this.f6465i = 0;
            this.f6461e = i4 & (-9);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.s(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public RpcMetaPb$RpcRequestMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcRequestMeta.getDefaultInstance();
        }

        public b s(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            if (rpcMetaPb$RpcRequestMeta == RpcMetaPb$RpcRequestMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcRequestMeta.hasServiceId()) {
                x(rpcMetaPb$RpcRequestMeta.getServiceId());
            }
            if (rpcMetaPb$RpcRequestMeta.hasMethodId()) {
                v(rpcMetaPb$RpcRequestMeta.getMethodId());
            }
            if (rpcMetaPb$RpcRequestMeta.hasLogId()) {
                u(rpcMetaPb$RpcRequestMeta.getLogId());
            }
            if (rpcMetaPb$RpcRequestMeta.hasNeedCommon()) {
                w(rpcMetaPb$RpcRequestMeta.getNeedCommon());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = null;
            try {
                try {
                    RpcMetaPb$RpcRequestMeta parsePartialFrom = RpcMetaPb$RpcRequestMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta2 = (RpcMetaPb$RpcRequestMeta) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        rpcMetaPb$RpcRequestMeta = rpcMetaPb$RpcRequestMeta2;
                        if (rpcMetaPb$RpcRequestMeta != null) {
                            s(rpcMetaPb$RpcRequestMeta);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rpcMetaPb$RpcRequestMeta != null) {
                }
                throw th;
            }
        }

        public b u(long j) {
            this.f6461e |= 4;
            this.f6464h = j;
            return this;
        }

        public b v(long j) {
            this.f6461e |= 2;
            this.f6463g = j;
            return this;
        }

        public b w(int i2) {
            this.f6461e |= 8;
            this.f6465i = i2;
            return this;
        }

        public b x(long j) {
            this.f6461e |= 1;
            this.f6462f = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            s(rpcMetaPb$RpcRequestMeta);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = new RpcMetaPb$RpcRequestMeta(true);
        defaultInstance = rpcMetaPb$RpcRequestMeta;
        rpcMetaPb$RpcRequestMeta.initFields();
    }

    public static RpcMetaPb$RpcRequestMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.serviceId = 0L;
        this.methodId = 0L;
        this.logId = 0L;
        this.needCommon = 0;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static RpcMetaPb$RpcRequestMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public long getLogId() {
        return this.logId;
    }

    public long getMethodId() {
        return this.methodId;
    }

    public int getNeedCommon() {
        return this.needCommon;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcRequestMeta> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeInt64Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId) : 0;
        if ((this.bitField0 & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeInt64Size(2, this.methodId);
        }
        if ((this.bitField0 & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeInt64Size(3, this.logId);
        }
        if ((this.bitField0 & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt32Size(4, this.needCommon);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public long getServiceId() {
        return this.serviceId;
    }

    public boolean hasLogId() {
        return (this.bitField0 & 4) == 4;
    }

    public boolean hasMethodId() {
        return (this.bitField0 & 2) == 2;
    }

    public boolean hasNeedCommon() {
        return (this.bitField0 & 8) == 8;
    }

    public boolean hasServiceId() {
        return (this.bitField0 & 1) == 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
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

    public static b newBuilder(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
        b newBuilder = newBuilder();
        newBuilder.s(rpcMetaPb$RpcRequestMeta);
        return newBuilder;
    }

    public static RpcMetaPb$RpcRequestMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcRequestMeta getDefaultInstanceForType() {
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

    public RpcMetaPb$RpcRequestMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcRequestMeta(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$RpcRequestMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.bitField0 |= 1;
                                this.serviceId = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.bitField0 |= 2;
                                this.methodId = codedInputStream.readInt64();
                            } else if (readTag == 24) {
                                this.bitField0 |= 4;
                                this.logId = codedInputStream.readInt64();
                            } else if (readTag != 32) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0 |= 8;
                                this.needCommon = codedInputStream.readInt32();
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
