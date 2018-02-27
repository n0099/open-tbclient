package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat LTR = new e(null, false);
    public static final TextDirectionHeuristicCompat RTL = new e(null, true);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new e(b.Be, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new e(b.Be, true);
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new e(a.Bc, false);
    public static final TextDirectionHeuristicCompat LOCALE = f.Bh;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface c {
        int b(CharSequence charSequence, int i, int i2);
    }

    static int at(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int au(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class d implements TextDirectionHeuristicCompat {
        private final c Bf;

        protected abstract boolean dQ();

        public d(c cVar) {
            this.Bf = cVar;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl(CharBuffer.wrap(cArr), i, i2);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.Bf == null ? dQ() : c(charSequence, i, i2);
        }

        private boolean c(CharSequence charSequence, int i, int i2) {
            switch (this.Bf.b(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return dQ();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class e extends d {
        private final boolean Bg;

        e(c cVar, boolean z) {
            super(cVar);
            this.Bg = z;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.d
        protected boolean dQ() {
            return this.Bg;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements c {
        public static final b Be = new b();

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.c
        public int b(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.au(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements c {
        public static final a Bc = new a(true);
        public static final a Bd = new a(false);
        private final boolean Bb;

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.c
        public int b(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (TextDirectionHeuristicsCompat.at(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.Bb) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (this.Bb) {
                            z = true;
                            break;
                        } else {
                            return 1;
                        }
                }
                i++;
            }
            if (z) {
                return !this.Bb ? 0 : 1;
            }
            return 2;
        }

        private a(boolean z) {
            this.Bb = z;
        }
    }

    /* loaded from: classes2.dex */
    private static class f extends d {
        public static final f Bh = new f();

        public f() {
            super(null);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.d
        protected boolean dQ() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    private TextDirectionHeuristicsCompat() {
    }
}
