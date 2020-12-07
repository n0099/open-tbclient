package com.baidu.g.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes26.dex */
public final class b extends MessageMicro {
    private boolean arN;
    private a arO = null;
    private List<C0125b> arP = Collections.emptyList();
    private int arM = -1;

    /* loaded from: classes26.dex */
    public static final class a extends MessageMicro {
        private boolean arQ;
        private boolean arS;
        private boolean arU;
        private int arR = 0;
        private int arT = 0;
        private int type_ = 0;
        private int arM = -1;

        public a bP(int i) {
            this.arQ = true;
            this.arR = i;
            return this;
        }

        public a bQ(int i) {
            this.arS = true;
            this.arT = i;
            return this;
        }

        public a bR(int i) {
            this.arU = true;
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
                        bP(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bQ(codedInputStreamMicro.readInt32());
                        break;
                    case 24:
                        bR(codedInputStreamMicro.readInt32());
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
            if (this.arM < 0) {
                getSerializedSize();
            }
            return this.arM;
        }

        public int getError() {
            return this.arR;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasError() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getError()) : 0;
            if (vJ()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.arM = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.arT;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.arQ;
        }

        public boolean hasType() {
            return this.arU;
        }

        public boolean vJ() {
            return this.arS;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (vJ()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    /* renamed from: com.baidu.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0125b extends MessageMicro {
        private boolean arV;
        private boolean arX;
        private boolean asa;
        private int arW = 0;
        private int arY = 0;
        private List<a> arZ = Collections.emptyList();
        private int asb = 0;
        private int arM = -1;

        /* renamed from: com.baidu.g.a.b$b$a */
        /* loaded from: classes26.dex */
        public static final class a extends MessageMicro {
            private boolean arV;
            private boolean arX;
            private List<Double> asc = Collections.emptyList();
            private List<Double> asd = Collections.emptyList();
            private int arW = 0;
            private int arY = 0;
            private List<C0126a> ase = Collections.emptyList();
            private int arM = -1;

            /* renamed from: com.baidu.g.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public static final class C0126a extends MessageMicro {
                private boolean arU;
                private boolean arV;
                private boolean arX;
                private boolean asf;
                private boolean ash;
                private boolean asl;
                private List<Double> asc = Collections.emptyList();
                private List<Double> asd = Collections.emptyList();
                private int arW = 0;
                private int arY = 0;
                private String asg = "";
                private int type_ = 0;
                private String asi = "";
                private List<Double> asj = Collections.emptyList();
                private List<C0127a> ask = Collections.emptyList();
                private String asn = "";
                private int arM = -1;

                /* renamed from: com.baidu.g.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes26.dex */
                public static final class C0127a extends MessageMicro {
                    private boolean arD;
                    private boolean arU;
                    private boolean asp;
                    private String arE = "";
                    private int type_ = 0;
                    private List<Double> aso = Collections.emptyList();
                    private String asq = "";
                    private int arM = -1;

                    public C0127a ca(int i) {
                        this.arU = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0127a et(String str) {
                        this.arD = true;
                        this.arE = str;
                        return this;
                    }

                    public C0127a eu(String str) {
                        this.asp = true;
                        this.asq = str;
                        return this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: g */
                    public C0127a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    et(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    ca(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
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

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.arM < 0) {
                            getSerializedSize();
                        }
                        return this.arM;
                    }

                    public String getDetail() {
                        return this.asq;
                    }

                    public String getName() {
                        return this.arE;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        int size = computeStringSize + (vY().size() * 8) + (vY().size() * 1);
                        if (vZ()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        this.arM = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.arD;
                    }

                    public boolean hasType() {
                        return this.arU;
                    }

                    public C0127a m(double d) {
                        if (this.aso.isEmpty()) {
                            this.aso = new ArrayList();
                        }
                        this.aso.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> vY() {
                        return this.aso;
                    }

                    public boolean vZ() {
                        return this.asp;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        for (Double d : vY()) {
                            codedOutputStreamMicro.writeDouble(3, d.doubleValue());
                        }
                        if (vZ()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                    }
                }

                public C0126a a(C0127a c0127a) {
                    if (c0127a != null) {
                        if (this.ask.isEmpty()) {
                            this.ask = new ArrayList();
                        }
                        this.ask.add(c0127a);
                    }
                    return this;
                }

                public C0126a bX(int i) {
                    this.arV = true;
                    this.arW = i;
                    return this;
                }

                public C0126a bY(int i) {
                    this.arX = true;
                    this.arY = i;
                    return this;
                }

                public C0126a bZ(int i) {
                    this.arU = true;
                    this.type_ = i;
                    return this;
                }

                public C0126a eq(String str) {
                    this.asf = true;
                    this.asg = str;
                    return this;
                }

                public C0126a er(String str) {
                    this.ash = true;
                    this.asi = str;
                    return this;
                }

                public C0126a es(String str) {
                    this.asl = true;
                    this.asn = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: f */
                public C0126a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                bX(codedInputStreamMicro.readInt32());
                                break;
                            case 32:
                                bY(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                eq(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bZ(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                er(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                l(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                C0127a c0127a = new C0127a();
                                codedInputStreamMicro.readMessage(c0127a);
                                a(c0127a);
                                break;
                            case 82:
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

                public String getInstructions() {
                    return this.asg;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int size = 0 + (vO().size() * 8) + (vO().size() * 1) + (vP().size() * 8) + (vP().size() * 1);
                    if (vK()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (vR()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (vT()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, vS());
                    }
                    int size2 = size + (vU().size() * 8) + (vU().size() * 1);
                    Iterator<C0127a> it = vV().iterator();
                    while (true) {
                        i = size2;
                        if (!it.hasNext()) {
                            break;
                        }
                        size2 = CodedOutputStreamMicro.computeMessageSize(9, it.next()) + i;
                    }
                    if (vX()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, vW());
                    }
                    this.arM = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.arX;
                }

                public boolean hasType() {
                    return this.arU;
                }

                public C0126a j(double d) {
                    if (this.asc.isEmpty()) {
                        this.asc = new ArrayList();
                    }
                    this.asc.add(Double.valueOf(d));
                    return this;
                }

                public C0126a k(double d) {
                    if (this.asd.isEmpty()) {
                        this.asd = new ArrayList();
                    }
                    this.asd.add(Double.valueOf(d));
                    return this;
                }

                public C0126a l(double d) {
                    if (this.asj.isEmpty()) {
                        this.asj = new ArrayList();
                    }
                    this.asj.add(Double.valueOf(d));
                    return this;
                }

                public boolean vK() {
                    return this.arV;
                }

                public List<Double> vO() {
                    return this.asc;
                }

                public List<Double> vP() {
                    return this.asd;
                }

                public boolean vR() {
                    return this.asf;
                }

                public String vS() {
                    return this.asi;
                }

                public boolean vT() {
                    return this.ash;
                }

                public List<Double> vU() {
                    return this.asj;
                }

                public List<C0127a> vV() {
                    return this.ask;
                }

                public String vW() {
                    return this.asn;
                }

                public boolean vX() {
                    return this.asl;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double d : vO()) {
                        codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                    }
                    for (Double d2 : vP()) {
                        codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                    }
                    if (vK()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (vR()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (vT()) {
                        codedOutputStreamMicro.writeString(7, vS());
                    }
                    for (Double d3 : vU()) {
                        codedOutputStreamMicro.writeDouble(8, d3.doubleValue());
                    }
                    for (C0127a c0127a : vV()) {
                        codedOutputStreamMicro.writeMessage(9, c0127a);
                    }
                    if (vX()) {
                        codedOutputStreamMicro.writeString(10, vW());
                    }
                }
            }

            public a a(C0126a c0126a) {
                if (c0126a != null) {
                    if (this.ase.isEmpty()) {
                        this.ase = new ArrayList();
                    }
                    this.ase.add(c0126a);
                }
                return this;
            }

            public a bV(int i) {
                this.arV = true;
                this.arW = i;
                return this;
            }

            public a bW(int i) {
                this.arX = true;
                this.arY = i;
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
                            bV(codedInputStreamMicro.readInt32());
                            break;
                        case 32:
                            bW(codedInputStreamMicro.readInt32());
                            break;
                        case 42:
                            C0126a c0126a = new C0126a();
                            codedInputStreamMicro.readMessage(c0126a);
                            a(c0126a);
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
                int size = 0 + (vO().size() * 8) + (vO().size() * 1) + (vP().size() * 8) + (vP().size() * 1);
                if (vK()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                Iterator<C0126a> it = vQ().iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        this.arM = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.asc.isEmpty()) {
                    this.asc = new ArrayList();
                }
                this.asc.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.arX;
            }

            public a i(double d) {
                if (this.asd.isEmpty()) {
                    this.asd = new ArrayList();
                }
                this.asd.add(Double.valueOf(d));
                return this;
            }

            public boolean vK() {
                return this.arV;
            }

            public List<Double> vO() {
                return this.asc;
            }

            public List<Double> vP() {
                return this.asd;
            }

            public List<C0126a> vQ() {
                return this.ase;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Double d : vO()) {
                    codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                }
                for (Double d2 : vP()) {
                    codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                }
                if (vK()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                for (C0126a c0126a : vQ()) {
                    codedOutputStreamMicro.writeMessage(5, c0126a);
                }
            }
        }

        public C0125b a(a aVar) {
            if (aVar != null) {
                if (this.arZ.isEmpty()) {
                    this.arZ = new ArrayList();
                }
                this.arZ.add(aVar);
            }
            return this;
        }

        public C0125b bS(int i) {
            this.arV = true;
            this.arW = i;
            return this;
        }

        public C0125b bT(int i) {
            this.arX = true;
            this.arY = i;
            return this;
        }

        public C0125b bU(int i) {
            this.asa = true;
            this.asb = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: d */
        public C0125b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        bS(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bT(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        a aVar = new a();
                        codedInputStreamMicro.readMessage(aVar);
                        a(aVar);
                        break;
                    case 32:
                        bU(codedInputStreamMicro.readInt32());
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
            int computeInt32Size = vK() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
            if (hasDuration()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            Iterator<a> it = vL().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(3, it.next()) + i;
            }
            if (vN()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, vM());
            }
            this.arM = i;
            return i;
        }

        public boolean hasDuration() {
            return this.arX;
        }

        public boolean vK() {
            return this.arV;
        }

        public List<a> vL() {
            return this.arZ;
        }

        public int vM() {
            return this.asb;
        }

        public boolean vN() {
            return this.asa;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vK()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            for (a aVar : vL()) {
                codedOutputStreamMicro.writeMessage(3, aVar);
            }
            if (vN()) {
                codedOutputStreamMicro.writeInt32(4, vM());
            }
        }
    }

    public b a(a aVar) {
        if (aVar == null) {
            return vG();
        }
        this.arN = true;
        this.arO = aVar;
        return this;
    }

    public b a(C0125b c0125b) {
        if (c0125b != null) {
            if (this.arP.isEmpty()) {
                this.arP = new ArrayList();
            }
            this.arP.add(c0125b);
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
                    C0125b c0125b = new C0125b();
                    codedInputStreamMicro.readMessage(c0125b);
                    a(c0125b);
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

    public C0125b bO(int i) {
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
        int computeMessageSize = vE() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vF()) : 0;
        Iterator<C0125b> it = vH().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.arM = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vE() {
        return this.arN;
    }

    public a vF() {
        return this.arO;
    }

    public b vG() {
        this.arN = false;
        this.arO = null;
        return this;
    }

    public List<C0125b> vH() {
        return this.arP;
    }

    public int vI() {
        return this.arP.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vE()) {
            codedOutputStreamMicro.writeMessage(1, vF());
        }
        for (C0125b c0125b : vH()) {
            codedOutputStreamMicro.writeMessage(2, c0125b);
        }
    }
}
