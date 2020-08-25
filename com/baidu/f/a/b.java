package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes20.dex */
public final class b extends MessageMicro {
    private boolean apv;
    private a apw = null;
    private List<C0111b> apx = Collections.emptyList();
    private int apu = -1;

    /* loaded from: classes20.dex */
    public static final class a extends MessageMicro {
        private boolean apA;
        private boolean apC;
        private boolean apy;
        private int apz = 0;
        private int apB = 0;
        private int type_ = 0;
        private int apu = -1;

        public a bJ(int i) {
            this.apy = true;
            this.apz = i;
            return this;
        }

        public a bK(int i) {
            this.apA = true;
            this.apB = i;
            return this;
        }

        public a bL(int i) {
            this.apC = true;
            this.type_ = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: c */
        public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        bJ(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bK(codedInputStreamMicro.readInt32());
                        break;
                    case 24:
                        bL(codedInputStreamMicro.readInt32());
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
        public int getCachedSize() {
            if (this.apu < 0) {
                getSerializedSize();
            }
            return this.apu;
        }

        public int getError() {
            return this.apz;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasError() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getError()) : 0;
            if (vv()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.apu = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.apB;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.apy;
        }

        public boolean hasType() {
            return this.apC;
        }

        public boolean vv() {
            return this.apA;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (vv()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    /* renamed from: com.baidu.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C0111b extends MessageMicro {
        private boolean apD;
        private boolean apF;
        private boolean apI;
        private int apE = 0;
        private int apG = 0;
        private List<a> apH = Collections.emptyList();
        private int apJ = 0;
        private int apu = -1;

        /* renamed from: com.baidu.f.a.b$b$a */
        /* loaded from: classes20.dex */
        public static final class a extends MessageMicro {
            private boolean apD;
            private boolean apF;
            private List<Double> apK = Collections.emptyList();
            private List<Double> apL = Collections.emptyList();
            private int apE = 0;
            private int apG = 0;
            private List<C0112a> apM = Collections.emptyList();
            private int apu = -1;

            /* renamed from: com.baidu.f.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes20.dex */
            public static final class C0112a extends MessageMicro {
                private boolean apC;
                private boolean apD;
                private boolean apF;
                private boolean apN;
                private boolean apP;
                private boolean apT;
                private List<Double> apK = Collections.emptyList();
                private List<Double> apL = Collections.emptyList();
                private int apE = 0;
                private int apG = 0;
                private String apO = "";
                private int type_ = 0;
                private String apQ = "";
                private List<Double> apR = Collections.emptyList();
                private List<C0113a> apS = Collections.emptyList();
                private String apU = "";
                private int apu = -1;

                /* renamed from: com.baidu.f.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes20.dex */
                public static final class C0113a extends MessageMicro {
                    private boolean apC;
                    private boolean apW;
                    private boolean apj;
                    private String apl = "";
                    private int type_ = 0;
                    private List<Double> apV = Collections.emptyList();
                    private String apX = "";
                    private int apu = -1;

                    public C0113a bU(int i) {
                        this.apC = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0113a ef(String str) {
                        this.apj = true;
                        this.apl = str;
                        return this;
                    }

                    public C0113a eg(String str) {
                        this.apW = true;
                        this.apX = str;
                        return this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: g */
                    public C0113a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    ef(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    bU(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
                                    eg(codedInputStreamMicro.readString());
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
                    public int getCachedSize() {
                        if (this.apu < 0) {
                            getSerializedSize();
                        }
                        return this.apu;
                    }

                    public String getDetail() {
                        return this.apX;
                    }

                    public String getName() {
                        return this.apl;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        int size = computeStringSize + (vK().size() * 8) + (vK().size() * 1);
                        if (vL()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        this.apu = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.apj;
                    }

                    public boolean hasType() {
                        return this.apC;
                    }

                    public C0113a m(double d) {
                        if (this.apV.isEmpty()) {
                            this.apV = new ArrayList();
                        }
                        this.apV.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> vK() {
                        return this.apV;
                    }

                    public boolean vL() {
                        return this.apW;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        for (Double d : vK()) {
                            codedOutputStreamMicro.writeDouble(3, d.doubleValue());
                        }
                        if (vL()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                    }
                }

                public C0112a a(C0113a c0113a) {
                    if (c0113a != null) {
                        if (this.apS.isEmpty()) {
                            this.apS = new ArrayList();
                        }
                        this.apS.add(c0113a);
                    }
                    return this;
                }

                public C0112a bR(int i) {
                    this.apD = true;
                    this.apE = i;
                    return this;
                }

                public C0112a bS(int i) {
                    this.apF = true;
                    this.apG = i;
                    return this;
                }

                public C0112a bT(int i) {
                    this.apC = true;
                    this.type_ = i;
                    return this;
                }

                public C0112a ec(String str) {
                    this.apN = true;
                    this.apO = str;
                    return this;
                }

                public C0112a ed(String str) {
                    this.apP = true;
                    this.apQ = str;
                    return this;
                }

                public C0112a ee(String str) {
                    this.apT = true;
                    this.apU = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: f */
                public C0112a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 9:
                                j(codedInputStreamMicro.readDouble());
                                break;
                            case 17:
                                k(codedInputStreamMicro.readDouble());
                                break;
                            case 24:
                                bR(codedInputStreamMicro.readInt32());
                                break;
                            case 32:
                                bS(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                ec(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bT(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                ed(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                l(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                C0113a c0113a = new C0113a();
                                codedInputStreamMicro.readMessage(c0113a);
                                a(c0113a);
                                break;
                            case 82:
                                ee(codedInputStreamMicro.readString());
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

                public String getInstructions() {
                    return this.apO;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int size = 0 + (vA().size() * 8) + (vA().size() * 1) + (vB().size() * 8) + (vB().size() * 1);
                    if (vw()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (vD()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (vF()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, vE());
                    }
                    int size2 = size + (vG().size() * 8) + (vG().size() * 1);
                    Iterator<C0113a> it = vH().iterator();
                    while (true) {
                        i = size2;
                        if (!it.hasNext()) {
                            break;
                        }
                        size2 = CodedOutputStreamMicro.computeMessageSize(9, it.next()) + i;
                    }
                    if (vJ()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, vI());
                    }
                    this.apu = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.apF;
                }

                public boolean hasType() {
                    return this.apC;
                }

                public C0112a j(double d) {
                    if (this.apK.isEmpty()) {
                        this.apK = new ArrayList();
                    }
                    this.apK.add(Double.valueOf(d));
                    return this;
                }

                public C0112a k(double d) {
                    if (this.apL.isEmpty()) {
                        this.apL = new ArrayList();
                    }
                    this.apL.add(Double.valueOf(d));
                    return this;
                }

                public C0112a l(double d) {
                    if (this.apR.isEmpty()) {
                        this.apR = new ArrayList();
                    }
                    this.apR.add(Double.valueOf(d));
                    return this;
                }

                public List<Double> vA() {
                    return this.apK;
                }

                public List<Double> vB() {
                    return this.apL;
                }

                public boolean vD() {
                    return this.apN;
                }

                public String vE() {
                    return this.apQ;
                }

                public boolean vF() {
                    return this.apP;
                }

                public List<Double> vG() {
                    return this.apR;
                }

                public List<C0113a> vH() {
                    return this.apS;
                }

                public String vI() {
                    return this.apU;
                }

                public boolean vJ() {
                    return this.apT;
                }

                public boolean vw() {
                    return this.apD;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double d : vA()) {
                        codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                    }
                    for (Double d2 : vB()) {
                        codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                    }
                    if (vw()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (vD()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (vF()) {
                        codedOutputStreamMicro.writeString(7, vE());
                    }
                    for (Double d3 : vG()) {
                        codedOutputStreamMicro.writeDouble(8, d3.doubleValue());
                    }
                    for (C0113a c0113a : vH()) {
                        codedOutputStreamMicro.writeMessage(9, c0113a);
                    }
                    if (vJ()) {
                        codedOutputStreamMicro.writeString(10, vI());
                    }
                }
            }

            public a a(C0112a c0112a) {
                if (c0112a != null) {
                    if (this.apM.isEmpty()) {
                        this.apM = new ArrayList();
                    }
                    this.apM.add(c0112a);
                }
                return this;
            }

            public a bP(int i) {
                this.apD = true;
                this.apE = i;
                return this;
            }

            public a bQ(int i) {
                this.apF = true;
                this.apG = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.micro.MessageMicro
            /* renamed from: e */
            public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 9:
                            h(codedInputStreamMicro.readDouble());
                            break;
                        case 17:
                            i(codedInputStreamMicro.readDouble());
                            break;
                        case 24:
                            bP(codedInputStreamMicro.readInt32());
                            break;
                        case 32:
                            bQ(codedInputStreamMicro.readInt32());
                            break;
                        case 42:
                            C0112a c0112a = new C0112a();
                            codedInputStreamMicro.readMessage(c0112a);
                            a(c0112a);
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
                int size = 0 + (vA().size() * 8) + (vA().size() * 1) + (vB().size() * 8) + (vB().size() * 1);
                if (vw()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                Iterator<C0112a> it = vC().iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        this.apu = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.apK.isEmpty()) {
                    this.apK = new ArrayList();
                }
                this.apK.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.apF;
            }

            public a i(double d) {
                if (this.apL.isEmpty()) {
                    this.apL = new ArrayList();
                }
                this.apL.add(Double.valueOf(d));
                return this;
            }

            public List<Double> vA() {
                return this.apK;
            }

            public List<Double> vB() {
                return this.apL;
            }

            public List<C0112a> vC() {
                return this.apM;
            }

            public boolean vw() {
                return this.apD;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Double d : vA()) {
                    codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                }
                for (Double d2 : vB()) {
                    codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                }
                if (vw()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                for (C0112a c0112a : vC()) {
                    codedOutputStreamMicro.writeMessage(5, c0112a);
                }
            }
        }

        public C0111b a(a aVar) {
            if (aVar != null) {
                if (this.apH.isEmpty()) {
                    this.apH = new ArrayList();
                }
                this.apH.add(aVar);
            }
            return this;
        }

        public C0111b bM(int i) {
            this.apD = true;
            this.apE = i;
            return this;
        }

        public C0111b bN(int i) {
            this.apF = true;
            this.apG = i;
            return this;
        }

        public C0111b bO(int i) {
            this.apI = true;
            this.apJ = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: d */
        public C0111b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        bM(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bN(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        a aVar = new a();
                        codedInputStreamMicro.readMessage(aVar);
                        a(aVar);
                        break;
                    case 32:
                        bO(codedInputStreamMicro.readInt32());
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
            int computeInt32Size = vw() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
            if (hasDuration()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            Iterator<a> it = vx().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(3, it.next()) + i;
            }
            if (vz()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, vy());
            }
            this.apu = i;
            return i;
        }

        public boolean hasDuration() {
            return this.apF;
        }

        public boolean vw() {
            return this.apD;
        }

        public List<a> vx() {
            return this.apH;
        }

        public int vy() {
            return this.apJ;
        }

        public boolean vz() {
            return this.apI;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vw()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            for (a aVar : vx()) {
                codedOutputStreamMicro.writeMessage(3, aVar);
            }
            if (vz()) {
                codedOutputStreamMicro.writeInt32(4, vy());
            }
        }
    }

    public b a(a aVar) {
        if (aVar == null) {
            return vs();
        }
        this.apv = true;
        this.apw = aVar;
        return this;
    }

    public b a(C0111b c0111b) {
        if (c0111b != null) {
            if (this.apx.isEmpty()) {
                this.apx = new ArrayList();
            }
            this.apx.add(c0111b);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.micro.MessageMicro
    /* renamed from: b */
    public b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    a aVar = new a();
                    codedInputStreamMicro.readMessage(aVar);
                    a(aVar);
                    break;
                case 18:
                    C0111b c0111b = new C0111b();
                    codedInputStreamMicro.readMessage(c0111b);
                    a(c0111b);
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

    public C0111b bI(int i) {
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
        int computeMessageSize = vq() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vr()) : 0;
        Iterator<C0111b> it = vt().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.apu = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vq() {
        return this.apv;
    }

    public a vr() {
        return this.apw;
    }

    public b vs() {
        this.apv = false;
        this.apw = null;
        return this;
    }

    public List<C0111b> vt() {
        return this.apx;
    }

    public int vu() {
        return this.apx.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vq()) {
            codedOutputStreamMicro.writeMessage(1, vr());
        }
        for (C0111b c0111b : vt()) {
            codedOutputStreamMicro.writeMessage(2, c0111b);
        }
    }
}
