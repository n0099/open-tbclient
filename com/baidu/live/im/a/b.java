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
import com.baidu.live.data.bi;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.b;
import com.baidu.tbadk.TbConfig;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.im.c> {
    protected static int bkJ = 1;
    private String aFp;
    protected com.baidu.live.im.e.a bkK;
    protected boolean bkL;
    protected boolean bkM;
    private boolean bkN;
    private long bkO;
    private int bkP;
    private int bkQ;
    private boolean bkR;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void Mb();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bkM = false;
        this.bkN = false;
        this.bkO = 0L;
        this.bkK = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: o */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == bkJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(33:1|(2:3|(28:5|6|7|8|(2:10|11)(1:110)|12|13|14|15|(1:19)|(1:105)(1:24)|25|(1:104)(2:29|(1:31)(2:95|(1:97)(2:98|(1:100)(2:101|(1:103)))))|32|(9:34|(1:93)(2:38|(1:(2:42|(1:44)(1:71)))(2:72|(1:92)))|(1:70)(1:50)|51|(4:62|(1:66)|67|(1:69))(1:55)|56|(1:58)|59|60)|94|(1:46)|70|51|(1:53)|62|(1:66)|67|(0)|56|(0)|59|60))|113|6|7|8|(0)(0)|12|13|14|15|(2:17|19)|(1:21)|105|25|(1:27)|104|32|(0)|94|(0)|70|51|(0)|62|(0)|67|(0)|56|(0)|59|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0233, code lost:
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013f, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0140, code lost:
        r3 = r0;
        r0 = "";
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0221 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: JSONException -> 0x013e, TRY_LEAVE, TryCatch #1 {JSONException -> 0x013e, blocks: (B:8:0x0025, B:10:0x002d, B:52:0x0133), top: B:114:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133 A[Catch: JSONException -> 0x013e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x013e, blocks: (B:8:0x0025, B:10:0x002d, B:52:0x0133), top: B:114:0x0025 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        int i2;
        String str;
        String str2;
        boolean a2;
        boolean z;
        SpannableStringBuilder a3;
        SpannableStringBuilder d;
        JSONObject jSONObject;
        this.bkN = false;
        Mb();
        cVar.reset();
        if (aVar.Mo() != null) {
            List<AlaLiveMarkData> list = aVar.Mo().aHG;
            if (!ListUtils.isEmpty(list)) {
                i2 = T(list);
                if (!(aVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                String optString = jSONObject.optString("content_type");
                str = jSONObject.optString("level_id");
                str2 = optString;
                JSONObject jSONObject2 = jSONObject;
                if (!TextUtils.isEmpty(str) && JavaTypesHelper.toInt(str, 0) > 0) {
                    aVar.Mo().level_id = JavaTypesHelper.toInt(str, 0);
                }
                if (str2 == null && str2.equals("activity_common_im") && jSONObject2 != null) {
                    a2 = a(jSONObject2.optJSONObject("content_data"), cVar);
                } else {
                    a2 = a(aVar, cVar, i2);
                }
                boolean a4 = a(aVar, i2);
                this.bkK.blW = false;
                this.bkK.blX = false;
                this.bkK.blY = false;
                this.bkK.blZ = false;
                this.bkK.bma = false;
                if (!"send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                    this.bkK.blW = true;
                } else if ("guard_seat".equals(str2)) {
                    this.bkK.blX = true;
                } else if ("guard_club_join".equals(str2)) {
                    this.bkK.blY = true;
                } else if ("haokan_buy_goods".equals(str2)) {
                    this.bkK.blZ = true;
                } else if ("privilege_award_royal_success".equals(str2)) {
                    this.bkK.bma = true;
                }
                this.bkR = a4;
                cVar.bhH = a2;
                if (!aVar.Mz()) {
                    if (aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                        z = true;
                    } else if (aVar.getMsgType() == 24) {
                        if (str2 != null && jSONObject2 != null) {
                            z = !jSONObject2.optString("content_type").equals("pk_send_props");
                        }
                    } else if ((aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str2, "enter_live") || TextUtils.equals(str2, "follow_anchor") || TextUtils.equals(str2, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str2, "share_tieba") || TextUtils.equals(str2, "share_rmb") || TextUtils.equals(str2, "zan_rmb") || TextUtils.equals(str2, "tying_gift") || TextUtils.equals(str2, "add_tags_to_anchor"))) {
                        z = true;
                    }
                    if (!z && aVar.Mo() != null && !TextUtils.isEmpty(aVar.Mo().portrait)) {
                        cVar.a(true, aVar.Mo().portrait, i2);
                        cVar.bhE.setOnClickListener(new c(aVar.Mo(), this.mGroupId, this.mLiveId, this.bkL, this.aFp));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.bhE.setOnClickListener(null);
                    }
                    if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).bhq != null) {
                        a3 = ((com.baidu.live.im.a) aVar).bhq;
                    } else {
                        a3 = a(aVar, cVar);
                        d = d(aVar.Mo());
                        if (this.bkN && d != null && a3 != null) {
                            a3.insert(0, (CharSequence) d);
                        }
                        if (aVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) aVar).bhq = a3;
                        }
                    }
                    cVar.a(this.mContext, this.bkK);
                    cVar.i(this.mContext, this.bkK.blV);
                    cVar.bhB.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.bhB.setMovementMethod(com.baidu.live.im.g.LG());
                    if (this.bkM) {
                        cVar.bT(true);
                    }
                    cVar.bhB.setText(a3);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.bhE.setOnClickListener(null);
                if (!(aVar instanceof com.baidu.live.im.a)) {
                }
                a3 = a(aVar, cVar);
                d = d(aVar.Mo());
                if (this.bkN) {
                    a3.insert(0, (CharSequence) d);
                }
                if (aVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.bkK);
                cVar.i(this.mContext, this.bkK.blV);
                cVar.bhB.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.bhB.setMovementMethod(com.baidu.live.im.g.LG());
                if (this.bkM) {
                }
                cVar.bhB.setText(a3);
                return view;
            }
        }
        i2 = 0;
        if (!(aVar.getObjContent() instanceof JSONObject)) {
        }
        String optString2 = jSONObject.optString("content_type");
        str = jSONObject.optString("level_id");
        str2 = optString2;
        JSONObject jSONObject22 = jSONObject;
        if (!TextUtils.isEmpty(str)) {
            aVar.Mo().level_id = JavaTypesHelper.toInt(str, 0);
        }
        if (str2 == null) {
        }
        a2 = a(aVar, cVar, i2);
        boolean a42 = a(aVar, i2);
        this.bkK.blW = false;
        this.bkK.blX = false;
        this.bkK.blY = false;
        this.bkK.blZ = false;
        this.bkK.bma = false;
        if (!"send_redpacket".equals(str2)) {
        }
        this.bkK.blW = true;
        this.bkR = a42;
        cVar.bhH = a2;
        if (!aVar.Mz()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.bhE.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a3 = a(aVar, cVar);
        d = d(aVar.Mo());
        if (this.bkN) {
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.bkK);
        cVar.i(this.mContext, this.bkK.blV);
        cVar.bhB.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.bhB.setMovementMethod(com.baidu.live.im.g.LG());
        if (this.bkM) {
        }
        cVar.bhB.setText(a3);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aOi = Color.parseColor(optString.trim());
            cVar.aOj = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aOi = Color.parseColor(optString3);
                cVar.aOj = cVar.aOi;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aOm = (int) (255.0d * optDouble);
        } else {
            cVar.aOm = 255;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar, int i) {
        JSONObject jSONObject;
        boolean z;
        bi biVar;
        JSONObject jSONObject2 = null;
        String[] Mv = aVar.Mv();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (Mv == null || Mv.length == 0 || !TextUtils.equals(Mv[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.aa.a.PQ().btT != null && (biVar = com.baidu.live.aa.a.PQ().btT.aPz) != null && biVar.aPh != null && Mv != null && Mv.length > 0 && !TextUtils.isEmpty(Mv[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(Mv[0], "guard_seat_effect"))) {
            jSONObject2 = biVar.aPh.optJSONObject(Mv[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                cVar.aOm = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                cVar.aOm = 255;
            }
            cVar.bhI = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aOi = Color.parseColor(optString);
                    cVar.aOj = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aOi = Color.parseColor(optString3);
                        cVar.aOj = cVar.aOi;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cVar.aOk = Color.parseColor(optString4);
                        cVar.aOl = Color.parseColor(optString5);
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
        String[] Mv = aVar.Mv();
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
        } else if (com.baidu.live.aa.a.PQ().btT != null && (biVar = com.baidu.live.aa.a.PQ().btT.aPz) != null && biVar.aPi != null && Mv != null && Mv.length > 1 && !TextUtils.isEmpty(Mv[1])) {
            jSONObject2 = biVar.aPi.optJSONObject(Mv[1]);
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
                this.bkP = Color.parseColor(optString2);
                this.bkQ = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bkJ = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bkN = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bkN = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bkL, this.aFp);
                aVar2.bkR = this.bkR;
                aVar2.bkP = this.bkP;
                aVar2.bkQ = this.bkQ;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0187b c0187b = new C0187b(aVar, this.mGroupId, this.mLiveId, this.bkL, this.aFp);
                c0187b.bkR = this.bkR;
                c0187b.bkP = this.bkP;
                c0187b.bkQ = this.bkQ;
                spannableString.setSpan(c0187b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        int i = 0;
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aHG;
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
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bLq.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bkM, new b.a() { // from class: com.baidu.live.im.a.b.1
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            b.this.LZ();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bLq.put(genCacheKey, bVar);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aFp)) {
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
    public void LZ() {
        long currentTimeMillis = System.currentTimeMillis() - this.bkO;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bkO = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bkO = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bkL = z;
        this.aFp = str3;
    }

    public boolean Ma() {
        return this.bkL;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0187b extends ClickableSpan implements g.a {
        private boolean aKf;
        private String bbl;
        private int bkP;
        private int bkQ;
        private boolean bkR;
        private com.baidu.live.data.a bkT;
        private String groupId;
        private String liveId;

        C0187b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bkT = null;
            this.bkT = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aKf = z;
            this.bbl = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bkJ) {
                if (this.bkR) {
                    textPaint.setColor(this.bkP);
                    textPaint.setAlpha(this.bkQ);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bkJ) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bkT instanceof com.baidu.live.data.a) {
                str = this.bkT.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bkT.userId, this.bkT.userName, this.bkT.portrait, this.bkT.sex, this.bkT.level_id, null, null, 0L, this.bkT.aHA, this.bkT.aHB, this.bkT.aHC, this.groupId, this.liveId, this.aKf, this.bbl, str, this.bkT.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void LH() {
            if (this.bkT != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bkT.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bkT));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aKf;
        private String bbl;
        private int bkP;
        private int bkQ;
        private boolean bkR;
        private com.baidu.live.data.a bkT;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bkT = null;
            this.bkT = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aKf = z;
            this.bbl = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bkJ) {
                if (this.bkR) {
                    textPaint.setColor(this.bkP);
                    textPaint.setAlpha(this.bkQ);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bkJ) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bkT instanceof com.baidu.live.data.a) {
                str = this.bkT.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bkT.userId, this.bkT.userName, this.bkT.portrait, this.bkT.sex, this.bkT.level_id, null, null, 0L, this.bkT.aHA, this.bkT.aHB, this.bkT.aHC, this.groupId, this.liveId, this.aKf, this.bbl, str, this.bkT.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void LH() {
            if (this.bkT != null) {
                if (this.bkT.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bkT));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private boolean aKf;
        private String bbl;
        private com.baidu.live.data.a bkT;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bkT = null;
            this.bkT = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aKf = z;
            this.bbl = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bkT.userId, this.bkT.userName, this.bkT.portrait, this.bkT.sex, this.bkT.level_id, null, null, 0L, this.bkT.aHA, this.bkT.aHB, this.bkT.aHC, this.groupId, this.liveId, this.aKf, this.bbl, this.bkT.appId, this.bkT.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Mc() {
        return 2 != bkJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Md() {
        this.bkK.blU = true;
        this.bkK.blV = false;
        this.bkK.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Me() {
        this.bkK.blU = false;
        this.bkK.blV = false;
        this.bkK.isNormal = false;
    }

    public void bX(boolean z) {
        this.bkM = z;
    }

    public void bY(boolean z) {
        this.bkN = z;
    }
}
