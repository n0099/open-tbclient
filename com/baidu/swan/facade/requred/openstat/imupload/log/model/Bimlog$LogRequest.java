package com.baidu.swan.facade.requred.openstat.imupload.log.model;

import com.baidu.tieba.zx3;
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

    /* loaded from: classes4.dex */
    public static final class AuthInfo extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<AuthInfo> PARSER = new a();
        public static final int TOKEN_FIELD_NUMBER = 1;
        public static final AuthInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object token_;

        /* loaded from: classes4.dex */
        public static final class b extends GeneratedMessageLite.Builder<AuthInfo, b> implements Object {
            public int a;
            public Object b = "";

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
            public AuthInfo build() {
                AuthInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: m */
            public AuthInfo buildPartial() {
                AuthInfo authInfo = new AuthInfo(this, (zx3) null);
                int i = 1;
                if ((this.a & 1) != 1) {
                    i = 0;
                }
                authInfo.token_ = this.b;
                authInfo.bitField0_ = i;
                return authInfo;
            }

            public b n() {
                super.clear();
                this.b = "";
                this.a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: o */
            public b mo43clone() {
                b p = p();
                p.r(buildPartial());
                return p;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: q */
            public AuthInfo getDefaultInstanceForType() {
                return AuthInfo.getDefaultInstance();
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
                AuthInfo authInfo = null;
                try {
                    try {
                        AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            r(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AuthInfo authInfo2 = (AuthInfo) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            authInfo = authInfo2;
                            if (authInfo != null) {
                                r(authInfo);
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

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
            /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ b mergeFrom(AuthInfo authInfo) {
                r(authInfo);
                return this;
            }

            public b r(AuthInfo authInfo) {
                if (authInfo == AuthInfo.getDefaultInstance()) {
                    return this;
                }
                if (authInfo.hasToken()) {
                    this.a |= 1;
                    this.b = authInfo.token_;
                }
                return this;
            }

            public b t(String str) {
                if (str != null) {
                    this.a |= 1;
                    this.b = str;
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                s(codedInputStream, extensionRegistryLite);
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
            return b.k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AuthInfo getDefaultInstanceForType() {
            return defaultInstance;
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
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes());
            }
            this.memoizedSerializedSize = i2;
            return i2;
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
            if ((this.bitField0_ & 1) == 1) {
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
        public static class a extends AbstractParser<AuthInfo> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: b */
            public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AuthInfo(codedInputStream, extensionRegistryLite, null);
            }
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        public /* synthetic */ AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, zx3 zx3Var) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public AuthInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static b newBuilder(AuthInfo authInfo) {
            b newBuilder = newBuilder();
            newBuilder.r(authInfo);
            return newBuilder;
        }

        public static AuthInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AuthInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getTokenBytes());
            }
        }

        public /* synthetic */ AuthInfo(GeneratedMessageLite.Builder builder, zx3 zx3Var) {
            this(builder);
        }

        public static AuthInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public AuthInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AuthInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AuthInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static AuthInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AuthInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bimlog$LogRequest, b> implements Object {
        public int a;
        public long b;
        public long e;
        public Object c = "";
        public AuthInfo d = AuthInfo.getDefaultInstance();
        public Object f = "";
        public ByteString g = ByteString.EMPTY;

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
        public Bimlog$LogRequest build() {
            Bimlog$LogRequest buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            b p = p();
            p.s(buildPartial());
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public Bimlog$LogRequest getDefaultInstanceForType() {
            return Bimlog$LogRequest.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bimlog$LogRequest buildPartial() {
            Bimlog$LogRequest bimlog$LogRequest = new Bimlog$LogRequest(this, (zx3) null);
            int i = this.a;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            bimlog$LogRequest.version_ = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bimlog$LogRequest.serviceName_ = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bimlog$LogRequest.authInfo_ = this.d;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            bimlog$LogRequest.requestTimestampMs_ = this.e;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            bimlog$LogRequest.sign_ = this.f;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            bimlog$LogRequest.payload_ = this.g;
            bimlog$LogRequest.bitField0_ = i2;
            return bimlog$LogRequest;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bimlog$LogRequest bimlog$LogRequest = null;
            try {
                try {
                    Bimlog$LogRequest parsePartialFrom = Bimlog$LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Bimlog$LogRequest bimlog$LogRequest2 = (Bimlog$LogRequest) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bimlog$LogRequest = bimlog$LogRequest2;
                        if (bimlog$LogRequest != null) {
                            s(bimlog$LogRequest);
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bimlog$LogRequest bimlog$LogRequest) {
            s(bimlog$LogRequest);
            return this;
        }

        public b r(AuthInfo authInfo) {
            if ((this.a & 4) == 4 && this.d != AuthInfo.getDefaultInstance()) {
                AuthInfo.b newBuilder = AuthInfo.newBuilder(this.d);
                newBuilder.r(authInfo);
                this.d = newBuilder.buildPartial();
            } else {
                this.d = authInfo;
            }
            this.a |= 4;
            return this;
        }

        public b u(AuthInfo authInfo) {
            if (authInfo != null) {
                this.d = authInfo;
                this.a |= 4;
                return this;
            }
            throw null;
        }

        public b v(ByteString byteString) {
            if (byteString != null) {
                this.a |= 32;
                this.g = byteString;
                return this;
            }
            throw null;
        }

        public b w(long j) {
            this.a |= 8;
            this.e = j;
            return this;
        }

        public b x(String str) {
            if (str != null) {
                this.a |= 2;
                this.c = str;
                return this;
            }
            throw null;
        }

        public b y(String str) {
            if (str != null) {
                this.a |= 16;
                this.f = str;
                return this;
            }
            throw null;
        }

        public b z(long j) {
            this.a |= 1;
            this.b = j;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b n() {
            super.clear();
            this.b = 0L;
            int i = this.a & (-2);
            this.a = i;
            this.c = "";
            this.a = i & (-3);
            this.d = AuthInfo.getDefaultInstance();
            int i2 = this.a & (-5);
            this.a = i2;
            this.e = 0L;
            int i3 = i2 & (-9);
            this.a = i3;
            this.f = "";
            int i4 = i3 & (-17);
            this.a = i4;
            this.g = ByteString.EMPTY;
            this.a = i4 & (-33);
            return this;
        }

        public b s(Bimlog$LogRequest bimlog$LogRequest) {
            if (bimlog$LogRequest == Bimlog$LogRequest.getDefaultInstance()) {
                return this;
            }
            if (bimlog$LogRequest.hasVersion()) {
                z(bimlog$LogRequest.getVersion());
            }
            if (bimlog$LogRequest.hasServiceName()) {
                this.a |= 2;
                this.c = bimlog$LogRequest.serviceName_;
            }
            if (bimlog$LogRequest.hasAuthInfo()) {
                r(bimlog$LogRequest.getAuthInfo());
            }
            if (bimlog$LogRequest.hasRequestTimestampMs()) {
                w(bimlog$LogRequest.getRequestTimestampMs());
            }
            if (bimlog$LogRequest.hasSign()) {
                this.a |= 16;
                this.f = bimlog$LogRequest.sign_;
            }
            if (bimlog$LogRequest.hasPayload()) {
                v(bimlog$LogRequest.getPayload());
            }
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
        return b.k();
    }

    public AuthInfo getAuthInfo() {
        return this.authInfo_;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bimlog$LogRequest getDefaultInstanceForType() {
        return defaultInstance;
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
        if ((this.bitField0_ & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean hasPayload() {
        if ((this.bitField0_ & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean hasRequestTimestampMs() {
        if ((this.bitField0_ & 8) == 8) {
            return true;
        }
        return false;
    }

    public boolean hasServiceName() {
        if ((this.bitField0_ & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasSign() {
        if ((this.bitField0_ & 16) == 16) {
            return true;
        }
        return false;
    }

    public boolean hasVersion() {
        if ((this.bitField0_ & 1) == 1) {
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
    public static class a extends AbstractParser<Bimlog$LogRequest> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bimlog$LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bimlog$LogRequest(codedInputStream, extensionRegistryLite, null);
        }
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
                        if (readTag != 8) {
                            if (readTag != 18) {
                                if (readTag != 26) {
                                    if (readTag != 32) {
                                        if (readTag != 42) {
                                            if (readTag != 50) {
                                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                                }
                                            } else {
                                                this.bitField0_ |= 32;
                                                this.payload_ = codedInputStream.readBytes();
                                            }
                                        } else {
                                            this.bitField0_ |= 16;
                                            this.sign_ = codedInputStream.readBytes();
                                        }
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.requestTimestampMs_ = codedInputStream.readInt64();
                                    }
                                } else {
                                    AuthInfo.b builder = (this.bitField0_ & 4) == 4 ? this.authInfo_.toBuilder() : null;
                                    AuthInfo authInfo = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                                    this.authInfo_ = authInfo;
                                    if (builder != null) {
                                        builder.r(authInfo);
                                        this.authInfo_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.serviceName_ = codedInputStream.readBytes();
                            }
                        } else {
                            this.bitField0_ |= 1;
                            this.version_ = codedInputStream.readInt64();
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ Bimlog$LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, zx3 zx3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public Bimlog$LogRequest(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static b newBuilder(Bimlog$LogRequest bimlog$LogRequest) {
        b newBuilder = newBuilder();
        newBuilder.s(bimlog$LogRequest);
        return newBuilder;
    }

    public static Bimlog$LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bimlog$LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public /* synthetic */ Bimlog$LogRequest(GeneratedMessageLite.Builder builder, zx3 zx3Var) {
        this(builder);
    }

    public static Bimlog$LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Bimlog$LogRequest(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bimlog$LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public static Bimlog$LogRequest parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public static Bimlog$LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bimlog$LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bimlog$LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            i2 = 0 + CodedOutputStream.computeInt64Size(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            i2 += CodedOutputStream.computeMessageSize(3, this.authInfo_);
        }
        if ((this.bitField0_ & 8) == 8) {
            i2 += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i2 += CodedOutputStream.computeBytesSize(5, getSignBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            i2 += CodedOutputStream.computeBytesSize(6, this.payload_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
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
}
