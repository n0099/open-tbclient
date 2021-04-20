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
public final class Bimlog$LogRequest extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int AUTH_INFO_FIELD_NUMBER = 3;
    public static Parser<Bimlog$LogRequest> PARSER = new a();
    public static final int PAYLOAD_FIELD_NUMBER = 6;
    public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
    public static final int SERVICE_NAME_FIELD_NUMBER = 2;
    public static final int SIGN_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final Bimlog$LogRequest defaultInstance;
    public static final long serialVersionUID = 0;
    public AuthInfo authInfo_;
    public int bitField0_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public ByteString payload_;
    public long requestTimestampMs_;
    public Object serviceName_;
    public Object sign_;
    public long version_;

    /* loaded from: classes3.dex */
    public static final class AuthInfo extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<AuthInfo> PARSER = new a();
        public static final int TOKEN_FIELD_NUMBER = 1;
        public static final AuthInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object token_;

        /* loaded from: classes3.dex */
        public static class a extends AbstractParser<AuthInfo> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: b */
            public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AuthInfo(codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.Builder<AuthInfo, b> implements Object {

            /* renamed from: e  reason: collision with root package name */
            public int f12401e;

            /* renamed from: f  reason: collision with root package name */
            public Object f12402f = "";

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
            public AuthInfo build() {
                AuthInfo buildPartial = buildPartial();
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
            public AuthInfo buildPartial() {
                AuthInfo authInfo = new AuthInfo(this);
                int i = (this.f12401e & 1) != 1 ? 0 : 1;
                authInfo.token_ = this.f12402f;
                authInfo.bitField0_ = i;
                return authInfo;
            }

            public b o() {
                super.clear();
                this.f12402f = "";
                this.f12401e &= -2;
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
            public AuthInfo getDefaultInstanceForType() {
                return AuthInfo.getDefaultInstance();
            }

            public b s(AuthInfo authInfo) {
                if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                    this.f12401e |= 1;
                    this.f12402f = authInfo.token_;
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AuthInfo authInfo = null;
                try {
                    try {
                        AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            s(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        AuthInfo authInfo2 = (AuthInfo) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            authInfo = authInfo2;
                            if (authInfo != null) {
                                s(authInfo);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (authInfo != null) {
                    }
                    throw th;
                }
            }

            public b u(String str) {
                if (str != null) {
                    this.f12401e |= 1;
                    this.f12402f = str;
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                o();
                return this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
            /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ b mergeFrom(AuthInfo authInfo) {
                s(authInfo);
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t(codedInputStream, extensionRegistryLite);
                return this;
            }
        }

        static {
            AuthInfo authInfo = new AuthInfo(true);
            defaultInstance = authInfo;
            authInfo.initFields();
        }

        public static AuthInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.token_ = "";
        }

        public static b newBuilder() {
            return b.q();
        }

        public static AuthInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AuthInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<AuthInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
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

        public boolean hasToken() {
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
                codedOutputStream.writeBytes(1, getTokenBytes());
            }
        }

        public static b newBuilder(AuthInfo authInfo) {
            b newBuilder = newBuilder();
            newBuilder.s(authInfo);
            return newBuilder;
        }

        public static AuthInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AuthInfo getDefaultInstanceForType() {
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

        public AuthInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AuthInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AuthInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public AuthInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AuthInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AuthInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.token_ = codedInputStream.readBytes();
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

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bimlog$LogRequest> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bimlog$LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bimlog$LogRequest(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bimlog$LogRequest, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f12403e;

        /* renamed from: f  reason: collision with root package name */
        public long f12404f;
        public long i;

        /* renamed from: g  reason: collision with root package name */
        public Object f12405g = "";

        /* renamed from: h  reason: collision with root package name */
        public AuthInfo f12406h = AuthInfo.getDefaultInstance();
        public Object j = "";
        public ByteString k = ByteString.EMPTY;

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        public b A(long j) {
            this.f12403e |= 1;
            this.f12404f = j;
            return this;
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
        public Bimlog$LogRequest build() {
            Bimlog$LogRequest buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public Bimlog$LogRequest buildPartial() {
            Bimlog$LogRequest bimlog$LogRequest = new Bimlog$LogRequest(this);
            int i = this.f12403e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bimlog$LogRequest.version_ = this.f12404f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bimlog$LogRequest.serviceName_ = this.f12405g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bimlog$LogRequest.authInfo_ = this.f12406h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            bimlog$LogRequest.requestTimestampMs_ = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            bimlog$LogRequest.sign_ = this.j;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            bimlog$LogRequest.payload_ = this.k;
            bimlog$LogRequest.bitField0_ = i2;
            return bimlog$LogRequest;
        }

        public b o() {
            super.clear();
            this.f12404f = 0L;
            int i = this.f12403e & (-2);
            this.f12403e = i;
            this.f12405g = "";
            this.f12403e = i & (-3);
            this.f12406h = AuthInfo.getDefaultInstance();
            int i2 = this.f12403e & (-5);
            this.f12403e = i2;
            this.i = 0L;
            int i3 = i2 & (-9);
            this.f12403e = i3;
            this.j = "";
            int i4 = i3 & (-17);
            this.f12403e = i4;
            this.k = ByteString.EMPTY;
            this.f12403e = i4 & (-33);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.t(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bimlog$LogRequest getDefaultInstanceForType() {
            return Bimlog$LogRequest.getDefaultInstance();
        }

        public b s(AuthInfo authInfo) {
            if ((this.f12403e & 4) == 4 && this.f12406h != AuthInfo.getDefaultInstance()) {
                AuthInfo.b newBuilder = AuthInfo.newBuilder(this.f12406h);
                newBuilder.s(authInfo);
                this.f12406h = newBuilder.buildPartial();
            } else {
                this.f12406h = authInfo;
            }
            this.f12403e |= 4;
            return this;
        }

        public b t(Bimlog$LogRequest bimlog$LogRequest) {
            if (bimlog$LogRequest == Bimlog$LogRequest.getDefaultInstance()) {
                return this;
            }
            if (bimlog$LogRequest.hasVersion()) {
                A(bimlog$LogRequest.getVersion());
            }
            if (bimlog$LogRequest.hasServiceName()) {
                this.f12403e |= 2;
                this.f12405g = bimlog$LogRequest.serviceName_;
            }
            if (bimlog$LogRequest.hasAuthInfo()) {
                s(bimlog$LogRequest.getAuthInfo());
            }
            if (bimlog$LogRequest.hasRequestTimestampMs()) {
                x(bimlog$LogRequest.getRequestTimestampMs());
            }
            if (bimlog$LogRequest.hasSign()) {
                this.f12403e |= 16;
                this.j = bimlog$LogRequest.sign_;
            }
            if (bimlog$LogRequest.hasPayload()) {
                w(bimlog$LogRequest.getPayload());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bimlog$LogRequest bimlog$LogRequest = null;
            try {
                try {
                    Bimlog$LogRequest parsePartialFrom = Bimlog$LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        t(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bimlog$LogRequest bimlog$LogRequest2 = (Bimlog$LogRequest) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bimlog$LogRequest = bimlog$LogRequest2;
                        if (bimlog$LogRequest != null) {
                            t(bimlog$LogRequest);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bimlog$LogRequest != null) {
                }
                throw th;
            }
        }

        public b v(AuthInfo authInfo) {
            if (authInfo != null) {
                this.f12406h = authInfo;
                this.f12403e |= 4;
                return this;
            }
            throw null;
        }

        public b w(ByteString byteString) {
            if (byteString != null) {
                this.f12403e |= 32;
                this.k = byteString;
                return this;
            }
            throw null;
        }

        public b x(long j) {
            this.f12403e |= 8;
            this.i = j;
            return this;
        }

        public b y(String str) {
            if (str != null) {
                this.f12403e |= 2;
                this.f12405g = str;
                return this;
            }
            throw null;
        }

        public b z(String str) {
            if (str != null) {
                this.f12403e |= 16;
                this.j = str;
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bimlog$LogRequest bimlog$LogRequest) {
            t(bimlog$LogRequest);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        Bimlog$LogRequest bimlog$LogRequest = new Bimlog$LogRequest(true);
        defaultInstance = bimlog$LogRequest;
        bimlog$LogRequest.initFields();
    }

    public static Bimlog$LogRequest getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.version_ = 0L;
        this.serviceName_ = "";
        this.authInfo_ = AuthInfo.getDefaultInstance();
        this.requestTimestampMs_ = 0L;
        this.sign_ = "";
        this.payload_ = ByteString.EMPTY;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static Bimlog$LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bimlog$LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public AuthInfo getAuthInfo() {
        return this.authInfo_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bimlog$LogRequest> getParserForType() {
        return PARSER;
    }

    public ByteString getPayload() {
        return this.payload_;
    }

    public long getRequestTimestampMs() {
        return this.requestTimestampMs_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.version_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeMessageSize(3, this.authInfo_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt64Size += CodedOutputStream.computeBytesSize(5, getSignBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt64Size += CodedOutputStream.computeBytesSize(6, this.payload_);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public String getServiceName() {
        Object obj = this.serviceName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.serviceName_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getServiceNameBytes() {
        Object obj = this.serviceName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public String getSign() {
        Object obj = this.sign_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.sign_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getSignBytes() {
        Object obj = this.sign_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sign_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public long getVersion() {
        return this.version_;
    }

    public boolean hasAuthInfo() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasRequestTimestampMs() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasServiceName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasSign() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVersion() {
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
            codedOutputStream.writeInt64(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, getServiceNameBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.authInfo_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt64(4, this.requestTimestampMs_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(5, getSignBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBytes(6, this.payload_);
        }
    }

    public static b newBuilder(Bimlog$LogRequest bimlog$LogRequest) {
        b newBuilder = newBuilder();
        newBuilder.t(bimlog$LogRequest);
        return newBuilder;
    }

    public static Bimlog$LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bimlog$LogRequest getDefaultInstanceForType() {
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

    public Bimlog$LogRequest(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bimlog$LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bimlog$LogRequest parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bimlog$LogRequest(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bimlog$LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public Bimlog$LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 1;
                            this.version_ = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0_ |= 2;
                            this.serviceName_ = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            AuthInfo.b builder = (this.bitField0_ & 4) == 4 ? this.authInfo_.toBuilder() : null;
                            AuthInfo authInfo = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                            this.authInfo_ = authInfo;
                            if (builder != null) {
                                builder.s(authInfo);
                                this.authInfo_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                        } else if (readTag == 32) {
                            this.bitField0_ |= 8;
                            this.requestTimestampMs_ = codedInputStream.readInt64();
                        } else if (readTag == 42) {
                            this.bitField0_ |= 16;
                            this.sign_ = codedInputStream.readBytes();
                        } else if (readTag != 50) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 32;
                            this.payload_ = codedInputStream.readBytes();
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
