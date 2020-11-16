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
/* loaded from: classes7.dex */
public final class d extends MessageMicro {
    private boolean aqP;
    private boolean arB;
    private boolean arE;
    private c arC = null;
    private List<b> aqR = Collections.emptyList();
    private a arD = null;
    private com.baidu.g.a.a arF = null;
    private List<com.baidu.g.a.b> arG = Collections.emptyList();
    private int aqO = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqU;
        private boolean arH;
        private boolean arJ;
        private boolean arL;
        private boolean arO;
        private boolean arQ;
        private boolean arT;
        private boolean arV;
        private boolean arX;
        private boolean arZ;
        private int aqV = 0;
        private String arI = "";
        private int arK = 0;
        private c arM = null;
        private List<C0127a> arN = Collections.emptyList();
        private int arP = 0;
        private C0128d arR = null;
        private List<b> arS = Collections.emptyList();
        private int arU = 0;
        private String arW = "";
        private int arY = 0;
        private String asa = "";
        private int aqO = -1;

        /* renamed from: com.baidu.g.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0127a extends MessageMicro {
            private boolean aqL;
            private boolean asb;
            private boolean asd;
            private boolean asf;
            private boolean asi;
            private boolean ask;
            private String asc = "";
            private String ase = "";
            private String aqM = "";
            private boolean asg = false;
            private List<Integer> ash = Collections.emptyList();
            private String asj = "";
            private String asl = "";
            private int aqO = -1;

            public C0127a aW(boolean z) {
                this.asf = true;
                this.asg = z;
                return this;
            }

            public int ci(int i) {
                return this.ash.get(i).intValue();
            }

            public C0127a cj(int i) {
                if (this.ash.isEmpty()) {
                    this.ash = new ArrayList();
                }
                this.ash.add(Integer.valueOf(i));
                return this;
            }

            public C0127a eA(String str) {
                this.aqL = true;
                this.aqM = str;
                return this;
            }

            public C0127a eB(String str) {
                this.asi = true;
                this.asj = str;
                return this;
            }

            public C0127a eC(String str) {
                this.ask = true;
                this.asl = str;
                return this;
            }

            public C0127a ey(String str) {
                this.asb = true;
                this.asc = str;
                return this;
            }

            public C0127a ez(String str) {
                this.asd = true;
                this.ase = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getFloor() {
                return this.asj;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wW() ? CodedOutputStreamMicro.computeStringSize(1, wV()) + 0 : 0;
                if (wY()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wX());
                }
                if (vK()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = xa() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wZ()) : computeStringSize;
                for (Integer num : xb()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (xb().size() * 1);
                if (xc()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (xe()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, xd());
                }
                this.aqO = size;
                return size;
            }

            public String getUid() {
                return this.aqM;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: l */
            public C0127a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ey(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            ez(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eA(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aW(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cj(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            eB(codedInputStreamMicro.readString());
                            break;
                        case 58:
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

            public boolean vK() {
                return this.aqL;
            }

            public String wV() {
                return this.asc;
            }

            public boolean wW() {
                return this.asb;
            }

            public String wX() {
                return this.ase;
            }

            public boolean wY() {
                return this.asd;
            }

            public boolean wZ() {
                return this.asg;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wW()) {
                    codedOutputStreamMicro.writeString(1, wV());
                }
                if (wY()) {
                    codedOutputStreamMicro.writeString(2, wX());
                }
                if (vK()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (xa()) {
                    codedOutputStreamMicro.writeBool(4, wZ());
                }
                for (Integer num : xb()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (xc()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (xe()) {
                    codedOutputStreamMicro.writeString(7, xd());
                }
            }

            public boolean xa() {
                return this.asf;
            }

            public List<Integer> xb() {
                return this.ash;
            }

            public boolean xc() {
                return this.asi;
            }

            public String xd() {
                return this.asl;
            }

            public boolean xe() {
                return this.ask;
            }
        }

        /* loaded from: classes7.dex */
        public static final class b extends MessageMicro {
            private boolean aqA;
            private boolean asn;
            private int aqB = 0;
            private String aso = "";
            private int aqO = -1;

            public b ck(int i) {
                this.aqA = true;
                this.aqB = i;
                return this;
            }

            public b eD(String str) {
                this.asn = true;
                this.aso = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getCname() {
                return this.aso;
            }

            public int getCode() {
                return this.aqB;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vD() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (xf()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.aqO = computeInt32Size;
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
                            ck(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
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

            public boolean vD() {
                return this.aqA;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vD()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (xf()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }

            public boolean xf() {
                return this.asn;
            }
        }

        /* loaded from: classes7.dex */
        public static final class c extends MessageMicro {
            private boolean aqL;
            private boolean asb;
            private boolean asd;
            private boolean asf;
            private boolean asi;
            private boolean ask;
            private String asc = "";
            private String ase = "";
            private String aqM = "";
            private boolean asg = false;
            private List<Integer> ash = Collections.emptyList();
            private String asj = "";
            private String asl = "";
            private int aqO = -1;

            public c aX(boolean z) {
                this.asf = true;
                this.asg = z;
                return this;
            }

            public int ci(int i) {
                return this.ash.get(i).intValue();
            }

            public c cl(int i) {
                if (this.ash.isEmpty()) {
                    this.ash = new ArrayList();
                }
                this.ash.add(Integer.valueOf(i));
                return this;
            }

            public c eE(String str) {
                this.asb = true;
                this.asc = str;
                return this;
            }

            public c eF(String str) {
                this.asd = true;
                this.ase = str;
                return this;
            }

            public c eG(String str) {
                this.aqL = true;
                this.aqM = str;
                return this;
            }

            public c eH(String str) {
                this.asi = true;
                this.asj = str;
                return this;
            }

            public c eI(String str) {
                this.ask = true;
                this.asl = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getFloor() {
                return this.asj;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wW() ? CodedOutputStreamMicro.computeStringSize(1, wV()) + 0 : 0;
                if (wY()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wX());
                }
                if (vK()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = xa() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wZ()) : computeStringSize;
                for (Integer num : xb()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (xb().size() * 1);
                if (xc()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (xe()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, xd());
                }
                this.aqO = size;
                return size;
            }

            public String getUid() {
                return this.aqM;
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
                            eE(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eF(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eG(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aX(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cl(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            eH(codedInputStreamMicro.readString());
                            break;
                        case 58:
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

            public boolean vK() {
                return this.aqL;
            }

            public String wV() {
                return this.asc;
            }

            public boolean wW() {
                return this.asb;
            }

            public String wX() {
                return this.ase;
            }

            public boolean wY() {
                return this.asd;
            }

            public boolean wZ() {
                return this.asg;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wW()) {
                    codedOutputStreamMicro.writeString(1, wV());
                }
                if (wY()) {
                    codedOutputStreamMicro.writeString(2, wX());
                }
                if (vK()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (xa()) {
                    codedOutputStreamMicro.writeBool(4, wZ());
                }
                for (Integer num : xb()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (xc()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (xe()) {
                    codedOutputStreamMicro.writeString(7, xd());
                }
            }

            public boolean xa() {
                return this.asf;
            }

            public List<Integer> xb() {
                return this.ash;
            }

            public boolean xc() {
                return this.asi;
            }

            public String xd() {
                return this.asl;
            }

            public boolean xe() {
                return this.ask;
            }

            public int xg() {
                return this.ash.size();
            }
        }

        /* renamed from: com.baidu.g.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0128d extends MessageMicro {
            private boolean aqA;
            private boolean asn;
            private int aqB = 0;
            private String aso = "";
            private int aqO = -1;

            public C0128d cm(int i) {
                this.aqA = true;
                this.aqB = i;
                return this;
            }

            public C0128d eJ(String str) {
                this.asn = true;
                this.aso = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getCname() {
                return this.aso;
            }

            public int getCode() {
                return this.aqB;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vD() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (xf()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.aqO = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: o */
            public C0128d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cm(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            eJ(codedInputStreamMicro.readString());
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

            public boolean vD() {
                return this.aqA;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vD()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (xf()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }

            public boolean xf() {
                return this.asn;
            }
        }

        public a a(C0127a c0127a) {
            if (c0127a != null) {
                if (this.arN.isEmpty()) {
                    this.arN = new ArrayList();
                }
                this.arN.add(c0127a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.arS.isEmpty()) {
                    this.arS = new ArrayList();
                }
                this.arS.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wF();
            }
            this.arL = true;
            this.arM = cVar;
            return this;
        }

        public a a(C0128d c0128d) {
            if (c0128d == null) {
                return wL();
            }
            this.arQ = true;
            this.arR = c0128d;
            return this;
        }

        public a cb(int i) {
            this.aqU = true;
            this.aqV = i;
            return this;
        }

        public a cc(int i) {
            this.arJ = true;
            this.arK = i;
            return this;
        }

        public C0127a cd(int i) {
            return this.arN.get(i);
        }

        public a ce(int i) {
            this.arO = true;
            this.arP = i;
            return this;
        }

        public b cf(int i) {
            return this.arS.get(i);
        }

        public a cg(int i) {
            this.arT = true;
            this.arU = i;
            return this;
        }

        public a ch(int i) {
            this.arX = true;
            this.arY = i;
            return this;
        }

        public a eu(String str) {
            this.arH = true;
            this.arI = str;
            return this;
        }

        public a ev(String str) {
            this.arV = true;
            this.arW = str;
            return this;
        }

        public a ew(String str) {
            this.arZ = true;
            this.asa = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqO < 0) {
                getSerializedSize();
            }
            return this.aqO;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int computeInt32Size = vR() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (wB()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wA());
            }
            if (wD()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, wC());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, wE());
            }
            Iterator<C0127a> it = wG().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
            }
            if (wI()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, wH());
            }
            if (wJ()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, wK());
            }
            for (b bVar : wM()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, bVar);
            }
            if (wO()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, wN());
            }
            if (wQ()) {
                i += CodedOutputStreamMicro.computeStringSize(10, wP());
            }
            if (wS()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, wR());
            }
            if (wU()) {
                i += CodedOutputStreamMicro.computeStringSize(12, wT());
            }
            this.aqO = i;
            return i;
        }

        public int getTotal() {
            return this.aqV;
        }

        public boolean hasStart() {
            return this.arL;
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
                        cb(codedInputStreamMicro.readInt32());
                        break;
                    case 18:
                        eu(codedInputStreamMicro.readString());
                        break;
                    case 24:
                        cc(codedInputStreamMicro.readInt32());
                        break;
                    case 34:
                        c cVar = new c();
                        codedInputStreamMicro.readMessage(cVar);
                        a(cVar);
                        break;
                    case 42:
                        C0127a c0127a = new C0127a();
                        codedInputStreamMicro.readMessage(c0127a);
                        a(c0127a);
                        break;
                    case 48:
                        ce(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        C0128d c0128d = new C0128d();
                        codedInputStreamMicro.readMessage(c0128d);
                        a(c0128d);
                        break;
                    case 66:
                        b bVar = new b();
                        codedInputStreamMicro.readMessage(bVar);
                        a(bVar);
                        break;
                    case 72:
                        cg(codedInputStreamMicro.readInt32());
                        break;
                    case 82:
                        ev(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        ch(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
                        ew(codedInputStreamMicro.readString());
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

        public boolean vR() {
            return this.aqU;
        }

        public String wA() {
            return this.arI;
        }

        public boolean wB() {
            return this.arH;
        }

        public int wC() {
            return this.arK;
        }

        public boolean wD() {
            return this.arJ;
        }

        public c wE() {
            return this.arM;
        }

        public a wF() {
            this.arL = false;
            this.arM = null;
            return this;
        }

        public List<C0127a> wG() {
            return this.arN;
        }

        public int wH() {
            return this.arP;
        }

        public boolean wI() {
            return this.arO;
        }

        public boolean wJ() {
            return this.arQ;
        }

        public C0128d wK() {
            return this.arR;
        }

        public a wL() {
            this.arQ = false;
            this.arR = null;
            return this;
        }

        public List<b> wM() {
            return this.arS;
        }

        public int wN() {
            return this.arU;
        }

        public boolean wO() {
            return this.arT;
        }

        public String wP() {
            return this.arW;
        }

        public boolean wQ() {
            return this.arV;
        }

        public int wR() {
            return this.arY;
        }

        public boolean wS() {
            return this.arX;
        }

        public String wT() {
            return this.asa;
        }

        public boolean wU() {
            return this.arZ;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vR()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (wB()) {
                codedOutputStreamMicro.writeString(2, wA());
            }
            if (wD()) {
                codedOutputStreamMicro.writeInt32(3, wC());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, wE());
            }
            for (C0127a c0127a : wG()) {
                codedOutputStreamMicro.writeMessage(5, c0127a);
            }
            if (wI()) {
                codedOutputStreamMicro.writeInt32(6, wH());
            }
            if (wJ()) {
                codedOutputStreamMicro.writeMessage(7, wK());
            }
            for (b bVar : wM()) {
                codedOutputStreamMicro.writeMessage(8, bVar);
            }
            if (wO()) {
                codedOutputStreamMicro.writeInt32(9, wN());
            }
            if (wQ()) {
                codedOutputStreamMicro.writeString(10, wP());
            }
            if (wS()) {
                codedOutputStreamMicro.writeInt32(11, wR());
            }
            if (wU()) {
                codedOutputStreamMicro.writeString(12, wT());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends MessageMicro {
        private boolean asp;
        private boolean asr;
        private boolean ast;
        private boolean asv;
        private boolean asy;
        private List<C0129b> arb = Collections.emptyList();
        private a asq = null;
        private f ass = null;
        private C0132d asu = null;
        private e asw = null;
        private List<c> asx = Collections.emptyList();
        private String asz = "";
        private int aqO = -1;

        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean asA;
            private boolean asC;
            private boolean asE;
            private int asB = 0;
            private int asD = 0;
            private int asF = 0;
            private int aqO = -1;

            public a co(int i) {
                this.asA = true;
                this.asB = i;
                return this;
            }

            public a cp(int i) {
                this.asC = true;
                this.asD = i;
                return this;
            }

            public a cq(int i) {
                this.asE = true;
                this.asF = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = xy() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xx()) : 0;
                if (xA()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xz());
                }
                if (xC()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, xB());
                }
                this.aqO = computeInt32Size;
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
                            co(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            cp(codedInputStreamMicro.readInt32());
                            break;
                        case 24:
                            cq(codedInputStreamMicro.readInt32());
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
                if (xy()) {
                    codedOutputStreamMicro.writeInt32(1, xx());
                }
                if (xA()) {
                    codedOutputStreamMicro.writeInt32(2, xz());
                }
                if (xC()) {
                    codedOutputStreamMicro.writeInt32(3, xB());
                }
            }

            public boolean xA() {
                return this.asC;
            }

            public int xB() {
                return this.asF;
            }

            public boolean xC() {
                return this.asE;
            }

            public int xx() {
                return this.asB;
            }

            public boolean xy() {
                return this.asA;
            }

            public int xz() {
                return this.asD;
            }
        }

        /* renamed from: com.baidu.g.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0129b extends MessageMicro {
            private boolean aqX;
            private boolean aqZ;
            private boolean asG;
            private boolean asI;
            private boolean asK;
            private boolean asM;
            private boolean asO;
            private boolean asR;
            private List<c> arg = Collections.emptyList();
            private List<Integer> are = Collections.emptyList();
            private List<Integer> arf = Collections.emptyList();
            private String asH = "";
            private String asJ = "";
            private int aqY = 0;
            private int ara = 0;
            private int asL = 0;
            private int asN = 0;
            private int asP = 0;
            private List<a> asQ = Collections.emptyList();
            private C0130b asS = null;
            private int aqO = -1;

            /* renamed from: com.baidu.g.a.d$b$b$a */
            /* loaded from: classes7.dex */
            public static final class a extends MessageMicro {
                private boolean aqW;
                private boolean asT;
                private boolean asV;
                private boolean asi;
                private boolean ask;
                private int type_ = 0;
                private int asU = 0;
                private String asW = "";
                private List<Integer> arp = Collections.emptyList();
                private String asj = "";
                private String asl = "";
                private int aqO = -1;

                public a cA(int i) {
                    this.asT = true;
                    this.asU = i;
                    return this;
                }

                public a cB(int i) {
                    if (this.arp.isEmpty()) {
                        this.arp = new ArrayList();
                    }
                    this.arp.add(Integer.valueOf(i));
                    return this;
                }

                public a cz(int i) {
                    this.aqW = true;
                    this.type_ = i;
                    return this;
                }

                public a eN(String str) {
                    this.asV = true;
                    this.asW = str;
                    return this;
                }

                public a eO(String str) {
                    this.asi = true;
                    this.asj = str;
                    return this;
                }

                public a eP(String str) {
                    this.ask = true;
                    this.asl = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqO < 0) {
                        getSerializedSize();
                    }
                    return this.aqO;
                }

                public String getFloor() {
                    return this.asj;
                }

                public String getInfo() {
                    return this.asW;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (xT()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xS());
                    }
                    int computeStringSize = xU() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
                    for (Integer num : wg()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize + i + (wg().size() * 1);
                    if (xc()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (xe()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, xd());
                    }
                    this.aqO = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.aqW;
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
                                cz(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cA(codedInputStreamMicro.readInt32());
                                break;
                            case 26:
                                eN(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cB(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eO(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eP(codedInputStreamMicro.readString());
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

                public List<Integer> wg() {
                    return this.arp;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (xT()) {
                        codedOutputStreamMicro.writeInt32(2, xS());
                    }
                    if (xU()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    for (Integer num : wg()) {
                        codedOutputStreamMicro.writeInt32(4, num.intValue());
                    }
                    if (xc()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (xe()) {
                        codedOutputStreamMicro.writeString(6, xd());
                    }
                }

                public int xS() {
                    return this.asU;
                }

                public boolean xT() {
                    return this.asT;
                }

                public boolean xU() {
                    return this.asV;
                }

                public boolean xc() {
                    return this.asi;
                }

                public String xd() {
                    return this.asl;
                }

                public boolean xe() {
                    return this.ask;
                }
            }

            /* renamed from: com.baidu.g.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public static final class C0130b extends MessageMicro {
                private boolean asX;
                private boolean hasNext;
                private int asY = 0;
                private int asZ = 0;
                private int aqO = -1;

                public C0130b cC(int i) {
                    this.asX = true;
                    this.asY = i;
                    return this;
                }

                public C0130b cD(int i) {
                    this.hasNext = true;
                    this.asZ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqO < 0) {
                        getSerializedSize();
                    }
                    return this.aqO;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xW() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xV()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xX());
                    }
                    this.aqO = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: t */
                public C0130b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                cC(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cD(codedInputStreamMicro.readInt32());
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
                    if (xW()) {
                        codedOutputStreamMicro.writeInt32(1, xV());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, xX());
                    }
                }

                public int xV() {
                    return this.asY;
                }

                public boolean xW() {
                    return this.asX;
                }

                public int xX() {
                    return this.asZ;
                }
            }

            /* renamed from: com.baidu.g.a.d$b$b$c */
            /* loaded from: classes7.dex */
            public static final class c extends MessageMicro {
                private boolean aqF;
                private boolean aqW;
                private boolean aqX;
                private boolean aqZ;
                private boolean arh;
                private boolean atb;
                private boolean atd;
                private boolean atf;
                private boolean ath;
                private boolean atj;
                private boolean atl;
                private boolean atn;
                private boolean atp;
                private boolean ats;
                private boolean atv;
                private List<a> ata = Collections.emptyList();
                private List<C0131b> arm = Collections.emptyList();
                private List<Integer> arl = Collections.emptyList();
                private String ari = "";
                private int type_ = 0;
                private String aqG = "";
                private int atc = 0;
                private int ate = 0;
                private int atg = 0;
                private int ati = 0;
                private int atk = 0;
                private int atm = 0;
                private int aqY = 0;
                private int ara = 0;
                private int ato = 0;
                private int atq = 0;
                private List<Integer> are = Collections.emptyList();
                private List<Integer> arf = Collections.emptyList();
                private List<Integer> atr = Collections.emptyList();
                private int att = 0;
                private List<Integer> atu = Collections.emptyList();
                private int atw = 0;
                private List<C0131b> atx = Collections.emptyList();
                private int aqO = -1;

                /* renamed from: com.baidu.g.a.d$b$b$c$a */
                /* loaded from: classes7.dex */
                public static final class a extends MessageMicro {
                    private boolean arz;
                    private boolean atA;
                    private boolean atC;
                    private boolean atE;
                    private boolean atp;
                    private boolean aty;
                    private String atz = "";
                    private int atB = 0;
                    private int arA = 0;
                    private int atq = 0;
                    private int atD = 0;
                    private int atF = 0;
                    private int aqO = -1;

                    public a cW(int i) {
                        this.atA = true;
                        this.atB = i;
                        return this;
                    }

                    public a cX(int i) {
                        this.arz = true;
                        this.arA = i;
                        return this;
                    }

                    public a cY(int i) {
                        this.atp = true;
                        this.atq = i;
                        return this;
                    }

                    public a cZ(int i) {
                        this.atC = true;
                        this.atD = i;
                        return this;
                    }

                    public a da(int i) {
                        this.atE = true;
                        this.atF = i;
                        return this;
                    }

                    public a eS(String str) {
                        this.aty = true;
                        this.atz = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqO < 0) {
                            getSerializedSize();
                        }
                        return this.aqO;
                    }

                    public String getId() {
                        return this.atz;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (yw()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, yv());
                        }
                        if (wp()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, wo());
                        }
                        if (yn()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, ym());
                        }
                        if (yy()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, yx());
                        }
                        if (yA()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, yz());
                        }
                        this.aqO = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.aty;
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
                                    eS(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    cW(codedInputStreamMicro.readInt32());
                                    break;
                                case 24:
                                    cX(codedInputStreamMicro.readInt32());
                                    break;
                                case 32:
                                    cY(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    cZ(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    da(codedInputStreamMicro.readInt32());
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

                    public int wo() {
                        return this.arA;
                    }

                    public boolean wp() {
                        return this.arz;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (yw()) {
                            codedOutputStreamMicro.writeInt32(2, yv());
                        }
                        if (wp()) {
                            codedOutputStreamMicro.writeInt32(3, wo());
                        }
                        if (yn()) {
                            codedOutputStreamMicro.writeInt32(4, ym());
                        }
                        if (yy()) {
                            codedOutputStreamMicro.writeInt32(5, yx());
                        }
                        if (yA()) {
                            codedOutputStreamMicro.writeInt32(6, yz());
                        }
                    }

                    public boolean yA() {
                        return this.atE;
                    }

                    public int ym() {
                        return this.atq;
                    }

                    public boolean yn() {
                        return this.atp;
                    }

                    public int yv() {
                        return this.atB;
                    }

                    public boolean yw() {
                        return this.atA;
                    }

                    public int yx() {
                        return this.atD;
                    }

                    public boolean yy() {
                        return this.atC;
                    }

                    public int yz() {
                        return this.atF;
                    }
                }

                /* renamed from: com.baidu.g.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C0131b extends MessageMicro {
                    private boolean aqF;
                    private boolean aqL;
                    private boolean asK;
                    private boolean atH;
                    private boolean atJ;
                    private boolean atL;
                    private boolean atO;
                    private boolean atQ;
                    private boolean atS;
                    private boolean atU;
                    private boolean atW;
                    private String aqG = "";
                    private List<Integer> atG = Collections.emptyList();
                    private int asL = 0;
                    private String atI = "";
                    private String atK = "";
                    private String atM = "";
                    private String aqM = "";
                    private List<Integer> atN = Collections.emptyList();
                    private String atP = "";
                    private String atR = "";
                    private String atT = "";
                    private int atV = 0;
                    private int atX = 0;
                    private int aqO = -1;

                    public C0131b db(int i) {
                        if (this.atG.isEmpty()) {
                            this.atG = new ArrayList();
                        }
                        this.atG.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0131b dc(int i) {
                        this.asK = true;
                        this.asL = i;
                        return this;
                    }

                    public C0131b dd(int i) {
                        if (this.atN.isEmpty()) {
                            this.atN = new ArrayList();
                        }
                        this.atN.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0131b de(int i) {
                        this.atU = true;
                        this.atV = i;
                        return this;
                    }

                    public C0131b df(int i) {
                        this.atW = true;
                        this.atX = i;
                        return this;
                    }

                    public C0131b eT(String str) {
                        this.aqF = true;
                        this.aqG = str;
                        return this;
                    }

                    public C0131b eU(String str) {
                        this.atH = true;
                        this.atI = str;
                        return this;
                    }

                    public C0131b eV(String str) {
                        this.atJ = true;
                        this.atK = str;
                        return this;
                    }

                    public C0131b eW(String str) {
                        this.atL = true;
                        this.atM = str;
                        return this;
                    }

                    public C0131b eX(String str) {
                        this.aqL = true;
                        this.aqM = str;
                        return this;
                    }

                    public C0131b eY(String str) {
                        this.atO = true;
                        this.atP = str;
                        return this;
                    }

                    public C0131b eZ(String str) {
                        this.atQ = true;
                        this.atR = str;
                        return this;
                    }

                    public C0131b fa(String str) {
                        this.atS = true;
                        this.atT = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqO < 0) {
                            getSerializedSize();
                        }
                        return this.aqO;
                    }

                    public String getIconUrl() {
                        return this.atP;
                    }

                    public String getName() {
                        return this.aqG;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        int i2 = 0;
                        for (Integer num : yB()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i2;
                        }
                        int size = computeStringSize + i2 + (yB().size() * 1);
                        if (xJ()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, xI());
                        }
                        if (yD()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, yC());
                        }
                        if (yF()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, yE());
                        }
                        if (yH()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, yG());
                        }
                        int computeStringSize2 = vK() ? size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : size;
                        for (Integer num2 : yI()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                        }
                        int size2 = computeStringSize2 + i + (yI().size() * 1);
                        if (yJ()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (yL()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, yK());
                        }
                        if (yN()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, yM());
                        }
                        if (yP()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, yO());
                        }
                        if (yR()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, yQ());
                        }
                        this.aqO = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.aqM;
                    }

                    public boolean hasName() {
                        return this.aqF;
                    }

                    public boolean vK() {
                        return this.aqL;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: w */
                    public C0131b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eT(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    db(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    dc(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eU(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eV(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    eW(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    eX(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    dd(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    eY(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    eZ(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    fa(codedInputStreamMicro.readString());
                                    break;
                                case 96:
                                    de(codedInputStreamMicro.readInt32());
                                    break;
                                case 104:
                                    df(codedInputStreamMicro.readInt32());
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
                        for (Integer num : yB()) {
                            codedOutputStreamMicro.writeSInt32(2, num.intValue());
                        }
                        if (xJ()) {
                            codedOutputStreamMicro.writeInt32(3, xI());
                        }
                        if (yD()) {
                            codedOutputStreamMicro.writeString(4, yC());
                        }
                        if (yF()) {
                            codedOutputStreamMicro.writeString(5, yE());
                        }
                        if (yH()) {
                            codedOutputStreamMicro.writeString(6, yG());
                        }
                        if (vK()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        for (Integer num2 : yI()) {
                            codedOutputStreamMicro.writeSInt32(8, num2.intValue());
                        }
                        if (yJ()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (yL()) {
                            codedOutputStreamMicro.writeString(10, yK());
                        }
                        if (yN()) {
                            codedOutputStreamMicro.writeString(11, yM());
                        }
                        if (yP()) {
                            codedOutputStreamMicro.writeInt32(12, yO());
                        }
                        if (yR()) {
                            codedOutputStreamMicro.writeInt32(13, yQ());
                        }
                    }

                    public int xI() {
                        return this.asL;
                    }

                    public boolean xJ() {
                        return this.asK;
                    }

                    public List<Integer> yB() {
                        return this.atG;
                    }

                    public String yC() {
                        return this.atI;
                    }

                    public boolean yD() {
                        return this.atH;
                    }

                    public String yE() {
                        return this.atK;
                    }

                    public boolean yF() {
                        return this.atJ;
                    }

                    public String yG() {
                        return this.atM;
                    }

                    public boolean yH() {
                        return this.atL;
                    }

                    public List<Integer> yI() {
                        return this.atN;
                    }

                    public boolean yJ() {
                        return this.atO;
                    }

                    public String yK() {
                        return this.atR;
                    }

                    public boolean yL() {
                        return this.atQ;
                    }

                    public String yM() {
                        return this.atT;
                    }

                    public boolean yN() {
                        return this.atS;
                    }

                    public int yO() {
                        return this.atV;
                    }

                    public boolean yP() {
                        return this.atU;
                    }

                    public int yQ() {
                        return this.atX;
                    }

                    public boolean yR() {
                        return this.atW;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.ata.isEmpty()) {
                            this.ata = new ArrayList();
                        }
                        this.ata.add(aVar);
                    }
                    return this;
                }

                public c a(C0131b c0131b) {
                    if (c0131b != null) {
                        if (this.arm.isEmpty()) {
                            this.arm = new ArrayList();
                        }
                        this.arm.add(c0131b);
                    }
                    return this;
                }

                public c b(C0131b c0131b) {
                    if (c0131b != null) {
                        if (this.atx.isEmpty()) {
                            this.atx = new ArrayList();
                        }
                        this.atx.add(c0131b);
                    }
                    return this;
                }

                public c cE(int i) {
                    if (this.arl.isEmpty()) {
                        this.arl = new ArrayList();
                    }
                    this.arl.add(Integer.valueOf(i));
                    return this;
                }

                public c cF(int i) {
                    this.aqW = true;
                    this.type_ = i;
                    return this;
                }

                public c cG(int i) {
                    this.atb = true;
                    this.atc = i;
                    return this;
                }

                public c cH(int i) {
                    this.atd = true;
                    this.ate = i;
                    return this;
                }

                public c cI(int i) {
                    this.atf = true;
                    this.atg = i;
                    return this;
                }

                public c cJ(int i) {
                    this.ath = true;
                    this.ati = i;
                    return this;
                }

                public c cK(int i) {
                    this.atj = true;
                    this.atk = i;
                    return this;
                }

                public c cL(int i) {
                    this.atl = true;
                    this.atm = i;
                    return this;
                }

                public c cM(int i) {
                    this.aqX = true;
                    this.aqY = i;
                    return this;
                }

                public c cN(int i) {
                    this.aqZ = true;
                    this.ara = i;
                    return this;
                }

                public c cO(int i) {
                    this.atn = true;
                    this.ato = i;
                    return this;
                }

                public c cP(int i) {
                    this.atp = true;
                    this.atq = i;
                    return this;
                }

                public c cQ(int i) {
                    if (this.are.isEmpty()) {
                        this.are = new ArrayList();
                    }
                    this.are.add(Integer.valueOf(i));
                    return this;
                }

                public c cR(int i) {
                    if (this.arf.isEmpty()) {
                        this.arf = new ArrayList();
                    }
                    this.arf.add(Integer.valueOf(i));
                    return this;
                }

                public c cS(int i) {
                    if (this.atr.isEmpty()) {
                        this.atr = new ArrayList();
                    }
                    this.atr.add(Integer.valueOf(i));
                    return this;
                }

                public c cT(int i) {
                    this.ats = true;
                    this.att = i;
                    return this;
                }

                public c cU(int i) {
                    if (this.atu.isEmpty()) {
                        this.atu = new ArrayList();
                    }
                    this.atu.add(Integer.valueOf(i));
                    return this;
                }

                public c cV(int i) {
                    this.atv = true;
                    this.atw = i;
                    return this;
                }

                public c eQ(String str) {
                    this.arh = true;
                    this.ari = str;
                    return this;
                }

                public c eR(String str) {
                    this.aqF = true;
                    this.aqG = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqO < 0) {
                        getSerializedSize();
                    }
                    return this.aqO;
                }

                public int getDirection() {
                    return this.ato;
                }

                public int getDistance() {
                    return this.aqY;
                }

                public int getDuration() {
                    return this.ara;
                }

                public String getInstructions() {
                    return this.ari;
                }

                public String getName() {
                    return this.aqG;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int i2 = 0;
                    int i3 = 0;
                    for (Integer num : wc()) {
                        i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                    }
                    int size = 0 + i3 + (wc().size() * 1);
                    if (vZ()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (ya()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, xZ());
                    }
                    if (yc()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, yb());
                    }
                    if (ye()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, yd());
                    }
                    if (yg()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, yf());
                    }
                    if (yi()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, yh());
                    }
                    if (yk()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, yj());
                    }
                    if (vS()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<a> it = xY().iterator();
                    while (true) {
                        i = size;
                        if (!it.hasNext()) {
                            break;
                        }
                        size = CodedOutputStreamMicro.computeMessageSize(13, it.next()) + i;
                    }
                    for (C0131b c0131b : wd()) {
                        i += CodedOutputStreamMicro.computeMessageSize(14, c0131b);
                    }
                    if (yl()) {
                        i += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (yn()) {
                        i += CodedOutputStreamMicro.computeInt32Size(16, ym());
                    }
                    int i4 = 0;
                    for (Integer num2 : vW()) {
                        i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue()) + i4;
                    }
                    int size2 = i + i4 + (vW().size() * 2);
                    int i5 = 0;
                    for (Integer num3 : vX()) {
                        i5 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num3.intValue()) + i5;
                    }
                    int size3 = size2 + i5 + (vX().size() * 2);
                    int i6 = 0;
                    for (Integer num4 : yo()) {
                        i6 = CodedOutputStreamMicro.computeInt32SizeNoTag(num4.intValue()) + i6;
                    }
                    int size4 = size3 + i6 + (yo().size() * 2);
                    int computeInt32Size = yq() ? size4 + CodedOutputStreamMicro.computeInt32Size(20, yp()) : size4;
                    for (Integer num5 : yr()) {
                        i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num5.intValue());
                    }
                    int size5 = computeInt32Size + i2 + (yr().size() * 2);
                    if (yt()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, ys());
                    }
                    Iterator<C0131b> it2 = yu().iterator();
                    while (true) {
                        int i7 = size5;
                        if (!it2.hasNext()) {
                            this.aqO = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqZ;
                }

                public boolean hasName() {
                    return this.aqF;
                }

                public boolean hasType() {
                    return this.aqW;
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
                                cE(codedInputStreamMicro.readSInt32());
                                break;
                            case 18:
                                eQ(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cF(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eR(codedInputStreamMicro.readString());
                                break;
                            case 40:
                                cG(codedInputStreamMicro.readInt32());
                                break;
                            case 48:
                                cH(codedInputStreamMicro.readInt32());
                                break;
                            case 56:
                                cI(codedInputStreamMicro.readInt32());
                                break;
                            case 64:
                                cJ(codedInputStreamMicro.readInt32());
                                break;
                            case 72:
                                cK(codedInputStreamMicro.readInt32());
                                break;
                            case 80:
                                cL(codedInputStreamMicro.readInt32());
                                break;
                            case 88:
                                cM(codedInputStreamMicro.readInt32());
                                break;
                            case 96:
                                cN(codedInputStreamMicro.readInt32());
                                break;
                            case 106:
                                a aVar = new a();
                                codedInputStreamMicro.readMessage(aVar);
                                a(aVar);
                                break;
                            case 114:
                                C0131b c0131b = new C0131b();
                                codedInputStreamMicro.readMessage(c0131b);
                                a(c0131b);
                                break;
                            case 120:
                                cO(codedInputStreamMicro.readInt32());
                                break;
                            case 128:
                                cP(codedInputStreamMicro.readInt32());
                                break;
                            case 136:
                                cQ(codedInputStreamMicro.readSInt32());
                                break;
                            case 144:
                                cR(codedInputStreamMicro.readSInt32());
                                break;
                            case 152:
                                cS(codedInputStreamMicro.readInt32());
                                break;
                            case 160:
                                cT(codedInputStreamMicro.readInt32());
                                break;
                            case 168:
                                cU(codedInputStreamMicro.readSInt32());
                                break;
                            case Opcodes.ARETURN /* 176 */:
                                cV(codedInputStreamMicro.readInt32());
                                break;
                            case 186:
                                C0131b c0131b2 = new C0131b();
                                codedInputStreamMicro.readMessage(c0131b2);
                                b(c0131b2);
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

                public boolean vS() {
                    return this.aqX;
                }

                public List<Integer> vW() {
                    return this.are;
                }

                public List<Integer> vX() {
                    return this.arf;
                }

                public boolean vZ() {
                    return this.arh;
                }

                public List<Integer> wc() {
                    return this.arl;
                }

                public List<C0131b> wd() {
                    return this.arm;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer num : wc()) {
                        codedOutputStreamMicro.writeSInt32(1, num.intValue());
                    }
                    if (vZ()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (ya()) {
                        codedOutputStreamMicro.writeInt32(5, xZ());
                    }
                    if (yc()) {
                        codedOutputStreamMicro.writeInt32(6, yb());
                    }
                    if (ye()) {
                        codedOutputStreamMicro.writeInt32(7, yd());
                    }
                    if (yg()) {
                        codedOutputStreamMicro.writeInt32(8, yf());
                    }
                    if (yi()) {
                        codedOutputStreamMicro.writeInt32(9, yh());
                    }
                    if (yk()) {
                        codedOutputStreamMicro.writeInt32(10, yj());
                    }
                    if (vS()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (a aVar : xY()) {
                        codedOutputStreamMicro.writeMessage(13, aVar);
                    }
                    for (C0131b c0131b : wd()) {
                        codedOutputStreamMicro.writeMessage(14, c0131b);
                    }
                    if (yl()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (yn()) {
                        codedOutputStreamMicro.writeInt32(16, ym());
                    }
                    for (Integer num2 : vW()) {
                        codedOutputStreamMicro.writeSInt32(17, num2.intValue());
                    }
                    for (Integer num3 : vX()) {
                        codedOutputStreamMicro.writeSInt32(18, num3.intValue());
                    }
                    for (Integer num4 : yo()) {
                        codedOutputStreamMicro.writeInt32(19, num4.intValue());
                    }
                    if (yq()) {
                        codedOutputStreamMicro.writeInt32(20, yp());
                    }
                    for (Integer num5 : yr()) {
                        codedOutputStreamMicro.writeSInt32(21, num5.intValue());
                    }
                    if (yt()) {
                        codedOutputStreamMicro.writeInt32(22, ys());
                    }
                    for (C0131b c0131b2 : yu()) {
                        codedOutputStreamMicro.writeMessage(23, c0131b2);
                    }
                }

                public List<a> xY() {
                    return this.ata;
                }

                public int xZ() {
                    return this.atc;
                }

                public boolean ya() {
                    return this.atb;
                }

                public int yb() {
                    return this.ate;
                }

                public boolean yc() {
                    return this.atd;
                }

                public int yd() {
                    return this.atg;
                }

                public boolean ye() {
                    return this.atf;
                }

                public int yf() {
                    return this.ati;
                }

                public boolean yg() {
                    return this.ath;
                }

                public int yh() {
                    return this.atk;
                }

                public boolean yi() {
                    return this.atj;
                }

                public int yj() {
                    return this.atm;
                }

                public boolean yk() {
                    return this.atl;
                }

                public boolean yl() {
                    return this.atn;
                }

                public int ym() {
                    return this.atq;
                }

                public boolean yn() {
                    return this.atp;
                }

                public List<Integer> yo() {
                    return this.atr;
                }

                public int yp() {
                    return this.att;
                }

                public boolean yq() {
                    return this.ats;
                }

                public List<Integer> yr() {
                    return this.atu;
                }

                public int ys() {
                    return this.atw;
                }

                public boolean yt() {
                    return this.atv;
                }

                public List<C0131b> yu() {
                    return this.atx;
                }
            }

            public C0129b a(a aVar) {
                if (aVar != null) {
                    if (this.asQ.isEmpty()) {
                        this.asQ = new ArrayList();
                    }
                    this.asQ.add(aVar);
                }
                return this;
            }

            public C0129b a(C0130b c0130b) {
                if (c0130b == null) {
                    return xR();
                }
                this.asR = true;
                this.asS = c0130b;
                return this;
            }

            public C0129b a(c cVar) {
                if (cVar != null) {
                    if (this.arg.isEmpty()) {
                        this.arg = new ArrayList();
                    }
                    this.arg.add(cVar);
                }
                return this;
            }

            public c cr(int i) {
                return this.arg.get(i);
            }

            public C0129b cs(int i) {
                if (this.are.isEmpty()) {
                    this.are = new ArrayList();
                }
                this.are.add(Integer.valueOf(i));
                return this;
            }

            public C0129b ct(int i) {
                if (this.arf.isEmpty()) {
                    this.arf = new ArrayList();
                }
                this.arf.add(Integer.valueOf(i));
                return this;
            }

            public C0129b cu(int i) {
                this.aqX = true;
                this.aqY = i;
                return this;
            }

            public C0129b cv(int i) {
                this.aqZ = true;
                this.ara = i;
                return this;
            }

            public C0129b cw(int i) {
                this.asK = true;
                this.asL = i;
                return this;
            }

            public C0129b cx(int i) {
                this.asM = true;
                this.asN = i;
                return this;
            }

            public C0129b cy(int i) {
                this.asO = true;
                this.asP = i;
                return this;
            }

            public C0129b eL(String str) {
                this.asG = true;
                this.asH = str;
                return this;
            }

            public C0129b eM(String str) {
                this.asI = true;
                this.asJ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public int getDistance() {
                return this.aqY;
            }

            public int getDuration() {
                return this.ara;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int i2 = 0;
                int i3 = 0;
                for (Integer num : vW()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                }
                int size = (vW().size() * 1) + 0 + i3;
                for (Integer num2 : vX()) {
                    i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                }
                int size2 = size + i2 + (vX().size() * 1);
                if (xF()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, xE());
                }
                if (xH()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, xG());
                }
                if (vS()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (xJ()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, xI());
                }
                if (xL()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, xK());
                }
                if (xN()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, xM());
                }
                Iterator<c> it = vY().iterator();
                while (true) {
                    i = size2;
                    if (!it.hasNext()) {
                        break;
                    }
                    size2 = CodedOutputStreamMicro.computeMessageSize(10, it.next()) + i;
                }
                for (a aVar : xO()) {
                    i += CodedOutputStreamMicro.computeMessageSize(11, aVar);
                }
                if (xP()) {
                    i += CodedOutputStreamMicro.computeMessageSize(12, xQ());
                }
                this.aqO = i;
                return i;
            }

            public boolean hasDuration() {
                return this.aqZ;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: r */
            public C0129b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cs(codedInputStreamMicro.readSInt32());
                            break;
                        case 16:
                            ct(codedInputStreamMicro.readSInt32());
                            break;
                        case 26:
                            eL(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eM(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            cu(codedInputStreamMicro.readInt32());
                            break;
                        case 48:
                            cv(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            cw(codedInputStreamMicro.readInt32());
                            break;
                        case 64:
                            cx(codedInputStreamMicro.readInt32());
                            break;
                        case 72:
                            cy(codedInputStreamMicro.readInt32());
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
                            C0130b c0130b = new C0130b();
                            codedInputStreamMicro.readMessage(c0130b);
                            a(c0130b);
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

            public boolean vS() {
                return this.aqX;
            }

            public List<Integer> vW() {
                return this.are;
            }

            public List<Integer> vX() {
                return this.arf;
            }

            public List<c> vY() {
                return this.arg;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer num : vW()) {
                    codedOutputStreamMicro.writeSInt32(1, num.intValue());
                }
                for (Integer num2 : vX()) {
                    codedOutputStreamMicro.writeSInt32(2, num2.intValue());
                }
                if (xF()) {
                    codedOutputStreamMicro.writeString(3, xE());
                }
                if (xH()) {
                    codedOutputStreamMicro.writeString(4, xG());
                }
                if (vS()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (xJ()) {
                    codedOutputStreamMicro.writeInt32(7, xI());
                }
                if (xL()) {
                    codedOutputStreamMicro.writeInt32(8, xK());
                }
                if (xN()) {
                    codedOutputStreamMicro.writeInt32(9, xM());
                }
                for (c cVar : vY()) {
                    codedOutputStreamMicro.writeMessage(10, cVar);
                }
                for (a aVar : xO()) {
                    codedOutputStreamMicro.writeMessage(11, aVar);
                }
                if (xP()) {
                    codedOutputStreamMicro.writeMessage(12, xQ());
                }
            }

            public int xD() {
                return this.arg.size();
            }

            public String xE() {
                return this.asH;
            }

            public boolean xF() {
                return this.asG;
            }

            public String xG() {
                return this.asJ;
            }

            public boolean xH() {
                return this.asI;
            }

            public int xI() {
                return this.asL;
            }

            public boolean xJ() {
                return this.asK;
            }

            public int xK() {
                return this.asN;
            }

            public boolean xL() {
                return this.asM;
            }

            public int xM() {
                return this.asP;
            }

            public boolean xN() {
                return this.asO;
            }

            public List<a> xO() {
                return this.asQ;
            }

            public boolean xP() {
                return this.asR;
            }

            public C0130b xQ() {
                return this.asS;
            }

            public C0129b xR() {
                this.asR = false;
                this.asS = null;
                return this;
            }
        }

        /* loaded from: classes7.dex */
        public static final class c extends MessageMicro {
            private boolean atY;
            private int atZ = 0;
            private List<Integer> aua = Collections.emptyList();
            private int aqO = -1;

            public c dg(int i) {
                this.atY = true;
                this.atZ = i;
                return this;
            }

            public c dh(int i) {
                if (this.aua.isEmpty()) {
                    this.aua = new ArrayList();
                }
                this.aua.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yT() ? CodedOutputStreamMicro.computeInt32Size(1, yS()) + 0 : 0;
                for (Integer num : yU()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yU().size() * 1);
                this.aqO = size;
                return size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yT()) {
                    codedOutputStreamMicro.writeInt32(1, yS());
                }
                for (Integer num : yU()) {
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
                            dg(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            dh(codedInputStreamMicro.readSInt32());
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

            public int yS() {
                return this.atZ;
            }

            public boolean yT() {
                return this.atY;
            }

            public List<Integer> yU() {
                return this.aua;
            }
        }

        /* renamed from: com.baidu.g.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0132d extends MessageMicro {
            private boolean aub;
            private int auc = 0;
            private int aqO = -1;

            public C0132d di(int i) {
                this.aub = true;
                this.auc = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public int getLightNum() {
                return this.auc;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yV() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.aqO = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yV()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: y */
            public C0132d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            di(codedInputStreamMicro.readInt32());
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

            public boolean yV() {
                return this.aub;
            }
        }

        /* loaded from: classes7.dex */
        public static final class e extends MessageMicro {
            private boolean arB;
            private boolean arL;
            private boolean aud;
            private boolean auf;
            private int aue = 0;
            private String aug = "";
            private a auh = null;
            private List<a> arN = Collections.emptyList();
            private c arC = null;
            private int aqO = -1;

            /* loaded from: classes7.dex */
            public static final class a extends MessageMicro {
                private boolean aqF;
                private boolean aqL;
                private boolean asb;
                private boolean asi;
                private boolean ask;
                private String asc = "";
                private String aqG = "";
                private String aqM = "";
                private List<Integer> ash = Collections.emptyList();
                private String asj = "";
                private String asl = "";
                private int aqO = -1;

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
                                fc(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                fd(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                fe(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                dk(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                ff(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                fg(codedInputStreamMicro.readString());
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

                public a dk(int i) {
                    if (this.ash.isEmpty()) {
                        this.ash = new ArrayList();
                    }
                    this.ash.add(Integer.valueOf(i));
                    return this;
                }

                public a fc(String str) {
                    this.asb = true;
                    this.asc = str;
                    return this;
                }

                public a fd(String str) {
                    this.aqF = true;
                    this.aqG = str;
                    return this;
                }

                public a fe(String str) {
                    this.aqL = true;
                    this.aqM = str;
                    return this;
                }

                public a ff(String str) {
                    this.asi = true;
                    this.asj = str;
                    return this;
                }

                public a fg(String str) {
                    this.ask = true;
                    this.asl = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqO < 0) {
                        getSerializedSize();
                    }
                    return this.aqO;
                }

                public String getFloor() {
                    return this.asj;
                }

                public String getName() {
                    return this.aqG;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeStringSize = wW() ? CodedOutputStreamMicro.computeStringSize(1, wV()) + 0 : 0;
                    if (hasName()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    int computeStringSize2 = vK() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                    for (Integer num : xb()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize2 + i + (xb().size() * 1);
                    if (xc()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (xe()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, xd());
                    }
                    this.aqO = size;
                    return size;
                }

                public String getUid() {
                    return this.aqM;
                }

                public boolean hasName() {
                    return this.aqF;
                }

                public boolean vK() {
                    return this.aqL;
                }

                public String wV() {
                    return this.asc;
                }

                public boolean wW() {
                    return this.asb;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (wW()) {
                        codedOutputStreamMicro.writeString(1, wV());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (vK()) {
                        codedOutputStreamMicro.writeString(3, getUid());
                    }
                    for (Integer num : xb()) {
                        codedOutputStreamMicro.writeSInt32(4, num.intValue());
                    }
                    if (xc()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (xe()) {
                        codedOutputStreamMicro.writeString(6, xd());
                    }
                }

                public List<Integer> xb() {
                    return this.ash;
                }

                public boolean xc() {
                    return this.asi;
                }

                public String xd() {
                    return this.asl;
                }

                public boolean xe() {
                    return this.ask;
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return za();
                }
                this.arL = true;
                this.auh = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.arN.isEmpty()) {
                        this.arN = new ArrayList();
                    }
                    this.arN.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return zb();
                }
                this.arB = true;
                this.arC = cVar;
                return this;
            }

            public e dj(int i) {
                this.aud = true;
                this.aue = i;
                return this;
            }

            public e fb(String str) {
                this.auf = true;
                this.aug = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getLabel() {
                return this.aug;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int computeInt32Size = yX() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, yW()) : 0;
                if (yY()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, yZ());
                }
                Iterator<a> it = wG().iterator();
                while (true) {
                    i = computeInt32Size;
                    if (!it.hasNext()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
                }
                if (wq()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, wr());
                }
                this.aqO = i;
                return i;
            }

            public boolean hasStart() {
                return this.arL;
            }

            public List<a> wG() {
                return this.arN;
            }

            public boolean wq() {
                return this.arB;
            }

            public c wr() {
                return this.arC;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yX()) {
                    codedOutputStreamMicro.writeInt32(1, yW());
                }
                if (yY()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, yZ());
                }
                for (a aVar : wG()) {
                    codedOutputStreamMicro.writeMessage(4, aVar);
                }
                if (wq()) {
                    codedOutputStreamMicro.writeMessage(5, wr());
                }
            }

            public int yW() {
                return this.aue;
            }

            public boolean yX() {
                return this.aud;
            }

            public boolean yY() {
                return this.auf;
            }

            public a yZ() {
                return this.auh;
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
                            dj(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            fb(codedInputStreamMicro.readString());
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

            public e za() {
                this.arL = false;
                this.auh = null;
                return this;
            }

            public e zb() {
                this.arB = false;
                this.arC = null;
                return this;
            }
        }

        /* loaded from: classes7.dex */
        public static final class f extends MessageMicro {
            private boolean aui;
            private boolean auk;
            private String auj = "";
            private String aul = "";
            private int aqO = -1;

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
                            fh(codedInputStreamMicro.readString());
                            break;
                        case 18:
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

            public f fh(String str) {
                this.aui = true;
                this.auj = str;
                return this;
            }

            public f fi(String str) {
                this.auk = true;
                this.aul = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getContent() {
                return this.auj;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zc() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (ze()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, zd());
                }
                this.aqO = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (zc()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (ze()) {
                    codedOutputStreamMicro.writeString(2, zd());
                }
            }

            public boolean zc() {
                return this.aui;
            }

            public String zd() {
                return this.aul;
            }

            public boolean ze() {
                return this.auk;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return xk();
            }
            this.asp = true;
            this.asq = aVar;
            return this;
        }

        public b a(C0129b c0129b) {
            if (c0129b != null) {
                if (this.arb.isEmpty()) {
                    this.arb = new ArrayList();
                }
                this.arb.add(c0129b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.asx.isEmpty()) {
                    this.asx = new ArrayList();
                }
                this.asx.add(cVar);
            }
            return this;
        }

        public b a(C0132d c0132d) {
            if (c0132d == null) {
                return xq();
            }
            this.ast = true;
            this.asu = c0132d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return xt();
            }
            this.asv = true;
            this.asw = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return xn();
            }
            this.asr = true;
            this.ass = fVar;
            return this;
        }

        public C0129b cn(int i) {
            return this.arb.get(i);
        }

        public b eK(String str) {
            this.asy = true;
            this.asz = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqO < 0) {
                getSerializedSize();
            }
            return this.aqO;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int i2 = 0;
            Iterator<C0129b> it = vT().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
            }
            if (xi()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, xj());
            }
            if (xl()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, xm());
            }
            if (xo()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, xp());
            }
            if (xr()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, xs());
            }
            for (c cVar : xu()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, cVar);
            }
            if (xw()) {
                i += CodedOutputStreamMicro.computeStringSize(7, xv());
            }
            this.aqO = i;
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
                        C0129b c0129b = new C0129b();
                        codedInputStreamMicro.readMessage(c0129b);
                        a(c0129b);
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
                        C0132d c0132d = new C0132d();
                        codedInputStreamMicro.readMessage(c0132d);
                        a(c0132d);
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
                        eK(codedInputStreamMicro.readString());
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

        public List<C0129b> vT() {
            return this.arb;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (C0129b c0129b : vT()) {
                codedOutputStreamMicro.writeMessage(1, c0129b);
            }
            if (xi()) {
                codedOutputStreamMicro.writeMessage(2, xj());
            }
            if (xl()) {
                codedOutputStreamMicro.writeMessage(3, xm());
            }
            if (xo()) {
                codedOutputStreamMicro.writeMessage(4, xp());
            }
            if (xr()) {
                codedOutputStreamMicro.writeMessage(5, xs());
            }
            for (c cVar : xu()) {
                codedOutputStreamMicro.writeMessage(6, cVar);
            }
            if (xw()) {
                codedOutputStreamMicro.writeString(7, xv());
            }
        }

        public int xh() {
            return this.arb.size();
        }

        public boolean xi() {
            return this.asp;
        }

        public a xj() {
            return this.asq;
        }

        public b xk() {
            this.asp = false;
            this.asq = null;
            return this;
        }

        public boolean xl() {
            return this.asr;
        }

        public f xm() {
            return this.ass;
        }

        public b xn() {
            this.asr = false;
            this.ass = null;
            return this;
        }

        public boolean xo() {
            return this.ast;
        }

        public C0132d xp() {
            return this.asu;
        }

        public b xq() {
            this.ast = false;
            this.asu = null;
            return this;
        }

        public boolean xr() {
            return this.asv;
        }

        public e xs() {
            return this.asw;
        }

        public b xt() {
            this.asv = false;
            this.asw = null;
            return this;
        }

        public List<c> xu() {
            return this.asx;
        }

        public String xv() {
            return this.asz;
        }

        public boolean xw() {
            return this.asy;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends MessageMicro {
        private boolean aqX;
        private boolean aqZ;
        private boolean auo;
        private String aum = "";
        private String aun = "";
        private String aup = "";
        private List<a> auq = Collections.emptyList();
        private int aqO = -1;

        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean aur;
            private boolean aut;
            private boolean auv;
            private boolean aux;
            private String aus = "";
            private String auu = "";
            private String auw = "";
            private String auy = "";
            private int aqO = -1;

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
                            fm(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fn(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            fo(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            fp(codedInputStreamMicro.readString());
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

            public a fm(String str) {
                this.aur = true;
                this.aus = str;
                return this;
            }

            public a fn(String str) {
                this.aut = true;
                this.auu = str;
                return this;
            }

            public a fo(String str) {
                this.auv = true;
                this.auw = str;
                return this;
            }

            public a fp(String str) {
                this.aux = true;
                this.auy = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public String getDesc() {
                return this.auy;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zj() ? 0 + CodedOutputStreamMicro.computeStringSize(1, zi()) : 0;
                if (zl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, zk());
                }
                if (zn()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, zm());
                }
                if (zo()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.aqO = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (zj()) {
                    codedOutputStreamMicro.writeString(1, zi());
                }
                if (zl()) {
                    codedOutputStreamMicro.writeString(2, zk());
                }
                if (zn()) {
                    codedOutputStreamMicro.writeString(3, zm());
                }
                if (zo()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public String zi() {
                return this.aus;
            }

            public boolean zj() {
                return this.aur;
            }

            public String zk() {
                return this.auu;
            }

            public boolean zl() {
                return this.aut;
            }

            public String zm() {
                return this.auw;
            }

            public boolean zn() {
                return this.auv;
            }

            public boolean zo() {
                return this.aux;
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
                        fj(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        fk(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fl(codedInputStreamMicro.readString());
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
                if (this.auq.isEmpty()) {
                    this.auq = new ArrayList();
                }
                this.auq.add(aVar);
            }
            return this;
        }

        public c fj(String str) {
            this.aqX = true;
            this.aum = str;
            return this;
        }

        public c fk(String str) {
            this.aqZ = true;
            this.aun = str;
            return this;
        }

        public c fl(String str) {
            this.auo = true;
            this.aup = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqO < 0) {
                getSerializedSize();
            }
            return this.aqO;
        }

        public String getDistance() {
            return this.aum;
        }

        public String getDuration() {
            return this.aun;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = vS() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (zg()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, zf());
            }
            Iterator<a> it = zh().iterator();
            while (true) {
                int i = computeStringSize;
                if (!it.hasNext()) {
                    this.aqO = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.aqZ;
        }

        public boolean vS() {
            return this.aqX;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vS()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (zg()) {
                codedOutputStreamMicro.writeString(3, zf());
            }
            for (a aVar : zh()) {
                codedOutputStreamMicro.writeMessage(4, aVar);
            }
        }

        public String zf() {
            return this.aup;
        }

        public boolean zg() {
            return this.auo;
        }

        public List<a> zh() {
            return this.auq;
        }
    }

    public d a(com.baidu.g.a.a aVar) {
        if (aVar == null) {
            return wx();
        }
        this.arE = true;
        this.arF = aVar;
        return this;
    }

    public d a(com.baidu.g.a.b bVar) {
        if (bVar != null) {
            if (this.arG.isEmpty()) {
                this.arG = new ArrayList();
            }
            this.arG.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return wu();
        }
        this.aqP = true;
        this.arD = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.aqR.isEmpty()) {
                this.aqR = new ArrayList();
            }
            this.aqR.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return ws();
        }
        this.arB = true;
        this.arC = cVar;
        return this;
    }

    public b ca(int i) {
        return this.aqR.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqO < 0) {
            getSerializedSize();
        }
        return this.aqO;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        Iterator<b> it = vP().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
        }
        if (wq()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, wr());
        }
        if (vM()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, wt());
        }
        if (wv()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, ww());
        }
        for (com.baidu.g.a.b bVar : wy()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, bVar);
        }
        this.aqO = i;
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

    public boolean vM() {
        return this.aqP;
    }

    public List<b> vP() {
        return this.aqR;
    }

    public int vQ() {
        return this.aqR.size();
    }

    public boolean wq() {
        return this.arB;
    }

    public c wr() {
        return this.arC;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (b bVar : vP()) {
            codedOutputStreamMicro.writeMessage(1, bVar);
        }
        if (wq()) {
            codedOutputStreamMicro.writeMessage(2, wr());
        }
        if (vM()) {
            codedOutputStreamMicro.writeMessage(3, wt());
        }
        if (wv()) {
            codedOutputStreamMicro.writeMessage(4, ww());
        }
        for (com.baidu.g.a.b bVar2 : wy()) {
            codedOutputStreamMicro.writeMessage(5, bVar2);
        }
    }

    public d ws() {
        this.arB = false;
        this.arC = null;
        return this;
    }

    public a wt() {
        return this.arD;
    }

    public d wu() {
        this.aqP = false;
        this.arD = null;
        return this;
    }

    public boolean wv() {
        return this.arE;
    }

    public com.baidu.g.a.a ww() {
        return this.arF;
    }

    public d wx() {
        this.arE = false;
        this.arF = null;
        return this;
    }

    public List<com.baidu.g.a.b> wy() {
        return this.arG;
    }

    public int wz() {
        return this.arG.size();
    }
}
