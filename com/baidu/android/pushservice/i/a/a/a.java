package com.baidu.android.pushservice.i.a.a;

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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1587a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C1587a> f37305a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1587a f37306b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37307c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37308d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37309e;

        /* renamed from: f  reason: collision with root package name */
        public long f37310f;

        /* renamed from: g  reason: collision with root package name */
        public Object f37311g;

        /* renamed from: h  reason: collision with root package name */
        public long f37312h;

        /* renamed from: i  reason: collision with root package name */
        public byte f37313i;

        /* renamed from: j  reason: collision with root package name */
        public int f37314j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1588a extends GeneratedMessageLite.Builder<C1587a, C1588a> implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37315a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37316b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37317c;

            /* renamed from: d  reason: collision with root package name */
            public long f37318d;

            /* renamed from: e  reason: collision with root package name */
            public Object f37319e;

            /* renamed from: f  reason: collision with root package name */
            public long f37320f;

            public C1588a() {
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
                this.f37316b = "";
                this.f37317c = "";
                this.f37319e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1588a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1588a() : (C1588a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1588a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37316b = "";
                    int i2 = this.f37315a & (-2);
                    this.f37315a = i2;
                    this.f37317c = "";
                    int i3 = i2 & (-3);
                    this.f37315a = i3;
                    this.f37318d = 0L;
                    int i4 = i3 & (-5);
                    this.f37315a = i4;
                    this.f37319e = "";
                    int i5 = i4 & (-9);
                    this.f37315a = i5;
                    this.f37320f = 0L;
                    this.f37315a = i5 & (-17);
                    return this;
                }
                return (C1588a) invokeV.objValue;
            }

            public C1588a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37315a |= 4;
                    this.f37318d = j2;
                    return this;
                }
                return (C1588a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1588a mergeFrom(C1587a c1587a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1587a)) == null) {
                    if (c1587a == C1587a.a()) {
                        return this;
                    }
                    if (c1587a.c()) {
                        this.f37315a |= 1;
                        this.f37316b = c1587a.f37308d;
                    }
                    if (c1587a.e()) {
                        this.f37315a |= 2;
                        this.f37317c = c1587a.f37309e;
                    }
                    if (c1587a.g()) {
                        a(c1587a.h());
                    }
                    if (c1587a.i()) {
                        this.f37315a |= 8;
                        this.f37319e = c1587a.f37311g;
                    }
                    if (c1587a.k()) {
                        b(c1587a.l());
                    }
                    return this;
                }
                return (C1588a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1588a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    C1587a c1587a = null;
                    try {
                        try {
                            C1587a parsePartialFrom = C1587a.f37305a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C1587a c1587a2 = (C1587a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c1587a = c1587a2;
                                if (c1587a != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1587a != null) {
                            mergeFrom(c1587a);
                        }
                        throw th;
                    }
                }
                return (C1588a) invokeLL.objValue;
            }

            public C1588a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37315a |= 1;
                        this.f37316b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1588a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1588a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1588a) invokeV.objValue;
            }

            public C1588a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37315a |= 16;
                    this.f37320f = j2;
                    return this;
                }
                return (C1588a) invokeJ.objValue;
            }

            public C1588a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37315a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1588a) invokeL.objValue;
            }

            public C1588a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                    if (str != null) {
                        this.f37315a |= 8;
                        this.f37319e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1588a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C1587a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? C1587a.a() : (C1587a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C1587a build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    C1587a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (C1587a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C1587a buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    C1587a c1587a = new C1587a(this, (AnonymousClass1) null);
                    int i2 = this.f37315a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1587a.f37308d = this.f37316b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1587a.f37309e = this.f37317c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1587a.f37310f = this.f37318d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1587a.f37311g = this.f37319e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1587a.f37312h = this.f37320f;
                    c1587a.f37307c = i3;
                    return c1587a;
                }
                return (C1587a) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293503, "Lcom/baidu/android/pushservice/i/a/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293503, "Lcom/baidu/android/pushservice/i/a/a/a$a;");
                    return;
                }
            }
            f37305a = new AbstractParser<C1587a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
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
                public C1587a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1587a(codedInputStream, extensionRegistryLite, null) : (C1587a) invokeLL.objValue;
                }
            };
            C1587a c1587a = new C1587a();
            f37306b = c1587a;
            c1587a.p();
        }

        public C1587a() {
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
            this.f37313i = (byte) -1;
            this.f37314j = -1;
        }

        public C1587a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f37313i = (byte) -1;
            this.f37314j = -1;
            p();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f37307c |= 1;
                                this.f37308d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f37307c |= 2;
                                this.f37309e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f37307c |= 4;
                                this.f37310f = codedInputStream.readInt64();
                            } else if (readTag == 34) {
                                this.f37307c |= 8;
                                this.f37311g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f37307c |= 16;
                                this.f37312h = codedInputStream.readInt64();
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

        public /* synthetic */ C1587a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1587a(GeneratedMessageLite.Builder builder) {
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
            this.f37313i = (byte) -1;
            this.f37314j = -1;
        }

        public /* synthetic */ C1587a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1588a a(C1587a c1587a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c1587a)) == null) ? m().mergeFrom(c1587a) : (C1588a) invokeL.objValue;
        }

        public static C1587a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37306b : (C1587a) invokeV.objValue;
        }

        public static C1588a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1588a.h() : (C1588a) invokeV.objValue;
        }

        private void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f37308d = "";
                this.f37309e = "";
                this.f37310f = 0L;
                this.f37311g = "";
                this.f37312h = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1587a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37306b : (C1587a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37307c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37308d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37308d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37307c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37309e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37309e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37307c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C1587a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37305a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37314j;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37307c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37307c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37307c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f37310f);
                }
                if ((this.f37307c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f37307c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37312h);
                }
                this.f37314j = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37310f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37307c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37313i;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37313i = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f37311g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37311g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37307c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37312h : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C1588a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? a(this) : (C1588a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C1588a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? m() : (C1588a) invokeV.objValue;
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
                if ((this.f37307c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37307c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37307c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37310f);
                }
                if ((this.f37307c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f37307c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37312h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class aa extends GeneratedMessageLite implements ab {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f37321a;

        /* renamed from: b  reason: collision with root package name */
        public static final aa f37322b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37323c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37324d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37325e;

        /* renamed from: f  reason: collision with root package name */
        public long f37326f;

        /* renamed from: g  reason: collision with root package name */
        public long f37327g;

        /* renamed from: h  reason: collision with root package name */
        public long f37328h;

        /* renamed from: i  reason: collision with root package name */
        public Object f37329i;

        /* renamed from: j  reason: collision with root package name */
        public long f37330j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1589a extends GeneratedMessageLite.Builder<aa, C1589a> implements ab {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37331a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37332b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37333c;

            /* renamed from: d  reason: collision with root package name */
            public long f37334d;

            /* renamed from: e  reason: collision with root package name */
            public long f37335e;

            /* renamed from: f  reason: collision with root package name */
            public long f37336f;

            /* renamed from: g  reason: collision with root package name */
            public Object f37337g;

            /* renamed from: h  reason: collision with root package name */
            public long f37338h;

            public C1589a() {
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
                this.f37332b = "";
                this.f37333c = "";
                this.f37337g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1589a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1589a() : (C1589a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1589a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37332b = "";
                    int i2 = this.f37331a & (-2);
                    this.f37331a = i2;
                    this.f37333c = "";
                    int i3 = i2 & (-3);
                    this.f37331a = i3;
                    this.f37334d = 0L;
                    int i4 = i3 & (-5);
                    this.f37331a = i4;
                    this.f37335e = 0L;
                    int i5 = i4 & (-9);
                    this.f37331a = i5;
                    this.f37336f = 0L;
                    int i6 = i5 & (-17);
                    this.f37331a = i6;
                    this.f37337g = "";
                    int i7 = i6 & (-33);
                    this.f37331a = i7;
                    this.f37338h = 0L;
                    this.f37331a = i7 & (-65);
                    return this;
                }
                return (C1589a) invokeV.objValue;
            }

            public C1589a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37331a |= 4;
                    this.f37334d = j2;
                    return this;
                }
                return (C1589a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1589a mergeFrom(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar == aa.a()) {
                        return this;
                    }
                    if (aaVar.c()) {
                        this.f37331a |= 1;
                        this.f37332b = aaVar.f37324d;
                    }
                    if (aaVar.e()) {
                        this.f37331a |= 2;
                        this.f37333c = aaVar.f37325e;
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
                        this.f37331a |= 32;
                        this.f37337g = aaVar.f37329i;
                    }
                    if (aaVar.o()) {
                        d(aaVar.p());
                    }
                    return this;
                }
                return (C1589a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1589a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    aa aaVar = null;
                    try {
                        try {
                            aa parsePartialFrom = aa.f37321a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1589a) invokeLL.objValue;
            }

            public C1589a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37331a |= 1;
                        this.f37332b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1589a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1589a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1589a) invokeV.objValue;
            }

            public C1589a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37331a |= 8;
                    this.f37335e = j2;
                    return this;
                }
                return (C1589a) invokeJ.objValue;
            }

            public C1589a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37331a |= 2;
                        this.f37333c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1589a) invokeL.objValue;
            }

            public C1589a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.f37331a |= 16;
                    this.f37336f = j2;
                    return this;
                }
                return (C1589a) invokeJ.objValue;
            }

            public C1589a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.f37331a |= 32;
                        this.f37337g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1589a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? aa.a() : (aa) invokeV.objValue;
            }

            public C1589a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.f37331a |= 64;
                    this.f37338h = j2;
                    return this;
                }
                return (C1589a) invokeJ.objValue;
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
                    int i2 = this.f37331a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aaVar.f37324d = this.f37332b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aaVar.f37325e = this.f37333c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aaVar.f37326f = this.f37334d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aaVar.f37327g = this.f37335e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aaVar.f37328h = this.f37336f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aaVar.f37329i = this.f37337g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aaVar.f37330j = this.f37338h;
                    aaVar.f37323c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-631391692, "Lcom/baidu/android/pushservice/i/a/a/a$aa;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-631391692, "Lcom/baidu/android/pushservice/i/a/a/a$aa;");
                    return;
                }
            }
            f37321a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
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
            f37322b = aaVar;
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
            this.k = (byte) -1;
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
            this.k = (byte) -1;
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
                                    this.f37323c |= 1;
                                    this.f37324d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37323c |= 2;
                                    this.f37325e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f37323c |= 4;
                                    this.f37326f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f37323c |= 8;
                                    this.f37327g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f37323c |= 16;
                                    this.f37328h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f37323c |= 32;
                                    this.f37329i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f37323c |= 64;
                                    this.f37330j = codedInputStream.readInt64();
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
            this.k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ aa(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1589a a(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aaVar)) == null) ? q().mergeFrom(aaVar) : (C1589a) invokeL.objValue;
        }

        public static aa a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37322b : (aa) invokeV.objValue;
        }

        public static C1589a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1589a.h() : (C1589a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37324d = "";
                this.f37325e = "";
                this.f37326f = 0L;
                this.f37327g = 0L;
                this.f37328h = 0L;
                this.f37329i = "";
                this.f37330j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37322b : (aa) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37323c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37324d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37324d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37323c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37325e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37325e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37323c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37321a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37323c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37323c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37323c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f37326f);
                }
                if ((this.f37323c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f37327g);
                }
                if ((this.f37323c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37328h);
                }
                if ((this.f37323c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f37323c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f37330j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37326f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37323c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37327g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37323c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37328h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37323c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f37329i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37329i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37323c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37330j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1589a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1589a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1589a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1589a) invokeV.objValue;
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
                if ((this.f37323c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37323c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37323c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37326f);
                }
                if ((this.f37323c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37327g);
                }
                if ((this.f37323c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37328h);
                }
                if ((this.f37323c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f37323c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37330j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class ac extends GeneratedMessageLite implements ad {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ac> f37339a;

        /* renamed from: b  reason: collision with root package name */
        public static final ac f37340b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37341c;

        /* renamed from: d  reason: collision with root package name */
        public x f37342d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37343e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37344f;

        /* renamed from: g  reason: collision with root package name */
        public Object f37345g;

        /* renamed from: h  reason: collision with root package name */
        public int f37346h;

        /* renamed from: i  reason: collision with root package name */
        public int f37347i;

        /* renamed from: j  reason: collision with root package name */
        public int f37348j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1590a extends GeneratedMessageLite.Builder<ac, C1590a> implements ad {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37349a;

            /* renamed from: b  reason: collision with root package name */
            public x f37350b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37351c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37352d;

            /* renamed from: e  reason: collision with root package name */
            public Object f37353e;

            /* renamed from: f  reason: collision with root package name */
            public int f37354f;

            /* renamed from: g  reason: collision with root package name */
            public int f37355g;

            /* renamed from: h  reason: collision with root package name */
            public int f37356h;

            public C1590a() {
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
                this.f37350b = x.f37534a;
                this.f37351c = "";
                this.f37352d = "";
                this.f37353e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1590a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1590a() : (C1590a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1590a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37350b = x.f37534a;
                    int i2 = this.f37349a & (-2);
                    this.f37349a = i2;
                    this.f37351c = "";
                    int i3 = i2 & (-3);
                    this.f37349a = i3;
                    this.f37352d = "";
                    int i4 = i3 & (-5);
                    this.f37349a = i4;
                    this.f37353e = "";
                    int i5 = i4 & (-9);
                    this.f37349a = i5;
                    this.f37354f = 0;
                    int i6 = i5 & (-17);
                    this.f37349a = i6;
                    this.f37355g = 0;
                    int i7 = i6 & (-33);
                    this.f37349a = i7;
                    this.f37356h = 0;
                    this.f37349a = i7 & (-65);
                    return this;
                }
                return (C1590a) invokeV.objValue;
            }

            public C1590a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f37349a |= 16;
                    this.f37354f = i2;
                    return this;
                }
                return (C1590a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1590a mergeFrom(ac acVar) {
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
                        this.f37349a |= 2;
                        this.f37351c = acVar.f37343e;
                    }
                    if (acVar.g()) {
                        this.f37349a |= 4;
                        this.f37352d = acVar.f37344f;
                    }
                    if (acVar.i()) {
                        this.f37349a |= 8;
                        this.f37353e = acVar.f37345g;
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
                return (C1590a) invokeL.objValue;
            }

            public C1590a a(x xVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xVar)) == null) {
                    if (xVar != null) {
                        this.f37349a |= 1;
                        this.f37350b = xVar;
                        return this;
                    }
                    throw null;
                }
                return (C1590a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1590a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, codedInputStream, extensionRegistryLite)) == null) {
                    ac acVar = null;
                    try {
                        try {
                            ac parsePartialFrom = ac.f37339a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1590a) invokeLL.objValue;
            }

            public C1590a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.f37349a |= 2;
                        this.f37351c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1590a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1590a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h().mergeFrom(buildPartial()) : (C1590a) invokeV.objValue;
            }

            public C1590a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                    this.f37349a |= 32;
                    this.f37355g = i2;
                    return this;
                }
                return (C1590a) invokeI.objValue;
            }

            public C1590a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.f37349a |= 4;
                        this.f37352d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1590a) invokeL.objValue;
            }

            public C1590a c(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                    this.f37349a |= 64;
                    this.f37356h = i2;
                    return this;
                }
                return (C1590a) invokeI.objValue;
            }

            public C1590a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                    if (str != null) {
                        this.f37349a |= 8;
                        this.f37353e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1590a) invokeL.objValue;
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
                    int i2 = this.f37349a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    acVar.f37342d = this.f37350b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    acVar.f37343e = this.f37351c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    acVar.f37344f = this.f37352d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    acVar.f37345g = this.f37353e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    acVar.f37346h = this.f37354f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    acVar.f37347i = this.f37355g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    acVar.f37348j = this.f37356h;
                    acVar.f37341c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-631391630, "Lcom/baidu/android/pushservice/i/a/a/a$ac;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-631391630, "Lcom/baidu/android/pushservice/i/a/a/a$ac;");
                    return;
                }
            }
            f37339a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
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
            f37340b = acVar;
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
            this.k = (byte) -1;
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
            this.k = (byte) -1;
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
                                    this.f37341c = 1 | this.f37341c;
                                    this.f37342d = a2;
                                }
                            } else if (readTag == 18) {
                                this.f37341c |= 2;
                                this.f37343e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f37341c |= 4;
                                this.f37344f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f37341c |= 8;
                                this.f37345g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f37341c |= 16;
                                this.f37346h = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.f37341c |= 32;
                                this.f37347i = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.f37341c |= 64;
                                this.f37348j = codedInputStream.readInt32();
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
            this.k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ ac(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1590a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, acVar)) == null) ? q().mergeFrom(acVar) : (C1590a) invokeL.objValue;
        }

        public static ac a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37340b : (ac) invokeV.objValue;
        }

        public static C1590a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1590a.h() : (C1590a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37342d = x.f37534a;
                this.f37343e = "";
                this.f37344f = "";
                this.f37345g = "";
                this.f37346h = 0;
                this.f37347i = 0;
                this.f37348j = 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37340b : (ac) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37341c & 1) == 1 : invokeV.booleanValue;
        }

        public x d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37342d : (x) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37341c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37343e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37343e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37341c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37339a : (Parser) invokeV.objValue;
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
                int computeEnumSize = (this.f37341c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f37342d.getNumber()) : 0;
                if ((this.f37341c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37341c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37341c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f37341c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f37346h);
                }
                if ((this.f37341c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f37347i);
                }
                if ((this.f37341c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.f37348j);
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
                Object obj = this.f37344f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37344f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37341c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f37345g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37345g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37341c & 16) == 16 : invokeV.booleanValue;
        }

        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37346h : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37341c & 32) == 32 : invokeV.booleanValue;
        }

        public int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37347i : invokeV.intValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37341c & 64) == 64 : invokeV.booleanValue;
        }

        public int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37348j : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1590a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1590a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1590a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1590a) invokeV.objValue;
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
                if ((this.f37341c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f37342d.getNumber());
                }
                if ((this.f37341c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37341c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37341c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f37341c & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.f37346h);
                }
                if ((this.f37341c & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.f37347i);
                }
                if ((this.f37341c & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.f37348j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class ae extends GeneratedMessageLite implements af {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ae> f37357a;

        /* renamed from: b  reason: collision with root package name */
        public static final ae f37358b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37359c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37360d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37361e;

        /* renamed from: f  reason: collision with root package name */
        public long f37362f;

        /* renamed from: g  reason: collision with root package name */
        public long f37363g;

        /* renamed from: h  reason: collision with root package name */
        public long f37364h;

        /* renamed from: i  reason: collision with root package name */
        public Object f37365i;

        /* renamed from: j  reason: collision with root package name */
        public long f37366j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1591a extends GeneratedMessageLite.Builder<ae, C1591a> implements af {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37367a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37368b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37369c;

            /* renamed from: d  reason: collision with root package name */
            public long f37370d;

            /* renamed from: e  reason: collision with root package name */
            public long f37371e;

            /* renamed from: f  reason: collision with root package name */
            public long f37372f;

            /* renamed from: g  reason: collision with root package name */
            public Object f37373g;

            /* renamed from: h  reason: collision with root package name */
            public long f37374h;

            public C1591a() {
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
                this.f37368b = "";
                this.f37369c = "";
                this.f37373g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1591a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1591a() : (C1591a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1591a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37368b = "";
                    int i2 = this.f37367a & (-2);
                    this.f37367a = i2;
                    this.f37369c = "";
                    int i3 = i2 & (-3);
                    this.f37367a = i3;
                    this.f37370d = 0L;
                    int i4 = i3 & (-5);
                    this.f37367a = i4;
                    this.f37371e = 0L;
                    int i5 = i4 & (-9);
                    this.f37367a = i5;
                    this.f37372f = 0L;
                    int i6 = i5 & (-17);
                    this.f37367a = i6;
                    this.f37373g = "";
                    int i7 = i6 & (-33);
                    this.f37367a = i7;
                    this.f37374h = 0L;
                    this.f37367a = i7 & (-65);
                    return this;
                }
                return (C1591a) invokeV.objValue;
            }

            public C1591a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37367a |= 4;
                    this.f37370d = j2;
                    return this;
                }
                return (C1591a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1591a mergeFrom(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aeVar)) == null) {
                    if (aeVar == ae.a()) {
                        return this;
                    }
                    if (aeVar.c()) {
                        this.f37367a |= 1;
                        this.f37368b = aeVar.f37360d;
                    }
                    if (aeVar.e()) {
                        this.f37367a |= 2;
                        this.f37369c = aeVar.f37361e;
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
                        this.f37367a |= 32;
                        this.f37373g = aeVar.f37365i;
                    }
                    if (aeVar.o()) {
                        d(aeVar.p());
                    }
                    return this;
                }
                return (C1591a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1591a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    ae aeVar = null;
                    try {
                        try {
                            ae parsePartialFrom = ae.f37357a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1591a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1591a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1591a) invokeV.objValue;
            }

            public C1591a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.f37367a |= 8;
                    this.f37371e = j2;
                    return this;
                }
                return (C1591a) invokeJ.objValue;
            }

            public C1591a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.f37367a |= 16;
                    this.f37372f = j2;
                    return this;
                }
                return (C1591a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ae.a() : (ae) invokeV.objValue;
            }

            public C1591a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.f37367a |= 64;
                    this.f37374h = j2;
                    return this;
                }
                return (C1591a) invokeJ.objValue;
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
                    int i2 = this.f37367a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aeVar.f37360d = this.f37368b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aeVar.f37361e = this.f37369c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aeVar.f37362f = this.f37370d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aeVar.f37363g = this.f37371e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aeVar.f37364h = this.f37372f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aeVar.f37365i = this.f37373g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aeVar.f37366j = this.f37374h;
                    aeVar.f37359c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-631391568, "Lcom/baidu/android/pushservice/i/a/a/a$ae;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-631391568, "Lcom/baidu/android/pushservice/i/a/a/a$ae;");
                    return;
                }
            }
            f37357a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
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
            f37358b = aeVar;
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
            this.k = (byte) -1;
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
            this.k = (byte) -1;
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
                                    this.f37359c |= 1;
                                    this.f37360d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37359c |= 2;
                                    this.f37361e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f37359c |= 4;
                                    this.f37362f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f37359c |= 8;
                                    this.f37363g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f37359c |= 16;
                                    this.f37364h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f37359c |= 32;
                                    this.f37365i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f37359c |= 64;
                                    this.f37366j = codedInputStream.readInt64();
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
            this.k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ ae(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1591a a(ae aeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aeVar)) == null) ? q().mergeFrom(aeVar) : (C1591a) invokeL.objValue;
        }

        public static ae a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37358b : (ae) invokeV.objValue;
        }

        public static C1591a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1591a.h() : (C1591a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37360d = "";
                this.f37361e = "";
                this.f37362f = 0L;
                this.f37363g = 0L;
                this.f37364h = 0L;
                this.f37365i = "";
                this.f37366j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37358b : (ae) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37359c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37360d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37360d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37359c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37361e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37361e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37359c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37357a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37359c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37359c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37359c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f37362f);
                }
                if ((this.f37359c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f37363g);
                }
                if ((this.f37359c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37364h);
                }
                if ((this.f37359c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f37359c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f37366j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37362f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37359c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37363g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37359c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37364h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37359c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f37365i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37365i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37359c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37366j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1591a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1591a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1591a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1591a) invokeV.objValue;
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
                if ((this.f37359c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37359c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37359c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37362f);
                }
                if ((this.f37359c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37363g);
                }
                if ((this.f37359c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37364h);
                }
                if ((this.f37359c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f37359c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37366j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class c extends GeneratedMessageLite implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f37375a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37376b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37377c;

        /* renamed from: d  reason: collision with root package name */
        public e f37378d;

        /* renamed from: e  reason: collision with root package name */
        public ae f37379e;

        /* renamed from: f  reason: collision with root package name */
        public l f37380f;

        /* renamed from: g  reason: collision with root package name */
        public n f37381g;

        /* renamed from: h  reason: collision with root package name */
        public j f37382h;

        /* renamed from: i  reason: collision with root package name */
        public aa f37383i;

        /* renamed from: j  reason: collision with root package name */
        public C1587a f37384j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1592a extends GeneratedMessageLite.Builder<c, C1592a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37385a;

            /* renamed from: b  reason: collision with root package name */
            public e f37386b;

            /* renamed from: c  reason: collision with root package name */
            public ae f37387c;

            /* renamed from: d  reason: collision with root package name */
            public l f37388d;

            /* renamed from: e  reason: collision with root package name */
            public n f37389e;

            /* renamed from: f  reason: collision with root package name */
            public j f37390f;

            /* renamed from: g  reason: collision with root package name */
            public aa f37391g;

            /* renamed from: h  reason: collision with root package name */
            public C1587a f37392h;

            /* renamed from: i  reason: collision with root package name */
            public t f37393i;

            public C1592a() {
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
                this.f37386b = e.f37394a;
                this.f37387c = ae.a();
                this.f37388d = l.a();
                this.f37389e = n.a();
                this.f37390f = j.a();
                this.f37391g = aa.a();
                this.f37392h = C1587a.a();
                this.f37393i = t.a();
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1592a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1592a() : (C1592a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1592a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37386b = e.f37394a;
                    this.f37385a &= -2;
                    this.f37387c = ae.a();
                    this.f37385a &= -3;
                    this.f37388d = l.a();
                    this.f37385a &= -5;
                    this.f37389e = n.a();
                    this.f37385a &= -9;
                    this.f37390f = j.a();
                    this.f37385a &= -17;
                    this.f37391g = aa.a();
                    this.f37385a &= -33;
                    this.f37392h = C1587a.a();
                    this.f37385a &= -65;
                    this.f37393i = t.a();
                    this.f37385a &= -129;
                    return this;
                }
                return (C1592a) invokeV.objValue;
            }

            public C1592a a(C1587a c1587a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1587a)) == null) {
                    if (c1587a != null) {
                        this.f37392h = c1587a;
                        this.f37385a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar != null) {
                        this.f37391g = aaVar;
                        this.f37385a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aeVar)) == null) {
                    if ((this.f37385a & 2) == 2 && this.f37387c != ae.a()) {
                        aeVar = ae.a(this.f37387c).mergeFrom(aeVar).buildPartial();
                    }
                    this.f37387c = aeVar;
                    this.f37385a |= 2;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1592a mergeFrom(c cVar) {
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
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(e eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
                    if (eVar != null) {
                        this.f37385a |= 1;
                        this.f37386b = eVar;
                        return this;
                    }
                    throw null;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                    if (jVar != null) {
                        this.f37390f = jVar;
                        this.f37385a |= 16;
                        return this;
                    }
                    throw null;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
                    if (lVar != null) {
                        this.f37388d = lVar;
                        this.f37385a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) {
                    if (nVar != null) {
                        this.f37389e = nVar;
                        this.f37385a |= 8;
                        return this;
                    }
                    throw null;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a a(t tVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tVar)) == null) {
                    if ((this.f37385a & 128) == 128 && this.f37393i != t.a()) {
                        tVar = t.a(this.f37393i).mergeFrom(tVar).buildPartial();
                    }
                    this.f37393i = tVar;
                    this.f37385a |= 128;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1592a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, codedInputStream, extensionRegistryLite)) == null) {
                    c cVar = null;
                    try {
                        try {
                            c parsePartialFrom = c.f37375a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1592a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1592a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? h().mergeFrom(buildPartial()) : (C1592a) invokeV.objValue;
            }

            public C1592a b(C1587a c1587a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, c1587a)) == null) {
                    if ((this.f37385a & 64) == 64 && this.f37392h != C1587a.a()) {
                        c1587a = C1587a.a(this.f37392h).mergeFrom(c1587a).buildPartial();
                    }
                    this.f37392h = c1587a;
                    this.f37385a |= 64;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aaVar)) == null) {
                    if ((this.f37385a & 32) == 32 && this.f37391g != aa.a()) {
                        aaVar = aa.a(this.f37391g).mergeFrom(aaVar).buildPartial();
                    }
                    this.f37391g = aaVar;
                    this.f37385a |= 32;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jVar)) == null) {
                    if ((this.f37385a & 16) == 16 && this.f37390f != j.a()) {
                        jVar = j.a(this.f37390f).mergeFrom(jVar).buildPartial();
                    }
                    this.f37390f = jVar;
                    this.f37385a |= 16;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, lVar)) == null) {
                    if ((this.f37385a & 4) == 4 && this.f37388d != l.a()) {
                        lVar = l.a(this.f37388d).mergeFrom(lVar).buildPartial();
                    }
                    this.f37388d = lVar;
                    this.f37385a |= 4;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, nVar)) == null) {
                    if ((this.f37385a & 8) == 8 && this.f37389e != n.a()) {
                        nVar = n.a(this.f37389e).mergeFrom(nVar).buildPartial();
                    }
                    this.f37389e = nVar;
                    this.f37385a |= 8;
                    return this;
                }
                return (C1592a) invokeL.objValue;
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
                    int i2 = this.f37385a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f37378d = this.f37386b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f37379e = this.f37387c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f37380f = this.f37388d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.f37381g = this.f37389e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    cVar.f37382h = this.f37390f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    cVar.f37383i = this.f37391g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    cVar.f37384j = this.f37392h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    cVar.k = this.f37393i;
                    cVar.f37377c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293441, "Lcom/baidu/android/pushservice/i/a/a/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293441, "Lcom/baidu/android/pushservice/i/a/a/a$c;");
                    return;
                }
            }
            f37375a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
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
            f37376b = cVar;
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
                                        ae.C1591a builder = (this.f37377c & 2) == 2 ? this.f37379e.toBuilder() : null;
                                        ae aeVar = (ae) codedInputStream.readMessage(ae.f37357a, extensionRegistryLite);
                                        this.f37379e = aeVar;
                                        if (builder != null) {
                                            builder.mergeFrom(aeVar);
                                            this.f37379e = builder.buildPartial();
                                        }
                                        i3 = this.f37377c;
                                    } else if (readTag == 26) {
                                        i2 = 4;
                                        l.C1596a builder2 = (this.f37377c & 4) == 4 ? this.f37380f.toBuilder() : null;
                                        l lVar = (l) codedInputStream.readMessage(l.f37452a, extensionRegistryLite);
                                        this.f37380f = lVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(lVar);
                                            this.f37380f = builder2.buildPartial();
                                        }
                                        i3 = this.f37377c;
                                    } else if (readTag == 34) {
                                        n.C1597a builder3 = (this.f37377c & 8) == 8 ? this.f37381g.toBuilder() : null;
                                        n nVar = (n) codedInputStream.readMessage(n.f37466a, extensionRegistryLite);
                                        this.f37381g = nVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(nVar);
                                            this.f37381g = builder3.buildPartial();
                                        }
                                        this.f37377c |= 8;
                                    } else if (readTag == 42) {
                                        i2 = 16;
                                        j.C1595a builder4 = (this.f37377c & 16) == 16 ? this.f37382h.toBuilder() : null;
                                        j jVar = (j) codedInputStream.readMessage(j.f37434a, extensionRegistryLite);
                                        this.f37382h = jVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(jVar);
                                            this.f37382h = builder4.buildPartial();
                                        }
                                        i3 = this.f37377c;
                                    } else if (readTag == 50) {
                                        i2 = 32;
                                        aa.C1589a builder5 = (this.f37377c & 32) == 32 ? this.f37383i.toBuilder() : null;
                                        aa aaVar = (aa) codedInputStream.readMessage(aa.f37321a, extensionRegistryLite);
                                        this.f37383i = aaVar;
                                        if (builder5 != null) {
                                            builder5.mergeFrom(aaVar);
                                            this.f37383i = builder5.buildPartial();
                                        }
                                        i3 = this.f37377c;
                                    } else if (readTag == 58) {
                                        i2 = 64;
                                        C1587a.C1588a builder6 = (this.f37377c & 64) == 64 ? this.f37384j.toBuilder() : null;
                                        C1587a c1587a = (C1587a) codedInputStream.readMessage(C1587a.f37305a, extensionRegistryLite);
                                        this.f37384j = c1587a;
                                        if (builder6 != null) {
                                            builder6.mergeFrom(c1587a);
                                            this.f37384j = builder6.buildPartial();
                                        }
                                        i3 = this.f37377c;
                                    } else if (readTag == 66) {
                                        i2 = 128;
                                        t.C1600a builder7 = (this.f37377c & 128) == 128 ? this.k.toBuilder() : null;
                                        t tVar = (t) codedInputStream.readMessage(t.f37506a, extensionRegistryLite);
                                        this.k = tVar;
                                        if (builder7 != null) {
                                            builder7.mergeFrom(tVar);
                                            this.k = builder7.buildPartial();
                                        }
                                        i3 = this.f37377c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f37377c = i3 | i2;
                                } else {
                                    e a2 = e.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f37377c = 1 | this.f37377c;
                                        this.f37378d = a2;
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

        public static C1592a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cVar)) == null) ? s().mergeFrom(cVar) : (C1592a) invokeL.objValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f37376b : (c) invokeV.objValue;
        }

        public static C1592a s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1592a.h() : (C1592a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f37378d = e.f37394a;
                this.f37379e = ae.a();
                this.f37380f = l.a();
                this.f37381g = n.a();
                this.f37382h = j.a();
                this.f37383i = aa.a();
                this.f37384j = C1587a.a();
                this.k = t.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37376b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37377c & 1) == 1 : invokeV.booleanValue;
        }

        public e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37378d : (e) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37377c & 2) == 2 : invokeV.booleanValue;
        }

        public ae f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37379e : (ae) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37377c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37375a : (Parser) invokeV.objValue;
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
                int computeEnumSize = (this.f37377c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f37378d.getNumber()) : 0;
                if ((this.f37377c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f37379e);
                }
                if ((this.f37377c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f37380f);
                }
                if ((this.f37377c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f37381g);
                }
                if ((this.f37377c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f37382h);
                }
                if ((this.f37377c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f37383i);
                }
                if ((this.f37377c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(7, this.f37384j);
                }
                if ((this.f37377c & 128) == 128) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
                }
                this.m = computeEnumSize;
                return computeEnumSize;
            }
            return invokeV.intValue;
        }

        public l h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37380f : (l) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37377c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37381g : (n) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37377c & 16) == 16 : invokeV.booleanValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37382h : (j) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37377c & 32) == 32 : invokeV.booleanValue;
        }

        public aa n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37383i : (aa) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37377c & 64) == 64 : invokeV.booleanValue;
        }

        public C1587a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37384j : (C1587a) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f37377c & 128) == 128 : invokeV.booleanValue;
        }

        public t r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (t) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C1592a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? s() : (C1592a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1592a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1592a) invokeV.objValue;
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
                if ((this.f37377c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f37378d.getNumber());
                }
                if ((this.f37377c & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.f37379e);
                }
                if ((this.f37377c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f37380f);
                }
                if ((this.f37377c & 8) == 8) {
                    codedOutputStream.writeMessage(4, this.f37381g);
                }
                if ((this.f37377c & 16) == 16) {
                    codedOutputStream.writeMessage(5, this.f37382h);
                }
                if ((this.f37377c & 32) == 32) {
                    codedOutputStream.writeMessage(6, this.f37383i);
                }
                if ((this.f37377c & 64) == 64) {
                    codedOutputStream.writeMessage(7, this.f37384j);
                }
                if ((this.f37377c & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.k);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class e implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f37394a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f37395b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f37396c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f37397d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f37398e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f37399f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f37400g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ e[] f37401i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f37402h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293379, "Lcom/baidu/android/pushservice/i/a/a/a$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293379, "Lcom/baidu/android/pushservice/i/a/a/a$e;");
                    return;
                }
            }
            f37394a = new e("UI", 0, 101);
            f37395b = new e("CRASH", 1, 201);
            f37396c = new e("DB", 2, 301);
            f37397d = new e("CONNECTION", 3, 401);
            f37398e = new e("REQUEST", 4, 501);
            f37399f = new e("ACK", 5, 601);
            e eVar = new e("MSG", 6, 701);
            f37400g = eVar;
            f37401i = new e[]{f37394a, f37395b, f37396c, f37397d, f37398e, f37399f, eVar};
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
            this.f37402h = i3;
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
                                        return f37400g;
                                    }
                                    return f37399f;
                                }
                                return f37398e;
                            }
                            return f37397d;
                        }
                        return f37396c;
                    }
                    return f37395b;
                }
                return f37394a;
            }
            return (e) invokeI.objValue;
        }

        public static e[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f37401i.clone() : (e[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37402h : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends GeneratedMessageLite implements g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f37403a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37404b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37405c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37406d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37407e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37408f;

        /* renamed from: g  reason: collision with root package name */
        public byte f37409g;

        /* renamed from: h  reason: collision with root package name */
        public int f37410h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1593a extends GeneratedMessageLite.Builder<f, C1593a> implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37411a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37412b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37413c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37414d;

            public C1593a() {
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
                this.f37412b = "";
                this.f37413c = "";
                this.f37414d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1593a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1593a() : (C1593a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1593a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37412b = "";
                    int i2 = this.f37411a & (-2);
                    this.f37411a = i2;
                    this.f37413c = "";
                    int i3 = i2 & (-3);
                    this.f37411a = i3;
                    this.f37414d = "";
                    this.f37411a = i3 & (-5);
                    return this;
                }
                return (C1593a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1593a mergeFrom(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
                    if (fVar == f.a()) {
                        return this;
                    }
                    if (fVar.c()) {
                        this.f37411a |= 1;
                        this.f37412b = fVar.f37406d;
                    }
                    if (fVar.e()) {
                        this.f37411a |= 2;
                        this.f37413c = fVar.f37407e;
                    }
                    if (fVar.g()) {
                        this.f37411a |= 4;
                        this.f37414d = fVar.f37408f;
                    }
                    return this;
                }
                return (C1593a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1593a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    f fVar = null;
                    try {
                        try {
                            f parsePartialFrom = f.f37403a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1593a) invokeLL.objValue;
            }

            public C1593a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.f37411a |= 1;
                        this.f37412b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1593a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1593a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1593a) invokeV.objValue;
            }

            public C1593a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.f37411a |= 2;
                        this.f37413c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1593a) invokeL.objValue;
            }

            public C1593a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.f37411a |= 4;
                        this.f37414d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1593a) invokeL.objValue;
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
                    int i2 = this.f37411a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    fVar.f37406d = this.f37412b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    fVar.f37407e = this.f37413c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    fVar.f37408f = this.f37414d;
                    fVar.f37405c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293348, "Lcom/baidu/android/pushservice/i/a/a/a$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293348, "Lcom/baidu/android/pushservice/i/a/a/a$f;");
                    return;
                }
            }
            f37403a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
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
            f37404b = fVar;
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
            this.f37409g = (byte) -1;
            this.f37410h = -1;
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
            this.f37409g = (byte) -1;
            this.f37410h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f37405c |= 1;
                                this.f37406d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f37405c |= 2;
                                this.f37407e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f37405c |= 4;
                                this.f37408f = codedInputStream.readBytes();
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
            this.f37409g = (byte) -1;
            this.f37410h = -1;
        }

        public /* synthetic */ f(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1593a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) ? i().mergeFrom(fVar) : (C1593a) invokeL.objValue;
        }

        public static f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37404b : (f) invokeV.objValue;
        }

        public static C1593a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1593a.h() : (C1593a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f37406d = "";
                this.f37407e = "";
                this.f37408f = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37404b : (f) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37405c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37406d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37406d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37405c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37407e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37407e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37405c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37403a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37410h;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37405c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37405c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37405c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f37410h = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37408f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37408f = copyFromUtf8;
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
                byte b2 = this.f37409g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37409g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1593a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1593a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1593a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1593a) invokeV.objValue;
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
                if ((this.f37405c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37405c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37405c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class h extends GeneratedMessageLite implements i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<h> f37415a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f37416b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37417c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37418d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37419e;

        /* renamed from: f  reason: collision with root package name */
        public p f37420f;

        /* renamed from: g  reason: collision with root package name */
        public long f37421g;

        /* renamed from: h  reason: collision with root package name */
        public long f37422h;

        /* renamed from: i  reason: collision with root package name */
        public ac f37423i;

        /* renamed from: j  reason: collision with root package name */
        public f f37424j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1594a extends GeneratedMessageLite.Builder<h, C1594a> implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37425a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37426b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37427c;

            /* renamed from: d  reason: collision with root package name */
            public p f37428d;

            /* renamed from: e  reason: collision with root package name */
            public long f37429e;

            /* renamed from: f  reason: collision with root package name */
            public long f37430f;

            /* renamed from: g  reason: collision with root package name */
            public ac f37431g;

            /* renamed from: h  reason: collision with root package name */
            public f f37432h;

            /* renamed from: i  reason: collision with root package name */
            public v f37433i;

            public C1594a() {
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
                this.f37426b = "";
                this.f37427c = "";
                this.f37428d = p.a();
                this.f37431g = ac.a();
                this.f37432h = f.a();
                this.f37433i = v.a();
                j();
            }

            private void j() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1594a k() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1594a() : (C1594a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1594a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37426b = "";
                    int i2 = this.f37425a & (-2);
                    this.f37425a = i2;
                    this.f37427c = "";
                    this.f37425a = i2 & (-3);
                    this.f37428d = p.a();
                    int i3 = this.f37425a & (-5);
                    this.f37425a = i3;
                    this.f37429e = 0L;
                    int i4 = i3 & (-9);
                    this.f37425a = i4;
                    this.f37430f = 0L;
                    this.f37425a = i4 & (-17);
                    this.f37431g = ac.a();
                    this.f37425a &= -33;
                    this.f37432h = f.a();
                    this.f37425a &= -65;
                    this.f37433i = v.a();
                    this.f37425a &= -129;
                    return this;
                }
                return (C1594a) invokeV.objValue;
            }

            public C1594a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37425a |= 8;
                    this.f37429e = j2;
                    return this;
                }
                return (C1594a) invokeJ.objValue;
            }

            public C1594a a(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acVar)) == null) {
                    if (acVar != null) {
                        this.f37431g = acVar;
                        this.f37425a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a a(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                    if (fVar != null) {
                        this.f37432h = fVar;
                        this.f37425a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1594a mergeFrom(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
                    if (hVar == h.a()) {
                        return this;
                    }
                    if (hVar.c()) {
                        this.f37425a |= 1;
                        this.f37426b = hVar.f37418d;
                    }
                    if (hVar.e()) {
                        this.f37425a |= 2;
                        this.f37427c = hVar.f37419e;
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
                return (C1594a) invokeL.objValue;
            }

            public C1594a a(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pVar)) == null) {
                    if (pVar != null) {
                        this.f37428d = pVar;
                        this.f37425a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a a(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vVar)) == null) {
                    if (vVar != null) {
                        this.f37433i = vVar;
                        this.f37425a |= 128;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1594a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, codedInputStream, extensionRegistryLite)) == null) {
                    h hVar = null;
                    try {
                        try {
                            h parsePartialFrom = h.f37415a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1594a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1594a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? k().mergeFrom(buildPartial()) : (C1594a) invokeV.objValue;
            }

            public C1594a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                    this.f37425a |= 16;
                    this.f37430f = j2;
                    return this;
                }
                return (C1594a) invokeJ.objValue;
            }

            public C1594a b(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, acVar)) == null) {
                    if ((this.f37425a & 32) == 32 && this.f37431g != ac.a()) {
                        acVar = ac.a(this.f37431g).mergeFrom(acVar).buildPartial();
                    }
                    this.f37431g = acVar;
                    this.f37425a |= 32;
                    return this;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a b(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
                    if ((this.f37425a & 64) == 64 && this.f37432h != f.a()) {
                        fVar = f.a(this.f37432h).mergeFrom(fVar).buildPartial();
                    }
                    this.f37432h = fVar;
                    this.f37425a |= 64;
                    return this;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a b(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pVar)) == null) {
                    if ((this.f37425a & 4) == 4 && this.f37428d != p.a()) {
                        pVar = p.a(this.f37428d).mergeFrom(pVar).buildPartial();
                    }
                    this.f37428d = pVar;
                    this.f37425a |= 4;
                    return this;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a b(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vVar)) == null) {
                    if ((this.f37425a & 128) == 128 && this.f37433i != v.a()) {
                        vVar = v.a(this.f37433i).mergeFrom(vVar).buildPartial();
                    }
                    this.f37433i = vVar;
                    this.f37425a |= 128;
                    return this;
                }
                return (C1594a) invokeL.objValue;
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
                    int i2 = this.f37425a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    hVar.f37418d = this.f37426b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    hVar.f37419e = this.f37427c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    hVar.f37420f = this.f37428d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    hVar.f37421g = this.f37429e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    hVar.f37422h = this.f37430f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    hVar.f37423i = this.f37431g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    hVar.f37424j = this.f37432h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    hVar.k = this.f37433i;
                    hVar.f37417c = i3;
                    return hVar;
                }
                return (h) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.f37425a & 4) == 4 : invokeV.booleanValue;
            }

            public p g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f37428d : (p) invokeV.objValue;
            }

            public boolean h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f37425a & 8) == 8 : invokeV.booleanValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293286, "Lcom/baidu/android/pushservice/i/a/a/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293286, "Lcom/baidu/android/pushservice/i/a/a/a$h;");
                    return;
                }
            }
            f37415a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
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
            f37416b = hVar;
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
                                    this.f37417c |= 1;
                                    this.f37418d = codedInputStream.readBytes();
                                } else if (readTag != 18) {
                                    if (readTag == 58) {
                                        i2 = 4;
                                        p.C1598a builder = (this.f37417c & 4) == 4 ? this.f37420f.toBuilder() : null;
                                        p pVar = (p) codedInputStream.readMessage(p.f37486a, extensionRegistryLite);
                                        this.f37420f = pVar;
                                        if (builder != null) {
                                            builder.mergeFrom(pVar);
                                            this.f37420f = builder.buildPartial();
                                        }
                                        i3 = this.f37417c;
                                    } else if (readTag == 80) {
                                        this.f37417c |= 8;
                                        this.f37421g = codedInputStream.readInt64();
                                    } else if (readTag == 96) {
                                        this.f37417c |= 16;
                                        this.f37422h = codedInputStream.readInt64();
                                    } else if (readTag == 162) {
                                        i2 = 32;
                                        ac.C1590a builder2 = (this.f37417c & 32) == 32 ? this.f37423i.toBuilder() : null;
                                        ac acVar = (ac) codedInputStream.readMessage(ac.f37339a, extensionRegistryLite);
                                        this.f37423i = acVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(acVar);
                                            this.f37423i = builder2.buildPartial();
                                        }
                                        i3 = this.f37417c;
                                    } else if (readTag == 170) {
                                        i2 = 64;
                                        f.C1593a builder3 = (this.f37417c & 64) == 64 ? this.f37424j.toBuilder() : null;
                                        f fVar = (f) codedInputStream.readMessage(f.f37403a, extensionRegistryLite);
                                        this.f37424j = fVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(fVar);
                                            this.f37424j = builder3.buildPartial();
                                        }
                                        i3 = this.f37417c;
                                    } else if (readTag == 178) {
                                        i2 = 128;
                                        v.C1601a builder4 = (this.f37417c & 128) == 128 ? this.k.toBuilder() : null;
                                        v vVar = (v) codedInputStream.readMessage(v.f37524a, extensionRegistryLite);
                                        this.k = vVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(vVar);
                                            this.k = builder4.buildPartial();
                                        }
                                        i3 = this.f37417c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f37417c = i3 | i2;
                                } else {
                                    this.f37417c |= 2;
                                    this.f37419e = codedInputStream.readBytes();
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

        public static C1594a a(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hVar)) == null) ? t().mergeFrom(hVar) : (C1594a) invokeL.objValue;
        }

        public static h a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f37416b : (h) invokeV.objValue;
        }

        public static C1594a t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1594a.k() : (C1594a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37418d = "";
                this.f37419e = "";
                this.f37420f = p.a();
                this.f37421g = 0L;
                this.f37422h = 0L;
                this.f37423i = ac.a();
                this.f37424j = f.a();
                this.k = v.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37416b : (h) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37417c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37418d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37418d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37417c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37419e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37419e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37417c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37415a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37417c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37417c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37417c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f37420f);
                }
                if ((this.f37417c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f37421g);
                }
                if ((this.f37417c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f37422h);
                }
                if ((this.f37417c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f37423i);
                }
                if ((this.f37417c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(21, this.f37424j);
                }
                if ((this.f37417c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
                }
                this.m = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public p h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37420f : (p) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37417c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37421g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37417c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37422h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37417c & 32) == 32 : invokeV.booleanValue;
        }

        public ac n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37423i : (ac) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37417c & 64) == 64 : invokeV.booleanValue;
        }

        public f p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37424j : (f) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f37417c & 128) == 128 : invokeV.booleanValue;
        }

        public v r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (v) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1594a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? t() : (C1594a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1594a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1594a) invokeV.objValue;
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
                if ((this.f37417c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37417c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37417c & 4) == 4) {
                    codedOutputStream.writeMessage(7, this.f37420f);
                }
                if ((this.f37417c & 8) == 8) {
                    codedOutputStream.writeInt64(10, this.f37421g);
                }
                if ((this.f37417c & 16) == 16) {
                    codedOutputStream.writeInt64(12, this.f37422h);
                }
                if ((this.f37417c & 32) == 32) {
                    codedOutputStream.writeMessage(20, this.f37423i);
                }
                if ((this.f37417c & 64) == 64) {
                    codedOutputStream.writeMessage(21, this.f37424j);
                }
                if ((this.f37417c & 128) == 128) {
                    codedOutputStream.writeMessage(22, this.k);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class j extends GeneratedMessageLite implements k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<j> f37434a;

        /* renamed from: b  reason: collision with root package name */
        public static final j f37435b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37436c;

        /* renamed from: d  reason: collision with root package name */
        public long f37437d;

        /* renamed from: e  reason: collision with root package name */
        public long f37438e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37439f;

        /* renamed from: g  reason: collision with root package name */
        public long f37440g;

        /* renamed from: h  reason: collision with root package name */
        public long f37441h;

        /* renamed from: i  reason: collision with root package name */
        public Object f37442i;

        /* renamed from: j  reason: collision with root package name */
        public long f37443j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1595a extends GeneratedMessageLite.Builder<j, C1595a> implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37444a;

            /* renamed from: b  reason: collision with root package name */
            public long f37445b;

            /* renamed from: c  reason: collision with root package name */
            public long f37446c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37447d;

            /* renamed from: e  reason: collision with root package name */
            public long f37448e;

            /* renamed from: f  reason: collision with root package name */
            public long f37449f;

            /* renamed from: g  reason: collision with root package name */
            public Object f37450g;

            /* renamed from: h  reason: collision with root package name */
            public long f37451h;

            public C1595a() {
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
                this.f37447d = "";
                this.f37450g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1595a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1595a() : (C1595a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1595a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37445b = 0L;
                    int i2 = this.f37444a & (-2);
                    this.f37444a = i2;
                    this.f37446c = 0L;
                    int i3 = i2 & (-3);
                    this.f37444a = i3;
                    this.f37447d = "";
                    int i4 = i3 & (-5);
                    this.f37444a = i4;
                    this.f37448e = 0L;
                    int i5 = i4 & (-9);
                    this.f37444a = i5;
                    this.f37449f = 0L;
                    int i6 = i5 & (-17);
                    this.f37444a = i6;
                    this.f37450g = "";
                    int i7 = i6 & (-33);
                    this.f37444a = i7;
                    this.f37451h = 0L;
                    this.f37444a = i7 & (-65);
                    return this;
                }
                return (C1595a) invokeV.objValue;
            }

            public C1595a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37444a |= 1;
                    this.f37445b = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1595a mergeFrom(j jVar) {
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
                        this.f37444a |= 4;
                        this.f37447d = jVar.f37439f;
                    }
                    if (jVar.i()) {
                        c(jVar.j());
                    }
                    if (jVar.k()) {
                        d(jVar.l());
                    }
                    if (jVar.m()) {
                        this.f37444a |= 32;
                        this.f37450g = jVar.f37442i;
                    }
                    if (jVar.o()) {
                        e(jVar.p());
                    }
                    return this;
                }
                return (C1595a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1595a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    j jVar = null;
                    try {
                        try {
                            j parsePartialFrom = j.f37434a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1595a) invokeLL.objValue;
            }

            public C1595a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37444a |= 4;
                        this.f37447d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1595a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1595a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1595a) invokeV.objValue;
            }

            public C1595a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37444a |= 2;
                    this.f37446c = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            public C1595a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37444a |= 32;
                        this.f37450g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1595a) invokeL.objValue;
            }

            public C1595a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.f37444a |= 8;
                    this.f37448e = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j.a() : (j) invokeV.objValue;
            }

            public C1595a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.f37444a |= 16;
                    this.f37449f = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
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

            public C1595a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
                    this.f37444a |= 64;
                    this.f37451h = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    j jVar = new j(this, (AnonymousClass1) null);
                    int i2 = this.f37444a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    jVar.f37437d = this.f37445b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    jVar.f37438e = this.f37446c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    jVar.f37439f = this.f37447d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    jVar.f37440g = this.f37448e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    jVar.f37441h = this.f37449f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    jVar.f37442i = this.f37450g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    jVar.f37443j = this.f37451h;
                    jVar.f37436c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293224, "Lcom/baidu/android/pushservice/i/a/a/a$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293224, "Lcom/baidu/android/pushservice/i/a/a/a$j;");
                    return;
                }
            }
            f37434a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
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
            f37435b = jVar;
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
            this.k = (byte) -1;
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
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f37436c |= 1;
                                this.f37437d = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.f37436c |= 2;
                                this.f37438e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f37436c |= 4;
                                this.f37439f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f37436c |= 8;
                                this.f37440g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f37436c |= 16;
                                this.f37441h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f37436c |= 32;
                                this.f37442i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f37436c |= 64;
                                this.f37443j = codedInputStream.readInt64();
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
            this.k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ j(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1595a a(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jVar)) == null) ? q().mergeFrom(jVar) : (C1595a) invokeL.objValue;
        }

        public static j a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37435b : (j) invokeV.objValue;
        }

        public static C1595a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1595a.h() : (C1595a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f37437d = 0L;
                this.f37438e = 0L;
                this.f37439f = "";
                this.f37440g = 0L;
                this.f37441h = 0L;
                this.f37442i = "";
                this.f37443j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37435b : (j) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37436c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37437d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37436c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37438e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37436c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37434a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f37436c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f37437d) : 0;
                if ((this.f37436c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f37438e);
                }
                if ((this.f37436c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37436c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f37440g);
                }
                if ((this.f37436c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f37441h);
                }
                if ((this.f37436c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f37436c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f37443j);
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
                Object obj = this.f37439f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37439f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37436c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37440g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37436c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37441h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37436c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f37442i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37442i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37436c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37443j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1595a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1595a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1595a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1595a) invokeV.objValue;
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
                if ((this.f37436c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f37437d);
                }
                if ((this.f37436c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f37438e);
                }
                if ((this.f37436c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37436c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37440g);
                }
                if ((this.f37436c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37441h);
                }
                if ((this.f37436c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f37436c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37443j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class l extends GeneratedMessageLite implements m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<l> f37452a;

        /* renamed from: b  reason: collision with root package name */
        public static final l f37453b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37454c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37455d;

        /* renamed from: e  reason: collision with root package name */
        public long f37456e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37457f;

        /* renamed from: g  reason: collision with root package name */
        public long f37458g;

        /* renamed from: h  reason: collision with root package name */
        public byte f37459h;

        /* renamed from: i  reason: collision with root package name */
        public int f37460i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1596a extends GeneratedMessageLite.Builder<l, C1596a> implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37461a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37462b;

            /* renamed from: c  reason: collision with root package name */
            public long f37463c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37464d;

            /* renamed from: e  reason: collision with root package name */
            public long f37465e;

            public C1596a() {
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
                this.f37462b = "";
                this.f37464d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1596a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1596a() : (C1596a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1596a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37462b = "";
                    int i2 = this.f37461a & (-2);
                    this.f37461a = i2;
                    this.f37463c = 0L;
                    int i3 = i2 & (-3);
                    this.f37461a = i3;
                    this.f37464d = "";
                    int i4 = i3 & (-5);
                    this.f37461a = i4;
                    this.f37465e = 0L;
                    this.f37461a = i4 & (-9);
                    return this;
                }
                return (C1596a) invokeV.objValue;
            }

            public C1596a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37461a |= 2;
                    this.f37463c = j2;
                    return this;
                }
                return (C1596a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1596a mergeFrom(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
                    if (lVar == l.a()) {
                        return this;
                    }
                    if (lVar.c()) {
                        this.f37461a |= 1;
                        this.f37462b = lVar.f37455d;
                    }
                    if (lVar.e()) {
                        a(lVar.f());
                    }
                    if (lVar.g()) {
                        this.f37461a |= 4;
                        this.f37464d = lVar.f37457f;
                    }
                    if (lVar.i()) {
                        b(lVar.j());
                    }
                    return this;
                }
                return (C1596a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1596a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    l lVar = null;
                    try {
                        try {
                            l parsePartialFrom = l.f37452a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1596a) invokeLL.objValue;
            }

            public C1596a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37461a |= 1;
                        this.f37462b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1596a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1596a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1596a) invokeV.objValue;
            }

            public C1596a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37461a |= 8;
                    this.f37465e = j2;
                    return this;
                }
                return (C1596a) invokeJ.objValue;
            }

            public C1596a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37461a |= 4;
                        this.f37464d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1596a) invokeL.objValue;
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
                    int i2 = this.f37461a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    lVar.f37455d = this.f37462b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    lVar.f37456e = this.f37463c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    lVar.f37457f = this.f37464d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    lVar.f37458g = this.f37465e;
                    lVar.f37454c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293162, "Lcom/baidu/android/pushservice/i/a/a/a$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293162, "Lcom/baidu/android/pushservice/i/a/a/a$l;");
                    return;
                }
            }
            f37452a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
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
            f37453b = lVar;
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
            this.f37459h = (byte) -1;
            this.f37460i = -1;
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
            this.f37459h = (byte) -1;
            this.f37460i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f37454c |= 1;
                                this.f37455d = codedInputStream.readBytes();
                            } else if (readTag == 16) {
                                this.f37454c |= 2;
                                this.f37456e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f37454c |= 4;
                                this.f37457f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f37454c |= 8;
                                this.f37458g = codedInputStream.readInt64();
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
            this.f37459h = (byte) -1;
            this.f37460i = -1;
        }

        public /* synthetic */ l(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1596a a(l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lVar)) == null) ? k().mergeFrom(lVar) : (C1596a) invokeL.objValue;
        }

        public static l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37453b : (l) invokeV.objValue;
        }

        public static C1596a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1596a.h() : (C1596a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f37455d = "";
                this.f37456e = 0L;
                this.f37457f = "";
                this.f37458g = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37453b : (l) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37454c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37455d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37455d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37454c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37456e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37454c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37452a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37460i;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37454c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37454c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f37456e);
                }
                if ((this.f37454c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37454c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f37458g);
                }
                this.f37460i = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37457f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37457f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37454c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37459h;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37459h = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37458g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1596a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(this) : (C1596a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1596a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? k() : (C1596a) invokeV.objValue;
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
                if ((this.f37454c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37454c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f37456e);
                }
                if ((this.f37454c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37454c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37458g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class n extends GeneratedMessageLite implements o {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f37466a;

        /* renamed from: b  reason: collision with root package name */
        public static final n f37467b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37468c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37469d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37470e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37471f;

        /* renamed from: g  reason: collision with root package name */
        public Object f37472g;

        /* renamed from: h  reason: collision with root package name */
        public long f37473h;

        /* renamed from: i  reason: collision with root package name */
        public long f37474i;

        /* renamed from: j  reason: collision with root package name */
        public long f37475j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1597a extends GeneratedMessageLite.Builder<n, C1597a> implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37476a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37477b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37478c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37479d;

            /* renamed from: e  reason: collision with root package name */
            public Object f37480e;

            /* renamed from: f  reason: collision with root package name */
            public long f37481f;

            /* renamed from: g  reason: collision with root package name */
            public long f37482g;

            /* renamed from: h  reason: collision with root package name */
            public long f37483h;

            /* renamed from: i  reason: collision with root package name */
            public Object f37484i;

            /* renamed from: j  reason: collision with root package name */
            public long f37485j;

            public C1597a() {
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
                this.f37477b = "";
                this.f37478c = "";
                this.f37479d = "";
                this.f37480e = "";
                this.f37484i = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1597a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1597a() : (C1597a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1597a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37477b = "";
                    int i2 = this.f37476a & (-2);
                    this.f37476a = i2;
                    this.f37478c = "";
                    int i3 = i2 & (-3);
                    this.f37476a = i3;
                    this.f37479d = "";
                    int i4 = i3 & (-5);
                    this.f37476a = i4;
                    this.f37480e = "";
                    int i5 = i4 & (-9);
                    this.f37476a = i5;
                    this.f37481f = 0L;
                    int i6 = i5 & (-17);
                    this.f37476a = i6;
                    this.f37482g = 0L;
                    int i7 = i6 & (-33);
                    this.f37476a = i7;
                    this.f37483h = 0L;
                    int i8 = i7 & (-65);
                    this.f37476a = i8;
                    this.f37484i = "";
                    int i9 = i8 & (-129);
                    this.f37476a = i9;
                    this.f37485j = 0L;
                    this.f37476a = i9 & (-257);
                    return this;
                }
                return (C1597a) invokeV.objValue;
            }

            public C1597a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37476a |= 16;
                    this.f37481f = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1597a mergeFrom(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar)) == null) {
                    if (nVar == n.a()) {
                        return this;
                    }
                    if (nVar.c()) {
                        this.f37476a |= 1;
                        this.f37477b = nVar.f37469d;
                    }
                    if (nVar.e()) {
                        this.f37476a |= 2;
                        this.f37478c = nVar.f37470e;
                    }
                    if (nVar.g()) {
                        this.f37476a |= 4;
                        this.f37479d = nVar.f37471f;
                    }
                    if (nVar.i()) {
                        this.f37476a |= 8;
                        this.f37480e = nVar.f37472g;
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
                        this.f37476a |= 128;
                        this.f37484i = nVar.k;
                    }
                    if (nVar.s()) {
                        d(nVar.t());
                    }
                    return this;
                }
                return (C1597a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1597a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    n nVar = null;
                    try {
                        try {
                            n parsePartialFrom = n.f37466a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1597a) invokeLL.objValue;
            }

            public C1597a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37476a |= 1;
                        this.f37477b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1597a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1597a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1597a) invokeV.objValue;
            }

            public C1597a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37476a |= 32;
                    this.f37482g = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37476a |= 2;
                        this.f37478c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1597a) invokeL.objValue;
            }

            public C1597a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.f37476a |= 64;
                    this.f37483h = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.f37476a |= 4;
                        this.f37479d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1597a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? n.a() : (n) invokeV.objValue;
            }

            public C1597a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.f37476a |= 256;
                    this.f37485j = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                    if (str != null) {
                        this.f37476a |= 8;
                        this.f37480e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1597a) invokeL.objValue;
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

            public C1597a e(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                    if (str != null) {
                        this.f37476a |= 128;
                        this.f37484i = str;
                        return this;
                    }
                    throw null;
                }
                return (C1597a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    n nVar = new n(this, (AnonymousClass1) null);
                    int i2 = this.f37476a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    nVar.f37469d = this.f37477b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    nVar.f37470e = this.f37478c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    nVar.f37471f = this.f37479d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    nVar.f37472g = this.f37480e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    nVar.f37473h = this.f37481f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    nVar.f37474i = this.f37482g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    nVar.f37475j = this.f37483h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    nVar.k = this.f37484i;
                    if ((i2 & 256) == 256) {
                        i3 |= 256;
                    }
                    nVar.l = this.f37485j;
                    nVar.f37468c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293100, "Lcom/baidu/android/pushservice/i/a/a/a$n;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293100, "Lcom/baidu/android/pushservice/i/a/a/a$n;");
                    return;
                }
            }
            f37466a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
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
            f37467b = nVar;
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
                                    this.f37468c |= 1;
                                    this.f37469d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37468c |= 2;
                                    this.f37470e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f37468c |= 4;
                                    this.f37471f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f37468c |= 8;
                                    this.f37472g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f37468c |= 16;
                                    this.f37473h = codedInputStream.readInt64();
                                } else if (readTag == 48) {
                                    this.f37468c |= 32;
                                    this.f37474i = codedInputStream.readInt64();
                                } else if (readTag == 56) {
                                    this.f37468c |= 64;
                                    this.f37475j = codedInputStream.readInt64();
                                } else if (readTag == 66) {
                                    this.f37468c |= 128;
                                    this.k = codedInputStream.readBytes();
                                } else if (readTag == 72) {
                                    this.f37468c |= 256;
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

        public static C1597a a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nVar)) == null) ? u().mergeFrom(nVar) : (C1597a) invokeL.objValue;
        }

        public static n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37467b : (n) invokeV.objValue;
        }

        public static C1597a u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? C1597a.h() : (C1597a) invokeV.objValue;
        }

        private void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65560, this) == null) {
                this.f37469d = "";
                this.f37470e = "";
                this.f37471f = "";
                this.f37472g = "";
                this.f37473h = 0L;
                this.f37474i = 0L;
                this.f37475j = 0L;
                this.k = "";
                this.l = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37467b : (n) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37468c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37469d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37469d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37468c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37470e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37470e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37468c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37466a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37468c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37468c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37468c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37468c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f37468c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37473h);
                }
                if ((this.f37468c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f37474i);
                }
                if ((this.f37468c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f37475j);
                }
                if ((this.f37468c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
                }
                if ((this.f37468c & 256) == 256) {
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
                Object obj = this.f37471f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37471f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37468c & 8) == 8 : invokeV.booleanValue;
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
                Object obj = this.f37472g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37472g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37468c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37473h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37468c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37474i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37468c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37475j : invokeV.longValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f37468c & 128) == 128 : invokeV.booleanValue;
        }

        public ByteString r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                Object obj = this.k;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.k = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.f37468c & 256) == 256 : invokeV.booleanValue;
        }

        public long t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C1597a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? a(this) : (C1597a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C1597a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? u() : (C1597a) invokeV.objValue;
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
                if ((this.f37468c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37468c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37468c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37468c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f37468c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37473h);
                }
                if ((this.f37468c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f37474i);
                }
                if ((this.f37468c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37475j);
                }
                if ((this.f37468c & 128) == 128) {
                    codedOutputStream.writeBytes(8, r());
                }
                if ((this.f37468c & 256) == 256) {
                    codedOutputStream.writeInt64(9, this.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class p extends GeneratedMessageLite implements q {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<p> f37486a;

        /* renamed from: b  reason: collision with root package name */
        public static final p f37487b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37488c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37489d;

        /* renamed from: e  reason: collision with root package name */
        public byte f37490e;

        /* renamed from: f  reason: collision with root package name */
        public int f37491f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1598a extends GeneratedMessageLite.Builder<p, C1598a> implements q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37492a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37493b;

            public C1598a() {
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
                this.f37493b = "";
                h();
            }

            private void h() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1598a i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1598a() : (C1598a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1598a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37493b = "";
                    this.f37492a &= -2;
                    return this;
                }
                return (C1598a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1598a mergeFrom(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar)) == null) {
                    if (pVar != p.a() && pVar.c()) {
                        this.f37492a |= 1;
                        this.f37493b = pVar.f37489d;
                    }
                    return this;
                }
                return (C1598a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1598a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    p pVar = null;
                    try {
                        try {
                            p parsePartialFrom = p.f37486a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1598a) invokeLL.objValue;
            }

            public C1598a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.f37492a |= 1;
                        this.f37493b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1598a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i().mergeFrom(buildPartial()) : (C1598a) invokeV.objValue;
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
                    int i2 = (this.f37492a & 1) != 1 ? 0 : 1;
                    pVar.f37489d = this.f37493b;
                    pVar.f37488c = i2;
                    return pVar;
                }
                return (p) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.f37492a & 1) == 1 : invokeV.booleanValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267293038, "Lcom/baidu/android/pushservice/i/a/a/a$p;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267293038, "Lcom/baidu/android/pushservice/i/a/a/a$p;");
                    return;
                }
            }
            f37486a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
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
            f37487b = pVar;
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
            this.f37490e = (byte) -1;
            this.f37491f = -1;
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
            this.f37490e = (byte) -1;
            this.f37491f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 34) {
                                    this.f37488c |= 1;
                                    this.f37489d = codedInputStream.readBytes();
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
            this.f37490e = (byte) -1;
            this.f37491f = -1;
        }

        public /* synthetic */ p(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1598a a(p pVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pVar)) == null) ? e().mergeFrom(pVar) : (C1598a) invokeL.objValue;
        }

        public static p a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37487b : (p) invokeV.objValue;
        }

        public static C1598a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1598a.i() : (C1598a) invokeV.objValue;
        }

        private void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.f37489d = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37487b : (p) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37488c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37489d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37489d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C1598a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e() : (C1598a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C1598a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this) : (C1598a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f37486a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f37491f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37488c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
                this.f37491f = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                byte b2 = this.f37490e;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (c()) {
                    this.f37490e = (byte) 1;
                    return true;
                } else {
                    this.f37490e = (byte) 0;
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
                if ((this.f37488c & 1) == 1) {
                    codedOutputStream.writeBytes(4, d());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class r extends GeneratedMessageLite implements s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<r> f37494a;

        /* renamed from: b  reason: collision with root package name */
        public static final r f37495b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37496c;

        /* renamed from: d  reason: collision with root package name */
        public int f37497d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37498e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37499f;

        /* renamed from: g  reason: collision with root package name */
        public byte f37500g;

        /* renamed from: h  reason: collision with root package name */
        public int f37501h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1599a extends GeneratedMessageLite.Builder<r, C1599a> implements s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37502a;

            /* renamed from: b  reason: collision with root package name */
            public int f37503b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37504c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37505d;

            public C1599a() {
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
                this.f37503b = 7399;
                this.f37504c = "push_im_client";
                this.f37505d = "phonebaidu";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1599a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1599a() : (C1599a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1599a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37503b = 7399;
                    int i2 = this.f37502a & (-2);
                    this.f37502a = i2;
                    this.f37504c = "push_im_client";
                    int i3 = i2 & (-3);
                    this.f37502a = i3;
                    this.f37505d = "phonebaidu";
                    this.f37502a = i3 & (-5);
                    return this;
                }
                return (C1599a) invokeV.objValue;
            }

            public C1599a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f37502a |= 1;
                    this.f37503b = i2;
                    return this;
                }
                return (C1599a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1599a mergeFrom(r rVar) {
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
                        this.f37502a |= 2;
                        this.f37504c = rVar.f37498e;
                    }
                    if (rVar.g()) {
                        this.f37502a |= 4;
                        this.f37505d = rVar.f37499f;
                    }
                    return this;
                }
                return (C1599a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1599a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    r rVar = null;
                    try {
                        try {
                            r parsePartialFrom = r.f37494a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1599a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1599a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1599a) invokeV.objValue;
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
                    int i2 = this.f37502a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    rVar.f37497d = this.f37503b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    rVar.f37498e = this.f37504c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    rVar.f37499f = this.f37505d;
                    rVar.f37496c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267292976, "Lcom/baidu/android/pushservice/i/a/a/a$r;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267292976, "Lcom/baidu/android/pushservice/i/a/a/a$r;");
                    return;
                }
            }
            f37494a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
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
            f37495b = rVar;
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
            this.f37500g = (byte) -1;
            this.f37501h = -1;
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
            this.f37500g = (byte) -1;
            this.f37501h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f37496c |= 1;
                                this.f37497d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f37496c |= 2;
                                this.f37498e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f37496c |= 4;
                                this.f37499f = codedInputStream.readBytes();
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
            this.f37500g = (byte) -1;
            this.f37501h = -1;
        }

        public /* synthetic */ r(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1599a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, rVar)) == null) ? i().mergeFrom(rVar) : (C1599a) invokeL.objValue;
        }

        public static r a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37495b : (r) invokeV.objValue;
        }

        public static C1599a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1599a.h() : (C1599a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f37497d = 7399;
                this.f37498e = "push_im_client";
                this.f37499f = "phonebaidu";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37495b : (r) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37496c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37497d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37496c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37498e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37498e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37496c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37494a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37501h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f37496c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f37497d) : 0;
                if ((this.f37496c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37496c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f37501h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37499f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37499f = copyFromUtf8;
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
                byte b2 = this.f37500g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37500g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1599a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1599a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1599a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1599a) invokeV.objValue;
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
                if ((this.f37496c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f37497d);
                }
                if ((this.f37496c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37496c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class t extends GeneratedMessageLite implements u {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<t> f37506a;

        /* renamed from: b  reason: collision with root package name */
        public static final t f37507b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37508c;

        /* renamed from: d  reason: collision with root package name */
        public long f37509d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37510e;

        /* renamed from: f  reason: collision with root package name */
        public long f37511f;

        /* renamed from: g  reason: collision with root package name */
        public long f37512g;

        /* renamed from: h  reason: collision with root package name */
        public Object f37513h;

        /* renamed from: i  reason: collision with root package name */
        public long f37514i;

        /* renamed from: j  reason: collision with root package name */
        public long f37515j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1600a extends GeneratedMessageLite.Builder<t, C1600a> implements u {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37516a;

            /* renamed from: b  reason: collision with root package name */
            public long f37517b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37518c;

            /* renamed from: d  reason: collision with root package name */
            public long f37519d;

            /* renamed from: e  reason: collision with root package name */
            public long f37520e;

            /* renamed from: f  reason: collision with root package name */
            public Object f37521f;

            /* renamed from: g  reason: collision with root package name */
            public long f37522g;

            /* renamed from: h  reason: collision with root package name */
            public long f37523h;

            public C1600a() {
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
                this.f37518c = "";
                this.f37521f = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1600a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1600a() : (C1600a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1600a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37517b = 0L;
                    int i2 = this.f37516a & (-2);
                    this.f37516a = i2;
                    this.f37518c = "";
                    int i3 = i2 & (-3);
                    this.f37516a = i3;
                    this.f37519d = 0L;
                    int i4 = i3 & (-5);
                    this.f37516a = i4;
                    this.f37520e = 0L;
                    int i5 = i4 & (-9);
                    this.f37516a = i5;
                    this.f37521f = "";
                    int i6 = i5 & (-17);
                    this.f37516a = i6;
                    this.f37522g = 0L;
                    int i7 = i6 & (-33);
                    this.f37516a = i7;
                    this.f37523h = 0L;
                    this.f37516a = i7 & (-65);
                    return this;
                }
                return (C1600a) invokeV.objValue;
            }

            public C1600a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37516a |= 1;
                    this.f37517b = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1600a mergeFrom(t tVar) {
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
                        this.f37516a |= 2;
                        this.f37518c = tVar.f37510e;
                    }
                    if (tVar.g()) {
                        b(tVar.h());
                    }
                    if (tVar.i()) {
                        c(tVar.j());
                    }
                    if (tVar.k()) {
                        this.f37516a |= 16;
                        this.f37521f = tVar.f37513h;
                    }
                    if (tVar.m()) {
                        d(tVar.n());
                    }
                    if (tVar.o()) {
                        e(tVar.p());
                    }
                    return this;
                }
                return (C1600a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1600a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    t tVar = null;
                    try {
                        try {
                            t parsePartialFrom = t.f37506a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1600a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1600a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1600a) invokeV.objValue;
            }

            public C1600a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.f37516a |= 4;
                    this.f37519d = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            public C1600a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.f37516a |= 8;
                    this.f37520e = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? t.a() : (t) invokeV.objValue;
            }

            public C1600a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.f37516a |= 32;
                    this.f37522g = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
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

            public C1600a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.f37516a |= 64;
                    this.f37523h = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    t tVar = new t(this, (AnonymousClass1) null);
                    int i2 = this.f37516a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    tVar.f37509d = this.f37517b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    tVar.f37510e = this.f37518c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    tVar.f37511f = this.f37519d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    tVar.f37512g = this.f37520e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    tVar.f37513h = this.f37521f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    tVar.f37514i = this.f37522g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    tVar.f37515j = this.f37523h;
                    tVar.f37508c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267292914, "Lcom/baidu/android/pushservice/i/a/a/a$t;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267292914, "Lcom/baidu/android/pushservice/i/a/a/a$t;");
                    return;
                }
            }
            f37506a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
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
            f37507b = tVar;
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
            this.k = (byte) -1;
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
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f37508c |= 1;
                                this.f37509d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f37508c |= 2;
                                this.f37510e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f37508c |= 4;
                                this.f37511f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f37508c |= 8;
                                this.f37512g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f37508c |= 16;
                                this.f37513h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f37508c |= 32;
                                this.f37514i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f37508c |= 64;
                                this.f37515j = codedInputStream.readInt64();
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
            this.k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ t(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1600a a(t tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tVar)) == null) ? q().mergeFrom(tVar) : (C1600a) invokeL.objValue;
        }

        public static t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37507b : (t) invokeV.objValue;
        }

        public static C1600a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1600a.h() : (C1600a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f37509d = 0L;
                this.f37510e = "";
                this.f37511f = 0L;
                this.f37512g = 0L;
                this.f37513h = "";
                this.f37514i = 0L;
                this.f37515j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37507b : (t) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37508c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37509d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37508c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37510e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37510e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37508c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37506a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f37508c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f37509d) : 0;
                if ((this.f37508c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37508c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f37511f);
                }
                if ((this.f37508c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f37512g);
                }
                if ((this.f37508c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f37508c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f37514i);
                }
                if ((this.f37508c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f37515j);
                }
                this.l = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37511f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37508c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37512g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37508c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f37513h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37513h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37508c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37514i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37508c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37515j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1600a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1600a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1600a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1600a) invokeV.objValue;
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
                if ((this.f37508c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f37509d);
                }
                if ((this.f37508c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37508c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37511f);
                }
                if ((this.f37508c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37512g);
                }
                if ((this.f37508c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f37508c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f37514i);
                }
                if ((this.f37508c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37515j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class v extends GeneratedMessageLite implements w {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<v> f37524a;

        /* renamed from: b  reason: collision with root package name */
        public static final v f37525b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37526c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37527d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37528e;

        /* renamed from: f  reason: collision with root package name */
        public byte f37529f;

        /* renamed from: g  reason: collision with root package name */
        public int f37530g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1601a extends GeneratedMessageLite.Builder<v, C1601a> implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37531a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37532b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37533c;

            public C1601a() {
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
                this.f37532b = "";
                this.f37533c = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1601a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1601a() : (C1601a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1601a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37532b = "";
                    int i2 = this.f37531a & (-2);
                    this.f37531a = i2;
                    this.f37533c = "";
                    this.f37531a = i2 & (-3);
                    return this;
                }
                return (C1601a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1601a mergeFrom(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar)) == null) {
                    if (vVar == v.a()) {
                        return this;
                    }
                    if (vVar.c()) {
                        this.f37531a |= 1;
                        this.f37532b = vVar.f37527d;
                    }
                    if (vVar.e()) {
                        this.f37531a |= 2;
                        this.f37533c = vVar.f37528e;
                    }
                    return this;
                }
                return (C1601a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1601a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    v vVar = null;
                    try {
                        try {
                            v parsePartialFrom = v.f37524a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1601a) invokeLL.objValue;
            }

            public C1601a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.f37531a |= 1;
                        this.f37532b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1601a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1601a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1601a) invokeV.objValue;
            }

            public C1601a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.f37531a |= 2;
                        this.f37533c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1601a) invokeL.objValue;
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
                    int i2 = this.f37531a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    vVar.f37527d = this.f37532b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    vVar.f37528e = this.f37533c;
                    vVar.f37526c = i3;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267292852, "Lcom/baidu/android/pushservice/i/a/a/a$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267292852, "Lcom/baidu/android/pushservice/i/a/a/a$v;");
                    return;
                }
            }
            f37524a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
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
            f37525b = vVar;
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
            this.f37529f = (byte) -1;
            this.f37530g = -1;
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
            this.f37529f = (byte) -1;
            this.f37530g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f37526c |= 1;
                                    this.f37527d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37526c |= 2;
                                    this.f37528e = codedInputStream.readBytes();
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
            this.f37529f = (byte) -1;
            this.f37530g = -1;
        }

        public /* synthetic */ v(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1601a a(v vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, vVar)) == null) ? g().mergeFrom(vVar) : (C1601a) invokeL.objValue;
        }

        public static v a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37525b : (v) invokeV.objValue;
        }

        public static C1601a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? C1601a.h() : (C1601a) invokeV.objValue;
        }

        private void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.f37527d = "";
                this.f37528e = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37525b : (v) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37526c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37527d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37527d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37526c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37528e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37528e = copyFromUtf8;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f37524a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f37530g;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37526c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37526c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                this.f37530g = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C1601a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g() : (C1601a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C1601a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? a(this) : (C1601a) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.f37529f;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37529f = (byte) 1;
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
                if ((this.f37526c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37526c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class x implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final x f37534a;

        /* renamed from: b  reason: collision with root package name */
        public static final x f37535b;

        /* renamed from: c  reason: collision with root package name */
        public static final x f37536c;

        /* renamed from: d  reason: collision with root package name */
        public static final x f37537d;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ x[] f37538f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f37539e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267292790, "Lcom/baidu/android/pushservice/i/a/a/a$x;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267292790, "Lcom/baidu/android/pushservice/i/a/a/a$x;");
                    return;
                }
            }
            f37534a = new x("OS_TYPE_UNKNWON", 0, 0);
            f37535b = new x("IOS", 1, 1);
            f37536c = new x("ANDROID", 2, 2);
            x xVar = new x("WINDOWSPHONE", 3, 3);
            f37537d = xVar;
            f37538f = new x[]{f37534a, f37535b, f37536c, xVar};
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
            this.f37539e = i3;
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
                            return f37537d;
                        }
                        return f37536c;
                    }
                    return f37535b;
                }
                return f37534a;
            }
            return (x) invokeI.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37539e : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class y extends GeneratedMessageLite implements z {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f37540a;

        /* renamed from: b  reason: collision with root package name */
        public static final y f37541b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37542c;

        /* renamed from: d  reason: collision with root package name */
        public r f37543d;

        /* renamed from: e  reason: collision with root package name */
        public h f37544e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37545f;

        /* renamed from: g  reason: collision with root package name */
        public long f37546g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f37547h;

        /* renamed from: i  reason: collision with root package name */
        public byte f37548i;

        /* renamed from: j  reason: collision with root package name */
        public int f37549j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1602a extends GeneratedMessageLite.Builder<y, C1602a> implements z {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37550a;

            /* renamed from: b  reason: collision with root package name */
            public r f37551b;

            /* renamed from: c  reason: collision with root package name */
            public h f37552c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37553d;

            /* renamed from: e  reason: collision with root package name */
            public long f37554e;

            /* renamed from: f  reason: collision with root package name */
            public List<c> f37555f;

            public C1602a() {
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
                this.f37551b = r.a();
                this.f37552c = h.a();
                this.f37553d = "";
                this.f37555f = Collections.emptyList();
                i();
            }

            private void i() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1602a j() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1602a() : (C1602a) invokeV.objValue;
            }

            private void k() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (this.f37550a & 16) == 16) {
                    return;
                }
                this.f37555f = new ArrayList(this.f37555f);
                this.f37550a |= 16;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1602a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37551b = r.a();
                    this.f37550a &= -2;
                    this.f37552c = h.a();
                    int i2 = this.f37550a & (-3);
                    this.f37550a = i2;
                    this.f37553d = "";
                    int i3 = i2 & (-5);
                    this.f37550a = i3;
                    this.f37554e = 0L;
                    this.f37550a = i3 & (-9);
                    this.f37555f = Collections.emptyList();
                    this.f37550a &= -17;
                    return this;
                }
                return (C1602a) invokeV.objValue;
            }

            public C1602a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37550a |= 8;
                    this.f37554e = j2;
                    return this;
                }
                return (C1602a) invokeJ.objValue;
            }

            public C1602a a(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
                    if (hVar != null) {
                        this.f37552c = hVar;
                        this.f37550a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1602a) invokeL.objValue;
            }

            public C1602a a(r rVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rVar)) == null) {
                    if ((this.f37550a & 1) == 1 && this.f37551b != r.a()) {
                        rVar = r.a(this.f37551b).mergeFrom(rVar).buildPartial();
                    }
                    this.f37551b = rVar;
                    this.f37550a |= 1;
                    return this;
                }
                return (C1602a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1602a mergeFrom(y yVar) {
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
                        this.f37550a |= 4;
                        this.f37553d = yVar.f37545f;
                    }
                    if (yVar.i()) {
                        a(yVar.j());
                    }
                    if (!yVar.f37547h.isEmpty()) {
                        if (this.f37555f.isEmpty()) {
                            this.f37555f = yVar.f37547h;
                            this.f37550a &= -17;
                        } else {
                            k();
                            this.f37555f.addAll(yVar.f37547h);
                        }
                    }
                    return this;
                }
                return (C1602a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1602a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, codedInputStream, extensionRegistryLite)) == null) {
                    y yVar = null;
                    try {
                        try {
                            y parsePartialFrom = y.f37540a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1602a) invokeLL.objValue;
            }

            public C1602a a(Iterable<? extends c> iterable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iterable)) == null) {
                    k();
                    AbstractMessageLite.Builder.addAll(iterable, this.f37555f);
                    return this;
                }
                return (C1602a) invokeL.objValue;
            }

            public C1602a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37550a |= 4;
                        this.f37553d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1602a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1602a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? j().mergeFrom(buildPartial()) : (C1602a) invokeV.objValue;
            }

            public C1602a b(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hVar)) == null) {
                    if ((this.f37550a & 2) == 2 && this.f37552c != h.a()) {
                        hVar = h.a(this.f37552c).mergeFrom(hVar).buildPartial();
                    }
                    this.f37552c = hVar;
                    this.f37550a |= 2;
                    return this;
                }
                return (C1602a) invokeL.objValue;
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
                    int i2 = this.f37550a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    yVar.f37543d = this.f37551b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    yVar.f37544e = this.f37552c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    yVar.f37545f = this.f37553d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    yVar.f37546g = this.f37554e;
                    if ((this.f37550a & 16) == 16) {
                        this.f37555f = Collections.unmodifiableList(this.f37555f);
                        this.f37550a &= -17;
                    }
                    yVar.f37547h = this.f37555f;
                    yVar.f37542c = i3;
                    return yVar;
                }
                return (y) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.f37550a & 2) == 2 : invokeV.booleanValue;
            }

            public h g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f37552c : (h) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267292759, "Lcom/baidu/android/pushservice/i/a/a/a$y;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1267292759, "Lcom/baidu/android/pushservice/i/a/a/a$y;");
                    return;
                }
            }
            f37540a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
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
            f37541b = yVar;
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
            this.f37548i = (byte) -1;
            this.f37549j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v15, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
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
            this.f37548i = (byte) -1;
            this.f37549j = -1;
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
                                    r.C1599a builder = (this.f37542c & 1) == 1 ? this.f37543d.toBuilder() : null;
                                    r rVar = (r) codedInputStream.readMessage(r.f37494a, extensionRegistryLite);
                                    this.f37543d = rVar;
                                    if (builder != null) {
                                        builder.mergeFrom(rVar);
                                        this.f37543d = builder.buildPartial();
                                    }
                                    i2 = this.f37542c;
                                } else if (readTag == 330) {
                                    i5 = 2;
                                    h.C1594a builder2 = (this.f37542c & 2) == 2 ? this.f37544e.toBuilder() : null;
                                    h hVar = (h) codedInputStream.readMessage(h.f37415a, extensionRegistryLite);
                                    this.f37544e = hVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(hVar);
                                        this.f37544e = builder2.buildPartial();
                                    }
                                    i2 = this.f37542c;
                                } else if (readTag == 1042) {
                                    this.f37542c |= 4;
                                    this.f37545f = codedInputStream.readBytes();
                                } else if (readTag == 1048) {
                                    this.f37542c |= 8;
                                    this.f37546g = codedInputStream.readInt64();
                                } else if (readTag == 1058) {
                                    if (!(z2 & true)) {
                                        this.f37547h = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.f37547h.add(codedInputStream.readMessage(c.f37375a, extensionRegistryLite));
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f37542c = i2 | i5;
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
                        this.f37547h = Collections.unmodifiableList(this.f37547h);
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
            this.f37548i = (byte) -1;
            this.f37549j = -1;
        }

        public /* synthetic */ y(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1602a a(y yVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, yVar)) == null) ? k().mergeFrom(yVar) : (C1602a) invokeL.objValue;
        }

        public static y a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f37541b : (y) invokeV.objValue;
        }

        public static C1602a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? C1602a.j() : (C1602a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.f37543d = r.a();
                this.f37544e = h.a();
                this.f37545f = "";
                this.f37546g = 0L;
                this.f37547h = Collections.emptyList();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37541b : (y) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37542c & 1) == 1 : invokeV.booleanValue;
        }

        public r d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37543d : (r) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37542c & 2) == 2 : invokeV.booleanValue;
        }

        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37544e : (h) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37542c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37540a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37549j;
                if (i2 != -1) {
                    return i2;
                }
                int computeMessageSize = (this.f37542c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f37543d) + 0 : 0;
                if ((this.f37542c & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f37544e);
                }
                if ((this.f37542c & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.f37542c & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f37546g);
                }
                for (int i3 = 0; i3 < this.f37547h.size(); i3++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f37547h.get(i3));
                }
                this.f37549j = computeMessageSize;
                return computeMessageSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37545f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37545f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37542c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37548i;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (!e()) {
                    this.f37548i = (byte) 0;
                    return false;
                } else if (f().isInitialized()) {
                    this.f37548i = (byte) 1;
                    return true;
                } else {
                    this.f37548i = (byte) 0;
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37546g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1602a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? k() : (C1602a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1602a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(this) : (C1602a) invokeV.objValue;
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
                if ((this.f37542c & 1) == 1) {
                    codedOutputStream.writeMessage(25, this.f37543d);
                }
                if ((this.f37542c & 2) == 2) {
                    codedOutputStream.writeMessage(41, this.f37544e);
                }
                if ((this.f37542c & 4) == 4) {
                    codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.f37542c & 8) == 8) {
                    codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f37546g);
                }
                for (int i2 = 0; i2 < this.f37547h.size(); i2++) {
                    codedOutputStream.writeMessage(132, this.f37547h.get(i2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
