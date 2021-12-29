package com.baidu.android.pushservice.h.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.h.a.a.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.android.pushservice.h.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1710a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<C1710a> a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1710a f32992b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32993c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32994d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32995e;

        /* renamed from: f  reason: collision with root package name */
        public long f32996f;

        /* renamed from: g  reason: collision with root package name */
        public Object f32997g;

        /* renamed from: h  reason: collision with root package name */
        public long f32998h;

        /* renamed from: i  reason: collision with root package name */
        public byte f32999i;

        /* renamed from: j  reason: collision with root package name */
        public int f33000j;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1711a extends GeneratedMessageLite.Builder<C1710a, C1711a> implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33001b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33002c;

            /* renamed from: d  reason: collision with root package name */
            public long f33003d;

            /* renamed from: e  reason: collision with root package name */
            public Object f33004e;

            /* renamed from: f  reason: collision with root package name */
            public long f33005f;

            public C1711a() {
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
                this.f33001b = "";
                this.f33002c = "";
                this.f33004e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1711a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1711a() : (C1711a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1711a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33001b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33002c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33003d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33004e = "";
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33005f = 0L;
                    this.a = i5 & (-17);
                    return this;
                }
                return (C1711a) invokeV.objValue;
            }

            public C1711a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 4;
                    this.f33003d = j2;
                    return this;
                }
                return (C1711a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1711a mergeFrom(C1710a c1710a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1710a)) == null) {
                    if (c1710a == C1710a.a()) {
                        return this;
                    }
                    if (c1710a.c()) {
                        this.a |= 1;
                        this.f33001b = c1710a.f32994d;
                    }
                    if (c1710a.e()) {
                        this.a |= 2;
                        this.f33002c = c1710a.f32995e;
                    }
                    if (c1710a.g()) {
                        a(c1710a.h());
                    }
                    if (c1710a.i()) {
                        this.a |= 8;
                        this.f33004e = c1710a.f32997g;
                    }
                    if (c1710a.k()) {
                        b(c1710a.l());
                    }
                    return this;
                }
                return (C1711a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1711a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    C1710a c1710a = null;
                    try {
                        try {
                            C1710a parsePartialFrom = C1710a.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C1710a c1710a2 = (C1710a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c1710a = c1710a2;
                                if (c1710a != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1710a != null) {
                            mergeFrom(c1710a);
                        }
                        throw th;
                    }
                }
                return (C1711a) invokeLL.objValue;
            }

            public C1711a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33001b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1711a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1711a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1711a) invokeV.objValue;
            }

            public C1711a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 16;
                    this.f33005f = j2;
                    return this;
                }
                return (C1711a) invokeJ.objValue;
            }

            public C1711a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1711a) invokeL.objValue;
            }

            public C1711a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                    if (str != null) {
                        this.a |= 8;
                        this.f33004e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1711a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C1710a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? C1710a.a() : (C1710a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C1710a build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    C1710a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (C1710a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C1710a buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    C1710a c1710a = new C1710a(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1710a.f32994d = this.f33001b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1710a.f32995e = this.f33002c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1710a.f32996f = this.f33003d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1710a.f32997g = this.f33004e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1710a.f32998h = this.f33005f;
                    c1710a.f32993c = i3;
                    return c1710a;
                }
                return (C1710a) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779998, "Lcom/baidu/android/pushservice/h/a/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779998, "Lcom/baidu/android/pushservice/h/a/a/a$a;");
                    return;
                }
            }
            a = new AbstractParser<C1710a>() { // from class: com.baidu.android.pushservice.h.a.a.a.a.1
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
                public C1710a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1710a(codedInputStream, extensionRegistryLite, null) : (C1710a) invokeLL.objValue;
                }
            };
            C1710a c1710a = new C1710a();
            f32992b = c1710a;
            c1710a.p();
        }

        public C1710a() {
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
            this.f32999i = (byte) -1;
            this.f33000j = -1;
        }

        public C1710a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f32999i = (byte) -1;
            this.f33000j = -1;
            p();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f32993c |= 1;
                                this.f32994d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f32993c |= 2;
                                this.f32995e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f32993c |= 4;
                                this.f32996f = codedInputStream.readInt64();
                            } else if (readTag == 34) {
                                this.f32993c |= 8;
                                this.f32997g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f32993c |= 16;
                                this.f32998h = codedInputStream.readInt64();
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

        public /* synthetic */ C1710a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1710a(GeneratedMessageLite.Builder builder) {
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
            this.f32999i = (byte) -1;
            this.f33000j = -1;
        }

        public /* synthetic */ C1710a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1711a a(C1710a c1710a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c1710a)) == null) ? m().mergeFrom(c1710a) : (C1711a) invokeL.objValue;
        }

        public static C1710a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32992b : (C1710a) invokeV.objValue;
        }

        public static C1711a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1711a.h() : (C1711a) invokeV.objValue;
        }

        private void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f32994d = "";
                this.f32995e = "";
                this.f32996f = 0L;
                this.f32997g = "";
                this.f32998h = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1710a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32992b : (C1710a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32993c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32994d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32994d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32993c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32995e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32995e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32993c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C1710a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f33000j;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f32993c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32993c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32993c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f32996f);
                }
                if ((this.f32993c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f32993c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f32998h);
                }
                this.f33000j = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32996f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32993c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32999i;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32999i = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f32997g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32997g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32993c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32998h : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C1711a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? a(this) : (C1711a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C1711a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? m() : (C1711a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f32993c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32993c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32993c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f32996f);
                }
                if ((this.f32993c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f32993c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f32998h);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class aa extends GeneratedMessageLite implements ab {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<aa> a;

        /* renamed from: b  reason: collision with root package name */
        public static final aa f33006b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33007c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33008d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33009e;

        /* renamed from: f  reason: collision with root package name */
        public long f33010f;

        /* renamed from: g  reason: collision with root package name */
        public long f33011g;

        /* renamed from: h  reason: collision with root package name */
        public long f33012h;

        /* renamed from: i  reason: collision with root package name */
        public Object f33013i;

        /* renamed from: j  reason: collision with root package name */
        public long f33014j;

        /* renamed from: k  reason: collision with root package name */
        public byte f33015k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1712a extends GeneratedMessageLite.Builder<aa, C1712a> implements ab {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33016b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33017c;

            /* renamed from: d  reason: collision with root package name */
            public long f33018d;

            /* renamed from: e  reason: collision with root package name */
            public long f33019e;

            /* renamed from: f  reason: collision with root package name */
            public long f33020f;

            /* renamed from: g  reason: collision with root package name */
            public Object f33021g;

            /* renamed from: h  reason: collision with root package name */
            public long f33022h;

            public C1712a() {
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
                this.f33016b = "";
                this.f33017c = "";
                this.f33021g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1712a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1712a() : (C1712a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1712a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33016b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33017c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33018d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33019e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33020f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f33021g = "";
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f33022h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1712a) invokeV.objValue;
            }

            public C1712a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 4;
                    this.f33018d = j2;
                    return this;
                }
                return (C1712a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1712a mergeFrom(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar == aa.a()) {
                        return this;
                    }
                    if (aaVar.c()) {
                        this.a |= 1;
                        this.f33016b = aaVar.f33008d;
                    }
                    if (aaVar.e()) {
                        this.a |= 2;
                        this.f33017c = aaVar.f33009e;
                    }
                    if (aaVar.g()) {
                        a(aaVar.h());
                    }
                    if (aaVar.i()) {
                        b(aaVar.j());
                    }
                    if (aaVar.k()) {
                        c(aaVar.l());
                    }
                    if (aaVar.m()) {
                        this.a |= 32;
                        this.f33021g = aaVar.f33013i;
                    }
                    if (aaVar.o()) {
                        d(aaVar.p());
                    }
                    return this;
                }
                return (C1712a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1712a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    aa aaVar = null;
                    try {
                        try {
                            aa parsePartialFrom = aa.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            aa aaVar2 = (aa) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                aaVar = aaVar2;
                                if (aaVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (aaVar != null) {
                            mergeFrom(aaVar);
                        }
                        throw th;
                    }
                }
                return (C1712a) invokeLL.objValue;
            }

            public C1712a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33016b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1712a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1712a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1712a) invokeV.objValue;
            }

            public C1712a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 8;
                    this.f33019e = j2;
                    return this;
                }
                return (C1712a) invokeJ.objValue;
            }

            public C1712a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f33017c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1712a) invokeL.objValue;
            }

            public C1712a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.a |= 16;
                    this.f33020f = j2;
                    return this;
                }
                return (C1712a) invokeJ.objValue;
            }

            public C1712a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.a |= 32;
                        this.f33021g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1712a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? aa.a() : (aa) invokeV.objValue;
            }

            public C1712a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.a |= 64;
                    this.f33022h = j2;
                    return this;
                }
                return (C1712a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public aa build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    aa buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (aa) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public aa buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    aa aaVar = new aa(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aaVar.f33008d = this.f33016b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aaVar.f33009e = this.f33017c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aaVar.f33010f = this.f33018d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aaVar.f33011g = this.f33019e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aaVar.f33012h = this.f33020f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aaVar.f33013i = this.f33021g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aaVar.f33014j = this.f33022h;
                    aaVar.f33007c = i3;
                    return aaVar;
                }
                return (aa) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1165559667, "Lcom/baidu/android/pushservice/h/a/a/a$aa;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1165559667, "Lcom/baidu/android/pushservice/h/a/a/a$aa;");
                    return;
                }
            }
            a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.h.a.a.a.aa.1
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
                public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new aa(codedInputStream, extensionRegistryLite, null) : (aa) invokeLL.objValue;
                }
            };
            aa aaVar = new aa();
            f33006b = aaVar;
            aaVar.t();
        }

        public aa() {
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
            this.f33015k = (byte) -1;
            this.l = -1;
        }

        public aa(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33015k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f33007c |= 1;
                                    this.f33008d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f33007c |= 2;
                                    this.f33009e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f33007c |= 4;
                                    this.f33010f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f33007c |= 8;
                                    this.f33011g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f33007c |= 16;
                                    this.f33012h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f33007c |= 32;
                                    this.f33013i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f33007c |= 64;
                                    this.f33014j = codedInputStream.readInt64();
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

        public /* synthetic */ aa(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aa(GeneratedMessageLite.Builder builder) {
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
            this.f33015k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ aa(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1712a a(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aaVar)) == null) ? q().mergeFrom(aaVar) : (C1712a) invokeL.objValue;
        }

        public static aa a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f33006b : (aa) invokeV.objValue;
        }

        public static C1712a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1712a.h() : (C1712a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f33008d = "";
                this.f33009e = "";
                this.f33010f = 0L;
                this.f33011g = 0L;
                this.f33012h = 0L;
                this.f33013i = "";
                this.f33014j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33006b : (aa) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33007c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33008d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33008d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33007c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33009e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33009e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33007c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.l;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33007c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33007c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33007c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f33010f);
                }
                if ((this.f33007c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f33011g);
                }
                if ((this.f33007c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f33012h);
                }
                if ((this.f33007c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f33007c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f33014j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33010f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33007c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33015k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33015k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33011g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33007c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33012h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33007c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f33013i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33013i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33007c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33014j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1712a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1712a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1712a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1712a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33007c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33007c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33007c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f33010f);
                }
                if ((this.f33007c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f33011g);
                }
                if ((this.f33007c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f33012h);
                }
                if ((this.f33007c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f33007c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f33014j);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class ac extends GeneratedMessageLite implements ad {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<ac> a;

        /* renamed from: b  reason: collision with root package name */
        public static final ac f33023b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33024c;

        /* renamed from: d  reason: collision with root package name */
        public x f33025d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33026e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33027f;

        /* renamed from: g  reason: collision with root package name */
        public Object f33028g;

        /* renamed from: h  reason: collision with root package name */
        public int f33029h;

        /* renamed from: i  reason: collision with root package name */
        public int f33030i;

        /* renamed from: j  reason: collision with root package name */
        public int f33031j;

        /* renamed from: k  reason: collision with root package name */
        public byte f33032k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1713a extends GeneratedMessageLite.Builder<ac, C1713a> implements ad {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public x f33033b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33034c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33035d;

            /* renamed from: e  reason: collision with root package name */
            public Object f33036e;

            /* renamed from: f  reason: collision with root package name */
            public int f33037f;

            /* renamed from: g  reason: collision with root package name */
            public int f33038g;

            /* renamed from: h  reason: collision with root package name */
            public int f33039h;

            public C1713a() {
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
                this.f33033b = x.a;
                this.f33034c = "";
                this.f33035d = "";
                this.f33036e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1713a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1713a() : (C1713a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1713a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33033b = x.a;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33034c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33035d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33036e = "";
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33037f = 0;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f33038g = 0;
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f33039h = 0;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1713a) invokeV.objValue;
            }

            public C1713a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.a |= 16;
                    this.f33037f = i2;
                    return this;
                }
                return (C1713a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1713a mergeFrom(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acVar)) == null) {
                    if (acVar == ac.a()) {
                        return this;
                    }
                    if (acVar.c()) {
                        a(acVar.d());
                    }
                    if (acVar.e()) {
                        this.a |= 2;
                        this.f33034c = acVar.f33026e;
                    }
                    if (acVar.g()) {
                        this.a |= 4;
                        this.f33035d = acVar.f33027f;
                    }
                    if (acVar.i()) {
                        this.a |= 8;
                        this.f33036e = acVar.f33028g;
                    }
                    if (acVar.k()) {
                        a(acVar.l());
                    }
                    if (acVar.m()) {
                        b(acVar.n());
                    }
                    if (acVar.o()) {
                        c(acVar.p());
                    }
                    return this;
                }
                return (C1713a) invokeL.objValue;
            }

            public C1713a a(x xVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xVar)) == null) {
                    if (xVar != null) {
                        this.a |= 1;
                        this.f33033b = xVar;
                        return this;
                    }
                    throw null;
                }
                return (C1713a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1713a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, codedInputStream, extensionRegistryLite)) == null) {
                    ac acVar = null;
                    try {
                        try {
                            ac parsePartialFrom = ac.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            ac acVar2 = (ac) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                acVar = acVar2;
                                if (acVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (acVar != null) {
                            mergeFrom(acVar);
                        }
                        throw th;
                    }
                }
                return (C1713a) invokeLL.objValue;
            }

            public C1713a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f33034c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1713a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1713a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h().mergeFrom(buildPartial()) : (C1713a) invokeV.objValue;
            }

            public C1713a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                    this.a |= 32;
                    this.f33038g = i2;
                    return this;
                }
                return (C1713a) invokeI.objValue;
            }

            public C1713a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f33035d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1713a) invokeL.objValue;
            }

            public C1713a c(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                    this.a |= 64;
                    this.f33039h = i2;
                    return this;
                }
                return (C1713a) invokeI.objValue;
            }

            public C1713a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                    if (str != null) {
                        this.a |= 8;
                        this.f33036e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1713a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ac getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ac.a() : (ac) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public ac build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    ac buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (ac) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ac buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    ac acVar = new ac(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    acVar.f33025d = this.f33033b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    acVar.f33026e = this.f33034c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    acVar.f33027f = this.f33035d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    acVar.f33028g = this.f33036e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    acVar.f33029h = this.f33037f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    acVar.f33030i = this.f33038g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    acVar.f33031j = this.f33039h;
                    acVar.f33024c = i3;
                    return acVar;
                }
                return (ac) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1165559729, "Lcom/baidu/android/pushservice/h/a/a/a$ac;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1165559729, "Lcom/baidu/android/pushservice/h/a/a/a$ac;");
                    return;
                }
            }
            a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.h.a.a.a.ac.1
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
                public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new ac(codedInputStream, extensionRegistryLite, null) : (ac) invokeLL.objValue;
                }
            };
            ac acVar = new ac();
            f33023b = acVar;
            acVar.t();
        }

        public ac() {
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
            this.f33032k = (byte) -1;
            this.l = -1;
        }

        public ac(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33032k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                x a2 = x.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f33024c = 1 | this.f33024c;
                                    this.f33025d = a2;
                                }
                            } else if (readTag == 18) {
                                this.f33024c |= 2;
                                this.f33026e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f33024c |= 4;
                                this.f33027f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f33024c |= 8;
                                this.f33028g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f33024c |= 16;
                                this.f33029h = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.f33024c |= 32;
                                this.f33030i = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.f33024c |= 64;
                                this.f33031j = codedInputStream.readInt32();
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

        public /* synthetic */ ac(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ac(GeneratedMessageLite.Builder builder) {
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
            this.f33032k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ ac(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1713a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, acVar)) == null) ? q().mergeFrom(acVar) : (C1713a) invokeL.objValue;
        }

        public static ac a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f33023b : (ac) invokeV.objValue;
        }

        public static C1713a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1713a.h() : (C1713a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f33025d = x.a;
                this.f33026e = "";
                this.f33027f = "";
                this.f33028g = "";
                this.f33029h = 0;
                this.f33030i = 0;
                this.f33031j = 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33023b : (ac) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33024c & 1) == 1 : invokeV.booleanValue;
        }

        public x d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33025d : (x) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33024c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33026e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33026e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33024c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.l;
                if (i2 != -1) {
                    return i2;
                }
                int computeEnumSize = (this.f33024c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f33025d.getNumber()) : 0;
                if ((this.f33024c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33024c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f33024c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f33024c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f33029h);
                }
                if ((this.f33024c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f33030i);
                }
                if ((this.f33024c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.f33031j);
                }
                this.l = computeEnumSize;
                return computeEnumSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33027f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33027f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33024c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33032k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33032k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f33028g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33028g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33024c & 16) == 16 : invokeV.booleanValue;
        }

        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33029h : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33024c & 32) == 32 : invokeV.booleanValue;
        }

        public int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33030i : invokeV.intValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33024c & 64) == 64 : invokeV.booleanValue;
        }

        public int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33031j : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1713a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1713a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1713a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1713a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33024c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f33025d.getNumber());
                }
                if ((this.f33024c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33024c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f33024c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f33024c & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.f33029h);
                }
                if ((this.f33024c & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.f33030i);
                }
                if ((this.f33024c & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.f33031j);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class ae extends GeneratedMessageLite implements af {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<ae> a;

        /* renamed from: b  reason: collision with root package name */
        public static final ae f33040b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33041c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33042d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33043e;

        /* renamed from: f  reason: collision with root package name */
        public long f33044f;

        /* renamed from: g  reason: collision with root package name */
        public long f33045g;

        /* renamed from: h  reason: collision with root package name */
        public long f33046h;

        /* renamed from: i  reason: collision with root package name */
        public Object f33047i;

        /* renamed from: j  reason: collision with root package name */
        public long f33048j;

        /* renamed from: k  reason: collision with root package name */
        public byte f33049k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1714a extends GeneratedMessageLite.Builder<ae, C1714a> implements af {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33050b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33051c;

            /* renamed from: d  reason: collision with root package name */
            public long f33052d;

            /* renamed from: e  reason: collision with root package name */
            public long f33053e;

            /* renamed from: f  reason: collision with root package name */
            public long f33054f;

            /* renamed from: g  reason: collision with root package name */
            public Object f33055g;

            /* renamed from: h  reason: collision with root package name */
            public long f33056h;

            public C1714a() {
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
                this.f33050b = "";
                this.f33051c = "";
                this.f33055g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1714a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1714a() : (C1714a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1714a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33050b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33051c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33052d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33053e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33054f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f33055g = "";
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f33056h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1714a) invokeV.objValue;
            }

            public C1714a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 4;
                    this.f33052d = j2;
                    return this;
                }
                return (C1714a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1714a mergeFrom(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aeVar)) == null) {
                    if (aeVar == ae.a()) {
                        return this;
                    }
                    if (aeVar.c()) {
                        this.a |= 1;
                        this.f33050b = aeVar.f33042d;
                    }
                    if (aeVar.e()) {
                        this.a |= 2;
                        this.f33051c = aeVar.f33043e;
                    }
                    if (aeVar.g()) {
                        a(aeVar.h());
                    }
                    if (aeVar.i()) {
                        b(aeVar.j());
                    }
                    if (aeVar.k()) {
                        c(aeVar.l());
                    }
                    if (aeVar.m()) {
                        this.a |= 32;
                        this.f33055g = aeVar.f33047i;
                    }
                    if (aeVar.o()) {
                        d(aeVar.p());
                    }
                    return this;
                }
                return (C1714a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1714a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    ae aeVar = null;
                    try {
                        try {
                            ae parsePartialFrom = ae.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            ae aeVar2 = (ae) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                aeVar = aeVar2;
                                if (aeVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (aeVar != null) {
                            mergeFrom(aeVar);
                        }
                        throw th;
                    }
                }
                return (C1714a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1714a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1714a) invokeV.objValue;
            }

            public C1714a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.a |= 8;
                    this.f33053e = j2;
                    return this;
                }
                return (C1714a) invokeJ.objValue;
            }

            public C1714a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.a |= 16;
                    this.f33054f = j2;
                    return this;
                }
                return (C1714a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ae.a() : (ae) invokeV.objValue;
            }

            public C1714a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.a |= 64;
                    this.f33056h = j2;
                    return this;
                }
                return (C1714a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public ae build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    ae buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (ae) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ae buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    ae aeVar = new ae(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aeVar.f33042d = this.f33050b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aeVar.f33043e = this.f33051c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aeVar.f33044f = this.f33052d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aeVar.f33045g = this.f33053e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aeVar.f33046h = this.f33054f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aeVar.f33047i = this.f33055g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aeVar.f33048j = this.f33056h;
                    aeVar.f33041c = i3;
                    return aeVar;
                }
                return (ae) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1165559791, "Lcom/baidu/android/pushservice/h/a/a/a$ae;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1165559791, "Lcom/baidu/android/pushservice/h/a/a/a$ae;");
                    return;
                }
            }
            a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.h.a.a.a.ae.1
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
                public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new ae(codedInputStream, extensionRegistryLite, null) : (ae) invokeLL.objValue;
                }
            };
            ae aeVar = new ae();
            f33040b = aeVar;
            aeVar.t();
        }

        public ae() {
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
            this.f33049k = (byte) -1;
            this.l = -1;
        }

        public ae(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33049k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f33041c |= 1;
                                    this.f33042d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f33041c |= 2;
                                    this.f33043e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f33041c |= 4;
                                    this.f33044f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f33041c |= 8;
                                    this.f33045g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f33041c |= 16;
                                    this.f33046h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f33041c |= 32;
                                    this.f33047i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f33041c |= 64;
                                    this.f33048j = codedInputStream.readInt64();
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

        public /* synthetic */ ae(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ae(GeneratedMessageLite.Builder builder) {
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
            this.f33049k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ ae(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1714a a(ae aeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aeVar)) == null) ? q().mergeFrom(aeVar) : (C1714a) invokeL.objValue;
        }

        public static ae a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f33040b : (ae) invokeV.objValue;
        }

        public static C1714a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1714a.h() : (C1714a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f33042d = "";
                this.f33043e = "";
                this.f33044f = 0L;
                this.f33045g = 0L;
                this.f33046h = 0L;
                this.f33047i = "";
                this.f33048j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33040b : (ae) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33041c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33042d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33042d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33041c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33043e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33043e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33041c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.l;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33041c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33041c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33041c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f33044f);
                }
                if ((this.f33041c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f33045g);
                }
                if ((this.f33041c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f33046h);
                }
                if ((this.f33041c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f33041c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f33048j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33044f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33041c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33049k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33049k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33045g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33041c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33046h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33041c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f33047i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33047i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33041c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33048j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1714a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1714a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1714a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1714a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33041c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33041c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33041c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f33044f);
                }
                if ((this.f33041c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f33045g);
                }
                if ((this.f33041c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f33046h);
                }
                if ((this.f33041c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f33041c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f33048j);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class c extends GeneratedMessageLite implements d {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<c> a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f33057b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33058c;

        /* renamed from: d  reason: collision with root package name */
        public e f33059d;

        /* renamed from: e  reason: collision with root package name */
        public ae f33060e;

        /* renamed from: f  reason: collision with root package name */
        public l f33061f;

        /* renamed from: g  reason: collision with root package name */
        public n f33062g;

        /* renamed from: h  reason: collision with root package name */
        public j f33063h;

        /* renamed from: i  reason: collision with root package name */
        public aa f33064i;

        /* renamed from: j  reason: collision with root package name */
        public C1710a f33065j;

        /* renamed from: k  reason: collision with root package name */
        public t f33066k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1715a extends GeneratedMessageLite.Builder<c, C1715a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public e f33067b;

            /* renamed from: c  reason: collision with root package name */
            public ae f33068c;

            /* renamed from: d  reason: collision with root package name */
            public l f33069d;

            /* renamed from: e  reason: collision with root package name */
            public n f33070e;

            /* renamed from: f  reason: collision with root package name */
            public j f33071f;

            /* renamed from: g  reason: collision with root package name */
            public aa f33072g;

            /* renamed from: h  reason: collision with root package name */
            public C1710a f33073h;

            /* renamed from: i  reason: collision with root package name */
            public t f33074i;

            public C1715a() {
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
                this.f33067b = e.a;
                this.f33068c = ae.a();
                this.f33069d = l.a();
                this.f33070e = n.a();
                this.f33071f = j.a();
                this.f33072g = aa.a();
                this.f33073h = C1710a.a();
                this.f33074i = t.a();
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1715a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1715a() : (C1715a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1715a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33067b = e.a;
                    this.a &= -2;
                    this.f33068c = ae.a();
                    this.a &= -3;
                    this.f33069d = l.a();
                    this.a &= -5;
                    this.f33070e = n.a();
                    this.a &= -9;
                    this.f33071f = j.a();
                    this.a &= -17;
                    this.f33072g = aa.a();
                    this.a &= -33;
                    this.f33073h = C1710a.a();
                    this.a &= -65;
                    this.f33074i = t.a();
                    this.a &= -129;
                    return this;
                }
                return (C1715a) invokeV.objValue;
            }

            public C1715a a(C1710a c1710a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1710a)) == null) {
                    if (c1710a != null) {
                        this.f33073h = c1710a;
                        this.a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar != null) {
                        this.f33072g = aaVar;
                        this.a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aeVar)) == null) {
                    if ((this.a & 2) == 2 && this.f33068c != ae.a()) {
                        aeVar = ae.a(this.f33068c).mergeFrom(aeVar).buildPartial();
                    }
                    this.f33068c = aeVar;
                    this.a |= 2;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1715a mergeFrom(c cVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
                    if (cVar == c.a()) {
                        return this;
                    }
                    if (cVar.c()) {
                        a(cVar.d());
                    }
                    if (cVar.e()) {
                        a(cVar.f());
                    }
                    if (cVar.g()) {
                        b(cVar.h());
                    }
                    if (cVar.i()) {
                        b(cVar.j());
                    }
                    if (cVar.k()) {
                        b(cVar.l());
                    }
                    if (cVar.m()) {
                        b(cVar.n());
                    }
                    if (cVar.o()) {
                        b(cVar.p());
                    }
                    if (cVar.q()) {
                        a(cVar.r());
                    }
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(e eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
                    if (eVar != null) {
                        this.a |= 1;
                        this.f33067b = eVar;
                        return this;
                    }
                    throw null;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                    if (jVar != null) {
                        this.f33071f = jVar;
                        this.a |= 16;
                        return this;
                    }
                    throw null;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
                    if (lVar != null) {
                        this.f33069d = lVar;
                        this.a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) {
                    if (nVar != null) {
                        this.f33070e = nVar;
                        this.a |= 8;
                        return this;
                    }
                    throw null;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a a(t tVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tVar)) == null) {
                    if ((this.a & 128) == 128 && this.f33074i != t.a()) {
                        tVar = t.a(this.f33074i).mergeFrom(tVar).buildPartial();
                    }
                    this.f33074i = tVar;
                    this.a |= 128;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1715a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, codedInputStream, extensionRegistryLite)) == null) {
                    c cVar = null;
                    try {
                        try {
                            c parsePartialFrom = c.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1715a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1715a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? h().mergeFrom(buildPartial()) : (C1715a) invokeV.objValue;
            }

            public C1715a b(C1710a c1710a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, c1710a)) == null) {
                    if ((this.a & 64) == 64 && this.f33073h != C1710a.a()) {
                        c1710a = C1710a.a(this.f33073h).mergeFrom(c1710a).buildPartial();
                    }
                    this.f33073h = c1710a;
                    this.a |= 64;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a b(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aaVar)) == null) {
                    if ((this.a & 32) == 32 && this.f33072g != aa.a()) {
                        aaVar = aa.a(this.f33072g).mergeFrom(aaVar).buildPartial();
                    }
                    this.f33072g = aaVar;
                    this.a |= 32;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a b(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jVar)) == null) {
                    if ((this.a & 16) == 16 && this.f33071f != j.a()) {
                        jVar = j.a(this.f33071f).mergeFrom(jVar).buildPartial();
                    }
                    this.f33071f = jVar;
                    this.a |= 16;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a b(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, lVar)) == null) {
                    if ((this.a & 4) == 4 && this.f33069d != l.a()) {
                        lVar = l.a(this.f33069d).mergeFrom(lVar).buildPartial();
                    }
                    this.f33069d = lVar;
                    this.a |= 4;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            public C1715a b(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, nVar)) == null) {
                    if ((this.a & 8) == 8 && this.f33070e != n.a()) {
                        nVar = n.a(this.f33070e).mergeFrom(nVar).buildPartial();
                    }
                    this.f33070e = nVar;
                    this.a |= 8;
                    return this;
                }
                return (C1715a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public c getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c.a() : (c) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public c build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    c cVar = new c(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f33059d = this.f33067b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f33060e = this.f33068c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f33061f = this.f33069d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.f33062g = this.f33070e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    cVar.f33063h = this.f33071f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    cVar.f33064i = this.f33072g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    cVar.f33065j = this.f33073h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    cVar.f33066k = this.f33074i;
                    cVar.f33058c = i3;
                    return cVar;
                }
                return (c) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779936, "Lcom/baidu/android/pushservice/h/a/a/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779936, "Lcom/baidu/android/pushservice/h/a/a/a$c;");
                    return;
                }
            }
            a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.h.a.a.a.c.1
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
            f33057b = cVar;
            cVar.v();
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
            this.l = (byte) -1;
            this.m = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 8) {
                                    if (readTag == 18) {
                                        i2 = 2;
                                        ae.C1714a builder = (this.f33058c & 2) == 2 ? this.f33060e.toBuilder() : null;
                                        ae aeVar = (ae) codedInputStream.readMessage(ae.a, extensionRegistryLite);
                                        this.f33060e = aeVar;
                                        if (builder != null) {
                                            builder.mergeFrom(aeVar);
                                            this.f33060e = builder.buildPartial();
                                        }
                                        i3 = this.f33058c;
                                    } else if (readTag == 26) {
                                        i2 = 4;
                                        l.C1719a builder2 = (this.f33058c & 4) == 4 ? this.f33061f.toBuilder() : null;
                                        l lVar = (l) codedInputStream.readMessage(l.a, extensionRegistryLite);
                                        this.f33061f = lVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(lVar);
                                            this.f33061f = builder2.buildPartial();
                                        }
                                        i3 = this.f33058c;
                                    } else if (readTag == 34) {
                                        n.C1720a builder3 = (this.f33058c & 8) == 8 ? this.f33062g.toBuilder() : null;
                                        n nVar = (n) codedInputStream.readMessage(n.a, extensionRegistryLite);
                                        this.f33062g = nVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(nVar);
                                            this.f33062g = builder3.buildPartial();
                                        }
                                        this.f33058c |= 8;
                                    } else if (readTag == 42) {
                                        i2 = 16;
                                        j.C1718a builder4 = (this.f33058c & 16) == 16 ? this.f33063h.toBuilder() : null;
                                        j jVar = (j) codedInputStream.readMessage(j.a, extensionRegistryLite);
                                        this.f33063h = jVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(jVar);
                                            this.f33063h = builder4.buildPartial();
                                        }
                                        i3 = this.f33058c;
                                    } else if (readTag == 50) {
                                        i2 = 32;
                                        aa.C1712a builder5 = (this.f33058c & 32) == 32 ? this.f33064i.toBuilder() : null;
                                        aa aaVar = (aa) codedInputStream.readMessage(aa.a, extensionRegistryLite);
                                        this.f33064i = aaVar;
                                        if (builder5 != null) {
                                            builder5.mergeFrom(aaVar);
                                            this.f33064i = builder5.buildPartial();
                                        }
                                        i3 = this.f33058c;
                                    } else if (readTag == 58) {
                                        i2 = 64;
                                        C1710a.C1711a builder6 = (this.f33058c & 64) == 64 ? this.f33065j.toBuilder() : null;
                                        C1710a c1710a = (C1710a) codedInputStream.readMessage(C1710a.a, extensionRegistryLite);
                                        this.f33065j = c1710a;
                                        if (builder6 != null) {
                                            builder6.mergeFrom(c1710a);
                                            this.f33065j = builder6.buildPartial();
                                        }
                                        i3 = this.f33058c;
                                    } else if (readTag == 66) {
                                        i2 = 128;
                                        t.C1723a builder7 = (this.f33058c & 128) == 128 ? this.f33066k.toBuilder() : null;
                                        t tVar = (t) codedInputStream.readMessage(t.a, extensionRegistryLite);
                                        this.f33066k = tVar;
                                        if (builder7 != null) {
                                            builder7.mergeFrom(tVar);
                                            this.f33066k = builder7.buildPartial();
                                        }
                                        i3 = this.f33058c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f33058c = i3 | i2;
                                } else {
                                    e a2 = e.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f33058c = 1 | this.f33058c;
                                        this.f33059d = a2;
                                    }
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
            this.l = (byte) -1;
            this.m = -1;
        }

        public /* synthetic */ c(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1715a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cVar)) == null) ? s().mergeFrom(cVar) : (C1715a) invokeL.objValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f33057b : (c) invokeV.objValue;
        }

        public static C1715a s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1715a.h() : (C1715a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f33059d = e.a;
                this.f33060e = ae.a();
                this.f33061f = l.a();
                this.f33062g = n.a();
                this.f33063h = j.a();
                this.f33064i = aa.a();
                this.f33065j = C1710a.a();
                this.f33066k = t.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33057b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33058c & 1) == 1 : invokeV.booleanValue;
        }

        public e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33059d : (e) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33058c & 2) == 2 : invokeV.booleanValue;
        }

        public ae f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33060e : (ae) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33058c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.m;
                if (i2 != -1) {
                    return i2;
                }
                int computeEnumSize = (this.f33058c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f33059d.getNumber()) : 0;
                if ((this.f33058c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f33060e);
                }
                if ((this.f33058c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f33061f);
                }
                if ((this.f33058c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f33062g);
                }
                if ((this.f33058c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f33063h);
                }
                if ((this.f33058c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f33064i);
                }
                if ((this.f33058c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(7, this.f33065j);
                }
                if ((this.f33058c & 128) == 128) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(8, this.f33066k);
                }
                this.m = computeEnumSize;
                return computeEnumSize;
            }
            return invokeV.intValue;
        }

        public l h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33061f : (l) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33058c & 8) == 8 : invokeV.booleanValue;
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

        public n j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33062g : (n) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33058c & 16) == 16 : invokeV.booleanValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33063h : (j) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33058c & 32) == 32 : invokeV.booleanValue;
        }

        public aa n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33064i : (aa) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33058c & 64) == 64 : invokeV.booleanValue;
        }

        public C1710a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33065j : (C1710a) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f33058c & 128) == 128 : invokeV.booleanValue;
        }

        public t r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f33066k : (t) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C1715a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? s() : (C1715a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1715a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1715a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33058c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f33059d.getNumber());
                }
                if ((this.f33058c & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.f33060e);
                }
                if ((this.f33058c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f33061f);
                }
                if ((this.f33058c & 8) == 8) {
                    codedOutputStream.writeMessage(4, this.f33062g);
                }
                if ((this.f33058c & 16) == 16) {
                    codedOutputStream.writeMessage(5, this.f33063h);
                }
                if ((this.f33058c & 32) == 32) {
                    codedOutputStream.writeMessage(6, this.f33064i);
                }
                if ((this.f33058c & 64) == 64) {
                    codedOutputStream.writeMessage(7, this.f33065j);
                }
                if ((this.f33058c & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.f33066k);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class e implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f33075b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f33076c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f33077d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f33078e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f33079f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f33080g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ e[] f33081i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f33082h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779874, "Lcom/baidu/android/pushservice/h/a/a/a$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779874, "Lcom/baidu/android/pushservice/h/a/a/a$e;");
                    return;
                }
            }
            a = new e("UI", 0, 101);
            f33075b = new e("CRASH", 1, 201);
            f33076c = new e("DB", 2, 301);
            f33077d = new e("CONNECTION", 3, 401);
            f33078e = new e("REQUEST", 4, 501);
            f33079f = new e("ACK", 5, 601);
            e eVar = new e("MSG", 6, 701);
            f33080g = eVar;
            f33081i = new e[]{a, f33075b, f33076c, f33077d, f33078e, f33079f, eVar};
        }

        public e(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33082h = i3;
        }

        public static e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 101) {
                    if (i2 != 201) {
                        if (i2 != 301) {
                            if (i2 != 401) {
                                if (i2 != 501) {
                                    if (i2 != 601) {
                                        if (i2 != 701) {
                                            return null;
                                        }
                                        return f33080g;
                                    }
                                    return f33079f;
                                }
                                return f33078e;
                            }
                            return f33077d;
                        }
                        return f33076c;
                    }
                    return f33075b;
                }
                return a;
            }
            return (e) invokeI.objValue;
        }

        public static e[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f33081i.clone() : (e[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33082h : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class f extends GeneratedMessageLite implements g {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<f> a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f33083b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33084c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33085d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33086e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33087f;

        /* renamed from: g  reason: collision with root package name */
        public byte f33088g;

        /* renamed from: h  reason: collision with root package name */
        public int f33089h;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1716a extends GeneratedMessageLite.Builder<f, C1716a> implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33090b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33091c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33092d;

            public C1716a() {
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
                this.f33090b = "";
                this.f33091c = "";
                this.f33092d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1716a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1716a() : (C1716a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1716a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33090b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33091c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33092d = "";
                    this.a = i3 & (-5);
                    return this;
                }
                return (C1716a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1716a mergeFrom(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
                    if (fVar == f.a()) {
                        return this;
                    }
                    if (fVar.c()) {
                        this.a |= 1;
                        this.f33090b = fVar.f33085d;
                    }
                    if (fVar.e()) {
                        this.a |= 2;
                        this.f33091c = fVar.f33086e;
                    }
                    if (fVar.g()) {
                        this.a |= 4;
                        this.f33092d = fVar.f33087f;
                    }
                    return this;
                }
                return (C1716a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1716a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    f fVar = null;
                    try {
                        try {
                            f parsePartialFrom = f.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            f fVar2 = (f) e2.getUnfinishedMessage();
                            try {
                                throw e2;
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
                return (C1716a) invokeLL.objValue;
            }

            public C1716a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33090b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1716a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1716a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1716a) invokeV.objValue;
            }

            public C1716a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f33091c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1716a) invokeL.objValue;
            }

            public C1716a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f33092d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1716a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public f getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? f.a() : (f) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public f build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    f buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (f) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public f buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    f fVar = new f(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    fVar.f33085d = this.f33090b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    fVar.f33086e = this.f33091c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    fVar.f33087f = this.f33092d;
                    fVar.f33084c = i3;
                    return fVar;
                }
                return (f) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779843, "Lcom/baidu/android/pushservice/h/a/a/a$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779843, "Lcom/baidu/android/pushservice/h/a/a/a$f;");
                    return;
                }
            }
            a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.h.a.a.a.f.1
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
                public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new f(codedInputStream, extensionRegistryLite, null) : (f) invokeLL.objValue;
                }
            };
            f fVar = new f();
            f33083b = fVar;
            fVar.l();
        }

        public f() {
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
            this.f33088g = (byte) -1;
            this.f33089h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33088g = (byte) -1;
            this.f33089h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f33084c |= 1;
                                this.f33085d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f33084c |= 2;
                                this.f33086e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f33084c |= 4;
                                this.f33087f = codedInputStream.readBytes();
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

        public /* synthetic */ f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
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
            this.f33088g = (byte) -1;
            this.f33089h = -1;
        }

        public /* synthetic */ f(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1716a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) ? i().mergeFrom(fVar) : (C1716a) invokeL.objValue;
        }

        public static f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f33083b : (f) invokeV.objValue;
        }

        public static C1716a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1716a.h() : (C1716a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f33085d = "";
                this.f33086e = "";
                this.f33087f = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33083b : (f) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33084c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33085d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33085d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33084c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33086e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33086e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33084c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f33089h;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33084c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33084c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33084c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f33089h = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33087f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33087f = copyFromUtf8;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.f33088g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33088g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1716a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1716a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1716a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1716a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33084c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33084c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33084c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class h extends GeneratedMessageLite implements i {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<h> a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f33093b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33094c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33095d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33096e;

        /* renamed from: f  reason: collision with root package name */
        public p f33097f;

        /* renamed from: g  reason: collision with root package name */
        public long f33098g;

        /* renamed from: h  reason: collision with root package name */
        public long f33099h;

        /* renamed from: i  reason: collision with root package name */
        public ac f33100i;

        /* renamed from: j  reason: collision with root package name */
        public f f33101j;

        /* renamed from: k  reason: collision with root package name */
        public v f33102k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1717a extends GeneratedMessageLite.Builder<h, C1717a> implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33103b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33104c;

            /* renamed from: d  reason: collision with root package name */
            public p f33105d;

            /* renamed from: e  reason: collision with root package name */
            public long f33106e;

            /* renamed from: f  reason: collision with root package name */
            public long f33107f;

            /* renamed from: g  reason: collision with root package name */
            public ac f33108g;

            /* renamed from: h  reason: collision with root package name */
            public f f33109h;

            /* renamed from: i  reason: collision with root package name */
            public v f33110i;

            public C1717a() {
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
                this.f33103b = "";
                this.f33104c = "";
                this.f33105d = p.a();
                this.f33108g = ac.a();
                this.f33109h = f.a();
                this.f33110i = v.a();
                j();
            }

            private void j() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1717a k() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1717a() : (C1717a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1717a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33103b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33104c = "";
                    this.a = i2 & (-3);
                    this.f33105d = p.a();
                    int i3 = this.a & (-5);
                    this.a = i3;
                    this.f33106e = 0L;
                    int i4 = i3 & (-9);
                    this.a = i4;
                    this.f33107f = 0L;
                    this.a = i4 & (-17);
                    this.f33108g = ac.a();
                    this.a &= -33;
                    this.f33109h = f.a();
                    this.a &= -65;
                    this.f33110i = v.a();
                    this.a &= -129;
                    return this;
                }
                return (C1717a) invokeV.objValue;
            }

            public C1717a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 8;
                    this.f33106e = j2;
                    return this;
                }
                return (C1717a) invokeJ.objValue;
            }

            public C1717a a(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acVar)) == null) {
                    if (acVar != null) {
                        this.f33108g = acVar;
                        this.a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1717a) invokeL.objValue;
            }

            public C1717a a(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                    if (fVar != null) {
                        this.f33109h = fVar;
                        this.a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1717a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1717a mergeFrom(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
                    if (hVar == h.a()) {
                        return this;
                    }
                    if (hVar.c()) {
                        this.a |= 1;
                        this.f33103b = hVar.f33095d;
                    }
                    if (hVar.e()) {
                        this.a |= 2;
                        this.f33104c = hVar.f33096e;
                    }
                    if (hVar.g()) {
                        b(hVar.h());
                    }
                    if (hVar.i()) {
                        a(hVar.j());
                    }
                    if (hVar.k()) {
                        b(hVar.l());
                    }
                    if (hVar.m()) {
                        b(hVar.n());
                    }
                    if (hVar.o()) {
                        b(hVar.p());
                    }
                    if (hVar.q()) {
                        b(hVar.r());
                    }
                    return this;
                }
                return (C1717a) invokeL.objValue;
            }

            public C1717a a(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pVar)) == null) {
                    if (pVar != null) {
                        this.f33105d = pVar;
                        this.a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1717a) invokeL.objValue;
            }

            public C1717a a(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vVar)) == null) {
                    if (vVar != null) {
                        this.f33110i = vVar;
                        this.a |= 128;
                        return this;
                    }
                    throw null;
                }
                return (C1717a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1717a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, codedInputStream, extensionRegistryLite)) == null) {
                    h hVar = null;
                    try {
                        try {
                            h parsePartialFrom = h.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            h hVar2 = (h) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                hVar = hVar2;
                                if (hVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (hVar != null) {
                            mergeFrom(hVar);
                        }
                        throw th;
                    }
                }
                return (C1717a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1717a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? k().mergeFrom(buildPartial()) : (C1717a) invokeV.objValue;
            }

            public C1717a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                    this.a |= 16;
                    this.f33107f = j2;
                    return this;
                }
                return (C1717a) invokeJ.objValue;
            }

            public C1717a b(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, acVar)) == null) {
                    if ((this.a & 32) == 32 && this.f33108g != ac.a()) {
                        acVar = ac.a(this.f33108g).mergeFrom(acVar).buildPartial();
                    }
                    this.f33108g = acVar;
                    this.a |= 32;
                    return this;
                }
                return (C1717a) invokeL.objValue;
            }

            public C1717a b(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
                    if ((this.a & 64) == 64 && this.f33109h != f.a()) {
                        fVar = f.a(this.f33109h).mergeFrom(fVar).buildPartial();
                    }
                    this.f33109h = fVar;
                    this.a |= 64;
                    return this;
                }
                return (C1717a) invokeL.objValue;
            }

            public C1717a b(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pVar)) == null) {
                    if ((this.a & 4) == 4 && this.f33105d != p.a()) {
                        pVar = p.a(this.f33105d).mergeFrom(pVar).buildPartial();
                    }
                    this.f33105d = pVar;
                    this.a |= 4;
                    return this;
                }
                return (C1717a) invokeL.objValue;
            }

            public C1717a b(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vVar)) == null) {
                    if ((this.a & 128) == 128 && this.f33110i != v.a()) {
                        vVar = v.a(this.f33110i).mergeFrom(vVar).buildPartial();
                    }
                    this.f33110i = vVar;
                    this.a |= 128;
                    return this;
                }
                return (C1717a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public h getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? h.a() : (h) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public h build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    h buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (h) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public h buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    h hVar = new h(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    hVar.f33095d = this.f33103b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    hVar.f33096e = this.f33104c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    hVar.f33097f = this.f33105d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    hVar.f33098g = this.f33106e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    hVar.f33099h = this.f33107f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    hVar.f33100i = this.f33108g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    hVar.f33101j = this.f33109h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    hVar.f33102k = this.f33110i;
                    hVar.f33094c = i3;
                    return hVar;
                }
                return (h) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.a & 4) == 4 : invokeV.booleanValue;
            }

            public p g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f33105d : (p) invokeV.objValue;
            }

            public boolean h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.a & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    if (h()) {
                        if (f()) {
                            return g().isInitialized();
                        }
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779781, "Lcom/baidu/android/pushservice/h/a/a/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779781, "Lcom/baidu/android/pushservice/h/a/a/a$h;");
                    return;
                }
            }
            a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.h.a.a.a.h.1
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
                public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new h(codedInputStream, extensionRegistryLite, null) : (h) invokeLL.objValue;
                }
            };
            h hVar = new h();
            f33093b = hVar;
            hVar.v();
        }

        public h() {
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
            this.l = (byte) -1;
            this.m = -1;
        }

        public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f33094c |= 1;
                                    this.f33095d = codedInputStream.readBytes();
                                } else if (readTag != 18) {
                                    if (readTag == 58) {
                                        i2 = 4;
                                        p.C1721a builder = (this.f33094c & 4) == 4 ? this.f33097f.toBuilder() : null;
                                        p pVar = (p) codedInputStream.readMessage(p.a, extensionRegistryLite);
                                        this.f33097f = pVar;
                                        if (builder != null) {
                                            builder.mergeFrom(pVar);
                                            this.f33097f = builder.buildPartial();
                                        }
                                        i3 = this.f33094c;
                                    } else if (readTag == 80) {
                                        this.f33094c |= 8;
                                        this.f33098g = codedInputStream.readInt64();
                                    } else if (readTag == 96) {
                                        this.f33094c |= 16;
                                        this.f33099h = codedInputStream.readInt64();
                                    } else if (readTag == 162) {
                                        i2 = 32;
                                        ac.C1713a builder2 = (this.f33094c & 32) == 32 ? this.f33100i.toBuilder() : null;
                                        ac acVar = (ac) codedInputStream.readMessage(ac.a, extensionRegistryLite);
                                        this.f33100i = acVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(acVar);
                                            this.f33100i = builder2.buildPartial();
                                        }
                                        i3 = this.f33094c;
                                    } else if (readTag == 170) {
                                        i2 = 64;
                                        f.C1716a builder3 = (this.f33094c & 64) == 64 ? this.f33101j.toBuilder() : null;
                                        f fVar = (f) codedInputStream.readMessage(f.a, extensionRegistryLite);
                                        this.f33101j = fVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(fVar);
                                            this.f33101j = builder3.buildPartial();
                                        }
                                        i3 = this.f33094c;
                                    } else if (readTag == 178) {
                                        i2 = 128;
                                        v.C1724a builder4 = (this.f33094c & 128) == 128 ? this.f33102k.toBuilder() : null;
                                        v vVar = (v) codedInputStream.readMessage(v.a, extensionRegistryLite);
                                        this.f33102k = vVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(vVar);
                                            this.f33102k = builder4.buildPartial();
                                        }
                                        i3 = this.f33094c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f33094c = i3 | i2;
                                } else {
                                    this.f33094c |= 2;
                                    this.f33096e = codedInputStream.readBytes();
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

        public /* synthetic */ h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(GeneratedMessageLite.Builder builder) {
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
            this.l = (byte) -1;
            this.m = -1;
        }

        public /* synthetic */ h(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1717a a(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hVar)) == null) ? t().mergeFrom(hVar) : (C1717a) invokeL.objValue;
        }

        public static h a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f33093b : (h) invokeV.objValue;
        }

        public static C1717a t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1717a.k() : (C1717a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f33095d = "";
                this.f33096e = "";
                this.f33097f = p.a();
                this.f33098g = 0L;
                this.f33099h = 0L;
                this.f33100i = ac.a();
                this.f33101j = f.a();
                this.f33102k = v.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33093b : (h) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33094c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33095d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33095d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33094c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33096e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33096e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33094c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.m;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33094c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33094c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33094c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f33097f);
                }
                if ((this.f33094c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f33098g);
                }
                if ((this.f33094c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f33099h);
                }
                if ((this.f33094c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f33100i);
                }
                if ((this.f33094c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(21, this.f33101j);
                }
                if ((this.f33094c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(22, this.f33102k);
                }
                this.m = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public p h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33097f : (p) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33094c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.l;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (!i()) {
                    this.l = (byte) 0;
                    return false;
                } else if (!g() || h().isInitialized()) {
                    this.l = (byte) 1;
                    return true;
                } else {
                    this.l = (byte) 0;
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33098g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33094c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33099h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33094c & 32) == 32 : invokeV.booleanValue;
        }

        public ac n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33100i : (ac) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33094c & 64) == 64 : invokeV.booleanValue;
        }

        public f p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33101j : (f) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f33094c & 128) == 128 : invokeV.booleanValue;
        }

        public v r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f33102k : (v) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1717a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? t() : (C1717a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1717a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1717a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33094c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33094c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33094c & 4) == 4) {
                    codedOutputStream.writeMessage(7, this.f33097f);
                }
                if ((this.f33094c & 8) == 8) {
                    codedOutputStream.writeInt64(10, this.f33098g);
                }
                if ((this.f33094c & 16) == 16) {
                    codedOutputStream.writeInt64(12, this.f33099h);
                }
                if ((this.f33094c & 32) == 32) {
                    codedOutputStream.writeMessage(20, this.f33100i);
                }
                if ((this.f33094c & 64) == 64) {
                    codedOutputStream.writeMessage(21, this.f33101j);
                }
                if ((this.f33094c & 128) == 128) {
                    codedOutputStream.writeMessage(22, this.f33102k);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class j extends GeneratedMessageLite implements k {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<j> a;

        /* renamed from: b  reason: collision with root package name */
        public static final j f33111b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33112c;

        /* renamed from: d  reason: collision with root package name */
        public long f33113d;

        /* renamed from: e  reason: collision with root package name */
        public long f33114e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33115f;

        /* renamed from: g  reason: collision with root package name */
        public long f33116g;

        /* renamed from: h  reason: collision with root package name */
        public long f33117h;

        /* renamed from: i  reason: collision with root package name */
        public Object f33118i;

        /* renamed from: j  reason: collision with root package name */
        public long f33119j;

        /* renamed from: k  reason: collision with root package name */
        public byte f33120k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1718a extends GeneratedMessageLite.Builder<j, C1718a> implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public long f33121b;

            /* renamed from: c  reason: collision with root package name */
            public long f33122c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33123d;

            /* renamed from: e  reason: collision with root package name */
            public long f33124e;

            /* renamed from: f  reason: collision with root package name */
            public long f33125f;

            /* renamed from: g  reason: collision with root package name */
            public Object f33126g;

            /* renamed from: h  reason: collision with root package name */
            public long f33127h;

            public C1718a() {
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
                this.f33123d = "";
                this.f33126g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1718a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1718a() : (C1718a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1718a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33121b = 0L;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33122c = 0L;
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33123d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33124e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33125f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f33126g = "";
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f33127h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1718a) invokeV.objValue;
            }

            public C1718a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 1;
                    this.f33121b = j2;
                    return this;
                }
                return (C1718a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1718a mergeFrom(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar)) == null) {
                    if (jVar == j.a()) {
                        return this;
                    }
                    if (jVar.c()) {
                        a(jVar.d());
                    }
                    if (jVar.e()) {
                        b(jVar.f());
                    }
                    if (jVar.g()) {
                        this.a |= 4;
                        this.f33123d = jVar.f33115f;
                    }
                    if (jVar.i()) {
                        c(jVar.j());
                    }
                    if (jVar.k()) {
                        d(jVar.l());
                    }
                    if (jVar.m()) {
                        this.a |= 32;
                        this.f33126g = jVar.f33118i;
                    }
                    if (jVar.o()) {
                        e(jVar.p());
                    }
                    return this;
                }
                return (C1718a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1718a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    j jVar = null;
                    try {
                        try {
                            j parsePartialFrom = j.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            j jVar2 = (j) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                jVar = jVar2;
                                if (jVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (jVar != null) {
                            mergeFrom(jVar);
                        }
                        throw th;
                    }
                }
                return (C1718a) invokeLL.objValue;
            }

            public C1718a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f33123d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1718a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1718a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1718a) invokeV.objValue;
            }

            public C1718a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 2;
                    this.f33122c = j2;
                    return this;
                }
                return (C1718a) invokeJ.objValue;
            }

            public C1718a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 32;
                        this.f33126g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1718a) invokeL.objValue;
            }

            public C1718a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.a |= 8;
                    this.f33124e = j2;
                    return this;
                }
                return (C1718a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j.a() : (j) invokeV.objValue;
            }

            public C1718a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.a |= 16;
                    this.f33125f = j2;
                    return this;
                }
                return (C1718a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public j build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    j buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (j) invokeV.objValue;
            }

            public C1718a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
                    this.a |= 64;
                    this.f33127h = j2;
                    return this;
                }
                return (C1718a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    j jVar = new j(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    jVar.f33113d = this.f33121b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    jVar.f33114e = this.f33122c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    jVar.f33115f = this.f33123d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    jVar.f33116g = this.f33124e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    jVar.f33117h = this.f33125f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    jVar.f33118i = this.f33126g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    jVar.f33119j = this.f33127h;
                    jVar.f33112c = i3;
                    return jVar;
                }
                return (j) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779719, "Lcom/baidu/android/pushservice/h/a/a/a$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779719, "Lcom/baidu/android/pushservice/h/a/a/a$j;");
                    return;
                }
            }
            a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.h.a.a.a.j.1
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
                public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new j(codedInputStream, extensionRegistryLite, null) : (j) invokeLL.objValue;
                }
            };
            j jVar = new j();
            f33111b = jVar;
            jVar.t();
        }

        public j() {
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
            this.f33120k = (byte) -1;
            this.l = -1;
        }

        public j(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33120k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f33112c |= 1;
                                this.f33113d = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.f33112c |= 2;
                                this.f33114e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f33112c |= 4;
                                this.f33115f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f33112c |= 8;
                                this.f33116g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f33112c |= 16;
                                this.f33117h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f33112c |= 32;
                                this.f33118i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f33112c |= 64;
                                this.f33119j = codedInputStream.readInt64();
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

        public /* synthetic */ j(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(GeneratedMessageLite.Builder builder) {
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
            this.f33120k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ j(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1718a a(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jVar)) == null) ? q().mergeFrom(jVar) : (C1718a) invokeL.objValue;
        }

        public static j a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f33111b : (j) invokeV.objValue;
        }

        public static C1718a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1718a.h() : (C1718a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f33113d = 0L;
                this.f33114e = 0L;
                this.f33115f = "";
                this.f33116g = 0L;
                this.f33117h = 0L;
                this.f33118i = "";
                this.f33119j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33111b : (j) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33112c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33113d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33112c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33114e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33112c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.l;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt64Size = (this.f33112c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f33113d) : 0;
                if ((this.f33112c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f33114e);
                }
                if ((this.f33112c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f33112c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f33116g);
                }
                if ((this.f33112c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f33117h);
                }
                if ((this.f33112c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f33112c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f33119j);
                }
                this.l = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33115f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33115f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33112c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33120k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33120k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33116g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33112c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33117h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33112c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f33118i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33118i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33112c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33119j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1718a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1718a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1718a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1718a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33112c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f33113d);
                }
                if ((this.f33112c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f33114e);
                }
                if ((this.f33112c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f33112c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f33116g);
                }
                if ((this.f33112c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f33117h);
                }
                if ((this.f33112c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f33112c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f33119j);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class l extends GeneratedMessageLite implements m {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<l> a;

        /* renamed from: b  reason: collision with root package name */
        public static final l f33128b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33129c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33130d;

        /* renamed from: e  reason: collision with root package name */
        public long f33131e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33132f;

        /* renamed from: g  reason: collision with root package name */
        public long f33133g;

        /* renamed from: h  reason: collision with root package name */
        public byte f33134h;

        /* renamed from: i  reason: collision with root package name */
        public int f33135i;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1719a extends GeneratedMessageLite.Builder<l, C1719a> implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33136b;

            /* renamed from: c  reason: collision with root package name */
            public long f33137c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33138d;

            /* renamed from: e  reason: collision with root package name */
            public long f33139e;

            public C1719a() {
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
                this.f33136b = "";
                this.f33138d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1719a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1719a() : (C1719a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1719a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33136b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33137c = 0L;
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33138d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33139e = 0L;
                    this.a = i4 & (-9);
                    return this;
                }
                return (C1719a) invokeV.objValue;
            }

            public C1719a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 2;
                    this.f33137c = j2;
                    return this;
                }
                return (C1719a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1719a mergeFrom(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
                    if (lVar == l.a()) {
                        return this;
                    }
                    if (lVar.c()) {
                        this.a |= 1;
                        this.f33136b = lVar.f33130d;
                    }
                    if (lVar.e()) {
                        a(lVar.f());
                    }
                    if (lVar.g()) {
                        this.a |= 4;
                        this.f33138d = lVar.f33132f;
                    }
                    if (lVar.i()) {
                        b(lVar.j());
                    }
                    return this;
                }
                return (C1719a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1719a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    l lVar = null;
                    try {
                        try {
                            l parsePartialFrom = l.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            l lVar2 = (l) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                lVar = lVar2;
                                if (lVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (lVar != null) {
                            mergeFrom(lVar);
                        }
                        throw th;
                    }
                }
                return (C1719a) invokeLL.objValue;
            }

            public C1719a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33136b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1719a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1719a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1719a) invokeV.objValue;
            }

            public C1719a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 8;
                    this.f33139e = j2;
                    return this;
                }
                return (C1719a) invokeJ.objValue;
            }

            public C1719a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f33138d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1719a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public l getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? l.a() : (l) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public l build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    l buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (l) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public l buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    l lVar = new l(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    lVar.f33130d = this.f33136b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    lVar.f33131e = this.f33137c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    lVar.f33132f = this.f33138d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    lVar.f33133g = this.f33139e;
                    lVar.f33129c = i3;
                    return lVar;
                }
                return (l) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779657, "Lcom/baidu/android/pushservice/h/a/a/a$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779657, "Lcom/baidu/android/pushservice/h/a/a/a$l;");
                    return;
                }
            }
            a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.h.a.a.a.l.1
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
                public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new l(codedInputStream, extensionRegistryLite, null) : (l) invokeLL.objValue;
                }
            };
            l lVar = new l();
            f33128b = lVar;
            lVar.n();
        }

        public l() {
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
            this.f33134h = (byte) -1;
            this.f33135i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33134h = (byte) -1;
            this.f33135i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f33129c |= 1;
                                this.f33130d = codedInputStream.readBytes();
                            } else if (readTag == 16) {
                                this.f33129c |= 2;
                                this.f33131e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f33129c |= 4;
                                this.f33132f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f33129c |= 8;
                                this.f33133g = codedInputStream.readInt64();
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

        public /* synthetic */ l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(GeneratedMessageLite.Builder builder) {
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
            this.f33134h = (byte) -1;
            this.f33135i = -1;
        }

        public /* synthetic */ l(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1719a a(l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lVar)) == null) ? k().mergeFrom(lVar) : (C1719a) invokeL.objValue;
        }

        public static l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f33128b : (l) invokeV.objValue;
        }

        public static C1719a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1719a.h() : (C1719a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f33130d = "";
                this.f33131e = 0L;
                this.f33132f = "";
                this.f33133g = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33128b : (l) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33129c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33130d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33130d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33129c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33131e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33129c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f33135i;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33129c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33129c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f33131e);
                }
                if ((this.f33129c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f33129c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f33133g);
                }
                this.f33135i = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33132f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33132f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33129c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33134h;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33134h = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33133g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1719a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(this) : (C1719a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1719a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? k() : (C1719a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33129c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33129c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f33131e);
                }
                if ((this.f33129c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f33129c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f33133g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class n extends GeneratedMessageLite implements o {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<n> a;

        /* renamed from: b  reason: collision with root package name */
        public static final n f33140b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33141c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33142d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33143e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33144f;

        /* renamed from: g  reason: collision with root package name */
        public Object f33145g;

        /* renamed from: h  reason: collision with root package name */
        public long f33146h;

        /* renamed from: i  reason: collision with root package name */
        public long f33147i;

        /* renamed from: j  reason: collision with root package name */
        public long f33148j;

        /* renamed from: k  reason: collision with root package name */
        public Object f33149k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1720a extends GeneratedMessageLite.Builder<n, C1720a> implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33150b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33151c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33152d;

            /* renamed from: e  reason: collision with root package name */
            public Object f33153e;

            /* renamed from: f  reason: collision with root package name */
            public long f33154f;

            /* renamed from: g  reason: collision with root package name */
            public long f33155g;

            /* renamed from: h  reason: collision with root package name */
            public long f33156h;

            /* renamed from: i  reason: collision with root package name */
            public Object f33157i;

            /* renamed from: j  reason: collision with root package name */
            public long f33158j;

            public C1720a() {
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
                this.f33150b = "";
                this.f33151c = "";
                this.f33152d = "";
                this.f33153e = "";
                this.f33157i = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1720a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1720a() : (C1720a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1720a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33150b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33151c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33152d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33153e = "";
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33154f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f33155g = 0L;
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f33156h = 0L;
                    int i8 = i7 & (-65);
                    this.a = i8;
                    this.f33157i = "";
                    int i9 = i8 & (-129);
                    this.a = i9;
                    this.f33158j = 0L;
                    this.a = i9 & (-257);
                    return this;
                }
                return (C1720a) invokeV.objValue;
            }

            public C1720a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 16;
                    this.f33154f = j2;
                    return this;
                }
                return (C1720a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1720a mergeFrom(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar)) == null) {
                    if (nVar == n.a()) {
                        return this;
                    }
                    if (nVar.c()) {
                        this.a |= 1;
                        this.f33150b = nVar.f33142d;
                    }
                    if (nVar.e()) {
                        this.a |= 2;
                        this.f33151c = nVar.f33143e;
                    }
                    if (nVar.g()) {
                        this.a |= 4;
                        this.f33152d = nVar.f33144f;
                    }
                    if (nVar.i()) {
                        this.a |= 8;
                        this.f33153e = nVar.f33145g;
                    }
                    if (nVar.k()) {
                        a(nVar.l());
                    }
                    if (nVar.m()) {
                        b(nVar.n());
                    }
                    if (nVar.o()) {
                        c(nVar.p());
                    }
                    if (nVar.q()) {
                        this.a |= 128;
                        this.f33157i = nVar.f33149k;
                    }
                    if (nVar.s()) {
                        d(nVar.t());
                    }
                    return this;
                }
                return (C1720a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1720a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    n nVar = null;
                    try {
                        try {
                            n parsePartialFrom = n.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            n nVar2 = (n) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                nVar = nVar2;
                                if (nVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (nVar != null) {
                            mergeFrom(nVar);
                        }
                        throw th;
                    }
                }
                return (C1720a) invokeLL.objValue;
            }

            public C1720a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33150b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1720a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1720a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1720a) invokeV.objValue;
            }

            public C1720a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 32;
                    this.f33155g = j2;
                    return this;
                }
                return (C1720a) invokeJ.objValue;
            }

            public C1720a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f33151c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1720a) invokeL.objValue;
            }

            public C1720a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.a |= 64;
                    this.f33156h = j2;
                    return this;
                }
                return (C1720a) invokeJ.objValue;
            }

            public C1720a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f33152d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1720a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? n.a() : (n) invokeV.objValue;
            }

            public C1720a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.a |= 256;
                    this.f33158j = j2;
                    return this;
                }
                return (C1720a) invokeJ.objValue;
            }

            public C1720a d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                    if (str != null) {
                        this.a |= 8;
                        this.f33153e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1720a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public n build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    n buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (n) invokeV.objValue;
            }

            public C1720a e(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                    if (str != null) {
                        this.a |= 128;
                        this.f33157i = str;
                        return this;
                    }
                    throw null;
                }
                return (C1720a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    n nVar = new n(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    nVar.f33142d = this.f33150b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    nVar.f33143e = this.f33151c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    nVar.f33144f = this.f33152d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    nVar.f33145g = this.f33153e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    nVar.f33146h = this.f33154f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    nVar.f33147i = this.f33155g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    nVar.f33148j = this.f33156h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    nVar.f33149k = this.f33157i;
                    if ((i2 & 256) == 256) {
                        i3 |= 256;
                    }
                    nVar.l = this.f33158j;
                    nVar.f33141c = i3;
                    return nVar;
                }
                return (n) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779595, "Lcom/baidu/android/pushservice/h/a/a/a$n;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779595, "Lcom/baidu/android/pushservice/h/a/a/a$n;");
                    return;
                }
            }
            a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.h.a.a.a.n.1
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
                public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new n(codedInputStream, extensionRegistryLite, null) : (n) invokeLL.objValue;
                }
            };
            n nVar = new n();
            f33140b = nVar;
            nVar.x();
        }

        public n() {
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
            this.m = (byte) -1;
            this.n = -1;
        }

        public n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.m = (byte) -1;
            this.n = -1;
            x();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f33141c |= 1;
                                    this.f33142d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f33141c |= 2;
                                    this.f33143e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f33141c |= 4;
                                    this.f33144f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f33141c |= 8;
                                    this.f33145g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f33141c |= 16;
                                    this.f33146h = codedInputStream.readInt64();
                                } else if (readTag == 48) {
                                    this.f33141c |= 32;
                                    this.f33147i = codedInputStream.readInt64();
                                } else if (readTag == 56) {
                                    this.f33141c |= 64;
                                    this.f33148j = codedInputStream.readInt64();
                                } else if (readTag == 66) {
                                    this.f33141c |= 128;
                                    this.f33149k = codedInputStream.readBytes();
                                } else if (readTag == 72) {
                                    this.f33141c |= 256;
                                    this.l = codedInputStream.readInt64();
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

        public /* synthetic */ n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(GeneratedMessageLite.Builder builder) {
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
            this.m = (byte) -1;
            this.n = -1;
        }

        public /* synthetic */ n(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1720a a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nVar)) == null) ? u().mergeFrom(nVar) : (C1720a) invokeL.objValue;
        }

        public static n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f33140b : (n) invokeV.objValue;
        }

        public static C1720a u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? C1720a.h() : (C1720a) invokeV.objValue;
        }

        private void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65560, this) == null) {
                this.f33142d = "";
                this.f33143e = "";
                this.f33144f = "";
                this.f33145g = "";
                this.f33146h = 0L;
                this.f33147i = 0L;
                this.f33148j = 0L;
                this.f33149k = "";
                this.l = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33140b : (n) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33141c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33142d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33142d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33141c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33143e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33143e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33141c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.n;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33141c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33141c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33141c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f33141c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f33141c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f33146h);
                }
                if ((this.f33141c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f33147i);
                }
                if ((this.f33141c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f33148j);
                }
                if ((this.f33141c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
                }
                if ((this.f33141c & 256) == 256) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
                }
                this.n = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33144f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33144f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33141c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.m;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.m = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f33145g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33145g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33141c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33146h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33141c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33147i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33141c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33148j : invokeV.longValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f33141c & 128) == 128 : invokeV.booleanValue;
        }

        public ByteString r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                Object obj = this.f33149k;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33149k = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.f33141c & 256) == 256 : invokeV.booleanValue;
        }

        public long t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C1720a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? a(this) : (C1720a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C1720a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? u() : (C1720a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33141c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33141c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33141c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f33141c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f33141c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f33146h);
                }
                if ((this.f33141c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f33147i);
                }
                if ((this.f33141c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f33148j);
                }
                if ((this.f33141c & 128) == 128) {
                    codedOutputStream.writeBytes(8, r());
                }
                if ((this.f33141c & 256) == 256) {
                    codedOutputStream.writeInt64(9, this.l);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class p extends GeneratedMessageLite implements q {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<p> a;

        /* renamed from: b  reason: collision with root package name */
        public static final p f33159b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33160c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33161d;

        /* renamed from: e  reason: collision with root package name */
        public byte f33162e;

        /* renamed from: f  reason: collision with root package name */
        public int f33163f;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1721a extends GeneratedMessageLite.Builder<p, C1721a> implements q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33164b;

            public C1721a() {
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
                this.f33164b = "";
                h();
            }

            private void h() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1721a i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1721a() : (C1721a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1721a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33164b = "";
                    this.a &= -2;
                    return this;
                }
                return (C1721a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1721a mergeFrom(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar)) == null) {
                    if (pVar != p.a() && pVar.c()) {
                        this.a |= 1;
                        this.f33164b = pVar.f33161d;
                    }
                    return this;
                }
                return (C1721a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1721a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    p pVar = null;
                    try {
                        try {
                            p parsePartialFrom = p.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            p pVar2 = (p) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                pVar = pVar2;
                                if (pVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (pVar != null) {
                            mergeFrom(pVar);
                        }
                        throw th;
                    }
                }
                return (C1721a) invokeLL.objValue;
            }

            public C1721a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33164b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1721a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1721a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i().mergeFrom(buildPartial()) : (C1721a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public p getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? p.a() : (p) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public p build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    p buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (p) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public p buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    p pVar = new p(this, (AnonymousClass1) null);
                    int i2 = (this.a & 1) != 1 ? 0 : 1;
                    pVar.f33161d = this.f33164b;
                    pVar.f33160c = i2;
                    return pVar;
                }
                return (p) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.a & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? f() : invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779533, "Lcom/baidu/android/pushservice/h/a/a/a$p;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779533, "Lcom/baidu/android/pushservice/h/a/a/a$p;");
                    return;
                }
            }
            a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.h.a.a.a.p.1
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
                public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new p(codedInputStream, extensionRegistryLite, null) : (p) invokeLL.objValue;
                }
            };
            p pVar = new p();
            f33159b = pVar;
            pVar.h();
        }

        public p() {
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
            this.f33162e = (byte) -1;
            this.f33163f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33162e = (byte) -1;
            this.f33163f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 34) {
                                    this.f33160c |= 1;
                                    this.f33161d = codedInputStream.readBytes();
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

        public /* synthetic */ p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(GeneratedMessageLite.Builder builder) {
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
            this.f33162e = (byte) -1;
            this.f33163f = -1;
        }

        public /* synthetic */ p(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1721a a(p pVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pVar)) == null) ? e().mergeFrom(pVar) : (C1721a) invokeL.objValue;
        }

        public static p a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f33159b : (p) invokeV.objValue;
        }

        public static C1721a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1721a.i() : (C1721a) invokeV.objValue;
        }

        private void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.f33161d = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33159b : (p) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33160c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33161d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33161d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C1721a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e() : (C1721a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C1721a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this) : (C1721a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f33163f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33160c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
                this.f33163f = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                byte b2 = this.f33162e;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (c()) {
                    this.f33162e = (byte) 1;
                    return true;
                } else {
                    this.f33162e = (byte) 0;
                    return false;
                }
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
                if ((this.f33160c & 1) == 1) {
                    codedOutputStream.writeBytes(4, d());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class r extends GeneratedMessageLite implements s {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<r> a;

        /* renamed from: b  reason: collision with root package name */
        public static final r f33165b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33166c;

        /* renamed from: d  reason: collision with root package name */
        public int f33167d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33168e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33169f;

        /* renamed from: g  reason: collision with root package name */
        public byte f33170g;

        /* renamed from: h  reason: collision with root package name */
        public int f33171h;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1722a extends GeneratedMessageLite.Builder<r, C1722a> implements s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f33172b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33173c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33174d;

            public C1722a() {
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
                this.f33172b = 7399;
                this.f33173c = "push_im_client";
                this.f33174d = "phonebaidu";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1722a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1722a() : (C1722a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1722a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33172b = 7399;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33173c = "push_im_client";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33174d = "phonebaidu";
                    this.a = i3 & (-5);
                    return this;
                }
                return (C1722a) invokeV.objValue;
            }

            public C1722a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.a |= 1;
                    this.f33172b = i2;
                    return this;
                }
                return (C1722a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1722a mergeFrom(r rVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rVar)) == null) {
                    if (rVar == r.a()) {
                        return this;
                    }
                    if (rVar.c()) {
                        a(rVar.d());
                    }
                    if (rVar.e()) {
                        this.a |= 2;
                        this.f33173c = rVar.f33168e;
                    }
                    if (rVar.g()) {
                        this.a |= 4;
                        this.f33174d = rVar.f33169f;
                    }
                    return this;
                }
                return (C1722a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1722a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    r rVar = null;
                    try {
                        try {
                            r parsePartialFrom = r.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            r rVar2 = (r) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                rVar = rVar2;
                                if (rVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (rVar != null) {
                            mergeFrom(rVar);
                        }
                        throw th;
                    }
                }
                return (C1722a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1722a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1722a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public r getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r.a() : (r) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public r build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    r buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (r) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public r buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    r rVar = new r(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    rVar.f33167d = this.f33172b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    rVar.f33168e = this.f33173c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    rVar.f33169f = this.f33174d;
                    rVar.f33166c = i3;
                    return rVar;
                }
                return (r) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779471, "Lcom/baidu/android/pushservice/h/a/a/a$r;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779471, "Lcom/baidu/android/pushservice/h/a/a/a$r;");
                    return;
                }
            }
            a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.h.a.a.a.r.1
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
                public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new r(codedInputStream, extensionRegistryLite, null) : (r) invokeLL.objValue;
                }
            };
            r rVar = new r();
            f33165b = rVar;
            rVar.l();
        }

        public r() {
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
            this.f33170g = (byte) -1;
            this.f33171h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33170g = (byte) -1;
            this.f33171h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f33166c |= 1;
                                this.f33167d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f33166c |= 2;
                                this.f33168e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f33166c |= 4;
                                this.f33169f = codedInputStream.readBytes();
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

        public /* synthetic */ r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(GeneratedMessageLite.Builder builder) {
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
            this.f33170g = (byte) -1;
            this.f33171h = -1;
        }

        public /* synthetic */ r(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1722a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, rVar)) == null) ? i().mergeFrom(rVar) : (C1722a) invokeL.objValue;
        }

        public static r a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f33165b : (r) invokeV.objValue;
        }

        public static C1722a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1722a.h() : (C1722a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f33167d = 7399;
                this.f33168e = "push_im_client";
                this.f33169f = "phonebaidu";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33165b : (r) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33166c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33167d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33166c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33168e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33168e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33166c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f33171h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f33166c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f33167d) : 0;
                if ((this.f33166c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33166c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f33171h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33169f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33169f = copyFromUtf8;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.f33170g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33170g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1722a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1722a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1722a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1722a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33166c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f33167d);
                }
                if ((this.f33166c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33166c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class t extends GeneratedMessageLite implements u {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<t> a;

        /* renamed from: b  reason: collision with root package name */
        public static final t f33175b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33176c;

        /* renamed from: d  reason: collision with root package name */
        public long f33177d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33178e;

        /* renamed from: f  reason: collision with root package name */
        public long f33179f;

        /* renamed from: g  reason: collision with root package name */
        public long f33180g;

        /* renamed from: h  reason: collision with root package name */
        public Object f33181h;

        /* renamed from: i  reason: collision with root package name */
        public long f33182i;

        /* renamed from: j  reason: collision with root package name */
        public long f33183j;

        /* renamed from: k  reason: collision with root package name */
        public byte f33184k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1723a extends GeneratedMessageLite.Builder<t, C1723a> implements u {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public long f33185b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33186c;

            /* renamed from: d  reason: collision with root package name */
            public long f33187d;

            /* renamed from: e  reason: collision with root package name */
            public long f33188e;

            /* renamed from: f  reason: collision with root package name */
            public Object f33189f;

            /* renamed from: g  reason: collision with root package name */
            public long f33190g;

            /* renamed from: h  reason: collision with root package name */
            public long f33191h;

            public C1723a() {
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
                this.f33186c = "";
                this.f33189f = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1723a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1723a() : (C1723a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1723a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33185b = 0L;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33186c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f33187d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f33188e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f33189f = "";
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f33190g = 0L;
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f33191h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1723a) invokeV.objValue;
            }

            public C1723a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 1;
                    this.f33185b = j2;
                    return this;
                }
                return (C1723a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1723a mergeFrom(t tVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar)) == null) {
                    if (tVar == t.a()) {
                        return this;
                    }
                    if (tVar.c()) {
                        a(tVar.d());
                    }
                    if (tVar.e()) {
                        this.a |= 2;
                        this.f33186c = tVar.f33178e;
                    }
                    if (tVar.g()) {
                        b(tVar.h());
                    }
                    if (tVar.i()) {
                        c(tVar.j());
                    }
                    if (tVar.k()) {
                        this.a |= 16;
                        this.f33189f = tVar.f33181h;
                    }
                    if (tVar.m()) {
                        d(tVar.n());
                    }
                    if (tVar.o()) {
                        e(tVar.p());
                    }
                    return this;
                }
                return (C1723a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1723a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    t tVar = null;
                    try {
                        try {
                            t parsePartialFrom = t.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            t tVar2 = (t) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                tVar = tVar2;
                                if (tVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (tVar != null) {
                            mergeFrom(tVar);
                        }
                        throw th;
                    }
                }
                return (C1723a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1723a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1723a) invokeV.objValue;
            }

            public C1723a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.a |= 4;
                    this.f33187d = j2;
                    return this;
                }
                return (C1723a) invokeJ.objValue;
            }

            public C1723a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.a |= 8;
                    this.f33188e = j2;
                    return this;
                }
                return (C1723a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? t.a() : (t) invokeV.objValue;
            }

            public C1723a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.a |= 32;
                    this.f33190g = j2;
                    return this;
                }
                return (C1723a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public t build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    t buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (t) invokeV.objValue;
            }

            public C1723a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.a |= 64;
                    this.f33191h = j2;
                    return this;
                }
                return (C1723a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    t tVar = new t(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    tVar.f33177d = this.f33185b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    tVar.f33178e = this.f33186c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    tVar.f33179f = this.f33187d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    tVar.f33180g = this.f33188e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    tVar.f33181h = this.f33189f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    tVar.f33182i = this.f33190g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    tVar.f33183j = this.f33191h;
                    tVar.f33176c = i3;
                    return tVar;
                }
                return (t) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779409, "Lcom/baidu/android/pushservice/h/a/a/a$t;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779409, "Lcom/baidu/android/pushservice/h/a/a/a$t;");
                    return;
                }
            }
            a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.h.a.a.a.t.1
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
                public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new t(codedInputStream, extensionRegistryLite, null) : (t) invokeLL.objValue;
                }
            };
            t tVar = new t();
            f33175b = tVar;
            tVar.t();
        }

        public t() {
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
            this.f33184k = (byte) -1;
            this.l = -1;
        }

        public t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33184k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f33176c |= 1;
                                this.f33177d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f33176c |= 2;
                                this.f33178e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f33176c |= 4;
                                this.f33179f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f33176c |= 8;
                                this.f33180g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f33176c |= 16;
                                this.f33181h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f33176c |= 32;
                                this.f33182i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f33176c |= 64;
                                this.f33183j = codedInputStream.readInt64();
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

        public /* synthetic */ t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(GeneratedMessageLite.Builder builder) {
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
            this.f33184k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ t(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1723a a(t tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tVar)) == null) ? q().mergeFrom(tVar) : (C1723a) invokeL.objValue;
        }

        public static t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f33175b : (t) invokeV.objValue;
        }

        public static C1723a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1723a.h() : (C1723a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f33177d = 0L;
                this.f33178e = "";
                this.f33179f = 0L;
                this.f33180g = 0L;
                this.f33181h = "";
                this.f33182i = 0L;
                this.f33183j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33175b : (t) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33176c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33177d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33176c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33178e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33178e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33176c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.l;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt64Size = (this.f33176c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f33177d) : 0;
                if ((this.f33176c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f33176c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f33179f);
                }
                if ((this.f33176c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f33180g);
                }
                if ((this.f33176c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f33176c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f33182i);
                }
                if ((this.f33176c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f33183j);
                }
                this.l = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33179f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33176c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33184k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33184k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33180g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f33176c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f33181h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33181h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f33176c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33182i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f33176c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33183j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1723a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1723a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1723a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1723a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33176c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f33177d);
                }
                if ((this.f33176c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f33176c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f33179f);
                }
                if ((this.f33176c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f33180g);
                }
                if ((this.f33176c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f33176c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f33182i);
                }
                if ((this.f33176c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f33183j);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes9.dex */
    public static final class v extends GeneratedMessageLite implements w {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<v> a;

        /* renamed from: b  reason: collision with root package name */
        public static final v f33192b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33193c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33194d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33195e;

        /* renamed from: f  reason: collision with root package name */
        public byte f33196f;

        /* renamed from: g  reason: collision with root package name */
        public int f33197g;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1724a extends GeneratedMessageLite.Builder<v, C1724a> implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f33198b;

            /* renamed from: c  reason: collision with root package name */
            public Object f33199c;

            public C1724a() {
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
                this.f33198b = "";
                this.f33199c = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1724a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1724a() : (C1724a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1724a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33198b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f33199c = "";
                    this.a = i2 & (-3);
                    return this;
                }
                return (C1724a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1724a mergeFrom(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar)) == null) {
                    if (vVar == v.a()) {
                        return this;
                    }
                    if (vVar.c()) {
                        this.a |= 1;
                        this.f33198b = vVar.f33194d;
                    }
                    if (vVar.e()) {
                        this.a |= 2;
                        this.f33199c = vVar.f33195e;
                    }
                    return this;
                }
                return (C1724a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1724a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    v vVar = null;
                    try {
                        try {
                            v parsePartialFrom = v.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            v vVar2 = (v) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                vVar = vVar2;
                                if (vVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (vVar != null) {
                            mergeFrom(vVar);
                        }
                        throw th;
                    }
                }
                return (C1724a) invokeLL.objValue;
            }

            public C1724a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f33198b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1724a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1724a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1724a) invokeV.objValue;
            }

            public C1724a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f33199c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1724a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public v getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? v.a() : (v) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public v build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    v buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (v) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public v buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    v vVar = new v(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    vVar.f33194d = this.f33198b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    vVar.f33195e = this.f33199c;
                    vVar.f33193c = i3;
                    return vVar;
                }
                return (v) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779347, "Lcom/baidu/android/pushservice/h/a/a/a$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779347, "Lcom/baidu/android/pushservice/h/a/a/a$v;");
                    return;
                }
            }
            a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.h.a.a.a.v.1
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
                public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new v(codedInputStream, extensionRegistryLite, null) : (v) invokeLL.objValue;
                }
            };
            v vVar = new v();
            f33192b = vVar;
            vVar.j();
        }

        public v() {
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
            this.f33196f = (byte) -1;
            this.f33197g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f33196f = (byte) -1;
            this.f33197g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f33193c |= 1;
                                    this.f33194d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f33193c |= 2;
                                    this.f33195e = codedInputStream.readBytes();
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

        public /* synthetic */ v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(GeneratedMessageLite.Builder builder) {
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
            this.f33196f = (byte) -1;
            this.f33197g = -1;
        }

        public /* synthetic */ v(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1724a a(v vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, vVar)) == null) ? g().mergeFrom(vVar) : (C1724a) invokeL.objValue;
        }

        public static v a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f33192b : (v) invokeV.objValue;
        }

        public static C1724a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? C1724a.h() : (C1724a) invokeV.objValue;
        }

        private void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.f33194d = "";
                this.f33195e = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33192b : (v) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33193c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f33194d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33194d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33193c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f33195e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33195e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f33197g;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f33193c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f33193c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                this.f33197g = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C1724a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g() : (C1724a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C1724a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? a(this) : (C1724a) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.f33196f;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f33196f = (byte) 1;
                return true;
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
                if ((this.f33193c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f33193c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class x implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;
        public static final x a;

        /* renamed from: b  reason: collision with root package name */
        public static final x f33200b;

        /* renamed from: c  reason: collision with root package name */
        public static final x f33201c;

        /* renamed from: d  reason: collision with root package name */
        public static final x f33202d;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ x[] f33203f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f33204e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779285, "Lcom/baidu/android/pushservice/h/a/a/a$x;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779285, "Lcom/baidu/android/pushservice/h/a/a/a$x;");
                    return;
                }
            }
            a = new x("OS_TYPE_UNKNWON", 0, 0);
            f33200b = new x("IOS", 1, 1);
            f33201c = new x("ANDROID", 2, 2);
            x xVar = new x("WINDOWSPHONE", 3, 3);
            f33202d = xVar;
            f33203f = new x[]{a, f33200b, f33201c, xVar};
        }

        public x(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33204e = i3;
        }

        public static x a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                return null;
                            }
                            return f33202d;
                        }
                        return f33201c;
                    }
                    return f33200b;
                }
                return a;
            }
            return (x) invokeI.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33204e : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class y extends GeneratedMessageLite implements z {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<y> a;

        /* renamed from: b  reason: collision with root package name */
        public static final y f33205b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f33206c;

        /* renamed from: d  reason: collision with root package name */
        public r f33207d;

        /* renamed from: e  reason: collision with root package name */
        public h f33208e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33209f;

        /* renamed from: g  reason: collision with root package name */
        public long f33210g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f33211h;

        /* renamed from: i  reason: collision with root package name */
        public byte f33212i;

        /* renamed from: j  reason: collision with root package name */
        public int f33213j;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1725a extends GeneratedMessageLite.Builder<y, C1725a> implements z {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public r f33214b;

            /* renamed from: c  reason: collision with root package name */
            public h f33215c;

            /* renamed from: d  reason: collision with root package name */
            public Object f33216d;

            /* renamed from: e  reason: collision with root package name */
            public long f33217e;

            /* renamed from: f  reason: collision with root package name */
            public List<c> f33218f;

            public C1725a() {
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
                this.f33214b = r.a();
                this.f33215c = h.a();
                this.f33216d = "";
                this.f33218f = Collections.emptyList();
                i();
            }

            private void i() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1725a j() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1725a() : (C1725a) invokeV.objValue;
            }

            private void k() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (this.a & 16) == 16) {
                    return;
                }
                this.f33218f = new ArrayList(this.f33218f);
                this.a |= 16;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1725a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f33214b = r.a();
                    this.a &= -2;
                    this.f33215c = h.a();
                    int i2 = this.a & (-3);
                    this.a = i2;
                    this.f33216d = "";
                    int i3 = i2 & (-5);
                    this.a = i3;
                    this.f33217e = 0L;
                    this.a = i3 & (-9);
                    this.f33218f = Collections.emptyList();
                    this.a &= -17;
                    return this;
                }
                return (C1725a) invokeV.objValue;
            }

            public C1725a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 8;
                    this.f33217e = j2;
                    return this;
                }
                return (C1725a) invokeJ.objValue;
            }

            public C1725a a(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
                    if (hVar != null) {
                        this.f33215c = hVar;
                        this.a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1725a) invokeL.objValue;
            }

            public C1725a a(r rVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rVar)) == null) {
                    if ((this.a & 1) == 1 && this.f33214b != r.a()) {
                        rVar = r.a(this.f33214b).mergeFrom(rVar).buildPartial();
                    }
                    this.f33214b = rVar;
                    this.a |= 1;
                    return this;
                }
                return (C1725a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1725a mergeFrom(y yVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yVar)) == null) {
                    if (yVar == y.a()) {
                        return this;
                    }
                    if (yVar.c()) {
                        a(yVar.d());
                    }
                    if (yVar.e()) {
                        b(yVar.f());
                    }
                    if (yVar.g()) {
                        this.a |= 4;
                        this.f33216d = yVar.f33209f;
                    }
                    if (yVar.i()) {
                        a(yVar.j());
                    }
                    if (!yVar.f33211h.isEmpty()) {
                        if (this.f33218f.isEmpty()) {
                            this.f33218f = yVar.f33211h;
                            this.a &= -17;
                        } else {
                            k();
                            this.f33218f.addAll(yVar.f33211h);
                        }
                    }
                    return this;
                }
                return (C1725a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1725a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, codedInputStream, extensionRegistryLite)) == null) {
                    y yVar = null;
                    try {
                        try {
                            y parsePartialFrom = y.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            y yVar2 = (y) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                yVar = yVar2;
                                if (yVar != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (yVar != null) {
                            mergeFrom(yVar);
                        }
                        throw th;
                    }
                }
                return (C1725a) invokeLL.objValue;
            }

            public C1725a a(Iterable<? extends c> iterable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iterable)) == null) {
                    k();
                    AbstractMessageLite.Builder.addAll(iterable, this.f33218f);
                    return this;
                }
                return (C1725a) invokeL.objValue;
            }

            public C1725a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f33216d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1725a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1725a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? j().mergeFrom(buildPartial()) : (C1725a) invokeV.objValue;
            }

            public C1725a b(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hVar)) == null) {
                    if ((this.a & 2) == 2 && this.f33215c != h.a()) {
                        hVar = h.a(this.f33215c).mergeFrom(hVar).buildPartial();
                    }
                    this.f33215c = hVar;
                    this.a |= 2;
                    return this;
                }
                return (C1725a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public y getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? y.a() : (y) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public y build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    y buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (y) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public y buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    y yVar = new y(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    yVar.f33207d = this.f33214b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    yVar.f33208e = this.f33215c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    yVar.f33209f = this.f33216d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    yVar.f33210g = this.f33217e;
                    if ((this.a & 16) == 16) {
                        this.f33218f = Collections.unmodifiableList(this.f33218f);
                        this.a &= -17;
                    }
                    yVar.f33211h = this.f33218f;
                    yVar.f33206c = i3;
                    return yVar;
                }
                return (y) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.a & 2) == 2 : invokeV.booleanValue;
            }

            public h g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f33215c : (h) invokeV.objValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    if (f()) {
                        return g().isInitialized();
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1070779254, "Lcom/baidu/android/pushservice/h/a/a/a$y;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1070779254, "Lcom/baidu/android/pushservice/h/a/a/a$y;");
                    return;
                }
            }
            a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.h.a.a.a.y.1
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
                public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new y(codedInputStream, extensionRegistryLite, null) : (y) invokeLL.objValue;
                }
            };
            y yVar = new y();
            f33205b = yVar;
            yVar.n();
        }

        public y() {
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
            this.f33212i = (byte) -1;
            this.f33213j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v15, resolved type: java.util.List<com.baidu.android.pushservice.h.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f33212i = (byte) -1;
            this.f33213j = -1;
            n();
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
                            int i5 = 1;
                            if (readTag != 0) {
                                if (readTag == 202) {
                                    r.C1722a builder = (this.f33206c & 1) == 1 ? this.f33207d.toBuilder() : null;
                                    r rVar = (r) codedInputStream.readMessage(r.a, extensionRegistryLite);
                                    this.f33207d = rVar;
                                    if (builder != null) {
                                        builder.mergeFrom(rVar);
                                        this.f33207d = builder.buildPartial();
                                    }
                                    i2 = this.f33206c;
                                } else if (readTag == 330) {
                                    i5 = 2;
                                    h.C1717a builder2 = (this.f33206c & 2) == 2 ? this.f33208e.toBuilder() : null;
                                    h hVar = (h) codedInputStream.readMessage(h.a, extensionRegistryLite);
                                    this.f33208e = hVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(hVar);
                                        this.f33208e = builder2.buildPartial();
                                    }
                                    i2 = this.f33206c;
                                } else if (readTag == 1042) {
                                    this.f33206c |= 4;
                                    this.f33209f = codedInputStream.readBytes();
                                } else if (readTag == 1048) {
                                    this.f33206c |= 8;
                                    this.f33210g = codedInputStream.readInt64();
                                } else if (readTag == 1058) {
                                    if (!(z2 & true)) {
                                        this.f33211h = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.f33211h.add(codedInputStream.readMessage(c.a, extensionRegistryLite));
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f33206c = i2 | i5;
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
                        this.f33211h = Collections.unmodifiableList(this.f33211h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public /* synthetic */ y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(GeneratedMessageLite.Builder builder) {
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
            this.f33212i = (byte) -1;
            this.f33213j = -1;
        }

        public /* synthetic */ y(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1725a a(y yVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, yVar)) == null) ? k().mergeFrom(yVar) : (C1725a) invokeL.objValue;
        }

        public static y a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f33205b : (y) invokeV.objValue;
        }

        public static C1725a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? C1725a.j() : (C1725a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.f33207d = r.a();
                this.f33208e = h.a();
                this.f33209f = "";
                this.f33210g = 0L;
                this.f33211h = Collections.emptyList();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f33205b : (y) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f33206c & 1) == 1 : invokeV.booleanValue;
        }

        public r d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33207d : (r) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f33206c & 2) == 2 : invokeV.booleanValue;
        }

        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33208e : (h) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f33206c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f33213j;
                if (i2 != -1) {
                    return i2;
                }
                int computeMessageSize = (this.f33206c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f33207d) + 0 : 0;
                if ((this.f33206c & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f33208e);
                }
                if ((this.f33206c & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(130, h());
                }
                if ((this.f33206c & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f33210g);
                }
                for (int i3 = 0; i3 < this.f33211h.size(); i3++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f33211h.get(i3));
                }
                this.f33213j = computeMessageSize;
                return computeMessageSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f33209f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f33209f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f33206c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f33212i;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (!e()) {
                    this.f33212i = (byte) 0;
                    return false;
                } else if (f().isInitialized()) {
                    this.f33212i = (byte) 1;
                    return true;
                } else {
                    this.f33212i = (byte) 0;
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33210g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1725a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? k() : (C1725a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1725a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(this) : (C1725a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.f33206c & 1) == 1) {
                    codedOutputStream.writeMessage(25, this.f33207d);
                }
                if ((this.f33206c & 2) == 2) {
                    codedOutputStream.writeMessage(41, this.f33208e);
                }
                if ((this.f33206c & 4) == 4) {
                    codedOutputStream.writeBytes(130, h());
                }
                if ((this.f33206c & 8) == 8) {
                    codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f33210g);
                }
                for (int i2 = 0; i2 < this.f33211h.size(); i2++) {
                    codedOutputStream.writeMessage(132, this.f33211h.get(i2));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
