package com.baidu.swan.facade.requred.openstat.imupload.log.model;

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
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.repackage.rn3;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class Bimlog$LogRequest extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_INFO_FIELD_NUMBER = 3;
    public static Parser<Bimlog$LogRequest> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 6;
    public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
    public static final int SERVICE_NAME_FIELD_NUMBER = 2;
    public static final int SIGN_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final Bimlog$LogRequest defaultInstance;
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
    public static final class AuthInfo extends GeneratedMessageLite implements MessageLiteOrBuilder {
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
        public static class a extends AbstractParser<AuthInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: b */
            public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new AuthInfo(codedInputStream, extensionRegistryLite, null) : (AuthInfo) invokeLL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.Builder<AuthInfo, b> implements Object {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public Object b;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = "";
                maybeForceBuilderInitialization();
            }

            public static b q() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
                o();
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: m */
            public AuthInfo build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    AuthInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (AuthInfo) invokeV.objValue;
            }

            public final void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                }
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
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    AuthInfo authInfo = new AuthInfo(this, (rn3) null);
                    int i = (this.a & 1) != 1 ? 0 : 1;
                    authInfo.token_ = this.b;
                    authInfo.bitField0_ = i;
                    return authInfo;
                }
                return (AuthInfo) invokeV.objValue;
            }

            public b o() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    super.clear();
                    this.b = "";
                    this.a &= -2;
                    return this;
                }
                return (b) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: p */
            public b clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    b q = q();
                    q.s(buildPartial());
                    return q;
                }
                return (b) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: r */
            public AuthInfo getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? AuthInfo.getDefaultInstance() : (AuthInfo) invokeV.objValue;
            }

            public b s(AuthInfo authInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, authInfo)) == null) {
                    if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                        this.a |= 1;
                        this.b = authInfo.token_;
                    }
                    return this;
                }
                return (b) invokeL.objValue;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, codedInputStream, extensionRegistryLite)) == null) {
                    AuthInfo authInfo = null;
                    try {
                        try {
                            AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                s(parsePartialFrom);
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (authInfo != null) {
                            s(authInfo);
                        }
                        throw th;
                    }
                }
                return (b) invokeLL.objValue;
            }

            public b u(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.b = str;
                        return this;
                    }
                    throw null;
                }
                return (b) invokeL.objValue;
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
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(74279886, "Lcom/baidu/swan/facade/requred/openstat/imupload/log/model/Bimlog$LogRequest$AuthInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(74279886, "Lcom/baidu/swan/facade/requred/openstat/imupload/log/model/Bimlog$LogRequest$AuthInfo;");
                    return;
                }
            }
            PARSER = new a();
            AuthInfo authInfo = new AuthInfo(true);
            defaultInstance = authInfo;
            authInfo.initFields();
        }

        public /* synthetic */ AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, rn3 rn3Var) throws InvalidProtocolBufferException {
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

        public static b newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? b.q() : (b) invokeV.objValue;
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
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
                this.memoizedSerializedSize = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

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

        public /* synthetic */ AuthInfo(GeneratedMessageLite.Builder builder, rn3 rn3Var) {
            this(builder);
        }

        public static b newBuilder(AuthInfo authInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, authInfo)) == null) {
                b newBuilder = newBuilder();
                newBuilder.s(authInfo);
                return newBuilder;
            }
            return (b) invokeL.objValue;
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
        public b newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? newBuilder() : (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    }

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bimlog$LogRequest> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bimlog$LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Bimlog$LogRequest(codedInputStream, extensionRegistryLite, null) : (Bimlog$LogRequest) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bimlog$LogRequest, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public Object c;
        public AuthInfo d;
        public long e;
        public Object f;
        public ByteString g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = "";
            this.d = AuthInfo.getDefaultInstance();
            this.f = "";
            this.g = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        public static b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
        }

        public b A(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.a |= 1;
                this.b = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bimlog$LogRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Bimlog$LogRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (Bimlog$LogRequest) invokeV.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                Bimlog$LogRequest bimlog$LogRequest = new Bimlog$LogRequest(this, (rn3) null);
                int i = this.a;
                int i2 = (i & 1) != 1 ? 0 : 1;
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
            return (Bimlog$LogRequest) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                b q = q();
                q.t(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bimlog$LogRequest getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? Bimlog$LogRequest.getDefaultInstance() : (Bimlog$LogRequest) invokeV.objValue;
        }

        public b s(AuthInfo authInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, authInfo)) == null) {
                if ((this.a & 4) == 4 && this.d != AuthInfo.getDefaultInstance()) {
                    AuthInfo.b newBuilder = AuthInfo.newBuilder(this.d);
                    newBuilder.s(authInfo);
                    this.d = newBuilder.buildPartial();
                } else {
                    this.d = authInfo;
                }
                this.a |= 4;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b t(Bimlog$LogRequest bimlog$LogRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bimlog$LogRequest)) == null) {
                if (bimlog$LogRequest == Bimlog$LogRequest.getDefaultInstance()) {
                    return this;
                }
                if (bimlog$LogRequest.hasVersion()) {
                    A(bimlog$LogRequest.getVersion());
                }
                if (bimlog$LogRequest.hasServiceName()) {
                    this.a |= 2;
                    this.c = bimlog$LogRequest.serviceName_;
                }
                if (bimlog$LogRequest.hasAuthInfo()) {
                    s(bimlog$LogRequest.getAuthInfo());
                }
                if (bimlog$LogRequest.hasRequestTimestampMs()) {
                    x(bimlog$LogRequest.getRequestTimestampMs());
                }
                if (bimlog$LogRequest.hasSign()) {
                    this.a |= 16;
                    this.f = bimlog$LogRequest.sign_;
                }
                if (bimlog$LogRequest.hasPayload()) {
                    w(bimlog$LogRequest.getPayload());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, codedInputStream, extensionRegistryLite)) == null) {
                Bimlog$LogRequest bimlog$LogRequest = null;
                try {
                    try {
                        Bimlog$LogRequest parsePartialFrom = Bimlog$LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            t(parsePartialFrom);
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
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bimlog$LogRequest != null) {
                        t(bimlog$LogRequest);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b v(AuthInfo authInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, authInfo)) == null) {
                if (authInfo != null) {
                    this.d = authInfo;
                    this.a |= 4;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b w(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 32;
                    this.g = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b x(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048602, this, j)) == null) {
                this.a |= 8;
                this.e = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b y(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                if (str != null) {
                    this.a |= 2;
                    this.c = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b z(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                if (str != null) {
                    this.a |= 16;
                    this.f = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(911193742, "Lcom/baidu/swan/facade/requred/openstat/imupload/log/model/Bimlog$LogRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(911193742, "Lcom/baidu/swan/facade/requred/openstat/imupload/log/model/Bimlog$LogRequest;");
                return;
            }
        }
        PARSER = new a();
        Bimlog$LogRequest bimlog$LogRequest = new Bimlog$LogRequest(true);
        defaultInstance = bimlog$LogRequest;
        bimlog$LogRequest.initFields();
    }

    public /* synthetic */ Bimlog$LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, rn3 rn3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Bimlog$LogRequest getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? defaultInstance : (Bimlog$LogRequest) invokeV.objValue;
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

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static Bimlog$LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Bimlog$LogRequest) invokeL.objValue;
    }

    public static Bimlog$LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Bimlog$LogRequest) invokeL.objValue;
    }

    public AuthInfo getAuthInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.authInfo_ : (AuthInfo) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bimlog$LogRequest> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? PARSER : (Parser) invokeV.objValue;
    }

    public ByteString getPayload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.payload_ : (ByteString) invokeV.objValue;
    }

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
        return invokeV.intValue;
    }

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

    public long getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.version_ : invokeV.longValue;
    }

    public boolean hasAuthInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasPayload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
    }

    public boolean hasRequestTimestampMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
    }

    public boolean hasServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    public boolean hasSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
    }

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

    public /* synthetic */ Bimlog$LogRequest(GeneratedMessageLite.Builder builder, rn3 rn3Var) {
        this(builder);
    }

    public static b newBuilder(Bimlog$LogRequest bimlog$LogRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bimlog$LogRequest)) == null) {
            b newBuilder = newBuilder();
            newBuilder.t(bimlog$LogRequest);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static Bimlog$LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Bimlog$LogRequest) invokeLL.objValue;
    }

    public static Bimlog$LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Bimlog$LogRequest) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bimlog$LogRequest getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Bimlog$LogRequest) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bimlog$LogRequest(GeneratedMessageLite.Builder builder) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Bimlog$LogRequest) invokeL.objValue;
    }

    public static Bimlog$LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Bimlog$LogRequest) invokeLL.objValue;
    }

    public static Bimlog$LogRequest parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Bimlog$LogRequest) invokeL.objValue;
    }

    public Bimlog$LogRequest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bimlog$LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Bimlog$LogRequest) invokeLL.objValue;
    }

    public static Bimlog$LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Bimlog$LogRequest) invokeL.objValue;
    }

    public static Bimlog$LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Bimlog$LogRequest) invokeLL.objValue;
    }

    public Bimlog$LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {codedInputStream, extensionRegistryLite};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
}
