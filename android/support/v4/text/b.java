package android.support.v4.text;
/* loaded from: classes.dex */
class b {
    private static final byte[] bi = new byte[1792];
    private final boolean bj;
    private int bk;
    private char bl;
    private final int length;
    private final String text;

    static {
        for (int i = 0; i < 1792; i++) {
            bi[i] = Character.getDirectionality(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, boolean z) {
        this.text = str;
        this.bj = z;
        this.length = str.length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int X() {
        this.bk = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (this.bk < this.length && i == 0) {
            switch (Z()) {
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
        while (this.bk > 0) {
            switch (aa()) {
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
    public int Y() {
        this.bk = this.length;
        int i = 0;
        int i2 = 0;
        while (this.bk > 0) {
            switch (aa()) {
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
        return c < 1792 ? bi[c] : Character.getDirectionality(c);
    }

    byte Z() {
        this.bl = this.text.charAt(this.bk);
        if (Character.isHighSurrogate(this.bl)) {
            int codePointAt = Character.codePointAt(this.text, this.bk);
            this.bk += Character.charCount(codePointAt);
            return Character.getDirectionality(codePointAt);
        }
        this.bk++;
        byte a = a(this.bl);
        if (this.bj) {
            if (this.bl == '<') {
                return ab();
            }
            if (this.bl == '&') {
                return ad();
            }
            return a;
        }
        return a;
    }

    byte aa() {
        this.bl = this.text.charAt(this.bk - 1);
        if (Character.isLowSurrogate(this.bl)) {
            int codePointBefore = Character.codePointBefore(this.text, this.bk);
            this.bk -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.bk--;
        byte a = a(this.bl);
        if (this.bj) {
            if (this.bl == '>') {
                return ac();
            }
            if (this.bl == ';') {
                return ae();
            }
            return a;
        }
        return a;
    }

    private byte ab() {
        int i = this.bk;
        while (this.bk < this.length) {
            String str = this.text;
            int i2 = this.bk;
            this.bk = i2 + 1;
            this.bl = str.charAt(i2);
            if (this.bl == '>') {
                return (byte) 12;
            }
            if (this.bl == '\"' || this.bl == '\'') {
                char c = this.bl;
                while (this.bk < this.length) {
                    String str2 = this.text;
                    int i3 = this.bk;
                    this.bk = i3 + 1;
                    char charAt = str2.charAt(i3);
                    this.bl = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.bk = i;
        this.bl = '<';
        return (byte) 13;
    }

    private byte ac() {
        int i = this.bk;
        while (this.bk > 0) {
            String str = this.text;
            int i2 = this.bk - 1;
            this.bk = i2;
            this.bl = str.charAt(i2);
            if (this.bl == '<') {
                return (byte) 12;
            }
            if (this.bl == '>') {
                break;
            } else if (this.bl == '\"' || this.bl == '\'') {
                char c = this.bl;
                while (this.bk > 0) {
                    String str2 = this.text;
                    int i3 = this.bk - 1;
                    this.bk = i3;
                    char charAt = str2.charAt(i3);
                    this.bl = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.bk = i;
        this.bl = '>';
        return (byte) 13;
    }

    private byte ad() {
        while (this.bk < this.length) {
            String str = this.text;
            int i = this.bk;
            this.bk = i + 1;
            char charAt = str.charAt(i);
            this.bl = charAt;
            if (charAt == ';') {
                return (byte) 12;
            }
        }
        return (byte) 12;
    }

    private byte ae() {
        int i = this.bk;
        while (this.bk > 0) {
            String str = this.text;
            int i2 = this.bk - 1;
            this.bk = i2;
            this.bl = str.charAt(i2);
            if (this.bl == '&') {
                return (byte) 12;
            }
            if (this.bl == ';') {
                break;
            }
        }
        this.bk = i;
        this.bl = ';';
        return (byte) 13;
    }
}
