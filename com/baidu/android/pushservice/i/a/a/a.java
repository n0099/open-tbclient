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
    public static final class C0037a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0037a> f3163a = new AbstractParser<C0037a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0037a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0037a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0037a f3164b;

        /* renamed from: c  reason: collision with root package name */
        public int f3165c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3166d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3167e;

        /* renamed from: f  reason: collision with root package name */
        public long f3168f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3169g;

        /* renamed from: h  reason: collision with root package name */
        public long f3170h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3171i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0038a extends GeneratedMessageLite.Builder<C0037a, C0038a> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3172a;

            /* renamed from: d  reason: collision with root package name */
            public long f3175d;

            /* renamed from: f  reason: collision with root package name */
            public long f3177f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3173b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3174c = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3176e = "";

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
                this.f3173b = "";
                int i2 = this.f3172a & (-2);
                this.f3172a = i2;
                this.f3174c = "";
                int i3 = i2 & (-3);
                this.f3172a = i3;
                this.f3175d = 0L;
                int i4 = i3 & (-5);
                this.f3172a = i4;
                this.f3176e = "";
                int i5 = i4 & (-9);
                this.f3172a = i5;
                this.f3177f = 0L;
                this.f3172a = i5 & (-17);
                return this;
            }

            public C0038a a(long j) {
                this.f3172a |= 4;
                this.f3175d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0038a mergeFrom(C0037a c0037a) {
                if (c0037a == C0037a.a()) {
                    return this;
                }
                if (c0037a.c()) {
                    this.f3172a |= 1;
                    this.f3173b = c0037a.f3166d;
                }
                if (c0037a.e()) {
                    this.f3172a |= 2;
                    this.f3174c = c0037a.f3167e;
                }
                if (c0037a.g()) {
                    a(c0037a.h());
                }
                if (c0037a.i()) {
                    this.f3172a |= 8;
                    this.f3176e = c0037a.f3169g;
                }
                if (c0037a.k()) {
                    b(c0037a.l());
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
                C0037a c0037a = null;
                try {
                    try {
                        C0037a parsePartialFrom = C0037a.f3163a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        C0037a c0037a2 = (C0037a) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0037a = c0037a2;
                            if (c0037a != null) {
                                mergeFrom(c0037a);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0037a != null) {
                    }
                    throw th;
                }
            }

            public C0038a a(String str) {
                if (str != null) {
                    this.f3172a |= 1;
                    this.f3173b = str;
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
                this.f3172a |= 16;
                this.f3177f = j;
                return this;
            }

            public C0038a b(String str) {
                if (str != null) {
                    this.f3172a |= 2;
                    return this;
                }
                throw null;
            }

            public C0038a c(String str) {
                if (str != null) {
                    this.f3172a |= 8;
                    this.f3176e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0037a getDefaultInstanceForType() {
                return C0037a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0037a build() {
                C0037a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0037a buildPartial() {
                C0037a c0037a = new C0037a(this);
                int i2 = this.f3172a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0037a.f3166d = this.f3173b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0037a.f3167e = this.f3174c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0037a.f3168f = this.f3175d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0037a.f3169g = this.f3176e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0037a.f3170h = this.f3177f;
                c0037a.f3165c = i3;
                return c0037a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0037a c0037a = new C0037a();
            f3164b = c0037a;
            c0037a.p();
        }

        public C0037a() {
            this.f3171i = (byte) -1;
            this.j = -1;
        }

        public C0037a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3171i = (byte) -1;
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
                                    this.f3165c |= 1;
                                    this.f3166d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3165c |= 2;
                                    this.f3167e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3165c |= 4;
                                    this.f3168f = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.f3165c |= 8;
                                    this.f3169g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3165c |= 16;
                                    this.f3170h = codedInputStream.readInt64();
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

        public C0037a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3171i = (byte) -1;
            this.j = -1;
        }

        public static C0038a a(C0037a c0037a) {
            return m().mergeFrom(c0037a);
        }

        public static C0037a a() {
            return f3164b;
        }

        public static C0038a m() {
            return C0038a.h();
        }

        private void p() {
            this.f3166d = "";
            this.f3167e = "";
            this.f3168f = 0L;
            this.f3169g = "";
            this.f3170h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0037a getDefaultInstanceForType() {
            return f3164b;
        }

        public boolean c() {
            return (this.f3165c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3166d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3166d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3165c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3167e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3167e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3165c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0037a> getParserForType() {
            return f3163a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3165c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3165c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3165c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3168f);
            }
            if ((this.f3165c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3165c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3170h);
            }
            this.j = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3168f;
        }

        public boolean i() {
            return (this.f3165c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3171i;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3171i = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3169g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3169g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3165c & 16) == 16;
        }

        public long l() {
            return this.f3170h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C0038a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C0038a newBuilderForType() {
            return m();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3165c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3165c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3165c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3168f);
            }
            if ((this.f3165c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3165c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3170h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f3178a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final aa f3179b;

        /* renamed from: c  reason: collision with root package name */
        public int f3180c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3181d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3182e;

        /* renamed from: f  reason: collision with root package name */
        public long f3183f;

        /* renamed from: g  reason: collision with root package name */
        public long f3184g;

        /* renamed from: h  reason: collision with root package name */
        public long f3185h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3186i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039a extends GeneratedMessageLite.Builder<aa, C0039a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            public int f3187a;

            /* renamed from: d  reason: collision with root package name */
            public long f3190d;

            /* renamed from: e  reason: collision with root package name */
            public long f3191e;

            /* renamed from: f  reason: collision with root package name */
            public long f3192f;

            /* renamed from: h  reason: collision with root package name */
            public long f3194h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3188b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3189c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3193g = "";

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
                this.f3188b = "";
                int i2 = this.f3187a & (-2);
                this.f3187a = i2;
                this.f3189c = "";
                int i3 = i2 & (-3);
                this.f3187a = i3;
                this.f3190d = 0L;
                int i4 = i3 & (-5);
                this.f3187a = i4;
                this.f3191e = 0L;
                int i5 = i4 & (-9);
                this.f3187a = i5;
                this.f3192f = 0L;
                int i6 = i5 & (-17);
                this.f3187a = i6;
                this.f3193g = "";
                int i7 = i6 & (-33);
                this.f3187a = i7;
                this.f3194h = 0L;
                this.f3187a = i7 & (-65);
                return this;
            }

            public C0039a a(long j) {
                this.f3187a |= 4;
                this.f3190d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0039a mergeFrom(aa aaVar) {
                if (aaVar == aa.a()) {
                    return this;
                }
                if (aaVar.c()) {
                    this.f3187a |= 1;
                    this.f3188b = aaVar.f3181d;
                }
                if (aaVar.e()) {
                    this.f3187a |= 2;
                    this.f3189c = aaVar.f3182e;
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
                    this.f3187a |= 32;
                    this.f3193g = aaVar.f3186i;
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
            public C0039a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                aa aaVar = null;
                try {
                    try {
                        aa parsePartialFrom = aa.f3178a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0039a a(String str) {
                if (str != null) {
                    this.f3187a |= 1;
                    this.f3188b = str;
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

            public C0039a b(long j) {
                this.f3187a |= 8;
                this.f3191e = j;
                return this;
            }

            public C0039a b(String str) {
                if (str != null) {
                    this.f3187a |= 2;
                    this.f3189c = str;
                    return this;
                }
                throw null;
            }

            public C0039a c(long j) {
                this.f3187a |= 16;
                this.f3192f = j;
                return this;
            }

            public C0039a c(String str) {
                if (str != null) {
                    this.f3187a |= 32;
                    this.f3193g = str;
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

            public C0039a d(long j) {
                this.f3187a |= 64;
                this.f3194h = j;
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
                int i2 = this.f3187a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aaVar.f3181d = this.f3188b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aaVar.f3182e = this.f3189c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aaVar.f3183f = this.f3190d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aaVar.f3184g = this.f3191e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aaVar.f3185h = this.f3192f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aaVar.f3186i = this.f3193g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aaVar.j = this.f3194h;
                aaVar.f3180c = i3;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            aa aaVar = new aa();
            f3179b = aaVar;
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
                                this.f3180c |= 1;
                                this.f3181d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3180c |= 2;
                                this.f3182e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3180c |= 4;
                                this.f3183f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3180c |= 8;
                                this.f3184g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3180c |= 16;
                                this.f3185h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3180c |= 32;
                                this.f3186i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3180c |= 64;
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

        public static C0039a a(aa aaVar) {
            return q().mergeFrom(aaVar);
        }

        public static aa a() {
            return f3179b;
        }

        public static C0039a q() {
            return C0039a.h();
        }

        private void t() {
            this.f3181d = "";
            this.f3182e = "";
            this.f3183f = 0L;
            this.f3184g = 0L;
            this.f3185h = 0L;
            this.f3186i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f3179b;
        }

        public boolean c() {
            return (this.f3180c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3181d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3181d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3180c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3182e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3182e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3180c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            return f3178a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3180c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3180c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3180c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3183f);
            }
            if ((this.f3180c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3184g);
            }
            if ((this.f3180c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3185h);
            }
            if ((this.f3180c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3180c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3183f;
        }

        public boolean i() {
            return (this.f3180c & 8) == 8;
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
            return this.f3184g;
        }

        public boolean k() {
            return (this.f3180c & 16) == 16;
        }

        public long l() {
            return this.f3185h;
        }

        public boolean m() {
            return (this.f3180c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3186i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3186i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3180c & 64) == 64;
        }

        public long p() {
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
            if ((this.f3180c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3180c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3180c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3183f);
            }
            if ((this.f3180c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3184g);
            }
            if ((this.f3180c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3185h);
            }
            if ((this.f3180c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3180c & 64) == 64) {
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
        public static Parser<ac> f3195a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ac f3196b;

        /* renamed from: c  reason: collision with root package name */
        public int f3197c;

        /* renamed from: d  reason: collision with root package name */
        public x f3198d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3199e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3200f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3201g;

        /* renamed from: h  reason: collision with root package name */
        public int f3202h;

        /* renamed from: i  reason: collision with root package name */
        public int f3203i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0040a extends GeneratedMessageLite.Builder<ac, C0040a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            public int f3204a;

            /* renamed from: b  reason: collision with root package name */
            public x f3205b = x.OS_TYPE_UNKNWON;

            /* renamed from: c  reason: collision with root package name */
            public Object f3206c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3207d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3208e = "";

            /* renamed from: f  reason: collision with root package name */
            public int f3209f;

            /* renamed from: g  reason: collision with root package name */
            public int f3210g;

            /* renamed from: h  reason: collision with root package name */
            public int f3211h;

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
                this.f3205b = x.OS_TYPE_UNKNWON;
                int i2 = this.f3204a & (-2);
                this.f3204a = i2;
                this.f3206c = "";
                int i3 = i2 & (-3);
                this.f3204a = i3;
                this.f3207d = "";
                int i4 = i3 & (-5);
                this.f3204a = i4;
                this.f3208e = "";
                int i5 = i4 & (-9);
                this.f3204a = i5;
                this.f3209f = 0;
                int i6 = i5 & (-17);
                this.f3204a = i6;
                this.f3210g = 0;
                int i7 = i6 & (-33);
                this.f3204a = i7;
                this.f3211h = 0;
                this.f3204a = i7 & (-65);
                return this;
            }

            public C0040a a(int i2) {
                this.f3204a |= 16;
                this.f3209f = i2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0040a mergeFrom(ac acVar) {
                if (acVar == ac.a()) {
                    return this;
                }
                if (acVar.c()) {
                    a(acVar.d());
                }
                if (acVar.e()) {
                    this.f3204a |= 2;
                    this.f3206c = acVar.f3199e;
                }
                if (acVar.g()) {
                    this.f3204a |= 4;
                    this.f3207d = acVar.f3200f;
                }
                if (acVar.i()) {
                    this.f3204a |= 8;
                    this.f3208e = acVar.f3201g;
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

            public C0040a a(x xVar) {
                if (xVar != null) {
                    this.f3204a |= 1;
                    this.f3205b = xVar;
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
            public C0040a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ac acVar = null;
                try {
                    try {
                        ac parsePartialFrom = ac.f3195a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0040a a(String str) {
                if (str != null) {
                    this.f3204a |= 2;
                    this.f3206c = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0040a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0040a b(int i2) {
                this.f3204a |= 32;
                this.f3210g = i2;
                return this;
            }

            public C0040a b(String str) {
                if (str != null) {
                    this.f3204a |= 4;
                    this.f3207d = str;
                    return this;
                }
                throw null;
            }

            public C0040a c(int i2) {
                this.f3204a |= 64;
                this.f3211h = i2;
                return this;
            }

            public C0040a c(String str) {
                if (str != null) {
                    this.f3204a |= 8;
                    this.f3208e = str;
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
                int i2 = this.f3204a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                acVar.f3198d = this.f3205b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                acVar.f3199e = this.f3206c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                acVar.f3200f = this.f3207d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                acVar.f3201g = this.f3208e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                acVar.f3202h = this.f3209f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                acVar.f3203i = this.f3210g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                acVar.j = this.f3211h;
                acVar.f3197c = i3;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ac acVar = new ac();
            f3196b = acVar;
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
                                        this.f3197c = 1 | this.f3197c;
                                        this.f3198d = a2;
                                    }
                                } else if (readTag == 18) {
                                    this.f3197c |= 2;
                                    this.f3199e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3197c |= 4;
                                    this.f3200f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f3197c |= 8;
                                    this.f3201g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3197c |= 16;
                                    this.f3202h = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.f3197c |= 32;
                                    this.f3203i = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.f3197c |= 64;
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

        public static C0040a a(ac acVar) {
            return q().mergeFrom(acVar);
        }

        public static ac a() {
            return f3196b;
        }

        public static C0040a q() {
            return C0040a.h();
        }

        private void t() {
            this.f3198d = x.OS_TYPE_UNKNWON;
            this.f3199e = "";
            this.f3200f = "";
            this.f3201g = "";
            this.f3202h = 0;
            this.f3203i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f3196b;
        }

        public boolean c() {
            return (this.f3197c & 1) == 1;
        }

        public x d() {
            return this.f3198d;
        }

        public boolean e() {
            return (this.f3197c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3199e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3199e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3197c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            return f3195a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3197c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3198d.getNumber()) : 0;
            if ((this.f3197c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3197c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3197c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3197c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f3202h);
            }
            if ((this.f3197c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f3203i);
            }
            if ((this.f3197c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
            }
            this.l = computeEnumSize;
            return computeEnumSize;
        }

        public ByteString h() {
            Object obj = this.f3200f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3200f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3197c & 8) == 8;
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
            Object obj = this.f3201g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3201g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3197c & 16) == 16;
        }

        public int l() {
            return this.f3202h;
        }

        public boolean m() {
            return (this.f3197c & 32) == 32;
        }

        public int n() {
            return this.f3203i;
        }

        public boolean o() {
            return (this.f3197c & 64) == 64;
        }

        public int p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0040a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0040a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3197c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3198d.getNumber());
            }
            if ((this.f3197c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3197c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3197c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3197c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.f3202h);
            }
            if ((this.f3197c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.f3203i);
            }
            if ((this.f3197c & 64) == 64) {
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
        public static Parser<ae> f3212a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ae f3213b;

        /* renamed from: c  reason: collision with root package name */
        public int f3214c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3215d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3216e;

        /* renamed from: f  reason: collision with root package name */
        public long f3217f;

        /* renamed from: g  reason: collision with root package name */
        public long f3218g;

        /* renamed from: h  reason: collision with root package name */
        public long f3219h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3220i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041a extends GeneratedMessageLite.Builder<ae, C0041a> implements af {

            /* renamed from: a  reason: collision with root package name */
            public int f3221a;

            /* renamed from: d  reason: collision with root package name */
            public long f3224d;

            /* renamed from: e  reason: collision with root package name */
            public long f3225e;

            /* renamed from: f  reason: collision with root package name */
            public long f3226f;

            /* renamed from: h  reason: collision with root package name */
            public long f3228h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3222b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3223c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3227g = "";

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
                this.f3222b = "";
                int i2 = this.f3221a & (-2);
                this.f3221a = i2;
                this.f3223c = "";
                int i3 = i2 & (-3);
                this.f3221a = i3;
                this.f3224d = 0L;
                int i4 = i3 & (-5);
                this.f3221a = i4;
                this.f3225e = 0L;
                int i5 = i4 & (-9);
                this.f3221a = i5;
                this.f3226f = 0L;
                int i6 = i5 & (-17);
                this.f3221a = i6;
                this.f3227g = "";
                int i7 = i6 & (-33);
                this.f3221a = i7;
                this.f3228h = 0L;
                this.f3221a = i7 & (-65);
                return this;
            }

            public C0041a a(long j) {
                this.f3221a |= 4;
                this.f3224d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0041a mergeFrom(ae aeVar) {
                if (aeVar == ae.a()) {
                    return this;
                }
                if (aeVar.c()) {
                    this.f3221a |= 1;
                    this.f3222b = aeVar.f3215d;
                }
                if (aeVar.e()) {
                    this.f3221a |= 2;
                    this.f3223c = aeVar.f3216e;
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
                    this.f3221a |= 32;
                    this.f3227g = aeVar.f3220i;
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
            public C0041a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ae aeVar = null;
                try {
                    try {
                        ae parsePartialFrom = ae.f3212a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0041a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0041a b(long j) {
                this.f3221a |= 8;
                this.f3225e = j;
                return this;
            }

            public C0041a c(long j) {
                this.f3221a |= 16;
                this.f3226f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0041a d(long j) {
                this.f3221a |= 64;
                this.f3228h = j;
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
                int i2 = this.f3221a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aeVar.f3215d = this.f3222b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aeVar.f3216e = this.f3223c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aeVar.f3217f = this.f3224d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aeVar.f3218g = this.f3225e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aeVar.f3219h = this.f3226f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aeVar.f3220i = this.f3227g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aeVar.j = this.f3228h;
                aeVar.f3214c = i3;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ae aeVar = new ae();
            f3213b = aeVar;
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
                                this.f3214c |= 1;
                                this.f3215d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3214c |= 2;
                                this.f3216e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3214c |= 4;
                                this.f3217f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3214c |= 8;
                                this.f3218g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3214c |= 16;
                                this.f3219h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3214c |= 32;
                                this.f3220i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3214c |= 64;
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

        public static C0041a a(ae aeVar) {
            return q().mergeFrom(aeVar);
        }

        public static ae a() {
            return f3213b;
        }

        public static C0041a q() {
            return C0041a.h();
        }

        private void t() {
            this.f3215d = "";
            this.f3216e = "";
            this.f3217f = 0L;
            this.f3218g = 0L;
            this.f3219h = 0L;
            this.f3220i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f3213b;
        }

        public boolean c() {
            return (this.f3214c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3215d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3215d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3214c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3216e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3216e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3214c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            return f3212a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3214c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3214c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3214c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3217f);
            }
            if ((this.f3214c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3218g);
            }
            if ((this.f3214c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3219h);
            }
            if ((this.f3214c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3214c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3217f;
        }

        public boolean i() {
            return (this.f3214c & 8) == 8;
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
            return this.f3218g;
        }

        public boolean k() {
            return (this.f3214c & 16) == 16;
        }

        public long l() {
            return this.f3219h;
        }

        public boolean m() {
            return (this.f3214c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3220i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3220i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3214c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0041a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
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
            if ((this.f3214c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3214c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3214c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3217f);
            }
            if ((this.f3214c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3218g);
            }
            if ((this.f3214c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3219h);
            }
            if ((this.f3214c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3214c & 64) == 64) {
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
        public static Parser<c> f3229a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3230b;

        /* renamed from: c  reason: collision with root package name */
        public int f3231c;

        /* renamed from: d  reason: collision with root package name */
        public e f3232d;

        /* renamed from: e  reason: collision with root package name */
        public ae f3233e;

        /* renamed from: f  reason: collision with root package name */
        public l f3234f;

        /* renamed from: g  reason: collision with root package name */
        public n f3235g;

        /* renamed from: h  reason: collision with root package name */
        public j f3236h;

        /* renamed from: i  reason: collision with root package name */
        public aa f3237i;
        public C0037a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0042a extends GeneratedMessageLite.Builder<c, C0042a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3238a;

            /* renamed from: b  reason: collision with root package name */
            public e f3239b = e.UI;

            /* renamed from: c  reason: collision with root package name */
            public ae f3240c = ae.a();

            /* renamed from: d  reason: collision with root package name */
            public l f3241d = l.a();

            /* renamed from: e  reason: collision with root package name */
            public n f3242e = n.a();

            /* renamed from: f  reason: collision with root package name */
            public j f3243f = j.a();

            /* renamed from: g  reason: collision with root package name */
            public aa f3244g = aa.a();

            /* renamed from: h  reason: collision with root package name */
            public C0037a f3245h = C0037a.a();

            /* renamed from: i  reason: collision with root package name */
            public t f3246i = t.a();

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
                this.f3239b = e.UI;
                this.f3238a &= -2;
                this.f3240c = ae.a();
                this.f3238a &= -3;
                this.f3241d = l.a();
                this.f3238a &= -5;
                this.f3242e = n.a();
                this.f3238a &= -9;
                this.f3243f = j.a();
                this.f3238a &= -17;
                this.f3244g = aa.a();
                this.f3238a &= -33;
                this.f3245h = C0037a.a();
                this.f3238a &= -65;
                this.f3246i = t.a();
                this.f3238a &= -129;
                return this;
            }

            public C0042a a(C0037a c0037a) {
                if (c0037a != null) {
                    this.f3245h = c0037a;
                    this.f3238a |= 64;
                    return this;
                }
                throw null;
            }

            public C0042a a(aa aaVar) {
                if (aaVar != null) {
                    this.f3244g = aaVar;
                    this.f3238a |= 32;
                    return this;
                }
                throw null;
            }

            public C0042a a(ae aeVar) {
                if ((this.f3238a & 2) == 2 && this.f3240c != ae.a()) {
                    aeVar = ae.a(this.f3240c).mergeFrom(aeVar).buildPartial();
                }
                this.f3240c = aeVar;
                this.f3238a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0042a mergeFrom(c cVar) {
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

            public C0042a a(e eVar) {
                if (eVar != null) {
                    this.f3238a |= 1;
                    this.f3239b = eVar;
                    return this;
                }
                throw null;
            }

            public C0042a a(j jVar) {
                if (jVar != null) {
                    this.f3243f = jVar;
                    this.f3238a |= 16;
                    return this;
                }
                throw null;
            }

            public C0042a a(l lVar) {
                if (lVar != null) {
                    this.f3241d = lVar;
                    this.f3238a |= 4;
                    return this;
                }
                throw null;
            }

            public C0042a a(n nVar) {
                if (nVar != null) {
                    this.f3242e = nVar;
                    this.f3238a |= 8;
                    return this;
                }
                throw null;
            }

            public C0042a a(t tVar) {
                if ((this.f3238a & 128) == 128 && this.f3246i != t.a()) {
                    tVar = t.a(this.f3246i).mergeFrom(tVar).buildPartial();
                }
                this.f3246i = tVar;
                this.f3238a |= 128;
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
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3229a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0042a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0042a b(C0037a c0037a) {
                if ((this.f3238a & 64) == 64 && this.f3245h != C0037a.a()) {
                    c0037a = C0037a.a(this.f3245h).mergeFrom(c0037a).buildPartial();
                }
                this.f3245h = c0037a;
                this.f3238a |= 64;
                return this;
            }

            public C0042a b(aa aaVar) {
                if ((this.f3238a & 32) == 32 && this.f3244g != aa.a()) {
                    aaVar = aa.a(this.f3244g).mergeFrom(aaVar).buildPartial();
                }
                this.f3244g = aaVar;
                this.f3238a |= 32;
                return this;
            }

            public C0042a b(j jVar) {
                if ((this.f3238a & 16) == 16 && this.f3243f != j.a()) {
                    jVar = j.a(this.f3243f).mergeFrom(jVar).buildPartial();
                }
                this.f3243f = jVar;
                this.f3238a |= 16;
                return this;
            }

            public C0042a b(l lVar) {
                if ((this.f3238a & 4) == 4 && this.f3241d != l.a()) {
                    lVar = l.a(this.f3241d).mergeFrom(lVar).buildPartial();
                }
                this.f3241d = lVar;
                this.f3238a |= 4;
                return this;
            }

            public C0042a b(n nVar) {
                if ((this.f3238a & 8) == 8 && this.f3242e != n.a()) {
                    nVar = n.a(this.f3242e).mergeFrom(nVar).buildPartial();
                }
                this.f3242e = nVar;
                this.f3238a |= 8;
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
                int i2 = this.f3238a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3232d = this.f3239b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3233e = this.f3240c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3234f = this.f3241d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                cVar.f3235g = this.f3242e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                cVar.f3236h = this.f3243f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                cVar.f3237i = this.f3244g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                cVar.j = this.f3245h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                cVar.k = this.f3246i;
                cVar.f3231c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3230b = cVar;
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
                                    ae.C0041a builder = (this.f3231c & 2) == 2 ? this.f3233e.toBuilder() : null;
                                    ae aeVar = (ae) codedInputStream.readMessage(ae.f3212a, extensionRegistryLite);
                                    this.f3233e = aeVar;
                                    if (builder != null) {
                                        builder.mergeFrom(aeVar);
                                        this.f3233e = builder.buildPartial();
                                    }
                                    i3 = this.f3231c;
                                } else if (readTag == 26) {
                                    i2 = 4;
                                    l.C0046a builder2 = (this.f3231c & 4) == 4 ? this.f3234f.toBuilder() : null;
                                    l lVar = (l) codedInputStream.readMessage(l.f3303a, extensionRegistryLite);
                                    this.f3234f = lVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar);
                                        this.f3234f = builder2.buildPartial();
                                    }
                                    i3 = this.f3231c;
                                } else if (readTag == 34) {
                                    n.C0047a builder3 = (this.f3231c & 8) == 8 ? this.f3235g.toBuilder() : null;
                                    n nVar = (n) codedInputStream.readMessage(n.f3317a, extensionRegistryLite);
                                    this.f3235g = nVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(nVar);
                                        this.f3235g = builder3.buildPartial();
                                    }
                                    this.f3231c |= 8;
                                } else if (readTag == 42) {
                                    i2 = 16;
                                    j.C0045a builder4 = (this.f3231c & 16) == 16 ? this.f3236h.toBuilder() : null;
                                    j jVar = (j) codedInputStream.readMessage(j.f3286a, extensionRegistryLite);
                                    this.f3236h = jVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(jVar);
                                        this.f3236h = builder4.buildPartial();
                                    }
                                    i3 = this.f3231c;
                                } else if (readTag == 50) {
                                    i2 = 32;
                                    aa.C0039a builder5 = (this.f3231c & 32) == 32 ? this.f3237i.toBuilder() : null;
                                    aa aaVar = (aa) codedInputStream.readMessage(aa.f3178a, extensionRegistryLite);
                                    this.f3237i = aaVar;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(aaVar);
                                        this.f3237i = builder5.buildPartial();
                                    }
                                    i3 = this.f3231c;
                                } else if (readTag == 58) {
                                    i2 = 64;
                                    C0037a.C0038a builder6 = (this.f3231c & 64) == 64 ? this.j.toBuilder() : null;
                                    C0037a c0037a = (C0037a) codedInputStream.readMessage(C0037a.f3163a, extensionRegistryLite);
                                    this.j = c0037a;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(c0037a);
                                        this.j = builder6.buildPartial();
                                    }
                                    i3 = this.f3231c;
                                } else if (readTag == 66) {
                                    i2 = 128;
                                    t.C0050a builder7 = (this.f3231c & 128) == 128 ? this.k.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.f3355a, extensionRegistryLite);
                                    this.k = tVar;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(tVar);
                                        this.k = builder7.buildPartial();
                                    }
                                    i3 = this.f3231c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3231c = i3 | i2;
                            } else {
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f3231c = 1 | this.f3231c;
                                    this.f3232d = a2;
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

        public static C0042a a(c cVar) {
            return s().mergeFrom(cVar);
        }

        public static c a() {
            return f3230b;
        }

        public static C0042a s() {
            return C0042a.h();
        }

        private void v() {
            this.f3232d = e.UI;
            this.f3233e = ae.a();
            this.f3234f = l.a();
            this.f3235g = n.a();
            this.f3236h = j.a();
            this.f3237i = aa.a();
            this.j = C0037a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3230b;
        }

        public boolean c() {
            return (this.f3231c & 1) == 1;
        }

        public e d() {
            return this.f3232d;
        }

        public boolean e() {
            return (this.f3231c & 2) == 2;
        }

        public ae f() {
            return this.f3233e;
        }

        public boolean g() {
            return (this.f3231c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3229a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3231c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3232d.getNumber()) : 0;
            if ((this.f3231c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f3233e);
            }
            if ((this.f3231c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f3234f);
            }
            if ((this.f3231c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f3235g);
            }
            if ((this.f3231c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f3236h);
            }
            if ((this.f3231c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f3237i);
            }
            if ((this.f3231c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
            }
            if ((this.f3231c & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
            }
            this.m = computeEnumSize;
            return computeEnumSize;
        }

        public l h() {
            return this.f3234f;
        }

        public boolean i() {
            return (this.f3231c & 8) == 8;
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
            return this.f3235g;
        }

        public boolean k() {
            return (this.f3231c & 16) == 16;
        }

        public j l() {
            return this.f3236h;
        }

        public boolean m() {
            return (this.f3231c & 32) == 32;
        }

        public aa n() {
            return this.f3237i;
        }

        public boolean o() {
            return (this.f3231c & 64) == 64;
        }

        public C0037a p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3231c & 128) == 128;
        }

        public t r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C0042a newBuilderForType() {
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0042a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3231c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3232d.getNumber());
            }
            if ((this.f3231c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.f3233e);
            }
            if ((this.f3231c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3234f);
            }
            if ((this.f3231c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f3235g);
            }
            if ((this.f3231c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.f3236h);
            }
            if ((this.f3231c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.f3237i);
            }
            if ((this.f3231c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.f3231c & 128) == 128) {
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
        public final int f3255h;

        e(int i2) {
            this.f3255h = i2;
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
            return this.f3255h;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f3256a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final f f3257b;

        /* renamed from: c  reason: collision with root package name */
        public int f3258c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3259d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3260e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3261f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3262g;

        /* renamed from: h  reason: collision with root package name */
        public int f3263h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<f, C0043a> implements g {

            /* renamed from: a  reason: collision with root package name */
            public int f3264a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3265b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3266c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3267d = "";

            public C0043a() {
                g();
            }

            private void g() {
            }

            public static C0043a h() {
                return new C0043a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0043a clear() {
                super.clear();
                this.f3265b = "";
                int i2 = this.f3264a & (-2);
                this.f3264a = i2;
                this.f3266c = "";
                int i3 = i2 & (-3);
                this.f3264a = i3;
                this.f3267d = "";
                this.f3264a = i3 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0043a mergeFrom(f fVar) {
                if (fVar == f.a()) {
                    return this;
                }
                if (fVar.c()) {
                    this.f3264a |= 1;
                    this.f3265b = fVar.f3259d;
                }
                if (fVar.e()) {
                    this.f3264a |= 2;
                    this.f3266c = fVar.f3260e;
                }
                if (fVar.g()) {
                    this.f3264a |= 4;
                    this.f3267d = fVar.f3261f;
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
            public C0043a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                f fVar = null;
                try {
                    try {
                        f parsePartialFrom = f.f3256a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0043a a(String str) {
                if (str != null) {
                    this.f3264a |= 1;
                    this.f3265b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0043a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0043a b(String str) {
                if (str != null) {
                    this.f3264a |= 2;
                    this.f3266c = str;
                    return this;
                }
                throw null;
            }

            public C0043a c(String str) {
                if (str != null) {
                    this.f3264a |= 4;
                    this.f3267d = str;
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
                int i2 = this.f3264a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                fVar.f3259d = this.f3265b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                fVar.f3260e = this.f3266c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                fVar.f3261f = this.f3267d;
                fVar.f3258c = i3;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f fVar = new f();
            f3257b = fVar;
            fVar.l();
        }

        public f() {
            this.f3262g = (byte) -1;
            this.f3263h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3262g = (byte) -1;
            this.f3263h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3258c |= 1;
                                    this.f3259d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3258c |= 2;
                                    this.f3260e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3258c |= 4;
                                    this.f3261f = codedInputStream.readBytes();
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
            this.f3262g = (byte) -1;
            this.f3263h = -1;
        }

        public static C0043a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f3257b;
        }

        public static C0043a i() {
            return C0043a.h();
        }

        private void l() {
            this.f3259d = "";
            this.f3260e = "";
            this.f3261f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f3257b;
        }

        public boolean c() {
            return (this.f3258c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3259d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3259d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3258c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3260e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3260e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3258c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            return f3256a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3263h;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3258c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3258c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3258c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3263h = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3261f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3261f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3262g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3262g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0043a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0043a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3258c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3258c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3258c & 4) == 4) {
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
        public static Parser<h> f3268a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final h f3269b;

        /* renamed from: c  reason: collision with root package name */
        public int f3270c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3271d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3272e;

        /* renamed from: f  reason: collision with root package name */
        public p f3273f;

        /* renamed from: g  reason: collision with root package name */
        public long f3274g;

        /* renamed from: h  reason: collision with root package name */
        public long f3275h;

        /* renamed from: i  reason: collision with root package name */
        public ac f3276i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<h, C0044a> implements i {

            /* renamed from: a  reason: collision with root package name */
            public int f3277a;

            /* renamed from: e  reason: collision with root package name */
            public long f3281e;

            /* renamed from: f  reason: collision with root package name */
            public long f3282f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3278b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3279c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f3280d = p.a();

            /* renamed from: g  reason: collision with root package name */
            public ac f3283g = ac.a();

            /* renamed from: h  reason: collision with root package name */
            public f f3284h = f.a();

            /* renamed from: i  reason: collision with root package name */
            public v f3285i = v.a();

            public C0044a() {
                j();
            }

            private void j() {
            }

            public static C0044a k() {
                return new C0044a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0044a clear() {
                super.clear();
                this.f3278b = "";
                int i2 = this.f3277a & (-2);
                this.f3277a = i2;
                this.f3279c = "";
                this.f3277a = i2 & (-3);
                this.f3280d = p.a();
                int i3 = this.f3277a & (-5);
                this.f3277a = i3;
                this.f3281e = 0L;
                int i4 = i3 & (-9);
                this.f3277a = i4;
                this.f3282f = 0L;
                this.f3277a = i4 & (-17);
                this.f3283g = ac.a();
                this.f3277a &= -33;
                this.f3284h = f.a();
                this.f3277a &= -65;
                this.f3285i = v.a();
                this.f3277a &= -129;
                return this;
            }

            public C0044a a(long j) {
                this.f3277a |= 8;
                this.f3281e = j;
                return this;
            }

            public C0044a a(ac acVar) {
                if (acVar != null) {
                    this.f3283g = acVar;
                    this.f3277a |= 32;
                    return this;
                }
                throw null;
            }

            public C0044a a(f fVar) {
                if (fVar != null) {
                    this.f3284h = fVar;
                    this.f3277a |= 64;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0044a mergeFrom(h hVar) {
                if (hVar == h.a()) {
                    return this;
                }
                if (hVar.c()) {
                    this.f3277a |= 1;
                    this.f3278b = hVar.f3271d;
                }
                if (hVar.e()) {
                    this.f3277a |= 2;
                    this.f3279c = hVar.f3272e;
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

            public C0044a a(p pVar) {
                if (pVar != null) {
                    this.f3280d = pVar;
                    this.f3277a |= 4;
                    return this;
                }
                throw null;
            }

            public C0044a a(v vVar) {
                if (vVar != null) {
                    this.f3285i = vVar;
                    this.f3277a |= 128;
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
            public C0044a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                h hVar = null;
                try {
                    try {
                        h parsePartialFrom = h.f3268a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0044a clone() {
                return k().mergeFrom(buildPartial());
            }

            public C0044a b(long j) {
                this.f3277a |= 16;
                this.f3282f = j;
                return this;
            }

            public C0044a b(ac acVar) {
                if ((this.f3277a & 32) == 32 && this.f3283g != ac.a()) {
                    acVar = ac.a(this.f3283g).mergeFrom(acVar).buildPartial();
                }
                this.f3283g = acVar;
                this.f3277a |= 32;
                return this;
            }

            public C0044a b(f fVar) {
                if ((this.f3277a & 64) == 64 && this.f3284h != f.a()) {
                    fVar = f.a(this.f3284h).mergeFrom(fVar).buildPartial();
                }
                this.f3284h = fVar;
                this.f3277a |= 64;
                return this;
            }

            public C0044a b(p pVar) {
                if ((this.f3277a & 4) == 4 && this.f3280d != p.a()) {
                    pVar = p.a(this.f3280d).mergeFrom(pVar).buildPartial();
                }
                this.f3280d = pVar;
                this.f3277a |= 4;
                return this;
            }

            public C0044a b(v vVar) {
                if ((this.f3277a & 128) == 128 && this.f3285i != v.a()) {
                    vVar = v.a(this.f3285i).mergeFrom(vVar).buildPartial();
                }
                this.f3285i = vVar;
                this.f3277a |= 128;
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
                int i2 = this.f3277a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                hVar.f3271d = this.f3278b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                hVar.f3272e = this.f3279c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                hVar.f3273f = this.f3280d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                hVar.f3274g = this.f3281e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                hVar.f3275h = this.f3282f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                hVar.f3276i = this.f3283g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                hVar.j = this.f3284h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                hVar.k = this.f3285i;
                hVar.f3270c = i3;
                return hVar;
            }

            public boolean f() {
                return (this.f3277a & 4) == 4;
            }

            public p g() {
                return this.f3280d;
            }

            public boolean h() {
                return (this.f3277a & 8) == 8;
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
            f3269b = hVar;
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
                                this.f3270c |= 1;
                                this.f3271d = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (readTag == 58) {
                                    i2 = 4;
                                    p.C0048a builder = (this.f3270c & 4) == 4 ? this.f3273f.toBuilder() : null;
                                    p pVar = (p) codedInputStream.readMessage(p.f3335a, extensionRegistryLite);
                                    this.f3273f = pVar;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar);
                                        this.f3273f = builder.buildPartial();
                                    }
                                    i3 = this.f3270c;
                                } else if (readTag == 80) {
                                    this.f3270c |= 8;
                                    this.f3274g = codedInputStream.readInt64();
                                } else if (readTag == 96) {
                                    this.f3270c |= 16;
                                    this.f3275h = codedInputStream.readInt64();
                                } else if (readTag == 162) {
                                    i2 = 32;
                                    ac.C0040a builder2 = (this.f3270c & 32) == 32 ? this.f3276i.toBuilder() : null;
                                    ac acVar = (ac) codedInputStream.readMessage(ac.f3195a, extensionRegistryLite);
                                    this.f3276i = acVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(acVar);
                                        this.f3276i = builder2.buildPartial();
                                    }
                                    i3 = this.f3270c;
                                } else if (readTag == 170) {
                                    i2 = 64;
                                    f.C0043a builder3 = (this.f3270c & 64) == 64 ? this.j.toBuilder() : null;
                                    f fVar = (f) codedInputStream.readMessage(f.f3256a, extensionRegistryLite);
                                    this.j = fVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(fVar);
                                        this.j = builder3.buildPartial();
                                    }
                                    i3 = this.f3270c;
                                } else if (readTag == 178) {
                                    i2 = 128;
                                    v.C0051a builder4 = (this.f3270c & 128) == 128 ? this.k.toBuilder() : null;
                                    v vVar = (v) codedInputStream.readMessage(v.f3372a, extensionRegistryLite);
                                    this.k = vVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(vVar);
                                        this.k = builder4.buildPartial();
                                    }
                                    i3 = this.f3270c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3270c = i3 | i2;
                            } else {
                                this.f3270c |= 2;
                                this.f3272e = codedInputStream.readBytes();
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

        public static C0044a a(h hVar) {
            return t().mergeFrom(hVar);
        }

        public static h a() {
            return f3269b;
        }

        public static C0044a t() {
            return C0044a.k();
        }

        private void v() {
            this.f3271d = "";
            this.f3272e = "";
            this.f3273f = p.a();
            this.f3274g = 0L;
            this.f3275h = 0L;
            this.f3276i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f3269b;
        }

        public boolean c() {
            return (this.f3270c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3271d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3271d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3270c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3272e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3272e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3270c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            return f3268a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3270c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3270c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3270c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f3273f);
            }
            if ((this.f3270c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f3274g);
            }
            if ((this.f3270c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f3275h);
            }
            if ((this.f3270c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f3276i);
            }
            if ((this.f3270c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
            }
            if ((this.f3270c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
            }
            this.m = computeBytesSize;
            return computeBytesSize;
        }

        public p h() {
            return this.f3273f;
        }

        public boolean i() {
            return (this.f3270c & 8) == 8;
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
            return this.f3274g;
        }

        public boolean k() {
            return (this.f3270c & 16) == 16;
        }

        public long l() {
            return this.f3275h;
        }

        public boolean m() {
            return (this.f3270c & 32) == 32;
        }

        public ac n() {
            return this.f3276i;
        }

        public boolean o() {
            return (this.f3270c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3270c & 128) == 128;
        }

        public v r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0044a newBuilderForType() {
            return t();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0044a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3270c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3270c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3270c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f3273f);
            }
            if ((this.f3270c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.f3274g);
            }
            if ((this.f3270c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.f3275h);
            }
            if ((this.f3270c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.f3276i);
            }
            if ((this.f3270c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.f3270c & 128) == 128) {
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
        public static Parser<j> f3286a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final j f3287b;

        /* renamed from: c  reason: collision with root package name */
        public int f3288c;

        /* renamed from: d  reason: collision with root package name */
        public long f3289d;

        /* renamed from: e  reason: collision with root package name */
        public long f3290e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3291f;

        /* renamed from: g  reason: collision with root package name */
        public long f3292g;

        /* renamed from: h  reason: collision with root package name */
        public long f3293h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3294i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<j, C0045a> implements k {

            /* renamed from: a  reason: collision with root package name */
            public int f3295a;

            /* renamed from: b  reason: collision with root package name */
            public long f3296b;

            /* renamed from: c  reason: collision with root package name */
            public long f3297c;

            /* renamed from: e  reason: collision with root package name */
            public long f3299e;

            /* renamed from: f  reason: collision with root package name */
            public long f3300f;

            /* renamed from: h  reason: collision with root package name */
            public long f3302h;

            /* renamed from: d  reason: collision with root package name */
            public Object f3298d = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3301g = "";

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
                this.f3296b = 0L;
                int i2 = this.f3295a & (-2);
                this.f3295a = i2;
                this.f3297c = 0L;
                int i3 = i2 & (-3);
                this.f3295a = i3;
                this.f3298d = "";
                int i4 = i3 & (-5);
                this.f3295a = i4;
                this.f3299e = 0L;
                int i5 = i4 & (-9);
                this.f3295a = i5;
                this.f3300f = 0L;
                int i6 = i5 & (-17);
                this.f3295a = i6;
                this.f3301g = "";
                int i7 = i6 & (-33);
                this.f3295a = i7;
                this.f3302h = 0L;
                this.f3295a = i7 & (-65);
                return this;
            }

            public C0045a a(long j) {
                this.f3295a |= 1;
                this.f3296b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0045a mergeFrom(j jVar) {
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
                    this.f3295a |= 4;
                    this.f3298d = jVar.f3291f;
                }
                if (jVar.i()) {
                    c(jVar.j());
                }
                if (jVar.k()) {
                    d(jVar.l());
                }
                if (jVar.m()) {
                    this.f3295a |= 32;
                    this.f3301g = jVar.f3294i;
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
            public C0045a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                j jVar = null;
                try {
                    try {
                        j parsePartialFrom = j.f3286a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0045a a(String str) {
                if (str != null) {
                    this.f3295a |= 4;
                    this.f3298d = str;
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
                this.f3295a |= 2;
                this.f3297c = j;
                return this;
            }

            public C0045a b(String str) {
                if (str != null) {
                    this.f3295a |= 32;
                    this.f3301g = str;
                    return this;
                }
                throw null;
            }

            public C0045a c(long j) {
                this.f3295a |= 8;
                this.f3299e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0045a d(long j) {
                this.f3295a |= 16;
                this.f3300f = j;
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

            public C0045a e(long j) {
                this.f3295a |= 64;
                this.f3302h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i2 = this.f3295a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jVar.f3289d = this.f3296b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jVar.f3290e = this.f3297c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                jVar.f3291f = this.f3298d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                jVar.f3292g = this.f3299e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                jVar.f3293h = this.f3300f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                jVar.f3294i = this.f3301g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                jVar.j = this.f3302h;
                jVar.f3288c = i3;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            j jVar = new j();
            f3287b = jVar;
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
                                    this.f3288c |= 1;
                                    this.f3289d = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.f3288c |= 2;
                                    this.f3290e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3288c |= 4;
                                    this.f3291f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3288c |= 8;
                                    this.f3292g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f3288c |= 16;
                                    this.f3293h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f3288c |= 32;
                                    this.f3294i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f3288c |= 64;
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

        public static C0045a a(j jVar) {
            return q().mergeFrom(jVar);
        }

        public static j a() {
            return f3287b;
        }

        public static C0045a q() {
            return C0045a.h();
        }

        private void t() {
            this.f3289d = 0L;
            this.f3290e = 0L;
            this.f3291f = "";
            this.f3292g = 0L;
            this.f3293h = 0L;
            this.f3294i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            return f3287b;
        }

        public boolean c() {
            return (this.f3288c & 1) == 1;
        }

        public long d() {
            return this.f3289d;
        }

        public boolean e() {
            return (this.f3288c & 2) == 2;
        }

        public long f() {
            return this.f3290e;
        }

        public boolean g() {
            return (this.f3288c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f3286a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3288c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3289d) : 0;
            if ((this.f3288c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3290e);
            }
            if ((this.f3288c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3288c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3292g);
            }
            if ((this.f3288c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3293h);
            }
            if ((this.f3288c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3288c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString h() {
            Object obj = this.f3291f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3291f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3288c & 8) == 8;
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
            return this.f3292g;
        }

        public boolean k() {
            return (this.f3288c & 16) == 16;
        }

        public long l() {
            return this.f3293h;
        }

        public boolean m() {
            return (this.f3288c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3294i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3294i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3288c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0045a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0045a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3288c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3289d);
            }
            if ((this.f3288c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3290e);
            }
            if ((this.f3288c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3288c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3292g);
            }
            if ((this.f3288c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3293h);
            }
            if ((this.f3288c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3288c & 64) == 64) {
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
        public static Parser<l> f3303a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final l f3304b;

        /* renamed from: c  reason: collision with root package name */
        public int f3305c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3306d;

        /* renamed from: e  reason: collision with root package name */
        public long f3307e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3308f;

        /* renamed from: g  reason: collision with root package name */
        public long f3309g;

        /* renamed from: h  reason: collision with root package name */
        public byte f3310h;

        /* renamed from: i  reason: collision with root package name */
        public int f3311i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<l, C0046a> implements m {

            /* renamed from: a  reason: collision with root package name */
            public int f3312a;

            /* renamed from: c  reason: collision with root package name */
            public long f3314c;

            /* renamed from: e  reason: collision with root package name */
            public long f3316e;

            /* renamed from: b  reason: collision with root package name */
            public Object f3313b = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3315d = "";

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
                this.f3313b = "";
                int i2 = this.f3312a & (-2);
                this.f3312a = i2;
                this.f3314c = 0L;
                int i3 = i2 & (-3);
                this.f3312a = i3;
                this.f3315d = "";
                int i4 = i3 & (-5);
                this.f3312a = i4;
                this.f3316e = 0L;
                this.f3312a = i4 & (-9);
                return this;
            }

            public C0046a a(long j) {
                this.f3312a |= 2;
                this.f3314c = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0046a mergeFrom(l lVar) {
                if (lVar == l.a()) {
                    return this;
                }
                if (lVar.c()) {
                    this.f3312a |= 1;
                    this.f3313b = lVar.f3306d;
                }
                if (lVar.e()) {
                    a(lVar.f());
                }
                if (lVar.g()) {
                    this.f3312a |= 4;
                    this.f3315d = lVar.f3308f;
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
            public C0046a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                l lVar = null;
                try {
                    try {
                        l parsePartialFrom = l.f3303a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0046a a(String str) {
                if (str != null) {
                    this.f3312a |= 1;
                    this.f3313b = str;
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
                this.f3312a |= 8;
                this.f3316e = j;
                return this;
            }

            public C0046a b(String str) {
                if (str != null) {
                    this.f3312a |= 4;
                    this.f3315d = str;
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
                int i2 = this.f3312a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lVar.f3306d = this.f3313b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lVar.f3307e = this.f3314c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lVar.f3308f = this.f3315d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lVar.f3309g = this.f3316e;
                lVar.f3305c = i3;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            l lVar = new l();
            f3304b = lVar;
            lVar.n();
        }

        public l() {
            this.f3310h = (byte) -1;
            this.f3311i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3310h = (byte) -1;
            this.f3311i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3305c |= 1;
                                    this.f3306d = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.f3305c |= 2;
                                    this.f3307e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3305c |= 4;
                                    this.f3308f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3305c |= 8;
                                    this.f3309g = codedInputStream.readInt64();
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
            this.f3310h = (byte) -1;
            this.f3311i = -1;
        }

        public static C0046a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f3304b;
        }

        public static C0046a k() {
            return C0046a.h();
        }

        private void n() {
            this.f3306d = "";
            this.f3307e = 0L;
            this.f3308f = "";
            this.f3309g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            return f3304b;
        }

        public boolean c() {
            return (this.f3305c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3306d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3306d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3305c & 2) == 2;
        }

        public long f() {
            return this.f3307e;
        }

        public boolean g() {
            return (this.f3305c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f3303a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3311i;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3305c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3305c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3307e);
            }
            if ((this.f3305c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3305c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3309g);
            }
            this.f3311i = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3308f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3308f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3305c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3310h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3310h = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3309g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0046a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0046a newBuilderForType() {
            return k();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3305c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3305c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3307e);
            }
            if ((this.f3305c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3305c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3309g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f3317a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final n f3318b;

        /* renamed from: c  reason: collision with root package name */
        public int f3319c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3320d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3321e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3322f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3323g;

        /* renamed from: h  reason: collision with root package name */
        public long f3324h;

        /* renamed from: i  reason: collision with root package name */
        public long f3325i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<n, C0047a> implements o {

            /* renamed from: a  reason: collision with root package name */
            public int f3326a;

            /* renamed from: f  reason: collision with root package name */
            public long f3331f;

            /* renamed from: g  reason: collision with root package name */
            public long f3332g;

            /* renamed from: h  reason: collision with root package name */
            public long f3333h;
            public long j;

            /* renamed from: b  reason: collision with root package name */
            public Object f3327b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3328c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3329d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3330e = "";

            /* renamed from: i  reason: collision with root package name */
            public Object f3334i = "";

            public C0047a() {
                g();
            }

            private void g() {
            }

            public static C0047a h() {
                return new C0047a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0047a clear() {
                super.clear();
                this.f3327b = "";
                int i2 = this.f3326a & (-2);
                this.f3326a = i2;
                this.f3328c = "";
                int i3 = i2 & (-3);
                this.f3326a = i3;
                this.f3329d = "";
                int i4 = i3 & (-5);
                this.f3326a = i4;
                this.f3330e = "";
                int i5 = i4 & (-9);
                this.f3326a = i5;
                this.f3331f = 0L;
                int i6 = i5 & (-17);
                this.f3326a = i6;
                this.f3332g = 0L;
                int i7 = i6 & (-33);
                this.f3326a = i7;
                this.f3333h = 0L;
                int i8 = i7 & (-65);
                this.f3326a = i8;
                this.f3334i = "";
                int i9 = i8 & (-129);
                this.f3326a = i9;
                this.j = 0L;
                this.f3326a = i9 & (-257);
                return this;
            }

            public C0047a a(long j) {
                this.f3326a |= 16;
                this.f3331f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(n nVar) {
                if (nVar == n.a()) {
                    return this;
                }
                if (nVar.c()) {
                    this.f3326a |= 1;
                    this.f3327b = nVar.f3320d;
                }
                if (nVar.e()) {
                    this.f3326a |= 2;
                    this.f3328c = nVar.f3321e;
                }
                if (nVar.g()) {
                    this.f3326a |= 4;
                    this.f3329d = nVar.f3322f;
                }
                if (nVar.i()) {
                    this.f3326a |= 8;
                    this.f3330e = nVar.f3323g;
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
                    this.f3326a |= 128;
                    this.f3334i = nVar.k;
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
            public C0047a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                n nVar = null;
                try {
                    try {
                        n parsePartialFrom = n.f3317a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0047a a(String str) {
                if (str != null) {
                    this.f3326a |= 1;
                    this.f3327b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0047a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0047a b(long j) {
                this.f3326a |= 32;
                this.f3332g = j;
                return this;
            }

            public C0047a b(String str) {
                if (str != null) {
                    this.f3326a |= 2;
                    this.f3328c = str;
                    return this;
                }
                throw null;
            }

            public C0047a c(long j) {
                this.f3326a |= 64;
                this.f3333h = j;
                return this;
            }

            public C0047a c(String str) {
                if (str != null) {
                    this.f3326a |= 4;
                    this.f3329d = str;
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

            public C0047a d(long j) {
                this.f3326a |= 256;
                this.j = j;
                return this;
            }

            public C0047a d(String str) {
                if (str != null) {
                    this.f3326a |= 8;
                    this.f3330e = str;
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

            public C0047a e(String str) {
                if (str != null) {
                    this.f3326a |= 128;
                    this.f3334i = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i2 = this.f3326a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                nVar.f3320d = this.f3327b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                nVar.f3321e = this.f3328c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                nVar.f3322f = this.f3329d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                nVar.f3323g = this.f3330e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                nVar.f3324h = this.f3331f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                nVar.f3325i = this.f3332g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                nVar.j = this.f3333h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                nVar.k = this.f3334i;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                nVar.l = this.j;
                nVar.f3319c = i3;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            n nVar = new n();
            f3318b = nVar;
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
                                this.f3319c |= 1;
                                this.f3320d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3319c |= 2;
                                this.f3321e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f3319c |= 4;
                                this.f3322f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f3319c |= 8;
                                this.f3323g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f3319c |= 16;
                                this.f3324h = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.f3319c |= 32;
                                this.f3325i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3319c |= 64;
                                this.j = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.f3319c |= 128;
                                this.k = codedInputStream.readBytes();
                            } else if (readTag == 72) {
                                this.f3319c |= 256;
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

        public static C0047a a(n nVar) {
            return u().mergeFrom(nVar);
        }

        public static n a() {
            return f3318b;
        }

        public static C0047a u() {
            return C0047a.h();
        }

        private void x() {
            this.f3320d = "";
            this.f3321e = "";
            this.f3322f = "";
            this.f3323g = "";
            this.f3324h = 0L;
            this.f3325i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f3318b;
        }

        public boolean c() {
            return (this.f3319c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3320d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3320d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3319c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3321e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3321e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3319c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            return f3317a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3319c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3319c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3319c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3319c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3319c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3324h);
            }
            if ((this.f3319c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f3325i);
            }
            if ((this.f3319c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            if ((this.f3319c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
            }
            if ((this.f3319c & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
            }
            this.n = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3322f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3322f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3319c & 8) == 8;
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
            Object obj = this.f3323g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3323g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3319c & 16) == 16;
        }

        public long l() {
            return this.f3324h;
        }

        public boolean m() {
            return (this.f3319c & 32) == 32;
        }

        public long n() {
            return this.f3325i;
        }

        public boolean o() {
            return (this.f3319c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3319c & 128) == 128;
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
            return (this.f3319c & 256) == 256;
        }

        public long t() {
            return this.l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C0047a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C0047a newBuilderForType() {
            return u();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3319c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3319c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3319c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3319c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3319c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3324h);
            }
            if ((this.f3319c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3325i);
            }
            if ((this.f3319c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.f3319c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.f3319c & 256) == 256) {
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
        public static Parser<p> f3335a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final p f3336b;

        /* renamed from: c  reason: collision with root package name */
        public int f3337c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3338d;

        /* renamed from: e  reason: collision with root package name */
        public byte f3339e;

        /* renamed from: f  reason: collision with root package name */
        public int f3340f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<p, C0048a> implements q {

            /* renamed from: a  reason: collision with root package name */
            public int f3341a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3342b = "";

            public C0048a() {
                h();
            }

            private void h() {
            }

            public static C0048a i() {
                return new C0048a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0048a clear() {
                super.clear();
                this.f3342b = "";
                this.f3341a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0048a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f3341a |= 1;
                    this.f3342b = pVar.f3338d;
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
                p pVar = null;
                try {
                    try {
                        p parsePartialFrom = p.f3335a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0048a a(String str) {
                if (str != null) {
                    this.f3341a |= 1;
                    this.f3342b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0048a clone() {
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
                int i2 = (this.f3341a & 1) != 1 ? 0 : 1;
                pVar.f3338d = this.f3342b;
                pVar.f3337c = i2;
                return pVar;
            }

            public boolean f() {
                return (this.f3341a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            p pVar = new p();
            f3336b = pVar;
            pVar.h();
        }

        public p() {
            this.f3339e = (byte) -1;
            this.f3340f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3339e = (byte) -1;
            this.f3340f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 34) {
                                this.f3337c |= 1;
                                this.f3338d = codedInputStream.readBytes();
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
            this.f3339e = (byte) -1;
            this.f3340f = -1;
        }

        public static C0048a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f3336b;
        }

        public static C0048a e() {
            return C0048a.i();
        }

        private void h() {
            this.f3338d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f3336b;
        }

        public boolean c() {
            return (this.f3337c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3338d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3338d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C0048a newBuilderForType() {
            return e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C0048a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            return f3335a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3340f;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3337c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
            this.f3340f = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3339e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.f3339e = (byte) 1;
                return true;
            } else {
                this.f3339e = (byte) 0;
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
            if ((this.f3337c & 1) == 1) {
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
        public static Parser<r> f3343a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final r f3344b;

        /* renamed from: c  reason: collision with root package name */
        public int f3345c;

        /* renamed from: d  reason: collision with root package name */
        public int f3346d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3347e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3348f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3349g;

        /* renamed from: h  reason: collision with root package name */
        public int f3350h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<r, C0049a> implements s {

            /* renamed from: a  reason: collision with root package name */
            public int f3351a;

            /* renamed from: b  reason: collision with root package name */
            public int f3352b = 7399;

            /* renamed from: c  reason: collision with root package name */
            public Object f3353c = "push_im_client";

            /* renamed from: d  reason: collision with root package name */
            public Object f3354d = "phonebaidu";

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
                this.f3352b = 7399;
                int i2 = this.f3351a & (-2);
                this.f3351a = i2;
                this.f3353c = "push_im_client";
                int i3 = i2 & (-3);
                this.f3351a = i3;
                this.f3354d = "phonebaidu";
                this.f3351a = i3 & (-5);
                return this;
            }

            public C0049a a(int i2) {
                this.f3351a |= 1;
                this.f3352b = i2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0049a mergeFrom(r rVar) {
                if (rVar == r.a()) {
                    return this;
                }
                if (rVar.c()) {
                    a(rVar.d());
                }
                if (rVar.e()) {
                    this.f3351a |= 2;
                    this.f3353c = rVar.f3347e;
                }
                if (rVar.g()) {
                    this.f3351a |= 4;
                    this.f3354d = rVar.f3348f;
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
                r rVar = null;
                try {
                    try {
                        r parsePartialFrom = r.f3343a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0049a clone() {
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
                int i2 = this.f3351a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                rVar.f3346d = this.f3352b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                rVar.f3347e = this.f3353c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                rVar.f3348f = this.f3354d;
                rVar.f3345c = i3;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            r rVar = new r();
            f3344b = rVar;
            rVar.l();
        }

        public r() {
            this.f3349g = (byte) -1;
            this.f3350h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3349g = (byte) -1;
            this.f3350h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3345c |= 1;
                                    this.f3346d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3345c |= 2;
                                    this.f3347e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3345c |= 4;
                                    this.f3348f = codedInputStream.readBytes();
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
            this.f3349g = (byte) -1;
            this.f3350h = -1;
        }

        public static C0049a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f3344b;
        }

        public static C0049a i() {
            return C0049a.h();
        }

        private void l() {
            this.f3346d = 7399;
            this.f3347e = "push_im_client";
            this.f3348f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f3344b;
        }

        public boolean c() {
            return (this.f3345c & 1) == 1;
        }

        public int d() {
            return this.f3346d;
        }

        public boolean e() {
            return (this.f3345c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3347e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3347e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3345c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            return f3343a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3350h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3345c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3346d) : 0;
            if ((this.f3345c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3345c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3350h = computeInt32Size;
            return computeInt32Size;
        }

        public ByteString h() {
            Object obj = this.f3348f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3348f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3349g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3349g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0049a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0049a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3345c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3346d);
            }
            if ((this.f3345c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3345c & 4) == 4) {
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
        public static Parser<t> f3355a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final t f3356b;

        /* renamed from: c  reason: collision with root package name */
        public int f3357c;

        /* renamed from: d  reason: collision with root package name */
        public long f3358d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3359e;

        /* renamed from: f  reason: collision with root package name */
        public long f3360f;

        /* renamed from: g  reason: collision with root package name */
        public long f3361g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3362h;

        /* renamed from: i  reason: collision with root package name */
        public long f3363i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<t, C0050a> implements u {

            /* renamed from: a  reason: collision with root package name */
            public int f3364a;

            /* renamed from: b  reason: collision with root package name */
            public long f3365b;

            /* renamed from: d  reason: collision with root package name */
            public long f3367d;

            /* renamed from: e  reason: collision with root package name */
            public long f3368e;

            /* renamed from: g  reason: collision with root package name */
            public long f3370g;

            /* renamed from: h  reason: collision with root package name */
            public long f3371h;

            /* renamed from: c  reason: collision with root package name */
            public Object f3366c = "";

            /* renamed from: f  reason: collision with root package name */
            public Object f3369f = "";

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
                this.f3365b = 0L;
                int i2 = this.f3364a & (-2);
                this.f3364a = i2;
                this.f3366c = "";
                int i3 = i2 & (-3);
                this.f3364a = i3;
                this.f3367d = 0L;
                int i4 = i3 & (-5);
                this.f3364a = i4;
                this.f3368e = 0L;
                int i5 = i4 & (-9);
                this.f3364a = i5;
                this.f3369f = "";
                int i6 = i5 & (-17);
                this.f3364a = i6;
                this.f3370g = 0L;
                int i7 = i6 & (-33);
                this.f3364a = i7;
                this.f3371h = 0L;
                this.f3364a = i7 & (-65);
                return this;
            }

            public C0050a a(long j) {
                this.f3364a |= 1;
                this.f3365b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0050a mergeFrom(t tVar) {
                if (tVar == t.a()) {
                    return this;
                }
                if (tVar.c()) {
                    a(tVar.d());
                }
                if (tVar.e()) {
                    this.f3364a |= 2;
                    this.f3366c = tVar.f3359e;
                }
                if (tVar.g()) {
                    b(tVar.h());
                }
                if (tVar.i()) {
                    c(tVar.j());
                }
                if (tVar.k()) {
                    this.f3364a |= 16;
                    this.f3369f = tVar.f3362h;
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
            public C0050a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t tVar = null;
                try {
                    try {
                        t parsePartialFrom = t.f3355a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0050a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0050a b(long j) {
                this.f3364a |= 4;
                this.f3367d = j;
                return this;
            }

            public C0050a c(long j) {
                this.f3364a |= 8;
                this.f3368e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0050a d(long j) {
                this.f3364a |= 32;
                this.f3370g = j;
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

            public C0050a e(long j) {
                this.f3364a |= 64;
                this.f3371h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i2 = this.f3364a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                tVar.f3358d = this.f3365b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                tVar.f3359e = this.f3366c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                tVar.f3360f = this.f3367d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                tVar.f3361g = this.f3368e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                tVar.f3362h = this.f3369f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                tVar.f3363i = this.f3370g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                tVar.j = this.f3371h;
                tVar.f3357c = i3;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            t tVar = new t();
            f3356b = tVar;
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
                                this.f3357c |= 1;
                                this.f3358d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3357c |= 2;
                                this.f3359e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3357c |= 4;
                                this.f3360f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3357c |= 8;
                                this.f3361g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3357c |= 16;
                                this.f3362h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f3357c |= 32;
                                this.f3363i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3357c |= 64;
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

        public static C0050a a(t tVar) {
            return q().mergeFrom(tVar);
        }

        public static t a() {
            return f3356b;
        }

        public static C0050a q() {
            return C0050a.h();
        }

        private void t() {
            this.f3358d = 0L;
            this.f3359e = "";
            this.f3360f = 0L;
            this.f3361g = 0L;
            this.f3362h = "";
            this.f3363i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f3356b;
        }

        public boolean c() {
            return (this.f3357c & 1) == 1;
        }

        public long d() {
            return this.f3358d;
        }

        public boolean e() {
            return (this.f3357c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3359e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3359e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3357c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            return f3355a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3357c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3358d) : 0;
            if ((this.f3357c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3357c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3360f);
            }
            if ((this.f3357c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3361g);
            }
            if ((this.f3357c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3357c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f3363i);
            }
            if ((this.f3357c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public long h() {
            return this.f3360f;
        }

        public boolean i() {
            return (this.f3357c & 8) == 8;
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
            return this.f3361g;
        }

        public boolean k() {
            return (this.f3357c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3362h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3362h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3357c & 32) == 32;
        }

        public long n() {
            return this.f3363i;
        }

        public boolean o() {
            return (this.f3357c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0050a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0050a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3357c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3358d);
            }
            if ((this.f3357c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3357c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3360f);
            }
            if ((this.f3357c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3361g);
            }
            if ((this.f3357c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3357c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3363i);
            }
            if ((this.f3357c & 64) == 64) {
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
        public static Parser<v> f3372a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final v f3373b;

        /* renamed from: c  reason: collision with root package name */
        public int f3374c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3375d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3376e;

        /* renamed from: f  reason: collision with root package name */
        public byte f3377f;

        /* renamed from: g  reason: collision with root package name */
        public int f3378g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0051a extends GeneratedMessageLite.Builder<v, C0051a> implements w {

            /* renamed from: a  reason: collision with root package name */
            public int f3379a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3380b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3381c = "";

            public C0051a() {
                g();
            }

            private void g() {
            }

            public static C0051a h() {
                return new C0051a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0051a clear() {
                super.clear();
                this.f3380b = "";
                int i2 = this.f3379a & (-2);
                this.f3379a = i2;
                this.f3381c = "";
                this.f3379a = i2 & (-3);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0051a mergeFrom(v vVar) {
                if (vVar == v.a()) {
                    return this;
                }
                if (vVar.c()) {
                    this.f3379a |= 1;
                    this.f3380b = vVar.f3375d;
                }
                if (vVar.e()) {
                    this.f3379a |= 2;
                    this.f3381c = vVar.f3376e;
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
                v vVar = null;
                try {
                    try {
                        v parsePartialFrom = v.f3372a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0051a a(String str) {
                if (str != null) {
                    this.f3379a |= 1;
                    this.f3380b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0051a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0051a b(String str) {
                if (str != null) {
                    this.f3379a |= 2;
                    this.f3381c = str;
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
                int i2 = this.f3379a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                vVar.f3375d = this.f3380b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                vVar.f3376e = this.f3381c;
                vVar.f3374c = i3;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            v vVar = new v();
            f3373b = vVar;
            vVar.j();
        }

        public v() {
            this.f3377f = (byte) -1;
            this.f3378g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3377f = (byte) -1;
            this.f3378g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3374c |= 1;
                                this.f3375d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3374c |= 2;
                                this.f3376e = codedInputStream.readBytes();
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
            this.f3377f = (byte) -1;
            this.f3378g = -1;
        }

        public static C0051a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f3373b;
        }

        public static C0051a g() {
            return C0051a.h();
        }

        private void j() {
            this.f3375d = "";
            this.f3376e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f3373b;
        }

        public boolean c() {
            return (this.f3374c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3375d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3375d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3374c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3376e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3376e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f3372a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3378g;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3374c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3374c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            this.f3378g = computeBytesSize;
            return computeBytesSize;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C0051a newBuilderForType() {
            return g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C0051a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3377f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3377f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3374c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3374c & 2) == 2) {
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
        public final int f3387e;

        x(int i2) {
            this.f3387e = i2;
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
            return this.f3387e;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f3388a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final y f3389b;

        /* renamed from: c  reason: collision with root package name */
        public int f3390c;

        /* renamed from: d  reason: collision with root package name */
        public r f3391d;

        /* renamed from: e  reason: collision with root package name */
        public h f3392e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3393f;

        /* renamed from: g  reason: collision with root package name */
        public long f3394g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f3395h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3396i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0052a extends GeneratedMessageLite.Builder<y, C0052a> implements z {

            /* renamed from: a  reason: collision with root package name */
            public int f3397a;

            /* renamed from: e  reason: collision with root package name */
            public long f3401e;

            /* renamed from: b  reason: collision with root package name */
            public r f3398b = r.a();

            /* renamed from: c  reason: collision with root package name */
            public h f3399c = h.a();

            /* renamed from: d  reason: collision with root package name */
            public Object f3400d = "";

            /* renamed from: f  reason: collision with root package name */
            public List<c> f3402f = Collections.emptyList();

            public C0052a() {
                i();
            }

            private void i() {
            }

            public static C0052a j() {
                return new C0052a();
            }

            private void k() {
                if ((this.f3397a & 16) != 16) {
                    this.f3402f = new ArrayList(this.f3402f);
                    this.f3397a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0052a clear() {
                super.clear();
                this.f3398b = r.a();
                this.f3397a &= -2;
                this.f3399c = h.a();
                int i2 = this.f3397a & (-3);
                this.f3397a = i2;
                this.f3400d = "";
                int i3 = i2 & (-5);
                this.f3397a = i3;
                this.f3401e = 0L;
                this.f3397a = i3 & (-9);
                this.f3402f = Collections.emptyList();
                this.f3397a &= -17;
                return this;
            }

            public C0052a a(long j) {
                this.f3397a |= 8;
                this.f3401e = j;
                return this;
            }

            public C0052a a(h hVar) {
                if (hVar != null) {
                    this.f3399c = hVar;
                    this.f3397a |= 2;
                    return this;
                }
                throw null;
            }

            public C0052a a(r rVar) {
                if ((this.f3397a & 1) == 1 && this.f3398b != r.a()) {
                    rVar = r.a(this.f3398b).mergeFrom(rVar).buildPartial();
                }
                this.f3398b = rVar;
                this.f3397a |= 1;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0052a mergeFrom(y yVar) {
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
                    this.f3397a |= 4;
                    this.f3400d = yVar.f3393f;
                }
                if (yVar.i()) {
                    a(yVar.j());
                }
                if (!yVar.f3395h.isEmpty()) {
                    if (this.f3402f.isEmpty()) {
                        this.f3402f = yVar.f3395h;
                        this.f3397a &= -17;
                    } else {
                        k();
                        this.f3402f.addAll(yVar.f3395h);
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
            public C0052a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                y yVar = null;
                try {
                    try {
                        y parsePartialFrom = y.f3388a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0052a a(Iterable<? extends c> iterable) {
                k();
                AbstractMessageLite.Builder.addAll(iterable, this.f3402f);
                return this;
            }

            public C0052a a(String str) {
                if (str != null) {
                    this.f3397a |= 4;
                    this.f3400d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0052a clone() {
                return j().mergeFrom(buildPartial());
            }

            public C0052a b(h hVar) {
                if ((this.f3397a & 2) == 2 && this.f3399c != h.a()) {
                    hVar = h.a(this.f3399c).mergeFrom(hVar).buildPartial();
                }
                this.f3399c = hVar;
                this.f3397a |= 2;
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
                int i2 = this.f3397a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                yVar.f3391d = this.f3398b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                yVar.f3392e = this.f3399c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                yVar.f3393f = this.f3400d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                yVar.f3394g = this.f3401e;
                if ((this.f3397a & 16) == 16) {
                    this.f3402f = Collections.unmodifiableList(this.f3402f);
                    this.f3397a &= -17;
                }
                yVar.f3395h = this.f3402f;
                yVar.f3390c = i3;
                return yVar;
            }

            public boolean f() {
                return (this.f3397a & 2) == 2;
            }

            public h g() {
                return this.f3399c;
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
            f3389b = yVar;
            yVar.n();
        }

        public y() {
            this.f3396i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            this.f3396i = (byte) -1;
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
                                r.C0049a builder = (this.f3390c & 1) == 1 ? this.f3391d.toBuilder() : null;
                                r rVar = (r) codedInputStream.readMessage(r.f3343a, extensionRegistryLite);
                                this.f3391d = rVar;
                                if (builder != null) {
                                    builder.mergeFrom(rVar);
                                    this.f3391d = builder.buildPartial();
                                }
                                i2 = this.f3390c;
                            } else if (readTag == 330) {
                                i3 = 2;
                                h.C0044a builder2 = (this.f3390c & 2) == 2 ? this.f3392e.toBuilder() : null;
                                h hVar = (h) codedInputStream.readMessage(h.f3268a, extensionRegistryLite);
                                this.f3392e = hVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hVar);
                                    this.f3392e = builder2.buildPartial();
                                }
                                i2 = this.f3390c;
                            } else if (readTag == 1042) {
                                this.f3390c |= 4;
                                this.f3393f = codedInputStream.readBytes();
                            } else if (readTag == 1048) {
                                this.f3390c |= 8;
                                this.f3394g = codedInputStream.readInt64();
                            } else if (readTag == 1058) {
                                if (!(z2 & true)) {
                                    this.f3395h = new ArrayList();
                                    z2 |= true;
                                }
                                this.f3395h.add(codedInputStream.readMessage(c.f3229a, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                            this.f3390c = i2 | i3;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f3395h = Collections.unmodifiableList(this.f3395h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3396i = (byte) -1;
            this.j = -1;
        }

        public static C0052a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f3389b;
        }

        public static C0052a k() {
            return C0052a.j();
        }

        private void n() {
            this.f3391d = r.a();
            this.f3392e = h.a();
            this.f3393f = "";
            this.f3394g = 0L;
            this.f3395h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f3389b;
        }

        public boolean c() {
            return (this.f3390c & 1) == 1;
        }

        public r d() {
            return this.f3391d;
        }

        public boolean e() {
            return (this.f3390c & 2) == 2;
        }

        public h f() {
            return this.f3392e;
        }

        public boolean g() {
            return (this.f3390c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f3388a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.f3390c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f3391d) + 0 : 0;
            if ((this.f3390c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f3392e);
            }
            if ((this.f3390c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3390c & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3394g);
            }
            for (int i3 = 0; i3 < this.f3395h.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f3395h.get(i3));
            }
            this.j = computeMessageSize;
            return computeMessageSize;
        }

        public ByteString h() {
            Object obj = this.f3393f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3393f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3390c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3396i;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!e()) {
                this.f3396i = (byte) 0;
                return false;
            } else if (f().isInitialized()) {
                this.f3396i = (byte) 1;
                return true;
            } else {
                this.f3396i = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.f3394g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0052a newBuilderForType() {
            return k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0052a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3390c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.f3391d);
            }
            if ((this.f3390c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f3392e);
            }
            if ((this.f3390c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3390c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3394g);
            }
            for (int i2 = 0; i2 < this.f3395h.size(); i2++) {
                codedOutputStream.writeMessage(132, this.f3395h.get(i2));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
