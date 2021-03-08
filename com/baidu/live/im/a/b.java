package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.live.data.bq;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.view.b;
import com.baidu.tbadk.TbConfig;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.b, com.baidu.live.im.c> {
    protected static int bpd = 1;
    private String aFb;
    protected com.baidu.live.im.e.a bpe;
    protected boolean bpf;
    private String bpg;
    protected boolean bph;
    private boolean bpi;
    private long bpj;
    private int bpk;
    private int bpl;
    private boolean bpm;
    private String mGroupId;
    private Handler mHandler;
    protected String mLiveId;

    protected abstract void KC();

    protected abstract SpannableStringBuilder b(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bph = false;
        this.bpi = false;
        this.bpj = 0L;
        this.bpe = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: n */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == bpd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(35:1|(2:3|(31:5|6|7|8|(1:10)(2:138|139)|11|12|13|(1:17)|(1:136)(1:22)|23|(1:135)(2:27|(1:29)(2:120|(1:122)(2:123|(1:125)(2:126|(1:128)(2:129|(1:131)(2:132|(1:134)))))))|30|(3:34|(1:36)(1:38)|37)|39|(11:41|(1:118)(2:45|(1:(3:49|(1:51)(1:87)|52))(2:88|(2:92|(1:117)(2:112|(1:116)))))|(1:86)(1:58)|59|(4:78|(1:82)|83|(1:85))(1:63)|64|(4:66|(1:68)|69|(1:71))|72|(1:74)|75|76)|119|(1:54)|86|59|(1:61)|78|(1:82)|83|(0)|64|(0)|72|(0)|75|76))|142|6|7|8|(0)(0)|11|12|13|(2:15|17)|(1:19)|136|23|(1:25)|135|30|(4:32|34|(0)(0)|37)|39|(0)|119|(0)|86|59|(0)|78|(0)|83|(0)|64|(0)|72|(0)|75|76) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01bb, code lost:
        r3 = null;
        r0 = "";
        r6 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: JSONException -> 0x01ba, TryCatch #0 {JSONException -> 0x01ba, blocks: (B:8:0x0025, B:10:0x002d, B:11:0x0034, B:67:0x01ae), top: B:141:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ae A[Catch: JSONException -> 0x01ba, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x01ba, blocks: (B:8:0x0025, B:10:0x002d, B:11:0x0034, B:67:0x01ae), top: B:141:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0226  */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar) {
        int i2;
        String str;
        String str2;
        boolean a2;
        boolean z;
        String str3;
        SpannableStringBuilder b;
        SpannableStringBuilder d;
        this.bpi = false;
        KC();
        cVar.reset();
        if (bVar.Lc() != null) {
            List<AlaLiveMarkData> list = bVar.Lc().aHz;
            if (!ListUtils.isEmpty(list)) {
                i2 = V(list);
                JSONObject jSONObject = null;
                if (!(bVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                str = jSONObject.optString("content_type");
                str2 = jSONObject.optString("level_id");
                JSONObject jSONObject2 = jSONObject;
                if (!TextUtils.isEmpty(str2) && JavaTypesHelper.toInt(str2, 0) > 0) {
                    bVar.Lc().level_id = JavaTypesHelper.toInt(str2, 0);
                }
                if (str == null && str.equals("activity_common_im") && jSONObject2 != null) {
                    a2 = a(jSONObject2.optJSONObject("content_data"), cVar);
                } else {
                    a2 = a(bVar, cVar, i2);
                }
                boolean a3 = a(bVar, i2);
                this.bpe.brq = false;
                this.bpe.brr = false;
                this.bpe.brs = false;
                this.bpe.brt = false;
                this.bpe.bru = false;
                this.bpe.isMysteriousMan = false;
                this.bpe.brv = false;
                this.bpe.isGroup = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bpe.brq = true;
                } else if ("guard_seat".equals(str)) {
                    this.bpe.brr = true;
                } else if ("guard_club_join".equals(str)) {
                    this.bpe.brs = true;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bpe.brt = true;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bpe.bru = true;
                } else if ("host_send_award".equals(str)) {
                    this.bpe.brv = true;
                } else if ("group_guess".equals(str)) {
                    this.bpe.isGroup = true;
                }
                if (bVar.Lc() != null && bVar.Lc().extInfoJson != null) {
                    this.bpe.isMysteriousMan = bVar.Lc().extInfoJson.optInt("is_mysterious_man") != 1;
                }
                this.bpm = a3;
                cVar.blR = a2;
                z = false;
                if (!bVar.Ln()) {
                    if (bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                        z = true;
                        str3 = str;
                    } else if (bVar.getMsgType() == 24) {
                        if (str != null && jSONObject2 != null) {
                            String optString = jSONObject2.optString("content_type");
                            z = !optString.equals("pk_send_props");
                            str3 = optString;
                        }
                    } else if (bVar.getMsgType() == 13 || bVar.getMsgType() == 27) {
                        if (TextUtils.equals(str, "enter_live") || TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) || TextUtils.equals(str, "add_tags_to_anchor") || TextUtils.equals(str, "live_poke_back") || TextUtils.equals(str, "group_guess")) {
                            z = true;
                            str3 = str;
                        } else if (TextUtils.equals(str, "remove_video") && !TextUtils.isEmpty(jSONObject2.optString("poke_msg"))) {
                            z = true;
                            str3 = str;
                        }
                    }
                    if (!z && bVar.Lc() != null && !TextUtils.isEmpty(bVar.Lc().portrait)) {
                        cVar.a(true, bVar.Lc().portrait, i2);
                        cVar.blO.setOnClickListener(new c(bVar.Lc(), this.mGroupId, this.mLiveId, this.bpf, this.aFb));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.blO.setOnClickListener(null);
                    }
                    if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).blA != null) {
                        b = ((com.baidu.live.im.a) bVar).blA;
                    } else {
                        b = b(bVar, cVar);
                        d = d(bVar.Lc());
                        if (this.bpi && d != null && b != null) {
                            b.insert(0, (CharSequence) d);
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) bVar).blA = b;
                        }
                    }
                    if ("host_send_award".equals(str3)) {
                        String optString2 = jSONObject2.optString("foot_color");
                        String optString3 = jSONObject2.optString("back_color");
                        if (!TextUtils.isEmpty(optString3)) {
                            cVar.dA(Color.parseColor(optString3));
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            b.setSpan(new ForegroundColorSpan(Color.parseColor(optString2)), 0, b.length(), 33);
                        }
                    }
                    cVar.a(this.mContext, this.bpe);
                    cVar.n(this.mContext, this.bpe.brp);
                    cVar.blL.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.blL.setMovementMethod(com.baidu.live.im.g.Kd());
                    if (this.bph) {
                        cVar.ci(true);
                    }
                    cVar.blL.setText(b);
                    return view;
                }
                str3 = str;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.blO.setOnClickListener(null);
                if (!(bVar instanceof com.baidu.live.im.a)) {
                }
                b = b(bVar, cVar);
                d = d(bVar.Lc());
                if (this.bpi) {
                    b.insert(0, (CharSequence) d);
                }
                if (bVar instanceof com.baidu.live.im.a) {
                }
                if ("host_send_award".equals(str3)) {
                }
                cVar.a(this.mContext, this.bpe);
                cVar.n(this.mContext, this.bpe.brp);
                cVar.blL.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.blL.setMovementMethod(com.baidu.live.im.g.Kd());
                if (this.bph) {
                }
                cVar.blL.setText(b);
                return view;
            }
        }
        i2 = 0;
        JSONObject jSONObject3 = null;
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        str = jSONObject3.optString("content_type");
        str2 = jSONObject3.optString("level_id");
        JSONObject jSONObject22 = jSONObject3;
        if (!TextUtils.isEmpty(str2)) {
            bVar.Lc().level_id = JavaTypesHelper.toInt(str2, 0);
        }
        if (str == null) {
        }
        a2 = a(bVar, cVar, i2);
        boolean a32 = a(bVar, i2);
        this.bpe.brq = false;
        this.bpe.brr = false;
        this.bpe.brs = false;
        this.bpe.brt = false;
        this.bpe.bru = false;
        this.bpe.isMysteriousMan = false;
        this.bpe.brv = false;
        this.bpe.isGroup = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bpe.brq = true;
        if (bVar.Lc() != null) {
            this.bpe.isMysteriousMan = bVar.Lc().extInfoJson.optInt("is_mysterious_man") != 1;
        }
        this.bpm = a32;
        cVar.blR = a2;
        z = false;
        if (!bVar.Ln()) {
        }
        str3 = str;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.blO.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        b = b(bVar, cVar);
        d = d(bVar.Lc());
        if (this.bpi) {
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        if ("host_send_award".equals(str3)) {
        }
        cVar.a(this.mContext, this.bpe);
        cVar.n(this.mContext, this.bpe.brp);
        cVar.blL.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.blL.setMovementMethod(com.baidu.live.im.g.Kd());
        if (this.bph) {
        }
        cVar.blL.setText(b);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aPV = Color.parseColor(optString.trim());
            cVar.aPW = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aPV = Color.parseColor(optString3);
                cVar.aPW = cVar.aPV;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aPZ = (int) (255.0d * optDouble);
        } else {
            cVar.aPZ = 255;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar, int i) {
        JSONObject jSONObject;
        boolean z;
        bq bqVar;
        JSONObject jSONObject2 = null;
        String[] Lj = bVar.Lj();
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && (Lj == null || Lj.length == 0 || !TextUtils.equals(Lj[0], "guard_seat_effect")) && i >= 5) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e = e;
                jSONObject = null;
            }
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
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                }
                if (a(bVar, cVar)) {
                }
            }
        } else if (com.baidu.live.ae.a.Qm().bCs != null && (bqVar = com.baidu.live.ae.a.Qm().bCs.aRo) != null && bqVar.aQV != null && Lj != null && Lj.length > 0 && !TextUtils.isEmpty(Lj[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(Lj[0], "guard_seat_effect"))) {
            jSONObject2 = bqVar.aQV.optJSONObject(Lj[0]);
        }
        if (jSONObject2 == null) {
            if (jSONObject2.optInt("bubble_type") == 0) {
                z = c(jSONObject2, cVar);
            } else {
                z = b(jSONObject2, cVar);
            }
        } else {
            z = false;
        }
        return !a(bVar, cVar) || z;
    }

    private boolean b(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        if (jSONObject.optInt("bubble_type") == 1) {
            try {
                int optInt = jSONObject.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    cVar.aPZ = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    cVar.aPZ = 255;
                }
                String optString = jSONObject.optString("bg_start_color");
                String optString2 = jSONObject.optString("bg_end_color");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aPV = Color.parseColor(optString);
                    cVar.aPW = Color.parseColor(optString2);
                } else {
                    String optString3 = jSONObject.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aPV = Color.parseColor(optString3);
                        cVar.aPW = Color.parseColor(optString3);
                    }
                }
                if (z) {
                    String optString4 = jSONObject.optString("frame_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        cVar.aPX = Color.parseColor(optString4);
                        cVar.aPY = Color.parseColor(optString4);
                        return z;
                    }
                    return z;
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return c(jSONObject, cVar);
    }

    private boolean c(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z;
        int optInt = jSONObject.optInt("transparency");
        if (optInt >= 0 && optInt <= 100) {
            cVar.aPZ = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
        } else {
            cVar.aPZ = 255;
        }
        cVar.blS = !TextUtils.isEmpty(jSONObject.optString("tail_icon"));
        String optString = jSONObject.optString("start_color");
        String optString2 = jSONObject.optString("end_color");
        try {
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                cVar.aPV = Color.parseColor(optString);
                cVar.aPW = Color.parseColor(optString2);
                z = true;
            } else {
                String optString3 = jSONObject.optString("bg_color");
                if (TextUtils.isEmpty(optString3)) {
                    z = false;
                } else {
                    cVar.aPV = Color.parseColor(optString3);
                    cVar.aPW = cVar.aPV;
                    z = true;
                }
            }
            if (z) {
                String optString4 = jSONObject.optString("frame_start_color");
                String optString5 = jSONObject.optString("frame_end_color");
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    cVar.aPX = Color.parseColor(optString4);
                    cVar.aPY = Color.parseColor(optString5);
                }
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean a(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            String optString = jSONObject.optString("content_type");
            if (TextUtils.equals("mysterious_man_tip", optString) || TextUtils.equals("mysterious_man_expired_remind", optString) || TextUtils.equals("mysterious_man_open_live", optString)) {
                if (jSONObject.has("alpha")) {
                    double optDouble = jSONObject.optDouble("alpha");
                    if (optDouble >= 0.0d && optDouble <= 1.0d) {
                        cVar.aPZ = (int) (optDouble * 255.0d);
                    } else {
                        cVar.aPZ = 255;
                    }
                } else {
                    cVar.aPZ = 255;
                }
                String optString2 = jSONObject.optString("bg_start_color");
                String optString3 = jSONObject.optString("bg_end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        cVar.aPV = Color.parseColor(optString2);
                        cVar.aPW = Color.parseColor(optString3);
                    }
                    String optString4 = jSONObject.optString("frame_color");
                    String optString5 = jSONObject.optString("frame_color");
                    cVar.aPX = Color.parseColor(optString4);
                    cVar.aPY = Color.parseColor(optString5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        } catch (JSONException e2) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, int i) {
        JSONObject jSONObject;
        bq bqVar;
        String[] Lj = bVar.Lj();
        JSONObject jSONObject2 = null;
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && i >= 2) {
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
                    if (jSONObject2 == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        } else if (com.baidu.live.ae.a.Qm().bCs != null && (bqVar = com.baidu.live.ae.a.Qm().bCs.aRo) != null && bqVar.aQW != null && Lj != null && Lj.length > 1 && !TextUtils.isEmpty(Lj[1])) {
            jSONObject2 = bqVar.aQW.optJSONObject(Lj[1]);
        }
        if (jSONObject2 == null) {
            return U(jSONObject2);
        }
        return false;
    }

    private boolean U(JSONObject jSONObject) {
        int i = 255;
        boolean z = false;
        String optString = jSONObject.optString("bg_color");
        String optString2 = jSONObject.optString("transparency");
        if (!TextUtils.isEmpty(optString2)) {
            try {
                i = (int) (((Integer.parseInt(optString2) * 1.0f) / 100.0f) * 255.0f);
            } catch (Exception e) {
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            z = true;
            this.bpk = Color.parseColor(optString);
            this.bpl = i;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bpd = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bpi = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bpi = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bpf, this.aFb);
                aVar2.bpm = this.bpm;
                aVar2.bpk = this.bpk;
                aVar2.bpl = this.bpl;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0183b c0183b = new C0183b(aVar, this.mGroupId, this.mLiveId, this.bpf, this.aFb);
                c0183b.bpm = this.bpm;
                c0183b.bpk = this.bpk;
                c0183b.bpl = this.bpl;
                spannableString.setSpan(c0183b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aHz;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> w = w(list);
        if (ListUtils.isEmpty(w)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (int i = 0; i < w.size(); i++) {
            AlaLiveMarkData alaLiveMarkData = w.get(i);
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = aVar.level_id;
                alaLiveMarkData.setupNewLevelMark();
                if (alaLiveMarkData.isGuardType()) {
                    if (TextUtils.isEmpty(alaLiveMarkData.guardName)) {
                        alaLiveMarkData.guardName = this.bpg;
                    }
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + alaLiveMarkData.level + "*_*" + alaLiveMarkData.guardName + "*_*" + (alaLiveMarkData.isGold() ? "1" : "0") + "*_*" + alaLiveMarkData.guardGoldenType;
                    com.baidu.live.view.b bVar = com.baidu.live.view.b.bUv.get(str);
                    if (bVar == null) {
                        if (alaLiveMarkData.level <= 0) {
                            alaLiveMarkData.level = com.baidu.live.guardclub.g.IW().gX(alaLiveMarkData.mark_pic);
                        }
                        Bitmap a2 = com.baidu.live.aj.b.a(this.mContext, alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds32, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            bVar = new com.baidu.live.view.b(this.mContext, a2);
                            com.baidu.live.view.b.bUv.put(str, bVar);
                        }
                    }
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("[img] ");
                    spannableStringBuilder2.setSpan(bVar, 0, spannableStringBuilder2.length() - 1, 17);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.b bVar2 = com.baidu.live.view.b.bUv.get(genCacheKey);
                    if (bVar2 == null) {
                        bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bph, new b.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                b.this.KA();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.b.bUv.put(genCacheKey, bVar2);
                    }
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("[img] ");
                    spannableStringBuilder3.setSpan(bVar2, 0, spannableStringBuilder3.length() - 1, 17);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                }
            }
        }
        return spannableStringBuilder;
    }

    private List<AlaLiveMarkData> w(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aFb)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int V(List<AlaLiveMarkData> list) {
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
    public void KA() {
        long currentTimeMillis = System.currentTimeMillis() - this.bpj;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bpj = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bpj = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bpf = z;
        this.aFb = str3;
        this.bpg = str4;
    }

    public boolean KB() {
        return this.bpf;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0183b extends ClickableSpan implements g.a {
        private boolean aLc;
        private String bez;
        private int bpk;
        private int bpl;
        private boolean bpm;
        private com.baidu.live.data.a bpo;
        private String groupId;
        private String liveId;

        C0183b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpo = null;
            this.bpo = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLc = z;
            this.bez = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bpd) {
                if (this.bpm) {
                    textPaint.setColor(this.bpk);
                    textPaint.setAlpha(this.bpl);
                } else {
                    textPaint.setColor(-7801);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bpd) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpo instanceof com.baidu.live.data.a) {
                str = this.bpo.appId;
            }
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bpo.userId, this.bpo.userName, this.bpo.portrait, this.bpo.sex, this.bpo.level_id, null, null, 0L, this.bpo.aHt, this.bpo.aHu, this.bpo.aHv, this.groupId, this.liveId, this.aLc, this.bez, str, this.bpo.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bpo.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }

        @Override // com.baidu.live.im.g.a
        public void Ke() {
            if (this.bpo != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bpo.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpo));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aLc;
        private String bez;
        private int bpk;
        private int bpl;
        private boolean bpm;
        private com.baidu.live.data.a bpo;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpo = null;
            this.bpo = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLc = z;
            this.bez = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bpd) {
                if (this.bpm) {
                    textPaint.setColor(this.bpk);
                    textPaint.setAlpha(this.bpl);
                } else {
                    textPaint.setColor(-7801);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bpd) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpo instanceof com.baidu.live.data.a) {
                str = this.bpo.appId;
            }
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bpo.userId, this.bpo.userName, this.bpo.portrait, this.bpo.sex, this.bpo.level_id, null, null, 0L, this.bpo.aHt, this.bpo.aHu, this.bpo.aHv, this.groupId, this.liveId, this.aLc, this.bez, str, this.bpo.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bpo.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }

        @Override // com.baidu.live.im.g.a
        public void Ke() {
            if (this.bpo != null) {
                if (this.bpo.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpo));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements View.OnClickListener {
        private boolean aLc;
        private String bez;
        private com.baidu.live.data.a bpo;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpo = null;
            this.bpo = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLc = z;
            this.bez = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bpo.userId, this.bpo.userName, this.bpo.portrait, this.bpo.sex, this.bpo.level_id, null, null, 0L, this.bpo.aHt, this.bpo.aHu, this.bpo.aHv, this.groupId, this.liveId, this.aLc, this.bez, this.bpo.appId, this.bpo.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bpo.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KD() {
        return 2 != bpd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KE() {
        this.bpe.bro = true;
        this.bpe.brp = false;
        this.bpe.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KF() {
        this.bpe.bro = false;
        this.bpe.brp = false;
        this.bpe.isNormal = false;
    }

    public void cm(boolean z) {
        this.bph = z;
    }

    public void cn(boolean z) {
        this.bpi = z;
    }
}
