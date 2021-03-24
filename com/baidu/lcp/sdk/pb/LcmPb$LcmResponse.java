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
public final class LcmPb$LcmResponse extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ERROR_CODE_FIELD_NUMBER = 2;
    public static final int ERROR_MSG_FIELD_NUMBER = 3;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static final int NEXT_INTERVAL_MS_FIELD_NUMBER = 4;
    public static Parser<LcmPb$LcmResponse> PARSER = new a();
    public static final LcmPb$LcmResponse defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public int errorCode_;
    public Object errorMsg_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long nextIntervalMs_;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<LcmPb$LcmResponse> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public LcmPb$LcmResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$LcmResponse(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$LcmResponse, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6393e;

        /* renamed from: f  reason: collision with root package name */
        public long f6394f;

        /* renamed from: g  reason: collision with root package name */
        public int f6395g;

        /* renamed from: h  reason: collision with root package name */
        public Object f6396h = "";
        public long i;

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

        public boolean hasErrorCode() {
            return (this.f6393e & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return t() && hasErrorCode() && s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$LcmResponse build() {
            LcmPb$LcmResponse buildPartial = buildPartial();
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
        public LcmPb$LcmResponse buildPartial() {
            LcmPb$LcmResponse lcmPb$LcmResponse = new LcmPb$LcmResponse(this);
            int i = this.f6393e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            lcmPb$LcmResponse.logId_ = this.f6394f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            lcmPb$LcmResponse.errorCode_ = this.f6395g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            lcmPb$LcmResponse.errorMsg_ = this.f6396h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            lcmPb$LcmResponse.nextIntervalMs_ = this.i;
            lcmPb$LcmResponse.bitField0_ = i2;
            return lcmPb$LcmResponse;
        }

        public b o() {
            super.clear();
            this.f6394f = 0L;
            int i = this.f6393e & (-2);
            this.f6393e = i;
            this.f6395g = 0;
            int i2 = i & (-3);
            this.f6393e = i2;
            this.f6396h = "";
            int i3 = i2 & (-5);
            this.f6393e = i3;
            this.i = 0L;
            this.f6393e = i3 & (-9);
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
        public LcmPb$LcmResponse getDefaultInstanceForType() {
            return LcmPb$LcmResponse.getDefaultInstance();
        }

        public boolean s() {
            return (this.f6393e & 4) == 4;
        }

        public boolean t() {
            return (this.f6393e & 1) == 1;
        }

        public b u(LcmPb$LcmResponse lcmPb$LcmResponse) {
            if (lcmPb$LcmResponse == LcmPb$LcmResponse.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$LcmResponse.hasLogId()) {
                x(lcmPb$LcmResponse.getLogId());
            }
            if (lcmPb$LcmResponse.hasErrorCode()) {
                w(lcmPb$LcmResponse.getErrorCode());
            }
            if (lcmPb$LcmResponse.hasErrorMsg()) {
                this.f6393e |= 4;
                this.f6396h = lcmPb$LcmResponse.errorMsg_;
            }
            if (lcmPb$LcmResponse.hasNextIntervalMs()) {
                y(lcmPb$LcmResponse.getNextIntervalMs());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$LcmResponse lcmPb$LcmResponse = null;
            try {
                try {
                    LcmPb$LcmResponse parsePartialFrom = LcmPb$LcmResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        u(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    LcmPb$LcmResponse lcmPb$LcmResponse2 = (LcmPb$LcmResponse) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        lcmPb$LcmResponse = lcmPb$LcmResponse2;
                        if (lcmPb$LcmResponse != null) {
                            u(lcmPb$LcmResponse);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lcmPb$LcmResponse != null) {
                }
                throw th;
            }
        }

        public b w(int i) {
            this.f6393e |= 2;
            this.f6395g = i;
            return this;
        }

        public b x(long j) {
            this.f6393e |= 1;
            this.f6394f = j;
            return this;
        }

        public b y(long j) {
            this.f6393e |= 8;
            this.i = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$LcmResponse lcmPb$LcmResponse) {
            u(lcmPb$LcmResponse);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        LcmPb$LcmResponse lcmPb$LcmResponse = new LcmPb$LcmResponse(true);
        defaultInstance = lcmPb$LcmResponse;
        lcmPb$LcmResponse.initFields();
    }

    public static LcmPb$LcmResponse getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.logId_ = 0L;
        this.errorCode_ = 0;
        this.errorMsg_ = "";
        this.nextIntervalMs_ = 0L;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static LcmPb$LcmResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$LcmResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public String getErrorMsg() {
        Object obj = this.errorMsg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.errorMsg_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getErrorMsgBytes() {
        Object obj = this.errorMsg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errorMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public long getLogId() {
        return this.logId_;
    }

    public long getNextIntervalMs() {
        return this.nextIntervalMs_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$LcmResponse> getParserForType() {
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
            computeInt64Size += CodedOutputStream.computeInt32Size(2, this.errorCode_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeBytesSize(3, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt64Size(4, this.nextIntervalMs_);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasErrorMsg() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasNextIntervalMs() {
        return (this.bitField0_ & 8) == 8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (!hasLogId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasErrorCode()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasErrorMsg()) {
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
            codedOutputStream.writeInt32(2, this.errorCode_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBytes(3, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt64(4, this.nextIntervalMs_);
        }
    }

    public static b newBuilder(LcmPb$LcmResponse lcmPb$LcmResponse) {
        b newBuilder = newBuilder();
        newBuilder.u(lcmPb$LcmResponse);
        return newBuilder;
    }

    public static LcmPb$LcmResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$LcmResponse getDefaultInstanceForType() {
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

    public LcmPb$LcmResponse(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$LcmResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$LcmResponse parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$LcmResponse(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$LcmResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$LcmResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.errorCode_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.bitField0_ |= 4;
                                this.errorMsg_ = codedInputStream.readBytes();
                            } else if (readTag != 32) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 8;
                                this.nextIntervalMs_ = codedInputStream.readInt64();
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
