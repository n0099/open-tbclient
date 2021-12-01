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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1664a extends GeneratedMessageLite implements b {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<C1664a> a;

        /* renamed from: b  reason: collision with root package name */
        public static final C1664a f32509b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32510c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32511d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32512e;

        /* renamed from: f  reason: collision with root package name */
        public long f32513f;

        /* renamed from: g  reason: collision with root package name */
        public Object f32514g;

        /* renamed from: h  reason: collision with root package name */
        public long f32515h;

        /* renamed from: i  reason: collision with root package name */
        public byte f32516i;

        /* renamed from: j  reason: collision with root package name */
        public int f32517j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1665a extends GeneratedMessageLite.Builder<C1664a, C1665a> implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32518b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32519c;

            /* renamed from: d  reason: collision with root package name */
            public long f32520d;

            /* renamed from: e  reason: collision with root package name */
            public Object f32521e;

            /* renamed from: f  reason: collision with root package name */
            public long f32522f;

            public C1665a() {
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
                this.f32518b = "";
                this.f32519c = "";
                this.f32521e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1665a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1665a() : (C1665a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1665a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32518b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32519c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32520d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32521e = "";
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32522f = 0L;
                    this.a = i5 & (-17);
                    return this;
                }
                return (C1665a) invokeV.objValue;
            }

            public C1665a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 4;
                    this.f32520d = j2;
                    return this;
                }
                return (C1665a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1665a mergeFrom(C1664a c1664a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1664a)) == null) {
                    if (c1664a == C1664a.a()) {
                        return this;
                    }
                    if (c1664a.c()) {
                        this.a |= 1;
                        this.f32518b = c1664a.f32511d;
                    }
                    if (c1664a.e()) {
                        this.a |= 2;
                        this.f32519c = c1664a.f32512e;
                    }
                    if (c1664a.g()) {
                        a(c1664a.h());
                    }
                    if (c1664a.i()) {
                        this.a |= 8;
                        this.f32521e = c1664a.f32514g;
                    }
                    if (c1664a.k()) {
                        b(c1664a.l());
                    }
                    return this;
                }
                return (C1665a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1665a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, codedInputStream, extensionRegistryLite)) == null) {
                    C1664a c1664a = null;
                    try {
                        try {
                            C1664a parsePartialFrom = C1664a.a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C1664a c1664a2 = (C1664a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c1664a = c1664a2;
                                if (c1664a != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1664a != null) {
                            mergeFrom(c1664a);
                        }
                        throw th;
                    }
                }
                return (C1665a) invokeLL.objValue;
            }

            public C1665a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32518b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1665a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1665a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1665a) invokeV.objValue;
            }

            public C1665a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 16;
                    this.f32522f = j2;
                    return this;
                }
                return (C1665a) invokeJ.objValue;
            }

            public C1665a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1665a) invokeL.objValue;
            }

            public C1665a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                    if (str != null) {
                        this.a |= 8;
                        this.f32521e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1665a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C1664a getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? C1664a.a() : (C1664a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C1664a build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    C1664a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (C1664a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C1664a buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    C1664a c1664a = new C1664a(this, (AnonymousClass1) null);
                    int i2 = this.a;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    c1664a.f32511d = this.f32518b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    c1664a.f32512e = this.f32519c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    c1664a.f32513f = this.f32520d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    c1664a.f32514g = this.f32521e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    c1664a.f32515h = this.f32522f;
                    c1664a.f32510c = i3;
                    return c1664a;
                }
                return (C1664a) invokeV.objValue;
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
            a = new AbstractParser<C1664a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
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
                public C1664a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new C1664a(codedInputStream, extensionRegistryLite, null) : (C1664a) invokeLL.objValue;
                }
            };
            C1664a c1664a = new C1664a();
            f32509b = c1664a;
            c1664a.p();
        }

        public C1664a() {
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
            this.f32516i = (byte) -1;
            this.f32517j = -1;
        }

        public C1664a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.f32516i = (byte) -1;
            this.f32517j = -1;
            p();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f32510c |= 1;
                                this.f32511d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f32510c |= 2;
                                this.f32512e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f32510c |= 4;
                                this.f32513f = codedInputStream.readInt64();
                            } else if (readTag == 34) {
                                this.f32510c |= 8;
                                this.f32514g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f32510c |= 16;
                                this.f32515h = codedInputStream.readInt64();
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

        public /* synthetic */ C1664a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1664a(GeneratedMessageLite.Builder builder) {
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
            this.f32516i = (byte) -1;
            this.f32517j = -1;
        }

        public /* synthetic */ C1664a(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1665a a(C1664a c1664a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c1664a)) == null) ? m().mergeFrom(c1664a) : (C1665a) invokeL.objValue;
        }

        public static C1664a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32509b : (C1664a) invokeV.objValue;
        }

        public static C1665a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1665a.h() : (C1665a) invokeV.objValue;
        }

        private void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f32511d = "";
                this.f32512e = "";
                this.f32513f = 0L;
                this.f32514g = "";
                this.f32515h = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C1664a getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32509b : (C1664a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32510c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32511d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32511d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32510c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32512e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32512e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32510c & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C1664a> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int i2 = this.f32517j;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f32510c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32510c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32510c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f32513f);
                }
                if ((this.f32510c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f32510c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f32515h);
                }
                this.f32517j = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32513f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32510c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32516i;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32516i = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f32514g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32514g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32510c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32515h : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C1665a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? a(this) : (C1665a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C1665a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? m() : (C1665a) invokeV.objValue;
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
                if ((this.f32510c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32510c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32510c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f32513f);
                }
                if ((this.f32510c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f32510c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f32515h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class aa extends GeneratedMessageLite implements ab {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<aa> a;

        /* renamed from: b  reason: collision with root package name */
        public static final aa f32523b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32524c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32525d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32526e;

        /* renamed from: f  reason: collision with root package name */
        public long f32527f;

        /* renamed from: g  reason: collision with root package name */
        public long f32528g;

        /* renamed from: h  reason: collision with root package name */
        public long f32529h;

        /* renamed from: i  reason: collision with root package name */
        public Object f32530i;

        /* renamed from: j  reason: collision with root package name */
        public long f32531j;

        /* renamed from: k  reason: collision with root package name */
        public byte f32532k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1666a extends GeneratedMessageLite.Builder<aa, C1666a> implements ab {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32533b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32534c;

            /* renamed from: d  reason: collision with root package name */
            public long f32535d;

            /* renamed from: e  reason: collision with root package name */
            public long f32536e;

            /* renamed from: f  reason: collision with root package name */
            public long f32537f;

            /* renamed from: g  reason: collision with root package name */
            public Object f32538g;

            /* renamed from: h  reason: collision with root package name */
            public long f32539h;

            public C1666a() {
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
                this.f32533b = "";
                this.f32534c = "";
                this.f32538g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1666a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1666a() : (C1666a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1666a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32533b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32534c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32535d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32536e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32537f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f32538g = "";
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f32539h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1666a) invokeV.objValue;
            }

            public C1666a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 4;
                    this.f32535d = j2;
                    return this;
                }
                return (C1666a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1666a mergeFrom(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar == aa.a()) {
                        return this;
                    }
                    if (aaVar.c()) {
                        this.a |= 1;
                        this.f32533b = aaVar.f32525d;
                    }
                    if (aaVar.e()) {
                        this.a |= 2;
                        this.f32534c = aaVar.f32526e;
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
                        this.f32538g = aaVar.f32530i;
                    }
                    if (aaVar.o()) {
                        d(aaVar.p());
                    }
                    return this;
                }
                return (C1666a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1666a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1666a) invokeLL.objValue;
            }

            public C1666a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32533b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1666a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1666a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1666a) invokeV.objValue;
            }

            public C1666a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 8;
                    this.f32536e = j2;
                    return this;
                }
                return (C1666a) invokeJ.objValue;
            }

            public C1666a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f32534c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1666a) invokeL.objValue;
            }

            public C1666a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.a |= 16;
                    this.f32537f = j2;
                    return this;
                }
                return (C1666a) invokeJ.objValue;
            }

            public C1666a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.a |= 32;
                        this.f32538g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1666a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? aa.a() : (aa) invokeV.objValue;
            }

            public C1666a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.a |= 64;
                    this.f32539h = j2;
                    return this;
                }
                return (C1666a) invokeJ.objValue;
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
                    aaVar.f32525d = this.f32533b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aaVar.f32526e = this.f32534c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aaVar.f32527f = this.f32535d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aaVar.f32528g = this.f32536e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aaVar.f32529h = this.f32537f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aaVar.f32530i = this.f32538g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aaVar.f32531j = this.f32539h;
                    aaVar.f32524c = i3;
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
            a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
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
            f32523b = aaVar;
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
            this.f32532k = (byte) -1;
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
            this.f32532k = (byte) -1;
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
                                    this.f32524c |= 1;
                                    this.f32525d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f32524c |= 2;
                                    this.f32526e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f32524c |= 4;
                                    this.f32527f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f32524c |= 8;
                                    this.f32528g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f32524c |= 16;
                                    this.f32529h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f32524c |= 32;
                                    this.f32530i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f32524c |= 64;
                                    this.f32531j = codedInputStream.readInt64();
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
            this.f32532k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ aa(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1666a a(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aaVar)) == null) ? q().mergeFrom(aaVar) : (C1666a) invokeL.objValue;
        }

        public static aa a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32523b : (aa) invokeV.objValue;
        }

        public static C1666a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1666a.h() : (C1666a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f32525d = "";
                this.f32526e = "";
                this.f32527f = 0L;
                this.f32528g = 0L;
                this.f32529h = 0L;
                this.f32530i = "";
                this.f32531j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32523b : (aa) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32524c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32525d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32525d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32524c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32526e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32526e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32524c & 4) == 4 : invokeV.booleanValue;
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
                int computeBytesSize = (this.f32524c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32524c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32524c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f32527f);
                }
                if ((this.f32524c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f32528g);
                }
                if ((this.f32524c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f32529h);
                }
                if ((this.f32524c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f32524c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f32531j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32527f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32524c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32532k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32532k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32528g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32524c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32529h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32524c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f32530i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32530i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32524c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32531j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1666a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1666a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1666a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1666a) invokeV.objValue;
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
                if ((this.f32524c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32524c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32524c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f32527f);
                }
                if ((this.f32524c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f32528g);
                }
                if ((this.f32524c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f32529h);
                }
                if ((this.f32524c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f32524c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f32531j);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class ac extends GeneratedMessageLite implements ad {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<ac> a;

        /* renamed from: b  reason: collision with root package name */
        public static final ac f32540b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32541c;

        /* renamed from: d  reason: collision with root package name */
        public x f32542d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32543e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32544f;

        /* renamed from: g  reason: collision with root package name */
        public Object f32545g;

        /* renamed from: h  reason: collision with root package name */
        public int f32546h;

        /* renamed from: i  reason: collision with root package name */
        public int f32547i;

        /* renamed from: j  reason: collision with root package name */
        public int f32548j;

        /* renamed from: k  reason: collision with root package name */
        public byte f32549k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1667a extends GeneratedMessageLite.Builder<ac, C1667a> implements ad {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public x f32550b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32551c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32552d;

            /* renamed from: e  reason: collision with root package name */
            public Object f32553e;

            /* renamed from: f  reason: collision with root package name */
            public int f32554f;

            /* renamed from: g  reason: collision with root package name */
            public int f32555g;

            /* renamed from: h  reason: collision with root package name */
            public int f32556h;

            public C1667a() {
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
                this.f32550b = x.a;
                this.f32551c = "";
                this.f32552d = "";
                this.f32553e = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1667a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1667a() : (C1667a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1667a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32550b = x.a;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32551c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32552d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32553e = "";
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32554f = 0;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f32555g = 0;
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f32556h = 0;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1667a) invokeV.objValue;
            }

            public C1667a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.a |= 16;
                    this.f32554f = i2;
                    return this;
                }
                return (C1667a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1667a mergeFrom(ac acVar) {
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
                        this.f32551c = acVar.f32543e;
                    }
                    if (acVar.g()) {
                        this.a |= 4;
                        this.f32552d = acVar.f32544f;
                    }
                    if (acVar.i()) {
                        this.a |= 8;
                        this.f32553e = acVar.f32545g;
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
                return (C1667a) invokeL.objValue;
            }

            public C1667a a(x xVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xVar)) == null) {
                    if (xVar != null) {
                        this.a |= 1;
                        this.f32550b = xVar;
                        return this;
                    }
                    throw null;
                }
                return (C1667a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1667a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1667a) invokeLL.objValue;
            }

            public C1667a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f32551c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1667a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1667a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h().mergeFrom(buildPartial()) : (C1667a) invokeV.objValue;
            }

            public C1667a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                    this.a |= 32;
                    this.f32555g = i2;
                    return this;
                }
                return (C1667a) invokeI.objValue;
            }

            public C1667a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f32552d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1667a) invokeL.objValue;
            }

            public C1667a c(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                    this.a |= 64;
                    this.f32556h = i2;
                    return this;
                }
                return (C1667a) invokeI.objValue;
            }

            public C1667a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                    if (str != null) {
                        this.a |= 8;
                        this.f32553e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1667a) invokeL.objValue;
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
                    acVar.f32542d = this.f32550b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    acVar.f32543e = this.f32551c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    acVar.f32544f = this.f32552d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    acVar.f32545g = this.f32553e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    acVar.f32546h = this.f32554f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    acVar.f32547i = this.f32555g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    acVar.f32548j = this.f32556h;
                    acVar.f32541c = i3;
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
            a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
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
            f32540b = acVar;
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
            this.f32549k = (byte) -1;
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
            this.f32549k = (byte) -1;
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
                                    this.f32541c = 1 | this.f32541c;
                                    this.f32542d = a2;
                                }
                            } else if (readTag == 18) {
                                this.f32541c |= 2;
                                this.f32543e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f32541c |= 4;
                                this.f32544f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f32541c |= 8;
                                this.f32545g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f32541c |= 16;
                                this.f32546h = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.f32541c |= 32;
                                this.f32547i = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.f32541c |= 64;
                                this.f32548j = codedInputStream.readInt32();
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
            this.f32549k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ ac(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1667a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, acVar)) == null) ? q().mergeFrom(acVar) : (C1667a) invokeL.objValue;
        }

        public static ac a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f32540b : (ac) invokeV.objValue;
        }

        public static C1667a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1667a.h() : (C1667a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f32542d = x.a;
                this.f32543e = "";
                this.f32544f = "";
                this.f32545g = "";
                this.f32546h = 0;
                this.f32547i = 0;
                this.f32548j = 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32540b : (ac) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32541c & 1) == 1 : invokeV.booleanValue;
        }

        public x d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32542d : (x) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32541c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32543e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32543e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32541c & 4) == 4 : invokeV.booleanValue;
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
                int computeEnumSize = (this.f32541c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f32542d.getNumber()) : 0;
                if ((this.f32541c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32541c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f32541c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f32541c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f32546h);
                }
                if ((this.f32541c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f32547i);
                }
                if ((this.f32541c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.f32548j);
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
                Object obj = this.f32544f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32544f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32541c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32549k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32549k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public ByteString j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.f32545g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32545g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32541c & 16) == 16 : invokeV.booleanValue;
        }

        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32546h : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32541c & 32) == 32 : invokeV.booleanValue;
        }

        public int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f32547i : invokeV.intValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32541c & 64) == 64 : invokeV.booleanValue;
        }

        public int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32548j : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1667a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1667a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1667a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1667a) invokeV.objValue;
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
                if ((this.f32541c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f32542d.getNumber());
                }
                if ((this.f32541c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32541c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f32541c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f32541c & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.f32546h);
                }
                if ((this.f32541c & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.f32547i);
                }
                if ((this.f32541c & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.f32548j);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class ae extends GeneratedMessageLite implements af {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<ae> a;

        /* renamed from: b  reason: collision with root package name */
        public static final ae f32557b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32558c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32559d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32560e;

        /* renamed from: f  reason: collision with root package name */
        public long f32561f;

        /* renamed from: g  reason: collision with root package name */
        public long f32562g;

        /* renamed from: h  reason: collision with root package name */
        public long f32563h;

        /* renamed from: i  reason: collision with root package name */
        public Object f32564i;

        /* renamed from: j  reason: collision with root package name */
        public long f32565j;

        /* renamed from: k  reason: collision with root package name */
        public byte f32566k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1668a extends GeneratedMessageLite.Builder<ae, C1668a> implements af {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32567b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32568c;

            /* renamed from: d  reason: collision with root package name */
            public long f32569d;

            /* renamed from: e  reason: collision with root package name */
            public long f32570e;

            /* renamed from: f  reason: collision with root package name */
            public long f32571f;

            /* renamed from: g  reason: collision with root package name */
            public Object f32572g;

            /* renamed from: h  reason: collision with root package name */
            public long f32573h;

            public C1668a() {
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
                this.f32567b = "";
                this.f32568c = "";
                this.f32572g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1668a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1668a() : (C1668a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1668a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32567b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32568c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32569d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32570e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32571f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f32572g = "";
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f32573h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1668a) invokeV.objValue;
            }

            public C1668a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 4;
                    this.f32569d = j2;
                    return this;
                }
                return (C1668a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1668a mergeFrom(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aeVar)) == null) {
                    if (aeVar == ae.a()) {
                        return this;
                    }
                    if (aeVar.c()) {
                        this.a |= 1;
                        this.f32567b = aeVar.f32559d;
                    }
                    if (aeVar.e()) {
                        this.a |= 2;
                        this.f32568c = aeVar.f32560e;
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
                        this.f32572g = aeVar.f32564i;
                    }
                    if (aeVar.o()) {
                        d(aeVar.p());
                    }
                    return this;
                }
                return (C1668a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1668a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1668a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1668a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1668a) invokeV.objValue;
            }

            public C1668a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.a |= 8;
                    this.f32570e = j2;
                    return this;
                }
                return (C1668a) invokeJ.objValue;
            }

            public C1668a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.a |= 16;
                    this.f32571f = j2;
                    return this;
                }
                return (C1668a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ae.a() : (ae) invokeV.objValue;
            }

            public C1668a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.a |= 64;
                    this.f32573h = j2;
                    return this;
                }
                return (C1668a) invokeJ.objValue;
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
                    aeVar.f32559d = this.f32567b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    aeVar.f32560e = this.f32568c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    aeVar.f32561f = this.f32569d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    aeVar.f32562g = this.f32570e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    aeVar.f32563h = this.f32571f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    aeVar.f32564i = this.f32572g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    aeVar.f32565j = this.f32573h;
                    aeVar.f32558c = i3;
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
            a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
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
            f32557b = aeVar;
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
            this.f32566k = (byte) -1;
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
            this.f32566k = (byte) -1;
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
                                    this.f32558c |= 1;
                                    this.f32559d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f32558c |= 2;
                                    this.f32560e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f32558c |= 4;
                                    this.f32561f = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.f32558c |= 8;
                                    this.f32562g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f32558c |= 16;
                                    this.f32563h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f32558c |= 32;
                                    this.f32564i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f32558c |= 64;
                                    this.f32565j = codedInputStream.readInt64();
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
            this.f32566k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ ae(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1668a a(ae aeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aeVar)) == null) ? q().mergeFrom(aeVar) : (C1668a) invokeL.objValue;
        }

        public static ae a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32557b : (ae) invokeV.objValue;
        }

        public static C1668a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1668a.h() : (C1668a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f32559d = "";
                this.f32560e = "";
                this.f32561f = 0L;
                this.f32562g = 0L;
                this.f32563h = 0L;
                this.f32564i = "";
                this.f32565j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32557b : (ae) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32558c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32559d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32559d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32558c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32560e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32560e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32558c & 4) == 4 : invokeV.booleanValue;
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
                int computeBytesSize = (this.f32558c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32558c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32558c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f32561f);
                }
                if ((this.f32558c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f32562g);
                }
                if ((this.f32558c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f32563h);
                }
                if ((this.f32558c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f32558c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f32565j);
                }
                this.l = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32561f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32558c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32566k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32566k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32562g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32558c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32563h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32558c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f32564i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32564i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32558c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32565j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1668a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1668a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1668a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1668a) invokeV.objValue;
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
                if ((this.f32558c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32558c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32558c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f32561f);
                }
                if ((this.f32558c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f32562g);
                }
                if ((this.f32558c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f32563h);
                }
                if ((this.f32558c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f32558c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f32565j);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class c extends GeneratedMessageLite implements d {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<c> a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f32574b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32575c;

        /* renamed from: d  reason: collision with root package name */
        public e f32576d;

        /* renamed from: e  reason: collision with root package name */
        public ae f32577e;

        /* renamed from: f  reason: collision with root package name */
        public l f32578f;

        /* renamed from: g  reason: collision with root package name */
        public n f32579g;

        /* renamed from: h  reason: collision with root package name */
        public j f32580h;

        /* renamed from: i  reason: collision with root package name */
        public aa f32581i;

        /* renamed from: j  reason: collision with root package name */
        public C1664a f32582j;

        /* renamed from: k  reason: collision with root package name */
        public t f32583k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1669a extends GeneratedMessageLite.Builder<c, C1669a> implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public e f32584b;

            /* renamed from: c  reason: collision with root package name */
            public ae f32585c;

            /* renamed from: d  reason: collision with root package name */
            public l f32586d;

            /* renamed from: e  reason: collision with root package name */
            public n f32587e;

            /* renamed from: f  reason: collision with root package name */
            public j f32588f;

            /* renamed from: g  reason: collision with root package name */
            public aa f32589g;

            /* renamed from: h  reason: collision with root package name */
            public C1664a f32590h;

            /* renamed from: i  reason: collision with root package name */
            public t f32591i;

            public C1669a() {
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
                this.f32584b = e.a;
                this.f32585c = ae.a();
                this.f32586d = l.a();
                this.f32587e = n.a();
                this.f32588f = j.a();
                this.f32589g = aa.a();
                this.f32590h = C1664a.a();
                this.f32591i = t.a();
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1669a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1669a() : (C1669a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1669a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32584b = e.a;
                    this.a &= -2;
                    this.f32585c = ae.a();
                    this.a &= -3;
                    this.f32586d = l.a();
                    this.a &= -5;
                    this.f32587e = n.a();
                    this.a &= -9;
                    this.f32588f = j.a();
                    this.a &= -17;
                    this.f32589g = aa.a();
                    this.a &= -33;
                    this.f32590h = C1664a.a();
                    this.a &= -65;
                    this.f32591i = t.a();
                    this.a &= -129;
                    return this;
                }
                return (C1669a) invokeV.objValue;
            }

            public C1669a a(C1664a c1664a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1664a)) == null) {
                    if (c1664a != null) {
                        this.f32590h = c1664a;
                        this.a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aaVar)) == null) {
                    if (aaVar != null) {
                        this.f32589g = aaVar;
                        this.a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(ae aeVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aeVar)) == null) {
                    if ((this.a & 2) == 2 && this.f32585c != ae.a()) {
                        aeVar = ae.a(this.f32585c).mergeFrom(aeVar).buildPartial();
                    }
                    this.f32585c = aeVar;
                    this.a |= 2;
                    return this;
                }
                return (C1669a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1669a mergeFrom(c cVar) {
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
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(e eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
                    if (eVar != null) {
                        this.a |= 1;
                        this.f32584b = eVar;
                        return this;
                    }
                    throw null;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                    if (jVar != null) {
                        this.f32588f = jVar;
                        this.a |= 16;
                        return this;
                    }
                    throw null;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
                    if (lVar != null) {
                        this.f32586d = lVar;
                        this.a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) {
                    if (nVar != null) {
                        this.f32587e = nVar;
                        this.a |= 8;
                        return this;
                    }
                    throw null;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a a(t tVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tVar)) == null) {
                    if ((this.a & 128) == 128 && this.f32591i != t.a()) {
                        tVar = t.a(this.f32591i).mergeFrom(tVar).buildPartial();
                    }
                    this.f32591i = tVar;
                    this.a |= 128;
                    return this;
                }
                return (C1669a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1669a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1669a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1669a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? h().mergeFrom(buildPartial()) : (C1669a) invokeV.objValue;
            }

            public C1669a b(C1664a c1664a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, c1664a)) == null) {
                    if ((this.a & 64) == 64 && this.f32590h != C1664a.a()) {
                        c1664a = C1664a.a(this.f32590h).mergeFrom(c1664a).buildPartial();
                    }
                    this.f32590h = c1664a;
                    this.a |= 64;
                    return this;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a b(aa aaVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aaVar)) == null) {
                    if ((this.a & 32) == 32 && this.f32589g != aa.a()) {
                        aaVar = aa.a(this.f32589g).mergeFrom(aaVar).buildPartial();
                    }
                    this.f32589g = aaVar;
                    this.a |= 32;
                    return this;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a b(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jVar)) == null) {
                    if ((this.a & 16) == 16 && this.f32588f != j.a()) {
                        jVar = j.a(this.f32588f).mergeFrom(jVar).buildPartial();
                    }
                    this.f32588f = jVar;
                    this.a |= 16;
                    return this;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a b(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, lVar)) == null) {
                    if ((this.a & 4) == 4 && this.f32586d != l.a()) {
                        lVar = l.a(this.f32586d).mergeFrom(lVar).buildPartial();
                    }
                    this.f32586d = lVar;
                    this.a |= 4;
                    return this;
                }
                return (C1669a) invokeL.objValue;
            }

            public C1669a b(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, nVar)) == null) {
                    if ((this.a & 8) == 8 && this.f32587e != n.a()) {
                        nVar = n.a(this.f32587e).mergeFrom(nVar).buildPartial();
                    }
                    this.f32587e = nVar;
                    this.a |= 8;
                    return this;
                }
                return (C1669a) invokeL.objValue;
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
                    cVar.f32576d = this.f32584b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.f32577e = this.f32585c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.f32578f = this.f32586d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.f32579g = this.f32587e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    cVar.f32580h = this.f32588f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    cVar.f32581i = this.f32589g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    cVar.f32582j = this.f32590h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    cVar.f32583k = this.f32591i;
                    cVar.f32575c = i3;
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
            a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
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
            f32574b = cVar;
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
                                        ae.C1668a builder = (this.f32575c & 2) == 2 ? this.f32577e.toBuilder() : null;
                                        ae aeVar = (ae) codedInputStream.readMessage(ae.a, extensionRegistryLite);
                                        this.f32577e = aeVar;
                                        if (builder != null) {
                                            builder.mergeFrom(aeVar);
                                            this.f32577e = builder.buildPartial();
                                        }
                                        i3 = this.f32575c;
                                    } else if (readTag == 26) {
                                        i2 = 4;
                                        l.C1673a builder2 = (this.f32575c & 4) == 4 ? this.f32578f.toBuilder() : null;
                                        l lVar = (l) codedInputStream.readMessage(l.a, extensionRegistryLite);
                                        this.f32578f = lVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(lVar);
                                            this.f32578f = builder2.buildPartial();
                                        }
                                        i3 = this.f32575c;
                                    } else if (readTag == 34) {
                                        n.C1674a builder3 = (this.f32575c & 8) == 8 ? this.f32579g.toBuilder() : null;
                                        n nVar = (n) codedInputStream.readMessage(n.a, extensionRegistryLite);
                                        this.f32579g = nVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(nVar);
                                            this.f32579g = builder3.buildPartial();
                                        }
                                        this.f32575c |= 8;
                                    } else if (readTag == 42) {
                                        i2 = 16;
                                        j.C1672a builder4 = (this.f32575c & 16) == 16 ? this.f32580h.toBuilder() : null;
                                        j jVar = (j) codedInputStream.readMessage(j.a, extensionRegistryLite);
                                        this.f32580h = jVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(jVar);
                                            this.f32580h = builder4.buildPartial();
                                        }
                                        i3 = this.f32575c;
                                    } else if (readTag == 50) {
                                        i2 = 32;
                                        aa.C1666a builder5 = (this.f32575c & 32) == 32 ? this.f32581i.toBuilder() : null;
                                        aa aaVar = (aa) codedInputStream.readMessage(aa.a, extensionRegistryLite);
                                        this.f32581i = aaVar;
                                        if (builder5 != null) {
                                            builder5.mergeFrom(aaVar);
                                            this.f32581i = builder5.buildPartial();
                                        }
                                        i3 = this.f32575c;
                                    } else if (readTag == 58) {
                                        i2 = 64;
                                        C1664a.C1665a builder6 = (this.f32575c & 64) == 64 ? this.f32582j.toBuilder() : null;
                                        C1664a c1664a = (C1664a) codedInputStream.readMessage(C1664a.a, extensionRegistryLite);
                                        this.f32582j = c1664a;
                                        if (builder6 != null) {
                                            builder6.mergeFrom(c1664a);
                                            this.f32582j = builder6.buildPartial();
                                        }
                                        i3 = this.f32575c;
                                    } else if (readTag == 66) {
                                        i2 = 128;
                                        t.C1677a builder7 = (this.f32575c & 128) == 128 ? this.f32583k.toBuilder() : null;
                                        t tVar = (t) codedInputStream.readMessage(t.a, extensionRegistryLite);
                                        this.f32583k = tVar;
                                        if (builder7 != null) {
                                            builder7.mergeFrom(tVar);
                                            this.f32583k = builder7.buildPartial();
                                        }
                                        i3 = this.f32575c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f32575c = i3 | i2;
                                } else {
                                    e a2 = e.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f32575c = 1 | this.f32575c;
                                        this.f32576d = a2;
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

        public static C1669a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cVar)) == null) ? s().mergeFrom(cVar) : (C1669a) invokeL.objValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f32574b : (c) invokeV.objValue;
        }

        public static C1669a s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? C1669a.h() : (C1669a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.f32576d = e.a;
                this.f32577e = ae.a();
                this.f32578f = l.a();
                this.f32579g = n.a();
                this.f32580h = j.a();
                this.f32581i = aa.a();
                this.f32582j = C1664a.a();
                this.f32583k = t.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32574b : (c) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32575c & 1) == 1 : invokeV.booleanValue;
        }

        public e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32576d : (e) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32575c & 2) == 2 : invokeV.booleanValue;
        }

        public ae f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32577e : (ae) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32575c & 4) == 4 : invokeV.booleanValue;
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
                int computeEnumSize = (this.f32575c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f32576d.getNumber()) : 0;
                if ((this.f32575c & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f32577e);
                }
                if ((this.f32575c & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f32578f);
                }
                if ((this.f32575c & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f32579g);
                }
                if ((this.f32575c & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f32580h);
                }
                if ((this.f32575c & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f32581i);
                }
                if ((this.f32575c & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(7, this.f32582j);
                }
                if ((this.f32575c & 128) == 128) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(8, this.f32583k);
                }
                this.m = computeEnumSize;
                return computeEnumSize;
            }
            return invokeV.intValue;
        }

        public l h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32578f : (l) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32575c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32579g : (n) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32575c & 16) == 16 : invokeV.booleanValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32580h : (j) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32575c & 32) == 32 : invokeV.booleanValue;
        }

        public aa n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f32581i : (aa) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32575c & 64) == 64 : invokeV.booleanValue;
        }

        public C1664a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32582j : (C1664a) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f32575c & 128) == 128 : invokeV.booleanValue;
        }

        public t r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f32583k : (t) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C1669a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? s() : (C1669a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1669a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1669a) invokeV.objValue;
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
                if ((this.f32575c & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.f32576d.getNumber());
                }
                if ((this.f32575c & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.f32577e);
                }
                if ((this.f32575c & 4) == 4) {
                    codedOutputStream.writeMessage(3, this.f32578f);
                }
                if ((this.f32575c & 8) == 8) {
                    codedOutputStream.writeMessage(4, this.f32579g);
                }
                if ((this.f32575c & 16) == 16) {
                    codedOutputStream.writeMessage(5, this.f32580h);
                }
                if ((this.f32575c & 32) == 32) {
                    codedOutputStream.writeMessage(6, this.f32581i);
                }
                if ((this.f32575c & 64) == 64) {
                    codedOutputStream.writeMessage(7, this.f32582j);
                }
                if ((this.f32575c & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.f32583k);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class e implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f32592b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f32593c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f32594d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f32595e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f32596f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f32597g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ e[] f32598i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f32599h;

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
            a = new e("UI", 0, 101);
            f32592b = new e("CRASH", 1, 201);
            f32593c = new e("DB", 2, 301);
            f32594d = new e("CONNECTION", 3, 401);
            f32595e = new e("REQUEST", 4, 501);
            f32596f = new e("ACK", 5, 601);
            e eVar = new e("MSG", 6, 701);
            f32597g = eVar;
            f32598i = new e[]{a, f32592b, f32593c, f32594d, f32595e, f32596f, eVar};
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
            this.f32599h = i3;
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
                                        return f32597g;
                                    }
                                    return f32596f;
                                }
                                return f32595e;
                            }
                            return f32594d;
                        }
                        return f32593c;
                    }
                    return f32592b;
                }
                return a;
            }
            return (e) invokeI.objValue;
        }

        public static e[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f32598i.clone() : (e[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32599h : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends GeneratedMessageLite implements g {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<f> a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f32600b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32601c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32602d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32603e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32604f;

        /* renamed from: g  reason: collision with root package name */
        public byte f32605g;

        /* renamed from: h  reason: collision with root package name */
        public int f32606h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1670a extends GeneratedMessageLite.Builder<f, C1670a> implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32607b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32608c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32609d;

            public C1670a() {
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
                this.f32607b = "";
                this.f32608c = "";
                this.f32609d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1670a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1670a() : (C1670a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1670a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32607b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32608c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32609d = "";
                    this.a = i3 & (-5);
                    return this;
                }
                return (C1670a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1670a mergeFrom(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
                    if (fVar == f.a()) {
                        return this;
                    }
                    if (fVar.c()) {
                        this.a |= 1;
                        this.f32607b = fVar.f32602d;
                    }
                    if (fVar.e()) {
                        this.a |= 2;
                        this.f32608c = fVar.f32603e;
                    }
                    if (fVar.g()) {
                        this.a |= 4;
                        this.f32609d = fVar.f32604f;
                    }
                    return this;
                }
                return (C1670a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1670a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1670a) invokeLL.objValue;
            }

            public C1670a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32607b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1670a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1670a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1670a) invokeV.objValue;
            }

            public C1670a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f32608c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1670a) invokeL.objValue;
            }

            public C1670a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f32609d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1670a) invokeL.objValue;
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
                    fVar.f32602d = this.f32607b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    fVar.f32603e = this.f32608c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    fVar.f32604f = this.f32609d;
                    fVar.f32601c = i3;
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
            a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
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
            f32600b = fVar;
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
            this.f32605g = (byte) -1;
            this.f32606h = -1;
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
            this.f32605g = (byte) -1;
            this.f32606h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f32601c |= 1;
                                this.f32602d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f32601c |= 2;
                                this.f32603e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f32601c |= 4;
                                this.f32604f = codedInputStream.readBytes();
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
            this.f32605g = (byte) -1;
            this.f32606h = -1;
        }

        public /* synthetic */ f(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1670a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) ? i().mergeFrom(fVar) : (C1670a) invokeL.objValue;
        }

        public static f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f32600b : (f) invokeV.objValue;
        }

        public static C1670a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1670a.h() : (C1670a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f32602d = "";
                this.f32603e = "";
                this.f32604f = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32600b : (f) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32601c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32602d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32602d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32601c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32603e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32603e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32601c & 4) == 4 : invokeV.booleanValue;
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
                int i2 = this.f32606h;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f32601c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32601c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32601c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f32606h = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f32604f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32604f = copyFromUtf8;
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
                byte b2 = this.f32605g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32605g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1670a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1670a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1670a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1670a) invokeV.objValue;
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
                if ((this.f32601c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32601c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32601c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class h extends GeneratedMessageLite implements i {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<h> a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f32610b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32611c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32612d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32613e;

        /* renamed from: f  reason: collision with root package name */
        public p f32614f;

        /* renamed from: g  reason: collision with root package name */
        public long f32615g;

        /* renamed from: h  reason: collision with root package name */
        public long f32616h;

        /* renamed from: i  reason: collision with root package name */
        public ac f32617i;

        /* renamed from: j  reason: collision with root package name */
        public f f32618j;

        /* renamed from: k  reason: collision with root package name */
        public v f32619k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1671a extends GeneratedMessageLite.Builder<h, C1671a> implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32620b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32621c;

            /* renamed from: d  reason: collision with root package name */
            public p f32622d;

            /* renamed from: e  reason: collision with root package name */
            public long f32623e;

            /* renamed from: f  reason: collision with root package name */
            public long f32624f;

            /* renamed from: g  reason: collision with root package name */
            public ac f32625g;

            /* renamed from: h  reason: collision with root package name */
            public f f32626h;

            /* renamed from: i  reason: collision with root package name */
            public v f32627i;

            public C1671a() {
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
                this.f32620b = "";
                this.f32621c = "";
                this.f32622d = p.a();
                this.f32625g = ac.a();
                this.f32626h = f.a();
                this.f32627i = v.a();
                j();
            }

            private void j() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1671a k() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1671a() : (C1671a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1671a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32620b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32621c = "";
                    this.a = i2 & (-3);
                    this.f32622d = p.a();
                    int i3 = this.a & (-5);
                    this.a = i3;
                    this.f32623e = 0L;
                    int i4 = i3 & (-9);
                    this.a = i4;
                    this.f32624f = 0L;
                    this.a = i4 & (-17);
                    this.f32625g = ac.a();
                    this.a &= -33;
                    this.f32626h = f.a();
                    this.a &= -65;
                    this.f32627i = v.a();
                    this.a &= -129;
                    return this;
                }
                return (C1671a) invokeV.objValue;
            }

            public C1671a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 8;
                    this.f32623e = j2;
                    return this;
                }
                return (C1671a) invokeJ.objValue;
            }

            public C1671a a(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acVar)) == null) {
                    if (acVar != null) {
                        this.f32625g = acVar;
                        this.a |= 32;
                        return this;
                    }
                    throw null;
                }
                return (C1671a) invokeL.objValue;
            }

            public C1671a a(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                    if (fVar != null) {
                        this.f32626h = fVar;
                        this.a |= 64;
                        return this;
                    }
                    throw null;
                }
                return (C1671a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1671a mergeFrom(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
                    if (hVar == h.a()) {
                        return this;
                    }
                    if (hVar.c()) {
                        this.a |= 1;
                        this.f32620b = hVar.f32612d;
                    }
                    if (hVar.e()) {
                        this.a |= 2;
                        this.f32621c = hVar.f32613e;
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
                return (C1671a) invokeL.objValue;
            }

            public C1671a a(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pVar)) == null) {
                    if (pVar != null) {
                        this.f32622d = pVar;
                        this.a |= 4;
                        return this;
                    }
                    throw null;
                }
                return (C1671a) invokeL.objValue;
            }

            public C1671a a(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vVar)) == null) {
                    if (vVar != null) {
                        this.f32627i = vVar;
                        this.a |= 128;
                        return this;
                    }
                    throw null;
                }
                return (C1671a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1671a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1671a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1671a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? k().mergeFrom(buildPartial()) : (C1671a) invokeV.objValue;
            }

            public C1671a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                    this.a |= 16;
                    this.f32624f = j2;
                    return this;
                }
                return (C1671a) invokeJ.objValue;
            }

            public C1671a b(ac acVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, acVar)) == null) {
                    if ((this.a & 32) == 32 && this.f32625g != ac.a()) {
                        acVar = ac.a(this.f32625g).mergeFrom(acVar).buildPartial();
                    }
                    this.f32625g = acVar;
                    this.a |= 32;
                    return this;
                }
                return (C1671a) invokeL.objValue;
            }

            public C1671a b(f fVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
                    if ((this.a & 64) == 64 && this.f32626h != f.a()) {
                        fVar = f.a(this.f32626h).mergeFrom(fVar).buildPartial();
                    }
                    this.f32626h = fVar;
                    this.a |= 64;
                    return this;
                }
                return (C1671a) invokeL.objValue;
            }

            public C1671a b(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pVar)) == null) {
                    if ((this.a & 4) == 4 && this.f32622d != p.a()) {
                        pVar = p.a(this.f32622d).mergeFrom(pVar).buildPartial();
                    }
                    this.f32622d = pVar;
                    this.a |= 4;
                    return this;
                }
                return (C1671a) invokeL.objValue;
            }

            public C1671a b(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vVar)) == null) {
                    if ((this.a & 128) == 128 && this.f32627i != v.a()) {
                        vVar = v.a(this.f32627i).mergeFrom(vVar).buildPartial();
                    }
                    this.f32627i = vVar;
                    this.a |= 128;
                    return this;
                }
                return (C1671a) invokeL.objValue;
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
                    hVar.f32612d = this.f32620b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    hVar.f32613e = this.f32621c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    hVar.f32614f = this.f32622d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    hVar.f32615g = this.f32623e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    hVar.f32616h = this.f32624f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    hVar.f32617i = this.f32625g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    hVar.f32618j = this.f32626h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    hVar.f32619k = this.f32627i;
                    hVar.f32611c = i3;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f32622d : (p) invokeV.objValue;
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
            a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
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
            f32610b = hVar;
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
                                    this.f32611c |= 1;
                                    this.f32612d = codedInputStream.readBytes();
                                } else if (readTag != 18) {
                                    if (readTag == 58) {
                                        i2 = 4;
                                        p.C1675a builder = (this.f32611c & 4) == 4 ? this.f32614f.toBuilder() : null;
                                        p pVar = (p) codedInputStream.readMessage(p.a, extensionRegistryLite);
                                        this.f32614f = pVar;
                                        if (builder != null) {
                                            builder.mergeFrom(pVar);
                                            this.f32614f = builder.buildPartial();
                                        }
                                        i3 = this.f32611c;
                                    } else if (readTag == 80) {
                                        this.f32611c |= 8;
                                        this.f32615g = codedInputStream.readInt64();
                                    } else if (readTag == 96) {
                                        this.f32611c |= 16;
                                        this.f32616h = codedInputStream.readInt64();
                                    } else if (readTag == 162) {
                                        i2 = 32;
                                        ac.C1667a builder2 = (this.f32611c & 32) == 32 ? this.f32617i.toBuilder() : null;
                                        ac acVar = (ac) codedInputStream.readMessage(ac.a, extensionRegistryLite);
                                        this.f32617i = acVar;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(acVar);
                                            this.f32617i = builder2.buildPartial();
                                        }
                                        i3 = this.f32611c;
                                    } else if (readTag == 170) {
                                        i2 = 64;
                                        f.C1670a builder3 = (this.f32611c & 64) == 64 ? this.f32618j.toBuilder() : null;
                                        f fVar = (f) codedInputStream.readMessage(f.a, extensionRegistryLite);
                                        this.f32618j = fVar;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(fVar);
                                            this.f32618j = builder3.buildPartial();
                                        }
                                        i3 = this.f32611c;
                                    } else if (readTag == 178) {
                                        i2 = 128;
                                        v.C1678a builder4 = (this.f32611c & 128) == 128 ? this.f32619k.toBuilder() : null;
                                        v vVar = (v) codedInputStream.readMessage(v.a, extensionRegistryLite);
                                        this.f32619k = vVar;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(vVar);
                                            this.f32619k = builder4.buildPartial();
                                        }
                                        i3 = this.f32611c;
                                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                    this.f32611c = i3 | i2;
                                } else {
                                    this.f32611c |= 2;
                                    this.f32613e = codedInputStream.readBytes();
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

        public static C1671a a(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hVar)) == null) ? t().mergeFrom(hVar) : (C1671a) invokeL.objValue;
        }

        public static h a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f32610b : (h) invokeV.objValue;
        }

        public static C1671a t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? C1671a.k() : (C1671a) invokeV.objValue;
        }

        private void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                this.f32612d = "";
                this.f32613e = "";
                this.f32614f = p.a();
                this.f32615g = 0L;
                this.f32616h = 0L;
                this.f32617i = ac.a();
                this.f32618j = f.a();
                this.f32619k = v.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32610b : (h) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32611c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32612d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32612d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32611c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32613e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32613e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32611c & 4) == 4 : invokeV.booleanValue;
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
                int computeBytesSize = (this.f32611c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32611c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32611c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f32614f);
                }
                if ((this.f32611c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f32615g);
                }
                if ((this.f32611c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f32616h);
                }
                if ((this.f32611c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f32617i);
                }
                if ((this.f32611c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(21, this.f32618j);
                }
                if ((this.f32611c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeMessageSize(22, this.f32619k);
                }
                this.m = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public p h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32614f : (p) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32611c & 8) == 8 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32615g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32611c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32616h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32611c & 32) == 32 : invokeV.booleanValue;
        }

        public ac n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f32617i : (ac) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32611c & 64) == 64 : invokeV.booleanValue;
        }

        public f p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32618j : (f) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f32611c & 128) == 128 : invokeV.booleanValue;
        }

        public v r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f32619k : (v) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1671a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? t() : (C1671a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C1671a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? a(this) : (C1671a) invokeV.objValue;
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
                if ((this.f32611c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32611c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32611c & 4) == 4) {
                    codedOutputStream.writeMessage(7, this.f32614f);
                }
                if ((this.f32611c & 8) == 8) {
                    codedOutputStream.writeInt64(10, this.f32615g);
                }
                if ((this.f32611c & 16) == 16) {
                    codedOutputStream.writeInt64(12, this.f32616h);
                }
                if ((this.f32611c & 32) == 32) {
                    codedOutputStream.writeMessage(20, this.f32617i);
                }
                if ((this.f32611c & 64) == 64) {
                    codedOutputStream.writeMessage(21, this.f32618j);
                }
                if ((this.f32611c & 128) == 128) {
                    codedOutputStream.writeMessage(22, this.f32619k);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class j extends GeneratedMessageLite implements k {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<j> a;

        /* renamed from: b  reason: collision with root package name */
        public static final j f32628b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32629c;

        /* renamed from: d  reason: collision with root package name */
        public long f32630d;

        /* renamed from: e  reason: collision with root package name */
        public long f32631e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32632f;

        /* renamed from: g  reason: collision with root package name */
        public long f32633g;

        /* renamed from: h  reason: collision with root package name */
        public long f32634h;

        /* renamed from: i  reason: collision with root package name */
        public Object f32635i;

        /* renamed from: j  reason: collision with root package name */
        public long f32636j;

        /* renamed from: k  reason: collision with root package name */
        public byte f32637k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1672a extends GeneratedMessageLite.Builder<j, C1672a> implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public long f32638b;

            /* renamed from: c  reason: collision with root package name */
            public long f32639c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32640d;

            /* renamed from: e  reason: collision with root package name */
            public long f32641e;

            /* renamed from: f  reason: collision with root package name */
            public long f32642f;

            /* renamed from: g  reason: collision with root package name */
            public Object f32643g;

            /* renamed from: h  reason: collision with root package name */
            public long f32644h;

            public C1672a() {
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
                this.f32640d = "";
                this.f32643g = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1672a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1672a() : (C1672a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1672a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32638b = 0L;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32639c = 0L;
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32640d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32641e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32642f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f32643g = "";
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f32644h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1672a) invokeV.objValue;
            }

            public C1672a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 1;
                    this.f32638b = j2;
                    return this;
                }
                return (C1672a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1672a mergeFrom(j jVar) {
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
                        this.f32640d = jVar.f32632f;
                    }
                    if (jVar.i()) {
                        c(jVar.j());
                    }
                    if (jVar.k()) {
                        d(jVar.l());
                    }
                    if (jVar.m()) {
                        this.a |= 32;
                        this.f32643g = jVar.f32635i;
                    }
                    if (jVar.o()) {
                        e(jVar.p());
                    }
                    return this;
                }
                return (C1672a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1672a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1672a) invokeLL.objValue;
            }

            public C1672a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f32640d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1672a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1672a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1672a) invokeV.objValue;
            }

            public C1672a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 2;
                    this.f32639c = j2;
                    return this;
                }
                return (C1672a) invokeJ.objValue;
            }

            public C1672a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 32;
                        this.f32643g = str;
                        return this;
                    }
                    throw null;
                }
                return (C1672a) invokeL.objValue;
            }

            public C1672a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.a |= 8;
                    this.f32641e = j2;
                    return this;
                }
                return (C1672a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j.a() : (j) invokeV.objValue;
            }

            public C1672a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.a |= 16;
                    this.f32642f = j2;
                    return this;
                }
                return (C1672a) invokeJ.objValue;
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

            public C1672a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
                    this.a |= 64;
                    this.f32644h = j2;
                    return this;
                }
                return (C1672a) invokeJ.objValue;
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
                    jVar.f32630d = this.f32638b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    jVar.f32631e = this.f32639c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    jVar.f32632f = this.f32640d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    jVar.f32633g = this.f32641e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    jVar.f32634h = this.f32642f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    jVar.f32635i = this.f32643g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    jVar.f32636j = this.f32644h;
                    jVar.f32629c = i3;
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
            a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
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
            f32628b = jVar;
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
            this.f32637k = (byte) -1;
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
            this.f32637k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f32629c |= 1;
                                this.f32630d = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.f32629c |= 2;
                                this.f32631e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f32629c |= 4;
                                this.f32632f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f32629c |= 8;
                                this.f32633g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f32629c |= 16;
                                this.f32634h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f32629c |= 32;
                                this.f32635i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f32629c |= 64;
                                this.f32636j = codedInputStream.readInt64();
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
            this.f32637k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ j(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1672a a(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jVar)) == null) ? q().mergeFrom(jVar) : (C1672a) invokeL.objValue;
        }

        public static j a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32628b : (j) invokeV.objValue;
        }

        public static C1672a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1672a.h() : (C1672a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f32630d = 0L;
                this.f32631e = 0L;
                this.f32632f = "";
                this.f32633g = 0L;
                this.f32634h = 0L;
                this.f32635i = "";
                this.f32636j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32628b : (j) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32629c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32630d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32629c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32631e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32629c & 4) == 4 : invokeV.booleanValue;
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
                int computeInt64Size = (this.f32629c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f32630d) : 0;
                if ((this.f32629c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f32631e);
                }
                if ((this.f32629c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f32629c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f32633g);
                }
                if ((this.f32629c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f32634h);
                }
                if ((this.f32629c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.f32629c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f32636j);
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
                Object obj = this.f32632f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32632f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32629c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32637k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32637k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32633g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32629c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32634h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32629c & 32) == 32 : invokeV.booleanValue;
        }

        public ByteString n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                Object obj = this.f32635i;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32635i = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32629c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32636j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1672a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a(this) : (C1672a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1672a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? q() : (C1672a) invokeV.objValue;
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
                if ((this.f32629c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f32630d);
                }
                if ((this.f32629c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f32631e);
                }
                if ((this.f32629c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f32629c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f32633g);
                }
                if ((this.f32629c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f32634h);
                }
                if ((this.f32629c & 32) == 32) {
                    codedOutputStream.writeBytes(6, n());
                }
                if ((this.f32629c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f32636j);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class l extends GeneratedMessageLite implements m {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<l> a;

        /* renamed from: b  reason: collision with root package name */
        public static final l f32645b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32646c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32647d;

        /* renamed from: e  reason: collision with root package name */
        public long f32648e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32649f;

        /* renamed from: g  reason: collision with root package name */
        public long f32650g;

        /* renamed from: h  reason: collision with root package name */
        public byte f32651h;

        /* renamed from: i  reason: collision with root package name */
        public int f32652i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1673a extends GeneratedMessageLite.Builder<l, C1673a> implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32653b;

            /* renamed from: c  reason: collision with root package name */
            public long f32654c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32655d;

            /* renamed from: e  reason: collision with root package name */
            public long f32656e;

            public C1673a() {
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
                this.f32653b = "";
                this.f32655d = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1673a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1673a() : (C1673a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1673a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32653b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32654c = 0L;
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32655d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32656e = 0L;
                    this.a = i4 & (-9);
                    return this;
                }
                return (C1673a) invokeV.objValue;
            }

            public C1673a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 2;
                    this.f32654c = j2;
                    return this;
                }
                return (C1673a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1673a mergeFrom(l lVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
                    if (lVar == l.a()) {
                        return this;
                    }
                    if (lVar.c()) {
                        this.a |= 1;
                        this.f32653b = lVar.f32647d;
                    }
                    if (lVar.e()) {
                        a(lVar.f());
                    }
                    if (lVar.g()) {
                        this.a |= 4;
                        this.f32655d = lVar.f32649f;
                    }
                    if (lVar.i()) {
                        b(lVar.j());
                    }
                    return this;
                }
                return (C1673a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1673a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1673a) invokeLL.objValue;
            }

            public C1673a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32653b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1673a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1673a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1673a) invokeV.objValue;
            }

            public C1673a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 8;
                    this.f32656e = j2;
                    return this;
                }
                return (C1673a) invokeJ.objValue;
            }

            public C1673a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f32655d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1673a) invokeL.objValue;
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
                    lVar.f32647d = this.f32653b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    lVar.f32648e = this.f32654c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    lVar.f32649f = this.f32655d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    lVar.f32650g = this.f32656e;
                    lVar.f32646c = i3;
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
            a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
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
            f32645b = lVar;
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
            this.f32651h = (byte) -1;
            this.f32652i = -1;
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
            this.f32651h = (byte) -1;
            this.f32652i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f32646c |= 1;
                                this.f32647d = codedInputStream.readBytes();
                            } else if (readTag == 16) {
                                this.f32646c |= 2;
                                this.f32648e = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.f32646c |= 4;
                                this.f32649f = codedInputStream.readBytes();
                            } else if (readTag == 32) {
                                this.f32646c |= 8;
                                this.f32650g = codedInputStream.readInt64();
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
            this.f32651h = (byte) -1;
            this.f32652i = -1;
        }

        public /* synthetic */ l(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1673a a(l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lVar)) == null) ? k().mergeFrom(lVar) : (C1673a) invokeL.objValue;
        }

        public static l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32645b : (l) invokeV.objValue;
        }

        public static C1673a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? C1673a.h() : (C1673a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.f32647d = "";
                this.f32648e = 0L;
                this.f32649f = "";
                this.f32650g = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32645b : (l) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32646c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32647d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32647d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32646c & 2) == 2 : invokeV.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32648e : invokeV.longValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32646c & 4) == 4 : invokeV.booleanValue;
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
                int i2 = this.f32652i;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f32646c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32646c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f32648e);
                }
                if ((this.f32646c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f32646c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f32650g);
                }
                this.f32652i = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f32649f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32649f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32646c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32651h;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32651h = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32650g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1673a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(this) : (C1673a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1673a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? k() : (C1673a) invokeV.objValue;
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
                if ((this.f32646c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32646c & 2) == 2) {
                    codedOutputStream.writeInt64(2, this.f32648e);
                }
                if ((this.f32646c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f32646c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f32650g);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class n extends GeneratedMessageLite implements o {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<n> a;

        /* renamed from: b  reason: collision with root package name */
        public static final n f32657b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32658c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32659d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32660e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32661f;

        /* renamed from: g  reason: collision with root package name */
        public Object f32662g;

        /* renamed from: h  reason: collision with root package name */
        public long f32663h;

        /* renamed from: i  reason: collision with root package name */
        public long f32664i;

        /* renamed from: j  reason: collision with root package name */
        public long f32665j;

        /* renamed from: k  reason: collision with root package name */
        public Object f32666k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1674a extends GeneratedMessageLite.Builder<n, C1674a> implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32667b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32668c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32669d;

            /* renamed from: e  reason: collision with root package name */
            public Object f32670e;

            /* renamed from: f  reason: collision with root package name */
            public long f32671f;

            /* renamed from: g  reason: collision with root package name */
            public long f32672g;

            /* renamed from: h  reason: collision with root package name */
            public long f32673h;

            /* renamed from: i  reason: collision with root package name */
            public Object f32674i;

            /* renamed from: j  reason: collision with root package name */
            public long f32675j;

            public C1674a() {
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
                this.f32667b = "";
                this.f32668c = "";
                this.f32669d = "";
                this.f32670e = "";
                this.f32674i = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1674a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1674a() : (C1674a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1674a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32667b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32668c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32669d = "";
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32670e = "";
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32671f = 0L;
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f32672g = 0L;
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f32673h = 0L;
                    int i8 = i7 & (-65);
                    this.a = i8;
                    this.f32674i = "";
                    int i9 = i8 & (-129);
                    this.a = i9;
                    this.f32675j = 0L;
                    this.a = i9 & (-257);
                    return this;
                }
                return (C1674a) invokeV.objValue;
            }

            public C1674a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 16;
                    this.f32671f = j2;
                    return this;
                }
                return (C1674a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1674a mergeFrom(n nVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar)) == null) {
                    if (nVar == n.a()) {
                        return this;
                    }
                    if (nVar.c()) {
                        this.a |= 1;
                        this.f32667b = nVar.f32659d;
                    }
                    if (nVar.e()) {
                        this.a |= 2;
                        this.f32668c = nVar.f32660e;
                    }
                    if (nVar.g()) {
                        this.a |= 4;
                        this.f32669d = nVar.f32661f;
                    }
                    if (nVar.i()) {
                        this.a |= 8;
                        this.f32670e = nVar.f32662g;
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
                        this.f32674i = nVar.f32666k;
                    }
                    if (nVar.s()) {
                        d(nVar.t());
                    }
                    return this;
                }
                return (C1674a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1674a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1674a) invokeLL.objValue;
            }

            public C1674a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32667b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1674a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1674a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().mergeFrom(buildPartial()) : (C1674a) invokeV.objValue;
            }

            public C1674a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                    this.a |= 32;
                    this.f32672g = j2;
                    return this;
                }
                return (C1674a) invokeJ.objValue;
            }

            public C1674a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f32668c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1674a) invokeL.objValue;
            }

            public C1674a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                    this.a |= 64;
                    this.f32673h = j2;
                    return this;
                }
                return (C1674a) invokeJ.objValue;
            }

            public C1674a c(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f32669d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1674a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? n.a() : (n) invokeV.objValue;
            }

            public C1674a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j2)) == null) {
                    this.a |= 256;
                    this.f32675j = j2;
                    return this;
                }
                return (C1674a) invokeJ.objValue;
            }

            public C1674a d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                    if (str != null) {
                        this.a |= 8;
                        this.f32670e = str;
                        return this;
                    }
                    throw null;
                }
                return (C1674a) invokeL.objValue;
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

            public C1674a e(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                    if (str != null) {
                        this.a |= 128;
                        this.f32674i = str;
                        return this;
                    }
                    throw null;
                }
                return (C1674a) invokeL.objValue;
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
                    nVar.f32659d = this.f32667b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    nVar.f32660e = this.f32668c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    nVar.f32661f = this.f32669d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    nVar.f32662g = this.f32670e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    nVar.f32663h = this.f32671f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    nVar.f32664i = this.f32672g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    nVar.f32665j = this.f32673h;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    nVar.f32666k = this.f32674i;
                    if ((i2 & 256) == 256) {
                        i3 |= 256;
                    }
                    nVar.l = this.f32675j;
                    nVar.f32658c = i3;
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
            a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
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
            f32657b = nVar;
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
                                    this.f32658c |= 1;
                                    this.f32659d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f32658c |= 2;
                                    this.f32660e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f32658c |= 4;
                                    this.f32661f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f32658c |= 8;
                                    this.f32662g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f32658c |= 16;
                                    this.f32663h = codedInputStream.readInt64();
                                } else if (readTag == 48) {
                                    this.f32658c |= 32;
                                    this.f32664i = codedInputStream.readInt64();
                                } else if (readTag == 56) {
                                    this.f32658c |= 64;
                                    this.f32665j = codedInputStream.readInt64();
                                } else if (readTag == 66) {
                                    this.f32658c |= 128;
                                    this.f32666k = codedInputStream.readBytes();
                                } else if (readTag == 72) {
                                    this.f32658c |= 256;
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

        public static C1674a a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nVar)) == null) ? u().mergeFrom(nVar) : (C1674a) invokeL.objValue;
        }

        public static n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32657b : (n) invokeV.objValue;
        }

        public static C1674a u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? C1674a.h() : (C1674a) invokeV.objValue;
        }

        private void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65560, this) == null) {
                this.f32659d = "";
                this.f32660e = "";
                this.f32661f = "";
                this.f32662g = "";
                this.f32663h = 0L;
                this.f32664i = 0L;
                this.f32665j = 0L;
                this.f32666k = "";
                this.l = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32657b : (n) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32658c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32659d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32659d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32658c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32660e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32660e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32658c & 4) == 4 : invokeV.booleanValue;
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
                int computeBytesSize = (this.f32658c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32658c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32658c & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.f32658c & 8) == 8) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.f32658c & 16) == 16) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f32663h);
                }
                if ((this.f32658c & 32) == 32) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f32664i);
                }
                if ((this.f32658c & 64) == 64) {
                    computeBytesSize += CodedOutputStream.computeInt64Size(7, this.f32665j);
                }
                if ((this.f32658c & 128) == 128) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
                }
                if ((this.f32658c & 256) == 256) {
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
                Object obj = this.f32661f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32661f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32658c & 8) == 8 : invokeV.booleanValue;
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
                Object obj = this.f32662g;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32662g = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32658c & 16) == 16 : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32663h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32658c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f32664i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32658c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32665j : invokeV.longValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.f32658c & 128) == 128 : invokeV.booleanValue;
        }

        public ByteString r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                Object obj = this.f32666k;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32666k = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.f32658c & 256) == 256 : invokeV.booleanValue;
        }

        public long t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C1674a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? a(this) : (C1674a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C1674a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? u() : (C1674a) invokeV.objValue;
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
                if ((this.f32658c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32658c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32658c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
                if ((this.f32658c & 8) == 8) {
                    codedOutputStream.writeBytes(4, j());
                }
                if ((this.f32658c & 16) == 16) {
                    codedOutputStream.writeInt64(5, this.f32663h);
                }
                if ((this.f32658c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f32664i);
                }
                if ((this.f32658c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f32665j);
                }
                if ((this.f32658c & 128) == 128) {
                    codedOutputStream.writeBytes(8, r());
                }
                if ((this.f32658c & 256) == 256) {
                    codedOutputStream.writeInt64(9, this.l);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class p extends GeneratedMessageLite implements q {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<p> a;

        /* renamed from: b  reason: collision with root package name */
        public static final p f32676b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32677c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32678d;

        /* renamed from: e  reason: collision with root package name */
        public byte f32679e;

        /* renamed from: f  reason: collision with root package name */
        public int f32680f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1675a extends GeneratedMessageLite.Builder<p, C1675a> implements q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32681b;

            public C1675a() {
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
                this.f32681b = "";
                h();
            }

            private void h() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1675a i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1675a() : (C1675a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1675a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32681b = "";
                    this.a &= -2;
                    return this;
                }
                return (C1675a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1675a mergeFrom(p pVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar)) == null) {
                    if (pVar != p.a() && pVar.c()) {
                        this.a |= 1;
                        this.f32681b = pVar.f32678d;
                    }
                    return this;
                }
                return (C1675a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1675a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1675a) invokeLL.objValue;
            }

            public C1675a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32681b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1675a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1675a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i().mergeFrom(buildPartial()) : (C1675a) invokeV.objValue;
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
                    pVar.f32678d = this.f32681b;
                    pVar.f32677c = i2;
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
            a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
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
            f32676b = pVar;
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
            this.f32679e = (byte) -1;
            this.f32680f = -1;
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
            this.f32679e = (byte) -1;
            this.f32680f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 34) {
                                    this.f32677c |= 1;
                                    this.f32678d = codedInputStream.readBytes();
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
            this.f32679e = (byte) -1;
            this.f32680f = -1;
        }

        public /* synthetic */ p(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1675a a(p pVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pVar)) == null) ? e().mergeFrom(pVar) : (C1675a) invokeL.objValue;
        }

        public static p a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f32676b : (p) invokeV.objValue;
        }

        public static C1675a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? C1675a.i() : (C1675a) invokeV.objValue;
        }

        private void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.f32678d = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32676b : (p) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32677c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32678d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32678d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C1675a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e() : (C1675a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C1675a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this) : (C1675a) invokeV.objValue;
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
                int i2 = this.f32680f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f32677c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
                this.f32680f = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                byte b2 = this.f32679e;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (c()) {
                    this.f32679e = (byte) 1;
                    return true;
                } else {
                    this.f32679e = (byte) 0;
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
                if ((this.f32677c & 1) == 1) {
                    codedOutputStream.writeBytes(4, d());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class r extends GeneratedMessageLite implements s {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<r> a;

        /* renamed from: b  reason: collision with root package name */
        public static final r f32682b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32683c;

        /* renamed from: d  reason: collision with root package name */
        public int f32684d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32685e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32686f;

        /* renamed from: g  reason: collision with root package name */
        public byte f32687g;

        /* renamed from: h  reason: collision with root package name */
        public int f32688h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1676a extends GeneratedMessageLite.Builder<r, C1676a> implements s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f32689b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32690c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32691d;

            public C1676a() {
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
                this.f32689b = 7399;
                this.f32690c = "push_im_client";
                this.f32691d = "phonebaidu";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1676a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1676a() : (C1676a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1676a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32689b = 7399;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32690c = "push_im_client";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32691d = "phonebaidu";
                    this.a = i3 & (-5);
                    return this;
                }
                return (C1676a) invokeV.objValue;
            }

            public C1676a a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.a |= 1;
                    this.f32689b = i2;
                    return this;
                }
                return (C1676a) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1676a mergeFrom(r rVar) {
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
                        this.f32690c = rVar.f32685e;
                    }
                    if (rVar.g()) {
                        this.a |= 4;
                        this.f32691d = rVar.f32686f;
                    }
                    return this;
                }
                return (C1676a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1676a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1676a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1676a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1676a) invokeV.objValue;
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
                    rVar.f32684d = this.f32689b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    rVar.f32685e = this.f32690c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    rVar.f32686f = this.f32691d;
                    rVar.f32683c = i3;
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
            a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
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
            f32682b = rVar;
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
            this.f32687g = (byte) -1;
            this.f32688h = -1;
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
            this.f32687g = (byte) -1;
            this.f32688h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f32683c |= 1;
                                this.f32684d = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.f32683c |= 2;
                                this.f32685e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f32683c |= 4;
                                this.f32686f = codedInputStream.readBytes();
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
            this.f32687g = (byte) -1;
            this.f32688h = -1;
        }

        public /* synthetic */ r(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1676a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, rVar)) == null) ? i().mergeFrom(rVar) : (C1676a) invokeL.objValue;
        }

        public static r a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f32682b : (r) invokeV.objValue;
        }

        public static C1676a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1676a.h() : (C1676a) invokeV.objValue;
        }

        private void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.f32684d = 7399;
                this.f32685e = "push_im_client";
                this.f32686f = "phonebaidu";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32682b : (r) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32683c & 1) == 1 : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32684d : invokeV.intValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32683c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32685e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32685e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32683c & 4) == 4 : invokeV.booleanValue;
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
                int i2 = this.f32688h;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.f32683c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f32684d) : 0;
                if ((this.f32683c & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32683c & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
                }
                this.f32688h = computeInt32Size;
                return computeInt32Size;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f32686f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32686f = copyFromUtf8;
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
                byte b2 = this.f32687g;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32687g = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C1676a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(this) : (C1676a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C1676a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() : (C1676a) invokeV.objValue;
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
                if ((this.f32683c & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.f32684d);
                }
                if ((this.f32683c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32683c & 4) == 4) {
                    codedOutputStream.writeBytes(3, h());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class t extends GeneratedMessageLite implements u {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<t> a;

        /* renamed from: b  reason: collision with root package name */
        public static final t f32692b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32693c;

        /* renamed from: d  reason: collision with root package name */
        public long f32694d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32695e;

        /* renamed from: f  reason: collision with root package name */
        public long f32696f;

        /* renamed from: g  reason: collision with root package name */
        public long f32697g;

        /* renamed from: h  reason: collision with root package name */
        public Object f32698h;

        /* renamed from: i  reason: collision with root package name */
        public long f32699i;

        /* renamed from: j  reason: collision with root package name */
        public long f32700j;

        /* renamed from: k  reason: collision with root package name */
        public byte f32701k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1677a extends GeneratedMessageLite.Builder<t, C1677a> implements u {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public long f32702b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32703c;

            /* renamed from: d  reason: collision with root package name */
            public long f32704d;

            /* renamed from: e  reason: collision with root package name */
            public long f32705e;

            /* renamed from: f  reason: collision with root package name */
            public Object f32706f;

            /* renamed from: g  reason: collision with root package name */
            public long f32707g;

            /* renamed from: h  reason: collision with root package name */
            public long f32708h;

            public C1677a() {
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
                this.f32703c = "";
                this.f32706f = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1677a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1677a() : (C1677a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1677a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32702b = 0L;
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32703c = "";
                    int i3 = i2 & (-3);
                    this.a = i3;
                    this.f32704d = 0L;
                    int i4 = i3 & (-5);
                    this.a = i4;
                    this.f32705e = 0L;
                    int i5 = i4 & (-9);
                    this.a = i5;
                    this.f32706f = "";
                    int i6 = i5 & (-17);
                    this.a = i6;
                    this.f32707g = 0L;
                    int i7 = i6 & (-33);
                    this.a = i7;
                    this.f32708h = 0L;
                    this.a = i7 & (-65);
                    return this;
                }
                return (C1677a) invokeV.objValue;
            }

            public C1677a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 1;
                    this.f32702b = j2;
                    return this;
                }
                return (C1677a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1677a mergeFrom(t tVar) {
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
                        this.f32703c = tVar.f32695e;
                    }
                    if (tVar.g()) {
                        b(tVar.h());
                    }
                    if (tVar.i()) {
                        c(tVar.j());
                    }
                    if (tVar.k()) {
                        this.a |= 16;
                        this.f32706f = tVar.f32698h;
                    }
                    if (tVar.m()) {
                        d(tVar.n());
                    }
                    if (tVar.o()) {
                        e(tVar.p());
                    }
                    return this;
                }
                return (C1677a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1677a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1677a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1677a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1677a) invokeV.objValue;
            }

            public C1677a b(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                    this.a |= 4;
                    this.f32704d = j2;
                    return this;
                }
                return (C1677a) invokeJ.objValue;
            }

            public C1677a c(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                    this.a |= 8;
                    this.f32705e = j2;
                    return this;
                }
                return (C1677a) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? t.a() : (t) invokeV.objValue;
            }

            public C1677a d(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                    this.a |= 32;
                    this.f32707g = j2;
                    return this;
                }
                return (C1677a) invokeJ.objValue;
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

            public C1677a e(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
                    this.a |= 64;
                    this.f32708h = j2;
                    return this;
                }
                return (C1677a) invokeJ.objValue;
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
                    tVar.f32694d = this.f32702b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    tVar.f32695e = this.f32703c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    tVar.f32696f = this.f32704d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    tVar.f32697g = this.f32705e;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    tVar.f32698h = this.f32706f;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    tVar.f32699i = this.f32707g;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    tVar.f32700j = this.f32708h;
                    tVar.f32693c = i3;
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
            a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
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
            f32692b = tVar;
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
            this.f32701k = (byte) -1;
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
            this.f32701k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f32693c |= 1;
                                this.f32694d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f32693c |= 2;
                                this.f32695e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f32693c |= 4;
                                this.f32696f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f32693c |= 8;
                                this.f32697g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f32693c |= 16;
                                this.f32698h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f32693c |= 32;
                                this.f32699i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f32693c |= 64;
                                this.f32700j = codedInputStream.readInt64();
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
            this.f32701k = (byte) -1;
            this.l = -1;
        }

        public /* synthetic */ t(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1677a a(t tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tVar)) == null) ? q().mergeFrom(tVar) : (C1677a) invokeL.objValue;
        }

        public static t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f32692b : (t) invokeV.objValue;
        }

        public static C1677a q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? C1677a.h() : (C1677a) invokeV.objValue;
        }

        private void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65555, this) == null) {
                this.f32694d = 0L;
                this.f32695e = "";
                this.f32696f = 0L;
                this.f32697g = 0L;
                this.f32698h = "";
                this.f32699i = 0L;
                this.f32700j = 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32692b : (t) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32693c & 1) == 1 : invokeV.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32694d : invokeV.longValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32693c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32695e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32695e = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32693c & 4) == 4 : invokeV.booleanValue;
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
                int computeInt64Size = (this.f32693c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f32694d) : 0;
                if ((this.f32693c & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.f32693c & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f32696f);
                }
                if ((this.f32693c & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f32697g);
                }
                if ((this.f32693c & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.f32693c & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f32699i);
                }
                if ((this.f32693c & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt64Size(7, this.f32700j);
                }
                this.l = computeInt64Size;
                return computeInt64Size;
            }
            return invokeV.intValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32696f : invokeV.longValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32693c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32701k;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32701k = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32697g : invokeV.longValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.f32693c & 16) == 16 : invokeV.booleanValue;
        }

        public ByteString l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Object obj = this.f32698h;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32698h = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.f32693c & 32) == 32 : invokeV.booleanValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f32699i : invokeV.longValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f32693c & 64) == 64 : invokeV.booleanValue;
        }

        public long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f32700j : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C1677a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q() : (C1677a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C1677a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a(this) : (C1677a) invokeV.objValue;
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
                if ((this.f32693c & 1) == 1) {
                    codedOutputStream.writeInt64(1, this.f32694d);
                }
                if ((this.f32693c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
                if ((this.f32693c & 4) == 4) {
                    codedOutputStream.writeInt64(3, this.f32696f);
                }
                if ((this.f32693c & 8) == 8) {
                    codedOutputStream.writeInt64(4, this.f32697g);
                }
                if ((this.f32693c & 16) == 16) {
                    codedOutputStream.writeBytes(5, l());
                }
                if ((this.f32693c & 32) == 32) {
                    codedOutputStream.writeInt64(6, this.f32699i);
                }
                if ((this.f32693c & 64) == 64) {
                    codedOutputStream.writeInt64(7, this.f32700j);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes8.dex */
    public static final class v extends GeneratedMessageLite implements w {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<v> a;

        /* renamed from: b  reason: collision with root package name */
        public static final v f32709b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32710c;

        /* renamed from: d  reason: collision with root package name */
        public Object f32711d;

        /* renamed from: e  reason: collision with root package name */
        public Object f32712e;

        /* renamed from: f  reason: collision with root package name */
        public byte f32713f;

        /* renamed from: g  reason: collision with root package name */
        public int f32714g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1678a extends GeneratedMessageLite.Builder<v, C1678a> implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public Object f32715b;

            /* renamed from: c  reason: collision with root package name */
            public Object f32716c;

            public C1678a() {
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
                this.f32715b = "";
                this.f32716c = "";
                g();
            }

            private void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1678a h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1678a() : (C1678a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1678a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32715b = "";
                    int i2 = this.a & (-2);
                    this.a = i2;
                    this.f32716c = "";
                    this.a = i2 & (-3);
                    return this;
                }
                return (C1678a) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1678a mergeFrom(v vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar)) == null) {
                    if (vVar == v.a()) {
                        return this;
                    }
                    if (vVar.c()) {
                        this.a |= 1;
                        this.f32715b = vVar.f32711d;
                    }
                    if (vVar.e()) {
                        this.a |= 2;
                        this.f32716c = vVar.f32712e;
                    }
                    return this;
                }
                return (C1678a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1678a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1678a) invokeLL.objValue;
            }

            public C1678a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    if (str != null) {
                        this.a |= 1;
                        this.f32715b = str;
                        return this;
                    }
                    throw null;
                }
                return (C1678a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1678a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h().mergeFrom(buildPartial()) : (C1678a) invokeV.objValue;
            }

            public C1678a b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    if (str != null) {
                        this.a |= 2;
                        this.f32716c = str;
                        return this;
                    }
                    throw null;
                }
                return (C1678a) invokeL.objValue;
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
                    vVar.f32711d = this.f32715b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    vVar.f32712e = this.f32716c;
                    vVar.f32710c = i3;
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
            a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
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
            f32709b = vVar;
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
            this.f32713f = (byte) -1;
            this.f32714g = -1;
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
            this.f32713f = (byte) -1;
            this.f32714g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f32710c |= 1;
                                    this.f32711d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f32710c |= 2;
                                    this.f32712e = codedInputStream.readBytes();
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
            this.f32713f = (byte) -1;
            this.f32714g = -1;
        }

        public /* synthetic */ v(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1678a a(v vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, vVar)) == null) ? g().mergeFrom(vVar) : (C1678a) invokeL.objValue;
        }

        public static v a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f32709b : (v) invokeV.objValue;
        }

        public static C1678a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? C1678a.h() : (C1678a) invokeV.objValue;
        }

        private void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.f32711d = "";
                this.f32712e = "";
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32709b : (v) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32710c & 1) == 1 : invokeV.booleanValue;
        }

        public ByteString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.f32711d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32711d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32710c & 2) == 2 : invokeV.booleanValue;
        }

        public ByteString f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.f32712e;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32712e = copyFromUtf8;
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
                int i2 = this.f32714g;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f32710c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.f32710c & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
                }
                this.f32714g = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C1678a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g() : (C1678a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C1678a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? a(this) : (C1678a) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.f32713f;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f32713f = (byte) 1;
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
                if ((this.f32710c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
                if ((this.f32710c & 2) == 2) {
                    codedOutputStream.writeBytes(2, f());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class x implements Internal.EnumLite {
        public static /* synthetic */ Interceptable $ic;
        public static final x a;

        /* renamed from: b  reason: collision with root package name */
        public static final x f32717b;

        /* renamed from: c  reason: collision with root package name */
        public static final x f32718c;

        /* renamed from: d  reason: collision with root package name */
        public static final x f32719d;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ x[] f32720f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f32721e;

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
            a = new x("OS_TYPE_UNKNWON", 0, 0);
            f32717b = new x("IOS", 1, 1);
            f32718c = new x("ANDROID", 2, 2);
            x xVar = new x("WINDOWSPHONE", 3, 3);
            f32719d = xVar;
            f32720f = new x[]{a, f32717b, f32718c, xVar};
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
            this.f32721e = i3;
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
                            return f32719d;
                        }
                        return f32718c;
                    }
                    return f32717b;
                }
                return a;
            }
            return (x) invokeI.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32721e : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class y extends GeneratedMessageLite implements z {
        public static /* synthetic */ Interceptable $ic;
        public static Parser<y> a;

        /* renamed from: b  reason: collision with root package name */
        public static final y f32722b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f32723c;

        /* renamed from: d  reason: collision with root package name */
        public r f32724d;

        /* renamed from: e  reason: collision with root package name */
        public h f32725e;

        /* renamed from: f  reason: collision with root package name */
        public Object f32726f;

        /* renamed from: g  reason: collision with root package name */
        public long f32727g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f32728h;

        /* renamed from: i  reason: collision with root package name */
        public byte f32729i;

        /* renamed from: j  reason: collision with root package name */
        public int f32730j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C1679a extends GeneratedMessageLite.Builder<y, C1679a> implements z {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public r f32731b;

            /* renamed from: c  reason: collision with root package name */
            public h f32732c;

            /* renamed from: d  reason: collision with root package name */
            public Object f32733d;

            /* renamed from: e  reason: collision with root package name */
            public long f32734e;

            /* renamed from: f  reason: collision with root package name */
            public List<c> f32735f;

            public C1679a() {
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
                this.f32731b = r.a();
                this.f32732c = h.a();
                this.f32733d = "";
                this.f32735f = Collections.emptyList();
                i();
            }

            private void i() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                }
            }

            public static C1679a j() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1679a() : (C1679a) invokeV.objValue;
            }

            private void k() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (this.a & 16) == 16) {
                    return;
                }
                this.f32735f = new ArrayList(this.f32735f);
                this.a |= 16;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C1679a clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    super.clear();
                    this.f32731b = r.a();
                    this.a &= -2;
                    this.f32732c = h.a();
                    int i2 = this.a & (-3);
                    this.a = i2;
                    this.f32733d = "";
                    int i3 = i2 & (-5);
                    this.a = i3;
                    this.f32734e = 0L;
                    this.a = i3 & (-9);
                    this.f32735f = Collections.emptyList();
                    this.a &= -17;
                    return this;
                }
                return (C1679a) invokeV.objValue;
            }

            public C1679a a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                    this.a |= 8;
                    this.f32734e = j2;
                    return this;
                }
                return (C1679a) invokeJ.objValue;
            }

            public C1679a a(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
                    if (hVar != null) {
                        this.f32732c = hVar;
                        this.a |= 2;
                        return this;
                    }
                    throw null;
                }
                return (C1679a) invokeL.objValue;
            }

            public C1679a a(r rVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rVar)) == null) {
                    if ((this.a & 1) == 1 && this.f32731b != r.a()) {
                        rVar = r.a(this.f32731b).mergeFrom(rVar).buildPartial();
                    }
                    this.f32731b = rVar;
                    this.a |= 1;
                    return this;
                }
                return (C1679a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C1679a mergeFrom(y yVar) {
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
                        this.f32733d = yVar.f32726f;
                    }
                    if (yVar.i()) {
                        a(yVar.j());
                    }
                    if (!yVar.f32728h.isEmpty()) {
                        if (this.f32735f.isEmpty()) {
                            this.f32735f = yVar.f32728h;
                            this.a &= -17;
                        } else {
                            k();
                            this.f32735f.addAll(yVar.f32728h);
                        }
                    }
                    return this;
                }
                return (C1679a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C1679a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
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
                return (C1679a) invokeLL.objValue;
            }

            public C1679a a(Iterable<? extends c> iterable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iterable)) == null) {
                    k();
                    AbstractMessageLite.Builder.addAll(iterable, this.f32735f);
                    return this;
                }
                return (C1679a) invokeL.objValue;
            }

            public C1679a a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    if (str != null) {
                        this.a |= 4;
                        this.f32733d = str;
                        return this;
                    }
                    throw null;
                }
                return (C1679a) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C1679a clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? j().mergeFrom(buildPartial()) : (C1679a) invokeV.objValue;
            }

            public C1679a b(h hVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hVar)) == null) {
                    if ((this.a & 2) == 2 && this.f32732c != h.a()) {
                        hVar = h.a(this.f32732c).mergeFrom(hVar).buildPartial();
                    }
                    this.f32732c = hVar;
                    this.a |= 2;
                    return this;
                }
                return (C1679a) invokeL.objValue;
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
                    yVar.f32724d = this.f32731b;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    yVar.f32725e = this.f32732c;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    yVar.f32726f = this.f32733d;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    yVar.f32727g = this.f32734e;
                    if ((this.a & 16) == 16) {
                        this.f32735f = Collections.unmodifiableList(this.f32735f);
                        this.a &= -17;
                    }
                    yVar.f32728h = this.f32735f;
                    yVar.f32723c = i3;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f32732c : (h) invokeV.objValue;
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
            a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
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
            f32722b = yVar;
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
            this.f32729i = (byte) -1;
            this.f32730j = -1;
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
            this.f32729i = (byte) -1;
            this.f32730j = -1;
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
                                    r.C1676a builder = (this.f32723c & 1) == 1 ? this.f32724d.toBuilder() : null;
                                    r rVar = (r) codedInputStream.readMessage(r.a, extensionRegistryLite);
                                    this.f32724d = rVar;
                                    if (builder != null) {
                                        builder.mergeFrom(rVar);
                                        this.f32724d = builder.buildPartial();
                                    }
                                    i2 = this.f32723c;
                                } else if (readTag == 330) {
                                    i5 = 2;
                                    h.C1671a builder2 = (this.f32723c & 2) == 2 ? this.f32725e.toBuilder() : null;
                                    h hVar = (h) codedInputStream.readMessage(h.a, extensionRegistryLite);
                                    this.f32725e = hVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(hVar);
                                        this.f32725e = builder2.buildPartial();
                                    }
                                    i2 = this.f32723c;
                                } else if (readTag == 1042) {
                                    this.f32723c |= 4;
                                    this.f32726f = codedInputStream.readBytes();
                                } else if (readTag == 1048) {
                                    this.f32723c |= 8;
                                    this.f32727g = codedInputStream.readInt64();
                                } else if (readTag == 1058) {
                                    if (!(z2 & true)) {
                                        this.f32728h = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.f32728h.add(codedInputStream.readMessage(c.a, extensionRegistryLite));
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f32723c = i2 | i5;
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
                        this.f32728h = Collections.unmodifiableList(this.f32728h);
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
            this.f32729i = (byte) -1;
            this.f32730j = -1;
        }

        public /* synthetic */ y(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static C1679a a(y yVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, yVar)) == null) ? k().mergeFrom(yVar) : (C1679a) invokeL.objValue;
        }

        public static y a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f32722b : (y) invokeV.objValue;
        }

        public static C1679a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? C1679a.j() : (C1679a) invokeV.objValue;
        }

        private void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.f32724d = r.a();
                this.f32725e = h.a();
                this.f32726f = "";
                this.f32727g = 0L;
                this.f32728h = Collections.emptyList();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f32722b : (y) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f32723c & 1) == 1 : invokeV.booleanValue;
        }

        public r d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32724d : (r) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f32723c & 2) == 2 : invokeV.booleanValue;
        }

        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32725e : (h) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f32723c & 4) == 4 : invokeV.booleanValue;
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
                int i2 = this.f32730j;
                if (i2 != -1) {
                    return i2;
                }
                int computeMessageSize = (this.f32723c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f32724d) + 0 : 0;
                if ((this.f32723c & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f32725e);
                }
                if ((this.f32723c & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(130, h());
                }
                if ((this.f32723c & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f32727g);
                }
                for (int i3 = 0; i3 < this.f32728h.size(); i3++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f32728h.get(i3));
                }
                this.f32730j = computeMessageSize;
                return computeMessageSize;
            }
            return invokeV.intValue;
        }

        public ByteString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.f32726f;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f32726f = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f32723c & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                byte b2 = this.f32729i;
                if (b2 != -1) {
                    return b2 == 1;
                } else if (!e()) {
                    this.f32729i = (byte) 0;
                    return false;
                } else if (f().isInitialized()) {
                    this.f32729i = (byte) 1;
                    return true;
                } else {
                    this.f32729i = (byte) 0;
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32727g : invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C1679a newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? k() : (C1679a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C1679a toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(this) : (C1679a) invokeV.objValue;
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
                if ((this.f32723c & 1) == 1) {
                    codedOutputStream.writeMessage(25, this.f32724d);
                }
                if ((this.f32723c & 2) == 2) {
                    codedOutputStream.writeMessage(41, this.f32725e);
                }
                if ((this.f32723c & 4) == 4) {
                    codedOutputStream.writeBytes(130, h());
                }
                if ((this.f32723c & 8) == 8) {
                    codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f32727g);
                }
                for (int i2 = 0; i2 < this.f32728h.size(); i2++) {
                    codedOutputStream.writeMessage(132, this.f32728h.get(i2));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
