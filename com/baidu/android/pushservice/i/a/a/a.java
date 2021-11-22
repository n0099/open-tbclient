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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1587a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C1587a> f36222a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1587a f36223b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36224c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36225d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36226e;

        /* renamed from: f  reason: collision with root package name */
        public long f36227f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36228g;

        /* renamed from: h  reason: collision with root package name */
        public long f36229h;

        /* renamed from: i  reason: collision with root package name */
        public byte f36230i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1588a extends GeneratedMessageLite.Builder<C1587a, C1588a> implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36231a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36232b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36233c;

            /* renamed from: d  reason: collision with root package name */
            public long f36234d;

            /* renamed from: e  reason: collision with root package name */
            public Object f36235e;

            /* renamed from: f  reason: collision with root package name */
            public long f36236f;

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
                this.f36232b = "";
                this.f36233c = "";
                this.f36235e = "";
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
                    this.f36232b = "";
                    int i2 = this.f36231a & (-2);
                    this.f36231a = i2;
                    this.f36233c = "";
                    int i3 = i2 & (-3);
                    this.f36231a = i3;
                    this.f36234d = 0L;
                    int i4 = i3 & (-5);
                    this.f36231a = i4;
                    this.f36235e = "";
                    int i5 = i4 & (-9);
                    this.f36231a = i5;
                    this.f36236f = 0L;
                    this.f36231a = i5 & (-17);
                    return this;
                }
                return (C1588a) invokeV.objValue;
            }

            public C1588a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36231a |= 4;
                    this.f36234d = j;
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
                        this.f36231a |= 1;
                        this.f36232b = c1587a.f36225d;
                    }
                    if (c1587a.e()) {
                        this.f36231a |= 2;
                        this.f36233c = c1587a.f36226e;
                    }
                    if (c1587a.g()) {
                        a(c1587a.h());
                    }
                    if (c1587a.i()) {
                        this.f36231a |= 8;
                        this.f36235e = c1587a.f36228g;
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
                            C1587a parsePartialFrom = C1587a.f36222a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36231a |= 1;
                        this.f36232b = str;
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

            public C1588a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                    this.f36231a |= 16;
                    this.f36236f = j;
                    return this;
                }
                return (C1588a) invokeJ.objValue;
            }

            public C1588a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f36231a |= 2;
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
                        this.f36231a |= 8;
                        this.f36235e = str;
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
                    int i2 = this.f36231a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1587a.f36225d = this.f36232b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1587a.f36226e = this.f36233c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1587a.f36227f = this.f36234d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1587a.f36228g = this.f36235e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1587a.f36229h = this.f36236f;
                    c1587a.f36224c = i3;
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
            f36222a = new AbstractParser<C1587a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
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
            f36223b = c1587a;
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
            this.f36230i = (byte) -1;
            this.j = -1;
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
            this.f36230i = (byte) -1;
            this.j = -1;
            p();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f36224c |= 1;
                                this.f36225d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f36224c |= 2;
                                this.f36226e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f36224c |= 4;
                                this.f36227f = codedInputStream.readInt64();
                            } else if (readTag == 34) {
                                this.f36224c |= 8;
                                this.f36228g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f36224c |= 16;
                                this.f36229h = codedInputStream.readInt64();
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
            this.f36230i = (byte) -1;
            this.j = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36223b : (C1587a) invokeV.objValue;
        }

        public static C1588a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1588a.h() : (C1588a) invokeV.objValue;
        }

        private void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f36225d = "";
                this.f36226e = "";
                this.f36227f = 0L;
                this.f36228g = "";
                this.f36229h = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1587a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36223b : (C1587a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36224c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36225d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36225d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36224c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36226e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36226e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36224c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C1587a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36222a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.j;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f36224c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36224c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36224c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f36227f);
                }
                if ((this.f36224c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f36224c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f36229h);
                }
                this.j = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36227f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36224c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f36230i;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f36230i = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f36228g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36228g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36224c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36229h : invokeV.longValue;
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
                if ((this.f36224c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36224c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36224c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f36227f);
                }
                if ((this.f36224c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f36224c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f36229h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class aa extends GeneratedMessageLite implements ab {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f36237a;

        /* renamed from: b  reason: collision with root package name */
        public static final aa f36238b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36239c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36240d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36241e;

        /* renamed from: f  reason: collision with root package name */
        public long f36242f;

        /* renamed from: g  reason: collision with root package name */
        public long f36243g;

        /* renamed from: h  reason: collision with root package name */
        public long f36244h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36245i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1589a extends GeneratedMessageLite.Builder<aa, C1589a> implements ab {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36246a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36247b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36248c;

            /* renamed from: d  reason: collision with root package name */
            public long f36249d;

            /* renamed from: e  reason: collision with root package name */
            public long f36250e;

            /* renamed from: f  reason: collision with root package name */
            public long f36251f;

            /* renamed from: g  reason: collision with root package name */
            public Object f36252g;

            /* renamed from: h  reason: collision with root package name */
            public long f36253h;

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
                this.f36247b = "";
                this.f36248c = "";
                this.f36252g = "";
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
                    this.f36247b = "";
                    int i2 = this.f36246a & (-2);
                    this.f36246a = i2;
                    this.f36248c = "";
                    int i3 = i2 & (-3);
                    this.f36246a = i3;
                    this.f36249d = 0L;
                    int i4 = i3 & (-5);
                    this.f36246a = i4;
                    this.f36250e = 0L;
                    int i5 = i4 & (-9);
                    this.f36246a = i5;
                    this.f36251f = 0L;
                    int i6 = i5 & (-17);
                    this.f36246a = i6;
                    this.f36252g = "";
                    int i7 = i6 & (-33);
                    this.f36246a = i7;
                    this.f36253h = 0L;
                    this.f36246a = i7 & (-65);
                    return this;
                }
                return (C1589a) invokeV.objValue;
            }

            public C1589a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36246a |= 4;
                    this.f36249d = j;
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
                        this.f36246a |= 1;
                        this.f36247b = aaVar.f36240d;
                    }
                    if (aaVar.e()) {
                        this.f36246a |= 2;
                        this.f36248c = aaVar.f36241e;
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
                        this.f36246a |= 32;
                        this.f36252g = aaVar.f36245i;
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
                            aa parsePartialFrom = aa.f36237a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36246a |= 1;
                        this.f36247b = str;
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

            public C1589a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                    this.f36246a |= 8;
                    this.f36250e = j;
                    return this;
                }
                return (C1589a) invokeJ.objValue;
            }

            public C1589a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f36246a |= 2;
                        this.f36248c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1589a) invokeL.objValue;
            }

            public C1589a c(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                    this.f36246a |= 16;
                    this.f36251f = j;
                    return this;
                }
                return (C1589a) invokeJ.objValue;
            }

            public C1589a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.f36246a |= 32;
                        this.f36252g = str;
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

            public C1589a d(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
                    this.f36246a |= 64;
                    this.f36253h = j;
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
                    int i2 = this.f36246a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aaVar.f36240d = this.f36247b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aaVar.f36241e = this.f36248c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aaVar.f36242f = this.f36249d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aaVar.f36243g = this.f36250e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aaVar.f36244h = this.f36251f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aaVar.f36245i = this.f36252g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aaVar.j = this.f36253h;
                    aaVar.f36239c = i3;
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
            f36237a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
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
            f36238b = aaVar;
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
                                    this.f36239c |= 1;
                                    this.f36240d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f36239c |= 2;
                                    this.f36241e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f36239c |= 4;
                                    this.f36242f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f36239c |= 8;
                                    this.f36243g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f36239c |= 16;
                                    this.f36244h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f36239c |= 32;
                                    this.f36245i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f36239c |= 64;
                                    this.j = codedInputStream.readInt64();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36238b : (aa) invokeV.objValue;
        }

        public static C1589a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1589a.h() : (C1589a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f36240d = "";
                this.f36241e = "";
                this.f36242f = 0L;
                this.f36243g = 0L;
                this.f36244h = 0L;
                this.f36245i = "";
                this.j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36238b : (aa) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36239c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36240d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36240d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36239c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36241e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36241e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36239c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36237a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f36239c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36239c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36239c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f36242f);
                }
                if ((this.f36239c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f36243g);
                }
                if ((this.f36239c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f36244h);
                }
                if ((this.f36239c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f36239c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36242f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36239c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36243g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36239c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36244h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36239c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f36245i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36245i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36239c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.longValue;
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
                if ((this.f36239c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36239c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36239c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f36242f);
                }
                if ((this.f36239c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f36243g);
                }
                if ((this.f36239c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f36244h);
                }
                if ((this.f36239c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f36239c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.j);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class ac extends GeneratedMessageLite implements ad {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ac> f36254a;

        /* renamed from: b  reason: collision with root package name */
        public static final ac f36255b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36256c;

        /* renamed from: d  reason: collision with root package name */
        public x f36257d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36258e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36259f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36260g;

        /* renamed from: h  reason: collision with root package name */
        public int f36261h;

        /* renamed from: i  reason: collision with root package name */
        public int f36262i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1590a extends GeneratedMessageLite.Builder<ac, C1590a> implements ad {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36263a;

            /* renamed from: b  reason: collision with root package name */
            public x f36264b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36265c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36266d;

            /* renamed from: e  reason: collision with root package name */
            public Object f36267e;

            /* renamed from: f  reason: collision with root package name */
            public int f36268f;

            /* renamed from: g  reason: collision with root package name */
            public int f36269g;

            /* renamed from: h  reason: collision with root package name */
            public int f36270h;

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
                this.f36264b = x.f36441a;
                this.f36265c = "";
                this.f36266d = "";
                this.f36267e = "";
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
                    this.f36264b = x.f36441a;
                    int i2 = this.f36263a & (-2);
                    this.f36263a = i2;
                    this.f36265c = "";
                    int i3 = i2 & (-3);
                    this.f36263a = i3;
                    this.f36266d = "";
                    int i4 = i3 & (-5);
                    this.f36263a = i4;
                    this.f36267e = "";
                    int i5 = i4 & (-9);
                    this.f36263a = i5;
                    this.f36268f = 0;
                    int i6 = i5 & (-17);
                    this.f36263a = i6;
                    this.f36269g = 0;
                    int i7 = i6 & (-33);
                    this.f36263a = i7;
                    this.f36270h = 0;
                    this.f36263a = i7 & (-65);
                    return this;
                }
                return (C1590a) invokeV.objValue;
            }

            public C1590a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f36263a |= 16;
                    this.f36268f = i2;
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
                        this.f36263a |= 2;
                        this.f36265c = acVar.f36258e;
                    }
                    if (acVar.g()) {
                        this.f36263a |= 4;
                        this.f36266d = acVar.f36259f;
                    }
                    if (acVar.i()) {
                        this.f36263a |= 8;
                        this.f36267e = acVar.f36260g;
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
                        this.f36263a |= 1;
                        this.f36264b = xVar;
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
                            ac parsePartialFrom = ac.f36254a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36263a |= 2;
                        this.f36265c = str;
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
                    this.f36263a |= 32;
                    this.f36269g = i2;
                    return this;
                }
                return (C1590a) invokeI.objValue;
            }

            public C1590a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.f36263a |= 4;
                        this.f36266d = str;
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
                    this.f36263a |= 64;
                    this.f36270h = i2;
                    return this;
                }
                return (C1590a) invokeI.objValue;
            }

            public C1590a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                    if (str != null) {
                        this.f36263a |= 8;
                        this.f36267e = str;
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
                    int i2 = this.f36263a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    acVar.f36257d = this.f36264b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    acVar.f36258e = this.f36265c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    acVar.f36259f = this.f36266d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    acVar.f36260g = this.f36267e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    acVar.f36261h = this.f36268f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    acVar.f36262i = this.f36269g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    acVar.j = this.f36270h;
                    acVar.f36256c = i3;
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
            f36254a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
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
            f36255b = acVar;
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
                                    this.f36256c = 1 | this.f36256c;
                                    this.f36257d = a2;
                                }
                            } else if (readTag == 18) {
                                this.f36256c |= 2;
                                this.f36258e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f36256c |= 4;
                                this.f36259f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f36256c |= 8;
                                this.f36260g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f36256c |= 16;
                                this.f36261h = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.f36256c |= 32;
                                this.f36262i = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.f36256c |= 64;
                                this.j = codedInputStream.readInt32();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f36255b : (ac) invokeV.objValue;
        }

        public static C1590a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1590a.h() : (C1590a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f36257d = x.f36441a;
                this.f36258e = "";
                this.f36259f = "";
                this.f36260g = "";
                this.f36261h = 0;
                this.f36262i = 0;
                this.j = 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36255b : (ac) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36256c & 1) == 1 : invokeV.booleanValue;
        }

        public x d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36257d : (x) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36256c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36258e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36258e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36256c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36254a : (Parser) invokeV.objValue;
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
                int computeEnumSize = (this.f36256c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f36257d.getNumber()) : 0;
                if ((this.f36256c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36256c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f36256c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f36256c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f36261h);
                }
                if ((this.f36256c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f36262i);
                }
                if ((this.f36256c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
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
                Object obj = this.f36259f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36259f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36256c & 8) == 8 : invokeV.booleanValue;
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
                Object obj = this.f36260g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36260g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36256c & 16) == 16 : invokeV.booleanValue;
        }

        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36261h : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36256c & 32) == 32 : invokeV.booleanValue;
        }

        public int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36262i : invokeV.intValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36256c & 64) == 64 : invokeV.booleanValue;
        }

        public int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.intValue;
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
                if ((this.f36256c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f36257d.getNumber());
                }
                if ((this.f36256c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36256c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f36256c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f36256c & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.f36261h);
                }
                if ((this.f36256c & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.f36262i);
                }
                if ((this.f36256c & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.j);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class ae extends GeneratedMessageLite implements af {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ae> f36271a;

        /* renamed from: b  reason: collision with root package name */
        public static final ae f36272b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36273c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36274d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36275e;

        /* renamed from: f  reason: collision with root package name */
        public long f36276f;

        /* renamed from: g  reason: collision with root package name */
        public long f36277g;

        /* renamed from: h  reason: collision with root package name */
        public long f36278h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36279i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1591a extends GeneratedMessageLite.Builder<ae, C1591a> implements af {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36280a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36281b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36282c;

            /* renamed from: d  reason: collision with root package name */
            public long f36283d;

            /* renamed from: e  reason: collision with root package name */
            public long f36284e;

            /* renamed from: f  reason: collision with root package name */
            public long f36285f;

            /* renamed from: g  reason: collision with root package name */
            public Object f36286g;

            /* renamed from: h  reason: collision with root package name */
            public long f36287h;

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
                this.f36281b = "";
                this.f36282c = "";
                this.f36286g = "";
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
                    this.f36281b = "";
                    int i2 = this.f36280a & (-2);
                    this.f36280a = i2;
                    this.f36282c = "";
                    int i3 = i2 & (-3);
                    this.f36280a = i3;
                    this.f36283d = 0L;
                    int i4 = i3 & (-5);
                    this.f36280a = i4;
                    this.f36284e = 0L;
                    int i5 = i4 & (-9);
                    this.f36280a = i5;
                    this.f36285f = 0L;
                    int i6 = i5 & (-17);
                    this.f36280a = i6;
                    this.f36286g = "";
                    int i7 = i6 & (-33);
                    this.f36280a = i7;
                    this.f36287h = 0L;
                    this.f36280a = i7 & (-65);
                    return this;
                }
                return (C1591a) invokeV.objValue;
            }

            public C1591a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36280a |= 4;
                    this.f36283d = j;
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
                        this.f36280a |= 1;
                        this.f36281b = aeVar.f36274d;
                    }
                    if (aeVar.e()) {
                        this.f36280a |= 2;
                        this.f36282c = aeVar.f36275e;
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
                        this.f36280a |= 32;
                        this.f36286g = aeVar.f36279i;
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
                            ae parsePartialFrom = ae.f36271a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C1591a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                    this.f36280a |= 8;
                    this.f36284e = j;
                    return this;
                }
                return (C1591a) invokeJ.objValue;
            }

            public C1591a c(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                    this.f36280a |= 16;
                    this.f36285f = j;
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

            public C1591a d(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
                    this.f36280a |= 64;
                    this.f36287h = j;
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
                    int i2 = this.f36280a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aeVar.f36274d = this.f36281b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aeVar.f36275e = this.f36282c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aeVar.f36276f = this.f36283d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aeVar.f36277g = this.f36284e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aeVar.f36278h = this.f36285f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aeVar.f36279i = this.f36286g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aeVar.j = this.f36287h;
                    aeVar.f36273c = i3;
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
            f36271a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
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
            f36272b = aeVar;
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
                                    this.f36273c |= 1;
                                    this.f36274d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f36273c |= 2;
                                    this.f36275e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f36273c |= 4;
                                    this.f36276f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f36273c |= 8;
                                    this.f36277g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f36273c |= 16;
                                    this.f36278h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f36273c |= 32;
                                    this.f36279i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f36273c |= 64;
                                    this.j = codedInputStream.readInt64();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36272b : (ae) invokeV.objValue;
        }

        public static C1591a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1591a.h() : (C1591a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f36274d = "";
                this.f36275e = "";
                this.f36276f = 0L;
                this.f36277g = 0L;
                this.f36278h = 0L;
                this.f36279i = "";
                this.j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36272b : (ae) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36273c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36274d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36274d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36273c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36275e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36275e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36273c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36271a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f36273c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36273c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36273c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f36276f);
                }
                if ((this.f36273c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f36277g);
                }
                if ((this.f36273c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f36278h);
                }
                if ((this.f36273c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f36273c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36276f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36273c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36277g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36273c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36278h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36273c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f36279i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36279i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36273c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.longValue;
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
                if ((this.f36273c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36273c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36273c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f36276f);
                }
                if ((this.f36273c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f36277g);
                }
                if ((this.f36273c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f36278h);
                }
                if ((this.f36273c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f36273c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.j);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class c extends GeneratedMessageLite implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f36288a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f36289b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36290c;

        /* renamed from: d  reason: collision with root package name */
        public e f36291d;

        /* renamed from: e  reason: collision with root package name */
        public ae f36292e;

        /* renamed from: f  reason: collision with root package name */
        public l f36293f;

        /* renamed from: g  reason: collision with root package name */
        public n f36294g;

        /* renamed from: h  reason: collision with root package name */
        public j f36295h;

        /* renamed from: i  reason: collision with root package name */
        public aa f36296i;
        public C1587a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1592a extends GeneratedMessageLite.Builder<c, C1592a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36297a;

            /* renamed from: b  reason: collision with root package name */
            public e f36298b;

            /* renamed from: c  reason: collision with root package name */
            public ae f36299c;

            /* renamed from: d  reason: collision with root package name */
            public l f36300d;

            /* renamed from: e  reason: collision with root package name */
            public n f36301e;

            /* renamed from: f  reason: collision with root package name */
            public j f36302f;

            /* renamed from: g  reason: collision with root package name */
            public aa f36303g;

            /* renamed from: h  reason: collision with root package name */
            public C1587a f36304h;

            /* renamed from: i  reason: collision with root package name */
            public t f36305i;

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
                this.f36298b = e.f36306a;
                this.f36299c = ae.a();
                this.f36300d = l.a();
                this.f36301e = n.a();
                this.f36302f = j.a();
                this.f36303g = aa.a();
                this.f36304h = C1587a.a();
                this.f36305i = t.a();
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
                    this.f36298b = e.f36306a;
                    this.f36297a &= -2;
                    this.f36299c = ae.a();
                    this.f36297a &= -3;
                    this.f36300d = l.a();
                    this.f36297a &= -5;
                    this.f36301e = n.a();
                    this.f36297a &= -9;
                    this.f36302f = j.a();
                    this.f36297a &= -17;
                    this.f36303g = aa.a();
                    this.f36297a &= -33;
                    this.f36304h = C1587a.a();
                    this.f36297a &= -65;
                    this.f36305i = t.a();
                    this.f36297a &= -129;
                    return this;
                }
                return (C1592a) invokeV.objValue;
            }

            public C1592a a(C1587a c1587a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1587a)) == null) {
                    if (c1587a != null) {
                        this.f36304h = c1587a;
                        this.f36297a |= 64;
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
                        this.f36303g = aaVar;
                        this.f36297a |= 32;
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
                    if ((this.f36297a & 2) == 2 && this.f36299c != ae.a()) {
                        aeVar = ae.a(this.f36299c).mergeFrom(aeVar).buildPartial();
                    }
                    this.f36299c = aeVar;
                    this.f36297a |= 2;
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
                        this.f36297a |= 1;
                        this.f36298b = eVar;
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
                        this.f36302f = jVar;
                        this.f36297a |= 16;
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
                        this.f36300d = lVar;
                        this.f36297a |= 4;
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
                        this.f36301e = nVar;
                        this.f36297a |= 8;
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
                    if ((this.f36297a & 128) == 128 && this.f36305i != t.a()) {
                        tVar = t.a(this.f36305i).mergeFrom(tVar).buildPartial();
                    }
                    this.f36305i = tVar;
                    this.f36297a |= 128;
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
                            c parsePartialFrom = c.f36288a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    if ((this.f36297a & 64) == 64 && this.f36304h != C1587a.a()) {
                        c1587a = C1587a.a(this.f36304h).mergeFrom(c1587a).buildPartial();
                    }
                    this.f36304h = c1587a;
                    this.f36297a |= 64;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aaVar)) == null) {
                    if ((this.f36297a & 32) == 32 && this.f36303g != aa.a()) {
                        aaVar = aa.a(this.f36303g).mergeFrom(aaVar).buildPartial();
                    }
                    this.f36303g = aaVar;
                    this.f36297a |= 32;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jVar)) == null) {
                    if ((this.f36297a & 16) == 16 && this.f36302f != j.a()) {
                        jVar = j.a(this.f36302f).mergeFrom(jVar).buildPartial();
                    }
                    this.f36302f = jVar;
                    this.f36297a |= 16;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, lVar)) == null) {
                    if ((this.f36297a & 4) == 4 && this.f36300d != l.a()) {
                        lVar = l.a(this.f36300d).mergeFrom(lVar).buildPartial();
                    }
                    this.f36300d = lVar;
                    this.f36297a |= 4;
                    return this;
                }
                return (C1592a) invokeL.objValue;
            }

            public C1592a b(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, nVar)) == null) {
                    if ((this.f36297a & 8) == 8 && this.f36301e != n.a()) {
                        nVar = n.a(this.f36301e).mergeFrom(nVar).buildPartial();
                    }
                    this.f36301e = nVar;
                    this.f36297a |= 8;
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
                    int i2 = this.f36297a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f36291d = this.f36298b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f36292e = this.f36299c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f36293f = this.f36300d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.f36294g = this.f36301e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    cVar.f36295h = this.f36302f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    cVar.f36296i = this.f36303g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    cVar.j = this.f36304h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    cVar.k = this.f36305i;
                    cVar.f36290c = i3;
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
            f36288a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
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
            f36289b = cVar;
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
                                        ae.C1591a builder = (this.f36290c & 2) == 2 ? this.f36292e.toBuilder() : null;
                                        ae aeVar = (ae) codedInputStream.readMessage(ae.f36271a, extensionRegistryLite);
                                        this.f36292e = aeVar;
                                        if (builder != null) {
                                            builder.mergeFrom(aeVar);
                                            this.f36292e = builder.buildPartial();
                                        }
                                        i3 = this.f36290c;
                                    } else if (readTag == 26) {
                                        i2 = 4;
                                        l.C1596a builder2 = (this.f36290c & 4) == 4 ? this.f36293f.toBuilder() : null;
                                        l lVar = (l) codedInputStream.readMessage(l.f36362a, extensionRegistryLite);
                                        this.f36293f = lVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(lVar);
                                            this.f36293f = builder2.buildPartial();
                                        }
                                        i3 = this.f36290c;
                                    } else if (readTag == 34) {
                                        n.C1597a builder3 = (this.f36290c & 8) == 8 ? this.f36294g.toBuilder() : null;
                                        n nVar = (n) codedInputStream.readMessage(n.f36376a, extensionRegistryLite);
                                        this.f36294g = nVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(nVar);
                                            this.f36294g = builder3.buildPartial();
                                        }
                                        this.f36290c |= 8;
                                    } else if (readTag == 42) {
                                        i2 = 16;
                                        j.C1595a builder4 = (this.f36290c & 16) == 16 ? this.f36295h.toBuilder() : null;
                                        j jVar = (j) codedInputStream.readMessage(j.f36345a, extensionRegistryLite);
                                        this.f36295h = jVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(jVar);
                                            this.f36295h = builder4.buildPartial();
                                        }
                                        i3 = this.f36290c;
                                    } else if (readTag == 50) {
                                        i2 = 32;
                                        aa.C1589a builder5 = (this.f36290c & 32) == 32 ? this.f36296i.toBuilder() : null;
                                        aa aaVar = (aa) codedInputStream.readMessage(aa.f36237a, extensionRegistryLite);
                                        this.f36296i = aaVar;
                                        if (builder5 != null) {
                                            builder5.mergeFrom(aaVar);
                                            this.f36296i = builder5.buildPartial();
                                        }
                                        i3 = this.f36290c;
                                    } else if (readTag == 58) {
                                        i2 = 64;
                                        C1587a.C1588a builder6 = (this.f36290c & 64) == 64 ? this.j.toBuilder() : null;
                                        C1587a c1587a = (C1587a) codedInputStream.readMessage(C1587a.f36222a, extensionRegistryLite);
                                        this.j = c1587a;
                                        if (builder6 != null) {
                                            builder6.mergeFrom(c1587a);
                                            this.j = builder6.buildPartial();
                                        }
                                        i3 = this.f36290c;
                                    } else if (readTag == 66) {
                                        i2 = 128;
                                        t.C1600a builder7 = (this.f36290c & 128) == 128 ? this.k.toBuilder() : null;
                                        t tVar = (t) codedInputStream.readMessage(t.f36414a, extensionRegistryLite);
                                        this.k = tVar;
                                        if (builder7 != null) {
                                            builder7.mergeFrom(tVar);
                                            this.k = builder7.buildPartial();
                                        }
                                        i3 = this.f36290c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f36290c = i3 | i2;
                                } else {
                                    e a2 = e.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f36290c = 1 | this.f36290c;
                                        this.f36291d = a2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f36289b : (c) invokeV.objValue;
        }

        public static C1592a s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1592a.h() : (C1592a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f36291d = e.f36306a;
                this.f36292e = ae.a();
                this.f36293f = l.a();
                this.f36294g = n.a();
                this.f36295h = j.a();
                this.f36296i = aa.a();
                this.j = C1587a.a();
                this.k = t.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36289b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36290c & 1) == 1 : invokeV.booleanValue;
        }

        public e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36291d : (e) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36290c & 2) == 2 : invokeV.booleanValue;
        }

        public ae f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36292e : (ae) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36290c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36288a : (Parser) invokeV.objValue;
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
                int computeEnumSize = (this.f36290c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f36291d.getNumber()) : 0;
                if ((this.f36290c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f36292e);
                }
                if ((this.f36290c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f36293f);
                }
                if ((this.f36290c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f36294g);
                }
                if ((this.f36290c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f36295h);
                }
                if ((this.f36290c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f36296i);
                }
                if ((this.f36290c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
                }
                if ((this.f36290c & 128) == 128) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36293f : (l) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36290c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36294g : (n) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36290c & 16) == 16 : invokeV.booleanValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36295h : (j) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36290c & 32) == 32 : invokeV.booleanValue;
        }

        public aa n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36296i : (aa) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36290c & 64) == 64 : invokeV.booleanValue;
        }

        public C1587a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (C1587a) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f36290c & 128) == 128 : invokeV.booleanValue;
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
                if ((this.f36290c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f36291d.getNumber());
                }
                if ((this.f36290c & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.f36292e);
                }
                if ((this.f36290c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f36293f);
                }
                if ((this.f36290c & 8) == 8) {
                    codedOutputStream.writeMessage(4, this.f36294g);
                }
                if ((this.f36290c & 16) == 16) {
                    codedOutputStream.writeMessage(5, this.f36295h);
                }
                if ((this.f36290c & 32) == 32) {
                    codedOutputStream.writeMessage(6, this.f36296i);
                }
                if ((this.f36290c & 64) == 64) {
                    codedOutputStream.writeMessage(7, this.j);
                }
                if ((this.f36290c & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.k);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class e implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f36306a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f36307b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f36308c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f36309d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f36310e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f36311f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f36312g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ e[] f36313i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f36314h;

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
            f36306a = new e("UI", 0, 101);
            f36307b = new e("CRASH", 1, 201);
            f36308c = new e("DB", 2, 301);
            f36309d = new e("CONNECTION", 3, 401);
            f36310e = new e("REQUEST", 4, 501);
            f36311f = new e("ACK", 5, 601);
            e eVar = new e("MSG", 6, 701);
            f36312g = eVar;
            f36313i = new e[]{f36306a, f36307b, f36308c, f36309d, f36310e, f36311f, eVar};
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
            this.f36314h = i3;
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
                                        return f36312g;
                                    }
                                    return f36311f;
                                }
                                return f36310e;
                            }
                            return f36309d;
                        }
                        return f36308c;
                    }
                    return f36307b;
                }
                return f36306a;
            }
            return (e) invokeI.objValue;
        }

        public static e[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f36313i.clone() : (e[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36314h : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends GeneratedMessageLite implements g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f36315a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f36316b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36317c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36318d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36319e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36320f;

        /* renamed from: g  reason: collision with root package name */
        public byte f36321g;

        /* renamed from: h  reason: collision with root package name */
        public int f36322h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1593a extends GeneratedMessageLite.Builder<f, C1593a> implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36323a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36324b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36325c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36326d;

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
                this.f36324b = "";
                this.f36325c = "";
                this.f36326d = "";
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
                    this.f36324b = "";
                    int i2 = this.f36323a & (-2);
                    this.f36323a = i2;
                    this.f36325c = "";
                    int i3 = i2 & (-3);
                    this.f36323a = i3;
                    this.f36326d = "";
                    this.f36323a = i3 & (-5);
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
                        this.f36323a |= 1;
                        this.f36324b = fVar.f36318d;
                    }
                    if (fVar.e()) {
                        this.f36323a |= 2;
                        this.f36325c = fVar.f36319e;
                    }
                    if (fVar.g()) {
                        this.f36323a |= 4;
                        this.f36326d = fVar.f36320f;
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
                            f parsePartialFrom = f.f36315a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36323a |= 1;
                        this.f36324b = str;
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
                        this.f36323a |= 2;
                        this.f36325c = str;
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
                        this.f36323a |= 4;
                        this.f36326d = str;
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
                    int i2 = this.f36323a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    fVar.f36318d = this.f36324b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    fVar.f36319e = this.f36325c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    fVar.f36320f = this.f36326d;
                    fVar.f36317c = i3;
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
            f36315a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
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
            f36316b = fVar;
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
            this.f36321g = (byte) -1;
            this.f36322h = -1;
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
            this.f36321g = (byte) -1;
            this.f36322h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f36317c |= 1;
                                this.f36318d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f36317c |= 2;
                                this.f36319e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f36317c |= 4;
                                this.f36320f = codedInputStream.readBytes();
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
            this.f36321g = (byte) -1;
            this.f36322h = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f36316b : (f) invokeV.objValue;
        }

        public static C1593a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1593a.h() : (C1593a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f36318d = "";
                this.f36319e = "";
                this.f36320f = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36316b : (f) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36317c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36318d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36318d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36317c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36319e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36319e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36317c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36315a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f36322h;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f36317c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36317c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36317c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f36322h = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f36320f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36320f = copyFromUtf8;
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
                byte b2 = this.f36321g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f36321g = (byte) 1;
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
                if ((this.f36317c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36317c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36317c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class h extends GeneratedMessageLite implements i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<h> f36327a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f36328b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36329c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36330d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36331e;

        /* renamed from: f  reason: collision with root package name */
        public p f36332f;

        /* renamed from: g  reason: collision with root package name */
        public long f36333g;

        /* renamed from: h  reason: collision with root package name */
        public long f36334h;

        /* renamed from: i  reason: collision with root package name */
        public ac f36335i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1594a extends GeneratedMessageLite.Builder<h, C1594a> implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36336a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36337b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36338c;

            /* renamed from: d  reason: collision with root package name */
            public p f36339d;

            /* renamed from: e  reason: collision with root package name */
            public long f36340e;

            /* renamed from: f  reason: collision with root package name */
            public long f36341f;

            /* renamed from: g  reason: collision with root package name */
            public ac f36342g;

            /* renamed from: h  reason: collision with root package name */
            public f f36343h;

            /* renamed from: i  reason: collision with root package name */
            public v f36344i;

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
                this.f36337b = "";
                this.f36338c = "";
                this.f36339d = p.a();
                this.f36342g = ac.a();
                this.f36343h = f.a();
                this.f36344i = v.a();
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
                    this.f36337b = "";
                    int i2 = this.f36336a & (-2);
                    this.f36336a = i2;
                    this.f36338c = "";
                    this.f36336a = i2 & (-3);
                    this.f36339d = p.a();
                    int i3 = this.f36336a & (-5);
                    this.f36336a = i3;
                    this.f36340e = 0L;
                    int i4 = i3 & (-9);
                    this.f36336a = i4;
                    this.f36341f = 0L;
                    this.f36336a = i4 & (-17);
                    this.f36342g = ac.a();
                    this.f36336a &= -33;
                    this.f36343h = f.a();
                    this.f36336a &= -65;
                    this.f36344i = v.a();
                    this.f36336a &= -129;
                    return this;
                }
                return (C1594a) invokeV.objValue;
            }

            public C1594a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36336a |= 8;
                    this.f36340e = j;
                    return this;
                }
                return (C1594a) invokeJ.objValue;
            }

            public C1594a a(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acVar)) == null) {
                    if (acVar != null) {
                        this.f36342g = acVar;
                        this.f36336a |= 32;
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
                        this.f36343h = fVar;
                        this.f36336a |= 64;
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
                        this.f36336a |= 1;
                        this.f36337b = hVar.f36330d;
                    }
                    if (hVar.e()) {
                        this.f36336a |= 2;
                        this.f36338c = hVar.f36331e;
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
                        this.f36339d = pVar;
                        this.f36336a |= 4;
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
                        this.f36344i = vVar;
                        this.f36336a |= 128;
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
                            h parsePartialFrom = h.f36327a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C1594a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                    this.f36336a |= 16;
                    this.f36341f = j;
                    return this;
                }
                return (C1594a) invokeJ.objValue;
            }

            public C1594a b(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, acVar)) == null) {
                    if ((this.f36336a & 32) == 32 && this.f36342g != ac.a()) {
                        acVar = ac.a(this.f36342g).mergeFrom(acVar).buildPartial();
                    }
                    this.f36342g = acVar;
                    this.f36336a |= 32;
                    return this;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a b(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
                    if ((this.f36336a & 64) == 64 && this.f36343h != f.a()) {
                        fVar = f.a(this.f36343h).mergeFrom(fVar).buildPartial();
                    }
                    this.f36343h = fVar;
                    this.f36336a |= 64;
                    return this;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a b(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pVar)) == null) {
                    if ((this.f36336a & 4) == 4 && this.f36339d != p.a()) {
                        pVar = p.a(this.f36339d).mergeFrom(pVar).buildPartial();
                    }
                    this.f36339d = pVar;
                    this.f36336a |= 4;
                    return this;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a b(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vVar)) == null) {
                    if ((this.f36336a & 128) == 128 && this.f36344i != v.a()) {
                        vVar = v.a(this.f36344i).mergeFrom(vVar).buildPartial();
                    }
                    this.f36344i = vVar;
                    this.f36336a |= 128;
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
                    int i2 = this.f36336a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    hVar.f36330d = this.f36337b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    hVar.f36331e = this.f36338c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    hVar.f36332f = this.f36339d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    hVar.f36333g = this.f36340e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    hVar.f36334h = this.f36341f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    hVar.f36335i = this.f36342g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    hVar.j = this.f36343h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    hVar.k = this.f36344i;
                    hVar.f36329c = i3;
                    return hVar;
                }
                return (h) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.f36336a & 4) == 4 : invokeV.booleanValue;
            }

            public p g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f36339d : (p) invokeV.objValue;
            }

            public boolean h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f36336a & 8) == 8 : invokeV.booleanValue;
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
            f36327a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
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
            f36328b = hVar;
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
                                    this.f36329c |= 1;
                                    this.f36330d = codedInputStream.readBytes();
                                } else if (readTag != 18) {
                                    if (readTag == 58) {
                                        i2 = 4;
                                        p.C1598a builder = (this.f36329c & 4) == 4 ? this.f36332f.toBuilder() : null;
                                        p pVar = (p) codedInputStream.readMessage(p.f36394a, extensionRegistryLite);
                                        this.f36332f = pVar;
                                        if (builder != null) {
                                            builder.mergeFrom(pVar);
                                            this.f36332f = builder.buildPartial();
                                        }
                                        i3 = this.f36329c;
                                    } else if (readTag == 80) {
                                        this.f36329c |= 8;
                                        this.f36333g = codedInputStream.readInt64();
                                    } else if (readTag == 96) {
                                        this.f36329c |= 16;
                                        this.f36334h = codedInputStream.readInt64();
                                    } else if (readTag == 162) {
                                        i2 = 32;
                                        ac.C1590a builder2 = (this.f36329c & 32) == 32 ? this.f36335i.toBuilder() : null;
                                        ac acVar = (ac) codedInputStream.readMessage(ac.f36254a, extensionRegistryLite);
                                        this.f36335i = acVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(acVar);
                                            this.f36335i = builder2.buildPartial();
                                        }
                                        i3 = this.f36329c;
                                    } else if (readTag == 170) {
                                        i2 = 64;
                                        f.C1593a builder3 = (this.f36329c & 64) == 64 ? this.j.toBuilder() : null;
                                        f fVar = (f) codedInputStream.readMessage(f.f36315a, extensionRegistryLite);
                                        this.j = fVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(fVar);
                                            this.j = builder3.buildPartial();
                                        }
                                        i3 = this.f36329c;
                                    } else if (readTag == 178) {
                                        i2 = 128;
                                        v.C1601a builder4 = (this.f36329c & 128) == 128 ? this.k.toBuilder() : null;
                                        v vVar = (v) codedInputStream.readMessage(v.f36431a, extensionRegistryLite);
                                        this.k = vVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(vVar);
                                            this.k = builder4.buildPartial();
                                        }
                                        i3 = this.f36329c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f36329c = i3 | i2;
                                } else {
                                    this.f36329c |= 2;
                                    this.f36331e = codedInputStream.readBytes();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f36328b : (h) invokeV.objValue;
        }

        public static C1594a t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1594a.k() : (C1594a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f36330d = "";
                this.f36331e = "";
                this.f36332f = p.a();
                this.f36333g = 0L;
                this.f36334h = 0L;
                this.f36335i = ac.a();
                this.j = f.a();
                this.k = v.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36328b : (h) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36329c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36330d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36330d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36329c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36331e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36331e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36329c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36327a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f36329c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36329c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36329c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f36332f);
                }
                if ((this.f36329c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f36333g);
                }
                if ((this.f36329c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f36334h);
                }
                if ((this.f36329c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f36335i);
                }
                if ((this.f36329c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
                }
                if ((this.f36329c & 128) == 128) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36332f : (p) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36329c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36333g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36329c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36334h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36329c & 32) == 32 : invokeV.booleanValue;
        }

        public ac n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36335i : (ac) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36329c & 64) == 64 : invokeV.booleanValue;
        }

        public f p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (f) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f36329c & 128) == 128 : invokeV.booleanValue;
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
                if ((this.f36329c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36329c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36329c & 4) == 4) {
                    codedOutputStream.writeMessage(7, this.f36332f);
                }
                if ((this.f36329c & 8) == 8) {
                    codedOutputStream.writeInt64(10, this.f36333g);
                }
                if ((this.f36329c & 16) == 16) {
                    codedOutputStream.writeInt64(12, this.f36334h);
                }
                if ((this.f36329c & 32) == 32) {
                    codedOutputStream.writeMessage(20, this.f36335i);
                }
                if ((this.f36329c & 64) == 64) {
                    codedOutputStream.writeMessage(21, this.j);
                }
                if ((this.f36329c & 128) == 128) {
                    codedOutputStream.writeMessage(22, this.k);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class j extends GeneratedMessageLite implements k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<j> f36345a;

        /* renamed from: b  reason: collision with root package name */
        public static final j f36346b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36347c;

        /* renamed from: d  reason: collision with root package name */
        public long f36348d;

        /* renamed from: e  reason: collision with root package name */
        public long f36349e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36350f;

        /* renamed from: g  reason: collision with root package name */
        public long f36351g;

        /* renamed from: h  reason: collision with root package name */
        public long f36352h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36353i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1595a extends GeneratedMessageLite.Builder<j, C1595a> implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36354a;

            /* renamed from: b  reason: collision with root package name */
            public long f36355b;

            /* renamed from: c  reason: collision with root package name */
            public long f36356c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36357d;

            /* renamed from: e  reason: collision with root package name */
            public long f36358e;

            /* renamed from: f  reason: collision with root package name */
            public long f36359f;

            /* renamed from: g  reason: collision with root package name */
            public Object f36360g;

            /* renamed from: h  reason: collision with root package name */
            public long f36361h;

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
                this.f36357d = "";
                this.f36360g = "";
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
                    this.f36355b = 0L;
                    int i2 = this.f36354a & (-2);
                    this.f36354a = i2;
                    this.f36356c = 0L;
                    int i3 = i2 & (-3);
                    this.f36354a = i3;
                    this.f36357d = "";
                    int i4 = i3 & (-5);
                    this.f36354a = i4;
                    this.f36358e = 0L;
                    int i5 = i4 & (-9);
                    this.f36354a = i5;
                    this.f36359f = 0L;
                    int i6 = i5 & (-17);
                    this.f36354a = i6;
                    this.f36360g = "";
                    int i7 = i6 & (-33);
                    this.f36354a = i7;
                    this.f36361h = 0L;
                    this.f36354a = i7 & (-65);
                    return this;
                }
                return (C1595a) invokeV.objValue;
            }

            public C1595a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36354a |= 1;
                    this.f36355b = j;
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
                        this.f36354a |= 4;
                        this.f36357d = jVar.f36350f;
                    }
                    if (jVar.i()) {
                        c(jVar.j());
                    }
                    if (jVar.k()) {
                        d(jVar.l());
                    }
                    if (jVar.m()) {
                        this.f36354a |= 32;
                        this.f36360g = jVar.f36353i;
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
                            j parsePartialFrom = j.f36345a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36354a |= 4;
                        this.f36357d = str;
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

            public C1595a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                    this.f36354a |= 2;
                    this.f36356c = j;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            public C1595a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f36354a |= 32;
                        this.f36360g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1595a) invokeL.objValue;
            }

            public C1595a c(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                    this.f36354a |= 8;
                    this.f36358e = j;
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

            public C1595a d(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
                    this.f36354a |= 16;
                    this.f36359f = j;
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

            public C1595a e(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
                    this.f36354a |= 64;
                    this.f36361h = j;
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
                    int i2 = this.f36354a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    jVar.f36348d = this.f36355b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    jVar.f36349e = this.f36356c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    jVar.f36350f = this.f36357d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    jVar.f36351g = this.f36358e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    jVar.f36352h = this.f36359f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    jVar.f36353i = this.f36360g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    jVar.j = this.f36361h;
                    jVar.f36347c = i3;
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
            f36345a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
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
            f36346b = jVar;
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
                                this.f36347c |= 1;
                                this.f36348d = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.f36347c |= 2;
                                this.f36349e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f36347c |= 4;
                                this.f36350f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f36347c |= 8;
                                this.f36351g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f36347c |= 16;
                                this.f36352h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f36347c |= 32;
                                this.f36353i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f36347c |= 64;
                                this.j = codedInputStream.readInt64();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36346b : (j) invokeV.objValue;
        }

        public static C1595a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1595a.h() : (C1595a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f36348d = 0L;
                this.f36349e = 0L;
                this.f36350f = "";
                this.f36351g = 0L;
                this.f36352h = 0L;
                this.f36353i = "";
                this.j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36346b : (j) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36347c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36348d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36347c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36349e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36347c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36345a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f36347c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f36348d) : 0;
                if ((this.f36347c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f36349e);
                }
                if ((this.f36347c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f36347c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f36351g);
                }
                if ((this.f36347c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f36352h);
                }
                if ((this.f36347c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f36347c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
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
                Object obj = this.f36350f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36350f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36347c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36351g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36347c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36352h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36347c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f36353i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36353i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36347c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.longValue;
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
                if ((this.f36347c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f36348d);
                }
                if ((this.f36347c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f36349e);
                }
                if ((this.f36347c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f36347c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f36351g);
                }
                if ((this.f36347c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f36352h);
                }
                if ((this.f36347c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f36347c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.j);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class l extends GeneratedMessageLite implements m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<l> f36362a;

        /* renamed from: b  reason: collision with root package name */
        public static final l f36363b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36364c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36365d;

        /* renamed from: e  reason: collision with root package name */
        public long f36366e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36367f;

        /* renamed from: g  reason: collision with root package name */
        public long f36368g;

        /* renamed from: h  reason: collision with root package name */
        public byte f36369h;

        /* renamed from: i  reason: collision with root package name */
        public int f36370i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1596a extends GeneratedMessageLite.Builder<l, C1596a> implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36371a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36372b;

            /* renamed from: c  reason: collision with root package name */
            public long f36373c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36374d;

            /* renamed from: e  reason: collision with root package name */
            public long f36375e;

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
                this.f36372b = "";
                this.f36374d = "";
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
                    this.f36372b = "";
                    int i2 = this.f36371a & (-2);
                    this.f36371a = i2;
                    this.f36373c = 0L;
                    int i3 = i2 & (-3);
                    this.f36371a = i3;
                    this.f36374d = "";
                    int i4 = i3 & (-5);
                    this.f36371a = i4;
                    this.f36375e = 0L;
                    this.f36371a = i4 & (-9);
                    return this;
                }
                return (C1596a) invokeV.objValue;
            }

            public C1596a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36371a |= 2;
                    this.f36373c = j;
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
                        this.f36371a |= 1;
                        this.f36372b = lVar.f36365d;
                    }
                    if (lVar.e()) {
                        a(lVar.f());
                    }
                    if (lVar.g()) {
                        this.f36371a |= 4;
                        this.f36374d = lVar.f36367f;
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
                            l parsePartialFrom = l.f36362a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36371a |= 1;
                        this.f36372b = str;
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

            public C1596a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                    this.f36371a |= 8;
                    this.f36375e = j;
                    return this;
                }
                return (C1596a) invokeJ.objValue;
            }

            public C1596a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f36371a |= 4;
                        this.f36374d = str;
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
                    int i2 = this.f36371a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    lVar.f36365d = this.f36372b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    lVar.f36366e = this.f36373c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    lVar.f36367f = this.f36374d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    lVar.f36368g = this.f36375e;
                    lVar.f36364c = i3;
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
            f36362a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
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
            f36363b = lVar;
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
            this.f36369h = (byte) -1;
            this.f36370i = -1;
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
            this.f36369h = (byte) -1;
            this.f36370i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f36364c |= 1;
                                this.f36365d = codedInputStream.readBytes();
                            } else if (readTag == 16) {
                                this.f36364c |= 2;
                                this.f36366e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f36364c |= 4;
                                this.f36367f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f36364c |= 8;
                                this.f36368g = codedInputStream.readInt64();
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
            this.f36369h = (byte) -1;
            this.f36370i = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36363b : (l) invokeV.objValue;
        }

        public static C1596a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1596a.h() : (C1596a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f36365d = "";
                this.f36366e = 0L;
                this.f36367f = "";
                this.f36368g = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36363b : (l) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36364c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36365d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36365d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36364c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36366e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36364c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36362a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f36370i;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f36364c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36364c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f36366e);
                }
                if ((this.f36364c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f36364c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f36368g);
                }
                this.f36370i = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f36367f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36367f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36364c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f36369h;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f36369h = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36368g : invokeV.longValue;
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
                if ((this.f36364c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36364c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f36366e);
                }
                if ((this.f36364c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f36364c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f36368g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class n extends GeneratedMessageLite implements o {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f36376a;

        /* renamed from: b  reason: collision with root package name */
        public static final n f36377b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36378c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36379d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36380e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36381f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36382g;

        /* renamed from: h  reason: collision with root package name */
        public long f36383h;

        /* renamed from: i  reason: collision with root package name */
        public long f36384i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1597a extends GeneratedMessageLite.Builder<n, C1597a> implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36385a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36386b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36387c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36388d;

            /* renamed from: e  reason: collision with root package name */
            public Object f36389e;

            /* renamed from: f  reason: collision with root package name */
            public long f36390f;

            /* renamed from: g  reason: collision with root package name */
            public long f36391g;

            /* renamed from: h  reason: collision with root package name */
            public long f36392h;

            /* renamed from: i  reason: collision with root package name */
            public Object f36393i;
            public long j;

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
                this.f36386b = "";
                this.f36387c = "";
                this.f36388d = "";
                this.f36389e = "";
                this.f36393i = "";
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
                    this.f36386b = "";
                    int i2 = this.f36385a & (-2);
                    this.f36385a = i2;
                    this.f36387c = "";
                    int i3 = i2 & (-3);
                    this.f36385a = i3;
                    this.f36388d = "";
                    int i4 = i3 & (-5);
                    this.f36385a = i4;
                    this.f36389e = "";
                    int i5 = i4 & (-9);
                    this.f36385a = i5;
                    this.f36390f = 0L;
                    int i6 = i5 & (-17);
                    this.f36385a = i6;
                    this.f36391g = 0L;
                    int i7 = i6 & (-33);
                    this.f36385a = i7;
                    this.f36392h = 0L;
                    int i8 = i7 & (-65);
                    this.f36385a = i8;
                    this.f36393i = "";
                    int i9 = i8 & (-129);
                    this.f36385a = i9;
                    this.j = 0L;
                    this.f36385a = i9 & (-257);
                    return this;
                }
                return (C1597a) invokeV.objValue;
            }

            public C1597a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36385a |= 16;
                    this.f36390f = j;
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
                        this.f36385a |= 1;
                        this.f36386b = nVar.f36379d;
                    }
                    if (nVar.e()) {
                        this.f36385a |= 2;
                        this.f36387c = nVar.f36380e;
                    }
                    if (nVar.g()) {
                        this.f36385a |= 4;
                        this.f36388d = nVar.f36381f;
                    }
                    if (nVar.i()) {
                        this.f36385a |= 8;
                        this.f36389e = nVar.f36382g;
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
                        this.f36385a |= 128;
                        this.f36393i = nVar.k;
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
                            n parsePartialFrom = n.f36376a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36385a |= 1;
                        this.f36386b = str;
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

            public C1597a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                    this.f36385a |= 32;
                    this.f36391g = j;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f36385a |= 2;
                        this.f36387c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1597a) invokeL.objValue;
            }

            public C1597a c(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                    this.f36385a |= 64;
                    this.f36392h = j;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.f36385a |= 4;
                        this.f36388d = str;
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

            public C1597a d(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
                    this.f36385a |= 256;
                    this.j = j;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                    if (str != null) {
                        this.f36385a |= 8;
                        this.f36389e = str;
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
                        this.f36385a |= 128;
                        this.f36393i = str;
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
                    int i2 = this.f36385a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    nVar.f36379d = this.f36386b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    nVar.f36380e = this.f36387c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    nVar.f36381f = this.f36388d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    nVar.f36382g = this.f36389e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    nVar.f36383h = this.f36390f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    nVar.f36384i = this.f36391g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    nVar.j = this.f36392h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    nVar.k = this.f36393i;
                    if ((i2 & 256) == 256) {
                        i3 |= 256;
                    }
                    nVar.l = this.j;
                    nVar.f36378c = i3;
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
            f36376a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
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
            f36377b = nVar;
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
                                    this.f36378c |= 1;
                                    this.f36379d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f36378c |= 2;
                                    this.f36380e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f36378c |= 4;
                                    this.f36381f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f36378c |= 8;
                                    this.f36382g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f36378c |= 16;
                                    this.f36383h = codedInputStream.readInt64();
                                } else if (readTag == 48) {
                                    this.f36378c |= 32;
                                    this.f36384i = codedInputStream.readInt64();
                                } else if (readTag == 56) {
                                    this.f36378c |= 64;
                                    this.j = codedInputStream.readInt64();
                                } else if (readTag == 66) {
                                    this.f36378c |= 128;
                                    this.k = codedInputStream.readBytes();
                                } else if (readTag == 72) {
                                    this.f36378c |= 256;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36377b : (n) invokeV.objValue;
        }

        public static C1597a u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? C1597a.h() : (C1597a) invokeV.objValue;
        }

        private void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65560, this) == null) {
                this.f36379d = "";
                this.f36380e = "";
                this.f36381f = "";
                this.f36382g = "";
                this.f36383h = 0L;
                this.f36384i = 0L;
                this.j = 0L;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36377b : (n) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36378c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36379d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36379d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36378c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36380e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36380e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36378c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36376a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f36378c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36378c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36378c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f36378c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f36378c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f36383h);
                }
                if ((this.f36378c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f36384i);
                }
                if ((this.f36378c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
                }
                if ((this.f36378c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
                }
                if ((this.f36378c & 256) == 256) {
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
                Object obj = this.f36381f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36381f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36378c & 8) == 8 : invokeV.booleanValue;
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
                Object obj = this.f36382g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36382g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36378c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36383h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36378c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36384i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36378c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.longValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f36378c & 128) == 128 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.f36378c & 256) == 256 : invokeV.booleanValue;
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
                if ((this.f36378c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36378c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36378c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f36378c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f36378c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f36383h);
                }
                if ((this.f36378c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f36384i);
                }
                if ((this.f36378c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.j);
                }
                if ((this.f36378c & 128) == 128) {
                    codedOutputStream.writeBytes(8, r());
                }
                if ((this.f36378c & 256) == 256) {
                    codedOutputStream.writeInt64(9, this.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class p extends GeneratedMessageLite implements q {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<p> f36394a;

        /* renamed from: b  reason: collision with root package name */
        public static final p f36395b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36396c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36397d;

        /* renamed from: e  reason: collision with root package name */
        public byte f36398e;

        /* renamed from: f  reason: collision with root package name */
        public int f36399f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1598a extends GeneratedMessageLite.Builder<p, C1598a> implements q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36400a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36401b;

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
                this.f36401b = "";
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
                    this.f36401b = "";
                    this.f36400a &= -2;
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
                        this.f36400a |= 1;
                        this.f36401b = pVar.f36397d;
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
                            p parsePartialFrom = p.f36394a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36400a |= 1;
                        this.f36401b = str;
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
                    int i2 = (this.f36400a & 1) != 1 ? 0 : 1;
                    pVar.f36397d = this.f36401b;
                    pVar.f36396c = i2;
                    return pVar;
                }
                return (p) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.f36400a & 1) == 1 : invokeV.booleanValue;
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
            f36394a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
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
            f36395b = pVar;
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
            this.f36398e = (byte) -1;
            this.f36399f = -1;
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
            this.f36398e = (byte) -1;
            this.f36399f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 34) {
                                    this.f36396c |= 1;
                                    this.f36397d = codedInputStream.readBytes();
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
            this.f36398e = (byte) -1;
            this.f36399f = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f36395b : (p) invokeV.objValue;
        }

        public static C1598a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1598a.i() : (C1598a) invokeV.objValue;
        }

        private void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.f36397d = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36395b : (p) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36396c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36397d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36397d = copyFromUtf8;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f36394a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f36399f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f36396c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
                this.f36399f = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                byte b2 = this.f36398e;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (c()) {
                    this.f36398e = (byte) 1;
                    return true;
                } else {
                    this.f36398e = (byte) 0;
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
                if ((this.f36396c & 1) == 1) {
                    codedOutputStream.writeBytes(4, d());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class r extends GeneratedMessageLite implements s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<r> f36402a;

        /* renamed from: b  reason: collision with root package name */
        public static final r f36403b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36404c;

        /* renamed from: d  reason: collision with root package name */
        public int f36405d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36406e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36407f;

        /* renamed from: g  reason: collision with root package name */
        public byte f36408g;

        /* renamed from: h  reason: collision with root package name */
        public int f36409h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1599a extends GeneratedMessageLite.Builder<r, C1599a> implements s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36410a;

            /* renamed from: b  reason: collision with root package name */
            public int f36411b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36412c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36413d;

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
                this.f36411b = 7399;
                this.f36412c = "push_im_client";
                this.f36413d = "phonebaidu";
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
                    this.f36411b = 7399;
                    int i2 = this.f36410a & (-2);
                    this.f36410a = i2;
                    this.f36412c = "push_im_client";
                    int i3 = i2 & (-3);
                    this.f36410a = i3;
                    this.f36413d = "phonebaidu";
                    this.f36410a = i3 & (-5);
                    return this;
                }
                return (C1599a) invokeV.objValue;
            }

            public C1599a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f36410a |= 1;
                    this.f36411b = i2;
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
                        this.f36410a |= 2;
                        this.f36412c = rVar.f36406e;
                    }
                    if (rVar.g()) {
                        this.f36410a |= 4;
                        this.f36413d = rVar.f36407f;
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
                            r parsePartialFrom = r.f36402a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    int i2 = this.f36410a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    rVar.f36405d = this.f36411b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    rVar.f36406e = this.f36412c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    rVar.f36407f = this.f36413d;
                    rVar.f36404c = i3;
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
            f36402a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
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
            f36403b = rVar;
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
            this.f36408g = (byte) -1;
            this.f36409h = -1;
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
            this.f36408g = (byte) -1;
            this.f36409h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f36404c |= 1;
                                this.f36405d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f36404c |= 2;
                                this.f36406e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f36404c |= 4;
                                this.f36407f = codedInputStream.readBytes();
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
            this.f36408g = (byte) -1;
            this.f36409h = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f36403b : (r) invokeV.objValue;
        }

        public static C1599a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1599a.h() : (C1599a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f36405d = 7399;
                this.f36406e = "push_im_client";
                this.f36407f = "phonebaidu";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36403b : (r) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36404c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36405d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36404c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36406e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36406e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36404c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36402a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f36409h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f36404c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f36405d) : 0;
                if ((this.f36404c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36404c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f36409h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f36407f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36407f = copyFromUtf8;
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
                byte b2 = this.f36408g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f36408g = (byte) 1;
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
                if ((this.f36404c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f36405d);
                }
                if ((this.f36404c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36404c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class t extends GeneratedMessageLite implements u {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<t> f36414a;

        /* renamed from: b  reason: collision with root package name */
        public static final t f36415b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36416c;

        /* renamed from: d  reason: collision with root package name */
        public long f36417d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36418e;

        /* renamed from: f  reason: collision with root package name */
        public long f36419f;

        /* renamed from: g  reason: collision with root package name */
        public long f36420g;

        /* renamed from: h  reason: collision with root package name */
        public Object f36421h;

        /* renamed from: i  reason: collision with root package name */
        public long f36422i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1600a extends GeneratedMessageLite.Builder<t, C1600a> implements u {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36423a;

            /* renamed from: b  reason: collision with root package name */
            public long f36424b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36425c;

            /* renamed from: d  reason: collision with root package name */
            public long f36426d;

            /* renamed from: e  reason: collision with root package name */
            public long f36427e;

            /* renamed from: f  reason: collision with root package name */
            public Object f36428f;

            /* renamed from: g  reason: collision with root package name */
            public long f36429g;

            /* renamed from: h  reason: collision with root package name */
            public long f36430h;

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
                this.f36425c = "";
                this.f36428f = "";
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
                    this.f36424b = 0L;
                    int i2 = this.f36423a & (-2);
                    this.f36423a = i2;
                    this.f36425c = "";
                    int i3 = i2 & (-3);
                    this.f36423a = i3;
                    this.f36426d = 0L;
                    int i4 = i3 & (-5);
                    this.f36423a = i4;
                    this.f36427e = 0L;
                    int i5 = i4 & (-9);
                    this.f36423a = i5;
                    this.f36428f = "";
                    int i6 = i5 & (-17);
                    this.f36423a = i6;
                    this.f36429g = 0L;
                    int i7 = i6 & (-33);
                    this.f36423a = i7;
                    this.f36430h = 0L;
                    this.f36423a = i7 & (-65);
                    return this;
                }
                return (C1600a) invokeV.objValue;
            }

            public C1600a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36423a |= 1;
                    this.f36424b = j;
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
                        this.f36423a |= 2;
                        this.f36425c = tVar.f36418e;
                    }
                    if (tVar.g()) {
                        b(tVar.h());
                    }
                    if (tVar.i()) {
                        c(tVar.j());
                    }
                    if (tVar.k()) {
                        this.f36423a |= 16;
                        this.f36428f = tVar.f36421h;
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
                            t parsePartialFrom = t.f36414a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C1600a b(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                    this.f36423a |= 4;
                    this.f36426d = j;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            public C1600a c(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                    this.f36423a |= 8;
                    this.f36427e = j;
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

            public C1600a d(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
                    this.f36423a |= 32;
                    this.f36429g = j;
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

            public C1600a e(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
                    this.f36423a |= 64;
                    this.f36430h = j;
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
                    int i2 = this.f36423a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    tVar.f36417d = this.f36424b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    tVar.f36418e = this.f36425c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    tVar.f36419f = this.f36426d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    tVar.f36420g = this.f36427e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    tVar.f36421h = this.f36428f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    tVar.f36422i = this.f36429g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    tVar.j = this.f36430h;
                    tVar.f36416c = i3;
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
            f36414a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
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
            f36415b = tVar;
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
                                this.f36416c |= 1;
                                this.f36417d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f36416c |= 2;
                                this.f36418e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f36416c |= 4;
                                this.f36419f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f36416c |= 8;
                                this.f36420g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f36416c |= 16;
                                this.f36421h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f36416c |= 32;
                                this.f36422i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f36416c |= 64;
                                this.j = codedInputStream.readInt64();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f36415b : (t) invokeV.objValue;
        }

        public static C1600a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1600a.h() : (C1600a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f36417d = 0L;
                this.f36418e = "";
                this.f36419f = 0L;
                this.f36420g = 0L;
                this.f36421h = "";
                this.f36422i = 0L;
                this.j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36415b : (t) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36416c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36417d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36416c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36418e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36418e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36416c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36414a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f36416c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f36417d) : 0;
                if ((this.f36416c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f36416c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f36419f);
                }
                if ((this.f36416c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f36420g);
                }
                if ((this.f36416c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f36416c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f36422i);
                }
                if ((this.f36416c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36419f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36416c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36420g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f36416c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f36421h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36421h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f36416c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36422i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f36416c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.longValue;
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
                if ((this.f36416c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f36417d);
                }
                if ((this.f36416c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f36416c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f36419f);
                }
                if ((this.f36416c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f36420g);
                }
                if ((this.f36416c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f36416c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f36422i);
                }
                if ((this.f36416c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.j);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes6.dex */
    public static final class v extends GeneratedMessageLite implements w {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<v> f36431a;

        /* renamed from: b  reason: collision with root package name */
        public static final v f36432b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36433c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36434d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36435e;

        /* renamed from: f  reason: collision with root package name */
        public byte f36436f;

        /* renamed from: g  reason: collision with root package name */
        public int f36437g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1601a extends GeneratedMessageLite.Builder<v, C1601a> implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36438a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36439b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36440c;

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
                this.f36439b = "";
                this.f36440c = "";
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
                    this.f36439b = "";
                    int i2 = this.f36438a & (-2);
                    this.f36438a = i2;
                    this.f36440c = "";
                    this.f36438a = i2 & (-3);
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
                        this.f36438a |= 1;
                        this.f36439b = vVar.f36434d;
                    }
                    if (vVar.e()) {
                        this.f36438a |= 2;
                        this.f36440c = vVar.f36435e;
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
                            v parsePartialFrom = v.f36431a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f36438a |= 1;
                        this.f36439b = str;
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
                        this.f36438a |= 2;
                        this.f36440c = str;
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
                    int i2 = this.f36438a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    vVar.f36434d = this.f36439b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    vVar.f36435e = this.f36440c;
                    vVar.f36433c = i3;
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
            f36431a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
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
            f36432b = vVar;
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
            this.f36436f = (byte) -1;
            this.f36437g = -1;
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
            this.f36436f = (byte) -1;
            this.f36437g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f36433c |= 1;
                                    this.f36434d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f36433c |= 2;
                                    this.f36435e = codedInputStream.readBytes();
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
            this.f36436f = (byte) -1;
            this.f36437g = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f36432b : (v) invokeV.objValue;
        }

        public static C1601a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? C1601a.h() : (C1601a) invokeV.objValue;
        }

        private void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.f36434d = "";
                this.f36435e = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36432b : (v) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36433c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f36434d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36434d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36433c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f36435e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36435e = copyFromUtf8;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f36431a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f36437g;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f36433c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f36433c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                this.f36437g = computeBytesSize;
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
                byte b2 = this.f36436f;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f36436f = (byte) 1;
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
                if ((this.f36433c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f36433c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class x implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final x f36441a;

        /* renamed from: b  reason: collision with root package name */
        public static final x f36442b;

        /* renamed from: c  reason: collision with root package name */
        public static final x f36443c;

        /* renamed from: d  reason: collision with root package name */
        public static final x f36444d;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ x[] f36445f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f36446e;

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
            f36441a = new x("OS_TYPE_UNKNWON", 0, 0);
            f36442b = new x("IOS", 1, 1);
            f36443c = new x("ANDROID", 2, 2);
            x xVar = new x("WINDOWSPHONE", 3, 3);
            f36444d = xVar;
            f36445f = new x[]{f36441a, f36442b, f36443c, xVar};
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
            this.f36446e = i3;
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
                            return f36444d;
                        }
                        return f36443c;
                    }
                    return f36442b;
                }
                return f36441a;
            }
            return (x) invokeI.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36446e : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class y extends GeneratedMessageLite implements z {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f36447a;

        /* renamed from: b  reason: collision with root package name */
        public static final y f36448b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f36449c;

        /* renamed from: d  reason: collision with root package name */
        public r f36450d;

        /* renamed from: e  reason: collision with root package name */
        public h f36451e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36452f;

        /* renamed from: g  reason: collision with root package name */
        public long f36453g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f36454h;

        /* renamed from: i  reason: collision with root package name */
        public byte f36455i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1602a extends GeneratedMessageLite.Builder<y, C1602a> implements z {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f36456a;

            /* renamed from: b  reason: collision with root package name */
            public r f36457b;

            /* renamed from: c  reason: collision with root package name */
            public h f36458c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36459d;

            /* renamed from: e  reason: collision with root package name */
            public long f36460e;

            /* renamed from: f  reason: collision with root package name */
            public List<c> f36461f;

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
                this.f36457b = r.a();
                this.f36458c = h.a();
                this.f36459d = "";
                this.f36461f = Collections.emptyList();
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
                if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (this.f36456a & 16) == 16) {
                    return;
                }
                this.f36461f = new ArrayList(this.f36461f);
                this.f36456a |= 16;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1602a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f36457b = r.a();
                    this.f36456a &= -2;
                    this.f36458c = h.a();
                    int i2 = this.f36456a & (-3);
                    this.f36456a = i2;
                    this.f36459d = "";
                    int i3 = i2 & (-5);
                    this.f36456a = i3;
                    this.f36460e = 0L;
                    this.f36456a = i3 & (-9);
                    this.f36461f = Collections.emptyList();
                    this.f36456a &= -17;
                    return this;
                }
                return (C1602a) invokeV.objValue;
            }

            public C1602a a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                    this.f36456a |= 8;
                    this.f36460e = j;
                    return this;
                }
                return (C1602a) invokeJ.objValue;
            }

            public C1602a a(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
                    if (hVar != null) {
                        this.f36458c = hVar;
                        this.f36456a |= 2;
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
                    if ((this.f36456a & 1) == 1 && this.f36457b != r.a()) {
                        rVar = r.a(this.f36457b).mergeFrom(rVar).buildPartial();
                    }
                    this.f36457b = rVar;
                    this.f36456a |= 1;
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
                        this.f36456a |= 4;
                        this.f36459d = yVar.f36452f;
                    }
                    if (yVar.i()) {
                        a(yVar.j());
                    }
                    if (!yVar.f36454h.isEmpty()) {
                        if (this.f36461f.isEmpty()) {
                            this.f36461f = yVar.f36454h;
                            this.f36456a &= -17;
                        } else {
                            k();
                            this.f36461f.addAll(yVar.f36454h);
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
                            y parsePartialFrom = y.f36447a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    AbstractMessageLite.Builder.addAll(iterable, this.f36461f);
                    return this;
                }
                return (C1602a) invokeL.objValue;
            }

            public C1602a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f36456a |= 4;
                        this.f36459d = str;
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
                    if ((this.f36456a & 2) == 2 && this.f36458c != h.a()) {
                        hVar = h.a(this.f36458c).mergeFrom(hVar).buildPartial();
                    }
                    this.f36458c = hVar;
                    this.f36456a |= 2;
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
                    int i2 = this.f36456a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    yVar.f36450d = this.f36457b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    yVar.f36451e = this.f36458c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    yVar.f36452f = this.f36459d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    yVar.f36453g = this.f36460e;
                    if ((this.f36456a & 16) == 16) {
                        this.f36461f = Collections.unmodifiableList(this.f36461f);
                        this.f36456a &= -17;
                    }
                    yVar.f36454h = this.f36461f;
                    yVar.f36449c = i3;
                    return yVar;
                }
                return (y) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.f36456a & 2) == 2 : invokeV.booleanValue;
            }

            public h g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f36458c : (h) invokeV.objValue;
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
            f36447a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
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
            f36448b = yVar;
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
            this.f36455i = (byte) -1;
            this.j = -1;
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
            this.f36455i = (byte) -1;
            this.j = -1;
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
                                    r.C1599a builder = (this.f36449c & 1) == 1 ? this.f36450d.toBuilder() : null;
                                    r rVar = (r) codedInputStream.readMessage(r.f36402a, extensionRegistryLite);
                                    this.f36450d = rVar;
                                    if (builder != null) {
                                        builder.mergeFrom(rVar);
                                        this.f36450d = builder.buildPartial();
                                    }
                                    i2 = this.f36449c;
                                } else if (readTag == 330) {
                                    i5 = 2;
                                    h.C1594a builder2 = (this.f36449c & 2) == 2 ? this.f36451e.toBuilder() : null;
                                    h hVar = (h) codedInputStream.readMessage(h.f36327a, extensionRegistryLite);
                                    this.f36451e = hVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(hVar);
                                        this.f36451e = builder2.buildPartial();
                                    }
                                    i2 = this.f36449c;
                                } else if (readTag == 1042) {
                                    this.f36449c |= 4;
                                    this.f36452f = codedInputStream.readBytes();
                                } else if (readTag == 1048) {
                                    this.f36449c |= 8;
                                    this.f36453g = codedInputStream.readInt64();
                                } else if (readTag == 1058) {
                                    if (!(z2 & true)) {
                                        this.f36454h = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.f36454h.add(codedInputStream.readMessage(c.f36288a, extensionRegistryLite));
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f36449c = i2 | i5;
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
                        this.f36454h = Collections.unmodifiableList(this.f36454h);
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
            this.f36455i = (byte) -1;
            this.j = -1;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f36448b : (y) invokeV.objValue;
        }

        public static C1602a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? C1602a.j() : (C1602a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.f36450d = r.a();
                this.f36451e = h.a();
                this.f36452f = "";
                this.f36453g = 0L;
                this.f36454h = Collections.emptyList();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f36448b : (y) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f36449c & 1) == 1 : invokeV.booleanValue;
        }

        public r d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36450d : (r) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f36449c & 2) == 2 : invokeV.booleanValue;
        }

        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36451e : (h) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36449c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f36447a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.j;
                if (i2 != -1) {
                    return i2;
                }
                int computeMessageSize = (this.f36449c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f36450d) + 0 : 0;
                if ((this.f36449c & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f36451e);
                }
                if ((this.f36449c & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.f36449c & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f36453g);
                }
                for (int i3 = 0; i3 < this.f36454h.size(); i3++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f36454h.get(i3));
                }
                this.j = computeMessageSize;
                return computeMessageSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f36452f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f36452f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f36449c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f36455i;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (!e()) {
                    this.f36455i = (byte) 0;
                    return false;
                } else if (f().isInitialized()) {
                    this.f36455i = (byte) 1;
                    return true;
                } else {
                    this.f36455i = (byte) 0;
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36453g : invokeV.longValue;
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
                if ((this.f36449c & 1) == 1) {
                    codedOutputStream.writeMessage(25, this.f36450d);
                }
                if ((this.f36449c & 2) == 2) {
                    codedOutputStream.writeMessage(41, this.f36451e);
                }
                if ((this.f36449c & 4) == 4) {
                    codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.f36449c & 8) == 8) {
                    codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f36453g);
                }
                for (int i2 = 0; i2 < this.f36454h.size(); i2++) {
                    codedOutputStream.writeMessage(132, this.f36454h.get(i2));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
