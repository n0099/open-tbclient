package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bi;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.b;
import com.baidu.tbadk.TbConfig;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.yuyinim.a> {
    protected static int biY = 1;
    private String aDE;
    protected com.baidu.live.yuyinim.c.a bRM;
    private Set<Integer> bRN;
    protected boolean bja;
    protected boolean bjb;
    private boolean bjc;
    private long bjd;
    private int bje;
    private int bjf;
    private boolean bjg;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void Ls();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bjb = false;
        this.bjc = false;
        this.bjd = 0L;
        this.bRN = new HashSet();
        this.bRM = new com.baidu.live.yuyinim.c.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: x */
    public com.baidu.live.yuyinim.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.yuyinim.a(this.mContext, 2 == biY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(34:1|(2:3|(22:5|6|7|8|(2:10|11)(2:130|131)|12|13|14|15|(1:19)|20|(1:125)(2:24|(1:26)(2:100|(1:102)(2:103|(1:105)(2:106|(1:108)(2:109|(1:124)(5:112|113|115|116|117))))))|27|(1:99)(2:33|(1:98))|(1:77)(1:42)|43|(5:68|(1:72)|73|(1:75)|76)(1:47)|48|(1:50)|51|(1:67)(2:59|(2:61|(1:63))(1:66))|64))|134|6|7|8|(0)(0)|12|13|14|15|(2:17|19)|20|(1:22)|125|27|(1:29)|99|(1:38)|77|43|(1:45)|68|(1:72)|73|(0)|76|48|(0)|51|(1:53)|67|64|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x030d, code lost:
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a6, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a7, code lost:
        r8 = null;
        r2 = "";
        r4 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[Catch: JSONException -> 0x01a5, TRY_LEAVE, TryCatch #1 {JSONException -> 0x01a5, blocks: (B:8:0x0035, B:10:0x003d, B:59:0x0199), top: B:130:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0199 A[Catch: JSONException -> 0x01a5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x01a5, blocks: (B:8:0x0035, B:10:0x003d, B:59:0x0199), top: B:130:0x0035 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        SpannableStringBuilder a2;
        SpannableStringBuilder d;
        SpannableStringBuilder spannableStringBuilder;
        Exception exc;
        String str5;
        String optString;
        JSONObject jSONObject;
        this.bjc = false;
        Ls();
        aVar2.reset();
        if (aVar.LF() != null) {
            List<AlaLiveMarkData> list = aVar.LF().aFV;
            if (!ListUtils.isEmpty(list)) {
                i2 = T(list);
                boolean a3 = a(aVar, aVar2, i2);
                boolean a4 = a(aVar, i2);
                if (!(aVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                String optString2 = jSONObject.optString("content_type");
                str2 = jSONObject.optString("level_id");
                str = optString2;
                JSONObject jSONObject2 = jSONObject;
                if (!TextUtils.isEmpty(str2) && JavaTypesHelper.toInt(str2, 0) > 0) {
                    aVar.LF().level_id = JavaTypesHelper.toInt(str2, 0);
                }
                this.bRM.bkl = false;
                this.bRM.bkm = false;
                this.bRM.bkn = false;
                this.bRM.bko = false;
                this.bRM.bkp = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bRM.bkl = true;
                    str3 = null;
                    str4 = null;
                } else if ("guard_seat".equals(str)) {
                    this.bRM.bkm = true;
                    str3 = null;
                    str4 = null;
                } else if ("guard_club_join".equals(str)) {
                    this.bRM.bkn = true;
                    str3 = null;
                    str4 = null;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bRM.bko = true;
                    str3 = null;
                    str4 = null;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bRM.bkp = true;
                    str3 = null;
                    str4 = null;
                } else if (!"audio_emoticon".equals(str) || jSONObject2 == null) {
                    str3 = null;
                    str4 = null;
                } else {
                    try {
                        jSONObject2.optJSONObject("emoticon_info").optString("compression_img");
                        optString = jSONObject2.optJSONObject("emoticon_info").optString("prototype_img");
                    } catch (Exception e) {
                        exc = e;
                        str5 = null;
                    }
                    try {
                        str4 = jSONObject2.optJSONObject("emoticon_info").optString("result_img");
                        str3 = optString;
                    } catch (Exception e2) {
                        exc = e2;
                        str5 = optString;
                        exc.printStackTrace();
                        str4 = null;
                        str3 = str5;
                        this.bjg = a4;
                        aVar2.bfV = a3;
                        z = false;
                        if (aVar.getMsgType() != 24) {
                        }
                        z = true;
                        if (!z) {
                        }
                        aVar2.a(false, "", 0);
                        aVar2.bfS.setOnClickListener(null);
                        if (!(aVar instanceof com.baidu.live.im.a)) {
                        }
                        a2 = a(aVar, aVar2);
                        d = d(aVar.LF());
                        if (this.bjc) {
                        }
                        if (aVar instanceof com.baidu.live.im.a) {
                        }
                        spannableStringBuilder = a2;
                        aVar2.a(this.mContext, this.bRM);
                        aVar2.h(this.mContext, this.bRM.bkk);
                        aVar2.bfP.setHighlightColor(this.mContext.getResources().getColor(17170445));
                        aVar2.bfP.setMovementMethod(com.baidu.live.im.g.KX());
                        if (this.bjb) {
                        }
                        aVar2.bfP.setText(spannableStringBuilder);
                        if (!"audio_emoticon".equals(str)) {
                        }
                        aVar2.bRF.setVisibility(8);
                        return view;
                    }
                }
                this.bjg = a4;
                aVar2.bfV = a3;
                z = false;
                if (aVar.getMsgType() != 24 || aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                    z = true;
                } else if ((aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, "audio_emoticon") || TextUtils.equals(str, "follow_anchor_phone") || TextUtils.equals(str, "audio_hat_level_toast") || TextUtils.equals(str, "audio_hat_user_toast") || TextUtils.equals(str, "follow_room"))) {
                    z = true;
                }
                if (!z && aVar.LF() != null && !TextUtils.isEmpty(aVar.LF().portrait)) {
                    aVar2.a(true, aVar.LF().portrait, i2);
                    aVar2.bfS.setOnClickListener(new c(aVar.LF(), this.mGroupId, this.mLiveId, this.bja, this.aDE));
                } else {
                    aVar2.a(false, "", 0);
                    aVar2.bfS.setOnClickListener(null);
                }
                if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).bfE != null) {
                    spannableStringBuilder = ((com.baidu.live.im.a) aVar).bfE;
                } else {
                    a2 = a(aVar, aVar2);
                    d = d(aVar.LF());
                    if (this.bjc && d != null && a2 != null) {
                        a2.insert(0, (CharSequence) d);
                    }
                    if (aVar instanceof com.baidu.live.im.a) {
                        ((com.baidu.live.im.a) aVar).bfE = a2;
                    }
                    spannableStringBuilder = a2;
                }
                aVar2.a(this.mContext, this.bRM);
                aVar2.h(this.mContext, this.bRM.bkk);
                aVar2.bfP.setHighlightColor(this.mContext.getResources().getColor(17170445));
                aVar2.bfP.setMovementMethod(com.baidu.live.im.g.KX());
                if (this.bjb) {
                    aVar2.bV(true);
                }
                aVar2.bfP.setText(spannableStringBuilder);
                if (!"audio_emoticon".equals(str) && !StringUtils.isNull(str3, true) && aVar.getMsgType() == 13 && !StringUtils.isNull(str4, true)) {
                    aVar2.bRF.setVisibility(0);
                    if (this.bRN.contains(Integer.valueOf(i))) {
                        if (TextUtils.isEmpty((String) aVar2.bRF.getTag())) {
                            aVar2.bRF.aM(null, str4);
                        }
                    } else {
                        this.bRN.add(Integer.valueOf(i));
                        aVar2.bRF.aM(str3, str4);
                        aVar2.bRF.setTag(str4);
                    }
                } else {
                    aVar2.bRF.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(aVar, aVar2, i2);
        boolean a42 = a(aVar, i2);
        if (!(aVar.getObjContent() instanceof JSONObject)) {
        }
        String optString22 = jSONObject.optString("content_type");
        str2 = jSONObject.optString("level_id");
        str = optString22;
        JSONObject jSONObject22 = jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            aVar.LF().level_id = JavaTypesHelper.toInt(str2, 0);
        }
        this.bRM.bkl = false;
        this.bRM.bkm = false;
        this.bRM.bkn = false;
        this.bRM.bko = false;
        this.bRM.bkp = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bRM.bkl = true;
        str3 = null;
        str4 = null;
        this.bjg = a42;
        aVar2.bfV = a32;
        z = false;
        if (aVar.getMsgType() != 24) {
        }
        z = true;
        if (!z) {
        }
        aVar2.a(false, "", 0);
        aVar2.bfS.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(aVar, aVar2);
        d = d(aVar.LF());
        if (this.bjc) {
            a2.insert(0, (CharSequence) d);
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        spannableStringBuilder = a2;
        aVar2.a(this.mContext, this.bRM);
        aVar2.h(this.mContext, this.bRM.bkk);
        aVar2.bfP.setHighlightColor(this.mContext.getResources().getColor(17170445));
        aVar2.bfP.setMovementMethod(com.baidu.live.im.g.KX());
        if (this.bjb) {
        }
        aVar2.bfP.setText(spannableStringBuilder);
        if (!"audio_emoticon".equals(str)) {
        }
        aVar2.bRF.setVisibility(8);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2, int i) {
        JSONObject jSONObject;
        boolean z;
        bi biVar;
        JSONObject jSONObject2 = null;
        String[] LM = aVar.LM();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (LM == null || LM.length == 0 || !TextUtils.equals(LM[0], "guard_seat_effect")) && i >= 5) {
            try {
                jSONObject = new JSONObject();
                try {
                    if (i == 7) {
                        jSONObject.put("start_color", "#4e030c");
                        jSONObject.put("end_color", "#4e030c");
                    } else {
                        jSONObject.put("start_color", "#031f33");
                        jSONObject.put("end_color", "#031f33");
                    }
                    jSONObject.put("transparency", 60);
                    jSONObject.put("frame_start_color", "#faca21");
                    jSONObject.put("frame_end_color", "#faca21");
                    jSONObject2 = jSONObject;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        } else if (com.baidu.live.aa.a.Ph().bsh != null && (biVar = com.baidu.live.aa.a.Ph().bsh.aNO) != null && biVar.aNw != null && LM != null && LM.length > 0 && !TextUtils.isEmpty(LM[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(LM[0], "guard_seat_effect"))) {
            jSONObject2 = biVar.aNw.optJSONObject(LM[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                aVar2.aMB = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                aVar2.aMB = 255;
            }
            aVar2.bfW = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    aVar2.aMx = Color.parseColor(optString);
                    aVar2.aMy = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        aVar2.aMx = Color.parseColor(optString3);
                        aVar2.aMy = aVar2.aMx;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        aVar2.aMz = Color.parseColor(optString4);
                        aVar2.aMA = Color.parseColor(optString5);
                    }
                }
                return z;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.a aVar, int i) {
        JSONObject jSONObject;
        String optString;
        bi biVar;
        int i2 = 255;
        String[] LM = aVar.LM();
        JSONObject jSONObject2 = null;
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && i >= 2) {
            try {
                jSONObject = new JSONObject();
                try {
                    if (i == 7) {
                        jSONObject.put("bg_color", "#ffef76");
                    } else {
                        jSONObject.put("bg_color", "#43c0a0");
                    }
                    jSONObject.put("transparency", 100);
                    jSONObject2 = jSONObject;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                    }
                    return false;
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        } else if (com.baidu.live.aa.a.Ph().bsh != null && (biVar = com.baidu.live.aa.a.Ph().bsh.aNO) != null && biVar.aNx != null && LM != null && LM.length > 1 && !TextUtils.isEmpty(LM[1])) {
            jSONObject2 = biVar.aNx.optJSONObject(LM[1]);
        }
        if (jSONObject2 != null) {
            String optString2 = jSONObject2.optString("bg_color");
            if (!TextUtils.isEmpty(jSONObject2.optString("transparency"))) {
                try {
                    i2 = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e3) {
                }
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.bje = Color.parseColor(optString2);
                this.bjf = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        biY = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, String str) {
        this.bjc = true;
        a(spannableStringBuilder, aVar, aVar2, false, false, true, null, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2) {
        this.bjc = true;
        a(spannableStringBuilder, aVar, aVar2, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, aVar2, z, z2, z3, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3, String str, String str2) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bjc = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar3 = new a(aVar, this.mGroupId, this.mLiveId, this.bja, this.aDE);
                aVar3.bjg = this.bjg;
                aVar3.bje = this.bje;
                aVar3.bjf = this.bjf;
                spannableString.setSpan(aVar3, 0, length, 17);
            } else {
                C0238b c0238b = new C0238b(aVar, this.mGroupId, this.mLiveId, this.bja, this.aDE);
                c0238b.bjg = this.bjg;
                c0238b.bje = this.bje;
                c0238b.bjf = this.bjf;
                spannableString.setSpan(c0238b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            if (!TextUtils.isEmpty(str2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinim.a.b.1
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        b.this.Lq();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        int i = 0;
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aFV;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> v = v(list);
        if (ListUtils.isEmpty(v)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < v.size(); i2++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        while (true) {
            int i3 = i;
            if (i3 >= v.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = v.get(i3);
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = aVar.level_id;
                alaLiveMarkData.setupNewLevelMark();
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bJF.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bjb, new b.a() { // from class: com.baidu.live.yuyinim.a.b.2
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            b.this.Lq();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bJF.put(genCacheKey, bVar);
                }
                spannableStringBuilder.setSpan(bVar, i4, i5, 17);
            }
            i = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> v(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aDE)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int T(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                return alaLiveMarkData.royalLevel;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        long currentTimeMillis = System.currentTimeMillis() - this.bjd;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bjd = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bjd = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bja = z;
        this.aDE = str3;
    }

    public boolean Lr() {
        return this.bja;
    }

    /* renamed from: com.baidu.live.yuyinim.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0238b extends ClickableSpan implements g.a {
        private boolean aIu;
        private String aZz;
        private int bje;
        private int bjf;
        private boolean bjg;
        private com.baidu.live.data.a bji;
        private String groupId;
        private String liveId;

        C0238b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bji = null;
            this.bji = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aIu = z;
            this.aZz = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.biY) {
                if (this.bjg) {
                    textPaint.setColor(this.bje);
                    textPaint.setAlpha(this.bjf);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.biY) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bji instanceof com.baidu.live.data.a) {
                str = this.bji.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bji.userId, this.bji.userName, this.bji.portrait, this.bji.sex, this.bji.level_id, null, null, 0L, this.bji.aFP, this.bji.aFQ, this.bji.aFR, this.groupId, this.liveId, this.aIu, this.aZz, str, this.bji.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void KY() {
            if (this.bji != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bji.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bji));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aIu;
        private String aZz;
        private int bje;
        private int bjf;
        private boolean bjg;
        private com.baidu.live.data.a bji;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bji = null;
            this.bji = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aIu = z;
            this.aZz = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.biY) {
                if (this.bjg) {
                    textPaint.setColor(this.bje);
                    textPaint.setAlpha(this.bjf);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.biY) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bji instanceof com.baidu.live.data.a) {
                str = this.bji.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bji.userId, this.bji.userName, this.bji.portrait, this.bji.sex, this.bji.level_id, null, null, 0L, this.bji.aFP, this.bji.aFQ, this.bji.aFR, this.groupId, this.liveId, this.aIu, this.aZz, str, this.bji.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void KY() {
            if (this.bji != null) {
                if (this.bji.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bji));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private boolean aIu;
        private String aZz;
        private com.baidu.live.data.a bji;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bji = null;
            this.bji = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aIu = z;
            this.aZz = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bji.userId, this.bji.userName, this.bji.portrait, this.bji.sex, this.bji.level_id, null, null, 0L, this.bji.aFP, this.bji.aFQ, this.bji.aFR, this.groupId, this.liveId, this.aIu, this.aZz, this.bji.appId, this.bji.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Lt() {
        return 2 != biY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lu() {
        this.bRM.bkj = true;
        this.bRM.bkk = false;
        this.bRM.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lv() {
        this.bRM.bkj = false;
        this.bRM.bkk = false;
        this.bRM.isNormal = false;
    }

    public void bZ(boolean z) {
        this.bjb = z;
    }

    public void ca(boolean z) {
        this.bjc = z;
    }
}
