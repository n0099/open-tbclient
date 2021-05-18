package com.baidu.swan.facade.requred.openstat.imupload.log.model;

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
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bimlog$LogResponse> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bimlog$LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bimlog$LogResponse(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bimlog$LogResponse, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f11616e;

        /* renamed from: f  reason: collision with root package name */
        public int f11617f;

        /* renamed from: g  reason: collision with root package name */
        public Object f11618g = "";

        /* renamed from: h  reason: collision with root package name */
        public long f11619h;

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
        public Bimlog$LogResponse build() {
            Bimlog$LogResponse buildPartial = buildPartial();
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
        public Bimlog$LogResponse buildPartial() {
            Bimlog$LogResponse bimlog$LogResponse = new Bimlog$LogResponse(this);
            int i2 = this.f11616e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            bimlog$LogResponse.errorCode_ = this.f11617f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            bimlog$LogResponse.errorMsg_ = this.f11618g;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            bimlog$LogResponse.pingIntervalMs_ = this.f11619h;
            bimlog$LogResponse.bitField0_ = i3;
            return bimlog$LogResponse;
        }

        public b o() {
            super.clear();
            this.f11617f = 0;
            int i2 = this.f11616e & (-2);
            this.f11616e = i2;
            this.f11618g = "";
            int i3 = i2 & (-3);
            this.f11616e = i3;
            this.f11619h = 0L;
            this.f11616e = i3 & (-5);
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
        public Bimlog$LogResponse getDefaultInstanceForType() {
            return Bimlog$LogResponse.getDefaultInstance();
        }

        public b s(Bimlog$LogResponse bimlog$LogResponse) {
            if (bimlog$LogResponse == Bimlog$LogResponse.getDefaultInstance()) {
                return this;
            }
            if (bimlog$LogResponse.hasErrorCode()) {
                u(bimlog$LogResponse.getErrorCode());
            }
            if (bimlog$LogResponse.hasErrorMsg()) {
                this.f11616e |= 2;
                this.f11618g = bimlog$LogResponse.errorMsg_;
            }
            if (bimlog$LogResponse.hasPingIntervalMs()) {
                v(bimlog$LogResponse.getPingIntervalMs());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bimlog$LogResponse bimlog$LogResponse = null;
            try {
                try {
                    Bimlog$LogResponse parsePartialFrom = Bimlog$LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bimlog$LogResponse bimlog$LogResponse2 = (Bimlog$LogResponse) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bimlog$LogResponse = bimlog$LogResponse2;
                        if (bimlog$LogResponse != null) {
                            s(bimlog$LogResponse);
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

        public b u(int i2) {
            this.f11616e |= 1;
            this.f11617f = i2;
            return this;
        }

        public b v(long j) {
            this.f11616e |= 4;
            this.f11619h = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(Bimlog$LogResponse bimlog$LogResponse) {
            s(bimlog$LogResponse);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
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
        return b.q();
    }

    public static Bimlog$LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bimlog$LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
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

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bimlog$LogResponse> getParserForType() {
        return PARSER;
    }

    public long getPingIntervalMs() {
        return this.pingIntervalMs_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.errorCode_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs_);
        }
        this.memoizedSerializedSize = computeInt32Size;
        return computeInt32Size;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasErrorMsg() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasPingIntervalMs() {
        return (this.bitField0_ & 4) == 4;
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
            codedOutputStream.writeInt32(1, this.errorCode_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt64(3, this.pingIntervalMs_);
        }
    }

    public static b newBuilder(Bimlog$LogResponse bimlog$LogResponse) {
        b newBuilder = newBuilder();
        newBuilder.s(bimlog$LogResponse);
        return newBuilder;
    }

    public static Bimlog$LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bimlog$LogResponse getDefaultInstanceForType() {
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

    public Bimlog$LogResponse(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bimlog$LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bimlog$LogResponse parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bimlog$LogResponse(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bimlog$LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
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
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.errorCode_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.errorMsg_ = codedInputStream.readBytes();
                            } else if (readTag != 24) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 4;
                                this.pingIntervalMs_ = codedInputStream.readInt64();
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
