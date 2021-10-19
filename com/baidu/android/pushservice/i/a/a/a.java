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
    public static final class C1593a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C1593a> f37357a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1593a f37358b;
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
        public Object f37363g;

        /* renamed from: h  reason: collision with root package name */
        public long f37364h;

        /* renamed from: i  reason: collision with root package name */
        public byte f37365i;

        /* renamed from: j  reason: collision with root package name */
        public int f37366j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1594a extends GeneratedMessageLite.Builder<C1593a, C1594a> implements b {
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
            public Object f37371e;

            /* renamed from: f  reason: collision with root package name */
            public long f37372f;

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
                this.f37368b = "";
                this.f37369c = "";
                this.f37371e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1594a h() {
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
                    this.f37368b = "";
                    int i2 = this.f37367a & (-2);
                    this.f37367a = i2;
                    this.f37369c = "";
                    int i3 = i2 & (-3);
                    this.f37367a = i3;
                    this.f37370d = 0L;
                    int i4 = i3 & (-5);
                    this.f37367a = i4;
                    this.f37371e = "";
                    int i5 = i4 & (-9);
                    this.f37367a = i5;
                    this.f37372f = 0L;
                    this.f37367a = i5 & (-17);
                    return this;
                }
                return (C1594a) invokeV.objValue;
            }

            public C1594a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37367a |= 4;
                    this.f37370d = j2;
                    return this;
                }
                return (C1594a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1594a mergeFrom(C1593a c1593a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1593a)) == null) {
                    if (c1593a == C1593a.a()) {
                        return this;
                    }
                    if (c1593a.c()) {
                        this.f37367a |= 1;
                        this.f37368b = c1593a.f37360d;
                    }
                    if (c1593a.e()) {
                        this.f37367a |= 2;
                        this.f37369c = c1593a.f37361e;
                    }
                    if (c1593a.g()) {
                        a(c1593a.h());
                    }
                    if (c1593a.i()) {
                        this.f37367a |= 8;
                        this.f37371e = c1593a.f37363g;
                    }
                    if (c1593a.k()) {
                        b(c1593a.l());
                    }
                    return this;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    C1593a c1593a = null;
                    try {
                        try {
                            C1593a parsePartialFrom = C1593a.f37357a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C1593a c1593a2 = (C1593a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c1593a = c1593a2;
                                if (c1593a != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1593a != null) {
                            mergeFrom(c1593a);
                        }
                        throw th;
                    }
                }
                return (C1594a) invokeLL.objValue;
            }

            public C1594a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37367a |= 1;
                        this.f37368b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1594a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1594a) invokeV.objValue;
            }

            public C1594a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37367a |= 16;
                    this.f37372f = j2;
                    return this;
                }
                return (C1594a) invokeJ.objValue;
            }

            public C1594a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37367a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            public C1594a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                    if (str != null) {
                        this.f37367a |= 8;
                        this.f37371e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1594a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C1593a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? C1593a.a() : (C1593a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C1593a build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    C1593a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (C1593a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C1593a buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    C1593a c1593a = new C1593a(this, (AnonymousClass1) null);
                    int i2 = this.f37367a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1593a.f37360d = this.f37368b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1593a.f37361e = this.f37369c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1593a.f37362f = this.f37370d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1593a.f37363g = this.f37371e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1593a.f37364h = this.f37372f;
                    c1593a.f37359c = i3;
                    return c1593a;
                }
                return (C1593a) invokeV.objValue;
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
            f37357a = new AbstractParser<C1593a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
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
                public C1593a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1593a(codedInputStream, extensionRegistryLite, null) : (C1593a) invokeLL.objValue;
                }
            };
            C1593a c1593a = new C1593a();
            f37358b = c1593a;
            c1593a.p();
        }

        public C1593a() {
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
            this.f37365i = (byte) -1;
            this.f37366j = -1;
        }

        public C1593a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f37365i = (byte) -1;
            this.f37366j = -1;
            p();
            boolean z = false;
            while (!z) {
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
                            } else if (readTag == 34) {
                                this.f37359c |= 8;
                                this.f37363g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f37359c |= 16;
                                this.f37364h = codedInputStream.readInt64();
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

        public /* synthetic */ C1593a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1593a(GeneratedMessageLite.Builder builder) {
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
            this.f37365i = (byte) -1;
            this.f37366j = -1;
        }

        public /* synthetic */ C1593a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1594a a(C1593a c1593a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c1593a)) == null) ? m().mergeFrom(c1593a) : (C1594a) invokeL.objValue;
        }

        public static C1593a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37358b : (C1593a) invokeV.objValue;
        }

        public static C1594a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1594a.h() : (C1594a) invokeV.objValue;
        }

        private void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f37360d = "";
                this.f37361e = "";
                this.f37362f = 0L;
                this.f37363g = "";
                this.f37364h = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1593a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37358b : (C1593a) invokeV.objValue;
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
        public Parser<C1593a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37357a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37366j;
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
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f37359c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37364h);
                }
                this.f37366j = computeBytesSize;
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
                byte b2 = this.f37365i;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37365i = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f37363g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37363g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C1594a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? a(this) : (C1594a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C1594a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? m() : (C1594a) invokeV.objValue;
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
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f37359c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37364h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class aa extends GeneratedMessageLite implements ab {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f37373a;

        /* renamed from: b  reason: collision with root package name */
        public static final aa f37374b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37375c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37376d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37377e;

        /* renamed from: f  reason: collision with root package name */
        public long f37378f;

        /* renamed from: g  reason: collision with root package name */
        public long f37379g;

        /* renamed from: h  reason: collision with root package name */
        public long f37380h;

        /* renamed from: i  reason: collision with root package name */
        public Object f37381i;

        /* renamed from: j  reason: collision with root package name */
        public long f37382j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1595a extends GeneratedMessageLite.Builder<aa, C1595a> implements ab {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37383a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37384b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37385c;

            /* renamed from: d  reason: collision with root package name */
            public long f37386d;

            /* renamed from: e  reason: collision with root package name */
            public long f37387e;

            /* renamed from: f  reason: collision with root package name */
            public long f37388f;

            /* renamed from: g  reason: collision with root package name */
            public Object f37389g;

            /* renamed from: h  reason: collision with root package name */
            public long f37390h;

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
                this.f37384b = "";
                this.f37385c = "";
                this.f37389g = "";
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
                    this.f37384b = "";
                    int i2 = this.f37383a & (-2);
                    this.f37383a = i2;
                    this.f37385c = "";
                    int i3 = i2 & (-3);
                    this.f37383a = i3;
                    this.f37386d = 0L;
                    int i4 = i3 & (-5);
                    this.f37383a = i4;
                    this.f37387e = 0L;
                    int i5 = i4 & (-9);
                    this.f37383a = i5;
                    this.f37388f = 0L;
                    int i6 = i5 & (-17);
                    this.f37383a = i6;
                    this.f37389g = "";
                    int i7 = i6 & (-33);
                    this.f37383a = i7;
                    this.f37390h = 0L;
                    this.f37383a = i7 & (-65);
                    return this;
                }
                return (C1595a) invokeV.objValue;
            }

            public C1595a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37383a |= 4;
                    this.f37386d = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1595a mergeFrom(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar == aa.a()) {
                        return this;
                    }
                    if (aaVar.c()) {
                        this.f37383a |= 1;
                        this.f37384b = aaVar.f37376d;
                    }
                    if (aaVar.e()) {
                        this.f37383a |= 2;
                        this.f37385c = aaVar.f37377e;
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
                        this.f37383a |= 32;
                        this.f37389g = aaVar.f37381i;
                    }
                    if (aaVar.o()) {
                        d(aaVar.p());
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
                    aa aaVar = null;
                    try {
                        try {
                            aa parsePartialFrom = aa.f37373a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1595a) invokeLL.objValue;
            }

            public C1595a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37383a |= 1;
                        this.f37384b = str;
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
                    this.f37383a |= 8;
                    this.f37387e = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            public C1595a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37383a |= 2;
                        this.f37385c = str;
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
                    this.f37383a |= 16;
                    this.f37388f = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
            }

            public C1595a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.f37383a |= 32;
                        this.f37389g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1595a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? aa.a() : (aa) invokeV.objValue;
            }

            public C1595a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.f37383a |= 64;
                    this.f37390h = j2;
                    return this;
                }
                return (C1595a) invokeJ.objValue;
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
                    int i2 = this.f37383a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aaVar.f37376d = this.f37384b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aaVar.f37377e = this.f37385c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aaVar.f37378f = this.f37386d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aaVar.f37379g = this.f37387e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aaVar.f37380h = this.f37388f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aaVar.f37381i = this.f37389g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aaVar.f37382j = this.f37390h;
                    aaVar.f37375c = i3;
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
            f37373a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
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
            f37374b = aaVar;
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
                                    this.f37375c |= 1;
                                    this.f37376d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37375c |= 2;
                                    this.f37377e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f37375c |= 4;
                                    this.f37378f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f37375c |= 8;
                                    this.f37379g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f37375c |= 16;
                                    this.f37380h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f37375c |= 32;
                                    this.f37381i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f37375c |= 64;
                                    this.f37382j = codedInputStream.readInt64();
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

        public static C1595a a(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aaVar)) == null) ? q().mergeFrom(aaVar) : (C1595a) invokeL.objValue;
        }

        public static aa a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37374b : (aa) invokeV.objValue;
        }

        public static C1595a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1595a.h() : (C1595a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37376d = "";
                this.f37377e = "";
                this.f37378f = 0L;
                this.f37379g = 0L;
                this.f37380h = 0L;
                this.f37381i = "";
                this.f37382j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37374b : (aa) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37375c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37376d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37376d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37375c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37377e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37377e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37375c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37373a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37375c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37375c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37375c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f37378f);
                }
                if ((this.f37375c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f37379g);
                }
                if ((this.f37375c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37380h);
                }
                if ((this.f37375c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f37375c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f37382j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37378f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37375c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37379g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37375c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37380h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37375c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f37381i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37381i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37375c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37382j : invokeV.longValue;
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
                if ((this.f37375c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37375c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37375c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37378f);
                }
                if ((this.f37375c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37379g);
                }
                if ((this.f37375c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37380h);
                }
                if ((this.f37375c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f37375c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37382j);
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
        public static Parser<ac> f37391a;

        /* renamed from: b  reason: collision with root package name */
        public static final ac f37392b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37393c;

        /* renamed from: d  reason: collision with root package name */
        public x f37394d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37395e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37396f;

        /* renamed from: g  reason: collision with root package name */
        public Object f37397g;

        /* renamed from: h  reason: collision with root package name */
        public int f37398h;

        /* renamed from: i  reason: collision with root package name */
        public int f37399i;

        /* renamed from: j  reason: collision with root package name */
        public int f37400j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1596a extends GeneratedMessageLite.Builder<ac, C1596a> implements ad {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37401a;

            /* renamed from: b  reason: collision with root package name */
            public x f37402b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37403c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37404d;

            /* renamed from: e  reason: collision with root package name */
            public Object f37405e;

            /* renamed from: f  reason: collision with root package name */
            public int f37406f;

            /* renamed from: g  reason: collision with root package name */
            public int f37407g;

            /* renamed from: h  reason: collision with root package name */
            public int f37408h;

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
                this.f37402b = x.f37586a;
                this.f37403c = "";
                this.f37404d = "";
                this.f37405e = "";
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
                    this.f37402b = x.f37586a;
                    int i2 = this.f37401a & (-2);
                    this.f37401a = i2;
                    this.f37403c = "";
                    int i3 = i2 & (-3);
                    this.f37401a = i3;
                    this.f37404d = "";
                    int i4 = i3 & (-5);
                    this.f37401a = i4;
                    this.f37405e = "";
                    int i5 = i4 & (-9);
                    this.f37401a = i5;
                    this.f37406f = 0;
                    int i6 = i5 & (-17);
                    this.f37401a = i6;
                    this.f37407g = 0;
                    int i7 = i6 & (-33);
                    this.f37401a = i7;
                    this.f37408h = 0;
                    this.f37401a = i7 & (-65);
                    return this;
                }
                return (C1596a) invokeV.objValue;
            }

            public C1596a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f37401a |= 16;
                    this.f37406f = i2;
                    return this;
                }
                return (C1596a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1596a mergeFrom(ac acVar) {
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
                        this.f37401a |= 2;
                        this.f37403c = acVar.f37395e;
                    }
                    if (acVar.g()) {
                        this.f37401a |= 4;
                        this.f37404d = acVar.f37396f;
                    }
                    if (acVar.i()) {
                        this.f37401a |= 8;
                        this.f37405e = acVar.f37397g;
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
                return (C1596a) invokeL.objValue;
            }

            public C1596a a(x xVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xVar)) == null) {
                    if (xVar != null) {
                        this.f37401a |= 1;
                        this.f37402b = xVar;
                        return this;
                    }
                    throw null;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, codedInputStream, extensionRegistryLite)) == null) {
                    ac acVar = null;
                    try {
                        try {
                            ac parsePartialFrom = ac.f37391a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1596a) invokeLL.objValue;
            }

            public C1596a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.f37401a |= 2;
                        this.f37403c = str;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h().mergeFrom(buildPartial()) : (C1596a) invokeV.objValue;
            }

            public C1596a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                    this.f37401a |= 32;
                    this.f37407g = i2;
                    return this;
                }
                return (C1596a) invokeI.objValue;
            }

            public C1596a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.f37401a |= 4;
                        this.f37404d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1596a) invokeL.objValue;
            }

            public C1596a c(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                    this.f37401a |= 64;
                    this.f37408h = i2;
                    return this;
                }
                return (C1596a) invokeI.objValue;
            }

            public C1596a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                    if (str != null) {
                        this.f37401a |= 8;
                        this.f37405e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1596a) invokeL.objValue;
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
                    int i2 = this.f37401a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    acVar.f37394d = this.f37402b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    acVar.f37395e = this.f37403c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    acVar.f37396f = this.f37404d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    acVar.f37397g = this.f37405e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    acVar.f37398h = this.f37406f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    acVar.f37399i = this.f37407g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    acVar.f37400j = this.f37408h;
                    acVar.f37393c = i3;
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
            f37391a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
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
            f37392b = acVar;
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
                                    this.f37393c = 1 | this.f37393c;
                                    this.f37394d = a2;
                                }
                            } else if (readTag == 18) {
                                this.f37393c |= 2;
                                this.f37395e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f37393c |= 4;
                                this.f37396f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f37393c |= 8;
                                this.f37397g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f37393c |= 16;
                                this.f37398h = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.f37393c |= 32;
                                this.f37399i = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.f37393c |= 64;
                                this.f37400j = codedInputStream.readInt32();
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

        public static C1596a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, acVar)) == null) ? q().mergeFrom(acVar) : (C1596a) invokeL.objValue;
        }

        public static ac a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37392b : (ac) invokeV.objValue;
        }

        public static C1596a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1596a.h() : (C1596a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37394d = x.f37586a;
                this.f37395e = "";
                this.f37396f = "";
                this.f37397g = "";
                this.f37398h = 0;
                this.f37399i = 0;
                this.f37400j = 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37392b : (ac) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37393c & 1) == 1 : invokeV.booleanValue;
        }

        public x d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37394d : (x) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37393c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37395e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37395e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37393c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37391a : (Parser) invokeV.objValue;
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
                int computeEnumSize = (this.f37393c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f37394d.getNumber()) : 0;
                if ((this.f37393c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37393c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37393c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f37393c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f37398h);
                }
                if ((this.f37393c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f37399i);
                }
                if ((this.f37393c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.f37400j);
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
                Object obj = this.f37396f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37396f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37393c & 8) == 8 : invokeV.booleanValue;
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
                Object obj = this.f37397g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37397g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37393c & 16) == 16 : invokeV.booleanValue;
        }

        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37398h : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37393c & 32) == 32 : invokeV.booleanValue;
        }

        public int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37399i : invokeV.intValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37393c & 64) == 64 : invokeV.booleanValue;
        }

        public int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37400j : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1596a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1596a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1596a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1596a) invokeV.objValue;
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
                if ((this.f37393c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f37394d.getNumber());
                }
                if ((this.f37393c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37393c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37393c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f37393c & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.f37398h);
                }
                if ((this.f37393c & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.f37399i);
                }
                if ((this.f37393c & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.f37400j);
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
        public static Parser<ae> f37409a;

        /* renamed from: b  reason: collision with root package name */
        public static final ae f37410b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37411c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37412d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37413e;

        /* renamed from: f  reason: collision with root package name */
        public long f37414f;

        /* renamed from: g  reason: collision with root package name */
        public long f37415g;

        /* renamed from: h  reason: collision with root package name */
        public long f37416h;

        /* renamed from: i  reason: collision with root package name */
        public Object f37417i;

        /* renamed from: j  reason: collision with root package name */
        public long f37418j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1597a extends GeneratedMessageLite.Builder<ae, C1597a> implements af {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37419a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37420b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37421c;

            /* renamed from: d  reason: collision with root package name */
            public long f37422d;

            /* renamed from: e  reason: collision with root package name */
            public long f37423e;

            /* renamed from: f  reason: collision with root package name */
            public long f37424f;

            /* renamed from: g  reason: collision with root package name */
            public Object f37425g;

            /* renamed from: h  reason: collision with root package name */
            public long f37426h;

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
                this.f37420b = "";
                this.f37421c = "";
                this.f37425g = "";
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
                    this.f37420b = "";
                    int i2 = this.f37419a & (-2);
                    this.f37419a = i2;
                    this.f37421c = "";
                    int i3 = i2 & (-3);
                    this.f37419a = i3;
                    this.f37422d = 0L;
                    int i4 = i3 & (-5);
                    this.f37419a = i4;
                    this.f37423e = 0L;
                    int i5 = i4 & (-9);
                    this.f37419a = i5;
                    this.f37424f = 0L;
                    int i6 = i5 & (-17);
                    this.f37419a = i6;
                    this.f37425g = "";
                    int i7 = i6 & (-33);
                    this.f37419a = i7;
                    this.f37426h = 0L;
                    this.f37419a = i7 & (-65);
                    return this;
                }
                return (C1597a) invokeV.objValue;
            }

            public C1597a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37419a |= 4;
                    this.f37422d = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1597a mergeFrom(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aeVar)) == null) {
                    if (aeVar == ae.a()) {
                        return this;
                    }
                    if (aeVar.c()) {
                        this.f37419a |= 1;
                        this.f37420b = aeVar.f37412d;
                    }
                    if (aeVar.e()) {
                        this.f37419a |= 2;
                        this.f37421c = aeVar.f37413e;
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
                        this.f37419a |= 32;
                        this.f37425g = aeVar.f37417i;
                    }
                    if (aeVar.o()) {
                        d(aeVar.p());
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
                    ae aeVar = null;
                    try {
                        try {
                            ae parsePartialFrom = ae.f37409a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1597a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1597a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1597a) invokeV.objValue;
            }

            public C1597a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.f37419a |= 8;
                    this.f37423e = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            public C1597a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.f37419a |= 16;
                    this.f37424f = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ae.a() : (ae) invokeV.objValue;
            }

            public C1597a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.f37419a |= 64;
                    this.f37426h = j2;
                    return this;
                }
                return (C1597a) invokeJ.objValue;
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
                    int i2 = this.f37419a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    aeVar.f37412d = this.f37420b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aeVar.f37413e = this.f37421c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aeVar.f37414f = this.f37422d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aeVar.f37415g = this.f37423e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aeVar.f37416h = this.f37424f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aeVar.f37417i = this.f37425g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aeVar.f37418j = this.f37426h;
                    aeVar.f37411c = i3;
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
            f37409a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
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
            f37410b = aeVar;
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
                                    this.f37411c |= 1;
                                    this.f37412d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37411c |= 2;
                                    this.f37413e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f37411c |= 4;
                                    this.f37414f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f37411c |= 8;
                                    this.f37415g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f37411c |= 16;
                                    this.f37416h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f37411c |= 32;
                                    this.f37417i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f37411c |= 64;
                                    this.f37418j = codedInputStream.readInt64();
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

        public static C1597a a(ae aeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aeVar)) == null) ? q().mergeFrom(aeVar) : (C1597a) invokeL.objValue;
        }

        public static ae a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37410b : (ae) invokeV.objValue;
        }

        public static C1597a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1597a.h() : (C1597a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37412d = "";
                this.f37413e = "";
                this.f37414f = 0L;
                this.f37415g = 0L;
                this.f37416h = 0L;
                this.f37417i = "";
                this.f37418j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37410b : (ae) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37411c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37412d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37412d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37411c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37413e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37413e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37411c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37409a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37411c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37411c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37411c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f37414f);
                }
                if ((this.f37411c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f37415g);
                }
                if ((this.f37411c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37416h);
                }
                if ((this.f37411c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f37411c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f37418j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37414f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37411c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37415g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37411c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37416h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37411c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f37417i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37417i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37411c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37418j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1597a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1597a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1597a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1597a) invokeV.objValue;
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
                if ((this.f37411c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37411c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37411c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37414f);
                }
                if ((this.f37411c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37415g);
                }
                if ((this.f37411c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37416h);
                }
                if ((this.f37411c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f37411c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37418j);
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
        public static Parser<c> f37427a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37428b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37429c;

        /* renamed from: d  reason: collision with root package name */
        public e f37430d;

        /* renamed from: e  reason: collision with root package name */
        public ae f37431e;

        /* renamed from: f  reason: collision with root package name */
        public l f37432f;

        /* renamed from: g  reason: collision with root package name */
        public n f37433g;

        /* renamed from: h  reason: collision with root package name */
        public j f37434h;

        /* renamed from: i  reason: collision with root package name */
        public aa f37435i;

        /* renamed from: j  reason: collision with root package name */
        public C1593a f37436j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1598a extends GeneratedMessageLite.Builder<c, C1598a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37437a;

            /* renamed from: b  reason: collision with root package name */
            public e f37438b;

            /* renamed from: c  reason: collision with root package name */
            public ae f37439c;

            /* renamed from: d  reason: collision with root package name */
            public l f37440d;

            /* renamed from: e  reason: collision with root package name */
            public n f37441e;

            /* renamed from: f  reason: collision with root package name */
            public j f37442f;

            /* renamed from: g  reason: collision with root package name */
            public aa f37443g;

            /* renamed from: h  reason: collision with root package name */
            public C1593a f37444h;

            /* renamed from: i  reason: collision with root package name */
            public t f37445i;

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
                this.f37438b = e.f37446a;
                this.f37439c = ae.a();
                this.f37440d = l.a();
                this.f37441e = n.a();
                this.f37442f = j.a();
                this.f37443g = aa.a();
                this.f37444h = C1593a.a();
                this.f37445i = t.a();
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1598a h() {
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
                    this.f37438b = e.f37446a;
                    this.f37437a &= -2;
                    this.f37439c = ae.a();
                    this.f37437a &= -3;
                    this.f37440d = l.a();
                    this.f37437a &= -5;
                    this.f37441e = n.a();
                    this.f37437a &= -9;
                    this.f37442f = j.a();
                    this.f37437a &= -17;
                    this.f37443g = aa.a();
                    this.f37437a &= -33;
                    this.f37444h = C1593a.a();
                    this.f37437a &= -65;
                    this.f37445i = t.a();
                    this.f37437a &= -129;
                    return this;
                }
                return (C1598a) invokeV.objValue;
            }

            public C1598a a(C1593a c1593a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1593a)) == null) {
                    if (c1593a != null) {
                        this.f37444h = c1593a;
                        this.f37437a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar != null) {
                        this.f37443g = aaVar;
                        this.f37437a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aeVar)) == null) {
                    if ((this.f37437a & 2) == 2 && this.f37439c != ae.a()) {
                        aeVar = ae.a(this.f37439c).mergeFrom(aeVar).buildPartial();
                    }
                    this.f37439c = aeVar;
                    this.f37437a |= 2;
                    return this;
                }
                return (C1598a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1598a mergeFrom(c cVar) {
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
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(e eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
                    if (eVar != null) {
                        this.f37437a |= 1;
                        this.f37438b = eVar;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                    if (jVar != null) {
                        this.f37442f = jVar;
                        this.f37437a |= 16;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
                    if (lVar != null) {
                        this.f37440d = lVar;
                        this.f37437a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) {
                    if (nVar != null) {
                        this.f37441e = nVar;
                        this.f37437a |= 8;
                        return this;
                    }
                    throw null;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a a(t tVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tVar)) == null) {
                    if ((this.f37437a & 128) == 128 && this.f37445i != t.a()) {
                        tVar = t.a(this.f37445i).mergeFrom(tVar).buildPartial();
                    }
                    this.f37445i = tVar;
                    this.f37437a |= 128;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, codedInputStream, extensionRegistryLite)) == null) {
                    c cVar = null;
                    try {
                        try {
                            c parsePartialFrom = c.f37427a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1598a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1598a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? h().mergeFrom(buildPartial()) : (C1598a) invokeV.objValue;
            }

            public C1598a b(C1593a c1593a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, c1593a)) == null) {
                    if ((this.f37437a & 64) == 64 && this.f37444h != C1593a.a()) {
                        c1593a = C1593a.a(this.f37444h).mergeFrom(c1593a).buildPartial();
                    }
                    this.f37444h = c1593a;
                    this.f37437a |= 64;
                    return this;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a b(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aaVar)) == null) {
                    if ((this.f37437a & 32) == 32 && this.f37443g != aa.a()) {
                        aaVar = aa.a(this.f37443g).mergeFrom(aaVar).buildPartial();
                    }
                    this.f37443g = aaVar;
                    this.f37437a |= 32;
                    return this;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a b(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jVar)) == null) {
                    if ((this.f37437a & 16) == 16 && this.f37442f != j.a()) {
                        jVar = j.a(this.f37442f).mergeFrom(jVar).buildPartial();
                    }
                    this.f37442f = jVar;
                    this.f37437a |= 16;
                    return this;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a b(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, lVar)) == null) {
                    if ((this.f37437a & 4) == 4 && this.f37440d != l.a()) {
                        lVar = l.a(this.f37440d).mergeFrom(lVar).buildPartial();
                    }
                    this.f37440d = lVar;
                    this.f37437a |= 4;
                    return this;
                }
                return (C1598a) invokeL.objValue;
            }

            public C1598a b(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, nVar)) == null) {
                    if ((this.f37437a & 8) == 8 && this.f37441e != n.a()) {
                        nVar = n.a(this.f37441e).mergeFrom(nVar).buildPartial();
                    }
                    this.f37441e = nVar;
                    this.f37437a |= 8;
                    return this;
                }
                return (C1598a) invokeL.objValue;
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
                    int i2 = this.f37437a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f37430d = this.f37438b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f37431e = this.f37439c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f37432f = this.f37440d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.f37433g = this.f37441e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    cVar.f37434h = this.f37442f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    cVar.f37435i = this.f37443g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    cVar.f37436j = this.f37444h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    cVar.k = this.f37445i;
                    cVar.f37429c = i3;
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
            f37427a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
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
            f37428b = cVar;
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
                                        ae.C1597a builder = (this.f37429c & 2) == 2 ? this.f37431e.toBuilder() : null;
                                        ae aeVar = (ae) codedInputStream.readMessage(ae.f37409a, extensionRegistryLite);
                                        this.f37431e = aeVar;
                                        if (builder != null) {
                                            builder.mergeFrom(aeVar);
                                            this.f37431e = builder.buildPartial();
                                        }
                                        i3 = this.f37429c;
                                    } else if (readTag == 26) {
                                        i2 = 4;
                                        l.C1602a builder2 = (this.f37429c & 4) == 4 ? this.f37432f.toBuilder() : null;
                                        l lVar = (l) codedInputStream.readMessage(l.f37504a, extensionRegistryLite);
                                        this.f37432f = lVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(lVar);
                                            this.f37432f = builder2.buildPartial();
                                        }
                                        i3 = this.f37429c;
                                    } else if (readTag == 34) {
                                        n.C1603a builder3 = (this.f37429c & 8) == 8 ? this.f37433g.toBuilder() : null;
                                        n nVar = (n) codedInputStream.readMessage(n.f37518a, extensionRegistryLite);
                                        this.f37433g = nVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(nVar);
                                            this.f37433g = builder3.buildPartial();
                                        }
                                        this.f37429c |= 8;
                                    } else if (readTag == 42) {
                                        i2 = 16;
                                        j.C1601a builder4 = (this.f37429c & 16) == 16 ? this.f37434h.toBuilder() : null;
                                        j jVar = (j) codedInputStream.readMessage(j.f37486a, extensionRegistryLite);
                                        this.f37434h = jVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(jVar);
                                            this.f37434h = builder4.buildPartial();
                                        }
                                        i3 = this.f37429c;
                                    } else if (readTag == 50) {
                                        i2 = 32;
                                        aa.C1595a builder5 = (this.f37429c & 32) == 32 ? this.f37435i.toBuilder() : null;
                                        aa aaVar = (aa) codedInputStream.readMessage(aa.f37373a, extensionRegistryLite);
                                        this.f37435i = aaVar;
                                        if (builder5 != null) {
                                            builder5.mergeFrom(aaVar);
                                            this.f37435i = builder5.buildPartial();
                                        }
                                        i3 = this.f37429c;
                                    } else if (readTag == 58) {
                                        i2 = 64;
                                        C1593a.C1594a builder6 = (this.f37429c & 64) == 64 ? this.f37436j.toBuilder() : null;
                                        C1593a c1593a = (C1593a) codedInputStream.readMessage(C1593a.f37357a, extensionRegistryLite);
                                        this.f37436j = c1593a;
                                        if (builder6 != null) {
                                            builder6.mergeFrom(c1593a);
                                            this.f37436j = builder6.buildPartial();
                                        }
                                        i3 = this.f37429c;
                                    } else if (readTag == 66) {
                                        i2 = 128;
                                        t.C1606a builder7 = (this.f37429c & 128) == 128 ? this.k.toBuilder() : null;
                                        t tVar = (t) codedInputStream.readMessage(t.f37558a, extensionRegistryLite);
                                        this.k = tVar;
                                        if (builder7 != null) {
                                            builder7.mergeFrom(tVar);
                                            this.k = builder7.buildPartial();
                                        }
                                        i3 = this.f37429c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f37429c = i3 | i2;
                                } else {
                                    e a2 = e.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f37429c = 1 | this.f37429c;
                                        this.f37430d = a2;
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

        public static C1598a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cVar)) == null) ? s().mergeFrom(cVar) : (C1598a) invokeL.objValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f37428b : (c) invokeV.objValue;
        }

        public static C1598a s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1598a.h() : (C1598a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f37430d = e.f37446a;
                this.f37431e = ae.a();
                this.f37432f = l.a();
                this.f37433g = n.a();
                this.f37434h = j.a();
                this.f37435i = aa.a();
                this.f37436j = C1593a.a();
                this.k = t.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37428b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37429c & 1) == 1 : invokeV.booleanValue;
        }

        public e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37430d : (e) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37429c & 2) == 2 : invokeV.booleanValue;
        }

        public ae f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37431e : (ae) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37429c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37427a : (Parser) invokeV.objValue;
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
                int computeEnumSize = (this.f37429c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f37430d.getNumber()) : 0;
                if ((this.f37429c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f37431e);
                }
                if ((this.f37429c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f37432f);
                }
                if ((this.f37429c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f37433g);
                }
                if ((this.f37429c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f37434h);
                }
                if ((this.f37429c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f37435i);
                }
                if ((this.f37429c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(7, this.f37436j);
                }
                if ((this.f37429c & 128) == 128) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37432f : (l) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37429c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37433g : (n) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37429c & 16) == 16 : invokeV.booleanValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37434h : (j) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37429c & 32) == 32 : invokeV.booleanValue;
        }

        public aa n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37435i : (aa) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37429c & 64) == 64 : invokeV.booleanValue;
        }

        public C1593a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37436j : (C1593a) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f37429c & 128) == 128 : invokeV.booleanValue;
        }

        public t r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (t) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C1598a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? s() : (C1598a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1598a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1598a) invokeV.objValue;
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
                if ((this.f37429c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f37430d.getNumber());
                }
                if ((this.f37429c & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.f37431e);
                }
                if ((this.f37429c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f37432f);
                }
                if ((this.f37429c & 8) == 8) {
                    codedOutputStream.writeMessage(4, this.f37433g);
                }
                if ((this.f37429c & 16) == 16) {
                    codedOutputStream.writeMessage(5, this.f37434h);
                }
                if ((this.f37429c & 32) == 32) {
                    codedOutputStream.writeMessage(6, this.f37435i);
                }
                if ((this.f37429c & 64) == 64) {
                    codedOutputStream.writeMessage(7, this.f37436j);
                }
                if ((this.f37429c & 128) == 128) {
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
        public static final e f37446a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f37447b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f37448c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f37449d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f37450e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f37451f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f37452g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ e[] f37453i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f37454h;

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
            f37446a = new e("UI", 0, 101);
            f37447b = new e("CRASH", 1, 201);
            f37448c = new e("DB", 2, 301);
            f37449d = new e("CONNECTION", 3, 401);
            f37450e = new e("REQUEST", 4, 501);
            f37451f = new e("ACK", 5, 601);
            e eVar = new e("MSG", 6, 701);
            f37452g = eVar;
            f37453i = new e[]{f37446a, f37447b, f37448c, f37449d, f37450e, f37451f, eVar};
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
            this.f37454h = i3;
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
                                        return f37452g;
                                    }
                                    return f37451f;
                                }
                                return f37450e;
                            }
                            return f37449d;
                        }
                        return f37448c;
                    }
                    return f37447b;
                }
                return f37446a;
            }
            return (e) invokeI.objValue;
        }

        public static e[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f37453i.clone() : (e[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37454h : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends GeneratedMessageLite implements g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f37455a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37456b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37457c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37458d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37459e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37460f;

        /* renamed from: g  reason: collision with root package name */
        public byte f37461g;

        /* renamed from: h  reason: collision with root package name */
        public int f37462h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1599a extends GeneratedMessageLite.Builder<f, C1599a> implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37463a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37464b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37465c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37466d;

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
                this.f37464b = "";
                this.f37465c = "";
                this.f37466d = "";
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
                    this.f37464b = "";
                    int i2 = this.f37463a & (-2);
                    this.f37463a = i2;
                    this.f37465c = "";
                    int i3 = i2 & (-3);
                    this.f37463a = i3;
                    this.f37466d = "";
                    this.f37463a = i3 & (-5);
                    return this;
                }
                return (C1599a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1599a mergeFrom(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
                    if (fVar == f.a()) {
                        return this;
                    }
                    if (fVar.c()) {
                        this.f37463a |= 1;
                        this.f37464b = fVar.f37458d;
                    }
                    if (fVar.e()) {
                        this.f37463a |= 2;
                        this.f37465c = fVar.f37459e;
                    }
                    if (fVar.g()) {
                        this.f37463a |= 4;
                        this.f37466d = fVar.f37460f;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    f fVar = null;
                    try {
                        try {
                            f parsePartialFrom = f.f37455a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1599a) invokeLL.objValue;
            }

            public C1599a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.f37463a |= 1;
                        this.f37464b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1599a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1599a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1599a) invokeV.objValue;
            }

            public C1599a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.f37463a |= 2;
                        this.f37465c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1599a) invokeL.objValue;
            }

            public C1599a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.f37463a |= 4;
                        this.f37466d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1599a) invokeL.objValue;
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
                    int i2 = this.f37463a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    fVar.f37458d = this.f37464b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    fVar.f37459e = this.f37465c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    fVar.f37460f = this.f37466d;
                    fVar.f37457c = i3;
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
            f37455a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
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
            f37456b = fVar;
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
            this.f37461g = (byte) -1;
            this.f37462h = -1;
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
            this.f37461g = (byte) -1;
            this.f37462h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f37457c |= 1;
                                this.f37458d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f37457c |= 2;
                                this.f37459e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f37457c |= 4;
                                this.f37460f = codedInputStream.readBytes();
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
            this.f37461g = (byte) -1;
            this.f37462h = -1;
        }

        public /* synthetic */ f(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1599a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) ? i().mergeFrom(fVar) : (C1599a) invokeL.objValue;
        }

        public static f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37456b : (f) invokeV.objValue;
        }

        public static C1599a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1599a.h() : (C1599a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f37458d = "";
                this.f37459e = "";
                this.f37460f = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37456b : (f) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37457c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37458d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37458d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37457c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37459e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37459e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37457c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37455a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37462h;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37457c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37457c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37457c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f37462h = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37460f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37460f = copyFromUtf8;
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
                byte b2 = this.f37461g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37461g = (byte) 1;
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
                if ((this.f37457c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37457c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37457c & 4) == 4) {
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
        public static Parser<h> f37467a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f37468b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37469c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37470d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37471e;

        /* renamed from: f  reason: collision with root package name */
        public p f37472f;

        /* renamed from: g  reason: collision with root package name */
        public long f37473g;

        /* renamed from: h  reason: collision with root package name */
        public long f37474h;

        /* renamed from: i  reason: collision with root package name */
        public ac f37475i;

        /* renamed from: j  reason: collision with root package name */
        public f f37476j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1600a extends GeneratedMessageLite.Builder<h, C1600a> implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37477a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37478b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37479c;

            /* renamed from: d  reason: collision with root package name */
            public p f37480d;

            /* renamed from: e  reason: collision with root package name */
            public long f37481e;

            /* renamed from: f  reason: collision with root package name */
            public long f37482f;

            /* renamed from: g  reason: collision with root package name */
            public ac f37483g;

            /* renamed from: h  reason: collision with root package name */
            public f f37484h;

            /* renamed from: i  reason: collision with root package name */
            public v f37485i;

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
                this.f37478b = "";
                this.f37479c = "";
                this.f37480d = p.a();
                this.f37483g = ac.a();
                this.f37484h = f.a();
                this.f37485i = v.a();
                j();
            }

            private void j() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1600a k() {
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
                    this.f37478b = "";
                    int i2 = this.f37477a & (-2);
                    this.f37477a = i2;
                    this.f37479c = "";
                    this.f37477a = i2 & (-3);
                    this.f37480d = p.a();
                    int i3 = this.f37477a & (-5);
                    this.f37477a = i3;
                    this.f37481e = 0L;
                    int i4 = i3 & (-9);
                    this.f37477a = i4;
                    this.f37482f = 0L;
                    this.f37477a = i4 & (-17);
                    this.f37483g = ac.a();
                    this.f37477a &= -33;
                    this.f37484h = f.a();
                    this.f37477a &= -65;
                    this.f37485i = v.a();
                    this.f37477a &= -129;
                    return this;
                }
                return (C1600a) invokeV.objValue;
            }

            public C1600a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37477a |= 8;
                    this.f37481e = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            public C1600a a(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acVar)) == null) {
                    if (acVar != null) {
                        this.f37483g = acVar;
                        this.f37477a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1600a) invokeL.objValue;
            }

            public C1600a a(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                    if (fVar != null) {
                        this.f37484h = fVar;
                        this.f37477a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1600a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1600a mergeFrom(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
                    if (hVar == h.a()) {
                        return this;
                    }
                    if (hVar.c()) {
                        this.f37477a |= 1;
                        this.f37478b = hVar.f37470d;
                    }
                    if (hVar.e()) {
                        this.f37477a |= 2;
                        this.f37479c = hVar.f37471e;
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
                return (C1600a) invokeL.objValue;
            }

            public C1600a a(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pVar)) == null) {
                    if (pVar != null) {
                        this.f37480d = pVar;
                        this.f37477a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1600a) invokeL.objValue;
            }

            public C1600a a(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vVar)) == null) {
                    if (vVar != null) {
                        this.f37485i = vVar;
                        this.f37477a |= 128;
                        return this;
                    }
                    throw null;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, codedInputStream, extensionRegistryLite)) == null) {
                    h hVar = null;
                    try {
                        try {
                            h parsePartialFrom = h.f37467a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1600a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1600a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? k().mergeFrom(buildPartial()) : (C1600a) invokeV.objValue;
            }

            public C1600a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                    this.f37477a |= 16;
                    this.f37482f = j2;
                    return this;
                }
                return (C1600a) invokeJ.objValue;
            }

            public C1600a b(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, acVar)) == null) {
                    if ((this.f37477a & 32) == 32 && this.f37483g != ac.a()) {
                        acVar = ac.a(this.f37483g).mergeFrom(acVar).buildPartial();
                    }
                    this.f37483g = acVar;
                    this.f37477a |= 32;
                    return this;
                }
                return (C1600a) invokeL.objValue;
            }

            public C1600a b(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
                    if ((this.f37477a & 64) == 64 && this.f37484h != f.a()) {
                        fVar = f.a(this.f37484h).mergeFrom(fVar).buildPartial();
                    }
                    this.f37484h = fVar;
                    this.f37477a |= 64;
                    return this;
                }
                return (C1600a) invokeL.objValue;
            }

            public C1600a b(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pVar)) == null) {
                    if ((this.f37477a & 4) == 4 && this.f37480d != p.a()) {
                        pVar = p.a(this.f37480d).mergeFrom(pVar).buildPartial();
                    }
                    this.f37480d = pVar;
                    this.f37477a |= 4;
                    return this;
                }
                return (C1600a) invokeL.objValue;
            }

            public C1600a b(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vVar)) == null) {
                    if ((this.f37477a & 128) == 128 && this.f37485i != v.a()) {
                        vVar = v.a(this.f37485i).mergeFrom(vVar).buildPartial();
                    }
                    this.f37485i = vVar;
                    this.f37477a |= 128;
                    return this;
                }
                return (C1600a) invokeL.objValue;
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
                    int i2 = this.f37477a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    hVar.f37470d = this.f37478b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    hVar.f37471e = this.f37479c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    hVar.f37472f = this.f37480d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    hVar.f37473g = this.f37481e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    hVar.f37474h = this.f37482f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    hVar.f37475i = this.f37483g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    hVar.f37476j = this.f37484h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    hVar.k = this.f37485i;
                    hVar.f37469c = i3;
                    return hVar;
                }
                return (h) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.f37477a & 4) == 4 : invokeV.booleanValue;
            }

            public p g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f37480d : (p) invokeV.objValue;
            }

            public boolean h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.f37477a & 8) == 8 : invokeV.booleanValue;
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
            f37467a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
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
            f37468b = hVar;
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
                                    this.f37469c |= 1;
                                    this.f37470d = codedInputStream.readBytes();
                                } else if (readTag != 18) {
                                    if (readTag == 58) {
                                        i2 = 4;
                                        p.C1604a builder = (this.f37469c & 4) == 4 ? this.f37472f.toBuilder() : null;
                                        p pVar = (p) codedInputStream.readMessage(p.f37538a, extensionRegistryLite);
                                        this.f37472f = pVar;
                                        if (builder != null) {
                                            builder.mergeFrom(pVar);
                                            this.f37472f = builder.buildPartial();
                                        }
                                        i3 = this.f37469c;
                                    } else if (readTag == 80) {
                                        this.f37469c |= 8;
                                        this.f37473g = codedInputStream.readInt64();
                                    } else if (readTag == 96) {
                                        this.f37469c |= 16;
                                        this.f37474h = codedInputStream.readInt64();
                                    } else if (readTag == 162) {
                                        i2 = 32;
                                        ac.C1596a builder2 = (this.f37469c & 32) == 32 ? this.f37475i.toBuilder() : null;
                                        ac acVar = (ac) codedInputStream.readMessage(ac.f37391a, extensionRegistryLite);
                                        this.f37475i = acVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(acVar);
                                            this.f37475i = builder2.buildPartial();
                                        }
                                        i3 = this.f37469c;
                                    } else if (readTag == 170) {
                                        i2 = 64;
                                        f.C1599a builder3 = (this.f37469c & 64) == 64 ? this.f37476j.toBuilder() : null;
                                        f fVar = (f) codedInputStream.readMessage(f.f37455a, extensionRegistryLite);
                                        this.f37476j = fVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(fVar);
                                            this.f37476j = builder3.buildPartial();
                                        }
                                        i3 = this.f37469c;
                                    } else if (readTag == 178) {
                                        i2 = 128;
                                        v.C1607a builder4 = (this.f37469c & 128) == 128 ? this.k.toBuilder() : null;
                                        v vVar = (v) codedInputStream.readMessage(v.f37576a, extensionRegistryLite);
                                        this.k = vVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(vVar);
                                            this.k = builder4.buildPartial();
                                        }
                                        i3 = this.f37469c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f37469c = i3 | i2;
                                } else {
                                    this.f37469c |= 2;
                                    this.f37471e = codedInputStream.readBytes();
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

        public static C1600a a(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hVar)) == null) ? t().mergeFrom(hVar) : (C1600a) invokeL.objValue;
        }

        public static h a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f37468b : (h) invokeV.objValue;
        }

        public static C1600a t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1600a.k() : (C1600a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f37470d = "";
                this.f37471e = "";
                this.f37472f = p.a();
                this.f37473g = 0L;
                this.f37474h = 0L;
                this.f37475i = ac.a();
                this.f37476j = f.a();
                this.k = v.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37468b : (h) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37469c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37470d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37470d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37469c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37471e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37471e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37469c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37467a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37469c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37469c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37469c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f37472f);
                }
                if ((this.f37469c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f37473g);
                }
                if ((this.f37469c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f37474h);
                }
                if ((this.f37469c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f37475i);
                }
                if ((this.f37469c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(21, this.f37476j);
                }
                if ((this.f37469c & 128) == 128) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37472f : (p) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37469c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37473g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37469c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37474h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37469c & 32) == 32 : invokeV.booleanValue;
        }

        public ac n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37475i : (ac) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37469c & 64) == 64 : invokeV.booleanValue;
        }

        public f p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37476j : (f) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f37469c & 128) == 128 : invokeV.booleanValue;
        }

        public v r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (v) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1600a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? t() : (C1600a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1600a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1600a) invokeV.objValue;
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
                if ((this.f37469c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37469c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37469c & 4) == 4) {
                    codedOutputStream.writeMessage(7, this.f37472f);
                }
                if ((this.f37469c & 8) == 8) {
                    codedOutputStream.writeInt64(10, this.f37473g);
                }
                if ((this.f37469c & 16) == 16) {
                    codedOutputStream.writeInt64(12, this.f37474h);
                }
                if ((this.f37469c & 32) == 32) {
                    codedOutputStream.writeMessage(20, this.f37475i);
                }
                if ((this.f37469c & 64) == 64) {
                    codedOutputStream.writeMessage(21, this.f37476j);
                }
                if ((this.f37469c & 128) == 128) {
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
        public static Parser<j> f37486a;

        /* renamed from: b  reason: collision with root package name */
        public static final j f37487b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37488c;

        /* renamed from: d  reason: collision with root package name */
        public long f37489d;

        /* renamed from: e  reason: collision with root package name */
        public long f37490e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37491f;

        /* renamed from: g  reason: collision with root package name */
        public long f37492g;

        /* renamed from: h  reason: collision with root package name */
        public long f37493h;

        /* renamed from: i  reason: collision with root package name */
        public Object f37494i;

        /* renamed from: j  reason: collision with root package name */
        public long f37495j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1601a extends GeneratedMessageLite.Builder<j, C1601a> implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37496a;

            /* renamed from: b  reason: collision with root package name */
            public long f37497b;

            /* renamed from: c  reason: collision with root package name */
            public long f37498c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37499d;

            /* renamed from: e  reason: collision with root package name */
            public long f37500e;

            /* renamed from: f  reason: collision with root package name */
            public long f37501f;

            /* renamed from: g  reason: collision with root package name */
            public Object f37502g;

            /* renamed from: h  reason: collision with root package name */
            public long f37503h;

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
                this.f37499d = "";
                this.f37502g = "";
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
                    this.f37497b = 0L;
                    int i2 = this.f37496a & (-2);
                    this.f37496a = i2;
                    this.f37498c = 0L;
                    int i3 = i2 & (-3);
                    this.f37496a = i3;
                    this.f37499d = "";
                    int i4 = i3 & (-5);
                    this.f37496a = i4;
                    this.f37500e = 0L;
                    int i5 = i4 & (-9);
                    this.f37496a = i5;
                    this.f37501f = 0L;
                    int i6 = i5 & (-17);
                    this.f37496a = i6;
                    this.f37502g = "";
                    int i7 = i6 & (-33);
                    this.f37496a = i7;
                    this.f37503h = 0L;
                    this.f37496a = i7 & (-65);
                    return this;
                }
                return (C1601a) invokeV.objValue;
            }

            public C1601a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37496a |= 1;
                    this.f37497b = j2;
                    return this;
                }
                return (C1601a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1601a mergeFrom(j jVar) {
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
                        this.f37496a |= 4;
                        this.f37499d = jVar.f37491f;
                    }
                    if (jVar.i()) {
                        c(jVar.j());
                    }
                    if (jVar.k()) {
                        d(jVar.l());
                    }
                    if (jVar.m()) {
                        this.f37496a |= 32;
                        this.f37502g = jVar.f37494i;
                    }
                    if (jVar.o()) {
                        e(jVar.p());
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    j jVar = null;
                    try {
                        try {
                            j parsePartialFrom = j.f37486a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1601a) invokeLL.objValue;
            }

            public C1601a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37496a |= 4;
                        this.f37499d = str;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1601a) invokeV.objValue;
            }

            public C1601a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37496a |= 2;
                    this.f37498c = j2;
                    return this;
                }
                return (C1601a) invokeJ.objValue;
            }

            public C1601a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37496a |= 32;
                        this.f37502g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1601a) invokeL.objValue;
            }

            public C1601a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.f37496a |= 8;
                    this.f37500e = j2;
                    return this;
                }
                return (C1601a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j.a() : (j) invokeV.objValue;
            }

            public C1601a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.f37496a |= 16;
                    this.f37501f = j2;
                    return this;
                }
                return (C1601a) invokeJ.objValue;
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

            public C1601a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
                    this.f37496a |= 64;
                    this.f37503h = j2;
                    return this;
                }
                return (C1601a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    j jVar = new j(this, (AnonymousClass1) null);
                    int i2 = this.f37496a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    jVar.f37489d = this.f37497b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    jVar.f37490e = this.f37498c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    jVar.f37491f = this.f37499d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    jVar.f37492g = this.f37500e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    jVar.f37493h = this.f37501f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    jVar.f37494i = this.f37502g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    jVar.f37495j = this.f37503h;
                    jVar.f37488c = i3;
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
            f37486a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
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
            f37487b = jVar;
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
                                this.f37488c |= 1;
                                this.f37489d = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.f37488c |= 2;
                                this.f37490e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f37488c |= 4;
                                this.f37491f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f37488c |= 8;
                                this.f37492g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f37488c |= 16;
                                this.f37493h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f37488c |= 32;
                                this.f37494i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f37488c |= 64;
                                this.f37495j = codedInputStream.readInt64();
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

        public static C1601a a(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jVar)) == null) ? q().mergeFrom(jVar) : (C1601a) invokeL.objValue;
        }

        public static j a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37487b : (j) invokeV.objValue;
        }

        public static C1601a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1601a.h() : (C1601a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f37489d = 0L;
                this.f37490e = 0L;
                this.f37491f = "";
                this.f37492g = 0L;
                this.f37493h = 0L;
                this.f37494i = "";
                this.f37495j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37487b : (j) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37488c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37489d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37488c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37490e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37488c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37486a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f37488c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f37489d) : 0;
                if ((this.f37488c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f37490e);
                }
                if ((this.f37488c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37488c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f37492g);
                }
                if ((this.f37488c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f37493h);
                }
                if ((this.f37488c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f37488c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f37495j);
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
                Object obj = this.f37491f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37491f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37488c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37492g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37488c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37493h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37488c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f37494i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37494i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37488c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37495j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1601a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1601a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1601a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1601a) invokeV.objValue;
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
                if ((this.f37488c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f37489d);
                }
                if ((this.f37488c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f37490e);
                }
                if ((this.f37488c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37488c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37492g);
                }
                if ((this.f37488c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37493h);
                }
                if ((this.f37488c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f37488c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37495j);
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
        public static Parser<l> f37504a;

        /* renamed from: b  reason: collision with root package name */
        public static final l f37505b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37506c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37507d;

        /* renamed from: e  reason: collision with root package name */
        public long f37508e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37509f;

        /* renamed from: g  reason: collision with root package name */
        public long f37510g;

        /* renamed from: h  reason: collision with root package name */
        public byte f37511h;

        /* renamed from: i  reason: collision with root package name */
        public int f37512i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1602a extends GeneratedMessageLite.Builder<l, C1602a> implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37513a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37514b;

            /* renamed from: c  reason: collision with root package name */
            public long f37515c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37516d;

            /* renamed from: e  reason: collision with root package name */
            public long f37517e;

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
                this.f37514b = "";
                this.f37516d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1602a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1602a() : (C1602a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1602a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37514b = "";
                    int i2 = this.f37513a & (-2);
                    this.f37513a = i2;
                    this.f37515c = 0L;
                    int i3 = i2 & (-3);
                    this.f37513a = i3;
                    this.f37516d = "";
                    int i4 = i3 & (-5);
                    this.f37513a = i4;
                    this.f37517e = 0L;
                    this.f37513a = i4 & (-9);
                    return this;
                }
                return (C1602a) invokeV.objValue;
            }

            public C1602a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37513a |= 2;
                    this.f37515c = j2;
                    return this;
                }
                return (C1602a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1602a mergeFrom(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
                    if (lVar == l.a()) {
                        return this;
                    }
                    if (lVar.c()) {
                        this.f37513a |= 1;
                        this.f37514b = lVar.f37507d;
                    }
                    if (lVar.e()) {
                        a(lVar.f());
                    }
                    if (lVar.g()) {
                        this.f37513a |= 4;
                        this.f37516d = lVar.f37509f;
                    }
                    if (lVar.i()) {
                        b(lVar.j());
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    l lVar = null;
                    try {
                        try {
                            l parsePartialFrom = l.f37504a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1602a) invokeLL.objValue;
            }

            public C1602a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37513a |= 1;
                        this.f37514b = str;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1602a) invokeV.objValue;
            }

            public C1602a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37513a |= 8;
                    this.f37517e = j2;
                    return this;
                }
                return (C1602a) invokeJ.objValue;
            }

            public C1602a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37513a |= 4;
                        this.f37516d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1602a) invokeL.objValue;
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
                    int i2 = this.f37513a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    lVar.f37507d = this.f37514b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    lVar.f37508e = this.f37515c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    lVar.f37509f = this.f37516d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    lVar.f37510g = this.f37517e;
                    lVar.f37506c = i3;
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
            f37504a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
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
            f37505b = lVar;
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
            this.f37511h = (byte) -1;
            this.f37512i = -1;
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
            this.f37511h = (byte) -1;
            this.f37512i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f37506c |= 1;
                                this.f37507d = codedInputStream.readBytes();
                            } else if (readTag == 16) {
                                this.f37506c |= 2;
                                this.f37508e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f37506c |= 4;
                                this.f37509f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f37506c |= 8;
                                this.f37510g = codedInputStream.readInt64();
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
            this.f37511h = (byte) -1;
            this.f37512i = -1;
        }

        public /* synthetic */ l(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1602a a(l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lVar)) == null) ? k().mergeFrom(lVar) : (C1602a) invokeL.objValue;
        }

        public static l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37505b : (l) invokeV.objValue;
        }

        public static C1602a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1602a.h() : (C1602a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f37507d = "";
                this.f37508e = 0L;
                this.f37509f = "";
                this.f37510g = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37505b : (l) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37506c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37507d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37507d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37506c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37508e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37506c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37504a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37512i;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37506c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37506c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f37508e);
                }
                if ((this.f37506c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37506c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f37510g);
                }
                this.f37512i = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37509f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37509f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37506c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37511h;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37511h = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37510g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1602a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(this) : (C1602a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1602a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? k() : (C1602a) invokeV.objValue;
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
                if ((this.f37506c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37506c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f37508e);
                }
                if ((this.f37506c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37506c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37510g);
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
        public static Parser<n> f37518a;

        /* renamed from: b  reason: collision with root package name */
        public static final n f37519b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37520c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37521d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37522e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37523f;

        /* renamed from: g  reason: collision with root package name */
        public Object f37524g;

        /* renamed from: h  reason: collision with root package name */
        public long f37525h;

        /* renamed from: i  reason: collision with root package name */
        public long f37526i;

        /* renamed from: j  reason: collision with root package name */
        public long f37527j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1603a extends GeneratedMessageLite.Builder<n, C1603a> implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37528a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37529b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37530c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37531d;

            /* renamed from: e  reason: collision with root package name */
            public Object f37532e;

            /* renamed from: f  reason: collision with root package name */
            public long f37533f;

            /* renamed from: g  reason: collision with root package name */
            public long f37534g;

            /* renamed from: h  reason: collision with root package name */
            public long f37535h;

            /* renamed from: i  reason: collision with root package name */
            public Object f37536i;

            /* renamed from: j  reason: collision with root package name */
            public long f37537j;

            public C1603a() {
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
                this.f37529b = "";
                this.f37530c = "";
                this.f37531d = "";
                this.f37532e = "";
                this.f37536i = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1603a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1603a() : (C1603a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1603a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37529b = "";
                    int i2 = this.f37528a & (-2);
                    this.f37528a = i2;
                    this.f37530c = "";
                    int i3 = i2 & (-3);
                    this.f37528a = i3;
                    this.f37531d = "";
                    int i4 = i3 & (-5);
                    this.f37528a = i4;
                    this.f37532e = "";
                    int i5 = i4 & (-9);
                    this.f37528a = i5;
                    this.f37533f = 0L;
                    int i6 = i5 & (-17);
                    this.f37528a = i6;
                    this.f37534g = 0L;
                    int i7 = i6 & (-33);
                    this.f37528a = i7;
                    this.f37535h = 0L;
                    int i8 = i7 & (-65);
                    this.f37528a = i8;
                    this.f37536i = "";
                    int i9 = i8 & (-129);
                    this.f37528a = i9;
                    this.f37537j = 0L;
                    this.f37528a = i9 & (-257);
                    return this;
                }
                return (C1603a) invokeV.objValue;
            }

            public C1603a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37528a |= 16;
                    this.f37533f = j2;
                    return this;
                }
                return (C1603a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1603a mergeFrom(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar)) == null) {
                    if (nVar == n.a()) {
                        return this;
                    }
                    if (nVar.c()) {
                        this.f37528a |= 1;
                        this.f37529b = nVar.f37521d;
                    }
                    if (nVar.e()) {
                        this.f37528a |= 2;
                        this.f37530c = nVar.f37522e;
                    }
                    if (nVar.g()) {
                        this.f37528a |= 4;
                        this.f37531d = nVar.f37523f;
                    }
                    if (nVar.i()) {
                        this.f37528a |= 8;
                        this.f37532e = nVar.f37524g;
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
                        this.f37528a |= 128;
                        this.f37536i = nVar.k;
                    }
                    if (nVar.s()) {
                        d(nVar.t());
                    }
                    return this;
                }
                return (C1603a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1603a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    n nVar = null;
                    try {
                        try {
                            n parsePartialFrom = n.f37518a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1603a) invokeLL.objValue;
            }

            public C1603a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.f37528a |= 1;
                        this.f37529b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1603a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1603a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1603a) invokeV.objValue;
            }

            public C1603a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.f37528a |= 32;
                    this.f37534g = j2;
                    return this;
                }
                return (C1603a) invokeJ.objValue;
            }

            public C1603a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37528a |= 2;
                        this.f37530c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1603a) invokeL.objValue;
            }

            public C1603a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.f37528a |= 64;
                    this.f37535h = j2;
                    return this;
                }
                return (C1603a) invokeJ.objValue;
            }

            public C1603a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.f37528a |= 4;
                        this.f37531d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1603a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? n.a() : (n) invokeV.objValue;
            }

            public C1603a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.f37528a |= 256;
                    this.f37537j = j2;
                    return this;
                }
                return (C1603a) invokeJ.objValue;
            }

            public C1603a d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                    if (str != null) {
                        this.f37528a |= 8;
                        this.f37532e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1603a) invokeL.objValue;
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

            public C1603a e(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                    if (str != null) {
                        this.f37528a |= 128;
                        this.f37536i = str;
                        return this;
                    }
                    throw null;
                }
                return (C1603a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    n nVar = new n(this, (AnonymousClass1) null);
                    int i2 = this.f37528a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    nVar.f37521d = this.f37529b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    nVar.f37522e = this.f37530c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    nVar.f37523f = this.f37531d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    nVar.f37524g = this.f37532e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    nVar.f37525h = this.f37533f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    nVar.f37526i = this.f37534g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    nVar.f37527j = this.f37535h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    nVar.k = this.f37536i;
                    if ((i2 & 256) == 256) {
                        i3 |= 256;
                    }
                    nVar.l = this.f37537j;
                    nVar.f37520c = i3;
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
            f37518a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
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
            f37519b = nVar;
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
                                    this.f37520c |= 1;
                                    this.f37521d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37520c |= 2;
                                    this.f37522e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f37520c |= 4;
                                    this.f37523f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f37520c |= 8;
                                    this.f37524g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f37520c |= 16;
                                    this.f37525h = codedInputStream.readInt64();
                                } else if (readTag == 48) {
                                    this.f37520c |= 32;
                                    this.f37526i = codedInputStream.readInt64();
                                } else if (readTag == 56) {
                                    this.f37520c |= 64;
                                    this.f37527j = codedInputStream.readInt64();
                                } else if (readTag == 66) {
                                    this.f37520c |= 128;
                                    this.k = codedInputStream.readBytes();
                                } else if (readTag == 72) {
                                    this.f37520c |= 256;
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

        public static C1603a a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nVar)) == null) ? u().mergeFrom(nVar) : (C1603a) invokeL.objValue;
        }

        public static n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37519b : (n) invokeV.objValue;
        }

        public static C1603a u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? C1603a.h() : (C1603a) invokeV.objValue;
        }

        private void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65560, this) == null) {
                this.f37521d = "";
                this.f37522e = "";
                this.f37523f = "";
                this.f37524g = "";
                this.f37525h = 0L;
                this.f37526i = 0L;
                this.f37527j = 0L;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37519b : (n) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37520c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37521d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37521d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37520c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37522e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37522e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37520c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37518a : (Parser) invokeV.objValue;
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
                int computeBytesSize = (this.f37520c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37520c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37520c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f37520c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f37520c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f37525h);
                }
                if ((this.f37520c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f37526i);
                }
                if ((this.f37520c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f37527j);
                }
                if ((this.f37520c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
                }
                if ((this.f37520c & 256) == 256) {
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
                Object obj = this.f37523f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37523f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37520c & 8) == 8 : invokeV.booleanValue;
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
                Object obj = this.f37524g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37524g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37520c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37525h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37520c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37526i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37520c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37527j : invokeV.longValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f37520c & 128) == 128 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.f37520c & 256) == 256 : invokeV.booleanValue;
        }

        public long t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C1603a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? a(this) : (C1603a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C1603a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? u() : (C1603a) invokeV.objValue;
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
                if ((this.f37520c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37520c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37520c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f37520c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f37520c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f37525h);
                }
                if ((this.f37520c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f37526i);
                }
                if ((this.f37520c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37527j);
                }
                if ((this.f37520c & 128) == 128) {
                    codedOutputStream.writeBytes(8, r());
                }
                if ((this.f37520c & 256) == 256) {
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
        public static Parser<p> f37538a;

        /* renamed from: b  reason: collision with root package name */
        public static final p f37539b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37540c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37541d;

        /* renamed from: e  reason: collision with root package name */
        public byte f37542e;

        /* renamed from: f  reason: collision with root package name */
        public int f37543f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1604a extends GeneratedMessageLite.Builder<p, C1604a> implements q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37544a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37545b;

            public C1604a() {
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
                this.f37545b = "";
                h();
            }

            private void h() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1604a i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1604a() : (C1604a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1604a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37545b = "";
                    this.f37544a &= -2;
                    return this;
                }
                return (C1604a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1604a mergeFrom(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar)) == null) {
                    if (pVar != p.a() && pVar.c()) {
                        this.f37544a |= 1;
                        this.f37545b = pVar.f37541d;
                    }
                    return this;
                }
                return (C1604a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1604a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    p pVar = null;
                    try {
                        try {
                            p parsePartialFrom = p.f37538a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1604a) invokeLL.objValue;
            }

            public C1604a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.f37544a |= 1;
                        this.f37545b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1604a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1604a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i().mergeFrom(buildPartial()) : (C1604a) invokeV.objValue;
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
                    int i2 = (this.f37544a & 1) != 1 ? 0 : 1;
                    pVar.f37541d = this.f37545b;
                    pVar.f37540c = i2;
                    return pVar;
                }
                return (p) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.f37544a & 1) == 1 : invokeV.booleanValue;
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
            f37538a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
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
            f37539b = pVar;
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
            this.f37542e = (byte) -1;
            this.f37543f = -1;
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
            this.f37542e = (byte) -1;
            this.f37543f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 34) {
                                    this.f37540c |= 1;
                                    this.f37541d = codedInputStream.readBytes();
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
            this.f37542e = (byte) -1;
            this.f37543f = -1;
        }

        public /* synthetic */ p(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1604a a(p pVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pVar)) == null) ? e().mergeFrom(pVar) : (C1604a) invokeL.objValue;
        }

        public static p a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37539b : (p) invokeV.objValue;
        }

        public static C1604a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1604a.i() : (C1604a) invokeV.objValue;
        }

        private void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.f37541d = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37539b : (p) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37540c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37541d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37541d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C1604a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e() : (C1604a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C1604a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this) : (C1604a) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f37538a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f37543f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37540c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
                this.f37543f = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                byte b2 = this.f37542e;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (c()) {
                    this.f37542e = (byte) 1;
                    return true;
                } else {
                    this.f37542e = (byte) 0;
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
                if ((this.f37540c & 1) == 1) {
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
        public static Parser<r> f37546a;

        /* renamed from: b  reason: collision with root package name */
        public static final r f37547b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37548c;

        /* renamed from: d  reason: collision with root package name */
        public int f37549d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37550e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37551f;

        /* renamed from: g  reason: collision with root package name */
        public byte f37552g;

        /* renamed from: h  reason: collision with root package name */
        public int f37553h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1605a extends GeneratedMessageLite.Builder<r, C1605a> implements s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37554a;

            /* renamed from: b  reason: collision with root package name */
            public int f37555b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37556c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37557d;

            public C1605a() {
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
                this.f37555b = 7399;
                this.f37556c = "push_im_client";
                this.f37557d = "phonebaidu";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1605a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1605a() : (C1605a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1605a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37555b = 7399;
                    int i2 = this.f37554a & (-2);
                    this.f37554a = i2;
                    this.f37556c = "push_im_client";
                    int i3 = i2 & (-3);
                    this.f37554a = i3;
                    this.f37557d = "phonebaidu";
                    this.f37554a = i3 & (-5);
                    return this;
                }
                return (C1605a) invokeV.objValue;
            }

            public C1605a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f37554a |= 1;
                    this.f37555b = i2;
                    return this;
                }
                return (C1605a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1605a mergeFrom(r rVar) {
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
                        this.f37554a |= 2;
                        this.f37556c = rVar.f37550e;
                    }
                    if (rVar.g()) {
                        this.f37554a |= 4;
                        this.f37557d = rVar.f37551f;
                    }
                    return this;
                }
                return (C1605a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1605a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    r rVar = null;
                    try {
                        try {
                            r parsePartialFrom = r.f37546a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1605a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1605a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1605a) invokeV.objValue;
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
                    int i2 = this.f37554a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    rVar.f37549d = this.f37555b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    rVar.f37550e = this.f37556c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    rVar.f37551f = this.f37557d;
                    rVar.f37548c = i3;
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
            f37546a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
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
            f37547b = rVar;
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
            this.f37552g = (byte) -1;
            this.f37553h = -1;
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
            this.f37552g = (byte) -1;
            this.f37553h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f37548c |= 1;
                                this.f37549d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f37548c |= 2;
                                this.f37550e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f37548c |= 4;
                                this.f37551f = codedInputStream.readBytes();
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
            this.f37552g = (byte) -1;
            this.f37553h = -1;
        }

        public /* synthetic */ r(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1605a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, rVar)) == null) ? i().mergeFrom(rVar) : (C1605a) invokeL.objValue;
        }

        public static r a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37547b : (r) invokeV.objValue;
        }

        public static C1605a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1605a.h() : (C1605a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f37549d = 7399;
                this.f37550e = "push_im_client";
                this.f37551f = "phonebaidu";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37547b : (r) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37548c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37549d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37548c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37550e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37550e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37548c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37546a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37553h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f37548c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f37549d) : 0;
                if ((this.f37548c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37548c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f37553h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37551f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37551f = copyFromUtf8;
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
                byte b2 = this.f37552g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37552g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1605a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1605a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1605a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1605a) invokeV.objValue;
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
                if ((this.f37548c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f37549d);
                }
                if ((this.f37548c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37548c & 4) == 4) {
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
        public static Parser<t> f37558a;

        /* renamed from: b  reason: collision with root package name */
        public static final t f37559b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37560c;

        /* renamed from: d  reason: collision with root package name */
        public long f37561d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37562e;

        /* renamed from: f  reason: collision with root package name */
        public long f37563f;

        /* renamed from: g  reason: collision with root package name */
        public long f37564g;

        /* renamed from: h  reason: collision with root package name */
        public Object f37565h;

        /* renamed from: i  reason: collision with root package name */
        public long f37566i;

        /* renamed from: j  reason: collision with root package name */
        public long f37567j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1606a extends GeneratedMessageLite.Builder<t, C1606a> implements u {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37568a;

            /* renamed from: b  reason: collision with root package name */
            public long f37569b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37570c;

            /* renamed from: d  reason: collision with root package name */
            public long f37571d;

            /* renamed from: e  reason: collision with root package name */
            public long f37572e;

            /* renamed from: f  reason: collision with root package name */
            public Object f37573f;

            /* renamed from: g  reason: collision with root package name */
            public long f37574g;

            /* renamed from: h  reason: collision with root package name */
            public long f37575h;

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
                this.f37570c = "";
                this.f37573f = "";
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
                    this.f37569b = 0L;
                    int i2 = this.f37568a & (-2);
                    this.f37568a = i2;
                    this.f37570c = "";
                    int i3 = i2 & (-3);
                    this.f37568a = i3;
                    this.f37571d = 0L;
                    int i4 = i3 & (-5);
                    this.f37568a = i4;
                    this.f37572e = 0L;
                    int i5 = i4 & (-9);
                    this.f37568a = i5;
                    this.f37573f = "";
                    int i6 = i5 & (-17);
                    this.f37568a = i6;
                    this.f37574g = 0L;
                    int i7 = i6 & (-33);
                    this.f37568a = i7;
                    this.f37575h = 0L;
                    this.f37568a = i7 & (-65);
                    return this;
                }
                return (C1606a) invokeV.objValue;
            }

            public C1606a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37568a |= 1;
                    this.f37569b = j2;
                    return this;
                }
                return (C1606a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1606a mergeFrom(t tVar) {
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
                        this.f37568a |= 2;
                        this.f37570c = tVar.f37562e;
                    }
                    if (tVar.g()) {
                        b(tVar.h());
                    }
                    if (tVar.i()) {
                        c(tVar.j());
                    }
                    if (tVar.k()) {
                        this.f37568a |= 16;
                        this.f37573f = tVar.f37565h;
                    }
                    if (tVar.m()) {
                        d(tVar.n());
                    }
                    if (tVar.o()) {
                        e(tVar.p());
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    t tVar = null;
                    try {
                        try {
                            t parsePartialFrom = t.f37558a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1606a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1606a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1606a) invokeV.objValue;
            }

            public C1606a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.f37568a |= 4;
                    this.f37571d = j2;
                    return this;
                }
                return (C1606a) invokeJ.objValue;
            }

            public C1606a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.f37568a |= 8;
                    this.f37572e = j2;
                    return this;
                }
                return (C1606a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? t.a() : (t) invokeV.objValue;
            }

            public C1606a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.f37568a |= 32;
                    this.f37574g = j2;
                    return this;
                }
                return (C1606a) invokeJ.objValue;
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

            public C1606a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.f37568a |= 64;
                    this.f37575h = j2;
                    return this;
                }
                return (C1606a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    t tVar = new t(this, (AnonymousClass1) null);
                    int i2 = this.f37568a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    tVar.f37561d = this.f37569b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    tVar.f37562e = this.f37570c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    tVar.f37563f = this.f37571d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    tVar.f37564g = this.f37572e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    tVar.f37565h = this.f37573f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    tVar.f37566i = this.f37574g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    tVar.f37567j = this.f37575h;
                    tVar.f37560c = i3;
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
            f37558a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
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
            f37559b = tVar;
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
                                this.f37560c |= 1;
                                this.f37561d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f37560c |= 2;
                                this.f37562e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f37560c |= 4;
                                this.f37563f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f37560c |= 8;
                                this.f37564g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f37560c |= 16;
                                this.f37565h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f37560c |= 32;
                                this.f37566i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f37560c |= 64;
                                this.f37567j = codedInputStream.readInt64();
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

        public static C1606a a(t tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tVar)) == null) ? q().mergeFrom(tVar) : (C1606a) invokeL.objValue;
        }

        public static t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f37559b : (t) invokeV.objValue;
        }

        public static C1606a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1606a.h() : (C1606a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f37561d = 0L;
                this.f37562e = "";
                this.f37563f = 0L;
                this.f37564g = 0L;
                this.f37565h = "";
                this.f37566i = 0L;
                this.f37567j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37559b : (t) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37560c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37561d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37560c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37562e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37562e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37560c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37558a : (Parser) invokeV.objValue;
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
                int computeInt64Size = (this.f37560c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f37561d) : 0;
                if ((this.f37560c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f37560c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f37563f);
                }
                if ((this.f37560c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f37564g);
                }
                if ((this.f37560c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f37560c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f37566i);
                }
                if ((this.f37560c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f37567j);
                }
                this.l = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37563f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37560c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37564g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f37560c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f37565h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37565h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f37560c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37566i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f37560c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37567j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1606a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1606a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1606a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1606a) invokeV.objValue;
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
                if ((this.f37560c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f37561d);
                }
                if ((this.f37560c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f37560c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f37563f);
                }
                if ((this.f37560c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f37564g);
                }
                if ((this.f37560c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f37560c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f37566i);
                }
                if ((this.f37560c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f37567j);
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
        public static Parser<v> f37576a;

        /* renamed from: b  reason: collision with root package name */
        public static final v f37577b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37578c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37579d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37580e;

        /* renamed from: f  reason: collision with root package name */
        public byte f37581f;

        /* renamed from: g  reason: collision with root package name */
        public int f37582g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1607a extends GeneratedMessageLite.Builder<v, C1607a> implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37583a;

            /* renamed from: b  reason: collision with root package name */
            public Object f37584b;

            /* renamed from: c  reason: collision with root package name */
            public Object f37585c;

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
                this.f37584b = "";
                this.f37585c = "";
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
                    this.f37584b = "";
                    int i2 = this.f37583a & (-2);
                    this.f37583a = i2;
                    this.f37585c = "";
                    this.f37583a = i2 & (-3);
                    return this;
                }
                return (C1607a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1607a mergeFrom(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar)) == null) {
                    if (vVar == v.a()) {
                        return this;
                    }
                    if (vVar.c()) {
                        this.f37583a |= 1;
                        this.f37584b = vVar.f37579d;
                    }
                    if (vVar.e()) {
                        this.f37583a |= 2;
                        this.f37585c = vVar.f37580e;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite)) == null) {
                    v vVar = null;
                    try {
                        try {
                            v parsePartialFrom = v.f37576a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1607a) invokeLL.objValue;
            }

            public C1607a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.f37583a |= 1;
                        this.f37584b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1607a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1607a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1607a) invokeV.objValue;
            }

            public C1607a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.f37583a |= 2;
                        this.f37585c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1607a) invokeL.objValue;
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
                    int i2 = this.f37583a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    vVar.f37579d = this.f37584b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    vVar.f37580e = this.f37585c;
                    vVar.f37578c = i3;
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
            f37576a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
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
            f37577b = vVar;
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
            this.f37581f = (byte) -1;
            this.f37582g = -1;
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
            this.f37581f = (byte) -1;
            this.f37582g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f37578c |= 1;
                                    this.f37579d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f37578c |= 2;
                                    this.f37580e = codedInputStream.readBytes();
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
            this.f37581f = (byte) -1;
            this.f37582g = -1;
        }

        public /* synthetic */ v(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1607a a(v vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, vVar)) == null) ? g().mergeFrom(vVar) : (C1607a) invokeL.objValue;
        }

        public static v a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37577b : (v) invokeV.objValue;
        }

        public static C1607a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? C1607a.h() : (C1607a) invokeV.objValue;
        }

        private void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.f37579d = "";
                this.f37580e = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37577b : (v) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37578c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f37579d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37579d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37578c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f37580e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37580e = copyFromUtf8;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f37576a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f37582g;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f37578c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f37578c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                this.f37582g = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C1607a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g() : (C1607a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C1607a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? a(this) : (C1607a) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.f37581f;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f37581f = (byte) 1;
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
                if ((this.f37578c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f37578c & 2) == 2) {
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
        public static final x f37586a;

        /* renamed from: b  reason: collision with root package name */
        public static final x f37587b;

        /* renamed from: c  reason: collision with root package name */
        public static final x f37588c;

        /* renamed from: d  reason: collision with root package name */
        public static final x f37589d;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ x[] f37590f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f37591e;

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
            f37586a = new x("OS_TYPE_UNKNWON", 0, 0);
            f37587b = new x("IOS", 1, 1);
            f37588c = new x("ANDROID", 2, 2);
            x xVar = new x("WINDOWSPHONE", 3, 3);
            f37589d = xVar;
            f37590f = new x[]{f37586a, f37587b, f37588c, xVar};
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
            this.f37591e = i3;
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
                            return f37589d;
                        }
                        return f37588c;
                    }
                    return f37587b;
                }
                return f37586a;
            }
            return (x) invokeI.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37591e : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class y extends GeneratedMessageLite implements z {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f37592a;

        /* renamed from: b  reason: collision with root package name */
        public static final y f37593b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f37594c;

        /* renamed from: d  reason: collision with root package name */
        public r f37595d;

        /* renamed from: e  reason: collision with root package name */
        public h f37596e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37597f;

        /* renamed from: g  reason: collision with root package name */
        public long f37598g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f37599h;

        /* renamed from: i  reason: collision with root package name */
        public byte f37600i;

        /* renamed from: j  reason: collision with root package name */
        public int f37601j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1608a extends GeneratedMessageLite.Builder<y, C1608a> implements z {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f37602a;

            /* renamed from: b  reason: collision with root package name */
            public r f37603b;

            /* renamed from: c  reason: collision with root package name */
            public h f37604c;

            /* renamed from: d  reason: collision with root package name */
            public Object f37605d;

            /* renamed from: e  reason: collision with root package name */
            public long f37606e;

            /* renamed from: f  reason: collision with root package name */
            public List<c> f37607f;

            public C1608a() {
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
                this.f37603b = r.a();
                this.f37604c = h.a();
                this.f37605d = "";
                this.f37607f = Collections.emptyList();
                i();
            }

            private void i() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1608a j() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1608a() : (C1608a) invokeV.objValue;
            }

            private void k() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (this.f37602a & 16) == 16) {
                    return;
                }
                this.f37607f = new ArrayList(this.f37607f);
                this.f37602a |= 16;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1608a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f37603b = r.a();
                    this.f37602a &= -2;
                    this.f37604c = h.a();
                    int i2 = this.f37602a & (-3);
                    this.f37602a = i2;
                    this.f37605d = "";
                    int i3 = i2 & (-5);
                    this.f37602a = i3;
                    this.f37606e = 0L;
                    this.f37602a = i3 & (-9);
                    this.f37607f = Collections.emptyList();
                    this.f37602a &= -17;
                    return this;
                }
                return (C1608a) invokeV.objValue;
            }

            public C1608a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.f37602a |= 8;
                    this.f37606e = j2;
                    return this;
                }
                return (C1608a) invokeJ.objValue;
            }

            public C1608a a(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
                    if (hVar != null) {
                        this.f37604c = hVar;
                        this.f37602a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1608a) invokeL.objValue;
            }

            public C1608a a(r rVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rVar)) == null) {
                    if ((this.f37602a & 1) == 1 && this.f37603b != r.a()) {
                        rVar = r.a(this.f37603b).mergeFrom(rVar).buildPartial();
                    }
                    this.f37603b = rVar;
                    this.f37602a |= 1;
                    return this;
                }
                return (C1608a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1608a mergeFrom(y yVar) {
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
                        this.f37602a |= 4;
                        this.f37605d = yVar.f37597f;
                    }
                    if (yVar.i()) {
                        a(yVar.j());
                    }
                    if (!yVar.f37599h.isEmpty()) {
                        if (this.f37607f.isEmpty()) {
                            this.f37607f = yVar.f37599h;
                            this.f37602a &= -17;
                        } else {
                            k();
                            this.f37607f.addAll(yVar.f37599h);
                        }
                    }
                    return this;
                }
                return (C1608a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1608a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, codedInputStream, extensionRegistryLite)) == null) {
                    y yVar = null;
                    try {
                        try {
                            y parsePartialFrom = y.f37592a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                return (C1608a) invokeLL.objValue;
            }

            public C1608a a(Iterable<? extends c> iterable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iterable)) == null) {
                    k();
                    AbstractMessageLite.Builder.addAll(iterable, this.f37607f);
                    return this;
                }
                return (C1608a) invokeL.objValue;
            }

            public C1608a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.f37602a |= 4;
                        this.f37605d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1608a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1608a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? j().mergeFrom(buildPartial()) : (C1608a) invokeV.objValue;
            }

            public C1608a b(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hVar)) == null) {
                    if ((this.f37602a & 2) == 2 && this.f37604c != h.a()) {
                        hVar = h.a(this.f37604c).mergeFrom(hVar).buildPartial();
                    }
                    this.f37604c = hVar;
                    this.f37602a |= 2;
                    return this;
                }
                return (C1608a) invokeL.objValue;
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
                    int i2 = this.f37602a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    yVar.f37595d = this.f37603b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    yVar.f37596e = this.f37604c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    yVar.f37597f = this.f37605d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    yVar.f37598g = this.f37606e;
                    if ((this.f37602a & 16) == 16) {
                        this.f37607f = Collections.unmodifiableList(this.f37607f);
                        this.f37602a &= -17;
                    }
                    yVar.f37599h = this.f37607f;
                    yVar.f37594c = i3;
                    return yVar;
                }
                return (y) invokeV.objValue;
            }

            public boolean f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.f37602a & 2) == 2 : invokeV.booleanValue;
            }

            public h g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f37604c : (h) invokeV.objValue;
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
            f37592a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
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
            f37593b = yVar;
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
            this.f37600i = (byte) -1;
            this.f37601j = -1;
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
            this.f37600i = (byte) -1;
            this.f37601j = -1;
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
                                    r.C1605a builder = (this.f37594c & 1) == 1 ? this.f37595d.toBuilder() : null;
                                    r rVar = (r) codedInputStream.readMessage(r.f37546a, extensionRegistryLite);
                                    this.f37595d = rVar;
                                    if (builder != null) {
                                        builder.mergeFrom(rVar);
                                        this.f37595d = builder.buildPartial();
                                    }
                                    i2 = this.f37594c;
                                } else if (readTag == 330) {
                                    i5 = 2;
                                    h.C1600a builder2 = (this.f37594c & 2) == 2 ? this.f37596e.toBuilder() : null;
                                    h hVar = (h) codedInputStream.readMessage(h.f37467a, extensionRegistryLite);
                                    this.f37596e = hVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(hVar);
                                        this.f37596e = builder2.buildPartial();
                                    }
                                    i2 = this.f37594c;
                                } else if (readTag == 1042) {
                                    this.f37594c |= 4;
                                    this.f37597f = codedInputStream.readBytes();
                                } else if (readTag == 1048) {
                                    this.f37594c |= 8;
                                    this.f37598g = codedInputStream.readInt64();
                                } else if (readTag == 1058) {
                                    if (!(z2 & true)) {
                                        this.f37599h = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.f37599h.add(codedInputStream.readMessage(c.f37427a, extensionRegistryLite));
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f37594c = i2 | i5;
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
                        this.f37599h = Collections.unmodifiableList(this.f37599h);
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
            this.f37600i = (byte) -1;
            this.f37601j = -1;
        }

        public /* synthetic */ y(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1608a a(y yVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, yVar)) == null) ? k().mergeFrom(yVar) : (C1608a) invokeL.objValue;
        }

        public static y a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f37593b : (y) invokeV.objValue;
        }

        public static C1608a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? C1608a.j() : (C1608a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.f37595d = r.a();
                this.f37596e = h.a();
                this.f37597f = "";
                this.f37598g = 0L;
                this.f37599h = Collections.emptyList();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f37593b : (y) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f37594c & 1) == 1 : invokeV.booleanValue;
        }

        public r d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37595d : (r) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f37594c & 2) == 2 : invokeV.booleanValue;
        }

        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37596e : (h) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f37594c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f37592a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f37601j;
                if (i2 != -1) {
                    return i2;
                }
                int computeMessageSize = (this.f37594c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f37595d) + 0 : 0;
                if ((this.f37594c & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f37596e);
                }
                if ((this.f37594c & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.f37594c & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f37598g);
                }
                for (int i3 = 0; i3 < this.f37599h.size(); i3++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f37599h.get(i3));
                }
                this.f37601j = computeMessageSize;
                return computeMessageSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f37597f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f37597f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f37594c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f37600i;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (!e()) {
                    this.f37600i = (byte) 0;
                    return false;
                } else if (f().isInitialized()) {
                    this.f37600i = (byte) 1;
                    return true;
                } else {
                    this.f37600i = (byte) 0;
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37598g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1608a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? k() : (C1608a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1608a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(this) : (C1608a) invokeV.objValue;
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
                if ((this.f37594c & 1) == 1) {
                    codedOutputStream.writeMessage(25, this.f37595d);
                }
                if ((this.f37594c & 2) == 2) {
                    codedOutputStream.writeMessage(41, this.f37596e);
                }
                if ((this.f37594c & 4) == 4) {
                    codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.f37594c & 8) == 8) {
                    codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f37598g);
                }
                for (int i2 = 0; i2 < this.f37599h.size(); i2++) {
                    codedOutputStream.writeMessage(132, this.f37599h.get(i2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
