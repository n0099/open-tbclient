package android.support.v4.text;
/* loaded from: classes.dex */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat LTR = new l(null, false);
    public static final TextDirectionHeuristicCompat RTL = new l(null, true);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new l(i.bs, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new l(i.bs, true);
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new l(h.bq, false);
    public static final TextDirectionHeuristicCompat LOCALE = m.bv;

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int i) {
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
    public static int h(int i) {
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
}
