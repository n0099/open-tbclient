package com.baidu.swan.bdtls.impl.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.tieba.jn3;
import com.baidu.tieba.kn3;
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
public final class Bdtls$ServerHello extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CIPHERSUITE_FIELD_NUMBER = 2;
    public static final int EXTENSIONS_FIELD_NUMBER = 5;
    public static final int LIFETIME_FIELD_NUMBER = 3;
    public static Parser<Bdtls$ServerHello> PARSER = null;
    public static final int RANDOM_FIELD_NUMBER = 1;
    public static final int SKR_FIELD_NUMBER = 4;
    public static final Bdtls$ServerHello defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitField0_;
    public ByteString cipherSuite_;
    public List<Bdtls$Extension> extensions_;
    public int lifeTime_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public Bdtls$Random random_;
    public ByteString sKR_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$ServerHello> {
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
        public Bdtls$ServerHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) {
                return new Bdtls$ServerHello(codedInputStream, extensionRegistryLite, null);
            }
            return (Bdtls$ServerHello) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ServerHello, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Bdtls$Random b;
        public ByteString c;
        public int d;
        public ByteString e;
        public List<Bdtls$Extension> f;

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
            this.b = Bdtls$Random.getDefaultInstance();
            ByteString byteString = ByteString.EMPTY;
            this.c = byteString;
            this.e = byteString;
            this.f = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                super.clear();
                this.b = Bdtls$Random.getDefaultInstance();
                int i = this.a & (-2);
                this.a = i;
                ByteString byteString = ByteString.EMPTY;
                this.c = byteString;
                int i2 = i & (-3);
                this.a = i2;
                this.d = 0;
                int i3 = i2 & (-5);
                this.a = i3;
                this.e = byteString;
                this.a = i3 & (-9);
                this.f = Collections.emptyList();
                this.a &= -17;
                return this;
            }
            return (b) invokeV.objValue;
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

        public final void ensureExtensionsIsMutable() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (this.a & 16) != 16) {
                this.f = new ArrayList(this.f);
                this.a |= 16;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$ServerHello build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                Bdtls$ServerHello buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (Bdtls$ServerHello) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                b q = q();
                q.z(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bdtls$ServerHello getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return Bdtls$ServerHello.getDefaultInstance();
            }
            return (Bdtls$ServerHello) invokeV.objValue;
        }

        public int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.f.size();
            }
            return invokeV.intValue;
        }

        public Bdtls$Random u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.b;
            }
            return (Bdtls$Random) invokeV.objValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                if ((this.a & 2) == 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                if ((this.a & 4) == 4) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean x() {
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

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                if ((this.a & 8) == 8) {
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
                Bdtls$ServerHello bdtls$ServerHello = null;
                try {
                    try {
                        Bdtls$ServerHello parsePartialFrom = Bdtls$ServerHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            z(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Bdtls$ServerHello bdtls$ServerHello2 = (Bdtls$ServerHello) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bdtls$ServerHello = bdtls$ServerHello2;
                            if (bdtls$ServerHello != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bdtls$ServerHello != null) {
                        z(bdtls$ServerHello);
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

        public b C(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 2;
                    this.c = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b D(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.a |= 4;
                this.d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b E(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 8;
                    this.e = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ServerHello bdtls$ServerHello) {
            z(bdtls$ServerHello);
            return this;
        }

        public Bdtls$Extension s(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
                return this.f.get(i);
            }
            return (Bdtls$Extension) invokeI.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (!x() || !v() || !w() || !y() || !u().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < t(); i++) {
                    if (!s(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
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
        /* renamed from: n */
        public Bdtls$ServerHello buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                Bdtls$ServerHello bdtls$ServerHello = new Bdtls$ServerHello(this, (jn3) null);
                int i = this.a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                bdtls$ServerHello.random_ = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bdtls$ServerHello.cipherSuite_ = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                bdtls$ServerHello.lifeTime_ = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                bdtls$ServerHello.sKR_ = this.e;
                if ((this.a & 16) == 16) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.a &= -17;
                }
                bdtls$ServerHello.extensions_ = this.f;
                bdtls$ServerHello.bitField0_ = i2;
                return bdtls$ServerHello;
            }
            return (Bdtls$ServerHello) invokeV.objValue;
        }

        public b z(Bdtls$ServerHello bdtls$ServerHello) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, bdtls$ServerHello)) == null) {
                if (bdtls$ServerHello == Bdtls$ServerHello.getDefaultInstance()) {
                    return this;
                }
                if (bdtls$ServerHello.hasRandom()) {
                    B(bdtls$ServerHello.getRandom());
                }
                if (bdtls$ServerHello.hasCipherSuite()) {
                    C(bdtls$ServerHello.getCipherSuite());
                }
                if (bdtls$ServerHello.hasLifeTime()) {
                    D(bdtls$ServerHello.getLifeTime());
                }
                if (bdtls$ServerHello.hasSKR()) {
                    E(bdtls$ServerHello.getSKR());
                }
                if (!bdtls$ServerHello.extensions_.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = bdtls$ServerHello.extensions_;
                        this.a &= -17;
                    } else {
                        ensureExtensionsIsMutable();
                        this.f.addAll(bdtls$ServerHello.extensions_);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(145298310, "Lcom/baidu/swan/bdtls/impl/model/Bdtls$ServerHello;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(145298310, "Lcom/baidu/swan/bdtls/impl/model/Bdtls$ServerHello;");
                return;
            }
        }
        PARSER = new a();
        Bdtls$ServerHello bdtls$ServerHello = new Bdtls$ServerHello(true);
        defaultInstance = bdtls$ServerHello;
        bdtls$ServerHello.initFields();
    }

    public static Bdtls$ServerHello getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return defaultInstance;
        }
        return (Bdtls$ServerHello) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.random_ = Bdtls$Random.getDefaultInstance();
            ByteString byteString = ByteString.EMPTY;
            this.cipherSuite_ = byteString;
            this.lifeTime_ = 0;
            this.sKR_ = byteString;
            this.extensions_ = Collections.emptyList();
        }
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65551, null)) != null) {
            return (b) invokeV.objValue;
        }
        return b.q();
    }

    public ByteString getCipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cipherSuite_;
        }
        return (ByteString) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ServerHello getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return defaultInstance;
        }
        return (Bdtls$ServerHello) invokeV.objValue;
    }

    public int getExtensionsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.extensions_.size();
        }
        return invokeV.intValue;
    }

    public List<Bdtls$Extension> getExtensionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.extensions_;
        }
        return (List) invokeV.objValue;
    }

    public List<? extends kn3> getExtensionsOrBuilderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.extensions_;
        }
        return (List) invokeV.objValue;
    }

    public int getLifeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.lifeTime_;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ServerHello> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return PARSER;
        }
        return (Parser) invokeV.objValue;
    }

    public Bdtls$Random getRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.random_;
        }
        return (Bdtls$Random) invokeV.objValue;
    }

    public ByteString getSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.sKR_;
        }
        return (ByteString) invokeV.objValue;
    }

    public boolean hasCipherSuite() {
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

    public boolean hasLifeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if ((this.bitField0_ & 8) == 8) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return newBuilder();
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return newBuilder(this);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return super.writeReplace();
        }
        return invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List<com.baidu.swan.bdtls.impl.model.Bdtls$Extension> */
    /* JADX WARN: Multi-variable type inference failed */
    public Bdtls$ServerHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (readTag != 24) {
                                        if (readTag != 34) {
                                            if (readTag != 42) {
                                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                                }
                                            } else {
                                                if (!(z2 & true)) {
                                                    this.extensions_ = new ArrayList();
                                                    z2 |= true;
                                                }
                                                this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                                            }
                                        } else {
                                            this.bitField0_ |= 8;
                                            this.sKR_ = codedInputStream.readBytes();
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.lifeTime_ = codedInputStream.readUInt32();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.cipherSuite_ = codedInputStream.readBytes();
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
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ Bdtls$ServerHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, jn3 jn3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bdtls$ServerHello(GeneratedMessageLite.Builder builder) {
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

    public /* synthetic */ Bdtls$ServerHello(GeneratedMessageLite.Builder builder, jn3 jn3Var) {
        this(builder);
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        return (Bdtls$ServerHello) invokeLL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, byteString, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }
        return (Bdtls$ServerHello) invokeLL.objValue;
    }

    public Bdtls$ServerHello(boolean z) {
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

    public static b newBuilder(Bdtls$ServerHello bdtls$ServerHello) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bdtls$ServerHello)) == null) {
            b newBuilder = newBuilder();
            newBuilder.z(bdtls$ServerHello);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) {
            return PARSER.parseDelimitedFrom(inputStream);
        }
        return (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, byteString)) == null) {
            return PARSER.parseFrom(byteString);
        }
        return (Bdtls$ServerHello) invokeL.objValue;
    }

    public Bdtls$Extension getExtensions(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.extensions_.get(i);
        }
        return (Bdtls$Extension) invokeI.objValue;
    }

    public kn3 getExtensionsOrBuilder(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.extensions_.get(i);
        }
        return (kn3) invokeI.objValue;
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, codedInputStream)) == null) {
            return PARSER.parseFrom(codedInputStream);
        }
        return (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, codedInputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }
        return (Bdtls$ServerHello) invokeLL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) {
            return PARSER.parseFrom(inputStream);
        }
        return (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }
        return (Bdtls$ServerHello) invokeLL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) {
            return PARSER.parseFrom(bArr);
        }
        return (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, extensionRegistryLite)) == null) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }
        return (Bdtls$ServerHello) invokeLL.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i = CodedOutputStream.computeMessageSize(1, this.random_) + 0;
            } else {
                i = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeBytesSize(2, this.cipherSuite_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeUInt32Size(3, this.lifeTime_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.computeBytesSize(4, this.sKR_);
            }
            for (int i3 = 0; i3 < this.extensions_.size(); i3++) {
                i += CodedOutputStream.computeMessageSize(5, this.extensions_.get(i3));
            }
            this.memoizedSerializedSize = i;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                if (b2 == 1) {
                    return true;
                }
                return false;
            } else if (!hasRandom()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasCipherSuite()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasLifeTime()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasSKR()) {
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
        if (interceptable == null || interceptable.invokeL(1048599, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.random_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, this.cipherSuite_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeUInt32(3, this.lifeTime_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, this.sKR_);
            }
            for (int i = 0; i < this.extensions_.size(); i++) {
                codedOutputStream.writeMessage(5, this.extensions_.get(i));
            }
        }
    }
}
