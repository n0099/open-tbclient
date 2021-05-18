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
    public static final class C0035a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0035a> f3141a = new AbstractParser<C0035a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0035a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0035a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0035a f3142b;

        /* renamed from: c  reason: collision with root package name */
        public int f3143c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3144d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3145e;

        /* renamed from: f  reason: collision with root package name */
        public long f3146f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3147g;

        /* renamed from: h  reason: collision with root package name */
        public long f3148h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3149i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0036a extends GeneratedMessageLite.Builder<C0035a, C0036a> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3150a;

            /* renamed from: d  reason: collision with root package name */
            public long f3153d;

            /* renamed from: f  reason: collision with root package name */
            public long f3155f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3151b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3152c = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3154e = "";

            public C0036a() {
                g();
            }

            private void g() {
            }

            public static C0036a h() {
                return new C0036a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0036a clear() {
                super.clear();
                this.f3151b = "";
                int i2 = this.f3150a & (-2);
                this.f3150a = i2;
                this.f3152c = "";
                int i3 = i2 & (-3);
                this.f3150a = i3;
                this.f3153d = 0L;
                int i4 = i3 & (-5);
                this.f3150a = i4;
                this.f3154e = "";
                int i5 = i4 & (-9);
                this.f3150a = i5;
                this.f3155f = 0L;
                this.f3150a = i5 & (-17);
                return this;
            }

            public C0036a a(long j) {
                this.f3150a |= 4;
                this.f3153d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0036a mergeFrom(C0035a c0035a) {
                if (c0035a == C0035a.a()) {
                    return this;
                }
                if (c0035a.c()) {
                    this.f3150a |= 1;
                    this.f3151b = c0035a.f3144d;
                }
                if (c0035a.e()) {
                    this.f3150a |= 2;
                    this.f3152c = c0035a.f3145e;
                }
                if (c0035a.g()) {
                    a(c0035a.h());
                }
                if (c0035a.i()) {
                    this.f3150a |= 8;
                    this.f3154e = c0035a.f3147g;
                }
                if (c0035a.k()) {
                    b(c0035a.l());
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
            public C0036a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                C0035a c0035a = null;
                try {
                    try {
                        C0035a parsePartialFrom = C0035a.f3141a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        C0035a c0035a2 = (C0035a) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0035a = c0035a2;
                            if (c0035a != null) {
                                mergeFrom(c0035a);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0035a != null) {
                    }
                    throw th;
                }
            }

            public C0036a a(String str) {
                if (str != null) {
                    this.f3150a |= 1;
                    this.f3151b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0036a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0036a b(long j) {
                this.f3150a |= 16;
                this.f3155f = j;
                return this;
            }

            public C0036a b(String str) {
                if (str != null) {
                    this.f3150a |= 2;
                    return this;
                }
                throw null;
            }

            public C0036a c(String str) {
                if (str != null) {
                    this.f3150a |= 8;
                    this.f3154e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0035a getDefaultInstanceForType() {
                return C0035a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0035a build() {
                C0035a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0035a buildPartial() {
                C0035a c0035a = new C0035a(this);
                int i2 = this.f3150a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0035a.f3144d = this.f3151b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0035a.f3145e = this.f3152c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0035a.f3146f = this.f3153d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0035a.f3147g = this.f3154e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0035a.f3148h = this.f3155f;
                c0035a.f3143c = i3;
                return c0035a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0035a c0035a = new C0035a();
            f3142b = c0035a;
            c0035a.p();
        }

        public C0035a() {
            this.f3149i = (byte) -1;
            this.j = -1;
        }

        public C0035a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3149i = (byte) -1;
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
                                    this.f3143c |= 1;
                                    this.f3144d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3143c |= 2;
                                    this.f3145e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3143c |= 4;
                                    this.f3146f = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.f3143c |= 8;
                                    this.f3147g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3143c |= 16;
                                    this.f3148h = codedInputStream.readInt64();
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

        public C0035a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3149i = (byte) -1;
            this.j = -1;
        }

        public static C0036a a(C0035a c0035a) {
            return m().mergeFrom(c0035a);
        }

        public static C0035a a() {
            return f3142b;
        }

        public static C0036a m() {
            return C0036a.h();
        }

        private void p() {
            this.f3144d = "";
            this.f3145e = "";
            this.f3146f = 0L;
            this.f3147g = "";
            this.f3148h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0035a getDefaultInstanceForType() {
            return f3142b;
        }

        public boolean c() {
            return (this.f3143c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3144d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3144d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3143c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3145e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3145e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3143c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0035a> getParserForType() {
            return f3141a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3143c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3143c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3143c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3146f);
            }
            if ((this.f3143c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3143c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3148h);
            }
            this.j = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3146f;
        }

        public boolean i() {
            return (this.f3143c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3149i;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3149i = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3147g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3147g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3143c & 16) == 16;
        }

        public long l() {
            return this.f3148h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C0036a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C0036a newBuilderForType() {
            return m();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3143c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3143c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3143c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3146f);
            }
            if ((this.f3143c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3143c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3148h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f3156a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final aa f3157b;

        /* renamed from: c  reason: collision with root package name */
        public int f3158c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3159d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3160e;

        /* renamed from: f  reason: collision with root package name */
        public long f3161f;

        /* renamed from: g  reason: collision with root package name */
        public long f3162g;

        /* renamed from: h  reason: collision with root package name */
        public long f3163h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3164i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0037a extends GeneratedMessageLite.Builder<aa, C0037a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            public int f3165a;

            /* renamed from: d  reason: collision with root package name */
            public long f3168d;

            /* renamed from: e  reason: collision with root package name */
            public long f3169e;

            /* renamed from: f  reason: collision with root package name */
            public long f3170f;

            /* renamed from: h  reason: collision with root package name */
            public long f3172h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3166b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3167c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3171g = "";

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
                this.f3166b = "";
                int i2 = this.f3165a & (-2);
                this.f3165a = i2;
                this.f3167c = "";
                int i3 = i2 & (-3);
                this.f3165a = i3;
                this.f3168d = 0L;
                int i4 = i3 & (-5);
                this.f3165a = i4;
                this.f3169e = 0L;
                int i5 = i4 & (-9);
                this.f3165a = i5;
                this.f3170f = 0L;
                int i6 = i5 & (-17);
                this.f3165a = i6;
                this.f3171g = "";
                int i7 = i6 & (-33);
                this.f3165a = i7;
                this.f3172h = 0L;
                this.f3165a = i7 & (-65);
                return this;
            }

            public C0037a a(long j) {
                this.f3165a |= 4;
                this.f3168d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0037a mergeFrom(aa aaVar) {
                if (aaVar == aa.a()) {
                    return this;
                }
                if (aaVar.c()) {
                    this.f3165a |= 1;
                    this.f3166b = aaVar.f3159d;
                }
                if (aaVar.e()) {
                    this.f3165a |= 2;
                    this.f3167c = aaVar.f3160e;
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
                    this.f3165a |= 32;
                    this.f3171g = aaVar.f3164i;
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
            public C0037a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                aa aaVar = null;
                try {
                    try {
                        aa parsePartialFrom = aa.f3156a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0037a a(String str) {
                if (str != null) {
                    this.f3165a |= 1;
                    this.f3166b = str;
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
                this.f3165a |= 8;
                this.f3169e = j;
                return this;
            }

            public C0037a b(String str) {
                if (str != null) {
                    this.f3165a |= 2;
                    this.f3167c = str;
                    return this;
                }
                throw null;
            }

            public C0037a c(long j) {
                this.f3165a |= 16;
                this.f3170f = j;
                return this;
            }

            public C0037a c(String str) {
                if (str != null) {
                    this.f3165a |= 32;
                    this.f3171g = str;
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

            public C0037a d(long j) {
                this.f3165a |= 64;
                this.f3172h = j;
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
                int i2 = this.f3165a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aaVar.f3159d = this.f3166b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aaVar.f3160e = this.f3167c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aaVar.f3161f = this.f3168d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aaVar.f3162g = this.f3169e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aaVar.f3163h = this.f3170f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aaVar.f3164i = this.f3171g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aaVar.j = this.f3172h;
                aaVar.f3158c = i3;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            aa aaVar = new aa();
            f3157b = aaVar;
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
                                this.f3158c |= 1;
                                this.f3159d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3158c |= 2;
                                this.f3160e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3158c |= 4;
                                this.f3161f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3158c |= 8;
                                this.f3162g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3158c |= 16;
                                this.f3163h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3158c |= 32;
                                this.f3164i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3158c |= 64;
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

        public static C0037a a(aa aaVar) {
            return q().mergeFrom(aaVar);
        }

        public static aa a() {
            return f3157b;
        }

        public static C0037a q() {
            return C0037a.h();
        }

        private void t() {
            this.f3159d = "";
            this.f3160e = "";
            this.f3161f = 0L;
            this.f3162g = 0L;
            this.f3163h = 0L;
            this.f3164i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f3157b;
        }

        public boolean c() {
            return (this.f3158c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3159d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3159d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3158c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3160e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3160e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3158c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            return f3156a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3158c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3158c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3158c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3161f);
            }
            if ((this.f3158c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3162g);
            }
            if ((this.f3158c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3163h);
            }
            if ((this.f3158c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3158c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3161f;
        }

        public boolean i() {
            return (this.f3158c & 8) == 8;
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
            return this.f3162g;
        }

        public boolean k() {
            return (this.f3158c & 16) == 16;
        }

        public long l() {
            return this.f3163h;
        }

        public boolean m() {
            return (this.f3158c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3164i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3164i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3158c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0037a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0037a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3158c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3158c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3158c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3161f);
            }
            if ((this.f3158c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3162g);
            }
            if ((this.f3158c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3163h);
            }
            if ((this.f3158c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3158c & 64) == 64) {
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
        public static Parser<ac> f3173a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ac f3174b;

        /* renamed from: c  reason: collision with root package name */
        public int f3175c;

        /* renamed from: d  reason: collision with root package name */
        public x f3176d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3177e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3178f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3179g;

        /* renamed from: h  reason: collision with root package name */
        public int f3180h;

        /* renamed from: i  reason: collision with root package name */
        public int f3181i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0038a extends GeneratedMessageLite.Builder<ac, C0038a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            public int f3182a;

            /* renamed from: b  reason: collision with root package name */
            public x f3183b = x.OS_TYPE_UNKNWON;

            /* renamed from: c  reason: collision with root package name */
            public Object f3184c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3185d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3186e = "";

            /* renamed from: f  reason: collision with root package name */
            public int f3187f;

            /* renamed from: g  reason: collision with root package name */
            public int f3188g;

            /* renamed from: h  reason: collision with root package name */
            public int f3189h;

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
                this.f3183b = x.OS_TYPE_UNKNWON;
                int i2 = this.f3182a & (-2);
                this.f3182a = i2;
                this.f3184c = "";
                int i3 = i2 & (-3);
                this.f3182a = i3;
                this.f3185d = "";
                int i4 = i3 & (-5);
                this.f3182a = i4;
                this.f3186e = "";
                int i5 = i4 & (-9);
                this.f3182a = i5;
                this.f3187f = 0;
                int i6 = i5 & (-17);
                this.f3182a = i6;
                this.f3188g = 0;
                int i7 = i6 & (-33);
                this.f3182a = i7;
                this.f3189h = 0;
                this.f3182a = i7 & (-65);
                return this;
            }

            public C0038a a(int i2) {
                this.f3182a |= 16;
                this.f3187f = i2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0038a mergeFrom(ac acVar) {
                if (acVar == ac.a()) {
                    return this;
                }
                if (acVar.c()) {
                    a(acVar.d());
                }
                if (acVar.e()) {
                    this.f3182a |= 2;
                    this.f3184c = acVar.f3177e;
                }
                if (acVar.g()) {
                    this.f3182a |= 4;
                    this.f3185d = acVar.f3178f;
                }
                if (acVar.i()) {
                    this.f3182a |= 8;
                    this.f3186e = acVar.f3179g;
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

            public C0038a a(x xVar) {
                if (xVar != null) {
                    this.f3182a |= 1;
                    this.f3183b = xVar;
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
            public C0038a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ac acVar = null;
                try {
                    try {
                        ac parsePartialFrom = ac.f3173a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0038a a(String str) {
                if (str != null) {
                    this.f3182a |= 2;
                    this.f3184c = str;
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

            public C0038a b(int i2) {
                this.f3182a |= 32;
                this.f3188g = i2;
                return this;
            }

            public C0038a b(String str) {
                if (str != null) {
                    this.f3182a |= 4;
                    this.f3185d = str;
                    return this;
                }
                throw null;
            }

            public C0038a c(int i2) {
                this.f3182a |= 64;
                this.f3189h = i2;
                return this;
            }

            public C0038a c(String str) {
                if (str != null) {
                    this.f3182a |= 8;
                    this.f3186e = str;
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
                int i2 = this.f3182a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                acVar.f3176d = this.f3183b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                acVar.f3177e = this.f3184c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                acVar.f3178f = this.f3185d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                acVar.f3179g = this.f3186e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                acVar.f3180h = this.f3187f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                acVar.f3181i = this.f3188g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                acVar.j = this.f3189h;
                acVar.f3175c = i3;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ac acVar = new ac();
            f3174b = acVar;
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
                                        this.f3175c = 1 | this.f3175c;
                                        this.f3176d = a2;
                                    }
                                } else if (readTag == 18) {
                                    this.f3175c |= 2;
                                    this.f3177e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3175c |= 4;
                                    this.f3178f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f3175c |= 8;
                                    this.f3179g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3175c |= 16;
                                    this.f3180h = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.f3175c |= 32;
                                    this.f3181i = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.f3175c |= 64;
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

        public static C0038a a(ac acVar) {
            return q().mergeFrom(acVar);
        }

        public static ac a() {
            return f3174b;
        }

        public static C0038a q() {
            return C0038a.h();
        }

        private void t() {
            this.f3176d = x.OS_TYPE_UNKNWON;
            this.f3177e = "";
            this.f3178f = "";
            this.f3179g = "";
            this.f3180h = 0;
            this.f3181i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f3174b;
        }

        public boolean c() {
            return (this.f3175c & 1) == 1;
        }

        public x d() {
            return this.f3176d;
        }

        public boolean e() {
            return (this.f3175c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3177e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3177e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3175c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            return f3173a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3175c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3176d.getNumber()) : 0;
            if ((this.f3175c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3175c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3175c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3175c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f3180h);
            }
            if ((this.f3175c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f3181i);
            }
            if ((this.f3175c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
            }
            this.l = computeEnumSize;
            return computeEnumSize;
        }

        public ByteString h() {
            Object obj = this.f3178f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3178f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3175c & 8) == 8;
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
            Object obj = this.f3179g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3179g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3175c & 16) == 16;
        }

        public int l() {
            return this.f3180h;
        }

        public boolean m() {
            return (this.f3175c & 32) == 32;
        }

        public int n() {
            return this.f3181i;
        }

        public boolean o() {
            return (this.f3175c & 64) == 64;
        }

        public int p() {
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
            if ((this.f3175c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3176d.getNumber());
            }
            if ((this.f3175c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3175c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3175c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3175c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.f3180h);
            }
            if ((this.f3175c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.f3181i);
            }
            if ((this.f3175c & 64) == 64) {
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
        public static Parser<ae> f3190a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ae f3191b;

        /* renamed from: c  reason: collision with root package name */
        public int f3192c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3193d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3194e;

        /* renamed from: f  reason: collision with root package name */
        public long f3195f;

        /* renamed from: g  reason: collision with root package name */
        public long f3196g;

        /* renamed from: h  reason: collision with root package name */
        public long f3197h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3198i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039a extends GeneratedMessageLite.Builder<ae, C0039a> implements af {

            /* renamed from: a  reason: collision with root package name */
            public int f3199a;

            /* renamed from: d  reason: collision with root package name */
            public long f3202d;

            /* renamed from: e  reason: collision with root package name */
            public long f3203e;

            /* renamed from: f  reason: collision with root package name */
            public long f3204f;

            /* renamed from: h  reason: collision with root package name */
            public long f3206h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3200b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3201c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3205g = "";

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
                this.f3200b = "";
                int i2 = this.f3199a & (-2);
                this.f3199a = i2;
                this.f3201c = "";
                int i3 = i2 & (-3);
                this.f3199a = i3;
                this.f3202d = 0L;
                int i4 = i3 & (-5);
                this.f3199a = i4;
                this.f3203e = 0L;
                int i5 = i4 & (-9);
                this.f3199a = i5;
                this.f3204f = 0L;
                int i6 = i5 & (-17);
                this.f3199a = i6;
                this.f3205g = "";
                int i7 = i6 & (-33);
                this.f3199a = i7;
                this.f3206h = 0L;
                this.f3199a = i7 & (-65);
                return this;
            }

            public C0039a a(long j) {
                this.f3199a |= 4;
                this.f3202d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0039a mergeFrom(ae aeVar) {
                if (aeVar == ae.a()) {
                    return this;
                }
                if (aeVar.c()) {
                    this.f3199a |= 1;
                    this.f3200b = aeVar.f3193d;
                }
                if (aeVar.e()) {
                    this.f3199a |= 2;
                    this.f3201c = aeVar.f3194e;
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
                    this.f3199a |= 32;
                    this.f3205g = aeVar.f3198i;
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
            public C0039a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ae aeVar = null;
                try {
                    try {
                        ae parsePartialFrom = ae.f3190a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0039a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0039a b(long j) {
                this.f3199a |= 8;
                this.f3203e = j;
                return this;
            }

            public C0039a c(long j) {
                this.f3199a |= 16;
                this.f3204f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0039a d(long j) {
                this.f3199a |= 64;
                this.f3206h = j;
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
                int i2 = this.f3199a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aeVar.f3193d = this.f3200b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aeVar.f3194e = this.f3201c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aeVar.f3195f = this.f3202d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aeVar.f3196g = this.f3203e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aeVar.f3197h = this.f3204f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aeVar.f3198i = this.f3205g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aeVar.j = this.f3206h;
                aeVar.f3192c = i3;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ae aeVar = new ae();
            f3191b = aeVar;
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
                                this.f3192c |= 1;
                                this.f3193d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3192c |= 2;
                                this.f3194e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3192c |= 4;
                                this.f3195f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3192c |= 8;
                                this.f3196g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3192c |= 16;
                                this.f3197h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3192c |= 32;
                                this.f3198i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3192c |= 64;
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

        public static C0039a a(ae aeVar) {
            return q().mergeFrom(aeVar);
        }

        public static ae a() {
            return f3191b;
        }

        public static C0039a q() {
            return C0039a.h();
        }

        private void t() {
            this.f3193d = "";
            this.f3194e = "";
            this.f3195f = 0L;
            this.f3196g = 0L;
            this.f3197h = 0L;
            this.f3198i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f3191b;
        }

        public boolean c() {
            return (this.f3192c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3193d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3193d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3192c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3194e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3194e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3192c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            return f3190a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3192c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3192c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3192c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3195f);
            }
            if ((this.f3192c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3196g);
            }
            if ((this.f3192c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3197h);
            }
            if ((this.f3192c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3192c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3195f;
        }

        public boolean i() {
            return (this.f3192c & 8) == 8;
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
            return this.f3196g;
        }

        public boolean k() {
            return (this.f3192c & 16) == 16;
        }

        public long l() {
            return this.f3197h;
        }

        public boolean m() {
            return (this.f3192c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3198i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3198i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3192c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0039a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0039a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3192c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3192c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3192c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3195f);
            }
            if ((this.f3192c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3196g);
            }
            if ((this.f3192c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3197h);
            }
            if ((this.f3192c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3192c & 64) == 64) {
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
        public static Parser<c> f3207a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3208b;

        /* renamed from: c  reason: collision with root package name */
        public int f3209c;

        /* renamed from: d  reason: collision with root package name */
        public e f3210d;

        /* renamed from: e  reason: collision with root package name */
        public ae f3211e;

        /* renamed from: f  reason: collision with root package name */
        public l f3212f;

        /* renamed from: g  reason: collision with root package name */
        public n f3213g;

        /* renamed from: h  reason: collision with root package name */
        public j f3214h;

        /* renamed from: i  reason: collision with root package name */
        public aa f3215i;
        public C0035a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0040a extends GeneratedMessageLite.Builder<c, C0040a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3216a;

            /* renamed from: b  reason: collision with root package name */
            public e f3217b = e.UI;

            /* renamed from: c  reason: collision with root package name */
            public ae f3218c = ae.a();

            /* renamed from: d  reason: collision with root package name */
            public l f3219d = l.a();

            /* renamed from: e  reason: collision with root package name */
            public n f3220e = n.a();

            /* renamed from: f  reason: collision with root package name */
            public j f3221f = j.a();

            /* renamed from: g  reason: collision with root package name */
            public aa f3222g = aa.a();

            /* renamed from: h  reason: collision with root package name */
            public C0035a f3223h = C0035a.a();

            /* renamed from: i  reason: collision with root package name */
            public t f3224i = t.a();

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
                this.f3217b = e.UI;
                this.f3216a &= -2;
                this.f3218c = ae.a();
                this.f3216a &= -3;
                this.f3219d = l.a();
                this.f3216a &= -5;
                this.f3220e = n.a();
                this.f3216a &= -9;
                this.f3221f = j.a();
                this.f3216a &= -17;
                this.f3222g = aa.a();
                this.f3216a &= -33;
                this.f3223h = C0035a.a();
                this.f3216a &= -65;
                this.f3224i = t.a();
                this.f3216a &= -129;
                return this;
            }

            public C0040a a(C0035a c0035a) {
                if (c0035a != null) {
                    this.f3223h = c0035a;
                    this.f3216a |= 64;
                    return this;
                }
                throw null;
            }

            public C0040a a(aa aaVar) {
                if (aaVar != null) {
                    this.f3222g = aaVar;
                    this.f3216a |= 32;
                    return this;
                }
                throw null;
            }

            public C0040a a(ae aeVar) {
                if ((this.f3216a & 2) == 2 && this.f3218c != ae.a()) {
                    aeVar = ae.a(this.f3218c).mergeFrom(aeVar).buildPartial();
                }
                this.f3218c = aeVar;
                this.f3216a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0040a mergeFrom(c cVar) {
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

            public C0040a a(e eVar) {
                if (eVar != null) {
                    this.f3216a |= 1;
                    this.f3217b = eVar;
                    return this;
                }
                throw null;
            }

            public C0040a a(j jVar) {
                if (jVar != null) {
                    this.f3221f = jVar;
                    this.f3216a |= 16;
                    return this;
                }
                throw null;
            }

            public C0040a a(l lVar) {
                if (lVar != null) {
                    this.f3219d = lVar;
                    this.f3216a |= 4;
                    return this;
                }
                throw null;
            }

            public C0040a a(n nVar) {
                if (nVar != null) {
                    this.f3220e = nVar;
                    this.f3216a |= 8;
                    return this;
                }
                throw null;
            }

            public C0040a a(t tVar) {
                if ((this.f3216a & 128) == 128 && this.f3224i != t.a()) {
                    tVar = t.a(this.f3224i).mergeFrom(tVar).buildPartial();
                }
                this.f3224i = tVar;
                this.f3216a |= 128;
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
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3207a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0040a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0040a b(C0035a c0035a) {
                if ((this.f3216a & 64) == 64 && this.f3223h != C0035a.a()) {
                    c0035a = C0035a.a(this.f3223h).mergeFrom(c0035a).buildPartial();
                }
                this.f3223h = c0035a;
                this.f3216a |= 64;
                return this;
            }

            public C0040a b(aa aaVar) {
                if ((this.f3216a & 32) == 32 && this.f3222g != aa.a()) {
                    aaVar = aa.a(this.f3222g).mergeFrom(aaVar).buildPartial();
                }
                this.f3222g = aaVar;
                this.f3216a |= 32;
                return this;
            }

            public C0040a b(j jVar) {
                if ((this.f3216a & 16) == 16 && this.f3221f != j.a()) {
                    jVar = j.a(this.f3221f).mergeFrom(jVar).buildPartial();
                }
                this.f3221f = jVar;
                this.f3216a |= 16;
                return this;
            }

            public C0040a b(l lVar) {
                if ((this.f3216a & 4) == 4 && this.f3219d != l.a()) {
                    lVar = l.a(this.f3219d).mergeFrom(lVar).buildPartial();
                }
                this.f3219d = lVar;
                this.f3216a |= 4;
                return this;
            }

            public C0040a b(n nVar) {
                if ((this.f3216a & 8) == 8 && this.f3220e != n.a()) {
                    nVar = n.a(this.f3220e).mergeFrom(nVar).buildPartial();
                }
                this.f3220e = nVar;
                this.f3216a |= 8;
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
                int i2 = this.f3216a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3210d = this.f3217b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3211e = this.f3218c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3212f = this.f3219d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                cVar.f3213g = this.f3220e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                cVar.f3214h = this.f3221f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                cVar.f3215i = this.f3222g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                cVar.j = this.f3223h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                cVar.k = this.f3224i;
                cVar.f3209c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3208b = cVar;
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
                                    ae.C0039a builder = (this.f3209c & 2) == 2 ? this.f3211e.toBuilder() : null;
                                    ae aeVar = (ae) codedInputStream.readMessage(ae.f3190a, extensionRegistryLite);
                                    this.f3211e = aeVar;
                                    if (builder != null) {
                                        builder.mergeFrom(aeVar);
                                        this.f3211e = builder.buildPartial();
                                    }
                                    i3 = this.f3209c;
                                } else if (readTag == 26) {
                                    i2 = 4;
                                    l.C0044a builder2 = (this.f3209c & 4) == 4 ? this.f3212f.toBuilder() : null;
                                    l lVar = (l) codedInputStream.readMessage(l.f3281a, extensionRegistryLite);
                                    this.f3212f = lVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar);
                                        this.f3212f = builder2.buildPartial();
                                    }
                                    i3 = this.f3209c;
                                } else if (readTag == 34) {
                                    n.C0045a builder3 = (this.f3209c & 8) == 8 ? this.f3213g.toBuilder() : null;
                                    n nVar = (n) codedInputStream.readMessage(n.f3295a, extensionRegistryLite);
                                    this.f3213g = nVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(nVar);
                                        this.f3213g = builder3.buildPartial();
                                    }
                                    this.f3209c |= 8;
                                } else if (readTag == 42) {
                                    i2 = 16;
                                    j.C0043a builder4 = (this.f3209c & 16) == 16 ? this.f3214h.toBuilder() : null;
                                    j jVar = (j) codedInputStream.readMessage(j.f3264a, extensionRegistryLite);
                                    this.f3214h = jVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(jVar);
                                        this.f3214h = builder4.buildPartial();
                                    }
                                    i3 = this.f3209c;
                                } else if (readTag == 50) {
                                    i2 = 32;
                                    aa.C0037a builder5 = (this.f3209c & 32) == 32 ? this.f3215i.toBuilder() : null;
                                    aa aaVar = (aa) codedInputStream.readMessage(aa.f3156a, extensionRegistryLite);
                                    this.f3215i = aaVar;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(aaVar);
                                        this.f3215i = builder5.buildPartial();
                                    }
                                    i3 = this.f3209c;
                                } else if (readTag == 58) {
                                    i2 = 64;
                                    C0035a.C0036a builder6 = (this.f3209c & 64) == 64 ? this.j.toBuilder() : null;
                                    C0035a c0035a = (C0035a) codedInputStream.readMessage(C0035a.f3141a, extensionRegistryLite);
                                    this.j = c0035a;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(c0035a);
                                        this.j = builder6.buildPartial();
                                    }
                                    i3 = this.f3209c;
                                } else if (readTag == 66) {
                                    i2 = 128;
                                    t.C0048a builder7 = (this.f3209c & 128) == 128 ? this.k.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.f3333a, extensionRegistryLite);
                                    this.k = tVar;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(tVar);
                                        this.k = builder7.buildPartial();
                                    }
                                    i3 = this.f3209c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3209c = i3 | i2;
                            } else {
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f3209c = 1 | this.f3209c;
                                    this.f3210d = a2;
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

        public static C0040a a(c cVar) {
            return s().mergeFrom(cVar);
        }

        public static c a() {
            return f3208b;
        }

        public static C0040a s() {
            return C0040a.h();
        }

        private void v() {
            this.f3210d = e.UI;
            this.f3211e = ae.a();
            this.f3212f = l.a();
            this.f3213g = n.a();
            this.f3214h = j.a();
            this.f3215i = aa.a();
            this.j = C0035a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3208b;
        }

        public boolean c() {
            return (this.f3209c & 1) == 1;
        }

        public e d() {
            return this.f3210d;
        }

        public boolean e() {
            return (this.f3209c & 2) == 2;
        }

        public ae f() {
            return this.f3211e;
        }

        public boolean g() {
            return (this.f3209c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3207a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3209c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3210d.getNumber()) : 0;
            if ((this.f3209c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f3211e);
            }
            if ((this.f3209c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f3212f);
            }
            if ((this.f3209c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f3213g);
            }
            if ((this.f3209c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f3214h);
            }
            if ((this.f3209c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f3215i);
            }
            if ((this.f3209c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
            }
            if ((this.f3209c & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
            }
            this.m = computeEnumSize;
            return computeEnumSize;
        }

        public l h() {
            return this.f3212f;
        }

        public boolean i() {
            return (this.f3209c & 8) == 8;
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
            return this.f3213g;
        }

        public boolean k() {
            return (this.f3209c & 16) == 16;
        }

        public j l() {
            return this.f3214h;
        }

        public boolean m() {
            return (this.f3209c & 32) == 32;
        }

        public aa n() {
            return this.f3215i;
        }

        public boolean o() {
            return (this.f3209c & 64) == 64;
        }

        public C0035a p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3209c & 128) == 128;
        }

        public t r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C0040a newBuilderForType() {
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
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
            if ((this.f3209c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3210d.getNumber());
            }
            if ((this.f3209c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.f3211e);
            }
            if ((this.f3209c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3212f);
            }
            if ((this.f3209c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f3213g);
            }
            if ((this.f3209c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.f3214h);
            }
            if ((this.f3209c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.f3215i);
            }
            if ((this.f3209c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.f3209c & 128) == 128) {
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
        public final int f3233h;

        e(int i2) {
            this.f3233h = i2;
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
            return this.f3233h;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f3234a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final f f3235b;

        /* renamed from: c  reason: collision with root package name */
        public int f3236c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3237d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3238e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3239f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3240g;

        /* renamed from: h  reason: collision with root package name */
        public int f3241h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041a extends GeneratedMessageLite.Builder<f, C0041a> implements g {

            /* renamed from: a  reason: collision with root package name */
            public int f3242a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3243b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3244c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3245d = "";

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
                this.f3243b = "";
                int i2 = this.f3242a & (-2);
                this.f3242a = i2;
                this.f3244c = "";
                int i3 = i2 & (-3);
                this.f3242a = i3;
                this.f3245d = "";
                this.f3242a = i3 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0041a mergeFrom(f fVar) {
                if (fVar == f.a()) {
                    return this;
                }
                if (fVar.c()) {
                    this.f3242a |= 1;
                    this.f3243b = fVar.f3237d;
                }
                if (fVar.e()) {
                    this.f3242a |= 2;
                    this.f3244c = fVar.f3238e;
                }
                if (fVar.g()) {
                    this.f3242a |= 4;
                    this.f3245d = fVar.f3239f;
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
                f fVar = null;
                try {
                    try {
                        f parsePartialFrom = f.f3234a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0041a a(String str) {
                if (str != null) {
                    this.f3242a |= 1;
                    this.f3243b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0041a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0041a b(String str) {
                if (str != null) {
                    this.f3242a |= 2;
                    this.f3244c = str;
                    return this;
                }
                throw null;
            }

            public C0041a c(String str) {
                if (str != null) {
                    this.f3242a |= 4;
                    this.f3245d = str;
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
                int i2 = this.f3242a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                fVar.f3237d = this.f3243b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                fVar.f3238e = this.f3244c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                fVar.f3239f = this.f3245d;
                fVar.f3236c = i3;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f fVar = new f();
            f3235b = fVar;
            fVar.l();
        }

        public f() {
            this.f3240g = (byte) -1;
            this.f3241h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3240g = (byte) -1;
            this.f3241h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3236c |= 1;
                                    this.f3237d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3236c |= 2;
                                    this.f3238e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3236c |= 4;
                                    this.f3239f = codedInputStream.readBytes();
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
            this.f3240g = (byte) -1;
            this.f3241h = -1;
        }

        public static C0041a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f3235b;
        }

        public static C0041a i() {
            return C0041a.h();
        }

        private void l() {
            this.f3237d = "";
            this.f3238e = "";
            this.f3239f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f3235b;
        }

        public boolean c() {
            return (this.f3236c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3237d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3237d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3236c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3238e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3238e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3236c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            return f3234a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3241h;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3236c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3236c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3236c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3241h = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3239f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3239f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3240g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3240g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0041a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0041a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3236c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3236c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3236c & 4) == 4) {
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
        public static Parser<h> f3246a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final h f3247b;

        /* renamed from: c  reason: collision with root package name */
        public int f3248c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3249d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3250e;

        /* renamed from: f  reason: collision with root package name */
        public p f3251f;

        /* renamed from: g  reason: collision with root package name */
        public long f3252g;

        /* renamed from: h  reason: collision with root package name */
        public long f3253h;

        /* renamed from: i  reason: collision with root package name */
        public ac f3254i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0042a extends GeneratedMessageLite.Builder<h, C0042a> implements i {

            /* renamed from: a  reason: collision with root package name */
            public int f3255a;

            /* renamed from: e  reason: collision with root package name */
            public long f3259e;

            /* renamed from: f  reason: collision with root package name */
            public long f3260f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3256b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3257c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f3258d = p.a();

            /* renamed from: g  reason: collision with root package name */
            public ac f3261g = ac.a();

            /* renamed from: h  reason: collision with root package name */
            public f f3262h = f.a();

            /* renamed from: i  reason: collision with root package name */
            public v f3263i = v.a();

            public C0042a() {
                j();
            }

            private void j() {
            }

            public static C0042a k() {
                return new C0042a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0042a clear() {
                super.clear();
                this.f3256b = "";
                int i2 = this.f3255a & (-2);
                this.f3255a = i2;
                this.f3257c = "";
                this.f3255a = i2 & (-3);
                this.f3258d = p.a();
                int i3 = this.f3255a & (-5);
                this.f3255a = i3;
                this.f3259e = 0L;
                int i4 = i3 & (-9);
                this.f3255a = i4;
                this.f3260f = 0L;
                this.f3255a = i4 & (-17);
                this.f3261g = ac.a();
                this.f3255a &= -33;
                this.f3262h = f.a();
                this.f3255a &= -65;
                this.f3263i = v.a();
                this.f3255a &= -129;
                return this;
            }

            public C0042a a(long j) {
                this.f3255a |= 8;
                this.f3259e = j;
                return this;
            }

            public C0042a a(ac acVar) {
                if (acVar != null) {
                    this.f3261g = acVar;
                    this.f3255a |= 32;
                    return this;
                }
                throw null;
            }

            public C0042a a(f fVar) {
                if (fVar != null) {
                    this.f3262h = fVar;
                    this.f3255a |= 64;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0042a mergeFrom(h hVar) {
                if (hVar == h.a()) {
                    return this;
                }
                if (hVar.c()) {
                    this.f3255a |= 1;
                    this.f3256b = hVar.f3249d;
                }
                if (hVar.e()) {
                    this.f3255a |= 2;
                    this.f3257c = hVar.f3250e;
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

            public C0042a a(p pVar) {
                if (pVar != null) {
                    this.f3258d = pVar;
                    this.f3255a |= 4;
                    return this;
                }
                throw null;
            }

            public C0042a a(v vVar) {
                if (vVar != null) {
                    this.f3263i = vVar;
                    this.f3255a |= 128;
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
            public C0042a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                h hVar = null;
                try {
                    try {
                        h parsePartialFrom = h.f3246a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0042a clone() {
                return k().mergeFrom(buildPartial());
            }

            public C0042a b(long j) {
                this.f3255a |= 16;
                this.f3260f = j;
                return this;
            }

            public C0042a b(ac acVar) {
                if ((this.f3255a & 32) == 32 && this.f3261g != ac.a()) {
                    acVar = ac.a(this.f3261g).mergeFrom(acVar).buildPartial();
                }
                this.f3261g = acVar;
                this.f3255a |= 32;
                return this;
            }

            public C0042a b(f fVar) {
                if ((this.f3255a & 64) == 64 && this.f3262h != f.a()) {
                    fVar = f.a(this.f3262h).mergeFrom(fVar).buildPartial();
                }
                this.f3262h = fVar;
                this.f3255a |= 64;
                return this;
            }

            public C0042a b(p pVar) {
                if ((this.f3255a & 4) == 4 && this.f3258d != p.a()) {
                    pVar = p.a(this.f3258d).mergeFrom(pVar).buildPartial();
                }
                this.f3258d = pVar;
                this.f3255a |= 4;
                return this;
            }

            public C0042a b(v vVar) {
                if ((this.f3255a & 128) == 128 && this.f3263i != v.a()) {
                    vVar = v.a(this.f3263i).mergeFrom(vVar).buildPartial();
                }
                this.f3263i = vVar;
                this.f3255a |= 128;
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
                int i2 = this.f3255a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                hVar.f3249d = this.f3256b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                hVar.f3250e = this.f3257c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                hVar.f3251f = this.f3258d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                hVar.f3252g = this.f3259e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                hVar.f3253h = this.f3260f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                hVar.f3254i = this.f3261g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                hVar.j = this.f3262h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                hVar.k = this.f3263i;
                hVar.f3248c = i3;
                return hVar;
            }

            public boolean f() {
                return (this.f3255a & 4) == 4;
            }

            public p g() {
                return this.f3258d;
            }

            public boolean h() {
                return (this.f3255a & 8) == 8;
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
            f3247b = hVar;
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
                                this.f3248c |= 1;
                                this.f3249d = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (readTag == 58) {
                                    i2 = 4;
                                    p.C0046a builder = (this.f3248c & 4) == 4 ? this.f3251f.toBuilder() : null;
                                    p pVar = (p) codedInputStream.readMessage(p.f3313a, extensionRegistryLite);
                                    this.f3251f = pVar;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar);
                                        this.f3251f = builder.buildPartial();
                                    }
                                    i3 = this.f3248c;
                                } else if (readTag == 80) {
                                    this.f3248c |= 8;
                                    this.f3252g = codedInputStream.readInt64();
                                } else if (readTag == 96) {
                                    this.f3248c |= 16;
                                    this.f3253h = codedInputStream.readInt64();
                                } else if (readTag == 162) {
                                    i2 = 32;
                                    ac.C0038a builder2 = (this.f3248c & 32) == 32 ? this.f3254i.toBuilder() : null;
                                    ac acVar = (ac) codedInputStream.readMessage(ac.f3173a, extensionRegistryLite);
                                    this.f3254i = acVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(acVar);
                                        this.f3254i = builder2.buildPartial();
                                    }
                                    i3 = this.f3248c;
                                } else if (readTag == 170) {
                                    i2 = 64;
                                    f.C0041a builder3 = (this.f3248c & 64) == 64 ? this.j.toBuilder() : null;
                                    f fVar = (f) codedInputStream.readMessage(f.f3234a, extensionRegistryLite);
                                    this.j = fVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(fVar);
                                        this.j = builder3.buildPartial();
                                    }
                                    i3 = this.f3248c;
                                } else if (readTag == 178) {
                                    i2 = 128;
                                    v.C0049a builder4 = (this.f3248c & 128) == 128 ? this.k.toBuilder() : null;
                                    v vVar = (v) codedInputStream.readMessage(v.f3350a, extensionRegistryLite);
                                    this.k = vVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(vVar);
                                        this.k = builder4.buildPartial();
                                    }
                                    i3 = this.f3248c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3248c = i3 | i2;
                            } else {
                                this.f3248c |= 2;
                                this.f3250e = codedInputStream.readBytes();
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

        public static C0042a a(h hVar) {
            return t().mergeFrom(hVar);
        }

        public static h a() {
            return f3247b;
        }

        public static C0042a t() {
            return C0042a.k();
        }

        private void v() {
            this.f3249d = "";
            this.f3250e = "";
            this.f3251f = p.a();
            this.f3252g = 0L;
            this.f3253h = 0L;
            this.f3254i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f3247b;
        }

        public boolean c() {
            return (this.f3248c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3249d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3249d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3248c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3250e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3250e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3248c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            return f3246a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3248c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3248c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3248c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f3251f);
            }
            if ((this.f3248c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f3252g);
            }
            if ((this.f3248c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f3253h);
            }
            if ((this.f3248c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f3254i);
            }
            if ((this.f3248c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
            }
            if ((this.f3248c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
            }
            this.m = computeBytesSize;
            return computeBytesSize;
        }

        public p h() {
            return this.f3251f;
        }

        public boolean i() {
            return (this.f3248c & 8) == 8;
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
            return this.f3252g;
        }

        public boolean k() {
            return (this.f3248c & 16) == 16;
        }

        public long l() {
            return this.f3253h;
        }

        public boolean m() {
            return (this.f3248c & 32) == 32;
        }

        public ac n() {
            return this.f3254i;
        }

        public boolean o() {
            return (this.f3248c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3248c & 128) == 128;
        }

        public v r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0042a newBuilderForType() {
            return t();
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
            if ((this.f3248c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3248c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3248c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f3251f);
            }
            if ((this.f3248c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.f3252g);
            }
            if ((this.f3248c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.f3253h);
            }
            if ((this.f3248c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.f3254i);
            }
            if ((this.f3248c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.f3248c & 128) == 128) {
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
        public static Parser<j> f3264a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final j f3265b;

        /* renamed from: c  reason: collision with root package name */
        public int f3266c;

        /* renamed from: d  reason: collision with root package name */
        public long f3267d;

        /* renamed from: e  reason: collision with root package name */
        public long f3268e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3269f;

        /* renamed from: g  reason: collision with root package name */
        public long f3270g;

        /* renamed from: h  reason: collision with root package name */
        public long f3271h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3272i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<j, C0043a> implements k {

            /* renamed from: a  reason: collision with root package name */
            public int f3273a;

            /* renamed from: b  reason: collision with root package name */
            public long f3274b;

            /* renamed from: c  reason: collision with root package name */
            public long f3275c;

            /* renamed from: e  reason: collision with root package name */
            public long f3277e;

            /* renamed from: f  reason: collision with root package name */
            public long f3278f;

            /* renamed from: h  reason: collision with root package name */
            public long f3280h;

            /* renamed from: d  reason: collision with root package name */
            public Object f3276d = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3279g = "";

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
                this.f3274b = 0L;
                int i2 = this.f3273a & (-2);
                this.f3273a = i2;
                this.f3275c = 0L;
                int i3 = i2 & (-3);
                this.f3273a = i3;
                this.f3276d = "";
                int i4 = i3 & (-5);
                this.f3273a = i4;
                this.f3277e = 0L;
                int i5 = i4 & (-9);
                this.f3273a = i5;
                this.f3278f = 0L;
                int i6 = i5 & (-17);
                this.f3273a = i6;
                this.f3279g = "";
                int i7 = i6 & (-33);
                this.f3273a = i7;
                this.f3280h = 0L;
                this.f3273a = i7 & (-65);
                return this;
            }

            public C0043a a(long j) {
                this.f3273a |= 1;
                this.f3274b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0043a mergeFrom(j jVar) {
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
                    this.f3273a |= 4;
                    this.f3276d = jVar.f3269f;
                }
                if (jVar.i()) {
                    c(jVar.j());
                }
                if (jVar.k()) {
                    d(jVar.l());
                }
                if (jVar.m()) {
                    this.f3273a |= 32;
                    this.f3279g = jVar.f3272i;
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
            public C0043a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                j jVar = null;
                try {
                    try {
                        j parsePartialFrom = j.f3264a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0043a a(String str) {
                if (str != null) {
                    this.f3273a |= 4;
                    this.f3276d = str;
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

            public C0043a b(long j) {
                this.f3273a |= 2;
                this.f3275c = j;
                return this;
            }

            public C0043a b(String str) {
                if (str != null) {
                    this.f3273a |= 32;
                    this.f3279g = str;
                    return this;
                }
                throw null;
            }

            public C0043a c(long j) {
                this.f3273a |= 8;
                this.f3277e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0043a d(long j) {
                this.f3273a |= 16;
                this.f3278f = j;
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

            public C0043a e(long j) {
                this.f3273a |= 64;
                this.f3280h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i2 = this.f3273a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jVar.f3267d = this.f3274b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jVar.f3268e = this.f3275c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                jVar.f3269f = this.f3276d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                jVar.f3270g = this.f3277e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                jVar.f3271h = this.f3278f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                jVar.f3272i = this.f3279g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                jVar.j = this.f3280h;
                jVar.f3266c = i3;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            j jVar = new j();
            f3265b = jVar;
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
                                    this.f3266c |= 1;
                                    this.f3267d = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.f3266c |= 2;
                                    this.f3268e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3266c |= 4;
                                    this.f3269f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3266c |= 8;
                                    this.f3270g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f3266c |= 16;
                                    this.f3271h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f3266c |= 32;
                                    this.f3272i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f3266c |= 64;
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

        public static C0043a a(j jVar) {
            return q().mergeFrom(jVar);
        }

        public static j a() {
            return f3265b;
        }

        public static C0043a q() {
            return C0043a.h();
        }

        private void t() {
            this.f3267d = 0L;
            this.f3268e = 0L;
            this.f3269f = "";
            this.f3270g = 0L;
            this.f3271h = 0L;
            this.f3272i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
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

        public long f() {
            return this.f3268e;
        }

        public boolean g() {
            return (this.f3266c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f3264a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3266c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3267d) : 0;
            if ((this.f3266c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3268e);
            }
            if ((this.f3266c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3266c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3270g);
            }
            if ((this.f3266c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3271h);
            }
            if ((this.f3266c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3266c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString h() {
            Object obj = this.f3269f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3269f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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

        public long l() {
            return this.f3271h;
        }

        public boolean m() {
            return (this.f3266c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3272i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3272i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
        public C0043a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0043a newBuilderForType() {
            return q();
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
                codedOutputStream.writeInt64(2, this.f3268e);
            }
            if ((this.f3266c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3266c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3270g);
            }
            if ((this.f3266c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3271h);
            }
            if ((this.f3266c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3266c & 64) == 64) {
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
        public static Parser<l> f3281a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final l f3282b;

        /* renamed from: c  reason: collision with root package name */
        public int f3283c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3284d;

        /* renamed from: e  reason: collision with root package name */
        public long f3285e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3286f;

        /* renamed from: g  reason: collision with root package name */
        public long f3287g;

        /* renamed from: h  reason: collision with root package name */
        public byte f3288h;

        /* renamed from: i  reason: collision with root package name */
        public int f3289i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<l, C0044a> implements m {

            /* renamed from: a  reason: collision with root package name */
            public int f3290a;

            /* renamed from: c  reason: collision with root package name */
            public long f3292c;

            /* renamed from: e  reason: collision with root package name */
            public long f3294e;

            /* renamed from: b  reason: collision with root package name */
            public Object f3291b = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3293d = "";

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
                this.f3291b = "";
                int i2 = this.f3290a & (-2);
                this.f3290a = i2;
                this.f3292c = 0L;
                int i3 = i2 & (-3);
                this.f3290a = i3;
                this.f3293d = "";
                int i4 = i3 & (-5);
                this.f3290a = i4;
                this.f3294e = 0L;
                this.f3290a = i4 & (-9);
                return this;
            }

            public C0044a a(long j) {
                this.f3290a |= 2;
                this.f3292c = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0044a mergeFrom(l lVar) {
                if (lVar == l.a()) {
                    return this;
                }
                if (lVar.c()) {
                    this.f3290a |= 1;
                    this.f3291b = lVar.f3284d;
                }
                if (lVar.e()) {
                    a(lVar.f());
                }
                if (lVar.g()) {
                    this.f3290a |= 4;
                    this.f3293d = lVar.f3286f;
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
            public C0044a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                l lVar = null;
                try {
                    try {
                        l parsePartialFrom = l.f3281a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0044a a(String str) {
                if (str != null) {
                    this.f3290a |= 1;
                    this.f3291b = str;
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
                this.f3290a |= 8;
                this.f3294e = j;
                return this;
            }

            public C0044a b(String str) {
                if (str != null) {
                    this.f3290a |= 4;
                    this.f3293d = str;
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
                int i2 = this.f3290a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lVar.f3284d = this.f3291b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lVar.f3285e = this.f3292c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lVar.f3286f = this.f3293d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lVar.f3287g = this.f3294e;
                lVar.f3283c = i3;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            l lVar = new l();
            f3282b = lVar;
            lVar.n();
        }

        public l() {
            this.f3288h = (byte) -1;
            this.f3289i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3288h = (byte) -1;
            this.f3289i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3283c |= 1;
                                    this.f3284d = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.f3283c |= 2;
                                    this.f3285e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3283c |= 4;
                                    this.f3286f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3283c |= 8;
                                    this.f3287g = codedInputStream.readInt64();
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
            this.f3288h = (byte) -1;
            this.f3289i = -1;
        }

        public static C0044a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f3282b;
        }

        public static C0044a k() {
            return C0044a.h();
        }

        private void n() {
            this.f3284d = "";
            this.f3285e = 0L;
            this.f3286f = "";
            this.f3287g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            return f3282b;
        }

        public boolean c() {
            return (this.f3283c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3284d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3284d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3283c & 2) == 2;
        }

        public long f() {
            return this.f3285e;
        }

        public boolean g() {
            return (this.f3283c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f3281a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3289i;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3283c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3283c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3285e);
            }
            if ((this.f3283c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3283c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3287g);
            }
            this.f3289i = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3286f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3286f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3283c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3288h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3288h = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3287g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0044a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0044a newBuilderForType() {
            return k();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3283c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3283c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3285e);
            }
            if ((this.f3283c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3283c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3287g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f3295a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final n f3296b;

        /* renamed from: c  reason: collision with root package name */
        public int f3297c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3298d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3299e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3300f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3301g;

        /* renamed from: h  reason: collision with root package name */
        public long f3302h;

        /* renamed from: i  reason: collision with root package name */
        public long f3303i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<n, C0045a> implements o {

            /* renamed from: a  reason: collision with root package name */
            public int f3304a;

            /* renamed from: f  reason: collision with root package name */
            public long f3309f;

            /* renamed from: g  reason: collision with root package name */
            public long f3310g;

            /* renamed from: h  reason: collision with root package name */
            public long f3311h;
            public long j;

            /* renamed from: b  reason: collision with root package name */
            public Object f3305b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3306c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3307d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3308e = "";

            /* renamed from: i  reason: collision with root package name */
            public Object f3312i = "";

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
                this.f3305b = "";
                int i2 = this.f3304a & (-2);
                this.f3304a = i2;
                this.f3306c = "";
                int i3 = i2 & (-3);
                this.f3304a = i3;
                this.f3307d = "";
                int i4 = i3 & (-5);
                this.f3304a = i4;
                this.f3308e = "";
                int i5 = i4 & (-9);
                this.f3304a = i5;
                this.f3309f = 0L;
                int i6 = i5 & (-17);
                this.f3304a = i6;
                this.f3310g = 0L;
                int i7 = i6 & (-33);
                this.f3304a = i7;
                this.f3311h = 0L;
                int i8 = i7 & (-65);
                this.f3304a = i8;
                this.f3312i = "";
                int i9 = i8 & (-129);
                this.f3304a = i9;
                this.j = 0L;
                this.f3304a = i9 & (-257);
                return this;
            }

            public C0045a a(long j) {
                this.f3304a |= 16;
                this.f3309f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0045a mergeFrom(n nVar) {
                if (nVar == n.a()) {
                    return this;
                }
                if (nVar.c()) {
                    this.f3304a |= 1;
                    this.f3305b = nVar.f3298d;
                }
                if (nVar.e()) {
                    this.f3304a |= 2;
                    this.f3306c = nVar.f3299e;
                }
                if (nVar.g()) {
                    this.f3304a |= 4;
                    this.f3307d = nVar.f3300f;
                }
                if (nVar.i()) {
                    this.f3304a |= 8;
                    this.f3308e = nVar.f3301g;
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
                    this.f3304a |= 128;
                    this.f3312i = nVar.k;
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
            public C0045a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                n nVar = null;
                try {
                    try {
                        n parsePartialFrom = n.f3295a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0045a a(String str) {
                if (str != null) {
                    this.f3304a |= 1;
                    this.f3305b = str;
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
                this.f3304a |= 32;
                this.f3310g = j;
                return this;
            }

            public C0045a b(String str) {
                if (str != null) {
                    this.f3304a |= 2;
                    this.f3306c = str;
                    return this;
                }
                throw null;
            }

            public C0045a c(long j) {
                this.f3304a |= 64;
                this.f3311h = j;
                return this;
            }

            public C0045a c(String str) {
                if (str != null) {
                    this.f3304a |= 4;
                    this.f3307d = str;
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

            public C0045a d(long j) {
                this.f3304a |= 256;
                this.j = j;
                return this;
            }

            public C0045a d(String str) {
                if (str != null) {
                    this.f3304a |= 8;
                    this.f3308e = str;
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

            public C0045a e(String str) {
                if (str != null) {
                    this.f3304a |= 128;
                    this.f3312i = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i2 = this.f3304a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                nVar.f3298d = this.f3305b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                nVar.f3299e = this.f3306c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                nVar.f3300f = this.f3307d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                nVar.f3301g = this.f3308e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                nVar.f3302h = this.f3309f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                nVar.f3303i = this.f3310g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                nVar.j = this.f3311h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                nVar.k = this.f3312i;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                nVar.l = this.j;
                nVar.f3297c = i3;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            n nVar = new n();
            f3296b = nVar;
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
                                this.f3297c |= 1;
                                this.f3298d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3297c |= 2;
                                this.f3299e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f3297c |= 4;
                                this.f3300f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f3297c |= 8;
                                this.f3301g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f3297c |= 16;
                                this.f3302h = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.f3297c |= 32;
                                this.f3303i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3297c |= 64;
                                this.j = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.f3297c |= 128;
                                this.k = codedInputStream.readBytes();
                            } else if (readTag == 72) {
                                this.f3297c |= 256;
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

        public static C0045a a(n nVar) {
            return u().mergeFrom(nVar);
        }

        public static n a() {
            return f3296b;
        }

        public static C0045a u() {
            return C0045a.h();
        }

        private void x() {
            this.f3298d = "";
            this.f3299e = "";
            this.f3300f = "";
            this.f3301g = "";
            this.f3302h = 0L;
            this.f3303i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f3296b;
        }

        public boolean c() {
            return (this.f3297c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3298d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3298d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3297c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3299e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3299e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3297c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            return f3295a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3297c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3297c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3297c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3297c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3297c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3302h);
            }
            if ((this.f3297c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f3303i);
            }
            if ((this.f3297c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            if ((this.f3297c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
            }
            if ((this.f3297c & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
            }
            this.n = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3300f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3300f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3297c & 8) == 8;
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
            Object obj = this.f3301g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3301g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3297c & 16) == 16;
        }

        public long l() {
            return this.f3302h;
        }

        public boolean m() {
            return (this.f3297c & 32) == 32;
        }

        public long n() {
            return this.f3303i;
        }

        public boolean o() {
            return (this.f3297c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3297c & 128) == 128;
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
            return (this.f3297c & 256) == 256;
        }

        public long t() {
            return this.l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C0045a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C0045a newBuilderForType() {
            return u();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3297c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3297c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3297c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3297c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3297c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3302h);
            }
            if ((this.f3297c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3303i);
            }
            if ((this.f3297c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.f3297c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.f3297c & 256) == 256) {
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
        public static Parser<p> f3313a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final p f3314b;

        /* renamed from: c  reason: collision with root package name */
        public int f3315c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3316d;

        /* renamed from: e  reason: collision with root package name */
        public byte f3317e;

        /* renamed from: f  reason: collision with root package name */
        public int f3318f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<p, C0046a> implements q {

            /* renamed from: a  reason: collision with root package name */
            public int f3319a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3320b = "";

            public C0046a() {
                h();
            }

            private void h() {
            }

            public static C0046a i() {
                return new C0046a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0046a clear() {
                super.clear();
                this.f3320b = "";
                this.f3319a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0046a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f3319a |= 1;
                    this.f3320b = pVar.f3316d;
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
                p pVar = null;
                try {
                    try {
                        p parsePartialFrom = p.f3313a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0046a a(String str) {
                if (str != null) {
                    this.f3319a |= 1;
                    this.f3320b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0046a clone() {
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
                int i2 = (this.f3319a & 1) != 1 ? 0 : 1;
                pVar.f3316d = this.f3320b;
                pVar.f3315c = i2;
                return pVar;
            }

            public boolean f() {
                return (this.f3319a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            p pVar = new p();
            f3314b = pVar;
            pVar.h();
        }

        public p() {
            this.f3317e = (byte) -1;
            this.f3318f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3317e = (byte) -1;
            this.f3318f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 34) {
                                this.f3315c |= 1;
                                this.f3316d = codedInputStream.readBytes();
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
            this.f3317e = (byte) -1;
            this.f3318f = -1;
        }

        public static C0046a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f3314b;
        }

        public static C0046a e() {
            return C0046a.i();
        }

        private void h() {
            this.f3316d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f3314b;
        }

        public boolean c() {
            return (this.f3315c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3316d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3316d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C0046a newBuilderForType() {
            return e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C0046a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            return f3313a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3318f;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3315c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
            this.f3318f = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3317e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.f3317e = (byte) 1;
                return true;
            } else {
                this.f3317e = (byte) 0;
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
            if ((this.f3315c & 1) == 1) {
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
        public static Parser<r> f3321a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final r f3322b;

        /* renamed from: c  reason: collision with root package name */
        public int f3323c;

        /* renamed from: d  reason: collision with root package name */
        public int f3324d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3325e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3326f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3327g;

        /* renamed from: h  reason: collision with root package name */
        public int f3328h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<r, C0047a> implements s {

            /* renamed from: a  reason: collision with root package name */
            public int f3329a;

            /* renamed from: b  reason: collision with root package name */
            public int f3330b = 7399;

            /* renamed from: c  reason: collision with root package name */
            public Object f3331c = "push_im_client";

            /* renamed from: d  reason: collision with root package name */
            public Object f3332d = "phonebaidu";

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
                this.f3330b = 7399;
                int i2 = this.f3329a & (-2);
                this.f3329a = i2;
                this.f3331c = "push_im_client";
                int i3 = i2 & (-3);
                this.f3329a = i3;
                this.f3332d = "phonebaidu";
                this.f3329a = i3 & (-5);
                return this;
            }

            public C0047a a(int i2) {
                this.f3329a |= 1;
                this.f3330b = i2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(r rVar) {
                if (rVar == r.a()) {
                    return this;
                }
                if (rVar.c()) {
                    a(rVar.d());
                }
                if (rVar.e()) {
                    this.f3329a |= 2;
                    this.f3331c = rVar.f3325e;
                }
                if (rVar.g()) {
                    this.f3329a |= 4;
                    this.f3332d = rVar.f3326f;
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
                r rVar = null;
                try {
                    try {
                        r parsePartialFrom = r.f3321a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0047a clone() {
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
                int i2 = this.f3329a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                rVar.f3324d = this.f3330b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                rVar.f3325e = this.f3331c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                rVar.f3326f = this.f3332d;
                rVar.f3323c = i3;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            r rVar = new r();
            f3322b = rVar;
            rVar.l();
        }

        public r() {
            this.f3327g = (byte) -1;
            this.f3328h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3327g = (byte) -1;
            this.f3328h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3323c |= 1;
                                    this.f3324d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3323c |= 2;
                                    this.f3325e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3323c |= 4;
                                    this.f3326f = codedInputStream.readBytes();
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
            this.f3327g = (byte) -1;
            this.f3328h = -1;
        }

        public static C0047a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f3322b;
        }

        public static C0047a i() {
            return C0047a.h();
        }

        private void l() {
            this.f3324d = 7399;
            this.f3325e = "push_im_client";
            this.f3326f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f3322b;
        }

        public boolean c() {
            return (this.f3323c & 1) == 1;
        }

        public int d() {
            return this.f3324d;
        }

        public boolean e() {
            return (this.f3323c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3325e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3325e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3323c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            return f3321a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3328h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3323c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3324d) : 0;
            if ((this.f3323c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3323c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3328h = computeInt32Size;
            return computeInt32Size;
        }

        public ByteString h() {
            Object obj = this.f3326f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3326f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3327g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3327g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0047a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0047a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3323c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3324d);
            }
            if ((this.f3323c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3323c & 4) == 4) {
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
        public static Parser<t> f3333a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final t f3334b;

        /* renamed from: c  reason: collision with root package name */
        public int f3335c;

        /* renamed from: d  reason: collision with root package name */
        public long f3336d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3337e;

        /* renamed from: f  reason: collision with root package name */
        public long f3338f;

        /* renamed from: g  reason: collision with root package name */
        public long f3339g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3340h;

        /* renamed from: i  reason: collision with root package name */
        public long f3341i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<t, C0048a> implements u {

            /* renamed from: a  reason: collision with root package name */
            public int f3342a;

            /* renamed from: b  reason: collision with root package name */
            public long f3343b;

            /* renamed from: d  reason: collision with root package name */
            public long f3345d;

            /* renamed from: e  reason: collision with root package name */
            public long f3346e;

            /* renamed from: g  reason: collision with root package name */
            public long f3348g;

            /* renamed from: h  reason: collision with root package name */
            public long f3349h;

            /* renamed from: c  reason: collision with root package name */
            public Object f3344c = "";

            /* renamed from: f  reason: collision with root package name */
            public Object f3347f = "";

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
                this.f3343b = 0L;
                int i2 = this.f3342a & (-2);
                this.f3342a = i2;
                this.f3344c = "";
                int i3 = i2 & (-3);
                this.f3342a = i3;
                this.f3345d = 0L;
                int i4 = i3 & (-5);
                this.f3342a = i4;
                this.f3346e = 0L;
                int i5 = i4 & (-9);
                this.f3342a = i5;
                this.f3347f = "";
                int i6 = i5 & (-17);
                this.f3342a = i6;
                this.f3348g = 0L;
                int i7 = i6 & (-33);
                this.f3342a = i7;
                this.f3349h = 0L;
                this.f3342a = i7 & (-65);
                return this;
            }

            public C0048a a(long j) {
                this.f3342a |= 1;
                this.f3343b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0048a mergeFrom(t tVar) {
                if (tVar == t.a()) {
                    return this;
                }
                if (tVar.c()) {
                    a(tVar.d());
                }
                if (tVar.e()) {
                    this.f3342a |= 2;
                    this.f3344c = tVar.f3337e;
                }
                if (tVar.g()) {
                    b(tVar.h());
                }
                if (tVar.i()) {
                    c(tVar.j());
                }
                if (tVar.k()) {
                    this.f3342a |= 16;
                    this.f3347f = tVar.f3340h;
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
            public C0048a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t tVar = null;
                try {
                    try {
                        t parsePartialFrom = t.f3333a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0048a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0048a b(long j) {
                this.f3342a |= 4;
                this.f3345d = j;
                return this;
            }

            public C0048a c(long j) {
                this.f3342a |= 8;
                this.f3346e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0048a d(long j) {
                this.f3342a |= 32;
                this.f3348g = j;
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

            public C0048a e(long j) {
                this.f3342a |= 64;
                this.f3349h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i2 = this.f3342a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                tVar.f3336d = this.f3343b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                tVar.f3337e = this.f3344c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                tVar.f3338f = this.f3345d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                tVar.f3339g = this.f3346e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                tVar.f3340h = this.f3347f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                tVar.f3341i = this.f3348g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                tVar.j = this.f3349h;
                tVar.f3335c = i3;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            t tVar = new t();
            f3334b = tVar;
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
                                this.f3335c |= 1;
                                this.f3336d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3335c |= 2;
                                this.f3337e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3335c |= 4;
                                this.f3338f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3335c |= 8;
                                this.f3339g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3335c |= 16;
                                this.f3340h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f3335c |= 32;
                                this.f3341i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3335c |= 64;
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

        public static C0048a a(t tVar) {
            return q().mergeFrom(tVar);
        }

        public static t a() {
            return f3334b;
        }

        public static C0048a q() {
            return C0048a.h();
        }

        private void t() {
            this.f3336d = 0L;
            this.f3337e = "";
            this.f3338f = 0L;
            this.f3339g = 0L;
            this.f3340h = "";
            this.f3341i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f3334b;
        }

        public boolean c() {
            return (this.f3335c & 1) == 1;
        }

        public long d() {
            return this.f3336d;
        }

        public boolean e() {
            return (this.f3335c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3337e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3337e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3335c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            return f3333a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3335c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3336d) : 0;
            if ((this.f3335c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3335c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3338f);
            }
            if ((this.f3335c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3339g);
            }
            if ((this.f3335c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3335c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f3341i);
            }
            if ((this.f3335c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public long h() {
            return this.f3338f;
        }

        public boolean i() {
            return (this.f3335c & 8) == 8;
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
            return this.f3339g;
        }

        public boolean k() {
            return (this.f3335c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3340h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3340h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3335c & 32) == 32;
        }

        public long n() {
            return this.f3341i;
        }

        public boolean o() {
            return (this.f3335c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0048a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0048a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3335c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3336d);
            }
            if ((this.f3335c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3335c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3338f);
            }
            if ((this.f3335c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3339g);
            }
            if ((this.f3335c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3335c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3341i);
            }
            if ((this.f3335c & 64) == 64) {
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
        public static Parser<v> f3350a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final v f3351b;

        /* renamed from: c  reason: collision with root package name */
        public int f3352c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3353d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3354e;

        /* renamed from: f  reason: collision with root package name */
        public byte f3355f;

        /* renamed from: g  reason: collision with root package name */
        public int f3356g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<v, C0049a> implements w {

            /* renamed from: a  reason: collision with root package name */
            public int f3357a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3358b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3359c = "";

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
                this.f3358b = "";
                int i2 = this.f3357a & (-2);
                this.f3357a = i2;
                this.f3359c = "";
                this.f3357a = i2 & (-3);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0049a mergeFrom(v vVar) {
                if (vVar == v.a()) {
                    return this;
                }
                if (vVar.c()) {
                    this.f3357a |= 1;
                    this.f3358b = vVar.f3353d;
                }
                if (vVar.e()) {
                    this.f3357a |= 2;
                    this.f3359c = vVar.f3354e;
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
                v vVar = null;
                try {
                    try {
                        v parsePartialFrom = v.f3350a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0049a a(String str) {
                if (str != null) {
                    this.f3357a |= 1;
                    this.f3358b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0049a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0049a b(String str) {
                if (str != null) {
                    this.f3357a |= 2;
                    this.f3359c = str;
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
                int i2 = this.f3357a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                vVar.f3353d = this.f3358b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                vVar.f3354e = this.f3359c;
                vVar.f3352c = i3;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            v vVar = new v();
            f3351b = vVar;
            vVar.j();
        }

        public v() {
            this.f3355f = (byte) -1;
            this.f3356g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3355f = (byte) -1;
            this.f3356g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3352c |= 1;
                                this.f3353d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3352c |= 2;
                                this.f3354e = codedInputStream.readBytes();
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
            this.f3355f = (byte) -1;
            this.f3356g = -1;
        }

        public static C0049a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f3351b;
        }

        public static C0049a g() {
            return C0049a.h();
        }

        private void j() {
            this.f3353d = "";
            this.f3354e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f3351b;
        }

        public boolean c() {
            return (this.f3352c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3353d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3353d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3352c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3354e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3354e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f3350a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3356g;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3352c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3352c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            this.f3356g = computeBytesSize;
            return computeBytesSize;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C0049a newBuilderForType() {
            return g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C0049a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3355f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3355f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3352c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3352c & 2) == 2) {
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
        public final int f3365e;

        x(int i2) {
            this.f3365e = i2;
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
            return this.f3365e;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f3366a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final y f3367b;

        /* renamed from: c  reason: collision with root package name */
        public int f3368c;

        /* renamed from: d  reason: collision with root package name */
        public r f3369d;

        /* renamed from: e  reason: collision with root package name */
        public h f3370e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3371f;

        /* renamed from: g  reason: collision with root package name */
        public long f3372g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f3373h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3374i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<y, C0050a> implements z {

            /* renamed from: a  reason: collision with root package name */
            public int f3375a;

            /* renamed from: e  reason: collision with root package name */
            public long f3379e;

            /* renamed from: b  reason: collision with root package name */
            public r f3376b = r.a();

            /* renamed from: c  reason: collision with root package name */
            public h f3377c = h.a();

            /* renamed from: d  reason: collision with root package name */
            public Object f3378d = "";

            /* renamed from: f  reason: collision with root package name */
            public List<c> f3380f = Collections.emptyList();

            public C0050a() {
                i();
            }

            private void i() {
            }

            public static C0050a j() {
                return new C0050a();
            }

            private void k() {
                if ((this.f3375a & 16) != 16) {
                    this.f3380f = new ArrayList(this.f3380f);
                    this.f3375a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0050a clear() {
                super.clear();
                this.f3376b = r.a();
                this.f3375a &= -2;
                this.f3377c = h.a();
                int i2 = this.f3375a & (-3);
                this.f3375a = i2;
                this.f3378d = "";
                int i3 = i2 & (-5);
                this.f3375a = i3;
                this.f3379e = 0L;
                this.f3375a = i3 & (-9);
                this.f3380f = Collections.emptyList();
                this.f3375a &= -17;
                return this;
            }

            public C0050a a(long j) {
                this.f3375a |= 8;
                this.f3379e = j;
                return this;
            }

            public C0050a a(h hVar) {
                if (hVar != null) {
                    this.f3377c = hVar;
                    this.f3375a |= 2;
                    return this;
                }
                throw null;
            }

            public C0050a a(r rVar) {
                if ((this.f3375a & 1) == 1 && this.f3376b != r.a()) {
                    rVar = r.a(this.f3376b).mergeFrom(rVar).buildPartial();
                }
                this.f3376b = rVar;
                this.f3375a |= 1;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0050a mergeFrom(y yVar) {
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
                    this.f3375a |= 4;
                    this.f3378d = yVar.f3371f;
                }
                if (yVar.i()) {
                    a(yVar.j());
                }
                if (!yVar.f3373h.isEmpty()) {
                    if (this.f3380f.isEmpty()) {
                        this.f3380f = yVar.f3373h;
                        this.f3375a &= -17;
                    } else {
                        k();
                        this.f3380f.addAll(yVar.f3373h);
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
            public C0050a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                y yVar = null;
                try {
                    try {
                        y parsePartialFrom = y.f3366a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public C0050a a(Iterable<? extends c> iterable) {
                k();
                AbstractMessageLite.Builder.addAll(iterable, this.f3380f);
                return this;
            }

            public C0050a a(String str) {
                if (str != null) {
                    this.f3375a |= 4;
                    this.f3378d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0050a clone() {
                return j().mergeFrom(buildPartial());
            }

            public C0050a b(h hVar) {
                if ((this.f3375a & 2) == 2 && this.f3377c != h.a()) {
                    hVar = h.a(this.f3377c).mergeFrom(hVar).buildPartial();
                }
                this.f3377c = hVar;
                this.f3375a |= 2;
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
                int i2 = this.f3375a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                yVar.f3369d = this.f3376b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                yVar.f3370e = this.f3377c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                yVar.f3371f = this.f3378d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                yVar.f3372g = this.f3379e;
                if ((this.f3375a & 16) == 16) {
                    this.f3380f = Collections.unmodifiableList(this.f3380f);
                    this.f3375a &= -17;
                }
                yVar.f3373h = this.f3380f;
                yVar.f3368c = i3;
                return yVar;
            }

            public boolean f() {
                return (this.f3375a & 2) == 2;
            }

            public h g() {
                return this.f3377c;
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
            f3367b = yVar;
            yVar.n();
        }

        public y() {
            this.f3374i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            this.f3374i = (byte) -1;
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
                                r.C0047a builder = (this.f3368c & 1) == 1 ? this.f3369d.toBuilder() : null;
                                r rVar = (r) codedInputStream.readMessage(r.f3321a, extensionRegistryLite);
                                this.f3369d = rVar;
                                if (builder != null) {
                                    builder.mergeFrom(rVar);
                                    this.f3369d = builder.buildPartial();
                                }
                                i2 = this.f3368c;
                            } else if (readTag == 330) {
                                i3 = 2;
                                h.C0042a builder2 = (this.f3368c & 2) == 2 ? this.f3370e.toBuilder() : null;
                                h hVar = (h) codedInputStream.readMessage(h.f3246a, extensionRegistryLite);
                                this.f3370e = hVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hVar);
                                    this.f3370e = builder2.buildPartial();
                                }
                                i2 = this.f3368c;
                            } else if (readTag == 1042) {
                                this.f3368c |= 4;
                                this.f3371f = codedInputStream.readBytes();
                            } else if (readTag == 1048) {
                                this.f3368c |= 8;
                                this.f3372g = codedInputStream.readInt64();
                            } else if (readTag == 1058) {
                                if (!(z2 & true)) {
                                    this.f3373h = new ArrayList();
                                    z2 |= true;
                                }
                                this.f3373h.add(codedInputStream.readMessage(c.f3207a, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                            this.f3368c = i2 | i3;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f3373h = Collections.unmodifiableList(this.f3373h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3374i = (byte) -1;
            this.j = -1;
        }

        public static C0050a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f3367b;
        }

        public static C0050a k() {
            return C0050a.j();
        }

        private void n() {
            this.f3369d = r.a();
            this.f3370e = h.a();
            this.f3371f = "";
            this.f3372g = 0L;
            this.f3373h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f3367b;
        }

        public boolean c() {
            return (this.f3368c & 1) == 1;
        }

        public r d() {
            return this.f3369d;
        }

        public boolean e() {
            return (this.f3368c & 2) == 2;
        }

        public h f() {
            return this.f3370e;
        }

        public boolean g() {
            return (this.f3368c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f3366a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.f3368c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f3369d) + 0 : 0;
            if ((this.f3368c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f3370e);
            }
            if ((this.f3368c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3368c & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3372g);
            }
            for (int i3 = 0; i3 < this.f3373h.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f3373h.get(i3));
            }
            this.j = computeMessageSize;
            return computeMessageSize;
        }

        public ByteString h() {
            Object obj = this.f3371f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3371f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3368c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3374i;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!e()) {
                this.f3374i = (byte) 0;
                return false;
            } else if (f().isInitialized()) {
                this.f3374i = (byte) 1;
                return true;
            } else {
                this.f3374i = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.f3372g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0050a newBuilderForType() {
            return k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
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
            if ((this.f3368c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.f3369d);
            }
            if ((this.f3368c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f3370e);
            }
            if ((this.f3368c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3368c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3372g);
            }
            for (int i2 = 0; i2 < this.f3373h.size(); i2++) {
                codedOutputStream.writeMessage(132, this.f3373h.get(i2));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
