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
import com.baidu.live.data.bl;
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
    protected static int bkk = 1;
    private String aBO;
    protected com.baidu.live.im.e.a bkl;
    protected boolean bkm;
    private String bkn;
    protected boolean bko;
    private boolean bkp;
    private long bkq;
    private int bkr;
    private int bks;
    private boolean bkt;
    private String mGroupId;
    private Handler mHandler;
    protected String mLiveId;

    protected abstract void Jb();

    protected abstract SpannableStringBuilder b(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bko = false;
        this.bkp = false;
        this.bkq = 0L;
        this.bkl = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: n */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == bkk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(34:1|(2:3|(29:5|6|7|8|(2:10|11)(1:121)|12|13|14|(1:18)|(1:117)(1:23)|24|(1:116)(2:28|(1:30)(2:107|(1:109)(2:110|(1:112)(2:113|(1:115)))))|31|(3:35|(1:37)(1:39)|38)|40|(9:42|(1:105)(2:46|(1:(2:50|(1:52)(1:79)))(2:80|(1:104)))|(1:78)(1:58)|59|(4:70|(1:74)|75|(1:77))(1:63)|64|(1:66)|67|68)|106|(1:54)|78|59|(1:61)|70|(1:74)|75|(0)|64|(0)|67|68))|124|6|7|8|(0)(0)|12|13|14|(2:16|18)|(1:20)|117|24|(1:26)|116|31|(4:33|35|(0)(0)|38)|40|(0)|106|(0)|78|59|(0)|70|(0)|75|(0)|64|(0)|67|68|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0163, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0164, code lost:
        r0 = "";
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: JSONException -> 0x0162, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0162, blocks: (B:8:0x0025, B:10:0x002d, B:59:0x0157), top: B:124:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0259 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0157 A[Catch: JSONException -> 0x0162, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0162, blocks: (B:8:0x0025, B:10:0x002d, B:59:0x0157), top: B:124:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01aa  */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar) {
        int i2;
        JSONObject jSONObject;
        String str;
        String str2;
        boolean a2;
        boolean z;
        SpannableStringBuilder b2;
        SpannableStringBuilder d;
        this.bkp = false;
        Jb();
        cVar.reset();
        if (bVar.JB() != null) {
            List<AlaLiveMarkData> list = bVar.JB().aEm;
            if (!ListUtils.isEmpty(list)) {
                i2 = U(list);
                if (!(bVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                str2 = jSONObject.optString("content_type");
                str = jSONObject.optString("level_id");
                if (!TextUtils.isEmpty(str) && JavaTypesHelper.toInt(str, 0) > 0) {
                    bVar.JB().level_id = JavaTypesHelper.toInt(str, 0);
                }
                if (str2 == null && str2.equals("activity_common_im") && jSONObject != null) {
                    a2 = a(jSONObject.optJSONObject("content_data"), cVar);
                } else {
                    a2 = a(bVar, cVar, i2);
                }
                boolean a3 = a(bVar, i2);
                this.bkl.bmq = false;
                this.bkl.bmr = false;
                this.bkl.bms = false;
                this.bkl.bmt = false;
                this.bkl.bmu = false;
                this.bkl.isMysteriousMan = false;
                if (!"send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                    this.bkl.bmq = true;
                } else if ("guard_seat".equals(str2)) {
                    this.bkl.bmr = true;
                } else if ("guard_club_join".equals(str2)) {
                    this.bkl.bms = true;
                } else if ("haokan_buy_goods".equals(str2)) {
                    this.bkl.bmt = true;
                } else if ("privilege_award_royal_success".equals(str2)) {
                    this.bkl.bmu = true;
                }
                if (bVar.JB() != null && bVar.JB().extInfoJson != null) {
                    this.bkl.isMysteriousMan = bVar.JB().extInfoJson.optInt("is_mysterious_man") != 1;
                }
                this.bkt = a3;
                cVar.bha = a2;
                if (!bVar.JM()) {
                    if (bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                        z = true;
                    } else if (bVar.getMsgType() == 24) {
                        if (str2 != null && jSONObject != null) {
                            z = !jSONObject.optString("content_type").equals("pk_send_props");
                        }
                    } else if ((bVar.getMsgType() == 13 || bVar.getMsgType() == 27) && (TextUtils.equals(str2, "enter_live") || TextUtils.equals(str2, "follow_anchor") || TextUtils.equals(str2, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str2, "share_tieba") || TextUtils.equals(str2, "share_rmb") || TextUtils.equals(str2, "zan_rmb") || TextUtils.equals(str2, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) || TextUtils.equals(str2, "add_tags_to_anchor") || TextUtils.equals(str2, "remove_video") || TextUtils.equals(str2, "live_poke_back"))) {
                        z = true;
                    }
                    if (!z && bVar.JB() != null && !TextUtils.isEmpty(bVar.JB().portrait)) {
                        cVar.a(true, bVar.JB().portrait, i2);
                        cVar.bgX.setOnClickListener(new c(bVar.JB(), this.mGroupId, this.mLiveId, this.bkm, this.aBO));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.bgX.setOnClickListener(null);
                    }
                    if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).bgJ != null) {
                        b2 = ((com.baidu.live.im.a) bVar).bgJ;
                    } else {
                        b2 = b(bVar, cVar);
                        d = d(bVar.JB());
                        if (this.bkp && d != null && b2 != null) {
                            b2.insert(0, (CharSequence) d);
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) bVar).bgJ = b2;
                        }
                    }
                    cVar.a(this.mContext, this.bkl);
                    cVar.m(this.mContext, this.bkl.bmo);
                    cVar.bgU.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.bgU.setMovementMethod(com.baidu.live.im.g.IC());
                    if (this.bko) {
                        cVar.ca(true);
                    }
                    cVar.bgU.setText(b2);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.bgX.setOnClickListener(null);
                if (!(bVar instanceof com.baidu.live.im.a)) {
                }
                b2 = b(bVar, cVar);
                d = d(bVar.JB());
                if (this.bkp) {
                    b2.insert(0, (CharSequence) d);
                }
                if (bVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.bkl);
                cVar.m(this.mContext, this.bkl.bmo);
                cVar.bgU.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.bgU.setMovementMethod(com.baidu.live.im.g.IC());
                if (this.bko) {
                }
                cVar.bgU.setText(b2);
                return view;
            }
        }
        i2 = 0;
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        str2 = jSONObject.optString("content_type");
        str = jSONObject.optString("level_id");
        if (!TextUtils.isEmpty(str)) {
            bVar.JB().level_id = JavaTypesHelper.toInt(str, 0);
        }
        if (str2 == null) {
        }
        a2 = a(bVar, cVar, i2);
        boolean a32 = a(bVar, i2);
        this.bkl.bmq = false;
        this.bkl.bmr = false;
        this.bkl.bms = false;
        this.bkl.bmt = false;
        this.bkl.bmu = false;
        this.bkl.isMysteriousMan = false;
        if (!"send_redpacket".equals(str2)) {
        }
        this.bkl.bmq = true;
        if (bVar.JB() != null) {
            this.bkl.isMysteriousMan = bVar.JB().extInfoJson.optInt("is_mysterious_man") != 1;
        }
        this.bkt = a32;
        cVar.bha = a2;
        if (!bVar.JM()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.bgX.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        b2 = b(bVar, cVar);
        d = d(bVar.JB());
        if (this.bkp) {
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.bkl);
        cVar.m(this.mContext, this.bkl.bmo);
        cVar.bgU.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.bgU.setMovementMethod(com.baidu.live.im.g.IC());
        if (this.bko) {
        }
        cVar.bgU.setText(b2);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aLy = Color.parseColor(optString.trim());
            cVar.aLz = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aLy = Color.parseColor(optString3);
                cVar.aLz = cVar.aLy;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aLC = (int) (255.0d * optDouble);
        } else {
            cVar.aLC = 255;
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
        bl blVar;
        JSONObject jSONObject2 = null;
        String[] JI = bVar.JI();
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && (JI == null || JI.length == 0 || !TextUtils.equals(JI[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.af.a.OJ().bxp != null && (blVar = com.baidu.live.af.a.OJ().bxp.aMQ) != null && blVar.aMx != null && JI != null && JI.length > 0 && !TextUtils.isEmpty(JI[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(JI[0], "guard_seat_effect"))) {
            jSONObject2 = blVar.aMx.optJSONObject(JI[0]);
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
                    cVar.aLC = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    cVar.aLC = 255;
                }
                String optString = jSONObject.optString("bg_start_color");
                String optString2 = jSONObject.optString("bg_end_color");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aLy = Color.parseColor(optString);
                    cVar.aLz = Color.parseColor(optString2);
                } else {
                    String optString3 = jSONObject.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aLy = Color.parseColor(optString3);
                        cVar.aLz = Color.parseColor(optString3);
                    }
                }
                if (z) {
                    String optString4 = jSONObject.optString("frame_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        cVar.aLA = Color.parseColor(optString4);
                        cVar.aLB = Color.parseColor(optString4);
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
            cVar.aLC = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
        } else {
            cVar.aLC = 255;
        }
        cVar.bhb = !TextUtils.isEmpty(jSONObject.optString("tail_icon"));
        String optString = jSONObject.optString("start_color");
        String optString2 = jSONObject.optString("end_color");
        try {
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                cVar.aLy = Color.parseColor(optString);
                cVar.aLz = Color.parseColor(optString2);
                z = true;
            } else {
                String optString3 = jSONObject.optString("bg_color");
                if (TextUtils.isEmpty(optString3)) {
                    z = false;
                } else {
                    cVar.aLy = Color.parseColor(optString3);
                    cVar.aLz = cVar.aLy;
                    z = true;
                }
            }
            if (z) {
                String optString4 = jSONObject.optString("frame_start_color");
                String optString5 = jSONObject.optString("frame_end_color");
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    cVar.aLA = Color.parseColor(optString4);
                    cVar.aLB = Color.parseColor(optString5);
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
                        cVar.aLC = (int) (optDouble * 255.0d);
                    } else {
                        cVar.aLC = 255;
                    }
                } else {
                    cVar.aLC = 255;
                }
                String optString2 = jSONObject.optString("bg_start_color");
                String optString3 = jSONObject.optString("bg_end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        cVar.aLy = Color.parseColor(optString2);
                        cVar.aLz = Color.parseColor(optString3);
                    }
                    String optString4 = jSONObject.optString("frame_color");
                    String optString5 = jSONObject.optString("frame_color");
                    cVar.aLA = Color.parseColor(optString4);
                    cVar.aLB = Color.parseColor(optString5);
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
        bl blVar;
        String[] JI = bVar.JI();
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
        } else if (com.baidu.live.af.a.OJ().bxp != null && (blVar = com.baidu.live.af.a.OJ().bxp.aMQ) != null && blVar.aMy != null && JI != null && JI.length > 1 && !TextUtils.isEmpty(JI[1])) {
            jSONObject2 = blVar.aMy.optJSONObject(JI[1]);
        }
        if (jSONObject2 == null) {
            return S(jSONObject2);
        }
        return false;
    }

    private boolean S(JSONObject jSONObject) {
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
            this.bkr = Color.parseColor(optString);
            this.bks = i;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bkk = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bkp = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bkp = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bkm, this.aBO);
                aVar2.bkt = this.bkt;
                aVar2.bkr = this.bkr;
                aVar2.bks = this.bks;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0175b c0175b = new C0175b(aVar, this.mGroupId, this.mLiveId, this.bkm, this.aBO);
                c0175b.bkt = this.bkt;
                c0175b.bkr = this.bkr;
                c0175b.bks = this.bks;
                spannableString.setSpan(c0175b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aEm;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> w = w(list);
        if (ListUtils.isEmpty(w)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < w.size(); i++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= w.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = w.get(i3);
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = aVar.level_id;
                alaLiveMarkData.setupNewLevelMark();
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (alaLiveMarkData.isGuardType()) {
                    if (TextUtils.isEmpty(alaLiveMarkData.guardName)) {
                        alaLiveMarkData.guardName = this.bkn;
                    }
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + alaLiveMarkData.level + "*_*" + alaLiveMarkData.guardName + "*_*" + (alaLiveMarkData.isGold() ? "1" : "0") + "*_*" + alaLiveMarkData.guardGoldenType;
                    com.baidu.live.view.b bVar = com.baidu.live.view.b.bPf.get(str);
                    if (bVar == null) {
                        if (alaLiveMarkData.level <= 0) {
                            alaLiveMarkData.level = com.baidu.live.guardclub.g.HD().gu(alaLiveMarkData.mark_pic);
                        }
                        Bitmap a2 = com.baidu.live.al.b.a(this.mContext, alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds32, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            bVar = new com.baidu.live.view.b(this.mContext, a2);
                            com.baidu.live.view.b.bPf.put(str, bVar);
                        }
                    }
                    spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.b bVar2 = com.baidu.live.view.b.bPf.get(genCacheKey);
                    if (bVar2 == null) {
                        bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bko, new b.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                b.this.IZ();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.b.bPf.put(genCacheKey, bVar2);
                    }
                    spannableStringBuilder.setSpan(bVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> w(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aBO)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int U(List<AlaLiveMarkData> list) {
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
    public void IZ() {
        long currentTimeMillis = System.currentTimeMillis() - this.bkq;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bkq = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bkq = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bkm = z;
        this.aBO = str3;
        this.bkn = str4;
    }

    public boolean Ja() {
        return this.bkm;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0175b extends ClickableSpan implements g.a {
        private boolean aGY;
        private String aZQ;
        private int bkr;
        private int bks;
        private boolean bkt;
        private com.baidu.live.data.a bkv;
        private String groupId;
        private String liveId;

        C0175b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bkv = null;
            this.bkv = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aGY = z;
            this.aZQ = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bkk) {
                if (this.bkt) {
                    textPaint.setColor(this.bkr);
                    textPaint.setAlpha(this.bks);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bkk) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bkv instanceof com.baidu.live.data.a) {
                str = this.bkv.appId;
            }
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bkv.userId, this.bkv.userName, this.bkv.portrait, this.bkv.sex, this.bkv.level_id, null, null, 0L, this.bkv.aEg, this.bkv.aEh, this.bkv.aEi, this.groupId, this.liveId, this.aGY, this.aZQ, str, this.bkv.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bkv.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }

        @Override // com.baidu.live.im.g.a
        public void ID() {
            if (this.bkv != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bkv.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bkv));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aGY;
        private String aZQ;
        private int bkr;
        private int bks;
        private boolean bkt;
        private com.baidu.live.data.a bkv;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bkv = null;
            this.bkv = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aGY = z;
            this.aZQ = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bkk) {
                if (this.bkt) {
                    textPaint.setColor(this.bkr);
                    textPaint.setAlpha(this.bks);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bkk) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bkv instanceof com.baidu.live.data.a) {
                str = this.bkv.appId;
            }
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bkv.userId, this.bkv.userName, this.bkv.portrait, this.bkv.sex, this.bkv.level_id, null, null, 0L, this.bkv.aEg, this.bkv.aEh, this.bkv.aEi, this.groupId, this.liveId, this.aGY, this.aZQ, str, this.bkv.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bkv.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }

        @Override // com.baidu.live.im.g.a
        public void ID() {
            if (this.bkv != null) {
                if (this.bkv.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bkv));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements View.OnClickListener {
        private boolean aGY;
        private String aZQ;
        private com.baidu.live.data.a bkv;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bkv = null;
            this.bkv = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aGY = z;
            this.aZQ = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bkv.userId, this.bkv.userName, this.bkv.portrait, this.bkv.sex, this.bkv.level_id, null, null, 0L, this.bkv.aEg, this.bkv.aEh, this.bkv.aEi, this.groupId, this.liveId, this.aGY, this.aZQ, this.bkv.appId, this.bkv.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bkv.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jc() {
        return 2 != bkk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jd() {
        this.bkl.bmn = true;
        this.bkl.bmo = false;
        this.bkl.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Je() {
        this.bkl.bmn = false;
        this.bkl.bmo = false;
        this.bkl.isNormal = false;
    }

    public void ce(boolean z) {
        this.bko = z;
    }

    public void cf(boolean z) {
        this.bkp = z;
    }
}
