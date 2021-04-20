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
public final class RpcMetaPb$RpcResponseMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ERROR_CODE_FIELD_NUMBER = 4;
    public static final int ERROR_TEXT_FIELD_NUMBER = 5;
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static final Parser<RpcMetaPb$RpcResponseMeta> PARSER = new a();
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcResponseMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public int errorCode;
    public Object errorText;
    public long logId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId;
    public long serviceId;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcResponseMeta> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public RpcMetaPb$RpcResponseMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcResponseMeta(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcResponseMeta, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6452e;

        /* renamed from: f  reason: collision with root package name */
        public long f6453f;

        /* renamed from: g  reason: collision with root package name */
        public long f6454g;

        /* renamed from: h  reason: collision with root package name */
        public long f6455h;
        public int i;
        public Object j = "";

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
        public RpcMetaPb$RpcResponseMeta build() {
            RpcMetaPb$RpcResponseMeta buildPartial = buildPartial();
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
        public RpcMetaPb$RpcResponseMeta buildPartial() {
            RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = new RpcMetaPb$RpcResponseMeta(this);
            int i = this.f6452e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            rpcMetaPb$RpcResponseMeta.serviceId = this.f6453f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            rpcMetaPb$RpcResponseMeta.methodId = this.f6454g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            rpcMetaPb$RpcResponseMeta.logId = this.f6455h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            rpcMetaPb$RpcResponseMeta.errorCode = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            rpcMetaPb$RpcResponseMeta.errorText = this.j;
            rpcMetaPb$RpcResponseMeta.bitField0 = i2;
            return rpcMetaPb$RpcResponseMeta;
        }

        public b o() {
            super.clear();
            this.f6453f = 0L;
            int i = this.f6452e & (-2);
            this.f6452e = i;
            this.f6454g = 0L;
            int i2 = i & (-3);
            this.f6452e = i2;
            this.f6455h = 0L;
            int i3 = i2 & (-5);
            this.f6452e = i3;
            this.i = 0;
            int i4 = i3 & (-9);
            this.f6452e = i4;
            this.j = "";
            this.f6452e = i4 & (-17);
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
        public RpcMetaPb$RpcResponseMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcResponseMeta.getDefaultInstance();
        }

        public b s(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            if (rpcMetaPb$RpcResponseMeta == RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcResponseMeta.hasServiceId()) {
                x(rpcMetaPb$RpcResponseMeta.getServiceId());
            }
            if (rpcMetaPb$RpcResponseMeta.hasMethodId()) {
                w(rpcMetaPb$RpcResponseMeta.getMethodId());
            }
            if (rpcMetaPb$RpcResponseMeta.hasLogId()) {
                v(rpcMetaPb$RpcResponseMeta.getLogId());
            }
            if (rpcMetaPb$RpcResponseMeta.hasErrorCode()) {
                u(rpcMetaPb$RpcResponseMeta.getErrorCode());
            }
            if (rpcMetaPb$RpcResponseMeta.hasErrorText()) {
                this.f6452e |= 16;
                this.j = rpcMetaPb$RpcResponseMeta.errorText;
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = null;
            try {
                try {
                    RpcMetaPb$RpcResponseMeta parsePartialFrom = RpcMetaPb$RpcResponseMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta2 = (RpcMetaPb$RpcResponseMeta) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        rpcMetaPb$RpcResponseMeta = rpcMetaPb$RpcResponseMeta2;
                        if (rpcMetaPb$RpcResponseMeta != null) {
                            s(rpcMetaPb$RpcResponseMeta);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rpcMetaPb$RpcResponseMeta != null) {
                }
                throw th;
            }
        }

        public b u(int i) {
            this.f6452e |= 8;
            this.i = i;
            return this;
        }

        public b v(long j) {
            this.f6452e |= 4;
            this.f6455h = j;
            return this;
        }

        public b w(long j) {
            this.f6452e |= 2;
            this.f6454g = j;
            return this;
        }

        public b x(long j) {
            this.f6452e |= 1;
            this.f6453f = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            s(rpcMetaPb$RpcResponseMeta);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = new RpcMetaPb$RpcResponseMeta(true);
        defaultInstance = rpcMetaPb$RpcResponseMeta;
        rpcMetaPb$RpcResponseMeta.initFields();
    }

    public static RpcMetaPb$RpcResponseMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.serviceId = 0L;
        this.methodId = 0L;
        this.logId = 0L;
        this.errorCode = 0;
        this.errorText = "";
    }

    public static b newBuilder() {
        return b.q();
    }

    public static RpcMetaPb$RpcResponseMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getErrorCode() {
        return this.errorCode;
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

    public long getLogId() {
        return this.logId;
    }

    public long getMethodId() {
        return this.methodId;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcResponseMeta> getParserForType() {
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
        if ((this.bitField0 & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt32Size(4, this.errorCode);
        }
        if ((this.bitField0 & 16) == 16) {
            computeInt64Size += CodedOutputStream.computeBytesSize(5, getErrorTextBytes());
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public long getServiceId() {
        return this.serviceId;
    }

    public boolean hasErrorCode() {
        return (this.bitField0 & 8) == 8;
    }

    public boolean hasErrorText() {
        return (this.bitField0 & 16) == 16;
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
        if ((this.bitField0 & 8) == 8) {
            codedOutputStream.writeInt32(4, this.errorCode);
        }
        if ((this.bitField0 & 16) == 16) {
            codedOutputStream.writeBytes(5, getErrorTextBytes());
        }
    }

    public static b newBuilder(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
        b newBuilder = newBuilder();
        newBuilder.s(rpcMetaPb$RpcResponseMeta);
        return newBuilder;
    }

    public static RpcMetaPb$RpcResponseMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcResponseMeta getDefaultInstanceForType() {
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

    public RpcMetaPb$RpcResponseMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcResponseMeta(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$RpcResponseMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 32) {
                                this.bitField0 |= 8;
                                this.errorCode = codedInputStream.readInt32();
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0 |= 16;
                                this.errorText = codedInputStream.readBytes();
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
