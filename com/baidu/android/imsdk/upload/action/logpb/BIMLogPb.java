package com.baidu.android.imsdk.upload.action.logpb;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
/* loaded from: classes2.dex */
public final class BIMLogPb {

    /* loaded from: classes2.dex */
    public static final class LogRequest extends GeneratedMessageLite implements LogRequestOrBuilder {
        public static final Parser<LogRequest> PARSER = new AbstractParser<LogRequest>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogRequest(codedInputStream, extensionRegistryLite);
            }
        };
        public static final LogRequest defaultInstance;
        public static final long serialVersionUID = 0;
        public AuthInfo authInfo;
        public int bitField0;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public ByteString payload;
        public long requestTimestampMs;
        public Object serviceName;
        public Object sign;
        public long version;

        /* loaded from: classes2.dex */
        public static final class AuthInfo extends GeneratedMessageLite implements AuthInfoOrBuilder {
            public static final Parser<AuthInfo> PARSER = new AbstractParser<AuthInfo>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfo.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AuthInfo(codedInputStream, extensionRegistryLite);
                }
            };
            public static final AuthInfo defaultInstance;
            public static final long serialVersionUID = 0;
            public int bitField0;
            public byte memoizedIsInitialized;
            public int memoizedSerializedSize;
            public Object token;

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<AuthInfo, Builder> implements AuthInfoOrBuilder {
                public int bitField0;
                public Object token = "";

                public Builder() {
                    maybeForceBuilderInitialization();
                }

                public static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder setToken(String str) {
                    if (str != null) {
                        this.bitField0 |= 1;
                        this.token = str;
                        return this;
                    }
                    throw null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                public AuthInfo build() {
                    AuthInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                public AuthInfo buildPartial() {
                    AuthInfo authInfo = new AuthInfo(this);
                    int i = (this.bitField0 & 1) != 1 ? 0 : 1;
                    authInfo.token = this.token;
                    authInfo.bitField0 = i;
                    return authInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public Builder clear() {
                    super.clear();
                    this.token = "";
                    this.bitField0 &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public AuthInfo getDefaultInstanceForType() {
                    return AuthInfo.getDefaultInstance();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(AuthInfo authInfo) {
                    if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                        this.bitField0 |= 1;
                        this.token = authInfo.token;
                    }
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    AuthInfo authInfo = null;
                    try {
                        try {
                            AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
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
                                    mergeFrom(authInfo);
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
                this.token = "";
            }

            public static Builder newBuilder() {
                return Builder.create();
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
                int computeBytesSize = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
                this.memoizedSerializedSize = computeBytesSize;
                return computeBytesSize;
            }

            public ByteString getTokenBytes() {
                Object obj = this.token;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.token = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public boolean hasToken() {
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
                    codedOutputStream.writeBytes(1, getTokenBytes());
                }
            }

            public static Builder newBuilder(AuthInfo authInfo) {
                return newBuilder().mergeFrom(authInfo);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            public AuthInfo getDefaultInstanceForType() {
                return defaultInstance;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            public AuthInfo(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public AuthInfo(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
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
                                    this.bitField0 |= 1;
                                    this.token = codedInputStream.readBytes();
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

        /* loaded from: classes2.dex */
        public interface AuthInfoOrBuilder extends MessageLiteOrBuilder {
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LogRequest, Builder> implements LogRequestOrBuilder {
            public int bitField0;
            public long requestTimestampMs;
            public long version;
            public Object serviceName = "";
            public AuthInfo authInfo = AuthInfo.getDefaultInstance();
            public Object sign = "";
            public ByteString payload = ByteString.EMPTY;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeAuthInfo(AuthInfo authInfo) {
                if ((this.bitField0 & 4) == 4 && this.authInfo != AuthInfo.getDefaultInstance()) {
                    this.authInfo = AuthInfo.newBuilder(this.authInfo).mergeFrom(authInfo).buildPartial();
                } else {
                    this.authInfo = authInfo;
                }
                this.bitField0 |= 4;
                return this;
            }

            public Builder setAuthInfo(AuthInfo authInfo) {
                if (authInfo != null) {
                    this.authInfo = authInfo;
                    this.bitField0 |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setPayload(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 32;
                    this.payload = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRequestTimestampMs(long j) {
                this.bitField0 |= 8;
                this.requestTimestampMs = j;
                return this;
            }

            public Builder setServiceName(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.serviceName = str;
                    return this;
                }
                throw null;
            }

            public Builder setSign(String str) {
                if (str != null) {
                    this.bitField0 |= 16;
                    this.sign = str;
                    return this;
                }
                throw null;
            }

            public Builder setVersion(long j) {
                this.bitField0 |= 1;
                this.version = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogRequest build() {
                LogRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogRequest buildPartial() {
                LogRequest logRequest = new LogRequest(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                logRequest.version = this.version;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                logRequest.serviceName = this.serviceName;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                logRequest.authInfo = this.authInfo;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                logRequest.requestTimestampMs = this.requestTimestampMs;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                logRequest.sign = this.sign;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                logRequest.payload = this.payload;
                logRequest.bitField0 = i2;
                return logRequest;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.version = 0L;
                int i = this.bitField0 & (-2);
                this.bitField0 = i;
                this.serviceName = "";
                this.bitField0 = i & (-3);
                this.authInfo = AuthInfo.getDefaultInstance();
                int i2 = this.bitField0 & (-5);
                this.bitField0 = i2;
                this.requestTimestampMs = 0L;
                int i3 = i2 & (-9);
                this.bitField0 = i3;
                this.sign = "";
                int i4 = i3 & (-17);
                this.bitField0 = i4;
                this.payload = ByteString.EMPTY;
                this.bitField0 = i4 & (-33);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogRequest getDefaultInstanceForType() {
                return LogRequest.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(LogRequest logRequest) {
                if (logRequest == LogRequest.getDefaultInstance()) {
                    return this;
                }
                if (logRequest.hasVersion()) {
                    setVersion(logRequest.getVersion());
                }
                if (logRequest.hasServiceName()) {
                    this.bitField0 |= 2;
                    this.serviceName = logRequest.serviceName;
                }
                if (logRequest.hasAuthInfo()) {
                    mergeAuthInfo(logRequest.getAuthInfo());
                }
                if (logRequest.hasRequestTimestampMs()) {
                    setRequestTimestampMs(logRequest.getRequestTimestampMs());
                }
                if (logRequest.hasSign()) {
                    this.bitField0 |= 16;
                    this.sign = logRequest.sign;
                }
                if (logRequest.hasPayload()) {
                    setPayload(logRequest.getPayload());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogRequest logRequest = null;
                try {
                    try {
                        LogRequest parsePartialFrom = LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        LogRequest logRequest2 = (LogRequest) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            logRequest = logRequest2;
                            if (logRequest != null) {
                                mergeFrom(logRequest);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (logRequest != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            LogRequest logRequest = new LogRequest(true);
            defaultInstance = logRequest;
            logRequest.initFields();
        }

        public static LogRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version = 0L;
            this.serviceName = "";
            this.authInfo = AuthInfo.getDefaultInstance();
            this.requestTimestampMs = 0L;
            this.sign = "";
            this.payload = ByteString.EMPTY;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public AuthInfo getAuthInfo() {
            return this.authInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogRequest> getParserForType() {
            return PARSER;
        }

        public ByteString getPayload() {
            return this.payload;
        }

        public long getRequestTimestampMs() {
            return this.requestTimestampMs;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.version) : 0;
            if ((this.bitField0 & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.authInfo);
            }
            if ((this.bitField0 & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs);
            }
            if ((this.bitField0 & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, getSignBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, this.payload);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString getServiceNameBytes() {
            Object obj = this.serviceName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serviceName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public ByteString getSignBytes() {
            Object obj = this.sign;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sign = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public long getVersion() {
            return this.version;
        }

        public boolean hasAuthInfo() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasPayload() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasRequestTimestampMs() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasServiceName() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasSign() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasVersion() {
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
                codedOutputStream.writeInt64(1, this.version);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getServiceNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeMessage(3, this.authInfo);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.requestTimestampMs);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeBytes(5, getSignBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, this.payload);
            }
        }

        public static Builder newBuilder(LogRequest logRequest) {
            return newBuilder().mergeFrom(logRequest);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public LogRequest(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public LogRequest(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.bitField0 |= 1;
                                this.version = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.bitField0 |= 2;
                                this.serviceName = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                AuthInfo.Builder builder = (this.bitField0 & 4) == 4 ? this.authInfo.toBuilder() : null;
                                AuthInfo authInfo = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                                this.authInfo = authInfo;
                                if (builder != null) {
                                    builder.mergeFrom(authInfo);
                                    this.authInfo = builder.buildPartial();
                                }
                                this.bitField0 |= 4;
                            } else if (readTag == 32) {
                                this.bitField0 |= 8;
                                this.requestTimestampMs = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.bitField0 |= 16;
                                this.sign = codedInputStream.readBytes();
                            } else if (readTag != 50) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0 |= 32;
                                this.payload = codedInputStream.readBytes();
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

    /* loaded from: classes2.dex */
    public interface LogRequestOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class LogResponse extends GeneratedMessageLite implements LogResponseOrBuilder {
        public static final Parser<LogResponse> PARSER = new AbstractParser<LogResponse>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponse.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogResponse(codedInputStream, extensionRegistryLite);
            }
        };
        public static final LogResponse defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public int errorCode;
        public Object errorMsg;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long pingIntervalMs;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LogResponse, Builder> implements LogResponseOrBuilder {
            public int bitField0;
            public int errorCode;
            public Object errorMsg = "";
            public long pingIntervalMs;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrorCode(int i) {
                this.bitField0 |= 1;
                this.errorCode = i;
                return this;
            }

            public Builder setPingIntervalMs(long j) {
                this.bitField0 |= 4;
                this.pingIntervalMs = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogResponse build() {
                LogResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogResponse buildPartial() {
                LogResponse logResponse = new LogResponse(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                logResponse.errorCode = this.errorCode;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                logResponse.errorMsg = this.errorMsg;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                logResponse.pingIntervalMs = this.pingIntervalMs;
                logResponse.bitField0 = i2;
                return logResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.errorCode = 0;
                int i = this.bitField0 & (-2);
                this.bitField0 = i;
                this.errorMsg = "";
                int i2 = i & (-3);
                this.bitField0 = i2;
                this.pingIntervalMs = 0L;
                this.bitField0 = i2 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogResponse getDefaultInstanceForType() {
                return LogResponse.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(LogResponse logResponse) {
                if (logResponse == LogResponse.getDefaultInstance()) {
                    return this;
                }
                if (logResponse.hasErrorCode()) {
                    setErrorCode(logResponse.getErrorCode());
                }
                if (logResponse.hasErrorMsg()) {
                    this.bitField0 |= 2;
                    this.errorMsg = logResponse.errorMsg;
                }
                if (logResponse.hasPingIntervalMs()) {
                    setPingIntervalMs(logResponse.getPingIntervalMs());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogResponse logResponse = null;
                try {
                    try {
                        LogResponse parsePartialFrom = LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        LogResponse logResponse2 = (LogResponse) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            logResponse = logResponse2;
                            if (logResponse != null) {
                                mergeFrom(logResponse);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (logResponse != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            LogResponse logResponse = new LogResponse(true);
            defaultInstance = logResponse;
            logResponse.initFields();
        }

        public static LogResponse getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.errorCode = 0;
            this.errorMsg = "";
            this.pingIntervalMs = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            Object obj = this.errorMsg;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.errorMsg = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getErrorMsgBytes() {
            Object obj = this.errorMsg;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errorMsg = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogResponse> getParserForType() {
            return PARSER;
        }

        public long getPingIntervalMs() {
            return this.pingIntervalMs;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.errorCode) : 0;
            if ((this.bitField0 & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs);
            }
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasErrorCode() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasErrorMsg() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasPingIntervalMs() {
            return (this.bitField0 & 4) == 4;
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
                codedOutputStream.writeInt32(1, this.errorCode);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getErrorMsgBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.pingIntervalMs);
            }
        }

        public static Builder newBuilder(LogResponse logResponse) {
            return newBuilder().mergeFrom(logResponse);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public LogResponse(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public LogResponse(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.errorCode = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.bitField0 |= 2;
                                    this.errorMsg = codedInputStream.readBytes();
                                } else if (readTag != 24) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0 |= 4;
                                    this.pingIntervalMs = codedInputStream.readInt64();
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

    /* loaded from: classes2.dex */
    public interface LogResponseOrBuilder extends MessageLiteOrBuilder {
    }
}
