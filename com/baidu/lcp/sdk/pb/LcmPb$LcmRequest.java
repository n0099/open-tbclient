package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.LcmPb$Common;
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
public final class LcmPb$LcmRequest extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 5;
    public static final int COMMON_FIELD_NUMBER = 3;
    public static final int CONN_TYPE_FIELD_NUMBER = 7;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static Parser<LcmPb$LcmRequest> PARSER = new a();
    public static final int START_TYPE_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int TOKEN_FIELD_NUMBER = 2;
    public static final LcmPb$LcmRequest defaultInstance;
    public static final long serialVersionUID = 0;
    public int action_;
    public int bitField0_;
    public LcmPb$Common common_;
    public int connType_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int startType_;
    public long timestamp_;
    public Object token_;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<LcmPb$LcmRequest> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public LcmPb$LcmRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$LcmRequest(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$LcmRequest, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6425e;

        /* renamed from: f  reason: collision with root package name */
        public long f6426f;

        /* renamed from: g  reason: collision with root package name */
        public Object f6427g = "";

        /* renamed from: h  reason: collision with root package name */
        public LcmPb$Common f6428h = LcmPb$Common.getDefaultInstance();
        public long i;
        public int j;
        public int k;
        public int l;

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        public b A(int i) {
            this.f6425e |= 32;
            this.k = i;
            return this;
        }

        public b B(long j) {
            this.f6425e |= 8;
            this.i = j;
            return this;
        }

        public b C(String str) {
            if (str != null) {
                this.f6425e |= 2;
                this.f6427g = str;
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
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$LcmRequest build() {
            LcmPb$LcmRequest buildPartial = buildPartial();
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
        public LcmPb$LcmRequest buildPartial() {
            LcmPb$LcmRequest lcmPb$LcmRequest = new LcmPb$LcmRequest(this);
            int i = this.f6425e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            lcmPb$LcmRequest.logId_ = this.f6426f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            lcmPb$LcmRequest.token_ = this.f6427g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            lcmPb$LcmRequest.common_ = this.f6428h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            lcmPb$LcmRequest.timestamp_ = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            lcmPb$LcmRequest.action_ = this.j;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            lcmPb$LcmRequest.startType_ = this.k;
            if ((i & 64) == 64) {
                i2 |= 64;
            }
            lcmPb$LcmRequest.connType_ = this.l;
            lcmPb$LcmRequest.bitField0_ = i2;
            return lcmPb$LcmRequest;
        }

        public b o() {
            super.clear();
            this.f6426f = 0L;
            int i = this.f6425e & (-2);
            this.f6425e = i;
            this.f6427g = "";
            this.f6425e = i & (-3);
            this.f6428h = LcmPb$Common.getDefaultInstance();
            int i2 = this.f6425e & (-5);
            this.f6425e = i2;
            this.i = 0L;
            int i3 = i2 & (-9);
            this.f6425e = i3;
            this.j = 0;
            int i4 = i3 & (-17);
            this.f6425e = i4;
            this.k = 0;
            int i5 = i4 & (-33);
            this.f6425e = i5;
            this.l = 0;
            this.f6425e = i5 & (-65);
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
        public LcmPb$LcmRequest getDefaultInstanceForType() {
            return LcmPb$LcmRequest.getDefaultInstance();
        }

        public boolean s() {
            return (this.f6425e & 1) == 1;
        }

        public b t(LcmPb$Common lcmPb$Common) {
            if ((this.f6425e & 4) == 4 && this.f6428h != LcmPb$Common.getDefaultInstance()) {
                LcmPb$Common.b newBuilder = LcmPb$Common.newBuilder(this.f6428h);
                newBuilder.s(lcmPb$Common);
                this.f6428h = newBuilder.buildPartial();
            } else {
                this.f6428h = lcmPb$Common;
            }
            this.f6425e |= 4;
            return this;
        }

        public b u(LcmPb$LcmRequest lcmPb$LcmRequest) {
            if (lcmPb$LcmRequest == LcmPb$LcmRequest.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$LcmRequest.hasLogId()) {
                z(lcmPb$LcmRequest.getLogId());
            }
            if (lcmPb$LcmRequest.hasToken()) {
                this.f6425e |= 2;
                this.f6427g = lcmPb$LcmRequest.token_;
            }
            if (lcmPb$LcmRequest.hasCommon()) {
                t(lcmPb$LcmRequest.getCommon());
            }
            if (lcmPb$LcmRequest.hasTimestamp()) {
                B(lcmPb$LcmRequest.getTimestamp());
            }
            if (lcmPb$LcmRequest.hasAction()) {
                w(lcmPb$LcmRequest.getAction());
            }
            if (lcmPb$LcmRequest.hasStartType()) {
                A(lcmPb$LcmRequest.getStartType());
            }
            if (lcmPb$LcmRequest.hasConnType()) {
                y(lcmPb$LcmRequest.getConnType());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$LcmRequest lcmPb$LcmRequest = null;
            try {
                try {
                    LcmPb$LcmRequest parsePartialFrom = LcmPb$LcmRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        u(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    LcmPb$LcmRequest lcmPb$LcmRequest2 = (LcmPb$LcmRequest) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        lcmPb$LcmRequest = lcmPb$LcmRequest2;
                        if (lcmPb$LcmRequest != null) {
                            u(lcmPb$LcmRequest);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lcmPb$LcmRequest != null) {
                }
                throw th;
            }
        }

        public b w(int i) {
            this.f6425e |= 16;
            this.j = i;
            return this;
        }

        public b x(LcmPb$Common lcmPb$Common) {
            if (lcmPb$Common != null) {
                this.f6428h = lcmPb$Common;
                this.f6425e |= 4;
                return this;
            }
            throw null;
        }

        public b y(int i) {
            this.f6425e |= 64;
            this.l = i;
            return this;
        }

        public b z(long j) {
            this.f6425e |= 1;
            this.f6426f = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$LcmRequest lcmPb$LcmRequest) {
            u(lcmPb$LcmRequest);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        LcmPb$LcmRequest lcmPb$LcmRequest = new LcmPb$LcmRequest(true);
        defaultInstance = lcmPb$LcmRequest;
        lcmPb$LcmRequest.initFields();
    }

    public static LcmPb$LcmRequest getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.logId_ = 0L;
        this.token_ = "";
        this.common_ = LcmPb$Common.getDefaultInstance();
        this.timestamp_ = 0L;
        this.action_ = 0;
        this.startType_ = 0;
        this.connType_ = 0;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static LcmPb$LcmRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$LcmRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getAction() {
        return this.action_;
    }

    public LcmPb$Common getCommon() {
        return this.common_;
    }

    public int getConnType() {
        return this.connType_;
    }

    public long getLogId() {
        return this.logId_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$LcmRequest> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeBytesSize(2, getTokenBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeMessageSize(3, this.common_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt64Size(4, this.timestamp_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt64Size += CodedOutputStream.computeInt32Size(5, this.action_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt64Size += CodedOutputStream.computeInt32Size(6, this.startType_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt64Size += CodedOutputStream.computeInt32Size(7, this.connType_);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public int getStartType() {
        return this.startType_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public String getToken() {
        Object obj = this.token_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.token_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getTokenBytes() {
        Object obj = this.token_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.token_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasCommon() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasConnType() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasStartType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasToken() {
        return (this.bitField0_ & 2) == 2;
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
            codedOutputStream.writeBytes(2, getTokenBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.common_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt64(4, this.timestamp_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.action_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.startType_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(7, this.connType_);
        }
    }

    public static b newBuilder(LcmPb$LcmRequest lcmPb$LcmRequest) {
        b newBuilder = newBuilder();
        newBuilder.u(lcmPb$LcmRequest);
        return newBuilder;
    }

    public static LcmPb$LcmRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$LcmRequest getDefaultInstanceForType() {
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

    public LcmPb$LcmRequest(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$LcmRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$LcmRequest(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$LcmRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$LcmRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.logId_ = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.token_ = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                LcmPb$Common.b builder = (this.bitField0_ & 4) == 4 ? this.common_.toBuilder() : null;
                                LcmPb$Common lcmPb$Common = (LcmPb$Common) codedInputStream.readMessage(LcmPb$Common.PARSER, extensionRegistryLite);
                                this.common_ = lcmPb$Common;
                                if (builder != null) {
                                    builder.s(lcmPb$Common);
                                    this.common_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.timestamp_ = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.action_ = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.bitField0_ |= 32;
                                this.startType_ = codedInputStream.readInt32();
                            } else if (readTag != 56) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 64;
                                this.connType_ = codedInputStream.readInt32();
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
