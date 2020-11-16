package com.baidu.g.a;

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
    private boolean aqP;
    private a aqQ = null;
    private List<C0124b> aqR = Collections.emptyList();
    private int aqO = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqS;
        private boolean aqU;
        private boolean aqW;
        private int aqT = 0;
        private int aqV = 0;
        private int type_ = 0;
        private int aqO = -1;

        public a bL(int i) {
            this.aqS = true;
            this.aqT = i;
            return this;
        }

        public a bM(int i) {
            this.aqU = true;
            this.aqV = i;
            return this;
        }

        public a bN(int i) {
            this.aqW = true;
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
                        bL(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bM(codedInputStreamMicro.readInt32());
                        break;
                    case 24:
                        bN(codedInputStreamMicro.readInt32());
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
            if (this.aqO < 0) {
                getSerializedSize();
            }
            return this.aqO;
        }

        public int getError() {
            return this.aqT;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasError() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getError()) : 0;
            if (vR()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            this.aqO = computeInt32Size;
            return computeInt32Size;
        }

        public int getTotal() {
            return this.aqV;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.aqS;
        }

        public boolean hasType() {
            return this.aqW;
        }

        public boolean vR() {
            return this.aqU;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (vR()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
        }
    }

    /* renamed from: com.baidu.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0124b extends MessageMicro {
        private boolean aqX;
        private boolean aqZ;
        private boolean arc;
        private int aqY = 0;
        private int ara = 0;
        private List<a> arb = Collections.emptyList();
        private int ard = 0;
        private int aqO = -1;

        /* renamed from: com.baidu.g.a.b$b$a */
        /* loaded from: classes7.dex */
        public static final class a extends MessageMicro {
            private boolean aqX;
            private boolean aqZ;
            private List<Double> are = Collections.emptyList();
            private List<Double> arf = Collections.emptyList();
            private int aqY = 0;
            private int ara = 0;
            private List<C0125a> arg = Collections.emptyList();
            private int aqO = -1;

            /* renamed from: com.baidu.g.a.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public static final class C0125a extends MessageMicro {
                private boolean aqW;
                private boolean aqX;
                private boolean aqZ;
                private boolean arh;
                private boolean arj;
                private boolean arn;
                private List<Double> are = Collections.emptyList();
                private List<Double> arf = Collections.emptyList();
                private int aqY = 0;
                private int ara = 0;
                private String ari = "";
                private int type_ = 0;
                private String ark = "";
                private List<Double> arl = Collections.emptyList();
                private List<C0126a> arm = Collections.emptyList();
                private String aro = "";
                private int aqO = -1;

                /* renamed from: com.baidu.g.a.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C0126a extends MessageMicro {
                    private boolean aqF;
                    private boolean aqW;
                    private boolean arq;
                    private String aqG = "";
                    private int type_ = 0;
                    private List<Double> arp = Collections.emptyList();
                    private String arr = "";
                    private int aqO = -1;

                    public C0126a bW(int i) {
                        this.aqW = true;
                        this.type_ = i;
                        return this;
                    }

                    public C0126a ep(String str) {
                        this.aqF = true;
                        this.aqG = str;
                        return this;
                    }

                    public C0126a eq(String str) {
                        this.arq = true;
                        this.arr = str;
                        return this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.protobuf.micro.MessageMicro
                    /* renamed from: g */
                    public C0126a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    ep(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    bW(codedInputStreamMicro.readInt32());
                                    break;
                                case 25:
                                    m(codedInputStreamMicro.readDouble());
                                    break;
                                case 34:
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

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.aqO < 0) {
                            getSerializedSize();
                        }
                        return this.aqO;
                    }

                    public String getDetail() {
                        return this.arr;
                    }

                    public String getName() {
                        return this.aqG;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        int size = computeStringSize + (wg().size() * 8) + (wg().size() * 1);
                        if (wh()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        this.aqO = size;
                        return size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.aqF;
                    }

                    public boolean hasType() {
                        return this.aqW;
                    }

                    public C0126a m(double d) {
                        if (this.arp.isEmpty()) {
                            this.arp = new ArrayList();
                        }
                        this.arp.add(Double.valueOf(d));
                        return this;
                    }

                    public List<Double> wg() {
                        return this.arp;
                    }

                    public boolean wh() {
                        return this.arq;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        for (Double d : wg()) {
                            codedOutputStreamMicro.writeDouble(3, d.doubleValue());
                        }
                        if (wh()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                    }
                }

                public C0125a a(C0126a c0126a) {
                    if (c0126a != null) {
                        if (this.arm.isEmpty()) {
                            this.arm = new ArrayList();
                        }
                        this.arm.add(c0126a);
                    }
                    return this;
                }

                public C0125a bT(int i) {
                    this.aqX = true;
                    this.aqY = i;
                    return this;
                }

                public C0125a bU(int i) {
                    this.aqZ = true;
                    this.ara = i;
                    return this;
                }

                public C0125a bV(int i) {
                    this.aqW = true;
                    this.type_ = i;
                    return this;
                }

                public C0125a em(String str) {
                    this.arh = true;
                    this.ari = str;
                    return this;
                }

                public C0125a en(String str) {
                    this.arj = true;
                    this.ark = str;
                    return this;
                }

                public C0125a eo(String str) {
                    this.arn = true;
                    this.aro = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.micro.MessageMicro
                /* renamed from: f */
                public C0125a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                bT(codedInputStreamMicro.readInt32());
                                break;
                            case 32:
                                bU(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                em(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                bV(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                en(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                l(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                C0126a c0126a = new C0126a();
                                codedInputStreamMicro.readMessage(c0126a);
                                a(c0126a);
                                break;
                            case 82:
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
                    if (this.aqO < 0) {
                        getSerializedSize();
                    }
                    return this.aqO;
                }

                public int getDistance() {
                    return this.aqY;
                }

                public int getDuration() {
                    return this.ara;
                }

                public String getInstructions() {
                    return this.ari;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i;
                    int size = 0 + (vW().size() * 8) + (vW().size() * 1) + (vX().size() * 8) + (vX().size() * 1);
                    if (vS()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (vZ()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (wb()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, wa());
                    }
                    int size2 = size + (wc().size() * 8) + (wc().size() * 1);
                    Iterator<C0126a> it = wd().iterator();
                    while (true) {
                        i = size2;
                        if (!it.hasNext()) {
                            break;
                        }
                        size2 = CodedOutputStreamMicro.computeMessageSize(9, it.next()) + i;
                    }
                    if (wf()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, we());
                    }
                    this.aqO = i;
                    return i;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDuration() {
                    return this.aqZ;
                }

                public boolean hasType() {
                    return this.aqW;
                }

                public C0125a j(double d) {
                    if (this.are.isEmpty()) {
                        this.are = new ArrayList();
                    }
                    this.are.add(Double.valueOf(d));
                    return this;
                }

                public C0125a k(double d) {
                    if (this.arf.isEmpty()) {
                        this.arf = new ArrayList();
                    }
                    this.arf.add(Double.valueOf(d));
                    return this;
                }

                public C0125a l(double d) {
                    if (this.arl.isEmpty()) {
                        this.arl = new ArrayList();
                    }
                    this.arl.add(Double.valueOf(d));
                    return this;
                }

                public boolean vS() {
                    return this.aqX;
                }

                public List<Double> vW() {
                    return this.are;
                }

                public List<Double> vX() {
                    return this.arf;
                }

                public boolean vZ() {
                    return this.arh;
                }

                public String wa() {
                    return this.ark;
                }

                public boolean wb() {
                    return this.arj;
                }

                public List<Double> wc() {
                    return this.arl;
                }

                public List<C0126a> wd() {
                    return this.arm;
                }

                public String we() {
                    return this.aro;
                }

                public boolean wf() {
                    return this.arn;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    for (Double d : vW()) {
                        codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                    }
                    for (Double d2 : vX()) {
                        codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                    }
                    if (vS()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (vZ()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (wb()) {
                        codedOutputStreamMicro.writeString(7, wa());
                    }
                    for (Double d3 : wc()) {
                        codedOutputStreamMicro.writeDouble(8, d3.doubleValue());
                    }
                    for (C0126a c0126a : wd()) {
                        codedOutputStreamMicro.writeMessage(9, c0126a);
                    }
                    if (wf()) {
                        codedOutputStreamMicro.writeString(10, we());
                    }
                }
            }

            public a a(C0125a c0125a) {
                if (c0125a != null) {
                    if (this.arg.isEmpty()) {
                        this.arg = new ArrayList();
                    }
                    this.arg.add(c0125a);
                }
                return this;
            }

            public a bR(int i) {
                this.aqX = true;
                this.aqY = i;
                return this;
            }

            public a bS(int i) {
                this.aqZ = true;
                this.ara = i;
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
                            bR(codedInputStreamMicro.readInt32());
                            break;
                        case 32:
                            bS(codedInputStreamMicro.readInt32());
                            break;
                        case 42:
                            C0125a c0125a = new C0125a();
                            codedInputStreamMicro.readMessage(c0125a);
                            a(c0125a);
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
                if (this.aqO < 0) {
                    getSerializedSize();
                }
                return this.aqO;
            }

            public int getDistance() {
                return this.aqY;
            }

            public int getDuration() {
                return this.ara;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int size = 0 + (vW().size() * 8) + (vW().size() * 1) + (vX().size() * 8) + (vX().size() * 1);
                if (vS()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                Iterator<C0125a> it = vY().iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        this.aqO = i;
                        return i;
                    }
                    size = CodedOutputStreamMicro.computeMessageSize(5, it.next()) + i;
                }
            }

            public a h(double d) {
                if (this.are.isEmpty()) {
                    this.are = new ArrayList();
                }
                this.are.add(Double.valueOf(d));
                return this;
            }

            public boolean hasDuration() {
                return this.aqZ;
            }

            public a i(double d) {
                if (this.arf.isEmpty()) {
                    this.arf = new ArrayList();
                }
                this.arf.add(Double.valueOf(d));
                return this;
            }

            public boolean vS() {
                return this.aqX;
            }

            public List<Double> vW() {
                return this.are;
            }

            public List<Double> vX() {
                return this.arf;
            }

            public List<C0125a> vY() {
                return this.arg;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Double d : vW()) {
                    codedOutputStreamMicro.writeDouble(1, d.doubleValue());
                }
                for (Double d2 : vX()) {
                    codedOutputStreamMicro.writeDouble(2, d2.doubleValue());
                }
                if (vS()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                for (C0125a c0125a : vY()) {
                    codedOutputStreamMicro.writeMessage(5, c0125a);
                }
            }
        }

        public C0124b a(a aVar) {
            if (aVar != null) {
                if (this.arb.isEmpty()) {
                    this.arb = new ArrayList();
                }
                this.arb.add(aVar);
            }
            return this;
        }

        public C0124b bO(int i) {
            this.aqX = true;
            this.aqY = i;
            return this;
        }

        public C0124b bP(int i) {
            this.aqZ = true;
            this.ara = i;
            return this;
        }

        public C0124b bQ(int i) {
            this.arc = true;
            this.ard = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: d */
        public C0124b mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        bO(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bP(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        a aVar = new a();
                        codedInputStreamMicro.readMessage(aVar);
                        a(aVar);
                        break;
                    case 32:
                        bQ(codedInputStreamMicro.readInt32());
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
            if (this.aqO < 0) {
                getSerializedSize();
            }
            return this.aqO;
        }

        public int getDistance() {
            return this.aqY;
        }

        public int getDuration() {
            return this.ara;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i;
            int computeInt32Size = vS() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
            if (hasDuration()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            Iterator<a> it = vT().iterator();
            while (true) {
                i = computeInt32Size;
                if (!it.hasNext()) {
                    break;
                }
                computeInt32Size = CodedOutputStreamMicro.computeMessageSize(3, it.next()) + i;
            }
            if (vV()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, vU());
            }
            this.aqO = i;
            return i;
        }

        public boolean hasDuration() {
            return this.aqZ;
        }

        public boolean vS() {
            return this.aqX;
        }

        public List<a> vT() {
            return this.arb;
        }

        public int vU() {
            return this.ard;
        }

        public boolean vV() {
            return this.arc;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vS()) {
                codedOutputStreamMicro.writeInt32(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeInt32(2, getDuration());
            }
            for (a aVar : vT()) {
                codedOutputStreamMicro.writeMessage(3, aVar);
            }
            if (vV()) {
                codedOutputStreamMicro.writeInt32(4, vU());
            }
        }
    }

    public b a(a aVar) {
        if (aVar == null) {
            return vO();
        }
        this.aqP = true;
        this.aqQ = aVar;
        return this;
    }

    public b a(C0124b c0124b) {
        if (c0124b != null) {
            if (this.aqR.isEmpty()) {
                this.aqR = new ArrayList();
            }
            this.aqR.add(c0124b);
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
                    C0124b c0124b = new C0124b();
                    codedInputStreamMicro.readMessage(c0124b);
                    a(c0124b);
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

    public C0124b bK(int i) {
        return this.aqR.get(i);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqO < 0) {
            getSerializedSize();
        }
        return this.aqO;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeMessageSize = vM() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, vN()) : 0;
        Iterator<C0124b> it = vP().iterator();
        while (true) {
            int i = computeMessageSize;
            if (!it.hasNext()) {
                this.aqO = i;
                return i;
            }
            computeMessageSize = CodedOutputStreamMicro.computeMessageSize(2, it.next()) + i;
        }
    }

    public boolean vM() {
        return this.aqP;
    }

    public a vN() {
        return this.aqQ;
    }

    public b vO() {
        this.aqP = false;
        this.aqQ = null;
        return this;
    }

    public List<C0124b> vP() {
        return this.aqR;
    }

    public int vQ() {
        return this.aqR.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vM()) {
            codedOutputStreamMicro.writeMessage(1, vN());
        }
        for (C0124b c0124b : vP()) {
            codedOutputStreamMicro.writeMessage(2, c0124b);
        }
    }
}
