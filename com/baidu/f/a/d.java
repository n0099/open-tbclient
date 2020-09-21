package com.baidu.f.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class d extends MessageMicro {
    private boolean apZ;
    private boolean aqL;
    private boolean aqO;
    private c aqM = null;
    private List<b> aqb = Collections.emptyList();
    private a aqN = null;
    private com.baidu.f.a.a aqP = null;
    private List<com.baidu.f.a.b> aqQ = Collections.emptyList();
    private int apY = -1;

    /* loaded from: classes3.dex */
    public static final class a extends MessageMicro {
        private boolean aqR;
        private boolean aqT;
        private boolean aqV;
        private boolean aqY;
        private boolean aqe;
        private boolean ara;
        private boolean ard;
        private boolean arf;
        private boolean arh;
        private boolean arj;
        private int aqf = 0;
        private String aqS = "";
        private int aqU = 0;
        private c aqW = null;
        private List<C0115a> aqX = Collections.emptyList();
        private int aqZ = 0;
        private C0116d arb = null;
        private List<b> arc = Collections.emptyList();
        private int are = 0;
        private String arg = "";
        private int ari = 0;
        private String ark = "";
        private int apY = -1;

        /* renamed from: com.baidu.f.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0115a extends MessageMicro {
            private boolean apV;
            private boolean arl;
            private boolean arn;
            private boolean arp;
            private boolean ars;
            private boolean aru;
            private String arm = "";
            private String aro = "";
            private String apW = "";
            private boolean arq = false;
            private List<Integer> arr = Collections.emptyList();
            private String art = "";
            private String arv = "";
            private int apY = -1;

            public C0115a aR(boolean z) {
                this.arp = true;
                this.arq = z;
                return this;
            }

            public int ck(int i) {
                return this.arr.get(i).intValue();
            }

            public C0115a cl(int i) {
                if (this.arr.isEmpty()) {
                    this.arr = new ArrayList();
                }
                this.arr.add(Integer.valueOf(i));
                return this;
            }

            public C0115a eq(String str) {
                this.arl = true;
                this.arm = str;
                return this;
            }

            public C0115a er(String str) {
                this.arn = true;
                this.aro = str;
                return this;
            }

            public C0115a es(String str) {
                this.apV = true;
                this.apW = str;
                return this;
            }

            public C0115a et(String str) {
                this.ars = true;
                this.art = str;
                return this;
            }

            public C0115a eu(String str) {
                this.aru = true;
                this.arv = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public String getFloor() {
                return this.art;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wO() ? CodedOutputStreamMicro.computeStringSize(1, wN()) + 0 : 0;
                if (wQ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wP());
                }
                if (vC()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = wS() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wR()) : computeStringSize;
                for (Integer num : wT()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (wT().size() * 1);
                if (wU()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (wW()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, wV());
                }
                this.apY = size;
                return size;
            }

            public String getUid() {
                return this.apW;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: l */
            public C0115a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            eq(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            er(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            es(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aR(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cl(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            et(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            eu(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public boolean vC() {
                return this.apV;
            }

            public String wN() {
                return this.arm;
            }

            public boolean wO() {
                return this.arl;
            }

            public String wP() {
                return this.aro;
            }

            public boolean wQ() {
                return this.arn;
            }

            public boolean wR() {
                return this.arq;
            }

            public boolean wS() {
                return this.arp;
            }

            public List<Integer> wT() {
                return this.arr;
            }

            public boolean wU() {
                return this.ars;
            }

            public String wV() {
                return this.arv;
            }

            public boolean wW() {
                return this.aru;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wO()) {
                    codedOutputStreamMicro.writeString(1, wN());
                }
                if (wQ()) {
                    codedOutputStreamMicro.writeString(2, wP());
                }
                if (vC()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (wS()) {
                    codedOutputStreamMicro.writeBool(4, wR());
                }
                for (Integer num : wT()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (wU()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (wW()) {
                    codedOutputStreamMicro.writeString(7, wV());
                }
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends MessageMicro {
            private boolean apK;
            private boolean arw;
            private int apL = 0;
            private String arx = "";
            private int apY = -1;

            public b cm(int i) {
                this.apK = true;
                this.apL = i;
                return this;
            }

            public b ev(String str) {
                this.arw = true;
                this.arx = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public int getCode() {
                return this.apL;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vv() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wY()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wX());
                }
                this.apY = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: m */
            public b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cm(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            ev(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public boolean vv() {
                return this.apK;
            }

            public String wX() {
                return this.arx;
            }

            public boolean wY() {
                return this.arw;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vv()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wY()) {
                    codedOutputStreamMicro.writeString(2, wX());
                }
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends MessageMicro {
            private boolean apV;
            private boolean arl;
            private boolean arn;
            private boolean arp;
            private boolean ars;
            private boolean aru;
            private String arm = "";
            private String aro = "";
            private String apW = "";
            private boolean arq = false;
            private List<Integer> arr = Collections.emptyList();
            private String art = "";
            private String arv = "";
            private int apY = -1;

            public c aS(boolean z) {
                this.arp = true;
                this.arq = z;
                return this;
            }

            public int ck(int i) {
                return this.arr.get(i).intValue();
            }

            public c cn(int i) {
                if (this.arr.isEmpty()) {
                    this.arr = new ArrayList();
                }
                this.arr.add(Integer.valueOf(i));
                return this;
            }

            public c eA(String str) {
                this.ars = true;
                this.art = str;
                return this;
            }

            public c eB(String str) {
                this.aru = true;
                this.arv = str;
                return this;
            }

            public c ew(String str) {
                this.arl = true;
                this.arm = str;
                return this;
            }

            public c ey(String str) {
                this.arn = true;
                this.aro = str;
                return this;
            }

            public c ez(String str) {
                this.apV = true;
                this.apW = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public String getFloor() {
                return this.art;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wO() ? CodedOutputStreamMicro.computeStringSize(1, wN()) + 0 : 0;
                if (wQ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wP());
                }
                if (vC()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = wS() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wR()) : computeStringSize;
                for (Integer num : wT()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (wT().size() * 1);
                if (wU()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (wW()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, wV());
                }
                this.apY = size;
                return size;
            }

            public String getUid() {
                return this.apW;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: n */
            public c mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ew(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            ey(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            ez(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aS(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cn(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            eA(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            eB(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public boolean vC() {
                return this.apV;
            }

            public String wN() {
                return this.arm;
            }

            public boolean wO() {
                return this.arl;
            }

            public String wP() {
                return this.aro;
            }

            public boolean wQ() {
                return this.arn;
            }

            public boolean wR() {
                return this.arq;
            }

            public boolean wS() {
                return this.arp;
            }

            public List<Integer> wT() {
                return this.arr;
            }

            public boolean wU() {
                return this.ars;
            }

            public String wV() {
                return this.arv;
            }

            public boolean wW() {
                return this.aru;
            }

            public int wZ() {
                return this.arr.size();
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wO()) {
                    codedOutputStreamMicro.writeString(1, wN());
                }
                if (wQ()) {
                    codedOutputStreamMicro.writeString(2, wP());
                }
                if (vC()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (wS()) {
                    codedOutputStreamMicro.writeBool(4, wR());
                }
                for (Integer num : wT()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (wU()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (wW()) {
                    codedOutputStreamMicro.writeString(7, wV());
                }
            }
        }

        /* renamed from: com.baidu.f.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0116d extends MessageMicro {
            private boolean apK;
            private boolean arw;
            private int apL = 0;
            private String arx = "";
            private int apY = -1;

            public C0116d co(int i) {
                this.apK = true;
                this.apL = i;
                return this;
            }

            public C0116d eC(String str) {
                this.arw = true;
                this.arx = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public int getCode() {
                return this.apL;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vv() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wY()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wX());
                }
                this.apY = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: o */
            public C0116d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            co(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            eC(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public boolean vv() {
                return this.apK;
            }

            public String wX() {
                return this.arx;
            }

            public boolean wY() {
                return this.arw;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vv()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wY()) {
                    codedOutputStreamMicro.writeString(2, wX());
                }
            }
        }

        public a a(C0115a c0115a) {
            if (c0115a != null) {
                if (this.aqX.isEmpty()) {
                    this.aqX = new ArrayList();
                }
                this.aqX.add(c0115a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.arc.isEmpty()) {
                    this.arc = new ArrayList();
                }
                this.arc.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wx();
            }
            this.aqV = true;
            this.aqW = cVar;
            return this;
        }

        public a a(C0116d c0116d) {
            if (c0116d == null) {
                return wD();
            }
            this.ara = true;
            this.arb = c0116d;
            return this;
        }

        public a cd(int i) {
            this.aqe = true;
            this.aqf = i;
            return this;
        }

        public a ce(int i) {
            this.aqT = true;
            this.aqU = i;
            return this;
        }

        public C0115a cf(int i) {
            return this.aqX.get(i);
        }

        public a cg(int i) {
            this.aqY = true;
            this.aqZ = i;
            return this;
        }

        public b ch(int i) {
            return this.arc.get(i);
        }

        public a ci(int i) {
            this.ard = true;
            this.are = i;
            return this;
        }

        public a cj(int i) {
            this.arh = true;
            this.ari = i;
            return this;
        }

        public a en(String str) {
            this.aqR = true;
            this.aqS = str;
            return this;
        }

        public a eo(String str) {
            this.arf = true;
            this.arg = str;
            return this;
        }

        public a ep(String str) {
            this.arj = true;
            this.ark = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apY < 0) {
                getSerializedSize();
            }
            return this.apY;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int computeInt32Size = vJ() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (wt()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, ws());
            }
            if (wv()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, wu());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, ww());
            }
            Iterator<C0115a> it = wy().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
            }
            if (wA()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, wz());
            }
            if (wB()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, wC());
            }
            for (b bVar : wE()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, bVar);
            }
            if (wG()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, wF());
            }
            if (wI()) {
                i += CodedOutputStreamMicro.computeStringSize(10, wH());
            }
            if (wK()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, wJ());
            }
            if (wM()) {
                i += CodedOutputStreamMicro.computeStringSize(12, wL());
            }
            this.apY = i;
            return i;
        }

        public int getTotal() {
            return this.aqf;
        }

        public boolean hasStart() {
            return this.aqV;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: k */
        public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        cd(codedInputStreamMicro.readInt32());
                        break;
                    case 18:
                        en(codedInputStreamMicro.readString());
                        break;
                    case 24:
                        ce(codedInputStreamMicro.readInt32());
                        break;
                    case 34:
                        c cVar = new c();
                        codedInputStreamMicro.readMessage(cVar);
                        a(cVar);
                        break;
                    case 42:
                        C0115a c0115a = new C0115a();
                        codedInputStreamMicro.readMessage(c0115a);
                        a(c0115a);
                        break;
                    case 48:
                        cg(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        C0116d c0116d = new C0116d();
                        codedInputStreamMicro.readMessage(c0116d);
                        a(c0116d);
                        break;
                    case 66:
                        b bVar = new b();
                        codedInputStreamMicro.readMessage(bVar);
                        a(bVar);
                        break;
                    case 72:
                        ci(codedInputStreamMicro.readInt32());
                        break;
                    case 82:
                        eo(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        cj(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
                        ep(codedInputStreamMicro.readString());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public boolean vJ() {
            return this.aqe;
        }

        public boolean wA() {
            return this.aqY;
        }

        public boolean wB() {
            return this.ara;
        }

        public C0116d wC() {
            return this.arb;
        }

        public a wD() {
            this.ara = false;
            this.arb = null;
            return this;
        }

        public List<b> wE() {
            return this.arc;
        }

        public int wF() {
            return this.are;
        }

        public boolean wG() {
            return this.ard;
        }

        public String wH() {
            return this.arg;
        }

        public boolean wI() {
            return this.arf;
        }

        public int wJ() {
            return this.ari;
        }

        public boolean wK() {
            return this.arh;
        }

        public String wL() {
            return this.ark;
        }

        public boolean wM() {
            return this.arj;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vJ()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (wt()) {
                codedOutputStreamMicro.writeString(2, ws());
            }
            if (wv()) {
                codedOutputStreamMicro.writeInt32(3, wu());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, ww());
            }
            for (C0115a c0115a : wy()) {
                codedOutputStreamMicro.writeMessage(5, c0115a);
            }
            if (wA()) {
                codedOutputStreamMicro.writeInt32(6, wz());
            }
            if (wB()) {
                codedOutputStreamMicro.writeMessage(7, wC());
            }
            for (b bVar : wE()) {
                codedOutputStreamMicro.writeMessage(8, bVar);
            }
            if (wG()) {
                codedOutputStreamMicro.writeInt32(9, wF());
            }
            if (wI()) {
                codedOutputStreamMicro.writeString(10, wH());
            }
            if (wK()) {
                codedOutputStreamMicro.writeInt32(11, wJ());
            }
            if (wM()) {
                codedOutputStreamMicro.writeString(12, wL());
            }
        }

        public String ws() {
            return this.aqS;
        }

        public boolean wt() {
            return this.aqR;
        }

        public int wu() {
            return this.aqU;
        }

        public boolean wv() {
            return this.aqT;
        }

        public c ww() {
            return this.aqW;
        }

        public a wx() {
            this.aqV = false;
            this.aqW = null;
            return this;
        }

        public List<C0115a> wy() {
            return this.aqX;
        }

        public int wz() {
            return this.aqZ;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends MessageMicro {
        private boolean arA;
        private boolean arC;
        private boolean arE;
        private boolean arH;
        private boolean ary;
        private List<C0117b> aql = Collections.emptyList();
        private a arz = null;
        private f arB = null;
        private C0120d arD = null;
        private e arF = null;
        private List<c> arG = Collections.emptyList();
        private String arI = "";
        private int apY = -1;

        /* loaded from: classes3.dex */
        public static final class a extends MessageMicro {
            private boolean arJ;
            private boolean arL;
            private boolean arN;
            private int arK = 0;
            private int arM = 0;
            private int arO = 0;
            private int apY = -1;

            public a cq(int i) {
                this.arJ = true;
                this.arK = i;
                return this;
            }

            public a cr(int i) {
                this.arL = true;
                this.arM = i;
                return this;
            }

            public a cs(int i) {
                this.arN = true;
                this.arO = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = xr() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xq()) : 0;
                if (xt()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xs());
                }
                if (xv()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, xu());
                }
                this.apY = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: q */
            public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cq(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            cr(codedInputStreamMicro.readInt32());
                            break;
                        case 24:
                            cs(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (xr()) {
                    codedOutputStreamMicro.writeInt32(1, xq());
                }
                if (xt()) {
                    codedOutputStreamMicro.writeInt32(2, xs());
                }
                if (xv()) {
                    codedOutputStreamMicro.writeInt32(3, xu());
                }
            }

            public int xq() {
                return this.arK;
            }

            public boolean xr() {
                return this.arJ;
            }

            public int xs() {
                return this.arM;
            }

            public boolean xt() {
                return this.arL;
            }

            public int xu() {
                return this.arO;
            }

            public boolean xv() {
                return this.arN;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0117b extends MessageMicro {
            private boolean aqh;
            private boolean aqj;
            private boolean arP;
            private boolean arR;
            private boolean arT;
            private boolean arV;
            private boolean arX;
            private boolean asa;
            private List<c> aqq = Collections.emptyList();
            private List<Integer> aqo = Collections.emptyList();
            private List<Integer> aqp = Collections.emptyList();
            private String arQ = "";
            private String arS = "";
            private int aqi = 0;
            private int aqk = 0;
            private int arU = 0;
            private int arW = 0;
            private int arY = 0;
            private List<a> arZ = Collections.emptyList();
            private C0118b asb = null;
            private int apY = -1;

            /* renamed from: com.baidu.f.a.d$b$b$a */
            /* loaded from: classes3.dex */
            public static final class a extends MessageMicro {
                private boolean aqg;
                private boolean ars;
                private boolean aru;
                private boolean asc;
                private boolean ase;
                private int type_ = 0;
                private int asd = 0;
                private String asf = "";
                private List<Integer> aqz = Collections.emptyList();
                private String art = "";
                private String arv = "";
                private int apY = -1;

                public a cB(int i) {
                    this.aqg = true;
                    this.type_ = i;
                    return this;
                }

                public a cC(int i) {
                    this.asc = true;
                    this.asd = i;
                    return this;
                }

                public a cD(int i) {
                    if (this.aqz.isEmpty()) {
                        this.aqz = new ArrayList();
                    }
                    this.aqz.add(Integer.valueOf(i));
                    return this;
                }

                public a eG(String str) {
                    this.ase = true;
                    this.asf = str;
                    return this;
                }

                public a eH(String str) {
                    this.ars = true;
                    this.art = str;
                    return this;
                }

                public a eI(String str) {
                    this.aru = true;
                    this.arv = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apY < 0) {
                        getSerializedSize();
                    }
                    return this.apY;
                }

                public String getFloor() {
                    return this.art;
                }

                public String getInfo() {
                    return this.asf;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (xM()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xL());
                    }
                    int computeStringSize = xN() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
                    for (Integer num : vY()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize + i + (vY().size() * 1);
                    if (wU()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (wW()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, wV());
                    }
                    this.apY = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.aqg;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: s */
                public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                cB(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cC(codedInputStreamMicro.readInt32());
                                break;
                            case 26:
                                eG(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cD(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eH(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eI(codedInputStreamMicro.readString());
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                public List<Integer> vY() {
                    return this.aqz;
                }

                public boolean wU() {
                    return this.ars;
                }

                public String wV() {
                    return this.arv;
                }

                public boolean wW() {
                    return this.aru;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (xM()) {
                        codedOutputStreamMicro.writeInt32(2, xL());
                    }
                    if (xN()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    for (Integer num : vY()) {
                        codedOutputStreamMicro.writeInt32(4, num.intValue());
                    }
                    if (wU()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (wW()) {
                        codedOutputStreamMicro.writeString(6, wV());
                    }
                }

                public int xL() {
                    return this.asd;
                }

                public boolean xM() {
                    return this.asc;
                }

                public boolean xN() {
                    return this.ase;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0118b extends MessageMicro {
                private boolean asg;
                private boolean hasNext;
                private int ash = 0;
                private int asi = 0;
                private int apY = -1;

                public C0118b cE(int i) {
                    this.asg = true;
                    this.ash = i;
                    return this;
                }

                public C0118b cF(int i) {
                    this.hasNext = true;
                    this.asi = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apY < 0) {
                        getSerializedSize();
                    }
                    return this.apY;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xP() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xO()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xQ());
                    }
                    this.apY = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: t */
                public C0118b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                cE(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cF(codedInputStreamMicro.readInt32());
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (xP()) {
                        codedOutputStreamMicro.writeInt32(1, xO());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, xQ());
                    }
                }

                public int xO() {
                    return this.ash;
                }

                public boolean xP() {
                    return this.asg;
                }

                public int xQ() {
                    return this.asi;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$c */
            /* loaded from: classes3.dex */
            public static final class c extends MessageMicro {
                private boolean apP;
                private boolean aqg;
                private boolean aqh;
                private boolean aqj;
                private boolean aqr;
                private boolean asC;
                private boolean asF;
                private boolean ask;
                private boolean asn;
                private boolean asp;
                private boolean asr;
                private boolean ast;
                private boolean asv;
                private boolean asx;
                private boolean asz;
                private List<a> asj = Collections.emptyList();
                private List<C0119b> aqw = Collections.emptyList();
                private List<Integer> aqv = Collections.emptyList();
                private String aqs = "";
                private int type_ = 0;
                private String apQ = "";
                private int asl = 0;
                private int aso = 0;
                private int asq = 0;
                private int ass = 0;
                private int asu = 0;
                private int asw = 0;
                private int aqi = 0;
                private int aqk = 0;
                private int asy = 0;
                private int asA = 0;
                private List<Integer> aqo = Collections.emptyList();
                private List<Integer> aqp = Collections.emptyList();
                private List<Integer> asB = Collections.emptyList();
                private int asD = 0;
                private List<Integer> asE = Collections.emptyList();
                private int asG = 0;
                private List<C0119b> asH = Collections.emptyList();
                private int apY = -1;

                /* renamed from: com.baidu.f.a.d$b$b$c$a */
                /* loaded from: classes3.dex */
                public static final class a extends MessageMicro {
                    private boolean aqJ;
                    private boolean asI;
                    private boolean asK;
                    private boolean asM;
                    private boolean asO;
                    private boolean asz;
                    private String asJ = "";
                    private int asL = 0;
                    private int aqK = 0;
                    private int asA = 0;
                    private int asN = 0;
                    private int asP = 0;
                    private int apY = -1;

                    public a cY(int i) {
                        this.asK = true;
                        this.asL = i;
                        return this;
                    }

                    public a cZ(int i) {
                        this.aqJ = true;
                        this.aqK = i;
                        return this;
                    }

                    public a da(int i) {
                        this.asz = true;
                        this.asA = i;
                        return this;
                    }

                    public a db(int i) {
                        this.asM = true;
                        this.asN = i;
                        return this;
                    }

                    public a dc(int i) {
                        this.asO = true;
                        this.asP = i;
                        return this;
                    }

                    public a eL(String str) {
                        this.asI = true;
                        this.asJ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.apY < 0) {
                            getSerializedSize();
                        }
                        return this.apY;
                    }

                    public String getId() {
                        return this.asJ;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (yp()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, yo());
                        }
                        if (wh()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, wg());
                        }
                        if (yg()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, yf());
                        }
                        if (yr()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, yq());
                        }
                        if (yt()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, ys());
                        }
                        this.apY = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.asI;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: v */
                    public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eL(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    cY(codedInputStreamMicro.readInt32());
                                    break;
                                case 24:
                                    cZ(codedInputStreamMicro.readInt32());
                                    break;
                                case 32:
                                    da(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    db(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    dc(codedInputStreamMicro.readInt32());
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                        return this;
                    }

                    public int wg() {
                        return this.aqK;
                    }

                    public boolean wh() {
                        return this.aqJ;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (yp()) {
                            codedOutputStreamMicro.writeInt32(2, yo());
                        }
                        if (wh()) {
                            codedOutputStreamMicro.writeInt32(3, wg());
                        }
                        if (yg()) {
                            codedOutputStreamMicro.writeInt32(4, yf());
                        }
                        if (yr()) {
                            codedOutputStreamMicro.writeInt32(5, yq());
                        }
                        if (yt()) {
                            codedOutputStreamMicro.writeInt32(6, ys());
                        }
                    }

                    public int yf() {
                        return this.asA;
                    }

                    public boolean yg() {
                        return this.asz;
                    }

                    public int yo() {
                        return this.asL;
                    }

                    public boolean yp() {
                        return this.asK;
                    }

                    public int yq() {
                        return this.asN;
                    }

                    public boolean yr() {
                        return this.asM;
                    }

                    public int ys() {
                        return this.asP;
                    }

                    public boolean yt() {
                        return this.asO;
                    }
                }

                /* renamed from: com.baidu.f.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C0119b extends MessageMicro {
                    private boolean apP;
                    private boolean apV;
                    private boolean arT;
                    private boolean asR;
                    private boolean asT;
                    private boolean asV;
                    private boolean asY;
                    private boolean ata;
                    private boolean atc;
                    private boolean ate;
                    private boolean atg;
                    private String apQ = "";
                    private List<Integer> asQ = Collections.emptyList();
                    private int arU = 0;
                    private String asS = "";
                    private String asU = "";
                    private String asW = "";
                    private String apW = "";
                    private List<Integer> asX = Collections.emptyList();
                    private String asZ = "";
                    private String atb = "";
                    private String atd = "";
                    private int atf = 0;
                    private int ath = 0;
                    private int apY = -1;

                    public C0119b dd(int i) {
                        if (this.asQ.isEmpty()) {
                            this.asQ = new ArrayList();
                        }
                        this.asQ.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0119b de(int i) {
                        this.arT = true;
                        this.arU = i;
                        return this;
                    }

                    public C0119b df(int i) {
                        if (this.asX.isEmpty()) {
                            this.asX = new ArrayList();
                        }
                        this.asX.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0119b dg(int i) {
                        this.ate = true;
                        this.atf = i;
                        return this;
                    }

                    public C0119b dh(int i) {
                        this.atg = true;
                        this.ath = i;
                        return this;
                    }

                    public C0119b eM(String str) {
                        this.apP = true;
                        this.apQ = str;
                        return this;
                    }

                    public C0119b eN(String str) {
                        this.asR = true;
                        this.asS = str;
                        return this;
                    }

                    public C0119b eO(String str) {
                        this.asT = true;
                        this.asU = str;
                        return this;
                    }

                    public C0119b eP(String str) {
                        this.asV = true;
                        this.asW = str;
                        return this;
                    }

                    public C0119b eQ(String str) {
                        this.apV = true;
                        this.apW = str;
                        return this;
                    }

                    public C0119b eR(String str) {
                        this.asY = true;
                        this.asZ = str;
                        return this;
                    }

                    public C0119b eS(String str) {
                        this.ata = true;
                        this.atb = str;
                        return this;
                    }

                    public C0119b eT(String str) {
                        this.atc = true;
                        this.atd = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.apY < 0) {
                            getSerializedSize();
                        }
                        return this.apY;
                    }

                    public String getIconUrl() {
                        return this.asZ;
                    }

                    public String getName() {
                        return this.apQ;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        int i2 = 0;
                        for (Integer num : yu()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i2;
                        }
                        int size = computeStringSize + i2 + (yu().size() * 1);
                        if (xC()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, xB());
                        }
                        if (yw()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, yv());
                        }
                        if (yy()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, yx());
                        }
                        if (yA()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, yz());
                        }
                        int computeStringSize2 = vC() ? size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : size;
                        for (Integer num2 : yB()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                        }
                        int size2 = computeStringSize2 + i + (yB().size() * 1);
                        if (yC()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (yE()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, yD());
                        }
                        if (yG()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, yF());
                        }
                        if (yI()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, yH());
                        }
                        if (yK()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, yJ());
                        }
                        this.apY = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.apW;
                    }

                    public boolean hasName() {
                        return this.apP;
                    }

                    public boolean vC() {
                        return this.apV;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: w */
                    public C0119b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eM(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    dd(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    de(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eN(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eO(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    eP(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    eQ(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    df(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    eR(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    eS(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    eT(codedInputStreamMicro.readString());
                                    break;
                                case 96:
                                    dg(codedInputStreamMicro.readInt32());
                                    break;
                                case 104:
                                    dh(codedInputStreamMicro.readInt32());
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        for (Integer num : yu()) {
                            codedOutputStreamMicro.writeSInt32(2, num.intValue());
                        }
                        if (xC()) {
                            codedOutputStreamMicro.writeInt32(3, xB());
                        }
                        if (yw()) {
                            codedOutputStreamMicro.writeString(4, yv());
                        }
                        if (yy()) {
                            codedOutputStreamMicro.writeString(5, yx());
                        }
                        if (yA()) {
                            codedOutputStreamMicro.writeString(6, yz());
                        }
                        if (vC()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        for (Integer num2 : yB()) {
                            codedOutputStreamMicro.writeSInt32(8, num2.intValue());
                        }
                        if (yC()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (yE()) {
                            codedOutputStreamMicro.writeString(10, yD());
                        }
                        if (yG()) {
                            codedOutputStreamMicro.writeString(11, yF());
                        }
                        if (yI()) {
                            codedOutputStreamMicro.writeInt32(12, yH());
                        }
                        if (yK()) {
                            codedOutputStreamMicro.writeInt32(13, yJ());
                        }
                    }

                    public int xB() {
                        return this.arU;
                    }

                    public boolean xC() {
                        return this.arT;
                    }

                    public boolean yA() {
                        return this.asV;
                    }

                    public List<Integer> yB() {
                        return this.asX;
                    }

                    public boolean yC() {
                        return this.asY;
                    }

                    public String yD() {
                        return this.atb;
                    }

                    public boolean yE() {
                        return this.ata;
                    }

                    public String yF() {
                        return this.atd;
                    }

                    public boolean yG() {
                        return this.atc;
                    }

                    public int yH() {
                        return this.atf;
                    }

                    public boolean yI() {
                        return this.ate;
                    }

                    public int yJ() {
                        return this.ath;
                    }

                    public boolean yK() {
                        return this.atg;
                    }

                    public List<Integer> yu() {
                        return this.asQ;
                    }

                    public String yv() {
                        return this.asS;
                    }

                    public boolean yw() {
                        return this.asR;
                    }

                    public String yx() {
                        return this.asU;
                    }

                    public boolean yy() {
                        return this.asT;
                    }

                    public String yz() {
                        return this.asW;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.asj.isEmpty()) {
                            this.asj = new ArrayList();
                        }
                        this.asj.add(aVar);
                    }
                    return this;
                }

                public c a(C0119b c0119b) {
                    if (c0119b != null) {
                        if (this.aqw.isEmpty()) {
                            this.aqw = new ArrayList();
                        }
                        this.aqw.add(c0119b);
                    }
                    return this;
                }

                public c b(C0119b c0119b) {
                    if (c0119b != null) {
                        if (this.asH.isEmpty()) {
                            this.asH = new ArrayList();
                        }
                        this.asH.add(c0119b);
                    }
                    return this;
                }

                public c cG(int i) {
                    if (this.aqv.isEmpty()) {
                        this.aqv = new ArrayList();
                    }
                    this.aqv.add(Integer.valueOf(i));
                    return this;
                }

                public c cH(int i) {
                    this.aqg = true;
                    this.type_ = i;
                    return this;
                }

                public c cI(int i) {
                    this.ask = true;
                    this.asl = i;
                    return this;
                }

                public c cJ(int i) {
                    this.asn = true;
                    this.aso = i;
                    return this;
                }

                public c cK(int i) {
                    this.asp = true;
                    this.asq = i;
                    return this;
                }

                public c cL(int i) {
                    this.asr = true;
                    this.ass = i;
                    return this;
                }

                public c cM(int i) {
                    this.ast = true;
                    this.asu = i;
                    return this;
                }

                public c cN(int i) {
                    this.asv = true;
                    this.asw = i;
                    return this;
                }

                public c cO(int i) {
                    this.aqh = true;
                    this.aqi = i;
                    return this;
                }

                public c cP(int i) {
                    this.aqj = true;
                    this.aqk = i;
                    return this;
                }

                public c cQ(int i) {
                    this.asx = true;
                    this.asy = i;
                    return this;
                }

                public c cR(int i) {
                    this.asz = true;
                    this.asA = i;
                    return this;
                }

                public c cS(int i) {
                    if (this.aqo.isEmpty()) {
                        this.aqo = new ArrayList();
                    }
                    this.aqo.add(Integer.valueOf(i));
                    return this;
                }

                public c cT(int i) {
                    if (this.aqp.isEmpty()) {
                        this.aqp = new ArrayList();
                    }
                    this.aqp.add(Integer.valueOf(i));
                    return this;
                }

                public c cU(int i) {
                    if (this.asB.isEmpty()) {
                        this.asB = new ArrayList();
                    }
                    this.asB.add(Integer.valueOf(i));
                    return this;
                }

                public c cV(int i) {
                    this.asC = true;
                    this.asD = i;
                    return this;
                }

                public c cW(int i) {
                    if (this.asE.isEmpty()) {
                        this.asE = new ArrayList();
                    }
                    this.asE.add(Integer.valueOf(i));
                    return this;
                }

                public c cX(int i) {
                    this.asF = true;
                    this.asG = i;
                    return this;
                }

                public c eJ(String str) {
                    this.aqr = true;
                    this.aqs = str;
                    return this;
                }

                public c eK(String str) {
                    this.apP = true;
                    this.apQ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apY < 0) {
                        getSerializedSize();
                    }
                    return this.apY;
                }

                public int getDirection() {
                    return this.asy;
                }

                public int getDistance() {
                    return this.aqi;
                }

                public int getDuration() {
                    return this.aqk;
                }

                public String getInstructions() {
                    return this.aqs;
                }

                public String getName() {
                    return this.apQ;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int i2 = 0;
                    int i3 = 0;
                    for (Integer num : vU()) {
                        i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                    }
                    int size = 0 + i3 + (vU().size() * 1);
                    if (vR()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (xT()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, xS());
                    }
                    if (xV()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, xU());
                    }
                    if (xX()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, xW());
                    }
                    if (xZ()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, xY());
                    }
                    if (yb()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, ya());
                    }
                    if (yd()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, yc());
                    }
                    if (vK()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<a> it = xR().iterator();
                    while (true) {
                        i = size;
                        if (!it.hasNext()) {
                            break;
                        }
                        size = CodedOutputStreamMicro.computeMessageSize(13, it.next()) + i;
                    }
                    for (C0119b c0119b : vV()) {
                        i += CodedOutputStreamMicro.computeMessageSize(14, c0119b);
                    }
                    if (ye()) {
                        i += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (yg()) {
                        i += CodedOutputStreamMicro.computeInt32Size(16, yf());
                    }
                    int i4 = 0;
                    for (Integer num2 : vO()) {
                        i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue()) + i4;
                    }
                    int size2 = i + i4 + (vO().size() * 2);
                    int i5 = 0;
                    for (Integer num3 : vP()) {
                        i5 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num3.intValue()) + i5;
                    }
                    int size3 = size2 + i5 + (vP().size() * 2);
                    int i6 = 0;
                    for (Integer num4 : yh()) {
                        i6 = CodedOutputStreamMicro.computeInt32SizeNoTag(num4.intValue()) + i6;
                    }
                    int size4 = size3 + i6 + (yh().size() * 2);
                    int computeInt32Size = yj() ? size4 + CodedOutputStreamMicro.computeInt32Size(20, yi()) : size4;
                    for (Integer num5 : yk()) {
                        i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num5.intValue());
                    }
                    int size5 = computeInt32Size + i2 + (yk().size() * 2);
                    if (ym()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, yl());
                    }
                    Iterator<C0119b> it2 = yn().iterator();
                    while (true) {
                        int i7 = size5;
                        if (!it2.hasNext()) {
                            this.apY = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqj;
                }

                public boolean hasName() {
                    return this.apP;
                }

                public boolean hasType() {
                    return this.aqg;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: u */
                public c mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                cG(codedInputStreamMicro.readSInt32());
                                break;
                            case 18:
                                eJ(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cH(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eK(codedInputStreamMicro.readString());
                                break;
                            case 40:
                                cI(codedInputStreamMicro.readInt32());
                                break;
                            case 48:
                                cJ(codedInputStreamMicro.readInt32());
                                break;
                            case 56:
                                cK(codedInputStreamMicro.readInt32());
                                break;
                            case 64:
                                cL(codedInputStreamMicro.readInt32());
                                break;
                            case 72:
                                cM(codedInputStreamMicro.readInt32());
                                break;
                            case 80:
                                cN(codedInputStreamMicro.readInt32());
                                break;
                            case 88:
                                cO(codedInputStreamMicro.readInt32());
                                break;
                            case 96:
                                cP(codedInputStreamMicro.readInt32());
                                break;
                            case 106:
                                a aVar = new a();
                                codedInputStreamMicro.readMessage(aVar);
                                a(aVar);
                                break;
                            case 114:
                                C0119b c0119b = new C0119b();
                                codedInputStreamMicro.readMessage(c0119b);
                                a(c0119b);
                                break;
                            case 120:
                                cQ(codedInputStreamMicro.readInt32());
                                break;
                            case 128:
                                cR(codedInputStreamMicro.readInt32());
                                break;
                            case 136:
                                cS(codedInputStreamMicro.readSInt32());
                                break;
                            case 144:
                                cT(codedInputStreamMicro.readSInt32());
                                break;
                            case 152:
                                cU(codedInputStreamMicro.readInt32());
                                break;
                            case 160:
                                cV(codedInputStreamMicro.readInt32());
                                break;
                            case 168:
                                cW(codedInputStreamMicro.readSInt32());
                                break;
                            case Opcodes.ARETURN /* 176 */:
                                cX(codedInputStreamMicro.readInt32());
                                break;
                            case 186:
                                C0119b c0119b2 = new C0119b();
                                codedInputStreamMicro.readMessage(c0119b2);
                                b(c0119b2);
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                public boolean vK() {
                    return this.aqh;
                }

                public List<Integer> vO() {
                    return this.aqo;
                }

                public List<Integer> vP() {
                    return this.aqp;
                }

                public boolean vR() {
                    return this.aqr;
                }

                public List<Integer> vU() {
                    return this.aqv;
                }

                public List<C0119b> vV() {
                    return this.aqw;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer num : vU()) {
                        codedOutputStreamMicro.writeSInt32(1, num.intValue());
                    }
                    if (vR()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (xT()) {
                        codedOutputStreamMicro.writeInt32(5, xS());
                    }
                    if (xV()) {
                        codedOutputStreamMicro.writeInt32(6, xU());
                    }
                    if (xX()) {
                        codedOutputStreamMicro.writeInt32(7, xW());
                    }
                    if (xZ()) {
                        codedOutputStreamMicro.writeInt32(8, xY());
                    }
                    if (yb()) {
                        codedOutputStreamMicro.writeInt32(9, ya());
                    }
                    if (yd()) {
                        codedOutputStreamMicro.writeInt32(10, yc());
                    }
                    if (vK()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (a aVar : xR()) {
                        codedOutputStreamMicro.writeMessage(13, aVar);
                    }
                    for (C0119b c0119b : vV()) {
                        codedOutputStreamMicro.writeMessage(14, c0119b);
                    }
                    if (ye()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (yg()) {
                        codedOutputStreamMicro.writeInt32(16, yf());
                    }
                    for (Integer num2 : vO()) {
                        codedOutputStreamMicro.writeSInt32(17, num2.intValue());
                    }
                    for (Integer num3 : vP()) {
                        codedOutputStreamMicro.writeSInt32(18, num3.intValue());
                    }
                    for (Integer num4 : yh()) {
                        codedOutputStreamMicro.writeInt32(19, num4.intValue());
                    }
                    if (yj()) {
                        codedOutputStreamMicro.writeInt32(20, yi());
                    }
                    for (Integer num5 : yk()) {
                        codedOutputStreamMicro.writeSInt32(21, num5.intValue());
                    }
                    if (ym()) {
                        codedOutputStreamMicro.writeInt32(22, yl());
                    }
                    for (C0119b c0119b2 : yn()) {
                        codedOutputStreamMicro.writeMessage(23, c0119b2);
                    }
                }

                public List<a> xR() {
                    return this.asj;
                }

                public int xS() {
                    return this.asl;
                }

                public boolean xT() {
                    return this.ask;
                }

                public int xU() {
                    return this.aso;
                }

                public boolean xV() {
                    return this.asn;
                }

                public int xW() {
                    return this.asq;
                }

                public boolean xX() {
                    return this.asp;
                }

                public int xY() {
                    return this.ass;
                }

                public boolean xZ() {
                    return this.asr;
                }

                public int ya() {
                    return this.asu;
                }

                public boolean yb() {
                    return this.ast;
                }

                public int yc() {
                    return this.asw;
                }

                public boolean yd() {
                    return this.asv;
                }

                public boolean ye() {
                    return this.asx;
                }

                public int yf() {
                    return this.asA;
                }

                public boolean yg() {
                    return this.asz;
                }

                public List<Integer> yh() {
                    return this.asB;
                }

                public int yi() {
                    return this.asD;
                }

                public boolean yj() {
                    return this.asC;
                }

                public List<Integer> yk() {
                    return this.asE;
                }

                public int yl() {
                    return this.asG;
                }

                public boolean ym() {
                    return this.asF;
                }

                public List<C0119b> yn() {
                    return this.asH;
                }
            }

            public C0117b a(a aVar) {
                if (aVar != null) {
                    if (this.arZ.isEmpty()) {
                        this.arZ = new ArrayList();
                    }
                    this.arZ.add(aVar);
                }
                return this;
            }

            public C0117b a(C0118b c0118b) {
                if (c0118b == null) {
                    return xK();
                }
                this.asa = true;
                this.asb = c0118b;
                return this;
            }

            public C0117b a(c cVar) {
                if (cVar != null) {
                    if (this.aqq.isEmpty()) {
                        this.aqq = new ArrayList();
                    }
                    this.aqq.add(cVar);
                }
                return this;
            }

            public C0117b cA(int i) {
                this.arX = true;
                this.arY = i;
                return this;
            }

            public c ct(int i) {
                return this.aqq.get(i);
            }

            public C0117b cu(int i) {
                if (this.aqo.isEmpty()) {
                    this.aqo = new ArrayList();
                }
                this.aqo.add(Integer.valueOf(i));
                return this;
            }

            public C0117b cv(int i) {
                if (this.aqp.isEmpty()) {
                    this.aqp = new ArrayList();
                }
                this.aqp.add(Integer.valueOf(i));
                return this;
            }

            public C0117b cw(int i) {
                this.aqh = true;
                this.aqi = i;
                return this;
            }

            public C0117b cx(int i) {
                this.aqj = true;
                this.aqk = i;
                return this;
            }

            public C0117b cy(int i) {
                this.arT = true;
                this.arU = i;
                return this;
            }

            public C0117b cz(int i) {
                this.arV = true;
                this.arW = i;
                return this;
            }

            public C0117b eE(String str) {
                this.arP = true;
                this.arQ = str;
                return this;
            }

            public C0117b eF(String str) {
                this.arR = true;
                this.arS = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public int getDistance() {
                return this.aqi;
            }

            public int getDuration() {
                return this.aqk;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int i2 = 0;
                int i3 = 0;
                for (Integer num : vO()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                }
                int size = (vO().size() * 1) + 0 + i3;
                for (Integer num2 : vP()) {
                    i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                }
                int size2 = size + i2 + (vP().size() * 1);
                if (xy()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, xx());
                }
                if (xA()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, xz());
                }
                if (vK()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (xC()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, xB());
                }
                if (xE()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, xD());
                }
                if (xG()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, xF());
                }
                Iterator<c> it = vQ().iterator();
                while (true) {
                    i = size2;
                    if (!it.hasNext()) {
                        break;
                    }
                    size2 = CodedOutputStreamMicro.computeMessageSize(10, it.next()) + i;
                }
                for (a aVar : xH()) {
                    i += CodedOutputStreamMicro.computeMessageSize(11, aVar);
                }
                if (xI()) {
                    i += CodedOutputStreamMicro.computeMessageSize(12, xJ());
                }
                this.apY = i;
                return i;
            }

            public boolean hasDuration() {
                return this.aqj;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: r */
            public C0117b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cu(codedInputStreamMicro.readSInt32());
                            break;
                        case 16:
                            cv(codedInputStreamMicro.readSInt32());
                            break;
                        case 26:
                            eE(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eF(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            cw(codedInputStreamMicro.readInt32());
                            break;
                        case 48:
                            cx(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            cy(codedInputStreamMicro.readInt32());
                            break;
                        case 64:
                            cz(codedInputStreamMicro.readInt32());
                            break;
                        case 72:
                            cA(codedInputStreamMicro.readInt32());
                            break;
                        case 82:
                            c cVar = new c();
                            codedInputStreamMicro.readMessage(cVar);
                            a(cVar);
                            break;
                        case 90:
                            a aVar = new a();
                            codedInputStreamMicro.readMessage(aVar);
                            a(aVar);
                            break;
                        case 98:
                            C0118b c0118b = new C0118b();
                            codedInputStreamMicro.readMessage(c0118b);
                            a(c0118b);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public boolean vK() {
                return this.aqh;
            }

            public List<Integer> vO() {
                return this.aqo;
            }

            public List<Integer> vP() {
                return this.aqp;
            }

            public List<c> vQ() {
                return this.aqq;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer num : vO()) {
                    codedOutputStreamMicro.writeSInt32(1, num.intValue());
                }
                for (Integer num2 : vP()) {
                    codedOutputStreamMicro.writeSInt32(2, num2.intValue());
                }
                if (xy()) {
                    codedOutputStreamMicro.writeString(3, xx());
                }
                if (xA()) {
                    codedOutputStreamMicro.writeString(4, xz());
                }
                if (vK()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (xC()) {
                    codedOutputStreamMicro.writeInt32(7, xB());
                }
                if (xE()) {
                    codedOutputStreamMicro.writeInt32(8, xD());
                }
                if (xG()) {
                    codedOutputStreamMicro.writeInt32(9, xF());
                }
                for (c cVar : vQ()) {
                    codedOutputStreamMicro.writeMessage(10, cVar);
                }
                for (a aVar : xH()) {
                    codedOutputStreamMicro.writeMessage(11, aVar);
                }
                if (xI()) {
                    codedOutputStreamMicro.writeMessage(12, xJ());
                }
            }

            public boolean xA() {
                return this.arR;
            }

            public int xB() {
                return this.arU;
            }

            public boolean xC() {
                return this.arT;
            }

            public int xD() {
                return this.arW;
            }

            public boolean xE() {
                return this.arV;
            }

            public int xF() {
                return this.arY;
            }

            public boolean xG() {
                return this.arX;
            }

            public List<a> xH() {
                return this.arZ;
            }

            public boolean xI() {
                return this.asa;
            }

            public C0118b xJ() {
                return this.asb;
            }

            public C0117b xK() {
                this.asa = false;
                this.asb = null;
                return this;
            }

            public int xw() {
                return this.aqq.size();
            }

            public String xx() {
                return this.arQ;
            }

            public boolean xy() {
                return this.arP;
            }

            public String xz() {
                return this.arS;
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends MessageMicro {
            private boolean ati;
            private int atj = 0;
            private List<Integer> atk = Collections.emptyList();
            private int apY = -1;

            public c di(int i) {
                this.ati = true;
                this.atj = i;
                return this;
            }

            public c dj(int i) {
                if (this.atk.isEmpty()) {
                    this.atk = new ArrayList();
                }
                this.atk.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yM() ? CodedOutputStreamMicro.computeInt32Size(1, yL()) + 0 : 0;
                for (Integer num : yN()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yN().size() * 1);
                this.apY = size;
                return size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yM()) {
                    codedOutputStreamMicro.writeInt32(1, yL());
                }
                for (Integer num : yN()) {
                    codedOutputStreamMicro.writeSInt32(2, num.intValue());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: x */
            public c mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            di(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            dj(codedInputStreamMicro.readSInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public int yL() {
                return this.atj;
            }

            public boolean yM() {
                return this.ati;
            }

            public List<Integer> yN() {
                return this.atk;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0120d extends MessageMicro {
            private boolean atl;
            private int atm = 0;
            private int apY = -1;

            public C0120d dk(int i) {
                this.atl = true;
                this.atm = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public int getLightNum() {
                return this.atm;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yO() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.apY = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yO()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: y */
            public C0120d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            dk(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public boolean yO() {
                return this.atl;
            }
        }

        /* loaded from: classes3.dex */
        public static final class e extends MessageMicro {
            private boolean aqL;
            private boolean aqV;
            private boolean atn;
            private boolean atp;
            private int ato = 0;
            private String atq = "";
            private a atr = null;
            private List<a> aqX = Collections.emptyList();
            private c aqM = null;
            private int apY = -1;

            /* loaded from: classes3.dex */
            public static final class a extends MessageMicro {
                private boolean apP;
                private boolean apV;
                private boolean arl;
                private boolean ars;
                private boolean aru;
                private String arm = "";
                private String apQ = "";
                private String apW = "";
                private List<Integer> arr = Collections.emptyList();
                private String art = "";
                private String arv = "";
                private int apY = -1;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: A */
                public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                eV(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                eW(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                eX(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                dm(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                eY(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eZ(codedInputStreamMicro.readString());
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                public a dm(int i) {
                    if (this.arr.isEmpty()) {
                        this.arr = new ArrayList();
                    }
                    this.arr.add(Integer.valueOf(i));
                    return this;
                }

                public a eV(String str) {
                    this.arl = true;
                    this.arm = str;
                    return this;
                }

                public a eW(String str) {
                    this.apP = true;
                    this.apQ = str;
                    return this;
                }

                public a eX(String str) {
                    this.apV = true;
                    this.apW = str;
                    return this;
                }

                public a eY(String str) {
                    this.ars = true;
                    this.art = str;
                    return this;
                }

                public a eZ(String str) {
                    this.aru = true;
                    this.arv = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apY < 0) {
                        getSerializedSize();
                    }
                    return this.apY;
                }

                public String getFloor() {
                    return this.art;
                }

                public String getName() {
                    return this.apQ;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeStringSize = wO() ? CodedOutputStreamMicro.computeStringSize(1, wN()) + 0 : 0;
                    if (hasName()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    int computeStringSize2 = vC() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                    for (Integer num : wT()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize2 + i + (wT().size() * 1);
                    if (wU()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (wW()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, wV());
                    }
                    this.apY = size;
                    return size;
                }

                public String getUid() {
                    return this.apW;
                }

                public boolean hasName() {
                    return this.apP;
                }

                public boolean vC() {
                    return this.apV;
                }

                public String wN() {
                    return this.arm;
                }

                public boolean wO() {
                    return this.arl;
                }

                public List<Integer> wT() {
                    return this.arr;
                }

                public boolean wU() {
                    return this.ars;
                }

                public String wV() {
                    return this.arv;
                }

                public boolean wW() {
                    return this.aru;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (wO()) {
                        codedOutputStreamMicro.writeString(1, wN());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (vC()) {
                        codedOutputStreamMicro.writeString(3, getUid());
                    }
                    for (Integer num : wT()) {
                        codedOutputStreamMicro.writeSInt32(4, num.intValue());
                    }
                    if (wU()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (wW()) {
                        codedOutputStreamMicro.writeString(6, wV());
                    }
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return yT();
                }
                this.aqV = true;
                this.atr = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.aqX.isEmpty()) {
                        this.aqX = new ArrayList();
                    }
                    this.aqX.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return yU();
                }
                this.aqL = true;
                this.aqM = cVar;
                return this;
            }

            public e dl(int i) {
                this.atn = true;
                this.ato = i;
                return this;
            }

            public e eU(String str) {
                this.atp = true;
                this.atq = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public String getLabel() {
                return this.atq;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int computeInt32Size = yQ() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, yP()) : 0;
                if (yR()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, yS());
                }
                Iterator<a> it = wy().iterator();
                while (true) {
                    i = computeInt32Size;
                    if (!it.hasNext()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
                }
                if (wi()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, wj());
                }
                this.apY = i;
                return i;
            }

            public boolean hasStart() {
                return this.aqV;
            }

            public boolean wi() {
                return this.aqL;
            }

            public c wj() {
                return this.aqM;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yQ()) {
                    codedOutputStreamMicro.writeInt32(1, yP());
                }
                if (yR()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, yS());
                }
                for (a aVar : wy()) {
                    codedOutputStreamMicro.writeMessage(4, aVar);
                }
                if (wi()) {
                    codedOutputStreamMicro.writeMessage(5, wj());
                }
            }

            public List<a> wy() {
                return this.aqX;
            }

            public int yP() {
                return this.ato;
            }

            public boolean yQ() {
                return this.atn;
            }

            public boolean yR() {
                return this.atp;
            }

            public a yS() {
                return this.atr;
            }

            public e yT() {
                this.aqV = false;
                this.atr = null;
                return this;
            }

            public e yU() {
                this.aqL = false;
                this.aqM = null;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: z */
            public e mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            dl(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            eU(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            a aVar = new a();
                            codedInputStreamMicro.readMessage(aVar);
                            a(aVar);
                            break;
                        case 34:
                            a aVar2 = new a();
                            codedInputStreamMicro.readMessage(aVar2);
                            b(aVar2);
                            break;
                        case 42:
                            c cVar = new c();
                            codedInputStreamMicro.readMessage(cVar);
                            b(cVar);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class f extends MessageMicro {
            private boolean ats;
            private boolean atu;
            private String att = "";
            private String atv = "";
            private int apY = -1;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: B */
            public f mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            fa(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fb(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public f fa(String str) {
                this.ats = true;
                this.att = str;
                return this;
            }

            public f fb(String str) {
                this.atu = true;
                this.atv = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public String getContent() {
                return this.att;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = yV() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (yX()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, yW());
                }
                this.apY = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yV()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (yX()) {
                    codedOutputStreamMicro.writeString(2, yW());
                }
            }

            public boolean yV() {
                return this.ats;
            }

            public String yW() {
                return this.atv;
            }

            public boolean yX() {
                return this.atu;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return xd();
            }
            this.ary = true;
            this.arz = aVar;
            return this;
        }

        public b a(C0117b c0117b) {
            if (c0117b != null) {
                if (this.aql.isEmpty()) {
                    this.aql = new ArrayList();
                }
                this.aql.add(c0117b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.arG.isEmpty()) {
                    this.arG = new ArrayList();
                }
                this.arG.add(cVar);
            }
            return this;
        }

        public b a(C0120d c0120d) {
            if (c0120d == null) {
                return xj();
            }
            this.arC = true;
            this.arD = c0120d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return xm();
            }
            this.arE = true;
            this.arF = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return xg();
            }
            this.arA = true;
            this.arB = fVar;
            return this;
        }

        public C0117b cp(int i) {
            return this.aql.get(i);
        }

        public b eD(String str) {
            this.arH = true;
            this.arI = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apY < 0) {
                getSerializedSize();
            }
            return this.apY;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int i2 = 0;
            Iterator<C0117b> it = vL().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
            }
            if (xb()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, xc());
            }
            if (xe()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, xf());
            }
            if (xh()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, xi());
            }
            if (xk()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, xl());
            }
            for (c cVar : xn()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, cVar);
            }
            if (xp()) {
                i += CodedOutputStreamMicro.computeStringSize(7, xo());
            }
            this.apY = i;
            return i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: p */
        public b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        C0117b c0117b = new C0117b();
                        codedInputStreamMicro.readMessage(c0117b);
                        a(c0117b);
                        break;
                    case 18:
                        a aVar = new a();
                        codedInputStreamMicro.readMessage(aVar);
                        a(aVar);
                        break;
                    case 26:
                        f fVar = new f();
                        codedInputStreamMicro.readMessage(fVar);
                        a(fVar);
                        break;
                    case 34:
                        C0120d c0120d = new C0120d();
                        codedInputStreamMicro.readMessage(c0120d);
                        a(c0120d);
                        break;
                    case 42:
                        e eVar = new e();
                        codedInputStreamMicro.readMessage(eVar);
                        a(eVar);
                        break;
                    case 50:
                        c cVar = new c();
                        codedInputStreamMicro.readMessage(cVar);
                        a(cVar);
                        break;
                    case 58:
                        eD(codedInputStreamMicro.readString());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public List<C0117b> vL() {
            return this.aql;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (C0117b c0117b : vL()) {
                codedOutputStreamMicro.writeMessage(1, c0117b);
            }
            if (xb()) {
                codedOutputStreamMicro.writeMessage(2, xc());
            }
            if (xe()) {
                codedOutputStreamMicro.writeMessage(3, xf());
            }
            if (xh()) {
                codedOutputStreamMicro.writeMessage(4, xi());
            }
            if (xk()) {
                codedOutputStreamMicro.writeMessage(5, xl());
            }
            for (c cVar : xn()) {
                codedOutputStreamMicro.writeMessage(6, cVar);
            }
            if (xp()) {
                codedOutputStreamMicro.writeString(7, xo());
            }
        }

        public int xa() {
            return this.aql.size();
        }

        public boolean xb() {
            return this.ary;
        }

        public a xc() {
            return this.arz;
        }

        public b xd() {
            this.ary = false;
            this.arz = null;
            return this;
        }

        public boolean xe() {
            return this.arA;
        }

        public f xf() {
            return this.arB;
        }

        public b xg() {
            this.arA = false;
            this.arB = null;
            return this;
        }

        public boolean xh() {
            return this.arC;
        }

        public C0120d xi() {
            return this.arD;
        }

        public b xj() {
            this.arC = false;
            this.arD = null;
            return this;
        }

        public boolean xk() {
            return this.arE;
        }

        public e xl() {
            return this.arF;
        }

        public b xm() {
            this.arE = false;
            this.arF = null;
            return this;
        }

        public List<c> xn() {
            return this.arG;
        }

        public String xo() {
            return this.arI;
        }

        public boolean xp() {
            return this.arH;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends MessageMicro {
        private boolean aqh;
        private boolean aqj;
        private boolean aty;
        private String atw = "";
        private String atx = "";
        private String atz = "";
        private List<a> atA = Collections.emptyList();
        private int apY = -1;

        /* loaded from: classes3.dex */
        public static final class a extends MessageMicro {
            private boolean atB;
            private boolean atD;
            private boolean atF;
            private boolean atH;
            private String atC = "";
            private String atE = "";
            private String atG = "";
            private String atI = "";
            private int apY = -1;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: D */
            public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ff(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fg(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            fh(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            fi(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public a ff(String str) {
                this.atB = true;
                this.atC = str;
                return this;
            }

            public a fg(String str) {
                this.atD = true;
                this.atE = str;
                return this;
            }

            public a fh(String str) {
                this.atF = true;
                this.atG = str;
                return this;
            }

            public a fi(String str) {
                this.atH = true;
                this.atI = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public String getDesc() {
                return this.atI;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zc() ? 0 + CodedOutputStreamMicro.computeStringSize(1, zb()) : 0;
                if (ze()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, zd());
                }
                if (zg()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, zf());
                }
                if (zh()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.apY = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (zc()) {
                    codedOutputStreamMicro.writeString(1, zb());
                }
                if (ze()) {
                    codedOutputStreamMicro.writeString(2, zd());
                }
                if (zg()) {
                    codedOutputStreamMicro.writeString(3, zf());
                }
                if (zh()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public String zb() {
                return this.atC;
            }

            public boolean zc() {
                return this.atB;
            }

            public String zd() {
                return this.atE;
            }

            public boolean ze() {
                return this.atD;
            }

            public String zf() {
                return this.atG;
            }

            public boolean zg() {
                return this.atF;
            }

            public boolean zh() {
                return this.atH;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: C */
        public c mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        fc(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        fd(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fe(codedInputStreamMicro.readString());
                        break;
                    case 34:
                        a aVar = new a();
                        codedInputStreamMicro.readMessage(aVar);
                        a(aVar);
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(a aVar) {
            if (aVar != null) {
                if (this.atA.isEmpty()) {
                    this.atA = new ArrayList();
                }
                this.atA.add(aVar);
            }
            return this;
        }

        public c fc(String str) {
            this.aqh = true;
            this.atw = str;
            return this;
        }

        public c fd(String str) {
            this.aqj = true;
            this.atx = str;
            return this;
        }

        public c fe(String str) {
            this.aty = true;
            this.atz = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apY < 0) {
                getSerializedSize();
            }
            return this.apY;
        }

        public String getDistance() {
            return this.atw;
        }

        public String getDuration() {
            return this.atx;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = vK() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (yZ()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, yY());
            }
            Iterator<a> it = za().iterator();
            while (true) {
                int i = computeStringSize;
                if (!it.hasNext()) {
                    this.apY = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.aqj;
        }

        public boolean vK() {
            return this.aqh;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vK()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (yZ()) {
                codedOutputStreamMicro.writeString(3, yY());
            }
            for (a aVar : za()) {
                codedOutputStreamMicro.writeMessage(4, aVar);
            }
        }

        public String yY() {
            return this.atz;
        }

        public boolean yZ() {
            return this.aty;
        }

        public List<a> za() {
            return this.atA;
        }
    }

    public d a(com.baidu.f.a.a aVar) {
        if (aVar == null) {
            return wp();
        }
        this.aqO = true;
        this.aqP = aVar;
        return this;
    }

    public d a(com.baidu.f.a.b bVar) {
        if (bVar != null) {
            if (this.aqQ.isEmpty()) {
                this.aqQ = new ArrayList();
            }
            this.aqQ.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return wm();
        }
        this.apZ = true;
        this.aqN = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.aqb.isEmpty()) {
                this.aqb = new ArrayList();
            }
            this.aqb.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return wk();
        }
        this.aqL = true;
        this.aqM = cVar;
        return this;
    }

    public b cc(int i) {
        return this.aqb.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apY < 0) {
            getSerializedSize();
        }
        return this.apY;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        Iterator<b> it = vH().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
        }
        if (wi()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, wj());
        }
        if (vE()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, wl());
        }
        if (wn()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, wo());
        }
        for (com.baidu.f.a.b bVar : wq()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, bVar);
        }
        this.apY = i;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.micro.MessageMicro
    /* renamed from: j */
    public d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    b bVar = new b();
                    codedInputStreamMicro.readMessage(bVar);
                    a(bVar);
                    break;
                case 18:
                    c cVar = new c();
                    codedInputStreamMicro.readMessage(cVar);
                    a(cVar);
                    break;
                case 26:
                    a aVar = new a();
                    codedInputStreamMicro.readMessage(aVar);
                    a(aVar);
                    break;
                case 34:
                    com.baidu.f.a.a aVar2 = new com.baidu.f.a.a();
                    codedInputStreamMicro.readMessage(aVar2);
                    a(aVar2);
                    break;
                case 42:
                    com.baidu.f.a.b bVar2 = new com.baidu.f.a.b();
                    codedInputStreamMicro.readMessage(bVar2);
                    a(bVar2);
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    public boolean vE() {
        return this.apZ;
    }

    public List<b> vH() {
        return this.aqb;
    }

    public int vI() {
        return this.aqb.size();
    }

    public boolean wi() {
        return this.aqL;
    }

    public c wj() {
        return this.aqM;
    }

    public d wk() {
        this.aqL = false;
        this.aqM = null;
        return this;
    }

    public a wl() {
        return this.aqN;
    }

    public d wm() {
        this.apZ = false;
        this.aqN = null;
        return this;
    }

    public boolean wn() {
        return this.aqO;
    }

    public com.baidu.f.a.a wo() {
        return this.aqP;
    }

    public d wp() {
        this.aqO = false;
        this.aqP = null;
        return this;
    }

    public List<com.baidu.f.a.b> wq() {
        return this.aqQ;
    }

    public int wr() {
        return this.aqQ.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (b bVar : vH()) {
            codedOutputStreamMicro.writeMessage(1, bVar);
        }
        if (wi()) {
            codedOutputStreamMicro.writeMessage(2, wj());
        }
        if (vE()) {
            codedOutputStreamMicro.writeMessage(3, wl());
        }
        if (wn()) {
            codedOutputStreamMicro.writeMessage(4, wo());
        }
        for (com.baidu.f.a.b bVar2 : wq()) {
            codedOutputStreamMicro.writeMessage(5, bVar2);
        }
    }
}
