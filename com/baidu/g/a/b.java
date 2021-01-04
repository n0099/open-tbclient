package com.baidu.g.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public final class b extends MessageMicro {
    private boolean asj;
    private a ask = null;
    private List<C0117b> asl = Collections.emptyList();
    private int asi = -1;

    /* loaded from: classes15.dex */
    public static final class a extends MessageMicro {
        private boolean asn;
        private boolean asp;
        private boolean asr;
        private int aso = 0;
        private int asq = 0;
        private int type_ = 0;
        private int asi = -1;

        public a bP(int i) {
            this.asn = true;
            this.aso = i;
            return this;
        }

        public a bQ(int i) {
            this.asp = true;
            this.asq = i;
            return this;
        }

        public a bR(int i) {
            this.asr = true;
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
            if (this.asi < 0) {
                getSerializedSize();
            }
            return this.asi;
        }

        public int getError() {
            return this.aso;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasError() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getError()) : 0;
            if (va()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.asi = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.asq;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.asn;
        }

        public boolean hasType() {
            return this.asr;
        }

        public boolean va() {
            return this.asp;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (va()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    /* renamed from: com.baidu.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C0117b extends MessageMicro {
        private boolean ass;
        private boolean asu;
        private boolean asx;
        private int ast = 0;
        private int asv = 0;
        private List<a> asw = Collections.emptyList();
        private int asy = 0;
        private int asi = -1;

        /* renamed from: com.baidu.g.a.b$b$a */
        /* loaded from: classes15.dex */
        public static final class a extends MessageMicro {
            private boolean ass;
            private boolean asu;
            private List<Double> asz = Collections.emptyList();
            private List<Double> asA = Collections.emptyList();
            private int ast = 0;
            private int asv = 0;
            private List<C0118a> asB = Collections.emptyList();
            private int asi = -1;

            /* renamed from: com.baidu.g.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes15.dex */
            public static final class C0118a extends MessageMicro {
                private boolean asC;
                private boolean asE;
                private boolean asI;
                private boolean asr;
                private boolean ass;
                private boolean asu;
                private List<Double> asz = Collections.emptyList();
                private List<Double> asA = Collections.emptyList();
                private int ast = 0;
                private int asv = 0;
                private String asD = "";
                private int type_ = 0;
                private String asF = "";
                private List<Double> asG = Collections.emptyList();
                private List<C0119a> asH = Collections.emptyList();
                private String asJ = "";
                private int asi = -1;

                /* renamed from: com.baidu.g.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes15.dex */
                public static final class C0119a extends MessageMicro {
                    private boolean arZ;
                    private boolean asL;
                    private boolean asr;
                    private String asa = "";
                    private int type_ = 0;
                    private List<Double> asK = Collections.emptyList();
                    private String asM = "";
                    private int asi = -1;

                    public C0119a ca(int i) {
                        this.asr = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0119a ee(String str) {
                        this.arZ = true;
                        this.asa = str;
                        return this;
                    }

                    public C0119a ef(String str) {
                        this.asL = true;
                        this.asM = str;
                        return this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: g */
                    public C0119a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    ee(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    ca(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
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
                        if (this.asi < 0) {
                            getSerializedSize();
                        }
                        return this.asi;
                    }

                    public String getDetail() {
                        return this.asM;
                    }

                    public String getName() {
                        return this.asa;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        int size = computeStringSize + (vp().size() * 8) + (vp().size() * 1);
                        if (vq()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        this.asi = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.arZ;
                    }

                    public boolean hasType() {
                        return this.asr;
                    }

                    public C0119a m(double d) {
                        if (this.asK.isEmpty()) {
                            this.asK = new ArrayList();
                        }
                        this.asK.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> vp() {
                        return this.asK;
                    }

                    public boolean vq() {
                        return this.asL;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        for (Double d : vp()) {
                            codedOutputStreamMicro.writeDouble(3, d.doubleValue());
                        }
                        if (vq()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                    }
                }

                public C0118a a(C0119a c0119a) {
                    if (c0119a != null) {
                        if (this.asH.isEmpty()) {
                            this.asH = new ArrayList();
                        }
                        this.asH.add(c0119a);
                    }
                    return this;
                }

                public C0118a bX(int i) {
                    this.ass = true;
                    this.ast = i;
                    return this;
                }

                public C0118a bY(int i) {
                    this.asu = true;
                    this.asv = i;
                    return this;
                }

                public C0118a bZ(int i) {
                    this.asr = true;
                    this.type_ = i;
                    return this;
                }

                public C0118a eb(String str) {
                    this.asC = true;
                    this.asD = str;
                    return this;
                }

                public C0118a ec(String str) {
                    this.asE = true;
                    this.asF = str;
                    return this;
                }

                public C0118a ed(String str) {
                    this.asI = true;
                    this.asJ = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: f */
                public C0118a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                eb(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bZ(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                ec(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                l(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                C0119a c0119a = new C0119a();
                                codedInputStreamMicro.readMessage(c0119a);
                                a(c0119a);
                                break;
                            case 82:
                                ed(codedInputStreamMicro.readString());
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

                public String getInstructions() {
                    return this.asD;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int size = 0 + (vf().size() * 8) + (vf().size() * 1) + (vg().size() * 8) + (vg().size() * 1);
                    if (vb()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (vi()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (vk()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, vj());
                    }
                    int size2 = size + (vl().size() * 8) + (vl().size() * 1);
                    Iterator<C0119a> it = vm().iterator();
                    while (true) {
                        i = size2;
                        if (!it.hasNext()) {
                            break;
                        }
                        size2 = CodedOutputStreamMicro.computeMessageSize(9, it.next()) + i;
                    }
                    if (vo()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, vn());
                    }
                    this.asi = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.asu;
                }

                public boolean hasType() {
                    return this.asr;
                }

                public C0118a j(double d) {
                    if (this.asz.isEmpty()) {
                        this.asz = new ArrayList();
                    }
                    this.asz.add(Double.valueOf(d));
                    return this;
                }

                public C0118a k(double d) {
                    if (this.asA.isEmpty()) {
                        this.asA = new ArrayList();
                    }
                    this.asA.add(Double.valueOf(d));
                    return this;
                }

                public C0118a l(double d) {
                    if (this.asG.isEmpty()) {
                        this.asG = new ArrayList();
                    }
                    this.asG.add(Double.valueOf(d));
                    return this;
                }

                public boolean vb() {
                    return this.ass;
                }

                public List<Double> vf() {
                    return this.asz;
                }

                public List<Double> vg() {
                    return this.asA;
                }

                public boolean vi() {
                    return this.asC;
                }

                public String vj() {
                    return this.asF;
                }

                public boolean vk() {
                    return this.asE;
                }

                public List<Double> vl() {
                    return this.asG;
                }

                public List<C0119a> vm() {
                    return this.asH;
                }

                public String vn() {
                    return this.asJ;
                }

                public boolean vo() {
                    return this.asI;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double d : vf()) {
                        codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                    }
                    for (Double d2 : vg()) {
                        codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                    }
                    if (vb()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (vi()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (vk()) {
                        codedOutputStreamMicro.writeString(7, vj());
                    }
                    for (Double d3 : vl()) {
                        codedOutputStreamMicro.writeDouble(8, d3.doubleValue());
                    }
                    for (C0119a c0119a : vm()) {
                        codedOutputStreamMicro.writeMessage(9, c0119a);
                    }
                    if (vo()) {
                        codedOutputStreamMicro.writeString(10, vn());
                    }
                }
            }

            public a a(C0118a c0118a) {
                if (c0118a != null) {
                    if (this.asB.isEmpty()) {
                        this.asB = new ArrayList();
                    }
                    this.asB.add(c0118a);
                }
                return this;
            }

            public a bV(int i) {
                this.ass = true;
                this.ast = i;
                return this;
            }

            public a bW(int i) {
                this.asu = true;
                this.asv = i;
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
                            C0118a c0118a = new C0118a();
                            codedInputStreamMicro.readMessage(c0118a);
                            a(c0118a);
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
                int size = 0 + (vf().size() * 8) + (vf().size() * 1) + (vg().size() * 8) + (vg().size() * 1);
                if (vb()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                Iterator<C0118a> it = vh().iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        this.asi = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.asz.isEmpty()) {
                    this.asz = new ArrayList();
                }
                this.asz.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.asu;
            }

            public a i(double d) {
                if (this.asA.isEmpty()) {
                    this.asA = new ArrayList();
                }
                this.asA.add(Double.valueOf(d));
                return this;
            }

            public boolean vb() {
                return this.ass;
            }

            public List<Double> vf() {
                return this.asz;
            }

            public List<Double> vg() {
                return this.asA;
            }

            public List<C0118a> vh() {
                return this.asB;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Double d : vf()) {
                    codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                }
                for (Double d2 : vg()) {
                    codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                }
                if (vb()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                for (C0118a c0118a : vh()) {
                    codedOutputStreamMicro.writeMessage(5, c0118a);
                }
            }
        }

        public C0117b a(a aVar) {
            if (aVar != null) {
                if (this.asw.isEmpty()) {
                    this.asw = new ArrayList();
                }
                this.asw.add(aVar);
            }
            return this;
        }

        public C0117b bS(int i) {
            this.ass = true;
            this.ast = i;
            return this;
        }

        public C0117b bT(int i) {
            this.asu = true;
            this.asv = i;
            return this;
        }

        public C0117b bU(int i) {
            this.asx = true;
            this.asy = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: d */
        public C0117b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
            int computeInt32Size = vb() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
            if (hasDuration()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            Iterator<a> it = vc().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(3, it.next()) + i;
            }
            if (ve()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, vd());
            }
            this.asi = i;
            return i;
        }

        public boolean hasDuration() {
            return this.asu;
        }

        public boolean vb() {
            return this.ass;
        }

        public List<a> vc() {
            return this.asw;
        }

        public int vd() {
            return this.asy;
        }

        public boolean ve() {
            return this.asx;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vb()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            for (a aVar : vc()) {
                codedOutputStreamMicro.writeMessage(3, aVar);
            }
            if (ve()) {
                codedOutputStreamMicro.writeInt32(4, vd());
            }
        }
    }

    public b a(a aVar) {
        if (aVar == null) {
            return uX();
        }
        this.asj = true;
        this.ask = aVar;
        return this;
    }

    public b a(C0117b c0117b) {
        if (c0117b != null) {
            if (this.asl.isEmpty()) {
                this.asl = new ArrayList();
            }
            this.asl.add(c0117b);
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

    public C0117b bO(int i) {
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
        int computeMessageSize = uV() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, uW()) : 0;
        Iterator<C0117b> it = uY().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.asi = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean uV() {
        return this.asj;
    }

    public a uW() {
        return this.ask;
    }

    public b uX() {
        this.asj = false;
        this.ask = null;
        return this;
    }

    public List<C0117b> uY() {
        return this.asl;
    }

    public int uZ() {
        return this.asl.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (uV()) {
            codedOutputStreamMicro.writeMessage(1, uW());
        }
        for (C0117b c0117b : uY()) {
            codedOutputStreamMicro.writeMessage(2, c0117b);
        }
    }
}
