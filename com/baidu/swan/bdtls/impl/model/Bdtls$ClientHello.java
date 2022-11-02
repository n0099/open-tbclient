package com.baidu.swan.bdtls.impl.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.tieba.in3;
import com.baidu.tieba.jn3;
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
public final class Bdtls$ClientHello extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CIPHERSUITES_FIELD_NUMBER = 2;
    public static final int EXTENSIONS_FIELD_NUMBER = 3;
    public static Parser<Bdtls$ClientHello> PARSER = null;
    public static final int RANDOM_FIELD_NUMBER = 1;
    public static final int SKR_FIELD_NUMBER = 4;
    public static final Bdtls$ClientHello defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public List<ByteString> cipherSuites_;
    public List<Bdtls$Extension> extensions_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public Bdtls$Random random_;
    public ByteString sKR_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$ClientHello> {
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
        public Bdtls$ClientHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new Bdtls$ClientHello(codedInputStream, extensionRegistryLite, null);
            }
            return (Bdtls$ClientHello) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ClientHello, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Bdtls$Random b;
        public List<ByteString> c;
        public List<Bdtls$Extension> d;
        public ByteString e;

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
            this.b = Bdtls$Random.getDefaultInstance();
            this.c = Collections.emptyList();
            this.d = Collections.emptyList();
            this.e = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (!y() || !x().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < w(); i++) {
                    if (!v(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                super.clear();
                this.b = Bdtls$Random.getDefaultInstance();
                this.a &= -2;
                this.c = Collections.emptyList();
                this.a &= -3;
                this.d = Collections.emptyList();
                int i = this.a & (-5);
                this.a = i;
                this.e = ByteString.EMPTY;
                this.a = i & (-9);
                return this;
            }
            return (b) invokeV.objValue;
        }

        public static b s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return new b();
            }
            return (b) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            q();
            return this;
        }

        public final void ensureExtensionsIsMutable() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (this.a & 4) != 4) {
                this.d = new ArrayList(this.d);
                this.a |= 4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: o */
        public Bdtls$ClientHello build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                Bdtls$ClientHello buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (Bdtls$ClientHello) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: r */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                b s = s();
                s.z(buildPartial());
                return s;
            }
            return (b) invokeV.objValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (this.a & 2) != 2) {
                this.c = new ArrayList(this.c);
                this.a |= 2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: u */
        public Bdtls$ClientHello getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return Bdtls$ClientHello.getDefaultInstance();
            }
            return (Bdtls$ClientHello) invokeV.objValue;
        }

        public int w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.d.size();
            }
            return invokeV.intValue;
        }

        public Bdtls$Random x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.b;
            }
            return (Bdtls$Random) invokeV.objValue;
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                if ((this.a & 1) == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b A(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                Bdtls$ClientHello bdtls$ClientHello = null;
                try {
                    try {
                        Bdtls$ClientHello parsePartialFrom = Bdtls$ClientHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            z(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Bdtls$ClientHello bdtls$ClientHello2 = (Bdtls$ClientHello) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bdtls$ClientHello = bdtls$ClientHello2;
                            if (bdtls$ClientHello != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bdtls$ClientHello != null) {
                        z(bdtls$ClientHello);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b B(Bdtls$Random bdtls$Random) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdtls$Random)) == null) {
                if ((this.a & 1) == 1 && this.b != Bdtls$Random.getDefaultInstance()) {
                    Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder(this.b);
                    newBuilder.u(bdtls$Random);
                    this.b = newBuilder.buildPartial();
                } else {
                    this.b = bdtls$Random;
                }
                this.a |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b C(Bdtls$Random bdtls$Random) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdtls$Random)) == null) {
                if (bdtls$Random != null) {
                    this.b = bdtls$Random;
                    this.a |= 1;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b D(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 8;
                    this.e = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b m(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, byteString)) == null) {
                if (byteString != null) {
                    t();
                    this.c.add(byteString);
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ClientHello bdtls$ClientHello) {
            z(bdtls$ClientHello);
            return this;
        }

        public b n(Bdtls$Extension bdtls$Extension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bdtls$Extension)) == null) {
                if (bdtls$Extension != null) {
                    ensureExtensionsIsMutable();
                    this.d.add(bdtls$Extension);
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public Bdtls$Extension v(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
                return this.d.get(i);
            }
            return (Bdtls$Extension) invokeI.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            q();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public Bdtls$ClientHello buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                Bdtls$ClientHello bdtls$ClientHello = new Bdtls$ClientHello(this, (in3) null);
                int i = this.a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                bdtls$ClientHello.random_ = this.b;
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                bdtls$ClientHello.cipherSuites_ = this.c;
                if ((this.a & 4) == 4) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.a &= -5;
                }
                bdtls$ClientHello.extensions_ = this.d;
                if ((i & 8) == 8) {
                    i2 |= 2;
                }
                bdtls$ClientHello.sKR_ = this.e;
                bdtls$ClientHello.bitField0_ = i2;
                return bdtls$ClientHello;
            }
            return (Bdtls$ClientHello) invokeV.objValue;
        }

        public b z(Bdtls$ClientHello bdtls$ClientHello) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, bdtls$ClientHello)) == null) {
                if (bdtls$ClientHello == Bdtls$ClientHello.getDefaultInstance()) {
                    return this;
                }
                if (bdtls$ClientHello.hasRandom()) {
                    B(bdtls$ClientHello.getRandom());
                }
                if (!bdtls$ClientHello.cipherSuites_.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = bdtls$ClientHello.cipherSuites_;
                        this.a &= -3;
                    } else {
                        t();
                        this.c.addAll(bdtls$ClientHello.cipherSuites_);
                    }
                }
                if (!bdtls$ClientHello.extensions_.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = bdtls$ClientHello.extensions_;
                        this.a &= -5;
                    } else {
                        ensureExtensionsIsMutable();
                        this.d.addAll(bdtls$ClientHello.extensions_);
                    }
                }
                if (bdtls$ClientHello.hasSKR()) {
                    D(bdtls$ClientHello.getSKR());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1097224718, "Lcom/baidu/swan/bdtls/impl/model/Bdtls$ClientHello;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1097224718, "Lcom/baidu/swan/bdtls/impl/model/Bdtls$ClientHello;");
                return;
            }
        }
        PARSER = new a();
        Bdtls$ClientHello bdtls$ClientHello = new Bdtls$ClientHello(true);
        defaultInstance = bdtls$ClientHello;
        bdtls$ClientHello.initFields();
    }

    public static Bdtls$ClientHello getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return defaultInstance;
        }
        return (Bdtls$ClientHello) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.random_ = Bdtls$Random.getDefaultInstance();
            this.cipherSuites_ = Collections.emptyList();
            this.extensions_ = Collections.emptyList();
            this.sKR_ = ByteString.EMPTY;
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65551, null)) != null) {
            return (b) invokeV.objValue;
        }
        return b.s();
    }

    public int getCipherSuitesCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cipherSuites_.size();
        }
        return invokeV.intValue;
    }

    public List<ByteString> getCipherSuitesList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cipherSuites_;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ClientHello getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return defaultInstance;
        }
        return (Bdtls$ClientHello) invokeV.objValue;
    }

    public int getExtensionsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.extensions_.size();
        }
        return invokeV.intValue;
    }

    public List<Bdtls$Extension> getExtensionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.extensions_;
        }
        return (List) invokeV.objValue;
    }

    public List<? extends jn3> getExtensionsOrBuilderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.extensions_;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ClientHello> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public Bdtls$Random getRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.random_;
        }
        return (Bdtls$Random) invokeV.objValue;
    }

    public ByteString getSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.sKR_;
        }
        return (ByteString) invokeV.objValue;
    }

    public boolean hasRandom() {
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

    public boolean hasSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: java.util.List<com.baidu.swan.bdtls.impl.model.Bdtls$Extension> */
    /* JADX WARN: Multi-variable type inference failed */
    public Bdtls$ClientHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 10) {
                                if (readTag != 18) {
                                    if (readTag != 26) {
                                        if (readTag != 34) {
                                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                            }
                                        } else {
                                            this.bitField0_ |= 2;
                                            this.sKR_ = codedInputStream.readBytes();
                                        }
                                    } else {
                                        if (!(z2 & true)) {
                                            this.extensions_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.cipherSuites_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.cipherSuites_.add(codedInputStream.readBytes());
                                }
                            } else {
                                Bdtls$Random.b builder = (this.bitField0_ & 1) == 1 ? this.random_.toBuilder() : null;
                                Bdtls$Random bdtls$Random = (Bdtls$Random) codedInputStream.readMessage(Bdtls$Random.PARSER, extensionRegistryLite);
                                this.random_ = bdtls$Random;
                                if (builder != null) {
                                    builder.u(bdtls$Random);
                                    this.random_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
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
                    this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
                }
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ Bdtls$ClientHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, in3 in3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bdtls$ClientHello(GeneratedMessageLite.Builder builder) {
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

    public /* synthetic */ Bdtls$ClientHello(GeneratedMessageLite.Builder builder, in3 in3Var) {
        this(builder);
    }

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (Bdtls$ClientHello) invokeLL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (Bdtls$ClientHello) invokeLL.objValue;
    }

    public Bdtls$ClientHello(boolean z) {
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

    public static b newBuilder(Bdtls$ClientHello bdtls$ClientHello) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bdtls$ClientHello)) == null) {
            b newBuilder = newBuilder();
            newBuilder.z(bdtls$ClientHello);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (Bdtls$ClientHello) invokeL.objValue;
    }

    public ByteString getCipherSuites(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.cipherSuites_.get(i);
        }
        return (ByteString) invokeI.objValue;
    }

    public Bdtls$Extension getExtensions(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.extensions_.get(i);
        }
        return (Bdtls$Extension) invokeI.objValue;
    }

    public jn3 getExtensionsOrBuilder(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.extensions_.get(i);
        }
        return (jn3) invokeI.objValue;
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (Bdtls$ClientHello) invokeLL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (Bdtls$ClientHello) invokeLL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (Bdtls$ClientHello) invokeLL.objValue;
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
                i = CodedOutputStream.computeMessageSize(1, this.random_) + 0;
            } else {
                i = 0;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.cipherSuites_.size(); i4++) {
                i3 += CodedOutputStream.computeBytesSizeNoTag(this.cipherSuites_.get(i4));
            }
            int size = i + i3 + (getCipherSuitesList().size() * 1);
            for (int i5 = 0; i5 < this.extensions_.size(); i5++) {
                size += CodedOutputStream.computeMessageSize(3, this.extensions_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeBytesSize(4, this.sKR_);
            }
            this.memoizedSerializedSize = size;
            return size;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                if (b2 == 1) {
                    return true;
                }
                return false;
            } else if (!hasRandom()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!getRandom().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i = 0; i < getExtensionsCount(); i++) {
                    if (!getExtensions(i).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.random_);
            }
            for (int i = 0; i < this.cipherSuites_.size(); i++) {
                codedOutputStream.writeBytes(2, this.cipherSuites_.get(i));
            }
            for (int i2 = 0; i2 < this.extensions_.size(); i2++) {
                codedOutputStream.writeMessage(3, this.extensions_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(4, this.sKR_);
            }
        }
    }
}
