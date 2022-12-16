package com.baidu.swan.bdtls.impl.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.in3;
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
public final class Bdtls$ApplicationData extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static Parser<Bdtls$ApplicationData> PARSER = null;
    public static final int SKR_FIELD_NUMBER = 1;
    public static final Bdtls$ApplicationData defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public ByteString sKR_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$ApplicationData> {
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
        public Bdtls$ApplicationData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new Bdtls$ApplicationData(codedInputStream, extensionRegistryLite, null);
            }
            return (Bdtls$ApplicationData) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ApplicationData, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public ByteString b;

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
            this.b = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        public static b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return new b();
            }
            return (b) invokeV.objValue;
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
                if (!s()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$ApplicationData build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                Bdtls$ApplicationData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (Bdtls$ApplicationData) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public Bdtls$ApplicationData buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Bdtls$ApplicationData bdtls$ApplicationData = new Bdtls$ApplicationData(this, (in3) null);
                int i = 1;
                if ((this.a & 1) != 1) {
                    i = 0;
                }
                bdtls$ApplicationData.sKR_ = this.b;
                bdtls$ApplicationData.bitField0_ = i;
                return bdtls$ApplicationData;
            }
            return (Bdtls$ApplicationData) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                super.clear();
                this.b = ByteString.EMPTY;
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
                q.t(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bdtls$ApplicationData getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return Bdtls$ApplicationData.getDefaultInstance();
            }
            return (Bdtls$ApplicationData) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                if ((this.a & 1) == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ApplicationData bdtls$ApplicationData) {
            t(bdtls$ApplicationData);
            return this;
        }

        public b t(Bdtls$ApplicationData bdtls$ApplicationData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bdtls$ApplicationData)) == null) {
                if (bdtls$ApplicationData == Bdtls$ApplicationData.getDefaultInstance()) {
                    return this;
                }
                if (bdtls$ApplicationData.hasSKR()) {
                    v(bdtls$ApplicationData.getSKR());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b v(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 1;
                    this.b = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, codedInputStream, extensionRegistryLite)) == null) {
                Bdtls$ApplicationData bdtls$ApplicationData = null;
                try {
                    try {
                        Bdtls$ApplicationData parsePartialFrom = Bdtls$ApplicationData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            t(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Bdtls$ApplicationData bdtls$ApplicationData2 = (Bdtls$ApplicationData) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bdtls$ApplicationData = bdtls$ApplicationData2;
                            if (bdtls$ApplicationData != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bdtls$ApplicationData != null) {
                        t(bdtls$ApplicationData);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-516969957, "Lcom/baidu/swan/bdtls/impl/model/Bdtls$ApplicationData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-516969957, "Lcom/baidu/swan/bdtls/impl/model/Bdtls$ApplicationData;");
                return;
            }
        }
        PARSER = new a();
        Bdtls$ApplicationData bdtls$ApplicationData = new Bdtls$ApplicationData(true);
        defaultInstance = bdtls$ApplicationData;
        bdtls$ApplicationData.initFields();
    }

    public static Bdtls$ApplicationData getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return defaultInstance;
        }
        return (Bdtls$ApplicationData) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.sKR_ = ByteString.EMPTY;
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return b.q();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ApplicationData getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return defaultInstance;
        }
        return (Bdtls$ApplicationData) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ApplicationData> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public ByteString getSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.sKR_;
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeBytesSize(1, this.sKR_);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean hasSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                if (b2 != 1) {
                    return false;
                }
                return true;
            } else if (!hasSKR()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    public Bdtls$ApplicationData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.sKR_ = codedInputStream.readBytes();
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

    public /* synthetic */ Bdtls$ApplicationData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, in3 in3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bdtls$ApplicationData(GeneratedMessageLite.Builder builder) {
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

    public /* synthetic */ Bdtls$ApplicationData(GeneratedMessageLite.Builder builder, in3 in3Var) {
        this(builder);
    }

    public static Bdtls$ApplicationData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (Bdtls$ApplicationData) invokeLL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (Bdtls$ApplicationData) invokeLL.objValue;
    }

    public Bdtls$ApplicationData(boolean z) {
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

    public static b newBuilder(Bdtls$ApplicationData bdtls$ApplicationData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bdtls$ApplicationData)) == null) {
            b newBuilder = newBuilder();
            newBuilder.t(bdtls$ApplicationData);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static Bdtls$ApplicationData parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (Bdtls$ApplicationData) invokeL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (Bdtls$ApplicationData) invokeL.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, this.sKR_);
            }
        }
    }

    public static Bdtls$ApplicationData parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (Bdtls$ApplicationData) invokeL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (Bdtls$ApplicationData) invokeLL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (Bdtls$ApplicationData) invokeL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (Bdtls$ApplicationData) invokeLL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (Bdtls$ApplicationData) invokeL.objValue;
    }

    public static Bdtls$ApplicationData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (Bdtls$ApplicationData) invokeLL.objValue;
    }
}
