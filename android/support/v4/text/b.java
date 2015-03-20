package android.support.v4.text;
/* loaded from: classes.dex */
class b {
    private static final byte[] mn = new byte[1792];
    private final int length;
    private final boolean mo;
    private int mp;
    private char mq;
    private final String text;

    static {
        for (int i = 0; i < 1792; i++) {
            mn[i] = Character.getDirectionality(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, boolean z) {
        this.text = str;
        this.mo = z;
        this.length = str.length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dv() {
        this.mp = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (this.mp < this.length && i == 0) {
            switch (dx()) {
                case 0:
                    if (i3 != 0) {
                        i = i3;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                case 2:
                    if (i3 != 0) {
                        i = i3;
                        break;
                    } else {
                        return 1;
                    }
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    i = i3;
                    break;
                case 9:
                    break;
                case 14:
                case 15:
                    i3++;
                    i2 = -1;
                    break;
                case 16:
                case 17:
                    i3++;
                    i2 = 1;
                    break;
                case 18:
                    i3--;
                    i2 = 0;
                    break;
            }
        }
        if (i == 0) {
            return 0;
        }
        if (i2 != 0) {
            return i2;
        }
        while (this.mp > 0) {
            switch (dy()) {
                case 14:
                case 15:
                    if (i != i3) {
                        i3--;
                        break;
                    } else {
                        return -1;
                    }
                case 16:
                case 17:
                    if (i != i3) {
                        i3--;
                        break;
                    } else {
                        return 1;
                    }
                case 18:
                    i3++;
                    break;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dw() {
        this.mp = this.length;
        int i = 0;
        int i2 = 0;
        while (this.mp > 0) {
            switch (dy()) {
                case 0:
                    if (i2 != 0) {
                        if (i != 0) {
                            break;
                        } else {
                            i = i2;
                            break;
                        }
                    } else {
                        return -1;
                    }
                case 1:
                case 2:
                    if (i2 != 0) {
                        if (i != 0) {
                            break;
                        } else {
                            i = i2;
                            break;
                        }
                    } else {
                        return 1;
                    }
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    if (i != 0) {
                        break;
                    } else {
                        i = i2;
                        break;
                    }
                case 9:
                    break;
                case 14:
                case 15:
                    if (i != i2) {
                        i2--;
                        break;
                    } else {
                        return -1;
                    }
                case 16:
                case 17:
                    if (i != i2) {
                        i2--;
                        break;
                    } else {
                        return 1;
                    }
                case 18:
                    i2++;
                    break;
            }
        }
        return 0;
    }

    private static byte a(char c) {
        return c < 1792 ? mn[c] : Character.getDirectionality(c);
    }

    byte dx() {
        this.mq = this.text.charAt(this.mp);
        if (Character.isHighSurrogate(this.mq)) {
            int codePointAt = Character.codePointAt(this.text, this.mp);
            this.mp += Character.charCount(codePointAt);
            return Character.getDirectionality(codePointAt);
        }
        this.mp++;
        byte a = a(this.mq);
        if (this.mo) {
            if (this.mq == '<') {
                return dz();
            }
            if (this.mq == '&') {
                return dB();
            }
            return a;
        }
        return a;
    }

    byte dy() {
        this.mq = this.text.charAt(this.mp - 1);
        if (Character.isLowSurrogate(this.mq)) {
            int codePointBefore = Character.codePointBefore(this.text, this.mp);
            this.mp -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.mp--;
        byte a = a(this.mq);
        if (this.mo) {
            if (this.mq == '>') {
                return dA();
            }
            if (this.mq == ';') {
                return dC();
            }
            return a;
        }
        return a;
    }

    private byte dz() {
        int i = this.mp;
        while (this.mp < this.length) {
            String str = this.text;
            int i2 = this.mp;
            this.mp = i2 + 1;
            this.mq = str.charAt(i2);
            if (this.mq == '>') {
                return (byte) 12;
            }
            if (this.mq == '\"' || this.mq == '\'') {
                char c = this.mq;
                while (this.mp < this.length) {
                    String str2 = this.text;
                    int i3 = this.mp;
                    this.mp = i3 + 1;
                    char charAt = str2.charAt(i3);
                    this.mq = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.mp = i;
        this.mq = '<';
        return (byte) 13;
    }

    private byte dA() {
        int i = this.mp;
        while (this.mp > 0) {
            String str = this.text;
            int i2 = this.mp - 1;
            this.mp = i2;
            this.mq = str.charAt(i2);
            if (this.mq == '<') {
                return (byte) 12;
            }
            if (this.mq == '>') {
                break;
            } else if (this.mq == '\"' || this.mq == '\'') {
                char c = this.mq;
                while (this.mp > 0) {
                    String str2 = this.text;
                    int i3 = this.mp - 1;
                    this.mp = i3;
                    char charAt = str2.charAt(i3);
                    this.mq = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.mp = i;
        this.mq = '>';
        return (byte) 13;
    }

    private byte dB() {
        while (this.mp < this.length) {
            String str = this.text;
            int i = this.mp;
            this.mp = i + 1;
            char charAt = str.charAt(i);
            this.mq = charAt;
            if (charAt == ';') {
                return (byte) 12;
            }
        }
        return (byte) 12;
    }

    private byte dC() {
        int i = this.mp;
        while (this.mp > 0) {
            String str = this.text;
            int i2 = this.mp - 1;
            this.mp = i2;
            this.mq = str.charAt(i2);
            if (this.mq == '&') {
                return (byte) 12;
            }
            if (this.mq == ';') {
                break;
            }
        }
        this.mp = i;
        this.mq = ';';
        return (byte) 13;
    }
}
