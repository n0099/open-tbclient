package android.support.v4.text;
/* loaded from: classes.dex */
class b {
    private static final byte[] bj = new byte[1792];
    private final boolean bk;
    private int bl;
    private char bm;
    private final int length;
    private final String text;

    static {
        for (int i = 0; i < 1792; i++) {
            bj[i] = Character.getDirectionality(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, boolean z) {
        this.text = str;
        this.bk = z;
        this.length = str.length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int X() {
        this.bl = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (this.bl < this.length && i == 0) {
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
        while (this.bl > 0) {
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
        this.bl = this.length;
        int i = 0;
        int i2 = 0;
        while (this.bl > 0) {
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
        return c < 1792 ? bj[c] : Character.getDirectionality(c);
    }

    byte Z() {
        this.bm = this.text.charAt(this.bl);
        if (Character.isHighSurrogate(this.bm)) {
            int codePointAt = Character.codePointAt(this.text, this.bl);
            this.bl += Character.charCount(codePointAt);
            return Character.getDirectionality(codePointAt);
        }
        this.bl++;
        byte a = a(this.bm);
        if (this.bk) {
            if (this.bm == '<') {
                return ab();
            }
            if (this.bm == '&') {
                return ad();
            }
            return a;
        }
        return a;
    }

    byte aa() {
        this.bm = this.text.charAt(this.bl - 1);
        if (Character.isLowSurrogate(this.bm)) {
            int codePointBefore = Character.codePointBefore(this.text, this.bl);
            this.bl -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.bl--;
        byte a = a(this.bm);
        if (this.bk) {
            if (this.bm == '>') {
                return ac();
            }
            if (this.bm == ';') {
                return ae();
            }
            return a;
        }
        return a;
    }

    private byte ab() {
        int i = this.bl;
        while (this.bl < this.length) {
            String str = this.text;
            int i2 = this.bl;
            this.bl = i2 + 1;
            this.bm = str.charAt(i2);
            if (this.bm == '>') {
                return (byte) 12;
            }
            if (this.bm == '\"' || this.bm == '\'') {
                char c = this.bm;
                while (this.bl < this.length) {
                    String str2 = this.text;
                    int i3 = this.bl;
                    this.bl = i3 + 1;
                    char charAt = str2.charAt(i3);
                    this.bm = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.bl = i;
        this.bm = '<';
        return (byte) 13;
    }

    private byte ac() {
        int i = this.bl;
        while (this.bl > 0) {
            String str = this.text;
            int i2 = this.bl - 1;
            this.bl = i2;
            this.bm = str.charAt(i2);
            if (this.bm == '<') {
                return (byte) 12;
            }
            if (this.bm == '>') {
                break;
            } else if (this.bm == '\"' || this.bm == '\'') {
                char c = this.bm;
                while (this.bl > 0) {
                    String str2 = this.text;
                    int i3 = this.bl - 1;
                    this.bl = i3;
                    char charAt = str2.charAt(i3);
                    this.bm = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.bl = i;
        this.bm = '>';
        return (byte) 13;
    }

    private byte ad() {
        while (this.bl < this.length) {
            String str = this.text;
            int i = this.bl;
            this.bl = i + 1;
            char charAt = str.charAt(i);
            this.bm = charAt;
            if (charAt == ';') {
                return (byte) 12;
            }
        }
        return (byte) 12;
    }

    private byte ae() {
        int i = this.bl;
        while (this.bl > 0) {
            String str = this.text;
            int i2 = this.bl - 1;
            this.bl = i2;
            this.bm = str.charAt(i2);
            if (this.bm == '&') {
                return (byte) 12;
            }
            if (this.bm == ';') {
                break;
            }
        }
        this.bl = i;
        this.bm = ';';
        return (byte) 13;
    }
}
