package com.baidu.lcp.sdk.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
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
public final class LcmPb$LcmRequest extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_FIELD_NUMBER = 5;
    public static final int COMMON_FIELD_NUMBER = 3;
    public static final int CONN_TYPE_FIELD_NUMBER = 7;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static Parser<LcmPb$LcmRequest> PARSER = null;
    public static final int START_TYPE_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int TOKEN_FIELD_NUMBER = 2;
    public static final LcmPb$LcmRequest defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int action_;
    public int bitField0_;
    public LcmPb$Common common_;
    public int connType_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int startType_;
    public long timestamp_;
    public Object token_;

    /* loaded from: classes5.dex */
    public static class a extends AbstractParser<LcmPb$LcmRequest> {
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
        public LcmPb$LcmRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LcmPb$LcmRequest(codedInputStream, extensionRegistryLite, null) : (LcmPb$LcmRequest) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$LcmRequest, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f40723e;

        /* renamed from: f  reason: collision with root package name */
        public long f40724f;

        /* renamed from: g  reason: collision with root package name */
        public Object f40725g;

        /* renamed from: h  reason: collision with root package name */
        public LcmPb$Common f40726h;

        /* renamed from: i  reason: collision with root package name */
        public long f40727i;

        /* renamed from: j  reason: collision with root package name */
        public int f40728j;
        public int k;
        public int l;

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
            this.f40725g = "";
            this.f40726h = LcmPb$Common.getDefaultInstance();
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
                this.f40723e |= 32;
                this.k = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b B(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f40723e |= 8;
                this.f40727i = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null) {
                    this.f40723e |= 2;
                    this.f40725g = str;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? s() : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$LcmRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                LcmPb$LcmRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (LcmPb$LcmRequest) invokeV.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public LcmPb$LcmRequest buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                LcmPb$LcmRequest lcmPb$LcmRequest = new LcmPb$LcmRequest(this, (c.a.u.a.e.a) null);
                int i2 = this.f40723e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lcmPb$LcmRequest.logId_ = this.f40724f;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lcmPb$LcmRequest.token_ = this.f40725g;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lcmPb$LcmRequest.common_ = this.f40726h;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lcmPb$LcmRequest.timestamp_ = this.f40727i;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                lcmPb$LcmRequest.action_ = this.f40728j;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                lcmPb$LcmRequest.startType_ = this.k;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                lcmPb$LcmRequest.connType_ = this.l;
                lcmPb$LcmRequest.bitField0_ = i3;
                return lcmPb$LcmRequest;
            }
            return (LcmPb$LcmRequest) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                super.clear();
                this.f40724f = 0L;
                int i2 = this.f40723e & (-2);
                this.f40723e = i2;
                this.f40725g = "";
                this.f40723e = i2 & (-3);
                this.f40726h = LcmPb$Common.getDefaultInstance();
                int i3 = this.f40723e & (-5);
                this.f40723e = i3;
                this.f40727i = 0L;
                int i4 = i3 & (-9);
                this.f40723e = i4;
                this.f40728j = 0;
                int i5 = i4 & (-17);
                this.f40723e = i5;
                this.k = 0;
                int i6 = i5 & (-33);
                this.f40723e = i6;
                this.l = 0;
                this.f40723e = i6 & (-65);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                b q = q();
                q.u(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$LcmRequest getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? LcmPb$LcmRequest.getDefaultInstance() : (LcmPb$LcmRequest) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f40723e & 1) == 1 : invokeV.booleanValue;
        }

        public b t(LcmPb$Common lcmPb$Common) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, lcmPb$Common)) == null) {
                if ((this.f40723e & 4) == 4 && this.f40726h != LcmPb$Common.getDefaultInstance()) {
                    LcmPb$Common.b newBuilder = LcmPb$Common.newBuilder(this.f40726h);
                    newBuilder.s(lcmPb$Common);
                    this.f40726h = newBuilder.buildPartial();
                } else {
                    this.f40726h = lcmPb$Common;
                }
                this.f40723e |= 4;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b u(LcmPb$LcmRequest lcmPb$LcmRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, lcmPb$LcmRequest)) == null) {
                if (lcmPb$LcmRequest == LcmPb$LcmRequest.getDefaultInstance()) {
                    return this;
                }
                if (lcmPb$LcmRequest.hasLogId()) {
                    z(lcmPb$LcmRequest.getLogId());
                }
                if (lcmPb$LcmRequest.hasToken()) {
                    this.f40723e |= 2;
                    this.f40725g = lcmPb$LcmRequest.token_;
                }
                if (lcmPb$LcmRequest.hasCommon()) {
                    t(lcmPb$LcmRequest.getCommon());
                }
                if (lcmPb$LcmRequest.hasTimestamp()) {
                    B(lcmPb$LcmRequest.getTimestamp());
                }
                if (lcmPb$LcmRequest.hasAction()) {
                    w(lcmPb$LcmRequest.getAction());
                }
                if (lcmPb$LcmRequest.hasStartType()) {
                    A(lcmPb$LcmRequest.getStartType());
                }
                if (lcmPb$LcmRequest.hasConnType()) {
                    y(lcmPb$LcmRequest.getConnType());
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, codedInputStream, extensionRegistryLite)) == null) {
                LcmPb$LcmRequest lcmPb$LcmRequest = null;
                try {
                    try {
                        LcmPb$LcmRequest parsePartialFrom = LcmPb$LcmRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            u(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        LcmPb$LcmRequest lcmPb$LcmRequest2 = (LcmPb$LcmRequest) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            lcmPb$LcmRequest = lcmPb$LcmRequest2;
                            if (lcmPb$LcmRequest != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lcmPb$LcmRequest != null) {
                        u(lcmPb$LcmRequest);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b w(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
                this.f40723e |= 16;
                this.f40728j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b x(LcmPb$Common lcmPb$Common) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, lcmPb$Common)) == null) {
                if (lcmPb$Common != null) {
                    this.f40726h = lcmPb$Common;
                    this.f40723e |= 4;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b y(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
                this.f40723e |= 64;
                this.l = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b z(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048606, this, j2)) == null) {
                this.f40723e |= 1;
                this.f40724f = j2;
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
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$LcmRequest lcmPb$LcmRequest) {
            u(lcmPb$LcmRequest);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(299007074, "Lcom/baidu/lcp/sdk/pb/LcmPb$LcmRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(299007074, "Lcom/baidu/lcp/sdk/pb/LcmPb$LcmRequest;");
                return;
            }
        }
        PARSER = new a();
        LcmPb$LcmRequest lcmPb$LcmRequest = new LcmPb$LcmRequest(true);
        defaultInstance = lcmPb$LcmRequest;
        lcmPb$LcmRequest.initFields();
    }

    public /* synthetic */ LcmPb$LcmRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, c.a.u.a.e.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? defaultInstance : (LcmPb$LcmRequest) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.logId_ = 0L;
            this.token_ = "";
            this.common_ = LcmPb$Common.getDefaultInstance();
            this.timestamp_ = 0L;
            this.action_ = 0;
            this.startType_ = 0;
            this.connType_ = 0;
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static LcmPb$LcmRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LcmPb$LcmRequest) invokeL.objValue;
    }

    public static LcmPb$LcmRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LcmPb$LcmRequest) invokeL.objValue;
    }

    public int getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.action_ : invokeV.intValue;
    }

    public LcmPb$Common getCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.common_ : (LcmPb$Common) invokeV.objValue;
    }

    public int getConnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.connType_ : invokeV.intValue;
    }

    public long getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.logId_ : invokeV.longValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$LcmRequest> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PARSER : (Parser) invokeV.objValue;
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
            int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, getTokenBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.common_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.timestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt32Size(5, this.action_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt32Size(6, this.startType_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt32Size(7, this.connType_);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }
        return invokeV.intValue;
    }

    public int getStartType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.startType_ : invokeV.intValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.timestamp_ : invokeV.longValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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

    public boolean hasAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
    }

    public boolean hasCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasConnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
    }

    public boolean hasLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    public boolean hasStartType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
    }

    public boolean hasTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
    }

    public boolean hasToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasLogId()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(1, this.logId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getTokenBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.common_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.timestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.action_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.startType_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.connType_);
            }
        }
    }

    public /* synthetic */ LcmPb$LcmRequest(GeneratedMessageLite.Builder builder, c.a.u.a.e.a aVar) {
        this(builder);
    }

    public static b newBuilder(LcmPb$LcmRequest lcmPb$LcmRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, lcmPb$LcmRequest)) == null) {
            b newBuilder = newBuilder();
            newBuilder.u(lcmPb$LcmRequest);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static LcmPb$LcmRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LcmPb$LcmRequest) invokeLL.objValue;
    }

    public static LcmPb$LcmRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LcmPb$LcmRequest) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$LcmRequest getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? defaultInstance : (LcmPb$LcmRequest) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LcmPb$LcmRequest(GeneratedMessageLite.Builder builder) {
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

    public static LcmPb$LcmRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LcmPb$LcmRequest) invokeL.objValue;
    }

    public static LcmPb$LcmRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LcmPb$LcmRequest) invokeLL.objValue;
    }

    public static LcmPb$LcmRequest parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LcmPb$LcmRequest) invokeL.objValue;
    }

    public LcmPb$LcmRequest(boolean z) {
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

    public static LcmPb$LcmRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LcmPb$LcmRequest) invokeLL.objValue;
    }

    public static LcmPb$LcmRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LcmPb$LcmRequest) invokeL.objValue;
    }

    public static LcmPb$LcmRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LcmPb$LcmRequest) invokeLL.objValue;
    }

    public LcmPb$LcmRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.logId_ = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0_ |= 2;
                            this.token_ = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            LcmPb$Common.b builder = (this.bitField0_ & 4) == 4 ? this.common_.toBuilder() : null;
                            LcmPb$Common lcmPb$Common = (LcmPb$Common) codedInputStream.readMessage(LcmPb$Common.PARSER, extensionRegistryLite);
                            this.common_ = lcmPb$Common;
                            if (builder != null) {
                                builder.s(lcmPb$Common);
                                this.common_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                        } else if (readTag == 32) {
                            this.bitField0_ |= 8;
                            this.timestamp_ = codedInputStream.readInt64();
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.action_ = codedInputStream.readInt32();
                        } else if (readTag == 48) {
                            this.bitField0_ |= 32;
                            this.startType_ = codedInputStream.readInt32();
                        } else if (readTag != 56) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 64;
                            this.connType_ = codedInputStream.readInt32();
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
