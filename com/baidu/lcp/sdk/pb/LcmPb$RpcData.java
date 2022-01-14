package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
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
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class a extends AbstractParser<LcmPb$RpcData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LcmPb$RpcData(codedInputStream, extensionRegistryLite, null) : (LcmPb$RpcData) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$RpcData, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f34645e;

        /* renamed from: f  reason: collision with root package name */
        public LcmPb$LcmRequest f34646f;

        /* renamed from: g  reason: collision with root package name */
        public LcmPb$LcmResponse f34647g;

        /* renamed from: h  reason: collision with root package name */
        public LcmPb$LcmNotify f34648h;

        public b() {
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
            this.f34646f = LcmPb$LcmRequest.getDefaultInstance();
            this.f34647g = LcmPb$LcmResponse.getDefaultInstance();
            this.f34648h = LcmPb$LcmNotify.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        public static b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
        }

        public b A(LcmPb$LcmNotify lcmPb$LcmNotify) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lcmPb$LcmNotify)) == null) {
                if ((this.f34645e & 4) == 4 && this.f34648h != LcmPb$LcmNotify.getDefaultInstance()) {
                    LcmPb$LcmNotify.b newBuilder = LcmPb$LcmNotify.newBuilder(this.f34648h);
                    newBuilder.t(lcmPb$LcmNotify);
                    this.f34648h = newBuilder.buildPartial();
                } else {
                    this.f34648h = lcmPb$LcmNotify;
                }
                this.f34645e |= 4;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b B(LcmPb$LcmRequest lcmPb$LcmRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lcmPb$LcmRequest)) == null) {
                if ((this.f34645e & 1) == 1 && this.f34646f != LcmPb$LcmRequest.getDefaultInstance()) {
                    LcmPb$LcmRequest.b newBuilder = LcmPb$LcmRequest.newBuilder(this.f34646f);
                    newBuilder.u(lcmPb$LcmRequest);
                    this.f34646f = newBuilder.buildPartial();
                } else {
                    this.f34646f = lcmPb$LcmRequest;
                }
                this.f34645e |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b C(LcmPb$LcmResponse lcmPb$LcmResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lcmPb$LcmResponse)) == null) {
                if ((this.f34645e & 2) == 2 && this.f34647g != LcmPb$LcmResponse.getDefaultInstance()) {
                    LcmPb$LcmResponse.b newBuilder = LcmPb$LcmResponse.newBuilder(this.f34647g);
                    newBuilder.t(lcmPb$LcmResponse);
                    this.f34647g = newBuilder.buildPartial();
                } else {
                    this.f34647g = lcmPb$LcmResponse;
                }
                this.f34645e |= 2;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b D(LcmPb$LcmNotify lcmPb$LcmNotify) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lcmPb$LcmNotify)) == null) {
                if (lcmPb$LcmNotify != null) {
                    this.f34648h = lcmPb$LcmNotify;
                    this.f34645e |= 4;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b E(LcmPb$LcmRequest lcmPb$LcmRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lcmPb$LcmRequest)) == null) {
                if (lcmPb$LcmRequest != null) {
                    this.f34646f = lcmPb$LcmRequest;
                    this.f34645e |= 1;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (!w() || t().isInitialized()) {
                    if (!x() || u().isInitialized()) {
                        return !v() || s().isInitialized();
                    }
                    return false;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$RpcData build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                LcmPb$RpcData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (LcmPb$RpcData) invokeV.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public LcmPb$RpcData buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData(this, (c.a.u.a.e.a) null);
                int i2 = this.f34645e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lcmPb$RpcData.lcmRequest_ = this.f34646f;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lcmPb$RpcData.lcmResponse_ = this.f34647g;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lcmPb$RpcData.lcmNotify_ = this.f34648h;
                lcmPb$RpcData.bitField0_ = i3;
                return lcmPb$RpcData;
            }
            return (LcmPb$RpcData) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                super.clear();
                this.f34646f = LcmPb$LcmRequest.getDefaultInstance();
                this.f34645e &= -2;
                this.f34647g = LcmPb$LcmResponse.getDefaultInstance();
                this.f34645e &= -3;
                this.f34648h = LcmPb$LcmNotify.getDefaultInstance();
                this.f34645e &= -5;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                b q = q();
                q.y(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$RpcData getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? LcmPb$RpcData.getDefaultInstance() : (LcmPb$RpcData) invokeV.objValue;
        }

        public LcmPb$LcmNotify s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f34648h : (LcmPb$LcmNotify) invokeV.objValue;
        }

        public LcmPb$LcmRequest t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f34646f : (LcmPb$LcmRequest) invokeV.objValue;
        }

        public LcmPb$LcmResponse u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f34647g : (LcmPb$LcmResponse) invokeV.objValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.f34645e & 4) == 4 : invokeV.booleanValue;
        }

        public boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f34645e & 1) == 1 : invokeV.booleanValue;
        }

        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.f34645e & 2) == 2 : invokeV.booleanValue;
        }

        public b y(LcmPb$RpcData lcmPb$RpcData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, lcmPb$RpcData)) == null) {
                if (lcmPb$RpcData == LcmPb$RpcData.getDefaultInstance()) {
                    return this;
                }
                if (lcmPb$RpcData.hasLcmRequest()) {
                    B(lcmPb$RpcData.getLcmRequest());
                }
                if (lcmPb$RpcData.hasLcmResponse()) {
                    C(lcmPb$RpcData.getLcmResponse());
                }
                if (lcmPb$RpcData.hasLcmNotify()) {
                    A(lcmPb$RpcData.getLcmNotify());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b z(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, codedInputStream, extensionRegistryLite)) == null) {
                LcmPb$RpcData lcmPb$RpcData = null;
                try {
                    try {
                        LcmPb$RpcData parsePartialFrom = LcmPb$RpcData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            y(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        LcmPb$RpcData lcmPb$RpcData2 = (LcmPb$RpcData) e2.getUnfinishedMessage();
                        try {
                            throw e2;
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
                        y(lcmPb$RpcData);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$RpcData lcmPb$RpcData) {
            y(lcmPb$RpcData);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
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

    public /* synthetic */ LcmPb$RpcData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, c.a.u.a.e.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static LcmPb$RpcData getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? defaultInstance : (LcmPb$RpcData) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LcmPb$RpcData) invokeL.objValue;
    }

    public LcmPb$LcmNotify getLcmNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.lcmNotify_ : (LcmPb$LcmNotify) invokeV.objValue;
    }

    public LcmPb$LcmRequest getLcmRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lcmRequest_ : (LcmPb$LcmRequest) invokeV.objValue;
    }

    public LcmPb$LcmResponse getLcmResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lcmResponse_ : (LcmPb$LcmResponse) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$RpcData> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PARSER : (Parser) invokeV.objValue;
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
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.lcmRequest_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.lcmResponse_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.lcmNotify_);
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }
        return invokeV.intValue;
    }

    public boolean hasLcmNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasLcmRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    public boolean hasLcmResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.writeReplace() : invokeV.objValue;
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

    public /* synthetic */ LcmPb$RpcData(GeneratedMessageLite.Builder builder, c.a.u.a.e.a aVar) {
        this(builder);
    }

    public static b newBuilder(LcmPb$RpcData lcmPb$RpcData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, lcmPb$RpcData)) == null) {
            b newBuilder = newBuilder();
            newBuilder.y(lcmPb$RpcData);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LcmPb$RpcData) invokeLL.objValue;
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LcmPb$RpcData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$RpcData getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (LcmPb$RpcData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
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

    public static LcmPb$RpcData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LcmPb$RpcData) invokeLL.objValue;
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LcmPb$RpcData) invokeL.objValue;
    }

    public LcmPb$RpcData(boolean z) {
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

    public static LcmPb$RpcData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LcmPb$RpcData) invokeLL.objValue;
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LcmPb$RpcData) invokeL.objValue;
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LcmPb$RpcData) invokeLL.objValue;
    }

    public LcmPb$RpcData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            LcmPb$LcmRequest.b builder = (this.bitField0_ & 1) == 1 ? this.lcmRequest_.toBuilder() : null;
                            LcmPb$LcmRequest lcmPb$LcmRequest = (LcmPb$LcmRequest) codedInputStream.readMessage(LcmPb$LcmRequest.PARSER, extensionRegistryLite);
                            this.lcmRequest_ = lcmPb$LcmRequest;
                            if (builder != null) {
                                builder.u(lcmPb$LcmRequest);
                                this.lcmRequest_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                        } else if (readTag == 18) {
                            LcmPb$LcmResponse.b builder2 = (this.bitField0_ & 2) == 2 ? this.lcmResponse_.toBuilder() : null;
                            LcmPb$LcmResponse lcmPb$LcmResponse = (LcmPb$LcmResponse) codedInputStream.readMessage(LcmPb$LcmResponse.PARSER, extensionRegistryLite);
                            this.lcmResponse_ = lcmPb$LcmResponse;
                            if (builder2 != null) {
                                builder2.t(lcmPb$LcmResponse);
                                this.lcmResponse_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (readTag != 26) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            LcmPb$LcmNotify.b builder3 = (this.bitField0_ & 4) == 4 ? this.lcmNotify_.toBuilder() : null;
                            LcmPb$LcmNotify lcmPb$LcmNotify = (LcmPb$LcmNotify) codedInputStream.readMessage(LcmPb$LcmNotify.PARSER, extensionRegistryLite);
                            this.lcmNotify_ = lcmPb$LcmNotify;
                            if (builder3 != null) {
                                builder3.t(lcmPb$LcmNotify);
                                this.lcmNotify_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 4;
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
