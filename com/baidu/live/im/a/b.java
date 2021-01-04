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
/* loaded from: classes11.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.b, com.baidu.live.im.c> {
    protected static int boX = 1;
    private String aGB;
    protected com.baidu.live.im.e.a boY;
    protected boolean boZ;
    private String bpa;
    protected boolean bpb;
    private boolean bpc;
    private long bpd;
    private int bpe;
    private int bpf;
    private boolean bpg;
    private String mGroupId;
    private Handler mHandler;
    protected String mLiveId;

    protected abstract void MW();

    protected abstract SpannableStringBuilder b(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bpb = false;
        this.bpc = false;
        this.bpd = 0L;
        this.boY = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: n */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == boX);
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
        this.bpc = false;
        MW();
        cVar.reset();
        if (bVar.Nw() != null) {
            List<AlaLiveMarkData> list = bVar.Nw().aIZ;
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
                    bVar.Nw().level_id = JavaTypesHelper.toInt(str, 0);
                }
                if (str2 == null && str2.equals("activity_common_im") && jSONObject != null) {
                    a2 = a(jSONObject.optJSONObject("content_data"), cVar);
                } else {
                    a2 = a(bVar, cVar, i2);
                }
                boolean a3 = a(bVar, i2);
                this.boY.brc = false;
                this.boY.brd = false;
                this.boY.bre = false;
                this.boY.brf = false;
                this.boY.brg = false;
                this.boY.isMysteriousMan = false;
                if (!"send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                    this.boY.brc = true;
                } else if ("guard_seat".equals(str2)) {
                    this.boY.brd = true;
                } else if ("guard_club_join".equals(str2)) {
                    this.boY.bre = true;
                } else if ("haokan_buy_goods".equals(str2)) {
                    this.boY.brf = true;
                } else if ("privilege_award_royal_success".equals(str2)) {
                    this.boY.brg = true;
                }
                if (bVar.Nw() != null && bVar.Nw().extInfoJson != null) {
                    this.boY.isMysteriousMan = bVar.Nw().extInfoJson.optInt("is_mysterious_man") != 1;
                }
                this.bpg = a3;
                cVar.blP = a2;
                if (!bVar.NH()) {
                    if (bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                        z = true;
                    } else if (bVar.getMsgType() == 24) {
                        if (str2 != null && jSONObject != null) {
                            z = !jSONObject.optString("content_type").equals("pk_send_props");
                        }
                    } else if ((bVar.getMsgType() == 13 || bVar.getMsgType() == 27) && (TextUtils.equals(str2, "enter_live") || TextUtils.equals(str2, "follow_anchor") || TextUtils.equals(str2, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str2, "share_tieba") || TextUtils.equals(str2, "share_rmb") || TextUtils.equals(str2, "zan_rmb") || TextUtils.equals(str2, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) || TextUtils.equals(str2, "add_tags_to_anchor") || TextUtils.equals(str2, "remove_video") || TextUtils.equals(str2, "live_poke_back"))) {
                        z = true;
                    }
                    if (!z && bVar.Nw() != null && !TextUtils.isEmpty(bVar.Nw().portrait)) {
                        cVar.a(true, bVar.Nw().portrait, i2);
                        cVar.blM.setOnClickListener(new c(bVar.Nw(), this.mGroupId, this.mLiveId, this.boZ, this.aGB));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.blM.setOnClickListener(null);
                    }
                    if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).bly != null) {
                        b2 = ((com.baidu.live.im.a) bVar).bly;
                    } else {
                        b2 = b(bVar, cVar);
                        d = d(bVar.Nw());
                        if (this.bpc && d != null && b2 != null) {
                            b2.insert(0, (CharSequence) d);
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) bVar).bly = b2;
                        }
                    }
                    cVar.a(this.mContext, this.boY);
                    cVar.m(this.mContext, this.boY.brb);
                    cVar.blJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.blJ.setMovementMethod(com.baidu.live.im.g.Mx());
                    if (this.bpb) {
                        cVar.ce(true);
                    }
                    cVar.blJ.setText(b2);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.blM.setOnClickListener(null);
                if (!(bVar instanceof com.baidu.live.im.a)) {
                }
                b2 = b(bVar, cVar);
                d = d(bVar.Nw());
                if (this.bpc) {
                    b2.insert(0, (CharSequence) d);
                }
                if (bVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.boY);
                cVar.m(this.mContext, this.boY.brb);
                cVar.blJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.blJ.setMovementMethod(com.baidu.live.im.g.Mx());
                if (this.bpb) {
                }
                cVar.blJ.setText(b2);
                return view;
            }
        }
        i2 = 0;
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        str2 = jSONObject.optString("content_type");
        str = jSONObject.optString("level_id");
        if (!TextUtils.isEmpty(str)) {
            bVar.Nw().level_id = JavaTypesHelper.toInt(str, 0);
        }
        if (str2 == null) {
        }
        a2 = a(bVar, cVar, i2);
        boolean a32 = a(bVar, i2);
        this.boY.brc = false;
        this.boY.brd = false;
        this.boY.bre = false;
        this.boY.brf = false;
        this.boY.brg = false;
        this.boY.isMysteriousMan = false;
        if (!"send_redpacket".equals(str2)) {
        }
        this.boY.brc = true;
        if (bVar.Nw() != null) {
            this.boY.isMysteriousMan = bVar.Nw().extInfoJson.optInt("is_mysterious_man") != 1;
        }
        this.bpg = a32;
        cVar.blP = a2;
        if (!bVar.NH()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.blM.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        b2 = b(bVar, cVar);
        d = d(bVar.Nw());
        if (this.bpc) {
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.boY);
        cVar.m(this.mContext, this.boY.brb);
        cVar.blJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.blJ.setMovementMethod(com.baidu.live.im.g.Mx());
        if (this.bpb) {
        }
        cVar.blJ.setText(b2);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aQl = Color.parseColor(optString.trim());
            cVar.aQm = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aQl = Color.parseColor(optString3);
                cVar.aQm = cVar.aQl;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aQp = (int) (255.0d * optDouble);
        } else {
            cVar.aQp = 255;
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
        String[] ND = bVar.ND();
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && (ND == null || ND.length == 0 || !TextUtils.equals(ND[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.af.a.SE().bCb != null && (blVar = com.baidu.live.af.a.SE().bCb.aRD) != null && blVar.aRk != null && ND != null && ND.length > 0 && !TextUtils.isEmpty(ND[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(ND[0], "guard_seat_effect"))) {
            jSONObject2 = blVar.aRk.optJSONObject(ND[0]);
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
                    cVar.aQp = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    cVar.aQp = 255;
                }
                String optString = jSONObject.optString("bg_start_color");
                String optString2 = jSONObject.optString("bg_end_color");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aQl = Color.parseColor(optString);
                    cVar.aQm = Color.parseColor(optString2);
                } else {
                    String optString3 = jSONObject.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aQl = Color.parseColor(optString3);
                        cVar.aQm = Color.parseColor(optString3);
                    }
                }
                if (z) {
                    String optString4 = jSONObject.optString("frame_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        cVar.aQn = Color.parseColor(optString4);
                        cVar.aQo = Color.parseColor(optString4);
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
            cVar.aQp = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
        } else {
            cVar.aQp = 255;
        }
        cVar.blQ = !TextUtils.isEmpty(jSONObject.optString("tail_icon"));
        String optString = jSONObject.optString("start_color");
        String optString2 = jSONObject.optString("end_color");
        try {
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                cVar.aQl = Color.parseColor(optString);
                cVar.aQm = Color.parseColor(optString2);
                z = true;
            } else {
                String optString3 = jSONObject.optString("bg_color");
                if (TextUtils.isEmpty(optString3)) {
                    z = false;
                } else {
                    cVar.aQl = Color.parseColor(optString3);
                    cVar.aQm = cVar.aQl;
                    z = true;
                }
            }
            if (z) {
                String optString4 = jSONObject.optString("frame_start_color");
                String optString5 = jSONObject.optString("frame_end_color");
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    cVar.aQn = Color.parseColor(optString4);
                    cVar.aQo = Color.parseColor(optString5);
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
                        cVar.aQp = (int) (optDouble * 255.0d);
                    } else {
                        cVar.aQp = 255;
                    }
                } else {
                    cVar.aQp = 255;
                }
                String optString2 = jSONObject.optString("bg_start_color");
                String optString3 = jSONObject.optString("bg_end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        cVar.aQl = Color.parseColor(optString2);
                        cVar.aQm = Color.parseColor(optString3);
                    }
                    String optString4 = jSONObject.optString("frame_color");
                    String optString5 = jSONObject.optString("frame_color");
                    cVar.aQn = Color.parseColor(optString4);
                    cVar.aQo = Color.parseColor(optString5);
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
        String[] ND = bVar.ND();
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
        } else if (com.baidu.live.af.a.SE().bCb != null && (blVar = com.baidu.live.af.a.SE().bCb.aRD) != null && blVar.aRl != null && ND != null && ND.length > 1 && !TextUtils.isEmpty(ND[1])) {
            jSONObject2 = blVar.aRl.optJSONObject(ND[1]);
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
            this.bpe = Color.parseColor(optString);
            this.bpf = i;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        boX = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bpc = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bpc = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.boZ, this.aGB);
                aVar2.bpg = this.bpg;
                aVar2.bpe = this.bpe;
                aVar2.bpf = this.bpf;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0184b c0184b = new C0184b(aVar, this.mGroupId, this.mLiveId, this.boZ, this.aGB);
                c0184b.bpg = this.bpg;
                c0184b.bpe = this.bpe;
                c0184b.bpf = this.bpf;
                spannableString.setSpan(c0184b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aIZ;
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
                        alaLiveMarkData.guardName = this.bpa;
                    }
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + alaLiveMarkData.level + "*_*" + alaLiveMarkData.guardName + "*_*" + (alaLiveMarkData.isGold() ? "1" : "0") + "*_*" + alaLiveMarkData.guardGoldenType;
                    com.baidu.live.view.b bVar = com.baidu.live.view.b.bTR.get(str);
                    if (bVar == null) {
                        if (alaLiveMarkData.level <= 0) {
                            alaLiveMarkData.level = com.baidu.live.guardclub.g.Ly().hF(alaLiveMarkData.mark_pic);
                        }
                        Bitmap a2 = com.baidu.live.al.b.a(this.mContext, alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds32, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            bVar = new com.baidu.live.view.b(this.mContext, a2);
                            com.baidu.live.view.b.bTR.put(str, bVar);
                        }
                    }
                    spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.b bVar2 = com.baidu.live.view.b.bTR.get(genCacheKey);
                    if (bVar2 == null) {
                        bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bpb, new b.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                b.this.MU();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.b.bTR.put(genCacheKey, bVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aGB)) {
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
    public void MU() {
        long currentTimeMillis = System.currentTimeMillis() - this.bpd;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bpd = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bpd = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.boZ = z;
        this.aGB = str3;
        this.bpa = str4;
    }

    public boolean MV() {
        return this.boZ;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0184b extends ClickableSpan implements g.a {
        private boolean aLL;
        private String beG;
        private int bpe;
        private int bpf;
        private boolean bpg;
        private com.baidu.live.data.a bpi;
        private String groupId;
        private String liveId;

        C0184b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpi = null;
            this.bpi = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLL = z;
            this.beG = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.boX) {
                if (this.bpg) {
                    textPaint.setColor(this.bpe);
                    textPaint.setAlpha(this.bpf);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.boX) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpi instanceof com.baidu.live.data.a) {
                str = this.bpi.appId;
            }
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bpi.userId, this.bpi.userName, this.bpi.portrait, this.bpi.sex, this.bpi.level_id, null, null, 0L, this.bpi.aIT, this.bpi.aIU, this.bpi.aIV, this.groupId, this.liveId, this.aLL, this.beG, str, this.bpi.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bpi.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }

        @Override // com.baidu.live.im.g.a
        public void My() {
            if (this.bpi != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bpi.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpi));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aLL;
        private String beG;
        private int bpe;
        private int bpf;
        private boolean bpg;
        private com.baidu.live.data.a bpi;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpi = null;
            this.bpi = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLL = z;
            this.beG = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.boX) {
                if (this.bpg) {
                    textPaint.setColor(this.bpe);
                    textPaint.setAlpha(this.bpf);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.boX) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpi instanceof com.baidu.live.data.a) {
                str = this.bpi.appId;
            }
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bpi.userId, this.bpi.userName, this.bpi.portrait, this.bpi.sex, this.bpi.level_id, null, null, 0L, this.bpi.aIT, this.bpi.aIU, this.bpi.aIV, this.groupId, this.liveId, this.aLL, this.beG, str, this.bpi.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bpi.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }

        @Override // com.baidu.live.im.g.a
        public void My() {
            if (this.bpi != null) {
                if (this.bpi.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpi));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c implements View.OnClickListener {
        private boolean aLL;
        private String beG;
        private com.baidu.live.data.a bpi;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpi = null;
            this.bpi = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLL = z;
            this.beG = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(view.getContext(), this.bpi.userId, this.bpi.userName, this.bpi.portrait, this.bpi.sex, this.bpi.level_id, null, null, 0L, this.bpi.aIT, this.bpi.aIU, this.bpi.aIV, this.groupId, this.liveId, this.aLL, this.beG, this.bpi.appId, this.bpi.getNameShow());
            alaPersonCardActivityConfig.setExtInfo(this.bpi.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean MX() {
        return 2 != boX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MY() {
        this.boY.bra = true;
        this.boY.brb = false;
        this.boY.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MZ() {
        this.boY.bra = false;
        this.boY.brb = false;
        this.boY.isNormal = false;
    }

    public void ci(boolean z) {
        this.bpb = z;
    }

    public void cj(boolean z) {
        this.bpc = z;
    }
}
