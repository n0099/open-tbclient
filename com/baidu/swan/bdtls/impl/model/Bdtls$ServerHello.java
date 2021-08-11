package com.baidu.swan.bdtls.impl.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
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
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class a extends AbstractParser<Bdtls$ServerHello> {
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
        public Bdtls$ServerHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Bdtls$ServerHello(codedInputStream, extensionRegistryLite, null) : (Bdtls$ServerHello) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ServerHello, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f46573e;

        /* renamed from: f  reason: collision with root package name */
        public Bdtls$Random f46574f;

        /* renamed from: g  reason: collision with root package name */
        public ByteString f46575g;

        /* renamed from: h  reason: collision with root package name */
        public int f46576h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f46577i;

        /* renamed from: j  reason: collision with root package name */
        public List<Bdtls$Extension> f46578j;

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
            this.f46574f = Bdtls$Random.getDefaultInstance();
            ByteString byteString = ByteString.EMPTY;
            this.f46575g = byteString;
            this.f46577i = byteString;
            this.f46578j = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public static b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
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
                    } catch (InvalidProtocolBufferException e2) {
                        Bdtls$ServerHello bdtls$ServerHello2 = (Bdtls$ServerHello) e2.getUnfinishedMessage();
                        try {
                            throw e2;
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
                if ((this.f46573e & 1) == 1 && this.f46574f != Bdtls$Random.getDefaultInstance()) {
                    Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder(this.f46574f);
                    newBuilder.u(bdtls$Random);
                    this.f46574f = newBuilder.buildPartial();
                } else {
                    this.f46574f = bdtls$Random;
                }
                this.f46573e |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b C(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteString)) == null) {
                if (byteString != null) {
                    this.f46573e |= 2;
                    this.f46575g = byteString;
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
                this.f46573e |= 4;
                this.f46576h = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b E(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) {
                if (byteString != null) {
                    this.f46573e |= 8;
                    this.f46577i = byteString;
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

        public final void ensureExtensionsIsMutable() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (this.f46573e & 16) == 16) {
                return;
            }
            this.f46578j = new ArrayList(this.f46578j);
            this.f46573e |= 16;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (x() && v() && w() && y() && u().isInitialized()) {
                    for (int i2 = 0; i2 < t(); i2++) {
                        if (!s(i2).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                Bdtls$ServerHello bdtls$ServerHello = new Bdtls$ServerHello(this, (c.a.n0.c.a.i.a) null);
                int i2 = this.f46573e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                bdtls$ServerHello.random_ = this.f46574f;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                bdtls$ServerHello.cipherSuite_ = this.f46575g;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                bdtls$ServerHello.lifeTime_ = this.f46576h;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                bdtls$ServerHello.sKR_ = this.f46577i;
                if ((this.f46573e & 16) == 16) {
                    this.f46578j = Collections.unmodifiableList(this.f46578j);
                    this.f46573e &= -17;
                }
                bdtls$ServerHello.extensions_ = this.f46578j;
                bdtls$ServerHello.bitField0_ = i3;
                return bdtls$ServerHello;
            }
            return (Bdtls$ServerHello) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                super.clear();
                this.f46574f = Bdtls$Random.getDefaultInstance();
                int i2 = this.f46573e & (-2);
                this.f46573e = i2;
                ByteString byteString = ByteString.EMPTY;
                this.f46575g = byteString;
                int i3 = i2 & (-3);
                this.f46573e = i3;
                this.f46576h = 0;
                int i4 = i3 & (-5);
                this.f46573e = i4;
                this.f46577i = byteString;
                this.f46573e = i4 & (-9);
                this.f46578j = Collections.emptyList();
                this.f46573e &= -17;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? Bdtls$ServerHello.getDefaultInstance() : (Bdtls$ServerHello) invokeV.objValue;
        }

        public Bdtls$Extension s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? this.f46578j.get(i2) : (Bdtls$Extension) invokeI.objValue;
        }

        public int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f46578j.size() : invokeV.intValue;
        }

        public Bdtls$Random u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f46574f : (Bdtls$Random) invokeV.objValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f46573e & 2) == 2 : invokeV.booleanValue;
        }

        public boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.f46573e & 4) == 4 : invokeV.booleanValue;
        }

        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.f46573e & 1) == 1 : invokeV.booleanValue;
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.f46573e & 8) == 8 : invokeV.booleanValue;
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
                    if (this.f46578j.isEmpty()) {
                        this.f46578j = bdtls$ServerHello.extensions_;
                        this.f46573e &= -17;
                    } else {
                        ensureExtensionsIsMutable();
                        this.f46578j.addAll(bdtls$ServerHello.extensions_);
                    }
                }
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
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ServerHello bdtls$ServerHello) {
            z(bdtls$ServerHello);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
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

    public /* synthetic */ Bdtls$ServerHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, c.a.n0.c.a.i.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Bdtls$ServerHello getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? defaultInstance : (Bdtls$ServerHello) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Bdtls$ServerHello) invokeL.objValue;
    }

    public ByteString getCipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cipherSuite_ : (ByteString) invokeV.objValue;
    }

    public Bdtls$Extension getExtensions(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.extensions_.get(i2) : (Bdtls$Extension) invokeI.objValue;
    }

    public int getExtensionsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.extensions_.size() : invokeV.intValue;
    }

    public List<Bdtls$Extension> getExtensionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.extensions_ : (List) invokeV.objValue;
    }

    public c.a.n0.c.a.i.b getExtensionsOrBuilder(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.extensions_.get(i2) : (c.a.n0.c.a.i.b) invokeI.objValue;
    }

    public List<? extends c.a.n0.c.a.i.b> getExtensionsOrBuilderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.extensions_ : (List) invokeV.objValue;
    }

    public int getLifeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.lifeTime_ : invokeV.intValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ServerHello> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? PARSER : (Parser) invokeV.objValue;
    }

    public Bdtls$Random getRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.random_ : (Bdtls$Random) invokeV.objValue;
    }

    public ByteString getSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sKR_ : (ByteString) invokeV.objValue;
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
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.random_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeBytesSize(2, this.cipherSuite_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeUInt32Size(3, this.lifeTime_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeBytesSize(4, this.sKR_);
            }
            for (int i3 = 0; i3 < this.extensions_.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, this.extensions_.get(i3));
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }
        return invokeV.intValue;
    }

    public boolean hasCipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    public boolean hasLifeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    public boolean hasSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
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
                for (int i2 = 0; i2 < getExtensionsCount(); i2++) {
                    if (!getExtensions(i2).isInitialized()) {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? super.writeReplace() : invokeV.objValue;
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
            for (int i2 = 0; i2 < this.extensions_.size(); i2++) {
                codedOutputStream.writeMessage(5, this.extensions_.get(i2));
            }
        }
    }

    public /* synthetic */ Bdtls$ServerHello(GeneratedMessageLite.Builder builder, c.a.n0.c.a.i.a aVar) {
        this(builder);
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

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Bdtls$ServerHello) invokeLL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Bdtls$ServerHello) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ServerHello getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Bdtls$ServerHello) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
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

    public static Bdtls$ServerHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Bdtls$ServerHello) invokeLL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Bdtls$ServerHello) invokeL.objValue;
    }

    public Bdtls$ServerHello(boolean z) {
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

    public static Bdtls$ServerHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Bdtls$ServerHello) invokeLL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Bdtls$ServerHello) invokeL.objValue;
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Bdtls$ServerHello) invokeLL.objValue;
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
                            if (readTag == 10) {
                                Bdtls$Random.b builder = (this.bitField0_ & 1) == 1 ? this.random_.toBuilder() : null;
                                Bdtls$Random bdtls$Random = (Bdtls$Random) codedInputStream.readMessage(Bdtls$Random.PARSER, extensionRegistryLite);
                                this.random_ = bdtls$Random;
                                if (builder != null) {
                                    builder.u(bdtls$Random);
                                    this.random_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.cipherSuite_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.lifeTime_ = codedInputStream.readUInt32();
                            } else if (readTag == 34) {
                                this.bitField0_ |= 8;
                                this.sKR_ = codedInputStream.readBytes();
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.extensions_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }
}
