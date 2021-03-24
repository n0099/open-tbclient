package com.baidu.android.pushservice.i.a.a;

import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0036a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0036a> f3085a = new AbstractParser<C0036a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0036a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0036a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0036a f3086b;

        /* renamed from: c  reason: collision with root package name */
        public int f3087c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3088d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3089e;

        /* renamed from: f  reason: collision with root package name */
        public long f3090f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3091g;

        /* renamed from: h  reason: collision with root package name */
        public long f3092h;
        public byte i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0037a extends GeneratedMessageLite.Builder<C0036a, C0037a> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3093a;

            /* renamed from: d  reason: collision with root package name */
            public long f3096d;

            /* renamed from: f  reason: collision with root package name */
            public long f3098f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3094b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3095c = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3097e = "";

            public C0037a() {
                g();
            }

            private void g() {
            }

            public static C0037a h() {
                return new C0037a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0037a clear() {
                super.clear();
                this.f3094b = "";
                int i = this.f3093a & (-2);
                this.f3093a = i;
                this.f3095c = "";
                int i2 = i & (-3);
                this.f3093a = i2;
                this.f3096d = 0L;
                int i3 = i2 & (-5);
                this.f3093a = i3;
                this.f3097e = "";
                int i4 = i3 & (-9);
                this.f3093a = i4;
                this.f3098f = 0L;
                this.f3093a = i4 & (-17);
                return this;
            }

            public C0037a a(long j) {
                this.f3093a |= 4;
                this.f3096d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0037a mergeFrom(C0036a c0036a) {
                if (c0036a == C0036a.a()) {
                    return this;
                }
                if (c0036a.c()) {
                    this.f3093a |= 1;
                    this.f3094b = c0036a.f3088d;
                }
                if (c0036a.e()) {
                    this.f3093a |= 2;
                    this.f3095c = c0036a.f3089e;
                }
                if (c0036a.g()) {
                    a(c0036a.h());
                }
                if (c0036a.i()) {
                    this.f3093a |= 8;
                    this.f3097e = c0036a.f3091g;
                }
                if (c0036a.k()) {
                    b(c0036a.l());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0037a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                C0036a c0036a = null;
                try {
                    try {
                        C0036a parsePartialFrom = C0036a.f3085a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        C0036a c0036a2 = (C0036a) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0036a = c0036a2;
                            if (c0036a != null) {
                                mergeFrom(c0036a);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0036a != null) {
                    }
                    throw th;
                }
            }

            public C0037a a(String str) {
                if (str != null) {
                    this.f3093a |= 1;
                    this.f3094b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0037a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0037a b(long j) {
                this.f3093a |= 16;
                this.f3098f = j;
                return this;
            }

            public C0037a b(String str) {
                if (str != null) {
                    this.f3093a |= 2;
                    return this;
                }
                throw null;
            }

            public C0037a c(String str) {
                if (str != null) {
                    this.f3093a |= 8;
                    this.f3097e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0036a getDefaultInstanceForType() {
                return C0036a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0036a build() {
                C0036a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0036a buildPartial() {
                C0036a c0036a = new C0036a(this);
                int i = this.f3093a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c0036a.f3088d = this.f3094b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c0036a.f3089e = this.f3095c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c0036a.f3090f = this.f3096d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                c0036a.f3091g = this.f3097e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                c0036a.f3092h = this.f3098f;
                c0036a.f3087c = i2;
                return c0036a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0036a c0036a = new C0036a();
            f3086b = c0036a;
            c0036a.p();
        }

        public C0036a() {
            this.i = (byte) -1;
            this.j = -1;
        }

        public C0036a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.i = (byte) -1;
            this.j = -1;
            p();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3087c |= 1;
                                    this.f3088d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3087c |= 2;
                                    this.f3089e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3087c |= 4;
                                    this.f3090f = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.f3087c |= 8;
                                    this.f3091g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3087c |= 16;
                                    this.f3092h = codedInputStream.readInt64();
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

        public C0036a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.i = (byte) -1;
            this.j = -1;
        }

        public static C0037a a(C0036a c0036a) {
            return m().mergeFrom(c0036a);
        }

        public static C0036a a() {
            return f3086b;
        }

        public static C0037a m() {
            return C0037a.h();
        }

        private void p() {
            this.f3088d = "";
            this.f3089e = "";
            this.f3090f = 0L;
            this.f3091g = "";
            this.f3092h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0036a getDefaultInstanceForType() {
            return f3086b;
        }

        public boolean c() {
            return (this.f3087c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3088d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3088d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3087c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3089e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3089e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3087c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0036a> getParserForType() {
            return f3085a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.j;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3087c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3087c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3087c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3090f);
            }
            if ((this.f3087c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3087c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3092h);
            }
            this.j = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3090f;
        }

        public boolean i() {
            return (this.f3087c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.i = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3091g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3091g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3087c & 16) == 16;
        }

        public long l() {
            return this.f3092h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C0037a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C0037a newBuilderForType() {
            return m();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3087c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3087c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3087c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3090f);
            }
            if ((this.f3087c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3087c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3092h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f3099a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final aa f3100b;

        /* renamed from: c  reason: collision with root package name */
        public int f3101c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3102d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3103e;

        /* renamed from: f  reason: collision with root package name */
        public long f3104f;

        /* renamed from: g  reason: collision with root package name */
        public long f3105g;

        /* renamed from: h  reason: collision with root package name */
        public long f3106h;
        public Object i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0038a extends GeneratedMessageLite.Builder<aa, C0038a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            public int f3107a;

            /* renamed from: d  reason: collision with root package name */
            public long f3110d;

            /* renamed from: e  reason: collision with root package name */
            public long f3111e;

            /* renamed from: f  reason: collision with root package name */
            public long f3112f;

            /* renamed from: h  reason: collision with root package name */
            public long f3114h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3108b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3109c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3113g = "";

            public C0038a() {
                g();
            }

            private void g() {
            }

            public static C0038a h() {
                return new C0038a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0038a clear() {
                super.clear();
                this.f3108b = "";
                int i = this.f3107a & (-2);
                this.f3107a = i;
                this.f3109c = "";
                int i2 = i & (-3);
                this.f3107a = i2;
                this.f3110d = 0L;
                int i3 = i2 & (-5);
                this.f3107a = i3;
                this.f3111e = 0L;
                int i4 = i3 & (-9);
                this.f3107a = i4;
                this.f3112f = 0L;
                int i5 = i4 & (-17);
                this.f3107a = i5;
                this.f3113g = "";
                int i6 = i5 & (-33);
                this.f3107a = i6;
                this.f3114h = 0L;
                this.f3107a = i6 & (-65);
                return this;
            }

            public C0038a a(long j) {
                this.f3107a |= 4;
                this.f3110d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0038a mergeFrom(aa aaVar) {
                if (aaVar == aa.a()) {
                    return this;
                }
                if (aaVar.c()) {
                    this.f3107a |= 1;
                    this.f3108b = aaVar.f3102d;
                }
                if (aaVar.e()) {
                    this.f3107a |= 2;
                    this.f3109c = aaVar.f3103e;
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
                    this.f3107a |= 32;
                    this.f3113g = aaVar.i;
                }
                if (aaVar.o()) {
                    d(aaVar.p());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0038a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                aa aaVar = null;
                try {
                    try {
                        aa parsePartialFrom = aa.f3099a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(aaVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (aaVar != null) {
                    }
                    throw th;
                }
            }

            public C0038a a(String str) {
                if (str != null) {
                    this.f3107a |= 1;
                    this.f3108b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0038a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0038a b(long j) {
                this.f3107a |= 8;
                this.f3111e = j;
                return this;
            }

            public C0038a b(String str) {
                if (str != null) {
                    this.f3107a |= 2;
                    this.f3109c = str;
                    return this;
                }
                throw null;
            }

            public C0038a c(long j) {
                this.f3107a |= 16;
                this.f3112f = j;
                return this;
            }

            public C0038a c(String str) {
                if (str != null) {
                    this.f3107a |= 32;
                    this.f3113g = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                return aa.a();
            }

            public C0038a d(long j) {
                this.f3107a |= 64;
                this.f3114h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public aa build() {
                aa buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public aa buildPartial() {
                aa aaVar = new aa(this);
                int i = this.f3107a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aaVar.f3102d = this.f3108b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aaVar.f3103e = this.f3109c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                aaVar.f3104f = this.f3110d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                aaVar.f3105g = this.f3111e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                aaVar.f3106h = this.f3112f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                aaVar.i = this.f3113g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                aaVar.j = this.f3114h;
                aaVar.f3101c = i2;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            aa aaVar = new aa();
            f3100b = aaVar;
            aaVar.t();
        }

        public aa() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public aa(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3101c |= 1;
                                this.f3102d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3101c |= 2;
                                this.f3103e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3101c |= 4;
                                this.f3104f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3101c |= 8;
                                this.f3105g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3101c |= 16;
                                this.f3106h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3101c |= 32;
                                this.i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3101c |= 64;
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

        public aa(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0038a a(aa aaVar) {
            return q().mergeFrom(aaVar);
        }

        public static aa a() {
            return f3100b;
        }

        public static C0038a q() {
            return C0038a.h();
        }

        private void t() {
            this.f3102d = "";
            this.f3103e = "";
            this.f3104f = 0L;
            this.f3105g = 0L;
            this.f3106h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f3100b;
        }

        public boolean c() {
            return (this.f3101c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3102d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3102d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3101c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3103e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3103e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3101c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            return f3099a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3101c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3101c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3101c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3104f);
            }
            if ((this.f3101c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3105g);
            }
            if ((this.f3101c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3106h);
            }
            if ((this.f3101c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3101c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3104f;
        }

        public boolean i() {
            return (this.f3101c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3105g;
        }

        public boolean k() {
            return (this.f3101c & 16) == 16;
        }

        public long l() {
            return this.f3106h;
        }

        public boolean m() {
            return (this.f3101c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3101c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0038a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0038a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3101c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3101c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3101c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3104f);
            }
            if ((this.f3101c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3105g);
            }
            if ((this.f3101c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3106h);
            }
            if ((this.f3101c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3101c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class ac extends GeneratedMessageLite implements ad {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ac> f3115a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ac f3116b;

        /* renamed from: c  reason: collision with root package name */
        public int f3117c;

        /* renamed from: d  reason: collision with root package name */
        public x f3118d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3119e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3120f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3121g;

        /* renamed from: h  reason: collision with root package name */
        public int f3122h;
        public int i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0039a extends GeneratedMessageLite.Builder<ac, C0039a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            public int f3123a;

            /* renamed from: b  reason: collision with root package name */
            public x f3124b = x.OS_TYPE_UNKNWON;

            /* renamed from: c  reason: collision with root package name */
            public Object f3125c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3126d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3127e = "";

            /* renamed from: f  reason: collision with root package name */
            public int f3128f;

            /* renamed from: g  reason: collision with root package name */
            public int f3129g;

            /* renamed from: h  reason: collision with root package name */
            public int f3130h;

            public C0039a() {
                g();
            }

            private void g() {
            }

            public static C0039a h() {
                return new C0039a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0039a clear() {
                super.clear();
                this.f3124b = x.OS_TYPE_UNKNWON;
                int i = this.f3123a & (-2);
                this.f3123a = i;
                this.f3125c = "";
                int i2 = i & (-3);
                this.f3123a = i2;
                this.f3126d = "";
                int i3 = i2 & (-5);
                this.f3123a = i3;
                this.f3127e = "";
                int i4 = i3 & (-9);
                this.f3123a = i4;
                this.f3128f = 0;
                int i5 = i4 & (-17);
                this.f3123a = i5;
                this.f3129g = 0;
                int i6 = i5 & (-33);
                this.f3123a = i6;
                this.f3130h = 0;
                this.f3123a = i6 & (-65);
                return this;
            }

            public C0039a a(int i) {
                this.f3123a |= 16;
                this.f3128f = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0039a mergeFrom(ac acVar) {
                if (acVar == ac.a()) {
                    return this;
                }
                if (acVar.c()) {
                    a(acVar.d());
                }
                if (acVar.e()) {
                    this.f3123a |= 2;
                    this.f3125c = acVar.f3119e;
                }
                if (acVar.g()) {
                    this.f3123a |= 4;
                    this.f3126d = acVar.f3120f;
                }
                if (acVar.i()) {
                    this.f3123a |= 8;
                    this.f3127e = acVar.f3121g;
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

            public C0039a a(x xVar) {
                if (xVar != null) {
                    this.f3123a |= 1;
                    this.f3124b = xVar;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0039a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ac acVar = null;
                try {
                    try {
                        ac parsePartialFrom = ac.f3115a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(acVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (acVar != null) {
                    }
                    throw th;
                }
            }

            public C0039a a(String str) {
                if (str != null) {
                    this.f3123a |= 2;
                    this.f3125c = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0039a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0039a b(int i) {
                this.f3123a |= 32;
                this.f3129g = i;
                return this;
            }

            public C0039a b(String str) {
                if (str != null) {
                    this.f3123a |= 4;
                    this.f3126d = str;
                    return this;
                }
                throw null;
            }

            public C0039a c(int i) {
                this.f3123a |= 64;
                this.f3130h = i;
                return this;
            }

            public C0039a c(String str) {
                if (str != null) {
                    this.f3123a |= 8;
                    this.f3127e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ac getDefaultInstanceForType() {
                return ac.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public ac build() {
                ac buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ac buildPartial() {
                ac acVar = new ac(this);
                int i = this.f3123a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                acVar.f3118d = this.f3124b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                acVar.f3119e = this.f3125c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                acVar.f3120f = this.f3126d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                acVar.f3121g = this.f3127e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                acVar.f3122h = this.f3128f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                acVar.i = this.f3129g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                acVar.j = this.f3130h;
                acVar.f3117c = i2;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ac acVar = new ac();
            f3116b = acVar;
            acVar.t();
        }

        public ac() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public ac(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    x a2 = x.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f3117c = 1 | this.f3117c;
                                        this.f3118d = a2;
                                    }
                                } else if (readTag == 18) {
                                    this.f3117c |= 2;
                                    this.f3119e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3117c |= 4;
                                    this.f3120f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f3117c |= 8;
                                    this.f3121g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3117c |= 16;
                                    this.f3122h = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.f3117c |= 32;
                                    this.i = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.f3117c |= 64;
                                    this.j = codedInputStream.readInt32();
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

        public ac(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0039a a(ac acVar) {
            return q().mergeFrom(acVar);
        }

        public static ac a() {
            return f3116b;
        }

        public static C0039a q() {
            return C0039a.h();
        }

        private void t() {
            this.f3118d = x.OS_TYPE_UNKNWON;
            this.f3119e = "";
            this.f3120f = "";
            this.f3121g = "";
            this.f3122h = 0;
            this.i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f3116b;
        }

        public boolean c() {
            return (this.f3117c & 1) == 1;
        }

        public x d() {
            return this.f3118d;
        }

        public boolean e() {
            return (this.f3117c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3119e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3119e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3117c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            return f3115a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.f3117c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3118d.getNumber()) : 0;
            if ((this.f3117c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3117c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3117c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3117c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f3122h);
            }
            if ((this.f3117c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.i);
            }
            if ((this.f3117c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
            }
            this.l = computeEnumSize;
            return computeEnumSize;
        }

        public ByteString h() {
            Object obj = this.f3120f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3120f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3117c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3121g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3121g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3117c & 16) == 16;
        }

        public int l() {
            return this.f3122h;
        }

        public boolean m() {
            return (this.f3117c & 32) == 32;
        }

        public int n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3117c & 64) == 64;
        }

        public int p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0039a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0039a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3117c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3118d.getNumber());
            }
            if ((this.f3117c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3117c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3117c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3117c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.f3122h);
            }
            if ((this.f3117c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.i);
            }
            if ((this.f3117c & 64) == 64) {
                codedOutputStream.writeInt32(7, this.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class ae extends GeneratedMessageLite implements af {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ae> f3131a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ae f3132b;

        /* renamed from: c  reason: collision with root package name */
        public int f3133c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3134d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3135e;

        /* renamed from: f  reason: collision with root package name */
        public long f3136f;

        /* renamed from: g  reason: collision with root package name */
        public long f3137g;

        /* renamed from: h  reason: collision with root package name */
        public long f3138h;
        public Object i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0040a extends GeneratedMessageLite.Builder<ae, C0040a> implements af {

            /* renamed from: a  reason: collision with root package name */
            public int f3139a;

            /* renamed from: d  reason: collision with root package name */
            public long f3142d;

            /* renamed from: e  reason: collision with root package name */
            public long f3143e;

            /* renamed from: f  reason: collision with root package name */
            public long f3144f;

            /* renamed from: h  reason: collision with root package name */
            public long f3146h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3140b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3141c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3145g = "";

            public C0040a() {
                g();
            }

            private void g() {
            }

            public static C0040a h() {
                return new C0040a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0040a clear() {
                super.clear();
                this.f3140b = "";
                int i = this.f3139a & (-2);
                this.f3139a = i;
                this.f3141c = "";
                int i2 = i & (-3);
                this.f3139a = i2;
                this.f3142d = 0L;
                int i3 = i2 & (-5);
                this.f3139a = i3;
                this.f3143e = 0L;
                int i4 = i3 & (-9);
                this.f3139a = i4;
                this.f3144f = 0L;
                int i5 = i4 & (-17);
                this.f3139a = i5;
                this.f3145g = "";
                int i6 = i5 & (-33);
                this.f3139a = i6;
                this.f3146h = 0L;
                this.f3139a = i6 & (-65);
                return this;
            }

            public C0040a a(long j) {
                this.f3139a |= 4;
                this.f3142d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0040a mergeFrom(ae aeVar) {
                if (aeVar == ae.a()) {
                    return this;
                }
                if (aeVar.c()) {
                    this.f3139a |= 1;
                    this.f3140b = aeVar.f3134d;
                }
                if (aeVar.e()) {
                    this.f3139a |= 2;
                    this.f3141c = aeVar.f3135e;
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
                    this.f3139a |= 32;
                    this.f3145g = aeVar.i;
                }
                if (aeVar.o()) {
                    d(aeVar.p());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0040a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ae aeVar = null;
                try {
                    try {
                        ae parsePartialFrom = ae.f3131a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(aeVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (aeVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0040a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0040a b(long j) {
                this.f3139a |= 8;
                this.f3143e = j;
                return this;
            }

            public C0040a c(long j) {
                this.f3139a |= 16;
                this.f3144f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0040a d(long j) {
                this.f3139a |= 64;
                this.f3146h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public ae build() {
                ae buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ae buildPartial() {
                ae aeVar = new ae(this);
                int i = this.f3139a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aeVar.f3134d = this.f3140b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aeVar.f3135e = this.f3141c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                aeVar.f3136f = this.f3142d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                aeVar.f3137g = this.f3143e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                aeVar.f3138h = this.f3144f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                aeVar.i = this.f3145g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                aeVar.j = this.f3146h;
                aeVar.f3133c = i2;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ae aeVar = new ae();
            f3132b = aeVar;
            aeVar.t();
        }

        public ae() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public ae(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3133c |= 1;
                                this.f3134d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3133c |= 2;
                                this.f3135e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3133c |= 4;
                                this.f3136f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3133c |= 8;
                                this.f3137g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3133c |= 16;
                                this.f3138h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3133c |= 32;
                                this.i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3133c |= 64;
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

        public ae(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0040a a(ae aeVar) {
            return q().mergeFrom(aeVar);
        }

        public static ae a() {
            return f3132b;
        }

        public static C0040a q() {
            return C0040a.h();
        }

        private void t() {
            this.f3134d = "";
            this.f3135e = "";
            this.f3136f = 0L;
            this.f3137g = 0L;
            this.f3138h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f3132b;
        }

        public boolean c() {
            return (this.f3133c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3134d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3134d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3133c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3135e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3135e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3133c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            return f3131a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3133c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3133c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3133c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3136f);
            }
            if ((this.f3133c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3137g);
            }
            if ((this.f3133c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3138h);
            }
            if ((this.f3133c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3133c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3136f;
        }

        public boolean i() {
            return (this.f3133c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3137g;
        }

        public boolean k() {
            return (this.f3133c & 16) == 16;
        }

        public long l() {
            return this.f3138h;
        }

        public boolean m() {
            return (this.f3133c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3133c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0040a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0040a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3133c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3133c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3133c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3136f);
            }
            if ((this.f3133c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3137g);
            }
            if ((this.f3133c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3138h);
            }
            if ((this.f3133c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3133c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3147a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3148b;

        /* renamed from: c  reason: collision with root package name */
        public int f3149c;

        /* renamed from: d  reason: collision with root package name */
        public e f3150d;

        /* renamed from: e  reason: collision with root package name */
        public ae f3151e;

        /* renamed from: f  reason: collision with root package name */
        public l f3152f;

        /* renamed from: g  reason: collision with root package name */
        public n f3153g;

        /* renamed from: h  reason: collision with root package name */
        public j f3154h;
        public aa i;
        public C0036a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0041a extends GeneratedMessageLite.Builder<c, C0041a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3155a;

            /* renamed from: b  reason: collision with root package name */
            public e f3156b = e.UI;

            /* renamed from: c  reason: collision with root package name */
            public ae f3157c = ae.a();

            /* renamed from: d  reason: collision with root package name */
            public l f3158d = l.a();

            /* renamed from: e  reason: collision with root package name */
            public n f3159e = n.a();

            /* renamed from: f  reason: collision with root package name */
            public j f3160f = j.a();

            /* renamed from: g  reason: collision with root package name */
            public aa f3161g = aa.a();

            /* renamed from: h  reason: collision with root package name */
            public C0036a f3162h = C0036a.a();
            public t i = t.a();

            public C0041a() {
                g();
            }

            private void g() {
            }

            public static C0041a h() {
                return new C0041a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0041a clear() {
                super.clear();
                this.f3156b = e.UI;
                this.f3155a &= -2;
                this.f3157c = ae.a();
                this.f3155a &= -3;
                this.f3158d = l.a();
                this.f3155a &= -5;
                this.f3159e = n.a();
                this.f3155a &= -9;
                this.f3160f = j.a();
                this.f3155a &= -17;
                this.f3161g = aa.a();
                this.f3155a &= -33;
                this.f3162h = C0036a.a();
                this.f3155a &= -65;
                this.i = t.a();
                this.f3155a &= -129;
                return this;
            }

            public C0041a a(C0036a c0036a) {
                if (c0036a != null) {
                    this.f3162h = c0036a;
                    this.f3155a |= 64;
                    return this;
                }
                throw null;
            }

            public C0041a a(aa aaVar) {
                if (aaVar != null) {
                    this.f3161g = aaVar;
                    this.f3155a |= 32;
                    return this;
                }
                throw null;
            }

            public C0041a a(ae aeVar) {
                if ((this.f3155a & 2) == 2 && this.f3157c != ae.a()) {
                    aeVar = ae.a(this.f3157c).mergeFrom(aeVar).buildPartial();
                }
                this.f3157c = aeVar;
                this.f3155a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0041a mergeFrom(c cVar) {
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

            public C0041a a(e eVar) {
                if (eVar != null) {
                    this.f3155a |= 1;
                    this.f3156b = eVar;
                    return this;
                }
                throw null;
            }

            public C0041a a(j jVar) {
                if (jVar != null) {
                    this.f3160f = jVar;
                    this.f3155a |= 16;
                    return this;
                }
                throw null;
            }

            public C0041a a(l lVar) {
                if (lVar != null) {
                    this.f3158d = lVar;
                    this.f3155a |= 4;
                    return this;
                }
                throw null;
            }

            public C0041a a(n nVar) {
                if (nVar != null) {
                    this.f3159e = nVar;
                    this.f3155a |= 8;
                    return this;
                }
                throw null;
            }

            public C0041a a(t tVar) {
                if ((this.f3155a & 128) == 128 && this.i != t.a()) {
                    tVar = t.a(this.i).mergeFrom(tVar).buildPartial();
                }
                this.i = tVar;
                this.f3155a |= 128;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0041a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3147a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0041a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0041a b(C0036a c0036a) {
                if ((this.f3155a & 64) == 64 && this.f3162h != C0036a.a()) {
                    c0036a = C0036a.a(this.f3162h).mergeFrom(c0036a).buildPartial();
                }
                this.f3162h = c0036a;
                this.f3155a |= 64;
                return this;
            }

            public C0041a b(aa aaVar) {
                if ((this.f3155a & 32) == 32 && this.f3161g != aa.a()) {
                    aaVar = aa.a(this.f3161g).mergeFrom(aaVar).buildPartial();
                }
                this.f3161g = aaVar;
                this.f3155a |= 32;
                return this;
            }

            public C0041a b(j jVar) {
                if ((this.f3155a & 16) == 16 && this.f3160f != j.a()) {
                    jVar = j.a(this.f3160f).mergeFrom(jVar).buildPartial();
                }
                this.f3160f = jVar;
                this.f3155a |= 16;
                return this;
            }

            public C0041a b(l lVar) {
                if ((this.f3155a & 4) == 4 && this.f3158d != l.a()) {
                    lVar = l.a(this.f3158d).mergeFrom(lVar).buildPartial();
                }
                this.f3158d = lVar;
                this.f3155a |= 4;
                return this;
            }

            public C0041a b(n nVar) {
                if ((this.f3155a & 8) == 8 && this.f3159e != n.a()) {
                    nVar = n.a(this.f3159e).mergeFrom(nVar).buildPartial();
                }
                this.f3159e = nVar;
                this.f3155a |= 8;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public c getDefaultInstanceForType() {
                return c.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public c build() {
                c buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public c buildPartial() {
                c cVar = new c(this);
                int i = this.f3155a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.f3150d = this.f3156b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.f3151e = this.f3157c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f3152f = this.f3158d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                cVar.f3153g = this.f3159e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                cVar.f3154h = this.f3160f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                cVar.i = this.f3161g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                cVar.j = this.f3162h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                cVar.k = this.i;
                cVar.f3149c = i2;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3148b = cVar;
            cVar.v();
        }

        public c() {
            this.l = (byte) -1;
            this.m = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i;
            int i2;
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 8) {
                                if (readTag == 18) {
                                    i = 2;
                                    ae.C0040a builder = (this.f3149c & 2) == 2 ? this.f3151e.toBuilder() : null;
                                    ae aeVar = (ae) codedInputStream.readMessage(ae.f3131a, extensionRegistryLite);
                                    this.f3151e = aeVar;
                                    if (builder != null) {
                                        builder.mergeFrom(aeVar);
                                        this.f3151e = builder.buildPartial();
                                    }
                                    i2 = this.f3149c;
                                } else if (readTag == 26) {
                                    i = 4;
                                    l.C0045a builder2 = (this.f3149c & 4) == 4 ? this.f3152f.toBuilder() : null;
                                    l lVar = (l) codedInputStream.readMessage(l.f3215a, extensionRegistryLite);
                                    this.f3152f = lVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar);
                                        this.f3152f = builder2.buildPartial();
                                    }
                                    i2 = this.f3149c;
                                } else if (readTag == 34) {
                                    n.C0046a builder3 = (this.f3149c & 8) == 8 ? this.f3153g.toBuilder() : null;
                                    n nVar = (n) codedInputStream.readMessage(n.f3228a, extensionRegistryLite);
                                    this.f3153g = nVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(nVar);
                                        this.f3153g = builder3.buildPartial();
                                    }
                                    this.f3149c |= 8;
                                } else if (readTag == 42) {
                                    i = 16;
                                    j.C0044a builder4 = (this.f3149c & 16) == 16 ? this.f3154h.toBuilder() : null;
                                    j jVar = (j) codedInputStream.readMessage(j.f3199a, extensionRegistryLite);
                                    this.f3154h = jVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(jVar);
                                        this.f3154h = builder4.buildPartial();
                                    }
                                    i2 = this.f3149c;
                                } else if (readTag == 50) {
                                    i = 32;
                                    aa.C0038a builder5 = (this.f3149c & 32) == 32 ? this.i.toBuilder() : null;
                                    aa aaVar = (aa) codedInputStream.readMessage(aa.f3099a, extensionRegistryLite);
                                    this.i = aaVar;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(aaVar);
                                        this.i = builder5.buildPartial();
                                    }
                                    i2 = this.f3149c;
                                } else if (readTag == 58) {
                                    i = 64;
                                    C0036a.C0037a builder6 = (this.f3149c & 64) == 64 ? this.j.toBuilder() : null;
                                    C0036a c0036a = (C0036a) codedInputStream.readMessage(C0036a.f3085a, extensionRegistryLite);
                                    this.j = c0036a;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(c0036a);
                                        this.j = builder6.buildPartial();
                                    }
                                    i2 = this.f3149c;
                                } else if (readTag == 66) {
                                    i = 128;
                                    t.C0049a builder7 = (this.f3149c & 128) == 128 ? this.k.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.f3264a, extensionRegistryLite);
                                    this.k = tVar;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(tVar);
                                        this.k = builder7.buildPartial();
                                    }
                                    i2 = this.f3149c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3149c = i2 | i;
                            } else {
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f3149c = 1 | this.f3149c;
                                    this.f3150d = a2;
                                }
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

        public c(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.l = (byte) -1;
            this.m = -1;
        }

        public static C0041a a(c cVar) {
            return s().mergeFrom(cVar);
        }

        public static c a() {
            return f3148b;
        }

        public static C0041a s() {
            return C0041a.h();
        }

        private void v() {
            this.f3150d = e.UI;
            this.f3151e = ae.a();
            this.f3152f = l.a();
            this.f3153g = n.a();
            this.f3154h = j.a();
            this.i = aa.a();
            this.j = C0036a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3148b;
        }

        public boolean c() {
            return (this.f3149c & 1) == 1;
        }

        public e d() {
            return this.f3150d;
        }

        public boolean e() {
            return (this.f3149c & 2) == 2;
        }

        public ae f() {
            return this.f3151e;
        }

        public boolean g() {
            return (this.f3149c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3147a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.m;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.f3149c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3150d.getNumber()) : 0;
            if ((this.f3149c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f3151e);
            }
            if ((this.f3149c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f3152f);
            }
            if ((this.f3149c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f3153g);
            }
            if ((this.f3149c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f3154h);
            }
            if ((this.f3149c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.i);
            }
            if ((this.f3149c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
            }
            if ((this.f3149c & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
            }
            this.m = computeEnumSize;
            return computeEnumSize;
        }

        public l h() {
            return this.f3152f;
        }

        public boolean i() {
            return (this.f3149c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.l;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.l = (byte) 1;
            return true;
        }

        public n j() {
            return this.f3153g;
        }

        public boolean k() {
            return (this.f3149c & 16) == 16;
        }

        public j l() {
            return this.f3154h;
        }

        public boolean m() {
            return (this.f3149c & 32) == 32;
        }

        public aa n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3149c & 64) == 64;
        }

        public C0036a p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3149c & 128) == 128;
        }

        public t r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C0041a newBuilderForType() {
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0041a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3149c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3150d.getNumber());
            }
            if ((this.f3149c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.f3151e);
            }
            if ((this.f3149c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3152f);
            }
            if ((this.f3149c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f3153g);
            }
            if ((this.f3149c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.f3154h);
            }
            if ((this.f3149c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.i);
            }
            if ((this.f3149c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.f3149c & 128) == 128) {
                codedOutputStream.writeMessage(8, this.k);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public enum e implements Internal.EnumLite {
        UI(101),
        CRASH(201),
        DB(301),
        CONNECTION(401),
        REQUEST(501),
        ACK(601),
        MSG(701);
        

        /* renamed from: h  reason: collision with root package name */
        public final int f3170h;

        e(int i2) {
            this.f3170h = i2;
        }

        public static e a(int i2) {
            if (i2 != 101) {
                if (i2 != 201) {
                    if (i2 != 301) {
                        if (i2 != 401) {
                            if (i2 != 501) {
                                if (i2 != 601) {
                                    if (i2 != 701) {
                                        return null;
                                    }
                                    return MSG;
                                }
                                return ACK;
                            }
                            return REQUEST;
                        }
                        return CONNECTION;
                    }
                    return DB;
                }
                return CRASH;
            }
            return UI;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.f3170h;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f3171a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final f f3172b;

        /* renamed from: c  reason: collision with root package name */
        public int f3173c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3174d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3175e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3176f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3177g;

        /* renamed from: h  reason: collision with root package name */
        public int f3178h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0042a extends GeneratedMessageLite.Builder<f, C0042a> implements g {

            /* renamed from: a  reason: collision with root package name */
            public int f3179a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3180b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3181c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3182d = "";

            public C0042a() {
                g();
            }

            private void g() {
            }

            public static C0042a h() {
                return new C0042a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0042a clear() {
                super.clear();
                this.f3180b = "";
                int i = this.f3179a & (-2);
                this.f3179a = i;
                this.f3181c = "";
                int i2 = i & (-3);
                this.f3179a = i2;
                this.f3182d = "";
                this.f3179a = i2 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0042a mergeFrom(f fVar) {
                if (fVar == f.a()) {
                    return this;
                }
                if (fVar.c()) {
                    this.f3179a |= 1;
                    this.f3180b = fVar.f3174d;
                }
                if (fVar.e()) {
                    this.f3179a |= 2;
                    this.f3181c = fVar.f3175e;
                }
                if (fVar.g()) {
                    this.f3179a |= 4;
                    this.f3182d = fVar.f3176f;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0042a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                f fVar = null;
                try {
                    try {
                        f parsePartialFrom = f.f3171a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(fVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fVar != null) {
                    }
                    throw th;
                }
            }

            public C0042a a(String str) {
                if (str != null) {
                    this.f3179a |= 1;
                    this.f3180b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0042a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0042a b(String str) {
                if (str != null) {
                    this.f3179a |= 2;
                    this.f3181c = str;
                    return this;
                }
                throw null;
            }

            public C0042a c(String str) {
                if (str != null) {
                    this.f3179a |= 4;
                    this.f3182d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public f getDefaultInstanceForType() {
                return f.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public f build() {
                f buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public f buildPartial() {
                f fVar = new f(this);
                int i = this.f3179a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                fVar.f3174d = this.f3180b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                fVar.f3175e = this.f3181c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                fVar.f3176f = this.f3182d;
                fVar.f3173c = i2;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f fVar = new f();
            f3172b = fVar;
            fVar.l();
        }

        public f() {
            this.f3177g = (byte) -1;
            this.f3178h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3177g = (byte) -1;
            this.f3178h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3173c |= 1;
                                    this.f3174d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3173c |= 2;
                                    this.f3175e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3173c |= 4;
                                    this.f3176f = codedInputStream.readBytes();
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

        public f(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3177g = (byte) -1;
            this.f3178h = -1;
        }

        public static C0042a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f3172b;
        }

        public static C0042a i() {
            return C0042a.h();
        }

        private void l() {
            this.f3174d = "";
            this.f3175e = "";
            this.f3176f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f3172b;
        }

        public boolean c() {
            return (this.f3173c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3174d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3174d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3173c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3175e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3175e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3173c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            return f3171a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3178h;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3173c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3173c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3173c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3178h = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3176f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3176f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3177g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3177g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0042a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0042a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3173c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3173c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3173c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class h extends GeneratedMessageLite implements i {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<h> f3183a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final h f3184b;

        /* renamed from: c  reason: collision with root package name */
        public int f3185c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3186d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3187e;

        /* renamed from: f  reason: collision with root package name */
        public p f3188f;

        /* renamed from: g  reason: collision with root package name */
        public long f3189g;

        /* renamed from: h  reason: collision with root package name */
        public long f3190h;
        public ac i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<h, C0043a> implements i {

            /* renamed from: a  reason: collision with root package name */
            public int f3191a;

            /* renamed from: e  reason: collision with root package name */
            public long f3195e;

            /* renamed from: f  reason: collision with root package name */
            public long f3196f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3192b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3193c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f3194d = p.a();

            /* renamed from: g  reason: collision with root package name */
            public ac f3197g = ac.a();

            /* renamed from: h  reason: collision with root package name */
            public f f3198h = f.a();
            public v i = v.a();

            public C0043a() {
                j();
            }

            private void j() {
            }

            public static C0043a k() {
                return new C0043a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0043a clear() {
                super.clear();
                this.f3192b = "";
                int i = this.f3191a & (-2);
                this.f3191a = i;
                this.f3193c = "";
                this.f3191a = i & (-3);
                this.f3194d = p.a();
                int i2 = this.f3191a & (-5);
                this.f3191a = i2;
                this.f3195e = 0L;
                int i3 = i2 & (-9);
                this.f3191a = i3;
                this.f3196f = 0L;
                this.f3191a = i3 & (-17);
                this.f3197g = ac.a();
                this.f3191a &= -33;
                this.f3198h = f.a();
                this.f3191a &= -65;
                this.i = v.a();
                this.f3191a &= -129;
                return this;
            }

            public C0043a a(long j) {
                this.f3191a |= 8;
                this.f3195e = j;
                return this;
            }

            public C0043a a(ac acVar) {
                if (acVar != null) {
                    this.f3197g = acVar;
                    this.f3191a |= 32;
                    return this;
                }
                throw null;
            }

            public C0043a a(f fVar) {
                if (fVar != null) {
                    this.f3198h = fVar;
                    this.f3191a |= 64;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0043a mergeFrom(h hVar) {
                if (hVar == h.a()) {
                    return this;
                }
                if (hVar.c()) {
                    this.f3191a |= 1;
                    this.f3192b = hVar.f3186d;
                }
                if (hVar.e()) {
                    this.f3191a |= 2;
                    this.f3193c = hVar.f3187e;
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

            public C0043a a(p pVar) {
                if (pVar != null) {
                    this.f3194d = pVar;
                    this.f3191a |= 4;
                    return this;
                }
                throw null;
            }

            public C0043a a(v vVar) {
                if (vVar != null) {
                    this.i = vVar;
                    this.f3191a |= 128;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0043a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                h hVar = null;
                try {
                    try {
                        h parsePartialFrom = h.f3183a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(hVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (hVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0043a clone() {
                return k().mergeFrom(buildPartial());
            }

            public C0043a b(long j) {
                this.f3191a |= 16;
                this.f3196f = j;
                return this;
            }

            public C0043a b(ac acVar) {
                if ((this.f3191a & 32) == 32 && this.f3197g != ac.a()) {
                    acVar = ac.a(this.f3197g).mergeFrom(acVar).buildPartial();
                }
                this.f3197g = acVar;
                this.f3191a |= 32;
                return this;
            }

            public C0043a b(f fVar) {
                if ((this.f3191a & 64) == 64 && this.f3198h != f.a()) {
                    fVar = f.a(this.f3198h).mergeFrom(fVar).buildPartial();
                }
                this.f3198h = fVar;
                this.f3191a |= 64;
                return this;
            }

            public C0043a b(p pVar) {
                if ((this.f3191a & 4) == 4 && this.f3194d != p.a()) {
                    pVar = p.a(this.f3194d).mergeFrom(pVar).buildPartial();
                }
                this.f3194d = pVar;
                this.f3191a |= 4;
                return this;
            }

            public C0043a b(v vVar) {
                if ((this.f3191a & 128) == 128 && this.i != v.a()) {
                    vVar = v.a(this.i).mergeFrom(vVar).buildPartial();
                }
                this.i = vVar;
                this.f3191a |= 128;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public h getDefaultInstanceForType() {
                return h.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public h build() {
                h buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public h buildPartial() {
                h hVar = new h(this);
                int i = this.f3191a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                hVar.f3186d = this.f3192b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                hVar.f3187e = this.f3193c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                hVar.f3188f = this.f3194d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                hVar.f3189g = this.f3195e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                hVar.f3190h = this.f3196f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                hVar.i = this.f3197g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                hVar.j = this.f3198h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                hVar.k = this.i;
                hVar.f3185c = i2;
                return hVar;
            }

            public boolean f() {
                return (this.f3191a & 4) == 4;
            }

            public p g() {
                return this.f3194d;
            }

            public boolean h() {
                return (this.f3191a & 8) == 8;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (h()) {
                    if (f()) {
                        return g().isInitialized();
                    }
                    return true;
                }
                return false;
            }
        }

        static {
            h hVar = new h();
            f3184b = hVar;
            hVar.v();
        }

        public h() {
            this.l = (byte) -1;
            this.m = -1;
        }

        public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i;
            int i2;
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3185c |= 1;
                                this.f3186d = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (readTag == 58) {
                                    i = 4;
                                    p.C0047a builder = (this.f3185c & 4) == 4 ? this.f3188f.toBuilder() : null;
                                    p pVar = (p) codedInputStream.readMessage(p.f3244a, extensionRegistryLite);
                                    this.f3188f = pVar;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar);
                                        this.f3188f = builder.buildPartial();
                                    }
                                    i2 = this.f3185c;
                                } else if (readTag == 80) {
                                    this.f3185c |= 8;
                                    this.f3189g = codedInputStream.readInt64();
                                } else if (readTag == 96) {
                                    this.f3185c |= 16;
                                    this.f3190h = codedInputStream.readInt64();
                                } else if (readTag == 162) {
                                    i = 32;
                                    ac.C0039a builder2 = (this.f3185c & 32) == 32 ? this.i.toBuilder() : null;
                                    ac acVar = (ac) codedInputStream.readMessage(ac.f3115a, extensionRegistryLite);
                                    this.i = acVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(acVar);
                                        this.i = builder2.buildPartial();
                                    }
                                    i2 = this.f3185c;
                                } else if (readTag == 170) {
                                    i = 64;
                                    f.C0042a builder3 = (this.f3185c & 64) == 64 ? this.j.toBuilder() : null;
                                    f fVar = (f) codedInputStream.readMessage(f.f3171a, extensionRegistryLite);
                                    this.j = fVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(fVar);
                                        this.j = builder3.buildPartial();
                                    }
                                    i2 = this.f3185c;
                                } else if (readTag == 178) {
                                    i = 128;
                                    v.C0050a builder4 = (this.f3185c & 128) == 128 ? this.k.toBuilder() : null;
                                    v vVar = (v) codedInputStream.readMessage(v.f3280a, extensionRegistryLite);
                                    this.k = vVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(vVar);
                                        this.k = builder4.buildPartial();
                                    }
                                    i2 = this.f3185c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3185c = i2 | i;
                            } else {
                                this.f3185c |= 2;
                                this.f3187e = codedInputStream.readBytes();
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

        public h(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.l = (byte) -1;
            this.m = -1;
        }

        public static C0043a a(h hVar) {
            return t().mergeFrom(hVar);
        }

        public static h a() {
            return f3184b;
        }

        public static C0043a t() {
            return C0043a.k();
        }

        private void v() {
            this.f3186d = "";
            this.f3187e = "";
            this.f3188f = p.a();
            this.f3189g = 0L;
            this.f3190h = 0L;
            this.i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f3184b;
        }

        public boolean c() {
            return (this.f3185c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3186d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3186d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3185c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3187e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3187e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3185c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            return f3183a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.m;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3185c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3185c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3185c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f3188f);
            }
            if ((this.f3185c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f3189g);
            }
            if ((this.f3185c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f3190h);
            }
            if ((this.f3185c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.i);
            }
            if ((this.f3185c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
            }
            if ((this.f3185c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
            }
            this.m = computeBytesSize;
            return computeBytesSize;
        }

        public p h() {
            return this.f3188f;
        }

        public boolean i() {
            return (this.f3185c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
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

        public long j() {
            return this.f3189g;
        }

        public boolean k() {
            return (this.f3185c & 16) == 16;
        }

        public long l() {
            return this.f3190h;
        }

        public boolean m() {
            return (this.f3185c & 32) == 32;
        }

        public ac n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3185c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3185c & 128) == 128;
        }

        public v r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0043a newBuilderForType() {
            return t();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0043a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3185c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3185c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3185c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f3188f);
            }
            if ((this.f3185c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.f3189g);
            }
            if ((this.f3185c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.f3190h);
            }
            if ((this.f3185c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.i);
            }
            if ((this.f3185c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.f3185c & 128) == 128) {
                codedOutputStream.writeMessage(22, this.k);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class j extends GeneratedMessageLite implements k {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<j> f3199a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final j f3200b;

        /* renamed from: c  reason: collision with root package name */
        public int f3201c;

        /* renamed from: d  reason: collision with root package name */
        public long f3202d;

        /* renamed from: e  reason: collision with root package name */
        public long f3203e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3204f;

        /* renamed from: g  reason: collision with root package name */
        public long f3205g;

        /* renamed from: h  reason: collision with root package name */
        public long f3206h;
        public Object i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<j, C0044a> implements k {

            /* renamed from: a  reason: collision with root package name */
            public int f3207a;

            /* renamed from: b  reason: collision with root package name */
            public long f3208b;

            /* renamed from: c  reason: collision with root package name */
            public long f3209c;

            /* renamed from: e  reason: collision with root package name */
            public long f3211e;

            /* renamed from: f  reason: collision with root package name */
            public long f3212f;

            /* renamed from: h  reason: collision with root package name */
            public long f3214h;

            /* renamed from: d  reason: collision with root package name */
            public Object f3210d = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3213g = "";

            public C0044a() {
                g();
            }

            private void g() {
            }

            public static C0044a h() {
                return new C0044a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0044a clear() {
                super.clear();
                this.f3208b = 0L;
                int i = this.f3207a & (-2);
                this.f3207a = i;
                this.f3209c = 0L;
                int i2 = i & (-3);
                this.f3207a = i2;
                this.f3210d = "";
                int i3 = i2 & (-5);
                this.f3207a = i3;
                this.f3211e = 0L;
                int i4 = i3 & (-9);
                this.f3207a = i4;
                this.f3212f = 0L;
                int i5 = i4 & (-17);
                this.f3207a = i5;
                this.f3213g = "";
                int i6 = i5 & (-33);
                this.f3207a = i6;
                this.f3214h = 0L;
                this.f3207a = i6 & (-65);
                return this;
            }

            public C0044a a(long j) {
                this.f3207a |= 1;
                this.f3208b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0044a mergeFrom(j jVar) {
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
                    this.f3207a |= 4;
                    this.f3210d = jVar.f3204f;
                }
                if (jVar.i()) {
                    c(jVar.j());
                }
                if (jVar.k()) {
                    d(jVar.l());
                }
                if (jVar.m()) {
                    this.f3207a |= 32;
                    this.f3213g = jVar.i;
                }
                if (jVar.o()) {
                    e(jVar.p());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0044a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                j jVar = null;
                try {
                    try {
                        j parsePartialFrom = j.f3199a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(jVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jVar != null) {
                    }
                    throw th;
                }
            }

            public C0044a a(String str) {
                if (str != null) {
                    this.f3207a |= 4;
                    this.f3210d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0044a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0044a b(long j) {
                this.f3207a |= 2;
                this.f3209c = j;
                return this;
            }

            public C0044a b(String str) {
                if (str != null) {
                    this.f3207a |= 32;
                    this.f3213g = str;
                    return this;
                }
                throw null;
            }

            public C0044a c(long j) {
                this.f3207a |= 8;
                this.f3211e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0044a d(long j) {
                this.f3207a |= 16;
                this.f3212f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public j build() {
                j buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public C0044a e(long j) {
                this.f3207a |= 64;
                this.f3214h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i = this.f3207a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                jVar.f3202d = this.f3208b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jVar.f3203e = this.f3209c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jVar.f3204f = this.f3210d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jVar.f3205g = this.f3211e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                jVar.f3206h = this.f3212f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                jVar.i = this.f3213g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                jVar.j = this.f3214h;
                jVar.f3201c = i2;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            j jVar = new j();
            f3200b = jVar;
            jVar.t();
        }

        public j() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public j(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.f3201c |= 1;
                                    this.f3202d = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.f3201c |= 2;
                                    this.f3203e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3201c |= 4;
                                    this.f3204f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3201c |= 8;
                                    this.f3205g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f3201c |= 16;
                                    this.f3206h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f3201c |= 32;
                                    this.i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f3201c |= 64;
                                    this.j = codedInputStream.readInt64();
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

        public j(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0044a a(j jVar) {
            return q().mergeFrom(jVar);
        }

        public static j a() {
            return f3200b;
        }

        public static C0044a q() {
            return C0044a.h();
        }

        private void t() {
            this.f3202d = 0L;
            this.f3203e = 0L;
            this.f3204f = "";
            this.f3205g = 0L;
            this.f3206h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            return f3200b;
        }

        public boolean c() {
            return (this.f3201c & 1) == 1;
        }

        public long d() {
            return this.f3202d;
        }

        public boolean e() {
            return (this.f3201c & 2) == 2;
        }

        public long f() {
            return this.f3203e;
        }

        public boolean g() {
            return (this.f3201c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f3199a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.f3201c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3202d) : 0;
            if ((this.f3201c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3203e);
            }
            if ((this.f3201c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3201c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3205g);
            }
            if ((this.f3201c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3206h);
            }
            if ((this.f3201c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3201c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString h() {
            Object obj = this.f3204f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3204f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3201c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3205g;
        }

        public boolean k() {
            return (this.f3201c & 16) == 16;
        }

        public long l() {
            return this.f3206h;
        }

        public boolean m() {
            return (this.f3201c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3201c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0044a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0044a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3201c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3202d);
            }
            if ((this.f3201c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3203e);
            }
            if ((this.f3201c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3201c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3205g);
            }
            if ((this.f3201c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3206h);
            }
            if ((this.f3201c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3201c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class l extends GeneratedMessageLite implements m {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<l> f3215a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final l f3216b;

        /* renamed from: c  reason: collision with root package name */
        public int f3217c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3218d;

        /* renamed from: e  reason: collision with root package name */
        public long f3219e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3220f;

        /* renamed from: g  reason: collision with root package name */
        public long f3221g;

        /* renamed from: h  reason: collision with root package name */
        public byte f3222h;
        public int i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<l, C0045a> implements m {

            /* renamed from: a  reason: collision with root package name */
            public int f3223a;

            /* renamed from: c  reason: collision with root package name */
            public long f3225c;

            /* renamed from: e  reason: collision with root package name */
            public long f3227e;

            /* renamed from: b  reason: collision with root package name */
            public Object f3224b = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3226d = "";

            public C0045a() {
                g();
            }

            private void g() {
            }

            public static C0045a h() {
                return new C0045a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0045a clear() {
                super.clear();
                this.f3224b = "";
                int i = this.f3223a & (-2);
                this.f3223a = i;
                this.f3225c = 0L;
                int i2 = i & (-3);
                this.f3223a = i2;
                this.f3226d = "";
                int i3 = i2 & (-5);
                this.f3223a = i3;
                this.f3227e = 0L;
                this.f3223a = i3 & (-9);
                return this;
            }

            public C0045a a(long j) {
                this.f3223a |= 2;
                this.f3225c = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0045a mergeFrom(l lVar) {
                if (lVar == l.a()) {
                    return this;
                }
                if (lVar.c()) {
                    this.f3223a |= 1;
                    this.f3224b = lVar.f3218d;
                }
                if (lVar.e()) {
                    a(lVar.f());
                }
                if (lVar.g()) {
                    this.f3223a |= 4;
                    this.f3226d = lVar.f3220f;
                }
                if (lVar.i()) {
                    b(lVar.j());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0045a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                l lVar = null;
                try {
                    try {
                        l parsePartialFrom = l.f3215a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(lVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lVar != null) {
                    }
                    throw th;
                }
            }

            public C0045a a(String str) {
                if (str != null) {
                    this.f3223a |= 1;
                    this.f3224b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0045a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0045a b(long j) {
                this.f3223a |= 8;
                this.f3227e = j;
                return this;
            }

            public C0045a b(String str) {
                if (str != null) {
                    this.f3223a |= 4;
                    this.f3226d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public l getDefaultInstanceForType() {
                return l.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public l build() {
                l buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public l buildPartial() {
                l lVar = new l(this);
                int i = this.f3223a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lVar.f3218d = this.f3224b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lVar.f3219e = this.f3225c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                lVar.f3220f = this.f3226d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                lVar.f3221g = this.f3227e;
                lVar.f3217c = i2;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            l lVar = new l();
            f3216b = lVar;
            lVar.n();
        }

        public l() {
            this.f3222h = (byte) -1;
            this.i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3222h = (byte) -1;
            this.i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3217c |= 1;
                                    this.f3218d = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.f3217c |= 2;
                                    this.f3219e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3217c |= 4;
                                    this.f3220f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3217c |= 8;
                                    this.f3221g = codedInputStream.readInt64();
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

        public l(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3222h = (byte) -1;
            this.i = -1;
        }

        public static C0045a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f3216b;
        }

        public static C0045a k() {
            return C0045a.h();
        }

        private void n() {
            this.f3218d = "";
            this.f3219e = 0L;
            this.f3220f = "";
            this.f3221g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            return f3216b;
        }

        public boolean c() {
            return (this.f3217c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3218d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3218d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3217c & 2) == 2;
        }

        public long f() {
            return this.f3219e;
        }

        public boolean g() {
            return (this.f3217c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f3215a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.i;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3217c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3217c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3219e);
            }
            if ((this.f3217c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3217c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3221g);
            }
            this.i = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3220f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3220f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3217c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3222h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3222h = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3221g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0045a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0045a newBuilderForType() {
            return k();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3217c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3217c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3219e);
            }
            if ((this.f3217c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3217c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3221g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f3228a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final n f3229b;

        /* renamed from: c  reason: collision with root package name */
        public int f3230c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3231d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3232e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3233f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3234g;

        /* renamed from: h  reason: collision with root package name */
        public long f3235h;
        public long i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<n, C0046a> implements o {

            /* renamed from: a  reason: collision with root package name */
            public int f3236a;

            /* renamed from: f  reason: collision with root package name */
            public long f3241f;

            /* renamed from: g  reason: collision with root package name */
            public long f3242g;

            /* renamed from: h  reason: collision with root package name */
            public long f3243h;
            public long j;

            /* renamed from: b  reason: collision with root package name */
            public Object f3237b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3238c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3239d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3240e = "";
            public Object i = "";

            public C0046a() {
                g();
            }

            private void g() {
            }

            public static C0046a h() {
                return new C0046a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0046a clear() {
                super.clear();
                this.f3237b = "";
                int i = this.f3236a & (-2);
                this.f3236a = i;
                this.f3238c = "";
                int i2 = i & (-3);
                this.f3236a = i2;
                this.f3239d = "";
                int i3 = i2 & (-5);
                this.f3236a = i3;
                this.f3240e = "";
                int i4 = i3 & (-9);
                this.f3236a = i4;
                this.f3241f = 0L;
                int i5 = i4 & (-17);
                this.f3236a = i5;
                this.f3242g = 0L;
                int i6 = i5 & (-33);
                this.f3236a = i6;
                this.f3243h = 0L;
                int i7 = i6 & (-65);
                this.f3236a = i7;
                this.i = "";
                int i8 = i7 & (-129);
                this.f3236a = i8;
                this.j = 0L;
                this.f3236a = i8 & (-257);
                return this;
            }

            public C0046a a(long j) {
                this.f3236a |= 16;
                this.f3241f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0046a mergeFrom(n nVar) {
                if (nVar == n.a()) {
                    return this;
                }
                if (nVar.c()) {
                    this.f3236a |= 1;
                    this.f3237b = nVar.f3231d;
                }
                if (nVar.e()) {
                    this.f3236a |= 2;
                    this.f3238c = nVar.f3232e;
                }
                if (nVar.g()) {
                    this.f3236a |= 4;
                    this.f3239d = nVar.f3233f;
                }
                if (nVar.i()) {
                    this.f3236a |= 8;
                    this.f3240e = nVar.f3234g;
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
                    this.f3236a |= 128;
                    this.i = nVar.k;
                }
                if (nVar.s()) {
                    d(nVar.t());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0046a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                n nVar = null;
                try {
                    try {
                        n parsePartialFrom = n.f3228a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(nVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (nVar != null) {
                    }
                    throw th;
                }
            }

            public C0046a a(String str) {
                if (str != null) {
                    this.f3236a |= 1;
                    this.f3237b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0046a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0046a b(long j) {
                this.f3236a |= 32;
                this.f3242g = j;
                return this;
            }

            public C0046a b(String str) {
                if (str != null) {
                    this.f3236a |= 2;
                    this.f3238c = str;
                    return this;
                }
                throw null;
            }

            public C0046a c(long j) {
                this.f3236a |= 64;
                this.f3243h = j;
                return this;
            }

            public C0046a c(String str) {
                if (str != null) {
                    this.f3236a |= 4;
                    this.f3239d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                return n.a();
            }

            public C0046a d(long j) {
                this.f3236a |= 256;
                this.j = j;
                return this;
            }

            public C0046a d(String str) {
                if (str != null) {
                    this.f3236a |= 8;
                    this.f3240e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public n build() {
                n buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public C0046a e(String str) {
                if (str != null) {
                    this.f3236a |= 128;
                    this.i = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i = this.f3236a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                nVar.f3231d = this.f3237b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                nVar.f3232e = this.f3238c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                nVar.f3233f = this.f3239d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                nVar.f3234g = this.f3240e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                nVar.f3235h = this.f3241f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                nVar.i = this.f3242g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                nVar.j = this.f3243h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                nVar.k = this.i;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                nVar.l = this.j;
                nVar.f3230c = i2;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            n nVar = new n();
            f3229b = nVar;
            nVar.x();
        }

        public n() {
            this.m = (byte) -1;
            this.n = -1;
        }

        public n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.m = (byte) -1;
            this.n = -1;
            x();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3230c |= 1;
                                this.f3231d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3230c |= 2;
                                this.f3232e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f3230c |= 4;
                                this.f3233f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f3230c |= 8;
                                this.f3234g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f3230c |= 16;
                                this.f3235h = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.f3230c |= 32;
                                this.i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3230c |= 64;
                                this.j = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.f3230c |= 128;
                                this.k = codedInputStream.readBytes();
                            } else if (readTag == 72) {
                                this.f3230c |= 256;
                                this.l = codedInputStream.readInt64();
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

        public n(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.m = (byte) -1;
            this.n = -1;
        }

        public static C0046a a(n nVar) {
            return u().mergeFrom(nVar);
        }

        public static n a() {
            return f3229b;
        }

        public static C0046a u() {
            return C0046a.h();
        }

        private void x() {
            this.f3231d = "";
            this.f3232e = "";
            this.f3233f = "";
            this.f3234g = "";
            this.f3235h = 0L;
            this.i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f3229b;
        }

        public boolean c() {
            return (this.f3230c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3231d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3231d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3230c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3232e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3232e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3230c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            return f3228a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.n;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3230c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3230c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3230c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3230c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3230c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3235h);
            }
            if ((this.f3230c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.i);
            }
            if ((this.f3230c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            if ((this.f3230c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
            }
            if ((this.f3230c & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
            }
            this.n = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3233f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3233f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3230c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.m = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3234g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3234g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3230c & 16) == 16;
        }

        public long l() {
            return this.f3235h;
        }

        public boolean m() {
            return (this.f3230c & 32) == 32;
        }

        public long n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3230c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3230c & 128) == 128;
        }

        public ByteString r() {
            Object obj = this.k;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.k = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean s() {
            return (this.f3230c & 256) == 256;
        }

        public long t() {
            return this.l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C0046a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C0046a newBuilderForType() {
            return u();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3230c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3230c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3230c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3230c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3230c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3235h);
            }
            if ((this.f3230c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.i);
            }
            if ((this.f3230c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.f3230c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.f3230c & 256) == 256) {
                codedOutputStream.writeInt64(9, this.l);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class p extends GeneratedMessageLite implements q {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<p> f3244a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final p f3245b;

        /* renamed from: c  reason: collision with root package name */
        public int f3246c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3247d;

        /* renamed from: e  reason: collision with root package name */
        public byte f3248e;

        /* renamed from: f  reason: collision with root package name */
        public int f3249f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<p, C0047a> implements q {

            /* renamed from: a  reason: collision with root package name */
            public int f3250a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3251b = "";

            public C0047a() {
                h();
            }

            private void h() {
            }

            public static C0047a i() {
                return new C0047a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0047a clear() {
                super.clear();
                this.f3251b = "";
                this.f3250a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f3250a |= 1;
                    this.f3251b = pVar.f3247d;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0047a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                p pVar = null;
                try {
                    try {
                        p parsePartialFrom = p.f3244a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(pVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (pVar != null) {
                    }
                    throw th;
                }
            }

            public C0047a a(String str) {
                if (str != null) {
                    this.f3250a |= 1;
                    this.f3251b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0047a clone() {
                return i().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public p getDefaultInstanceForType() {
                return p.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public p build() {
                p buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public p buildPartial() {
                p pVar = new p(this);
                int i = (this.f3250a & 1) != 1 ? 0 : 1;
                pVar.f3247d = this.f3251b;
                pVar.f3246c = i;
                return pVar;
            }

            public boolean f() {
                return (this.f3250a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            p pVar = new p();
            f3245b = pVar;
            pVar.h();
        }

        public p() {
            this.f3248e = (byte) -1;
            this.f3249f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3248e = (byte) -1;
            this.f3249f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 34) {
                                this.f3246c |= 1;
                                this.f3247d = codedInputStream.readBytes();
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

        public p(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3248e = (byte) -1;
            this.f3249f = -1;
        }

        public static C0047a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f3245b;
        }

        public static C0047a e() {
            return C0047a.i();
        }

        private void h() {
            this.f3247d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f3245b;
        }

        public boolean c() {
            return (this.f3246c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3247d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3247d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C0047a newBuilderForType() {
            return e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C0047a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            return f3244a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3249f;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3246c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
            this.f3249f = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3248e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.f3248e = (byte) 1;
                return true;
            } else {
                this.f3248e = (byte) 0;
                return false;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3246c & 1) == 1) {
                codedOutputStream.writeBytes(4, d());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class r extends GeneratedMessageLite implements s {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<r> f3252a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final r f3253b;

        /* renamed from: c  reason: collision with root package name */
        public int f3254c;

        /* renamed from: d  reason: collision with root package name */
        public int f3255d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3256e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3257f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3258g;

        /* renamed from: h  reason: collision with root package name */
        public int f3259h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<r, C0048a> implements s {

            /* renamed from: a  reason: collision with root package name */
            public int f3260a;

            /* renamed from: b  reason: collision with root package name */
            public int f3261b = 7399;

            /* renamed from: c  reason: collision with root package name */
            public Object f3262c = "push_im_client";

            /* renamed from: d  reason: collision with root package name */
            public Object f3263d = "phonebaidu";

            public C0048a() {
                g();
            }

            private void g() {
            }

            public static C0048a h() {
                return new C0048a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0048a clear() {
                super.clear();
                this.f3261b = 7399;
                int i = this.f3260a & (-2);
                this.f3260a = i;
                this.f3262c = "push_im_client";
                int i2 = i & (-3);
                this.f3260a = i2;
                this.f3263d = "phonebaidu";
                this.f3260a = i2 & (-5);
                return this;
            }

            public C0048a a(int i) {
                this.f3260a |= 1;
                this.f3261b = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0048a mergeFrom(r rVar) {
                if (rVar == r.a()) {
                    return this;
                }
                if (rVar.c()) {
                    a(rVar.d());
                }
                if (rVar.e()) {
                    this.f3260a |= 2;
                    this.f3262c = rVar.f3256e;
                }
                if (rVar.g()) {
                    this.f3260a |= 4;
                    this.f3263d = rVar.f3257f;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0048a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                r rVar = null;
                try {
                    try {
                        r parsePartialFrom = r.f3252a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(rVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0048a clone() {
                return h().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public r getDefaultInstanceForType() {
                return r.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public r build() {
                r buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public r buildPartial() {
                r rVar = new r(this);
                int i = this.f3260a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rVar.f3255d = this.f3261b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rVar.f3256e = this.f3262c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rVar.f3257f = this.f3263d;
                rVar.f3254c = i2;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            r rVar = new r();
            f3253b = rVar;
            rVar.l();
        }

        public r() {
            this.f3258g = (byte) -1;
            this.f3259h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3258g = (byte) -1;
            this.f3259h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3254c |= 1;
                                    this.f3255d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3254c |= 2;
                                    this.f3256e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3254c |= 4;
                                    this.f3257f = codedInputStream.readBytes();
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

        public r(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3258g = (byte) -1;
            this.f3259h = -1;
        }

        public static C0048a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f3253b;
        }

        public static C0048a i() {
            return C0048a.h();
        }

        private void l() {
            this.f3255d = 7399;
            this.f3256e = "push_im_client";
            this.f3257f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f3253b;
        }

        public boolean c() {
            return (this.f3254c & 1) == 1;
        }

        public int d() {
            return this.f3255d;
        }

        public boolean e() {
            return (this.f3254c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3256e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3256e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3254c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            return f3252a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3259h;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.f3254c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3255d) : 0;
            if ((this.f3254c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3254c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3259h = computeInt32Size;
            return computeInt32Size;
        }

        public ByteString h() {
            Object obj = this.f3257f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3257f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3258g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3258g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0048a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0048a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3254c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3255d);
            }
            if ((this.f3254c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3254c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class t extends GeneratedMessageLite implements u {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<t> f3264a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final t f3265b;

        /* renamed from: c  reason: collision with root package name */
        public int f3266c;

        /* renamed from: d  reason: collision with root package name */
        public long f3267d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3268e;

        /* renamed from: f  reason: collision with root package name */
        public long f3269f;

        /* renamed from: g  reason: collision with root package name */
        public long f3270g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3271h;
        public long i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<t, C0049a> implements u {

            /* renamed from: a  reason: collision with root package name */
            public int f3272a;

            /* renamed from: b  reason: collision with root package name */
            public long f3273b;

            /* renamed from: d  reason: collision with root package name */
            public long f3275d;

            /* renamed from: e  reason: collision with root package name */
            public long f3276e;

            /* renamed from: g  reason: collision with root package name */
            public long f3278g;

            /* renamed from: h  reason: collision with root package name */
            public long f3279h;

            /* renamed from: c  reason: collision with root package name */
            public Object f3274c = "";

            /* renamed from: f  reason: collision with root package name */
            public Object f3277f = "";

            public C0049a() {
                g();
            }

            private void g() {
            }

            public static C0049a h() {
                return new C0049a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0049a clear() {
                super.clear();
                this.f3273b = 0L;
                int i = this.f3272a & (-2);
                this.f3272a = i;
                this.f3274c = "";
                int i2 = i & (-3);
                this.f3272a = i2;
                this.f3275d = 0L;
                int i3 = i2 & (-5);
                this.f3272a = i3;
                this.f3276e = 0L;
                int i4 = i3 & (-9);
                this.f3272a = i4;
                this.f3277f = "";
                int i5 = i4 & (-17);
                this.f3272a = i5;
                this.f3278g = 0L;
                int i6 = i5 & (-33);
                this.f3272a = i6;
                this.f3279h = 0L;
                this.f3272a = i6 & (-65);
                return this;
            }

            public C0049a a(long j) {
                this.f3272a |= 1;
                this.f3273b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0049a mergeFrom(t tVar) {
                if (tVar == t.a()) {
                    return this;
                }
                if (tVar.c()) {
                    a(tVar.d());
                }
                if (tVar.e()) {
                    this.f3272a |= 2;
                    this.f3274c = tVar.f3268e;
                }
                if (tVar.g()) {
                    b(tVar.h());
                }
                if (tVar.i()) {
                    c(tVar.j());
                }
                if (tVar.k()) {
                    this.f3272a |= 16;
                    this.f3277f = tVar.f3271h;
                }
                if (tVar.m()) {
                    d(tVar.n());
                }
                if (tVar.o()) {
                    e(tVar.p());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0049a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t tVar = null;
                try {
                    try {
                        t parsePartialFrom = t.f3264a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(tVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (tVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0049a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0049a b(long j) {
                this.f3272a |= 4;
                this.f3275d = j;
                return this;
            }

            public C0049a c(long j) {
                this.f3272a |= 8;
                this.f3276e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0049a d(long j) {
                this.f3272a |= 32;
                this.f3278g = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public t build() {
                t buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public C0049a e(long j) {
                this.f3272a |= 64;
                this.f3279h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i = this.f3272a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                tVar.f3267d = this.f3273b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                tVar.f3268e = this.f3274c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                tVar.f3269f = this.f3275d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                tVar.f3270g = this.f3276e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                tVar.f3271h = this.f3277f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                tVar.i = this.f3278g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                tVar.j = this.f3279h;
                tVar.f3266c = i2;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            t tVar = new t();
            f3265b = tVar;
            tVar.t();
        }

        public t() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.f3266c |= 1;
                                this.f3267d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3266c |= 2;
                                this.f3268e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3266c |= 4;
                                this.f3269f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3266c |= 8;
                                this.f3270g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3266c |= 16;
                                this.f3271h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f3266c |= 32;
                                this.i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3266c |= 64;
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

        public t(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0049a a(t tVar) {
            return q().mergeFrom(tVar);
        }

        public static t a() {
            return f3265b;
        }

        public static C0049a q() {
            return C0049a.h();
        }

        private void t() {
            this.f3267d = 0L;
            this.f3268e = "";
            this.f3269f = 0L;
            this.f3270g = 0L;
            this.f3271h = "";
            this.i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f3265b;
        }

        public boolean c() {
            return (this.f3266c & 1) == 1;
        }

        public long d() {
            return this.f3267d;
        }

        public boolean e() {
            return (this.f3266c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3268e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3268e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3266c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            return f3264a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.f3266c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3267d) : 0;
            if ((this.f3266c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3266c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3269f);
            }
            if ((this.f3266c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3270g);
            }
            if ((this.f3266c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3266c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.i);
            }
            if ((this.f3266c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public long h() {
            return this.f3269f;
        }

        public boolean i() {
            return (this.f3266c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3270g;
        }

        public boolean k() {
            return (this.f3266c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3271h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3271h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3266c & 32) == 32;
        }

        public long n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3266c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0049a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0049a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3266c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3267d);
            }
            if ((this.f3266c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3266c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3269f);
            }
            if ((this.f3266c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3270g);
            }
            if ((this.f3266c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3266c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.i);
            }
            if ((this.f3266c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class v extends GeneratedMessageLite implements w {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<v> f3280a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final v f3281b;

        /* renamed from: c  reason: collision with root package name */
        public int f3282c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3283d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3284e;

        /* renamed from: f  reason: collision with root package name */
        public byte f3285f;

        /* renamed from: g  reason: collision with root package name */
        public int f3286g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<v, C0050a> implements w {

            /* renamed from: a  reason: collision with root package name */
            public int f3287a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3288b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3289c = "";

            public C0050a() {
                g();
            }

            private void g() {
            }

            public static C0050a h() {
                return new C0050a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0050a clear() {
                super.clear();
                this.f3288b = "";
                int i = this.f3287a & (-2);
                this.f3287a = i;
                this.f3289c = "";
                this.f3287a = i & (-3);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0050a mergeFrom(v vVar) {
                if (vVar == v.a()) {
                    return this;
                }
                if (vVar.c()) {
                    this.f3287a |= 1;
                    this.f3288b = vVar.f3283d;
                }
                if (vVar.e()) {
                    this.f3287a |= 2;
                    this.f3289c = vVar.f3284e;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0050a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                v vVar = null;
                try {
                    try {
                        v parsePartialFrom = v.f3280a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(vVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (vVar != null) {
                    }
                    throw th;
                }
            }

            public C0050a a(String str) {
                if (str != null) {
                    this.f3287a |= 1;
                    this.f3288b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0050a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0050a b(String str) {
                if (str != null) {
                    this.f3287a |= 2;
                    this.f3289c = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public v getDefaultInstanceForType() {
                return v.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public v build() {
                v buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public v buildPartial() {
                v vVar = new v(this);
                int i = this.f3287a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                vVar.f3283d = this.f3288b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                vVar.f3284e = this.f3289c;
                vVar.f3282c = i2;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            v vVar = new v();
            f3281b = vVar;
            vVar.j();
        }

        public v() {
            this.f3285f = (byte) -1;
            this.f3286g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3285f = (byte) -1;
            this.f3286g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3282c |= 1;
                                this.f3283d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3282c |= 2;
                                this.f3284e = codedInputStream.readBytes();
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

        public v(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3285f = (byte) -1;
            this.f3286g = -1;
        }

        public static C0050a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f3281b;
        }

        public static C0050a g() {
            return C0050a.h();
        }

        private void j() {
            this.f3283d = "";
            this.f3284e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f3281b;
        }

        public boolean c() {
            return (this.f3282c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3283d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3283d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3282c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3284e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3284e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f3280a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3286g;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3282c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3282c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            this.f3286g = computeBytesSize;
            return computeBytesSize;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C0050a newBuilderForType() {
            return g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C0050a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3285f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3285f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3282c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3282c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public enum x implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0),
        IOS(1),
        ANDROID(2),
        WINDOWSPHONE(3);
        

        /* renamed from: e  reason: collision with root package name */
        public final int f3295e;

        x(int i) {
            this.f3295e = i;
        }

        public static x a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return WINDOWSPHONE;
                    }
                    return ANDROID;
                }
                return IOS;
            }
            return OS_TYPE_UNKNWON;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.f3295e;
        }
    }

    /* loaded from: classes2.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f3296a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final y f3297b;

        /* renamed from: c  reason: collision with root package name */
        public int f3298c;

        /* renamed from: d  reason: collision with root package name */
        public r f3299d;

        /* renamed from: e  reason: collision with root package name */
        public h f3300e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3301f;

        /* renamed from: g  reason: collision with root package name */
        public long f3302g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f3303h;
        public byte i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0051a extends GeneratedMessageLite.Builder<y, C0051a> implements z {

            /* renamed from: a  reason: collision with root package name */
            public int f3304a;

            /* renamed from: e  reason: collision with root package name */
            public long f3308e;

            /* renamed from: b  reason: collision with root package name */
            public r f3305b = r.a();

            /* renamed from: c  reason: collision with root package name */
            public h f3306c = h.a();

            /* renamed from: d  reason: collision with root package name */
            public Object f3307d = "";

            /* renamed from: f  reason: collision with root package name */
            public List<c> f3309f = Collections.emptyList();

            public C0051a() {
                i();
            }

            private void i() {
            }

            public static C0051a j() {
                return new C0051a();
            }

            private void k() {
                if ((this.f3304a & 16) != 16) {
                    this.f3309f = new ArrayList(this.f3309f);
                    this.f3304a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0051a clear() {
                super.clear();
                this.f3305b = r.a();
                this.f3304a &= -2;
                this.f3306c = h.a();
                int i = this.f3304a & (-3);
                this.f3304a = i;
                this.f3307d = "";
                int i2 = i & (-5);
                this.f3304a = i2;
                this.f3308e = 0L;
                this.f3304a = i2 & (-9);
                this.f3309f = Collections.emptyList();
                this.f3304a &= -17;
                return this;
            }

            public C0051a a(long j) {
                this.f3304a |= 8;
                this.f3308e = j;
                return this;
            }

            public C0051a a(h hVar) {
                if (hVar != null) {
                    this.f3306c = hVar;
                    this.f3304a |= 2;
                    return this;
                }
                throw null;
            }

            public C0051a a(r rVar) {
                if ((this.f3304a & 1) == 1 && this.f3305b != r.a()) {
                    rVar = r.a(this.f3305b).mergeFrom(rVar).buildPartial();
                }
                this.f3305b = rVar;
                this.f3304a |= 1;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0051a mergeFrom(y yVar) {
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
                    this.f3304a |= 4;
                    this.f3307d = yVar.f3301f;
                }
                if (yVar.i()) {
                    a(yVar.j());
                }
                if (!yVar.f3303h.isEmpty()) {
                    if (this.f3309f.isEmpty()) {
                        this.f3309f = yVar.f3303h;
                        this.f3304a &= -17;
                    } else {
                        k();
                        this.f3309f.addAll(yVar.f3303h);
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0051a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                y yVar = null;
                try {
                    try {
                        y parsePartialFrom = y.f3296a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                                mergeFrom(yVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (yVar != null) {
                    }
                    throw th;
                }
            }

            public C0051a a(Iterable<? extends c> iterable) {
                k();
                AbstractMessageLite.Builder.addAll(iterable, this.f3309f);
                return this;
            }

            public C0051a a(String str) {
                if (str != null) {
                    this.f3304a |= 4;
                    this.f3307d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0051a clone() {
                return j().mergeFrom(buildPartial());
            }

            public C0051a b(h hVar) {
                if ((this.f3304a & 2) == 2 && this.f3306c != h.a()) {
                    hVar = h.a(this.f3306c).mergeFrom(hVar).buildPartial();
                }
                this.f3306c = hVar;
                this.f3304a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public y getDefaultInstanceForType() {
                return y.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public y build() {
                y buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public y buildPartial() {
                y yVar = new y(this);
                int i = this.f3304a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                yVar.f3299d = this.f3305b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                yVar.f3300e = this.f3306c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                yVar.f3301f = this.f3307d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                yVar.f3302g = this.f3308e;
                if ((this.f3304a & 16) == 16) {
                    this.f3309f = Collections.unmodifiableList(this.f3309f);
                    this.f3304a &= -17;
                }
                yVar.f3303h = this.f3309f;
                yVar.f3298c = i2;
                return yVar;
            }

            public boolean f() {
                return (this.f3304a & 2) == 2;
            }

            public h g() {
                return this.f3306c;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (f()) {
                    return g().isInitialized();
                }
                return false;
            }
        }

        static {
            y yVar = new y();
            f3297b = yVar;
            yVar.n();
        }

        public y() {
            this.i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i;
            this.i = (byte) -1;
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
                        int readTag = codedInputStream.readTag();
                        int i2 = 1;
                        if (readTag != 0) {
                            if (readTag == 202) {
                                r.C0048a builder = (this.f3298c & 1) == 1 ? this.f3299d.toBuilder() : null;
                                r rVar = (r) codedInputStream.readMessage(r.f3252a, extensionRegistryLite);
                                this.f3299d = rVar;
                                if (builder != null) {
                                    builder.mergeFrom(rVar);
                                    this.f3299d = builder.buildPartial();
                                }
                                i = this.f3298c;
                            } else if (readTag == 330) {
                                i2 = 2;
                                h.C0043a builder2 = (this.f3298c & 2) == 2 ? this.f3300e.toBuilder() : null;
                                h hVar = (h) codedInputStream.readMessage(h.f3183a, extensionRegistryLite);
                                this.f3300e = hVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hVar);
                                    this.f3300e = builder2.buildPartial();
                                }
                                i = this.f3298c;
                            } else if (readTag == 1042) {
                                this.f3298c |= 4;
                                this.f3301f = codedInputStream.readBytes();
                            } else if (readTag == 1048) {
                                this.f3298c |= 8;
                                this.f3302g = codedInputStream.readInt64();
                            } else if (readTag == 1058) {
                                if (!(z2 & true)) {
                                    this.f3303h = new ArrayList();
                                    z2 |= true;
                                }
                                this.f3303h.add(codedInputStream.readMessage(c.f3147a, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                            this.f3298c = i | i2;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f3303h = Collections.unmodifiableList(this.f3303h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.i = (byte) -1;
            this.j = -1;
        }

        public static C0051a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f3297b;
        }

        public static C0051a k() {
            return C0051a.j();
        }

        private void n() {
            this.f3299d = r.a();
            this.f3300e = h.a();
            this.f3301f = "";
            this.f3302g = 0L;
            this.f3303h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f3297b;
        }

        public boolean c() {
            return (this.f3298c & 1) == 1;
        }

        public r d() {
            return this.f3299d;
        }

        public boolean e() {
            return (this.f3298c & 2) == 2;
        }

        public h f() {
            return this.f3300e;
        }

        public boolean g() {
            return (this.f3298c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f3296a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.j;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.f3298c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f3299d) + 0 : 0;
            if ((this.f3298c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f3300e);
            }
            if ((this.f3298c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3298c & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3302g);
            }
            for (int i2 = 0; i2 < this.f3303h.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f3303h.get(i2));
            }
            this.j = computeMessageSize;
            return computeMessageSize;
        }

        public ByteString h() {
            Object obj = this.f3301f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3301f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3298c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!e()) {
                this.i = (byte) 0;
                return false;
            } else if (f().isInitialized()) {
                this.i = (byte) 1;
                return true;
            } else {
                this.i = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.f3302g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0051a newBuilderForType() {
            return k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0051a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3298c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.f3299d);
            }
            if ((this.f3298c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f3300e);
            }
            if ((this.f3298c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3298c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3302g);
            }
            for (int i = 0; i < this.f3303h.size(); i++) {
                codedOutputStream.writeMessage(132, this.f3303h.get(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
