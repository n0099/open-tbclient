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
/* loaded from: classes7.dex */
public final class d extends MessageMicro {
    private boolean aqJ;
    private boolean arv;
    private boolean ary;
    private c arw = null;
    private List<b> aqL = Collections.emptyList();
    private a arx = null;
    private com.baidu.f.a.a arz = null;
    private List<com.baidu.f.a.b> arA = Collections.emptyList();
    private int aqI = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqO;
        private boolean arB;
        private boolean arD;
        private boolean arF;
        private boolean arI;
        private boolean arK;
        private boolean arN;
        private boolean arP;
        private boolean arR;
        private boolean arT;
        private int aqP = 0;
        private String arC = "";
        private int arE = 0;
        private c arG = null;
        private List<C0119a> arH = Collections.emptyList();
        private int arJ = 0;
        private C0120d arL = null;
        private List<b> arM = Collections.emptyList();
        private int arO = 0;
        private String arQ = "";
        private int arS = 0;
        private String arU = "";
        private int aqI = -1;

        /* renamed from: com.baidu.f.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0119a extends MessageMicro {
            private boolean aqF;
            private boolean arV;
            private boolean arX;
            private boolean arZ;
            private boolean asc;
            private boolean ase;
            private String arW = "";
            private String arY = "";
            private String aqG = "";
            private boolean asa = false;
            private List<Integer> asb = Collections.emptyList();
            private String asd = "";
            private String asf = "";
            private int aqI = -1;

            public C0119a aU(boolean z) {
                this.arZ = true;
                this.asa = z;
                return this;
            }

            public int ck(int i) {
                return this.asb.get(i).intValue();
            }

            public C0119a cl(int i) {
                if (this.asb.isEmpty()) {
                    this.asb = new ArrayList();
                }
                this.asb.add(Integer.valueOf(i));
                return this;
            }

            public C0119a eA(String str) {
                this.ase = true;
                this.asf = str;
                return this;
            }

            public C0119a ev(String str) {
                this.arV = true;
                this.arW = str;
                return this;
            }

            public C0119a ew(String str) {
                this.arX = true;
                this.arY = str;
                return this;
            }

            public C0119a ey(String str) {
                this.aqF = true;
                this.aqG = str;
                return this;
            }

            public C0119a ez(String str) {
                this.asc = true;
                this.asd = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getFloor() {
                return this.asd;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wX() ? CodedOutputStreamMicro.computeStringSize(1, wW()) + 0 : 0;
                if (wZ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wY());
                }
                if (vL()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = xb() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, xa()) : computeStringSize;
                for (Integer num : xc()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (xc().size() * 1);
                if (xd()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (xf()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, xe());
                }
                this.aqI = size;
                return size;
            }

            public String getUid() {
                return this.aqG;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: l */
            public C0119a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            ev(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            ew(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            ey(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aU(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cl(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            ez(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            eA(codedInputStreamMicro.readString());
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

            public boolean vL() {
                return this.aqF;
            }

            public String wW() {
                return this.arW;
            }

            public boolean wX() {
                return this.arV;
            }

            public String wY() {
                return this.arY;
            }

            public boolean wZ() {
                return this.arX;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wX()) {
                    codedOutputStreamMicro.writeString(1, wW());
                }
                if (wZ()) {
                    codedOutputStreamMicro.writeString(2, wY());
                }
                if (vL()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (xb()) {
                    codedOutputStreamMicro.writeBool(4, xa());
                }
                for (Integer num : xc()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (xd()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (xf()) {
                    codedOutputStreamMicro.writeString(7, xe());
                }
            }

            public boolean xa() {
                return this.asa;
            }

            public boolean xb() {
                return this.arZ;
            }

            public List<Integer> xc() {
                return this.asb;
            }

            public boolean xd() {
                return this.asc;
            }

            public String xe() {
                return this.asf;
            }

            public boolean xf() {
                return this.ase;
            }
        }

        /* loaded from: classes7.dex */
        public static final class b extends MessageMicro {
            private boolean aqu;
            private boolean asg;
            private int aqv = 0;
            private String ash = "";
            private int aqI = -1;

            public b cm(int i) {
                this.aqu = true;
                this.aqv = i;
                return this;
            }

            public b eB(String str) {
                this.asg = true;
                this.ash = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getCname() {
                return this.ash;
            }

            public int getCode() {
                return this.aqv;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vE() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (xg()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.aqI = computeInt32Size;
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

            public boolean vE() {
                return this.aqu;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vE()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (xg()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }

            public boolean xg() {
                return this.asg;
            }
        }

        /* loaded from: classes7.dex */
        public static final class c extends MessageMicro {
            private boolean aqF;
            private boolean arV;
            private boolean arX;
            private boolean arZ;
            private boolean asc;
            private boolean ase;
            private String arW = "";
            private String arY = "";
            private String aqG = "";
            private boolean asa = false;
            private List<Integer> asb = Collections.emptyList();
            private String asd = "";
            private String asf = "";
            private int aqI = -1;

            public c aV(boolean z) {
                this.arZ = true;
                this.asa = z;
                return this;
            }

            public int ck(int i) {
                return this.asb.get(i).intValue();
            }

            public c cn(int i) {
                if (this.asb.isEmpty()) {
                    this.asb = new ArrayList();
                }
                this.asb.add(Integer.valueOf(i));
                return this;
            }

            public c eC(String str) {
                this.arV = true;
                this.arW = str;
                return this;
            }

            public c eD(String str) {
                this.arX = true;
                this.arY = str;
                return this;
            }

            public c eE(String str) {
                this.aqF = true;
                this.aqG = str;
                return this;
            }

            public c eF(String str) {
                this.asc = true;
                this.asd = str;
                return this;
            }

            public c eG(String str) {
                this.ase = true;
                this.asf = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getFloor() {
                return this.asd;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wX() ? CodedOutputStreamMicro.computeStringSize(1, wW()) + 0 : 0;
                if (wZ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wY());
                }
                if (vL()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = xb() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, xa()) : computeStringSize;
                for (Integer num : xc()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (xc().size() * 1);
                if (xd()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (xf()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, xe());
                }
                this.aqI = size;
                return size;
            }

            public String getUid() {
                return this.aqG;
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
                            eC(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eD(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eE(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aV(codedInputStreamMicro.readBool());
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

            public boolean vL() {
                return this.aqF;
            }

            public String wW() {
                return this.arW;
            }

            public boolean wX() {
                return this.arV;
            }

            public String wY() {
                return this.arY;
            }

            public boolean wZ() {
                return this.arX;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wX()) {
                    codedOutputStreamMicro.writeString(1, wW());
                }
                if (wZ()) {
                    codedOutputStreamMicro.writeString(2, wY());
                }
                if (vL()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (xb()) {
                    codedOutputStreamMicro.writeBool(4, xa());
                }
                for (Integer num : xc()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (xd()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (xf()) {
                    codedOutputStreamMicro.writeString(7, xe());
                }
            }

            public boolean xa() {
                return this.asa;
            }

            public boolean xb() {
                return this.arZ;
            }

            public List<Integer> xc() {
                return this.asb;
            }

            public boolean xd() {
                return this.asc;
            }

            public String xe() {
                return this.asf;
            }

            public boolean xf() {
                return this.ase;
            }

            public int xh() {
                return this.asb.size();
            }
        }

        /* renamed from: com.baidu.f.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0120d extends MessageMicro {
            private boolean aqu;
            private boolean asg;
            private int aqv = 0;
            private String ash = "";
            private int aqI = -1;

            public C0120d co(int i) {
                this.aqu = true;
                this.aqv = i;
                return this;
            }

            public C0120d eH(String str) {
                this.asg = true;
                this.ash = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getCname() {
                return this.ash;
            }

            public int getCode() {
                return this.aqv;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vE() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (xg()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.aqI = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: o */
            public C0120d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

            public boolean vE() {
                return this.aqu;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vE()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (xg()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }

            public boolean xg() {
                return this.asg;
            }
        }

        public a a(C0119a c0119a) {
            if (c0119a != null) {
                if (this.arH.isEmpty()) {
                    this.arH = new ArrayList();
                }
                this.arH.add(c0119a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.arM.isEmpty()) {
                    this.arM = new ArrayList();
                }
                this.arM.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wG();
            }
            this.arF = true;
            this.arG = cVar;
            return this;
        }

        public a a(C0120d c0120d) {
            if (c0120d == null) {
                return wM();
            }
            this.arK = true;
            this.arL = c0120d;
            return this;
        }

        public a cd(int i) {
            this.aqO = true;
            this.aqP = i;
            return this;
        }

        public a ce(int i) {
            this.arD = true;
            this.arE = i;
            return this;
        }

        public C0119a cf(int i) {
            return this.arH.get(i);
        }

        public a cg(int i) {
            this.arI = true;
            this.arJ = i;
            return this;
        }

        public b ch(int i) {
            return this.arM.get(i);
        }

        public a ci(int i) {
            this.arN = true;
            this.arO = i;
            return this;
        }

        public a cj(int i) {
            this.arR = true;
            this.arS = i;
            return this;
        }

        public a es(String str) {
            this.arB = true;
            this.arC = str;
            return this;
        }

        public a et(String str) {
            this.arP = true;
            this.arQ = str;
            return this;
        }

        public a eu(String str) {
            this.arT = true;
            this.arU = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqI < 0) {
                getSerializedSize();
            }
            return this.aqI;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int computeInt32Size = vS() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (wC()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wB());
            }
            if (wE()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, wD());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, wF());
            }
            Iterator<C0119a> it = wH().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
            }
            if (wJ()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, wI());
            }
            if (wK()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, wL());
            }
            for (b bVar : wN()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, bVar);
            }
            if (wP()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, wO());
            }
            if (wR()) {
                i += CodedOutputStreamMicro.computeStringSize(10, wQ());
            }
            if (wT()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, wS());
            }
            if (wV()) {
                i += CodedOutputStreamMicro.computeStringSize(12, wU());
            }
            this.aqI = i;
            return i;
        }

        public int getTotal() {
            return this.aqP;
        }

        public boolean hasStart() {
            return this.arF;
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
                        es(codedInputStreamMicro.readString());
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
                        C0119a c0119a = new C0119a();
                        codedInputStreamMicro.readMessage(c0119a);
                        a(c0119a);
                        break;
                    case 48:
                        cg(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        C0120d c0120d = new C0120d();
                        codedInputStreamMicro.readMessage(c0120d);
                        a(c0120d);
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
                        et(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        cj(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
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

        public boolean vS() {
            return this.aqO;
        }

        public String wB() {
            return this.arC;
        }

        public boolean wC() {
            return this.arB;
        }

        public int wD() {
            return this.arE;
        }

        public boolean wE() {
            return this.arD;
        }

        public c wF() {
            return this.arG;
        }

        public a wG() {
            this.arF = false;
            this.arG = null;
            return this;
        }

        public List<C0119a> wH() {
            return this.arH;
        }

        public int wI() {
            return this.arJ;
        }

        public boolean wJ() {
            return this.arI;
        }

        public boolean wK() {
            return this.arK;
        }

        public C0120d wL() {
            return this.arL;
        }

        public a wM() {
            this.arK = false;
            this.arL = null;
            return this;
        }

        public List<b> wN() {
            return this.arM;
        }

        public int wO() {
            return this.arO;
        }

        public boolean wP() {
            return this.arN;
        }

        public String wQ() {
            return this.arQ;
        }

        public boolean wR() {
            return this.arP;
        }

        public int wS() {
            return this.arS;
        }

        public boolean wT() {
            return this.arR;
        }

        public String wU() {
            return this.arU;
        }

        public boolean wV() {
            return this.arT;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vS()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (wC()) {
                codedOutputStreamMicro.writeString(2, wB());
            }
            if (wE()) {
                codedOutputStreamMicro.writeInt32(3, wD());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, wF());
            }
            for (C0119a c0119a : wH()) {
                codedOutputStreamMicro.writeMessage(5, c0119a);
            }
            if (wJ()) {
                codedOutputStreamMicro.writeInt32(6, wI());
            }
            if (wK()) {
                codedOutputStreamMicro.writeMessage(7, wL());
            }
            for (b bVar : wN()) {
                codedOutputStreamMicro.writeMessage(8, bVar);
            }
            if (wP()) {
                codedOutputStreamMicro.writeInt32(9, wO());
            }
            if (wR()) {
                codedOutputStreamMicro.writeString(10, wQ());
            }
            if (wT()) {
                codedOutputStreamMicro.writeInt32(11, wS());
            }
            if (wV()) {
                codedOutputStreamMicro.writeString(12, wU());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends MessageMicro {
        private boolean asi;
        private boolean ask;
        private boolean asn;
        private boolean asp;
        private boolean ass;
        private List<C0121b> aqV = Collections.emptyList();
        private a asj = null;
        private f asl = null;
        private C0124d aso = null;
        private e asq = null;
        private List<c> asr = Collections.emptyList();
        private String ast = "";
        private int aqI = -1;

        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean asu;
            private boolean asw;
            private boolean asy;
            private int asv = 0;
            private int asx = 0;
            private int asz = 0;
            private int aqI = -1;

            public a cq(int i) {
                this.asu = true;
                this.asv = i;
                return this;
            }

            public a cr(int i) {
                this.asw = true;
                this.asx = i;
                return this;
            }

            public a cs(int i) {
                this.asy = true;
                this.asz = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = xz() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xy()) : 0;
                if (xB()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xA());
                }
                if (xD()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, xC());
                }
                this.aqI = computeInt32Size;
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
                if (xz()) {
                    codedOutputStreamMicro.writeInt32(1, xy());
                }
                if (xB()) {
                    codedOutputStreamMicro.writeInt32(2, xA());
                }
                if (xD()) {
                    codedOutputStreamMicro.writeInt32(3, xC());
                }
            }

            public int xA() {
                return this.asx;
            }

            public boolean xB() {
                return this.asw;
            }

            public int xC() {
                return this.asz;
            }

            public boolean xD() {
                return this.asy;
            }

            public int xy() {
                return this.asv;
            }

            public boolean xz() {
                return this.asu;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0121b extends MessageMicro {
            private boolean aqR;
            private boolean aqT;
            private boolean asA;
            private boolean asC;
            private boolean asE;
            private boolean asG;
            private boolean asI;
            private boolean asL;
            private List<c> ara = Collections.emptyList();
            private List<Integer> aqY = Collections.emptyList();
            private List<Integer> aqZ = Collections.emptyList();
            private String asB = "";
            private String asD = "";
            private int aqS = 0;
            private int aqU = 0;
            private int asF = 0;
            private int asH = 0;
            private int asJ = 0;
            private List<a> asK = Collections.emptyList();
            private C0122b asM = null;
            private int aqI = -1;

            /* renamed from: com.baidu.f.a.d$b$b$a */
            /* loaded from: classes7.dex */
            public static final class a extends MessageMicro {
                private boolean aqQ;
                private boolean asN;
                private boolean asP;
                private boolean asc;
                private boolean ase;
                private int type_ = 0;
                private int asO = 0;
                private String asQ = "";
                private List<Integer> arj = Collections.emptyList();
                private String asd = "";
                private String asf = "";
                private int aqI = -1;

                public a cB(int i) {
                    this.aqQ = true;
                    this.type_ = i;
                    return this;
                }

                public a cC(int i) {
                    this.asN = true;
                    this.asO = i;
                    return this;
                }

                public a cD(int i) {
                    if (this.arj.isEmpty()) {
                        this.arj = new ArrayList();
                    }
                    this.arj.add(Integer.valueOf(i));
                    return this;
                }

                public a eL(String str) {
                    this.asP = true;
                    this.asQ = str;
                    return this;
                }

                public a eM(String str) {
                    this.asc = true;
                    this.asd = str;
                    return this;
                }

                public a eN(String str) {
                    this.ase = true;
                    this.asf = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqI < 0) {
                        getSerializedSize();
                    }
                    return this.aqI;
                }

                public String getFloor() {
                    return this.asd;
                }

                public String getInfo() {
                    return this.asQ;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (xU()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xT());
                    }
                    int computeStringSize = xV() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
                    for (Integer num : wh()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize + i + (wh().size() * 1);
                    if (xd()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (xf()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, xe());
                    }
                    this.aqI = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.aqQ;
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
                                eL(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cD(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eM(codedInputStreamMicro.readString());
                                break;
                            case 50:
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

                public List<Integer> wh() {
                    return this.arj;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (xU()) {
                        codedOutputStreamMicro.writeInt32(2, xT());
                    }
                    if (xV()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    for (Integer num : wh()) {
                        codedOutputStreamMicro.writeInt32(4, num.intValue());
                    }
                    if (xd()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (xf()) {
                        codedOutputStreamMicro.writeString(6, xe());
                    }
                }

                public int xT() {
                    return this.asO;
                }

                public boolean xU() {
                    return this.asN;
                }

                public boolean xV() {
                    return this.asP;
                }

                public boolean xd() {
                    return this.asc;
                }

                public String xe() {
                    return this.asf;
                }

                public boolean xf() {
                    return this.ase;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public static final class C0122b extends MessageMicro {
                private boolean asR;
                private boolean hasNext;
                private int asS = 0;
                private int asT = 0;
                private int aqI = -1;

                public C0122b cE(int i) {
                    this.asR = true;
                    this.asS = i;
                    return this;
                }

                public C0122b cF(int i) {
                    this.hasNext = true;
                    this.asT = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqI < 0) {
                        getSerializedSize();
                    }
                    return this.aqI;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xX() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xW()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xY());
                    }
                    this.aqI = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: t */
                public C0122b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    if (xX()) {
                        codedOutputStreamMicro.writeInt32(1, xW());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, xY());
                    }
                }

                public int xW() {
                    return this.asS;
                }

                public boolean xX() {
                    return this.asR;
                }

                public int xY() {
                    return this.asT;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$c */
            /* loaded from: classes7.dex */
            public static final class c extends MessageMicro {
                private boolean aqQ;
                private boolean aqR;
                private boolean aqT;
                private boolean aqz;
                private boolean arb;
                private boolean asV;
                private boolean asX;
                private boolean asZ;
                private boolean atb;
                private boolean atd;
                private boolean atf;
                private boolean ath;
                private boolean atj;
                private boolean atm;
                private boolean atp;
                private List<a> asU = Collections.emptyList();
                private List<C0123b> arg = Collections.emptyList();
                private List<Integer> arf = Collections.emptyList();
                private String arc = "";
                private int type_ = 0;
                private String aqA = "";
                private int asW = 0;
                private int asY = 0;
                private int ata = 0;
                private int atc = 0;
                private int ate = 0;
                private int atg = 0;
                private int aqS = 0;
                private int aqU = 0;
                private int ati = 0;
                private int atk = 0;
                private List<Integer> aqY = Collections.emptyList();
                private List<Integer> aqZ = Collections.emptyList();
                private List<Integer> atl = Collections.emptyList();
                private int atn = 0;
                private List<Integer> ato = Collections.emptyList();
                private int atq = 0;
                private List<C0123b> atr = Collections.emptyList();
                private int aqI = -1;

                /* renamed from: com.baidu.f.a.d$b$b$c$a */
                /* loaded from: classes7.dex */
                public static final class a extends MessageMicro {
                    private boolean art;
                    private boolean atj;
                    private boolean ats;
                    private boolean atu;
                    private boolean atw;
                    private boolean aty;
                    private String att = "";
                    private int atv = 0;
                    private int aru = 0;
                    private int atk = 0;
                    private int atx = 0;
                    private int atz = 0;
                    private int aqI = -1;

                    public a cY(int i) {
                        this.atu = true;
                        this.atv = i;
                        return this;
                    }

                    public a cZ(int i) {
                        this.art = true;
                        this.aru = i;
                        return this;
                    }

                    public a da(int i) {
                        this.atj = true;
                        this.atk = i;
                        return this;
                    }

                    public a db(int i) {
                        this.atw = true;
                        this.atx = i;
                        return this;
                    }

                    public a dc(int i) {
                        this.aty = true;
                        this.atz = i;
                        return this;
                    }

                    public a eQ(String str) {
                        this.ats = true;
                        this.att = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqI < 0) {
                            getSerializedSize();
                        }
                        return this.aqI;
                    }

                    public String getId() {
                        return this.att;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (yx()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, yw());
                        }
                        if (wq()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, wp());
                        }
                        if (yo()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, yn());
                        }
                        if (yz()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, yy());
                        }
                        if (yB()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, yA());
                        }
                        this.aqI = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.ats;
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
                                    eQ(codedInputStreamMicro.readString());
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

                    public int wp() {
                        return this.aru;
                    }

                    public boolean wq() {
                        return this.art;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (yx()) {
                            codedOutputStreamMicro.writeInt32(2, yw());
                        }
                        if (wq()) {
                            codedOutputStreamMicro.writeInt32(3, wp());
                        }
                        if (yo()) {
                            codedOutputStreamMicro.writeInt32(4, yn());
                        }
                        if (yz()) {
                            codedOutputStreamMicro.writeInt32(5, yy());
                        }
                        if (yB()) {
                            codedOutputStreamMicro.writeInt32(6, yA());
                        }
                    }

                    public int yA() {
                        return this.atz;
                    }

                    public boolean yB() {
                        return this.aty;
                    }

                    public int yn() {
                        return this.atk;
                    }

                    public boolean yo() {
                        return this.atj;
                    }

                    public int yw() {
                        return this.atv;
                    }

                    public boolean yx() {
                        return this.atu;
                    }

                    public int yy() {
                        return this.atx;
                    }

                    public boolean yz() {
                        return this.atw;
                    }
                }

                /* renamed from: com.baidu.f.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C0123b extends MessageMicro {
                    private boolean aqF;
                    private boolean aqz;
                    private boolean asE;
                    private boolean atB;
                    private boolean atD;
                    private boolean atF;
                    private boolean atI;
                    private boolean atK;
                    private boolean atM;
                    private boolean atO;
                    private boolean atQ;
                    private String aqA = "";
                    private List<Integer> atA = Collections.emptyList();
                    private int asF = 0;
                    private String atC = "";
                    private String atE = "";
                    private String atG = "";
                    private String aqG = "";
                    private List<Integer> atH = Collections.emptyList();
                    private String atJ = "";
                    private String atL = "";
                    private String atN = "";
                    private int atP = 0;
                    private int atR = 0;
                    private int aqI = -1;

                    public C0123b dd(int i) {
                        if (this.atA.isEmpty()) {
                            this.atA = new ArrayList();
                        }
                        this.atA.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0123b de(int i) {
                        this.asE = true;
                        this.asF = i;
                        return this;
                    }

                    public C0123b df(int i) {
                        if (this.atH.isEmpty()) {
                            this.atH = new ArrayList();
                        }
                        this.atH.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0123b dg(int i) {
                        this.atO = true;
                        this.atP = i;
                        return this;
                    }

                    public C0123b dh(int i) {
                        this.atQ = true;
                        this.atR = i;
                        return this;
                    }

                    public C0123b eR(String str) {
                        this.aqz = true;
                        this.aqA = str;
                        return this;
                    }

                    public C0123b eS(String str) {
                        this.atB = true;
                        this.atC = str;
                        return this;
                    }

                    public C0123b eT(String str) {
                        this.atD = true;
                        this.atE = str;
                        return this;
                    }

                    public C0123b eU(String str) {
                        this.atF = true;
                        this.atG = str;
                        return this;
                    }

                    public C0123b eV(String str) {
                        this.aqF = true;
                        this.aqG = str;
                        return this;
                    }

                    public C0123b eW(String str) {
                        this.atI = true;
                        this.atJ = str;
                        return this;
                    }

                    public C0123b eX(String str) {
                        this.atK = true;
                        this.atL = str;
                        return this;
                    }

                    public C0123b eY(String str) {
                        this.atM = true;
                        this.atN = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqI < 0) {
                            getSerializedSize();
                        }
                        return this.aqI;
                    }

                    public String getIconUrl() {
                        return this.atJ;
                    }

                    public String getName() {
                        return this.aqA;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        int i2 = 0;
                        for (Integer num : yC()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i2;
                        }
                        int size = computeStringSize + i2 + (yC().size() * 1);
                        if (xK()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, xJ());
                        }
                        if (yE()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, yD());
                        }
                        if (yG()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, yF());
                        }
                        if (yI()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, yH());
                        }
                        int computeStringSize2 = vL() ? size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : size;
                        for (Integer num2 : yJ()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                        }
                        int size2 = computeStringSize2 + i + (yJ().size() * 1);
                        if (yK()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (yM()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, yL());
                        }
                        if (yO()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, yN());
                        }
                        if (yQ()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, yP());
                        }
                        if (yS()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, yR());
                        }
                        this.aqI = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.aqG;
                    }

                    public boolean hasName() {
                        return this.aqz;
                    }

                    public boolean vL() {
                        return this.aqF;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: w */
                    public C0123b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eR(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    dd(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    de(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eS(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eT(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    eU(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    eV(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    df(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    eW(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    eX(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    eY(codedInputStreamMicro.readString());
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
                        for (Integer num : yC()) {
                            codedOutputStreamMicro.writeSInt32(2, num.intValue());
                        }
                        if (xK()) {
                            codedOutputStreamMicro.writeInt32(3, xJ());
                        }
                        if (yE()) {
                            codedOutputStreamMicro.writeString(4, yD());
                        }
                        if (yG()) {
                            codedOutputStreamMicro.writeString(5, yF());
                        }
                        if (yI()) {
                            codedOutputStreamMicro.writeString(6, yH());
                        }
                        if (vL()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        for (Integer num2 : yJ()) {
                            codedOutputStreamMicro.writeSInt32(8, num2.intValue());
                        }
                        if (yK()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (yM()) {
                            codedOutputStreamMicro.writeString(10, yL());
                        }
                        if (yO()) {
                            codedOutputStreamMicro.writeString(11, yN());
                        }
                        if (yQ()) {
                            codedOutputStreamMicro.writeInt32(12, yP());
                        }
                        if (yS()) {
                            codedOutputStreamMicro.writeInt32(13, yR());
                        }
                    }

                    public int xJ() {
                        return this.asF;
                    }

                    public boolean xK() {
                        return this.asE;
                    }

                    public List<Integer> yC() {
                        return this.atA;
                    }

                    public String yD() {
                        return this.atC;
                    }

                    public boolean yE() {
                        return this.atB;
                    }

                    public String yF() {
                        return this.atE;
                    }

                    public boolean yG() {
                        return this.atD;
                    }

                    public String yH() {
                        return this.atG;
                    }

                    public boolean yI() {
                        return this.atF;
                    }

                    public List<Integer> yJ() {
                        return this.atH;
                    }

                    public boolean yK() {
                        return this.atI;
                    }

                    public String yL() {
                        return this.atL;
                    }

                    public boolean yM() {
                        return this.atK;
                    }

                    public String yN() {
                        return this.atN;
                    }

                    public boolean yO() {
                        return this.atM;
                    }

                    public int yP() {
                        return this.atP;
                    }

                    public boolean yQ() {
                        return this.atO;
                    }

                    public int yR() {
                        return this.atR;
                    }

                    public boolean yS() {
                        return this.atQ;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.asU.isEmpty()) {
                            this.asU = new ArrayList();
                        }
                        this.asU.add(aVar);
                    }
                    return this;
                }

                public c a(C0123b c0123b) {
                    if (c0123b != null) {
                        if (this.arg.isEmpty()) {
                            this.arg = new ArrayList();
                        }
                        this.arg.add(c0123b);
                    }
                    return this;
                }

                public c b(C0123b c0123b) {
                    if (c0123b != null) {
                        if (this.atr.isEmpty()) {
                            this.atr = new ArrayList();
                        }
                        this.atr.add(c0123b);
                    }
                    return this;
                }

                public c cG(int i) {
                    if (this.arf.isEmpty()) {
                        this.arf = new ArrayList();
                    }
                    this.arf.add(Integer.valueOf(i));
                    return this;
                }

                public c cH(int i) {
                    this.aqQ = true;
                    this.type_ = i;
                    return this;
                }

                public c cI(int i) {
                    this.asV = true;
                    this.asW = i;
                    return this;
                }

                public c cJ(int i) {
                    this.asX = true;
                    this.asY = i;
                    return this;
                }

                public c cK(int i) {
                    this.asZ = true;
                    this.ata = i;
                    return this;
                }

                public c cL(int i) {
                    this.atb = true;
                    this.atc = i;
                    return this;
                }

                public c cM(int i) {
                    this.atd = true;
                    this.ate = i;
                    return this;
                }

                public c cN(int i) {
                    this.atf = true;
                    this.atg = i;
                    return this;
                }

                public c cO(int i) {
                    this.aqR = true;
                    this.aqS = i;
                    return this;
                }

                public c cP(int i) {
                    this.aqT = true;
                    this.aqU = i;
                    return this;
                }

                public c cQ(int i) {
                    this.ath = true;
                    this.ati = i;
                    return this;
                }

                public c cR(int i) {
                    this.atj = true;
                    this.atk = i;
                    return this;
                }

                public c cS(int i) {
                    if (this.aqY.isEmpty()) {
                        this.aqY = new ArrayList();
                    }
                    this.aqY.add(Integer.valueOf(i));
                    return this;
                }

                public c cT(int i) {
                    if (this.aqZ.isEmpty()) {
                        this.aqZ = new ArrayList();
                    }
                    this.aqZ.add(Integer.valueOf(i));
                    return this;
                }

                public c cU(int i) {
                    if (this.atl.isEmpty()) {
                        this.atl = new ArrayList();
                    }
                    this.atl.add(Integer.valueOf(i));
                    return this;
                }

                public c cV(int i) {
                    this.atm = true;
                    this.atn = i;
                    return this;
                }

                public c cW(int i) {
                    if (this.ato.isEmpty()) {
                        this.ato = new ArrayList();
                    }
                    this.ato.add(Integer.valueOf(i));
                    return this;
                }

                public c cX(int i) {
                    this.atp = true;
                    this.atq = i;
                    return this;
                }

                public c eO(String str) {
                    this.arb = true;
                    this.arc = str;
                    return this;
                }

                public c eP(String str) {
                    this.aqz = true;
                    this.aqA = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqI < 0) {
                        getSerializedSize();
                    }
                    return this.aqI;
                }

                public int getDirection() {
                    return this.ati;
                }

                public int getDistance() {
                    return this.aqS;
                }

                public int getDuration() {
                    return this.aqU;
                }

                public String getInstructions() {
                    return this.arc;
                }

                public String getName() {
                    return this.aqA;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int i2 = 0;
                    int i3 = 0;
                    for (Integer num : wd()) {
                        i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                    }
                    int size = 0 + i3 + (wd().size() * 1);
                    if (wa()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (yb()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, ya());
                    }
                    if (yd()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, yc());
                    }
                    if (yf()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, ye());
                    }
                    if (yh()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, yg());
                    }
                    if (yj()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, yi());
                    }
                    if (yl()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, yk());
                    }
                    if (vT()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<a> it = xZ().iterator();
                    while (true) {
                        i = size;
                        if (!it.hasNext()) {
                            break;
                        }
                        size = CodedOutputStreamMicro.computeMessageSize(13, it.next()) + i;
                    }
                    for (C0123b c0123b : we()) {
                        i += CodedOutputStreamMicro.computeMessageSize(14, c0123b);
                    }
                    if (ym()) {
                        i += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (yo()) {
                        i += CodedOutputStreamMicro.computeInt32Size(16, yn());
                    }
                    int i4 = 0;
                    for (Integer num2 : vX()) {
                        i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue()) + i4;
                    }
                    int size2 = i + i4 + (vX().size() * 2);
                    int i5 = 0;
                    for (Integer num3 : vY()) {
                        i5 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num3.intValue()) + i5;
                    }
                    int size3 = size2 + i5 + (vY().size() * 2);
                    int i6 = 0;
                    for (Integer num4 : yp()) {
                        i6 = CodedOutputStreamMicro.computeInt32SizeNoTag(num4.intValue()) + i6;
                    }
                    int size4 = size3 + i6 + (yp().size() * 2);
                    int computeInt32Size = yr() ? size4 + CodedOutputStreamMicro.computeInt32Size(20, yq()) : size4;
                    for (Integer num5 : ys()) {
                        i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num5.intValue());
                    }
                    int size5 = computeInt32Size + i2 + (ys().size() * 2);
                    if (yu()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, yt());
                    }
                    Iterator<C0123b> it2 = yv().iterator();
                    while (true) {
                        int i7 = size5;
                        if (!it2.hasNext()) {
                            this.aqI = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqT;
                }

                public boolean hasName() {
                    return this.aqz;
                }

                public boolean hasType() {
                    return this.aqQ;
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
                                eO(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cH(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eP(codedInputStreamMicro.readString());
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
                                C0123b c0123b = new C0123b();
                                codedInputStreamMicro.readMessage(c0123b);
                                a(c0123b);
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
                                C0123b c0123b2 = new C0123b();
                                codedInputStreamMicro.readMessage(c0123b2);
                                b(c0123b2);
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

                public boolean vT() {
                    return this.aqR;
                }

                public List<Integer> vX() {
                    return this.aqY;
                }

                public List<Integer> vY() {
                    return this.aqZ;
                }

                public boolean wa() {
                    return this.arb;
                }

                public List<Integer> wd() {
                    return this.arf;
                }

                public List<C0123b> we() {
                    return this.arg;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer num : wd()) {
                        codedOutputStreamMicro.writeSInt32(1, num.intValue());
                    }
                    if (wa()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (yb()) {
                        codedOutputStreamMicro.writeInt32(5, ya());
                    }
                    if (yd()) {
                        codedOutputStreamMicro.writeInt32(6, yc());
                    }
                    if (yf()) {
                        codedOutputStreamMicro.writeInt32(7, ye());
                    }
                    if (yh()) {
                        codedOutputStreamMicro.writeInt32(8, yg());
                    }
                    if (yj()) {
                        codedOutputStreamMicro.writeInt32(9, yi());
                    }
                    if (yl()) {
                        codedOutputStreamMicro.writeInt32(10, yk());
                    }
                    if (vT()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (a aVar : xZ()) {
                        codedOutputStreamMicro.writeMessage(13, aVar);
                    }
                    for (C0123b c0123b : we()) {
                        codedOutputStreamMicro.writeMessage(14, c0123b);
                    }
                    if (ym()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (yo()) {
                        codedOutputStreamMicro.writeInt32(16, yn());
                    }
                    for (Integer num2 : vX()) {
                        codedOutputStreamMicro.writeSInt32(17, num2.intValue());
                    }
                    for (Integer num3 : vY()) {
                        codedOutputStreamMicro.writeSInt32(18, num3.intValue());
                    }
                    for (Integer num4 : yp()) {
                        codedOutputStreamMicro.writeInt32(19, num4.intValue());
                    }
                    if (yr()) {
                        codedOutputStreamMicro.writeInt32(20, yq());
                    }
                    for (Integer num5 : ys()) {
                        codedOutputStreamMicro.writeSInt32(21, num5.intValue());
                    }
                    if (yu()) {
                        codedOutputStreamMicro.writeInt32(22, yt());
                    }
                    for (C0123b c0123b2 : yv()) {
                        codedOutputStreamMicro.writeMessage(23, c0123b2);
                    }
                }

                public List<a> xZ() {
                    return this.asU;
                }

                public int ya() {
                    return this.asW;
                }

                public boolean yb() {
                    return this.asV;
                }

                public int yc() {
                    return this.asY;
                }

                public boolean yd() {
                    return this.asX;
                }

                public int ye() {
                    return this.ata;
                }

                public boolean yf() {
                    return this.asZ;
                }

                public int yg() {
                    return this.atc;
                }

                public boolean yh() {
                    return this.atb;
                }

                public int yi() {
                    return this.ate;
                }

                public boolean yj() {
                    return this.atd;
                }

                public int yk() {
                    return this.atg;
                }

                public boolean yl() {
                    return this.atf;
                }

                public boolean ym() {
                    return this.ath;
                }

                public int yn() {
                    return this.atk;
                }

                public boolean yo() {
                    return this.atj;
                }

                public List<Integer> yp() {
                    return this.atl;
                }

                public int yq() {
                    return this.atn;
                }

                public boolean yr() {
                    return this.atm;
                }

                public List<Integer> ys() {
                    return this.ato;
                }

                public int yt() {
                    return this.atq;
                }

                public boolean yu() {
                    return this.atp;
                }

                public List<C0123b> yv() {
                    return this.atr;
                }
            }

            public C0121b a(a aVar) {
                if (aVar != null) {
                    if (this.asK.isEmpty()) {
                        this.asK = new ArrayList();
                    }
                    this.asK.add(aVar);
                }
                return this;
            }

            public C0121b a(C0122b c0122b) {
                if (c0122b == null) {
                    return xS();
                }
                this.asL = true;
                this.asM = c0122b;
                return this;
            }

            public C0121b a(c cVar) {
                if (cVar != null) {
                    if (this.ara.isEmpty()) {
                        this.ara = new ArrayList();
                    }
                    this.ara.add(cVar);
                }
                return this;
            }

            public C0121b cA(int i) {
                this.asI = true;
                this.asJ = i;
                return this;
            }

            public c ct(int i) {
                return this.ara.get(i);
            }

            public C0121b cu(int i) {
                if (this.aqY.isEmpty()) {
                    this.aqY = new ArrayList();
                }
                this.aqY.add(Integer.valueOf(i));
                return this;
            }

            public C0121b cv(int i) {
                if (this.aqZ.isEmpty()) {
                    this.aqZ = new ArrayList();
                }
                this.aqZ.add(Integer.valueOf(i));
                return this;
            }

            public C0121b cw(int i) {
                this.aqR = true;
                this.aqS = i;
                return this;
            }

            public C0121b cx(int i) {
                this.aqT = true;
                this.aqU = i;
                return this;
            }

            public C0121b cy(int i) {
                this.asE = true;
                this.asF = i;
                return this;
            }

            public C0121b cz(int i) {
                this.asG = true;
                this.asH = i;
                return this;
            }

            public C0121b eJ(String str) {
                this.asA = true;
                this.asB = str;
                return this;
            }

            public C0121b eK(String str) {
                this.asC = true;
                this.asD = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public int getDistance() {
                return this.aqS;
            }

            public int getDuration() {
                return this.aqU;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int i2 = 0;
                int i3 = 0;
                for (Integer num : vX()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                }
                int size = (vX().size() * 1) + 0 + i3;
                for (Integer num2 : vY()) {
                    i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                }
                int size2 = size + i2 + (vY().size() * 1);
                if (xG()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, xF());
                }
                if (xI()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, xH());
                }
                if (vT()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (xK()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, xJ());
                }
                if (xM()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, xL());
                }
                if (xO()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, xN());
                }
                Iterator<c> it = vZ().iterator();
                while (true) {
                    i = size2;
                    if (!it.hasNext()) {
                        break;
                    }
                    size2 = CodedOutputStreamMicro.computeMessageSize(10, it.next()) + i;
                }
                for (a aVar : xP()) {
                    i += CodedOutputStreamMicro.computeMessageSize(11, aVar);
                }
                if (xQ()) {
                    i += CodedOutputStreamMicro.computeMessageSize(12, xR());
                }
                this.aqI = i;
                return i;
            }

            public boolean hasDuration() {
                return this.aqT;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: r */
            public C0121b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                            eJ(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eK(codedInputStreamMicro.readString());
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
                            C0122b c0122b = new C0122b();
                            codedInputStreamMicro.readMessage(c0122b);
                            a(c0122b);
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

            public boolean vT() {
                return this.aqR;
            }

            public List<Integer> vX() {
                return this.aqY;
            }

            public List<Integer> vY() {
                return this.aqZ;
            }

            public List<c> vZ() {
                return this.ara;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer num : vX()) {
                    codedOutputStreamMicro.writeSInt32(1, num.intValue());
                }
                for (Integer num2 : vY()) {
                    codedOutputStreamMicro.writeSInt32(2, num2.intValue());
                }
                if (xG()) {
                    codedOutputStreamMicro.writeString(3, xF());
                }
                if (xI()) {
                    codedOutputStreamMicro.writeString(4, xH());
                }
                if (vT()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (xK()) {
                    codedOutputStreamMicro.writeInt32(7, xJ());
                }
                if (xM()) {
                    codedOutputStreamMicro.writeInt32(8, xL());
                }
                if (xO()) {
                    codedOutputStreamMicro.writeInt32(9, xN());
                }
                for (c cVar : vZ()) {
                    codedOutputStreamMicro.writeMessage(10, cVar);
                }
                for (a aVar : xP()) {
                    codedOutputStreamMicro.writeMessage(11, aVar);
                }
                if (xQ()) {
                    codedOutputStreamMicro.writeMessage(12, xR());
                }
            }

            public int xE() {
                return this.ara.size();
            }

            public String xF() {
                return this.asB;
            }

            public boolean xG() {
                return this.asA;
            }

            public String xH() {
                return this.asD;
            }

            public boolean xI() {
                return this.asC;
            }

            public int xJ() {
                return this.asF;
            }

            public boolean xK() {
                return this.asE;
            }

            public int xL() {
                return this.asH;
            }

            public boolean xM() {
                return this.asG;
            }

            public int xN() {
                return this.asJ;
            }

            public boolean xO() {
                return this.asI;
            }

            public List<a> xP() {
                return this.asK;
            }

            public boolean xQ() {
                return this.asL;
            }

            public C0122b xR() {
                return this.asM;
            }

            public C0121b xS() {
                this.asL = false;
                this.asM = null;
                return this;
            }
        }

        /* loaded from: classes7.dex */
        public static final class c extends MessageMicro {
            private boolean atS;
            private int atT = 0;
            private List<Integer> atU = Collections.emptyList();
            private int aqI = -1;

            public c di(int i) {
                this.atS = true;
                this.atT = i;
                return this;
            }

            public c dj(int i) {
                if (this.atU.isEmpty()) {
                    this.atU = new ArrayList();
                }
                this.atU.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yU() ? CodedOutputStreamMicro.computeInt32Size(1, yT()) + 0 : 0;
                for (Integer num : yV()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yV().size() * 1);
                this.aqI = size;
                return size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yU()) {
                    codedOutputStreamMicro.writeInt32(1, yT());
                }
                for (Integer num : yV()) {
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

            public int yT() {
                return this.atT;
            }

            public boolean yU() {
                return this.atS;
            }

            public List<Integer> yV() {
                return this.atU;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0124d extends MessageMicro {
            private boolean atV;
            private int atW = 0;
            private int aqI = -1;

            public C0124d dk(int i) {
                this.atV = true;
                this.atW = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public int getLightNum() {
                return this.atW;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yW() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.aqI = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yW()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: y */
            public C0124d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

            public boolean yW() {
                return this.atV;
            }
        }

        /* loaded from: classes7.dex */
        public static final class e extends MessageMicro {
            private boolean arF;
            private boolean arv;
            private boolean atX;
            private boolean atZ;
            private int atY = 0;
            private String aua = "";
            private a aub = null;
            private List<a> arH = Collections.emptyList();
            private c arw = null;
            private int aqI = -1;

            /* loaded from: classes7.dex */
            public static final class a extends MessageMicro {
                private boolean aqF;
                private boolean aqz;
                private boolean arV;
                private boolean asc;
                private boolean ase;
                private String arW = "";
                private String aqA = "";
                private String aqG = "";
                private List<Integer> asb = Collections.emptyList();
                private String asd = "";
                private String asf = "";
                private int aqI = -1;

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
                                fa(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                fb(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                fc(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                dm(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                fd(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                fe(codedInputStreamMicro.readString());
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
                    if (this.asb.isEmpty()) {
                        this.asb = new ArrayList();
                    }
                    this.asb.add(Integer.valueOf(i));
                    return this;
                }

                public a fa(String str) {
                    this.arV = true;
                    this.arW = str;
                    return this;
                }

                public a fb(String str) {
                    this.aqz = true;
                    this.aqA = str;
                    return this;
                }

                public a fc(String str) {
                    this.aqF = true;
                    this.aqG = str;
                    return this;
                }

                public a fd(String str) {
                    this.asc = true;
                    this.asd = str;
                    return this;
                }

                public a fe(String str) {
                    this.ase = true;
                    this.asf = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqI < 0) {
                        getSerializedSize();
                    }
                    return this.aqI;
                }

                public String getFloor() {
                    return this.asd;
                }

                public String getName() {
                    return this.aqA;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeStringSize = wX() ? CodedOutputStreamMicro.computeStringSize(1, wW()) + 0 : 0;
                    if (hasName()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    int computeStringSize2 = vL() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                    for (Integer num : xc()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize2 + i + (xc().size() * 1);
                    if (xd()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (xf()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, xe());
                    }
                    this.aqI = size;
                    return size;
                }

                public String getUid() {
                    return this.aqG;
                }

                public boolean hasName() {
                    return this.aqz;
                }

                public boolean vL() {
                    return this.aqF;
                }

                public String wW() {
                    return this.arW;
                }

                public boolean wX() {
                    return this.arV;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (wX()) {
                        codedOutputStreamMicro.writeString(1, wW());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (vL()) {
                        codedOutputStreamMicro.writeString(3, getUid());
                    }
                    for (Integer num : xc()) {
                        codedOutputStreamMicro.writeSInt32(4, num.intValue());
                    }
                    if (xd()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (xf()) {
                        codedOutputStreamMicro.writeString(6, xe());
                    }
                }

                public List<Integer> xc() {
                    return this.asb;
                }

                public boolean xd() {
                    return this.asc;
                }

                public String xe() {
                    return this.asf;
                }

                public boolean xf() {
                    return this.ase;
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return zb();
                }
                this.arF = true;
                this.aub = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.arH.isEmpty()) {
                        this.arH = new ArrayList();
                    }
                    this.arH.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return zc();
                }
                this.arv = true;
                this.arw = cVar;
                return this;
            }

            public e dl(int i) {
                this.atX = true;
                this.atY = i;
                return this;
            }

            public e eZ(String str) {
                this.atZ = true;
                this.aua = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getLabel() {
                return this.aua;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int computeInt32Size = yY() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, yX()) : 0;
                if (yZ()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, za());
                }
                Iterator<a> it = wH().iterator();
                while (true) {
                    i = computeInt32Size;
                    if (!it.hasNext()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
                }
                if (wr()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, ws());
                }
                this.aqI = i;
                return i;
            }

            public boolean hasStart() {
                return this.arF;
            }

            public List<a> wH() {
                return this.arH;
            }

            public boolean wr() {
                return this.arv;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yY()) {
                    codedOutputStreamMicro.writeInt32(1, yX());
                }
                if (yZ()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, za());
                }
                for (a aVar : wH()) {
                    codedOutputStreamMicro.writeMessage(4, aVar);
                }
                if (wr()) {
                    codedOutputStreamMicro.writeMessage(5, ws());
                }
            }

            public c ws() {
                return this.arw;
            }

            public int yX() {
                return this.atY;
            }

            public boolean yY() {
                return this.atX;
            }

            public boolean yZ() {
                return this.atZ;
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
                            eZ(codedInputStreamMicro.readString());
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

            public a za() {
                return this.aub;
            }

            public e zb() {
                this.arF = false;
                this.aub = null;
                return this;
            }

            public e zc() {
                this.arv = false;
                this.arw = null;
                return this;
            }
        }

        /* loaded from: classes7.dex */
        public static final class f extends MessageMicro {
            private boolean auc;
            private boolean aue;
            private String aud = "";
            private String auf = "";
            private int aqI = -1;

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
                            ff(codedInputStreamMicro.readString());
                            break;
                        case 18:
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

            public f ff(String str) {
                this.auc = true;
                this.aud = str;
                return this;
            }

            public f fg(String str) {
                this.aue = true;
                this.auf = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getContent() {
                return this.aud;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zd() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (zf()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, ze());
                }
                this.aqI = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (zd()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (zf()) {
                    codedOutputStreamMicro.writeString(2, ze());
                }
            }

            public boolean zd() {
                return this.auc;
            }

            public String ze() {
                return this.auf;
            }

            public boolean zf() {
                return this.aue;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return xl();
            }
            this.asi = true;
            this.asj = aVar;
            return this;
        }

        public b a(C0121b c0121b) {
            if (c0121b != null) {
                if (this.aqV.isEmpty()) {
                    this.aqV = new ArrayList();
                }
                this.aqV.add(c0121b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.asr.isEmpty()) {
                    this.asr = new ArrayList();
                }
                this.asr.add(cVar);
            }
            return this;
        }

        public b a(C0124d c0124d) {
            if (c0124d == null) {
                return xr();
            }
            this.asn = true;
            this.aso = c0124d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return xu();
            }
            this.asp = true;
            this.asq = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return xo();
            }
            this.ask = true;
            this.asl = fVar;
            return this;
        }

        public C0121b cp(int i) {
            return this.aqV.get(i);
        }

        public b eI(String str) {
            this.ass = true;
            this.ast = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqI < 0) {
                getSerializedSize();
            }
            return this.aqI;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int i2 = 0;
            Iterator<C0121b> it = vU().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
            }
            if (xj()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, xk());
            }
            if (xm()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, xn());
            }
            if (xp()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, xq());
            }
            if (xs()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, xt());
            }
            for (c cVar : xv()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, cVar);
            }
            if (xx()) {
                i += CodedOutputStreamMicro.computeStringSize(7, xw());
            }
            this.aqI = i;
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
                        C0121b c0121b = new C0121b();
                        codedInputStreamMicro.readMessage(c0121b);
                        a(c0121b);
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
                        C0124d c0124d = new C0124d();
                        codedInputStreamMicro.readMessage(c0124d);
                        a(c0124d);
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

        public List<C0121b> vU() {
            return this.aqV;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (C0121b c0121b : vU()) {
                codedOutputStreamMicro.writeMessage(1, c0121b);
            }
            if (xj()) {
                codedOutputStreamMicro.writeMessage(2, xk());
            }
            if (xm()) {
                codedOutputStreamMicro.writeMessage(3, xn());
            }
            if (xp()) {
                codedOutputStreamMicro.writeMessage(4, xq());
            }
            if (xs()) {
                codedOutputStreamMicro.writeMessage(5, xt());
            }
            for (c cVar : xv()) {
                codedOutputStreamMicro.writeMessage(6, cVar);
            }
            if (xx()) {
                codedOutputStreamMicro.writeString(7, xw());
            }
        }

        public int xi() {
            return this.aqV.size();
        }

        public boolean xj() {
            return this.asi;
        }

        public a xk() {
            return this.asj;
        }

        public b xl() {
            this.asi = false;
            this.asj = null;
            return this;
        }

        public boolean xm() {
            return this.ask;
        }

        public f xn() {
            return this.asl;
        }

        public b xo() {
            this.ask = false;
            this.asl = null;
            return this;
        }

        public boolean xp() {
            return this.asn;
        }

        public C0124d xq() {
            return this.aso;
        }

        public b xr() {
            this.asn = false;
            this.aso = null;
            return this;
        }

        public boolean xs() {
            return this.asp;
        }

        public e xt() {
            return this.asq;
        }

        public b xu() {
            this.asp = false;
            this.asq = null;
            return this;
        }

        public List<c> xv() {
            return this.asr;
        }

        public String xw() {
            return this.ast;
        }

        public boolean xx() {
            return this.ass;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends MessageMicro {
        private boolean aqR;
        private boolean aqT;
        private boolean aui;
        private String aug = "";
        private String auh = "";
        private String auj = "";
        private List<a> auk = Collections.emptyList();
        private int aqI = -1;

        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean aul;
            private boolean aun;
            private boolean aup;
            private boolean aur;
            private String aum = "";
            private String auo = "";
            private String auq = "";
            private String aus = "";
            private int aqI = -1;

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
                            fk(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fl(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            fm(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            fn(codedInputStreamMicro.readString());
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

            public a fk(String str) {
                this.aul = true;
                this.aum = str;
                return this;
            }

            public a fl(String str) {
                this.aun = true;
                this.auo = str;
                return this;
            }

            public a fm(String str) {
                this.aup = true;
                this.auq = str;
                return this;
            }

            public a fn(String str) {
                this.aur = true;
                this.aus = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqI < 0) {
                    getSerializedSize();
                }
                return this.aqI;
            }

            public String getDesc() {
                return this.aus;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zk() ? 0 + CodedOutputStreamMicro.computeStringSize(1, zj()) : 0;
                if (zm()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, zl());
                }
                if (zo()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, zn());
                }
                if (zp()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.aqI = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (zk()) {
                    codedOutputStreamMicro.writeString(1, zj());
                }
                if (zm()) {
                    codedOutputStreamMicro.writeString(2, zl());
                }
                if (zo()) {
                    codedOutputStreamMicro.writeString(3, zn());
                }
                if (zp()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public String zj() {
                return this.aum;
            }

            public boolean zk() {
                return this.aul;
            }

            public String zl() {
                return this.auo;
            }

            public boolean zm() {
                return this.aun;
            }

            public String zn() {
                return this.auq;
            }

            public boolean zo() {
                return this.aup;
            }

            public boolean zp() {
                return this.aur;
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
                        fh(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        fi(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fj(codedInputStreamMicro.readString());
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
                if (this.auk.isEmpty()) {
                    this.auk = new ArrayList();
                }
                this.auk.add(aVar);
            }
            return this;
        }

        public c fh(String str) {
            this.aqR = true;
            this.aug = str;
            return this;
        }

        public c fi(String str) {
            this.aqT = true;
            this.auh = str;
            return this;
        }

        public c fj(String str) {
            this.aui = true;
            this.auj = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqI < 0) {
                getSerializedSize();
            }
            return this.aqI;
        }

        public String getDistance() {
            return this.aug;
        }

        public String getDuration() {
            return this.auh;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = vT() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (zh()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, zg());
            }
            Iterator<a> it = zi().iterator();
            while (true) {
                int i = computeStringSize;
                if (!it.hasNext()) {
                    this.aqI = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.aqT;
        }

        public boolean vT() {
            return this.aqR;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vT()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (zh()) {
                codedOutputStreamMicro.writeString(3, zg());
            }
            for (a aVar : zi()) {
                codedOutputStreamMicro.writeMessage(4, aVar);
            }
        }

        public String zg() {
            return this.auj;
        }

        public boolean zh() {
            return this.aui;
        }

        public List<a> zi() {
            return this.auk;
        }
    }

    public d a(com.baidu.f.a.a aVar) {
        if (aVar == null) {
            return wy();
        }
        this.ary = true;
        this.arz = aVar;
        return this;
    }

    public d a(com.baidu.f.a.b bVar) {
        if (bVar != null) {
            if (this.arA.isEmpty()) {
                this.arA = new ArrayList();
            }
            this.arA.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return wv();
        }
        this.aqJ = true;
        this.arx = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.aqL.isEmpty()) {
                this.aqL = new ArrayList();
            }
            this.aqL.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return wt();
        }
        this.arv = true;
        this.arw = cVar;
        return this;
    }

    public b cc(int i) {
        return this.aqL.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqI < 0) {
            getSerializedSize();
        }
        return this.aqI;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        Iterator<b> it = vQ().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
        }
        if (wr()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, ws());
        }
        if (vN()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, wu());
        }
        if (ww()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, wx());
        }
        for (com.baidu.f.a.b bVar : wz()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, bVar);
        }
        this.aqI = i;
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

    public boolean vN() {
        return this.aqJ;
    }

    public List<b> vQ() {
        return this.aqL;
    }

    public int vR() {
        return this.aqL.size();
    }

    public int wA() {
        return this.arA.size();
    }

    public boolean wr() {
        return this.arv;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (b bVar : vQ()) {
            codedOutputStreamMicro.writeMessage(1, bVar);
        }
        if (wr()) {
            codedOutputStreamMicro.writeMessage(2, ws());
        }
        if (vN()) {
            codedOutputStreamMicro.writeMessage(3, wu());
        }
        if (ww()) {
            codedOutputStreamMicro.writeMessage(4, wx());
        }
        for (com.baidu.f.a.b bVar2 : wz()) {
            codedOutputStreamMicro.writeMessage(5, bVar2);
        }
    }

    public c ws() {
        return this.arw;
    }

    public d wt() {
        this.arv = false;
        this.arw = null;
        return this;
    }

    public a wu() {
        return this.arx;
    }

    public d wv() {
        this.aqJ = false;
        this.arx = null;
        return this;
    }

    public boolean ww() {
        return this.ary;
    }

    public com.baidu.f.a.a wx() {
        return this.arz;
    }

    public d wy() {
        this.ary = false;
        this.arz = null;
        return this;
    }

    public List<com.baidu.f.a.b> wz() {
        return this.arA;
    }
}
