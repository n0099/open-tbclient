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
    public static Parser<RpcMetaPb$RpcResponseMeta> PARSER = new a();
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcResponseMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public int errorCode_;
    public Object errorText_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId_;
    public long serviceId_;

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
        public int f6366e;

        /* renamed from: f  reason: collision with root package name */
        public long f6367f;

        /* renamed from: g  reason: collision with root package name */
        public long f6368g;

        /* renamed from: h  reason: collision with root package name */
        public long f6369h;

        /* renamed from: i  reason: collision with root package name */
        public int f6370i;
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
            int i2 = this.f6366e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            rpcMetaPb$RpcResponseMeta.serviceId_ = this.f6367f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            rpcMetaPb$RpcResponseMeta.methodId_ = this.f6368g;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            rpcMetaPb$RpcResponseMeta.logId_ = this.f6369h;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            rpcMetaPb$RpcResponseMeta.errorCode_ = this.f6370i;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            rpcMetaPb$RpcResponseMeta.errorText_ = this.j;
            rpcMetaPb$RpcResponseMeta.bitField0_ = i3;
            return rpcMetaPb$RpcResponseMeta;
        }

        public b o() {
            super.clear();
            this.f6367f = 0L;
            int i2 = this.f6366e & (-2);
            this.f6366e = i2;
            this.f6368g = 0L;
            int i3 = i2 & (-3);
            this.f6366e = i3;
            this.f6369h = 0L;
            int i4 = i3 & (-5);
            this.f6366e = i4;
            this.f6370i = 0;
            int i5 = i4 & (-9);
            this.f6366e = i5;
            this.j = "";
            this.f6366e = i5 & (-17);
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
                this.f6366e |= 16;
                this.j = rpcMetaPb$RpcResponseMeta.errorText_;
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

        public b u(int i2) {
            this.f6366e |= 8;
            this.f6370i = i2;
            return this;
        }

        public b v(long j) {
            this.f6366e |= 4;
            this.f6369h = j;
            return this;
        }

        public b w(long j) {
            this.f6366e |= 2;
            this.f6368g = j;
            return this;
        }

        public b x(long j) {
            this.f6366e |= 1;
            this.f6367f = j;
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
        this.serviceId_ = 0L;
        this.methodId_ = 0L;
        this.logId_ = 0L;
        this.errorCode_ = 0;
        this.errorText_ = "";
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
        return this.errorCode_;
    }

    public String getErrorText() {
        Object obj = this.errorText_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.errorText_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getErrorTextBytes() {
        Object obj = this.errorText_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errorText_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public long getLogId() {
        return this.logId_;
    }

    public long getMethodId() {
        return this.methodId_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcResponseMeta> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeInt64Size(2, this.methodId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeInt64Size(3, this.logId_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt64Size += CodedOutputStream.computeBytesSize(5, getErrorTextBytes());
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public long getServiceId() {
        return this.serviceId_;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasErrorText() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasMethodId() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasServiceId() {
        return (this.bitField0_ & 1) == 1;
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt64(1, this.serviceId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt64(2, this.methodId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt64(3, this.logId_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
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
                                this.bitField0_ |= 1;
                                this.serviceId_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.methodId_ = codedInputStream.readInt64();
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.logId_ = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = codedInputStream.readInt32();
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 16;
                                this.errorText_ = codedInputStream.readBytes();
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
