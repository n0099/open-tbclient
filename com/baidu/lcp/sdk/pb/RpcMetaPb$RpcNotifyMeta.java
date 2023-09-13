package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r90;
import com.baidu.tieba.s90;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class RpcMetaPb$RpcNotifyMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_LIST_FIELD_NUMBER = 4;
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static Parser<RpcMetaPb$RpcNotifyMeta> PARSER = null;
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcNotifyMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public List<RpcMetaPb$event_timestamp> eventList_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId_;
    public long serviceId_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcNotifyMeta> {
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
        public RpcMetaPb$RpcNotifyMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new RpcMetaPb$RpcNotifyMeta(codedInputStream, extensionRegistryLite, null);
            }
            return (RpcMetaPb$RpcNotifyMeta) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcNotifyMeta, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;
        public long d;
        public List<RpcMetaPb$event_timestamp> e;

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
            this.e = Collections.emptyList();
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

        public final void ensureEventListIsMutable() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (this.a & 8) != 8) {
                this.e = new ArrayList(this.e);
                this.a |= 8;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public RpcMetaPb$RpcNotifyMeta build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                RpcMetaPb$RpcNotifyMeta buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                b p = p();
                p.r(buildPartial());
                return p;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public RpcMetaPb$RpcNotifyMeta getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            }
            return (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$RpcNotifyMeta buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = new RpcMetaPb$RpcNotifyMeta(this, (r90) null);
                int i = this.a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                rpcMetaPb$RpcNotifyMeta.serviceId_ = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcMetaPb$RpcNotifyMeta.methodId_ = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcMetaPb$RpcNotifyMeta.logId_ = this.d;
                if ((this.a & 8) == 8) {
                    this.e = Collections.unmodifiableList(this.e);
                    this.a &= -9;
                }
                rpcMetaPb$RpcNotifyMeta.eventList_ = this.e;
                rpcMetaPb$RpcNotifyMeta.bitField0_ = i2;
                return rpcMetaPb$RpcNotifyMeta;
            }
            return (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            s(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            r(rpcMetaPb$RpcNotifyMeta);
            return this;
        }

        public b t(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j)) == null) {
                this.a |= 4;
                this.d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b u(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j)) == null) {
                this.a |= 2;
                this.c = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b v(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j)) == null) {
                this.a |= 1;
                this.b = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            s(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                super.clear();
                this.b = 0L;
                int i = this.a & (-2);
                this.a = i;
                this.c = 0L;
                int i2 = i & (-3);
                this.a = i2;
                this.d = 0L;
                this.a = i2 & (-5);
                this.e = Collections.emptyList();
                this.a &= -9;
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b r(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, rpcMetaPb$RpcNotifyMeta)) == null) {
                if (rpcMetaPb$RpcNotifyMeta == RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                    return this;
                }
                if (rpcMetaPb$RpcNotifyMeta.hasServiceId()) {
                    v(rpcMetaPb$RpcNotifyMeta.getServiceId());
                }
                if (rpcMetaPb$RpcNotifyMeta.hasMethodId()) {
                    u(rpcMetaPb$RpcNotifyMeta.getMethodId());
                }
                if (rpcMetaPb$RpcNotifyMeta.hasLogId()) {
                    t(rpcMetaPb$RpcNotifyMeta.getLogId());
                }
                if (!rpcMetaPb$RpcNotifyMeta.eventList_.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = rpcMetaPb$RpcNotifyMeta.eventList_;
                        this.a &= -9;
                    } else {
                        ensureEventListIsMutable();
                        this.e.addAll(rpcMetaPb$RpcNotifyMeta.eventList_);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b s(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, codedInputStream, extensionRegistryLite)) == null) {
                RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = null;
                try {
                    try {
                        RpcMetaPb$RpcNotifyMeta parsePartialFrom = RpcMetaPb$RpcNotifyMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            r(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta2 = (RpcMetaPb$RpcNotifyMeta) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            rpcMetaPb$RpcNotifyMeta = rpcMetaPb$RpcNotifyMeta2;
                            if (rpcMetaPb$RpcNotifyMeta != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rpcMetaPb$RpcNotifyMeta != null) {
                        r(rpcMetaPb$RpcNotifyMeta);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(623247828, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcNotifyMeta;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(623247828, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcNotifyMeta;");
                return;
            }
        }
        PARSER = new a();
        RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = new RpcMetaPb$RpcNotifyMeta(true);
        defaultInstance = rpcMetaPb$RpcNotifyMeta;
        rpcMetaPb$RpcNotifyMeta.initFields();
    }

    public static RpcMetaPb$RpcNotifyMeta getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return defaultInstance;
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.serviceId_ = 0L;
            this.methodId_ = 0L;
            this.logId_ = 0L;
            this.eventList_ = Collections.emptyList();
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return b.k();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcNotifyMeta getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return defaultInstance;
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeV.objValue;
    }

    public int getEventListCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.eventList_.size();
        }
        return invokeV.intValue;
    }

    public List<RpcMetaPb$event_timestamp> getEventListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.eventList_;
        }
        return (List) invokeV.objValue;
    }

    public List<? extends s90> getEventListOrBuilderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.eventList_;
        }
        return (List) invokeV.objValue;
    }

    public long getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.logId_;
        }
        return invokeV.longValue;
    }

    public long getMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.methodId_;
        }
        return invokeV.longValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcNotifyMeta> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public long getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.serviceId_;
        }
        return invokeV.longValue;
    }

    public boolean hasLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if ((this.bitField0_ & 1) == 1) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                if (b2 == 1) {
                    return true;
                }
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List<com.baidu.lcp.sdk.pb.RpcMetaPb$event_timestamp> */
    /* JADX WARN: Multi-variable type inference failed */
    public RpcMetaPb$RpcNotifyMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
        boolean z2 = false;
        while (true) {
            if (z) {
                break;
            }
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 8) {
                                if (readTag != 16) {
                                    if (readTag != 24) {
                                        if (readTag != 34) {
                                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                            }
                                        } else {
                                            if (!(z2 & true)) {
                                                this.eventList_ = new ArrayList();
                                                z2 |= true;
                                            }
                                            this.eventList_.add(codedInputStream.readMessage(RpcMetaPb$event_timestamp.PARSER, extensionRegistryLite));
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.logId_ = codedInputStream.readInt64();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.methodId_ = codedInputStream.readInt64();
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.serviceId_ = codedInputStream.readInt64();
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
                if (z2 & true) {
                    this.eventList_ = Collections.unmodifiableList(this.eventList_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ RpcMetaPb$RpcNotifyMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, r90 r90Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcMetaPb$RpcNotifyMeta(GeneratedMessageLite.Builder builder) {
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

    public /* synthetic */ RpcMetaPb$RpcNotifyMeta(GeneratedMessageLite.Builder builder, r90 r90Var) {
        this(builder);
    }

    public static RpcMetaPb$RpcNotifyMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeLL.objValue;
    }

    public RpcMetaPb$RpcNotifyMeta(boolean z) {
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

    public static b newBuilder(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, rpcMetaPb$RpcNotifyMeta)) == null) {
            b newBuilder = newBuilder();
            newBuilder.r(rpcMetaPb$RpcNotifyMeta);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeL.objValue;
    }

    public RpcMetaPb$event_timestamp getEventList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.eventList_.get(i);
        }
        return (RpcMetaPb$event_timestamp) invokeI.objValue;
    }

    public s90 getEventListOrBuilder(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.eventList_.get(i);
        }
        return (s90) invokeI.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcNotifyMeta) invokeLL.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i = CodedOutputStream.computeInt64Size(1, this.serviceId_) + 0;
            } else {
                i = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeInt64Size(2, this.methodId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeInt64Size(3, this.logId_);
            }
            for (int i3 = 0; i3 < this.eventList_.size(); i3++) {
                i += CodedOutputStream.computeMessageSize(4, this.eventList_.get(i3));
            }
            this.memoizedSerializedSize = i;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, codedOutputStream) == null) {
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
            for (int i = 0; i < this.eventList_.size(); i++) {
                codedOutputStream.writeMessage(4, this.eventList_.get(i));
            }
        }
    }
}
