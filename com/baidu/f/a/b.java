package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class b extends MessageMicro {
    private boolean apZ;
    private a aqa = null;
    private List<C0112b> aqb = Collections.emptyList();
    private int apY = -1;

    /* loaded from: classes3.dex */
    public static final class a extends MessageMicro {
        private boolean aqc;
        private boolean aqe;
        private boolean aqg;
        private int aqd = 0;
        private int aqf = 0;
        private int type_ = 0;
        private int apY = -1;

        public a bN(int i) {
            this.aqc = true;
            this.aqd = i;
            return this;
        }

        public a bO(int i) {
            this.aqe = true;
            this.aqf = i;
            return this;
        }

        public a bP(int i) {
            this.aqg = true;
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
            if (this.apY < 0) {
                getSerializedSize();
            }
            return this.apY;
        }

        public int getError() {
            return this.aqd;
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
            this.apY = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.aqf;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.aqc;
        }

        public boolean hasType() {
            return this.aqg;
        }

        public boolean vJ() {
            return this.aqe;
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

    /* renamed from: com.baidu.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0112b extends MessageMicro {
        private boolean aqh;
        private boolean aqj;
        private boolean aqm;
        private int aqi = 0;
        private int aqk = 0;
        private List<a> aql = Collections.emptyList();
        private int aqn = 0;
        private int apY = -1;

        /* renamed from: com.baidu.f.a.b$b$a */
        /* loaded from: classes3.dex */
        public static final class a extends MessageMicro {
            private boolean aqh;
            private boolean aqj;
            private List<Double> aqo = Collections.emptyList();
            private List<Double> aqp = Collections.emptyList();
            private int aqi = 0;
            private int aqk = 0;
            private List<C0113a> aqq = Collections.emptyList();
            private int apY = -1;

            /* renamed from: com.baidu.f.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0113a extends MessageMicro {
                private boolean aqg;
                private boolean aqh;
                private boolean aqj;
                private boolean aqr;
                private boolean aqt;
                private boolean aqx;
                private List<Double> aqo = Collections.emptyList();
                private List<Double> aqp = Collections.emptyList();
                private int aqi = 0;
                private int aqk = 0;
                private String aqs = "";
                private int type_ = 0;
                private String aqu = "";
                private List<Double> aqv = Collections.emptyList();
                private List<C0114a> aqw = Collections.emptyList();
                private String aqy = "";
                private int apY = -1;

                /* renamed from: com.baidu.f.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C0114a extends MessageMicro {
                    private boolean apP;
                    private boolean aqA;
                    private boolean aqg;
                    private String apQ = "";
                    private int type_ = 0;
                    private List<Double> aqz = Collections.emptyList();
                    private String aqB = "";
                    private int apY = -1;

                    public C0114a bY(int i) {
                        this.aqg = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0114a ei(String str) {
                        this.apP = true;
                        this.apQ = str;
                        return this;
                    }

                    public C0114a ej(String str) {
                        this.aqA = true;
                        this.aqB = str;
                        return this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: g */
                    public C0114a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    ei(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    bY(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
                                    ej(codedInputStreamMicro.readString());
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
                        if (this.apY < 0) {
                            getSerializedSize();
                        }
                        return this.apY;
                    }

                    public String getDetail() {
                        return this.aqB;
                    }

                    public String getName() {
                        return this.apQ;
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
                        this.apY = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.apP;
                    }

                    public boolean hasType() {
                        return this.aqg;
                    }

                    public C0114a m(double d) {
                        if (this.aqz.isEmpty()) {
                            this.aqz = new ArrayList();
                        }
                        this.aqz.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> vY() {
                        return this.aqz;
                    }

                    public boolean vZ() {
                        return this.aqA;
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

                public C0113a a(C0114a c0114a) {
                    if (c0114a != null) {
                        if (this.aqw.isEmpty()) {
                            this.aqw = new ArrayList();
                        }
                        this.aqw.add(c0114a);
                    }
                    return this;
                }

                public C0113a bV(int i) {
                    this.aqh = true;
                    this.aqi = i;
                    return this;
                }

                public C0113a bW(int i) {
                    this.aqj = true;
                    this.aqk = i;
                    return this;
                }

                public C0113a bX(int i) {
                    this.aqg = true;
                    this.type_ = i;
                    return this;
                }

                public C0113a ef(String str) {
                    this.aqr = true;
                    this.aqs = str;
                    return this;
                }

                public C0113a eg(String str) {
                    this.aqt = true;
                    this.aqu = str;
                    return this;
                }

                public C0113a eh(String str) {
                    this.aqx = true;
                    this.aqy = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: f */
                public C0113a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                ef(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bX(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                eg(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                l(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                C0114a c0114a = new C0114a();
                                codedInputStreamMicro.readMessage(c0114a);
                                a(c0114a);
                                break;
                            case 82:
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
                    if (this.apY < 0) {
                        getSerializedSize();
                    }
                    return this.apY;
                }

                public int getDistance() {
                    return this.aqi;
                }

                public int getDuration() {
                    return this.aqk;
                }

                public String getInstructions() {
                    return this.aqs;
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
                    Iterator<C0114a> it = vV().iterator();
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
                    this.apY = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqj;
                }

                public boolean hasType() {
                    return this.aqg;
                }

                public C0113a j(double d) {
                    if (this.aqo.isEmpty()) {
                        this.aqo = new ArrayList();
                    }
                    this.aqo.add(Double.valueOf(d));
                    return this;
                }

                public C0113a k(double d) {
                    if (this.aqp.isEmpty()) {
                        this.aqp = new ArrayList();
                    }
                    this.aqp.add(Double.valueOf(d));
                    return this;
                }

                public C0113a l(double d) {
                    if (this.aqv.isEmpty()) {
                        this.aqv = new ArrayList();
                    }
                    this.aqv.add(Double.valueOf(d));
                    return this;
                }

                public boolean vK() {
                    return this.aqh;
                }

                public List<Double> vO() {
                    return this.aqo;
                }

                public List<Double> vP() {
                    return this.aqp;
                }

                public boolean vR() {
                    return this.aqr;
                }

                public String vS() {
                    return this.aqu;
                }

                public boolean vT() {
                    return this.aqt;
                }

                public List<Double> vU() {
                    return this.aqv;
                }

                public List<C0114a> vV() {
                    return this.aqw;
                }

                public String vW() {
                    return this.aqy;
                }

                public boolean vX() {
                    return this.aqx;
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
                    for (C0114a c0114a : vV()) {
                        codedOutputStreamMicro.writeMessage(9, c0114a);
                    }
                    if (vX()) {
                        codedOutputStreamMicro.writeString(10, vW());
                    }
                }
            }

            public a a(C0113a c0113a) {
                if (c0113a != null) {
                    if (this.aqq.isEmpty()) {
                        this.aqq = new ArrayList();
                    }
                    this.aqq.add(c0113a);
                }
                return this;
            }

            public a bT(int i) {
                this.aqh = true;
                this.aqi = i;
                return this;
            }

            public a bU(int i) {
                this.aqj = true;
                this.aqk = i;
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
                            C0113a c0113a = new C0113a();
                            codedInputStreamMicro.readMessage(c0113a);
                            a(c0113a);
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
                if (this.apY < 0) {
                    getSerializedSize();
                }
                return this.apY;
            }

            public int getDistance() {
                return this.aqi;
            }

            public int getDuration() {
                return this.aqk;
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
                Iterator<C0113a> it = vQ().iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        this.apY = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.aqo.isEmpty()) {
                    this.aqo = new ArrayList();
                }
                this.aqo.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.aqj;
            }

            public a i(double d) {
                if (this.aqp.isEmpty()) {
                    this.aqp = new ArrayList();
                }
                this.aqp.add(Double.valueOf(d));
                return this;
            }

            public boolean vK() {
                return this.aqh;
            }

            public List<Double> vO() {
                return this.aqo;
            }

            public List<Double> vP() {
                return this.aqp;
            }

            public List<C0113a> vQ() {
                return this.aqq;
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
                for (C0113a c0113a : vQ()) {
                    codedOutputStreamMicro.writeMessage(5, c0113a);
                }
            }
        }

        public C0112b a(a aVar) {
            if (aVar != null) {
                if (this.aql.isEmpty()) {
                    this.aql = new ArrayList();
                }
                this.aql.add(aVar);
            }
            return this;
        }

        public C0112b bQ(int i) {
            this.aqh = true;
            this.aqi = i;
            return this;
        }

        public C0112b bR(int i) {
            this.aqj = true;
            this.aqk = i;
            return this;
        }

        public C0112b bS(int i) {
            this.aqm = true;
            this.aqn = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: d */
        public C0112b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
            if (this.apY < 0) {
                getSerializedSize();
            }
            return this.apY;
        }

        public int getDistance() {
            return this.aqi;
        }

        public int getDuration() {
            return this.aqk;
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
            this.apY = i;
            return i;
        }

        public boolean hasDuration() {
            return this.aqj;
        }

        public boolean vK() {
            return this.aqh;
        }

        public List<a> vL() {
            return this.aql;
        }

        public int vM() {
            return this.aqn;
        }

        public boolean vN() {
            return this.aqm;
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
        this.apZ = true;
        this.aqa = aVar;
        return this;
    }

    public b a(C0112b c0112b) {
        if (c0112b != null) {
            if (this.aqb.isEmpty()) {
                this.aqb = new ArrayList();
            }
            this.aqb.add(c0112b);
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
                    C0112b c0112b = new C0112b();
                    codedInputStreamMicro.readMessage(c0112b);
                    a(c0112b);
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

    public C0112b bM(int i) {
        return this.aqb.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apY < 0) {
            getSerializedSize();
        }
        return this.apY;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeMessageSize = vE() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vF()) : 0;
        Iterator<C0112b> it = vH().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.apY = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vE() {
        return this.apZ;
    }

    public a vF() {
        return this.aqa;
    }

    public b vG() {
        this.apZ = false;
        this.aqa = null;
        return this;
    }

    public List<C0112b> vH() {
        return this.aqb;
    }

    public int vI() {
        return this.aqb.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vE()) {
            codedOutputStreamMicro.writeMessage(1, vF());
        }
        for (C0112b c0112b : vH()) {
            codedOutputStreamMicro.writeMessage(2, c0112b);
        }
    }
}
