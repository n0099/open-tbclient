package com.baidu.android.pushservice.y.e;

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
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static final e k;
    public static Parser<e> l;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public LazyStringList e;
    public int f;
    public int g;
    public List<c> h;
    public byte i;
    public int j;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<e> {
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
        /* renamed from: a */
        public e parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new e(codedInputStream, extensionRegistryLite, null) : (e) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<e, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public LazyStringList e;
        public int f;
        public int g;
        public List<c> h;

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
            this.e = LazyStringArrayList.EMPTY;
            this.h = Collections.emptyList();
            j();
        }

        public static /* synthetic */ b a() {
            return f();
        }

        public static b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
        }

        public b a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a |= 32;
                this.g = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                if (eVar == e.c()) {
                    return this;
                }
                if (eVar.l()) {
                    c(eVar.g());
                }
                if (eVar.k()) {
                    b(eVar.f());
                }
                if (eVar.n()) {
                    e(eVar.i());
                }
                if (!eVar.e.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = eVar.e;
                        this.a &= -9;
                    } else {
                        h();
                        this.e.addAll(eVar.e);
                    }
                }
                if (eVar.m()) {
                    d(eVar.h());
                }
                if (eVar.j()) {
                    a(eVar.e());
                }
                if (!eVar.h.isEmpty()) {
                    if (this.h.isEmpty()) {
                        this.h = eVar.h;
                        this.a &= -65;
                    } else {
                        g();
                        this.h.addAll(eVar.h);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                e eVar = null;
                try {
                    try {
                        e parsePartialFrom = e.l.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        e eVar2 = (e) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            eVar = eVar2;
                            if (eVar != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (eVar != null) {
                        mergeFrom(eVar);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.a |= 2;
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public e build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                e buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (e) invokeV.objValue;
        }

        public b c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.a |= 1;
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public e buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                e eVar = new e(this, (com.baidu.android.pushservice.y.e.a) null);
                int i = this.a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                eVar.b = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                eVar.c = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                eVar.d = this.d;
                if ((this.a & 8) == 8) {
                    this.e = new UnmodifiableLazyStringList(this.e);
                    this.a &= -9;
                }
                eVar.e = this.e;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                eVar.f = this.f;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                eVar.g = this.g;
                if ((this.a & 64) == 64) {
                    this.h = Collections.unmodifiableList(this.h);
                    this.a &= -65;
                }
                eVar.h = this.h;
                eVar.a = i2;
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                super.clear();
                this.b = 0;
                int i = this.a & (-2);
                this.a = i;
                this.c = 0;
                int i2 = i & (-3);
                this.a = i2;
                this.d = 0;
                int i3 = i2 & (-5);
                this.a = i3;
                this.e = LazyStringArrayList.EMPTY;
                int i4 = i3 & (-9);
                this.a = i4;
                this.f = 0;
                int i5 = i4 & (-17);
                this.a = i5;
                this.g = 0;
                this.a = i5 & (-33);
                this.h = Collections.emptyList();
                this.a &= -65;
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                this.a |= 16;
                this.f = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public b mo43clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? f().mergeFrom(buildPartial()) : (b) invokeV.objValue;
        }

        public b e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
                this.a |= 4;
                this.d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (this.a & 64) == 64) {
                return;
            }
            this.h = new ArrayList(this.h);
            this.a |= 64;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (this.a & 8) == 8) {
                return;
            }
            this.e = new LazyStringArrayList(this.e);
            this.a |= 8;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: i */
        public e getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? e.c() : (e) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502689896, "Lcom/baidu/android/pushservice/y/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1502689896, "Lcom/baidu/android/pushservice/y/e/e;");
                return;
            }
        }
        l = new a();
        e eVar = new e(true);
        k = eVar;
        eVar.o();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<com.baidu.android.pushservice.y.e.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
        this.i = (byte) -1;
        this.j = -1;
        o();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z) {
                break;
            }
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.a |= 1;
                            this.b = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.a |= 2;
                            this.c = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.a |= 4;
                            this.d = codedInputStream.readInt32();
                        } else if (readTag == 34) {
                            if (!(z2 & true)) {
                                this.e = new LazyStringArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.readBytes());
                        } else if (readTag == 40) {
                            this.a |= 8;
                            this.f = codedInputStream.readUInt32();
                        } else if (readTag == 48) {
                            this.a |= 16;
                            this.g = codedInputStream.readInt32();
                        } else if (readTag == 58) {
                            if (!(z2 & true)) {
                                this.h = new ArrayList();
                                z2 |= true;
                            }
                            this.h.add(codedInputStream.readMessage(c.j, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.e = new UnmodifiableLazyStringList(this.e);
                }
                if (z2 & true) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ e(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, com.baidu.android.pushservice.y.e.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(GeneratedMessageLite.Builder builder) {
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
        this.i = (byte) -1;
        this.j = -1;
    }

    public /* synthetic */ e(GeneratedMessageLite.Builder builder, com.baidu.android.pushservice.y.e.a aVar) {
        this(builder);
    }

    public e(boolean z) {
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
        this.i = (byte) -1;
        this.j = -1;
    }

    public static b c(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, eVar)) == null) ? p().mergeFrom(eVar) : (b) invokeL.objValue;
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? k : (e) invokeV.objValue;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? b.a() : (b) invokeV.objValue;
    }

    public List<c> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (List) invokeV.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: d */
    public e getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k : (e) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<e> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? l : (Parser) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.j;
            if (i != -1) {
                return i;
            }
            int computeUInt32Size = (this.a & 1) == 1 ? CodedOutputStream.computeUInt32Size(1, this.b) + 0 : 0;
            if ((this.a & 2) == 2) {
                computeUInt32Size += CodedOutputStream.computeInt32Size(2, this.c);
            }
            if ((this.a & 4) == 4) {
                computeUInt32Size += CodedOutputStream.computeInt32Size(3, this.d);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                i2 += CodedOutputStream.computeBytesSizeNoTag(this.e.getByteString(i3));
            }
            int size = computeUInt32Size + i2 + (b().size() * 1);
            if ((this.a & 8) == 8) {
                size += CodedOutputStream.computeUInt32Size(5, this.f);
            }
            if ((this.a & 16) == 16) {
                size += CodedOutputStream.computeInt32Size(6, this.g);
            }
            for (int i4 = 0; i4 < this.h.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(7, this.h.get(i4));
            }
            this.j = size;
            return size;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : invokeV.intValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            byte b2 = this.i;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.i = (byte) 1;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.a & 16) == 16 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.a & 2) == 2 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.a & 1) == 1 : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.a & 8) == 8 : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.a & 4) == 4 : invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = LazyStringArrayList.EMPTY;
            this.f = 0;
            this.g = 0;
            this.h = Collections.emptyList();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: q */
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? p() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: r */
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c(this) : (b) invokeV.objValue;
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
            if ((this.a & 1) == 1) {
                codedOutputStream.writeUInt32(1, this.b);
            }
            if ((this.a & 2) == 2) {
                codedOutputStream.writeInt32(2, this.c);
            }
            if ((this.a & 4) == 4) {
                codedOutputStream.writeInt32(3, this.d);
            }
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.writeBytes(4, this.e.getByteString(i));
            }
            if ((this.a & 8) == 8) {
                codedOutputStream.writeUInt32(5, this.f);
            }
            if ((this.a & 16) == 16) {
                codedOutputStream.writeInt32(6, this.g);
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                codedOutputStream.writeMessage(7, this.h.get(i2));
            }
        }
    }
}
