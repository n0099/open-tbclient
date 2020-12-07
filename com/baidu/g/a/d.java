package com.baidu.g.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes26.dex */
public final class d extends MessageMicro {
    private boolean arN;
    private boolean asA;
    private boolean asD;
    private c asB = null;
    private List<b> arP = Collections.emptyList();
    private a asC = null;
    private com.baidu.g.a.a asE = null;
    private List<com.baidu.g.a.b> asF = Collections.emptyList();
    private int arM = -1;

    /* loaded from: classes26.dex */
    public static final class a extends MessageMicro {
        private boolean arS;
        private boolean asG;
        private boolean asI;
        private boolean asK;
        private boolean asN;
        private boolean asP;
        private boolean asS;
        private boolean asU;
        private boolean asW;
        private boolean asY;
        private int arT = 0;
        private String asH = "";
        private int asJ = 0;
        private c asL = null;
        private List<C0128a> asM = Collections.emptyList();
        private int asO = 0;
        private C0129d asQ = null;
        private List<b> asR = Collections.emptyList();
        private int asT = 0;
        private String asV = "";
        private int asX = 0;
        private String asZ = "";
        private int arM = -1;

        /* renamed from: com.baidu.g.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C0128a extends MessageMicro {
            private boolean arJ;
            private boolean ata;
            private boolean atc;
            private boolean ate;
            private boolean ath;
            private boolean atj;
            private String atb = "";
            private String atd = "";
            private String arK = "";
            private boolean atf = false;
            private List<Integer> atg = Collections.emptyList();
            private String ati = "";
            private String atk = "";
            private int arM = -1;

            public C0128a aW(boolean z) {
                this.ate = true;
                this.atf = z;
                return this;
            }

            public int cm(int i) {
                return this.atg.get(i).intValue();
            }

            public C0128a cn(int i) {
                if (this.atg.isEmpty()) {
                    this.atg = new ArrayList();
                }
                this.atg.add(Integer.valueOf(i));
                return this;
            }

            public C0128a eC(String str) {
                this.ata = true;
                this.atb = str;
                return this;
            }

            public C0128a eD(String str) {
                this.atc = true;
                this.atd = str;
                return this;
            }

            public C0128a eE(String str) {
                this.arJ = true;
                this.arK = str;
                return this;
            }

            public C0128a eF(String str) {
                this.ath = true;
                this.ati = str;
                return this;
            }

            public C0128a eG(String str) {
                this.atj = true;
                this.atk = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getFloor() {
                return this.ati;
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
                this.arM = size;
                return size;
            }

            public String getUid() {
                return this.arK;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: l */
            public C0128a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            eC(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eD(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eE(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aW(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cn(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            eF(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            eG(codedInputStreamMicro.readString());
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
                return this.arJ;
            }

            public String wN() {
                return this.atb;
            }

            public boolean wO() {
                return this.ata;
            }

            public String wP() {
                return this.atd;
            }

            public boolean wQ() {
                return this.atc;
            }

            public boolean wR() {
                return this.atf;
            }

            public boolean wS() {
                return this.ate;
            }

            public List<Integer> wT() {
                return this.atg;
            }

            public boolean wU() {
                return this.ath;
            }

            public String wV() {
                return this.atk;
            }

            public boolean wW() {
                return this.atj;
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

        /* loaded from: classes26.dex */
        public static final class b extends MessageMicro {
            private boolean ary;
            private boolean atl;
            private int arz = 0;
            private String atm = "";
            private int arM = -1;

            public b co(int i) {
                this.ary = true;
                this.arz = i;
                return this;
            }

            public b eH(String str) {
                this.atl = true;
                this.atm = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getCname() {
                return this.atm;
            }

            public int getCode() {
                return this.arz;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vv() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wX()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.arM = computeInt32Size;
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
                            co(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            eH(codedInputStreamMicro.readString());
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
                return this.ary;
            }

            public boolean wX() {
                return this.atl;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vv()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wX()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        /* loaded from: classes26.dex */
        public static final class c extends MessageMicro {
            private boolean arJ;
            private boolean ata;
            private boolean atc;
            private boolean ate;
            private boolean ath;
            private boolean atj;
            private String atb = "";
            private String atd = "";
            private String arK = "";
            private boolean atf = false;
            private List<Integer> atg = Collections.emptyList();
            private String ati = "";
            private String atk = "";
            private int arM = -1;

            public c aX(boolean z) {
                this.ate = true;
                this.atf = z;
                return this;
            }

            public int cm(int i) {
                return this.atg.get(i).intValue();
            }

            public c cp(int i) {
                if (this.atg.isEmpty()) {
                    this.atg = new ArrayList();
                }
                this.atg.add(Integer.valueOf(i));
                return this;
            }

            public c eI(String str) {
                this.ata = true;
                this.atb = str;
                return this;
            }

            public c eJ(String str) {
                this.atc = true;
                this.atd = str;
                return this;
            }

            public c eK(String str) {
                this.arJ = true;
                this.arK = str;
                return this;
            }

            public c eL(String str) {
                this.ath = true;
                this.ati = str;
                return this;
            }

            public c eM(String str) {
                this.atj = true;
                this.atk = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getFloor() {
                return this.ati;
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
                this.arM = size;
                return size;
            }

            public String getUid() {
                return this.arK;
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
                            eI(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eJ(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eK(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aX(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cp(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            eL(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            eM(codedInputStreamMicro.readString());
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
                return this.arJ;
            }

            public String wN() {
                return this.atb;
            }

            public boolean wO() {
                return this.ata;
            }

            public String wP() {
                return this.atd;
            }

            public boolean wQ() {
                return this.atc;
            }

            public boolean wR() {
                return this.atf;
            }

            public boolean wS() {
                return this.ate;
            }

            public List<Integer> wT() {
                return this.atg;
            }

            public boolean wU() {
                return this.ath;
            }

            public String wV() {
                return this.atk;
            }

            public boolean wW() {
                return this.atj;
            }

            public int wY() {
                return this.atg.size();
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

        /* renamed from: com.baidu.g.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C0129d extends MessageMicro {
            private boolean ary;
            private boolean atl;
            private int arz = 0;
            private String atm = "";
            private int arM = -1;

            public C0129d cq(int i) {
                this.ary = true;
                this.arz = i;
                return this;
            }

            public C0129d eN(String str) {
                this.atl = true;
                this.atm = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getCname() {
                return this.atm;
            }

            public int getCode() {
                return this.arz;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vv() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wX()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.arM = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: o */
            public C0129d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cq(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            eN(codedInputStreamMicro.readString());
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
                return this.ary;
            }

            public boolean wX() {
                return this.atl;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vv()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wX()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public a a(C0128a c0128a) {
            if (c0128a != null) {
                if (this.asM.isEmpty()) {
                    this.asM = new ArrayList();
                }
                this.asM.add(c0128a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.asR.isEmpty()) {
                    this.asR = new ArrayList();
                }
                this.asR.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wx();
            }
            this.asK = true;
            this.asL = cVar;
            return this;
        }

        public a a(C0129d c0129d) {
            if (c0129d == null) {
                return wD();
            }
            this.asP = true;
            this.asQ = c0129d;
            return this;
        }

        public a cf(int i) {
            this.arS = true;
            this.arT = i;
            return this;
        }

        public a cg(int i) {
            this.asI = true;
            this.asJ = i;
            return this;
        }

        public C0128a ch(int i) {
            return this.asM.get(i);
        }

        public a ci(int i) {
            this.asN = true;
            this.asO = i;
            return this;
        }

        public b cj(int i) {
            return this.asR.get(i);
        }

        public a ck(int i) {
            this.asS = true;
            this.asT = i;
            return this;
        }

        public a cl(int i) {
            this.asW = true;
            this.asX = i;
            return this;
        }

        public a eA(String str) {
            this.asU = true;
            this.asV = str;
            return this;
        }

        public a eB(String str) {
            this.asY = true;
            this.asZ = str;
            return this;
        }

        public a ez(String str) {
            this.asG = true;
            this.asH = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.arM < 0) {
                getSerializedSize();
            }
            return this.arM;
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
            Iterator<C0128a> it = wy().iterator();
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
            this.arM = i;
            return i;
        }

        public int getTotal() {
            return this.arT;
        }

        public boolean hasStart() {
            return this.asK;
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
                        cf(codedInputStreamMicro.readInt32());
                        break;
                    case 18:
                        ez(codedInputStreamMicro.readString());
                        break;
                    case 24:
                        cg(codedInputStreamMicro.readInt32());
                        break;
                    case 34:
                        c cVar = new c();
                        codedInputStreamMicro.readMessage(cVar);
                        a(cVar);
                        break;
                    case 42:
                        C0128a c0128a = new C0128a();
                        codedInputStreamMicro.readMessage(c0128a);
                        a(c0128a);
                        break;
                    case 48:
                        ci(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        C0129d c0129d = new C0129d();
                        codedInputStreamMicro.readMessage(c0129d);
                        a(c0129d);
                        break;
                    case 66:
                        b bVar = new b();
                        codedInputStreamMicro.readMessage(bVar);
                        a(bVar);
                        break;
                    case 72:
                        ck(codedInputStreamMicro.readInt32());
                        break;
                    case 82:
                        eA(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        cl(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
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

        public boolean vJ() {
            return this.arS;
        }

        public boolean wA() {
            return this.asN;
        }

        public boolean wB() {
            return this.asP;
        }

        public C0129d wC() {
            return this.asQ;
        }

        public a wD() {
            this.asP = false;
            this.asQ = null;
            return this;
        }

        public List<b> wE() {
            return this.asR;
        }

        public int wF() {
            return this.asT;
        }

        public boolean wG() {
            return this.asS;
        }

        public String wH() {
            return this.asV;
        }

        public boolean wI() {
            return this.asU;
        }

        public int wJ() {
            return this.asX;
        }

        public boolean wK() {
            return this.asW;
        }

        public String wL() {
            return this.asZ;
        }

        public boolean wM() {
            return this.asY;
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
            for (C0128a c0128a : wy()) {
                codedOutputStreamMicro.writeMessage(5, c0128a);
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
            return this.asH;
        }

        public boolean wt() {
            return this.asG;
        }

        public int wu() {
            return this.asJ;
        }

        public boolean wv() {
            return this.asI;
        }

        public c ww() {
            return this.asL;
        }

        public a wx() {
            this.asK = false;
            this.asL = null;
            return this;
        }

        public List<C0128a> wy() {
            return this.asM;
        }

        public int wz() {
            return this.asO;
        }
    }

    /* loaded from: classes26.dex */
    public static final class b extends MessageMicro {
        private boolean atn;
        private boolean atp;
        private boolean atr;
        private boolean att;
        private boolean atw;
        private List<C0130b> arZ = Collections.emptyList();
        private a ato = null;
        private f atq = null;
        private C0133d ats = null;
        private e atu = null;
        private List<c> atv = Collections.emptyList();
        private String atx = "";
        private int arM = -1;

        /* loaded from: classes26.dex */
        public static final class a extends MessageMicro {
            private boolean atA;
            private boolean atC;
            private boolean aty;
            private int atz = 0;
            private int atB = 0;
            private int atD = 0;
            private int arM = -1;

            public a cs(int i) {
                this.aty = true;
                this.atz = i;
                return this;
            }

            public a ct(int i) {
                this.atA = true;
                this.atB = i;
                return this;
            }

            public a cu(int i) {
                this.atC = true;
                this.atD = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = xq() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xp()) : 0;
                if (xs()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xr());
                }
                if (xu()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, xt());
                }
                this.arM = computeInt32Size;
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
                            cs(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            ct(codedInputStreamMicro.readInt32());
                            break;
                        case 24:
                            cu(codedInputStreamMicro.readInt32());
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
                if (xq()) {
                    codedOutputStreamMicro.writeInt32(1, xp());
                }
                if (xs()) {
                    codedOutputStreamMicro.writeInt32(2, xr());
                }
                if (xu()) {
                    codedOutputStreamMicro.writeInt32(3, xt());
                }
            }

            public int xp() {
                return this.atz;
            }

            public boolean xq() {
                return this.aty;
            }

            public int xr() {
                return this.atB;
            }

            public boolean xs() {
                return this.atA;
            }

            public int xt() {
                return this.atD;
            }

            public boolean xu() {
                return this.atC;
            }
        }

        /* renamed from: com.baidu.g.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C0130b extends MessageMicro {
            private boolean arV;
            private boolean arX;
            private boolean atE;
            private boolean atG;
            private boolean atI;
            private boolean atK;
            private boolean atM;
            private boolean atP;
            private List<c> ase = Collections.emptyList();
            private List<Integer> asc = Collections.emptyList();
            private List<Integer> asd = Collections.emptyList();
            private String atF = "";
            private String atH = "";
            private int arW = 0;
            private int arY = 0;
            private int atJ = 0;
            private int atL = 0;
            private int atN = 0;
            private List<a> atO = Collections.emptyList();
            private C0131b atQ = null;
            private int arM = -1;

            /* renamed from: com.baidu.g.a.d$b$b$a */
            /* loaded from: classes26.dex */
            public static final class a extends MessageMicro {
                private boolean arU;
                private boolean atR;
                private boolean atT;
                private boolean ath;
                private boolean atj;
                private int type_ = 0;
                private int atS = 0;
                private String atU = "";
                private List<Integer> aso = Collections.emptyList();
                private String ati = "";
                private String atk = "";
                private int arM = -1;

                public a cD(int i) {
                    this.arU = true;
                    this.type_ = i;
                    return this;
                }

                public a cE(int i) {
                    this.atR = true;
                    this.atS = i;
                    return this;
                }

                public a cF(int i) {
                    if (this.aso.isEmpty()) {
                        this.aso = new ArrayList();
                    }
                    this.aso.add(Integer.valueOf(i));
                    return this;
                }

                public a eR(String str) {
                    this.atT = true;
                    this.atU = str;
                    return this;
                }

                public a eS(String str) {
                    this.ath = true;
                    this.ati = str;
                    return this;
                }

                public a eT(String str) {
                    this.atj = true;
                    this.atk = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.arM < 0) {
                        getSerializedSize();
                    }
                    return this.arM;
                }

                public String getFloor() {
                    return this.ati;
                }

                public String getInfo() {
                    return this.atU;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (xL()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xK());
                    }
                    int computeStringSize = xM() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
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
                    this.arM = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.arU;
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
                                cD(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cE(codedInputStreamMicro.readInt32());
                                break;
                            case 26:
                                eR(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cF(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eS(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eT(codedInputStreamMicro.readString());
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
                    return this.aso;
                }

                public boolean wU() {
                    return this.ath;
                }

                public String wV() {
                    return this.atk;
                }

                public boolean wW() {
                    return this.atj;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (xL()) {
                        codedOutputStreamMicro.writeInt32(2, xK());
                    }
                    if (xM()) {
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

                public int xK() {
                    return this.atS;
                }

                public boolean xL() {
                    return this.atR;
                }

                public boolean xM() {
                    return this.atT;
                }
            }

            /* renamed from: com.baidu.g.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public static final class C0131b extends MessageMicro {
                private boolean atV;
                private boolean hasNext;
                private int atW = 0;
                private int atX = 0;
                private int arM = -1;

                public C0131b cG(int i) {
                    this.atV = true;
                    this.atW = i;
                    return this;
                }

                public C0131b cH(int i) {
                    this.hasNext = true;
                    this.atX = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.arM < 0) {
                        getSerializedSize();
                    }
                    return this.arM;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xO() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xN()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xP());
                    }
                    this.arM = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: t */
                public C0131b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                cG(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cH(codedInputStreamMicro.readInt32());
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
                    if (xO()) {
                        codedOutputStreamMicro.writeInt32(1, xN());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, xP());
                    }
                }

                public int xN() {
                    return this.atW;
                }

                public boolean xO() {
                    return this.atV;
                }

                public int xP() {
                    return this.atX;
                }
            }

            /* renamed from: com.baidu.g.a.d$b$b$c */
            /* loaded from: classes26.dex */
            public static final class c extends MessageMicro {
                private boolean arD;
                private boolean arU;
                private boolean arV;
                private boolean arX;
                private boolean asf;
                private boolean atZ;
                private boolean aub;
                private boolean aud;
                private boolean auf;
                private boolean auh;
                private boolean auj;
                private boolean aul;
                private boolean aun;
                private boolean auq;
                private boolean aut;
                private List<a> atY = Collections.emptyList();
                private List<C0132b> ask = Collections.emptyList();
                private List<Integer> asj = Collections.emptyList();
                private String asg = "";
                private int type_ = 0;
                private String arE = "";
                private int aua = 0;
                private int auc = 0;
                private int aue = 0;
                private int aug = 0;
                private int aui = 0;
                private int auk = 0;
                private int arW = 0;
                private int arY = 0;
                private int aum = 0;
                private int auo = 0;
                private List<Integer> asc = Collections.emptyList();
                private List<Integer> asd = Collections.emptyList();
                private List<Integer> aup = Collections.emptyList();
                private int aur = 0;
                private List<Integer> aus = Collections.emptyList();
                private int auu = 0;
                private List<C0132b> auv = Collections.emptyList();
                private int arM = -1;

                /* renamed from: com.baidu.g.a.d$b$b$c$a */
                /* loaded from: classes26.dex */
                public static final class a extends MessageMicro {
                    private boolean asy;
                    private boolean auA;
                    private boolean auC;
                    private boolean aun;
                    private boolean auw;
                    private boolean auy;
                    private String aux = "";
                    private int auz = 0;
                    private int asz = 0;
                    private int auo = 0;
                    private int auB = 0;
                    private int auD = 0;
                    private int arM = -1;

                    public a da(int i) {
                        this.auy = true;
                        this.auz = i;
                        return this;
                    }

                    public a db(int i) {
                        this.asy = true;
                        this.asz = i;
                        return this;
                    }

                    public a dc(int i) {
                        this.aun = true;
                        this.auo = i;
                        return this;
                    }

                    public a dd(int i) {
                        this.auA = true;
                        this.auB = i;
                        return this;
                    }

                    public a de(int i) {
                        this.auC = true;
                        this.auD = i;
                        return this;
                    }

                    public a eW(String str) {
                        this.auw = true;
                        this.aux = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.arM < 0) {
                            getSerializedSize();
                        }
                        return this.arM;
                    }

                    public String getId() {
                        return this.aux;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (yo()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, yn());
                        }
                        if (wh()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, wg());
                        }
                        if (yf()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, ye());
                        }
                        if (yq()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, yp());
                        }
                        if (ys()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, yr());
                        }
                        this.arM = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.auw;
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
                                    eW(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    da(codedInputStreamMicro.readInt32());
                                    break;
                                case 24:
                                    db(codedInputStreamMicro.readInt32());
                                    break;
                                case 32:
                                    dc(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    dd(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    de(codedInputStreamMicro.readInt32());
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
                        return this.asz;
                    }

                    public boolean wh() {
                        return this.asy;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (yo()) {
                            codedOutputStreamMicro.writeInt32(2, yn());
                        }
                        if (wh()) {
                            codedOutputStreamMicro.writeInt32(3, wg());
                        }
                        if (yf()) {
                            codedOutputStreamMicro.writeInt32(4, ye());
                        }
                        if (yq()) {
                            codedOutputStreamMicro.writeInt32(5, yp());
                        }
                        if (ys()) {
                            codedOutputStreamMicro.writeInt32(6, yr());
                        }
                    }

                    public int ye() {
                        return this.auo;
                    }

                    public boolean yf() {
                        return this.aun;
                    }

                    public int yn() {
                        return this.auz;
                    }

                    public boolean yo() {
                        return this.auy;
                    }

                    public int yp() {
                        return this.auB;
                    }

                    public boolean yq() {
                        return this.auA;
                    }

                    public int yr() {
                        return this.auD;
                    }

                    public boolean ys() {
                        return this.auC;
                    }
                }

                /* renamed from: com.baidu.g.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes26.dex */
                public static final class C0132b extends MessageMicro {
                    private boolean arD;
                    private boolean arJ;
                    private boolean atI;
                    private boolean auF;
                    private boolean auH;
                    private boolean auJ;
                    private boolean auM;
                    private boolean auO;
                    private boolean auQ;
                    private boolean auS;
                    private boolean auU;
                    private String arE = "";
                    private List<Integer> auE = Collections.emptyList();
                    private int atJ = 0;
                    private String auG = "";
                    private String auI = "";
                    private String auK = "";
                    private String arK = "";
                    private List<Integer> auL = Collections.emptyList();
                    private String auN = "";
                    private String auP = "";
                    private String auR = "";
                    private int auT = 0;
                    private int auV = 0;
                    private int arM = -1;

                    public C0132b df(int i) {
                        if (this.auE.isEmpty()) {
                            this.auE = new ArrayList();
                        }
                        this.auE.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0132b dg(int i) {
                        this.atI = true;
                        this.atJ = i;
                        return this;
                    }

                    public C0132b dh(int i) {
                        if (this.auL.isEmpty()) {
                            this.auL = new ArrayList();
                        }
                        this.auL.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0132b di(int i) {
                        this.auS = true;
                        this.auT = i;
                        return this;
                    }

                    public C0132b dj(int i) {
                        this.auU = true;
                        this.auV = i;
                        return this;
                    }

                    public C0132b eX(String str) {
                        this.arD = true;
                        this.arE = str;
                        return this;
                    }

                    public C0132b eY(String str) {
                        this.auF = true;
                        this.auG = str;
                        return this;
                    }

                    public C0132b eZ(String str) {
                        this.auH = true;
                        this.auI = str;
                        return this;
                    }

                    public C0132b fa(String str) {
                        this.auJ = true;
                        this.auK = str;
                        return this;
                    }

                    public C0132b fb(String str) {
                        this.arJ = true;
                        this.arK = str;
                        return this;
                    }

                    public C0132b fc(String str) {
                        this.auM = true;
                        this.auN = str;
                        return this;
                    }

                    public C0132b fd(String str) {
                        this.auO = true;
                        this.auP = str;
                        return this;
                    }

                    public C0132b fe(String str) {
                        this.auQ = true;
                        this.auR = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.arM < 0) {
                            getSerializedSize();
                        }
                        return this.arM;
                    }

                    public String getIconUrl() {
                        return this.auN;
                    }

                    public String getName() {
                        return this.arE;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        int i2 = 0;
                        for (Integer num : yt()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i2;
                        }
                        int size = computeStringSize + i2 + (yt().size() * 1);
                        if (xB()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, xA());
                        }
                        if (yv()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, yu());
                        }
                        if (yx()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, yw());
                        }
                        if (yz()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, yy());
                        }
                        int computeStringSize2 = vC() ? size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : size;
                        for (Integer num2 : yA()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                        }
                        int size2 = computeStringSize2 + i + (yA().size() * 1);
                        if (yB()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (yD()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, yC());
                        }
                        if (yF()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, yE());
                        }
                        if (yH()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, yG());
                        }
                        if (yJ()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, yI());
                        }
                        this.arM = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.arK;
                    }

                    public boolean hasName() {
                        return this.arD;
                    }

                    public boolean vC() {
                        return this.arJ;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: w */
                    public C0132b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eX(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    df(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    dg(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eY(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eZ(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    fa(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    fb(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    dh(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    fc(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    fd(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    fe(codedInputStreamMicro.readString());
                                    break;
                                case 96:
                                    di(codedInputStreamMicro.readInt32());
                                    break;
                                case 104:
                                    dj(codedInputStreamMicro.readInt32());
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
                        for (Integer num : yt()) {
                            codedOutputStreamMicro.writeSInt32(2, num.intValue());
                        }
                        if (xB()) {
                            codedOutputStreamMicro.writeInt32(3, xA());
                        }
                        if (yv()) {
                            codedOutputStreamMicro.writeString(4, yu());
                        }
                        if (yx()) {
                            codedOutputStreamMicro.writeString(5, yw());
                        }
                        if (yz()) {
                            codedOutputStreamMicro.writeString(6, yy());
                        }
                        if (vC()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        for (Integer num2 : yA()) {
                            codedOutputStreamMicro.writeSInt32(8, num2.intValue());
                        }
                        if (yB()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (yD()) {
                            codedOutputStreamMicro.writeString(10, yC());
                        }
                        if (yF()) {
                            codedOutputStreamMicro.writeString(11, yE());
                        }
                        if (yH()) {
                            codedOutputStreamMicro.writeInt32(12, yG());
                        }
                        if (yJ()) {
                            codedOutputStreamMicro.writeInt32(13, yI());
                        }
                    }

                    public int xA() {
                        return this.atJ;
                    }

                    public boolean xB() {
                        return this.atI;
                    }

                    public List<Integer> yA() {
                        return this.auL;
                    }

                    public boolean yB() {
                        return this.auM;
                    }

                    public String yC() {
                        return this.auP;
                    }

                    public boolean yD() {
                        return this.auO;
                    }

                    public String yE() {
                        return this.auR;
                    }

                    public boolean yF() {
                        return this.auQ;
                    }

                    public int yG() {
                        return this.auT;
                    }

                    public boolean yH() {
                        return this.auS;
                    }

                    public int yI() {
                        return this.auV;
                    }

                    public boolean yJ() {
                        return this.auU;
                    }

                    public List<Integer> yt() {
                        return this.auE;
                    }

                    public String yu() {
                        return this.auG;
                    }

                    public boolean yv() {
                        return this.auF;
                    }

                    public String yw() {
                        return this.auI;
                    }

                    public boolean yx() {
                        return this.auH;
                    }

                    public String yy() {
                        return this.auK;
                    }

                    public boolean yz() {
                        return this.auJ;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.atY.isEmpty()) {
                            this.atY = new ArrayList();
                        }
                        this.atY.add(aVar);
                    }
                    return this;
                }

                public c a(C0132b c0132b) {
                    if (c0132b != null) {
                        if (this.ask.isEmpty()) {
                            this.ask = new ArrayList();
                        }
                        this.ask.add(c0132b);
                    }
                    return this;
                }

                public c b(C0132b c0132b) {
                    if (c0132b != null) {
                        if (this.auv.isEmpty()) {
                            this.auv = new ArrayList();
                        }
                        this.auv.add(c0132b);
                    }
                    return this;
                }

                public c cI(int i) {
                    if (this.asj.isEmpty()) {
                        this.asj = new ArrayList();
                    }
                    this.asj.add(Integer.valueOf(i));
                    return this;
                }

                public c cJ(int i) {
                    this.arU = true;
                    this.type_ = i;
                    return this;
                }

                public c cK(int i) {
                    this.atZ = true;
                    this.aua = i;
                    return this;
                }

                public c cL(int i) {
                    this.aub = true;
                    this.auc = i;
                    return this;
                }

                public c cM(int i) {
                    this.aud = true;
                    this.aue = i;
                    return this;
                }

                public c cN(int i) {
                    this.auf = true;
                    this.aug = i;
                    return this;
                }

                public c cO(int i) {
                    this.auh = true;
                    this.aui = i;
                    return this;
                }

                public c cP(int i) {
                    this.auj = true;
                    this.auk = i;
                    return this;
                }

                public c cQ(int i) {
                    this.arV = true;
                    this.arW = i;
                    return this;
                }

                public c cR(int i) {
                    this.arX = true;
                    this.arY = i;
                    return this;
                }

                public c cS(int i) {
                    this.aul = true;
                    this.aum = i;
                    return this;
                }

                public c cT(int i) {
                    this.aun = true;
                    this.auo = i;
                    return this;
                }

                public c cU(int i) {
                    if (this.asc.isEmpty()) {
                        this.asc = new ArrayList();
                    }
                    this.asc.add(Integer.valueOf(i));
                    return this;
                }

                public c cV(int i) {
                    if (this.asd.isEmpty()) {
                        this.asd = new ArrayList();
                    }
                    this.asd.add(Integer.valueOf(i));
                    return this;
                }

                public c cW(int i) {
                    if (this.aup.isEmpty()) {
                        this.aup = new ArrayList();
                    }
                    this.aup.add(Integer.valueOf(i));
                    return this;
                }

                public c cX(int i) {
                    this.auq = true;
                    this.aur = i;
                    return this;
                }

                public c cY(int i) {
                    if (this.aus.isEmpty()) {
                        this.aus = new ArrayList();
                    }
                    this.aus.add(Integer.valueOf(i));
                    return this;
                }

                public c cZ(int i) {
                    this.aut = true;
                    this.auu = i;
                    return this;
                }

                public c eU(String str) {
                    this.asf = true;
                    this.asg = str;
                    return this;
                }

                public c eV(String str) {
                    this.arD = true;
                    this.arE = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.arM < 0) {
                        getSerializedSize();
                    }
                    return this.arM;
                }

                public int getDirection() {
                    return this.aum;
                }

                public int getDistance() {
                    return this.arW;
                }

                public int getDuration() {
                    return this.arY;
                }

                public String getInstructions() {
                    return this.asg;
                }

                public String getName() {
                    return this.arE;
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
                    if (xS()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, xR());
                    }
                    if (xU()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, xT());
                    }
                    if (xW()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, xV());
                    }
                    if (xY()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, xX());
                    }
                    if (ya()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, xZ());
                    }
                    if (yc()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, yb());
                    }
                    if (vK()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<a> it = xQ().iterator();
                    while (true) {
                        i = size;
                        if (!it.hasNext()) {
                            break;
                        }
                        size = CodedOutputStreamMicro.computeMessageSize(13, it.next()) + i;
                    }
                    for (C0132b c0132b : vV()) {
                        i += CodedOutputStreamMicro.computeMessageSize(14, c0132b);
                    }
                    if (yd()) {
                        i += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (yf()) {
                        i += CodedOutputStreamMicro.computeInt32Size(16, ye());
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
                    for (Integer num4 : yg()) {
                        i6 = CodedOutputStreamMicro.computeInt32SizeNoTag(num4.intValue()) + i6;
                    }
                    int size4 = size3 + i6 + (yg().size() * 2);
                    int computeInt32Size = yi() ? size4 + CodedOutputStreamMicro.computeInt32Size(20, yh()) : size4;
                    for (Integer num5 : yj()) {
                        i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num5.intValue());
                    }
                    int size5 = computeInt32Size + i2 + (yj().size() * 2);
                    if (yl()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, yk());
                    }
                    Iterator<C0132b> it2 = ym().iterator();
                    while (true) {
                        int i7 = size5;
                        if (!it2.hasNext()) {
                            this.arM = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.arX;
                }

                public boolean hasName() {
                    return this.arD;
                }

                public boolean hasType() {
                    return this.arU;
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
                                cI(codedInputStreamMicro.readSInt32());
                                break;
                            case 18:
                                eU(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cJ(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eV(codedInputStreamMicro.readString());
                                break;
                            case 40:
                                cK(codedInputStreamMicro.readInt32());
                                break;
                            case 48:
                                cL(codedInputStreamMicro.readInt32());
                                break;
                            case 56:
                                cM(codedInputStreamMicro.readInt32());
                                break;
                            case 64:
                                cN(codedInputStreamMicro.readInt32());
                                break;
                            case 72:
                                cO(codedInputStreamMicro.readInt32());
                                break;
                            case 80:
                                cP(codedInputStreamMicro.readInt32());
                                break;
                            case 88:
                                cQ(codedInputStreamMicro.readInt32());
                                break;
                            case 96:
                                cR(codedInputStreamMicro.readInt32());
                                break;
                            case 106:
                                a aVar = new a();
                                codedInputStreamMicro.readMessage(aVar);
                                a(aVar);
                                break;
                            case 114:
                                C0132b c0132b = new C0132b();
                                codedInputStreamMicro.readMessage(c0132b);
                                a(c0132b);
                                break;
                            case 120:
                                cS(codedInputStreamMicro.readInt32());
                                break;
                            case 128:
                                cT(codedInputStreamMicro.readInt32());
                                break;
                            case 136:
                                cU(codedInputStreamMicro.readSInt32());
                                break;
                            case 144:
                                cV(codedInputStreamMicro.readSInt32());
                                break;
                            case 152:
                                cW(codedInputStreamMicro.readInt32());
                                break;
                            case 160:
                                cX(codedInputStreamMicro.readInt32());
                                break;
                            case 168:
                                cY(codedInputStreamMicro.readSInt32());
                                break;
                            case Opcodes.ARETURN /* 176 */:
                                cZ(codedInputStreamMicro.readInt32());
                                break;
                            case 186:
                                C0132b c0132b2 = new C0132b();
                                codedInputStreamMicro.readMessage(c0132b2);
                                b(c0132b2);
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
                    return this.arV;
                }

                public List<Integer> vO() {
                    return this.asc;
                }

                public List<Integer> vP() {
                    return this.asd;
                }

                public boolean vR() {
                    return this.asf;
                }

                public List<Integer> vU() {
                    return this.asj;
                }

                public List<C0132b> vV() {
                    return this.ask;
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
                    if (xS()) {
                        codedOutputStreamMicro.writeInt32(5, xR());
                    }
                    if (xU()) {
                        codedOutputStreamMicro.writeInt32(6, xT());
                    }
                    if (xW()) {
                        codedOutputStreamMicro.writeInt32(7, xV());
                    }
                    if (xY()) {
                        codedOutputStreamMicro.writeInt32(8, xX());
                    }
                    if (ya()) {
                        codedOutputStreamMicro.writeInt32(9, xZ());
                    }
                    if (yc()) {
                        codedOutputStreamMicro.writeInt32(10, yb());
                    }
                    if (vK()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (a aVar : xQ()) {
                        codedOutputStreamMicro.writeMessage(13, aVar);
                    }
                    for (C0132b c0132b : vV()) {
                        codedOutputStreamMicro.writeMessage(14, c0132b);
                    }
                    if (yd()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (yf()) {
                        codedOutputStreamMicro.writeInt32(16, ye());
                    }
                    for (Integer num2 : vO()) {
                        codedOutputStreamMicro.writeSInt32(17, num2.intValue());
                    }
                    for (Integer num3 : vP()) {
                        codedOutputStreamMicro.writeSInt32(18, num3.intValue());
                    }
                    for (Integer num4 : yg()) {
                        codedOutputStreamMicro.writeInt32(19, num4.intValue());
                    }
                    if (yi()) {
                        codedOutputStreamMicro.writeInt32(20, yh());
                    }
                    for (Integer num5 : yj()) {
                        codedOutputStreamMicro.writeSInt32(21, num5.intValue());
                    }
                    if (yl()) {
                        codedOutputStreamMicro.writeInt32(22, yk());
                    }
                    for (C0132b c0132b2 : ym()) {
                        codedOutputStreamMicro.writeMessage(23, c0132b2);
                    }
                }

                public List<a> xQ() {
                    return this.atY;
                }

                public int xR() {
                    return this.aua;
                }

                public boolean xS() {
                    return this.atZ;
                }

                public int xT() {
                    return this.auc;
                }

                public boolean xU() {
                    return this.aub;
                }

                public int xV() {
                    return this.aue;
                }

                public boolean xW() {
                    return this.aud;
                }

                public int xX() {
                    return this.aug;
                }

                public boolean xY() {
                    return this.auf;
                }

                public int xZ() {
                    return this.aui;
                }

                public boolean ya() {
                    return this.auh;
                }

                public int yb() {
                    return this.auk;
                }

                public boolean yc() {
                    return this.auj;
                }

                public boolean yd() {
                    return this.aul;
                }

                public int ye() {
                    return this.auo;
                }

                public boolean yf() {
                    return this.aun;
                }

                public List<Integer> yg() {
                    return this.aup;
                }

                public int yh() {
                    return this.aur;
                }

                public boolean yi() {
                    return this.auq;
                }

                public List<Integer> yj() {
                    return this.aus;
                }

                public int yk() {
                    return this.auu;
                }

                public boolean yl() {
                    return this.aut;
                }

                public List<C0132b> ym() {
                    return this.auv;
                }
            }

            public C0130b a(a aVar) {
                if (aVar != null) {
                    if (this.atO.isEmpty()) {
                        this.atO = new ArrayList();
                    }
                    this.atO.add(aVar);
                }
                return this;
            }

            public C0130b a(C0131b c0131b) {
                if (c0131b == null) {
                    return xJ();
                }
                this.atP = true;
                this.atQ = c0131b;
                return this;
            }

            public C0130b a(c cVar) {
                if (cVar != null) {
                    if (this.ase.isEmpty()) {
                        this.ase = new ArrayList();
                    }
                    this.ase.add(cVar);
                }
                return this;
            }

            public C0130b cA(int i) {
                this.atI = true;
                this.atJ = i;
                return this;
            }

            public C0130b cB(int i) {
                this.atK = true;
                this.atL = i;
                return this;
            }

            public C0130b cC(int i) {
                this.atM = true;
                this.atN = i;
                return this;
            }

            public c cv(int i) {
                return this.ase.get(i);
            }

            public C0130b cw(int i) {
                if (this.asc.isEmpty()) {
                    this.asc = new ArrayList();
                }
                this.asc.add(Integer.valueOf(i));
                return this;
            }

            public C0130b cx(int i) {
                if (this.asd.isEmpty()) {
                    this.asd = new ArrayList();
                }
                this.asd.add(Integer.valueOf(i));
                return this;
            }

            public C0130b cy(int i) {
                this.arV = true;
                this.arW = i;
                return this;
            }

            public C0130b cz(int i) {
                this.arX = true;
                this.arY = i;
                return this;
            }

            public C0130b eP(String str) {
                this.atE = true;
                this.atF = str;
                return this;
            }

            public C0130b eQ(String str) {
                this.atG = true;
                this.atH = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public int getDistance() {
                return this.arW;
            }

            public int getDuration() {
                return this.arY;
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
                if (xx()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, xw());
                }
                if (xz()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, xy());
                }
                if (vK()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (xB()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, xA());
                }
                if (xD()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, xC());
                }
                if (xF()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, xE());
                }
                Iterator<c> it = vQ().iterator();
                while (true) {
                    i = size2;
                    if (!it.hasNext()) {
                        break;
                    }
                    size2 = CodedOutputStreamMicro.computeMessageSize(10, it.next()) + i;
                }
                for (a aVar : xG()) {
                    i += CodedOutputStreamMicro.computeMessageSize(11, aVar);
                }
                if (xH()) {
                    i += CodedOutputStreamMicro.computeMessageSize(12, xI());
                }
                this.arM = i;
                return i;
            }

            public boolean hasDuration() {
                return this.arX;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: r */
            public C0130b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cw(codedInputStreamMicro.readSInt32());
                            break;
                        case 16:
                            cx(codedInputStreamMicro.readSInt32());
                            break;
                        case 26:
                            eP(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eQ(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            cy(codedInputStreamMicro.readInt32());
                            break;
                        case 48:
                            cz(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            cA(codedInputStreamMicro.readInt32());
                            break;
                        case 64:
                            cB(codedInputStreamMicro.readInt32());
                            break;
                        case 72:
                            cC(codedInputStreamMicro.readInt32());
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
                            C0131b c0131b = new C0131b();
                            codedInputStreamMicro.readMessage(c0131b);
                            a(c0131b);
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
                return this.arV;
            }

            public List<Integer> vO() {
                return this.asc;
            }

            public List<Integer> vP() {
                return this.asd;
            }

            public List<c> vQ() {
                return this.ase;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer num : vO()) {
                    codedOutputStreamMicro.writeSInt32(1, num.intValue());
                }
                for (Integer num2 : vP()) {
                    codedOutputStreamMicro.writeSInt32(2, num2.intValue());
                }
                if (xx()) {
                    codedOutputStreamMicro.writeString(3, xw());
                }
                if (xz()) {
                    codedOutputStreamMicro.writeString(4, xy());
                }
                if (vK()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (xB()) {
                    codedOutputStreamMicro.writeInt32(7, xA());
                }
                if (xD()) {
                    codedOutputStreamMicro.writeInt32(8, xC());
                }
                if (xF()) {
                    codedOutputStreamMicro.writeInt32(9, xE());
                }
                for (c cVar : vQ()) {
                    codedOutputStreamMicro.writeMessage(10, cVar);
                }
                for (a aVar : xG()) {
                    codedOutputStreamMicro.writeMessage(11, aVar);
                }
                if (xH()) {
                    codedOutputStreamMicro.writeMessage(12, xI());
                }
            }

            public int xA() {
                return this.atJ;
            }

            public boolean xB() {
                return this.atI;
            }

            public int xC() {
                return this.atL;
            }

            public boolean xD() {
                return this.atK;
            }

            public int xE() {
                return this.atN;
            }

            public boolean xF() {
                return this.atM;
            }

            public List<a> xG() {
                return this.atO;
            }

            public boolean xH() {
                return this.atP;
            }

            public C0131b xI() {
                return this.atQ;
            }

            public C0130b xJ() {
                this.atP = false;
                this.atQ = null;
                return this;
            }

            public int xv() {
                return this.ase.size();
            }

            public String xw() {
                return this.atF;
            }

            public boolean xx() {
                return this.atE;
            }

            public String xy() {
                return this.atH;
            }

            public boolean xz() {
                return this.atG;
            }
        }

        /* loaded from: classes26.dex */
        public static final class c extends MessageMicro {
            private boolean auW;
            private int auX = 0;
            private List<Integer> auY = Collections.emptyList();
            private int arM = -1;

            public c dk(int i) {
                this.auW = true;
                this.auX = i;
                return this;
            }

            public c dl(int i) {
                if (this.auY.isEmpty()) {
                    this.auY = new ArrayList();
                }
                this.auY.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yL() ? CodedOutputStreamMicro.computeInt32Size(1, yK()) + 0 : 0;
                for (Integer num : yM()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yM().size() * 1);
                this.arM = size;
                return size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yL()) {
                    codedOutputStreamMicro.writeInt32(1, yK());
                }
                for (Integer num : yM()) {
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
                            dk(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            dl(codedInputStreamMicro.readSInt32());
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

            public int yK() {
                return this.auX;
            }

            public boolean yL() {
                return this.auW;
            }

            public List<Integer> yM() {
                return this.auY;
            }
        }

        /* renamed from: com.baidu.g.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C0133d extends MessageMicro {
            private boolean auZ;
            private int ava = 0;
            private int arM = -1;

            public C0133d dm(int i) {
                this.auZ = true;
                this.ava = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public int getLightNum() {
                return this.ava;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yN() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.arM = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yN()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: y */
            public C0133d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            dm(codedInputStreamMicro.readInt32());
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

            public boolean yN() {
                return this.auZ;
            }
        }

        /* loaded from: classes26.dex */
        public static final class e extends MessageMicro {
            private boolean asA;
            private boolean asK;
            private boolean avb;
            private boolean avd;
            private int avc = 0;
            private String ave = "";
            private a avf = null;
            private List<a> asM = Collections.emptyList();
            private c asB = null;
            private int arM = -1;

            /* loaded from: classes26.dex */
            public static final class a extends MessageMicro {
                private boolean arD;
                private boolean arJ;
                private boolean ata;
                private boolean ath;
                private boolean atj;
                private String atb = "";
                private String arE = "";
                private String arK = "";
                private List<Integer> atg = Collections.emptyList();
                private String ati = "";
                private String atk = "";
                private int arM = -1;

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
                                fg(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                fh(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                fi(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                m19do(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                fj(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                fk(codedInputStreamMicro.readString());
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

                /* renamed from: do  reason: not valid java name */
                public a m19do(int i) {
                    if (this.atg.isEmpty()) {
                        this.atg = new ArrayList();
                    }
                    this.atg.add(Integer.valueOf(i));
                    return this;
                }

                public a fg(String str) {
                    this.ata = true;
                    this.atb = str;
                    return this;
                }

                public a fh(String str) {
                    this.arD = true;
                    this.arE = str;
                    return this;
                }

                public a fi(String str) {
                    this.arJ = true;
                    this.arK = str;
                    return this;
                }

                public a fj(String str) {
                    this.ath = true;
                    this.ati = str;
                    return this;
                }

                public a fk(String str) {
                    this.atj = true;
                    this.atk = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.arM < 0) {
                        getSerializedSize();
                    }
                    return this.arM;
                }

                public String getFloor() {
                    return this.ati;
                }

                public String getName() {
                    return this.arE;
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
                    this.arM = size;
                    return size;
                }

                public String getUid() {
                    return this.arK;
                }

                public boolean hasName() {
                    return this.arD;
                }

                public boolean vC() {
                    return this.arJ;
                }

                public String wN() {
                    return this.atb;
                }

                public boolean wO() {
                    return this.ata;
                }

                public List<Integer> wT() {
                    return this.atg;
                }

                public boolean wU() {
                    return this.ath;
                }

                public String wV() {
                    return this.atk;
                }

                public boolean wW() {
                    return this.atj;
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
                    return yS();
                }
                this.asK = true;
                this.avf = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.asM.isEmpty()) {
                        this.asM = new ArrayList();
                    }
                    this.asM.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return yT();
                }
                this.asA = true;
                this.asB = cVar;
                return this;
            }

            public e dn(int i) {
                this.avb = true;
                this.avc = i;
                return this;
            }

            public e ff(String str) {
                this.avd = true;
                this.ave = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getLabel() {
                return this.ave;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int computeInt32Size = yP() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, yO()) : 0;
                if (yQ()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, yR());
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
                this.arM = i;
                return i;
            }

            public boolean hasStart() {
                return this.asK;
            }

            public boolean wi() {
                return this.asA;
            }

            public c wj() {
                return this.asB;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yP()) {
                    codedOutputStreamMicro.writeInt32(1, yO());
                }
                if (yQ()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, yR());
                }
                for (a aVar : wy()) {
                    codedOutputStreamMicro.writeMessage(4, aVar);
                }
                if (wi()) {
                    codedOutputStreamMicro.writeMessage(5, wj());
                }
            }

            public List<a> wy() {
                return this.asM;
            }

            public int yO() {
                return this.avc;
            }

            public boolean yP() {
                return this.avb;
            }

            public boolean yQ() {
                return this.avd;
            }

            public a yR() {
                return this.avf;
            }

            public e yS() {
                this.asK = false;
                this.avf = null;
                return this;
            }

            public e yT() {
                this.asA = false;
                this.asB = null;
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
                            dn(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            ff(codedInputStreamMicro.readString());
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

        /* loaded from: classes26.dex */
        public static final class f extends MessageMicro {
            private boolean avg;
            private boolean avi;
            private String avh = "";
            private String avj = "";
            private int arM = -1;

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
                            fl(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fm(codedInputStreamMicro.readString());
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

            public f fl(String str) {
                this.avg = true;
                this.avh = str;
                return this;
            }

            public f fm(String str) {
                this.avi = true;
                this.avj = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getContent() {
                return this.avh;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = yU() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (yW()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, yV());
                }
                this.arM = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yU()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (yW()) {
                    codedOutputStreamMicro.writeString(2, yV());
                }
            }

            public boolean yU() {
                return this.avg;
            }

            public String yV() {
                return this.avj;
            }

            public boolean yW() {
                return this.avi;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return xc();
            }
            this.atn = true;
            this.ato = aVar;
            return this;
        }

        public b a(C0130b c0130b) {
            if (c0130b != null) {
                if (this.arZ.isEmpty()) {
                    this.arZ = new ArrayList();
                }
                this.arZ.add(c0130b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.atv.isEmpty()) {
                    this.atv = new ArrayList();
                }
                this.atv.add(cVar);
            }
            return this;
        }

        public b a(C0133d c0133d) {
            if (c0133d == null) {
                return xi();
            }
            this.atr = true;
            this.ats = c0133d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return xl();
            }
            this.att = true;
            this.atu = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return xf();
            }
            this.atp = true;
            this.atq = fVar;
            return this;
        }

        public C0130b cr(int i) {
            return this.arZ.get(i);
        }

        public b eO(String str) {
            this.atw = true;
            this.atx = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.arM < 0) {
                getSerializedSize();
            }
            return this.arM;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int i2 = 0;
            Iterator<C0130b> it = vL().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
            }
            if (xa()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, xb());
            }
            if (xd()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, xe());
            }
            if (xg()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, xh());
            }
            if (xj()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, xk());
            }
            for (c cVar : xm()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, cVar);
            }
            if (xo()) {
                i += CodedOutputStreamMicro.computeStringSize(7, xn());
            }
            this.arM = i;
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
                        C0130b c0130b = new C0130b();
                        codedInputStreamMicro.readMessage(c0130b);
                        a(c0130b);
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
                        C0133d c0133d = new C0133d();
                        codedInputStreamMicro.readMessage(c0133d);
                        a(c0133d);
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
                        eO(codedInputStreamMicro.readString());
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

        public List<C0130b> vL() {
            return this.arZ;
        }

        public int wZ() {
            return this.arZ.size();
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (C0130b c0130b : vL()) {
                codedOutputStreamMicro.writeMessage(1, c0130b);
            }
            if (xa()) {
                codedOutputStreamMicro.writeMessage(2, xb());
            }
            if (xd()) {
                codedOutputStreamMicro.writeMessage(3, xe());
            }
            if (xg()) {
                codedOutputStreamMicro.writeMessage(4, xh());
            }
            if (xj()) {
                codedOutputStreamMicro.writeMessage(5, xk());
            }
            for (c cVar : xm()) {
                codedOutputStreamMicro.writeMessage(6, cVar);
            }
            if (xo()) {
                codedOutputStreamMicro.writeString(7, xn());
            }
        }

        public boolean xa() {
            return this.atn;
        }

        public a xb() {
            return this.ato;
        }

        public b xc() {
            this.atn = false;
            this.ato = null;
            return this;
        }

        public boolean xd() {
            return this.atp;
        }

        public f xe() {
            return this.atq;
        }

        public b xf() {
            this.atp = false;
            this.atq = null;
            return this;
        }

        public boolean xg() {
            return this.atr;
        }

        public C0133d xh() {
            return this.ats;
        }

        public b xi() {
            this.atr = false;
            this.ats = null;
            return this;
        }

        public boolean xj() {
            return this.att;
        }

        public e xk() {
            return this.atu;
        }

        public b xl() {
            this.att = false;
            this.atu = null;
            return this;
        }

        public List<c> xm() {
            return this.atv;
        }

        public String xn() {
            return this.atx;
        }

        public boolean xo() {
            return this.atw;
        }
    }

    /* loaded from: classes26.dex */
    public static final class c extends MessageMicro {
        private boolean arV;
        private boolean arX;
        private boolean avm;
        private String avk = "";
        private String avl = "";
        private String avn = "";
        private List<a> avo = Collections.emptyList();
        private int arM = -1;

        /* loaded from: classes26.dex */
        public static final class a extends MessageMicro {
            private boolean avp;
            private boolean avr;
            private boolean avt;
            private boolean avv;
            private String avq = "";
            private String avs = "";
            private String avu = "";
            private String avw = "";
            private int arM = -1;

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
                            fq(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fr(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            fs(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            ft(codedInputStreamMicro.readString());
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

            public a fq(String str) {
                this.avp = true;
                this.avq = str;
                return this;
            }

            public a fr(String str) {
                this.avr = true;
                this.avs = str;
                return this;
            }

            public a fs(String str) {
                this.avt = true;
                this.avu = str;
                return this;
            }

            public a ft(String str) {
                this.avv = true;
                this.avw = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.arM < 0) {
                    getSerializedSize();
                }
                return this.arM;
            }

            public String getDesc() {
                return this.avw;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zb() ? 0 + CodedOutputStreamMicro.computeStringSize(1, za()) : 0;
                if (zd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, zc());
                }
                if (zf()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, ze());
                }
                if (zg()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.arM = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (zb()) {
                    codedOutputStreamMicro.writeString(1, za());
                }
                if (zd()) {
                    codedOutputStreamMicro.writeString(2, zc());
                }
                if (zf()) {
                    codedOutputStreamMicro.writeString(3, ze());
                }
                if (zg()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public String za() {
                return this.avq;
            }

            public boolean zb() {
                return this.avp;
            }

            public String zc() {
                return this.avs;
            }

            public boolean zd() {
                return this.avr;
            }

            public String ze() {
                return this.avu;
            }

            public boolean zf() {
                return this.avt;
            }

            public boolean zg() {
                return this.avv;
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
                        fn(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        fo(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fp(codedInputStreamMicro.readString());
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
                if (this.avo.isEmpty()) {
                    this.avo = new ArrayList();
                }
                this.avo.add(aVar);
            }
            return this;
        }

        public c fn(String str) {
            this.arV = true;
            this.avk = str;
            return this;
        }

        public c fo(String str) {
            this.arX = true;
            this.avl = str;
            return this;
        }

        public c fp(String str) {
            this.avm = true;
            this.avn = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.arM < 0) {
                getSerializedSize();
            }
            return this.arM;
        }

        public String getDistance() {
            return this.avk;
        }

        public String getDuration() {
            return this.avl;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = vK() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (yY()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, yX());
            }
            Iterator<a> it = yZ().iterator();
            while (true) {
                int i = computeStringSize;
                if (!it.hasNext()) {
                    this.arM = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.arX;
        }

        public boolean vK() {
            return this.arV;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vK()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (yY()) {
                codedOutputStreamMicro.writeString(3, yX());
            }
            for (a aVar : yZ()) {
                codedOutputStreamMicro.writeMessage(4, aVar);
            }
        }

        public String yX() {
            return this.avn;
        }

        public boolean yY() {
            return this.avm;
        }

        public List<a> yZ() {
            return this.avo;
        }
    }

    public d a(com.baidu.g.a.a aVar) {
        if (aVar == null) {
            return wp();
        }
        this.asD = true;
        this.asE = aVar;
        return this;
    }

    public d a(com.baidu.g.a.b bVar) {
        if (bVar != null) {
            if (this.asF.isEmpty()) {
                this.asF = new ArrayList();
            }
            this.asF.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return wm();
        }
        this.arN = true;
        this.asC = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.arP.isEmpty()) {
                this.arP = new ArrayList();
            }
            this.arP.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return wk();
        }
        this.asA = true;
        this.asB = cVar;
        return this;
    }

    public b ce(int i) {
        return this.arP.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.arM < 0) {
            getSerializedSize();
        }
        return this.arM;
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
        for (com.baidu.g.a.b bVar : wq()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, bVar);
        }
        this.arM = i;
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
                    com.baidu.g.a.a aVar2 = new com.baidu.g.a.a();
                    codedInputStreamMicro.readMessage(aVar2);
                    a(aVar2);
                    break;
                case 42:
                    com.baidu.g.a.b bVar2 = new com.baidu.g.a.b();
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
        return this.arN;
    }

    public List<b> vH() {
        return this.arP;
    }

    public int vI() {
        return this.arP.size();
    }

    public boolean wi() {
        return this.asA;
    }

    public c wj() {
        return this.asB;
    }

    public d wk() {
        this.asA = false;
        this.asB = null;
        return this;
    }

    public a wl() {
        return this.asC;
    }

    public d wm() {
        this.arN = false;
        this.asC = null;
        return this;
    }

    public boolean wn() {
        return this.asD;
    }

    public com.baidu.g.a.a wo() {
        return this.asE;
    }

    public d wp() {
        this.asD = false;
        this.asE = null;
        return this;
    }

    public List<com.baidu.g.a.b> wq() {
        return this.asF;
    }

    public int wr() {
        return this.asF.size();
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
        for (com.baidu.g.a.b bVar2 : wq()) {
            codedOutputStreamMicro.writeMessage(5, bVar2);
        }
    }
}
