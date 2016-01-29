package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;
/* loaded from: classes.dex */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat LTR = new e(null, false);
    public static final TextDirectionHeuristicCompat RTL = new e(null, true);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new e(b.mB, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new e(b.mB, true);
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new e(a.mz, false);
    public static final TextDirectionHeuristicCompat LOCALE = f.mF;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int b(CharSequence charSequence, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i) {
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
    public static int o(int i) {
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
        private final c mD;

        protected abstract boolean dF();

        public d(c cVar) {
            this.mD = cVar;
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
            return this.mD == null ? dF() : c(charSequence, i, i2);
        }

        private boolean c(CharSequence charSequence, int i, int i2) {
            switch (this.mD.b(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return dF();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        private final boolean mE;

        private e(c cVar, boolean z) {
            super(cVar);
            this.mE = z;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.d
        protected boolean dF() {
            return this.mE;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {
        public static final b mB = new b();

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.c
        public int b(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.o(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* loaded from: classes.dex */
    private static class a implements c {
        private final boolean my;
        public static final a mz = new a(true);
        public static final a mA = new a(false);

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.c
        public int b(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (TextDirectionHeuristicsCompat.n(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.my) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (this.my) {
                            z = true;
                            break;
                        } else {
                            return 1;
                        }
                }
                i++;
            }
            if (z) {
                return !this.my ? 0 : 1;
            }
            return 2;
        }

        private a(boolean z) {
            this.my = z;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends d {
        public static final f mF = new f();

        public f() {
            super(null);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.d
        protected boolean dF() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }
}
