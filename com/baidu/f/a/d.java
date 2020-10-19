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
    private boolean aqI;
    private boolean aru;
    private boolean arx;
    private c arv = null;
    private List<b> aqK = Collections.emptyList();
    private a arw = null;
    private com.baidu.f.a.a ary = null;
    private List<com.baidu.f.a.b> arz = Collections.emptyList();
    private int aqH = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqN;
        private boolean arA;
        private boolean arC;
        private boolean arE;
        private boolean arH;
        private boolean arJ;
        private boolean arM;
        private boolean arO;
        private boolean arQ;
        private boolean arS;
        private int aqO = 0;
        private String arB = "";
        private int arD = 0;
        private c arF = null;
        private List<C0119a> arG = Collections.emptyList();
        private int arI = 0;
        private C0120d arK = null;
        private List<b> arL = Collections.emptyList();
        private int arN = 0;
        private String arP = "";
        private int arR = 0;
        private String arT = "";
        private int aqH = -1;

        /* renamed from: com.baidu.f.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0119a extends MessageMicro {
            private boolean aqE;
            private boolean arU;
            private boolean arW;
            private boolean arY;
            private boolean asb;
            private boolean asd;
            private String arV = "";
            private String arX = "";
            private String aqF = "";
            private boolean arZ = false;
            private List<Integer> asa = Collections.emptyList();
            private String asc = "";
            private String ase = "";
            private int aqH = -1;

            public C0119a aU(boolean z) {
                this.arY = true;
                this.arZ = z;
                return this;
            }

            public int ck(int i) {
                return this.asa.get(i).intValue();
            }

            public C0119a cl(int i) {
                if (this.asa.isEmpty()) {
                    this.asa = new ArrayList();
                }
                this.asa.add(Integer.valueOf(i));
                return this;
            }

            public C0119a eA(String str) {
                this.asd = true;
                this.ase = str;
                return this;
            }

            public C0119a ev(String str) {
                this.arU = true;
                this.arV = str;
                return this;
            }

            public C0119a ew(String str) {
                this.arW = true;
                this.arX = str;
                return this;
            }

            public C0119a ey(String str) {
                this.aqE = true;
                this.aqF = str;
                return this;
            }

            public C0119a ez(String str) {
                this.asb = true;
                this.asc = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getFloor() {
                return this.asc;
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
                this.aqH = size;
                return size;
            }

            public String getUid() {
                return this.aqF;
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
                return this.aqE;
            }

            public String wW() {
                return this.arV;
            }

            public boolean wX() {
                return this.arU;
            }

            public String wY() {
                return this.arX;
            }

            public boolean wZ() {
                return this.arW;
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
                return this.arZ;
            }

            public boolean xb() {
                return this.arY;
            }

            public List<Integer> xc() {
                return this.asa;
            }

            public boolean xd() {
                return this.asb;
            }

            public String xe() {
                return this.ase;
            }

            public boolean xf() {
                return this.asd;
            }
        }

        /* loaded from: classes7.dex */
        public static final class b extends MessageMicro {
            private boolean aqt;
            private boolean asf;
            private int aqu = 0;
            private String asg = "";
            private int aqH = -1;

            public b cm(int i) {
                this.aqt = true;
                this.aqu = i;
                return this;
            }

            public b eB(String str) {
                this.asf = true;
                this.asg = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getCname() {
                return this.asg;
            }

            public int getCode() {
                return this.aqu;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vE() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (xg()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.aqH = computeInt32Size;
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
                return this.aqt;
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
                return this.asf;
            }
        }

        /* loaded from: classes7.dex */
        public static final class c extends MessageMicro {
            private boolean aqE;
            private boolean arU;
            private boolean arW;
            private boolean arY;
            private boolean asb;
            private boolean asd;
            private String arV = "";
            private String arX = "";
            private String aqF = "";
            private boolean arZ = false;
            private List<Integer> asa = Collections.emptyList();
            private String asc = "";
            private String ase = "";
            private int aqH = -1;

            public c aV(boolean z) {
                this.arY = true;
                this.arZ = z;
                return this;
            }

            public int ck(int i) {
                return this.asa.get(i).intValue();
            }

            public c cn(int i) {
                if (this.asa.isEmpty()) {
                    this.asa = new ArrayList();
                }
                this.asa.add(Integer.valueOf(i));
                return this;
            }

            public c eC(String str) {
                this.arU = true;
                this.arV = str;
                return this;
            }

            public c eD(String str) {
                this.arW = true;
                this.arX = str;
                return this;
            }

            public c eE(String str) {
                this.aqE = true;
                this.aqF = str;
                return this;
            }

            public c eF(String str) {
                this.asb = true;
                this.asc = str;
                return this;
            }

            public c eG(String str) {
                this.asd = true;
                this.ase = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getFloor() {
                return this.asc;
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
                this.aqH = size;
                return size;
            }

            public String getUid() {
                return this.aqF;
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
                return this.aqE;
            }

            public String wW() {
                return this.arV;
            }

            public boolean wX() {
                return this.arU;
            }

            public String wY() {
                return this.arX;
            }

            public boolean wZ() {
                return this.arW;
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
                return this.arZ;
            }

            public boolean xb() {
                return this.arY;
            }

            public List<Integer> xc() {
                return this.asa;
            }

            public boolean xd() {
                return this.asb;
            }

            public String xe() {
                return this.ase;
            }

            public boolean xf() {
                return this.asd;
            }

            public int xh() {
                return this.asa.size();
            }
        }

        /* renamed from: com.baidu.f.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0120d extends MessageMicro {
            private boolean aqt;
            private boolean asf;
            private int aqu = 0;
            private String asg = "";
            private int aqH = -1;

            public C0120d co(int i) {
                this.aqt = true;
                this.aqu = i;
                return this;
            }

            public C0120d eH(String str) {
                this.asf = true;
                this.asg = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getCname() {
                return this.asg;
            }

            public int getCode() {
                return this.aqu;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vE() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (xg()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.aqH = computeInt32Size;
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
                return this.aqt;
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
                return this.asf;
            }
        }

        public a a(C0119a c0119a) {
            if (c0119a != null) {
                if (this.arG.isEmpty()) {
                    this.arG = new ArrayList();
                }
                this.arG.add(c0119a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.arL.isEmpty()) {
                    this.arL = new ArrayList();
                }
                this.arL.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wG();
            }
            this.arE = true;
            this.arF = cVar;
            return this;
        }

        public a a(C0120d c0120d) {
            if (c0120d == null) {
                return wM();
            }
            this.arJ = true;
            this.arK = c0120d;
            return this;
        }

        public a cd(int i) {
            this.aqN = true;
            this.aqO = i;
            return this;
        }

        public a ce(int i) {
            this.arC = true;
            this.arD = i;
            return this;
        }

        public C0119a cf(int i) {
            return this.arG.get(i);
        }

        public a cg(int i) {
            this.arH = true;
            this.arI = i;
            return this;
        }

        public b ch(int i) {
            return this.arL.get(i);
        }

        public a ci(int i) {
            this.arM = true;
            this.arN = i;
            return this;
        }

        public a cj(int i) {
            this.arQ = true;
            this.arR = i;
            return this;
        }

        public a es(String str) {
            this.arA = true;
            this.arB = str;
            return this;
        }

        public a et(String str) {
            this.arO = true;
            this.arP = str;
            return this;
        }

        public a eu(String str) {
            this.arS = true;
            this.arT = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqH < 0) {
                getSerializedSize();
            }
            return this.aqH;
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
            this.aqH = i;
            return i;
        }

        public int getTotal() {
            return this.aqO;
        }

        public boolean hasStart() {
            return this.arE;
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
            return this.aqN;
        }

        public String wB() {
            return this.arB;
        }

        public boolean wC() {
            return this.arA;
        }

        public int wD() {
            return this.arD;
        }

        public boolean wE() {
            return this.arC;
        }

        public c wF() {
            return this.arF;
        }

        public a wG() {
            this.arE = false;
            this.arF = null;
            return this;
        }

        public List<C0119a> wH() {
            return this.arG;
        }

        public int wI() {
            return this.arI;
        }

        public boolean wJ() {
            return this.arH;
        }

        public boolean wK() {
            return this.arJ;
        }

        public C0120d wL() {
            return this.arK;
        }

        public a wM() {
            this.arJ = false;
            this.arK = null;
            return this;
        }

        public List<b> wN() {
            return this.arL;
        }

        public int wO() {
            return this.arN;
        }

        public boolean wP() {
            return this.arM;
        }

        public String wQ() {
            return this.arP;
        }

        public boolean wR() {
            return this.arO;
        }

        public int wS() {
            return this.arR;
        }

        public boolean wT() {
            return this.arQ;
        }

        public String wU() {
            return this.arT;
        }

        public boolean wV() {
            return this.arS;
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
        private boolean ash;
        private boolean asj;
        private boolean asl;
        private boolean aso;
        private boolean asr;
        private List<C0121b> aqU = Collections.emptyList();
        private a asi = null;
        private f ask = null;
        private C0124d asn = null;
        private e asp = null;
        private List<c> asq = Collections.emptyList();
        private String ass = "";
        private int aqH = -1;

        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean ast;
            private boolean asv;
            private boolean asx;
            private int asu = 0;
            private int asw = 0;
            private int asy = 0;
            private int aqH = -1;

            public a cq(int i) {
                this.ast = true;
                this.asu = i;
                return this;
            }

            public a cr(int i) {
                this.asv = true;
                this.asw = i;
                return this;
            }

            public a cs(int i) {
                this.asx = true;
                this.asy = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
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
                this.aqH = computeInt32Size;
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
                return this.asw;
            }

            public boolean xB() {
                return this.asv;
            }

            public int xC() {
                return this.asy;
            }

            public boolean xD() {
                return this.asx;
            }

            public int xy() {
                return this.asu;
            }

            public boolean xz() {
                return this.ast;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0121b extends MessageMicro {
            private boolean aqQ;
            private boolean aqS;
            private boolean asB;
            private boolean asD;
            private boolean asF;
            private boolean asH;
            private boolean asK;
            private boolean asz;
            private List<c> aqZ = Collections.emptyList();
            private List<Integer> aqX = Collections.emptyList();
            private List<Integer> aqY = Collections.emptyList();
            private String asA = "";
            private String asC = "";
            private int aqR = 0;
            private int aqT = 0;
            private int asE = 0;
            private int asG = 0;
            private int asI = 0;
            private List<a> asJ = Collections.emptyList();
            private C0122b asL = null;
            private int aqH = -1;

            /* renamed from: com.baidu.f.a.d$b$b$a */
            /* loaded from: classes7.dex */
            public static final class a extends MessageMicro {
                private boolean aqP;
                private boolean asM;
                private boolean asO;
                private boolean asb;
                private boolean asd;
                private int type_ = 0;
                private int asN = 0;
                private String asP = "";
                private List<Integer> ari = Collections.emptyList();
                private String asc = "";
                private String ase = "";
                private int aqH = -1;

                public a cB(int i) {
                    this.aqP = true;
                    this.type_ = i;
                    return this;
                }

                public a cC(int i) {
                    this.asM = true;
                    this.asN = i;
                    return this;
                }

                public a cD(int i) {
                    if (this.ari.isEmpty()) {
                        this.ari = new ArrayList();
                    }
                    this.ari.add(Integer.valueOf(i));
                    return this;
                }

                public a eL(String str) {
                    this.asO = true;
                    this.asP = str;
                    return this;
                }

                public a eM(String str) {
                    this.asb = true;
                    this.asc = str;
                    return this;
                }

                public a eN(String str) {
                    this.asd = true;
                    this.ase = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqH < 0) {
                        getSerializedSize();
                    }
                    return this.aqH;
                }

                public String getFloor() {
                    return this.asc;
                }

                public String getInfo() {
                    return this.asP;
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
                    this.aqH = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.aqP;
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
                    return this.ari;
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
                    return this.asN;
                }

                public boolean xU() {
                    return this.asM;
                }

                public boolean xV() {
                    return this.asO;
                }

                public boolean xd() {
                    return this.asb;
                }

                public String xe() {
                    return this.ase;
                }

                public boolean xf() {
                    return this.asd;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public static final class C0122b extends MessageMicro {
                private boolean asQ;
                private boolean hasNext;
                private int asR = 0;
                private int asS = 0;
                private int aqH = -1;

                public C0122b cE(int i) {
                    this.asQ = true;
                    this.asR = i;
                    return this;
                }

                public C0122b cF(int i) {
                    this.hasNext = true;
                    this.asS = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqH < 0) {
                        getSerializedSize();
                    }
                    return this.aqH;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xX() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xW()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xY());
                    }
                    this.aqH = computeInt32Size;
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
                    return this.asR;
                }

                public boolean xX() {
                    return this.asQ;
                }

                public int xY() {
                    return this.asS;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$c */
            /* loaded from: classes7.dex */
            public static final class c extends MessageMicro {
                private boolean aqP;
                private boolean aqQ;
                private boolean aqS;
                private boolean aqy;
                private boolean ara;
                private boolean asU;
                private boolean asW;
                private boolean asY;
                private boolean ata;
                private boolean atc;
                private boolean ate;
                private boolean atg;
                private boolean ati;
                private boolean atl;
                private boolean ato;
                private List<a> asT = Collections.emptyList();
                private List<C0123b> arf = Collections.emptyList();
                private List<Integer> are = Collections.emptyList();
                private String arb = "";
                private int type_ = 0;
                private String aqz = "";
                private int asV = 0;
                private int asX = 0;
                private int asZ = 0;
                private int atb = 0;
                private int atd = 0;
                private int atf = 0;
                private int aqR = 0;
                private int aqT = 0;
                private int ath = 0;
                private int atj = 0;
                private List<Integer> aqX = Collections.emptyList();
                private List<Integer> aqY = Collections.emptyList();
                private List<Integer> atk = Collections.emptyList();
                private int atm = 0;
                private List<Integer> atn = Collections.emptyList();
                private int atp = 0;
                private List<C0123b> atq = Collections.emptyList();
                private int aqH = -1;

                /* renamed from: com.baidu.f.a.d$b$b$c$a */
                /* loaded from: classes7.dex */
                public static final class a extends MessageMicro {
                    private boolean ars;
                    private boolean ati;
                    private boolean atr;
                    private boolean att;
                    private boolean atv;
                    private boolean atx;
                    private String ats = "";
                    private int atu = 0;
                    private int art = 0;
                    private int atj = 0;
                    private int atw = 0;
                    private int aty = 0;
                    private int aqH = -1;

                    public a cY(int i) {
                        this.att = true;
                        this.atu = i;
                        return this;
                    }

                    public a cZ(int i) {
                        this.ars = true;
                        this.art = i;
                        return this;
                    }

                    public a da(int i) {
                        this.ati = true;
                        this.atj = i;
                        return this;
                    }

                    public a db(int i) {
                        this.atv = true;
                        this.atw = i;
                        return this;
                    }

                    public a dc(int i) {
                        this.atx = true;
                        this.aty = i;
                        return this;
                    }

                    public a eQ(String str) {
                        this.atr = true;
                        this.ats = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqH < 0) {
                            getSerializedSize();
                        }
                        return this.aqH;
                    }

                    public String getId() {
                        return this.ats;
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
                        this.aqH = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.atr;
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
                        return this.art;
                    }

                    public boolean wq() {
                        return this.ars;
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
                        return this.aty;
                    }

                    public boolean yB() {
                        return this.atx;
                    }

                    public int yn() {
                        return this.atj;
                    }

                    public boolean yo() {
                        return this.ati;
                    }

                    public int yw() {
                        return this.atu;
                    }

                    public boolean yx() {
                        return this.att;
                    }

                    public int yy() {
                        return this.atw;
                    }

                    public boolean yz() {
                        return this.atv;
                    }
                }

                /* renamed from: com.baidu.f.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C0123b extends MessageMicro {
                    private boolean aqE;
                    private boolean aqy;
                    private boolean asD;
                    private boolean atA;
                    private boolean atC;
                    private boolean atE;
                    private boolean atH;
                    private boolean atJ;
                    private boolean atL;
                    private boolean atN;
                    private boolean atP;
                    private String aqz = "";
                    private List<Integer> atz = Collections.emptyList();
                    private int asE = 0;
                    private String atB = "";
                    private String atD = "";
                    private String atF = "";
                    private String aqF = "";
                    private List<Integer> atG = Collections.emptyList();
                    private String atI = "";
                    private String atK = "";
                    private String atM = "";
                    private int atO = 0;
                    private int atQ = 0;
                    private int aqH = -1;

                    public C0123b dd(int i) {
                        if (this.atz.isEmpty()) {
                            this.atz = new ArrayList();
                        }
                        this.atz.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0123b de(int i) {
                        this.asD = true;
                        this.asE = i;
                        return this;
                    }

                    public C0123b df(int i) {
                        if (this.atG.isEmpty()) {
                            this.atG = new ArrayList();
                        }
                        this.atG.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0123b dg(int i) {
                        this.atN = true;
                        this.atO = i;
                        return this;
                    }

                    public C0123b dh(int i) {
                        this.atP = true;
                        this.atQ = i;
                        return this;
                    }

                    public C0123b eR(String str) {
                        this.aqy = true;
                        this.aqz = str;
                        return this;
                    }

                    public C0123b eS(String str) {
                        this.atA = true;
                        this.atB = str;
                        return this;
                    }

                    public C0123b eT(String str) {
                        this.atC = true;
                        this.atD = str;
                        return this;
                    }

                    public C0123b eU(String str) {
                        this.atE = true;
                        this.atF = str;
                        return this;
                    }

                    public C0123b eV(String str) {
                        this.aqE = true;
                        this.aqF = str;
                        return this;
                    }

                    public C0123b eW(String str) {
                        this.atH = true;
                        this.atI = str;
                        return this;
                    }

                    public C0123b eX(String str) {
                        this.atJ = true;
                        this.atK = str;
                        return this;
                    }

                    public C0123b eY(String str) {
                        this.atL = true;
                        this.atM = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqH < 0) {
                            getSerializedSize();
                        }
                        return this.aqH;
                    }

                    public String getIconUrl() {
                        return this.atI;
                    }

                    public String getName() {
                        return this.aqz;
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
                        this.aqH = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.aqF;
                    }

                    public boolean hasName() {
                        return this.aqy;
                    }

                    public boolean vL() {
                        return this.aqE;
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
                        return this.asE;
                    }

                    public boolean xK() {
                        return this.asD;
                    }

                    public List<Integer> yC() {
                        return this.atz;
                    }

                    public String yD() {
                        return this.atB;
                    }

                    public boolean yE() {
                        return this.atA;
                    }

                    public String yF() {
                        return this.atD;
                    }

                    public boolean yG() {
                        return this.atC;
                    }

                    public String yH() {
                        return this.atF;
                    }

                    public boolean yI() {
                        return this.atE;
                    }

                    public List<Integer> yJ() {
                        return this.atG;
                    }

                    public boolean yK() {
                        return this.atH;
                    }

                    public String yL() {
                        return this.atK;
                    }

                    public boolean yM() {
                        return this.atJ;
                    }

                    public String yN() {
                        return this.atM;
                    }

                    public boolean yO() {
                        return this.atL;
                    }

                    public int yP() {
                        return this.atO;
                    }

                    public boolean yQ() {
                        return this.atN;
                    }

                    public int yR() {
                        return this.atQ;
                    }

                    public boolean yS() {
                        return this.atP;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.asT.isEmpty()) {
                            this.asT = new ArrayList();
                        }
                        this.asT.add(aVar);
                    }
                    return this;
                }

                public c a(C0123b c0123b) {
                    if (c0123b != null) {
                        if (this.arf.isEmpty()) {
                            this.arf = new ArrayList();
                        }
                        this.arf.add(c0123b);
                    }
                    return this;
                }

                public c b(C0123b c0123b) {
                    if (c0123b != null) {
                        if (this.atq.isEmpty()) {
                            this.atq = new ArrayList();
                        }
                        this.atq.add(c0123b);
                    }
                    return this;
                }

                public c cG(int i) {
                    if (this.are.isEmpty()) {
                        this.are = new ArrayList();
                    }
                    this.are.add(Integer.valueOf(i));
                    return this;
                }

                public c cH(int i) {
                    this.aqP = true;
                    this.type_ = i;
                    return this;
                }

                public c cI(int i) {
                    this.asU = true;
                    this.asV = i;
                    return this;
                }

                public c cJ(int i) {
                    this.asW = true;
                    this.asX = i;
                    return this;
                }

                public c cK(int i) {
                    this.asY = true;
                    this.asZ = i;
                    return this;
                }

                public c cL(int i) {
                    this.ata = true;
                    this.atb = i;
                    return this;
                }

                public c cM(int i) {
                    this.atc = true;
                    this.atd = i;
                    return this;
                }

                public c cN(int i) {
                    this.ate = true;
                    this.atf = i;
                    return this;
                }

                public c cO(int i) {
                    this.aqQ = true;
                    this.aqR = i;
                    return this;
                }

                public c cP(int i) {
                    this.aqS = true;
                    this.aqT = i;
                    return this;
                }

                public c cQ(int i) {
                    this.atg = true;
                    this.ath = i;
                    return this;
                }

                public c cR(int i) {
                    this.ati = true;
                    this.atj = i;
                    return this;
                }

                public c cS(int i) {
                    if (this.aqX.isEmpty()) {
                        this.aqX = new ArrayList();
                    }
                    this.aqX.add(Integer.valueOf(i));
                    return this;
                }

                public c cT(int i) {
                    if (this.aqY.isEmpty()) {
                        this.aqY = new ArrayList();
                    }
                    this.aqY.add(Integer.valueOf(i));
                    return this;
                }

                public c cU(int i) {
                    if (this.atk.isEmpty()) {
                        this.atk = new ArrayList();
                    }
                    this.atk.add(Integer.valueOf(i));
                    return this;
                }

                public c cV(int i) {
                    this.atl = true;
                    this.atm = i;
                    return this;
                }

                public c cW(int i) {
                    if (this.atn.isEmpty()) {
                        this.atn = new ArrayList();
                    }
                    this.atn.add(Integer.valueOf(i));
                    return this;
                }

                public c cX(int i) {
                    this.ato = true;
                    this.atp = i;
                    return this;
                }

                public c eO(String str) {
                    this.ara = true;
                    this.arb = str;
                    return this;
                }

                public c eP(String str) {
                    this.aqy = true;
                    this.aqz = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqH < 0) {
                        getSerializedSize();
                    }
                    return this.aqH;
                }

                public int getDirection() {
                    return this.ath;
                }

                public int getDistance() {
                    return this.aqR;
                }

                public int getDuration() {
                    return this.aqT;
                }

                public String getInstructions() {
                    return this.arb;
                }

                public String getName() {
                    return this.aqz;
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
                            this.aqH = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqS;
                }

                public boolean hasName() {
                    return this.aqy;
                }

                public boolean hasType() {
                    return this.aqP;
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
                    return this.aqQ;
                }

                public List<Integer> vX() {
                    return this.aqX;
                }

                public List<Integer> vY() {
                    return this.aqY;
                }

                public boolean wa() {
                    return this.ara;
                }

                public List<Integer> wd() {
                    return this.are;
                }

                public List<C0123b> we() {
                    return this.arf;
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
                    return this.asT;
                }

                public int ya() {
                    return this.asV;
                }

                public boolean yb() {
                    return this.asU;
                }

                public int yc() {
                    return this.asX;
                }

                public boolean yd() {
                    return this.asW;
                }

                public int ye() {
                    return this.asZ;
                }

                public boolean yf() {
                    return this.asY;
                }

                public int yg() {
                    return this.atb;
                }

                public boolean yh() {
                    return this.ata;
                }

                public int yi() {
                    return this.atd;
                }

                public boolean yj() {
                    return this.atc;
                }

                public int yk() {
                    return this.atf;
                }

                public boolean yl() {
                    return this.ate;
                }

                public boolean ym() {
                    return this.atg;
                }

                public int yn() {
                    return this.atj;
                }

                public boolean yo() {
                    return this.ati;
                }

                public List<Integer> yp() {
                    return this.atk;
                }

                public int yq() {
                    return this.atm;
                }

                public boolean yr() {
                    return this.atl;
                }

                public List<Integer> ys() {
                    return this.atn;
                }

                public int yt() {
                    return this.atp;
                }

                public boolean yu() {
                    return this.ato;
                }

                public List<C0123b> yv() {
                    return this.atq;
                }
            }

            public C0121b a(a aVar) {
                if (aVar != null) {
                    if (this.asJ.isEmpty()) {
                        this.asJ = new ArrayList();
                    }
                    this.asJ.add(aVar);
                }
                return this;
            }

            public C0121b a(C0122b c0122b) {
                if (c0122b == null) {
                    return xS();
                }
                this.asK = true;
                this.asL = c0122b;
                return this;
            }

            public C0121b a(c cVar) {
                if (cVar != null) {
                    if (this.aqZ.isEmpty()) {
                        this.aqZ = new ArrayList();
                    }
                    this.aqZ.add(cVar);
                }
                return this;
            }

            public C0121b cA(int i) {
                this.asH = true;
                this.asI = i;
                return this;
            }

            public c ct(int i) {
                return this.aqZ.get(i);
            }

            public C0121b cu(int i) {
                if (this.aqX.isEmpty()) {
                    this.aqX = new ArrayList();
                }
                this.aqX.add(Integer.valueOf(i));
                return this;
            }

            public C0121b cv(int i) {
                if (this.aqY.isEmpty()) {
                    this.aqY = new ArrayList();
                }
                this.aqY.add(Integer.valueOf(i));
                return this;
            }

            public C0121b cw(int i) {
                this.aqQ = true;
                this.aqR = i;
                return this;
            }

            public C0121b cx(int i) {
                this.aqS = true;
                this.aqT = i;
                return this;
            }

            public C0121b cy(int i) {
                this.asD = true;
                this.asE = i;
                return this;
            }

            public C0121b cz(int i) {
                this.asF = true;
                this.asG = i;
                return this;
            }

            public C0121b eJ(String str) {
                this.asz = true;
                this.asA = str;
                return this;
            }

            public C0121b eK(String str) {
                this.asB = true;
                this.asC = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public int getDistance() {
                return this.aqR;
            }

            public int getDuration() {
                return this.aqT;
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
                this.aqH = i;
                return i;
            }

            public boolean hasDuration() {
                return this.aqS;
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
                return this.aqQ;
            }

            public List<Integer> vX() {
                return this.aqX;
            }

            public List<Integer> vY() {
                return this.aqY;
            }

            public List<c> vZ() {
                return this.aqZ;
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
                return this.aqZ.size();
            }

            public String xF() {
                return this.asA;
            }

            public boolean xG() {
                return this.asz;
            }

            public String xH() {
                return this.asC;
            }

            public boolean xI() {
                return this.asB;
            }

            public int xJ() {
                return this.asE;
            }

            public boolean xK() {
                return this.asD;
            }

            public int xL() {
                return this.asG;
            }

            public boolean xM() {
                return this.asF;
            }

            public int xN() {
                return this.asI;
            }

            public boolean xO() {
                return this.asH;
            }

            public List<a> xP() {
                return this.asJ;
            }

            public boolean xQ() {
                return this.asK;
            }

            public C0122b xR() {
                return this.asL;
            }

            public C0121b xS() {
                this.asK = false;
                this.asL = null;
                return this;
            }
        }

        /* loaded from: classes7.dex */
        public static final class c extends MessageMicro {
            private boolean atR;
            private int atS = 0;
            private List<Integer> atT = Collections.emptyList();
            private int aqH = -1;

            public c di(int i) {
                this.atR = true;
                this.atS = i;
                return this;
            }

            public c dj(int i) {
                if (this.atT.isEmpty()) {
                    this.atT = new ArrayList();
                }
                this.atT.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yU() ? CodedOutputStreamMicro.computeInt32Size(1, yT()) + 0 : 0;
                for (Integer num : yV()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yV().size() * 1);
                this.aqH = size;
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
                return this.atS;
            }

            public boolean yU() {
                return this.atR;
            }

            public List<Integer> yV() {
                return this.atT;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0124d extends MessageMicro {
            private boolean atU;
            private int atV = 0;
            private int aqH = -1;

            public C0124d dk(int i) {
                this.atU = true;
                this.atV = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public int getLightNum() {
                return this.atV;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yW() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.aqH = computeInt32Size;
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
                return this.atU;
            }
        }

        /* loaded from: classes7.dex */
        public static final class e extends MessageMicro {
            private boolean arE;
            private boolean aru;
            private boolean atW;
            private boolean atY;
            private int atX = 0;
            private String atZ = "";
            private a aua = null;
            private List<a> arG = Collections.emptyList();
            private c arv = null;
            private int aqH = -1;

            /* loaded from: classes7.dex */
            public static final class a extends MessageMicro {
                private boolean aqE;
                private boolean aqy;
                private boolean arU;
                private boolean asb;
                private boolean asd;
                private String arV = "";
                private String aqz = "";
                private String aqF = "";
                private List<Integer> asa = Collections.emptyList();
                private String asc = "";
                private String ase = "";
                private int aqH = -1;

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
                    if (this.asa.isEmpty()) {
                        this.asa = new ArrayList();
                    }
                    this.asa.add(Integer.valueOf(i));
                    return this;
                }

                public a fa(String str) {
                    this.arU = true;
                    this.arV = str;
                    return this;
                }

                public a fb(String str) {
                    this.aqy = true;
                    this.aqz = str;
                    return this;
                }

                public a fc(String str) {
                    this.aqE = true;
                    this.aqF = str;
                    return this;
                }

                public a fd(String str) {
                    this.asb = true;
                    this.asc = str;
                    return this;
                }

                public a fe(String str) {
                    this.asd = true;
                    this.ase = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.aqH < 0) {
                        getSerializedSize();
                    }
                    return this.aqH;
                }

                public String getFloor() {
                    return this.asc;
                }

                public String getName() {
                    return this.aqz;
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
                    this.aqH = size;
                    return size;
                }

                public String getUid() {
                    return this.aqF;
                }

                public boolean hasName() {
                    return this.aqy;
                }

                public boolean vL() {
                    return this.aqE;
                }

                public String wW() {
                    return this.arV;
                }

                public boolean wX() {
                    return this.arU;
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
                    return this.asa;
                }

                public boolean xd() {
                    return this.asb;
                }

                public String xe() {
                    return this.ase;
                }

                public boolean xf() {
                    return this.asd;
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return zb();
                }
                this.arE = true;
                this.aua = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.arG.isEmpty()) {
                        this.arG = new ArrayList();
                    }
                    this.arG.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return zc();
                }
                this.aru = true;
                this.arv = cVar;
                return this;
            }

            public e dl(int i) {
                this.atW = true;
                this.atX = i;
                return this;
            }

            public e eZ(String str) {
                this.atY = true;
                this.atZ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getLabel() {
                return this.atZ;
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
                this.aqH = i;
                return i;
            }

            public boolean hasStart() {
                return this.arE;
            }

            public List<a> wH() {
                return this.arG;
            }

            public boolean wr() {
                return this.aru;
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
                return this.arv;
            }

            public int yX() {
                return this.atX;
            }

            public boolean yY() {
                return this.atW;
            }

            public boolean yZ() {
                return this.atY;
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
                return this.aua;
            }

            public e zb() {
                this.arE = false;
                this.aua = null;
                return this;
            }

            public e zc() {
                this.aru = false;
                this.arv = null;
                return this;
            }
        }

        /* loaded from: classes7.dex */
        public static final class f extends MessageMicro {
            private boolean aub;
            private boolean aud;
            private String auc = "";
            private String aue = "";
            private int aqH = -1;

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
                this.aub = true;
                this.auc = str;
                return this;
            }

            public f fg(String str) {
                this.aud = true;
                this.aue = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getContent() {
                return this.auc;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = zd() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (zf()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, ze());
                }
                this.aqH = computeStringSize;
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
                return this.aub;
            }

            public String ze() {
                return this.aue;
            }

            public boolean zf() {
                return this.aud;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return xl();
            }
            this.ash = true;
            this.asi = aVar;
            return this;
        }

        public b a(C0121b c0121b) {
            if (c0121b != null) {
                if (this.aqU.isEmpty()) {
                    this.aqU = new ArrayList();
                }
                this.aqU.add(c0121b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.asq.isEmpty()) {
                    this.asq = new ArrayList();
                }
                this.asq.add(cVar);
            }
            return this;
        }

        public b a(C0124d c0124d) {
            if (c0124d == null) {
                return xr();
            }
            this.asl = true;
            this.asn = c0124d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return xu();
            }
            this.aso = true;
            this.asp = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return xo();
            }
            this.asj = true;
            this.ask = fVar;
            return this;
        }

        public C0121b cp(int i) {
            return this.aqU.get(i);
        }

        public b eI(String str) {
            this.asr = true;
            this.ass = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqH < 0) {
                getSerializedSize();
            }
            return this.aqH;
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
            this.aqH = i;
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
            return this.aqU;
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
            return this.aqU.size();
        }

        public boolean xj() {
            return this.ash;
        }

        public a xk() {
            return this.asi;
        }

        public b xl() {
            this.ash = false;
            this.asi = null;
            return this;
        }

        public boolean xm() {
            return this.asj;
        }

        public f xn() {
            return this.ask;
        }

        public b xo() {
            this.asj = false;
            this.ask = null;
            return this;
        }

        public boolean xp() {
            return this.asl;
        }

        public C0124d xq() {
            return this.asn;
        }

        public b xr() {
            this.asl = false;
            this.asn = null;
            return this;
        }

        public boolean xs() {
            return this.aso;
        }

        public e xt() {
            return this.asp;
        }

        public b xu() {
            this.aso = false;
            this.asp = null;
            return this;
        }

        public List<c> xv() {
            return this.asq;
        }

        public String xw() {
            return this.ass;
        }

        public boolean xx() {
            return this.asr;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends MessageMicro {
        private boolean aqQ;
        private boolean aqS;
        private boolean auh;
        private String auf = "";
        private String aug = "";
        private String aui = "";
        private List<a> auj = Collections.emptyList();
        private int aqH = -1;

        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean auk;
            private boolean aum;
            private boolean auo;
            private boolean auq;
            private String aul = "";
            private String aun = "";
            private String aup = "";
            private String aur = "";
            private int aqH = -1;

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
                this.auk = true;
                this.aul = str;
                return this;
            }

            public a fl(String str) {
                this.aum = true;
                this.aun = str;
                return this;
            }

            public a fm(String str) {
                this.auo = true;
                this.aup = str;
                return this;
            }

            public a fn(String str) {
                this.auq = true;
                this.aur = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.aqH < 0) {
                    getSerializedSize();
                }
                return this.aqH;
            }

            public String getDesc() {
                return this.aur;
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
                this.aqH = computeStringSize;
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
                return this.aul;
            }

            public boolean zk() {
                return this.auk;
            }

            public String zl() {
                return this.aun;
            }

            public boolean zm() {
                return this.aum;
            }

            public String zn() {
                return this.aup;
            }

            public boolean zo() {
                return this.auo;
            }

            public boolean zp() {
                return this.auq;
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
                if (this.auj.isEmpty()) {
                    this.auj = new ArrayList();
                }
                this.auj.add(aVar);
            }
            return this;
        }

        public c fh(String str) {
            this.aqQ = true;
            this.auf = str;
            return this;
        }

        public c fi(String str) {
            this.aqS = true;
            this.aug = str;
            return this;
        }

        public c fj(String str) {
            this.auh = true;
            this.aui = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqH < 0) {
                getSerializedSize();
            }
            return this.aqH;
        }

        public String getDistance() {
            return this.auf;
        }

        public String getDuration() {
            return this.aug;
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
                    this.aqH = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.aqS;
        }

        public boolean vT() {
            return this.aqQ;
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
            return this.aui;
        }

        public boolean zh() {
            return this.auh;
        }

        public List<a> zi() {
            return this.auj;
        }
    }

    public d a(com.baidu.f.a.a aVar) {
        if (aVar == null) {
            return wy();
        }
        this.arx = true;
        this.ary = aVar;
        return this;
    }

    public d a(com.baidu.f.a.b bVar) {
        if (bVar != null) {
            if (this.arz.isEmpty()) {
                this.arz = new ArrayList();
            }
            this.arz.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return wv();
        }
        this.aqI = true;
        this.arw = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.aqK.isEmpty()) {
                this.aqK = new ArrayList();
            }
            this.aqK.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return wt();
        }
        this.aru = true;
        this.arv = cVar;
        return this;
    }

    public b cc(int i) {
        return this.aqK.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqH < 0) {
            getSerializedSize();
        }
        return this.aqH;
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
        this.aqH = i;
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
        return this.aqI;
    }

    public List<b> vQ() {
        return this.aqK;
    }

    public int vR() {
        return this.aqK.size();
    }

    public int wA() {
        return this.arz.size();
    }

    public boolean wr() {
        return this.aru;
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
        return this.arv;
    }

    public d wt() {
        this.aru = false;
        this.arv = null;
        return this;
    }

    public a wu() {
        return this.arw;
    }

    public d wv() {
        this.aqI = false;
        this.arw = null;
        return this;
    }

    public boolean ww() {
        return this.arx;
    }

    public com.baidu.f.a.a wx() {
        return this.ary;
    }

    public d wy() {
        this.arx = false;
        this.ary = null;
        return this;
    }

    public List<com.baidu.f.a.b> wz() {
        return this.arz;
    }
}
