package com.baidu.swan.facade.requred.openstat.imupload.log.model;

import com.baidu.tieba.at3;
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
/* loaded from: classes4.dex */
public final class Bimlog$LogResponse extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ERROR_CODE_FIELD_NUMBER = 1;
    public static final int ERROR_MSG_FIELD_NUMBER = 2;
    public static Parser<Bimlog$LogResponse> PARSER = new a();
    public static final int PING_INTERVAL_MS_FIELD_NUMBER = 3;
    public static final Bimlog$LogResponse defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public int errorCode_;
    public Object errorMsg_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long pingIntervalMs_;

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bimlog$LogResponse, b> implements Object {
        public int a;
        public int b;
        public Object c = "";
        public long d;

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public final void maybeForceBuilderInitialization() {
        }

        public b() {
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ b k() {
            return p();
        }

        public static b p() {
            return new b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            n();
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public Bimlog$LogResponse build() {
            Bimlog$LogResponse buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bimlog$LogResponse buildPartial() {
            Bimlog$LogResponse bimlog$LogResponse = new Bimlog$LogResponse(this, (at3) null);
            int i = this.a;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            bimlog$LogResponse.errorCode_ = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bimlog$LogResponse.errorMsg_ = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bimlog$LogResponse.pingIntervalMs_ = this.d;
            bimlog$LogResponse.bitField0_ = i2;
            return bimlog$LogResponse;
        }

        public b n() {
            super.clear();
            this.b = 0;
            int i = this.a & (-2);
            this.a = i;
            this.c = "";
            int i2 = i & (-3);
            this.a = i2;
            this.d = 0L;
            this.a = i2 & (-5);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo44clone() {
            b p = p();
            p.r(buildPartial());
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public Bimlog$LogResponse getDefaultInstanceForType() {
            return Bimlog$LogResponse.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            s(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b s(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bimlog$LogResponse bimlog$LogResponse = null;
            try {
                try {
                    Bimlog$LogResponse parsePartialFrom = Bimlog$LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        r(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Bimlog$LogResponse bimlog$LogResponse2 = (Bimlog$LogResponse) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bimlog$LogResponse = bimlog$LogResponse2;
                        if (bimlog$LogResponse != null) {
                            r(bimlog$LogResponse);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bimlog$LogResponse != null) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bimlog$LogResponse bimlog$LogResponse) {
            r(bimlog$LogResponse);
            return this;
        }

        public b t(int i) {
            this.a |= 1;
            this.b = i;
            return this;
        }

        public b u(long j) {
            this.a |= 4;
            this.d = j;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            s(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b r(Bimlog$LogResponse bimlog$LogResponse) {
            if (bimlog$LogResponse == Bimlog$LogResponse.getDefaultInstance()) {
                return this;
            }
            if (bimlog$LogResponse.hasErrorCode()) {
                t(bimlog$LogResponse.getErrorCode());
            }
            if (bimlog$LogResponse.hasErrorMsg()) {
                this.a |= 2;
                this.c = bimlog$LogResponse.errorMsg_;
            }
            if (bimlog$LogResponse.hasPingIntervalMs()) {
                u(bimlog$LogResponse.getPingIntervalMs());
            }
            return this;
        }
    }

    static {
        Bimlog$LogResponse bimlog$LogResponse = new Bimlog$LogResponse(true);
        defaultInstance = bimlog$LogResponse;
        bimlog$LogResponse.initFields();
    }

    public static Bimlog$LogResponse getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.errorCode_ = 0;
        this.errorMsg_ = "";
        this.pingIntervalMs_ = 0L;
    }

    public static b newBuilder() {
        return b.k();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bimlog$LogResponse getDefaultInstanceForType() {
        return defaultInstance;
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

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bimlog$LogResponse> getParserForType() {
        return PARSER;
    }

    public long getPingIntervalMs() {
        return this.pingIntervalMs_;
    }

    public boolean hasErrorCode() {
        if ((this.bitField0_ & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean hasErrorMsg() {
        if ((this.bitField0_ & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasPingIntervalMs() {
        if ((this.bitField0_ & 4) == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            if (b2 == 1) {
                return true;
            }
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    /* loaded from: classes4.dex */
    public static class a extends AbstractParser<Bimlog$LogResponse> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bimlog$LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bimlog$LogResponse(codedInputStream, extensionRegistryLite, null);
        }
    }

    public Bimlog$LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 8) {
                                if (readTag != 18) {
                                    if (readTag != 24) {
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.pingIntervalMs_ = codedInputStream.readInt64();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.errorMsg_ = codedInputStream.readBytes();
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.errorCode_ = codedInputStream.readInt32();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ Bimlog$LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, at3 at3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public Bimlog$LogResponse(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static b newBuilder(Bimlog$LogResponse bimlog$LogResponse) {
        b newBuilder = newBuilder();
        newBuilder.r(bimlog$LogResponse);
        return newBuilder;
    }

    public static Bimlog$LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bimlog$LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.errorCode_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt64(3, this.pingIntervalMs_);
        }
    }

    public /* synthetic */ Bimlog$LogResponse(GeneratedMessageLite.Builder builder, at3 at3Var) {
        this(builder);
    }

    public static Bimlog$LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Bimlog$LogResponse(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bimlog$LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public static Bimlog$LogResponse parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public static Bimlog$LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bimlog$LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, this.errorCode_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            i2 += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }
}
