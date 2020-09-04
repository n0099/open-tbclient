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
    private boolean apx;
    private a apy = null;
    private List<C0111b> apz = Collections.emptyList();
    private int apw = -1;

    /* loaded from: classes20.dex */
    public static final class a extends MessageMicro {
        private boolean apA;
        private boolean apC;
        private boolean apE;
        private int apB = 0;
        private int apD = 0;
        private int type_ = 0;
        private int apw = -1;

        public a bJ(int i) {
            this.apA = true;
            this.apB = i;
            return this;
        }

        public a bK(int i) {
            this.apC = true;
            this.apD = i;
            return this;
        }

        public a bL(int i) {
            this.apE = true;
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
            if (this.apw < 0) {
                getSerializedSize();
            }
            return this.apw;
        }

        public int getError() {
            return this.apB;
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
            this.apw = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.apD;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.apA;
        }

        public boolean hasType() {
            return this.apE;
        }

        public boolean vv() {
            return this.apC;
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
        private boolean apF;
        private boolean apH;
        private boolean apK;
        private int apG = 0;
        private int apI = 0;
        private List<a> apJ = Collections.emptyList();
        private int apL = 0;
        private int apw = -1;

        /* renamed from: com.baidu.f.a.b$b$a */
        /* loaded from: classes20.dex */
        public static final class a extends MessageMicro {
            private boolean apF;
            private boolean apH;
            private List<Double> apM = Collections.emptyList();
            private List<Double> apN = Collections.emptyList();
            private int apG = 0;
            private int apI = 0;
            private List<C0112a> apO = Collections.emptyList();
            private int apw = -1;

            /* renamed from: com.baidu.f.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes20.dex */
            public static final class C0112a extends MessageMicro {
                private boolean apE;
                private boolean apF;
                private boolean apH;
                private boolean apP;
                private boolean apR;
                private boolean apV;
                private List<Double> apM = Collections.emptyList();
                private List<Double> apN = Collections.emptyList();
                private int apG = 0;
                private int apI = 0;
                private String apQ = "";
                private int type_ = 0;
                private String apS = "";
                private List<Double> apT = Collections.emptyList();
                private List<C0113a> apU = Collections.emptyList();
                private String apW = "";
                private int apw = -1;

                /* renamed from: com.baidu.f.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes20.dex */
                public static final class C0113a extends MessageMicro {
                    private boolean apE;
                    private boolean apY;
                    private boolean apm;
                    private String apn = "";
                    private int type_ = 0;
                    private List<Double> apX = Collections.emptyList();
                    private String apZ = "";
                    private int apw = -1;

                    public C0113a bU(int i) {
                        this.apE = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0113a eg(String str) {
                        this.apm = true;
                        this.apn = str;
                        return this;
                    }

                    public C0113a eh(String str) {
                        this.apY = true;
                        this.apZ = str;
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
                                    eg(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    bU(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
                                    eh(codedInputStreamMicro.readString());
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
                        if (this.apw < 0) {
                            getSerializedSize();
                        }
                        return this.apw;
                    }

                    public String getDetail() {
                        return this.apZ;
                    }

                    public String getName() {
                        return this.apn;
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
                        this.apw = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.apm;
                    }

                    public boolean hasType() {
                        return this.apE;
                    }

                    public C0113a m(double d) {
                        if (this.apX.isEmpty()) {
                            this.apX = new ArrayList();
                        }
                        this.apX.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> vK() {
                        return this.apX;
                    }

                    public boolean vL() {
                        return this.apY;
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
                        if (this.apU.isEmpty()) {
                            this.apU = new ArrayList();
                        }
                        this.apU.add(c0113a);
                    }
                    return this;
                }

                public C0112a bR(int i) {
                    this.apF = true;
                    this.apG = i;
                    return this;
                }

                public C0112a bS(int i) {
                    this.apH = true;
                    this.apI = i;
                    return this;
                }

                public C0112a bT(int i) {
                    this.apE = true;
                    this.type_ = i;
                    return this;
                }

                public C0112a ed(String str) {
                    this.apP = true;
                    this.apQ = str;
                    return this;
                }

                public C0112a ee(String str) {
                    this.apR = true;
                    this.apS = str;
                    return this;
                }

                public C0112a ef(String str) {
                    this.apV = true;
                    this.apW = str;
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
                                ed(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bT(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                ee(codedInputStreamMicro.readString());
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
                                ef(codedInputStreamMicro.readString());
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

                public String getInstructions() {
                    return this.apQ;
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
                    this.apw = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.apH;
                }

                public boolean hasType() {
                    return this.apE;
                }

                public C0112a j(double d) {
                    if (this.apM.isEmpty()) {
                        this.apM = new ArrayList();
                    }
                    this.apM.add(Double.valueOf(d));
                    return this;
                }

                public C0112a k(double d) {
                    if (this.apN.isEmpty()) {
                        this.apN = new ArrayList();
                    }
                    this.apN.add(Double.valueOf(d));
                    return this;
                }

                public C0112a l(double d) {
                    if (this.apT.isEmpty()) {
                        this.apT = new ArrayList();
                    }
                    this.apT.add(Double.valueOf(d));
                    return this;
                }

                public List<Double> vA() {
                    return this.apM;
                }

                public List<Double> vB() {
                    return this.apN;
                }

                public boolean vD() {
                    return this.apP;
                }

                public String vE() {
                    return this.apS;
                }

                public boolean vF() {
                    return this.apR;
                }

                public List<Double> vG() {
                    return this.apT;
                }

                public List<C0113a> vH() {
                    return this.apU;
                }

                public String vI() {
                    return this.apW;
                }

                public boolean vJ() {
                    return this.apV;
                }

                public boolean vw() {
                    return this.apF;
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
                    if (this.apO.isEmpty()) {
                        this.apO = new ArrayList();
                    }
                    this.apO.add(c0112a);
                }
                return this;
            }

            public a bP(int i) {
                this.apF = true;
                this.apG = i;
                return this;
            }

            public a bQ(int i) {
                this.apH = true;
                this.apI = i;
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
                        this.apw = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.apM.isEmpty()) {
                    this.apM = new ArrayList();
                }
                this.apM.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.apH;
            }

            public a i(double d) {
                if (this.apN.isEmpty()) {
                    this.apN = new ArrayList();
                }
                this.apN.add(Double.valueOf(d));
                return this;
            }

            public List<Double> vA() {
                return this.apM;
            }

            public List<Double> vB() {
                return this.apN;
            }

            public List<C0112a> vC() {
                return this.apO;
            }

            public boolean vw() {
                return this.apF;
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
                if (this.apJ.isEmpty()) {
                    this.apJ = new ArrayList();
                }
                this.apJ.add(aVar);
            }
            return this;
        }

        public C0111b bM(int i) {
            this.apF = true;
            this.apG = i;
            return this;
        }

        public C0111b bN(int i) {
            this.apH = true;
            this.apI = i;
            return this;
        }

        public C0111b bO(int i) {
            this.apK = true;
            this.apL = i;
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
            this.apw = i;
            return i;
        }

        public boolean hasDuration() {
            return this.apH;
        }

        public boolean vw() {
            return this.apF;
        }

        public List<a> vx() {
            return this.apJ;
        }

        public int vy() {
            return this.apL;
        }

        public boolean vz() {
            return this.apK;
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
        this.apx = true;
        this.apy = aVar;
        return this;
    }

    public b a(C0111b c0111b) {
        if (c0111b != null) {
            if (this.apz.isEmpty()) {
                this.apz = new ArrayList();
            }
            this.apz.add(c0111b);
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
        int computeMessageSize = vq() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vr()) : 0;
        Iterator<C0111b> it = vt().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.apw = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vq() {
        return this.apx;
    }

    public a vr() {
        return this.apy;
    }

    public b vs() {
        this.apx = false;
        this.apy = null;
        return this;
    }

    public List<C0111b> vt() {
        return this.apz;
    }

    public int vu() {
        return this.apz.size();
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
