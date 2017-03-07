package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;
/* loaded from: classes.dex */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat LTR = new e(null, false);
    public static final TextDirectionHeuristicCompat RTL = new e(null, true);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new e(b.kk, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new e(b.kk, true);
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new e(a.ki, false);
    public static final TextDirectionHeuristicCompat LOCALE = f.kn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int b(CharSequence charSequence, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i) {
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

    /* loaded from: classes.dex */
    private static abstract class d implements TextDirectionHeuristicCompat {
        private final c kl;

        protected abstract boolean bf();

        public d(c cVar) {
            this.kl = cVar;
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
            return this.kl == null ? bf() : c(charSequence, i, i2);
        }

        private boolean c(CharSequence charSequence, int i, int i2) {
            switch (this.kl.b(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return bf();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        private final boolean km;

        private e(c cVar, boolean z) {
            super(cVar);
            this.km = z;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.d
        protected boolean bf() {
            return this.km;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {
        public static final b kk = new b();

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.c
        public int b(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.m(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* loaded from: classes.dex */
    private static class a implements c {
        public static final a ki = new a(true);
        public static final a kj = new a(false);
        private final boolean kh;

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.c
        public int b(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (TextDirectionHeuristicsCompat.l(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.kh) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (this.kh) {
                            z = true;
                            break;
                        } else {
                            return 1;
                        }
                }
                i++;
            }
            if (z) {
                return !this.kh ? 0 : 1;
            }
            return 2;
        }

        private a(boolean z) {
            this.kh = z;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends d {
        public static final f kn = new f();

        public f() {
            super(null);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.d
        protected boolean bf() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }
}
