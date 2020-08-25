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
    private boolean apv;
    private boolean aqh;
    private boolean aqk;
    private c aqi = null;
    private List<b> apx = Collections.emptyList();
    private a aqj = null;
    private com.baidu.f.a.a aql = null;
    private List<com.baidu.f.a.b> aqm = Collections.emptyList();
    private int apu = -1;

    /* loaded from: classes20.dex */
    public static final class a extends MessageMicro {
        private boolean apA;
        private boolean aqB;
        private boolean aqD;
        private boolean aqF;
        private boolean aqn;
        private boolean aqp;
        private boolean aqr;
        private boolean aqu;
        private boolean aqw;
        private boolean aqz;
        private int apB = 0;
        private String aqo = "";
        private int aqq = 0;
        private c aqs = null;
        private List<C0114a> aqt = Collections.emptyList();
        private int aqv = 0;
        private C0115d aqx = null;
        private List<b> aqy = Collections.emptyList();
        private int aqA = 0;
        private String aqC = "";
        private int aqE = 0;
        private String aqG = "";
        private int apu = -1;

        /* renamed from: com.baidu.f.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0114a extends MessageMicro {
            private boolean apr;
            private boolean aqH;
            private boolean aqJ;
            private boolean aqL;
            private boolean aqO;
            private boolean aqQ;
            private String aqI = "";
            private String aqK = "";
            private String aps = "";
            private boolean aqM = false;
            private List<Integer> aqN = Collections.emptyList();
            private String aqP = "";
            private String aqR = "";
            private int apu = -1;

            public C0114a aR(boolean z) {
                this.aqL = true;
                this.aqM = z;
                return this;
            }

            public int cg(int i) {
                return this.aqN.get(i).intValue();
            }

            public C0114a ch(int i) {
                if (this.aqN.isEmpty()) {
                    this.aqN = new ArrayList();
                }
                this.aqN.add(Integer.valueOf(i));
                return this;
            }

            public C0114a en(String str) {
                this.aqH = true;
                this.aqI = str;
                return this;
            }

            public C0114a eo(String str) {
                this.aqJ = true;
                this.aqK = str;
                return this;
            }

            public C0114a ep(String str) {
                this.apr = true;
                this.aps = str;
                return this;
            }

            public C0114a eq(String str) {
                this.aqO = true;
                this.aqP = str;
                return this;
            }

            public C0114a er(String str) {
                this.aqQ = true;
                this.aqR = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public String getFloor() {
                return this.aqP;
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
                this.apu = size;
                return size;
            }

            public String getUid() {
                return this.aps;
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
                            en(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eo(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            ep(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aR(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            ch(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            eq(codedInputStreamMicro.readString());
                            break;
                        case 58:
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

            public boolean vo() {
                return this.apr;
            }

            public boolean wA() {
                return this.aqH;
            }

            public String wB() {
                return this.aqK;
            }

            public boolean wC() {
                return this.aqJ;
            }

            public boolean wD() {
                return this.aqM;
            }

            public boolean wE() {
                return this.aqL;
            }

            public List<Integer> wF() {
                return this.aqN;
            }

            public boolean wG() {
                return this.aqO;
            }

            public String wH() {
                return this.aqR;
            }

            public boolean wI() {
                return this.aqQ;
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
                return this.aqI;
            }
        }

        /* loaded from: classes20.dex */
        public static final class b extends MessageMicro {
            private boolean ape;
            private boolean aqS;
            private int apf = 0;
            private String aqT = "";
            private int apu = -1;

            public b ci(int i) {
                this.ape = true;
                this.apf = i;
                return this;
            }

            public b es(String str) {
                this.aqS = true;
                this.aqT = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public int getCode() {
                return this.apf;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vh() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wK()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wJ());
                }
                this.apu = computeInt32Size;
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

            public boolean vh() {
                return this.ape;
            }

            public String wJ() {
                return this.aqT;
            }

            public boolean wK() {
                return this.aqS;
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
            private boolean apr;
            private boolean aqH;
            private boolean aqJ;
            private boolean aqL;
            private boolean aqO;
            private boolean aqQ;
            private String aqI = "";
            private String aqK = "";
            private String aps = "";
            private boolean aqM = false;
            private List<Integer> aqN = Collections.emptyList();
            private String aqP = "";
            private String aqR = "";
            private int apu = -1;

            public c aS(boolean z) {
                this.aqL = true;
                this.aqM = z;
                return this;
            }

            public int cg(int i) {
                return this.aqN.get(i).intValue();
            }

            public c cj(int i) {
                if (this.aqN.isEmpty()) {
                    this.aqN = new ArrayList();
                }
                this.aqN.add(Integer.valueOf(i));
                return this;
            }

            public c et(String str) {
                this.aqH = true;
                this.aqI = str;
                return this;
            }

            public c eu(String str) {
                this.aqJ = true;
                this.aqK = str;
                return this;
            }

            public c ev(String str) {
                this.apr = true;
                this.aps = str;
                return this;
            }

            public c ew(String str) {
                this.aqO = true;
                this.aqP = str;
                return this;
            }

            public c ey(String str) {
                this.aqQ = true;
                this.aqR = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public String getFloor() {
                return this.aqP;
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
                this.apu = size;
                return size;
            }

            public String getUid() {
                return this.aps;
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
                            et(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eu(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            ev(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            aS(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            cj(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            ew(codedInputStreamMicro.readString());
                            break;
                        case 58:
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

            public boolean vo() {
                return this.apr;
            }

            public boolean wA() {
                return this.aqH;
            }

            public String wB() {
                return this.aqK;
            }

            public boolean wC() {
                return this.aqJ;
            }

            public boolean wD() {
                return this.aqM;
            }

            public boolean wE() {
                return this.aqL;
            }

            public List<Integer> wF() {
                return this.aqN;
            }

            public boolean wG() {
                return this.aqO;
            }

            public String wH() {
                return this.aqR;
            }

            public boolean wI() {
                return this.aqQ;
            }

            public int wL() {
                return this.aqN.size();
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
                return this.aqI;
            }
        }

        /* renamed from: com.baidu.f.a.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0115d extends MessageMicro {
            private boolean ape;
            private boolean aqS;
            private int apf = 0;
            private String aqT = "";
            private int apu = -1;

            public C0115d ck(int i) {
                this.ape = true;
                this.apf = i;
                return this;
            }

            public C0115d ez(String str) {
                this.aqS = true;
                this.aqT = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public int getCode() {
                return this.apf;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = vh() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (wK()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, wJ());
                }
                this.apu = computeInt32Size;
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

            public boolean vh() {
                return this.ape;
            }

            public String wJ() {
                return this.aqT;
            }

            public boolean wK() {
                return this.aqS;
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
                if (this.aqt.isEmpty()) {
                    this.aqt = new ArrayList();
                }
                this.aqt.add(c0114a);
            }
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                if (this.aqy.isEmpty()) {
                    this.aqy = new ArrayList();
                }
                this.aqy.add(bVar);
            }
            return this;
        }

        public a a(c cVar) {
            if (cVar == null) {
                return wj();
            }
            this.aqr = true;
            this.aqs = cVar;
            return this;
        }

        public a a(C0115d c0115d) {
            if (c0115d == null) {
                return wp();
            }
            this.aqw = true;
            this.aqx = c0115d;
            return this;
        }

        public a bZ(int i) {
            this.apA = true;
            this.apB = i;
            return this;
        }

        public a ca(int i) {
            this.aqp = true;
            this.aqq = i;
            return this;
        }

        public C0114a cb(int i) {
            return this.aqt.get(i);
        }

        public a cc(int i) {
            this.aqu = true;
            this.aqv = i;
            return this;
        }

        public b cd(int i) {
            return this.aqy.get(i);
        }

        public a ce(int i) {
            this.aqz = true;
            this.aqA = i;
            return this;
        }

        public a cf(int i) {
            this.aqD = true;
            this.aqE = i;
            return this;
        }

        public a ek(String str) {
            this.aqn = true;
            this.aqo = str;
            return this;
        }

        public a el(String str) {
            this.aqB = true;
            this.aqC = str;
            return this;
        }

        public a em(String str) {
            this.aqF = true;
            this.aqG = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apu < 0) {
                getSerializedSize();
            }
            return this.apu;
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
            this.apu = i;
            return i;
        }

        public int getTotal() {
            return this.apB;
        }

        public boolean hasStart() {
            return this.aqr;
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
                        ek(codedInputStreamMicro.readString());
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
                        el(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        cf(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
                        em(codedInputStreamMicro.readString());
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
            return this.apA;
        }

        public String we() {
            return this.aqo;
        }

        public boolean wf() {
            return this.aqn;
        }

        public int wg() {
            return this.aqq;
        }

        public boolean wh() {
            return this.aqp;
        }

        public c wi() {
            return this.aqs;
        }

        public a wj() {
            this.aqr = false;
            this.aqs = null;
            return this;
        }

        public List<C0114a> wk() {
            return this.aqt;
        }

        public int wl() {
            return this.aqv;
        }

        public boolean wm() {
            return this.aqu;
        }

        public boolean wn() {
            return this.aqw;
        }

        public C0115d wo() {
            return this.aqx;
        }

        public a wp() {
            this.aqw = false;
            this.aqx = null;
            return this;
        }

        public List<b> wq() {
            return this.aqy;
        }

        public int wr() {
            return this.aqA;
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
            return this.aqz;
        }

        public String wt() {
            return this.aqC;
        }

        public boolean wu() {
            return this.aqB;
        }

        public int wv() {
            return this.aqE;
        }

        public boolean ww() {
            return this.aqD;
        }

        public String wx() {
            return this.aqG;
        }

        public boolean wy() {
            return this.aqF;
        }
    }

    /* loaded from: classes20.dex */
    public static final class b extends MessageMicro {
        private boolean aqU;
        private boolean aqW;
        private boolean aqY;
        private boolean ara;
        private boolean ard;
        private List<C0116b> apH = Collections.emptyList();
        private a aqV = null;
        private f aqX = null;
        private C0119d aqZ = null;
        private e arb = null;
        private List<c> arc = Collections.emptyList();
        private String are = "";
        private int apu = -1;

        /* loaded from: classes20.dex */
        public static final class a extends MessageMicro {
            private boolean arf;
            private boolean arh;
            private boolean arj;
            private int arg = 0;
            private int ari = 0;
            private int ark = 0;
            private int apu = -1;

            public a cm(int i) {
                this.arf = true;
                this.arg = i;
                return this;
            }

            public a cn(int i) {
                this.arh = true;
                this.ari = i;
                return this;
            }

            public a co(int i) {
                this.arj = true;
                this.ark = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
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
                this.apu = computeInt32Size;
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
                return this.arg;
            }

            public boolean xd() {
                return this.arf;
            }

            public int xe() {
                return this.ari;
            }

            public boolean xf() {
                return this.arh;
            }

            public int xg() {
                return this.ark;
            }

            public boolean xh() {
                return this.arj;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0116b extends MessageMicro {
            private boolean apD;
            private boolean apF;
            private boolean arl;
            private boolean arn;
            private boolean arp;
            private boolean arr;
            private boolean art;
            private boolean arw;
            private List<c> apM = Collections.emptyList();
            private List<Integer> apK = Collections.emptyList();
            private List<Integer> apL = Collections.emptyList();
            private String arm = "";
            private String aro = "";
            private int apE = 0;
            private int apG = 0;
            private int arq = 0;
            private int ars = 0;
            private int aru = 0;
            private List<a> arv = Collections.emptyList();
            private C0117b arx = null;
            private int apu = -1;

            /* renamed from: com.baidu.f.a.d$b$b$a */
            /* loaded from: classes20.dex */
            public static final class a extends MessageMicro {
                private boolean apC;
                private boolean aqO;
                private boolean aqQ;
                private boolean arA;
                private boolean ary;
                private int type_ = 0;
                private int arz = 0;
                private String arB = "";
                private List<Integer> apV = Collections.emptyList();
                private String aqP = "";
                private String aqR = "";
                private int apu = -1;

                public a cx(int i) {
                    this.apC = true;
                    this.type_ = i;
                    return this;
                }

                public a cy(int i) {
                    this.ary = true;
                    this.arz = i;
                    return this;
                }

                public a cz(int i) {
                    if (this.apV.isEmpty()) {
                        this.apV = new ArrayList();
                    }
                    this.apV.add(Integer.valueOf(i));
                    return this;
                }

                public a eD(String str) {
                    this.arA = true;
                    this.arB = str;
                    return this;
                }

                public a eE(String str) {
                    this.aqO = true;
                    this.aqP = str;
                    return this;
                }

                public a eF(String str) {
                    this.aqQ = true;
                    this.aqR = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apu < 0) {
                        getSerializedSize();
                    }
                    return this.apu;
                }

                public String getFloor() {
                    return this.aqP;
                }

                public String getInfo() {
                    return this.arB;
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
                    this.apu = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.apC;
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
                                eD(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                cz(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eE(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eF(codedInputStreamMicro.readString());
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
                    return this.apV;
                }

                public boolean wG() {
                    return this.aqO;
                }

                public String wH() {
                    return this.aqR;
                }

                public boolean wI() {
                    return this.aqQ;
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
                    return this.arz;
                }

                public boolean xy() {
                    return this.ary;
                }

                public boolean xz() {
                    return this.arA;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$b  reason: collision with other inner class name */
            /* loaded from: classes20.dex */
            public static final class C0117b extends MessageMicro {
                private boolean arC;
                private boolean hasNext;
                private int arD = 0;
                private int arE = 0;
                private int apu = -1;

                public C0117b cA(int i) {
                    this.arC = true;
                    this.arD = i;
                    return this;
                }

                public C0117b cB(int i) {
                    this.hasNext = true;
                    this.arE = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apu < 0) {
                        getSerializedSize();
                    }
                    return this.apu;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = xB() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, xA()) : 0;
                    if (hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, xC());
                    }
                    this.apu = computeInt32Size;
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
                    return this.arD;
                }

                public boolean xB() {
                    return this.arC;
                }

                public int xC() {
                    return this.arE;
                }
            }

            /* renamed from: com.baidu.f.a.d$b$b$c */
            /* loaded from: classes20.dex */
            public static final class c extends MessageMicro {
                private boolean apC;
                private boolean apD;
                private boolean apF;
                private boolean apN;
                private boolean apj;
                private boolean arG;
                private boolean arI;
                private boolean arK;
                private boolean arM;
                private boolean arO;
                private boolean arQ;
                private boolean arS;
                private boolean arU;
                private boolean arX;
                private boolean asa;
                private List<a> arF = Collections.emptyList();
                private List<C0118b> apS = Collections.emptyList();
                private List<Integer> apR = Collections.emptyList();
                private String apO = "";
                private int type_ = 0;
                private String apl = "";
                private int arH = 0;
                private int arJ = 0;
                private int arL = 0;
                private int arN = 0;
                private int arP = 0;
                private int arR = 0;
                private int apE = 0;
                private int apG = 0;
                private int arT = 0;
                private int arV = 0;
                private List<Integer> apK = Collections.emptyList();
                private List<Integer> apL = Collections.emptyList();
                private List<Integer> arW = Collections.emptyList();
                private int arY = 0;
                private List<Integer> arZ = Collections.emptyList();
                private int asb = 0;
                private List<C0118b> asc = Collections.emptyList();
                private int apu = -1;

                /* renamed from: com.baidu.f.a.d$b$b$c$a */
                /* loaded from: classes20.dex */
                public static final class a extends MessageMicro {
                    private boolean aqf;
                    private boolean arU;
                    private boolean asd;
                    private boolean asf;
                    private boolean ash;
                    private boolean asj;
                    private String ase = "";
                    private int asg = 0;
                    private int aqg = 0;
                    private int arV = 0;
                    private int asi = 0;
                    private int ask = 0;
                    private int apu = -1;

                    public a cU(int i) {
                        this.asf = true;
                        this.asg = i;
                        return this;
                    }

                    public a cV(int i) {
                        this.aqf = true;
                        this.aqg = i;
                        return this;
                    }

                    public a cW(int i) {
                        this.arU = true;
                        this.arV = i;
                        return this;
                    }

                    public a cX(int i) {
                        this.ash = true;
                        this.asi = i;
                        return this;
                    }

                    public a cY(int i) {
                        this.asj = true;
                        this.ask = i;
                        return this;
                    }

                    public a eI(String str) {
                        this.asd = true;
                        this.ase = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.apu < 0) {
                            getSerializedSize();
                        }
                        return this.apu;
                    }

                    public String getId() {
                        return this.ase;
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
                        this.apu = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasId() {
                        return this.asd;
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
                                    eI(codedInputStreamMicro.readString());
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
                        return this.aqg;
                    }

                    public boolean vT() {
                        return this.aqf;
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
                        return this.arV;
                    }

                    public boolean xS() {
                        return this.arU;
                    }

                    public int ya() {
                        return this.asg;
                    }

                    public boolean yb() {
                        return this.asf;
                    }

                    public int yc() {
                        return this.asi;
                    }

                    public boolean yd() {
                        return this.ash;
                    }

                    public int ye() {
                        return this.ask;
                    }

                    public boolean yf() {
                        return this.asj;
                    }
                }

                /* renamed from: com.baidu.f.a.d$b$b$c$b  reason: collision with other inner class name */
                /* loaded from: classes20.dex */
                public static final class C0118b extends MessageMicro {
                    private boolean apj;
                    private boolean apr;
                    private boolean arp;
                    private boolean asA;
                    private boolean asC;
                    private boolean asn;
                    private boolean asp;
                    private boolean asr;
                    private boolean asu;
                    private boolean asw;
                    private boolean asy;
                    private String apl = "";
                    private List<Integer> asl = Collections.emptyList();
                    private int arq = 0;
                    private String aso = "";
                    private String asq = "";
                    private String ass = "";
                    private String aps = "";
                    private List<Integer> ast = Collections.emptyList();
                    private String asv = "";
                    private String asx = "";
                    private String asz = "";
                    private int asB = 0;
                    private int asD = 0;
                    private int apu = -1;

                    public C0118b cZ(int i) {
                        if (this.asl.isEmpty()) {
                            this.asl = new ArrayList();
                        }
                        this.asl.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0118b da(int i) {
                        this.arp = true;
                        this.arq = i;
                        return this;
                    }

                    public C0118b db(int i) {
                        if (this.ast.isEmpty()) {
                            this.ast = new ArrayList();
                        }
                        this.ast.add(Integer.valueOf(i));
                        return this;
                    }

                    public C0118b dc(int i) {
                        this.asA = true;
                        this.asB = i;
                        return this;
                    }

                    public C0118b dd(int i) {
                        this.asC = true;
                        this.asD = i;
                        return this;
                    }

                    public C0118b eJ(String str) {
                        this.apj = true;
                        this.apl = str;
                        return this;
                    }

                    public C0118b eK(String str) {
                        this.asn = true;
                        this.aso = str;
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
                        this.apr = true;
                        this.aps = str;
                        return this;
                    }

                    public C0118b eO(String str) {
                        this.asu = true;
                        this.asv = str;
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

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.apu < 0) {
                            getSerializedSize();
                        }
                        return this.apu;
                    }

                    public String getIconUrl() {
                        return this.asv;
                    }

                    public String getName() {
                        return this.apl;
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
                        this.apu = size2;
                        return size2;
                    }

                    public String getUid() {
                        return this.aps;
                    }

                    public boolean hasName() {
                        return this.apj;
                    }

                    public boolean vo() {
                        return this.apr;
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
                                    eJ(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    cZ(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    da(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    eK(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    eL(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    eM(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    eN(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    db(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    eO(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    eP(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    eQ(codedInputStreamMicro.readString());
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
                        return this.arq;
                    }

                    public boolean xo() {
                        return this.arp;
                    }

                    public List<Integer> yg() {
                        return this.asl;
                    }

                    public String yh() {
                        return this.aso;
                    }

                    public boolean yi() {
                        return this.asn;
                    }

                    public String yj() {
                        return this.asq;
                    }

                    public boolean yk() {
                        return this.asp;
                    }

                    public String yl() {
                        return this.ass;
                    }

                    public boolean ym() {
                        return this.asr;
                    }

                    public List<Integer> yn() {
                        return this.ast;
                    }

                    public boolean yo() {
                        return this.asu;
                    }

                    public String yp() {
                        return this.asx;
                    }

                    public boolean yq() {
                        return this.asw;
                    }

                    public String yr() {
                        return this.asz;
                    }

                    public boolean ys() {
                        return this.asy;
                    }

                    public int yt() {
                        return this.asB;
                    }

                    public boolean yu() {
                        return this.asA;
                    }

                    public int yv() {
                        return this.asD;
                    }

                    public boolean yw() {
                        return this.asC;
                    }
                }

                public c a(a aVar) {
                    if (aVar != null) {
                        if (this.arF.isEmpty()) {
                            this.arF = new ArrayList();
                        }
                        this.arF.add(aVar);
                    }
                    return this;
                }

                public c a(C0118b c0118b) {
                    if (c0118b != null) {
                        if (this.apS.isEmpty()) {
                            this.apS = new ArrayList();
                        }
                        this.apS.add(c0118b);
                    }
                    return this;
                }

                public c b(C0118b c0118b) {
                    if (c0118b != null) {
                        if (this.asc.isEmpty()) {
                            this.asc = new ArrayList();
                        }
                        this.asc.add(c0118b);
                    }
                    return this;
                }

                public c cC(int i) {
                    if (this.apR.isEmpty()) {
                        this.apR = new ArrayList();
                    }
                    this.apR.add(Integer.valueOf(i));
                    return this;
                }

                public c cD(int i) {
                    this.apC = true;
                    this.type_ = i;
                    return this;
                }

                public c cE(int i) {
                    this.arG = true;
                    this.arH = i;
                    return this;
                }

                public c cF(int i) {
                    this.arI = true;
                    this.arJ = i;
                    return this;
                }

                public c cG(int i) {
                    this.arK = true;
                    this.arL = i;
                    return this;
                }

                public c cH(int i) {
                    this.arM = true;
                    this.arN = i;
                    return this;
                }

                public c cI(int i) {
                    this.arO = true;
                    this.arP = i;
                    return this;
                }

                public c cJ(int i) {
                    this.arQ = true;
                    this.arR = i;
                    return this;
                }

                public c cK(int i) {
                    this.apD = true;
                    this.apE = i;
                    return this;
                }

                public c cL(int i) {
                    this.apF = true;
                    this.apG = i;
                    return this;
                }

                public c cM(int i) {
                    this.arS = true;
                    this.arT = i;
                    return this;
                }

                public c cN(int i) {
                    this.arU = true;
                    this.arV = i;
                    return this;
                }

                public c cO(int i) {
                    if (this.apK.isEmpty()) {
                        this.apK = new ArrayList();
                    }
                    this.apK.add(Integer.valueOf(i));
                    return this;
                }

                public c cP(int i) {
                    if (this.apL.isEmpty()) {
                        this.apL = new ArrayList();
                    }
                    this.apL.add(Integer.valueOf(i));
                    return this;
                }

                public c cQ(int i) {
                    if (this.arW.isEmpty()) {
                        this.arW = new ArrayList();
                    }
                    this.arW.add(Integer.valueOf(i));
                    return this;
                }

                public c cR(int i) {
                    this.arX = true;
                    this.arY = i;
                    return this;
                }

                public c cS(int i) {
                    if (this.arZ.isEmpty()) {
                        this.arZ = new ArrayList();
                    }
                    this.arZ.add(Integer.valueOf(i));
                    return this;
                }

                public c cT(int i) {
                    this.asa = true;
                    this.asb = i;
                    return this;
                }

                public c eG(String str) {
                    this.apN = true;
                    this.apO = str;
                    return this;
                }

                public c eH(String str) {
                    this.apj = true;
                    this.apl = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apu < 0) {
                        getSerializedSize();
                    }
                    return this.apu;
                }

                public int getDirection() {
                    return this.arT;
                }

                public int getDistance() {
                    return this.apE;
                }

                public int getDuration() {
                    return this.apG;
                }

                public String getInstructions() {
                    return this.apO;
                }

                public String getName() {
                    return this.apl;
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
                            this.apu = i7;
                            return i7;
                        }
                        size5 = CodedOutputStreamMicro.computeMessageSize(23, it2.next()) + i7;
                    }
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.apF;
                }

                public boolean hasName() {
                    return this.apj;
                }

                public boolean hasType() {
                    return this.apC;
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
                                eG(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                cD(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                eH(codedInputStreamMicro.readString());
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
                    return this.apK;
                }

                public List<Integer> vB() {
                    return this.apL;
                }

                public boolean vD() {
                    return this.apN;
                }

                public List<Integer> vG() {
                    return this.apR;
                }

                public List<C0118b> vH() {
                    return this.apS;
                }

                public boolean vw() {
                    return this.apD;
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
                    return this.arF;
                }

                public int xE() {
                    return this.arH;
                }

                public boolean xF() {
                    return this.arG;
                }

                public int xG() {
                    return this.arJ;
                }

                public boolean xH() {
                    return this.arI;
                }

                public int xI() {
                    return this.arL;
                }

                public boolean xJ() {
                    return this.arK;
                }

                public int xK() {
                    return this.arN;
                }

                public boolean xL() {
                    return this.arM;
                }

                public int xM() {
                    return this.arP;
                }

                public boolean xN() {
                    return this.arO;
                }

                public int xO() {
                    return this.arR;
                }

                public boolean xP() {
                    return this.arQ;
                }

                public boolean xQ() {
                    return this.arS;
                }

                public int xR() {
                    return this.arV;
                }

                public boolean xS() {
                    return this.arU;
                }

                public List<Integer> xT() {
                    return this.arW;
                }

                public int xU() {
                    return this.arY;
                }

                public boolean xV() {
                    return this.arX;
                }

                public List<Integer> xW() {
                    return this.arZ;
                }

                public int xX() {
                    return this.asb;
                }

                public boolean xY() {
                    return this.asa;
                }

                public List<C0118b> xZ() {
                    return this.asc;
                }
            }

            public C0116b a(a aVar) {
                if (aVar != null) {
                    if (this.arv.isEmpty()) {
                        this.arv = new ArrayList();
                    }
                    this.arv.add(aVar);
                }
                return this;
            }

            public C0116b a(C0117b c0117b) {
                if (c0117b == null) {
                    return xw();
                }
                this.arw = true;
                this.arx = c0117b;
                return this;
            }

            public C0116b a(c cVar) {
                if (cVar != null) {
                    if (this.apM.isEmpty()) {
                        this.apM = new ArrayList();
                    }
                    this.apM.add(cVar);
                }
                return this;
            }

            public c cp(int i) {
                return this.apM.get(i);
            }

            public C0116b cq(int i) {
                if (this.apK.isEmpty()) {
                    this.apK = new ArrayList();
                }
                this.apK.add(Integer.valueOf(i));
                return this;
            }

            public C0116b cr(int i) {
                if (this.apL.isEmpty()) {
                    this.apL = new ArrayList();
                }
                this.apL.add(Integer.valueOf(i));
                return this;
            }

            public C0116b cs(int i) {
                this.apD = true;
                this.apE = i;
                return this;
            }

            public C0116b ct(int i) {
                this.apF = true;
                this.apG = i;
                return this;
            }

            public C0116b cu(int i) {
                this.arp = true;
                this.arq = i;
                return this;
            }

            public C0116b cv(int i) {
                this.arr = true;
                this.ars = i;
                return this;
            }

            public C0116b cw(int i) {
                this.art = true;
                this.aru = i;
                return this;
            }

            public C0116b eB(String str) {
                this.arl = true;
                this.arm = str;
                return this;
            }

            public C0116b eC(String str) {
                this.arn = true;
                this.aro = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public int getDistance() {
                return this.apE;
            }

            public int getDuration() {
                return this.apG;
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
                this.apu = i;
                return i;
            }

            public boolean hasDuration() {
                return this.apF;
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
                            eB(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            eC(codedInputStreamMicro.readString());
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
                return this.apK;
            }

            public List<Integer> vB() {
                return this.apL;
            }

            public List<c> vC() {
                return this.apM;
            }

            public boolean vw() {
                return this.apD;
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
                return this.apM.size();
            }

            public String xj() {
                return this.arm;
            }

            public boolean xk() {
                return this.arl;
            }

            public String xl() {
                return this.aro;
            }

            public boolean xm() {
                return this.arn;
            }

            public int xn() {
                return this.arq;
            }

            public boolean xo() {
                return this.arp;
            }

            public int xp() {
                return this.ars;
            }

            public boolean xq() {
                return this.arr;
            }

            public int xr() {
                return this.aru;
            }

            public boolean xs() {
                return this.art;
            }

            public List<a> xt() {
                return this.arv;
            }

            public boolean xu() {
                return this.arw;
            }

            public C0117b xv() {
                return this.arx;
            }

            public C0116b xw() {
                this.arw = false;
                this.arx = null;
                return this;
            }
        }

        /* loaded from: classes20.dex */
        public static final class c extends MessageMicro {
            private boolean asE;
            private int asF = 0;
            private List<Integer> asG = Collections.emptyList();
            private int apu = -1;

            public c de(int i) {
                this.asE = true;
                this.asF = i;
                return this;
            }

            public c df(int i) {
                if (this.asG.isEmpty()) {
                    this.asG = new ArrayList();
                }
                this.asG.add(Integer.valueOf(i));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = yy() ? CodedOutputStreamMicro.computeInt32Size(1, yx()) + 0 : 0;
                for (Integer num : yz()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
                }
                int size = computeInt32Size + i + (yz().size() * 1);
                this.apu = size;
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
                return this.asF;
            }

            public boolean yy() {
                return this.asE;
            }

            public List<Integer> yz() {
                return this.asG;
            }
        }

        /* renamed from: com.baidu.f.a.d$b$d  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C0119d extends MessageMicro {
            private boolean asH;
            private int asI = 0;
            private int apu = -1;

            public C0119d dg(int i) {
                this.asH = true;
                this.asI = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public int getLightNum() {
                return this.asI;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = yA() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.apu = computeInt32Size;
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
                return this.asH;
            }
        }

        /* loaded from: classes20.dex */
        public static final class e extends MessageMicro {
            private boolean aqh;
            private boolean aqr;
            private boolean asJ;
            private boolean asL;
            private int asK = 0;
            private String asM = "";
            private a asN = null;
            private List<a> aqt = Collections.emptyList();
            private c aqi = null;
            private int apu = -1;

            /* loaded from: classes20.dex */
            public static final class a extends MessageMicro {
                private boolean apj;
                private boolean apr;
                private boolean aqH;
                private boolean aqO;
                private boolean aqQ;
                private String aqI = "";
                private String apl = "";
                private String aps = "";
                private List<Integer> aqN = Collections.emptyList();
                private String aqP = "";
                private String aqR = "";
                private int apu = -1;

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
                                eS(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                eT(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                eU(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                di(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                eV(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                eW(codedInputStreamMicro.readString());
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
                    if (this.aqN.isEmpty()) {
                        this.aqN = new ArrayList();
                    }
                    this.aqN.add(Integer.valueOf(i));
                    return this;
                }

                public a eS(String str) {
                    this.aqH = true;
                    this.aqI = str;
                    return this;
                }

                public a eT(String str) {
                    this.apj = true;
                    this.apl = str;
                    return this;
                }

                public a eU(String str) {
                    this.apr = true;
                    this.aps = str;
                    return this;
                }

                public a eV(String str) {
                    this.aqO = true;
                    this.aqP = str;
                    return this;
                }

                public a eW(String str) {
                    this.aqQ = true;
                    this.aqR = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.apu < 0) {
                        getSerializedSize();
                    }
                    return this.apu;
                }

                public String getFloor() {
                    return this.aqP;
                }

                public String getName() {
                    return this.apl;
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
                    this.apu = size;
                    return size;
                }

                public String getUid() {
                    return this.aps;
                }

                public boolean hasName() {
                    return this.apj;
                }

                public boolean vo() {
                    return this.apr;
                }

                public boolean wA() {
                    return this.aqH;
                }

                public List<Integer> wF() {
                    return this.aqN;
                }

                public boolean wG() {
                    return this.aqO;
                }

                public String wH() {
                    return this.aqR;
                }

                public boolean wI() {
                    return this.aqQ;
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
                    return this.aqI;
                }
            }

            public e a(a aVar) {
                if (aVar == null) {
                    return yF();
                }
                this.aqr = true;
                this.asN = aVar;
                return this;
            }

            public e b(a aVar) {
                if (aVar != null) {
                    if (this.aqt.isEmpty()) {
                        this.aqt = new ArrayList();
                    }
                    this.aqt.add(aVar);
                }
                return this;
            }

            public e b(c cVar) {
                if (cVar == null) {
                    return yG();
                }
                this.aqh = true;
                this.aqi = cVar;
                return this;
            }

            public e dh(int i) {
                this.asJ = true;
                this.asK = i;
                return this;
            }

            public e eR(String str) {
                this.asL = true;
                this.asM = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public String getLabel() {
                return this.asM;
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
                this.apu = i;
                return i;
            }

            public boolean hasStart() {
                return this.aqr;
            }

            public boolean vU() {
                return this.aqh;
            }

            public c vV() {
                return this.aqi;
            }

            public List<a> wk() {
                return this.aqt;
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
                return this.asK;
            }

            public boolean yC() {
                return this.asJ;
            }

            public boolean yD() {
                return this.asL;
            }

            public a yE() {
                return this.asN;
            }

            public e yF() {
                this.aqr = false;
                this.asN = null;
                return this;
            }

            public e yG() {
                this.aqh = false;
                this.aqi = null;
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
                            eR(codedInputStreamMicro.readString());
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
            private boolean asO;
            private boolean asQ;
            private String asP = "";
            private String asR = "";
            private int apu = -1;

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
                            eX(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            eY(codedInputStreamMicro.readString());
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

            public f eX(String str) {
                this.asO = true;
                this.asP = str;
                return this;
            }

            public f eY(String str) {
                this.asQ = true;
                this.asR = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public String getContent() {
                return this.asP;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = yH() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (yJ()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, yI());
                }
                this.apu = computeStringSize;
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
                return this.asO;
            }

            public String yI() {
                return this.asR;
            }

            public boolean yJ() {
                return this.asQ;
            }
        }

        public b a(a aVar) {
            if (aVar == null) {
                return wP();
            }
            this.aqU = true;
            this.aqV = aVar;
            return this;
        }

        public b a(C0116b c0116b) {
            if (c0116b != null) {
                if (this.apH.isEmpty()) {
                    this.apH = new ArrayList();
                }
                this.apH.add(c0116b);
            }
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                if (this.arc.isEmpty()) {
                    this.arc = new ArrayList();
                }
                this.arc.add(cVar);
            }
            return this;
        }

        public b a(C0119d c0119d) {
            if (c0119d == null) {
                return wV();
            }
            this.aqY = true;
            this.aqZ = c0119d;
            return this;
        }

        public b a(e eVar) {
            if (eVar == null) {
                return wY();
            }
            this.ara = true;
            this.arb = eVar;
            return this;
        }

        public b a(f fVar) {
            if (fVar == null) {
                return wS();
            }
            this.aqW = true;
            this.aqX = fVar;
            return this;
        }

        public C0116b cl(int i) {
            return this.apH.get(i);
        }

        public b eA(String str) {
            this.ard = true;
            this.are = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apu < 0) {
                getSerializedSize();
            }
            return this.apu;
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
            this.apu = i;
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

        public List<C0116b> vx() {
            return this.apH;
        }

        public int wM() {
            return this.apH.size();
        }

        public boolean wN() {
            return this.aqU;
        }

        public a wO() {
            return this.aqV;
        }

        public b wP() {
            this.aqU = false;
            this.aqV = null;
            return this;
        }

        public boolean wQ() {
            return this.aqW;
        }

        public f wR() {
            return this.aqX;
        }

        public b wS() {
            this.aqW = false;
            this.aqX = null;
            return this;
        }

        public boolean wT() {
            return this.aqY;
        }

        public C0119d wU() {
            return this.aqZ;
        }

        public b wV() {
            this.aqY = false;
            this.aqZ = null;
            return this;
        }

        public boolean wW() {
            return this.ara;
        }

        public e wX() {
            return this.arb;
        }

        public b wY() {
            this.ara = false;
            this.arb = null;
            return this;
        }

        public List<c> wZ() {
            return this.arc;
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
            return this.are;
        }

        public boolean xb() {
            return this.ard;
        }
    }

    /* loaded from: classes20.dex */
    public static final class c extends MessageMicro {
        private boolean apD;
        private boolean apF;
        private boolean asU;
        private String asS = "";
        private String asT = "";
        private String asV = "";
        private List<a> asW = Collections.emptyList();
        private int apu = -1;

        /* loaded from: classes20.dex */
        public static final class a extends MessageMicro {
            private boolean asX;
            private boolean asZ;
            private boolean atb;
            private boolean atd;
            private String asY = "";
            private String ata = "";
            private String atc = "";
            private String ate = "";
            private int apu = -1;

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
                            fc(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            fd(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            fe(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            ff(codedInputStreamMicro.readString());
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

            public a fc(String str) {
                this.asX = true;
                this.asY = str;
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

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.apu < 0) {
                    getSerializedSize();
                }
                return this.apu;
            }

            public String getDesc() {
                return this.ate;
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
                this.apu = computeStringSize;
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
                return this.asY;
            }

            public boolean yO() {
                return this.asX;
            }

            public String yP() {
                return this.ata;
            }

            public boolean yQ() {
                return this.asZ;
            }

            public String yR() {
                return this.atc;
            }

            public boolean yS() {
                return this.atb;
            }

            public boolean yT() {
                return this.atd;
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
                        eZ(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        fa(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        fb(codedInputStreamMicro.readString());
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
                if (this.asW.isEmpty()) {
                    this.asW = new ArrayList();
                }
                this.asW.add(aVar);
            }
            return this;
        }

        public c eZ(String str) {
            this.apD = true;
            this.asS = str;
            return this;
        }

        public c fa(String str) {
            this.apF = true;
            this.asT = str;
            return this;
        }

        public c fb(String str) {
            this.asU = true;
            this.asV = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apu < 0) {
                getSerializedSize();
            }
            return this.apu;
        }

        public String getDistance() {
            return this.asS;
        }

        public String getDuration() {
            return this.asT;
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
                    this.apu = i;
                    return i;
                }
                computeStringSize = CodedOutputStreamMicro.computeMessageSize(4, it.next()) + i;
            }
        }

        public boolean hasDuration() {
            return this.apF;
        }

        public boolean vw() {
            return this.apD;
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
            return this.asV;
        }

        public boolean yL() {
            return this.asU;
        }

        public List<a> yM() {
            return this.asW;
        }
    }

    public d a(com.baidu.f.a.a aVar) {
        if (aVar == null) {
            return wb();
        }
        this.aqk = true;
        this.aql = aVar;
        return this;
    }

    public d a(com.baidu.f.a.b bVar) {
        if (bVar != null) {
            if (this.aqm.isEmpty()) {
                this.aqm = new ArrayList();
            }
            this.aqm.add(bVar);
        }
        return this;
    }

    public d a(a aVar) {
        if (aVar == null) {
            return vY();
        }
        this.apv = true;
        this.aqj = aVar;
        return this;
    }

    public d a(b bVar) {
        if (bVar != null) {
            if (this.apx.isEmpty()) {
                this.apx = new ArrayList();
            }
            this.apx.add(bVar);
        }
        return this;
    }

    public d a(c cVar) {
        if (cVar == null) {
            return vW();
        }
        this.aqh = true;
        this.aqi = cVar;
        return this;
    }

    public b bY(int i) {
        return this.apx.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apu < 0) {
            getSerializedSize();
        }
        return this.apu;
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
        this.apu = i;
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
        return this.aqh;
    }

    public c vV() {
        return this.aqi;
    }

    public d vW() {
        this.aqh = false;
        this.aqi = null;
        return this;
    }

    public a vX() {
        return this.aqj;
    }

    public d vY() {
        this.apv = false;
        this.aqj = null;
        return this;
    }

    public boolean vZ() {
        return this.aqk;
    }

    public boolean vq() {
        return this.apv;
    }

    public List<b> vt() {
        return this.apx;
    }

    public int vu() {
        return this.apx.size();
    }

    public com.baidu.f.a.a wa() {
        return this.aql;
    }

    public d wb() {
        this.aqk = false;
        this.aql = null;
        return this;
    }

    public List<com.baidu.f.a.b> wc() {
        return this.aqm;
    }

    public int wd() {
        return this.aqm.size();
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
