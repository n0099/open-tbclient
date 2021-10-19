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
    public static final class C1610a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C1610a> f37634a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1610a f37635b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37636c;

        /* renamed from: d  reason: collision with root package name */
        public long f37637d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37638e;

        /* renamed from: f  reason: collision with root package name */
        public C1611a f37639f;

        /* renamed from: g  reason: collision with root package name */
        public long f37640g;

        /* renamed from: h  reason: collision with root package name */
        public Object f37641h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f37642i;

        /* renamed from: j  reason: collision with root package name */
        public byte f37643j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1611a extends GeneratedMessageLite implements b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C1611a> f37644a;

            /* renamed from: b  reason: collision with root package name */
            public static final C1611a f37645b;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: c  reason: collision with root package name */
            public int f37646c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37647d;

            /* renamed from: e  reason: collision with root package name */
            public byte f37648e;

            /* renamed from: f  reason: collision with root package name */
            public int f37649f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static final class C1612a extends GeneratedMessageLite.Builder<C1611a, C1612a> implements b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public int f37650a;

                /* renamed from: b  reason: collision with root package name */
                public Object f37651b;

                public C1612a() {
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
                    this.f37651b = "";
                    g();
                }

                private void g() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                    }
                }

                public static C1612a h() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1612a() : (C1612a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                public C1612a clear() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        super.clear();
                        this.f37651b = "";
                        this.f37650a &= -2;
                        return this;
                    }
                    return (C1612a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C1612a mergeFrom(C1611a c1611a) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1611a)) == null) {
                        if (c1611a != C1611a.a() && c1611a.c()) {
                            this.f37650a |= 1;
                            this.f37651b = c1611a.f37647d;
                        }
                        return this;
                    }
                    return (C1612a) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public C1612a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    InterceptResult invokeLL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                        C1611a c1611a = null;
                        try {
                            try {
                                C1611a parsePartialFrom = C1611a.f37644a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (parsePartialFrom != null) {
                                    mergeFrom(parsePartialFrom);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e2) {
                                C1611a c1611a2 = (C1611a) e2.getUnfinishedMessage();
                                try {
                                    throw e2;
                                } catch (Throwable th) {
                                    th = th;
                                    c1611a = c1611a2;
                                    if (c1611a != null) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (c1611a != null) {
                                mergeFrom(c1611a);
                            }
                            throw th;
                        }
                    }
                    return (C1612a) invokeLL.objValue;
                }

                public C1612a a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                        if (str != null) {
                            this.f37650a |= 1;
                            this.f37651b = str;
                            return this;
                        }
                        throw null;
                    }
                    return (C1612a) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: b */
                public C1612a clone() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1612a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                /* renamed from: c */
                public C1611a getDefaultInstanceForType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? C1611a.a() : (C1611a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                public C1611a build() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                        C1611a buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                    }
                    return (C1611a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: e */
                public C1611a buildPartial() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                        C1611a c1611a = new C1611a(this, (AnonymousClass1) null);
                        int i2 = (this.f37650a & 1) != 1 ? 0 : 1;
                        c1611a.f37647d = this.f37651b;
                        c1611a.f37646c = i2;
                        return c1611a;
                    }
                    return (C1611a) invokeV.objValue;
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
                f37644a = new AbstractParser<C1611a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
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
                    public C1611a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1611a(codedInputStream, extensionRegistryLite, null) : (C1611a) invokeLL.objValue;
                    }
                };
                C1611a c1611a = new C1611a();
                f37645b = c1611a;
                c1611a.h();
            }

            public C1611a() {
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
                this.f37648e = (byte) -1;
                this.f37649f = -1;
            }

            public C1611a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                this.f37648e = (byte) -1;
                this.f37649f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        this.f37646c |= 1;
                                        this.f37647d = codedInputStream.readBytes();
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

            public /* synthetic */ C1611a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1611a(GeneratedMessageLite.Builder builder) {
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
                this.f37648e = (byte) -1;
                this.f37649f = -1;
            }

            public /* synthetic */ C1611a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public static C1612a a(C1611a c1611a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, c1611a)) == null) ? e().mergeFrom(c1611a) : (C1612a) invokeL.objValue;
            }

            public static C1611a a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37645b : (C1611a) invokeV.objValue;
            }

            public static C1612a e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1612a.h() : (C1612a) invokeV.objValue;
            }

            private void h() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                    this.f37647d = "";
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C1611a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37645b : (C1611a) invokeV.objValue;
            }

            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37646c & 1) == 1 : invokeV.booleanValue;
            }

            public ByteString d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Object obj = this.f37647d;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.f37647d = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: f */
            public C1612a newBuilderForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e() : (C1612a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: g */
            public C1612a toBuilder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this) : (C1612a) invokeV.objValue;
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<C1611a> getParserForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f37644a : (Parser) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    int i2 = this.f37649f;
                    if (i2 != -1) {
                        return i2;
                    }
                    int computeBytesSize = (this.f37646c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                    this.f37649f = computeBytesSize;
                    return computeBytesSize;
                }
                return invokeV.intValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    byte b2 = this.f37648e;
                    if (b2 != -1) {
                        return b2 == 1;
                    }
                    this.f37648e = (byte) 1;
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
                    if ((this.f37646c & 1) == 1) {
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
        public static final class c extends GeneratedMessageLite.Builder<C1610a, c> implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37652a;

            /* renamed from: b  reason: collision with root package name */
            public long f37653b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37654c;

            /* renamed from: d  reason: collision with root package name */
            public C1611a f37655d;

            /* renamed from: e  reason: collision with root package name */
            public long f37656e;

            /* renamed from: f  reason: collision with root package name */
            public Object f37657f;

            /* renamed from: g  reason: collision with root package name */
            public ByteString f37658g;

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
                this.f37654c = "";
                this.f37655d = C1611a.a();
                this.f37657f = "";
                this.f37658g = ByteString.EMPTY;
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
                    this.f37653b = 0L;
                    int i2 = this.f37652a & (-2);
                    this.f37652a = i2;
                    this.f37654c = "";
                    this.f37652a = i2 & (-3);
                    this.f37655d = C1611a.a();
                    int i3 = this.f37652a & (-5);
                    this.f37652a = i3;
                    this.f37656e = 0L;
                    int i4 = i3 & (-9);
                    this.f37652a = i4;
                    this.f37657f = "";
                    int i5 = i4 & (-17);
                    this.f37652a = i5;
                    this.f37658g = ByteString.EMPTY;
                    this.f37652a = i5 & (-33);
                    return this;
                }
                return (c) invokeV.objValue;
            }

            public c a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37652a |= 1;
                    this.f37653b = j2;
                    return this;
                }
                return (c) invokeJ.objValue;
            }

            public c a(C1611a c1611a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1611a)) == null) {
                    if (c1611a != null) {
                        this.f37655d = c1611a;
                        this.f37652a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public c mergeFrom(C1610a c1610a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c1610a)) == null) {
                    if (c1610a == C1610a.a()) {
                        return this;
                    }
                    if (c1610a.c()) {
                        a(c1610a.d());
                    }
                    if (c1610a.e()) {
                        this.f37652a |= 2;
                        this.f37654c = c1610a.f37638e;
                    }
                    if (c1610a.g()) {
                        b(c1610a.h());
                    }
                    if (c1610a.i()) {
                        b(c1610a.j());
                    }
                    if (c1610a.k()) {
                        this.f37652a |= 16;
                        this.f37657f = c1610a.f37641h;
                    }
                    if (c1610a.m()) {
                        a(c1610a.n());
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
                        this.f37652a |= 32;
                        this.f37658g = byteString;
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
                    C1610a c1610a = null;
                    try {
                        try {
                            C1610a parsePartialFrom = C1610a.f37634a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C1610a c1610a2 = (C1610a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c1610a = c1610a2;
                                if (c1610a != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1610a != null) {
                            mergeFrom(c1610a);
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
                        this.f37652a |= 2;
                        this.f37654c = str;
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
                    this.f37652a |= 8;
                    this.f37656e = j2;
                    return this;
                }
                return (c) invokeJ.objValue;
            }

            public c b(C1611a c1611a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c1611a)) == null) {
                    if ((this.f37652a & 4) == 4 && this.f37655d != C1611a.a()) {
                        c1611a = C1611a.a(this.f37655d).mergeFrom(c1611a).buildPartial();
                    }
                    this.f37655d = c1611a;
                    this.f37652a |= 4;
                    return this;
                }
                return (c) invokeL.objValue;
            }

            public c b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                    if (str != null) {
                        this.f37652a |= 16;
                        this.f37657f = str;
                        return this;
                    }
                    throw null;
                }
                return (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C1610a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? C1610a.a() : (C1610a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C1610a build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    C1610a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (C1610a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C1610a buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    C1610a c1610a = new C1610a(this, (AnonymousClass1) null);
                    int i2 = this.f37652a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1610a.f37637d = this.f37653b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1610a.f37638e = this.f37654c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1610a.f37639f = this.f37655d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1610a.f37640g = this.f37656e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1610a.f37641h = this.f37657f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    c1610a.f37642i = this.f37658g;
                    c1610a.f37636c = i3;
                    return c1610a;
                }
                return (C1610a) invokeV.objValue;
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
            f37634a = new AbstractParser<C1610a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
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
                public C1610a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1610a(codedInputStream, extensionRegistryLite, null) : (C1610a) invokeLL.objValue;
                }
            };
            C1610a c1610a = new C1610a();
            f37635b = c1610a;
            c1610a.r();
        }

        public C1610a() {
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
            this.f37643j = (byte) -1;
            this.k = -1;
        }

        public C1610a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f37643j = (byte) -1;
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
                                    this.f37636c |= 1;
                                    this.f37637d = codedInputStream.readInt64();
                                } else if (readTag == 18) {
                                    this.f37636c |= 2;
                                    this.f37638e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    C1611a.C1612a builder = (this.f37636c & 4) == 4 ? this.f37639f.toBuilder() : null;
                                    C1611a c1611a = (C1611a) codedInputStream.readMessage(C1611a.f37644a, extensionRegistryLite);
                                    this.f37639f = c1611a;
                                    if (builder != null) {
                                        builder.mergeFrom(c1611a);
                                        this.f37639f = builder.buildPartial();
                                    }
                                    this.f37636c |= 4;
                                } else if (readTag == 32) {
                                    this.f37636c |= 8;
                                    this.f37640g = codedInputStream.readInt64();
                                } else if (readTag == 42) {
                                    this.f37636c |= 16;
                                    this.f37641h = codedInputStream.readBytes();
                                } else if (readTag == 50) {
                                    this.f37636c |= 32;
                                    this.f37642i = codedInputStream.readBytes();
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

        public /* synthetic */ C1610a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1610a(GeneratedMessageLite.Builder builder) {
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
            this.f37643j = (byte) -1;
            this.k = -1;
        }

        public /* synthetic */ C1610a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static c a(C1610a c1610a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c1610a)) == null) ? o().mergeFrom(c1610a) : (c) invokeL.objValue;
        }

        public static C1610a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f37635b : (C1610a) invokeV.objValue;
        }

        public static c o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? c.h() : (c) invokeV.objValue;
        }

        private void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f37637d = 0L;
                this.f37638e = "";
                this.f37639f = C1611a.a();
                this.f37640g = 0L;
                this.f37641h = "";
                this.f37642i = ByteString.EMPTY;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1610a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37635b : (C1610a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37636c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37637d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37636c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37638e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37638e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37636c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C1610a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37634a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f37636c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f37637d) : 0;
                if ((this.f37636c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37636c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f37639f);
                }
                if ((this.f37636c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f37640g);
                }
                if ((this.f37636c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f37636c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, this.f37642i);
                }
                this.k = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public C1611a h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37639f : (C1611a) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37636c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37643j;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37643j = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37640g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37636c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f37641h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37641h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37636c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37642i : (ByteString) invokeV.objValue;
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
                if ((this.f37636c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f37637d);
                }
                if ((this.f37636c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37636c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f37639f);
                }
                if ((this.f37636c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37640g);
                }
                if ((this.f37636c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f37636c & 32) == 32) {
                    codedOutputStream.writeBytes(6, this.f37642i);
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
        public static Parser<c> f37659a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37660b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37661c;

        /* renamed from: d  reason: collision with root package name */
        public int f37662d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37663e;

        /* renamed from: f  reason: collision with root package name */
        public long f37664f;

        /* renamed from: g  reason: collision with root package name */
        public byte f37665g;

        /* renamed from: h  reason: collision with root package name */
        public int f37666h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1613a extends GeneratedMessageLite.Builder<c, C1613a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37667a;

            /* renamed from: b  reason: collision with root package name */
            public int f37668b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37669c;

            /* renamed from: d  reason: collision with root package name */
            public long f37670d;

            public C1613a() {
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
                this.f37669c = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1613a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1613a() : (C1613a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1613a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37668b = 0;
                    int i2 = this.f37667a & (-2);
                    this.f37667a = i2;
                    this.f37669c = "";
                    int i3 = i2 & (-3);
                    this.f37667a = i3;
                    this.f37670d = 0L;
                    this.f37667a = i3 & (-5);
                    return this;
                }
                return (C1613a) invokeV.objValue;
            }

            public C1613a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f37667a |= 1;
                    this.f37668b = i2;
                    return this;
                }
                return (C1613a) invokeI.objValue;
            }

            public C1613a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                    this.f37667a |= 4;
                    this.f37670d = j2;
                    return this;
                }
                return (C1613a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1613a mergeFrom(c cVar) {
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
                        this.f37667a |= 2;
                        this.f37669c = cVar.f37663e;
                    }
                    if (cVar.h()) {
                        a(cVar.i());
                    }
                    return this;
                }
                return (C1613a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1613a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, codedInputStream, extensionRegistryLite)) == null) {
                    c cVar = null;
                    try {
                        try {
                            c parsePartialFrom = c.f37659a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1613a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1613a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1613a) invokeV.objValue;
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
                    int i2 = this.f37667a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f37662d = this.f37668b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f37663e = this.f37669c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f37664f = this.f37670d;
                    cVar.f37661c = i3;
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
            f37659a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
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
            f37660b = cVar;
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
            this.f37665g = (byte) -1;
            this.f37666h = -1;
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
            this.f37665g = (byte) -1;
            this.f37666h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f37661c |= 1;
                                this.f37662d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f37661c |= 2;
                                this.f37663e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f37661c |= 4;
                                this.f37664f = codedInputStream.readInt64();
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
            this.f37665g = (byte) -1;
            this.f37666h = -1;
        }

        public /* synthetic */ c(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1613a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cVar)) == null) ? j().mergeFrom(cVar) : (C1613a) invokeL.objValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37660b : (c) invokeV.objValue;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) ? f37659a.parseFrom(bArr) : (c) invokeL.objValue;
        }

        public static C1613a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1613a.h() : (C1613a) invokeV.objValue;
        }

        private void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f37662d = 0;
                this.f37663e = "";
                this.f37664f = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37660b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37661c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37662d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37661c & 2) == 2 : invokeV.booleanValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37663e;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.f37663e = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) invokeV.objValue;
        }

        public ByteString g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.f37663e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37663e = copyFromUtf8;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37659a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37666h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f37661c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f37662d) : 0;
                if ((this.f37661c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
                }
                if ((this.f37661c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f37664f);
                }
                this.f37666h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.f37661c & 4) == 4 : invokeV.booleanValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37664f : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37665g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37665g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1613a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? j() : (C1613a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1613a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(this) : (C1613a) invokeV.objValue;
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
                if ((this.f37661c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f37662d);
                }
                if ((this.f37661c & 2) == 2) {
                    codedOutputStream.writeBytes(2, g());
                }
                if ((this.f37661c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37664f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
