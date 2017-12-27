package android.support.v7.app;
/* loaded from: classes2.dex */
class n {
    private static n DZ;
    public long Ea;
    public long Eb;
    public int state;

    n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n em() {
        if (DZ == null) {
            DZ = new n();
        }
        return DZ;
    }

    public void a(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = 6.24006f + (0.01720197f * f);
        double sin = f2 + (0.03341960161924362d * Math.sin(f2)) + (3.4906598739326E-4d * Math.sin(2.0f * f2)) + (5.236000106378924E-6d * Math.sin(3.0f * f2)) + 1.796593063d + 3.141592653589793d;
        double d3 = (-d2) / 360.0d;
        double sin2 = (Math.sin(f2) * 0.0053d) + d3 + ((float) Math.round((f - 9.0E-4f) - d3)) + 9.0E-4f + ((-0.0069d) * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(asin))) / (Math.cos(asin) * Math.cos(d4));
        if (sin3 >= 1.0d) {
            this.state = 1;
            this.Ea = -1L;
            this.Eb = -1L;
        } else if (sin3 <= -1.0d) {
            this.state = 0;
            this.Ea = -1L;
            this.Eb = -1L;
        } else {
            float acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.Ea = Math.round((acos + sin2) * 8.64E7d) + 946728000000L;
            this.Eb = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            if (this.Eb < j && this.Ea > j) {
                this.state = 0;
            } else {
                this.state = 1;
            }
        }
    }
}
