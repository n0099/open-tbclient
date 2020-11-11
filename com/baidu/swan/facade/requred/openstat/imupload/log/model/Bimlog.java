package com.baidu.swan.facade.requred.openstat.imupload.log.model;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes16.dex */
public final class Bimlog {

    /* loaded from: classes16.dex */
    public static final class LogRequest extends GeneratedMessageLite implements b {
        public static final int AUTH_INFO_FIELD_NUMBER = 3;
        public static final int PAYLOAD_FIELD_NUMBER = 6;
        public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
        public static final int SERVICE_NAME_FIELD_NUMBER = 2;
        public static final int SIGN_FIELD_NUMBER = 5;
        public static final int VERSION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private AuthInfo authInfo_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ByteString payload_;
        private long requestTimestampMs_;
        private Object serviceName_;
        private Object sign_;
        private long version_;
        public static Parser<LogRequest> PARSER = new AbstractParser<LogRequest>() { // from class: com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog.LogRequest.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: b */
            public LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogRequest(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LogRequest defaultInstance = new LogRequest(true);

        private LogRequest(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LogRequest(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogRequest getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            AuthInfo.a aVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                continue;
                                z2 = z;
                            case 8:
                                this.bitField0_ |= 1;
                                this.version_ = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 18:
                                this.bitField0_ |= 2;
                                this.serviceName_ = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 26:
                                if ((this.bitField0_ & 4) != 4) {
                                    aVar = null;
                                } else {
                                    aVar = this.authInfo_.toBuilder();
                                }
                                this.authInfo_ = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                                if (aVar != null) {
                                    aVar.mergeFrom(this.authInfo_);
                                    this.authInfo_ = aVar.buildPartial();
                                }
                                this.bitField0_ |= 4;
                                z = z2;
                                continue;
                                z2 = z;
                            case 32:
                                this.bitField0_ |= 8;
                                this.requestTimestampMs_ = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 42:
                                this.bitField0_ |= 16;
                                this.sign_ = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 50:
                                this.bitField0_ |= 32;
                                this.payload_ = codedInputStream.readBytes();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    continue;
                                    z2 = z;
                                }
                                break;
                        }
                        z = z2;
                        z2 = z;
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

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogRequest> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes16.dex */
        public static final class AuthInfo extends GeneratedMessageLite implements com.baidu.swan.facade.requred.openstat.imupload.log.model.a {
            public static final int TOKEN_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Object token_;
            public static Parser<AuthInfo> PARSER = new AbstractParser<AuthInfo>() { // from class: com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog.LogRequest.AuthInfo.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: c */
                public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AuthInfo(codedInputStream, extensionRegistryLite);
                }
            };
            private static final AuthInfo defaultInstance = new AuthInfo(true);

            private AuthInfo(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private AuthInfo(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static AuthInfo getDefaultInstance() {
                return defaultInstance;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            public AuthInfo getDefaultInstanceForType() {
                return defaultInstance;
            }

            private AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 10:
                                        this.bitField0_ |= 1;
                                        this.token_ = codedInputStream.readBytes();
                                        break;
                                    default:
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                            z = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
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

            static {
                defaultInstance.initFields();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<AuthInfo> getParserForType() {
                return PARSER;
            }

            public boolean hasToken() {
                return (this.bitField0_ & 1) == 1;
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

            private void initFields() {
                this.token_ = "";
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b != -1) {
                    return b == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeBytes(1, getTokenBytes());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i == -1) {
                    i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
                    this.memoizedSerializedSize = i;
                }
                return i;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static AuthInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static AuthInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
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

            public static AuthInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(inputStream, extensionRegistryLite);
            }

            public static AuthInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream);
            }

            public static AuthInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public static AuthInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return PARSER.parseFrom(codedInputStream);
            }

            public static AuthInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public static a newBuilder() {
                return a.aPm();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public a newBuilderForType() {
                return newBuilder();
            }

            public static a newBuilder(AuthInfo authInfo) {
                return newBuilder().mergeFrom(authInfo);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public a toBuilder() {
                return newBuilder(this);
            }

            /* loaded from: classes16.dex */
            public static final class a extends GeneratedMessageLite.Builder<AuthInfo, a> implements com.baidu.swan.facade.requred.openstat.imupload.log.model.a {
                private int bitField0_;
                private Object token_ = "";

                private a() {
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static a aPm() {
                    return new a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: aPn */
                public a clear() {
                    super.clear();
                    this.token_ = "";
                    this.bitField0_ &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: aPo */
                public a clone() {
                    return aPm().mergeFrom(buildPartial());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public AuthInfo getDefaultInstanceForType() {
                    return AuthInfo.getDefaultInstance();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: aPp */
                public AuthInfo build() {
                    AuthInfo buildPartial = buildPartial();
                    if (!buildPartial.isInitialized()) {
                        throw newUninitializedMessageException(buildPartial);
                    }
                    return buildPartial;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: aPq */
                public AuthInfo buildPartial() {
                    AuthInfo authInfo = new AuthInfo(this);
                    int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
                    authInfo.token_ = this.token_;
                    authInfo.bitField0_ = i;
                    return authInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public a mergeFrom(AuthInfo authInfo) {
                    if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                        this.bitField0_ |= 1;
                        this.token_ = authInfo.token_;
                    }
                    return this;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    AuthInfo authInfo;
                    Throwable th;
                    try {
                        try {
                            AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (Throwable th2) {
                            th = th2;
                            authInfo = null;
                            if (authInfo != null) {
                                mergeFrom(authInfo);
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        AuthInfo authInfo2 = (AuthInfo) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            authInfo = authInfo2;
                            th = th3;
                            if (authInfo != null) {
                            }
                            throw th;
                        }
                    }
                }

                public a vl(String str) {
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.token_ = str;
                    return this;
                }
            }
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getVersion() {
            return this.version_;
        }

        public boolean hasServiceName() {
            return (this.bitField0_ & 2) == 2;
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

        public boolean hasAuthInfo() {
            return (this.bitField0_ & 4) == 4;
        }

        public AuthInfo getAuthInfo() {
            return this.authInfo_;
        }

        public boolean hasRequestTimestampMs() {
            return (this.bitField0_ & 8) == 8;
        }

        public long getRequestTimestampMs() {
            return this.requestTimestampMs_;
        }

        public boolean hasSign() {
            return (this.bitField0_ & 16) == 16;
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

        public boolean hasPayload() {
            return (this.bitField0_ & 32) == 32;
        }

        public ByteString getPayload() {
            return this.payload_;
        }

        private void initFields() {
            this.version_ = 0L;
            this.serviceName_ = "";
            this.authInfo_ = AuthInfo.getDefaultInstance();
            this.requestTimestampMs_ = 0L;
            this.sign_ = "";
            this.payload_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.version_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.authInfo_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getSignBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, this.payload_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LogRequest parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.aPs();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(LogRequest logRequest) {
            return newBuilder().mergeFrom(logRequest);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes16.dex */
        public static final class a extends GeneratedMessageLite.Builder<LogRequest, a> implements b {
            private int bitField0_;
            private long requestTimestampMs_;
            private long version_;
            private Object serviceName_ = "";
            private AuthInfo authInfo_ = AuthInfo.getDefaultInstance();
            private Object sign_ = "";
            private ByteString payload_ = ByteString.EMPTY;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a aPs() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: aPt */
            public a clear() {
                super.clear();
                this.version_ = 0L;
                this.bitField0_ &= -2;
                this.serviceName_ = "";
                this.bitField0_ &= -3;
                this.authInfo_ = AuthInfo.getDefaultInstance();
                this.bitField0_ &= -5;
                this.requestTimestampMs_ = 0L;
                this.bitField0_ &= -9;
                this.sign_ = "";
                this.bitField0_ &= -17;
                this.payload_ = ByteString.EMPTY;
                this.bitField0_ &= -33;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: aPu */
            public a clone() {
                return aPs().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogRequest getDefaultInstanceForType() {
                return LogRequest.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: aPv */
            public LogRequest build() {
                LogRequest buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: aPw */
            public LogRequest buildPartial() {
                LogRequest logRequest = new LogRequest(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                logRequest.version_ = this.version_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                logRequest.serviceName_ = this.serviceName_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                logRequest.authInfo_ = this.authInfo_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                logRequest.requestTimestampMs_ = this.requestTimestampMs_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                logRequest.sign_ = this.sign_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                logRequest.payload_ = this.payload_;
                logRequest.bitField0_ = i2;
                return logRequest;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LogRequest logRequest) {
                if (logRequest != LogRequest.getDefaultInstance()) {
                    if (logRequest.hasVersion()) {
                        cA(logRequest.getVersion());
                    }
                    if (logRequest.hasServiceName()) {
                        this.bitField0_ |= 2;
                        this.serviceName_ = logRequest.serviceName_;
                    }
                    if (logRequest.hasAuthInfo()) {
                        c(logRequest.getAuthInfo());
                    }
                    if (logRequest.hasRequestTimestampMs()) {
                        cB(logRequest.getRequestTimestampMs());
                    }
                    if (logRequest.hasSign()) {
                        this.bitField0_ |= 16;
                        this.sign_ = logRequest.sign_;
                    }
                    if (logRequest.hasPayload()) {
                        b(logRequest.getPayload());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogRequest logRequest;
                Throwable th;
                try {
                    try {
                        LogRequest parsePartialFrom = LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        logRequest = null;
                        if (logRequest != null) {
                            mergeFrom(logRequest);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LogRequest logRequest2 = (LogRequest) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        logRequest = logRequest2;
                        th = th3;
                        if (logRequest != null) {
                        }
                        throw th;
                    }
                }
            }

            public a cA(long j) {
                this.bitField0_ |= 1;
                this.version_ = j;
                return this;
            }

            public a vm(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.serviceName_ = str;
                return this;
            }

            public a b(AuthInfo authInfo) {
                if (authInfo == null) {
                    throw new NullPointerException();
                }
                this.authInfo_ = authInfo;
                this.bitField0_ |= 4;
                return this;
            }

            public a c(AuthInfo authInfo) {
                if ((this.bitField0_ & 4) == 4 && this.authInfo_ != AuthInfo.getDefaultInstance()) {
                    this.authInfo_ = AuthInfo.newBuilder(this.authInfo_).mergeFrom(authInfo).buildPartial();
                } else {
                    this.authInfo_ = authInfo;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public a cB(long j) {
                this.bitField0_ |= 8;
                this.requestTimestampMs_ = j;
                return this;
            }

            public a vn(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.sign_ = str;
                return this;
            }

            public a b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.payload_ = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes16.dex */
    public static final class LogResponse extends GeneratedMessageLite implements c {
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        public static final int ERROR_MSG_FIELD_NUMBER = 2;
        public static final int PING_INTERVAL_MS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errorCode_;
        private Object errorMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long pingIntervalMs_;
        public static Parser<LogResponse> PARSER = new AbstractParser<LogResponse>() { // from class: com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog.LogResponse.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: f */
            public LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogResponse(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LogResponse defaultInstance = new LogResponse(true);

        private LogResponse(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LogResponse(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogResponse getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.errorCode_ = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.errorMsg_ = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.pingIntervalMs_ = codedInputStream.readInt64();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public boolean hasErrorMsg() {
            return (this.bitField0_ & 2) == 2;
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

        public boolean hasPingIntervalMs() {
            return (this.bitField0_ & 4) == 4;
        }

        public long getPingIntervalMs() {
            return this.pingIntervalMs_;
        }

        private void initFields() {
            this.errorCode_ = 0;
            this.errorMsg_ = "";
            this.pingIntervalMs_ = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.errorCode_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LogResponse parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.aPy();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(LogResponse logResponse) {
            return newBuilder().mergeFrom(logResponse);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes16.dex */
        public static final class a extends GeneratedMessageLite.Builder<LogResponse, a> implements c {
            private int bitField0_;
            private int errorCode_;
            private Object errorMsg_ = "";
            private long pingIntervalMs_;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a aPy() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: aPz */
            public a clear() {
                super.clear();
                this.errorCode_ = 0;
                this.bitField0_ &= -2;
                this.errorMsg_ = "";
                this.bitField0_ &= -3;
                this.pingIntervalMs_ = 0L;
                this.bitField0_ &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: aPA */
            public a clone() {
                return aPy().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogResponse getDefaultInstanceForType() {
                return LogResponse.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: aPB */
            public LogResponse build() {
                LogResponse buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: aPC */
            public LogResponse buildPartial() {
                LogResponse logResponse = new LogResponse(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                logResponse.errorCode_ = this.errorCode_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                logResponse.errorMsg_ = this.errorMsg_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                logResponse.pingIntervalMs_ = this.pingIntervalMs_;
                logResponse.bitField0_ = i2;
                return logResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LogResponse logResponse) {
                if (logResponse != LogResponse.getDefaultInstance()) {
                    if (logResponse.hasErrorCode()) {
                        lI(logResponse.getErrorCode());
                    }
                    if (logResponse.hasErrorMsg()) {
                        this.bitField0_ |= 2;
                        this.errorMsg_ = logResponse.errorMsg_;
                    }
                    if (logResponse.hasPingIntervalMs()) {
                        cC(logResponse.getPingIntervalMs());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: g */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogResponse logResponse;
                Throwable th;
                try {
                    try {
                        LogResponse parsePartialFrom = LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        logResponse = null;
                        if (logResponse != null) {
                            mergeFrom(logResponse);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LogResponse logResponse2 = (LogResponse) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        logResponse = logResponse2;
                        th = th3;
                        if (logResponse != null) {
                        }
                        throw th;
                    }
                }
            }

            public a lI(int i) {
                this.bitField0_ |= 1;
                this.errorCode_ = i;
                return this;
            }

            public a cC(long j) {
                this.bitField0_ |= 4;
                this.pingIntervalMs_ = j;
                return this;
            }
        }
    }
}
