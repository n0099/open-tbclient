package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class b extends MessageMicro {
    private boolean aqJ;
    private a aqK = null;
    private List<C0116b> aqL = Collections.emptyList();
    private int aqI = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqM;
        private boolean aqO;
        private boolean aqQ;
        private int aqN = 0;
        private int aqP = 0;
        private int type_ = 0;
        private int aqI = -1;

        public a bN(int i) {
            this.aqM = true;
            this.aqN = i;
            return this;
        }

        public a bO(int i) {
            this.aqO = true;
            this.aqP = i;
            return this;
        }

        public a bP(int i) {
            this.aqQ = true;
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
                        bN(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bO(codedInputStreamMicro.readInt32());
                        break;
                    case 24:
                        bP(codedInputStreamMicro.readInt32());
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
            if (this.aqI < 0) {
                getSerializedSize();
            }
            return this.aqI;
        }

        public int getError() {
            return this.aqN;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasError() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getError()) : 0;
            if (vS()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.aqI = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.aqP;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.aqM;
        }

        public boolean hasType() {
            return this.aqQ;
        }

        public boolean vS() {
            return this.aqO;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (vS()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    /* renamed from: com.baidu.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0116b extends MessageMicro {
        private boolean aqR;
        private boolean aqT;
        private boolean aqW;
        private int aqS = 0;
        private int aqU = 0;
        private List<a> aqV = Collections.emptyList();
        private int aqX = 0;
        private int aqI = -1;

        /* renamed from: com.baidu.f.a.b$b$a */
        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean aqR;
            private boolean aqT;
            private List<Double> aqY = Collections.emptyList();
            private List<Double> aqZ = Collections.emptyList();
            private int aqS = 0;
            private int aqU = 0;
            private List<C0117a> ara = Collections.emptyList();
            private int aqI = -1;

            /* renamed from: com.baidu.f.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public static final class C0117a extends MessageMicro {
                private boolean aqQ;
                private boolean aqR;
                private boolean aqT;
                private boolean arb;
                private boolean ard;
                private boolean arh;
                private List<Double> aqY = Collections.emptyList();
                private List<Double> aqZ = Collections.emptyList();
                private int aqS = 0;
                private int aqU = 0;
                private String arc = "";
                private int type_ = 0;
                private String are = "";
                private List<Double> arf = Collections.emptyList();
                private List<C0118a> arg = Collections.emptyList();
                private String ari = "";
                private int aqI = -1;

                /* renamed from: com.baidu.f.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C0118a extends MessageMicro {
                    private boolean aqQ;
                    private boolean aqz;
                    private boolean ark;
                    private String aqA = "";
                    private int type_ = 0;
                    private List<Double> arj = Collections.emptyList();
                    private String arl = "";
                    private int aqI = -1;

                    public C0118a bY(int i) {
                        this.aqQ = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0118a en(String str) {
                        this.aqz = true;
                        this.aqA = str;
                        return this;
                    }

                    public C0118a eo(String str) {
                        this.ark = true;
                        this.arl = str;
                        return this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: g */
                    public C0118a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    en(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    bY(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
                                    eo(codedInputStreamMicro.readString());
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
                        if (this.aqI < 0) {
                            getSerializedSize();
                        }
                        return this.aqI;
                    }

                    public String getDetail() {
                        return this.arl;
                    }

                    public String getName() {
                        return this.aqA;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        int size = computeStringSize + (wh().size() * 8) + (wh().size() * 1);
                        if (wi()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        this.aqI = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.aqz;
                    }

                    public boolean hasType() {
                        return this.aqQ;
                    }

                    public C0118a m(double d) {
                        if (this.arj.isEmpty()) {
                            this.arj = new ArrayList();
                        }
                        this.arj.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> wh() {
                        return this.arj;
                    }

                    public boolean wi() {
                        return this.ark;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        for (Double d : wh()) {
                            codedOutputStreamMicro.writeDouble(3, d.doubleValue());
                        }
                        if (wi()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                    }
                }

                public C0117a a(C0118a c0118a) {
                    if (c0118a != null) {
                        if (this.arg.isEmpty()) {
                            this.arg = new ArrayList();
                        }
                        this.arg.add(c0118a);
                    }
                    return this;
                }

                public C0117a bV(int i) {
                    this.aqR = true;
                    this.aqS = i;
                    return this;
                }

                public C0117a bW(int i) {
                    this.aqT = true;
                    this.aqU = i;
                    return this;
                }

                public C0117a bX(int i) {
                    this.aqQ = true;
                    this.type_ = i;
                    return this;
                }

                public C0117a ek(String str) {
                    this.arb = true;
                    this.arc = str;
                    return this;
                }

                public C0117a el(String str) {
                    this.ard = true;
                    this.are = str;
                    return this;
                }

                public C0117a em(String str) {
                    this.arh = true;
                    this.ari = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: f */
                public C0117a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                bV(codedInputStreamMicro.readInt32());
                                break;
                            case 32:
                                bW(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                ek(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bX(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                el(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                l(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                C0118a c0118a = new C0118a();
                                codedInputStreamMicro.readMessage(c0118a);
                                a(c0118a);
                                break;
                            case 82:
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

                public String getInstructions() {
                    return this.arc;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int size = 0 + (vX().size() * 8) + (vX().size() * 1) + (vY().size() * 8) + (vY().size() * 1);
                    if (vT()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (wa()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (wc()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, wb());
                    }
                    int size2 = size + (wd().size() * 8) + (wd().size() * 1);
                    Iterator<C0118a> it = we().iterator();
                    while (true) {
                        i = size2;
                        if (!it.hasNext()) {
                            break;
                        }
                        size2 = CodedOutputStreamMicro.computeMessageSize(9, it.next()) + i;
                    }
                    if (wg()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, wf());
                    }
                    this.aqI = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqT;
                }

                public boolean hasType() {
                    return this.aqQ;
                }

                public C0117a j(double d) {
                    if (this.aqY.isEmpty()) {
                        this.aqY = new ArrayList();
                    }
                    this.aqY.add(Double.valueOf(d));
                    return this;
                }

                public C0117a k(double d) {
                    if (this.aqZ.isEmpty()) {
                        this.aqZ = new ArrayList();
                    }
                    this.aqZ.add(Double.valueOf(d));
                    return this;
                }

                public C0117a l(double d) {
                    if (this.arf.isEmpty()) {
                        this.arf = new ArrayList();
                    }
                    this.arf.add(Double.valueOf(d));
                    return this;
                }

                public boolean vT() {
                    return this.aqR;
                }

                public List<Double> vX() {
                    return this.aqY;
                }

                public List<Double> vY() {
                    return this.aqZ;
                }

                public boolean wa() {
                    return this.arb;
                }

                public String wb() {
                    return this.are;
                }

                public boolean wc() {
                    return this.ard;
                }

                public List<Double> wd() {
                    return this.arf;
                }

                public List<C0118a> we() {
                    return this.arg;
                }

                public String wf() {
                    return this.ari;
                }

                public boolean wg() {
                    return this.arh;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double d : vX()) {
                        codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                    }
                    for (Double d2 : vY()) {
                        codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                    }
                    if (vT()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (wa()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (wc()) {
                        codedOutputStreamMicro.writeString(7, wb());
                    }
                    for (Double d3 : wd()) {
                        codedOutputStreamMicro.writeDouble(8, d3.doubleValue());
                    }
                    for (C0118a c0118a : we()) {
                        codedOutputStreamMicro.writeMessage(9, c0118a);
                    }
                    if (wg()) {
                        codedOutputStreamMicro.writeString(10, wf());
                    }
                }
            }

            public a a(C0117a c0117a) {
                if (c0117a != null) {
                    if (this.ara.isEmpty()) {
                        this.ara = new ArrayList();
                    }
                    this.ara.add(c0117a);
                }
                return this;
            }

            public a bT(int i) {
                this.aqR = true;
                this.aqS = i;
                return this;
            }

            public a bU(int i) {
                this.aqT = true;
                this.aqU = i;
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
                            bT(codedInputStreamMicro.readInt32());
                            break;
                        case 32:
                            bU(codedInputStreamMicro.readInt32());
                            break;
                        case 42:
                            C0117a c0117a = new C0117a();
                            codedInputStreamMicro.readMessage(c0117a);
                            a(c0117a);
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
                int size = 0 + (vX().size() * 8) + (vX().size() * 1) + (vY().size() * 8) + (vY().size() * 1);
                if (vT()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                Iterator<C0117a> it = vZ().iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        this.aqI = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.aqY.isEmpty()) {
                    this.aqY = new ArrayList();
                }
                this.aqY.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.aqT;
            }

            public a i(double d) {
                if (this.aqZ.isEmpty()) {
                    this.aqZ = new ArrayList();
                }
                this.aqZ.add(Double.valueOf(d));
                return this;
            }

            public boolean vT() {
                return this.aqR;
            }

            public List<Double> vX() {
                return this.aqY;
            }

            public List<Double> vY() {
                return this.aqZ;
            }

            public List<C0117a> vZ() {
                return this.ara;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Double d : vX()) {
                    codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                }
                for (Double d2 : vY()) {
                    codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                }
                if (vT()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                for (C0117a c0117a : vZ()) {
                    codedOutputStreamMicro.writeMessage(5, c0117a);
                }
            }
        }

        public C0116b a(a aVar) {
            if (aVar != null) {
                if (this.aqV.isEmpty()) {
                    this.aqV = new ArrayList();
                }
                this.aqV.add(aVar);
            }
            return this;
        }

        public C0116b bQ(int i) {
            this.aqR = true;
            this.aqS = i;
            return this;
        }

        public C0116b bR(int i) {
            this.aqT = true;
            this.aqU = i;
            return this;
        }

        public C0116b bS(int i) {
            this.aqW = true;
            this.aqX = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: d */
        public C0116b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        bQ(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bR(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        a aVar = new a();
                        codedInputStreamMicro.readMessage(aVar);
                        a(aVar);
                        break;
                    case 32:
                        bS(codedInputStreamMicro.readInt32());
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
            int computeInt32Size = vT() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
            if (hasDuration()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            Iterator<a> it = vU().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(3, it.next()) + i;
            }
            if (vW()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, vV());
            }
            this.aqI = i;
            return i;
        }

        public boolean hasDuration() {
            return this.aqT;
        }

        public boolean vT() {
            return this.aqR;
        }

        public List<a> vU() {
            return this.aqV;
        }

        public int vV() {
            return this.aqX;
        }

        public boolean vW() {
            return this.aqW;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vT()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            for (a aVar : vU()) {
                codedOutputStreamMicro.writeMessage(3, aVar);
            }
            if (vW()) {
                codedOutputStreamMicro.writeInt32(4, vV());
            }
        }
    }

    public b a(a aVar) {
        if (aVar == null) {
            return vP();
        }
        this.aqJ = true;
        this.aqK = aVar;
        return this;
    }

    public b a(C0116b c0116b) {
        if (c0116b != null) {
            if (this.aqL.isEmpty()) {
                this.aqL = new ArrayList();
            }
            this.aqL.add(c0116b);
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
                    C0116b c0116b = new C0116b();
                    codedInputStreamMicro.readMessage(c0116b);
                    a(c0116b);
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

    public C0116b bM(int i) {
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
        int computeMessageSize = vN() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vO()) : 0;
        Iterator<C0116b> it = vQ().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.aqI = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vN() {
        return this.aqJ;
    }

    public a vO() {
        return this.aqK;
    }

    public b vP() {
        this.aqJ = false;
        this.aqK = null;
        return this;
    }

    public List<C0116b> vQ() {
        return this.aqL;
    }

    public int vR() {
        return this.aqL.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vN()) {
            codedOutputStreamMicro.writeMessage(1, vO());
        }
        for (C0116b c0116b : vQ()) {
            codedOutputStreamMicro.writeMessage(2, c0116b);
        }
    }
}
