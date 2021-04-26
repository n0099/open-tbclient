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
        public static Parser<C0036a> f3140a = new AbstractParser<C0036a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0036a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0036a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0036a f3141b;

        /* renamed from: c  reason: collision with root package name */
        public int f3142c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3143d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3144e;

        /* renamed from: f  reason: collision with root package name */
        public long f3145f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3146g;

        /* renamed from: h  reason: collision with root package name */
        public long f3147h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3148i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0037a extends GeneratedMessageLite.Builder<C0036a, C0037a> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3149a;

            /* renamed from: d  reason: collision with root package name */
            public long f3152d;

            /* renamed from: f  reason: collision with root package name */
            public long f3154f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3150b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3151c = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3153e = "";

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
                this.f3150b = "";
                int i2 = this.f3149a & (-2);
                this.f3149a = i2;
                this.f3151c = "";
                int i3 = i2 & (-3);
                this.f3149a = i3;
                this.f3152d = 0L;
                int i4 = i3 & (-5);
                this.f3149a = i4;
                this.f3153e = "";
                int i5 = i4 & (-9);
                this.f3149a = i5;
                this.f3154f = 0L;
                this.f3149a = i5 & (-17);
                return this;
            }

            public C0037a a(long j) {
                this.f3149a |= 4;
                this.f3152d = j;
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
                    this.f3149a |= 1;
                    this.f3150b = c0036a.f3143d;
                }
                if (c0036a.e()) {
                    this.f3149a |= 2;
                    this.f3151c = c0036a.f3144e;
                }
                if (c0036a.g()) {
                    a(c0036a.h());
                }
                if (c0036a.i()) {
                    this.f3149a |= 8;
                    this.f3153e = c0036a.f3146g;
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
                        C0036a parsePartialFrom = C0036a.f3140a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3149a |= 1;
                    this.f3150b = str;
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
                this.f3149a |= 16;
                this.f3154f = j;
                return this;
            }

            public C0037a b(String str) {
                if (str != null) {
                    this.f3149a |= 2;
                    return this;
                }
                throw null;
            }

            public C0037a c(String str) {
                if (str != null) {
                    this.f3149a |= 8;
                    this.f3153e = str;
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
                int i2 = this.f3149a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0036a.f3143d = this.f3150b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0036a.f3144e = this.f3151c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0036a.f3145f = this.f3152d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0036a.f3146g = this.f3153e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0036a.f3147h = this.f3154f;
                c0036a.f3142c = i3;
                return c0036a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0036a c0036a = new C0036a();
            f3141b = c0036a;
            c0036a.p();
        }

        public C0036a() {
            this.f3148i = (byte) -1;
            this.j = -1;
        }

        public C0036a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3148i = (byte) -1;
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
                                    this.f3142c |= 1;
                                    this.f3143d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3142c |= 2;
                                    this.f3144e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3142c |= 4;
                                    this.f3145f = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.f3142c |= 8;
                                    this.f3146g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3142c |= 16;
                                    this.f3147h = codedInputStream.readInt64();
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
            this.f3148i = (byte) -1;
            this.j = -1;
        }

        public static C0037a a(C0036a c0036a) {
            return m().mergeFrom(c0036a);
        }

        public static C0036a a() {
            return f3141b;
        }

        public static C0037a m() {
            return C0037a.h();
        }

        private void p() {
            this.f3143d = "";
            this.f3144e = "";
            this.f3145f = 0L;
            this.f3146g = "";
            this.f3147h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0036a getDefaultInstanceForType() {
            return f3141b;
        }

        public boolean c() {
            return (this.f3142c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3143d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3143d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3142c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3144e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3144e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3142c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0036a> getParserForType() {
            return f3140a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3142c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3142c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3142c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3145f);
            }
            if ((this.f3142c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3142c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3147h);
            }
            this.j = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3145f;
        }

        public boolean i() {
            return (this.f3142c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3148i;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3148i = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.f3146g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3146g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3142c & 16) == 16;
        }

        public long l() {
            return this.f3147h;
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
            if ((this.f3142c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3142c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3142c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3145f);
            }
            if ((this.f3142c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3142c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3147h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f3155a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final aa f3156b;

        /* renamed from: c  reason: collision with root package name */
        public int f3157c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3158d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3159e;

        /* renamed from: f  reason: collision with root package name */
        public long f3160f;

        /* renamed from: g  reason: collision with root package name */
        public long f3161g;

        /* renamed from: h  reason: collision with root package name */
        public long f3162h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3163i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0038a extends GeneratedMessageLite.Builder<aa, C0038a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            public int f3164a;

            /* renamed from: d  reason: collision with root package name */
            public long f3167d;

            /* renamed from: e  reason: collision with root package name */
            public long f3168e;

            /* renamed from: f  reason: collision with root package name */
            public long f3169f;

            /* renamed from: h  reason: collision with root package name */
            public long f3171h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3165b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3166c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3170g = "";

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
                this.f3165b = "";
                int i2 = this.f3164a & (-2);
                this.f3164a = i2;
                this.f3166c = "";
                int i3 = i2 & (-3);
                this.f3164a = i3;
                this.f3167d = 0L;
                int i4 = i3 & (-5);
                this.f3164a = i4;
                this.f3168e = 0L;
                int i5 = i4 & (-9);
                this.f3164a = i5;
                this.f3169f = 0L;
                int i6 = i5 & (-17);
                this.f3164a = i6;
                this.f3170g = "";
                int i7 = i6 & (-33);
                this.f3164a = i7;
                this.f3171h = 0L;
                this.f3164a = i7 & (-65);
                return this;
            }

            public C0038a a(long j) {
                this.f3164a |= 4;
                this.f3167d = j;
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
                    this.f3164a |= 1;
                    this.f3165b = aaVar.f3158d;
                }
                if (aaVar.e()) {
                    this.f3164a |= 2;
                    this.f3166c = aaVar.f3159e;
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
                    this.f3164a |= 32;
                    this.f3170g = aaVar.f3163i;
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
                        aa parsePartialFrom = aa.f3155a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3164a |= 1;
                    this.f3165b = str;
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
                this.f3164a |= 8;
                this.f3168e = j;
                return this;
            }

            public C0038a b(String str) {
                if (str != null) {
                    this.f3164a |= 2;
                    this.f3166c = str;
                    return this;
                }
                throw null;
            }

            public C0038a c(long j) {
                this.f3164a |= 16;
                this.f3169f = j;
                return this;
            }

            public C0038a c(String str) {
                if (str != null) {
                    this.f3164a |= 32;
                    this.f3170g = str;
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
                this.f3164a |= 64;
                this.f3171h = j;
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
                int i2 = this.f3164a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aaVar.f3158d = this.f3165b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aaVar.f3159e = this.f3166c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aaVar.f3160f = this.f3167d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aaVar.f3161g = this.f3168e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aaVar.f3162h = this.f3169f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aaVar.f3163i = this.f3170g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aaVar.j = this.f3171h;
                aaVar.f3157c = i3;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            aa aaVar = new aa();
            f3156b = aaVar;
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
                                this.f3157c |= 1;
                                this.f3158d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3157c |= 2;
                                this.f3159e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3157c |= 4;
                                this.f3160f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3157c |= 8;
                                this.f3161g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3157c |= 16;
                                this.f3162h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3157c |= 32;
                                this.f3163i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3157c |= 64;
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
            return f3156b;
        }

        public static C0038a q() {
            return C0038a.h();
        }

        private void t() {
            this.f3158d = "";
            this.f3159e = "";
            this.f3160f = 0L;
            this.f3161g = 0L;
            this.f3162h = 0L;
            this.f3163i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f3156b;
        }

        public boolean c() {
            return (this.f3157c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3158d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3158d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3157c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3159e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3159e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3157c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            return f3155a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3157c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3157c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3157c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3160f);
            }
            if ((this.f3157c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3161g);
            }
            if ((this.f3157c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3162h);
            }
            if ((this.f3157c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3157c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3160f;
        }

        public boolean i() {
            return (this.f3157c & 8) == 8;
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
            return this.f3161g;
        }

        public boolean k() {
            return (this.f3157c & 16) == 16;
        }

        public long l() {
            return this.f3162h;
        }

        public boolean m() {
            return (this.f3157c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3163i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3163i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3157c & 64) == 64;
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
            if ((this.f3157c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3157c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3157c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3160f);
            }
            if ((this.f3157c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3161g);
            }
            if ((this.f3157c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3162h);
            }
            if ((this.f3157c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3157c & 64) == 64) {
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
        public static Parser<ac> f3172a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ac f3173b;

        /* renamed from: c  reason: collision with root package name */
        public int f3174c;

        /* renamed from: d  reason: collision with root package name */
        public x f3175d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3176e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3177f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3178g;

        /* renamed from: h  reason: collision with root package name */
        public int f3179h;

        /* renamed from: i  reason: collision with root package name */
        public int f3180i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039a extends GeneratedMessageLite.Builder<ac, C0039a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            public int f3181a;

            /* renamed from: b  reason: collision with root package name */
            public x f3182b = x.OS_TYPE_UNKNWON;

            /* renamed from: c  reason: collision with root package name */
            public Object f3183c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3184d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3185e = "";

            /* renamed from: f  reason: collision with root package name */
            public int f3186f;

            /* renamed from: g  reason: collision with root package name */
            public int f3187g;

            /* renamed from: h  reason: collision with root package name */
            public int f3188h;

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
                this.f3182b = x.OS_TYPE_UNKNWON;
                int i2 = this.f3181a & (-2);
                this.f3181a = i2;
                this.f3183c = "";
                int i3 = i2 & (-3);
                this.f3181a = i3;
                this.f3184d = "";
                int i4 = i3 & (-5);
                this.f3181a = i4;
                this.f3185e = "";
                int i5 = i4 & (-9);
                this.f3181a = i5;
                this.f3186f = 0;
                int i6 = i5 & (-17);
                this.f3181a = i6;
                this.f3187g = 0;
                int i7 = i6 & (-33);
                this.f3181a = i7;
                this.f3188h = 0;
                this.f3181a = i7 & (-65);
                return this;
            }

            public C0039a a(int i2) {
                this.f3181a |= 16;
                this.f3186f = i2;
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
                    this.f3181a |= 2;
                    this.f3183c = acVar.f3176e;
                }
                if (acVar.g()) {
                    this.f3181a |= 4;
                    this.f3184d = acVar.f3177f;
                }
                if (acVar.i()) {
                    this.f3181a |= 8;
                    this.f3185e = acVar.f3178g;
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
                    this.f3181a |= 1;
                    this.f3182b = xVar;
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
                        ac parsePartialFrom = ac.f3172a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3181a |= 2;
                    this.f3183c = str;
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
                this.f3181a |= 32;
                this.f3187g = i2;
                return this;
            }

            public C0039a b(String str) {
                if (str != null) {
                    this.f3181a |= 4;
                    this.f3184d = str;
                    return this;
                }
                throw null;
            }

            public C0039a c(int i2) {
                this.f3181a |= 64;
                this.f3188h = i2;
                return this;
            }

            public C0039a c(String str) {
                if (str != null) {
                    this.f3181a |= 8;
                    this.f3185e = str;
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
                int i2 = this.f3181a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                acVar.f3175d = this.f3182b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                acVar.f3176e = this.f3183c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                acVar.f3177f = this.f3184d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                acVar.f3178g = this.f3185e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                acVar.f3179h = this.f3186f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                acVar.f3180i = this.f3187g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                acVar.j = this.f3188h;
                acVar.f3174c = i3;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ac acVar = new ac();
            f3173b = acVar;
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
                                        this.f3174c = 1 | this.f3174c;
                                        this.f3175d = a2;
                                    }
                                } else if (readTag == 18) {
                                    this.f3174c |= 2;
                                    this.f3176e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3174c |= 4;
                                    this.f3177f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f3174c |= 8;
                                    this.f3178g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3174c |= 16;
                                    this.f3179h = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.f3174c |= 32;
                                    this.f3180i = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.f3174c |= 64;
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
            return f3173b;
        }

        public static C0039a q() {
            return C0039a.h();
        }

        private void t() {
            this.f3175d = x.OS_TYPE_UNKNWON;
            this.f3176e = "";
            this.f3177f = "";
            this.f3178g = "";
            this.f3179h = 0;
            this.f3180i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f3173b;
        }

        public boolean c() {
            return (this.f3174c & 1) == 1;
        }

        public x d() {
            return this.f3175d;
        }

        public boolean e() {
            return (this.f3174c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3176e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3176e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3174c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            return f3172a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3174c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3175d.getNumber()) : 0;
            if ((this.f3174c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3174c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3174c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3174c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f3179h);
            }
            if ((this.f3174c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.f3180i);
            }
            if ((this.f3174c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
            }
            this.l = computeEnumSize;
            return computeEnumSize;
        }

        public ByteString h() {
            Object obj = this.f3177f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3177f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3174c & 8) == 8;
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
            Object obj = this.f3178g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3178g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3174c & 16) == 16;
        }

        public int l() {
            return this.f3179h;
        }

        public boolean m() {
            return (this.f3174c & 32) == 32;
        }

        public int n() {
            return this.f3180i;
        }

        public boolean o() {
            return (this.f3174c & 64) == 64;
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
            if ((this.f3174c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3175d.getNumber());
            }
            if ((this.f3174c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3174c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3174c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3174c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.f3179h);
            }
            if ((this.f3174c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.f3180i);
            }
            if ((this.f3174c & 64) == 64) {
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
        public static Parser<ae> f3189a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ae f3190b;

        /* renamed from: c  reason: collision with root package name */
        public int f3191c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3192d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3193e;

        /* renamed from: f  reason: collision with root package name */
        public long f3194f;

        /* renamed from: g  reason: collision with root package name */
        public long f3195g;

        /* renamed from: h  reason: collision with root package name */
        public long f3196h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3197i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0040a extends GeneratedMessageLite.Builder<ae, C0040a> implements af {

            /* renamed from: a  reason: collision with root package name */
            public int f3198a;

            /* renamed from: d  reason: collision with root package name */
            public long f3201d;

            /* renamed from: e  reason: collision with root package name */
            public long f3202e;

            /* renamed from: f  reason: collision with root package name */
            public long f3203f;

            /* renamed from: h  reason: collision with root package name */
            public long f3205h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3199b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3200c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3204g = "";

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
                this.f3199b = "";
                int i2 = this.f3198a & (-2);
                this.f3198a = i2;
                this.f3200c = "";
                int i3 = i2 & (-3);
                this.f3198a = i3;
                this.f3201d = 0L;
                int i4 = i3 & (-5);
                this.f3198a = i4;
                this.f3202e = 0L;
                int i5 = i4 & (-9);
                this.f3198a = i5;
                this.f3203f = 0L;
                int i6 = i5 & (-17);
                this.f3198a = i6;
                this.f3204g = "";
                int i7 = i6 & (-33);
                this.f3198a = i7;
                this.f3205h = 0L;
                this.f3198a = i7 & (-65);
                return this;
            }

            public C0040a a(long j) {
                this.f3198a |= 4;
                this.f3201d = j;
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
                    this.f3198a |= 1;
                    this.f3199b = aeVar.f3192d;
                }
                if (aeVar.e()) {
                    this.f3198a |= 2;
                    this.f3200c = aeVar.f3193e;
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
                    this.f3198a |= 32;
                    this.f3204g = aeVar.f3197i;
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
                        ae parsePartialFrom = ae.f3189a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                this.f3198a |= 8;
                this.f3202e = j;
                return this;
            }

            public C0040a c(long j) {
                this.f3198a |= 16;
                this.f3203f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0040a d(long j) {
                this.f3198a |= 64;
                this.f3205h = j;
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
                int i2 = this.f3198a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                aeVar.f3192d = this.f3199b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                aeVar.f3193e = this.f3200c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                aeVar.f3194f = this.f3201d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                aeVar.f3195g = this.f3202e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                aeVar.f3196h = this.f3203f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                aeVar.f3197i = this.f3204g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                aeVar.j = this.f3205h;
                aeVar.f3191c = i3;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ae aeVar = new ae();
            f3190b = aeVar;
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
                                this.f3191c |= 1;
                                this.f3192d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3191c |= 2;
                                this.f3193e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3191c |= 4;
                                this.f3194f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3191c |= 8;
                                this.f3195g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3191c |= 16;
                                this.f3196h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3191c |= 32;
                                this.f3197i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3191c |= 64;
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
            return f3190b;
        }

        public static C0040a q() {
            return C0040a.h();
        }

        private void t() {
            this.f3192d = "";
            this.f3193e = "";
            this.f3194f = 0L;
            this.f3195g = 0L;
            this.f3196h = 0L;
            this.f3197i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f3190b;
        }

        public boolean c() {
            return (this.f3191c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3192d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3192d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3191c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3193e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3193e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3191c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            return f3189a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3191c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3191c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3191c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3194f);
            }
            if ((this.f3191c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3195g);
            }
            if ((this.f3191c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3196h);
            }
            if ((this.f3191c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3191c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3194f;
        }

        public boolean i() {
            return (this.f3191c & 8) == 8;
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
            return this.f3195g;
        }

        public boolean k() {
            return (this.f3191c & 16) == 16;
        }

        public long l() {
            return this.f3196h;
        }

        public boolean m() {
            return (this.f3191c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3197i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3197i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3191c & 64) == 64;
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
            if ((this.f3191c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3191c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3191c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3194f);
            }
            if ((this.f3191c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3195g);
            }
            if ((this.f3191c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3196h);
            }
            if ((this.f3191c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3191c & 64) == 64) {
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
        public static Parser<c> f3206a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3207b;

        /* renamed from: c  reason: collision with root package name */
        public int f3208c;

        /* renamed from: d  reason: collision with root package name */
        public e f3209d;

        /* renamed from: e  reason: collision with root package name */
        public ae f3210e;

        /* renamed from: f  reason: collision with root package name */
        public l f3211f;

        /* renamed from: g  reason: collision with root package name */
        public n f3212g;

        /* renamed from: h  reason: collision with root package name */
        public j f3213h;

        /* renamed from: i  reason: collision with root package name */
        public aa f3214i;
        public C0036a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041a extends GeneratedMessageLite.Builder<c, C0041a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3215a;

            /* renamed from: b  reason: collision with root package name */
            public e f3216b = e.UI;

            /* renamed from: c  reason: collision with root package name */
            public ae f3217c = ae.a();

            /* renamed from: d  reason: collision with root package name */
            public l f3218d = l.a();

            /* renamed from: e  reason: collision with root package name */
            public n f3219e = n.a();

            /* renamed from: f  reason: collision with root package name */
            public j f3220f = j.a();

            /* renamed from: g  reason: collision with root package name */
            public aa f3221g = aa.a();

            /* renamed from: h  reason: collision with root package name */
            public C0036a f3222h = C0036a.a();

            /* renamed from: i  reason: collision with root package name */
            public t f3223i = t.a();

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
                this.f3216b = e.UI;
                this.f3215a &= -2;
                this.f3217c = ae.a();
                this.f3215a &= -3;
                this.f3218d = l.a();
                this.f3215a &= -5;
                this.f3219e = n.a();
                this.f3215a &= -9;
                this.f3220f = j.a();
                this.f3215a &= -17;
                this.f3221g = aa.a();
                this.f3215a &= -33;
                this.f3222h = C0036a.a();
                this.f3215a &= -65;
                this.f3223i = t.a();
                this.f3215a &= -129;
                return this;
            }

            public C0041a a(C0036a c0036a) {
                if (c0036a != null) {
                    this.f3222h = c0036a;
                    this.f3215a |= 64;
                    return this;
                }
                throw null;
            }

            public C0041a a(aa aaVar) {
                if (aaVar != null) {
                    this.f3221g = aaVar;
                    this.f3215a |= 32;
                    return this;
                }
                throw null;
            }

            public C0041a a(ae aeVar) {
                if ((this.f3215a & 2) == 2 && this.f3217c != ae.a()) {
                    aeVar = ae.a(this.f3217c).mergeFrom(aeVar).buildPartial();
                }
                this.f3217c = aeVar;
                this.f3215a |= 2;
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
                    this.f3215a |= 1;
                    this.f3216b = eVar;
                    return this;
                }
                throw null;
            }

            public C0041a a(j jVar) {
                if (jVar != null) {
                    this.f3220f = jVar;
                    this.f3215a |= 16;
                    return this;
                }
                throw null;
            }

            public C0041a a(l lVar) {
                if (lVar != null) {
                    this.f3218d = lVar;
                    this.f3215a |= 4;
                    return this;
                }
                throw null;
            }

            public C0041a a(n nVar) {
                if (nVar != null) {
                    this.f3219e = nVar;
                    this.f3215a |= 8;
                    return this;
                }
                throw null;
            }

            public C0041a a(t tVar) {
                if ((this.f3215a & 128) == 128 && this.f3223i != t.a()) {
                    tVar = t.a(this.f3223i).mergeFrom(tVar).buildPartial();
                }
                this.f3223i = tVar;
                this.f3215a |= 128;
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
                        c parsePartialFrom = c.f3206a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                if ((this.f3215a & 64) == 64 && this.f3222h != C0036a.a()) {
                    c0036a = C0036a.a(this.f3222h).mergeFrom(c0036a).buildPartial();
                }
                this.f3222h = c0036a;
                this.f3215a |= 64;
                return this;
            }

            public C0041a b(aa aaVar) {
                if ((this.f3215a & 32) == 32 && this.f3221g != aa.a()) {
                    aaVar = aa.a(this.f3221g).mergeFrom(aaVar).buildPartial();
                }
                this.f3221g = aaVar;
                this.f3215a |= 32;
                return this;
            }

            public C0041a b(j jVar) {
                if ((this.f3215a & 16) == 16 && this.f3220f != j.a()) {
                    jVar = j.a(this.f3220f).mergeFrom(jVar).buildPartial();
                }
                this.f3220f = jVar;
                this.f3215a |= 16;
                return this;
            }

            public C0041a b(l lVar) {
                if ((this.f3215a & 4) == 4 && this.f3218d != l.a()) {
                    lVar = l.a(this.f3218d).mergeFrom(lVar).buildPartial();
                }
                this.f3218d = lVar;
                this.f3215a |= 4;
                return this;
            }

            public C0041a b(n nVar) {
                if ((this.f3215a & 8) == 8 && this.f3219e != n.a()) {
                    nVar = n.a(this.f3219e).mergeFrom(nVar).buildPartial();
                }
                this.f3219e = nVar;
                this.f3215a |= 8;
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
                int i2 = this.f3215a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3209d = this.f3216b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3210e = this.f3217c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3211f = this.f3218d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                cVar.f3212g = this.f3219e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                cVar.f3213h = this.f3220f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                cVar.f3214i = this.f3221g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                cVar.j = this.f3222h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                cVar.k = this.f3223i;
                cVar.f3208c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3207b = cVar;
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
                                    ae.C0040a builder = (this.f3208c & 2) == 2 ? this.f3210e.toBuilder() : null;
                                    ae aeVar = (ae) codedInputStream.readMessage(ae.f3189a, extensionRegistryLite);
                                    this.f3210e = aeVar;
                                    if (builder != null) {
                                        builder.mergeFrom(aeVar);
                                        this.f3210e = builder.buildPartial();
                                    }
                                    i3 = this.f3208c;
                                } else if (readTag == 26) {
                                    i2 = 4;
                                    l.C0045a builder2 = (this.f3208c & 4) == 4 ? this.f3211f.toBuilder() : null;
                                    l lVar = (l) codedInputStream.readMessage(l.f3280a, extensionRegistryLite);
                                    this.f3211f = lVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar);
                                        this.f3211f = builder2.buildPartial();
                                    }
                                    i3 = this.f3208c;
                                } else if (readTag == 34) {
                                    n.C0046a builder3 = (this.f3208c & 8) == 8 ? this.f3212g.toBuilder() : null;
                                    n nVar = (n) codedInputStream.readMessage(n.f3294a, extensionRegistryLite);
                                    this.f3212g = nVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(nVar);
                                        this.f3212g = builder3.buildPartial();
                                    }
                                    this.f3208c |= 8;
                                } else if (readTag == 42) {
                                    i2 = 16;
                                    j.C0044a builder4 = (this.f3208c & 16) == 16 ? this.f3213h.toBuilder() : null;
                                    j jVar = (j) codedInputStream.readMessage(j.f3263a, extensionRegistryLite);
                                    this.f3213h = jVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(jVar);
                                        this.f3213h = builder4.buildPartial();
                                    }
                                    i3 = this.f3208c;
                                } else if (readTag == 50) {
                                    i2 = 32;
                                    aa.C0038a builder5 = (this.f3208c & 32) == 32 ? this.f3214i.toBuilder() : null;
                                    aa aaVar = (aa) codedInputStream.readMessage(aa.f3155a, extensionRegistryLite);
                                    this.f3214i = aaVar;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(aaVar);
                                        this.f3214i = builder5.buildPartial();
                                    }
                                    i3 = this.f3208c;
                                } else if (readTag == 58) {
                                    i2 = 64;
                                    C0036a.C0037a builder6 = (this.f3208c & 64) == 64 ? this.j.toBuilder() : null;
                                    C0036a c0036a = (C0036a) codedInputStream.readMessage(C0036a.f3140a, extensionRegistryLite);
                                    this.j = c0036a;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(c0036a);
                                        this.j = builder6.buildPartial();
                                    }
                                    i3 = this.f3208c;
                                } else if (readTag == 66) {
                                    i2 = 128;
                                    t.C0049a builder7 = (this.f3208c & 128) == 128 ? this.k.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.f3332a, extensionRegistryLite);
                                    this.k = tVar;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(tVar);
                                        this.k = builder7.buildPartial();
                                    }
                                    i3 = this.f3208c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3208c = i3 | i2;
                            } else {
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f3208c = 1 | this.f3208c;
                                    this.f3209d = a2;
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
            return f3207b;
        }

        public static C0041a s() {
            return C0041a.h();
        }

        private void v() {
            this.f3209d = e.UI;
            this.f3210e = ae.a();
            this.f3211f = l.a();
            this.f3212g = n.a();
            this.f3213h = j.a();
            this.f3214i = aa.a();
            this.j = C0036a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3207b;
        }

        public boolean c() {
            return (this.f3208c & 1) == 1;
        }

        public e d() {
            return this.f3209d;
        }

        public boolean e() {
            return (this.f3208c & 2) == 2;
        }

        public ae f() {
            return this.f3210e;
        }

        public boolean g() {
            return (this.f3208c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3206a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.f3208c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3209d.getNumber()) : 0;
            if ((this.f3208c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f3210e);
            }
            if ((this.f3208c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f3211f);
            }
            if ((this.f3208c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f3212g);
            }
            if ((this.f3208c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f3213h);
            }
            if ((this.f3208c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.f3214i);
            }
            if ((this.f3208c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
            }
            if ((this.f3208c & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
            }
            this.m = computeEnumSize;
            return computeEnumSize;
        }

        public l h() {
            return this.f3211f;
        }

        public boolean i() {
            return (this.f3208c & 8) == 8;
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
            return this.f3212g;
        }

        public boolean k() {
            return (this.f3208c & 16) == 16;
        }

        public j l() {
            return this.f3213h;
        }

        public boolean m() {
            return (this.f3208c & 32) == 32;
        }

        public aa n() {
            return this.f3214i;
        }

        public boolean o() {
            return (this.f3208c & 64) == 64;
        }

        public C0036a p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3208c & 128) == 128;
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
            if ((this.f3208c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3209d.getNumber());
            }
            if ((this.f3208c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.f3210e);
            }
            if ((this.f3208c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3211f);
            }
            if ((this.f3208c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f3212g);
            }
            if ((this.f3208c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.f3213h);
            }
            if ((this.f3208c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.f3214i);
            }
            if ((this.f3208c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.f3208c & 128) == 128) {
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
        public final int f3232h;

        e(int i2) {
            this.f3232h = i2;
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
            return this.f3232h;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f3233a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final f f3234b;

        /* renamed from: c  reason: collision with root package name */
        public int f3235c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3236d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3237e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3238f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3239g;

        /* renamed from: h  reason: collision with root package name */
        public int f3240h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0042a extends GeneratedMessageLite.Builder<f, C0042a> implements g {

            /* renamed from: a  reason: collision with root package name */
            public int f3241a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3242b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3243c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3244d = "";

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
                this.f3242b = "";
                int i2 = this.f3241a & (-2);
                this.f3241a = i2;
                this.f3243c = "";
                int i3 = i2 & (-3);
                this.f3241a = i3;
                this.f3244d = "";
                this.f3241a = i3 & (-5);
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
                    this.f3241a |= 1;
                    this.f3242b = fVar.f3236d;
                }
                if (fVar.e()) {
                    this.f3241a |= 2;
                    this.f3243c = fVar.f3237e;
                }
                if (fVar.g()) {
                    this.f3241a |= 4;
                    this.f3244d = fVar.f3238f;
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
                        f parsePartialFrom = f.f3233a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3241a |= 1;
                    this.f3242b = str;
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
                    this.f3241a |= 2;
                    this.f3243c = str;
                    return this;
                }
                throw null;
            }

            public C0042a c(String str) {
                if (str != null) {
                    this.f3241a |= 4;
                    this.f3244d = str;
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
                int i2 = this.f3241a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                fVar.f3236d = this.f3242b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                fVar.f3237e = this.f3243c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                fVar.f3238f = this.f3244d;
                fVar.f3235c = i3;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f fVar = new f();
            f3234b = fVar;
            fVar.l();
        }

        public f() {
            this.f3239g = (byte) -1;
            this.f3240h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3239g = (byte) -1;
            this.f3240h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3235c |= 1;
                                    this.f3236d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3235c |= 2;
                                    this.f3237e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3235c |= 4;
                                    this.f3238f = codedInputStream.readBytes();
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
            this.f3239g = (byte) -1;
            this.f3240h = -1;
        }

        public static C0042a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f3234b;
        }

        public static C0042a i() {
            return C0042a.h();
        }

        private void l() {
            this.f3236d = "";
            this.f3237e = "";
            this.f3238f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f3234b;
        }

        public boolean c() {
            return (this.f3235c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3236d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3236d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3235c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3237e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3237e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3235c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            return f3233a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3240h;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3235c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3235c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3235c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3240h = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3238f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3238f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3239g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3239g = (byte) 1;
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
            if ((this.f3235c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3235c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3235c & 4) == 4) {
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
        public static Parser<h> f3245a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final h f3246b;

        /* renamed from: c  reason: collision with root package name */
        public int f3247c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3248d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3249e;

        /* renamed from: f  reason: collision with root package name */
        public p f3250f;

        /* renamed from: g  reason: collision with root package name */
        public long f3251g;

        /* renamed from: h  reason: collision with root package name */
        public long f3252h;

        /* renamed from: i  reason: collision with root package name */
        public ac f3253i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<h, C0043a> implements i {

            /* renamed from: a  reason: collision with root package name */
            public int f3254a;

            /* renamed from: e  reason: collision with root package name */
            public long f3258e;

            /* renamed from: f  reason: collision with root package name */
            public long f3259f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3255b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3256c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f3257d = p.a();

            /* renamed from: g  reason: collision with root package name */
            public ac f3260g = ac.a();

            /* renamed from: h  reason: collision with root package name */
            public f f3261h = f.a();

            /* renamed from: i  reason: collision with root package name */
            public v f3262i = v.a();

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
                this.f3255b = "";
                int i2 = this.f3254a & (-2);
                this.f3254a = i2;
                this.f3256c = "";
                this.f3254a = i2 & (-3);
                this.f3257d = p.a();
                int i3 = this.f3254a & (-5);
                this.f3254a = i3;
                this.f3258e = 0L;
                int i4 = i3 & (-9);
                this.f3254a = i4;
                this.f3259f = 0L;
                this.f3254a = i4 & (-17);
                this.f3260g = ac.a();
                this.f3254a &= -33;
                this.f3261h = f.a();
                this.f3254a &= -65;
                this.f3262i = v.a();
                this.f3254a &= -129;
                return this;
            }

            public C0043a a(long j) {
                this.f3254a |= 8;
                this.f3258e = j;
                return this;
            }

            public C0043a a(ac acVar) {
                if (acVar != null) {
                    this.f3260g = acVar;
                    this.f3254a |= 32;
                    return this;
                }
                throw null;
            }

            public C0043a a(f fVar) {
                if (fVar != null) {
                    this.f3261h = fVar;
                    this.f3254a |= 64;
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
                    this.f3254a |= 1;
                    this.f3255b = hVar.f3248d;
                }
                if (hVar.e()) {
                    this.f3254a |= 2;
                    this.f3256c = hVar.f3249e;
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
                    this.f3257d = pVar;
                    this.f3254a |= 4;
                    return this;
                }
                throw null;
            }

            public C0043a a(v vVar) {
                if (vVar != null) {
                    this.f3262i = vVar;
                    this.f3254a |= 128;
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
                        h parsePartialFrom = h.f3245a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                this.f3254a |= 16;
                this.f3259f = j;
                return this;
            }

            public C0043a b(ac acVar) {
                if ((this.f3254a & 32) == 32 && this.f3260g != ac.a()) {
                    acVar = ac.a(this.f3260g).mergeFrom(acVar).buildPartial();
                }
                this.f3260g = acVar;
                this.f3254a |= 32;
                return this;
            }

            public C0043a b(f fVar) {
                if ((this.f3254a & 64) == 64 && this.f3261h != f.a()) {
                    fVar = f.a(this.f3261h).mergeFrom(fVar).buildPartial();
                }
                this.f3261h = fVar;
                this.f3254a |= 64;
                return this;
            }

            public C0043a b(p pVar) {
                if ((this.f3254a & 4) == 4 && this.f3257d != p.a()) {
                    pVar = p.a(this.f3257d).mergeFrom(pVar).buildPartial();
                }
                this.f3257d = pVar;
                this.f3254a |= 4;
                return this;
            }

            public C0043a b(v vVar) {
                if ((this.f3254a & 128) == 128 && this.f3262i != v.a()) {
                    vVar = v.a(this.f3262i).mergeFrom(vVar).buildPartial();
                }
                this.f3262i = vVar;
                this.f3254a |= 128;
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
                int i2 = this.f3254a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                hVar.f3248d = this.f3255b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                hVar.f3249e = this.f3256c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                hVar.f3250f = this.f3257d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                hVar.f3251g = this.f3258e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                hVar.f3252h = this.f3259f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                hVar.f3253i = this.f3260g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                hVar.j = this.f3261h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                hVar.k = this.f3262i;
                hVar.f3247c = i3;
                return hVar;
            }

            public boolean f() {
                return (this.f3254a & 4) == 4;
            }

            public p g() {
                return this.f3257d;
            }

            public boolean h() {
                return (this.f3254a & 8) == 8;
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
            f3246b = hVar;
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
                                this.f3247c |= 1;
                                this.f3248d = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (readTag == 58) {
                                    i2 = 4;
                                    p.C0047a builder = (this.f3247c & 4) == 4 ? this.f3250f.toBuilder() : null;
                                    p pVar = (p) codedInputStream.readMessage(p.f3312a, extensionRegistryLite);
                                    this.f3250f = pVar;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar);
                                        this.f3250f = builder.buildPartial();
                                    }
                                    i3 = this.f3247c;
                                } else if (readTag == 80) {
                                    this.f3247c |= 8;
                                    this.f3251g = codedInputStream.readInt64();
                                } else if (readTag == 96) {
                                    this.f3247c |= 16;
                                    this.f3252h = codedInputStream.readInt64();
                                } else if (readTag == 162) {
                                    i2 = 32;
                                    ac.C0039a builder2 = (this.f3247c & 32) == 32 ? this.f3253i.toBuilder() : null;
                                    ac acVar = (ac) codedInputStream.readMessage(ac.f3172a, extensionRegistryLite);
                                    this.f3253i = acVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(acVar);
                                        this.f3253i = builder2.buildPartial();
                                    }
                                    i3 = this.f3247c;
                                } else if (readTag == 170) {
                                    i2 = 64;
                                    f.C0042a builder3 = (this.f3247c & 64) == 64 ? this.j.toBuilder() : null;
                                    f fVar = (f) codedInputStream.readMessage(f.f3233a, extensionRegistryLite);
                                    this.j = fVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(fVar);
                                        this.j = builder3.buildPartial();
                                    }
                                    i3 = this.f3247c;
                                } else if (readTag == 178) {
                                    i2 = 128;
                                    v.C0050a builder4 = (this.f3247c & 128) == 128 ? this.k.toBuilder() : null;
                                    v vVar = (v) codedInputStream.readMessage(v.f3349a, extensionRegistryLite);
                                    this.k = vVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(vVar);
                                        this.k = builder4.buildPartial();
                                    }
                                    i3 = this.f3247c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3247c = i3 | i2;
                            } else {
                                this.f3247c |= 2;
                                this.f3249e = codedInputStream.readBytes();
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
            return f3246b;
        }

        public static C0043a t() {
            return C0043a.k();
        }

        private void v() {
            this.f3248d = "";
            this.f3249e = "";
            this.f3250f = p.a();
            this.f3251g = 0L;
            this.f3252h = 0L;
            this.f3253i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f3246b;
        }

        public boolean c() {
            return (this.f3247c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3248d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3248d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3247c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3249e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3249e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3247c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            return f3245a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.m;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3247c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3247c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3247c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f3250f);
            }
            if ((this.f3247c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f3251g);
            }
            if ((this.f3247c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f3252h);
            }
            if ((this.f3247c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.f3253i);
            }
            if ((this.f3247c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
            }
            if ((this.f3247c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
            }
            this.m = computeBytesSize;
            return computeBytesSize;
        }

        public p h() {
            return this.f3250f;
        }

        public boolean i() {
            return (this.f3247c & 8) == 8;
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
            return this.f3251g;
        }

        public boolean k() {
            return (this.f3247c & 16) == 16;
        }

        public long l() {
            return this.f3252h;
        }

        public boolean m() {
            return (this.f3247c & 32) == 32;
        }

        public ac n() {
            return this.f3253i;
        }

        public boolean o() {
            return (this.f3247c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3247c & 128) == 128;
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
            if ((this.f3247c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3247c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3247c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f3250f);
            }
            if ((this.f3247c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.f3251g);
            }
            if ((this.f3247c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.f3252h);
            }
            if ((this.f3247c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.f3253i);
            }
            if ((this.f3247c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.f3247c & 128) == 128) {
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
        public static Parser<j> f3263a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final j f3264b;

        /* renamed from: c  reason: collision with root package name */
        public int f3265c;

        /* renamed from: d  reason: collision with root package name */
        public long f3266d;

        /* renamed from: e  reason: collision with root package name */
        public long f3267e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3268f;

        /* renamed from: g  reason: collision with root package name */
        public long f3269g;

        /* renamed from: h  reason: collision with root package name */
        public long f3270h;

        /* renamed from: i  reason: collision with root package name */
        public Object f3271i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<j, C0044a> implements k {

            /* renamed from: a  reason: collision with root package name */
            public int f3272a;

            /* renamed from: b  reason: collision with root package name */
            public long f3273b;

            /* renamed from: c  reason: collision with root package name */
            public long f3274c;

            /* renamed from: e  reason: collision with root package name */
            public long f3276e;

            /* renamed from: f  reason: collision with root package name */
            public long f3277f;

            /* renamed from: h  reason: collision with root package name */
            public long f3279h;

            /* renamed from: d  reason: collision with root package name */
            public Object f3275d = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3278g = "";

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
                this.f3273b = 0L;
                int i2 = this.f3272a & (-2);
                this.f3272a = i2;
                this.f3274c = 0L;
                int i3 = i2 & (-3);
                this.f3272a = i3;
                this.f3275d = "";
                int i4 = i3 & (-5);
                this.f3272a = i4;
                this.f3276e = 0L;
                int i5 = i4 & (-9);
                this.f3272a = i5;
                this.f3277f = 0L;
                int i6 = i5 & (-17);
                this.f3272a = i6;
                this.f3278g = "";
                int i7 = i6 & (-33);
                this.f3272a = i7;
                this.f3279h = 0L;
                this.f3272a = i7 & (-65);
                return this;
            }

            public C0044a a(long j) {
                this.f3272a |= 1;
                this.f3273b = j;
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
                    this.f3272a |= 4;
                    this.f3275d = jVar.f3268f;
                }
                if (jVar.i()) {
                    c(jVar.j());
                }
                if (jVar.k()) {
                    d(jVar.l());
                }
                if (jVar.m()) {
                    this.f3272a |= 32;
                    this.f3278g = jVar.f3271i;
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
                        j parsePartialFrom = j.f3263a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3272a |= 4;
                    this.f3275d = str;
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
                this.f3272a |= 2;
                this.f3274c = j;
                return this;
            }

            public C0044a b(String str) {
                if (str != null) {
                    this.f3272a |= 32;
                    this.f3278g = str;
                    return this;
                }
                throw null;
            }

            public C0044a c(long j) {
                this.f3272a |= 8;
                this.f3276e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0044a d(long j) {
                this.f3272a |= 16;
                this.f3277f = j;
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
                this.f3272a |= 64;
                this.f3279h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i2 = this.f3272a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jVar.f3266d = this.f3273b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jVar.f3267e = this.f3274c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                jVar.f3268f = this.f3275d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                jVar.f3269g = this.f3276e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                jVar.f3270h = this.f3277f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                jVar.f3271i = this.f3278g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                jVar.j = this.f3279h;
                jVar.f3265c = i3;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            j jVar = new j();
            f3264b = jVar;
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
                                    this.f3265c |= 1;
                                    this.f3266d = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.f3265c |= 2;
                                    this.f3267e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3265c |= 4;
                                    this.f3268f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3265c |= 8;
                                    this.f3269g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f3265c |= 16;
                                    this.f3270h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f3265c |= 32;
                                    this.f3271i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f3265c |= 64;
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
            return f3264b;
        }

        public static C0044a q() {
            return C0044a.h();
        }

        private void t() {
            this.f3266d = 0L;
            this.f3267e = 0L;
            this.f3268f = "";
            this.f3269g = 0L;
            this.f3270h = 0L;
            this.f3271i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            return f3264b;
        }

        public boolean c() {
            return (this.f3265c & 1) == 1;
        }

        public long d() {
            return this.f3266d;
        }

        public boolean e() {
            return (this.f3265c & 2) == 2;
        }

        public long f() {
            return this.f3267e;
        }

        public boolean g() {
            return (this.f3265c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f3263a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3265c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3266d) : 0;
            if ((this.f3265c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3267e);
            }
            if ((this.f3265c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3265c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3269g);
            }
            if ((this.f3265c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3270h);
            }
            if ((this.f3265c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3265c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString h() {
            Object obj = this.f3268f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3268f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3265c & 8) == 8;
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
            return this.f3269g;
        }

        public boolean k() {
            return (this.f3265c & 16) == 16;
        }

        public long l() {
            return this.f3270h;
        }

        public boolean m() {
            return (this.f3265c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.f3271i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3271i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.f3265c & 64) == 64;
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
            if ((this.f3265c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3266d);
            }
            if ((this.f3265c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3267e);
            }
            if ((this.f3265c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3265c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3269g);
            }
            if ((this.f3265c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3270h);
            }
            if ((this.f3265c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3265c & 64) == 64) {
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
        public static Parser<l> f3280a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final l f3281b;

        /* renamed from: c  reason: collision with root package name */
        public int f3282c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3283d;

        /* renamed from: e  reason: collision with root package name */
        public long f3284e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3285f;

        /* renamed from: g  reason: collision with root package name */
        public long f3286g;

        /* renamed from: h  reason: collision with root package name */
        public byte f3287h;

        /* renamed from: i  reason: collision with root package name */
        public int f3288i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<l, C0045a> implements m {

            /* renamed from: a  reason: collision with root package name */
            public int f3289a;

            /* renamed from: c  reason: collision with root package name */
            public long f3291c;

            /* renamed from: e  reason: collision with root package name */
            public long f3293e;

            /* renamed from: b  reason: collision with root package name */
            public Object f3290b = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3292d = "";

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
                this.f3290b = "";
                int i2 = this.f3289a & (-2);
                this.f3289a = i2;
                this.f3291c = 0L;
                int i3 = i2 & (-3);
                this.f3289a = i3;
                this.f3292d = "";
                int i4 = i3 & (-5);
                this.f3289a = i4;
                this.f3293e = 0L;
                this.f3289a = i4 & (-9);
                return this;
            }

            public C0045a a(long j) {
                this.f3289a |= 2;
                this.f3291c = j;
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
                    this.f3289a |= 1;
                    this.f3290b = lVar.f3283d;
                }
                if (lVar.e()) {
                    a(lVar.f());
                }
                if (lVar.g()) {
                    this.f3289a |= 4;
                    this.f3292d = lVar.f3285f;
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
                        l parsePartialFrom = l.f3280a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3289a |= 1;
                    this.f3290b = str;
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
                this.f3289a |= 8;
                this.f3293e = j;
                return this;
            }

            public C0045a b(String str) {
                if (str != null) {
                    this.f3289a |= 4;
                    this.f3292d = str;
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
                int i2 = this.f3289a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lVar.f3283d = this.f3290b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lVar.f3284e = this.f3291c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lVar.f3285f = this.f3292d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lVar.f3286g = this.f3293e;
                lVar.f3282c = i3;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            l lVar = new l();
            f3281b = lVar;
            lVar.n();
        }

        public l() {
            this.f3287h = (byte) -1;
            this.f3288i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3287h = (byte) -1;
            this.f3288i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3282c |= 1;
                                    this.f3283d = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.f3282c |= 2;
                                    this.f3284e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3282c |= 4;
                                    this.f3285f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3282c |= 8;
                                    this.f3286g = codedInputStream.readInt64();
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
            this.f3287h = (byte) -1;
            this.f3288i = -1;
        }

        public static C0045a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f3281b;
        }

        public static C0045a k() {
            return C0045a.h();
        }

        private void n() {
            this.f3283d = "";
            this.f3284e = 0L;
            this.f3285f = "";
            this.f3286g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
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

        public long f() {
            return this.f3284e;
        }

        public boolean g() {
            return (this.f3282c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f3280a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3288i;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3282c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3282c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3284e);
            }
            if ((this.f3282c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3282c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3286g);
            }
            this.f3288i = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3285f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3285f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3282c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3287h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3287h = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3286g;
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
            if ((this.f3282c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3282c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3284e);
            }
            if ((this.f3282c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3282c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3286g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f3294a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final n f3295b;

        /* renamed from: c  reason: collision with root package name */
        public int f3296c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3297d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3298e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3299f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3300g;

        /* renamed from: h  reason: collision with root package name */
        public long f3301h;

        /* renamed from: i  reason: collision with root package name */
        public long f3302i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<n, C0046a> implements o {

            /* renamed from: a  reason: collision with root package name */
            public int f3303a;

            /* renamed from: f  reason: collision with root package name */
            public long f3308f;

            /* renamed from: g  reason: collision with root package name */
            public long f3309g;

            /* renamed from: h  reason: collision with root package name */
            public long f3310h;
            public long j;

            /* renamed from: b  reason: collision with root package name */
            public Object f3304b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3305c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3306d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3307e = "";

            /* renamed from: i  reason: collision with root package name */
            public Object f3311i = "";

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
                this.f3304b = "";
                int i2 = this.f3303a & (-2);
                this.f3303a = i2;
                this.f3305c = "";
                int i3 = i2 & (-3);
                this.f3303a = i3;
                this.f3306d = "";
                int i4 = i3 & (-5);
                this.f3303a = i4;
                this.f3307e = "";
                int i5 = i4 & (-9);
                this.f3303a = i5;
                this.f3308f = 0L;
                int i6 = i5 & (-17);
                this.f3303a = i6;
                this.f3309g = 0L;
                int i7 = i6 & (-33);
                this.f3303a = i7;
                this.f3310h = 0L;
                int i8 = i7 & (-65);
                this.f3303a = i8;
                this.f3311i = "";
                int i9 = i8 & (-129);
                this.f3303a = i9;
                this.j = 0L;
                this.f3303a = i9 & (-257);
                return this;
            }

            public C0046a a(long j) {
                this.f3303a |= 16;
                this.f3308f = j;
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
                    this.f3303a |= 1;
                    this.f3304b = nVar.f3297d;
                }
                if (nVar.e()) {
                    this.f3303a |= 2;
                    this.f3305c = nVar.f3298e;
                }
                if (nVar.g()) {
                    this.f3303a |= 4;
                    this.f3306d = nVar.f3299f;
                }
                if (nVar.i()) {
                    this.f3303a |= 8;
                    this.f3307e = nVar.f3300g;
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
                    this.f3303a |= 128;
                    this.f3311i = nVar.k;
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
                        n parsePartialFrom = n.f3294a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3303a |= 1;
                    this.f3304b = str;
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
                this.f3303a |= 32;
                this.f3309g = j;
                return this;
            }

            public C0046a b(String str) {
                if (str != null) {
                    this.f3303a |= 2;
                    this.f3305c = str;
                    return this;
                }
                throw null;
            }

            public C0046a c(long j) {
                this.f3303a |= 64;
                this.f3310h = j;
                return this;
            }

            public C0046a c(String str) {
                if (str != null) {
                    this.f3303a |= 4;
                    this.f3306d = str;
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
                this.f3303a |= 256;
                this.j = j;
                return this;
            }

            public C0046a d(String str) {
                if (str != null) {
                    this.f3303a |= 8;
                    this.f3307e = str;
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
                    this.f3303a |= 128;
                    this.f3311i = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i2 = this.f3303a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                nVar.f3297d = this.f3304b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                nVar.f3298e = this.f3305c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                nVar.f3299f = this.f3306d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                nVar.f3300g = this.f3307e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                nVar.f3301h = this.f3308f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                nVar.f3302i = this.f3309g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                nVar.j = this.f3310h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                nVar.k = this.f3311i;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                nVar.l = this.j;
                nVar.f3296c = i3;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            n nVar = new n();
            f3295b = nVar;
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
                                this.f3296c |= 1;
                                this.f3297d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3296c |= 2;
                                this.f3298e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f3296c |= 4;
                                this.f3299f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f3296c |= 8;
                                this.f3300g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f3296c |= 16;
                                this.f3301h = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.f3296c |= 32;
                                this.f3302i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3296c |= 64;
                                this.j = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.f3296c |= 128;
                                this.k = codedInputStream.readBytes();
                            } else if (readTag == 72) {
                                this.f3296c |= 256;
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
            return f3295b;
        }

        public static C0046a u() {
            return C0046a.h();
        }

        private void x() {
            this.f3297d = "";
            this.f3298e = "";
            this.f3299f = "";
            this.f3300g = "";
            this.f3301h = 0L;
            this.f3302i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f3295b;
        }

        public boolean c() {
            return (this.f3296c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3297d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3297d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3296c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3298e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3298e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3296c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            return f3294a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3296c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3296c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3296c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3296c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3296c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3301h);
            }
            if ((this.f3296c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.f3302i);
            }
            if ((this.f3296c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            if ((this.f3296c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
            }
            if ((this.f3296c & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
            }
            this.n = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3299f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3299f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3296c & 8) == 8;
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
            Object obj = this.f3300g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3300g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3296c & 16) == 16;
        }

        public long l() {
            return this.f3301h;
        }

        public boolean m() {
            return (this.f3296c & 32) == 32;
        }

        public long n() {
            return this.f3302i;
        }

        public boolean o() {
            return (this.f3296c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3296c & 128) == 128;
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
            return (this.f3296c & 256) == 256;
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
            if ((this.f3296c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3296c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3296c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3296c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3296c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3301h);
            }
            if ((this.f3296c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3302i);
            }
            if ((this.f3296c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.f3296c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.f3296c & 256) == 256) {
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
        public static Parser<p> f3312a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final p f3313b;

        /* renamed from: c  reason: collision with root package name */
        public int f3314c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3315d;

        /* renamed from: e  reason: collision with root package name */
        public byte f3316e;

        /* renamed from: f  reason: collision with root package name */
        public int f3317f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<p, C0047a> implements q {

            /* renamed from: a  reason: collision with root package name */
            public int f3318a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3319b = "";

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
                this.f3319b = "";
                this.f3318a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f3318a |= 1;
                    this.f3319b = pVar.f3315d;
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
                        p parsePartialFrom = p.f3312a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3318a |= 1;
                    this.f3319b = str;
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
                int i2 = (this.f3318a & 1) != 1 ? 0 : 1;
                pVar.f3315d = this.f3319b;
                pVar.f3314c = i2;
                return pVar;
            }

            public boolean f() {
                return (this.f3318a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            p pVar = new p();
            f3313b = pVar;
            pVar.h();
        }

        public p() {
            this.f3316e = (byte) -1;
            this.f3317f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3316e = (byte) -1;
            this.f3317f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 34) {
                                this.f3314c |= 1;
                                this.f3315d = codedInputStream.readBytes();
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
            this.f3316e = (byte) -1;
            this.f3317f = -1;
        }

        public static C0047a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f3313b;
        }

        public static C0047a e() {
            return C0047a.i();
        }

        private void h() {
            this.f3315d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f3313b;
        }

        public boolean c() {
            return (this.f3314c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3315d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3315d = copyFromUtf8;
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
            return f3312a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3317f;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3314c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
            this.f3317f = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3316e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.f3316e = (byte) 1;
                return true;
            } else {
                this.f3316e = (byte) 0;
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
            if ((this.f3314c & 1) == 1) {
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
        public static Parser<r> f3320a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final r f3321b;

        /* renamed from: c  reason: collision with root package name */
        public int f3322c;

        /* renamed from: d  reason: collision with root package name */
        public int f3323d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3324e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3325f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3326g;

        /* renamed from: h  reason: collision with root package name */
        public int f3327h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<r, C0048a> implements s {

            /* renamed from: a  reason: collision with root package name */
            public int f3328a;

            /* renamed from: b  reason: collision with root package name */
            public int f3329b = 7399;

            /* renamed from: c  reason: collision with root package name */
            public Object f3330c = "push_im_client";

            /* renamed from: d  reason: collision with root package name */
            public Object f3331d = "phonebaidu";

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
                this.f3329b = 7399;
                int i2 = this.f3328a & (-2);
                this.f3328a = i2;
                this.f3330c = "push_im_client";
                int i3 = i2 & (-3);
                this.f3328a = i3;
                this.f3331d = "phonebaidu";
                this.f3328a = i3 & (-5);
                return this;
            }

            public C0048a a(int i2) {
                this.f3328a |= 1;
                this.f3329b = i2;
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
                    this.f3328a |= 2;
                    this.f3330c = rVar.f3324e;
                }
                if (rVar.g()) {
                    this.f3328a |= 4;
                    this.f3331d = rVar.f3325f;
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
                        r parsePartialFrom = r.f3320a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                int i2 = this.f3328a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                rVar.f3323d = this.f3329b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                rVar.f3324e = this.f3330c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                rVar.f3325f = this.f3331d;
                rVar.f3322c = i3;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            r rVar = new r();
            f3321b = rVar;
            rVar.l();
        }

        public r() {
            this.f3326g = (byte) -1;
            this.f3327h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3326g = (byte) -1;
            this.f3327h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3322c |= 1;
                                    this.f3323d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3322c |= 2;
                                    this.f3324e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3322c |= 4;
                                    this.f3325f = codedInputStream.readBytes();
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
            this.f3326g = (byte) -1;
            this.f3327h = -1;
        }

        public static C0048a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f3321b;
        }

        public static C0048a i() {
            return C0048a.h();
        }

        private void l() {
            this.f3323d = 7399;
            this.f3324e = "push_im_client";
            this.f3325f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f3321b;
        }

        public boolean c() {
            return (this.f3322c & 1) == 1;
        }

        public int d() {
            return this.f3323d;
        }

        public boolean e() {
            return (this.f3322c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3324e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3324e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3322c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            return f3320a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3327h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3322c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3323d) : 0;
            if ((this.f3322c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3322c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3327h = computeInt32Size;
            return computeInt32Size;
        }

        public ByteString h() {
            Object obj = this.f3325f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3325f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3326g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3326g = (byte) 1;
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
            if ((this.f3322c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3323d);
            }
            if ((this.f3322c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3322c & 4) == 4) {
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
        public static Parser<t> f3332a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final t f3333b;

        /* renamed from: c  reason: collision with root package name */
        public int f3334c;

        /* renamed from: d  reason: collision with root package name */
        public long f3335d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3336e;

        /* renamed from: f  reason: collision with root package name */
        public long f3337f;

        /* renamed from: g  reason: collision with root package name */
        public long f3338g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3339h;

        /* renamed from: i  reason: collision with root package name */
        public long f3340i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<t, C0049a> implements u {

            /* renamed from: a  reason: collision with root package name */
            public int f3341a;

            /* renamed from: b  reason: collision with root package name */
            public long f3342b;

            /* renamed from: d  reason: collision with root package name */
            public long f3344d;

            /* renamed from: e  reason: collision with root package name */
            public long f3345e;

            /* renamed from: g  reason: collision with root package name */
            public long f3347g;

            /* renamed from: h  reason: collision with root package name */
            public long f3348h;

            /* renamed from: c  reason: collision with root package name */
            public Object f3343c = "";

            /* renamed from: f  reason: collision with root package name */
            public Object f3346f = "";

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
                this.f3342b = 0L;
                int i2 = this.f3341a & (-2);
                this.f3341a = i2;
                this.f3343c = "";
                int i3 = i2 & (-3);
                this.f3341a = i3;
                this.f3344d = 0L;
                int i4 = i3 & (-5);
                this.f3341a = i4;
                this.f3345e = 0L;
                int i5 = i4 & (-9);
                this.f3341a = i5;
                this.f3346f = "";
                int i6 = i5 & (-17);
                this.f3341a = i6;
                this.f3347g = 0L;
                int i7 = i6 & (-33);
                this.f3341a = i7;
                this.f3348h = 0L;
                this.f3341a = i7 & (-65);
                return this;
            }

            public C0049a a(long j) {
                this.f3341a |= 1;
                this.f3342b = j;
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
                    this.f3341a |= 2;
                    this.f3343c = tVar.f3336e;
                }
                if (tVar.g()) {
                    b(tVar.h());
                }
                if (tVar.i()) {
                    c(tVar.j());
                }
                if (tVar.k()) {
                    this.f3341a |= 16;
                    this.f3346f = tVar.f3339h;
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
                        t parsePartialFrom = t.f3332a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                this.f3341a |= 4;
                this.f3344d = j;
                return this;
            }

            public C0049a c(long j) {
                this.f3341a |= 8;
                this.f3345e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0049a d(long j) {
                this.f3341a |= 32;
                this.f3347g = j;
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
                this.f3341a |= 64;
                this.f3348h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i2 = this.f3341a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                tVar.f3335d = this.f3342b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                tVar.f3336e = this.f3343c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                tVar.f3337f = this.f3344d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                tVar.f3338g = this.f3345e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                tVar.f3339h = this.f3346f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                tVar.f3340i = this.f3347g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                tVar.j = this.f3348h;
                tVar.f3334c = i3;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            t tVar = new t();
            f3333b = tVar;
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
                                this.f3334c |= 1;
                                this.f3335d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3334c |= 2;
                                this.f3336e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3334c |= 4;
                                this.f3337f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3334c |= 8;
                                this.f3338g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3334c |= 16;
                                this.f3339h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f3334c |= 32;
                                this.f3340i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3334c |= 64;
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
            return f3333b;
        }

        public static C0049a q() {
            return C0049a.h();
        }

        private void t() {
            this.f3335d = 0L;
            this.f3336e = "";
            this.f3337f = 0L;
            this.f3338g = 0L;
            this.f3339h = "";
            this.f3340i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f3333b;
        }

        public boolean c() {
            return (this.f3334c & 1) == 1;
        }

        public long d() {
            return this.f3335d;
        }

        public boolean e() {
            return (this.f3334c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3336e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3336e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3334c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            return f3332a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3334c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3335d) : 0;
            if ((this.f3334c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3334c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3337f);
            }
            if ((this.f3334c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3338g);
            }
            if ((this.f3334c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3334c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.f3340i);
            }
            if ((this.f3334c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public long h() {
            return this.f3337f;
        }

        public boolean i() {
            return (this.f3334c & 8) == 8;
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
            return this.f3338g;
        }

        public boolean k() {
            return (this.f3334c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3339h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3339h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3334c & 32) == 32;
        }

        public long n() {
            return this.f3340i;
        }

        public boolean o() {
            return (this.f3334c & 64) == 64;
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
            if ((this.f3334c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3335d);
            }
            if ((this.f3334c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3334c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3337f);
            }
            if ((this.f3334c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3338g);
            }
            if ((this.f3334c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3334c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.f3340i);
            }
            if ((this.f3334c & 64) == 64) {
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
        public static Parser<v> f3349a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final v f3350b;

        /* renamed from: c  reason: collision with root package name */
        public int f3351c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3352d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3353e;

        /* renamed from: f  reason: collision with root package name */
        public byte f3354f;

        /* renamed from: g  reason: collision with root package name */
        public int f3355g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<v, C0050a> implements w {

            /* renamed from: a  reason: collision with root package name */
            public int f3356a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3357b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3358c = "";

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
                this.f3357b = "";
                int i2 = this.f3356a & (-2);
                this.f3356a = i2;
                this.f3358c = "";
                this.f3356a = i2 & (-3);
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
                    this.f3356a |= 1;
                    this.f3357b = vVar.f3352d;
                }
                if (vVar.e()) {
                    this.f3356a |= 2;
                    this.f3358c = vVar.f3353e;
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
                        v parsePartialFrom = v.f3349a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3356a |= 1;
                    this.f3357b = str;
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
                    this.f3356a |= 2;
                    this.f3358c = str;
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
                int i2 = this.f3356a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                vVar.f3352d = this.f3357b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                vVar.f3353e = this.f3358c;
                vVar.f3351c = i3;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            v vVar = new v();
            f3350b = vVar;
            vVar.j();
        }

        public v() {
            this.f3354f = (byte) -1;
            this.f3355g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3354f = (byte) -1;
            this.f3355g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3351c |= 1;
                                this.f3352d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3351c |= 2;
                                this.f3353e = codedInputStream.readBytes();
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
            this.f3354f = (byte) -1;
            this.f3355g = -1;
        }

        public static C0050a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f3350b;
        }

        public static C0050a g() {
            return C0050a.h();
        }

        private void j() {
            this.f3352d = "";
            this.f3353e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f3350b;
        }

        public boolean c() {
            return (this.f3351c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3352d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3352d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3351c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3353e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3353e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f3349a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3355g;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.f3351c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3351c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            this.f3355g = computeBytesSize;
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
            byte b2 = this.f3354f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3354f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3351c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3351c & 2) == 2) {
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
        public final int f3364e;

        x(int i2) {
            this.f3364e = i2;
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
            return this.f3364e;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f3365a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final y f3366b;

        /* renamed from: c  reason: collision with root package name */
        public int f3367c;

        /* renamed from: d  reason: collision with root package name */
        public r f3368d;

        /* renamed from: e  reason: collision with root package name */
        public h f3369e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3370f;

        /* renamed from: g  reason: collision with root package name */
        public long f3371g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f3372h;

        /* renamed from: i  reason: collision with root package name */
        public byte f3373i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0051a extends GeneratedMessageLite.Builder<y, C0051a> implements z {

            /* renamed from: a  reason: collision with root package name */
            public int f3374a;

            /* renamed from: e  reason: collision with root package name */
            public long f3378e;

            /* renamed from: b  reason: collision with root package name */
            public r f3375b = r.a();

            /* renamed from: c  reason: collision with root package name */
            public h f3376c = h.a();

            /* renamed from: d  reason: collision with root package name */
            public Object f3377d = "";

            /* renamed from: f  reason: collision with root package name */
            public List<c> f3379f = Collections.emptyList();

            public C0051a() {
                i();
            }

            private void i() {
            }

            public static C0051a j() {
                return new C0051a();
            }

            private void k() {
                if ((this.f3374a & 16) != 16) {
                    this.f3379f = new ArrayList(this.f3379f);
                    this.f3374a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0051a clear() {
                super.clear();
                this.f3375b = r.a();
                this.f3374a &= -2;
                this.f3376c = h.a();
                int i2 = this.f3374a & (-3);
                this.f3374a = i2;
                this.f3377d = "";
                int i3 = i2 & (-5);
                this.f3374a = i3;
                this.f3378e = 0L;
                this.f3374a = i3 & (-9);
                this.f3379f = Collections.emptyList();
                this.f3374a &= -17;
                return this;
            }

            public C0051a a(long j) {
                this.f3374a |= 8;
                this.f3378e = j;
                return this;
            }

            public C0051a a(h hVar) {
                if (hVar != null) {
                    this.f3376c = hVar;
                    this.f3374a |= 2;
                    return this;
                }
                throw null;
            }

            public C0051a a(r rVar) {
                if ((this.f3374a & 1) == 1 && this.f3375b != r.a()) {
                    rVar = r.a(this.f3375b).mergeFrom(rVar).buildPartial();
                }
                this.f3375b = rVar;
                this.f3374a |= 1;
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
                    this.f3374a |= 4;
                    this.f3377d = yVar.f3370f;
                }
                if (yVar.i()) {
                    a(yVar.j());
                }
                if (!yVar.f3372h.isEmpty()) {
                    if (this.f3379f.isEmpty()) {
                        this.f3379f = yVar.f3372h;
                        this.f3374a &= -17;
                    } else {
                        k();
                        this.f3379f.addAll(yVar.f3372h);
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
                        y parsePartialFrom = y.f3365a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                AbstractMessageLite.Builder.addAll(iterable, this.f3379f);
                return this;
            }

            public C0051a a(String str) {
                if (str != null) {
                    this.f3374a |= 4;
                    this.f3377d = str;
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
                if ((this.f3374a & 2) == 2 && this.f3376c != h.a()) {
                    hVar = h.a(this.f3376c).mergeFrom(hVar).buildPartial();
                }
                this.f3376c = hVar;
                this.f3374a |= 2;
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
                int i2 = this.f3374a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                yVar.f3368d = this.f3375b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                yVar.f3369e = this.f3376c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                yVar.f3370f = this.f3377d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                yVar.f3371g = this.f3378e;
                if ((this.f3374a & 16) == 16) {
                    this.f3379f = Collections.unmodifiableList(this.f3379f);
                    this.f3374a &= -17;
                }
                yVar.f3372h = this.f3379f;
                yVar.f3367c = i3;
                return yVar;
            }

            public boolean f() {
                return (this.f3374a & 2) == 2;
            }

            public h g() {
                return this.f3376c;
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
            f3366b = yVar;
            yVar.n();
        }

        public y() {
            this.f3373i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i2;
            this.f3373i = (byte) -1;
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
                                r.C0048a builder = (this.f3367c & 1) == 1 ? this.f3368d.toBuilder() : null;
                                r rVar = (r) codedInputStream.readMessage(r.f3320a, extensionRegistryLite);
                                this.f3368d = rVar;
                                if (builder != null) {
                                    builder.mergeFrom(rVar);
                                    this.f3368d = builder.buildPartial();
                                }
                                i2 = this.f3367c;
                            } else if (readTag == 330) {
                                i3 = 2;
                                h.C0043a builder2 = (this.f3367c & 2) == 2 ? this.f3369e.toBuilder() : null;
                                h hVar = (h) codedInputStream.readMessage(h.f3245a, extensionRegistryLite);
                                this.f3369e = hVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hVar);
                                    this.f3369e = builder2.buildPartial();
                                }
                                i2 = this.f3367c;
                            } else if (readTag == 1042) {
                                this.f3367c |= 4;
                                this.f3370f = codedInputStream.readBytes();
                            } else if (readTag == 1048) {
                                this.f3367c |= 8;
                                this.f3371g = codedInputStream.readInt64();
                            } else if (readTag == 1058) {
                                if (!(z2 & true)) {
                                    this.f3372h = new ArrayList();
                                    z2 |= true;
                                }
                                this.f3372h.add(codedInputStream.readMessage(c.f3206a, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                            this.f3367c = i2 | i3;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f3372h = Collections.unmodifiableList(this.f3372h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3373i = (byte) -1;
            this.j = -1;
        }

        public static C0051a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f3366b;
        }

        public static C0051a k() {
            return C0051a.j();
        }

        private void n() {
            this.f3368d = r.a();
            this.f3369e = h.a();
            this.f3370f = "";
            this.f3371g = 0L;
            this.f3372h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f3366b;
        }

        public boolean c() {
            return (this.f3367c & 1) == 1;
        }

        public r d() {
            return this.f3368d;
        }

        public boolean e() {
            return (this.f3367c & 2) == 2;
        }

        public h f() {
            return this.f3369e;
        }

        public boolean g() {
            return (this.f3367c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f3365a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.f3367c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f3368d) + 0 : 0;
            if ((this.f3367c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f3369e);
            }
            if ((this.f3367c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3367c & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3371g);
            }
            for (int i3 = 0; i3 < this.f3372h.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f3372h.get(i3));
            }
            this.j = computeMessageSize;
            return computeMessageSize;
        }

        public ByteString h() {
            Object obj = this.f3370f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3370f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3367c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3373i;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!e()) {
                this.f3373i = (byte) 0;
                return false;
            } else if (f().isInitialized()) {
                this.f3373i = (byte) 1;
                return true;
            } else {
                this.f3373i = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.f3371g;
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
            if ((this.f3367c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.f3368d);
            }
            if ((this.f3367c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f3369e);
            }
            if ((this.f3367c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3367c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3371g);
            }
            for (int i2 = 0; i2 < this.f3372h.size(); i2++) {
                codedOutputStream.writeMessage(132, this.f3372h.get(i2));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
