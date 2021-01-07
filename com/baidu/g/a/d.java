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
/* loaded from: classes3.dex */
public final class d extends MessageMicro {
    private boolean asW;
    private boolean asZ;
    private boolean asj;
    private c asX = null;
    private List<b> asl = Collections.emptyList();
    private a asY = null;
    private com.baidu.g.a.a ata = null;
    private List<com.baidu.g.a.b> atb = Collections.emptyList();
    private int asi = -1;

    /* loaded from: classes3.dex */
    public static final class a extends MessageMicro {
        private boolean asp;
        private boolean atc;
        private boolean ate;
        private boolean atg;
        private boolean atj;
        private boolean atl;
        private boolean ato;
        private boolean atq;
        private boolean ats;
        private boolean atu;
        private int asq = 0;
        private String atd = "";
        private int atf = 0;
        private c ath = null;
        private List<C0120a> ati = Collections.emptyList();
        private int atk = 0;
        private C0121d atm = null;
        private List<b> atn = Collections.emptyList();
        private int atp = 0;
        private String atr = "";
        private int att = 0;
        private String atv = "";
        private int asi = -1;

        /* renamed from: com.baidu.g.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0120a extends MessageMicro {
            private boolean asf;
            private boolean atA;
            private boolean atD;
            private boolean atF;
            private boolean atw;
            private boolean aty;
            private String atx = "";
            private String atz = "";
            private String asg = "";
            private boolean atB = false;
            private List<Integer> atC = Collections.emptyList();
            private String atE = "";
            private String atG = "";
            private int asi = -1;

            public C0120a aT(boolean z) {
                this.atA = true;
                this.atB = z;
                return this;
            }

            public int cm(int i) {
                return this.atC.get(i).intValue();
            }

            public C0120a cn(int i) {
                if (this.atC.isEmpty()) {
                    this.atC = new ArrayList();
                }
                this.atC.add(Integer.valueOf(i));
                return this;
            }

            public C0120a em(String str) {
                this.atw = true;
                this.atx = str;
                return this;
            }

            public C0120a en(String str) {
                this.aty = true;
                this.atz = str;
                return this;
            }

            public C0120a eo(String str) {
                this.asf = true;
                this.asg = str;
                return this;
            }

            public C0120a ep(String str) {
                this.atD = true;
                this.atE = str;
                return this;
            }

            public C0120a eq(String str) {
                this.atF = true;
                this.atG = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getFloor() {
                return this.atE;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wf() ? CodedOutputStreamMicro.computeStringSize(1, we()) + 0 : 0;
                if (wh()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wg());
                }
                if (uT()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = wj() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wi()) : computeStringSize;
                for (Integer num : wk()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (wk().size() * 1);
                if (wl()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (wn()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, wm());
                }
                this.asi = size;
                return size;
            }

            public String getUid() {
                return this.asg;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: l */
            public C0120a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            em(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            en(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eo(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aT(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cn(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            ep(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            eq(codedInputStreamMicro.readString());
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

            public boolean uT() {
                return this.asf;
            }

            public String we() {
                return this.atx;
            }

            public boolean wf() {
                return this.atw;
            }

            public String wg() {
                return this.atz;
            }

            public boolean wh() {
                return this.aty;
            }

            public boolean wi() {
                return this.atB;
            }

            public boolean wj() {
                return this.atA;
            }

            public List<Integer> wk() {
                return this.atC;
            }

            public boolean wl() {
                return this.atD;
            }

            public String wm() {
                return this.atG;
            }

            public boolean wn() {
                return this.atF;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wf()) {
                    codedOutputStreamMicro.writeString(1, we());
                }
                if (wh()) {
                    codedOutputStreamMicro.writeString(2, wg());
                }
                if (uT()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (wj()) {
                    codedOutputStreamMicro.writeBool(4, wi());
                }
                for (Integer num : wk()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (wl()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (wn()) {
                    codedOutputStreamMicro.writeString(7, wm());
                }
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends MessageMicro {
            private boolean arU;
            private boolean atH;
            private int arV = 0;
            private String atI = "";
            private int asi = -1;

            public b co(int i) {
                this.arU = true;
                this.arV = i;
                return this;
            }

            public b er(String str) {
                this.atH = true;
                this.atI = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getCname() {
                return this.atI;
            }

            public int getCode() {
                return this.arV;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = uM() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wo()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.asi = computeInt32Size;
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
                            er(codedInputStreamMicro.readString());
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

            public boolean uM() {
                return this.arU;
            }

            public boolean wo() {
                return this.atH;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (uM()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wo()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends MessageMicro {
            private boolean asf;
            private boolean atA;
            private boolean atD;
            private boolean atF;
            private boolean atw;
            private boolean aty;
            private String atx = "";
            private String atz = "";
            private String asg = "";
            private boolean atB = false;
            private List<Integer> atC = Collections.emptyList();
            private String atE = "";
            private String atG = "";
            private int asi = -1;

            public c aU(boolean z) {
                this.atA = true;
                this.atB = z;
                return this;
            }

            public int cm(int i) {
                return this.atC.get(i).intValue();
            }

            public c cp(int i) {
                if (this.atC.isEmpty()) {
                    this.atC = new ArrayList();
                }
                this.atC.add(Integer.valueOf(i));
                return this;
            }

            public c es(String str) {
                this.atw = true;
                this.atx = str;
                return this;
            }

            public c et(String str) {
                this.aty = true;
                this.atz = str;
                return this;
            }

            public c eu(String str) {
                this.asf = true;
                this.asg = str;
                return this;
            }

            public c ev(String str) {
                this.atD = true;
                this.atE = str;
                return this;
            }

            public c ew(String str) {
                this.atF = true;
                this.atG = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getFloor() {
                return this.atE;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wf() ? CodedOutputStreamMicro.computeStringSize(1, we()) + 0 : 0;
                if (wh()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wg());
                }
                if (uT()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = wj() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wi()) : computeStringSize;
                for (Integer num : wk()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (wk().size() * 1);
                if (wl()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (wn()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, wm());
                }
                this.asi = size;
                return size;
            }

            public String getUid() {
                return this.asg;
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
                            es(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            et(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eu(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aU(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cp(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            ev(codedInputStreamMicro.readString());
                            break;
                        case 58:
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

            public boolean uT() {
                return this.asf;
            }

            public String we() {
                return this.atx;
            }

            public boolean wf() {
                return this.atw;
            }

            public String wg() {
                return this.atz;
            }

            public boolean wh() {
                return this.aty;
            }

            public boolean wi() {
                return this.atB;
            }

            public boolean wj() {
                return this.atA;
            }

            public List<Integer> wk() {
                return this.atC;
            }

            public boolean wl() {
                return this.atD;
            }

            public String wm() {
                return this.atG;
            }

            public boolean wn() {
                return this.atF;
            }

            public int wp() {
                return this.atC.size();
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wf()) {
                    codedOutputStreamMicro.writeString(1, we());
                }
                if (wh()) {
                    codedOutputStreamMicro.writeString(2, wg());
                }
                if (uT()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (wj()) {
                    codedOutputStreamMicro.writeBool(4, wi());
                }
                for (Integer num : wk()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (wl()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (wn()) {
                    codedOutputStreamMicro.writeString(7, wm());
                }
            }
        }

        /* renamed from: com.baidu.g.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0121d extends MessageMicro {
            private boolean arU;
            private boolean atH;
            private int arV = 0;
            private String atI = "";
            private int asi = -1;

            public C0121d cq(int i) {
                this.arU = true;
                this.arV = i;
                return this;
            }

            public C0121d ey(String str) {
                this.atH = true;
                this.atI = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getCname() {
                return this.atI;
            }

            public int getCode() {
                return this.arV;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = uM() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wo()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.asi = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: o */
            public C0121d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cq(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            ey(codedInputStreamMicro.readString());
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

            public boolean uM() {
                return this.arU;
            }

            public boolean wo() {
                return this.atH;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (uM()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wo()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public a a(C0120a c0120a) {
            if (c0120a != null) {
                if (this.ati.isEmpty()) {
                    this.ati = new ArrayList();
                }
                this.ati.add(c0120a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.atn.isEmpty()) {
                    this.atn = new ArrayList();
                }
                this.atn.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return vO();
            }
            this.atg = true;
            this.ath = cVar;
            return this;
        }

        public a a(C0121d c0121d) {
            if (c0121d == null) {
                return vU();
            }
            this.atl = true;
            this.atm = c0121d;
            return this;
        }

        public a cf(int i) {
            this.asp = true;
            this.asq = i;
            return this;
        }

        public a cg(int i) {
            this.ate = true;
            this.atf = i;
            return this;
        }

        public C0120a ch(int i) {
            return this.ati.get(i);
        }

        public a ci(int i) {
            this.atj = true;
            this.atk = i;
            return this;
        }

        public b cj(int i) {
            return this.atn.get(i);
        }

        public a ck(int i) {
            this.ato = true;
            this.atp = i;
            return this;
        }

        public a cl(int i) {
            this.ats = true;
            this.att = i;
            return this;
        }

        public a ej(String str) {
            this.atc = true;
            this.atd = str;
            return this;
        }

        public a ek(String str) {
            this.atq = true;
            this.atr = str;
            return this;
        }

        public a el(String str) {
            this.atu = true;
            this.atv = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.asi < 0) {
                getSerializedSize();
            }
            return this.asi;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int computeInt32Size = va() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (vK()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, vJ());
            }
            if (vM()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, vL());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, vN());
            }
            Iterator<C0120a> it = vP().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
            }
            if (vR()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, vQ());
            }
            if (vS()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, vT());
            }
            for (b bVar : vV()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, bVar);
            }
            if (vX()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, vW());
            }
            if (vZ()) {
                i += CodedOutputStreamMicro.computeStringSize(10, vY());
            }
            if (wb()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, wa());
            }
            if (wd()) {
                i += CodedOutputStreamMicro.computeStringSize(12, wc());
            }
            this.asi = i;
            return i;
        }

        public int getTotal() {
            return this.asq;
        }

        public boolean hasStart() {
            return this.atg;
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
                        ej(codedInputStreamMicro.readString());
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
                        C0120a c0120a = new C0120a();
                        codedInputStreamMicro.readMessage(c0120a);
                        a(c0120a);
                        break;
                    case 48:
                        ci(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        C0121d c0121d = new C0121d();
                        codedInputStreamMicro.readMessage(c0121d);
                        a(c0121d);
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
                        ek(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        cl(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
                        el(codedInputStreamMicro.readString());
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

        public String vJ() {
            return this.atd;
        }

        public boolean vK() {
            return this.atc;
        }

        public int vL() {
            return this.atf;
        }

        public boolean vM() {
            return this.ate;
        }

        public c vN() {
            return this.ath;
        }

        public a vO() {
            this.atg = false;
            this.ath = null;
            return this;
        }

        public List<C0120a> vP() {
            return this.ati;
        }

        public int vQ() {
            return this.atk;
        }

        public boolean vR() {
            return this.atj;
        }

        public boolean vS() {
            return this.atl;
        }

        public C0121d vT() {
            return this.atm;
        }

        public a vU() {
            this.atl = false;
            this.atm = null;
            return this;
        }

        public List<b> vV() {
            return this.atn;
        }

        public int vW() {
            return this.atp;
        }

        public boolean vX() {
            return this.ato;
        }

        public String vY() {
            return this.atr;
        }

        public boolean vZ() {
            return this.atq;
        }

        public boolean va() {
            return this.asp;
        }

        public int wa() {
            return this.att;
        }

        public boolean wb() {
            return this.ats;
        }

        public String wc() {
            return this.atv;
        }

        public boolean wd() {
            return this.atu;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (va()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (vK()) {
                codedOutputStreamMicro.writeString(2, vJ());
            }
            if (vM()) {
                codedOutputStreamMicro.writeInt32(3, vL());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, vN());
            }
            for (C0120a c0120a : vP()) {
                codedOutputStreamMicro.writeMessage(5, c0120a);
            }
            if (vR()) {
                codedOutputStreamMicro.writeInt32(6, vQ());
            }
            if (vS()) {
                codedOutputStreamMicro.writeMessage(7, vT());
            }
            for (b bVar : vV()) {
                codedOutputStreamMicro.writeMessage(8, bVar);
            }
            if (vX()) {
                codedOutputStreamMicro.writeInt32(9, vW());
            }
            if (vZ()) {
                codedOutputStreamMicro.writeString(10, vY());
            }
            if (wb()) {
                codedOutputStreamMicro.writeInt32(11, wa());
            }
            if (wd()) {
                codedOutputStreamMicro.writeString(12, wc());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends MessageMicro {
        private boolean atJ;
        private boolean atL;
        private boolean atN;
        private boolean atP;
        private boolean atS;
        private List<C0122b> asw = Collections.emptyList();
        private a atK = null;
        private f atM = null;
        private C0125d atO = null;
        private e atQ = null;
        private List<c> atR = Collections.emptyList();
        private String atT = "";
        private int asi = -1;

        /* loaded from: classes3.dex */
        public static final class a extends MessageMicro {
            private boolean atU;
            private boolean atW;
            private boolean atY;
            private int atV = 0;
            private int atX = 0;
            private int atZ = 0;
            private int asi = -1;

            public a cs(int i) {
                this.atU = true;
                this.atV = i;
                return this;
            }

            public a ct(int i) {
                this.atW = true;
                this.atX = i;
                return this;
            }

            public a cu(int i) {
                this.atY = true;
                this.atZ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = wH() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, wG()) : 0;
                if (wJ()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, wI());
                }
                if (wL()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, wK());
                }
                this.asi = computeInt32Size;
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

            public int wG() {
                return this.atV;
            }

            public boolean wH() {
                return this.atU;
            }

            public int wI() {
                return this.atX;
            }

            public boolean wJ() {
                return this.atW;
            }

            public int wK() {
                return this.atZ;
            }

            public boolean wL() {
                return this.atY;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wH()) {
                    codedOutputStreamMicro.writeInt32(1, wG());
                }
                if (wJ()) {
                    codedOutputStreamMicro.writeInt32(2, wI());
                }
                if (wL()) {
                    codedOutputStreamMicro.writeInt32(3, wK());
                }
            }
        }

        /* renamed from: com.baidu.g.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0122b extends MessageMicro {
            private boolean ass;
            private boolean asu;
            private boolean aua;
            private boolean auc;
            private boolean aue;
            private boolean aug;
            private boolean aui;
            private boolean aul;
            private List<c> asB = Collections.emptyList();
            private List<Integer> asz = Collections.emptyList();
            private List<Integer> asA = Collections.emptyList();
            private String aub = "";
            private String aud = "";
            private int ast = 0;
            private int asv = 0;
            private int auf = 0;
            private int auh = 0;
            private int auj = 0;
            private List<a> auk = Collections.emptyList();
            private C0123b aum = null;
            private int asi = -1;

            /* renamed from: com.baidu.g.a.d$b$b$a */
            /* loaded from: classes3.dex */
            public static final class a extends MessageMicro {
                private boolean asr;
                private boolean atD;
                private boolean atF;
                private boolean aun;
                private boolean aup;
                private int type_ = 0;
                private int auo = 0;
                private String auq = "";
                private List<Integer> asK = Collections.emptyList();
                private String atE = "";
                private String atG = "";
                private int asi = -1;

                public a cD(int i) {
                    this.asr = true;
                    this.type_ = i;
                    return this;
                }

                public a cE(int i) {
                    this.aun = true;
                    this.auo = i;
                    return this;
                }

                public a cF(int i) {
                    if (this.asK.isEmpty()) {
                        this.asK = new ArrayList();
                    }
                    this.asK.add(Integer.valueOf(i));
                    return this;
                }

                public a eC(String str) {
                    this.aup = true;
                    this.auq = str;
                    return this;
                }

                public a eD(String str) {
                    this.atD = true;
                    this.atE = str;
                    return this;
                }

                public a eE(String str) {
                    this.atF = true;
                    this.atG = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.asi < 0) {
                        getSerializedSize();
                    }
                    return this.asi;
                }

                public String getFloor() {
                    return this.atE;
                }

                public String getInfo() {
                    return this.auq;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (xc()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xb());
                    }
                    int computeStringSize = xd() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
                    for (Integer num : vp()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize + i + (vp().size() * 1);
                    if (wl()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (wn()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, wm());
                    }
                    this.asi = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.asr;
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
                                eC(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cF(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eD(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eE(codedInputStreamMicro.readString());
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

                public List<Integer> vp() {
                    return this.asK;
                }

                public boolean wl() {
                    return this.atD;
                }

                public String wm() {
                    return this.atG;
                }

                public boolean wn() {
                    return this.atF;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (xc()) {
                        codedOutputStreamMicro.writeInt32(2, xb());
                    }
                    if (xd()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    for (Integer num : vp()) {
                        codedOutputStreamMicro.writeInt32(4, num.intValue());
                    }
                    if (wl()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (wn()) {
                        codedOutputStreamMicro.writeString(6, wm());
                    }
                }

                public int xb() {
                    return this.auo;
                }

                public boolean xc() {
                    return this.aun;
                }

                public boolean xd() {
                    return this.aup;
                }
            }

            /* renamed from: com.baidu.g.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0123b extends MessageMicro {
                private boolean aur;
                private boolean hasNext;
                private int aus = 0;
                private int aut = 0;
                private int asi = -1;

                public C0123b cG(int i) {
                    this.aur = true;
                    this.aus = i;
                    return this;
                }

                public C0123b cH(int i) {
                    this.hasNext = true;
                    this.aut = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.asi < 0) {
                        getSerializedSize();
                    }
                    return this.asi;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xf() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xe()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xg());
                    }
                    this.asi = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: t */
                public C0123b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    if (xf()) {
                        codedOutputStreamMicro.writeInt32(1, xe());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, xg());
                    }
                }

                public int xe() {
                    return this.aus;
                }

                public boolean xf() {
                    return this.aur;
                }

                public int xg() {
                    return this.aut;
                }
            }

            /* renamed from: com.baidu.g.a.d$b$b$c */
            /* loaded from: classes3.dex */
            public static final class c extends MessageMicro {
                private boolean arZ;
                private boolean asC;
                private boolean asr;
                private boolean ass;
                private boolean asu;
                private boolean auB;
                private boolean auD;
                private boolean auF;
                private boolean auH;
                private boolean auJ;
                private boolean auM;
                private boolean auP;
                private boolean auv;
                private boolean aux;
                private boolean auz;
                private List<a> auu = Collections.emptyList();
                private List<C0124b> asH = Collections.emptyList();
                private List<Integer> asG = Collections.emptyList();
                private String asD = "";
                private int type_ = 0;
                private String asa = "";
                private int auw = 0;
                private int auy = 0;
                private int auA = 0;
                private int auC = 0;
                private int auE = 0;
                private int auG = 0;
                private int ast = 0;
                private int asv = 0;
                private int auI = 0;
                private int auK = 0;
                private List<Integer> asz = Collections.emptyList();
                private List<Integer> asA = Collections.emptyList();
                private List<Integer> auL = Collections.emptyList();
                private int auN = 0;
                private List<Integer> auO = Collections.emptyList();
                private int auQ = 0;
                private List<C0124b> auR = Collections.emptyList();
                private int asi = -1;

                /* renamed from: com.baidu.g.a.d$b$b$c$a */
                /* loaded from: classes3.dex */
                public static final class a extends MessageMicro {
                    private boolean asU;
                    private boolean auJ;
                    private boolean auS;
                    private boolean auU;
                    private boolean auW;
                    private boolean auY;
                    private String auT = "";
                    private int auV = 0;
                    private int asV = 0;
                    private int auK = 0;
                    private int auX = 0;
                    private int auZ = 0;
                    private int asi = -1;

                    public a da(int i) {
                        this.auU = true;
                        this.auV = i;
                        return this;
                    }

                    public a db(int i) {
                        this.asU = true;
                        this.asV = i;
                        return this;
                    }

                    public a dc(int i) {
                        this.auJ = true;
                        this.auK = i;
                        return this;
                    }

                    public a dd(int i) {
                        this.auW = true;
                        this.auX = i;
                        return this;
                    }

                    public a de(int i) {
                        this.auY = true;
                        this.auZ = i;
                        return this;
                    }

                    public a eH(String str) {
                        this.auS = true;
                        this.auT = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.asi < 0) {
                            getSerializedSize();
                        }
                        return this.asi;
                    }

                    public String getId() {
                        return this.auT;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (xF()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, xE());
                        }
                        if (vy()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, vx());
                        }
                        if (xw()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, xv());
                        }
                        if (xH()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, xG());
                        }
                        if (xJ()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, xI());
                        }
                        this.asi = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.auS;
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
                                    eH(codedInputStreamMicro.readString());
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

                    public int vx() {
                        return this.asV;
                    }

                    public boolean vy() {
                        return this.asU;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (xF()) {
                            codedOutputStreamMicro.writeInt32(2, xE());
                        }
                        if (vy()) {
                            codedOutputStreamMicro.writeInt32(3, vx());
                        }
                        if (xw()) {
                            codedOutputStreamMicro.writeInt32(4, xv());
                        }
                        if (xH()) {
                            codedOutputStreamMicro.writeInt32(5, xG());
                        }
                        if (xJ()) {
                            codedOutputStreamMicro.writeInt32(6, xI());
                        }
                    }

                    public int xE() {
                        return this.auV;
                    }

                    public boolean xF() {
                        return this.auU;
                    }

                    public int xG() {
                        return this.auX;
                    }

                    public boolean xH() {
                        return this.auW;
                    }

                    public int xI() {
                        return this.auZ;
                    }

                    public boolean xJ() {
                        return this.auY;
                    }

                    public int xv() {
                        return this.auK;
                    }

                    public boolean xw() {
                        return this.auJ;
                    }
                }

                /* renamed from: com.baidu.g.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C0124b extends MessageMicro {
                    private boolean arZ;
                    private boolean asf;
                    private boolean aue;
                    private boolean avb;
                    private boolean avd;
                    private boolean avf;
                    private boolean avi;
                    private boolean avk;
                    private boolean avm;
                    private boolean avo;
                    private boolean avq;
                    private String asa = "";
                    private List<Integer> ava = Collections.emptyList();
                    private int auf = 0;
                    private String avc = "";
                    private String ave = "";
                    private String avg = "";
                    private String asg = "";
                    private List<Integer> avh = Collections.emptyList();
                    private String avj = "";
                    private String avl = "";
                    private String avn = "";
                    private int avp = 0;
                    private int avr = 0;
                    private int asi = -1;

                    public C0124b df(int i) {
                        if (this.ava.isEmpty()) {
                            this.ava = new ArrayList();
                        }
                        this.ava.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0124b dg(int i) {
                        this.aue = true;
                        this.auf = i;
                        return this;
                    }

                    public C0124b dh(int i) {
                        if (this.avh.isEmpty()) {
                            this.avh = new ArrayList();
                        }
                        this.avh.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0124b di(int i) {
                        this.avo = true;
                        this.avp = i;
                        return this;
                    }

                    public C0124b dj(int i) {
                        this.avq = true;
                        this.avr = i;
                        return this;
                    }

                    public C0124b eI(String str) {
                        this.arZ = true;
                        this.asa = str;
                        return this;
                    }

                    public C0124b eJ(String str) {
                        this.avb = true;
                        this.avc = str;
                        return this;
                    }

                    public C0124b eK(String str) {
                        this.avd = true;
                        this.ave = str;
                        return this;
                    }

                    public C0124b eL(String str) {
                        this.avf = true;
                        this.avg = str;
                        return this;
                    }

                    public C0124b eM(String str) {
                        this.asf = true;
                        this.asg = str;
                        return this;
                    }

                    public C0124b eN(String str) {
                        this.avi = true;
                        this.avj = str;
                        return this;
                    }

                    public C0124b eO(String str) {
                        this.avk = true;
                        this.avl = str;
                        return this;
                    }

                    public C0124b eP(String str) {
                        this.avm = true;
                        this.avn = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.asi < 0) {
                            getSerializedSize();
                        }
                        return this.asi;
                    }

                    public String getIconUrl() {
                        return this.avj;
                    }

                    public String getName() {
                        return this.asa;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        int i2 = 0;
                        for (Integer num : xK()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i2;
                        }
                        int size = computeStringSize + i2 + (xK().size() * 1);
                        if (wS()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, wR());
                        }
                        if (xM()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, xL());
                        }
                        if (xO()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, xN());
                        }
                        if (xQ()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, xP());
                        }
                        int computeStringSize2 = uT() ? size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : size;
                        for (Integer num2 : xR()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                        }
                        int size2 = computeStringSize2 + i + (xR().size() * 1);
                        if (xS()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (xU()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, xT());
                        }
                        if (xW()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, xV());
                        }
                        if (xY()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, xX());
                        }
                        if (ya()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, xZ());
                        }
                        this.asi = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.asg;
                    }

                    public boolean hasName() {
                        return this.arZ;
                    }

                    public boolean uT() {
                        return this.asf;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: w */
                    public C0124b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eI(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    df(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    dg(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eJ(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eK(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    eL(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    eM(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    dh(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    eN(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    eO(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    eP(codedInputStreamMicro.readString());
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

                    public int wR() {
                        return this.auf;
                    }

                    public boolean wS() {
                        return this.aue;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        for (Integer num : xK()) {
                            codedOutputStreamMicro.writeSInt32(2, num.intValue());
                        }
                        if (wS()) {
                            codedOutputStreamMicro.writeInt32(3, wR());
                        }
                        if (xM()) {
                            codedOutputStreamMicro.writeString(4, xL());
                        }
                        if (xO()) {
                            codedOutputStreamMicro.writeString(5, xN());
                        }
                        if (xQ()) {
                            codedOutputStreamMicro.writeString(6, xP());
                        }
                        if (uT()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        for (Integer num2 : xR()) {
                            codedOutputStreamMicro.writeSInt32(8, num2.intValue());
                        }
                        if (xS()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (xU()) {
                            codedOutputStreamMicro.writeString(10, xT());
                        }
                        if (xW()) {
                            codedOutputStreamMicro.writeString(11, xV());
                        }
                        if (xY()) {
                            codedOutputStreamMicro.writeInt32(12, xX());
                        }
                        if (ya()) {
                            codedOutputStreamMicro.writeInt32(13, xZ());
                        }
                    }

                    public List<Integer> xK() {
                        return this.ava;
                    }

                    public String xL() {
                        return this.avc;
                    }

                    public boolean xM() {
                        return this.avb;
                    }

                    public String xN() {
                        return this.ave;
                    }

                    public boolean xO() {
                        return this.avd;
                    }

                    public String xP() {
                        return this.avg;
                    }

                    public boolean xQ() {
                        return this.avf;
                    }

                    public List<Integer> xR() {
                        return this.avh;
                    }

                    public boolean xS() {
                        return this.avi;
                    }

                    public String xT() {
                        return this.avl;
                    }

                    public boolean xU() {
                        return this.avk;
                    }

                    public String xV() {
                        return this.avn;
                    }

                    public boolean xW() {
                        return this.avm;
                    }

                    public int xX() {
                        return this.avp;
                    }

                    public boolean xY() {
                        return this.avo;
                    }

                    public int xZ() {
                        return this.avr;
                    }

                    public boolean ya() {
                        return this.avq;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.auu.isEmpty()) {
                            this.auu = new ArrayList();
                        }
                        this.auu.add(aVar);
                    }
                    return this;
                }

                public c a(C0124b c0124b) {
                    if (c0124b != null) {
                        if (this.asH.isEmpty()) {
                            this.asH = new ArrayList();
                        }
                        this.asH.add(c0124b);
                    }
                    return this;
                }

                public c b(C0124b c0124b) {
                    if (c0124b != null) {
                        if (this.auR.isEmpty()) {
                            this.auR = new ArrayList();
                        }
                        this.auR.add(c0124b);
                    }
                    return this;
                }

                public c cI(int i) {
                    if (this.asG.isEmpty()) {
                        this.asG = new ArrayList();
                    }
                    this.asG.add(Integer.valueOf(i));
                    return this;
                }

                public c cJ(int i) {
                    this.asr = true;
                    this.type_ = i;
                    return this;
                }

                public c cK(int i) {
                    this.auv = true;
                    this.auw = i;
                    return this;
                }

                public c cL(int i) {
                    this.aux = true;
                    this.auy = i;
                    return this;
                }

                public c cM(int i) {
                    this.auz = true;
                    this.auA = i;
                    return this;
                }

                public c cN(int i) {
                    this.auB = true;
                    this.auC = i;
                    return this;
                }

                public c cO(int i) {
                    this.auD = true;
                    this.auE = i;
                    return this;
                }

                public c cP(int i) {
                    this.auF = true;
                    this.auG = i;
                    return this;
                }

                public c cQ(int i) {
                    this.ass = true;
                    this.ast = i;
                    return this;
                }

                public c cR(int i) {
                    this.asu = true;
                    this.asv = i;
                    return this;
                }

                public c cS(int i) {
                    this.auH = true;
                    this.auI = i;
                    return this;
                }

                public c cT(int i) {
                    this.auJ = true;
                    this.auK = i;
                    return this;
                }

                public c cU(int i) {
                    if (this.asz.isEmpty()) {
                        this.asz = new ArrayList();
                    }
                    this.asz.add(Integer.valueOf(i));
                    return this;
                }

                public c cV(int i) {
                    if (this.asA.isEmpty()) {
                        this.asA = new ArrayList();
                    }
                    this.asA.add(Integer.valueOf(i));
                    return this;
                }

                public c cW(int i) {
                    if (this.auL.isEmpty()) {
                        this.auL = new ArrayList();
                    }
                    this.auL.add(Integer.valueOf(i));
                    return this;
                }

                public c cX(int i) {
                    this.auM = true;
                    this.auN = i;
                    return this;
                }

                public c cY(int i) {
                    if (this.auO.isEmpty()) {
                        this.auO = new ArrayList();
                    }
                    this.auO.add(Integer.valueOf(i));
                    return this;
                }

                public c cZ(int i) {
                    this.auP = true;
                    this.auQ = i;
                    return this;
                }

                public c eF(String str) {
                    this.asC = true;
                    this.asD = str;
                    return this;
                }

                public c eG(String str) {
                    this.arZ = true;
                    this.asa = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.asi < 0) {
                        getSerializedSize();
                    }
                    return this.asi;
                }

                public int getDirection() {
                    return this.auI;
                }

                public int getDistance() {
                    return this.ast;
                }

                public int getDuration() {
                    return this.asv;
                }

                public String getInstructions() {
                    return this.asD;
                }

                public String getName() {
                    return this.asa;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int i2 = 0;
                    int i3 = 0;
                    for (Integer num : vl()) {
                        i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                    }
                    int size = 0 + i3 + (vl().size() * 1);
                    if (vi()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (xj()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, xi());
                    }
                    if (xl()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, xk());
                    }
                    if (xn()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, xm());
                    }
                    if (xp()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, xo());
                    }
                    if (xr()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, xq());
                    }
                    if (xt()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, xs());
                    }
                    if (vb()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<a> it = xh().iterator();
                    while (true) {
                        i = size;
                        if (!it.hasNext()) {
                            break;
                        }
                        size = CodedOutputStreamMicro.computeMessageSize(13, it.next()) + i;
                    }
                    for (C0124b c0124b : vm()) {
                        i += CodedOutputStreamMicro.computeMessageSize(14, c0124b);
                    }
                    if (xu()) {
                        i += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (xw()) {
                        i += CodedOutputStreamMicro.computeInt32Size(16, xv());
                    }
                    int i4 = 0;
                    for (Integer num2 : vf()) {
                        i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue()) + i4;
                    }
                    int size2 = i + i4 + (vf().size() * 2);
                    int i5 = 0;
                    for (Integer num3 : vg()) {
                        i5 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num3.intValue()) + i5;
                    }
                    int size3 = size2 + i5 + (vg().size() * 2);
                    int i6 = 0;
                    for (Integer num4 : xx()) {
                        i6 = CodedOutputStreamMicro.computeInt32SizeNoTag(num4.intValue()) + i6;
                    }
                    int size4 = size3 + i6 + (xx().size() * 2);
                    int computeInt32Size = xz() ? size4 + CodedOutputStreamMicro.computeInt32Size(20, xy()) : size4;
                    for (Integer num5 : xA()) {
                        i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num5.intValue());
                    }
                    int size5 = computeInt32Size + i2 + (xA().size() * 2);
                    if (xC()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, xB());
                    }
                    Iterator<C0124b> it2 = xD().iterator();
                    while (true) {
                        int i7 = size5;
                        if (!it2.hasNext()) {
                            this.asi = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.asu;
                }

                public boolean hasName() {
                    return this.arZ;
                }

                public boolean hasType() {
                    return this.asr;
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
                                eF(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cJ(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eG(codedInputStreamMicro.readString());
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
                                C0124b c0124b = new C0124b();
                                codedInputStreamMicro.readMessage(c0124b);
                                a(c0124b);
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
                                C0124b c0124b2 = new C0124b();
                                codedInputStreamMicro.readMessage(c0124b2);
                                b(c0124b2);
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

                public boolean vb() {
                    return this.ass;
                }

                public List<Integer> vf() {
                    return this.asz;
                }

                public List<Integer> vg() {
                    return this.asA;
                }

                public boolean vi() {
                    return this.asC;
                }

                public List<Integer> vl() {
                    return this.asG;
                }

                public List<C0124b> vm() {
                    return this.asH;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer num : vl()) {
                        codedOutputStreamMicro.writeSInt32(1, num.intValue());
                    }
                    if (vi()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (xj()) {
                        codedOutputStreamMicro.writeInt32(5, xi());
                    }
                    if (xl()) {
                        codedOutputStreamMicro.writeInt32(6, xk());
                    }
                    if (xn()) {
                        codedOutputStreamMicro.writeInt32(7, xm());
                    }
                    if (xp()) {
                        codedOutputStreamMicro.writeInt32(8, xo());
                    }
                    if (xr()) {
                        codedOutputStreamMicro.writeInt32(9, xq());
                    }
                    if (xt()) {
                        codedOutputStreamMicro.writeInt32(10, xs());
                    }
                    if (vb()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (a aVar : xh()) {
                        codedOutputStreamMicro.writeMessage(13, aVar);
                    }
                    for (C0124b c0124b : vm()) {
                        codedOutputStreamMicro.writeMessage(14, c0124b);
                    }
                    if (xu()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (xw()) {
                        codedOutputStreamMicro.writeInt32(16, xv());
                    }
                    for (Integer num2 : vf()) {
                        codedOutputStreamMicro.writeSInt32(17, num2.intValue());
                    }
                    for (Integer num3 : vg()) {
                        codedOutputStreamMicro.writeSInt32(18, num3.intValue());
                    }
                    for (Integer num4 : xx()) {
                        codedOutputStreamMicro.writeInt32(19, num4.intValue());
                    }
                    if (xz()) {
                        codedOutputStreamMicro.writeInt32(20, xy());
                    }
                    for (Integer num5 : xA()) {
                        codedOutputStreamMicro.writeSInt32(21, num5.intValue());
                    }
                    if (xC()) {
                        codedOutputStreamMicro.writeInt32(22, xB());
                    }
                    for (C0124b c0124b2 : xD()) {
                        codedOutputStreamMicro.writeMessage(23, c0124b2);
                    }
                }

                public List<Integer> xA() {
                    return this.auO;
                }

                public int xB() {
                    return this.auQ;
                }

                public boolean xC() {
                    return this.auP;
                }

                public List<C0124b> xD() {
                    return this.auR;
                }

                public List<a> xh() {
                    return this.auu;
                }

                public int xi() {
                    return this.auw;
                }

                public boolean xj() {
                    return this.auv;
                }

                public int xk() {
                    return this.auy;
                }

                public boolean xl() {
                    return this.aux;
                }

                public int xm() {
                    return this.auA;
                }

                public boolean xn() {
                    return this.auz;
                }

                public int xo() {
                    return this.auC;
                }

                public boolean xp() {
                    return this.auB;
                }

                public int xq() {
                    return this.auE;
                }

                public boolean xr() {
                    return this.auD;
                }

                public int xs() {
                    return this.auG;
                }

                public boolean xt() {
                    return this.auF;
                }

                public boolean xu() {
                    return this.auH;
                }

                public int xv() {
                    return this.auK;
                }

                public boolean xw() {
                    return this.auJ;
                }

                public List<Integer> xx() {
                    return this.auL;
                }

                public int xy() {
                    return this.auN;
                }

                public boolean xz() {
                    return this.auM;
                }
            }

            public C0122b a(a aVar) {
                if (aVar != null) {
                    if (this.auk.isEmpty()) {
                        this.auk = new ArrayList();
                    }
                    this.auk.add(aVar);
                }
                return this;
            }

            public C0122b a(C0123b c0123b) {
                if (c0123b == null) {
                    return xa();
                }
                this.aul = true;
                this.aum = c0123b;
                return this;
            }

            public C0122b a(c cVar) {
                if (cVar != null) {
                    if (this.asB.isEmpty()) {
                        this.asB = new ArrayList();
                    }
                    this.asB.add(cVar);
                }
                return this;
            }

            public C0122b cA(int i) {
                this.aue = true;
                this.auf = i;
                return this;
            }

            public C0122b cB(int i) {
                this.aug = true;
                this.auh = i;
                return this;
            }

            public C0122b cC(int i) {
                this.aui = true;
                this.auj = i;
                return this;
            }

            public c cv(int i) {
                return this.asB.get(i);
            }

            public C0122b cw(int i) {
                if (this.asz.isEmpty()) {
                    this.asz = new ArrayList();
                }
                this.asz.add(Integer.valueOf(i));
                return this;
            }

            public C0122b cx(int i) {
                if (this.asA.isEmpty()) {
                    this.asA = new ArrayList();
                }
                this.asA.add(Integer.valueOf(i));
                return this;
            }

            public C0122b cy(int i) {
                this.ass = true;
                this.ast = i;
                return this;
            }

            public C0122b cz(int i) {
                this.asu = true;
                this.asv = i;
                return this;
            }

            public C0122b eA(String str) {
                this.aua = true;
                this.aub = str;
                return this;
            }

            public C0122b eB(String str) {
                this.auc = true;
                this.aud = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public int getDistance() {
                return this.ast;
            }

            public int getDuration() {
                return this.asv;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int i2 = 0;
                int i3 = 0;
                for (Integer num : vf()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                }
                int size = (vf().size() * 1) + 0 + i3;
                for (Integer num2 : vg()) {
                    i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                }
                int size2 = size + i2 + (vg().size() * 1);
                if (wO()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, wN());
                }
                if (wQ()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, wP());
                }
                if (vb()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (wS()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, wR());
                }
                if (wU()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, wT());
                }
                if (wW()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, wV());
                }
                Iterator<c> it = vh().iterator();
                while (true) {
                    i = size2;
                    if (!it.hasNext()) {
                        break;
                    }
                    size2 = CodedOutputStreamMicro.computeMessageSize(10, it.next()) + i;
                }
                for (a aVar : wX()) {
                    i += CodedOutputStreamMicro.computeMessageSize(11, aVar);
                }
                if (wY()) {
                    i += CodedOutputStreamMicro.computeMessageSize(12, wZ());
                }
                this.asi = i;
                return i;
            }

            public boolean hasDuration() {
                return this.asu;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: r */
            public C0122b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                            eA(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eB(codedInputStreamMicro.readString());
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
                            C0123b c0123b = new C0123b();
                            codedInputStreamMicro.readMessage(c0123b);
                            a(c0123b);
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

            public boolean vb() {
                return this.ass;
            }

            public List<Integer> vf() {
                return this.asz;
            }

            public List<Integer> vg() {
                return this.asA;
            }

            public List<c> vh() {
                return this.asB;
            }

            public int wM() {
                return this.asB.size();
            }

            public String wN() {
                return this.aub;
            }

            public boolean wO() {
                return this.aua;
            }

            public String wP() {
                return this.aud;
            }

            public boolean wQ() {
                return this.auc;
            }

            public int wR() {
                return this.auf;
            }

            public boolean wS() {
                return this.aue;
            }

            public int wT() {
                return this.auh;
            }

            public boolean wU() {
                return this.aug;
            }

            public int wV() {
                return this.auj;
            }

            public boolean wW() {
                return this.aui;
            }

            public List<a> wX() {
                return this.auk;
            }

            public boolean wY() {
                return this.aul;
            }

            public C0123b wZ() {
                return this.aum;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer num : vf()) {
                    codedOutputStreamMicro.writeSInt32(1, num.intValue());
                }
                for (Integer num2 : vg()) {
                    codedOutputStreamMicro.writeSInt32(2, num2.intValue());
                }
                if (wO()) {
                    codedOutputStreamMicro.writeString(3, wN());
                }
                if (wQ()) {
                    codedOutputStreamMicro.writeString(4, wP());
                }
                if (vb()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (wS()) {
                    codedOutputStreamMicro.writeInt32(7, wR());
                }
                if (wU()) {
                    codedOutputStreamMicro.writeInt32(8, wT());
                }
                if (wW()) {
                    codedOutputStreamMicro.writeInt32(9, wV());
                }
                for (c cVar : vh()) {
                    codedOutputStreamMicro.writeMessage(10, cVar);
                }
                for (a aVar : wX()) {
                    codedOutputStreamMicro.writeMessage(11, aVar);
                }
                if (wY()) {
                    codedOutputStreamMicro.writeMessage(12, wZ());
                }
            }

            public C0122b xa() {
                this.aul = false;
                this.aum = null;
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends MessageMicro {
            private boolean avs;
            private int avt = 0;
            private List<Integer> avu = Collections.emptyList();
            private int asi = -1;

            public c dk(int i) {
                this.avs = true;
                this.avt = i;
                return this;
            }

            public c dl(int i) {
                if (this.avu.isEmpty()) {
                    this.avu = new ArrayList();
                }
                this.avu.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yc() ? CodedOutputStreamMicro.computeInt32Size(1, yb()) + 0 : 0;
                for (Integer num : yd()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yd().size() * 1);
                this.asi = size;
                return size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yc()) {
                    codedOutputStreamMicro.writeInt32(1, yb());
                }
                for (Integer num : yd()) {
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

            public int yb() {
                return this.avt;
            }

            public boolean yc() {
                return this.avs;
            }

            public List<Integer> yd() {
                return this.avu;
            }
        }

        /* renamed from: com.baidu.g.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0125d extends MessageMicro {
            private boolean avv;
            private int avw = 0;
            private int asi = -1;

            public C0125d dm(int i) {
                this.avv = true;
                this.avw = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public int getLightNum() {
                return this.avw;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = ye() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.asi = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (ye()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: y */
            public C0125d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

            public boolean ye() {
                return this.avv;
            }
        }

        /* loaded from: classes3.dex */
        public static final class e extends MessageMicro {
            private boolean asW;
            private boolean atg;
            private boolean avx;
            private boolean avz;
            private int avy = 0;
            private String avA = "";
            private a avB = null;
            private List<a> ati = Collections.emptyList();
            private c asX = null;
            private int asi = -1;

            /* loaded from: classes3.dex */
            public static final class a extends MessageMicro {
                private boolean arZ;
                private boolean asf;
                private boolean atD;
                private boolean atF;
                private boolean atw;
                private String atx = "";
                private String asa = "";
                private String asg = "";
                private List<Integer> atC = Collections.emptyList();
                private String atE = "";
                private String atG = "";
                private int asi = -1;

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
                                eR(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                eS(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                eT(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                m18do(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                eU(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eV(codedInputStreamMicro.readString());
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
                public a m18do(int i) {
                    if (this.atC.isEmpty()) {
                        this.atC = new ArrayList();
                    }
                    this.atC.add(Integer.valueOf(i));
                    return this;
                }

                public a eR(String str) {
                    this.atw = true;
                    this.atx = str;
                    return this;
                }

                public a eS(String str) {
                    this.arZ = true;
                    this.asa = str;
                    return this;
                }

                public a eT(String str) {
                    this.asf = true;
                    this.asg = str;
                    return this;
                }

                public a eU(String str) {
                    this.atD = true;
                    this.atE = str;
                    return this;
                }

                public a eV(String str) {
                    this.atF = true;
                    this.atG = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.asi < 0) {
                        getSerializedSize();
                    }
                    return this.asi;
                }

                public String getFloor() {
                    return this.atE;
                }

                public String getName() {
                    return this.asa;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeStringSize = wf() ? CodedOutputStreamMicro.computeStringSize(1, we()) + 0 : 0;
                    if (hasName()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    int computeStringSize2 = uT() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                    for (Integer num : wk()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize2 + i + (wk().size() * 1);
                    if (wl()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (wn()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, wm());
                    }
                    this.asi = size;
                    return size;
                }

                public String getUid() {
                    return this.asg;
                }

                public boolean hasName() {
                    return this.arZ;
                }

                public boolean uT() {
                    return this.asf;
                }

                public String we() {
                    return this.atx;
                }

                public boolean wf() {
                    return this.atw;
                }

                public List<Integer> wk() {
                    return this.atC;
                }

                public boolean wl() {
                    return this.atD;
                }

                public String wm() {
                    return this.atG;
                }

                public boolean wn() {
                    return this.atF;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (wf()) {
                        codedOutputStreamMicro.writeString(1, we());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (uT()) {
                        codedOutputStreamMicro.writeString(3, getUid());
                    }
                    for (Integer num : wk()) {
                        codedOutputStreamMicro.writeSInt32(4, num.intValue());
                    }
                    if (wl()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (wn()) {
                        codedOutputStreamMicro.writeString(6, wm());
                    }
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return yj();
                }
                this.atg = true;
                this.avB = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.ati.isEmpty()) {
                        this.ati = new ArrayList();
                    }
                    this.ati.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return yk();
                }
                this.asW = true;
                this.asX = cVar;
                return this;
            }

            public e dn(int i) {
                this.avx = true;
                this.avy = i;
                return this;
            }

            public e eQ(String str) {
                this.avz = true;
                this.avA = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getLabel() {
                return this.avA;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int computeInt32Size = yg() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, yf()) : 0;
                if (yh()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, yi());
                }
                Iterator<a> it = vP().iterator();
                while (true) {
                    i = computeInt32Size;
                    if (!it.hasNext()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
                }
                if (vz()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, vA());
                }
                this.asi = i;
                return i;
            }

            public boolean hasStart() {
                return this.atg;
            }

            public c vA() {
                return this.asX;
            }

            public List<a> vP() {
                return this.ati;
            }

            public boolean vz() {
                return this.asW;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yg()) {
                    codedOutputStreamMicro.writeInt32(1, yf());
                }
                if (yh()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, yi());
                }
                for (a aVar : vP()) {
                    codedOutputStreamMicro.writeMessage(4, aVar);
                }
                if (vz()) {
                    codedOutputStreamMicro.writeMessage(5, vA());
                }
            }

            public int yf() {
                return this.avy;
            }

            public boolean yg() {
                return this.avx;
            }

            public boolean yh() {
                return this.avz;
            }

            public a yi() {
                return this.avB;
            }

            public e yj() {
                this.atg = false;
                this.avB = null;
                return this;
            }

            public e yk() {
                this.asW = false;
                this.asX = null;
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
                            eQ(codedInputStreamMicro.readString());
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
            private boolean avC;
            private boolean avE;
            private String avD = "";
            private String avF = "";
            private int asi = -1;

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
                            eW(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eX(codedInputStreamMicro.readString());
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

            public f eW(String str) {
                this.avC = true;
                this.avD = str;
                return this;
            }

            public f eX(String str) {
                this.avE = true;
                this.avF = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getContent() {
                return this.avD;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = yl() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (yn()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, ym());
                }
                this.asi = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yl()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (yn()) {
                    codedOutputStreamMicro.writeString(2, ym());
                }
            }

            public boolean yl() {
                return this.avC;
            }

            public String ym() {
                return this.avF;
            }

            public boolean yn() {
                return this.avE;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return wt();
            }
            this.atJ = true;
            this.atK = aVar;
            return this;
        }

        public b a(C0122b c0122b) {
            if (c0122b != null) {
                if (this.asw.isEmpty()) {
                    this.asw = new ArrayList();
                }
                this.asw.add(c0122b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.atR.isEmpty()) {
                    this.atR = new ArrayList();
                }
                this.atR.add(cVar);
            }
            return this;
        }

        public b a(C0125d c0125d) {
            if (c0125d == null) {
                return wz();
            }
            this.atN = true;
            this.atO = c0125d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return wC();
            }
            this.atP = true;
            this.atQ = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return ww();
            }
            this.atL = true;
            this.atM = fVar;
            return this;
        }

        public C0122b cr(int i) {
            return this.asw.get(i);
        }

        public b ez(String str) {
            this.atS = true;
            this.atT = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.asi < 0) {
                getSerializedSize();
            }
            return this.asi;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int i2 = 0;
            Iterator<C0122b> it = vc().iterator();
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
            if (wu()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, wv());
            }
            if (wx()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, wy());
            }
            if (wA()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, wB());
            }
            for (c cVar : wD()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, cVar);
            }
            if (wF()) {
                i += CodedOutputStreamMicro.computeStringSize(7, wE());
            }
            this.asi = i;
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
                        C0122b c0122b = new C0122b();
                        codedInputStreamMicro.readMessage(c0122b);
                        a(c0122b);
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
                        C0125d c0125d = new C0125d();
                        codedInputStreamMicro.readMessage(c0125d);
                        a(c0125d);
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
                        ez(codedInputStreamMicro.readString());
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

        public List<C0122b> vc() {
            return this.asw;
        }

        public boolean wA() {
            return this.atP;
        }

        public e wB() {
            return this.atQ;
        }

        public b wC() {
            this.atP = false;
            this.atQ = null;
            return this;
        }

        public List<c> wD() {
            return this.atR;
        }

        public String wE() {
            return this.atT;
        }

        public boolean wF() {
            return this.atS;
        }

        public int wq() {
            return this.asw.size();
        }

        public boolean wr() {
            return this.atJ;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (C0122b c0122b : vc()) {
                codedOutputStreamMicro.writeMessage(1, c0122b);
            }
            if (wr()) {
                codedOutputStreamMicro.writeMessage(2, ws());
            }
            if (wu()) {
                codedOutputStreamMicro.writeMessage(3, wv());
            }
            if (wx()) {
                codedOutputStreamMicro.writeMessage(4, wy());
            }
            if (wA()) {
                codedOutputStreamMicro.writeMessage(5, wB());
            }
            for (c cVar : wD()) {
                codedOutputStreamMicro.writeMessage(6, cVar);
            }
            if (wF()) {
                codedOutputStreamMicro.writeString(7, wE());
            }
        }

        public a ws() {
            return this.atK;
        }

        public b wt() {
            this.atJ = false;
            this.atK = null;
            return this;
        }

        public boolean wu() {
            return this.atL;
        }

        public f wv() {
            return this.atM;
        }

        public b ww() {
            this.atL = false;
            this.atM = null;
            return this;
        }

        public boolean wx() {
            return this.atN;
        }

        public C0125d wy() {
            return this.atO;
        }

        public b wz() {
            this.atN = false;
            this.atO = null;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends MessageMicro {
        private boolean ass;
        private boolean asu;
        private boolean avI;
        private String avG = "";
        private String avH = "";
        private String avJ = "";
        private List<a> avK = Collections.emptyList();
        private int asi = -1;

        /* loaded from: classes3.dex */
        public static final class a extends MessageMicro {
            private boolean avL;
            private boolean avN;
            private boolean avP;
            private boolean avR;
            private String avM = "";
            private String avO = "";
            private String avQ = "";
            private String avS = "";
            private int asi = -1;

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
                            fb(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fc(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            fd(codedInputStreamMicro.readString());
                            break;
                        case 34:
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

            public a fb(String str) {
                this.avL = true;
                this.avM = str;
                return this;
            }

            public a fc(String str) {
                this.avN = true;
                this.avO = str;
                return this;
            }

            public a fd(String str) {
                this.avP = true;
                this.avQ = str;
                return this;
            }

            public a fe(String str) {
                this.avR = true;
                this.avS = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.asi < 0) {
                    getSerializedSize();
                }
                return this.asi;
            }

            public String getDesc() {
                return this.avS;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = ys() ? 0 + CodedOutputStreamMicro.computeStringSize(1, yr()) : 0;
                if (yu()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, yt());
                }
                if (yw()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, yv());
                }
                if (yx()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.asi = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (ys()) {
                    codedOutputStreamMicro.writeString(1, yr());
                }
                if (yu()) {
                    codedOutputStreamMicro.writeString(2, yt());
                }
                if (yw()) {
                    codedOutputStreamMicro.writeString(3, yv());
                }
                if (yx()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public String yr() {
                return this.avM;
            }

            public boolean ys() {
                return this.avL;
            }

            public String yt() {
                return this.avO;
            }

            public boolean yu() {
                return this.avN;
            }

            public String yv() {
                return this.avQ;
            }

            public boolean yw() {
                return this.avP;
            }

            public boolean yx() {
                return this.avR;
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
                        eY(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        eZ(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fa(codedInputStreamMicro.readString());
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
                if (this.avK.isEmpty()) {
                    this.avK = new ArrayList();
                }
                this.avK.add(aVar);
            }
            return this;
        }

        public c eY(String str) {
            this.ass = true;
            this.avG = str;
            return this;
        }

        public c eZ(String str) {
            this.asu = true;
            this.avH = str;
            return this;
        }

        public c fa(String str) {
            this.avI = true;
            this.avJ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.asi < 0) {
                getSerializedSize();
            }
            return this.asi;
        }

        public String getDistance() {
            return this.avG;
        }

        public String getDuration() {
            return this.avH;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = vb() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (yp()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, yo());
            }
            Iterator<a> it = yq().iterator();
            while (true) {
                int i = computeStringSize;
                if (!it.hasNext()) {
                    this.asi = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.asu;
        }

        public boolean vb() {
            return this.ass;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vb()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (yp()) {
                codedOutputStreamMicro.writeString(3, yo());
            }
            for (a aVar : yq()) {
                codedOutputStreamMicro.writeMessage(4, aVar);
            }
        }

        public String yo() {
            return this.avJ;
        }

        public boolean yp() {
            return this.avI;
        }

        public List<a> yq() {
            return this.avK;
        }
    }

    public d a(com.baidu.g.a.a aVar) {
        if (aVar == null) {
            return vG();
        }
        this.asZ = true;
        this.ata = aVar;
        return this;
    }

    public d a(com.baidu.g.a.b bVar) {
        if (bVar != null) {
            if (this.atb.isEmpty()) {
                this.atb = new ArrayList();
            }
            this.atb.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return vD();
        }
        this.asj = true;
        this.asY = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.asl.isEmpty()) {
                this.asl = new ArrayList();
            }
            this.asl.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return vB();
        }
        this.asW = true;
        this.asX = cVar;
        return this;
    }

    public b ce(int i) {
        return this.asl.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.asi < 0) {
            getSerializedSize();
        }
        return this.asi;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        Iterator<b> it = uY().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
        }
        if (vz()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, vA());
        }
        if (uV()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, vC());
        }
        if (vE()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, vF());
        }
        for (com.baidu.g.a.b bVar : vH()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, bVar);
        }
        this.asi = i;
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

    public boolean uV() {
        return this.asj;
    }

    public List<b> uY() {
        return this.asl;
    }

    public int uZ() {
        return this.asl.size();
    }

    public c vA() {
        return this.asX;
    }

    public d vB() {
        this.asW = false;
        this.asX = null;
        return this;
    }

    public a vC() {
        return this.asY;
    }

    public d vD() {
        this.asj = false;
        this.asY = null;
        return this;
    }

    public boolean vE() {
        return this.asZ;
    }

    public com.baidu.g.a.a vF() {
        return this.ata;
    }

    public d vG() {
        this.asZ = false;
        this.ata = null;
        return this;
    }

    public List<com.baidu.g.a.b> vH() {
        return this.atb;
    }

    public int vI() {
        return this.atb.size();
    }

    public boolean vz() {
        return this.asW;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (b bVar : uY()) {
            codedOutputStreamMicro.writeMessage(1, bVar);
        }
        if (vz()) {
            codedOutputStreamMicro.writeMessage(2, vA());
        }
        if (uV()) {
            codedOutputStreamMicro.writeMessage(3, vC());
        }
        if (vE()) {
            codedOutputStreamMicro.writeMessage(4, vF());
        }
        for (com.baidu.g.a.b bVar2 : vH()) {
            codedOutputStreamMicro.writeMessage(5, bVar2);
        }
    }
}
