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
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static final f n;
    public static Parser<f> o;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public long d;
    public Object e;
    public int f;
    public int g;
    public ByteString h;
    public e i;
    public com.baidu.android.pushservice.y.e.b j;
    public d k;
    public byte l;
    public int m;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<f> {
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
        public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new f(codedInputStream, extensionRegistryLite, null) : (f) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<f, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public long d;
        public Object e;
        public int f;
        public int g;
        public ByteString h;
        public e i;
        public com.baidu.android.pushservice.y.e.b j;
        public d k;

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
            this.e = "";
            this.h = ByteString.EMPTY;
            this.i = e.c();
            this.j = com.baidu.android.pushservice.y.e.b.a();
            this.k = d.a();
            h();
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
                this.a |= 16;
                this.f = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.a |= 4;
                this.d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b a(com.baidu.android.pushservice.y.e.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                if ((this.a & 256) == 256 && this.j != com.baidu.android.pushservice.y.e.b.a()) {
                    bVar = com.baidu.android.pushservice.y.e.b.a(this.j).mergeFrom(bVar).buildPartial();
                }
                this.j = bVar;
                this.a |= 256;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
                if ((this.a & 512) == 512 && this.k != d.a()) {
                    dVar = d.a(this.k).mergeFrom(dVar).buildPartial();
                }
                this.k = dVar;
                this.a |= 512;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
                if ((this.a & 128) == 128 && this.i != e.c()) {
                    eVar = e.c(this.i).mergeFrom(eVar).buildPartial();
                }
                this.i = eVar;
                this.a |= 128;
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
                if (fVar == f.b()) {
                    return this;
                }
                if (fVar.r()) {
                    b(fVar.h());
                }
                if (fVar.v()) {
                    d(fVar.l());
                }
                if (fVar.o()) {
                    a(fVar.e());
                }
                if (fVar.s()) {
                    this.a |= 8;
                    this.e = fVar.e;
                }
                if (fVar.p()) {
                    a(fVar.f());
                }
                if (fVar.u()) {
                    c(fVar.k());
                }
                if (fVar.q()) {
                    a(fVar.g());
                }
                if (fVar.t()) {
                    a(fVar.j());
                }
                if (fVar.m()) {
                    a(fVar.a());
                }
                if (fVar.n()) {
                    a(fVar.d());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 64;
                    this.h = byteString;
                    return this;
                }
                throw null;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, codedInputStream, extensionRegistryLite)) == null) {
                f fVar = null;
                try {
                    try {
                        f parsePartialFrom = f.o.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        f fVar2 = (f) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            fVar = fVar2;
                            if (fVar != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fVar != null) {
                        mergeFrom(fVar);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                if (str != null) {
                    this.a |= 8;
                    this.e = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.a |= 1;
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public f build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                f buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (f) invokeV.objValue;
        }

        public b c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.a |= 32;
                this.g = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public f buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                f fVar = new f(this, (com.baidu.android.pushservice.y.e.a) null);
                int i = this.a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                fVar.b = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                fVar.c = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                fVar.d = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                fVar.e = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                fVar.f = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                fVar.g = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                fVar.h = this.h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                fVar.i = this.i;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                fVar.j = this.j;
                if ((i & 512) == 512) {
                    i2 |= 512;
                }
                fVar.k = this.k;
                fVar.a = i2;
                return fVar;
            }
            return (f) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                super.clear();
                this.b = 0;
                int i = this.a & (-2);
                this.a = i;
                this.c = 0;
                int i2 = i & (-3);
                this.a = i2;
                this.d = 0L;
                int i3 = i2 & (-5);
                this.a = i3;
                this.e = "";
                int i4 = i3 & (-9);
                this.a = i4;
                this.f = 0;
                int i5 = i4 & (-17);
                this.a = i5;
                this.g = 0;
                int i6 = i5 & (-33);
                this.a = i6;
                this.h = ByteString.EMPTY;
                this.a = i6 & (-65);
                this.i = e.c();
                this.a &= -129;
                this.j = com.baidu.android.pushservice.y.e.b.a();
                this.a &= -257;
                this.k = d.a();
                this.a &= -513;
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.a |= 2;
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public b mo44clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? f().mergeFrom(buildPartial()) : (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: g */
        public f getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? f.b() : (f) invokeV.objValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            }
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502689865, "Lcom/baidu/android/pushservice/y/e/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1502689865, "Lcom/baidu/android/pushservice/y/e/f;");
                return;
            }
        }
        o = new a();
        f fVar = new f(true);
        n = fVar;
        fVar.w();
    }

    public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int i;
        GeneratedMessageLite.Builder builder;
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
        this.l = (byte) -1;
        this.m = -1;
        w();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.a |= 1;
                            this.b = codedInputStream.readUInt32();
                            break;
                        case 16:
                            this.a |= 2;
                            this.c = codedInputStream.readUInt32();
                            break;
                        case 24:
                            this.a |= 4;
                            this.d = codedInputStream.readInt64();
                            break;
                        case 34:
                            this.a |= 8;
                            this.e = codedInputStream.readBytes();
                            break;
                        case 40:
                            this.a |= 16;
                            this.f = codedInputStream.readUInt32();
                            break;
                        case 48:
                            this.a |= 32;
                            this.g = codedInputStream.readUInt32();
                            break;
                        case 58:
                            this.a |= 64;
                            this.h = codedInputStream.readBytes();
                            break;
                        case 66:
                            i = 128;
                            builder = (this.a & 128) == 128 ? this.i.toBuilder() : null;
                            e eVar = (e) codedInputStream.readMessage(e.l, extensionRegistryLite);
                            this.i = eVar;
                            if (builder != null) {
                                builder.mergeFrom(eVar);
                                this.i = builder.buildPartial();
                            }
                            this.a |= i;
                            break;
                        case 74:
                            i = 256;
                            builder = (this.a & 256) == 256 ? this.j.toBuilder() : null;
                            com.baidu.android.pushservice.y.e.b bVar = (com.baidu.android.pushservice.y.e.b) codedInputStream.readMessage(com.baidu.android.pushservice.y.e.b.g, extensionRegistryLite);
                            this.j = bVar;
                            if (builder != null) {
                                builder.mergeFrom(bVar);
                                this.j = builder.buildPartial();
                            }
                            this.a |= i;
                            break;
                        case 82:
                            i = 512;
                            builder = (this.a & 512) == 512 ? this.k.toBuilder() : null;
                            d dVar = (d) codedInputStream.readMessage(d.f, extensionRegistryLite);
                            this.k = dVar;
                            if (builder != null) {
                                builder.mergeFrom(dVar);
                                this.k = builder.buildPartial();
                            }
                            this.a |= i;
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            } else {
                                break;
                            }
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, com.baidu.android.pushservice.y.e.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GeneratedMessageLite.Builder builder) {
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
        this.l = (byte) -1;
        this.m = -1;
    }

    public /* synthetic */ f(GeneratedMessageLite.Builder builder, com.baidu.android.pushservice.y.e.a aVar) {
        this(builder);
    }

    public f(boolean z) {
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
        this.l = (byte) -1;
        this.m = -1;
    }

    public static f a(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) ? o.parseFrom(bArr) : (f) invokeL.objValue;
    }

    public static b b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, fVar)) == null) ? x().mergeFrom(fVar) : (b) invokeL.objValue;
    }

    public static f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? n : (f) invokeV.objValue;
    }

    public static b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? b.a() : (b) invokeV.objValue;
    }

    public com.baidu.android.pushservice.y.e.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (com.baidu.android.pushservice.y.e.b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public f getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? n : (f) invokeV.objValue;
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (d) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : invokeV.intValue;
    }

    public ByteString g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : (ByteString) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<f> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o : (Parser) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.m;
            if (i != -1) {
                return i;
            }
            int computeUInt32Size = (this.a & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.b) : 0;
            if ((this.a & 2) == 2) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(2, this.c);
            }
            if ((this.a & 4) == 4) {
                computeUInt32Size += CodedOutputStream.computeInt64Size(3, this.d);
            }
            if ((this.a & 8) == 8) {
                computeUInt32Size += CodedOutputStream.computeBytesSize(4, i());
            }
            if ((this.a & 16) == 16) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(5, this.f);
            }
            if ((this.a & 32) == 32) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(6, this.g);
            }
            if ((this.a & 64) == 64) {
                computeUInt32Size += CodedOutputStream.computeBytesSize(7, this.h);
            }
            if ((this.a & 128) == 128) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(8, this.i);
            }
            if ((this.a & 256) == 256) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(9, this.j);
            }
            if ((this.a & 512) == 512) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(10, this.k);
            }
            this.m = computeUInt32Size;
            return computeUInt32Size;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : invokeV.intValue;
    }

    public ByteString i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Object obj = this.e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            byte b2 = this.l;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.l = (byte) 1;
            return true;
        }
        return invokeV.booleanValue;
    }

    public e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (e) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.g : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.c : invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.a & 256) == 256 : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.a & 512) == 512 : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.a & 4) == 4 : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.a & 16) == 16 : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.a & 64) == 64 : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.a & 1) == 1 : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.a & 8) == 8 : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.a & 128) == 128 : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.a & 32) == 32 : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.a & 2) == 2 : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.b = 0;
            this.c = 0;
            this.d = 0L;
            this.e = "";
            this.f = 0;
            this.g = 0;
            this.h = ByteString.EMPTY;
            this.i = e.c();
            this.j = com.baidu.android.pushservice.y.e.b.a();
            this.k = d.a();
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.a & 1) == 1) {
                codedOutputStream.writeUInt32(1, this.b);
            }
            if ((this.a & 2) == 2) {
                codedOutputStream.writeUInt32(2, this.c);
            }
            if ((this.a & 4) == 4) {
                codedOutputStream.writeInt64(3, this.d);
            }
            if ((this.a & 8) == 8) {
                codedOutputStream.writeBytes(4, i());
            }
            if ((this.a & 16) == 16) {
                codedOutputStream.writeUInt32(5, this.f);
            }
            if ((this.a & 32) == 32) {
                codedOutputStream.writeUInt32(6, this.g);
            }
            if ((this.a & 64) == 64) {
                codedOutputStream.writeBytes(7, this.h);
            }
            if ((this.a & 128) == 128) {
                codedOutputStream.writeMessage(8, this.i);
            }
            if ((this.a & 256) == 256) {
                codedOutputStream.writeMessage(9, this.j);
            }
            if ((this.a & 512) == 512) {
                codedOutputStream.writeMessage(10, this.k);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: y */
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? x() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: z */
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? b(this) : (b) invokeV.objValue;
    }
}
