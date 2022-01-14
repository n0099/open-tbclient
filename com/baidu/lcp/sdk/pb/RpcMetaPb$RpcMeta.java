package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import c.a.u.a.e.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
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

    /* loaded from: classes10.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcMeta> {
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
        public RpcMetaPb$RpcMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new RpcMetaPb$RpcMeta(codedInputStream, extensionRegistryLite, null) : (RpcMetaPb$RpcMeta) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcMeta, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f34652e;

        /* renamed from: f  reason: collision with root package name */
        public RpcMetaPb$RpcRequestMeta f34653f;

        /* renamed from: g  reason: collision with root package name */
        public RpcMetaPb$RpcResponseMeta f34654g;

        /* renamed from: h  reason: collision with root package name */
        public int f34655h;

        /* renamed from: i  reason: collision with root package name */
        public long f34656i;

        /* renamed from: j  reason: collision with root package name */
        public int f34657j;
        public RpcMetaPb$ChunkInfo k;
        public ByteString l;
        public RpcMetaPb$RpcNotifyMeta m;
        public int n;

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
            this.f34653f = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
            this.f34654g = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            this.k = RpcMetaPb$ChunkInfo.getDefaultInstance();
            this.l = ByteString.EMPTY;
            this.m = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        public static b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
        }

        public b A(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34652e |= 256;
                this.n = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f34652e |= 16;
                this.f34657j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b C(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteString)) == null) {
                if (byteString != null) {
                    this.f34652e |= 64;
                    this.l = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b D(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f34652e |= 4;
                this.f34655h = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b E(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                this.f34652e |= 8;
                this.f34656i = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b F(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rpcMetaPb$RpcRequestMeta)) == null) {
                if (rpcMetaPb$RpcRequestMeta != null) {
                    this.f34653f = rpcMetaPb$RpcRequestMeta;
                    this.f34652e |= 1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? !t() || r().isInitialized() : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$RpcMeta build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                RpcMetaPb$RpcMeta buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (RpcMetaPb$RpcMeta) invokeV.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            w(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public RpcMetaPb$RpcMeta buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta(this, (e) null);
                int i2 = this.f34652e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                rpcMetaPb$RpcMeta.request_ = this.f34653f;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                rpcMetaPb$RpcMeta.response_ = this.f34654g;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                rpcMetaPb$RpcMeta.compressType_ = this.f34655h;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                rpcMetaPb$RpcMeta.correlationId_ = this.f34656i;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                rpcMetaPb$RpcMeta.attachmentSize_ = this.f34657j;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                rpcMetaPb$RpcMeta.chunkInfo_ = this.k;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                rpcMetaPb$RpcMeta.authenticationData_ = this.l;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                rpcMetaPb$RpcMeta.notify_ = this.m;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                rpcMetaPb$RpcMeta.acceptCompressType_ = this.n;
                rpcMetaPb$RpcMeta.bitField0_ = i3;
                return rpcMetaPb$RpcMeta;
            }
            return (RpcMetaPb$RpcMeta) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                super.clear();
                this.f34653f = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
                this.f34652e &= -2;
                this.f34654g = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
                int i2 = this.f34652e & (-3);
                this.f34652e = i2;
                this.f34655h = 0;
                int i3 = i2 & (-5);
                this.f34652e = i3;
                this.f34656i = 0L;
                int i4 = i3 & (-9);
                this.f34652e = i4;
                this.f34657j = 0;
                this.f34652e = i4 & (-17);
                this.k = RpcMetaPb$ChunkInfo.getDefaultInstance();
                int i5 = this.f34652e & (-33);
                this.f34652e = i5;
                this.l = ByteString.EMPTY;
                this.f34652e = i5 & (-65);
                this.m = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
                int i6 = this.f34652e & (-129);
                this.f34652e = i6;
                this.n = 0;
                this.f34652e = i6 & (-257);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                b q = q();
                q.v(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        public RpcMetaPb$ChunkInfo r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.k : (RpcMetaPb$ChunkInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: s */
        public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? RpcMetaPb$RpcMeta.getDefaultInstance() : (RpcMetaPb$RpcMeta) invokeV.objValue;
        }

        public boolean t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? (this.f34652e & 32) == 32 : invokeV.booleanValue;
        }

        public b u(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, rpcMetaPb$ChunkInfo)) == null) {
                if ((this.f34652e & 32) == 32 && this.k != RpcMetaPb$ChunkInfo.getDefaultInstance()) {
                    RpcMetaPb$ChunkInfo.b newBuilder = RpcMetaPb$ChunkInfo.newBuilder(this.k);
                    newBuilder.u(rpcMetaPb$ChunkInfo);
                    this.k = newBuilder.buildPartial();
                } else {
                    this.k = rpcMetaPb$ChunkInfo;
                }
                this.f34652e |= 32;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b v(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, rpcMetaPb$RpcMeta)) == null) {
                if (rpcMetaPb$RpcMeta == RpcMetaPb$RpcMeta.getDefaultInstance()) {
                    return this;
                }
                if (rpcMetaPb$RpcMeta.hasRequest()) {
                    y(rpcMetaPb$RpcMeta.getRequest());
                }
                if (rpcMetaPb$RpcMeta.hasResponse()) {
                    z(rpcMetaPb$RpcMeta.getResponse());
                }
                if (rpcMetaPb$RpcMeta.hasCompressType()) {
                    D(rpcMetaPb$RpcMeta.getCompressType());
                }
                if (rpcMetaPb$RpcMeta.hasCorrelationId()) {
                    E(rpcMetaPb$RpcMeta.getCorrelationId());
                }
                if (rpcMetaPb$RpcMeta.hasAttachmentSize()) {
                    B(rpcMetaPb$RpcMeta.getAttachmentSize());
                }
                if (rpcMetaPb$RpcMeta.hasChunkInfo()) {
                    u(rpcMetaPb$RpcMeta.getChunkInfo());
                }
                if (rpcMetaPb$RpcMeta.hasAuthenticationData()) {
                    C(rpcMetaPb$RpcMeta.getAuthenticationData());
                }
                if (rpcMetaPb$RpcMeta.hasNotify()) {
                    x(rpcMetaPb$RpcMeta.getNotify());
                }
                if (rpcMetaPb$RpcMeta.hasAcceptCompressType()) {
                    A(rpcMetaPb$RpcMeta.getAcceptCompressType());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b w(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, codedInputStream, extensionRegistryLite)) == null) {
                RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = null;
                try {
                    try {
                        RpcMetaPb$RpcMeta parsePartialFrom = RpcMetaPb$RpcMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            v(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta2 = (RpcMetaPb$RpcMeta) e2.getUnfinishedMessage();
                        try {
                            throw e2;
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
                        v(rpcMetaPb$RpcMeta);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b x(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, rpcMetaPb$RpcNotifyMeta)) == null) {
                if ((this.f34652e & 128) == 128 && this.m != RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                    RpcMetaPb$RpcNotifyMeta.b newBuilder = RpcMetaPb$RpcNotifyMeta.newBuilder(this.m);
                    newBuilder.s(rpcMetaPb$RpcNotifyMeta);
                    this.m = newBuilder.buildPartial();
                } else {
                    this.m = rpcMetaPb$RpcNotifyMeta;
                }
                this.f34652e |= 128;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b y(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, rpcMetaPb$RpcRequestMeta)) == null) {
                if ((this.f34652e & 1) == 1 && this.f34653f != RpcMetaPb$RpcRequestMeta.getDefaultInstance()) {
                    RpcMetaPb$RpcRequestMeta.b newBuilder = RpcMetaPb$RpcRequestMeta.newBuilder(this.f34653f);
                    newBuilder.s(rpcMetaPb$RpcRequestMeta);
                    this.f34653f = newBuilder.buildPartial();
                } else {
                    this.f34653f = rpcMetaPb$RpcRequestMeta;
                }
                this.f34652e |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b z(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, rpcMetaPb$RpcResponseMeta)) == null) {
                if ((this.f34652e & 2) == 2 && this.f34654g != RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                    RpcMetaPb$RpcResponseMeta.b newBuilder = RpcMetaPb$RpcResponseMeta.newBuilder(this.f34654g);
                    newBuilder.s(rpcMetaPb$RpcResponseMeta);
                    this.f34654g = newBuilder.buildPartial();
                } else {
                    this.f34654g = rpcMetaPb$RpcResponseMeta;
                }
                this.f34652e |= 2;
                return this;
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
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            v(rpcMetaPb$RpcMeta);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            w(codedInputStream, extensionRegistryLite);
            return this;
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

    public /* synthetic */ RpcMetaPb$RpcMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, e eVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? defaultInstance : (RpcMetaPb$RpcMeta) invokeV.objValue;
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

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public int getAcceptCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.acceptCompressType_ : invokeV.intValue;
    }

    public int getAttachmentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.attachmentSize_ : invokeV.intValue;
    }

    public ByteString getAuthenticationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.authenticationData_ : (ByteString) invokeV.objValue;
    }

    public RpcMetaPb$ChunkInfo getChunkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.chunkInfo_ : (RpcMetaPb$ChunkInfo) invokeV.objValue;
    }

    public int getCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.compressType_ : invokeV.intValue;
    }

    public long getCorrelationId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.correlationId_ : invokeV.longValue;
    }

    public RpcMetaPb$RpcNotifyMeta getNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.notify_ : (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcMeta> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? PARSER : (Parser) invokeV.objValue;
    }

    public RpcMetaPb$RpcRequestMeta getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.request_ : (RpcMetaPb$RpcRequestMeta) invokeV.objValue;
    }

    public RpcMetaPb$RpcResponseMeta getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.response_ : (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.request_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.response_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeInt32Size(3, this.compressType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(4, this.correlationId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeMessageSize += CodedOutputStream.computeInt32Size(5, this.attachmentSize_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeMessageSize += CodedOutputStream.computeMessageSize(6, this.chunkInfo_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeMessageSize += CodedOutputStream.computeBytesSize(7, this.authenticationData_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeMessageSize += CodedOutputStream.computeMessageSize(8, this.notify_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeMessageSize += CodedOutputStream.computeInt32Size(9, this.acceptCompressType_);
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }
        return invokeV.intValue;
    }

    public boolean hasAcceptCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
    }

    public boolean hasAttachmentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
    }

    public boolean hasAuthenticationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
    }

    public boolean hasChunkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
    }

    public boolean hasCompressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasCorrelationId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
    }

    public boolean hasNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
    }

    public boolean hasRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    public boolean hasResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? super.writeReplace() : invokeV.objValue;
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

    public /* synthetic */ RpcMetaPb$RpcMeta(GeneratedMessageLite.Builder builder, e eVar) {
        this(builder);
    }

    public static b newBuilder(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, rpcMetaPb$RpcMeta)) == null) {
            b newBuilder = newBuilder();
            newBuilder.v(rpcMetaPb$RpcMeta);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? defaultInstance : (RpcMetaPb$RpcMeta) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
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

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public RpcMetaPb$RpcMeta(boolean z) {
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

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (RpcMetaPb$RpcMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (RpcMetaPb$RpcMeta) invokeLL.objValue;
    }

    public RpcMetaPb$RpcMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                RpcMetaPb$RpcRequestMeta.b builder = (this.bitField0_ & 1) == 1 ? this.request_.toBuilder() : null;
                                RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta = (RpcMetaPb$RpcRequestMeta) codedInputStream.readMessage(RpcMetaPb$RpcRequestMeta.PARSER, extensionRegistryLite);
                                this.request_ = rpcMetaPb$RpcRequestMeta;
                                if (builder != null) {
                                    builder.s(rpcMetaPb$RpcRequestMeta);
                                    this.request_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (readTag == 18) {
                                RpcMetaPb$RpcResponseMeta.b builder2 = (this.bitField0_ & 2) == 2 ? this.response_.toBuilder() : null;
                                RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = (RpcMetaPb$RpcResponseMeta) codedInputStream.readMessage(RpcMetaPb$RpcResponseMeta.PARSER, extensionRegistryLite);
                                this.response_ = rpcMetaPb$RpcResponseMeta;
                                if (builder2 != null) {
                                    builder2.s(rpcMetaPb$RpcResponseMeta);
                                    this.response_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.compressType_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.correlationId_ = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.attachmentSize_ = codedInputStream.readInt32();
                            } else if (readTag == 50) {
                                RpcMetaPb$ChunkInfo.b builder3 = (this.bitField0_ & 32) == 32 ? this.chunkInfo_.toBuilder() : null;
                                RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = (RpcMetaPb$ChunkInfo) codedInputStream.readMessage(RpcMetaPb$ChunkInfo.PARSER, extensionRegistryLite);
                                this.chunkInfo_ = rpcMetaPb$ChunkInfo;
                                if (builder3 != null) {
                                    builder3.u(rpcMetaPb$ChunkInfo);
                                    this.chunkInfo_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 32;
                            } else if (readTag == 58) {
                                this.bitField0_ |= 64;
                                this.authenticationData_ = codedInputStream.readBytes();
                            } else if (readTag == 66) {
                                RpcMetaPb$RpcNotifyMeta.b builder4 = (this.bitField0_ & 128) == 128 ? this.notify_.toBuilder() : null;
                                RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = (RpcMetaPb$RpcNotifyMeta) codedInputStream.readMessage(RpcMetaPb$RpcNotifyMeta.PARSER, extensionRegistryLite);
                                this.notify_ = rpcMetaPb$RpcNotifyMeta;
                                if (builder4 != null) {
                                    builder4.s(rpcMetaPb$RpcNotifyMeta);
                                    this.notify_ = builder4.buildPartial();
                                }
                                this.bitField0_ |= 128;
                            } else if (readTag != 72) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 256;
                                this.acceptCompressType_ = codedInputStream.readInt32();
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
