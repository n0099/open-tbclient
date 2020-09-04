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
/* loaded from: classes20.dex */
public final class d extends MessageMicro {
    private boolean apx;
    private boolean aqj;
    private boolean aqm;
    private c aqk = null;
    private List<b> apz = Collections.emptyList();
    private a aql = null;
    private com.baidu.f.a.a aqn = null;
    private List<com.baidu.f.a.b> aqo = Collections.emptyList();
    private int apw = -1;

    /* loaded from: classes20.dex */
    public static final class a extends MessageMicro {
        private boolean apC;
        private boolean aqB;
        private boolean aqD;
        private boolean aqF;
        private boolean aqH;
        private boolean aqp;
        private boolean aqr;
        private boolean aqt;
        private boolean aqw;
        private boolean aqy;
        private int apD = 0;
        private String aqq = "";
        private int aqs = 0;
        private c aqu = null;
        private List<C0114a> aqv = Collections.emptyList();
        private int aqx = 0;
        private C0115d aqz = null;
        private List<b> aqA = Collections.emptyList();
        private int aqC = 0;
        private String aqE = "";
        private int aqG = 0;
        private String aqI = "";
        private int apw = -1;

        /* renamed from: com.baidu.f.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0114a extends MessageMicro {
            private boolean apt;
            private boolean aqJ;
            private boolean aqL;
            private boolean aqN;
            private boolean aqQ;
            private boolean aqS;
            private String aqK = "";
            private String aqM = "";
            private String apu = "";
            private boolean aqO = false;
            private List<Integer> aqP = Collections.emptyList();
            private String aqR = "";
            private String aqT = "";
            private int apw = -1;

            public C0114a aR(boolean z) {
                this.aqN = true;
                this.aqO = z;
                return this;
            }

            public int cg(int i) {
                return this.aqP.get(i).intValue();
            }

            public C0114a ch(int i) {
                if (this.aqP.isEmpty()) {
                    this.aqP = new ArrayList();
                }
                this.aqP.add(Integer.valueOf(i));
                return this;
            }

            public C0114a eo(String str) {
                this.aqJ = true;
                this.aqK = str;
                return this;
            }

            public C0114a ep(String str) {
                this.aqL = true;
                this.aqM = str;
                return this;
            }

            public C0114a eq(String str) {
                this.apt = true;
                this.apu = str;
                return this;
            }

            public C0114a er(String str) {
                this.aqQ = true;
                this.aqR = str;
                return this;
            }

            public C0114a es(String str) {
                this.aqS = true;
                this.aqT = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public String getFloor() {
                return this.aqR;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wA() ? CodedOutputStreamMicro.computeStringSize(1, wz()) + 0 : 0;
                if (wC()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wB());
                }
                if (vo()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = wE() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wD()) : computeStringSize;
                for (Integer num : wF()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (wF().size() * 1);
                if (wG()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (wI()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, wH());
                }
                this.apw = size;
                return size;
            }

            public String getUid() {
                return this.apu;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: l */
            public C0114a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            eo(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            ep(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            eq(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aR(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            ch(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            er(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            es(codedInputStreamMicro.readString());
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

            public boolean vo() {
                return this.apt;
            }

            public boolean wA() {
                return this.aqJ;
            }

            public String wB() {
                return this.aqM;
            }

            public boolean wC() {
                return this.aqL;
            }

            public boolean wD() {
                return this.aqO;
            }

            public boolean wE() {
                return this.aqN;
            }

            public List<Integer> wF() {
                return this.aqP;
            }

            public boolean wG() {
                return this.aqQ;
            }

            public String wH() {
                return this.aqT;
            }

            public boolean wI() {
                return this.aqS;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wA()) {
                    codedOutputStreamMicro.writeString(1, wz());
                }
                if (wC()) {
                    codedOutputStreamMicro.writeString(2, wB());
                }
                if (vo()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (wE()) {
                    codedOutputStreamMicro.writeBool(4, wD());
                }
                for (Integer num : wF()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (wG()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (wI()) {
                    codedOutputStreamMicro.writeString(7, wH());
                }
            }

            public String wz() {
                return this.aqK;
            }
        }

        /* loaded from: classes20.dex */
        public static final class b extends MessageMicro {
            private boolean apg;
            private boolean aqU;
            private int aph = 0;
            private String aqV = "";
            private int apw = -1;

            public b ci(int i) {
                this.apg = true;
                this.aph = i;
                return this;
            }

            public b et(String str) {
                this.aqU = true;
                this.aqV = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public int getCode() {
                return this.aph;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vh() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wK()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wJ());
                }
                this.apw = computeInt32Size;
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
                            ci(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            et(codedInputStreamMicro.readString());
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

            public boolean vh() {
                return this.apg;
            }

            public String wJ() {
                return this.aqV;
            }

            public boolean wK() {
                return this.aqU;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vh()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wK()) {
                    codedOutputStreamMicro.writeString(2, wJ());
                }
            }
        }

        /* loaded from: classes20.dex */
        public static final class c extends MessageMicro {
            private boolean apt;
            private boolean aqJ;
            private boolean aqL;
            private boolean aqN;
            private boolean aqQ;
            private boolean aqS;
            private String aqK = "";
            private String aqM = "";
            private String apu = "";
            private boolean aqO = false;
            private List<Integer> aqP = Collections.emptyList();
            private String aqR = "";
            private String aqT = "";
            private int apw = -1;

            public c aS(boolean z) {
                this.aqN = true;
                this.aqO = z;
                return this;
            }

            public int cg(int i) {
                return this.aqP.get(i).intValue();
            }

            public c cj(int i) {
                if (this.aqP.isEmpty()) {
                    this.aqP = new ArrayList();
                }
                this.aqP.add(Integer.valueOf(i));
                return this;
            }

            public c eu(String str) {
                this.aqJ = true;
                this.aqK = str;
                return this;
            }

            public c ev(String str) {
                this.aqL = true;
                this.aqM = str;
                return this;
            }

            public c ew(String str) {
                this.apt = true;
                this.apu = str;
                return this;
            }

            public c ey(String str) {
                this.aqQ = true;
                this.aqR = str;
                return this;
            }

            public c ez(String str) {
                this.aqS = true;
                this.aqT = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public String getFloor() {
                return this.aqR;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = wA() ? CodedOutputStreamMicro.computeStringSize(1, wz()) + 0 : 0;
                if (wC()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wB());
                }
                if (vo()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                int computeBoolSize = wE() ? computeStringSize + CodedOutputStreamMicro.computeBoolSize(4, wD()) : computeStringSize;
                for (Integer num : wF()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeBoolSize + i + (wF().size() * 1);
                if (wG()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (wI()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, wH());
                }
                this.apw = size;
                return size;
            }

            public String getUid() {
                return this.apu;
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
                            eu(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            ev(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            ew(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aS(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cj(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            ey(codedInputStreamMicro.readString());
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

            public boolean vo() {
                return this.apt;
            }

            public boolean wA() {
                return this.aqJ;
            }

            public String wB() {
                return this.aqM;
            }

            public boolean wC() {
                return this.aqL;
            }

            public boolean wD() {
                return this.aqO;
            }

            public boolean wE() {
                return this.aqN;
            }

            public List<Integer> wF() {
                return this.aqP;
            }

            public boolean wG() {
                return this.aqQ;
            }

            public String wH() {
                return this.aqT;
            }

            public boolean wI() {
                return this.aqS;
            }

            public int wL() {
                return this.aqP.size();
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (wA()) {
                    codedOutputStreamMicro.writeString(1, wz());
                }
                if (wC()) {
                    codedOutputStreamMicro.writeString(2, wB());
                }
                if (vo()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (wE()) {
                    codedOutputStreamMicro.writeBool(4, wD());
                }
                for (Integer num : wF()) {
                    codedOutputStreamMicro.writeSInt32(5, num.intValue());
                }
                if (wG()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (wI()) {
                    codedOutputStreamMicro.writeString(7, wH());
                }
            }

            public String wz() {
                return this.aqK;
            }
        }

        /* renamed from: com.baidu.f.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0115d extends MessageMicro {
            private boolean apg;
            private boolean aqU;
            private int aph = 0;
            private String aqV = "";
            private int apw = -1;

            public C0115d ck(int i) {
                this.apg = true;
                this.aph = i;
                return this;
            }

            public C0115d eA(String str) {
                this.aqU = true;
                this.aqV = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public int getCode() {
                return this.aph;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vh() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wK()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wJ());
                }
                this.apw = computeInt32Size;
                return computeInt32Size;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: o */
            public C0115d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            ck(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
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

            public boolean vh() {
                return this.apg;
            }

            public String wJ() {
                return this.aqV;
            }

            public boolean wK() {
                return this.aqU;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (vh()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (wK()) {
                    codedOutputStreamMicro.writeString(2, wJ());
                }
            }
        }

        public a a(C0114a c0114a) {
            if (c0114a != null) {
                if (this.aqv.isEmpty()) {
                    this.aqv = new ArrayList();
                }
                this.aqv.add(c0114a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.aqA.isEmpty()) {
                    this.aqA = new ArrayList();
                }
                this.aqA.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wj();
            }
            this.aqt = true;
            this.aqu = cVar;
            return this;
        }

        public a a(C0115d c0115d) {
            if (c0115d == null) {
                return wp();
            }
            this.aqy = true;
            this.aqz = c0115d;
            return this;
        }

        public a bZ(int i) {
            this.apC = true;
            this.apD = i;
            return this;
        }

        public a ca(int i) {
            this.aqr = true;
            this.aqs = i;
            return this;
        }

        public C0114a cb(int i) {
            return this.aqv.get(i);
        }

        public a cc(int i) {
            this.aqw = true;
            this.aqx = i;
            return this;
        }

        public b cd(int i) {
            return this.aqA.get(i);
        }

        public a ce(int i) {
            this.aqB = true;
            this.aqC = i;
            return this;
        }

        public a cf(int i) {
            this.aqF = true;
            this.aqG = i;
            return this;
        }

        public a el(String str) {
            this.aqp = true;
            this.aqq = str;
            return this;
        }

        public a em(String str) {
            this.aqD = true;
            this.aqE = str;
            return this;
        }

        public a en(String str) {
            this.aqH = true;
            this.aqI = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apw < 0) {
                getSerializedSize();
            }
            return this.apw;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int computeInt32Size = vv() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (wf()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, we());
            }
            if (wh()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, wg());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, wi());
            }
            Iterator<C0114a> it = wk().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
            }
            if (wm()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, wl());
            }
            if (wn()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, wo());
            }
            for (b bVar : wq()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, bVar);
            }
            if (ws()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, wr());
            }
            if (wu()) {
                i += CodedOutputStreamMicro.computeStringSize(10, wt());
            }
            if (ww()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, wv());
            }
            if (wy()) {
                i += CodedOutputStreamMicro.computeStringSize(12, wx());
            }
            this.apw = i;
            return i;
        }

        public int getTotal() {
            return this.apD;
        }

        public boolean hasStart() {
            return this.aqt;
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
                        bZ(codedInputStreamMicro.readInt32());
                        break;
                    case 18:
                        el(codedInputStreamMicro.readString());
                        break;
                    case 24:
                        ca(codedInputStreamMicro.readInt32());
                        break;
                    case 34:
                        c cVar = new c();
                        codedInputStreamMicro.readMessage(cVar);
                        a(cVar);
                        break;
                    case 42:
                        C0114a c0114a = new C0114a();
                        codedInputStreamMicro.readMessage(c0114a);
                        a(c0114a);
                        break;
                    case 48:
                        cc(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        C0115d c0115d = new C0115d();
                        codedInputStreamMicro.readMessage(c0115d);
                        a(c0115d);
                        break;
                    case 66:
                        b bVar = new b();
                        codedInputStreamMicro.readMessage(bVar);
                        a(bVar);
                        break;
                    case 72:
                        ce(codedInputStreamMicro.readInt32());
                        break;
                    case 82:
                        em(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        cf(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
                        en(codedInputStreamMicro.readString());
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
            return this.apC;
        }

        public String we() {
            return this.aqq;
        }

        public boolean wf() {
            return this.aqp;
        }

        public int wg() {
            return this.aqs;
        }

        public boolean wh() {
            return this.aqr;
        }

        public c wi() {
            return this.aqu;
        }

        public a wj() {
            this.aqt = false;
            this.aqu = null;
            return this;
        }

        public List<C0114a> wk() {
            return this.aqv;
        }

        public int wl() {
            return this.aqx;
        }

        public boolean wm() {
            return this.aqw;
        }

        public boolean wn() {
            return this.aqy;
        }

        public C0115d wo() {
            return this.aqz;
        }

        public a wp() {
            this.aqy = false;
            this.aqz = null;
            return this;
        }

        public List<b> wq() {
            return this.aqA;
        }

        public int wr() {
            return this.aqC;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vv()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (wf()) {
                codedOutputStreamMicro.writeString(2, we());
            }
            if (wh()) {
                codedOutputStreamMicro.writeInt32(3, wg());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, wi());
            }
            for (C0114a c0114a : wk()) {
                codedOutputStreamMicro.writeMessage(5, c0114a);
            }
            if (wm()) {
                codedOutputStreamMicro.writeInt32(6, wl());
            }
            if (wn()) {
                codedOutputStreamMicro.writeMessage(7, wo());
            }
            for (b bVar : wq()) {
                codedOutputStreamMicro.writeMessage(8, bVar);
            }
            if (ws()) {
                codedOutputStreamMicro.writeInt32(9, wr());
            }
            if (wu()) {
                codedOutputStreamMicro.writeString(10, wt());
            }
            if (ww()) {
                codedOutputStreamMicro.writeInt32(11, wv());
            }
            if (wy()) {
                codedOutputStreamMicro.writeString(12, wx());
            }
        }

        public boolean ws() {
            return this.aqB;
        }

        public String wt() {
            return this.aqE;
        }

        public boolean wu() {
            return this.aqD;
        }

        public int wv() {
            return this.aqG;
        }

        public boolean ww() {
            return this.aqF;
        }

        public String wx() {
            return this.aqI;
        }

        public boolean wy() {
            return this.aqH;
        }
    }

    /* loaded from: classes20.dex */
    public static final class b extends MessageMicro {
        private boolean aqW;
        private boolean aqY;
        private boolean ara;
        private boolean arc;
        private boolean arf;
        private List<C0116b> apJ = Collections.emptyList();
        private a aqX = null;
        private f aqZ = null;
        private C0119d arb = null;
        private e ard = null;
        private List<c> are = Collections.emptyList();
        private String arg = "";
        private int apw = -1;

        /* loaded from: classes20.dex */
        public static final class a extends MessageMicro {
            private boolean arh;
            private boolean arj;
            private boolean arl;
            private int ari = 0;
            private int ark = 0;
            private int arm = 0;
            private int apw = -1;

            public a cm(int i) {
                this.arh = true;
                this.ari = i;
                return this;
            }

            public a cn(int i) {
                this.arj = true;
                this.ark = i;
                return this;
            }

            public a co(int i) {
                this.arl = true;
                this.arm = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = xd() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xc()) : 0;
                if (xf()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xe());
                }
                if (xh()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, xg());
                }
                this.apw = computeInt32Size;
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
                            cm(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            cn(codedInputStreamMicro.readInt32());
                            break;
                        case 24:
                            co(codedInputStreamMicro.readInt32());
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
                if (xd()) {
                    codedOutputStreamMicro.writeInt32(1, xc());
                }
                if (xf()) {
                    codedOutputStreamMicro.writeInt32(2, xe());
                }
                if (xh()) {
                    codedOutputStreamMicro.writeInt32(3, xg());
                }
            }

            public int xc() {
                return this.ari;
            }

            public boolean xd() {
                return this.arh;
            }

            public int xe() {
                return this.ark;
            }

            public boolean xf() {
                return this.arj;
            }

            public int xg() {
                return this.arm;
            }

            public boolean xh() {
                return this.arl;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0116b extends MessageMicro {
            private boolean apF;
            private boolean apH;
            private boolean arn;
            private boolean arp;
            private boolean arr;
            private boolean art;
            private boolean arv;
            private boolean ary;
            private List<c> apO = Collections.emptyList();
            private List<Integer> apM = Collections.emptyList();
            private List<Integer> apN = Collections.emptyList();
            private String aro = "";
            private String arq = "";
            private int apG = 0;
            private int apI = 0;
            private int ars = 0;
            private int aru = 0;
            private int arw = 0;
            private List<a> arx = Collections.emptyList();
            private C0117b arz = null;
            private int apw = -1;

            /* renamed from: com.baidu.f.a.d$b$b$a */
            /* loaded from: classes20.dex */
            public static final class a extends MessageMicro {
                private boolean apE;
                private boolean aqQ;
                private boolean aqS;
                private boolean arA;
                private boolean arC;
                private int type_ = 0;
                private int arB = 0;
                private String arD = "";
                private List<Integer> apX = Collections.emptyList();
                private String aqR = "";
                private String aqT = "";
                private int apw = -1;

                public a cx(int i) {
                    this.apE = true;
                    this.type_ = i;
                    return this;
                }

                public a cy(int i) {
                    this.arA = true;
                    this.arB = i;
                    return this;
                }

                public a cz(int i) {
                    if (this.apX.isEmpty()) {
                        this.apX = new ArrayList();
                    }
                    this.apX.add(Integer.valueOf(i));
                    return this;
                }

                public a eE(String str) {
                    this.arC = true;
                    this.arD = str;
                    return this;
                }

                public a eF(String str) {
                    this.aqQ = true;
                    this.aqR = str;
                    return this;
                }

                public a eG(String str) {
                    this.aqS = true;
                    this.aqT = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apw < 0) {
                        getSerializedSize();
                    }
                    return this.apw;
                }

                public String getFloor() {
                    return this.aqR;
                }

                public String getInfo() {
                    return this.arD;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (xy()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xx());
                    }
                    int computeStringSize = xz() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(3, getInfo()) : computeInt32Size;
                    for (Integer num : vK()) {
                        i += CodedOutputStreamMicro.computeInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize + i + (vK().size() * 1);
                    if (wG()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (wI()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, wH());
                    }
                    this.apw = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.apE;
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
                                cx(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cy(codedInputStreamMicro.readInt32());
                                break;
                            case 26:
                                eE(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cz(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eF(codedInputStreamMicro.readString());
                                break;
                            case 50:
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

                public List<Integer> vK() {
                    return this.apX;
                }

                public boolean wG() {
                    return this.aqQ;
                }

                public String wH() {
                    return this.aqT;
                }

                public boolean wI() {
                    return this.aqS;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (xy()) {
                        codedOutputStreamMicro.writeInt32(2, xx());
                    }
                    if (xz()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    for (Integer num : vK()) {
                        codedOutputStreamMicro.writeInt32(4, num.intValue());
                    }
                    if (wG()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (wI()) {
                        codedOutputStreamMicro.writeString(6, wH());
                    }
                }

                public int xx() {
                    return this.arB;
                }

                public boolean xy() {
                    return this.arA;
                }

                public boolean xz() {
                    return this.arC;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes20.dex */
            public static final class C0117b extends MessageMicro {
                private boolean arE;
                private boolean hasNext;
                private int arF = 0;
                private int arG = 0;
                private int apw = -1;

                public C0117b cA(int i) {
                    this.arE = true;
                    this.arF = i;
                    return this;
                }

                public C0117b cB(int i) {
                    this.hasNext = true;
                    this.arG = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apw < 0) {
                        getSerializedSize();
                    }
                    return this.apw;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xB() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xA()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xC());
                    }
                    this.apw = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: t */
                public C0117b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                cA(codedInputStreamMicro.readInt32());
                                break;
                            case 16:
                                cB(codedInputStreamMicro.readInt32());
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
                    if (xB()) {
                        codedOutputStreamMicro.writeInt32(1, xA());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, xC());
                    }
                }

                public int xA() {
                    return this.arF;
                }

                public boolean xB() {
                    return this.arE;
                }

                public int xC() {
                    return this.arG;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$c */
            /* loaded from: classes20.dex */
            public static final class c extends MessageMicro {
                private boolean apE;
                private boolean apF;
                private boolean apH;
                private boolean apP;
                private boolean apm;
                private boolean arI;
                private boolean arK;
                private boolean arM;
                private boolean arO;
                private boolean arQ;
                private boolean arS;
                private boolean arU;
                private boolean arW;
                private boolean arZ;
                private boolean asc;
                private List<a> arH = Collections.emptyList();
                private List<C0118b> apU = Collections.emptyList();
                private List<Integer> apT = Collections.emptyList();
                private String apQ = "";
                private int type_ = 0;
                private String apn = "";
                private int arJ = 0;
                private int arL = 0;
                private int arN = 0;
                private int arP = 0;
                private int arR = 0;
                private int arT = 0;
                private int apG = 0;
                private int apI = 0;
                private int arV = 0;
                private int arX = 0;
                private List<Integer> apM = Collections.emptyList();
                private List<Integer> apN = Collections.emptyList();
                private List<Integer> arY = Collections.emptyList();
                private int asa = 0;
                private List<Integer> asb = Collections.emptyList();
                private int asd = 0;
                private List<C0118b> ase = Collections.emptyList();
                private int apw = -1;

                /* renamed from: com.baidu.f.a.d$b$b$c$a */
                /* loaded from: classes20.dex */
                public static final class a extends MessageMicro {
                    private boolean aqh;
                    private boolean arW;
                    private boolean asf;
                    private boolean ash;
                    private boolean asj;
                    private boolean asl;
                    private String asg = "";
                    private int asi = 0;
                    private int aqi = 0;
                    private int arX = 0;
                    private int ask = 0;
                    private int asn = 0;
                    private int apw = -1;

                    public a cU(int i) {
                        this.ash = true;
                        this.asi = i;
                        return this;
                    }

                    public a cV(int i) {
                        this.aqh = true;
                        this.aqi = i;
                        return this;
                    }

                    public a cW(int i) {
                        this.arW = true;
                        this.arX = i;
                        return this;
                    }

                    public a cX(int i) {
                        this.asj = true;
                        this.ask = i;
                        return this;
                    }

                    public a cY(int i) {
                        this.asl = true;
                        this.asn = i;
                        return this;
                    }

                    public a eJ(String str) {
                        this.asf = true;
                        this.asg = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.apw < 0) {
                            getSerializedSize();
                        }
                        return this.apw;
                    }

                    public String getId() {
                        return this.asg;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (yb()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, ya());
                        }
                        if (vT()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, vS());
                        }
                        if (xS()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, xR());
                        }
                        if (yd()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, yc());
                        }
                        if (yf()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, ye());
                        }
                        this.apw = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.asf;
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
                                    eJ(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    cU(codedInputStreamMicro.readInt32());
                                    break;
                                case 24:
                                    cV(codedInputStreamMicro.readInt32());
                                    break;
                                case 32:
                                    cW(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    cX(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    cY(codedInputStreamMicro.readInt32());
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

                    public int vS() {
                        return this.aqi;
                    }

                    public boolean vT() {
                        return this.aqh;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (yb()) {
                            codedOutputStreamMicro.writeInt32(2, ya());
                        }
                        if (vT()) {
                            codedOutputStreamMicro.writeInt32(3, vS());
                        }
                        if (xS()) {
                            codedOutputStreamMicro.writeInt32(4, xR());
                        }
                        if (yd()) {
                            codedOutputStreamMicro.writeInt32(5, yc());
                        }
                        if (yf()) {
                            codedOutputStreamMicro.writeInt32(6, ye());
                        }
                    }

                    public int xR() {
                        return this.arX;
                    }

                    public boolean xS() {
                        return this.arW;
                    }

                    public int ya() {
                        return this.asi;
                    }

                    public boolean yb() {
                        return this.ash;
                    }

                    public int yc() {
                        return this.ask;
                    }

                    public boolean yd() {
                        return this.asj;
                    }

                    public int ye() {
                        return this.asn;
                    }

                    public boolean yf() {
                        return this.asl;
                    }
                }

                /* renamed from: com.baidu.f.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes20.dex */
                public static final class C0118b extends MessageMicro {
                    private boolean apm;
                    private boolean apt;
                    private boolean arr;
                    private boolean asA;
                    private boolean asC;
                    private boolean asE;
                    private boolean asp;
                    private boolean asr;
                    private boolean ast;
                    private boolean asw;
                    private boolean asy;
                    private String apn = "";
                    private List<Integer> aso = Collections.emptyList();
                    private int ars = 0;
                    private String asq = "";
                    private String ass = "";
                    private String asu = "";
                    private String apu = "";
                    private List<Integer> asv = Collections.emptyList();
                    private String asx = "";
                    private String asz = "";
                    private String asB = "";
                    private int asD = 0;
                    private int asF = 0;
                    private int apw = -1;

                    public C0118b cZ(int i) {
                        if (this.aso.isEmpty()) {
                            this.aso = new ArrayList();
                        }
                        this.aso.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0118b da(int i) {
                        this.arr = true;
                        this.ars = i;
                        return this;
                    }

                    public C0118b db(int i) {
                        if (this.asv.isEmpty()) {
                            this.asv = new ArrayList();
                        }
                        this.asv.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0118b dc(int i) {
                        this.asC = true;
                        this.asD = i;
                        return this;
                    }

                    public C0118b dd(int i) {
                        this.asE = true;
                        this.asF = i;
                        return this;
                    }

                    public C0118b eK(String str) {
                        this.apm = true;
                        this.apn = str;
                        return this;
                    }

                    public C0118b eL(String str) {
                        this.asp = true;
                        this.asq = str;
                        return this;
                    }

                    public C0118b eM(String str) {
                        this.asr = true;
                        this.ass = str;
                        return this;
                    }

                    public C0118b eN(String str) {
                        this.ast = true;
                        this.asu = str;
                        return this;
                    }

                    public C0118b eO(String str) {
                        this.apt = true;
                        this.apu = str;
                        return this;
                    }

                    public C0118b eP(String str) {
                        this.asw = true;
                        this.asx = str;
                        return this;
                    }

                    public C0118b eQ(String str) {
                        this.asy = true;
                        this.asz = str;
                        return this;
                    }

                    public C0118b eR(String str) {
                        this.asA = true;
                        this.asB = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.apw < 0) {
                            getSerializedSize();
                        }
                        return this.apw;
                    }

                    public String getIconUrl() {
                        return this.asx;
                    }

                    public String getName() {
                        return this.apn;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int i = 0;
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        int i2 = 0;
                        for (Integer num : yg()) {
                            i2 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i2;
                        }
                        int size = computeStringSize + i2 + (yg().size() * 1);
                        if (xo()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, xn());
                        }
                        if (yi()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, yh());
                        }
                        if (yk()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, yj());
                        }
                        if (ym()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, yl());
                        }
                        int computeStringSize2 = vo() ? size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : size;
                        for (Integer num2 : yn()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                        }
                        int size2 = computeStringSize2 + i + (yn().size() * 1);
                        if (yo()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (yq()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, yp());
                        }
                        if (ys()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, yr());
                        }
                        if (yu()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, yt());
                        }
                        if (yw()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, yv());
                        }
                        this.apw = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.apu;
                    }

                    public boolean hasName() {
                        return this.apm;
                    }

                    public boolean vo() {
                        return this.apt;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: w */
                    public C0118b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    eK(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    cZ(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    da(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eL(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eM(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    eN(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    eO(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    db(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    eP(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    eQ(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    eR(codedInputStreamMicro.readString());
                                    break;
                                case 96:
                                    dc(codedInputStreamMicro.readInt32());
                                    break;
                                case 104:
                                    dd(codedInputStreamMicro.readInt32());
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
                        for (Integer num : yg()) {
                            codedOutputStreamMicro.writeSInt32(2, num.intValue());
                        }
                        if (xo()) {
                            codedOutputStreamMicro.writeInt32(3, xn());
                        }
                        if (yi()) {
                            codedOutputStreamMicro.writeString(4, yh());
                        }
                        if (yk()) {
                            codedOutputStreamMicro.writeString(5, yj());
                        }
                        if (ym()) {
                            codedOutputStreamMicro.writeString(6, yl());
                        }
                        if (vo()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        for (Integer num2 : yn()) {
                            codedOutputStreamMicro.writeSInt32(8, num2.intValue());
                        }
                        if (yo()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (yq()) {
                            codedOutputStreamMicro.writeString(10, yp());
                        }
                        if (ys()) {
                            codedOutputStreamMicro.writeString(11, yr());
                        }
                        if (yu()) {
                            codedOutputStreamMicro.writeInt32(12, yt());
                        }
                        if (yw()) {
                            codedOutputStreamMicro.writeInt32(13, yv());
                        }
                    }

                    public int xn() {
                        return this.ars;
                    }

                    public boolean xo() {
                        return this.arr;
                    }

                    public List<Integer> yg() {
                        return this.aso;
                    }

                    public String yh() {
                        return this.asq;
                    }

                    public boolean yi() {
                        return this.asp;
                    }

                    public String yj() {
                        return this.ass;
                    }

                    public boolean yk() {
                        return this.asr;
                    }

                    public String yl() {
                        return this.asu;
                    }

                    public boolean ym() {
                        return this.ast;
                    }

                    public List<Integer> yn() {
                        return this.asv;
                    }

                    public boolean yo() {
                        return this.asw;
                    }

                    public String yp() {
                        return this.asz;
                    }

                    public boolean yq() {
                        return this.asy;
                    }

                    public String yr() {
                        return this.asB;
                    }

                    public boolean ys() {
                        return this.asA;
                    }

                    public int yt() {
                        return this.asD;
                    }

                    public boolean yu() {
                        return this.asC;
                    }

                    public int yv() {
                        return this.asF;
                    }

                    public boolean yw() {
                        return this.asE;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.arH.isEmpty()) {
                            this.arH = new ArrayList();
                        }
                        this.arH.add(aVar);
                    }
                    return this;
                }

                public c a(C0118b c0118b) {
                    if (c0118b != null) {
                        if (this.apU.isEmpty()) {
                            this.apU = new ArrayList();
                        }
                        this.apU.add(c0118b);
                    }
                    return this;
                }

                public c b(C0118b c0118b) {
                    if (c0118b != null) {
                        if (this.ase.isEmpty()) {
                            this.ase = new ArrayList();
                        }
                        this.ase.add(c0118b);
                    }
                    return this;
                }

                public c cC(int i) {
                    if (this.apT.isEmpty()) {
                        this.apT = new ArrayList();
                    }
                    this.apT.add(Integer.valueOf(i));
                    return this;
                }

                public c cD(int i) {
                    this.apE = true;
                    this.type_ = i;
                    return this;
                }

                public c cE(int i) {
                    this.arI = true;
                    this.arJ = i;
                    return this;
                }

                public c cF(int i) {
                    this.arK = true;
                    this.arL = i;
                    return this;
                }

                public c cG(int i) {
                    this.arM = true;
                    this.arN = i;
                    return this;
                }

                public c cH(int i) {
                    this.arO = true;
                    this.arP = i;
                    return this;
                }

                public c cI(int i) {
                    this.arQ = true;
                    this.arR = i;
                    return this;
                }

                public c cJ(int i) {
                    this.arS = true;
                    this.arT = i;
                    return this;
                }

                public c cK(int i) {
                    this.apF = true;
                    this.apG = i;
                    return this;
                }

                public c cL(int i) {
                    this.apH = true;
                    this.apI = i;
                    return this;
                }

                public c cM(int i) {
                    this.arU = true;
                    this.arV = i;
                    return this;
                }

                public c cN(int i) {
                    this.arW = true;
                    this.arX = i;
                    return this;
                }

                public c cO(int i) {
                    if (this.apM.isEmpty()) {
                        this.apM = new ArrayList();
                    }
                    this.apM.add(Integer.valueOf(i));
                    return this;
                }

                public c cP(int i) {
                    if (this.apN.isEmpty()) {
                        this.apN = new ArrayList();
                    }
                    this.apN.add(Integer.valueOf(i));
                    return this;
                }

                public c cQ(int i) {
                    if (this.arY.isEmpty()) {
                        this.arY = new ArrayList();
                    }
                    this.arY.add(Integer.valueOf(i));
                    return this;
                }

                public c cR(int i) {
                    this.arZ = true;
                    this.asa = i;
                    return this;
                }

                public c cS(int i) {
                    if (this.asb.isEmpty()) {
                        this.asb = new ArrayList();
                    }
                    this.asb.add(Integer.valueOf(i));
                    return this;
                }

                public c cT(int i) {
                    this.asc = true;
                    this.asd = i;
                    return this;
                }

                public c eH(String str) {
                    this.apP = true;
                    this.apQ = str;
                    return this;
                }

                public c eI(String str) {
                    this.apm = true;
                    this.apn = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apw < 0) {
                        getSerializedSize();
                    }
                    return this.apw;
                }

                public int getDirection() {
                    return this.arV;
                }

                public int getDistance() {
                    return this.apG;
                }

                public int getDuration() {
                    return this.apI;
                }

                public String getInstructions() {
                    return this.apQ;
                }

                public String getName() {
                    return this.apn;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int i2 = 0;
                    int i3 = 0;
                    for (Integer num : vG()) {
                        i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                    }
                    int size = 0 + i3 + (vG().size() * 1);
                    if (vD()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (xF()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, xE());
                    }
                    if (xH()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, xG());
                    }
                    if (xJ()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, xI());
                    }
                    if (xL()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, xK());
                    }
                    if (xN()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, xM());
                    }
                    if (xP()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, xO());
                    }
                    if (vw()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<a> it = xD().iterator();
                    while (true) {
                        i = size;
                        if (!it.hasNext()) {
                            break;
                        }
                        size = CodedOutputStreamMicro.computeMessageSize(13, it.next()) + i;
                    }
                    for (C0118b c0118b : vH()) {
                        i += CodedOutputStreamMicro.computeMessageSize(14, c0118b);
                    }
                    if (xQ()) {
                        i += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (xS()) {
                        i += CodedOutputStreamMicro.computeInt32Size(16, xR());
                    }
                    int i4 = 0;
                    for (Integer num2 : vA()) {
                        i4 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue()) + i4;
                    }
                    int size2 = i + i4 + (vA().size() * 2);
                    int i5 = 0;
                    for (Integer num3 : vB()) {
                        i5 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num3.intValue()) + i5;
                    }
                    int size3 = size2 + i5 + (vB().size() * 2);
                    int i6 = 0;
                    for (Integer num4 : xT()) {
                        i6 = CodedOutputStreamMicro.computeInt32SizeNoTag(num4.intValue()) + i6;
                    }
                    int size4 = size3 + i6 + (xT().size() * 2);
                    int computeInt32Size = xV() ? size4 + CodedOutputStreamMicro.computeInt32Size(20, xU()) : size4;
                    for (Integer num5 : xW()) {
                        i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num5.intValue());
                    }
                    int size5 = computeInt32Size + i2 + (xW().size() * 2);
                    if (xY()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, xX());
                    }
                    Iterator<C0118b> it2 = xZ().iterator();
                    while (true) {
                        int i7 = size5;
                        if (!it2.hasNext()) {
                            this.apw = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.apH;
                }

                public boolean hasName() {
                    return this.apm;
                }

                public boolean hasType() {
                    return this.apE;
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
                                cC(codedInputStreamMicro.readSInt32());
                                break;
                            case 18:
                                eH(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cD(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eI(codedInputStreamMicro.readString());
                                break;
                            case 40:
                                cE(codedInputStreamMicro.readInt32());
                                break;
                            case 48:
                                cF(codedInputStreamMicro.readInt32());
                                break;
                            case 56:
                                cG(codedInputStreamMicro.readInt32());
                                break;
                            case 64:
                                cH(codedInputStreamMicro.readInt32());
                                break;
                            case 72:
                                cI(codedInputStreamMicro.readInt32());
                                break;
                            case 80:
                                cJ(codedInputStreamMicro.readInt32());
                                break;
                            case 88:
                                cK(codedInputStreamMicro.readInt32());
                                break;
                            case 96:
                                cL(codedInputStreamMicro.readInt32());
                                break;
                            case 106:
                                a aVar = new a();
                                codedInputStreamMicro.readMessage(aVar);
                                a(aVar);
                                break;
                            case 114:
                                C0118b c0118b = new C0118b();
                                codedInputStreamMicro.readMessage(c0118b);
                                a(c0118b);
                                break;
                            case 120:
                                cM(codedInputStreamMicro.readInt32());
                                break;
                            case 128:
                                cN(codedInputStreamMicro.readInt32());
                                break;
                            case 136:
                                cO(codedInputStreamMicro.readSInt32());
                                break;
                            case 144:
                                cP(codedInputStreamMicro.readSInt32());
                                break;
                            case 152:
                                cQ(codedInputStreamMicro.readInt32());
                                break;
                            case 160:
                                cR(codedInputStreamMicro.readInt32());
                                break;
                            case 168:
                                cS(codedInputStreamMicro.readSInt32());
                                break;
                            case Opcodes.ARETURN /* 176 */:
                                cT(codedInputStreamMicro.readInt32());
                                break;
                            case 186:
                                C0118b c0118b2 = new C0118b();
                                codedInputStreamMicro.readMessage(c0118b2);
                                b(c0118b2);
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

                public List<Integer> vA() {
                    return this.apM;
                }

                public List<Integer> vB() {
                    return this.apN;
                }

                public boolean vD() {
                    return this.apP;
                }

                public List<Integer> vG() {
                    return this.apT;
                }

                public List<C0118b> vH() {
                    return this.apU;
                }

                public boolean vw() {
                    return this.apF;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Integer num : vG()) {
                        codedOutputStreamMicro.writeSInt32(1, num.intValue());
                    }
                    if (vD()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (xF()) {
                        codedOutputStreamMicro.writeInt32(5, xE());
                    }
                    if (xH()) {
                        codedOutputStreamMicro.writeInt32(6, xG());
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
                    if (xP()) {
                        codedOutputStreamMicro.writeInt32(10, xO());
                    }
                    if (vw()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    for (a aVar : xD()) {
                        codedOutputStreamMicro.writeMessage(13, aVar);
                    }
                    for (C0118b c0118b : vH()) {
                        codedOutputStreamMicro.writeMessage(14, c0118b);
                    }
                    if (xQ()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (xS()) {
                        codedOutputStreamMicro.writeInt32(16, xR());
                    }
                    for (Integer num2 : vA()) {
                        codedOutputStreamMicro.writeSInt32(17, num2.intValue());
                    }
                    for (Integer num3 : vB()) {
                        codedOutputStreamMicro.writeSInt32(18, num3.intValue());
                    }
                    for (Integer num4 : xT()) {
                        codedOutputStreamMicro.writeInt32(19, num4.intValue());
                    }
                    if (xV()) {
                        codedOutputStreamMicro.writeInt32(20, xU());
                    }
                    for (Integer num5 : xW()) {
                        codedOutputStreamMicro.writeSInt32(21, num5.intValue());
                    }
                    if (xY()) {
                        codedOutputStreamMicro.writeInt32(22, xX());
                    }
                    for (C0118b c0118b2 : xZ()) {
                        codedOutputStreamMicro.writeMessage(23, c0118b2);
                    }
                }

                public List<a> xD() {
                    return this.arH;
                }

                public int xE() {
                    return this.arJ;
                }

                public boolean xF() {
                    return this.arI;
                }

                public int xG() {
                    return this.arL;
                }

                public boolean xH() {
                    return this.arK;
                }

                public int xI() {
                    return this.arN;
                }

                public boolean xJ() {
                    return this.arM;
                }

                public int xK() {
                    return this.arP;
                }

                public boolean xL() {
                    return this.arO;
                }

                public int xM() {
                    return this.arR;
                }

                public boolean xN() {
                    return this.arQ;
                }

                public int xO() {
                    return this.arT;
                }

                public boolean xP() {
                    return this.arS;
                }

                public boolean xQ() {
                    return this.arU;
                }

                public int xR() {
                    return this.arX;
                }

                public boolean xS() {
                    return this.arW;
                }

                public List<Integer> xT() {
                    return this.arY;
                }

                public int xU() {
                    return this.asa;
                }

                public boolean xV() {
                    return this.arZ;
                }

                public List<Integer> xW() {
                    return this.asb;
                }

                public int xX() {
                    return this.asd;
                }

                public boolean xY() {
                    return this.asc;
                }

                public List<C0118b> xZ() {
                    return this.ase;
                }
            }

            public C0116b a(a aVar) {
                if (aVar != null) {
                    if (this.arx.isEmpty()) {
                        this.arx = new ArrayList();
                    }
                    this.arx.add(aVar);
                }
                return this;
            }

            public C0116b a(C0117b c0117b) {
                if (c0117b == null) {
                    return xw();
                }
                this.ary = true;
                this.arz = c0117b;
                return this;
            }

            public C0116b a(c cVar) {
                if (cVar != null) {
                    if (this.apO.isEmpty()) {
                        this.apO = new ArrayList();
                    }
                    this.apO.add(cVar);
                }
                return this;
            }

            public c cp(int i) {
                return this.apO.get(i);
            }

            public C0116b cq(int i) {
                if (this.apM.isEmpty()) {
                    this.apM = new ArrayList();
                }
                this.apM.add(Integer.valueOf(i));
                return this;
            }

            public C0116b cr(int i) {
                if (this.apN.isEmpty()) {
                    this.apN = new ArrayList();
                }
                this.apN.add(Integer.valueOf(i));
                return this;
            }

            public C0116b cs(int i) {
                this.apF = true;
                this.apG = i;
                return this;
            }

            public C0116b ct(int i) {
                this.apH = true;
                this.apI = i;
                return this;
            }

            public C0116b cu(int i) {
                this.arr = true;
                this.ars = i;
                return this;
            }

            public C0116b cv(int i) {
                this.art = true;
                this.aru = i;
                return this;
            }

            public C0116b cw(int i) {
                this.arv = true;
                this.arw = i;
                return this;
            }

            public C0116b eC(String str) {
                this.arn = true;
                this.aro = str;
                return this;
            }

            public C0116b eD(String str) {
                this.arp = true;
                this.arq = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public int getDistance() {
                return this.apG;
            }

            public int getDuration() {
                return this.apI;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int i2 = 0;
                int i3 = 0;
                for (Integer num : vA()) {
                    i3 = CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue()) + i3;
                }
                int size = (vA().size() * 1) + 0 + i3;
                for (Integer num2 : vB()) {
                    i2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(num2.intValue());
                }
                int size2 = size + i2 + (vB().size() * 1);
                if (xk()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, xj());
                }
                if (xm()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, xl());
                }
                if (vw()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (xo()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, xn());
                }
                if (xq()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, xp());
                }
                if (xs()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, xr());
                }
                Iterator<c> it = vC().iterator();
                while (true) {
                    i = size2;
                    if (!it.hasNext()) {
                        break;
                    }
                    size2 = CodedOutputStreamMicro.computeMessageSize(10, it.next()) + i;
                }
                for (a aVar : xt()) {
                    i += CodedOutputStreamMicro.computeMessageSize(11, aVar);
                }
                if (xu()) {
                    i += CodedOutputStreamMicro.computeMessageSize(12, xv());
                }
                this.apw = i;
                return i;
            }

            public boolean hasDuration() {
                return this.apH;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: r */
            public C0116b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            cq(codedInputStreamMicro.readSInt32());
                            break;
                        case 16:
                            cr(codedInputStreamMicro.readSInt32());
                            break;
                        case 26:
                            eC(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eD(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            cs(codedInputStreamMicro.readInt32());
                            break;
                        case 48:
                            ct(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            cu(codedInputStreamMicro.readInt32());
                            break;
                        case 64:
                            cv(codedInputStreamMicro.readInt32());
                            break;
                        case 72:
                            cw(codedInputStreamMicro.readInt32());
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
                            C0117b c0117b = new C0117b();
                            codedInputStreamMicro.readMessage(c0117b);
                            a(c0117b);
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

            public List<Integer> vA() {
                return this.apM;
            }

            public List<Integer> vB() {
                return this.apN;
            }

            public List<c> vC() {
                return this.apO;
            }

            public boolean vw() {
                return this.apF;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Integer num : vA()) {
                    codedOutputStreamMicro.writeSInt32(1, num.intValue());
                }
                for (Integer num2 : vB()) {
                    codedOutputStreamMicro.writeSInt32(2, num2.intValue());
                }
                if (xk()) {
                    codedOutputStreamMicro.writeString(3, xj());
                }
                if (xm()) {
                    codedOutputStreamMicro.writeString(4, xl());
                }
                if (vw()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (xo()) {
                    codedOutputStreamMicro.writeInt32(7, xn());
                }
                if (xq()) {
                    codedOutputStreamMicro.writeInt32(8, xp());
                }
                if (xs()) {
                    codedOutputStreamMicro.writeInt32(9, xr());
                }
                for (c cVar : vC()) {
                    codedOutputStreamMicro.writeMessage(10, cVar);
                }
                for (a aVar : xt()) {
                    codedOutputStreamMicro.writeMessage(11, aVar);
                }
                if (xu()) {
                    codedOutputStreamMicro.writeMessage(12, xv());
                }
            }

            public int xi() {
                return this.apO.size();
            }

            public String xj() {
                return this.aro;
            }

            public boolean xk() {
                return this.arn;
            }

            public String xl() {
                return this.arq;
            }

            public boolean xm() {
                return this.arp;
            }

            public int xn() {
                return this.ars;
            }

            public boolean xo() {
                return this.arr;
            }

            public int xp() {
                return this.aru;
            }

            public boolean xq() {
                return this.art;
            }

            public int xr() {
                return this.arw;
            }

            public boolean xs() {
                return this.arv;
            }

            public List<a> xt() {
                return this.arx;
            }

            public boolean xu() {
                return this.ary;
            }

            public C0117b xv() {
                return this.arz;
            }

            public C0116b xw() {
                this.ary = false;
                this.arz = null;
                return this;
            }
        }

        /* loaded from: classes20.dex */
        public static final class c extends MessageMicro {
            private boolean asG;
            private int asH = 0;
            private List<Integer> asI = Collections.emptyList();
            private int apw = -1;

            public c de(int i) {
                this.asG = true;
                this.asH = i;
                return this;
            }

            public c df(int i) {
                if (this.asI.isEmpty()) {
                    this.asI = new ArrayList();
                }
                this.asI.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yy() ? CodedOutputStreamMicro.computeInt32Size(1, yx()) + 0 : 0;
                for (Integer num : yz()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yz().size() * 1);
                this.apw = size;
                return size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yy()) {
                    codedOutputStreamMicro.writeInt32(1, yx());
                }
                for (Integer num : yz()) {
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
                            de(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            df(codedInputStreamMicro.readSInt32());
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

            public int yx() {
                return this.asH;
            }

            public boolean yy() {
                return this.asG;
            }

            public List<Integer> yz() {
                return this.asI;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0119d extends MessageMicro {
            private boolean asJ;
            private int asK = 0;
            private int apw = -1;

            public C0119d dg(int i) {
                this.asJ = true;
                this.asK = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public int getLightNum() {
                return this.asK;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yA() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.apw = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yA()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: y */
            public C0119d mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            dg(codedInputStreamMicro.readInt32());
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

            public boolean yA() {
                return this.asJ;
            }
        }

        /* loaded from: classes20.dex */
        public static final class e extends MessageMicro {
            private boolean aqj;
            private boolean aqt;
            private boolean asL;
            private boolean asN;
            private int asM = 0;
            private String asO = "";
            private a asP = null;
            private List<a> aqv = Collections.emptyList();
            private c aqk = null;
            private int apw = -1;

            /* loaded from: classes20.dex */
            public static final class a extends MessageMicro {
                private boolean apm;
                private boolean apt;
                private boolean aqJ;
                private boolean aqQ;
                private boolean aqS;
                private String aqK = "";
                private String apn = "";
                private String apu = "";
                private List<Integer> aqP = Collections.emptyList();
                private String aqR = "";
                private String aqT = "";
                private int apw = -1;

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
                                eT(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                eU(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                eV(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                di(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                eW(codedInputStreamMicro.readString());
                                break;
                            case 50:
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

                public a di(int i) {
                    if (this.aqP.isEmpty()) {
                        this.aqP = new ArrayList();
                    }
                    this.aqP.add(Integer.valueOf(i));
                    return this;
                }

                public a eT(String str) {
                    this.aqJ = true;
                    this.aqK = str;
                    return this;
                }

                public a eU(String str) {
                    this.apm = true;
                    this.apn = str;
                    return this;
                }

                public a eV(String str) {
                    this.apt = true;
                    this.apu = str;
                    return this;
                }

                public a eW(String str) {
                    this.aqQ = true;
                    this.aqR = str;
                    return this;
                }

                public a eX(String str) {
                    this.aqS = true;
                    this.aqT = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apw < 0) {
                        getSerializedSize();
                    }
                    return this.apw;
                }

                public String getFloor() {
                    return this.aqR;
                }

                public String getName() {
                    return this.apn;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeStringSize = wA() ? CodedOutputStreamMicro.computeStringSize(1, wz()) + 0 : 0;
                    if (hasName()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    int computeStringSize2 = vo() ? computeStringSize + CodedOutputStreamMicro.computeStringSize(3, getUid()) : computeStringSize;
                    for (Integer num : wF()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                    }
                    int size = computeStringSize2 + i + (wF().size() * 1);
                    if (wG()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (wI()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, wH());
                    }
                    this.apw = size;
                    return size;
                }

                public String getUid() {
                    return this.apu;
                }

                public boolean hasName() {
                    return this.apm;
                }

                public boolean vo() {
                    return this.apt;
                }

                public boolean wA() {
                    return this.aqJ;
                }

                public List<Integer> wF() {
                    return this.aqP;
                }

                public boolean wG() {
                    return this.aqQ;
                }

                public String wH() {
                    return this.aqT;
                }

                public boolean wI() {
                    return this.aqS;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (wA()) {
                        codedOutputStreamMicro.writeString(1, wz());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (vo()) {
                        codedOutputStreamMicro.writeString(3, getUid());
                    }
                    for (Integer num : wF()) {
                        codedOutputStreamMicro.writeSInt32(4, num.intValue());
                    }
                    if (wG()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (wI()) {
                        codedOutputStreamMicro.writeString(6, wH());
                    }
                }

                public String wz() {
                    return this.aqK;
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return yF();
                }
                this.aqt = true;
                this.asP = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.aqv.isEmpty()) {
                        this.aqv = new ArrayList();
                    }
                    this.aqv.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return yG();
                }
                this.aqj = true;
                this.aqk = cVar;
                return this;
            }

            public e dh(int i) {
                this.asL = true;
                this.asM = i;
                return this;
            }

            public e eS(String str) {
                this.asN = true;
                this.asO = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public String getLabel() {
                return this.asO;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i;
                int computeInt32Size = yC() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, yB()) : 0;
                if (yD()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, yE());
                }
                Iterator<a> it = wk().iterator();
                while (true) {
                    i = computeInt32Size;
                    if (!it.hasNext()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
                }
                if (vU()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, vV());
                }
                this.apw = i;
                return i;
            }

            public boolean hasStart() {
                return this.aqt;
            }

            public boolean vU() {
                return this.aqj;
            }

            public c vV() {
                return this.aqk;
            }

            public List<a> wk() {
                return this.aqv;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yC()) {
                    codedOutputStreamMicro.writeInt32(1, yB());
                }
                if (yD()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, yE());
                }
                for (a aVar : wk()) {
                    codedOutputStreamMicro.writeMessage(4, aVar);
                }
                if (vU()) {
                    codedOutputStreamMicro.writeMessage(5, vV());
                }
            }

            public int yB() {
                return this.asM;
            }

            public boolean yC() {
                return this.asL;
            }

            public boolean yD() {
                return this.asN;
            }

            public a yE() {
                return this.asP;
            }

            public e yF() {
                this.aqt = false;
                this.asP = null;
                return this;
            }

            public e yG() {
                this.aqj = false;
                this.aqk = null;
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
                            dh(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            eS(codedInputStreamMicro.readString());
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

        /* loaded from: classes20.dex */
        public static final class f extends MessageMicro {
            private boolean asQ;
            private boolean asS;
            private String asR = "";
            private String asT = "";
            private int apw = -1;

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
                            eY(codedInputStreamMicro.readString());
                            break;
                        case 18:
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

            public f eY(String str) {
                this.asQ = true;
                this.asR = str;
                return this;
            }

            public f eZ(String str) {
                this.asS = true;
                this.asT = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public String getContent() {
                return this.asR;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = yH() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (yJ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, yI());
                }
                this.apw = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yH()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (yJ()) {
                    codedOutputStreamMicro.writeString(2, yI());
                }
            }

            public boolean yH() {
                return this.asQ;
            }

            public String yI() {
                return this.asT;
            }

            public boolean yJ() {
                return this.asS;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return wP();
            }
            this.aqW = true;
            this.aqX = aVar;
            return this;
        }

        public b a(C0116b c0116b) {
            if (c0116b != null) {
                if (this.apJ.isEmpty()) {
                    this.apJ = new ArrayList();
                }
                this.apJ.add(c0116b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.are.isEmpty()) {
                    this.are = new ArrayList();
                }
                this.are.add(cVar);
            }
            return this;
        }

        public b a(C0119d c0119d) {
            if (c0119d == null) {
                return wV();
            }
            this.ara = true;
            this.arb = c0119d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return wY();
            }
            this.arc = true;
            this.ard = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return wS();
            }
            this.aqY = true;
            this.aqZ = fVar;
            return this;
        }

        public C0116b cl(int i) {
            return this.apJ.get(i);
        }

        public b eB(String str) {
            this.arf = true;
            this.arg = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apw < 0) {
                getSerializedSize();
            }
            return this.apw;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int i2 = 0;
            Iterator<C0116b> it = vx().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
            }
            if (wN()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, wO());
            }
            if (wQ()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, wR());
            }
            if (wT()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, wU());
            }
            if (wW()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, wX());
            }
            for (c cVar : wZ()) {
                i += CodedOutputStreamMicro.computeMessageSize(6, cVar);
            }
            if (xb()) {
                i += CodedOutputStreamMicro.computeStringSize(7, xa());
            }
            this.apw = i;
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
                        C0116b c0116b = new C0116b();
                        codedInputStreamMicro.readMessage(c0116b);
                        a(c0116b);
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
                        C0119d c0119d = new C0119d();
                        codedInputStreamMicro.readMessage(c0119d);
                        a(c0119d);
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

        public List<C0116b> vx() {
            return this.apJ;
        }

        public int wM() {
            return this.apJ.size();
        }

        public boolean wN() {
            return this.aqW;
        }

        public a wO() {
            return this.aqX;
        }

        public b wP() {
            this.aqW = false;
            this.aqX = null;
            return this;
        }

        public boolean wQ() {
            return this.aqY;
        }

        public f wR() {
            return this.aqZ;
        }

        public b wS() {
            this.aqY = false;
            this.aqZ = null;
            return this;
        }

        public boolean wT() {
            return this.ara;
        }

        public C0119d wU() {
            return this.arb;
        }

        public b wV() {
            this.ara = false;
            this.arb = null;
            return this;
        }

        public boolean wW() {
            return this.arc;
        }

        public e wX() {
            return this.ard;
        }

        public b wY() {
            this.arc = false;
            this.ard = null;
            return this;
        }

        public List<c> wZ() {
            return this.are;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (C0116b c0116b : vx()) {
                codedOutputStreamMicro.writeMessage(1, c0116b);
            }
            if (wN()) {
                codedOutputStreamMicro.writeMessage(2, wO());
            }
            if (wQ()) {
                codedOutputStreamMicro.writeMessage(3, wR());
            }
            if (wT()) {
                codedOutputStreamMicro.writeMessage(4, wU());
            }
            if (wW()) {
                codedOutputStreamMicro.writeMessage(5, wX());
            }
            for (c cVar : wZ()) {
                codedOutputStreamMicro.writeMessage(6, cVar);
            }
            if (xb()) {
                codedOutputStreamMicro.writeString(7, xa());
            }
        }

        public String xa() {
            return this.arg;
        }

        public boolean xb() {
            return this.arf;
        }
    }

    /* loaded from: classes20.dex */
    public static final class c extends MessageMicro {
        private boolean apF;
        private boolean apH;
        private boolean asW;
        private String asU = "";
        private String asV = "";
        private String asX = "";
        private List<a> asY = Collections.emptyList();
        private int apw = -1;

        /* loaded from: classes20.dex */
        public static final class a extends MessageMicro {
            private boolean asZ;
            private boolean atb;
            private boolean atd;
            private boolean atf;
            private String ata = "";
            private String atc = "";
            private String ate = "";
            private String atg = "";
            private int apw = -1;

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
                            fd(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fe(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            ff(codedInputStreamMicro.readString());
                            break;
                        case 34:
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

            public a fd(String str) {
                this.asZ = true;
                this.ata = str;
                return this;
            }

            public a fe(String str) {
                this.atb = true;
                this.atc = str;
                return this;
            }

            public a ff(String str) {
                this.atd = true;
                this.ate = str;
                return this;
            }

            public a fg(String str) {
                this.atf = true;
                this.atg = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apw < 0) {
                    getSerializedSize();
                }
                return this.apw;
            }

            public String getDesc() {
                return this.atg;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = yO() ? 0 + CodedOutputStreamMicro.computeStringSize(1, yN()) : 0;
                if (yQ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, yP());
                }
                if (yS()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, yR());
                }
                if (yT()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.apw = computeStringSize;
                return computeStringSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (yO()) {
                    codedOutputStreamMicro.writeString(1, yN());
                }
                if (yQ()) {
                    codedOutputStreamMicro.writeString(2, yP());
                }
                if (yS()) {
                    codedOutputStreamMicro.writeString(3, yR());
                }
                if (yT()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public String yN() {
                return this.ata;
            }

            public boolean yO() {
                return this.asZ;
            }

            public String yP() {
                return this.atc;
            }

            public boolean yQ() {
                return this.atb;
            }

            public String yR() {
                return this.ate;
            }

            public boolean yS() {
                return this.atd;
            }

            public boolean yT() {
                return this.atf;
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
                        fa(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        fb(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fc(codedInputStreamMicro.readString());
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
                if (this.asY.isEmpty()) {
                    this.asY = new ArrayList();
                }
                this.asY.add(aVar);
            }
            return this;
        }

        public c fa(String str) {
            this.apF = true;
            this.asU = str;
            return this;
        }

        public c fb(String str) {
            this.apH = true;
            this.asV = str;
            return this;
        }

        public c fc(String str) {
            this.asW = true;
            this.asX = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apw < 0) {
                getSerializedSize();
            }
            return this.apw;
        }

        public String getDistance() {
            return this.asU;
        }

        public String getDuration() {
            return this.asV;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = vw() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (yL()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, yK());
            }
            Iterator<a> it = yM().iterator();
            while (true) {
                int i = computeStringSize;
                if (!it.hasNext()) {
                    this.apw = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.apH;
        }

        public boolean vw() {
            return this.apF;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vw()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (yL()) {
                codedOutputStreamMicro.writeString(3, yK());
            }
            for (a aVar : yM()) {
                codedOutputStreamMicro.writeMessage(4, aVar);
            }
        }

        public String yK() {
            return this.asX;
        }

        public boolean yL() {
            return this.asW;
        }

        public List<a> yM() {
            return this.asY;
        }
    }

    public d a(com.baidu.f.a.a aVar) {
        if (aVar == null) {
            return wb();
        }
        this.aqm = true;
        this.aqn = aVar;
        return this;
    }

    public d a(com.baidu.f.a.b bVar) {
        if (bVar != null) {
            if (this.aqo.isEmpty()) {
                this.aqo = new ArrayList();
            }
            this.aqo.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return vY();
        }
        this.apx = true;
        this.aql = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.apz.isEmpty()) {
                this.apz = new ArrayList();
            }
            this.apz.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return vW();
        }
        this.aqj = true;
        this.aqk = cVar;
        return this;
    }

    public b bY(int i) {
        return this.apz.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apw < 0) {
            getSerializedSize();
        }
        return this.apw;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        Iterator<b> it = vt().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = CodedOutputStreamMicro.computeMessageSize(1, it.next()) + i;
        }
        if (vU()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, vV());
        }
        if (vq()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, vX());
        }
        if (vZ()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, wa());
        }
        for (com.baidu.f.a.b bVar : wc()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, bVar);
        }
        this.apw = i;
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

    public boolean vU() {
        return this.aqj;
    }

    public c vV() {
        return this.aqk;
    }

    public d vW() {
        this.aqj = false;
        this.aqk = null;
        return this;
    }

    public a vX() {
        return this.aql;
    }

    public d vY() {
        this.apx = false;
        this.aql = null;
        return this;
    }

    public boolean vZ() {
        return this.aqm;
    }

    public boolean vq() {
        return this.apx;
    }

    public List<b> vt() {
        return this.apz;
    }

    public int vu() {
        return this.apz.size();
    }

    public com.baidu.f.a.a wa() {
        return this.aqn;
    }

    public d wb() {
        this.aqm = false;
        this.aqn = null;
        return this;
    }

    public List<com.baidu.f.a.b> wc() {
        return this.aqo;
    }

    public int wd() {
        return this.aqo.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (b bVar : vt()) {
            codedOutputStreamMicro.writeMessage(1, bVar);
        }
        if (vU()) {
            codedOutputStreamMicro.writeMessage(2, vV());
        }
        if (vq()) {
            codedOutputStreamMicro.writeMessage(3, vX());
        }
        if (vZ()) {
            codedOutputStreamMicro.writeMessage(4, wa());
        }
        for (com.baidu.f.a.b bVar2 : wc()) {
            codedOutputStreamMicro.writeMessage(5, bVar2);
        }
    }
}
