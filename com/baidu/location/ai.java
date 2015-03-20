package com.baidu.location;

import android.util.Xml;
import java.io.StringReader;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
class ai implements a0, n {
    private float hA;
    public String hB;
    private double hC;
    private boolean hD;
    public String hE;
    public String hu;
    private double hv;
    public String hw;
    private boolean hx;
    public String hy;
    public String hz;

    public ai() {
        this.hC = Double.MIN_VALUE;
        this.hv = Double.MIN_VALUE;
        this.hA = 0.0f;
        this.hD = false;
        this.hx = true;
        this.hz = "";
        this.hw = "";
        this.hy = "";
        this.hE = "";
        this.hB = "";
        this.hu = "";
    }

    public ai(String str) {
        XmlPullParser newPullParser;
        int eventType;
        boolean z = false;
        this.hC = Double.MIN_VALUE;
        this.hv = Double.MIN_VALUE;
        this.hA = 0.0f;
        this.hD = false;
        this.hx = true;
        this.hz = "";
        this.hw = "";
        this.hy = "";
        this.hE = "";
        this.hB = "";
        this.hu = "";
        try {
            newPullParser = Xml.newPullParser();
            newPullParser.setInput(new StringReader(str));
            newPullParser.next();
        } catch (Exception e) {
            return;
        }
        for (eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    if (z) {
                        String name = newPullParser.getName();
                        if (name != null) {
                            if (name.equals("latitude")) {
                                try {
                                    this.hC = Double.valueOf(newPullParser.nextText()).doubleValue();
                                    continue;
                                } catch (Exception e2) {
                                    this.hx = false;
                                    continue;
                                }
                            } else if (name.equals("longitude")) {
                                try {
                                    this.hv = Double.valueOf(newPullParser.nextText()).doubleValue();
                                    continue;
                                } catch (Exception e3) {
                                    this.hx = false;
                                    continue;
                                }
                            } else if (name.equals("hpe")) {
                                try {
                                    this.hA = Float.valueOf(newPullParser.nextText()).floatValue();
                                    continue;
                                } catch (Exception e4) {
                                    this.hx = false;
                                    continue;
                                }
                            } else if (name.equals("country")) {
                                try {
                                    this.hw = newPullParser.nextText();
                                    continue;
                                } catch (Exception e5) {
                                    continue;
                                }
                            } else if (name.equals("province")) {
                                try {
                                    this.hy = newPullParser.nextText();
                                    continue;
                                } catch (Exception e6) {
                                    continue;
                                }
                            } else if (name.equals("region")) {
                                try {
                                    this.hE = newPullParser.nextText();
                                    continue;
                                } catch (Exception e7) {
                                    continue;
                                }
                            } else if (name.equals("street-number")) {
                                try {
                                    this.hu = newPullParser.nextText();
                                    continue;
                                } catch (Exception e8) {
                                    continue;
                                }
                            } else if (name.equals("city")) {
                                try {
                                    this.hz = newPullParser.nextText();
                                    continue;
                                } catch (Exception e9) {
                                    continue;
                                }
                            } else if (name.equals("address-line")) {
                                try {
                                    this.hB = newPullParser.nextText();
                                    continue;
                                } catch (Exception e10) {
                                    continue;
                                }
                            } else if (name.equals("error")) {
                                this.hx = false;
                                continue;
                            } else {
                                continue;
                            }
                            return;
                        }
                        continue;
                    } else if (newPullParser.getName().equals("LocationRS")) {
                        z = true;
                        continue;
                    } else {
                        continue;
                    }
            }
        }
    }

    public boolean bJ() {
        return this.hx;
    }

    public double bK() {
        return this.hC;
    }

    public double bL() {
        return this.hv;
    }

    public float bM() {
        return this.hA;
    }

    public String bN() {
        if (this.hx) {
            return String.format(Locale.CHINA, "&skyll=%.6f|%.6f|%.1f&skyflag=1&skyadd=%s|%s|%s", Double.valueOf(this.hv), Double.valueOf(this.hC), Float.valueOf(this.hA), this.hw, this.hz, this.hB);
        }
        return null;
    }
}
