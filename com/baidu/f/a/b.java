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
    private boolean aqI;
    private a aqJ = null;
    private List<C0116b> aqK = Collections.emptyList();
    private int aqH = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqL;
        private boolean aqN;
        private boolean aqP;
        private int aqM = 0;
        private int aqO = 0;
        private int type_ = 0;
        private int aqH = -1;

        public a bN(int i) {
            this.aqL = true;
            this.aqM = i;
            return this;
        }

        public a bO(int i) {
            this.aqN = true;
            this.aqO = i;
            return this;
        }

        public a bP(int i) {
            this.aqP = true;
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
            if (this.aqH < 0) {
                getSerializedSize();
            }
            return this.aqH;
        }

        public int getError() {
            return this.aqM;
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
            this.aqH = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.aqO;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.aqL;
        }

        public boolean hasType() {
            return this.aqP;
        }

        public boolean vS() {
            return this.aqN;
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
        private boolean aqQ;
        private boolean aqS;
        private boolean aqV;
        private int aqR = 0;
        private int aqT = 0;
        private List<a> aqU = Collections.emptyList();
        private int aqW = 0;
        private int aqH = -1;

        /* renamed from: com.baidu.f.a.b$b$a */
        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean aqQ;
            private boolean aqS;
            private List<Double> aqX = Collections.emptyList();
            private List<Double> aqY = Collections.emptyList();
            private int aqR = 0;
            private int aqT = 0;
            private List<C0117a> aqZ = Collections.emptyList();
            private int aqH = -1;

            /* renamed from: com.baidu.f.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public static final class C0117a extends MessageMicro {
                private boolean aqP;
                private boolean aqQ;
                private boolean aqS;
                private boolean ara;
                private boolean arc;
                private boolean arg;
                private List<Double> aqX = Collections.emptyList();
                private List<Double> aqY = Collections.emptyList();
                private int aqR = 0;
                private int aqT = 0;
                private String arb = "";
                private int type_ = 0;
                private String ard = "";
                private List<Double> are = Collections.emptyList();
                private List<C0118a> arf = Collections.emptyList();
                private String arh = "";
                private int aqH = -1;

                /* renamed from: com.baidu.f.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C0118a extends MessageMicro {
                    private boolean aqP;
                    private boolean aqy;
                    private boolean arj;
                    private String aqz = "";
                    private int type_ = 0;
                    private List<Double> ari = Collections.emptyList();
                    private String ark = "";
                    private int aqH = -1;

                    public C0118a bY(int i) {
                        this.aqP = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0118a en(String str) {
                        this.aqy = true;
                        this.aqz = str;
                        return this;
                    }

                    public C0118a eo(String str) {
                        this.arj = true;
                        this.ark = str;
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
                        if (this.aqH < 0) {
                            getSerializedSize();
                        }
                        return this.aqH;
                    }

                    public String getDetail() {
                        return this.ark;
                    }

                    public String getName() {
                        return this.aqz;
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
                        this.aqH = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.aqy;
                    }

                    public boolean hasType() {
                        return this.aqP;
                    }

                    public C0118a m(double d) {
                        if (this.ari.isEmpty()) {
                            this.ari = new ArrayList();
                        }
                        this.ari.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> wh() {
                        return this.ari;
                    }

                    public boolean wi() {
                        return this.arj;
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
                        if (this.arf.isEmpty()) {
                            this.arf = new ArrayList();
                        }
                        this.arf.add(c0118a);
                    }
                    return this;
                }

                public C0117a bV(int i) {
                    this.aqQ = true;
                    this.aqR = i;
                    return this;
                }

                public C0117a bW(int i) {
                    this.aqS = true;
                    this.aqT = i;
                    return this;
                }

                public C0117a bX(int i) {
                    this.aqP = true;
                    this.type_ = i;
                    return this;
                }

                public C0117a ek(String str) {
                    this.ara = true;
                    this.arb = str;
                    return this;
                }

                public C0117a el(String str) {
                    this.arc = true;
                    this.ard = str;
                    return this;
                }

                public C0117a em(String str) {
                    this.arg = true;
                    this.arh = str;
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

                public String getInstructions() {
                    return this.arb;
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
                    this.aqH = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqS;
                }

                public boolean hasType() {
                    return this.aqP;
                }

                public C0117a j(double d) {
                    if (this.aqX.isEmpty()) {
                        this.aqX = new ArrayList();
                    }
                    this.aqX.add(Double.valueOf(d));
                    return this;
                }

                public C0117a k(double d) {
                    if (this.aqY.isEmpty()) {
                        this.aqY = new ArrayList();
                    }
                    this.aqY.add(Double.valueOf(d));
                    return this;
                }

                public C0117a l(double d) {
                    if (this.are.isEmpty()) {
                        this.are = new ArrayList();
                    }
                    this.are.add(Double.valueOf(d));
                    return this;
                }

                public boolean vT() {
                    return this.aqQ;
                }

                public List<Double> vX() {
                    return this.aqX;
                }

                public List<Double> vY() {
                    return this.aqY;
                }

                public boolean wa() {
                    return this.ara;
                }

                public String wb() {
                    return this.ard;
                }

                public boolean wc() {
                    return this.arc;
                }

                public List<Double> wd() {
                    return this.are;
                }

                public List<C0118a> we() {
                    return this.arf;
                }

                public String wf() {
                    return this.arh;
                }

                public boolean wg() {
                    return this.arg;
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
                    if (this.aqZ.isEmpty()) {
                        this.aqZ = new ArrayList();
                    }
                    this.aqZ.add(c0117a);
                }
                return this;
            }

            public a bT(int i) {
                this.aqQ = true;
                this.aqR = i;
                return this;
            }

            public a bU(int i) {
                this.aqS = true;
                this.aqT = i;
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
                        this.aqH = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.aqX.isEmpty()) {
                    this.aqX = new ArrayList();
                }
                this.aqX.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.aqS;
            }

            public a i(double d) {
                if (this.aqY.isEmpty()) {
                    this.aqY = new ArrayList();
                }
                this.aqY.add(Double.valueOf(d));
                return this;
            }

            public boolean vT() {
                return this.aqQ;
            }

            public List<Double> vX() {
                return this.aqX;
            }

            public List<Double> vY() {
                return this.aqY;
            }

            public List<C0117a> vZ() {
                return this.aqZ;
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
                if (this.aqU.isEmpty()) {
                    this.aqU = new ArrayList();
                }
                this.aqU.add(aVar);
            }
            return this;
        }

        public C0116b bQ(int i) {
            this.aqQ = true;
            this.aqR = i;
            return this;
        }

        public C0116b bR(int i) {
            this.aqS = true;
            this.aqT = i;
            return this;
        }

        public C0116b bS(int i) {
            this.aqV = true;
            this.aqW = i;
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
            this.aqH = i;
            return i;
        }

        public boolean hasDuration() {
            return this.aqS;
        }

        public boolean vT() {
            return this.aqQ;
        }

        public List<a> vU() {
            return this.aqU;
        }

        public int vV() {
            return this.aqW;
        }

        public boolean vW() {
            return this.aqV;
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
        this.aqI = true;
        this.aqJ = aVar;
        return this;
    }

    public b a(C0116b c0116b) {
        if (c0116b != null) {
            if (this.aqK.isEmpty()) {
                this.aqK = new ArrayList();
            }
            this.aqK.add(c0116b);
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
        int computeMessageSize = vN() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vO()) : 0;
        Iterator<C0116b> it = vQ().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.aqH = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vN() {
        return this.aqI;
    }

    public a vO() {
        return this.aqJ;
    }

    public b vP() {
        this.aqI = false;
        this.aqJ = null;
        return this;
    }

    public List<C0116b> vQ() {
        return this.aqK;
    }

    public int vR() {
        return this.aqK.size();
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
