package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.tieba.ga0;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class LcmPb$RpcData extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LCM_NOTIFY_FIELD_NUMBER = 3;
    public static final int LCM_REQUEST_FIELD_NUMBER = 1;
    public static final int LCM_RESPONSE_FIELD_NUMBER = 2;
    public static Parser<LcmPb$RpcData> PARSER;
    public static final LcmPb$RpcData defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public LcmPb$LcmNotify lcmNotify_;
    public LcmPb$LcmRequest lcmRequest_;
    public LcmPb$LcmResponse lcmResponse_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<LcmPb$RpcData> {
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
        public LcmPb$RpcData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new LcmPb$RpcData(codedInputStream, extensionRegistryLite, null);
            }
            return (LcmPb$RpcData) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$RpcData, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public LcmPb$LcmRequest b;
        public LcmPb$LcmResponse c;
        public LcmPb$LcmNotify d;

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            }
        }

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
            this.b = LcmPb$LcmRequest.getDefaultInstance();
            this.c = LcmPb$LcmResponse.getDefaultInstance();
            this.d = LcmPb$LcmNotify.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$RpcData buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData(this, (ga0) null);
                int i = this.a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                lcmPb$RpcData.lcmRequest_ = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lcmPb$RpcData.lcmResponse_ = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                lcmPb$RpcData.lcmNotify_ = this.d;
                lcmPb$RpcData.bitField0_ = i2;
                return lcmPb$RpcData;
            }
            return (LcmPb$RpcData) invokeV.objValue;
        }

        public b n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                super.clear();
                this.b = LcmPb$LcmRequest.getDefaultInstance();
                this.a &= -2;
                this.c = LcmPb$LcmResponse.getDefaultInstance();
                this.a &= -3;
                this.d = LcmPb$LcmNotify.getDefaultInstance();
                this.a &= -5;
                return this;
            }
            return (b) invokeV.objValue;
        }

        public static /* synthetic */ b k() {
            return p();
        }

        public static b p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return new b();
            }
            return (b) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            n();
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public LcmPb$RpcData build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                LcmPb$RpcData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (LcmPb$RpcData) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                b p = p();
                p.x(buildPartial());
                return p;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public LcmPb$RpcData getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return LcmPb$RpcData.getDefaultInstance();
            }
            return (LcmPb$RpcData) invokeV.objValue;
        }

        public LcmPb$LcmNotify r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.d;
            }
            return (LcmPb$LcmNotify) invokeV.objValue;
        }

        public LcmPb$LcmRequest s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.b;
            }
            return (LcmPb$LcmRequest) invokeV.objValue;
        }

        public LcmPb$LcmResponse t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.c;
            }
            return (LcmPb$LcmResponse) invokeV.objValue;
        }

        public boolean u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                if ((this.a & 4) == 4) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                if ((this.a & 1) == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                if ((this.a & 2) == 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public b A(LcmPb$LcmRequest lcmPb$LcmRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lcmPb$LcmRequest)) == null) {
                if ((this.a & 1) == 1 && this.b != LcmPb$LcmRequest.getDefaultInstance()) {
                    LcmPb$LcmRequest.b newBuilder = LcmPb$LcmRequest.newBuilder(this.b);
                    newBuilder.t(lcmPb$LcmRequest);
                    this.b = newBuilder.buildPartial();
                } else {
                    this.b = lcmPb$LcmRequest;
                }
                this.a |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b B(LcmPb$LcmResponse lcmPb$LcmResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lcmPb$LcmResponse)) == null) {
                if ((this.a & 2) == 2 && this.c != LcmPb$LcmResponse.getDefaultInstance()) {
                    LcmPb$LcmResponse.b newBuilder = LcmPb$LcmResponse.newBuilder(this.c);
                    newBuilder.s(lcmPb$LcmResponse);
                    this.c = newBuilder.buildPartial();
                } else {
                    this.c = lcmPb$LcmResponse;
                }
                this.a |= 2;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b x(LcmPb$RpcData lcmPb$RpcData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, lcmPb$RpcData)) == null) {
                if (lcmPb$RpcData == LcmPb$RpcData.getDefaultInstance()) {
                    return this;
                }
                if (lcmPb$RpcData.hasLcmRequest()) {
                    A(lcmPb$RpcData.getLcmRequest());
                }
                if (lcmPb$RpcData.hasLcmResponse()) {
                    B(lcmPb$RpcData.getLcmResponse());
                }
                if (lcmPb$RpcData.hasLcmNotify()) {
                    z(lcmPb$RpcData.getLcmNotify());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b z(LcmPb$LcmNotify lcmPb$LcmNotify) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, lcmPb$LcmNotify)) == null) {
                if ((this.a & 4) == 4 && this.d != LcmPb$LcmNotify.getDefaultInstance()) {
                    LcmPb$LcmNotify.b newBuilder = LcmPb$LcmNotify.newBuilder(this.d);
                    newBuilder.s(lcmPb$LcmNotify);
                    this.d = newBuilder.buildPartial();
                } else {
                    this.d = lcmPb$LcmNotify;
                }
                this.a |= 4;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b C(LcmPb$LcmNotify lcmPb$LcmNotify) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lcmPb$LcmNotify)) == null) {
                if (lcmPb$LcmNotify != null) {
                    this.d = lcmPb$LcmNotify;
                    this.a |= 4;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b D(LcmPb$LcmRequest lcmPb$LcmRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lcmPb$LcmRequest)) == null) {
                if (lcmPb$LcmRequest != null) {
                    this.b = lcmPb$LcmRequest;
                    this.a |= 1;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$RpcData lcmPb$RpcData) {
            x(lcmPb$RpcData);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (v() && !s().isInitialized()) {
                    return false;
                }
                if (w() && !t().isInitialized()) {
                    return false;
                }
                if (u() && !r().isInitialized()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            y(codedInputStream, extensionRegistryLite);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            y(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, codedInputStream, extensionRegistryLite)) == null) {
                LcmPb$RpcData lcmPb$RpcData = null;
                try {
                    try {
                        LcmPb$RpcData parsePartialFrom = LcmPb$RpcData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            x(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        LcmPb$RpcData lcmPb$RpcData2 = (LcmPb$RpcData) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            lcmPb$RpcData = lcmPb$RpcData2;
                            if (lcmPb$RpcData != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lcmPb$RpcData != null) {
                        x(lcmPb$RpcData);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1906745868, "Lcom/baidu/lcp/sdk/pb/LcmPb$RpcData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1906745868, "Lcom/baidu/lcp/sdk/pb/LcmPb$RpcData;");
                return;
            }
        }
        PARSER = new a();
        LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData(true);
        defaultInstance = lcmPb$RpcData;
        lcmPb$RpcData.initFields();
    }

    public static LcmPb$RpcData getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return defaultInstance;
        }
        return (LcmPb$RpcData) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.lcmRequest_ = LcmPb$LcmRequest.getDefaultInstance();
            this.lcmResponse_ = LcmPb$LcmResponse.getDefaultInstance();
            this.lcmNotify_ = LcmPb$LcmNotify.getDefaultInstance();
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return b.k();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$RpcData getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return defaultInstance;
        }
        return (LcmPb$RpcData) invokeV.objValue;
    }

    public LcmPb$LcmNotify getLcmNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.lcmNotify_;
        }
        return (LcmPb$LcmNotify) invokeV.objValue;
    }

    public LcmPb$LcmRequest getLcmRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.lcmRequest_;
        }
        return (LcmPb$LcmRequest) invokeV.objValue;
    }

    public LcmPb$LcmResponse getLcmResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.lcmResponse_;
        }
        return (LcmPb$LcmResponse) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$RpcData> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public boolean hasLcmNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasLcmRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasLcmResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    public LcmPb$RpcData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag != 10) {
                            if (readTag != 18) {
                                if (readTag != 26) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    LcmPb$LcmNotify.b builder = (this.bitField0_ & 4) == 4 ? this.lcmNotify_.toBuilder() : null;
                                    LcmPb$LcmNotify lcmPb$LcmNotify = (LcmPb$LcmNotify) codedInputStream.readMessage(LcmPb$LcmNotify.PARSER, extensionRegistryLite);
                                    this.lcmNotify_ = lcmPb$LcmNotify;
                                    if (builder != null) {
                                        builder.s(lcmPb$LcmNotify);
                                        this.lcmNotify_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                }
                            } else {
                                LcmPb$LcmResponse.b builder2 = (this.bitField0_ & 2) == 2 ? this.lcmResponse_.toBuilder() : null;
                                LcmPb$LcmResponse lcmPb$LcmResponse = (LcmPb$LcmResponse) codedInputStream.readMessage(LcmPb$LcmResponse.PARSER, extensionRegistryLite);
                                this.lcmResponse_ = lcmPb$LcmResponse;
                                if (builder2 != null) {
                                    builder2.s(lcmPb$LcmResponse);
                                    this.lcmResponse_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            }
                        } else {
                            LcmPb$LcmRequest.b builder3 = (this.bitField0_ & 1) == 1 ? this.lcmRequest_.toBuilder() : null;
                            LcmPb$LcmRequest lcmPb$LcmRequest = (LcmPb$LcmRequest) codedInputStream.readMessage(LcmPb$LcmRequest.PARSER, extensionRegistryLite);
                            this.lcmRequest_ = lcmPb$LcmRequest;
                            if (builder3 != null) {
                                builder3.t(lcmPb$LcmRequest);
                                this.lcmRequest_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 1;
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

    public /* synthetic */ LcmPb$RpcData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ga0 ga0Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LcmPb$RpcData(GeneratedMessageLite.Builder builder) {
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

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.lcmRequest_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.lcmResponse_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.lcmNotify_);
            }
        }
    }

    public /* synthetic */ LcmPb$RpcData(GeneratedMessageLite.Builder builder, ga0 ga0Var) {
        this(builder);
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (LcmPb$RpcData) invokeLL.objValue;
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (LcmPb$RpcData) invokeLL.objValue;
    }

    public LcmPb$RpcData(boolean z) {
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

    public static b newBuilder(LcmPb$RpcData lcmPb$RpcData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, lcmPb$RpcData)) == null) {
            b newBuilder = newBuilder();
            newBuilder.x(lcmPb$RpcData);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (LcmPb$RpcData) invokeLL.objValue;
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (LcmPb$RpcData) invokeLL.objValue;
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (LcmPb$RpcData) invokeLL.objValue;
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
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, this.lcmRequest_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, this.lcmResponse_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeMessageSize(3, this.lcmNotify_);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                if (b2 == 1) {
                    return true;
                }
                return false;
            } else if (hasLcmRequest() && !getLcmRequest().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasLcmResponse() && !getLcmResponse().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasLcmNotify() && !getLcmNotify().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
