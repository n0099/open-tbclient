package com.baidu.android.pushservice.y.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class g extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static final g C;
    public static Parser<g> D;
    public transient /* synthetic */ FieldHolder $fh;
    public byte A;
    public int B;
    public int a;
    public Object b;
    public int c;
    public int d;
    public int e;
    public Object f;
    public Object g;
    public int h;
    public int i;
    public ByteString j;
    public int k;
    public int l;
    public long m;
    public int n;
    public Object o;
    public Object p;
    public Object q;
    public int r;
    public Object s;
    public Object t;
    public Object u;
    public long v;
    public List<h> w;
    public int x;
    public long y;
    public Object z;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<g> {
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
        public g parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new g(codedInputStream, extensionRegistryLite, null) : (g) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<g, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Object b;
        public int c;
        public int d;
        public int e;
        public Object f;
        public Object g;
        public int h;
        public int i;
        public ByteString j;
        public int k;
        public int l;
        public long m;
        public int n;
        public Object o;
        public Object p;
        public Object q;
        public int r;
        public Object s;
        public Object t;
        public Object u;
        public long v;
        public List<h> w;
        public int x;
        public long y;
        public Object z;

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
            this.b = "";
            this.f = "";
            this.g = "";
            this.j = ByteString.EMPTY;
            this.o = "";
            this.p = "";
            this.q = "";
            this.s = "";
            this.t = "";
            this.u = "";
            this.w = Collections.emptyList();
            this.z = "";
            i();
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
                this.a |= 65536;
                this.r = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.a |= 1048576;
                this.v = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
                if (gVar == g.h()) {
                    return this;
                }
                if (gVar.F()) {
                    this.a |= 1;
                    this.b = gVar.b;
                }
                if (gVar.V()) {
                    i(gVar.x());
                }
                if (gVar.T()) {
                    h(gVar.v());
                }
                if (gVar.G()) {
                    b(gVar.g());
                }
                if (gVar.L()) {
                    this.a |= 16;
                    this.f = gVar.f;
                }
                if (gVar.O()) {
                    this.a |= 32;
                    this.g = gVar.g;
                }
                if (gVar.S()) {
                    g(gVar.u());
                }
                if (gVar.M()) {
                    d(gVar.o());
                }
                if (gVar.H()) {
                    a(gVar.j());
                }
                if (gVar.I()) {
                    c(gVar.k());
                }
                if (gVar.P()) {
                    e(gVar.r());
                }
                if (gVar.J()) {
                    b(gVar.l());
                }
                if (gVar.X()) {
                    j(gVar.z());
                }
                if (gVar.R()) {
                    this.a |= 8192;
                    this.o = gVar.o;
                }
                if (gVar.A()) {
                    this.a |= 16384;
                    this.p = gVar.p;
                }
                if (gVar.D()) {
                    this.a |= 32768;
                    this.q = gVar.q;
                }
                if (gVar.C()) {
                    a(gVar.c());
                }
                if (gVar.E()) {
                    this.a |= 131072;
                    this.s = gVar.s;
                }
                if (gVar.U()) {
                    this.a |= 262144;
                    this.t = gVar.t;
                }
                if (gVar.N()) {
                    this.a |= 524288;
                    this.u = gVar.u;
                }
                if (gVar.B()) {
                    a(gVar.b());
                }
                if (!gVar.w.isEmpty()) {
                    if (this.w.isEmpty()) {
                        this.w = gVar.w;
                        this.a &= -2097153;
                    } else {
                        g();
                        this.w.addAll(gVar.w);
                    }
                }
                if (gVar.Q()) {
                    f(gVar.s());
                }
                if (gVar.K()) {
                    c(gVar.m());
                }
                if (gVar.W()) {
                    this.a |= 16777216;
                    this.z = gVar.z;
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) {
                if (hVar != null) {
                    g();
                    this.w.add(hVar);
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b a(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) {
                if (byteString != null) {
                    this.a |= 256;
                    this.j = byteString;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, codedInputStream, extensionRegistryLite)) == null) {
                g gVar = null;
                try {
                    try {
                        g parsePartialFrom = g.D.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        g gVar2 = (g) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            gVar = gVar2;
                            if (gVar != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (gVar != null) {
                        mergeFrom(gVar);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (str != null) {
                    this.a |= 16384;
                    this.p = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.a |= 8;
                this.e = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                this.a |= 2048;
                this.m = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (str != null) {
                    this.a |= 32768;
                    this.q = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public g build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                g buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (g) invokeV.objValue;
        }

        public b c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.a |= 512;
                this.k = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
                this.a |= 8388608;
                this.y = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                if (str != null) {
                    this.a |= 131072;
                    this.s = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public g buildPartial() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                g gVar = new g(this, (com.baidu.android.pushservice.y.e.a) null);
                int i = this.a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                gVar.b = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                gVar.c = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                gVar.d = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                gVar.e = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                gVar.f = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                gVar.g = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                gVar.h = this.h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                gVar.i = this.i;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                gVar.j = this.j;
                if ((i & 512) == 512) {
                    i2 |= 512;
                }
                gVar.k = this.k;
                if ((i & 1024) == 1024) {
                    i2 |= 1024;
                }
                gVar.l = this.l;
                if ((i & 2048) == 2048) {
                    i2 |= 2048;
                }
                gVar.m = this.m;
                if ((i & 4096) == 4096) {
                    i2 |= 4096;
                }
                gVar.n = this.n;
                if ((i & 8192) == 8192) {
                    i2 |= 8192;
                }
                gVar.o = this.o;
                if ((i & 16384) == 16384) {
                    i2 |= 16384;
                }
                gVar.p = this.p;
                if ((i & 32768) == 32768) {
                    i2 |= 32768;
                }
                gVar.q = this.q;
                if ((i & 65536) == 65536) {
                    i2 |= 65536;
                }
                gVar.r = this.r;
                if ((i & 131072) == 131072) {
                    i2 |= 131072;
                }
                gVar.s = this.s;
                if ((i & 262144) == 262144) {
                    i2 |= 262144;
                }
                gVar.t = this.t;
                if ((i & 524288) == 524288) {
                    i2 |= 524288;
                }
                gVar.u = this.u;
                if ((i & 1048576) == 1048576) {
                    i2 |= 1048576;
                }
                gVar.v = this.v;
                if ((this.a & 2097152) == 2097152) {
                    this.w = Collections.unmodifiableList(this.w);
                    this.a &= -2097153;
                }
                gVar.w = this.w;
                if ((4194304 & i) == 4194304) {
                    i2 |= 2097152;
                }
                gVar.x = this.x;
                if ((8388608 & i) == 8388608) {
                    i2 |= 4194304;
                }
                gVar.y = this.y;
                if ((i & 16777216) == 16777216) {
                    i2 |= 8388608;
                }
                gVar.z = this.z;
                gVar.a = i2;
                return gVar;
            }
            return (g) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                super.clear();
                this.b = "";
                int i = this.a & (-2);
                this.a = i;
                this.c = 0;
                int i2 = i & (-3);
                this.a = i2;
                this.d = 0;
                int i3 = i2 & (-5);
                this.a = i3;
                this.e = 0;
                int i4 = i3 & (-9);
                this.a = i4;
                this.f = "";
                int i5 = i4 & (-17);
                this.a = i5;
                this.g = "";
                int i6 = i5 & (-33);
                this.a = i6;
                this.h = 0;
                int i7 = i6 & (-65);
                this.a = i7;
                this.i = 0;
                int i8 = i7 & (-129);
                this.a = i8;
                this.j = ByteString.EMPTY;
                int i9 = i8 & (-257);
                this.a = i9;
                this.k = 0;
                int i10 = i9 & (-513);
                this.a = i10;
                this.l = 0;
                int i11 = i10 & (-1025);
                this.a = i11;
                this.m = 0L;
                int i12 = i11 & (-2049);
                this.a = i12;
                this.n = 0;
                int i13 = i12 & (-4097);
                this.a = i13;
                this.o = "";
                int i14 = i13 & (-8193);
                this.a = i14;
                this.p = "";
                int i15 = i14 & (-16385);
                this.a = i15;
                this.q = "";
                int i16 = i15 & (-32769);
                this.a = i16;
                this.r = 0;
                int i17 = i16 & (-65537);
                this.a = i17;
                this.s = "";
                int i18 = i17 & (-131073);
                this.a = i18;
                this.t = "";
                int i19 = i18 & (-262145);
                this.a = i19;
                this.u = "";
                int i20 = i19 & (-524289);
                this.a = i20;
                this.v = 0L;
                this.a = i20 & (-1048577);
                this.w = Collections.emptyList();
                int i21 = this.a & (-2097153);
                this.a = i21;
                this.x = 0;
                int i22 = i21 & (-4194305);
                this.a = i22;
                this.y = 0L;
                int i23 = i22 & (-8388609);
                this.a = i23;
                this.z = "";
                this.a = (-16777217) & i23;
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
                this.a |= 128;
                this.i = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                if (str != null) {
                    this.a |= 1;
                    this.b = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public b mo29clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? f().mergeFrom(buildPartial()) : (b) invokeV.objValue;
        }

        public b e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                this.a |= 1024;
                this.l = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                if (str != null) {
                    this.a |= 16;
                    this.f = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
                this.a |= 4194304;
                this.x = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
                if (str != null) {
                    this.a |= 524288;
                    this.u = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
                this.a |= 64;
                this.h = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
                if (str != null) {
                    this.a |= 32;
                    this.g = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (this.a & 2097152) == 2097152) {
                return;
            }
            this.w = new ArrayList(this.w);
            this.a |= 2097152;
        }

        public b h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
                this.a |= 4;
                this.d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                if (str != null) {
                    this.a |= 8192;
                    this.o = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: h */
        public g getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? g.h() : (g) invokeV.objValue;
        }

        public b i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
                this.a |= 2;
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
                if (str != null) {
                    this.a |= 262144;
                    this.t = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            }
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i)) == null) {
                this.a |= 4096;
                this.n = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
                if (str != null) {
                    this.a |= 16777216;
                    this.z = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502689834, "Lcom/baidu/android/pushservice/y/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1502689834, "Lcom/baidu/android/pushservice/y/e/g;");
                return;
            }
        }
        D = new a();
        g gVar = new g(true);
        C = gVar;
        gVar.Y();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0016 */
    /* JADX DEBUG: Type inference failed for r4v67. Raw type applied. Possible types: java.util.List<com.baidu.android.pushservice.y.e.h>, java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean] */
    public g(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
        this.A = (byte) -1;
        this.B = -1;
        Y();
        boolean z = false;
        int i3 = 0;
        while (true) {
            ?? r3 = 2097152;
            if (z) {
                return;
            }
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.a |= 1;
                                this.b = codedInputStream.readBytes();
                                continue;
                            case 16:
                                this.a |= 2;
                                this.c = codedInputStream.readInt32();
                                continue;
                            case 24:
                                this.a |= 4;
                                this.d = codedInputStream.readInt32();
                                continue;
                            case 32:
                                this.a |= 8;
                                this.e = codedInputStream.readInt32();
                                continue;
                            case 42:
                                this.a |= 16;
                                this.f = codedInputStream.readBytes();
                                continue;
                            case 50:
                                this.a |= 32;
                                this.g = codedInputStream.readBytes();
                                continue;
                            case 56:
                                this.a |= 64;
                                this.h = codedInputStream.readInt32();
                                continue;
                            case 64:
                                this.a |= 128;
                                this.i = codedInputStream.readInt32();
                                continue;
                            case 74:
                                this.a |= 256;
                                this.j = codedInputStream.readBytes();
                                continue;
                            case 80:
                                this.a |= 512;
                                this.k = codedInputStream.readInt32();
                                continue;
                            case 88:
                                this.a |= 1024;
                                this.l = codedInputStream.readInt32();
                                continue;
                            case 96:
                                this.a |= 2048;
                                this.m = codedInputStream.readInt64();
                                continue;
                            case 104:
                                this.a |= 4096;
                                this.n = codedInputStream.readInt32();
                                continue;
                            case 114:
                                this.a |= 8192;
                                this.o = codedInputStream.readBytes();
                                continue;
                            case 122:
                                this.a |= 16384;
                                this.p = codedInputStream.readBytes();
                                continue;
                            case 130:
                                this.a |= 32768;
                                this.q = codedInputStream.readBytes();
                                continue;
                            case 136:
                                this.a |= 65536;
                                this.r = codedInputStream.readInt32();
                                continue;
                            case Cea708Decoder.COMMAND_SPL /* 146 */:
                                this.a |= 131072;
                                this.s = codedInputStream.readBytes();
                                continue;
                            case Cea708Decoder.COMMAND_DF2 /* 154 */:
                                this.a |= 262144;
                                this.t = codedInputStream.readBytes();
                                continue;
                            case BDLocation.TypeServerDecryptError /* 162 */:
                                this.a |= 524288;
                                this.u = codedInputStream.readBytes();
                                continue;
                            case 168:
                                this.a |= 1048576;
                                this.v = codedInputStream.readInt64();
                                continue;
                            case 178:
                                if ((i3 & 2097152) != 2097152) {
                                    this.w = new ArrayList();
                                    i3 |= 2097152;
                                }
                                this.w.add(codedInputStream.readMessage(h.g, extensionRegistryLite));
                                continue;
                            case H262Reader.START_GROUP /* 184 */:
                                this.a |= 2097152;
                                this.x = codedInputStream.readInt32();
                                continue;
                            case 192:
                                this.a |= 4194304;
                                this.y = codedInputStream.readInt64();
                                continue;
                            case 202:
                                this.a |= 8388608;
                                this.z = codedInputStream.readBytes();
                                continue;
                            default:
                                r3 = parseUnknownField(codedInputStream, extensionRegistryLite, readTag);
                                if (r3 == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if ((i3 & r3) == r3) {
                    this.w = Collections.unmodifiableList(this.w);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ g(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, com.baidu.android.pushservice.y.e.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(GeneratedMessageLite.Builder builder) {
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
        this.A = (byte) -1;
        this.B = -1;
    }

    public /* synthetic */ g(GeneratedMessageLite.Builder builder, com.baidu.android.pushservice.y.e.a aVar) {
        this(builder);
    }

    public g(boolean z) {
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
        this.A = (byte) -1;
        this.B = -1;
    }

    public static b Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? b.a() : (b) invokeV.objValue;
    }

    public static g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? C : (g) invokeV.objValue;
    }

    public static b l(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, gVar)) == null) ? Z().mergeFrom(gVar) : (b) invokeL.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a & 16384) == 16384 : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.a & 1048576) == 1048576 : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.a & 65536) == 65536 : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.a & 32768) == 32768 : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.a & 131072) == 131072 : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.a & 1) == 1 : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.a & 8) == 8 : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (this.a & 256) == 256 : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.a & 512) == 512 : invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.a & 2048) == 2048 : invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.a & 4194304) == 4194304 : invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.a & 16) == 16 : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.a & 128) == 128 : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.a & 524288) == 524288 : invokeV.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.a & 32) == 32 : invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.a & 1024) == 1024 : invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.a & 2097152) == 2097152 : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.a & 8192) == 8192 : invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.a & 64) == 64 : invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.a & 4) == 4 : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.a & 262144) == 262144 : invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.a & 2) == 2 : invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.a & 8388608) == 8388608 : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.a & 4096) == 4096 : invokeV.booleanValue;
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.b = "";
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = "";
            this.g = "";
            this.h = 0;
            this.i = 0;
            this.j = ByteString.EMPTY;
            this.k = 0;
            this.l = 0;
            this.m = 0L;
            this.n = 0;
            this.o = "";
            this.p = "";
            this.q = "";
            this.r = 0;
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = 0L;
            this.w = Collections.emptyList();
            this.x = 0;
            this.y = 0L;
            this.z = "";
        }
    }

    public ByteString a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Object obj = this.p;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.p = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: a0 */
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Z() : (b) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.v : invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: b0 */
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? l(this) : (b) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : invokeV.intValue;
    }

    public ByteString d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Object obj = this.q;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.q = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public ByteString e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            Object obj = this.s;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.s = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public ByteString f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            Object obj = this.b;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.b = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<g> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? D : (Parser) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            int i = this.B;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.a & 1) == 1 ? CodedOutputStream.computeBytesSize(1, f()) + 0 : 0;
            if ((this.a & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt32Size(2, this.c);
            }
            if ((this.a & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt32Size(3, this.d);
            }
            if ((this.a & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt32Size(4, this.e);
            }
            if ((this.a & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeBytesSize(5, n());
            }
            if ((this.a & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, q());
            }
            if ((this.a & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt32Size(7, this.h);
            }
            if ((this.a & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeInt32Size(8, this.i);
            }
            if ((this.a & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeBytesSize(9, this.j);
            }
            if ((this.a & 512) == 512) {
                computeBytesSize += CodedOutputStream.computeInt32Size(10, this.k);
            }
            if ((this.a & 1024) == 1024) {
                computeBytesSize += CodedOutputStream.computeInt32Size(11, this.l);
            }
            if ((this.a & 2048) == 2048) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.m);
            }
            if ((this.a & 4096) == 4096) {
                computeBytesSize += CodedOutputStream.computeInt32Size(13, this.n);
            }
            if ((this.a & 8192) == 8192) {
                computeBytesSize += CodedOutputStream.computeBytesSize(14, t());
            }
            if ((this.a & 16384) == 16384) {
                computeBytesSize += CodedOutputStream.computeBytesSize(15, a());
            }
            if ((this.a & 32768) == 32768) {
                computeBytesSize += CodedOutputStream.computeBytesSize(16, d());
            }
            if ((this.a & 65536) == 65536) {
                computeBytesSize += CodedOutputStream.computeInt32Size(17, this.r);
            }
            if ((this.a & 131072) == 131072) {
                computeBytesSize += CodedOutputStream.computeBytesSize(18, e());
            }
            if ((this.a & 262144) == 262144) {
                computeBytesSize += CodedOutputStream.computeBytesSize(19, w());
            }
            if ((this.a & 524288) == 524288) {
                computeBytesSize += CodedOutputStream.computeBytesSize(20, p());
            }
            if ((this.a & 1048576) == 1048576) {
                computeBytesSize += CodedOutputStream.computeInt64Size(21, this.v);
            }
            for (int i2 = 0; i2 < this.w.size(); i2++) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.w.get(i2));
            }
            if ((this.a & 2097152) == 2097152) {
                computeBytesSize += CodedOutputStream.computeInt32Size(23, this.x);
            }
            if ((this.a & 4194304) == 4194304) {
                computeBytesSize += CodedOutputStream.computeInt64Size(24, this.y);
            }
            if ((this.a & 8388608) == 8388608) {
                computeBytesSize += CodedOutputStream.computeBytesSize(25, y());
            }
            this.B = computeBytesSize;
            return computeBytesSize;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: i */
    public g getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? C : (g) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            byte b2 = this.A;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.A = (byte) 1;
            return true;
        }
        return invokeV.booleanValue;
    }

    public ByteString j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.j : (ByteString) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.k : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.m : invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.y : invokeV.longValue;
    }

    public ByteString n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.i : invokeV.intValue;
    }

    public ByteString p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            Object obj = this.u;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.u = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public ByteString q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Object obj = this.g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.x : invokeV.intValue;
    }

    public ByteString t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            Object obj = this.o;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.o = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.h : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.d : invokeV.intValue;
    }

    public ByteString w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            Object obj = this.t;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.t = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, codedOutputStream) == null) {
            getSerializedSize();
            if ((this.a & 1) == 1) {
                codedOutputStream.writeBytes(1, f());
            }
            if ((this.a & 2) == 2) {
                codedOutputStream.writeInt32(2, this.c);
            }
            if ((this.a & 4) == 4) {
                codedOutputStream.writeInt32(3, this.d);
            }
            if ((this.a & 8) == 8) {
                codedOutputStream.writeInt32(4, this.e);
            }
            if ((this.a & 16) == 16) {
                codedOutputStream.writeBytes(5, n());
            }
            if ((this.a & 32) == 32) {
                codedOutputStream.writeBytes(6, q());
            }
            if ((this.a & 64) == 64) {
                codedOutputStream.writeInt32(7, this.h);
            }
            if ((this.a & 128) == 128) {
                codedOutputStream.writeInt32(8, this.i);
            }
            if ((this.a & 256) == 256) {
                codedOutputStream.writeBytes(9, this.j);
            }
            if ((this.a & 512) == 512) {
                codedOutputStream.writeInt32(10, this.k);
            }
            if ((this.a & 1024) == 1024) {
                codedOutputStream.writeInt32(11, this.l);
            }
            if ((this.a & 2048) == 2048) {
                codedOutputStream.writeInt64(12, this.m);
            }
            if ((this.a & 4096) == 4096) {
                codedOutputStream.writeInt32(13, this.n);
            }
            if ((this.a & 8192) == 8192) {
                codedOutputStream.writeBytes(14, t());
            }
            if ((this.a & 16384) == 16384) {
                codedOutputStream.writeBytes(15, a());
            }
            if ((this.a & 32768) == 32768) {
                codedOutputStream.writeBytes(16, d());
            }
            if ((this.a & 65536) == 65536) {
                codedOutputStream.writeInt32(17, this.r);
            }
            if ((this.a & 131072) == 131072) {
                codedOutputStream.writeBytes(18, e());
            }
            if ((this.a & 262144) == 262144) {
                codedOutputStream.writeBytes(19, w());
            }
            if ((this.a & 524288) == 524288) {
                codedOutputStream.writeBytes(20, p());
            }
            if ((this.a & 1048576) == 1048576) {
                codedOutputStream.writeInt64(21, this.v);
            }
            for (int i = 0; i < this.w.size(); i++) {
                codedOutputStream.writeMessage(22, this.w.get(i));
            }
            if ((this.a & 2097152) == 2097152) {
                codedOutputStream.writeInt32(23, this.x);
            }
            if ((this.a & 4194304) == 4194304) {
                codedOutputStream.writeInt64(24, this.y);
            }
            if ((this.a & 8388608) == 8388608) {
                codedOutputStream.writeBytes(25, y());
            }
        }
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.c : invokeV.intValue;
    }

    public ByteString y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            Object obj = this.z;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.z = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.n : invokeV.intValue;
    }
}
