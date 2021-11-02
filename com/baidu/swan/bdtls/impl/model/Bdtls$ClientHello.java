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
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class a extends AbstractParser<Bdtls$ClientHello> {
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
        public Bdtls$ClientHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Bdtls$ClientHello(codedInputStream, extensionRegistryLite, null) : (Bdtls$ClientHello) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ClientHello, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f44445e;

        /* renamed from: f  reason: collision with root package name */
        public Bdtls$Random f44446f;

        /* renamed from: g  reason: collision with root package name */
        public List<ByteString> f44447g;

        /* renamed from: h  reason: collision with root package name */
        public List<Bdtls$Extension> f44448h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f44449i;

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
            this.f44446f = Bdtls$Random.getDefaultInstance();
            this.f44447g = Collections.emptyList();
            this.f44448h = Collections.emptyList();
            this.f44449i = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        public static b s() {
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
                Bdtls$ClientHello bdtls$ClientHello = null;
                try {
                    try {
                        Bdtls$ClientHello parsePartialFrom = Bdtls$ClientHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            z(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Bdtls$ClientHello bdtls$ClientHello2 = (Bdtls$ClientHello) e2.getUnfinishedMessage();
                        try {
                            throw e2;
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
                if ((this.f44445e & 1) == 1 && this.f44446f != Bdtls$Random.getDefaultInstance()) {
                    Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder(this.f44446f);
                    newBuilder.u(bdtls$Random);
                    this.f44446f = newBuilder.buildPartial();
                } else {
                    this.f44446f = bdtls$Random;
                }
                this.f44445e |= 1;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b C(Bdtls$Random bdtls$Random) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdtls$Random)) == null) {
                if (bdtls$Random != null) {
                    this.f44446f = bdtls$Random;
                    this.f44445e |= 1;
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
                    this.f44445e |= 8;
                    this.f44449i = byteString;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            q();
            return this;
        }

        public final void ensureExtensionsIsMutable() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (this.f44445e & 4) == 4) {
                return;
            }
            this.f44448h = new ArrayList(this.f44448h);
            this.f44445e |= 4;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (y() && x().isInitialized()) {
                    for (int i2 = 0; i2 < w(); i2++) {
                        if (!v(i2).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public b m(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, byteString)) == null) {
                if (byteString != null) {
                    t();
                    this.f44447g.add(byteString);
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b n(Bdtls$Extension bdtls$Extension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bdtls$Extension)) == null) {
                if (bdtls$Extension != null) {
                    ensureExtensionsIsMutable();
                    this.f44448h.add(bdtls$Extension);
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
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
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public Bdtls$ClientHello buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                Bdtls$ClientHello bdtls$ClientHello = new Bdtls$ClientHello(this, (b.a.p0.c.a.i.a) null);
                int i2 = this.f44445e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                bdtls$ClientHello.random_ = this.f44446f;
                if ((this.f44445e & 2) == 2) {
                    this.f44447g = Collections.unmodifiableList(this.f44447g);
                    this.f44445e &= -3;
                }
                bdtls$ClientHello.cipherSuites_ = this.f44447g;
                if ((this.f44445e & 4) == 4) {
                    this.f44448h = Collections.unmodifiableList(this.f44448h);
                    this.f44445e &= -5;
                }
                bdtls$ClientHello.extensions_ = this.f44448h;
                if ((i2 & 8) == 8) {
                    i3 |= 2;
                }
                bdtls$ClientHello.sKR_ = this.f44449i;
                bdtls$ClientHello.bitField0_ = i3;
                return bdtls$ClientHello;
            }
            return (Bdtls$ClientHello) invokeV.objValue;
        }

        public b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                super.clear();
                this.f44446f = Bdtls$Random.getDefaultInstance();
                this.f44445e &= -2;
                this.f44447g = Collections.emptyList();
                this.f44445e &= -3;
                this.f44448h = Collections.emptyList();
                int i2 = this.f44445e & (-5);
                this.f44445e = i2;
                this.f44449i = ByteString.EMPTY;
                this.f44445e = i2 & (-9);
                return this;
            }
            return (b) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (this.f44445e & 2) == 2) {
                return;
            }
            this.f44447g = new ArrayList(this.f44447g);
            this.f44445e |= 2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: u */
        public Bdtls$ClientHello getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? Bdtls$ClientHello.getDefaultInstance() : (Bdtls$ClientHello) invokeV.objValue;
        }

        public Bdtls$Extension v(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.f44448h.get(i2) : (Bdtls$Extension) invokeI.objValue;
        }

        public int w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f44448h.size() : invokeV.intValue;
        }

        public Bdtls$Random x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f44446f : (Bdtls$Random) invokeV.objValue;
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.f44445e & 1) == 1 : invokeV.booleanValue;
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
                    if (this.f44447g.isEmpty()) {
                        this.f44447g = bdtls$ClientHello.cipherSuites_;
                        this.f44445e &= -3;
                    } else {
                        t();
                        this.f44447g.addAll(bdtls$ClientHello.cipherSuites_);
                    }
                }
                if (!bdtls$ClientHello.extensions_.isEmpty()) {
                    if (this.f44448h.isEmpty()) {
                        this.f44448h = bdtls$ClientHello.extensions_;
                        this.f44445e &= -5;
                    } else {
                        ensureExtensionsIsMutable();
                        this.f44448h.addAll(bdtls$ClientHello.extensions_);
                    }
                }
                if (bdtls$ClientHello.hasSKR()) {
                    D(bdtls$ClientHello.getSKR());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            q();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ClientHello bdtls$ClientHello) {
            z(bdtls$ClientHello);
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

    public /* synthetic */ Bdtls$ClientHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, b.a.p0.c.a.i.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Bdtls$ClientHello getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? defaultInstance : (Bdtls$ClientHello) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? b.s() : (b) invokeV.objValue;
    }

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Bdtls$ClientHello) invokeL.objValue;
    }

    public ByteString getCipherSuites(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.cipherSuites_.get(i2) : (ByteString) invokeI.objValue;
    }

    public int getCipherSuitesCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cipherSuites_.size() : invokeV.intValue;
    }

    public List<ByteString> getCipherSuitesList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cipherSuites_ : (List) invokeV.objValue;
    }

    public Bdtls$Extension getExtensions(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.extensions_.get(i2) : (Bdtls$Extension) invokeI.objValue;
    }

    public int getExtensionsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.extensions_.size() : invokeV.intValue;
    }

    public List<Bdtls$Extension> getExtensionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.extensions_ : (List) invokeV.objValue;
    }

    public b.a.p0.c.a.i.b getExtensionsOrBuilder(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.extensions_.get(i2) : (b.a.p0.c.a.i.b) invokeI.objValue;
    }

    public List<? extends b.a.p0.c.a.i.b> getExtensionsOrBuilderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.extensions_ : (List) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ClientHello> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? PARSER : (Parser) invokeV.objValue;
    }

    public Bdtls$Random getRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.random_ : (Bdtls$Random) invokeV.objValue;
    }

    public ByteString getSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.sKR_ : (ByteString) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.random_) + 0 : 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.cipherSuites_.size(); i4++) {
                i3 += CodedOutputStream.computeBytesSizeNoTag(this.cipherSuites_.get(i4));
            }
            int size = computeMessageSize + i3 + (getCipherSuitesList().size() * 1);
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

    public boolean hasRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    public boolean hasSKR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasRandom()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.random_);
            }
            for (int i2 = 0; i2 < this.cipherSuites_.size(); i2++) {
                codedOutputStream.writeBytes(2, this.cipherSuites_.get(i2));
            }
            for (int i3 = 0; i3 < this.extensions_.size(); i3++) {
                codedOutputStream.writeMessage(3, this.extensions_.get(i3));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(4, this.sKR_);
            }
        }
    }

    public /* synthetic */ Bdtls$ClientHello(GeneratedMessageLite.Builder builder, b.a.p0.c.a.i.a aVar) {
        this(builder);
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

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Bdtls$ClientHello) invokeLL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Bdtls$ClientHello) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ClientHello getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? defaultInstance : (Bdtls$ClientHello) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
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

    public static Bdtls$ClientHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Bdtls$ClientHello) invokeLL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Bdtls$ClientHello) invokeL.objValue;
    }

    public Bdtls$ClientHello(boolean z) {
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

    public static Bdtls$ClientHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Bdtls$ClientHello) invokeLL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Bdtls$ClientHello) invokeL.objValue;
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Bdtls$ClientHello) invokeLL.objValue;
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
                                if (!(z2 & true)) {
                                    this.cipherSuites_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.cipherSuites_.add(codedInputStream.readBytes());
                            } else if (readTag == 26) {
                                if (!(z2 & true)) {
                                    this.extensions_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                            } else if (readTag != 34) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.sKR_ = codedInputStream.readBytes();
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
                    this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
                }
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }
}
