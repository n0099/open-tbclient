package com.baidu.android.imsdk.upload.action.logpb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public final class BIMLogPb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class LogRequest extends GeneratedMessageLite implements LogRequestOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AUTH_INFO_FIELD_NUMBER = 3;
        public static Parser<LogRequest> PARSER = null;
        public static final int PAYLOAD_FIELD_NUMBER = 6;
        public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
        public static final int SERVICE_NAME_FIELD_NUMBER = 2;
        public static final int SIGN_FIELD_NUMBER = 5;
        public static final int VERSION_FIELD_NUMBER = 1;
        public static final LogRequest defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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
        public static final class AuthInfo extends GeneratedMessageLite implements AuthInfoOrBuilder {
            public static /* synthetic */ Interceptable $ic = null;
            public static Parser<AuthInfo> PARSER = null;
            public static final int TOKEN_FIELD_NUMBER = 1;
            public static final AuthInfo defaultInstance;
            public static final long serialVersionUID = 0;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public byte memoizedIsInitialized;
            public int memoizedSerializedSize;
            public Object token_;

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<AuthInfo, Builder> implements AuthInfoOrBuilder {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int bitField0_;
                public Object token_;

                public Builder() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.token_ = "";
                    maybeForceBuilderInitialization();
                }

                public static Builder create() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
                }

                private void maybeForceBuilderInitialization() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                    }
                }

                public Builder clearToken() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                        this.bitField0_ &= -2;
                        this.token_ = AuthInfo.getDefaultInstance().getToken();
                        return this;
                    }
                    return (Builder) invokeV.objValue;
                }

                @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
                public String getToken() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                        Object obj = this.token_;
                        if (!(obj instanceof String)) {
                            String stringUtf8 = ((ByteString) obj).toStringUtf8();
                            this.token_ = stringUtf8;
                            return stringUtf8;
                        }
                        return (String) obj;
                    }
                    return (String) invokeV.objValue;
                }

                @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
                public ByteString getTokenBytes() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                        Object obj = this.token_;
                        if (obj instanceof String) {
                            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                            this.token_ = copyFromUtf8;
                            return copyFromUtf8;
                        }
                        return (ByteString) obj;
                    }
                    return (ByteString) invokeV.objValue;
                }

                @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
                public boolean hasToken() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                public Builder setToken(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                        if (str != null) {
                            this.bitField0_ |= 1;
                            this.token_ = str;
                            return this;
                        }
                        throw null;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder setTokenBytes(ByteString byteString) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, byteString)) == null) {
                        if (byteString != null) {
                            this.bitField0_ |= 1;
                            this.token_ = byteString;
                            return this;
                        }
                        throw null;
                    }
                    return (Builder) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                public AuthInfo build() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        AuthInfo buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                    }
                    return (AuthInfo) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                public AuthInfo buildPartial() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        AuthInfo authInfo = new AuthInfo(this, (AnonymousClass1) null);
                        int i2 = (this.bitField0_ & 1) != 1 ? 0 : 1;
                        authInfo.token_ = this.token_;
                        authInfo.bitField0_ = i2;
                        return authInfo;
                    }
                    return (AuthInfo) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public Builder clear() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                        super.clear();
                        this.token_ = "";
                        this.bitField0_ &= -2;
                        return this;
                    }
                    return (Builder) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public AuthInfo getDefaultInstanceForType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? AuthInfo.getDefaultInstance() : (AuthInfo) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(AuthInfo authInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, authInfo)) == null) {
                        if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                            this.bitField0_ |= 1;
                            this.token_ = authInfo.token_;
                        }
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public Builder clone() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    InterceptResult invokeLL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (authInfo != null) {
                                mergeFrom(authInfo);
                            }
                            throw th;
                        }
                    }
                    return (Builder) invokeLL.objValue;
                }
            }

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1511444117, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb$LogRequest$AuthInfo;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1511444117, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb$LogRequest$AuthInfo;");
                        return;
                    }
                }
                PARSER = new AbstractParser<AuthInfo>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfo.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.Parser
                    public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new AuthInfo(codedInputStream, extensionRegistryLite, null) : (AuthInfo) invokeLL.objValue;
                    }
                };
                AuthInfo authInfo = new AuthInfo(true);
                defaultInstance = authInfo;
                authInfo.initFields();
            }

            public /* synthetic */ AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            public static AuthInfo getDefaultInstance() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? defaultInstance : (AuthInfo) invokeV.objValue;
            }

            private void initFields() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65546, this) == null) {
                    this.token_ = "";
                }
            }

            public static Builder newBuilder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
            }

            public static AuthInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (AuthInfo) invokeL.objValue;
            }

            public static AuthInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (AuthInfo) invokeL.objValue;
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<AuthInfo> getParserForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PARSER : (Parser) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    int i2 = this.memoizedSerializedSize;
                    if (i2 != -1) {
                        return i2;
                    }
                    int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
                    this.memoizedSerializedSize = computeBytesSize;
                    return computeBytesSize;
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
            public String getToken() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
            public ByteString getTokenBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    Object obj = this.token_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.token_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.AuthInfoOrBuilder
            public boolean hasToken() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    byte b2 = this.memoizedIsInitialized;
                    if (b2 != -1) {
                        return b2 == 1;
                    }
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? super.writeReplace() : invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048589, this, codedOutputStream) == null) {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.writeBytes(1, getTokenBytes());
                    }
                }
            }

            public /* synthetic */ AuthInfo(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public static Builder newBuilder(AuthInfo authInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, authInfo)) == null) ? newBuilder().mergeFrom(authInfo) : (Builder) invokeL.objValue;
            }

            public static AuthInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (AuthInfo) invokeLL.objValue;
            }

            public static AuthInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (AuthInfo) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            public AuthInfo getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (AuthInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public Builder newBuilderForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public Builder toBuilder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuthInfo(GeneratedMessageLite.Builder builder) {
                super(builder);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {builder};
                    interceptable.invokeUnInit(65539, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65539, newInitContext);
                        return;
                    }
                }
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static AuthInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (AuthInfo) invokeL.objValue;
            }

            public static AuthInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (AuthInfo) invokeLL.objValue;
            }

            public static AuthInfo parseFrom(InputStream inputStream) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (AuthInfo) invokeL.objValue;
            }

            public AuthInfo(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65541, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65541, newInitContext);
                        return;
                    }
                }
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static AuthInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (AuthInfo) invokeLL.objValue;
            }

            public static AuthInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (AuthInfo) invokeL.objValue;
            }

            public static AuthInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (AuthInfo) invokeLL.objValue;
            }

            public AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {codedInputStream, extensionRegistryLite};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
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

        /* loaded from: classes3.dex */
        public interface AuthInfoOrBuilder extends MessageLiteOrBuilder {
            String getToken();

            ByteString getTokenBytes();

            boolean hasToken();
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LogRequest, Builder> implements LogRequestOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public AuthInfo authInfo_;
            public int bitField0_;
            public ByteString payload_;
            public long requestTimestampMs_;
            public Object serviceName_;
            public Object sign_;
            public long version_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.serviceName_ = "";
                this.authInfo_ = AuthInfo.getDefaultInstance();
                this.sign_ = "";
                this.payload_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAuthInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.authInfo_ = AuthInfo.getDefaultInstance();
                    this.bitField0_ &= -5;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearPayload() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -33;
                    this.payload_ = LogRequest.getDefaultInstance().getPayload();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRequestTimestampMs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -9;
                    this.requestTimestampMs_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearServiceName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -3;
                    this.serviceName_ = LogRequest.getDefaultInstance().getServiceName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearSign() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -17;
                    this.sign_ = LogRequest.getDefaultInstance().getSign();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -2;
                    this.version_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public AuthInfo getAuthInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.authInfo_ : (AuthInfo) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public ByteString getPayload() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.payload_ : (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public long getRequestTimestampMs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.requestTimestampMs_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public String getServiceName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    Object obj = this.serviceName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.serviceName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public ByteString getServiceNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.serviceName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.serviceName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public String getSign() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.sign_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.sign_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public ByteString getSignBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    Object obj = this.sign_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.sign_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public long getVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.version_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasAuthInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasPayload() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasRequestTimestampMs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasServiceName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasSign() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
            public boolean hasVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder mergeAuthInfo(AuthInfo authInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, authInfo)) == null) {
                    if ((this.bitField0_ & 4) == 4 && this.authInfo_ != AuthInfo.getDefaultInstance()) {
                        this.authInfo_ = AuthInfo.newBuilder(this.authInfo_).mergeFrom(authInfo).buildPartial();
                    } else {
                        this.authInfo_ = authInfo;
                    }
                    this.bitField0_ |= 4;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAuthInfo(AuthInfo authInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, authInfo)) == null) {
                    if (authInfo != null) {
                        this.authInfo_ = authInfo;
                        this.bitField0_ |= 4;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPayload(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 32;
                        this.payload_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRequestTimestampMs(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048621, this, j2)) == null) {
                    this.bitField0_ |= 8;
                    this.requestTimestampMs_ = j2;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setServiceName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.serviceName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setServiceNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.serviceName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setSign(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 16;
                        this.sign_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setSignBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 16;
                        this.sign_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setVersion(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048626, this, j2)) == null) {
                    this.bitField0_ |= 1;
                    this.version_ = j2;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogRequest build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    LogRequest buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (LogRequest) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogRequest buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    LogRequest logRequest = new LogRequest(this, (AnonymousClass1) null);
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
                return (LogRequest) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogRequest getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? LogRequest.getDefaultInstance() : (LogRequest) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(LogRequest logRequest) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, logRequest)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            public Builder setAuthInfo(AuthInfo.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, builder)) == null) {
                    this.authInfo_ = builder.build();
                    this.bitField0_ |= 4;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (logRequest != null) {
                            mergeFrom(logRequest);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(82954215, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb$LogRequest;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(82954215, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb$LogRequest;");
                    return;
                }
            }
            PARSER = new AbstractParser<LogRequest>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequest.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LogRequest(codedInputStream, extensionRegistryLite, null) : (LogRequest) invokeLL.objValue;
                }
            };
            LogRequest logRequest = new LogRequest(true);
            defaultInstance = logRequest;
            logRequest.initFields();
        }

        public /* synthetic */ LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static LogRequest getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? defaultInstance : (LogRequest) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.version_ = 0L;
                this.serviceName_ = "";
                this.authInfo_ = AuthInfo.getDefaultInstance();
                this.requestTimestampMs_ = 0L;
                this.sign_ = "";
                this.payload_ = ByteString.EMPTY;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LogRequest) invokeL.objValue;
        }

        public static LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LogRequest) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public AuthInfo getAuthInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.authInfo_ : (AuthInfo) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogRequest> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public ByteString getPayload() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.payload_ : (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public long getRequestTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.requestTimestampMs_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public String getServiceName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public ByteString getServiceNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Object obj = this.serviceName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serviceName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public String getSign() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public ByteString getSignBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object obj = this.sign_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sign_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public long getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.version_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasAuthInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasPayload() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasRequestTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasServiceName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasSign() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogRequestOrBuilder
        public boolean hasVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
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

        public /* synthetic */ LogRequest(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(LogRequest logRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, logRequest)) == null) ? newBuilder().mergeFrom(logRequest) : (Builder) invokeL.objValue;
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LogRequest) invokeLL.objValue;
        }

        public static LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LogRequest) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogRequest getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (LogRequest) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LogRequest(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LogRequest) invokeL.objValue;
        }

        public static LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LogRequest) invokeLL.objValue;
        }

        public static LogRequest parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LogRequest) invokeL.objValue;
        }

        public LogRequest(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65541, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LogRequest) invokeLL.objValue;
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LogRequest) invokeL.objValue;
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LogRequest) invokeLL.objValue;
        }

        public LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static final class LogResponse extends GeneratedMessageLite implements LogResponseOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        public static final int ERROR_MSG_FIELD_NUMBER = 2;
        public static Parser<LogResponse> PARSER = null;
        public static final int PING_INTERVAL_MS_FIELD_NUMBER = 3;
        public static final LogResponse defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitField0_;
        public int errorCode_;
        public Object errorMsg_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long pingIntervalMs_;

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LogResponse, Builder> implements LogResponseOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public int errorCode_;
            public Object errorMsg_;
            public long pingIntervalMs_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.errorMsg_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -2;
                    this.errorCode_ = 0;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearErrorMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -3;
                    this.errorMsg_ = LogResponse.getDefaultInstance().getErrorMsg();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearPingIntervalMs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -5;
                    this.pingIntervalMs_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public int getErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.errorCode_ : invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public String getErrorMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    Object obj = this.errorMsg_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.errorMsg_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public ByteString getErrorMsgBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.errorMsg_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.errorMsg_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public long getPingIntervalMs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.pingIntervalMs_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public boolean hasErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public boolean hasErrorMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
            public boolean hasPingIntervalMs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setErrorCode(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
                    this.bitField0_ |= 1;
                    this.errorCode_ = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setErrorMsg(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.errorMsg_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setErrorMsgBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.errorMsg_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPingIntervalMs(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j2)) == null) {
                    this.bitField0_ |= 4;
                    this.pingIntervalMs_ = j2;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogResponse build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    LogResponse buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (LogResponse) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LogResponse buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    LogResponse logResponse = new LogResponse(this, (AnonymousClass1) null);
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
                return (LogResponse) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogResponse getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? LogResponse.getDefaultInstance() : (LogResponse) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(LogResponse logResponse) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, logResponse)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (logResponse != null) {
                            mergeFrom(logResponse);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-82438369, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb$LogResponse;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-82438369, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb$LogResponse;");
                    return;
                }
            }
            PARSER = new AbstractParser<LogResponse>() { // from class: com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponse.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LogResponse(codedInputStream, extensionRegistryLite, null) : (LogResponse) invokeLL.objValue;
                }
            };
            LogResponse logResponse = new LogResponse(true);
            defaultInstance = logResponse;
            logResponse.initFields();
        }

        public /* synthetic */ LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static LogResponse getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? defaultInstance : (LogResponse) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.errorCode_ = 0;
                this.errorMsg_ = "";
                this.pingIntervalMs_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LogResponse) invokeL.objValue;
        }

        public static LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LogResponse) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public int getErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.errorCode_ : invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public String getErrorMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public ByteString getErrorMsgBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.errorMsg_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.errorMsg_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogResponse> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public long getPingIntervalMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pingIntervalMs_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public boolean hasErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public boolean hasErrorMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.logpb.BIMLogPb.LogResponseOrBuilder
        public boolean hasPingIntervalMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ LogResponse(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(LogResponse logResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, logResponse)) == null) ? newBuilder().mergeFrom(logResponse) : (Builder) invokeL.objValue;
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LogResponse) invokeLL.objValue;
        }

        public static LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LogResponse) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogResponse getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (LogResponse) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LogResponse(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LogResponse) invokeL.objValue;
        }

        public static LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LogResponse) invokeLL.objValue;
        }

        public static LogResponse parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LogResponse) invokeL.objValue;
        }

        public LogResponse(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65541, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LogResponse) invokeLL.objValue;
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LogResponse) invokeL.objValue;
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LogResponse) invokeLL.objValue;
        }

        public LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
    public interface LogResponseOrBuilder extends MessageLiteOrBuilder {
        int getErrorCode();

        String getErrorMsg();

        ByteString getErrorMsgBytes();

        long getPingIntervalMs();

        boolean hasErrorCode();

        boolean hasErrorMsg();

        boolean hasPingIntervalMs();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-69137568, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-69137568, "Lcom/baidu/android/imsdk/upload/action/logpb/BIMLogPb;");
        }
    }

    public BIMLogPb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, extensionRegistryLite) == null) {
        }
    }
}
