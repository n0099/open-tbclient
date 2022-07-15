package com.baidu.lcp.sdk.pb;

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
import com.repackage.f70;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes2.dex */
public final class LcmPb$LcmNotify extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_FIELD_NUMBER = 2;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static Parser<LcmPb$LcmNotify> PARSER;
    public static final LcmPb$LcmNotify defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int action_;
    public int bitField0_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<LcmPb$LcmNotify> {
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
        public LcmPb$LcmNotify parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LcmPb$LcmNotify(codedInputStream, extensionRegistryLite, null) : (LcmPb$LcmNotify) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$LcmNotify, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public int c;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? s() : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$LcmNotify build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                LcmPb$LcmNotify buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (LcmPb$LcmNotify) invokeV.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
        public LcmPb$LcmNotify buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                LcmPb$LcmNotify lcmPb$LcmNotify = new LcmPb$LcmNotify(this, (f70) null);
                int i = this.a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lcmPb$LcmNotify.logId_ = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lcmPb$LcmNotify.action_ = this.c;
                lcmPb$LcmNotify.bitField0_ = i2;
                return lcmPb$LcmNotify;
            }
            return (LcmPb$LcmNotify) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                super.clear();
                this.b = 0L;
                int i = this.a & (-2);
                this.a = i;
                this.c = 0;
                this.a = i & (-3);
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
                q.t(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$LcmNotify getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? LcmPb$LcmNotify.getDefaultInstance() : (LcmPb$LcmNotify) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.a & 1) == 1 : invokeV.booleanValue;
        }

        public b t(LcmPb$LcmNotify lcmPb$LcmNotify) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, lcmPb$LcmNotify)) == null) {
                if (lcmPb$LcmNotify == LcmPb$LcmNotify.getDefaultInstance()) {
                    return this;
                }
                if (lcmPb$LcmNotify.hasLogId()) {
                    w(lcmPb$LcmNotify.getLogId());
                }
                if (lcmPb$LcmNotify.hasAction()) {
                    v(lcmPb$LcmNotify.getAction());
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, codedInputStream, extensionRegistryLite)) == null) {
                LcmPb$LcmNotify lcmPb$LcmNotify = null;
                try {
                    try {
                        LcmPb$LcmNotify parsePartialFrom = LcmPb$LcmNotify.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            t(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        LcmPb$LcmNotify lcmPb$LcmNotify2 = (LcmPb$LcmNotify) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            lcmPb$LcmNotify = lcmPb$LcmNotify2;
                            if (lcmPb$LcmNotify != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lcmPb$LcmNotify != null) {
                        t(lcmPb$LcmNotify);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b v(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
                this.a |= 2;
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b w(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j)) == null) {
                this.a |= 1;
                this.b = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$LcmNotify lcmPb$LcmNotify) {
            t(lcmPb$LcmNotify);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1727643012, "Lcom/baidu/lcp/sdk/pb/LcmPb$LcmNotify;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1727643012, "Lcom/baidu/lcp/sdk/pb/LcmPb$LcmNotify;");
                return;
            }
        }
        PARSER = new a();
        LcmPb$LcmNotify lcmPb$LcmNotify = new LcmPb$LcmNotify(true);
        defaultInstance = lcmPb$LcmNotify;
        lcmPb$LcmNotify.initFields();
    }

    public /* synthetic */ LcmPb$LcmNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, f70 f70Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? defaultInstance : (LcmPb$LcmNotify) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.logId_ = 0L;
            this.action_ = 0;
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static LcmPb$LcmNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LcmPb$LcmNotify) invokeL.objValue;
    }

    public static LcmPb$LcmNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LcmPb$LcmNotify) invokeL.objValue;
    }

    public int getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.action_ : invokeV.intValue;
    }

    public long getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.logId_ : invokeV.longValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$LcmNotify> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? PARSER : (Parser) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt32Size(2, this.action_);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }
        return invokeV.intValue;
    }

    public boolean hasAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    public boolean hasLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(1, this.logId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.action_);
            }
        }
    }

    public /* synthetic */ LcmPb$LcmNotify(GeneratedMessageLite.Builder builder, f70 f70Var) {
        this(builder);
    }

    public static b newBuilder(LcmPb$LcmNotify lcmPb$LcmNotify) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, lcmPb$LcmNotify)) == null) {
            b newBuilder = newBuilder();
            newBuilder.t(lcmPb$LcmNotify);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static LcmPb$LcmNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LcmPb$LcmNotify) invokeLL.objValue;
    }

    public static LcmPb$LcmNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LcmPb$LcmNotify) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$LcmNotify getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (LcmPb$LcmNotify) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LcmPb$LcmNotify(GeneratedMessageLite.Builder builder) {
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

    public static LcmPb$LcmNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LcmPb$LcmNotify) invokeL.objValue;
    }

    public static LcmPb$LcmNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LcmPb$LcmNotify) invokeLL.objValue;
    }

    public static LcmPb$LcmNotify parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LcmPb$LcmNotify) invokeL.objValue;
    }

    public LcmPb$LcmNotify(boolean z) {
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

    public static LcmPb$LcmNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LcmPb$LcmNotify) invokeLL.objValue;
    }

    public static LcmPb$LcmNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LcmPb$LcmNotify) invokeL.objValue;
    }

    public static LcmPb$LcmNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LcmPb$LcmNotify) invokeLL.objValue;
    }

    public LcmPb$LcmNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.logId_ = codedInputStream.readInt64();
                            } else if (readTag != 16) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.action_ = codedInputStream.readInt32();
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
