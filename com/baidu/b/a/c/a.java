package com.baidu.b.a.c;

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
import com.baidu.b.a.e.c;
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
/* loaded from: classes13.dex */
public class a {
    public final int akF;
    public final int akG;
    public String alA;
    protected int alF;
    protected int alG;
    protected int alH;
    private CriusNode alI;
    public final CriusNode alJ;
    public final float alK;
    private TextView alL;
    private final CriusMeasureFunction alM;
    public String alN;
    public String alO;
    public String alP;
    public String alQ;
    public String alR;
    public int alS;
    public int alT;
    public int alU;
    public String alV;
    public String alW;
    public double alX;
    public double alY;
    private String alZ;
    private double amA;
    private double amB;
    public String amC;
    public double amD;
    public double amE;
    public double amF;
    public double amG;
    public double amH;
    public String amI;
    public String amJ;
    public Typeface amK;
    public String amL;
    public String amM;
    public String amN;
    public String amO;
    public String amP;
    public String amQ;
    public String amR;
    public String amS;
    public String amT;
    public double amU;
    public String amV;
    public String amW;
    public String amX;
    public String amY;
    public String amZ;
    private String ama;
    private String amb;
    private String amc;
    private String amd;
    private String ame;
    private double amf;
    private double amg;
    private double amh;
    private double ami;
    private double amj;
    private double amk;
    private double aml;
    private double amm;
    private double amn;
    private double amo;
    private double amp;
    private double amq;
    private double amr;
    private double ams;
    private double amt;
    private double amu;
    private double amv;
    private double amw;
    private double amx;
    private double amy;
    private double amz;
    public final List<a> ana;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0087a businessConverter;
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

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0087a {
        String dx(String str);
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
            if (Double.compare(aVar.sY(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.sY() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.amK);
            textView.setGravity(aVar.gravity);
            float h = aVar.alX > 0.0d ? h(aVar.alX) : 0.0f;
            float f = aVar.alY > 0.0d ? (float) aVar.alY : 1.0f;
            if (h > 0.0f || f > 0.0f) {
                textView.setLineSpacing(h, f);
            }
        }
    }

    public static boolean dt(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && dt(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void i(JSONObject jSONObject) {
        this.id = c.g(jSONObject, "id");
        this.name = c.g(jSONObject, "name");
        this.type = c.g(jSONObject, "type");
        if (tE()) {
            this.alJ.setMeasureFunction(this.alM);
        }
        this.alN = c.g(jSONObject, "component");
        this.src = c.g(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.g(jSONObject, "poster");
        this.alO = c.g(jSONObject, "href");
        this.text = c.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.alN) && this.businessConverter != null) {
            this.text = this.businessConverter.dx(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.alX = c.h(jSONObject, "line-space");
        this.alY = c.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.alP = jSONObject.optString("data-als-stat");
        this.alQ = jSONObject.optString("data-url-stat");
        this.alR = jSONObject.optString("data-href-pop");
        this.alS = c.i(jSONObject, "data-share-num");
        this.alT = c.i(jSONObject, "data-reply-num");
        this.alU = c.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.alV = jSONObject.optString("data-share-image");
        this.alW = jSONObject.optString("data-share-link");
    }

    private void j(JSONObject jSONObject) {
        this.alZ = c.g(jSONObject, "display");
        tw();
        this.ama = c.g(jSONObject, "flex-direction");
        tD();
        this.amb = c.g(jSONObject, "justify-content");
        tC();
        this.amc = c.g(jSONObject, "align-items");
        tB();
        this.amd = c.g(jSONObject, "align-self");
        tA();
        this.ame = c.g(jSONObject, "align-content");
        tz();
        this.amf = c.h(jSONObject, "flex");
        tv();
        this.amg = c.h(jSONObject, "flex-grow");
        tu();
        this.amh = c.h(jSONObject, "flex-shrink");
        tt();
        this.ami = c.h(jSONObject, "flex-basis");
        ts();
        this.position = c.g(jSONObject, "position");
        ty();
        this.amj = c.h(jSONObject, "left");
        this.amk = c.h(jSONObject, VerticalTranslateLayout.TOP);
        this.aml = c.h(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.amm = c.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        tx();
        this.amn = c.h(jSONObject, "margin");
        tr();
        this.amo = c.h(jSONObject, "margin-left");
        tm();
        this.amp = c.h(jSONObject, "margin-top");
        tq();
        this.amq = c.h(jSONObject, "margin-right");
        tp();
        this.amr = c.h(jSONObject, "margin-bottom");
        tn();
        this.ams = c.h(jSONObject, "padding");
        initPadding();
        this.amt = c.h(jSONObject, "padding-left");
        ti();
        this.amu = c.h(jSONObject, "padding-top");
        tl();
        this.amv = c.h(jSONObject, "padding-right");
        tk();
        this.amw = c.h(jSONObject, "padding-bottom");
        tj();
        this.width = c.h(jSONObject, "width");
        th();
        this.height = c.h(jSONObject, "height");
        tg();
        this.amx = c.h(jSONObject, "min-width");
        tf();
        this.amy = c.h(jSONObject, "min-height");
        te();
        this.amz = c.h(jSONObject, "max-width");
        tb();
        this.amA = c.h(jSONObject, "max-height");
        td();
        this.amB = c.h(jSONObject, "aspect-ratio");
        tc();
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.amW = c.g(optJSONObject, "background-image");
            this.amX = c.g(optJSONObject, "background-color");
            this.amY = c.g(optJSONObject, "border-color");
            this.amZ = c.g(optJSONObject, "color");
        }
    }

    private void l(JSONObject jSONObject) {
        this.amR = c.g(jSONObject, "background-image");
        this.amS = c.g(jSONObject, "background-color");
        this.amT = c.g(jSONObject, "border-color");
        this.amU = c.h(jSONObject, "opacity");
        this.amV = c.g(jSONObject, "color");
    }

    private void m(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.amN = c.g(optJSONObject, "background-image");
            this.amO = c.g(optJSONObject, "background-color");
            this.amP = c.g(optJSONObject, "border-color");
            this.amQ = c.g(optJSONObject, "color");
        }
    }

    private void n(JSONObject jSONObject) {
        this.amC = c.g(jSONObject, "background-image");
        this.backgroundColor = c.g(jSONObject, "background-color");
        this.borderColor = c.g(jSONObject, "border-color");
        this.opacity = c.h(jSONObject, "opacity");
        this.color = c.g(jSONObject, "color");
        this.amD = c.h(jSONObject, "border-width");
        this.borderRadius = c.h(jSONObject, "border-radius");
        this.amE = c.h(jSONObject, "border-top-left-radius");
        this.amF = c.h(jSONObject, "border-bottom-left-radius");
        this.amG = c.h(jSONObject, "border-top-right-radius");
        this.amH = c.h(jSONObject, "border-bottom-right-radius");
        this.amI = c.g(jSONObject, "font-style");
        this.amJ = c.g(jSONObject, "font-weight");
        this.amK = Typeface.create(Typeface.DEFAULT, sZ());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.amL = c.g(jSONObject, "text-align");
        this.amM = c.g(jSONObject, "vertical-align");
        this.gravity = ta();
        this.alA = c.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0087a interfaceC0087a, boolean z) {
        this.alF = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.alG = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.alH = 0;
        this.alM = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.alL, a.this);
                TextPaint paint = a.this.alL.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.alX > 0.0d) {
                    f3 = a.this.h(a.this.alX);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.alY > 0.0d ? (float) a.this.alY : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.alF).setHyphenationFrequency(a.this.alG);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.alH);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.alF).setHyphenationFrequency(a.this.alG);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.alH);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.o(build.getWidth()), a.this.n(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float o = a.this.o(build.getWidth());
                    float n = a.this.n(build.getHeight());
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
                            if (lineDescent > 0.0f && n > lineCount) {
                                n -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(o, n);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.amU = -10000.0d;
        this.alJ = new CriusNode();
        this.businessConverter = interfaceC0087a;
        this.alK = context.getResources().getDisplayMetrics().density;
        this.akF = context.getResources().getDisplayMetrics().widthPixels;
        this.akG = context.getResources().getDisplayMetrics().heightPixels;
        this.alL = new TextView(context);
        i(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            j(optJSONObject);
            n(optJSONObject);
            m(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            l(optJSONObject2);
            k(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.ana = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0087a, false);
                    this.ana.add(aVar);
                    this.alJ.addChildAt(aVar.alJ, i);
                }
            } else {
                this.ana = null;
            }
        } else {
            this.ana = null;
        }
        if (z) {
            this.alI = new CriusNode();
            this.alI.addChildAt(this.alJ, 0);
            this.alI.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double sY() {
        return this.fontSize;
    }

    private int sZ() {
        return "italic".equalsIgnoreCase(this.amI) ? (TextUtils.isEmpty(this.amJ) || "normal".equalsIgnoreCase(this.amJ) || !"bold".equalsIgnoreCase(this.amJ)) ? 2 : 3 : (TextUtils.isEmpty(this.amJ) || "normal".equalsIgnoreCase(this.amJ) || !"bold".equalsIgnoreCase(this.amJ)) ? 0 : 1;
    }

    private int ta() {
        int i;
        if ("left".equalsIgnoreCase(this.amL)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.amL)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.amL)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.amM)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.amM)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.amM)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tb() {
        if (this.amz >= 0.0d) {
            this.alJ.setMaxWidth(h(this.amz));
        } else if (this.amz > -10000.0d) {
            this.alJ.setMaxWidth(this.akF);
        }
    }

    private void tc() {
        if (this.amB > 0.0d) {
            this.alJ.setAspectRatio((float) this.amB);
        }
    }

    private void td() {
        if (this.amA >= 0.0d) {
            this.alJ.setMaxHeight(h(this.amA));
        } else if (this.amA > -10000.0d) {
            this.alJ.setMaxHeight(this.akG);
        }
    }

    private void te() {
        if (this.amy >= 0.0d) {
            this.alJ.setMinHeight(h(this.amy));
        } else if (this.amy > -10000.0d) {
            this.alJ.setMinHeight(this.akG);
        }
    }

    private void tf() {
        if (this.amx >= 0.0d) {
            this.alJ.setMinWidth(h(this.amx));
        } else if (this.amx > -10000.0d) {
            this.alJ.setMinWidth(this.akF);
        }
    }

    private void tg() {
        if (this.height >= 0.0d) {
            this.alJ.setHeight(h(this.height));
        } else if (this.height > -10000.0d) {
            this.alJ.setHeight(this.akG);
        }
    }

    private void th() {
        if (this.width >= 0.0d) {
            this.alJ.setWidth(h(this.width));
        } else if (this.width > -10000.0d) {
            this.alJ.setWidth(this.akF);
        }
    }

    private void ti() {
        if (this.amt >= -1.0d) {
            this.alJ.setPadding(CriusEdge.LEFT, h(this.amt));
        }
    }

    private void tj() {
        if (this.amw >= -1.0d) {
            this.alJ.setPadding(CriusEdge.BOTTOM, h(this.amw));
        }
    }

    private void tk() {
        if (this.amv >= -1.0d) {
            this.alJ.setPadding(CriusEdge.RIGHT, h(this.amv));
        }
    }

    private void tl() {
        if (this.amu >= -1.0d) {
            this.alJ.setPadding(CriusEdge.TOP, h(this.amu));
        }
    }

    private void initPadding() {
        if (this.ams >= -1.0d) {
            this.alJ.setPadding(CriusEdge.ALL, h(this.ams));
        }
    }

    private void tm() {
        if (this.amo >= -1.0d) {
            this.alJ.setMargin(CriusEdge.LEFT, h(this.amo));
        }
    }

    private void tn() {
        if (this.amr >= -1.0d) {
            this.alJ.setMargin(CriusEdge.BOTTOM, h(this.amr));
        }
    }

    private void tp() {
        if (this.amq >= -1.0d) {
            this.alJ.setMargin(CriusEdge.RIGHT, h(this.amq));
        }
    }

    private void tq() {
        if (this.amp >= -1.0d) {
            this.alJ.setMargin(CriusEdge.TOP, h(this.amp));
        }
    }

    private void tr() {
        if (this.amn >= -1.0d) {
            this.alJ.setMargin(CriusEdge.ALL, h(this.amn));
        }
    }

    private void ts() {
        if (this.ami >= -1.0d) {
            this.alJ.setFlexBasis(h(this.ami));
        }
    }

    private void tt() {
        if (this.amh >= -1.0d) {
            this.alJ.setFlexShrink((float) this.amh);
        }
    }

    private void tu() {
        if (this.amg >= -1.0d) {
            this.alJ.setFlexGrow((float) this.amg);
        }
    }

    private void tv() {
        if (this.amf >= -1.0d) {
            this.alJ.setFlex((float) this.amf);
        }
    }

    private void tw() {
        if (!TextUtils.isEmpty(this.alZ)) {
            if ("flex".equalsIgnoreCase(this.alZ)) {
                this.alJ.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.alZ)) {
                this.alJ.setDisplay(CriusDisplay.NONE);
            } else {
                this.alJ.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tx() {
        if (!c.b(this.amj, -10000.0d)) {
            this.alJ.setPosition(CriusEdge.LEFT, h(this.amj));
        }
        if (!c.b(this.amk, -10000.0d)) {
            this.alJ.setPosition(CriusEdge.TOP, h(this.amk));
        }
        if (!c.b(this.aml, -10000.0d)) {
            this.alJ.setPosition(CriusEdge.RIGHT, h(this.aml));
        }
        if (!c.b(this.amm, -10000.0d)) {
            this.alJ.setPosition(CriusEdge.BOTTOM, h(this.amm));
        }
    }

    private void ty() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.alJ.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.alJ.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void tz() {
        if (!TextUtils.isEmpty(this.ame)) {
            if ("flex-start".equalsIgnoreCase(this.ame)) {
                this.alJ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.ame)) {
                this.alJ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.ame)) {
                this.alJ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.ame)) {
                this.alJ.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.ame)) {
                this.alJ.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.ame)) {
                this.alJ.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.alJ.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void tA() {
        if (!TextUtils.isEmpty(this.amd)) {
            if ("auto".equalsIgnoreCase(this.amd)) {
                this.alJ.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.amd)) {
                this.alJ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.amd)) {
                this.alJ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.amd)) {
                this.alJ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.amd)) {
                this.alJ.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.alJ.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void tB() {
        if (!TextUtils.isEmpty(this.amc)) {
            if ("flex-start".equalsIgnoreCase(this.amc)) {
                this.alJ.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.amc)) {
                this.alJ.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.amc)) {
                this.alJ.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.amc)) {
                this.alJ.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.alJ.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void tC() {
        if (!TextUtils.isEmpty(this.amb)) {
            if ("flex-start".equalsIgnoreCase(this.amb)) {
                this.alJ.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.amb)) {
                this.alJ.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.amb)) {
                this.alJ.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.amb)) {
                this.alJ.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.amb)) {
                this.alJ.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.alJ.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void tD() {
        if (!TextUtils.isEmpty(this.ama)) {
            if ("column".equalsIgnoreCase(this.ama)) {
                this.alJ.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.ama)) {
                this.alJ.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.ama)) {
                this.alJ.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.ama)) {
                this.alJ.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.alJ.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean tE() {
        return "text".equals(this.type);
    }

    public a du(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.ana != null && this.ana.size() > 0) {
                for (a aVar : this.ana) {
                    a du = aVar.du(str);
                    if (du != null) {
                        return du;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.alN)) {
            if (this.ana != null && this.ana.size() > 0) {
                for (a aVar : this.ana) {
                    a dv = aVar.dv(str);
                    if (dv != null) {
                        return dv;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.alK * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean dw(String str) {
        a dv;
        if (this.alI == null || (dv = dv(str)) == null || dv.alJ == null) {
            return false;
        }
        dv.alJ.setDisplay(CriusDisplay.NONE);
        dv.alJ.dirty();
        this.alI.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a du;
        if (this.alI != null && (du = du(str)) != null && du.alJ != null) {
            du.fontSize = f;
            du.alJ.dirty();
            this.alI.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
