package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ka0;
import com.baidu.tieba.la0;
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
public final class RpcMetaPb$RpcResponseMeta extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_FIELD_NUMBER = 4;
    public static final int ERROR_TEXT_FIELD_NUMBER = 5;
    public static final int EVENT_LIST_FIELD_NUMBER = 6;
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static Parser<RpcMetaPb$RpcResponseMeta> PARSER = null;
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcResponseMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public int errorCode_;
    public Object errorText_;
    public List<RpcMetaPb$event_timestamp> eventList_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId_;
    public long serviceId_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<RpcMetaPb$RpcResponseMeta> {
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
        public RpcMetaPb$RpcResponseMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new RpcMetaPb$RpcResponseMeta(codedInputStream, extensionRegistryLite, null);
            }
            return (RpcMetaPb$RpcResponseMeta) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<RpcMetaPb$RpcResponseMeta, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;
        public long d;
        public int e;
        public Object f;
        public List<RpcMetaPb$event_timestamp> g;

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
            this.f = "";
            this.g = Collections.emptyList();
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public RpcMetaPb$RpcResponseMeta build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                RpcMetaPb$RpcResponseMeta buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                b p = p();
                p.s(buildPartial());
                return p;
            }
            return (b) invokeV.objValue;
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (this.a & 32) != 32) {
                this.g = new ArrayList(this.g);
                this.a |= 32;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public RpcMetaPb$RpcResponseMeta getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            }
            return (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public RpcMetaPb$RpcResponseMeta buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = new RpcMetaPb$RpcResponseMeta(this, (ka0) null);
                int i = this.a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                rpcMetaPb$RpcResponseMeta.serviceId_ = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcMetaPb$RpcResponseMeta.methodId_ = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcMetaPb$RpcResponseMeta.logId_ = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                rpcMetaPb$RpcResponseMeta.errorCode_ = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                rpcMetaPb$RpcResponseMeta.errorText_ = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                rpcMetaPb$RpcResponseMeta.eventList_ = this.g;
                rpcMetaPb$RpcResponseMeta.bitField0_ = i2;
                return rpcMetaPb$RpcResponseMeta;
            }
            return (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            s(rpcMetaPb$RpcResponseMeta);
            return this;
        }

        public b u(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
                this.a |= 8;
                this.e = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b v(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j)) == null) {
                this.a |= 4;
                this.d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b w(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j)) == null) {
                this.a |= 2;
                this.c = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b x(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048602, this, j)) == null) {
                this.a |= 1;
                this.b = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                super.clear();
                this.b = 0L;
                int i = this.a & (-2);
                this.a = i;
                this.c = 0L;
                int i2 = i & (-3);
                this.a = i2;
                this.d = 0L;
                int i3 = i2 & (-5);
                this.a = i3;
                this.e = 0;
                int i4 = i3 & (-9);
                this.a = i4;
                this.f = "";
                this.a = i4 & (-17);
                this.g = Collections.emptyList();
                this.a &= -33;
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b s(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, rpcMetaPb$RpcResponseMeta)) == null) {
                if (rpcMetaPb$RpcResponseMeta == RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                    return this;
                }
                if (rpcMetaPb$RpcResponseMeta.hasServiceId()) {
                    x(rpcMetaPb$RpcResponseMeta.getServiceId());
                }
                if (rpcMetaPb$RpcResponseMeta.hasMethodId()) {
                    w(rpcMetaPb$RpcResponseMeta.getMethodId());
                }
                if (rpcMetaPb$RpcResponseMeta.hasLogId()) {
                    v(rpcMetaPb$RpcResponseMeta.getLogId());
                }
                if (rpcMetaPb$RpcResponseMeta.hasErrorCode()) {
                    u(rpcMetaPb$RpcResponseMeta.getErrorCode());
                }
                if (rpcMetaPb$RpcResponseMeta.hasErrorText()) {
                    this.a |= 16;
                    this.f = rpcMetaPb$RpcResponseMeta.errorText_;
                }
                if (!rpcMetaPb$RpcResponseMeta.eventList_.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = rpcMetaPb$RpcResponseMeta.eventList_;
                        this.a &= -33;
                    } else {
                        q();
                        this.g.addAll(rpcMetaPb$RpcResponseMeta.eventList_);
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
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, codedInputStream, extensionRegistryLite)) == null) {
                RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = null;
                try {
                    try {
                        RpcMetaPb$RpcResponseMeta parsePartialFrom = RpcMetaPb$RpcResponseMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            s(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta2 = (RpcMetaPb$RpcResponseMeta) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            rpcMetaPb$RpcResponseMeta = rpcMetaPb$RpcResponseMeta2;
                            if (rpcMetaPb$RpcResponseMeta != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rpcMetaPb$RpcResponseMeta != null) {
                        s(rpcMetaPb$RpcResponseMeta);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1851078116, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcResponseMeta;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1851078116, "Lcom/baidu/lcp/sdk/pb/RpcMetaPb$RpcResponseMeta;");
                return;
            }
        }
        PARSER = new a();
        RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = new RpcMetaPb$RpcResponseMeta(true);
        defaultInstance = rpcMetaPb$RpcResponseMeta;
        rpcMetaPb$RpcResponseMeta.initFields();
    }

    public static RpcMetaPb$RpcResponseMeta getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return defaultInstance;
        }
        return (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.serviceId_ = 0L;
            this.methodId_ = 0L;
            this.logId_ = 0L;
            this.errorCode_ = 0;
            this.errorText_ = "";
            this.eventList_ = Collections.emptyList();
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return b.k();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public RpcMetaPb$RpcResponseMeta getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return defaultInstance;
        }
        return (RpcMetaPb$RpcResponseMeta) invokeV.objValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.errorCode_;
        }
        return invokeV.intValue;
    }

    public String getErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object obj = this.errorText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.errorText_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String) invokeV.objValue;
    }

    public ByteString getErrorTextBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object obj = this.errorText_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errorText_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public int getEventListCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.eventList_.size();
        }
        return invokeV.intValue;
    }

    public List<RpcMetaPb$event_timestamp> getEventListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.eventList_;
        }
        return (List) invokeV.objValue;
    }

    public List<? extends la0> getEventListOrBuilderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.eventList_;
        }
        return (List) invokeV.objValue;
    }

    public long getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.logId_;
        }
        return invokeV.longValue;
    }

    public long getMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.methodId_;
        }
        return invokeV.longValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<RpcMetaPb$RpcResponseMeta> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public long getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.serviceId_;
        }
        return invokeV.longValue;
    }

    public boolean hasErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasLogId() {
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

    public boolean hasMethodId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List<com.baidu.lcp.sdk.pb.RpcMetaPb$event_timestamp> */
    /* JADX WARN: Multi-variable type inference failed */
    public RpcMetaPb$RpcResponseMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        if (readTag != 32) {
                                            if (readTag != 42) {
                                                if (readTag != 50) {
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
                                                this.bitField0_ |= 16;
                                                this.errorText_ = codedInputStream.readBytes();
                                            }
                                        } else {
                                            this.bitField0_ |= 8;
                                            this.errorCode_ = codedInputStream.readInt32();
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
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.eventList_ = Collections.unmodifiableList(this.eventList_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ RpcMetaPb$RpcResponseMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ka0 ka0Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RpcMetaPb$RpcResponseMeta(GeneratedMessageLite.Builder builder) {
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

    public /* synthetic */ RpcMetaPb$RpcResponseMeta(GeneratedMessageLite.Builder builder, ka0 ka0Var) {
        this(builder);
    }

    public static RpcMetaPb$RpcResponseMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeLL.objValue;
    }

    public RpcMetaPb$RpcResponseMeta(boolean z) {
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

    public static b newBuilder(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, rpcMetaPb$RpcResponseMeta)) == null) {
            b newBuilder = newBuilder();
            newBuilder.s(rpcMetaPb$RpcResponseMeta);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeL.objValue;
    }

    public RpcMetaPb$event_timestamp getEventList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.eventList_.get(i);
        }
        return (RpcMetaPb$event_timestamp) invokeI.objValue;
    }

    public la0 getEventListOrBuilder(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.eventList_.get(i);
        }
        return (la0) invokeI.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeLL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeL.objValue;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (RpcMetaPb$RpcResponseMeta) invokeLL.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.computeBytesSize(5, getErrorTextBytes());
            }
            for (int i3 = 0; i3 < this.eventList_.size(); i3++) {
                i += CodedOutputStream.computeMessageSize(6, this.eventList_.get(i3));
            }
            this.memoizedSerializedSize = i;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, codedOutputStream) == null) {
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
                codedOutputStream.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getErrorTextBytes());
            }
            for (int i = 0; i < this.eventList_.size(); i++) {
                codedOutputStream.writeMessage(6, this.eventList_.get(i));
            }
        }
    }
}
