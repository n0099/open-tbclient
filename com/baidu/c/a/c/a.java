package com.baidu.c.a.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.c.a.e.c;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusConstants;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes20.dex */
public class a {
    public final int amA;
    public final int amB;
    public final float aoA;
    private TextView aoB;
    private final CriusMeasureFunction aoC;
    public String aoD;
    public String aoE;
    public String aoF;
    public String aoG;
    public String aoH;
    public int aoI;
    public int aoJ;
    public int aoK;
    public String aoL;
    public String aoM;
    public double aoN;
    public double aoO;
    private String aoP;
    private String aoQ;
    private String aoR;
    private String aoS;
    private String aoT;
    private String aoU;
    private double aoV;
    private double aoW;
    private double aoX;
    private double aoY;
    private double aoZ;
    public String aoq;
    protected int aov;
    protected int aow;
    protected int aox;
    private CriusNode aoy;
    public final CriusNode aoz;
    public String apA;
    public Typeface apB;
    public String apC;
    public String apD;
    public String apE;
    public String apF;
    public String apG;
    public String apH;
    public String apI;
    public String apJ;
    public String apK;
    public double apL;
    public String apM;
    public String apN;
    public String apO;
    public String apP;
    public String apQ;
    public final List<a> apR;
    private double apa;
    private double apb;
    private double apc;
    private double apd;
    private double ape;
    private double apf;
    private double apg;
    private double aph;
    private double api;
    private double apj;
    private double apk;
    private double apl;
    private double apm;
    private double apn;
    private double apo;
    private double apq;
    private double apr;
    private double aps;
    public String apt;
    public double apu;
    public double apv;
    public double apw;
    public double apx;
    public double apy;
    public String apz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0094a businessConverter;
    public String color;
    public double fontSize;
    public int gravity;
    private double height;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String poster;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0094a {
        String dR(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public void a(@NonNull StaticLayout.Builder builder, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = builder.getClass().getDeclaredMethod("setUseLineSpacingFromFallbacks", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.valueOf(z));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, a aVar) {
        if (!TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                }
                textView.setMaxLines(aVar.maxLines);
            }
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (Double.compare(aVar.tA(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.tA() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.apB);
            textView.setGravity(aVar.gravity);
            float h = aVar.aoN > 0.0d ? h(aVar.aoN) : 0.0f;
            float f = aVar.aoO > 0.0d ? (float) aVar.aoO : 1.0f;
            if (h > 0.0f || f > 0.0f) {
                textView.setLineSpacing(h, f);
            }
        }
    }

    public static boolean dN(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && dN(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (uf()) {
            this.aoz.setMeasureFunction(this.aoC);
        }
        this.aoD = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.l(jSONObject, "poster");
        this.aoE = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.aoD) && this.businessConverter != null) {
            this.text = this.businessConverter.dR(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.aoN = c.m(jSONObject, "line-space");
        this.aoO = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.aoF = jSONObject.optString("data-als-stat");
        this.aoG = jSONObject.optString("data-url-stat");
        this.aoH = jSONObject.optString("data-href-pop");
        this.aoI = c.n(jSONObject, "data-share-num");
        this.aoJ = c.n(jSONObject, "data-reply-num");
        this.aoK = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.aoL = jSONObject.optString("data-share-image");
        this.aoM = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.aoP = c.l(jSONObject, "display");
        tX();
        this.aoQ = c.l(jSONObject, "flex-direction");
        ue();
        this.aoR = c.l(jSONObject, "justify-content");
        ud();
        this.aoS = c.l(jSONObject, "align-items");
        uc();
        this.aoT = c.l(jSONObject, "align-self");
        ub();
        this.aoU = c.l(jSONObject, "align-content");
        ua();
        this.aoV = c.m(jSONObject, "flex");
        tW();
        this.aoW = c.m(jSONObject, "flex-grow");
        tV();
        this.aoX = c.m(jSONObject, "flex-shrink");
        tU();
        this.aoY = c.m(jSONObject, "flex-basis");
        tT();
        this.position = c.l(jSONObject, "position");
        tZ();
        this.aoZ = c.m(jSONObject, "left");
        this.apa = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.apb = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.apc = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        tY();
        this.apd = c.m(jSONObject, "margin");
        tS();
        this.ape = c.m(jSONObject, "margin-left");
        tO();
        this.apf = c.m(jSONObject, "margin-top");
        tR();
        this.apg = c.m(jSONObject, "margin-right");
        tQ();
        this.aph = c.m(jSONObject, "margin-bottom");
        tP();
        this.api = c.m(jSONObject, "padding");
        initPadding();
        this.apj = c.m(jSONObject, "padding-left");
        tK();
        this.apk = c.m(jSONObject, "padding-top");
        tN();
        this.apl = c.m(jSONObject, "padding-right");
        tM();
        this.apm = c.m(jSONObject, "padding-bottom");
        tL();
        this.width = c.m(jSONObject, "width");
        tJ();
        this.height = c.m(jSONObject, "height");
        tI();
        this.apn = c.m(jSONObject, "min-width");
        tH();
        this.apo = c.m(jSONObject, "min-height");
        tG();
        this.apq = c.m(jSONObject, "max-width");
        tD();
        this.apr = c.m(jSONObject, "max-height");
        tF();
        this.aps = c.m(jSONObject, "aspect-ratio");
        tE();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.apN = c.l(optJSONObject, "background-image");
            this.apO = c.l(optJSONObject, "background-color");
            this.apP = c.l(optJSONObject, "border-color");
            this.apQ = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.apI = c.l(jSONObject, "background-image");
        this.apJ = c.l(jSONObject, "background-color");
        this.apK = c.l(jSONObject, "border-color");
        this.apL = c.m(jSONObject, "opacity");
        this.apM = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.apE = c.l(optJSONObject, "background-image");
            this.apF = c.l(optJSONObject, "background-color");
            this.apG = c.l(optJSONObject, "border-color");
            this.apH = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.apt = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.apu = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.apv = c.m(jSONObject, "border-top-left-radius");
        this.apw = c.m(jSONObject, "border-bottom-left-radius");
        this.apx = c.m(jSONObject, "border-top-right-radius");
        this.apy = c.m(jSONObject, "border-bottom-right-radius");
        this.apz = c.l(jSONObject, "font-style");
        this.apA = c.l(jSONObject, "font-weight");
        this.apB = Typeface.create(Typeface.DEFAULT, tB());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.apC = c.l(jSONObject, "text-align");
        this.apD = c.l(jSONObject, "vertical-align");
        this.gravity = tC();
        this.aoq = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0094a interfaceC0094a, boolean z) {
        this.aov = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.aow = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.aox = 0;
        this.aoC = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.aoB, a.this);
                TextPaint paint = a.this.aoB.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.aoN > 0.0d) {
                    f3 = a.this.h(a.this.aoN);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.aoO > 0.0d ? (float) a.this.aoO : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.aov).setHyphenationFrequency(a.this.aow);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.aox);
                        }
                        a.this.a(hyphenationFrequency, true);
                        build2 = hyphenationFrequency.build();
                    }
                    z2 = false;
                    build = build2;
                } else if (isBoring != null && (z3 || isBoring.width <= f)) {
                    build = BoringLayout.make(spannableString, paint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, f4, f3, isBoring, false);
                    z2 = true;
                } else if (Build.VERSION.SDK_INT < 23) {
                    Layout staticLayout = new StaticLayout(spannableString, paint, (int) f, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    z2 = false;
                    build = staticLayout;
                } else {
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.aov).setHyphenationFrequency(a.this.aow);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.aox);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.q(build.getWidth()), a.this.p(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float q = a.this.q(build.getWidth());
                    float p = a.this.p(build.getHeight());
                    if (!z2) {
                        boolean z4 = false;
                        if (TbadkCoreApplication.getInst().isMIUIRom()) {
                            if (Build.VERSION.SDK_INT < 23) {
                                z4 = true;
                            }
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            float lineDescent = (build.getLineDescent(0) - build.getLineAscent(0)) - f3;
                            float lineCount = ((build.getLineCount() - 1) * f3) + (build.getLineCount() * lineDescent);
                            if (lineDescent > 0.0f && p > lineCount) {
                                p -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(q, p);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.apL = -10000.0d;
        this.aoz = new CriusNode();
        this.businessConverter = interfaceC0094a;
        this.aoA = context.getResources().getDisplayMetrics().density;
        this.amA = context.getResources().getDisplayMetrics().widthPixels;
        this.amB = context.getResources().getDisplayMetrics().heightPixels;
        this.aoB = new TextView(context);
        j(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            k(optJSONObject);
            o(optJSONObject);
            n(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            m(optJSONObject2);
            l(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.apR = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0094a, false);
                    this.apR.add(aVar);
                    this.aoz.addChildAt(aVar.aoz, i);
                }
            } else {
                this.apR = null;
            }
        } else {
            this.apR = null;
        }
        if (z) {
            this.aoy = new CriusNode();
            this.aoy.addChildAt(this.aoz, 0);
            this.aoy.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double tA() {
        return this.fontSize;
    }

    private int tB() {
        return "italic".equalsIgnoreCase(this.apz) ? (TextUtils.isEmpty(this.apA) || "normal".equalsIgnoreCase(this.apA) || !"bold".equalsIgnoreCase(this.apA)) ? 2 : 3 : (TextUtils.isEmpty(this.apA) || "normal".equalsIgnoreCase(this.apA) || !"bold".equalsIgnoreCase(this.apA)) ? 0 : 1;
    }

    private int tC() {
        int i;
        if ("left".equalsIgnoreCase(this.apC)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.apC)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.apC)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.apD)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.apD)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.apD)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tD() {
        if (this.apq >= 0.0d) {
            this.aoz.setMaxWidth(h(this.apq));
        } else if (this.apq > -10000.0d) {
            this.aoz.setMaxWidth(this.amA);
        }
    }

    private void tE() {
        if (this.aps > 0.0d) {
            this.aoz.setAspectRatio((float) this.aps);
        }
    }

    private void tF() {
        if (this.apr >= 0.0d) {
            this.aoz.setMaxHeight(h(this.apr));
        } else if (this.apr > -10000.0d) {
            this.aoz.setMaxHeight(this.amB);
        }
    }

    private void tG() {
        if (this.apo >= 0.0d) {
            this.aoz.setMinHeight(h(this.apo));
        } else if (this.apo > -10000.0d) {
            this.aoz.setMinHeight(this.amB);
        }
    }

    private void tH() {
        if (this.apn >= 0.0d) {
            this.aoz.setMinWidth(h(this.apn));
        } else if (this.apn > -10000.0d) {
            this.aoz.setMinWidth(this.amA);
        }
    }

    private void tI() {
        if (this.height >= 0.0d) {
            this.aoz.setHeight(h(this.height));
        } else if (this.height > -10000.0d) {
            this.aoz.setHeight(this.amB);
        }
    }

    private void tJ() {
        if (this.width >= 0.0d) {
            this.aoz.setWidth(h(this.width));
        } else if (this.width > -10000.0d) {
            this.aoz.setWidth(this.amA);
        }
    }

    private void tK() {
        if (this.apj >= -1.0d) {
            this.aoz.setPadding(CriusEdge.LEFT, h(this.apj));
        }
    }

    private void tL() {
        if (this.apm >= -1.0d) {
            this.aoz.setPadding(CriusEdge.BOTTOM, h(this.apm));
        }
    }

    private void tM() {
        if (this.apl >= -1.0d) {
            this.aoz.setPadding(CriusEdge.RIGHT, h(this.apl));
        }
    }

    private void tN() {
        if (this.apk >= -1.0d) {
            this.aoz.setPadding(CriusEdge.TOP, h(this.apk));
        }
    }

    private void initPadding() {
        if (this.api >= -1.0d) {
            this.aoz.setPadding(CriusEdge.ALL, h(this.api));
        }
    }

    private void tO() {
        if (this.ape >= -1.0d) {
            this.aoz.setMargin(CriusEdge.LEFT, h(this.ape));
        }
    }

    private void tP() {
        if (this.aph >= -1.0d) {
            this.aoz.setMargin(CriusEdge.BOTTOM, h(this.aph));
        }
    }

    private void tQ() {
        if (this.apg >= -1.0d) {
            this.aoz.setMargin(CriusEdge.RIGHT, h(this.apg));
        }
    }

    private void tR() {
        if (this.apf >= -1.0d) {
            this.aoz.setMargin(CriusEdge.TOP, h(this.apf));
        }
    }

    private void tS() {
        if (this.apd >= -1.0d) {
            this.aoz.setMargin(CriusEdge.ALL, h(this.apd));
        }
    }

    private void tT() {
        if (this.aoY >= -1.0d) {
            this.aoz.setFlexBasis(h(this.aoY));
        }
    }

    private void tU() {
        if (this.aoX >= -1.0d) {
            this.aoz.setFlexShrink((float) this.aoX);
        }
    }

    private void tV() {
        if (this.aoW >= -1.0d) {
            this.aoz.setFlexGrow((float) this.aoW);
        }
    }

    private void tW() {
        if (this.aoV >= -1.0d) {
            this.aoz.setFlex((float) this.aoV);
        }
    }

    private void tX() {
        if (!TextUtils.isEmpty(this.aoP)) {
            if ("flex".equalsIgnoreCase(this.aoP)) {
                this.aoz.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.aoP)) {
                this.aoz.setDisplay(CriusDisplay.NONE);
            } else {
                this.aoz.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tY() {
        if (!c.b(this.aoZ, -10000.0d)) {
            this.aoz.setPosition(CriusEdge.LEFT, h(this.aoZ));
        }
        if (!c.b(this.apa, -10000.0d)) {
            this.aoz.setPosition(CriusEdge.TOP, h(this.apa));
        }
        if (!c.b(this.apb, -10000.0d)) {
            this.aoz.setPosition(CriusEdge.RIGHT, h(this.apb));
        }
        if (!c.b(this.apc, -10000.0d)) {
            this.aoz.setPosition(CriusEdge.BOTTOM, h(this.apc));
        }
    }

    private void tZ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aoz.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aoz.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void ua() {
        if (!TextUtils.isEmpty(this.aoU)) {
            if ("flex-start".equalsIgnoreCase(this.aoU)) {
                this.aoz.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoU)) {
                this.aoz.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoU)) {
                this.aoz.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aoU)) {
                this.aoz.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.aoU)) {
                this.aoz.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aoU)) {
                this.aoz.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aoz.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void ub() {
        if (!TextUtils.isEmpty(this.aoT)) {
            if ("auto".equalsIgnoreCase(this.aoT)) {
                this.aoz.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.aoT)) {
                this.aoz.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoT)) {
                this.aoz.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoT)) {
                this.aoz.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aoT)) {
                this.aoz.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aoz.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void uc() {
        if (!TextUtils.isEmpty(this.aoS)) {
            if ("flex-start".equalsIgnoreCase(this.aoS)) {
                this.aoz.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoS)) {
                this.aoz.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoS)) {
                this.aoz.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aoS)) {
                this.aoz.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aoz.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ud() {
        if (!TextUtils.isEmpty(this.aoR)) {
            if ("flex-start".equalsIgnoreCase(this.aoR)) {
                this.aoz.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoR)) {
                this.aoz.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoR)) {
                this.aoz.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.aoR)) {
                this.aoz.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aoR)) {
                this.aoz.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aoz.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ue() {
        if (!TextUtils.isEmpty(this.aoQ)) {
            if ("column".equalsIgnoreCase(this.aoQ)) {
                this.aoz.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.aoQ)) {
                this.aoz.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.aoQ)) {
                this.aoz.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.aoQ)) {
                this.aoz.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aoz.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean uf() {
        return "text".equals(this.type);
    }

    public a dO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.apR != null && this.apR.size() > 0) {
                for (a aVar : this.apR) {
                    a dO = aVar.dO(str);
                    if (dO != null) {
                        return dO;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a dP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.aoD)) {
            if (this.apR != null && this.apR.size() > 0) {
                for (a aVar : this.apR) {
                    a dP = aVar.dP(str);
                    if (dP != null) {
                        return dP;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.aoA * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean dQ(String str) {
        a dP;
        if (this.aoy == null || (dP = dP(str)) == null || dP.aoz == null) {
            return false;
        }
        dP.aoz.setDisplay(CriusDisplay.NONE);
        dP.aoz.dirty();
        this.aoy.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a dO;
        if (this.aoy != null && (dO = dO(str)) != null && dO.aoz != null) {
            dO.fontSize = f;
            dO.aoz.dirty();
            this.aoy.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
