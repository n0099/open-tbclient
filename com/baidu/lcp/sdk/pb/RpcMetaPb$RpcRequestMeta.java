package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import c.a.u.a.e.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public final class RpcMetaPb$RpcRequestMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static final int NEED_COMMON_FIELD_NUMBER = 4;
    public static Parser<RpcMetaPb$RpcRequestMeta> PARSER = null;
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcRequestMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId_;
    public int needCommon_;
    public long serviceId_;

    /* loaded from: classes5.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcRequestMeta> {
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
        public RpcMetaPb$RpcRequestMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new RpcMetaPb$RpcRequestMeta(codedInputStream, extensionRegistryLite, null) : (RpcMetaPb$RpcRequestMeta) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcRequestMeta, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f40747e;

        /* renamed from: f  reason: collision with root package name */
        public long f40748f;

        /* renamed from: g  reason: collision with root package name */
        public long f40749g;

        /* renamed from: h  reason: collision with root package name */
        public long f40750h;

        /* renamed from: i  reason: collision with root package name */
        public int f40751i;

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
        public RpcMetaPb$RpcRequestMeta build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                RpcMetaPb$RpcRequestMeta buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
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
        public RpcMetaPb$RpcRequestMeta buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = new RpcMetaPb$RpcRequestMeta(this, (e) null);
                int i2 = this.f40747e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                rpcMetaPb$RpcRequestMeta.serviceId_ = this.f40748f;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                rpcMetaPb$RpcRequestMeta.methodId_ = this.f40749g;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                rpcMetaPb$RpcRequestMeta.logId_ = this.f40750h;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                rpcMetaPb$RpcRequestMeta.needCommon_ = this.f40751i;
                rpcMetaPb$RpcRequestMeta.bitField0_ = i3;
                return rpcMetaPb$RpcRequestMeta;
            }
            return (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                super.clear();
                this.f40748f = 0L;
                int i2 = this.f40747e & (-2);
                this.f40747e = i2;
                this.f40749g = 0L;
                int i3 = i2 & (-3);
                this.f40747e = i3;
                this.f40750h = 0L;
                int i4 = i3 & (-5);
                this.f40747e = i4;
                this.f40751i = 0;
                this.f40747e = i4 & (-9);
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
        public RpcMetaPb$RpcRequestMeta getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? RpcMetaPb$RpcRequestMeta.getDefaultInstance() : (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
        }

        public b s(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, rpcMetaPb$RpcRequestMeta)) == null) {
                if (rpcMetaPb$RpcRequestMeta == RpcMetaPb$RpcRequestMeta.getDefaultInstance()) {
                    return this;
                }
                if (rpcMetaPb$RpcRequestMeta.hasServiceId()) {
                    x(rpcMetaPb$RpcRequestMeta.getServiceId());
                }
                if (rpcMetaPb$RpcRequestMeta.hasMethodId()) {
                    v(rpcMetaPb$RpcRequestMeta.getMethodId());
                }
                if (rpcMetaPb$RpcRequestMeta.hasLogId()) {
                    u(rpcMetaPb$RpcRequestMeta.getLogId());
                }
                if (rpcMetaPb$RpcRequestMeta.hasNeedCommon()) {
                    w(rpcMetaPb$RpcRequestMeta.getNeedCommon());
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
                RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = null;
                try {
                    try {
                        RpcMetaPb$RpcRequestMeta parsePartialFrom = RpcMetaPb$RpcRequestMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            s(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta2 = (RpcMetaPb$RpcRequestMeta) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            rpcMetaPb$RpcRequestMeta = rpcMetaPb$RpcRequestMeta2;
                            if (rpcMetaPb$RpcRequestMeta != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rpcMetaPb$RpcRequestMeta != null) {
                        s(rpcMetaPb$RpcRequestMeta);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b u(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) {
                this.f40747e |= 4;
                this.f40750h = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b v(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
                this.f40747e |= 2;
                this.f40749g = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b w(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                this.f40747e |= 8;
                this.f40751i = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b x(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j2)) == null) {
                this.f40747e |= 1;
                this.f40748f = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            s(rpcMetaPb$RpcRequestMeta);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2142792096, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcRequestMeta;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2142792096, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcRequestMeta;");
                return;
            }
        }
        PARSER = new a();
        RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = new RpcMetaPb$RpcRequestMeta(true);
        defaultInstance = rpcMetaPb$RpcRequestMeta;
        rpcMetaPb$RpcRequestMeta.initFields();
    }

    public /* synthetic */ RpcMetaPb$RpcRequestMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, e eVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcRequestMeta getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? defaultInstance : (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.serviceId_ = 0L;
            this.methodId_ = 0L;
            this.logId_ = 0L;
            this.needCommon_ = 0;
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (RpcMetaPb$RpcRequestMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (RpcMetaPb$RpcRequestMeta) invokeL.objValue;
    }

    public long getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.logId_ : invokeV.longValue;
    }

    public long getMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.methodId_ : invokeV.longValue;
    }

    public int getNeedCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.needCommon_ : invokeV.intValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcRequestMeta> getParserForType() {
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
            int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.serviceId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.methodId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.logId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt32Size(4, this.needCommon_);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }
        return invokeV.intValue;
    }

    public long getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.serviceId_ : invokeV.longValue;
    }

    public boolean hasLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    public boolean hasNeedCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
    }

    public boolean hasServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(1, this.serviceId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.methodId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.logId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.needCommon_);
            }
        }
    }

    public /* synthetic */ RpcMetaPb$RpcRequestMeta(GeneratedMessageLite.Builder builder, e eVar) {
        this(builder);
    }

    public static b newBuilder(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, rpcMetaPb$RpcRequestMeta)) == null) {
            b newBuilder = newBuilder();
            newBuilder.s(rpcMetaPb$RpcRequestMeta);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (RpcMetaPb$RpcRequestMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (RpcMetaPb$RpcRequestMeta) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcRequestMeta getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcMetaPb$RpcRequestMeta(GeneratedMessageLite.Builder builder) {
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

    public static RpcMetaPb$RpcRequestMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (RpcMetaPb$RpcRequestMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (RpcMetaPb$RpcRequestMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (RpcMetaPb$RpcRequestMeta) invokeL.objValue;
    }

    public RpcMetaPb$RpcRequestMeta(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (RpcMetaPb$RpcRequestMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (RpcMetaPb$RpcRequestMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcRequestMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (RpcMetaPb$RpcRequestMeta) invokeLL.objValue;
    }

    public RpcMetaPb$RpcRequestMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.serviceId_ = codedInputStream.readInt64();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.methodId_ = codedInputStream.readInt64();
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.logId_ = codedInputStream.readInt64();
                        } else if (readTag != 32) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 8;
                            this.needCommon_ = codedInputStream.readInt32();
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
