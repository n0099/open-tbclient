package com.baidu.android.pushservice.i.b.a;

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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.b.a.a$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.android.pushservice.i.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1604a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C1604a> f37463a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1604a f37464b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37465c;

        /* renamed from: d  reason: collision with root package name */
        public long f37466d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37467e;

        /* renamed from: f  reason: collision with root package name */
        public C1605a f37468f;

        /* renamed from: g  reason: collision with root package name */
        public long f37469g;

        /* renamed from: h  reason: collision with root package name */
        public Object f37470h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f37471i;

        /* renamed from: j  reason: collision with root package name */
        public byte f37472j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1605a extends GeneratedMessageLite implements b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C1605a> f37473a;

            /* renamed from: b  reason: collision with root package name */
            public static final C1605a f37474b;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: c  reason: collision with root package name */
            public int f37475c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37476d;

            /* renamed from: e  reason: collision with root package name */
            public byte f37477e;

            /* renamed from: f  reason: collision with root package name */
            public int f37478f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static final class C1606a extends GeneratedMessageLite.Builder<C1605a, C1606a> implements b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public int f37479a;

                /* renamed from: b  reason: collision with root package name */
                public Object f37480b;

                public C1606a() {
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
                    this.f37480b = "";
                    g();
                }

                private void g() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                    }
                }

                public static C1606a h() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1606a() : (C1606a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                public C1606a clear() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        super.clear();
                        this.f37480b = "";
                        this.f37479a &= -2;
                        return this;
                    }
                    return (C1606a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C1606a mergeFrom(C1605a c1605a) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1605a)) == null) {
                        if (c1605a != C1605a.a() && c1605a.c()) {
                            this.f37479a |= 1;
                            this.f37480b = c1605a.f37476d;
                        }
                        return this;
                    }
                    return (C1606a) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public C1606a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    InterceptResult invokeLL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                        C1605a c1605a = null;
                        try {
                            try {
                                C1605a parsePartialFrom = C1605a.f37473a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (parsePartialFrom != null) {
                                    mergeFrom(parsePartialFrom);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e2) {
                                C1605a c1605a2 = (C1605a) e2.getUnfinishedMessage();
                                try {
                                    throw e2;
                                } catch (Throwable th) {
                                    th = th;
                                    c1605a = c1605a2;
                                    if (c1605a != null) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (c1605a != null) {
                                mergeFrom(c1605a);
                            }
                            throw th;
                        }
                    }
                    return (C1606a) invokeLL.objValue;
                }

                public C1606a a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                        if (str != null) {
                            this.f37479a |= 1;
                            this.f37480b = str;
                            return this;
                        }
                        throw null;
                    }
                    return (C1606a) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: b */
                public C1606a clone() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1606a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                /* renamed from: c */
                public C1605a getDefaultInstanceForType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? C1605a.a() : (C1605a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                public C1605a build() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                        C1605a buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                    }
                    return (C1605a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: e */
                public C1605a buildPartial() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                        C1605a c1605a = new C1605a(this, (AnonymousClass1) null);
                        int i2 = (this.f37479a & 1) != 1 ? 0 : 1;
                        c1605a.f37476d = this.f37480b;
                        c1605a.f37475c = i2;
                        return c1605a;
                    }
                    return (C1605a) invokeV.objValue;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }
            }

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1705123139, "Lcom/baidu/android/pushservice/i/b/a/a$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1705123139, "Lcom/baidu/android/pushservice/i/b/a/a$a$a;");
                        return;
                    }
                }
                f37473a = new AbstractParser<C1605a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.Parser
                    /* renamed from: a */
                    public C1605a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1605a(codedInputStream, extensionRegistryLite, null) : (C1605a) invokeLL.objValue;
                    }
                };
                C1605a c1605a = new C1605a();
                f37474b = c1605a;
                c1605a.h();
            }

            public C1605a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.f37477e = (byte) -1;
                this.f37478f = -1;
            }

            public C1605a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {codedInputStream, extensionRegistryLite};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
                this.f37477e = (byte) -1;
                this.f37478f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        this.f37475c |= 1;
                                        this.f37476d = codedInputStream.readBytes();
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
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
                        makeExtensionsImmutable();
                    }
                }
            }

            public /* synthetic */ C1605a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1605a(GeneratedMessageLite.Builder builder) {
                super(builder);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {builder};
                    interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                        return;
                    }
                }
                this.f37477e = (byte) -1;
                this.f37478f = -1;
            }

            public /* synthetic */ C1605a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public static C1606a a(C1605a c1605a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, c1605a)) == null) ? e().mergeFrom(c1605a) : (C1606a) invokeL.objValue;
            }

            public static C1605a a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37474b : (C1605a) invokeV.objValue;
            }

            public static C1606a e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1606a.h() : (C1606a) invokeV.objValue;
            }

            private void h() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                    this.f37476d = "";
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C1605a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37474b : (C1605a) invokeV.objValue;
            }

            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37475c & 1) == 1 : invokeV.booleanValue;
            }

            public ByteString d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Object obj = this.f37476d;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.f37476d = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: f */
            public C1606a newBuilderForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e() : (C1606a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: g */
            public C1606a toBuilder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this) : (C1606a) invokeV.objValue;
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<C1605a> getParserForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f37473a : (Parser) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    int i2 = this.f37478f;
                    if (i2 != -1) {
                        return i2;
                    }
                    int computeBytesSize = (this.f37475c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                    this.f37478f = computeBytesSize;
                    return computeBytesSize;
                }
                return invokeV.intValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    byte b2 = this.f37477e;
                    if (b2 != -1) {
                        return b2 == 1;
                    }
                    this.f37477e = (byte) 1;
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? super.writeReplace() : invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048588, this, codedOutputStream) == null) {
                    getSerializedSize();
                    if ((this.f37475c & 1) == 1) {
                        codedOutputStream.writeBytes(1, d());
                    }
                }
            }
        }

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$b */
        /* loaded from: classes4.dex */
        public interface b extends MessageLiteOrBuilder {
        }

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$c */
        /* loaded from: classes4.dex */
        public static final class c extends GeneratedMessageLite.Builder<C1604a, c> implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37481a;

            /* renamed from: b  reason: collision with root package name */
            public long f37482b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37483c;

            /* renamed from: d  reason: collision with root package name */
            public C1605a f37484d;

            /* renamed from: e  reason: collision with root package name */
            public long f37485e;

            /* renamed from: f  reason: collision with root package name */
            public Object f37486f;

            /* renamed from: g  reason: collision with root package name */
            public ByteString f37487g;

            public c() {
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
                this.f37483c = "";
                this.f37484d = C1605a.a();
                this.f37486f = "";
                this.f37487g = ByteString.EMPTY;
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static c h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new c() : (c) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public c clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37482b = 0L;
                    int i2 = this.f37481a & (-2);
                    this.f37481a = i2;
                    this.f37483c = "";
                    this.f37481a = i2 & (-3);
                    this.f37484d = C1605a.a();
                    int i3 = this.f37481a & (-5);
                    this.f37481a = i3;
                    this.f37485e = 0L;
                    int i4 = i3 & (-9);
                    this.f37481a = i4;
                    this.f37486f = "";
                    int i5 = i4 & (-17);
                    this.f37481a = i5;
                    this.f37487g = ByteString.EMPTY;
                    this.f37481a = i5 & (-33);
                    return this;
                }
                return (c) invokeV.objValue;
            }

            public c a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37481a |= 1;
                    this.f37482b = j2;
                    return this;
                }
                return (c) invokeJ.objValue;
            }

            public c a(C1605a c1605a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1605a)) == null) {
                    if (c1605a != null) {
                        this.f37484d = c1605a;
                        this.f37481a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public c mergeFrom(C1604a c1604a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c1604a)) == null) {
                    if (c1604a == C1604a.a()) {
                        return this;
                    }
                    if (c1604a.c()) {
                        a(c1604a.d());
                    }
                    if (c1604a.e()) {
                        this.f37481a |= 2;
                        this.f37483c = c1604a.f37467e;
                    }
                    if (c1604a.g()) {
                        b(c1604a.h());
                    }
                    if (c1604a.i()) {
                        b(c1604a.j());
                    }
                    if (c1604a.k()) {
                        this.f37481a |= 16;
                        this.f37486f = c1604a.f37470h;
                    }
                    if (c1604a.m()) {
                        a(c1604a.n());
                    }
                    return this;
                }
                return (c) invokeL.objValue;
            }

            public c a(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) {
                    if (byteString != null) {
                        this.f37481a |= 32;
                        this.f37487g = byteString;
                        return this;
                    }
                    throw null;
                }
                return (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, codedInputStream, extensionRegistryLite)) == null) {
                    C1604a c1604a = null;
                    try {
                        try {
                            C1604a parsePartialFrom = C1604a.f37463a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C1604a c1604a2 = (C1604a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c1604a = c1604a2;
                                if (c1604a != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1604a != null) {
                            mergeFrom(c1604a);
                        }
                        throw th;
                    }
                }
                return (c) invokeLL.objValue;
            }

            public c a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                    if (str != null) {
                        this.f37481a |= 2;
                        this.f37483c = str;
                        return this;
                    }
                    throw null;
                }
                return (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public c clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h().mergeFrom(buildPartial()) : (c) invokeV.objValue;
            }

            public c b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.f37481a |= 8;
                    this.f37485e = j2;
                    return this;
                }
                return (c) invokeJ.objValue;
            }

            public c b(C1605a c1605a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c1605a)) == null) {
                    if ((this.f37481a & 4) == 4 && this.f37484d != C1605a.a()) {
                        c1605a = C1605a.a(this.f37484d).mergeFrom(c1605a).buildPartial();
                    }
                    this.f37484d = c1605a;
                    this.f37481a |= 4;
                    return this;
                }
                return (c) invokeL.objValue;
            }

            public c b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                    if (str != null) {
                        this.f37481a |= 16;
                        this.f37486f = str;
                        return this;
                    }
                    throw null;
                }
                return (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C1604a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? C1604a.a() : (C1604a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C1604a build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    C1604a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (C1604a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C1604a buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    C1604a c1604a = new C1604a(this, (AnonymousClass1) null);
                    int i2 = this.f37481a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1604a.f37466d = this.f37482b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1604a.f37467e = this.f37483c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1604a.f37468f = this.f37484d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1604a.f37469g = this.f37485e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1604a.f37470h = this.f37486f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    c1604a.f37471i = this.f37487g;
                    c1604a.f37465c = i3;
                    return c1604a;
                }
                return (C1604a) invokeV.objValue;
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
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(475516832, "Lcom/baidu/android/pushservice/i/b/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(475516832, "Lcom/baidu/android/pushservice/i/b/a/a$a;");
                    return;
                }
            }
            f37463a = new AbstractParser<C1604a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C1604a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1604a(codedInputStream, extensionRegistryLite, null) : (C1604a) invokeLL.objValue;
                }
            };
            C1604a c1604a = new C1604a();
            f37464b = c1604a;
            c1604a.r();
        }

        public C1604a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37472j = (byte) -1;
            this.k = -1;
        }

        public C1604a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f37472j = (byte) -1;
            this.k = -1;
            r();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f37465c |= 1;
                                    this.f37466d = codedInputStream.readInt64();
                                } else if (readTag == 18) {
                                    this.f37465c |= 2;
                                    this.f37467e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    C1605a.C1606a builder = (this.f37465c & 4) == 4 ? this.f37468f.toBuilder() : null;
                                    C1605a c1605a = (C1605a) codedInputStream.readMessage(C1605a.f37473a, extensionRegistryLite);
                                    this.f37468f = c1605a;
                                    if (builder != null) {
                                        builder.mergeFrom(c1605a);
                                        this.f37468f = builder.buildPartial();
                                    }
                                    this.f37465c |= 4;
                                } else if (readTag == 32) {
                                    this.f37465c |= 8;
                                    this.f37469g = codedInputStream.readInt64();
                                } else if (readTag == 42) {
                                    this.f37465c |= 16;
                                    this.f37470h = codedInputStream.readBytes();
                                } else if (readTag == 50) {
                                    this.f37465c |= 32;
                                    this.f37471i = codedInputStream.readBytes();
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        public /* synthetic */ C1604a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1604a(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.f37472j = (byte) -1;
            this.k = -1;
        }

        public /* synthetic */ C1604a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static c a(C1604a c1604a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c1604a)) == null) ? o().mergeFrom(c1604a) : (c) invokeL.objValue;
        }

        public static C1604a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f37464b : (C1604a) invokeV.objValue;
        }

        public static c o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? c.h() : (c) invokeV.objValue;
        }

        private void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f37466d = 0L;
                this.f37467e = "";
                this.f37468f = C1605a.a();
                this.f37469g = 0L;
                this.f37470h = "";
                this.f37471i = ByteString.EMPTY;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1604a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37464b : (C1604a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37465c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37466d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37465c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37467e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37467e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37465c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C1604a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37463a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.k;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt64Size = (this.f37465c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f37466d) : 0;
                if ((this.f37465c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37465c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f37468f);
                }
                if ((this.f37465c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f37469g);
                }
                if ((this.f37465c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f37465c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, this.f37471i);
                }
                this.k = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public C1605a h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37468f : (C1605a) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37465c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37472j;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37472j = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37469g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37465c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f37470h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37470h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37465c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37471i : (ByteString) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: p */
        public c newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? o() : (c) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: q */
        public c toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? a(this) : (c) invokeV.objValue;
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
                if ((this.f37465c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f37466d);
                }
                if ((this.f37465c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37465c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f37468f);
                }
                if ((this.f37465c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37469g);
                }
                if ((this.f37465c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f37465c & 32) == 32) {
                    codedOutputStream.writeBytes(6, this.f37471i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class c extends GeneratedMessageLite implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f37488a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37489b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37490c;

        /* renamed from: d  reason: collision with root package name */
        public int f37491d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37492e;

        /* renamed from: f  reason: collision with root package name */
        public long f37493f;

        /* renamed from: g  reason: collision with root package name */
        public byte f37494g;

        /* renamed from: h  reason: collision with root package name */
        public int f37495h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1607a extends GeneratedMessageLite.Builder<c, C1607a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37496a;

            /* renamed from: b  reason: collision with root package name */
            public int f37497b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37498c;

            /* renamed from: d  reason: collision with root package name */
            public long f37499d;

            public C1607a() {
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
                this.f37498c = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1607a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1607a() : (C1607a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1607a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37497b = 0;
                    int i2 = this.f37496a & (-2);
                    this.f37496a = i2;
                    this.f37498c = "";
                    int i3 = i2 & (-3);
                    this.f37496a = i3;
                    this.f37499d = 0L;
                    this.f37496a = i3 & (-5);
                    return this;
                }
                return (C1607a) invokeV.objValue;
            }

            public C1607a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f37496a |= 1;
                    this.f37497b = i2;
                    return this;
                }
                return (C1607a) invokeI.objValue;
            }

            public C1607a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                    this.f37496a |= 4;
                    this.f37499d = j2;
                    return this;
                }
                return (C1607a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1607a mergeFrom(c cVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
                    if (cVar == c.a()) {
                        return this;
                    }
                    if (cVar.c()) {
                        a(cVar.d());
                    }
                    if (cVar.e()) {
                        this.f37496a |= 2;
                        this.f37498c = cVar.f37492e;
                    }
                    if (cVar.h()) {
                        a(cVar.i());
                    }
                    return this;
                }
                return (C1607a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1607a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, codedInputStream, extensionRegistryLite)) == null) {
                    c cVar = null;
                    try {
                        try {
                            c parsePartialFrom = c.f37488a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            c cVar2 = (c) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                cVar = cVar2;
                                if (cVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                }
                return (C1607a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1607a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1607a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public c getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a() : (c) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public c build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    c buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (c) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public c buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    c cVar = new c(this, (AnonymousClass1) null);
                    int i2 = this.f37496a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f37491d = this.f37497b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f37492e = this.f37498c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f37493f = this.f37499d;
                    cVar.f37490c = i3;
                    return cVar;
                }
                return (c) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(475516894, "Lcom/baidu/android/pushservice/i/b/a/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(475516894, "Lcom/baidu/android/pushservice/i/b/a/a$c;");
                    return;
                }
            }
            f37488a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new c(codedInputStream, extensionRegistryLite, null) : (c) invokeLL.objValue;
                }
            };
            c cVar = new c();
            f37489b = cVar;
            cVar.m();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37494g = (byte) -1;
            this.f37495h = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f37494g = (byte) -1;
            this.f37495h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f37490c |= 1;
                                this.f37491d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f37490c |= 2;
                                this.f37492e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f37490c |= 4;
                                this.f37493f = codedInputStream.readInt64();
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
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

        public /* synthetic */ c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.f37494g = (byte) -1;
            this.f37495h = -1;
        }

        public /* synthetic */ c(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1607a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cVar)) == null) ? j().mergeFrom(cVar) : (C1607a) invokeL.objValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37489b : (c) invokeV.objValue;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) ? f37488a.parseFrom(bArr) : (c) invokeL.objValue;
        }

        public static C1607a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1607a.h() : (C1607a) invokeV.objValue;
        }

        private void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f37491d = 0;
                this.f37492e = "";
                this.f37493f = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37489b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37490c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37491d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37490c & 2) == 2 : invokeV.booleanValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37492e;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.f37492e = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) invokeV.objValue;
        }

        public ByteString g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.f37492e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37492e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37488a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37495h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f37490c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f37491d) : 0;
                if ((this.f37490c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
                }
                if ((this.f37490c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f37493f);
                }
                this.f37495h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.f37490c & 4) == 4 : invokeV.booleanValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37493f : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37494g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37494g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1607a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? j() : (C1607a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1607a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(this) : (C1607a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f37490c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f37491d);
                }
                if ((this.f37490c & 2) == 2) {
                    codedOutputStream.writeBytes(2, g());
                }
                if ((this.f37490c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37493f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
