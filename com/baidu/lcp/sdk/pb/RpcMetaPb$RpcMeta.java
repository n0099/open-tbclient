package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import com.baidu.tieba.q90;
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
public final class RpcMetaPb$RpcMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_COMPRESS_TYPE_FIELD_NUMBER = 9;
    public static final int ATTACHMENT_SIZE_FIELD_NUMBER = 5;
    public static final int AUTHENTICATION_DATA_FIELD_NUMBER = 7;
    public static final int CHUNK_INFO_FIELD_NUMBER = 6;
    public static final int COMPRESS_TYPE_FIELD_NUMBER = 3;
    public static final int CORRELATION_ID_FIELD_NUMBER = 4;
    public static final int NOTIFY_FIELD_NUMBER = 8;
    public static Parser<RpcMetaPb$RpcMeta> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 1;
    public static final int RESPONSE_FIELD_NUMBER = 2;
    public static final RpcMetaPb$RpcMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int acceptCompressType_;
    public int attachmentSize_;
    public ByteString authenticationData_;
    public int bitField0_;
    public RpcMetaPb$ChunkInfo chunkInfo_;
    public int compressType_;
    public long correlationId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public RpcMetaPb$RpcNotifyMeta notify_;
    public RpcMetaPb$RpcRequestMeta request_;
    public RpcMetaPb$RpcResponseMeta response_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcMeta> {
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
        public RpcMetaPb$RpcMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new RpcMetaPb$RpcMeta(codedInputStream, extensionRegistryLite, null);
            }
            return (RpcMetaPb$RpcMeta) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcMeta, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public RpcMetaPb$RpcRequestMeta b;
        public RpcMetaPb$RpcResponseMeta c;
        public int d;
        public long e;
        public int f;
        public RpcMetaPb$ChunkInfo g;
        public ByteString h;
        public RpcMetaPb$RpcNotifyMeta i;
        public int j;

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
            this.b = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
            this.c = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            this.g = RpcMetaPb$ChunkInfo.getDefaultInstance();
            this.h = ByteString.EMPTY;
            this.i = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            maybeForceBuilderInitialization();
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

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (s() && !q().isInitialized()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public RpcMetaPb$RpcMeta build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                RpcMetaPb$RpcMeta buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (RpcMetaPb$RpcMeta) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                b p = p();
                p.u(buildPartial());
                return p;
            }
            return (b) invokeV.objValue;
        }

        public RpcMetaPb$ChunkInfo q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.g;
            }
            return (RpcMetaPb$ChunkInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return RpcMetaPb$RpcMeta.getDefaultInstance();
            }
            return (RpcMetaPb$RpcMeta) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if ((this.a & 32) == 32) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public b A(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a |= 16;
                this.f = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b B(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 64;
                    this.h = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b C(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.a |= 4;
                this.d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b D(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.a |= 8;
                this.e = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b E(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rpcMetaPb$RpcRequestMeta)) == null) {
                if (rpcMetaPb$RpcRequestMeta != null) {
                    this.b = rpcMetaPb$RpcRequestMeta;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            u(rpcMetaPb$RpcMeta);
            return this;
        }

        public b z(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
                this.a |= 256;
                this.j = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$RpcMeta buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta(this, (q90) null);
                int i = this.a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                rpcMetaPb$RpcMeta.request_ = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcMetaPb$RpcMeta.response_ = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcMetaPb$RpcMeta.compressType_ = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                rpcMetaPb$RpcMeta.correlationId_ = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                rpcMetaPb$RpcMeta.attachmentSize_ = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                rpcMetaPb$RpcMeta.chunkInfo_ = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                rpcMetaPb$RpcMeta.authenticationData_ = this.h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                rpcMetaPb$RpcMeta.notify_ = this.i;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                rpcMetaPb$RpcMeta.acceptCompressType_ = this.j;
                rpcMetaPb$RpcMeta.bitField0_ = i2;
                return rpcMetaPb$RpcMeta;
            }
            return (RpcMetaPb$RpcMeta) invokeV.objValue;
        }

        public b n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                super.clear();
                this.b = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
                this.a &= -2;
                this.c = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
                int i = this.a & (-3);
                this.a = i;
                this.d = 0;
                int i2 = i & (-5);
                this.a = i2;
                this.e = 0L;
                int i3 = i2 & (-9);
                this.a = i3;
                this.f = 0;
                this.a = i3 & (-17);
                this.g = RpcMetaPb$ChunkInfo.getDefaultInstance();
                int i4 = this.a & (-33);
                this.a = i4;
                this.h = ByteString.EMPTY;
                this.a = i4 & (-65);
                this.i = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
                int i5 = this.a & (-129);
                this.a = i5;
                this.j = 0;
                this.a = i5 & (-257);
                return this;
            }
            return (b) invokeV.objValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b t(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, rpcMetaPb$ChunkInfo)) == null) {
                if ((this.a & 32) == 32 && this.g != RpcMetaPb$ChunkInfo.getDefaultInstance()) {
                    RpcMetaPb$ChunkInfo.b newBuilder = RpcMetaPb$ChunkInfo.newBuilder(this.g);
                    newBuilder.t(rpcMetaPb$ChunkInfo);
                    this.g = newBuilder.buildPartial();
                } else {
                    this.g = rpcMetaPb$ChunkInfo;
                }
                this.a |= 32;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b w(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, rpcMetaPb$RpcNotifyMeta)) == null) {
                if ((this.a & 128) == 128 && this.i != RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                    RpcMetaPb$RpcNotifyMeta.b newBuilder = RpcMetaPb$RpcNotifyMeta.newBuilder(this.i);
                    newBuilder.r(rpcMetaPb$RpcNotifyMeta);
                    this.i = newBuilder.buildPartial();
                } else {
                    this.i = rpcMetaPb$RpcNotifyMeta;
                }
                this.a |= 128;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b x(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, rpcMetaPb$RpcRequestMeta)) == null) {
                if ((this.a & 1) == 1 && this.b != RpcMetaPb$RpcRequestMeta.getDefaultInstance()) {
                    RpcMetaPb$RpcRequestMeta.b newBuilder = RpcMetaPb$RpcRequestMeta.newBuilder(this.b);
                    newBuilder.s(rpcMetaPb$RpcRequestMeta);
                    this.b = newBuilder.buildPartial();
                } else {
                    this.b = rpcMetaPb$RpcRequestMeta;
                }
                this.a |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b y(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, rpcMetaPb$RpcResponseMeta)) == null) {
                if ((this.a & 2) == 2 && this.c != RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                    RpcMetaPb$RpcResponseMeta.b newBuilder = RpcMetaPb$RpcResponseMeta.newBuilder(this.c);
                    newBuilder.r(rpcMetaPb$RpcResponseMeta);
                    this.c = newBuilder.buildPartial();
                } else {
                    this.c = rpcMetaPb$RpcResponseMeta;
                }
                this.a |= 2;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b u(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, rpcMetaPb$RpcMeta)) == null) {
                if (rpcMetaPb$RpcMeta == RpcMetaPb$RpcMeta.getDefaultInstance()) {
                    return this;
                }
                if (rpcMetaPb$RpcMeta.hasRequest()) {
                    x(rpcMetaPb$RpcMeta.getRequest());
                }
                if (rpcMetaPb$RpcMeta.hasResponse()) {
                    y(rpcMetaPb$RpcMeta.getResponse());
                }
                if (rpcMetaPb$RpcMeta.hasCompressType()) {
                    C(rpcMetaPb$RpcMeta.getCompressType());
                }
                if (rpcMetaPb$RpcMeta.hasCorrelationId()) {
                    D(rpcMetaPb$RpcMeta.getCorrelationId());
                }
                if (rpcMetaPb$RpcMeta.hasAttachmentSize()) {
                    A(rpcMetaPb$RpcMeta.getAttachmentSize());
                }
                if (rpcMetaPb$RpcMeta.hasChunkInfo()) {
                    t(rpcMetaPb$RpcMeta.getChunkInfo());
                }
                if (rpcMetaPb$RpcMeta.hasAuthenticationData()) {
                    B(rpcMetaPb$RpcMeta.getAuthenticationData());
                }
                if (rpcMetaPb$RpcMeta.hasNotify()) {
                    w(rpcMetaPb$RpcMeta.getNotify());
                }
                if (rpcMetaPb$RpcMeta.hasAcceptCompressType()) {
                    z(rpcMetaPb$RpcMeta.getAcceptCompressType());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, codedInputStream, extensionRegistryLite)) == null) {
                RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = null;
                try {
                    try {
                        RpcMetaPb$RpcMeta parsePartialFrom = RpcMetaPb$RpcMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            u(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta2 = (RpcMetaPb$RpcMeta) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            rpcMetaPb$RpcMeta = rpcMetaPb$RpcMeta2;
                            if (rpcMetaPb$RpcMeta != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rpcMetaPb$RpcMeta != null) {
                        u(rpcMetaPb$RpcMeta);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1807203107, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcMeta;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1807203107, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcMeta;");
                return;
            }
        }
        PARSER = new a();
        RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta(true);
        defaultInstance = rpcMetaPb$RpcMeta;
        rpcMetaPb$RpcMeta.initFields();
    }

    public static RpcMetaPb$RpcMeta getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return defaultInstance;
        }
        return (RpcMetaPb$RpcMeta) invokeV.objValue;
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return b.k();
        }
        return (b) invokeV.objValue;
    }

    public int getAcceptCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.acceptCompressType_;
        }
        return invokeV.intValue;
    }

    public int getAttachmentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.attachmentSize_;
        }
        return invokeV.intValue;
    }

    public ByteString getAuthenticationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.authenticationData_;
        }
        return (ByteString) invokeV.objValue;
    }

    public RpcMetaPb$ChunkInfo getChunkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.chunkInfo_;
        }
        return (RpcMetaPb$ChunkInfo) invokeV.objValue;
    }

    public int getCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.compressType_;
        }
        return invokeV.intValue;
    }

    public long getCorrelationId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.correlationId_;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return defaultInstance;
        }
        return (RpcMetaPb$RpcMeta) invokeV.objValue;
    }

    public RpcMetaPb$RpcNotifyMeta getNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.notify_;
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcMeta> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public RpcMetaPb$RpcRequestMeta getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.request_;
        }
        return (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
    }

    public RpcMetaPb$RpcResponseMeta getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.response_;
        }
        return (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
    }

    public boolean hasAcceptCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasAttachmentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasAuthenticationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasChunkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasCorrelationId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                if (b2 != 1) {
                    return false;
                }
                return true;
            } else if (hasChunkInfo() && !getChunkInfo().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    public RpcMetaPb$RpcMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag != 18) {
                                    if (readTag != 24) {
                                        if (readTag != 32) {
                                            if (readTag != 40) {
                                                if (readTag != 50) {
                                                    if (readTag != 58) {
                                                        if (readTag != 66) {
                                                            if (readTag != 72) {
                                                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                                                }
                                                            } else {
                                                                this.bitField0_ |= 256;
                                                                this.acceptCompressType_ = codedInputStream.readInt32();
                                                            }
                                                        } else {
                                                            RpcMetaPb$RpcNotifyMeta.b builder = (this.bitField0_ & 128) == 128 ? this.notify_.toBuilder() : null;
                                                            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = (RpcMetaPb$RpcNotifyMeta) codedInputStream.readMessage(RpcMetaPb$RpcNotifyMeta.PARSER, extensionRegistryLite);
                                                            this.notify_ = rpcMetaPb$RpcNotifyMeta;
                                                            if (builder != null) {
                                                                builder.r(rpcMetaPb$RpcNotifyMeta);
                                                                this.notify_ = builder.buildPartial();
                                                            }
                                                            this.bitField0_ |= 128;
                                                        }
                                                    } else {
                                                        this.bitField0_ |= 64;
                                                        this.authenticationData_ = codedInputStream.readBytes();
                                                    }
                                                } else {
                                                    RpcMetaPb$ChunkInfo.b builder2 = (this.bitField0_ & 32) == 32 ? this.chunkInfo_.toBuilder() : null;
                                                    RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = (RpcMetaPb$ChunkInfo) codedInputStream.readMessage(RpcMetaPb$ChunkInfo.PARSER, extensionRegistryLite);
                                                    this.chunkInfo_ = rpcMetaPb$ChunkInfo;
                                                    if (builder2 != null) {
                                                        builder2.t(rpcMetaPb$ChunkInfo);
                                                        this.chunkInfo_ = builder2.buildPartial();
                                                    }
                                                    this.bitField0_ |= 32;
                                                }
                                            } else {
                                                this.bitField0_ |= 16;
                                                this.attachmentSize_ = codedInputStream.readInt32();
                                            }
                                        } else {
                                            this.bitField0_ |= 8;
                                            this.correlationId_ = codedInputStream.readInt64();
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.compressType_ = codedInputStream.readInt32();
                                    }
                                } else {
                                    RpcMetaPb$RpcResponseMeta.b builder3 = (this.bitField0_ & 2) == 2 ? this.response_.toBuilder() : null;
                                    RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = (RpcMetaPb$RpcResponseMeta) codedInputStream.readMessage(RpcMetaPb$RpcResponseMeta.PARSER, extensionRegistryLite);
                                    this.response_ = rpcMetaPb$RpcResponseMeta;
                                    if (builder3 != null) {
                                        builder3.r(rpcMetaPb$RpcResponseMeta);
                                        this.response_ = builder3.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                RpcMetaPb$RpcRequestMeta.b builder4 = (this.bitField0_ & 1) == 1 ? this.request_.toBuilder() : null;
                                RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = (RpcMetaPb$RpcRequestMeta) codedInputStream.readMessage(RpcMetaPb$RpcRequestMeta.PARSER, extensionRegistryLite);
                                this.request_ = rpcMetaPb$RpcRequestMeta;
                                if (builder4 != null) {
                                    builder4.s(rpcMetaPb$RpcRequestMeta);
                                    this.request_ = builder4.buildPartial();
                                }
                                this.bitField0_ |= 1;
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

    public /* synthetic */ RpcMetaPb$RpcMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, q90 q90Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcMetaPb$RpcMeta(GeneratedMessageLite.Builder builder) {
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

    public /* synthetic */ RpcMetaPb$RpcMeta(GeneratedMessageLite.Builder builder, q90 q90Var) {
        this(builder);
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public RpcMetaPb$RpcMeta(boolean z) {
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

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.request_ = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
            this.response_ = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            this.compressType_ = 0;
            this.correlationId_ = 0L;
            this.attachmentSize_ = 0;
            this.chunkInfo_ = RpcMetaPb$ChunkInfo.getDefaultInstance();
            this.authenticationData_ = ByteString.EMPTY;
            this.notify_ = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            this.acceptCompressType_ = 0;
        }
    }

    public static b newBuilder(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, rpcMetaPb$RpcMeta)) == null) {
            b newBuilder = newBuilder();
            newBuilder.u(rpcMetaPb$RpcMeta);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, this.request_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, this.response_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt32Size(3, this.compressType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeInt64Size(4, this.correlationId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeInt32Size(5, this.attachmentSize_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeMessageSize(6, this.chunkInfo_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += CodedOutputStream.computeBytesSize(7, this.authenticationData_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i2 += CodedOutputStream.computeMessageSize(8, this.notify_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i2 += CodedOutputStream.computeInt32Size(9, this.acceptCompressType_);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.request_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.response_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.compressType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.correlationId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.attachmentSize_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(6, this.chunkInfo_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(7, this.authenticationData_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(8, this.notify_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.acceptCompressType_);
            }
        }
    }
}
