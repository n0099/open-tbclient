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
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes.dex */
public final class BIMLogPb {

    /* loaded from: classes.dex */
    public static final class LogRequest extends GeneratedMessageLite implements LogRequestOrBuilder {
        public static final int AUTH_INFO_FIELD_NUMBER = 3;
        public static Parser<LogRequest> PARSER = new AbstractParser<LogRequest>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogRequest(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PAYLOAD_FIELD_NUMBER = 6;
        public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
        public static final int SERVICE_NAME_FIELD_NUMBER = 2;
        public static final int SIGN_FIELD_NUMBER = 5;
        public static final int VERSION_FIELD_NUMBER = 1;
        public static final LogRequest defaultInstance;
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

        /* loaded from: classes.dex */
        public static final class AuthInfo extends GeneratedMessageLite implements AuthInfoOrBuilder {
            public static Parser<AuthInfo> PARSER = new AbstractParser<AuthInfo>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfo.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AuthInfo(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int TOKEN_FIELD_NUMBER = 1;
            public static final AuthInfo defaultInstance;
            public static final long serialVersionUID = 0;
            public int bitField0_;
            public byte memoizedIsInitialized;
            public int memoizedSerializedSize;
            public Object token_;

            /* loaded from: classes.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<AuthInfo, Builder> implements AuthInfoOrBuilder {
                public int bitField0_;
                public Object token_ = "";

                public Builder() {
                    maybeForceBuilderInitialization();
                }

                public static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                public Builder clearToken() {
                    this.bitField0_ &= -2;
                    this.token_ = AuthInfo.getDefaultInstance().getToken();
                    return this;
                }

                @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
                public String getToken() {
                    Object obj = this.token_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.token_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
                public ByteString getTokenBytes() {
                    Object obj = this.token_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.token_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
                public boolean hasToken() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder setToken(String str) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.token_ = str;
                        return this;
                    }
                    throw null;
                }

                public Builder setTokenBytes(ByteString byteString) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.token_ = byteString;
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
                    int i2 = (this.bitField0_ & 1) != 1 ? 0 : 1;
                    authInfo.token_ = this.token_;
                    authInfo.bitField0_ = i2;
                    return authInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public Builder clear() {
                    super.clear();
                    this.token_ = "";
                    this.bitField0_ &= -2;
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
                        this.bitField0_ |= 1;
                        this.token_ = authInfo.token_;
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
                this.token_ = "";
            }

            public static Builder newBuilder() {
                return Builder.create();
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
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
                this.memoizedSerializedSize = computeBytesSize;
                return computeBytesSize;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
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

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.token_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
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

            public static Builder newBuilder(AuthInfo authInfo) {
                return newBuilder().mergeFrom(authInfo);
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

        /* loaded from: classes.dex */
        public interface AuthInfoOrBuilder extends MessageLiteOrBuilder {
            String getToken();

            ByteString getTokenBytes();

            boolean hasToken();
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LogRequest, Builder> implements LogRequestOrBuilder {
            public int bitField0_;
            public long requestTimestampMs_;
            public long version_;
            public Object serviceName_ = "";
            public AuthInfo authInfo_ = AuthInfo.getDefaultInstance();
            public Object sign_ = "";
            public ByteString payload_ = ByteString.EMPTY;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAuthInfo() {
                this.authInfo_ = AuthInfo.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearPayload() {
                this.bitField0_ &= -33;
                this.payload_ = LogRequest.getDefaultInstance().getPayload();
                return this;
            }

            public Builder clearRequestTimestampMs() {
                this.bitField0_ &= -9;
                this.requestTimestampMs_ = 0L;
                return this;
            }

            public Builder clearServiceName() {
                this.bitField0_ &= -3;
                this.serviceName_ = LogRequest.getDefaultInstance().getServiceName();
                return this;
            }

            public Builder clearSign() {
                this.bitField0_ &= -17;
                this.sign_ = LogRequest.getDefaultInstance().getSign();
                return this;
            }

            public Builder clearVersion() {
                this.bitField0_ &= -2;
                this.version_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public AuthInfo getAuthInfo() {
                return this.authInfo_;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public ByteString getPayload() {
                return this.payload_;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public long getRequestTimestampMs() {
                return this.requestTimestampMs_;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public String getServiceName() {
                Object obj = this.serviceName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.serviceName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public ByteString getServiceNameBytes() {
                Object obj = this.serviceName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serviceName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public String getSign() {
                Object obj = this.sign_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.sign_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public ByteString getSignBytes() {
                Object obj = this.sign_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sign_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public long getVersion() {
                return this.version_;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasAuthInfo() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasPayload() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasRequestTimestampMs() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasServiceName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasSign() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasVersion() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeAuthInfo(AuthInfo authInfo) {
                if ((this.bitField0_ & 4) == 4 && this.authInfo_ != AuthInfo.getDefaultInstance()) {
                    this.authInfo_ = AuthInfo.newBuilder(this.authInfo_).mergeFrom(authInfo).buildPartial();
                } else {
                    this.authInfo_ = authInfo;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setAuthInfo(AuthInfo authInfo) {
                if (authInfo != null) {
                    this.authInfo_ = authInfo;
                    this.bitField0_ |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setPayload(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 32;
                    this.payload_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRequestTimestampMs(long j) {
                this.bitField0_ |= 8;
                this.requestTimestampMs_ = j;
                return this;
            }

            public Builder setServiceName(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.serviceName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setServiceNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.serviceName_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setSign(String str) {
                if (str != null) {
                    this.bitField0_ |= 16;
                    this.sign_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setSignBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 16;
                    this.sign_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setVersion(long j) {
                this.bitField0_ |= 1;
                this.version_ = j;
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
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                logRequest.version_ = this.version_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                logRequest.serviceName_ = this.serviceName_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                logRequest.authInfo_ = this.authInfo_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                logRequest.requestTimestampMs_ = this.requestTimestampMs_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                logRequest.sign_ = this.sign_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                logRequest.payload_ = this.payload_;
                logRequest.bitField0_ = i3;
                return logRequest;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.version_ = 0L;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.serviceName_ = "";
                this.bitField0_ = i2 & (-3);
                this.authInfo_ = AuthInfo.getDefaultInstance();
                int i3 = this.bitField0_ & (-5);
                this.bitField0_ = i3;
                this.requestTimestampMs_ = 0L;
                int i4 = i3 & (-9);
                this.bitField0_ = i4;
                this.sign_ = "";
                int i5 = i4 & (-17);
                this.bitField0_ = i5;
                this.payload_ = ByteString.EMPTY;
                this.bitField0_ = i5 & (-33);
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
                    this.bitField0_ |= 2;
                    this.serviceName_ = logRequest.serviceName_;
                }
                if (logRequest.hasAuthInfo()) {
                    mergeAuthInfo(logRequest.getAuthInfo());
                }
                if (logRequest.hasRequestTimestampMs()) {
                    setRequestTimestampMs(logRequest.getRequestTimestampMs());
                }
                if (logRequest.hasSign()) {
                    this.bitField0_ |= 16;
                    this.sign_ = logRequest.sign_;
                }
                if (logRequest.hasPayload()) {
                    setPayload(logRequest.getPayload());
                }
                return this;
            }

            public Builder setAuthInfo(AuthInfo.Builder builder) {
                this.authInfo_ = builder.build();
                this.bitField0_ |= 4;
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
            this.version_ = 0L;
            this.serviceName_ = "";
            this.authInfo_ = AuthInfo.getDefaultInstance();
            this.requestTimestampMs_ = 0L;
            this.sign_ = "";
            this.payload_ = ByteString.EMPTY;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public AuthInfo getAuthInfo() {
            return this.authInfo_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public ByteString getPayload() {
            return this.payload_;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public long getRequestTimestampMs() {
            return this.requestTimestampMs_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
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

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public ByteString getServiceNameBytes() {
            Object obj = this.serviceName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public ByteString getSignBytes() {
            Object obj = this.sign_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sign_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public long getVersion() {
            return this.version_;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasAuthInfo() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasPayload() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasRequestTimestampMs() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasServiceName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasSign() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
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

        public static Builder newBuilder(LogRequest logRequest) {
            return newBuilder().mergeFrom(logRequest);
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
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

        public static LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LogRequest parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public LogRequest(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
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
                                this.bitField0_ |= 1;
                                this.version_ = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.serviceName_ = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                AuthInfo.Builder builder = (this.bitField0_ & 4) == 4 ? this.authInfo_.toBuilder() : null;
                                AuthInfo authInfo = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                                this.authInfo_ = authInfo;
                                if (builder != null) {
                                    builder.mergeFrom(authInfo);
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

    /* loaded from: classes.dex */
    public interface LogRequestOrBuilder extends MessageLiteOrBuilder {
        LogRequest.AuthInfo getAuthInfo();

        ByteString getPayload();

        long getRequestTimestampMs();

        String getServiceName();

        ByteString getServiceNameBytes();

        String getSign();

        ByteString getSignBytes();

        long getVersion();

        boolean hasAuthInfo();

        boolean hasPayload();

        boolean hasRequestTimestampMs();

        boolean hasServiceName();

        boolean hasSign();

        boolean hasVersion();
    }

    /* loaded from: classes.dex */
    public static final class LogResponse extends GeneratedMessageLite implements LogResponseOrBuilder {
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        public static final int ERROR_MSG_FIELD_NUMBER = 2;
        public static Parser<LogResponse> PARSER = new AbstractParser<LogResponse>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponse.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogResponse(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PING_INTERVAL_MS_FIELD_NUMBER = 3;
        public static final LogResponse defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public int errorCode_;
        public Object errorMsg_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long pingIntervalMs_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LogResponse, Builder> implements LogResponseOrBuilder {
            public int bitField0_;
            public int errorCode_;
            public Object errorMsg_ = "";
            public long pingIntervalMs_;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearErrorCode() {
                this.bitField0_ &= -2;
                this.errorCode_ = 0;
                return this;
            }

            public Builder clearErrorMsg() {
                this.bitField0_ &= -3;
                this.errorMsg_ = LogResponse.getDefaultInstance().getErrorMsg();
                return this;
            }

            public Builder clearPingIntervalMs() {
                this.bitField0_ &= -5;
                this.pingIntervalMs_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public int getErrorCode() {
                return this.errorCode_;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public String getErrorMsg() {
                Object obj = this.errorMsg_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.errorMsg_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public ByteString getErrorMsgBytes() {
                Object obj = this.errorMsg_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.errorMsg_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public long getPingIntervalMs() {
                return this.pingIntervalMs_;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public boolean hasErrorCode() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public boolean hasErrorMsg() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public boolean hasPingIntervalMs() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrorCode(int i2) {
                this.bitField0_ |= 1;
                this.errorCode_ = i2;
                return this;
            }

            public Builder setErrorMsg(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.errorMsg_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setErrorMsgBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.errorMsg_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setPingIntervalMs(long j) {
                this.bitField0_ |= 4;
                this.pingIntervalMs_ = j;
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
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                logResponse.errorCode_ = this.errorCode_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                logResponse.errorMsg_ = this.errorMsg_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                logResponse.pingIntervalMs_ = this.pingIntervalMs_;
                logResponse.bitField0_ = i3;
                return logResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.errorCode_ = 0;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.errorMsg_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.pingIntervalMs_ = 0L;
                this.bitField0_ = i3 & (-5);
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
                    this.bitField0_ |= 2;
                    this.errorMsg_ = logResponse.errorMsg_;
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
            this.errorCode_ = 0;
            this.errorMsg_ = "";
            this.pingIntervalMs_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public int getErrorCode() {
            return this.errorCode_;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
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
        public Parser<LogResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public boolean hasErrorCode() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public boolean hasErrorMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
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

        public static Builder newBuilder(LogResponse logResponse) {
            return newBuilder().mergeFrom(logResponse);
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
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

        public static LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LogResponse parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public LogResponse(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
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

    /* loaded from: classes.dex */
    public interface LogResponseOrBuilder extends MessageLiteOrBuilder {
        int getErrorCode();

        String getErrorMsg();

        ByteString getErrorMsgBytes();

        long getPingIntervalMs();

        boolean hasErrorCode();

        boolean hasErrorMsg();

        boolean hasPingIntervalMs();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
