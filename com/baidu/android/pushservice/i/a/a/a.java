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
/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0036a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0036a> f3144a = new AbstractParser<C0036a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0036a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0036a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0036a f3145b;

        /* renamed from: c  reason: collision with root package name */
        public int f3146c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3147d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3148e;

        /* renamed from: f  reason: collision with root package name */
        public long f3149f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3150g;

        /* renamed from: h  reason: collision with root package name */
        public long f3151h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3152i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0037a extends GeneratedMessageLite.Builder<C0036a, C0037a> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3153a;

            /* renamed from: d  reason: collision with root package name */
            public long f3156d;

            /* renamed from: f  reason: collision with root package name */
            public long f3158f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3154b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3155c = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3157e = "";

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
                this.f3154b = "";
                int i2 = this.f3153a & (-2);
                this.f3153a = i2;
                this.f3155c = "";
                int i3 = i2 & (-3);
                this.f3153a = i3;
                this.f3156d = 0L;
                int i4 = i3 & (-5);
                this.f3153a = i4;
                this.f3157e = "";
                int i5 = i4 & (-9);
                this.f3153a = i5;
                this.f3158f = 0L;
                this.f3153a = i5 & (-17);
                return this;
            }

            public C0037a a(long j) {
                this.f3153a |= 4;
                this.f3156d = j;
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
                    this.f3153a |= 1;
                    this.f3154b = c0036a.f3147d;
                }
                if (c0036a.e()) {
                    this.f3153a |= 2;
                    this.f3155c = c0036a.f3148e;
                }
                if (c0036a.g()) {
                    a(c0036a.h());
                }
                if (c0036a.i()) {
                    this.f3153a |= 8;
                    this.f3157e = c0036a.f3150g;
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
                        C0036a parsePartialFrom = C0036a.f3144a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3153a |= 1;
                    this.f3154b = str;
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
                this.f3153a |= 16;
                this.f3158f = j;
                return this;
            }

            public C0037a b(String str) {
                if (str != null) {
                    this.f3153a |= 2;
                    return this;
                }
                throw null;
            }

            public C0037a c(String str) {
                if (str != null) {
                    this.f3153a |= 8;
                    this.f3157e = str;
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
                int i2 = this.f3153a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0036a.f3147d = this.f3154b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0036a.f3148e = this.f3155c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0036a.f3149f = this.f3156d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0036a.f3150g = this.f3157e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0036a.f3151h = this.f3158f;
                c0036a.f3146c = i3;
                return c0036a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0036a c0036a = new C0036a();
            f3145b = c0036a;
            c0036a.p();
        }

        public C0036a() {
            this.f3152i = (byte) -1;
            this.j = -1;
        }

        public C0036a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3152i = (byte) -1;
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
                                    this.f3146c |= 1;
                                    this.f3147d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3146c |= 2;
                                    this.f3148e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3146c |= 4;
                                    this.f3149f = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.f3146c |= 8;
                                    this.f3150g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3146c |= 16;
                                    this.f3151h = codedInputStream.readInt64();
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
            this.f3152i = (byte) -1;
            this.j = -1;
        }

        public static C0037a a(C0036a c0036a) {
            return m().mergeFrom(c0036a);
        }

        public static C0036a a() {
            return f3145b;
        }

        public static C0037a m() {
            return C0037a.h();
        }

        private void p() {
            this.f3147d = "";
            this.f3148e = "";
            this.f3149f = 0L;
            this.f3150g = "";
            this.f3151h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0036a getDefaultInstanceForType() {
            return f3145b;
        }

        public boolean c() {
            return (this.f3146c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3147d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3147d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3146c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3148e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3148e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3146c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0036a> getParserForType() {
            return f3144a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3146c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3146c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3146c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3149f);
            }
            if ((this.f3146c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3146c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3151h);
            }
            this.j = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3149f;
        }

        public boolean i() {
            return (this.f3146c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3152i;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3152i = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3150g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3150g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3146c & 16) == 16;
        }

        public long l() {
            return this.f3151h;
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
            if ((this.f3146c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3146c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3146c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3149f);
            }
            if ((this.f3146c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3146c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3151h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f3159a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final aa f3160b;

        /* renamed from: c  reason: collision with root package name */
        public int f3161c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3162d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3163e;

        /* renamed from: f  reason: collision with root package name */
        public long f3164f;

        /* renamed from: g  reason: collision with root package name */
        public long f3165g;

        /* renamed from: h  reason: collision with root package name */
        public long f3166h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3167i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0038a extends GeneratedMessageLite.Builder<aa, C0038a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            public int f3168a;

            /* renamed from: d  reason: collision with root package name */
            public long f3171d;

            /* renamed from: e  reason: collision with root package name */
            public long f3172e;

            /* renamed from: f  reason: collision with root package name */
            public long f3173f;

            /* renamed from: h  reason: collision with root package name */
            public long f3175h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3169b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3170c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3174g = "";

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
                this.f3169b = "";
                int i2 = this.f3168a & (-2);
                this.f3168a = i2;
                this.f3170c = "";
                int i3 = i2 & (-3);
                this.f3168a = i3;
                this.f3171d = 0L;
                int i4 = i3 & (-5);
                this.f3168a = i4;
                this.f3172e = 0L;
                int i5 = i4 & (-9);
                this.f3168a = i5;
                this.f3173f = 0L;
                int i6 = i5 & (-17);
                this.f3168a = i6;
                this.f3174g = "";
                int i7 = i6 & (-33);
                this.f3168a = i7;
                this.f3175h = 0L;
                this.f3168a = i7 & (-65);
                return this;
            }

            public C0038a a(long j) {
                this.f3168a |= 4;
                this.f3171d = j;
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
                    this.f3168a |= 1;
                    this.f3169b = aaVar.f3162d;
                }
                if (aaVar.e()) {
                    this.f3168a |= 2;
                    this.f3170c = aaVar.f3163e;
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
                    this.f3168a |= 32;
                    this.f3174g = aaVar.f3167i;
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
                        aa parsePartialFrom = aa.f3159a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3168a |= 1;
                    this.f3169b = str;
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
                this.f3168a |= 8;
                this.f3172e = j;
                return this;
            }

            public C0038a b(String str) {
                if (str != null) {
                    this.f3168a |= 2;
                    this.f3170c = str;
                    return this;
                }
                throw null;
            }

            public C0038a c(long j) {
                this.f3168a |= 16;
                this.f3173f = j;
                return this;
            }

            public C0038a c(String str) {
                if (str != null) {
                    this.f3168a |= 32;
                    this.f3174g = str;
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
                this.f3168a |= 64;
                this.f3175h = j;
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
                int i2 = this.f3168a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aaVar.f3162d = this.f3169b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aaVar.f3163e = this.f3170c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aaVar.f3164f = this.f3171d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aaVar.f3165g = this.f3172e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aaVar.f3166h = this.f3173f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aaVar.f3167i = this.f3174g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aaVar.j = this.f3175h;
                aaVar.f3161c = i3;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            aa aaVar = new aa();
            f3160b = aaVar;
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
                                this.f3161c |= 1;
                                this.f3162d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3161c |= 2;
                                this.f3163e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3161c |= 4;
                                this.f3164f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3161c |= 8;
                                this.f3165g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3161c |= 16;
                                this.f3166h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3161c |= 32;
                                this.f3167i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3161c |= 64;
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
            return f3160b;
        }

        public static C0038a q() {
            return C0038a.h();
        }

        private void t() {
            this.f3162d = "";
            this.f3163e = "";
            this.f3164f = 0L;
            this.f3165g = 0L;
            this.f3166h = 0L;
            this.f3167i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f3160b;
        }

        public boolean c() {
            return (this.f3161c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3162d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3162d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3161c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3163e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3163e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3161c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            return f3159a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3161c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3161c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3161c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3164f);
            }
            if ((this.f3161c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3165g);
            }
            if ((this.f3161c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3166h);
            }
            if ((this.f3161c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3161c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3164f;
        }

        public boolean i() {
            return (this.f3161c & 8) == 8;
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
            return this.f3165g;
        }

        public boolean k() {
            return (this.f3161c & 16) == 16;
        }

        public long l() {
            return this.f3166h;
        }

        public boolean m() {
            return (this.f3161c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3167i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3167i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3161c & 64) == 64;
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
            if ((this.f3161c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3161c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3161c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3164f);
            }
            if ((this.f3161c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3165g);
            }
            if ((this.f3161c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3166h);
            }
            if ((this.f3161c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3161c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class ac extends GeneratedMessageLite implements ad {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ac> f3176a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ac f3177b;

        /* renamed from: c  reason: collision with root package name */
        public int f3178c;

        /* renamed from: d  reason: collision with root package name */
        public x f3179d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3180e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3181f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3182g;

        /* renamed from: h  reason: collision with root package name */
        public int f3183h;

        /* renamed from: i  reason: collision with root package name */
        public int f3184i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039a extends GeneratedMessageLite.Builder<ac, C0039a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            public int f3185a;

            /* renamed from: b  reason: collision with root package name */
            public x f3186b = x.OS_TYPE_UNKNWON;

            /* renamed from: c  reason: collision with root package name */
            public Object f3187c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3188d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3189e = "";

            /* renamed from: f  reason: collision with root package name */
            public int f3190f;

            /* renamed from: g  reason: collision with root package name */
            public int f3191g;

            /* renamed from: h  reason: collision with root package name */
            public int f3192h;

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
                this.f3186b = x.OS_TYPE_UNKNWON;
                int i2 = this.f3185a & (-2);
                this.f3185a = i2;
                this.f3187c = "";
                int i3 = i2 & (-3);
                this.f3185a = i3;
                this.f3188d = "";
                int i4 = i3 & (-5);
                this.f3185a = i4;
                this.f3189e = "";
                int i5 = i4 & (-9);
                this.f3185a = i5;
                this.f3190f = 0;
                int i6 = i5 & (-17);
                this.f3185a = i6;
                this.f3191g = 0;
                int i7 = i6 & (-33);
                this.f3185a = i7;
                this.f3192h = 0;
                this.f3185a = i7 & (-65);
                return this;
            }

            public C0039a a(int i2) {
                this.f3185a |= 16;
                this.f3190f = i2;
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
                    this.f3185a |= 2;
                    this.f3187c = acVar.f3180e;
                }
                if (acVar.g()) {
                    this.f3185a |= 4;
                    this.f3188d = acVar.f3181f;
                }
                if (acVar.i()) {
                    this.f3185a |= 8;
                    this.f3189e = acVar.f3182g;
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
                    this.f3185a |= 1;
                    this.f3186b = xVar;
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
                        ac parsePartialFrom = ac.f3176a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3185a |= 2;
                    this.f3187c = str;
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

            public C0039a b(int i2) {
                this.f3185a |= 32;
                this.f3191g = i2;
                return this;
            }

            public C0039a b(String str) {
                if (str != null) {
                    this.f3185a |= 4;
                    this.f3188d = str;
                    return this;
                }
                throw null;
            }

            public C0039a c(int i2) {
                this.f3185a |= 64;
                this.f3192h = i2;
                return this;
            }

            public C0039a c(String str) {
                if (str != null) {
                    this.f3185a |= 8;
                    this.f3189e = str;
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
                int i2 = this.f3185a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                acVar.f3179d = this.f3186b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                acVar.f3180e = this.f3187c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                acVar.f3181f = this.f3188d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                acVar.f3182g = this.f3189e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                acVar.f3183h = this.f3190f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                acVar.f3184i = this.f3191g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                acVar.j = this.f3192h;
                acVar.f3178c = i3;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ac acVar = new ac();
            f3177b = acVar;
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
                                        this.f3178c = 1 | this.f3178c;
                                        this.f3179d = a2;
                                    }
                                } else if (readTag == 18) {
                                    this.f3178c |= 2;
                                    this.f3180e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3178c |= 4;
                                    this.f3181f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f3178c |= 8;
                                    this.f3182g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3178c |= 16;
                                    this.f3183h = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.f3178c |= 32;
                                    this.f3184i = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.f3178c |= 64;
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
            return f3177b;
        }

        public static C0039a q() {
            return C0039a.h();
        }

        private void t() {
            this.f3179d = x.OS_TYPE_UNKNWON;
            this.f3180e = "";
            this.f3181f = "";
            this.f3182g = "";
            this.f3183h = 0;
            this.f3184i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f3177b;
        }

        public boolean c() {
            return (this.f3178c & 1) == 1;
        }

        public x d() {
            return this.f3179d;
        }

        public boolean e() {
            return (this.f3178c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3180e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3180e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3178c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            return f3176a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3178c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3179d.getNumber()) : 0;
            if ((this.f3178c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3178c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3178c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3178c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f3183h);
            }
            if ((this.f3178c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f3184i);
            }
            if ((this.f3178c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
            }
            this.l = computeEnumSize;
            return computeEnumSize;
        }

        public ByteString h() {
            Object obj = this.f3181f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3181f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3178c & 8) == 8;
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
            Object obj = this.f3182g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3182g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3178c & 16) == 16;
        }

        public int l() {
            return this.f3183h;
        }

        public boolean m() {
            return (this.f3178c & 32) == 32;
        }

        public int n() {
            return this.f3184i;
        }

        public boolean o() {
            return (this.f3178c & 64) == 64;
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
            if ((this.f3178c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3179d.getNumber());
            }
            if ((this.f3178c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3178c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3178c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3178c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.f3183h);
            }
            if ((this.f3178c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.f3184i);
            }
            if ((this.f3178c & 64) == 64) {
                codedOutputStream.writeInt32(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class ae extends GeneratedMessageLite implements af {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ae> f3193a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ae f3194b;

        /* renamed from: c  reason: collision with root package name */
        public int f3195c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3196d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3197e;

        /* renamed from: f  reason: collision with root package name */
        public long f3198f;

        /* renamed from: g  reason: collision with root package name */
        public long f3199g;

        /* renamed from: h  reason: collision with root package name */
        public long f3200h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3201i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0040a extends GeneratedMessageLite.Builder<ae, C0040a> implements af {

            /* renamed from: a  reason: collision with root package name */
            public int f3202a;

            /* renamed from: d  reason: collision with root package name */
            public long f3205d;

            /* renamed from: e  reason: collision with root package name */
            public long f3206e;

            /* renamed from: f  reason: collision with root package name */
            public long f3207f;

            /* renamed from: h  reason: collision with root package name */
            public long f3209h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3203b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3204c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3208g = "";

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
                this.f3203b = "";
                int i2 = this.f3202a & (-2);
                this.f3202a = i2;
                this.f3204c = "";
                int i3 = i2 & (-3);
                this.f3202a = i3;
                this.f3205d = 0L;
                int i4 = i3 & (-5);
                this.f3202a = i4;
                this.f3206e = 0L;
                int i5 = i4 & (-9);
                this.f3202a = i5;
                this.f3207f = 0L;
                int i6 = i5 & (-17);
                this.f3202a = i6;
                this.f3208g = "";
                int i7 = i6 & (-33);
                this.f3202a = i7;
                this.f3209h = 0L;
                this.f3202a = i7 & (-65);
                return this;
            }

            public C0040a a(long j) {
                this.f3202a |= 4;
                this.f3205d = j;
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
                    this.f3202a |= 1;
                    this.f3203b = aeVar.f3196d;
                }
                if (aeVar.e()) {
                    this.f3202a |= 2;
                    this.f3204c = aeVar.f3197e;
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
                    this.f3202a |= 32;
                    this.f3208g = aeVar.f3201i;
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
                        ae parsePartialFrom = ae.f3193a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                this.f3202a |= 8;
                this.f3206e = j;
                return this;
            }

            public C0040a c(long j) {
                this.f3202a |= 16;
                this.f3207f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0040a d(long j) {
                this.f3202a |= 64;
                this.f3209h = j;
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
                int i2 = this.f3202a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aeVar.f3196d = this.f3203b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aeVar.f3197e = this.f3204c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aeVar.f3198f = this.f3205d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aeVar.f3199g = this.f3206e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aeVar.f3200h = this.f3207f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aeVar.f3201i = this.f3208g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aeVar.j = this.f3209h;
                aeVar.f3195c = i3;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ae aeVar = new ae();
            f3194b = aeVar;
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
                                this.f3195c |= 1;
                                this.f3196d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3195c |= 2;
                                this.f3197e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3195c |= 4;
                                this.f3198f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3195c |= 8;
                                this.f3199g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3195c |= 16;
                                this.f3200h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3195c |= 32;
                                this.f3201i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3195c |= 64;
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
            return f3194b;
        }

        public static C0040a q() {
            return C0040a.h();
        }

        private void t() {
            this.f3196d = "";
            this.f3197e = "";
            this.f3198f = 0L;
            this.f3199g = 0L;
            this.f3200h = 0L;
            this.f3201i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f3194b;
        }

        public boolean c() {
            return (this.f3195c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3196d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3196d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3195c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3197e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3197e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3195c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            return f3193a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3195c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3195c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3195c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3198f);
            }
            if ((this.f3195c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3199g);
            }
            if ((this.f3195c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3200h);
            }
            if ((this.f3195c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3195c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3198f;
        }

        public boolean i() {
            return (this.f3195c & 8) == 8;
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
            return this.f3199g;
        }

        public boolean k() {
            return (this.f3195c & 16) == 16;
        }

        public long l() {
            return this.f3200h;
        }

        public boolean m() {
            return (this.f3195c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3201i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3201i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3195c & 64) == 64;
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
            if ((this.f3195c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3195c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3195c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3198f);
            }
            if ((this.f3195c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3199g);
            }
            if ((this.f3195c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3200h);
            }
            if ((this.f3195c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3195c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3210a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3211b;

        /* renamed from: c  reason: collision with root package name */
        public int f3212c;

        /* renamed from: d  reason: collision with root package name */
        public e f3213d;

        /* renamed from: e  reason: collision with root package name */
        public ae f3214e;

        /* renamed from: f  reason: collision with root package name */
        public l f3215f;

        /* renamed from: g  reason: collision with root package name */
        public n f3216g;

        /* renamed from: h  reason: collision with root package name */
        public j f3217h;

        /* renamed from: i  reason: collision with root package name */
        public aa f3218i;
        public C0036a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041a extends GeneratedMessageLite.Builder<c, C0041a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3219a;

            /* renamed from: b  reason: collision with root package name */
            public e f3220b = e.UI;

            /* renamed from: c  reason: collision with root package name */
            public ae f3221c = ae.a();

            /* renamed from: d  reason: collision with root package name */
            public l f3222d = l.a();

            /* renamed from: e  reason: collision with root package name */
            public n f3223e = n.a();

            /* renamed from: f  reason: collision with root package name */
            public j f3224f = j.a();

            /* renamed from: g  reason: collision with root package name */
            public aa f3225g = aa.a();

            /* renamed from: h  reason: collision with root package name */
            public C0036a f3226h = C0036a.a();

            /* renamed from: i  reason: collision with root package name */
            public t f3227i = t.a();

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
                this.f3220b = e.UI;
                this.f3219a &= -2;
                this.f3221c = ae.a();
                this.f3219a &= -3;
                this.f3222d = l.a();
                this.f3219a &= -5;
                this.f3223e = n.a();
                this.f3219a &= -9;
                this.f3224f = j.a();
                this.f3219a &= -17;
                this.f3225g = aa.a();
                this.f3219a &= -33;
                this.f3226h = C0036a.a();
                this.f3219a &= -65;
                this.f3227i = t.a();
                this.f3219a &= -129;
                return this;
            }

            public C0041a a(C0036a c0036a) {
                if (c0036a != null) {
                    this.f3226h = c0036a;
                    this.f3219a |= 64;
                    return this;
                }
                throw null;
            }

            public C0041a a(aa aaVar) {
                if (aaVar != null) {
                    this.f3225g = aaVar;
                    this.f3219a |= 32;
                    return this;
                }
                throw null;
            }

            public C0041a a(ae aeVar) {
                if ((this.f3219a & 2) == 2 && this.f3221c != ae.a()) {
                    aeVar = ae.a(this.f3221c).mergeFrom(aeVar).buildPartial();
                }
                this.f3221c = aeVar;
                this.f3219a |= 2;
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
                    this.f3219a |= 1;
                    this.f3220b = eVar;
                    return this;
                }
                throw null;
            }

            public C0041a a(j jVar) {
                if (jVar != null) {
                    this.f3224f = jVar;
                    this.f3219a |= 16;
                    return this;
                }
                throw null;
            }

            public C0041a a(l lVar) {
                if (lVar != null) {
                    this.f3222d = lVar;
                    this.f3219a |= 4;
                    return this;
                }
                throw null;
            }

            public C0041a a(n nVar) {
                if (nVar != null) {
                    this.f3223e = nVar;
                    this.f3219a |= 8;
                    return this;
                }
                throw null;
            }

            public C0041a a(t tVar) {
                if ((this.f3219a & 128) == 128 && this.f3227i != t.a()) {
                    tVar = t.a(this.f3227i).mergeFrom(tVar).buildPartial();
                }
                this.f3227i = tVar;
                this.f3219a |= 128;
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
                        c parsePartialFrom = c.f3210a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                if ((this.f3219a & 64) == 64 && this.f3226h != C0036a.a()) {
                    c0036a = C0036a.a(this.f3226h).mergeFrom(c0036a).buildPartial();
                }
                this.f3226h = c0036a;
                this.f3219a |= 64;
                return this;
            }

            public C0041a b(aa aaVar) {
                if ((this.f3219a & 32) == 32 && this.f3225g != aa.a()) {
                    aaVar = aa.a(this.f3225g).mergeFrom(aaVar).buildPartial();
                }
                this.f3225g = aaVar;
                this.f3219a |= 32;
                return this;
            }

            public C0041a b(j jVar) {
                if ((this.f3219a & 16) == 16 && this.f3224f != j.a()) {
                    jVar = j.a(this.f3224f).mergeFrom(jVar).buildPartial();
                }
                this.f3224f = jVar;
                this.f3219a |= 16;
                return this;
            }

            public C0041a b(l lVar) {
                if ((this.f3219a & 4) == 4 && this.f3222d != l.a()) {
                    lVar = l.a(this.f3222d).mergeFrom(lVar).buildPartial();
                }
                this.f3222d = lVar;
                this.f3219a |= 4;
                return this;
            }

            public C0041a b(n nVar) {
                if ((this.f3219a & 8) == 8 && this.f3223e != n.a()) {
                    nVar = n.a(this.f3223e).mergeFrom(nVar).buildPartial();
                }
                this.f3223e = nVar;
                this.f3219a |= 8;
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
                int i2 = this.f3219a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3213d = this.f3220b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3214e = this.f3221c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3215f = this.f3222d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                cVar.f3216g = this.f3223e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                cVar.f3217h = this.f3224f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                cVar.f3218i = this.f3225g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                cVar.j = this.f3226h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                cVar.k = this.f3227i;
                cVar.f3212c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3211b = cVar;
            cVar.v();
        }

        public c() {
            this.l = (byte) -1;
            this.m = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            int i3;
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
                                    i2 = 2;
                                    ae.C0040a builder = (this.f3212c & 2) == 2 ? this.f3214e.toBuilder() : null;
                                    ae aeVar = (ae) codedInputStream.readMessage(ae.f3193a, extensionRegistryLite);
                                    this.f3214e = aeVar;
                                    if (builder != null) {
                                        builder.mergeFrom(aeVar);
                                        this.f3214e = builder.buildPartial();
                                    }
                                    i3 = this.f3212c;
                                } else if (readTag == 26) {
                                    i2 = 4;
                                    l.C0045a builder2 = (this.f3212c & 4) == 4 ? this.f3215f.toBuilder() : null;
                                    l lVar = (l) codedInputStream.readMessage(l.f3284a, extensionRegistryLite);
                                    this.f3215f = lVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar);
                                        this.f3215f = builder2.buildPartial();
                                    }
                                    i3 = this.f3212c;
                                } else if (readTag == 34) {
                                    n.C0046a builder3 = (this.f3212c & 8) == 8 ? this.f3216g.toBuilder() : null;
                                    n nVar = (n) codedInputStream.readMessage(n.f3298a, extensionRegistryLite);
                                    this.f3216g = nVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(nVar);
                                        this.f3216g = builder3.buildPartial();
                                    }
                                    this.f3212c |= 8;
                                } else if (readTag == 42) {
                                    i2 = 16;
                                    j.C0044a builder4 = (this.f3212c & 16) == 16 ? this.f3217h.toBuilder() : null;
                                    j jVar = (j) codedInputStream.readMessage(j.f3267a, extensionRegistryLite);
                                    this.f3217h = jVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(jVar);
                                        this.f3217h = builder4.buildPartial();
                                    }
                                    i3 = this.f3212c;
                                } else if (readTag == 50) {
                                    i2 = 32;
                                    aa.C0038a builder5 = (this.f3212c & 32) == 32 ? this.f3218i.toBuilder() : null;
                                    aa aaVar = (aa) codedInputStream.readMessage(aa.f3159a, extensionRegistryLite);
                                    this.f3218i = aaVar;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(aaVar);
                                        this.f3218i = builder5.buildPartial();
                                    }
                                    i3 = this.f3212c;
                                } else if (readTag == 58) {
                                    i2 = 64;
                                    C0036a.C0037a builder6 = (this.f3212c & 64) == 64 ? this.j.toBuilder() : null;
                                    C0036a c0036a = (C0036a) codedInputStream.readMessage(C0036a.f3144a, extensionRegistryLite);
                                    this.j = c0036a;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(c0036a);
                                        this.j = builder6.buildPartial();
                                    }
                                    i3 = this.f3212c;
                                } else if (readTag == 66) {
                                    i2 = 128;
                                    t.C0049a builder7 = (this.f3212c & 128) == 128 ? this.k.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.f3336a, extensionRegistryLite);
                                    this.k = tVar;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(tVar);
                                        this.k = builder7.buildPartial();
                                    }
                                    i3 = this.f3212c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3212c = i3 | i2;
                            } else {
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f3212c = 1 | this.f3212c;
                                    this.f3213d = a2;
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
            return f3211b;
        }

        public static C0041a s() {
            return C0041a.h();
        }

        private void v() {
            this.f3213d = e.UI;
            this.f3214e = ae.a();
            this.f3215f = l.a();
            this.f3216g = n.a();
            this.f3217h = j.a();
            this.f3218i = aa.a();
            this.j = C0036a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3211b;
        }

        public boolean c() {
            return (this.f3212c & 1) == 1;
        }

        public e d() {
            return this.f3213d;
        }

        public boolean e() {
            return (this.f3212c & 2) == 2;
        }

        public ae f() {
            return this.f3214e;
        }

        public boolean g() {
            return (this.f3212c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3210a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3212c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3213d.getNumber()) : 0;
            if ((this.f3212c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f3214e);
            }
            if ((this.f3212c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f3215f);
            }
            if ((this.f3212c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f3216g);
            }
            if ((this.f3212c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f3217h);
            }
            if ((this.f3212c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f3218i);
            }
            if ((this.f3212c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
            }
            if ((this.f3212c & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
            }
            this.m = computeEnumSize;
            return computeEnumSize;
        }

        public l h() {
            return this.f3215f;
        }

        public boolean i() {
            return (this.f3212c & 8) == 8;
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
            return this.f3216g;
        }

        public boolean k() {
            return (this.f3212c & 16) == 16;
        }

        public j l() {
            return this.f3217h;
        }

        public boolean m() {
            return (this.f3212c & 32) == 32;
        }

        public aa n() {
            return this.f3218i;
        }

        public boolean o() {
            return (this.f3212c & 64) == 64;
        }

        public C0036a p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3212c & 128) == 128;
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
            if ((this.f3212c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3213d.getNumber());
            }
            if ((this.f3212c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.f3214e);
            }
            if ((this.f3212c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3215f);
            }
            if ((this.f3212c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f3216g);
            }
            if ((this.f3212c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.f3217h);
            }
            if ((this.f3212c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.f3218i);
            }
            if ((this.f3212c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.f3212c & 128) == 128) {
                codedOutputStream.writeMessage(8, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public enum e implements Internal.EnumLite {
        UI(101),
        CRASH(201),
        DB(301),
        CONNECTION(401),
        REQUEST(501),
        ACK(601),
        MSG(701);
        

        /* renamed from: h  reason: collision with root package name */
        public final int f3236h;

        e(int i2) {
            this.f3236h = i2;
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
            return this.f3236h;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f3237a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final f f3238b;

        /* renamed from: c  reason: collision with root package name */
        public int f3239c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3240d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3241e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3242f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3243g;

        /* renamed from: h  reason: collision with root package name */
        public int f3244h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0042a extends GeneratedMessageLite.Builder<f, C0042a> implements g {

            /* renamed from: a  reason: collision with root package name */
            public int f3245a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3246b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3247c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3248d = "";

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
                this.f3246b = "";
                int i2 = this.f3245a & (-2);
                this.f3245a = i2;
                this.f3247c = "";
                int i3 = i2 & (-3);
                this.f3245a = i3;
                this.f3248d = "";
                this.f3245a = i3 & (-5);
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
                    this.f3245a |= 1;
                    this.f3246b = fVar.f3240d;
                }
                if (fVar.e()) {
                    this.f3245a |= 2;
                    this.f3247c = fVar.f3241e;
                }
                if (fVar.g()) {
                    this.f3245a |= 4;
                    this.f3248d = fVar.f3242f;
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
                        f parsePartialFrom = f.f3237a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3245a |= 1;
                    this.f3246b = str;
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
                    this.f3245a |= 2;
                    this.f3247c = str;
                    return this;
                }
                throw null;
            }

            public C0042a c(String str) {
                if (str != null) {
                    this.f3245a |= 4;
                    this.f3248d = str;
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
                int i2 = this.f3245a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                fVar.f3240d = this.f3246b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                fVar.f3241e = this.f3247c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                fVar.f3242f = this.f3248d;
                fVar.f3239c = i3;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f fVar = new f();
            f3238b = fVar;
            fVar.l();
        }

        public f() {
            this.f3243g = (byte) -1;
            this.f3244h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3243g = (byte) -1;
            this.f3244h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3239c |= 1;
                                    this.f3240d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3239c |= 2;
                                    this.f3241e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3239c |= 4;
                                    this.f3242f = codedInputStream.readBytes();
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
            this.f3243g = (byte) -1;
            this.f3244h = -1;
        }

        public static C0042a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f3238b;
        }

        public static C0042a i() {
            return C0042a.h();
        }

        private void l() {
            this.f3240d = "";
            this.f3241e = "";
            this.f3242f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f3238b;
        }

        public boolean c() {
            return (this.f3239c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3240d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3240d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3239c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3241e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3241e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3239c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            return f3237a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3244h;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3239c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3239c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3239c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3244h = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3242f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3242f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3243g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3243g = (byte) 1;
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
            if ((this.f3239c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3239c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3239c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class h extends GeneratedMessageLite implements i {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<h> f3249a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final h f3250b;

        /* renamed from: c  reason: collision with root package name */
        public int f3251c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3252d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3253e;

        /* renamed from: f  reason: collision with root package name */
        public p f3254f;

        /* renamed from: g  reason: collision with root package name */
        public long f3255g;

        /* renamed from: h  reason: collision with root package name */
        public long f3256h;

        /* renamed from: i  reason: collision with root package name */
        public ac f3257i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<h, C0043a> implements i {

            /* renamed from: a  reason: collision with root package name */
            public int f3258a;

            /* renamed from: e  reason: collision with root package name */
            public long f3262e;

            /* renamed from: f  reason: collision with root package name */
            public long f3263f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3259b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3260c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f3261d = p.a();

            /* renamed from: g  reason: collision with root package name */
            public ac f3264g = ac.a();

            /* renamed from: h  reason: collision with root package name */
            public f f3265h = f.a();

            /* renamed from: i  reason: collision with root package name */
            public v f3266i = v.a();

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
                this.f3259b = "";
                int i2 = this.f3258a & (-2);
                this.f3258a = i2;
                this.f3260c = "";
                this.f3258a = i2 & (-3);
                this.f3261d = p.a();
                int i3 = this.f3258a & (-5);
                this.f3258a = i3;
                this.f3262e = 0L;
                int i4 = i3 & (-9);
                this.f3258a = i4;
                this.f3263f = 0L;
                this.f3258a = i4 & (-17);
                this.f3264g = ac.a();
                this.f3258a &= -33;
                this.f3265h = f.a();
                this.f3258a &= -65;
                this.f3266i = v.a();
                this.f3258a &= -129;
                return this;
            }

            public C0043a a(long j) {
                this.f3258a |= 8;
                this.f3262e = j;
                return this;
            }

            public C0043a a(ac acVar) {
                if (acVar != null) {
                    this.f3264g = acVar;
                    this.f3258a |= 32;
                    return this;
                }
                throw null;
            }

            public C0043a a(f fVar) {
                if (fVar != null) {
                    this.f3265h = fVar;
                    this.f3258a |= 64;
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
                    this.f3258a |= 1;
                    this.f3259b = hVar.f3252d;
                }
                if (hVar.e()) {
                    this.f3258a |= 2;
                    this.f3260c = hVar.f3253e;
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
                    this.f3261d = pVar;
                    this.f3258a |= 4;
                    return this;
                }
                throw null;
            }

            public C0043a a(v vVar) {
                if (vVar != null) {
                    this.f3266i = vVar;
                    this.f3258a |= 128;
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
                        h parsePartialFrom = h.f3249a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                this.f3258a |= 16;
                this.f3263f = j;
                return this;
            }

            public C0043a b(ac acVar) {
                if ((this.f3258a & 32) == 32 && this.f3264g != ac.a()) {
                    acVar = ac.a(this.f3264g).mergeFrom(acVar).buildPartial();
                }
                this.f3264g = acVar;
                this.f3258a |= 32;
                return this;
            }

            public C0043a b(f fVar) {
                if ((this.f3258a & 64) == 64 && this.f3265h != f.a()) {
                    fVar = f.a(this.f3265h).mergeFrom(fVar).buildPartial();
                }
                this.f3265h = fVar;
                this.f3258a |= 64;
                return this;
            }

            public C0043a b(p pVar) {
                if ((this.f3258a & 4) == 4 && this.f3261d != p.a()) {
                    pVar = p.a(this.f3261d).mergeFrom(pVar).buildPartial();
                }
                this.f3261d = pVar;
                this.f3258a |= 4;
                return this;
            }

            public C0043a b(v vVar) {
                if ((this.f3258a & 128) == 128 && this.f3266i != v.a()) {
                    vVar = v.a(this.f3266i).mergeFrom(vVar).buildPartial();
                }
                this.f3266i = vVar;
                this.f3258a |= 128;
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
                int i2 = this.f3258a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                hVar.f3252d = this.f3259b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                hVar.f3253e = this.f3260c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                hVar.f3254f = this.f3261d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                hVar.f3255g = this.f3262e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                hVar.f3256h = this.f3263f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                hVar.f3257i = this.f3264g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                hVar.j = this.f3265h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                hVar.k = this.f3266i;
                hVar.f3251c = i3;
                return hVar;
            }

            public boolean f() {
                return (this.f3258a & 4) == 4;
            }

            public p g() {
                return this.f3261d;
            }

            public boolean h() {
                return (this.f3258a & 8) == 8;
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
            f3250b = hVar;
            hVar.v();
        }

        public h() {
            this.l = (byte) -1;
            this.m = -1;
        }

        public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            int i3;
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
                                this.f3251c |= 1;
                                this.f3252d = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (readTag == 58) {
                                    i2 = 4;
                                    p.C0047a builder = (this.f3251c & 4) == 4 ? this.f3254f.toBuilder() : null;
                                    p pVar = (p) codedInputStream.readMessage(p.f3316a, extensionRegistryLite);
                                    this.f3254f = pVar;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar);
                                        this.f3254f = builder.buildPartial();
                                    }
                                    i3 = this.f3251c;
                                } else if (readTag == 80) {
                                    this.f3251c |= 8;
                                    this.f3255g = codedInputStream.readInt64();
                                } else if (readTag == 96) {
                                    this.f3251c |= 16;
                                    this.f3256h = codedInputStream.readInt64();
                                } else if (readTag == 162) {
                                    i2 = 32;
                                    ac.C0039a builder2 = (this.f3251c & 32) == 32 ? this.f3257i.toBuilder() : null;
                                    ac acVar = (ac) codedInputStream.readMessage(ac.f3176a, extensionRegistryLite);
                                    this.f3257i = acVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(acVar);
                                        this.f3257i = builder2.buildPartial();
                                    }
                                    i3 = this.f3251c;
                                } else if (readTag == 170) {
                                    i2 = 64;
                                    f.C0042a builder3 = (this.f3251c & 64) == 64 ? this.j.toBuilder() : null;
                                    f fVar = (f) codedInputStream.readMessage(f.f3237a, extensionRegistryLite);
                                    this.j = fVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(fVar);
                                        this.j = builder3.buildPartial();
                                    }
                                    i3 = this.f3251c;
                                } else if (readTag == 178) {
                                    i2 = 128;
                                    v.C0050a builder4 = (this.f3251c & 128) == 128 ? this.k.toBuilder() : null;
                                    v vVar = (v) codedInputStream.readMessage(v.f3353a, extensionRegistryLite);
                                    this.k = vVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(vVar);
                                        this.k = builder4.buildPartial();
                                    }
                                    i3 = this.f3251c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3251c = i3 | i2;
                            } else {
                                this.f3251c |= 2;
                                this.f3253e = codedInputStream.readBytes();
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
            return f3250b;
        }

        public static C0043a t() {
            return C0043a.k();
        }

        private void v() {
            this.f3252d = "";
            this.f3253e = "";
            this.f3254f = p.a();
            this.f3255g = 0L;
            this.f3256h = 0L;
            this.f3257i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f3250b;
        }

        public boolean c() {
            return (this.f3251c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3252d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3252d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3251c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3253e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3253e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3251c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            return f3249a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3251c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3251c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3251c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f3254f);
            }
            if ((this.f3251c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f3255g);
            }
            if ((this.f3251c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f3256h);
            }
            if ((this.f3251c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f3257i);
            }
            if ((this.f3251c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
            }
            if ((this.f3251c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
            }
            this.m = computeBytesSize;
            return computeBytesSize;
        }

        public p h() {
            return this.f3254f;
        }

        public boolean i() {
            return (this.f3251c & 8) == 8;
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
            return this.f3255g;
        }

        public boolean k() {
            return (this.f3251c & 16) == 16;
        }

        public long l() {
            return this.f3256h;
        }

        public boolean m() {
            return (this.f3251c & 32) == 32;
        }

        public ac n() {
            return this.f3257i;
        }

        public boolean o() {
            return (this.f3251c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3251c & 128) == 128;
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
            if ((this.f3251c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3251c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3251c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f3254f);
            }
            if ((this.f3251c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.f3255g);
            }
            if ((this.f3251c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.f3256h);
            }
            if ((this.f3251c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.f3257i);
            }
            if ((this.f3251c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.f3251c & 128) == 128) {
                codedOutputStream.writeMessage(22, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class j extends GeneratedMessageLite implements k {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<j> f3267a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final j f3268b;

        /* renamed from: c  reason: collision with root package name */
        public int f3269c;

        /* renamed from: d  reason: collision with root package name */
        public long f3270d;

        /* renamed from: e  reason: collision with root package name */
        public long f3271e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3272f;

        /* renamed from: g  reason: collision with root package name */
        public long f3273g;

        /* renamed from: h  reason: collision with root package name */
        public long f3274h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3275i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<j, C0044a> implements k {

            /* renamed from: a  reason: collision with root package name */
            public int f3276a;

            /* renamed from: b  reason: collision with root package name */
            public long f3277b;

            /* renamed from: c  reason: collision with root package name */
            public long f3278c;

            /* renamed from: e  reason: collision with root package name */
            public long f3280e;

            /* renamed from: f  reason: collision with root package name */
            public long f3281f;

            /* renamed from: h  reason: collision with root package name */
            public long f3283h;

            /* renamed from: d  reason: collision with root package name */
            public Object f3279d = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3282g = "";

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
                this.f3277b = 0L;
                int i2 = this.f3276a & (-2);
                this.f3276a = i2;
                this.f3278c = 0L;
                int i3 = i2 & (-3);
                this.f3276a = i3;
                this.f3279d = "";
                int i4 = i3 & (-5);
                this.f3276a = i4;
                this.f3280e = 0L;
                int i5 = i4 & (-9);
                this.f3276a = i5;
                this.f3281f = 0L;
                int i6 = i5 & (-17);
                this.f3276a = i6;
                this.f3282g = "";
                int i7 = i6 & (-33);
                this.f3276a = i7;
                this.f3283h = 0L;
                this.f3276a = i7 & (-65);
                return this;
            }

            public C0044a a(long j) {
                this.f3276a |= 1;
                this.f3277b = j;
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
                    this.f3276a |= 4;
                    this.f3279d = jVar.f3272f;
                }
                if (jVar.i()) {
                    c(jVar.j());
                }
                if (jVar.k()) {
                    d(jVar.l());
                }
                if (jVar.m()) {
                    this.f3276a |= 32;
                    this.f3282g = jVar.f3275i;
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
                        j parsePartialFrom = j.f3267a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3276a |= 4;
                    this.f3279d = str;
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
                this.f3276a |= 2;
                this.f3278c = j;
                return this;
            }

            public C0044a b(String str) {
                if (str != null) {
                    this.f3276a |= 32;
                    this.f3282g = str;
                    return this;
                }
                throw null;
            }

            public C0044a c(long j) {
                this.f3276a |= 8;
                this.f3280e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0044a d(long j) {
                this.f3276a |= 16;
                this.f3281f = j;
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
                this.f3276a |= 64;
                this.f3283h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i2 = this.f3276a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jVar.f3270d = this.f3277b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jVar.f3271e = this.f3278c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                jVar.f3272f = this.f3279d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                jVar.f3273g = this.f3280e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                jVar.f3274h = this.f3281f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                jVar.f3275i = this.f3282g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                jVar.j = this.f3283h;
                jVar.f3269c = i3;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            j jVar = new j();
            f3268b = jVar;
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
                                    this.f3269c |= 1;
                                    this.f3270d = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.f3269c |= 2;
                                    this.f3271e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3269c |= 4;
                                    this.f3272f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3269c |= 8;
                                    this.f3273g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f3269c |= 16;
                                    this.f3274h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f3269c |= 32;
                                    this.f3275i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f3269c |= 64;
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
            return f3268b;
        }

        public static C0044a q() {
            return C0044a.h();
        }

        private void t() {
            this.f3270d = 0L;
            this.f3271e = 0L;
            this.f3272f = "";
            this.f3273g = 0L;
            this.f3274h = 0L;
            this.f3275i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            return f3268b;
        }

        public boolean c() {
            return (this.f3269c & 1) == 1;
        }

        public long d() {
            return this.f3270d;
        }

        public boolean e() {
            return (this.f3269c & 2) == 2;
        }

        public long f() {
            return this.f3271e;
        }

        public boolean g() {
            return (this.f3269c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f3267a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3269c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3270d) : 0;
            if ((this.f3269c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3271e);
            }
            if ((this.f3269c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3269c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3273g);
            }
            if ((this.f3269c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3274h);
            }
            if ((this.f3269c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3269c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString h() {
            Object obj = this.f3272f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3272f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3269c & 8) == 8;
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
            return this.f3273g;
        }

        public boolean k() {
            return (this.f3269c & 16) == 16;
        }

        public long l() {
            return this.f3274h;
        }

        public boolean m() {
            return (this.f3269c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3275i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3275i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3269c & 64) == 64;
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
            if ((this.f3269c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3270d);
            }
            if ((this.f3269c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3271e);
            }
            if ((this.f3269c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3269c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3273g);
            }
            if ((this.f3269c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3274h);
            }
            if ((this.f3269c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3269c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class l extends GeneratedMessageLite implements m {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<l> f3284a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final l f3285b;

        /* renamed from: c  reason: collision with root package name */
        public int f3286c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3287d;

        /* renamed from: e  reason: collision with root package name */
        public long f3288e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3289f;

        /* renamed from: g  reason: collision with root package name */
        public long f3290g;

        /* renamed from: h  reason: collision with root package name */
        public byte f3291h;

        /* renamed from: i  reason: collision with root package name */
        public int f3292i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<l, C0045a> implements m {

            /* renamed from: a  reason: collision with root package name */
            public int f3293a;

            /* renamed from: c  reason: collision with root package name */
            public long f3295c;

            /* renamed from: e  reason: collision with root package name */
            public long f3297e;

            /* renamed from: b  reason: collision with root package name */
            public Object f3294b = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3296d = "";

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
                this.f3294b = "";
                int i2 = this.f3293a & (-2);
                this.f3293a = i2;
                this.f3295c = 0L;
                int i3 = i2 & (-3);
                this.f3293a = i3;
                this.f3296d = "";
                int i4 = i3 & (-5);
                this.f3293a = i4;
                this.f3297e = 0L;
                this.f3293a = i4 & (-9);
                return this;
            }

            public C0045a a(long j) {
                this.f3293a |= 2;
                this.f3295c = j;
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
                    this.f3293a |= 1;
                    this.f3294b = lVar.f3287d;
                }
                if (lVar.e()) {
                    a(lVar.f());
                }
                if (lVar.g()) {
                    this.f3293a |= 4;
                    this.f3296d = lVar.f3289f;
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
                        l parsePartialFrom = l.f3284a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3293a |= 1;
                    this.f3294b = str;
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
                this.f3293a |= 8;
                this.f3297e = j;
                return this;
            }

            public C0045a b(String str) {
                if (str != null) {
                    this.f3293a |= 4;
                    this.f3296d = str;
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
                int i2 = this.f3293a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lVar.f3287d = this.f3294b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lVar.f3288e = this.f3295c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lVar.f3289f = this.f3296d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lVar.f3290g = this.f3297e;
                lVar.f3286c = i3;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            l lVar = new l();
            f3285b = lVar;
            lVar.n();
        }

        public l() {
            this.f3291h = (byte) -1;
            this.f3292i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3291h = (byte) -1;
            this.f3292i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3286c |= 1;
                                    this.f3287d = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.f3286c |= 2;
                                    this.f3288e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3286c |= 4;
                                    this.f3289f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3286c |= 8;
                                    this.f3290g = codedInputStream.readInt64();
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
            this.f3291h = (byte) -1;
            this.f3292i = -1;
        }

        public static C0045a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f3285b;
        }

        public static C0045a k() {
            return C0045a.h();
        }

        private void n() {
            this.f3287d = "";
            this.f3288e = 0L;
            this.f3289f = "";
            this.f3290g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            return f3285b;
        }

        public boolean c() {
            return (this.f3286c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3287d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3287d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3286c & 2) == 2;
        }

        public long f() {
            return this.f3288e;
        }

        public boolean g() {
            return (this.f3286c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f3284a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3292i;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3286c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3286c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3288e);
            }
            if ((this.f3286c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3286c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3290g);
            }
            this.f3292i = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3289f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3289f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3286c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3291h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3291h = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3290g;
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
            if ((this.f3286c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3286c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3288e);
            }
            if ((this.f3286c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3286c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3290g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f3298a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final n f3299b;

        /* renamed from: c  reason: collision with root package name */
        public int f3300c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3301d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3302e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3303f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3304g;

        /* renamed from: h  reason: collision with root package name */
        public long f3305h;

        /* renamed from: i  reason: collision with root package name */
        public long f3306i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<n, C0046a> implements o {

            /* renamed from: a  reason: collision with root package name */
            public int f3307a;

            /* renamed from: f  reason: collision with root package name */
            public long f3312f;

            /* renamed from: g  reason: collision with root package name */
            public long f3313g;

            /* renamed from: h  reason: collision with root package name */
            public long f3314h;
            public long j;

            /* renamed from: b  reason: collision with root package name */
            public Object f3308b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3309c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3310d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3311e = "";

            /* renamed from: i  reason: collision with root package name */
            public Object f3315i = "";

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
                this.f3308b = "";
                int i2 = this.f3307a & (-2);
                this.f3307a = i2;
                this.f3309c = "";
                int i3 = i2 & (-3);
                this.f3307a = i3;
                this.f3310d = "";
                int i4 = i3 & (-5);
                this.f3307a = i4;
                this.f3311e = "";
                int i5 = i4 & (-9);
                this.f3307a = i5;
                this.f3312f = 0L;
                int i6 = i5 & (-17);
                this.f3307a = i6;
                this.f3313g = 0L;
                int i7 = i6 & (-33);
                this.f3307a = i7;
                this.f3314h = 0L;
                int i8 = i7 & (-65);
                this.f3307a = i8;
                this.f3315i = "";
                int i9 = i8 & (-129);
                this.f3307a = i9;
                this.j = 0L;
                this.f3307a = i9 & (-257);
                return this;
            }

            public C0046a a(long j) {
                this.f3307a |= 16;
                this.f3312f = j;
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
                    this.f3307a |= 1;
                    this.f3308b = nVar.f3301d;
                }
                if (nVar.e()) {
                    this.f3307a |= 2;
                    this.f3309c = nVar.f3302e;
                }
                if (nVar.g()) {
                    this.f3307a |= 4;
                    this.f3310d = nVar.f3303f;
                }
                if (nVar.i()) {
                    this.f3307a |= 8;
                    this.f3311e = nVar.f3304g;
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
                    this.f3307a |= 128;
                    this.f3315i = nVar.k;
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
                        n parsePartialFrom = n.f3298a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3307a |= 1;
                    this.f3308b = str;
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
                this.f3307a |= 32;
                this.f3313g = j;
                return this;
            }

            public C0046a b(String str) {
                if (str != null) {
                    this.f3307a |= 2;
                    this.f3309c = str;
                    return this;
                }
                throw null;
            }

            public C0046a c(long j) {
                this.f3307a |= 64;
                this.f3314h = j;
                return this;
            }

            public C0046a c(String str) {
                if (str != null) {
                    this.f3307a |= 4;
                    this.f3310d = str;
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
                this.f3307a |= 256;
                this.j = j;
                return this;
            }

            public C0046a d(String str) {
                if (str != null) {
                    this.f3307a |= 8;
                    this.f3311e = str;
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
                    this.f3307a |= 128;
                    this.f3315i = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i2 = this.f3307a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                nVar.f3301d = this.f3308b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                nVar.f3302e = this.f3309c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                nVar.f3303f = this.f3310d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                nVar.f3304g = this.f3311e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                nVar.f3305h = this.f3312f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                nVar.f3306i = this.f3313g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                nVar.j = this.f3314h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                nVar.k = this.f3315i;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                nVar.l = this.j;
                nVar.f3300c = i3;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            n nVar = new n();
            f3299b = nVar;
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
                                this.f3300c |= 1;
                                this.f3301d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3300c |= 2;
                                this.f3302e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f3300c |= 4;
                                this.f3303f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f3300c |= 8;
                                this.f3304g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f3300c |= 16;
                                this.f3305h = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.f3300c |= 32;
                                this.f3306i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3300c |= 64;
                                this.j = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.f3300c |= 128;
                                this.k = codedInputStream.readBytes();
                            } else if (readTag == 72) {
                                this.f3300c |= 256;
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
            return f3299b;
        }

        public static C0046a u() {
            return C0046a.h();
        }

        private void x() {
            this.f3301d = "";
            this.f3302e = "";
            this.f3303f = "";
            this.f3304g = "";
            this.f3305h = 0L;
            this.f3306i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f3299b;
        }

        public boolean c() {
            return (this.f3300c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3301d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3301d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3300c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3302e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3302e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3300c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            return f3298a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3300c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3300c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3300c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3300c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3300c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3305h);
            }
            if ((this.f3300c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f3306i);
            }
            if ((this.f3300c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            if ((this.f3300c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
            }
            if ((this.f3300c & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
            }
            this.n = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3303f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3303f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3300c & 8) == 8;
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
            Object obj = this.f3304g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3304g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3300c & 16) == 16;
        }

        public long l() {
            return this.f3305h;
        }

        public boolean m() {
            return (this.f3300c & 32) == 32;
        }

        public long n() {
            return this.f3306i;
        }

        public boolean o() {
            return (this.f3300c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3300c & 128) == 128;
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
            return (this.f3300c & 256) == 256;
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
            if ((this.f3300c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3300c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3300c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3300c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3300c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3305h);
            }
            if ((this.f3300c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3306i);
            }
            if ((this.f3300c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.f3300c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.f3300c & 256) == 256) {
                codedOutputStream.writeInt64(9, this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class p extends GeneratedMessageLite implements q {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<p> f3316a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final p f3317b;

        /* renamed from: c  reason: collision with root package name */
        public int f3318c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3319d;

        /* renamed from: e  reason: collision with root package name */
        public byte f3320e;

        /* renamed from: f  reason: collision with root package name */
        public int f3321f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<p, C0047a> implements q {

            /* renamed from: a  reason: collision with root package name */
            public int f3322a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3323b = "";

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
                this.f3323b = "";
                this.f3322a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f3322a |= 1;
                    this.f3323b = pVar.f3319d;
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
                        p parsePartialFrom = p.f3316a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3322a |= 1;
                    this.f3323b = str;
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
                int i2 = (this.f3322a & 1) != 1 ? 0 : 1;
                pVar.f3319d = this.f3323b;
                pVar.f3318c = i2;
                return pVar;
            }

            public boolean f() {
                return (this.f3322a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            p pVar = new p();
            f3317b = pVar;
            pVar.h();
        }

        public p() {
            this.f3320e = (byte) -1;
            this.f3321f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3320e = (byte) -1;
            this.f3321f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 34) {
                                this.f3318c |= 1;
                                this.f3319d = codedInputStream.readBytes();
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
            this.f3320e = (byte) -1;
            this.f3321f = -1;
        }

        public static C0047a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f3317b;
        }

        public static C0047a e() {
            return C0047a.i();
        }

        private void h() {
            this.f3319d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f3317b;
        }

        public boolean c() {
            return (this.f3318c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3319d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3319d = copyFromUtf8;
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
            return f3316a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3321f;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3318c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
            this.f3321f = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3320e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.f3320e = (byte) 1;
                return true;
            } else {
                this.f3320e = (byte) 0;
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
            if ((this.f3318c & 1) == 1) {
                codedOutputStream.writeBytes(4, d());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class r extends GeneratedMessageLite implements s {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<r> f3324a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final r f3325b;

        /* renamed from: c  reason: collision with root package name */
        public int f3326c;

        /* renamed from: d  reason: collision with root package name */
        public int f3327d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3328e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3329f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3330g;

        /* renamed from: h  reason: collision with root package name */
        public int f3331h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<r, C0048a> implements s {

            /* renamed from: a  reason: collision with root package name */
            public int f3332a;

            /* renamed from: b  reason: collision with root package name */
            public int f3333b = 7399;

            /* renamed from: c  reason: collision with root package name */
            public Object f3334c = "push_im_client";

            /* renamed from: d  reason: collision with root package name */
            public Object f3335d = "phonebaidu";

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
                this.f3333b = 7399;
                int i2 = this.f3332a & (-2);
                this.f3332a = i2;
                this.f3334c = "push_im_client";
                int i3 = i2 & (-3);
                this.f3332a = i3;
                this.f3335d = "phonebaidu";
                this.f3332a = i3 & (-5);
                return this;
            }

            public C0048a a(int i2) {
                this.f3332a |= 1;
                this.f3333b = i2;
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
                    this.f3332a |= 2;
                    this.f3334c = rVar.f3328e;
                }
                if (rVar.g()) {
                    this.f3332a |= 4;
                    this.f3335d = rVar.f3329f;
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
                        r parsePartialFrom = r.f3324a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                int i2 = this.f3332a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                rVar.f3327d = this.f3333b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                rVar.f3328e = this.f3334c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                rVar.f3329f = this.f3335d;
                rVar.f3326c = i3;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            r rVar = new r();
            f3325b = rVar;
            rVar.l();
        }

        public r() {
            this.f3330g = (byte) -1;
            this.f3331h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3330g = (byte) -1;
            this.f3331h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3326c |= 1;
                                    this.f3327d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3326c |= 2;
                                    this.f3328e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3326c |= 4;
                                    this.f3329f = codedInputStream.readBytes();
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
            this.f3330g = (byte) -1;
            this.f3331h = -1;
        }

        public static C0048a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f3325b;
        }

        public static C0048a i() {
            return C0048a.h();
        }

        private void l() {
            this.f3327d = 7399;
            this.f3328e = "push_im_client";
            this.f3329f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f3325b;
        }

        public boolean c() {
            return (this.f3326c & 1) == 1;
        }

        public int d() {
            return this.f3327d;
        }

        public boolean e() {
            return (this.f3326c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3328e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3328e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3326c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            return f3324a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3331h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3326c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3327d) : 0;
            if ((this.f3326c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3326c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3331h = computeInt32Size;
            return computeInt32Size;
        }

        public ByteString h() {
            Object obj = this.f3329f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3329f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3330g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3330g = (byte) 1;
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
            if ((this.f3326c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3327d);
            }
            if ((this.f3326c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3326c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class t extends GeneratedMessageLite implements u {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<t> f3336a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final t f3337b;

        /* renamed from: c  reason: collision with root package name */
        public int f3338c;

        /* renamed from: d  reason: collision with root package name */
        public long f3339d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3340e;

        /* renamed from: f  reason: collision with root package name */
        public long f3341f;

        /* renamed from: g  reason: collision with root package name */
        public long f3342g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3343h;

        /* renamed from: i  reason: collision with root package name */
        public long f3344i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<t, C0049a> implements u {

            /* renamed from: a  reason: collision with root package name */
            public int f3345a;

            /* renamed from: b  reason: collision with root package name */
            public long f3346b;

            /* renamed from: d  reason: collision with root package name */
            public long f3348d;

            /* renamed from: e  reason: collision with root package name */
            public long f3349e;

            /* renamed from: g  reason: collision with root package name */
            public long f3351g;

            /* renamed from: h  reason: collision with root package name */
            public long f3352h;

            /* renamed from: c  reason: collision with root package name */
            public Object f3347c = "";

            /* renamed from: f  reason: collision with root package name */
            public Object f3350f = "";

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
                this.f3346b = 0L;
                int i2 = this.f3345a & (-2);
                this.f3345a = i2;
                this.f3347c = "";
                int i3 = i2 & (-3);
                this.f3345a = i3;
                this.f3348d = 0L;
                int i4 = i3 & (-5);
                this.f3345a = i4;
                this.f3349e = 0L;
                int i5 = i4 & (-9);
                this.f3345a = i5;
                this.f3350f = "";
                int i6 = i5 & (-17);
                this.f3345a = i6;
                this.f3351g = 0L;
                int i7 = i6 & (-33);
                this.f3345a = i7;
                this.f3352h = 0L;
                this.f3345a = i7 & (-65);
                return this;
            }

            public C0049a a(long j) {
                this.f3345a |= 1;
                this.f3346b = j;
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
                    this.f3345a |= 2;
                    this.f3347c = tVar.f3340e;
                }
                if (tVar.g()) {
                    b(tVar.h());
                }
                if (tVar.i()) {
                    c(tVar.j());
                }
                if (tVar.k()) {
                    this.f3345a |= 16;
                    this.f3350f = tVar.f3343h;
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
                        t parsePartialFrom = t.f3336a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                this.f3345a |= 4;
                this.f3348d = j;
                return this;
            }

            public C0049a c(long j) {
                this.f3345a |= 8;
                this.f3349e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0049a d(long j) {
                this.f3345a |= 32;
                this.f3351g = j;
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
                this.f3345a |= 64;
                this.f3352h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i2 = this.f3345a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                tVar.f3339d = this.f3346b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                tVar.f3340e = this.f3347c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                tVar.f3341f = this.f3348d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                tVar.f3342g = this.f3349e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                tVar.f3343h = this.f3350f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                tVar.f3344i = this.f3351g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                tVar.j = this.f3352h;
                tVar.f3338c = i3;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            t tVar = new t();
            f3337b = tVar;
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
                                this.f3338c |= 1;
                                this.f3339d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3338c |= 2;
                                this.f3340e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3338c |= 4;
                                this.f3341f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3338c |= 8;
                                this.f3342g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3338c |= 16;
                                this.f3343h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f3338c |= 32;
                                this.f3344i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3338c |= 64;
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
            return f3337b;
        }

        public static C0049a q() {
            return C0049a.h();
        }

        private void t() {
            this.f3339d = 0L;
            this.f3340e = "";
            this.f3341f = 0L;
            this.f3342g = 0L;
            this.f3343h = "";
            this.f3344i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f3337b;
        }

        public boolean c() {
            return (this.f3338c & 1) == 1;
        }

        public long d() {
            return this.f3339d;
        }

        public boolean e() {
            return (this.f3338c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3340e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3340e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3338c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            return f3336a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3338c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3339d) : 0;
            if ((this.f3338c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3338c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3341f);
            }
            if ((this.f3338c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3342g);
            }
            if ((this.f3338c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3338c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f3344i);
            }
            if ((this.f3338c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public long h() {
            return this.f3341f;
        }

        public boolean i() {
            return (this.f3338c & 8) == 8;
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
            return this.f3342g;
        }

        public boolean k() {
            return (this.f3338c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3343h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3343h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3338c & 32) == 32;
        }

        public long n() {
            return this.f3344i;
        }

        public boolean o() {
            return (this.f3338c & 64) == 64;
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
            if ((this.f3338c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3339d);
            }
            if ((this.f3338c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3338c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3341f);
            }
            if ((this.f3338c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3342g);
            }
            if ((this.f3338c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3338c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3344i);
            }
            if ((this.f3338c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class v extends GeneratedMessageLite implements w {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<v> f3353a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final v f3354b;

        /* renamed from: c  reason: collision with root package name */
        public int f3355c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3356d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3357e;

        /* renamed from: f  reason: collision with root package name */
        public byte f3358f;

        /* renamed from: g  reason: collision with root package name */
        public int f3359g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<v, C0050a> implements w {

            /* renamed from: a  reason: collision with root package name */
            public int f3360a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3361b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3362c = "";

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
                this.f3361b = "";
                int i2 = this.f3360a & (-2);
                this.f3360a = i2;
                this.f3362c = "";
                this.f3360a = i2 & (-3);
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
                    this.f3360a |= 1;
                    this.f3361b = vVar.f3356d;
                }
                if (vVar.e()) {
                    this.f3360a |= 2;
                    this.f3362c = vVar.f3357e;
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
                        v parsePartialFrom = v.f3353a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3360a |= 1;
                    this.f3361b = str;
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
                    this.f3360a |= 2;
                    this.f3362c = str;
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
                int i2 = this.f3360a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                vVar.f3356d = this.f3361b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                vVar.f3357e = this.f3362c;
                vVar.f3355c = i3;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            v vVar = new v();
            f3354b = vVar;
            vVar.j();
        }

        public v() {
            this.f3358f = (byte) -1;
            this.f3359g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3358f = (byte) -1;
            this.f3359g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3355c |= 1;
                                this.f3356d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3355c |= 2;
                                this.f3357e = codedInputStream.readBytes();
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
            this.f3358f = (byte) -1;
            this.f3359g = -1;
        }

        public static C0050a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f3354b;
        }

        public static C0050a g() {
            return C0050a.h();
        }

        private void j() {
            this.f3356d = "";
            this.f3357e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f3354b;
        }

        public boolean c() {
            return (this.f3355c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3356d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3356d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3355c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3357e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3357e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f3353a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3359g;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3355c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3355c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            this.f3359g = computeBytesSize;
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
            byte b2 = this.f3358f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3358f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3355c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3355c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public enum x implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0),
        IOS(1),
        ANDROID(2),
        WINDOWSPHONE(3);
        

        /* renamed from: e  reason: collision with root package name */
        public final int f3368e;

        x(int i2) {
            this.f3368e = i2;
        }

        public static x a(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
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
            return this.f3368e;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f3369a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final y f3370b;

        /* renamed from: c  reason: collision with root package name */
        public int f3371c;

        /* renamed from: d  reason: collision with root package name */
        public r f3372d;

        /* renamed from: e  reason: collision with root package name */
        public h f3373e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3374f;

        /* renamed from: g  reason: collision with root package name */
        public long f3375g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f3376h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3377i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0051a extends GeneratedMessageLite.Builder<y, C0051a> implements z {

            /* renamed from: a  reason: collision with root package name */
            public int f3378a;

            /* renamed from: e  reason: collision with root package name */
            public long f3382e;

            /* renamed from: b  reason: collision with root package name */
            public r f3379b = r.a();

            /* renamed from: c  reason: collision with root package name */
            public h f3380c = h.a();

            /* renamed from: d  reason: collision with root package name */
            public Object f3381d = "";

            /* renamed from: f  reason: collision with root package name */
            public List<c> f3383f = Collections.emptyList();

            public C0051a() {
                i();
            }

            private void i() {
            }

            public static C0051a j() {
                return new C0051a();
            }

            private void k() {
                if ((this.f3378a & 16) != 16) {
                    this.f3383f = new ArrayList(this.f3383f);
                    this.f3378a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0051a clear() {
                super.clear();
                this.f3379b = r.a();
                this.f3378a &= -2;
                this.f3380c = h.a();
                int i2 = this.f3378a & (-3);
                this.f3378a = i2;
                this.f3381d = "";
                int i3 = i2 & (-5);
                this.f3378a = i3;
                this.f3382e = 0L;
                this.f3378a = i3 & (-9);
                this.f3383f = Collections.emptyList();
                this.f3378a &= -17;
                return this;
            }

            public C0051a a(long j) {
                this.f3378a |= 8;
                this.f3382e = j;
                return this;
            }

            public C0051a a(h hVar) {
                if (hVar != null) {
                    this.f3380c = hVar;
                    this.f3378a |= 2;
                    return this;
                }
                throw null;
            }

            public C0051a a(r rVar) {
                if ((this.f3378a & 1) == 1 && this.f3379b != r.a()) {
                    rVar = r.a(this.f3379b).mergeFrom(rVar).buildPartial();
                }
                this.f3379b = rVar;
                this.f3378a |= 1;
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
                    this.f3378a |= 4;
                    this.f3381d = yVar.f3374f;
                }
                if (yVar.i()) {
                    a(yVar.j());
                }
                if (!yVar.f3376h.isEmpty()) {
                    if (this.f3383f.isEmpty()) {
                        this.f3383f = yVar.f3376h;
                        this.f3378a &= -17;
                    } else {
                        k();
                        this.f3383f.addAll(yVar.f3376h);
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
                        y parsePartialFrom = y.f3369a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                AbstractMessageLite.Builder.addAll(iterable, this.f3383f);
                return this;
            }

            public C0051a a(String str) {
                if (str != null) {
                    this.f3378a |= 4;
                    this.f3381d = str;
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
                if ((this.f3378a & 2) == 2 && this.f3380c != h.a()) {
                    hVar = h.a(this.f3380c).mergeFrom(hVar).buildPartial();
                }
                this.f3380c = hVar;
                this.f3378a |= 2;
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
                int i2 = this.f3378a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                yVar.f3372d = this.f3379b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                yVar.f3373e = this.f3380c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                yVar.f3374f = this.f3381d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                yVar.f3375g = this.f3382e;
                if ((this.f3378a & 16) == 16) {
                    this.f3383f = Collections.unmodifiableList(this.f3383f);
                    this.f3378a &= -17;
                }
                yVar.f3376h = this.f3383f;
                yVar.f3371c = i3;
                return yVar;
            }

            public boolean f() {
                return (this.f3378a & 2) == 2;
            }

            public h g() {
                return this.f3380c;
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
            f3370b = yVar;
            yVar.n();
        }

        public y() {
            this.f3377i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            this.f3377i = (byte) -1;
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
                        int i3 = 1;
                        if (readTag != 0) {
                            if (readTag == 202) {
                                r.C0048a builder = (this.f3371c & 1) == 1 ? this.f3372d.toBuilder() : null;
                                r rVar = (r) codedInputStream.readMessage(r.f3324a, extensionRegistryLite);
                                this.f3372d = rVar;
                                if (builder != null) {
                                    builder.mergeFrom(rVar);
                                    this.f3372d = builder.buildPartial();
                                }
                                i2 = this.f3371c;
                            } else if (readTag == 330) {
                                i3 = 2;
                                h.C0043a builder2 = (this.f3371c & 2) == 2 ? this.f3373e.toBuilder() : null;
                                h hVar = (h) codedInputStream.readMessage(h.f3249a, extensionRegistryLite);
                                this.f3373e = hVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hVar);
                                    this.f3373e = builder2.buildPartial();
                                }
                                i2 = this.f3371c;
                            } else if (readTag == 1042) {
                                this.f3371c |= 4;
                                this.f3374f = codedInputStream.readBytes();
                            } else if (readTag == 1048) {
                                this.f3371c |= 8;
                                this.f3375g = codedInputStream.readInt64();
                            } else if (readTag == 1058) {
                                if (!(z2 & true)) {
                                    this.f3376h = new ArrayList();
                                    z2 |= true;
                                }
                                this.f3376h.add(codedInputStream.readMessage(c.f3210a, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                            this.f3371c = i2 | i3;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f3376h = Collections.unmodifiableList(this.f3376h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3377i = (byte) -1;
            this.j = -1;
        }

        public static C0051a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f3370b;
        }

        public static C0051a k() {
            return C0051a.j();
        }

        private void n() {
            this.f3372d = r.a();
            this.f3373e = h.a();
            this.f3374f = "";
            this.f3375g = 0L;
            this.f3376h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f3370b;
        }

        public boolean c() {
            return (this.f3371c & 1) == 1;
        }

        public r d() {
            return this.f3372d;
        }

        public boolean e() {
            return (this.f3371c & 2) == 2;
        }

        public h f() {
            return this.f3373e;
        }

        public boolean g() {
            return (this.f3371c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f3369a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.f3371c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f3372d) + 0 : 0;
            if ((this.f3371c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f3373e);
            }
            if ((this.f3371c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3371c & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3375g);
            }
            for (int i3 = 0; i3 < this.f3376h.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f3376h.get(i3));
            }
            this.j = computeMessageSize;
            return computeMessageSize;
        }

        public ByteString h() {
            Object obj = this.f3374f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3374f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3371c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3377i;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!e()) {
                this.f3377i = (byte) 0;
                return false;
            } else if (f().isInitialized()) {
                this.f3377i = (byte) 1;
                return true;
            } else {
                this.f3377i = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.f3375g;
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
            if ((this.f3371c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.f3372d);
            }
            if ((this.f3371c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f3373e);
            }
            if ((this.f3371c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3371c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3375g);
            }
            for (int i2 = 0; i2 < this.f3376h.size(); i2++) {
                codedOutputStream.writeMessage(132, this.f3376h.get(i2));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
