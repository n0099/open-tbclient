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
public final class RpcMetaPb$RpcNotifyMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static final Parser<RpcMetaPb$RpcNotifyMeta> PARSER = new a();
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcNotifyMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public long logId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId;
    public long serviceId;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcNotifyMeta> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public RpcMetaPb$RpcNotifyMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcNotifyMeta(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcNotifyMeta, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6444e;

        /* renamed from: f  reason: collision with root package name */
        public long f6445f;

        /* renamed from: g  reason: collision with root package name */
        public long f6446g;

        /* renamed from: h  reason: collision with root package name */
        public long f6447h;

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
        public RpcMetaPb$RpcNotifyMeta build() {
            RpcMetaPb$RpcNotifyMeta buildPartial = buildPartial();
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
        public RpcMetaPb$RpcNotifyMeta buildPartial() {
            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = new RpcMetaPb$RpcNotifyMeta(this);
            int i = this.f6444e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            rpcMetaPb$RpcNotifyMeta.serviceId = this.f6445f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            rpcMetaPb$RpcNotifyMeta.methodId = this.f6446g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            rpcMetaPb$RpcNotifyMeta.logId = this.f6447h;
            rpcMetaPb$RpcNotifyMeta.bitField0 = i2;
            return rpcMetaPb$RpcNotifyMeta;
        }

        public b o() {
            super.clear();
            this.f6445f = 0L;
            int i = this.f6444e & (-2);
            this.f6444e = i;
            this.f6446g = 0L;
            int i2 = i & (-3);
            this.f6444e = i2;
            this.f6447h = 0L;
            this.f6444e = i2 & (-5);
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
        public RpcMetaPb$RpcNotifyMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
        }

        public b s(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            if (rpcMetaPb$RpcNotifyMeta == RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcNotifyMeta.hasServiceId()) {
                w(rpcMetaPb$RpcNotifyMeta.getServiceId());
            }
            if (rpcMetaPb$RpcNotifyMeta.hasMethodId()) {
                v(rpcMetaPb$RpcNotifyMeta.getMethodId());
            }
            if (rpcMetaPb$RpcNotifyMeta.hasLogId()) {
                u(rpcMetaPb$RpcNotifyMeta.getLogId());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = null;
            try {
                try {
                    RpcMetaPb$RpcNotifyMeta parsePartialFrom = RpcMetaPb$RpcNotifyMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta2 = (RpcMetaPb$RpcNotifyMeta) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        rpcMetaPb$RpcNotifyMeta = rpcMetaPb$RpcNotifyMeta2;
                        if (rpcMetaPb$RpcNotifyMeta != null) {
                            s(rpcMetaPb$RpcNotifyMeta);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rpcMetaPb$RpcNotifyMeta != null) {
                }
                throw th;
            }
        }

        public b u(long j) {
            this.f6444e |= 4;
            this.f6447h = j;
            return this;
        }

        public b v(long j) {
            this.f6444e |= 2;
            this.f6446g = j;
            return this;
        }

        public b w(long j) {
            this.f6444e |= 1;
            this.f6445f = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            s(rpcMetaPb$RpcNotifyMeta);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = new RpcMetaPb$RpcNotifyMeta(true);
        defaultInstance = rpcMetaPb$RpcNotifyMeta;
        rpcMetaPb$RpcNotifyMeta.initFields();
    }

    public static RpcMetaPb$RpcNotifyMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.serviceId = 0L;
        this.methodId = 0L;
        this.logId = 0L;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static RpcMetaPb$RpcNotifyMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public long getLogId() {
        return this.logId;
    }

    public long getMethodId() {
        return this.methodId;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcNotifyMeta> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeInt64Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId) : 0;
        if ((this.bitField0 & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeInt64Size(2, this.methodId);
        }
        if ((this.bitField0 & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeInt64Size(3, this.logId);
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
    }

    public static b newBuilder(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
        b newBuilder = newBuilder();
        newBuilder.s(rpcMetaPb$RpcNotifyMeta);
        return newBuilder;
    }

    public static RpcMetaPb$RpcNotifyMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcNotifyMeta getDefaultInstanceForType() {
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

    public RpcMetaPb$RpcNotifyMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcNotifyMeta(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$RpcNotifyMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag != 24) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0 |= 4;
                                this.logId = codedInputStream.readInt64();
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
